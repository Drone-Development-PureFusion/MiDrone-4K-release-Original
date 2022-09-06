package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class DefaultDiskStorage implements DiskStorage {
    private static final String CONTENT_FILE_EXTENSION = ".cnt";
    private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    private static final String TEMP_FILE_EXTENSION = ".tmp";
    private final CacheErrorLogger mCacheErrorLogger;
    private final Clock mClock = SystemClock.get();
    private final File mRootDirectory;
    private final File mVersionDirectory;
    private static final Class<?> TAG = DefaultDiskStorage.class;
    static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class EntriesCollector implements FileTreeVisitor {
        private final List<DiskStorage.Entry> result;

        private EntriesCollector() {
            this.result = new ArrayList();
        }

        public List<DiskStorage.Entry> getEntries() {
            return Collections.unmodifiableList(this.result);
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            FileInfo shardFileInfo = DefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null || shardFileInfo.type != FileType.CONTENT) {
                return;
            }
            this.result.add(new EntryImpl(file));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public class EntryImpl implements DiskStorage.Entry {
        private final FileBinaryResource resource;
        private long size;
        private long timestamp;

        private EntryImpl(File file) {
            Preconditions.checkNotNull(file);
            this.resource = FileBinaryResource.createOrNull(file);
            this.size = -1L;
            this.timestamp = -1L;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        /* renamed from: getResource  reason: collision with other method in class */
        public FileBinaryResource mo21755getResource() {
            return this.resource;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.getFile().lastModified();
            }
            return this.timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FileInfo {
        public final String resourceId;
        public final FileType type;

        private FileInfo(FileType fileType, String str) {
            this.type = fileType;
            this.resourceId = str;
        }

        public static FileInfo fromFile(File file) {
            FileType fromExtension;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (fromExtension = FileType.fromExtension(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (fromExtension.equals(FileType.TEMP)) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new FileInfo(fromExtension, substring);
            }
            return null;
        }

        public File createTempFile(File file) {
            return File.createTempFile(this.resourceId + ".", DefaultDiskStorage.TEMP_FILE_EXTENSION, file);
        }

        public File toFile(File file) {
            return new File(file, this.resourceId + this.type.extension);
        }

        public String toString() {
            return this.type + "(" + this.resourceId + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum FileType {
        CONTENT(DefaultDiskStorage.CONTENT_FILE_EXTENSION),
        TEMP(DefaultDiskStorage.TEMP_FILE_EXTENSION);
        
        public final String extension;

        FileType(String str) {
            this.extension = str;
        }

        public static FileType fromExtension(String str) {
            if (DefaultDiskStorage.CONTENT_FILE_EXTENSION.equals(str)) {
                return CONTENT;
            }
            if (!DefaultDiskStorage.TEMP_FILE_EXTENSION.equals(str)) {
                return null;
            }
            return TEMP;
        }
    }

    /* loaded from: classes.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    /* loaded from: classes.dex */
    private class PurgingVisitor implements FileTreeVisitor {
        private boolean insideBaseDirectory;

        private PurgingVisitor() {
        }

        private boolean isExpectedFile(File file) {
            boolean z = false;
            FileInfo shardFileInfo = DefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null) {
                return false;
            }
            if (shardFileInfo.type == FileType.TEMP) {
                return isRecentFile(file);
            }
            if (shardFileInfo.type == FileType.CONTENT) {
                z = true;
            }
            Preconditions.checkState(z);
            return true;
        }

        private boolean isRecentFile(File file) {
            return file.lastModified() > DefaultDiskStorage.this.mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
            if (!DefaultDiskStorage.this.mRootDirectory.equals(file) && !this.insideBaseDirectory) {
                file.delete();
            }
            if (!this.insideBaseDirectory || !file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                return;
            }
            this.insideBaseDirectory = false;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
            if (this.insideBaseDirectory || !file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                return;
            }
            this.insideBaseDirectory = true;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            if (!this.insideBaseDirectory || !isExpectedFile(file)) {
                file.delete();
            }
        }
    }

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        Preconditions.checkNotNull(file);
        this.mRootDirectory = file;
        this.mVersionDirectory = new File(this.mRootDirectory, getVersionSubdirectoryName(i));
        this.mCacheErrorLogger = cacheErrorLogger;
        recreateDirectoryIfVersionChanges();
    }

    private long doRemove(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry entry) {
        EntryImpl entryImpl = (EntryImpl) entry;
        String str = "";
        byte[] read = entryImpl.mo21755getResource().read();
        String typeOfBytes = typeOfBytes(read);
        if (typeOfBytes.equals("undefined") && read.length >= 4) {
            str = String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", Byte.valueOf(read[0]), Byte.valueOf(read[1]), Byte.valueOf(read[2]), Byte.valueOf(read[3]));
        }
        return new DiskStorage.DiskDumpInfoEntry(entryImpl.mo21755getResource().getFile().getPath(), typeOfBytes, (float) entryImpl.getSize(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileInfo getShardFileInfo(File file) {
        FileInfo fromFile = FileInfo.fromFile(file);
        if (fromFile == null) {
            return null;
        }
        if (!getSubdirectory(fromFile.resourceId).equals(file.getParentFile())) {
            fromFile = null;
        }
        return fromFile;
    }

    private File getSubdirectory(String str) {
        return new File(this.mVersionDirectory, String.valueOf(Math.abs(str.hashCode() % 100)));
    }

    @VisibleForTesting
    static String getVersionSubdirectoryName(int i) {
        return String.format(null, "%s.ols%d.%d", DEFAULT_DISK_STORAGE_VERSION_PREFIX, 100, Integer.valueOf(i));
    }

    private void mkdirs(File file, String str) {
        try {
            FileUtils.mkdirs(file);
        } catch (FileUtils.CreateDirectoryException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, str, e);
            throw e;
        }
    }

    private boolean query(String str, boolean z) {
        File contentFileFor = getContentFileFor(str);
        boolean exists = contentFileFor.exists();
        if (z && exists) {
            contentFileFor.setLastModified(this.mClock.now());
        }
        return exists;
    }

    private void recreateDirectoryIfVersionChanges() {
        boolean z = true;
        if (this.mRootDirectory.exists()) {
            if (!this.mVersionDirectory.exists()) {
                FileTree.deleteRecursively(this.mRootDirectory);
            } else {
                z = false;
            }
        }
        if (z) {
            try {
                FileUtils.mkdirs(this.mVersionDirectory);
            } catch (FileUtils.CreateDirectoryException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
            }
        }
    }

    private String typeOfBytes(byte[] bArr) {
        if (bArr.length >= 2) {
            if (bArr[0] == -1 && bArr[1] == -40) {
                return "jpg";
            }
            if (bArr[0] == -119 && bArr[1] == 80) {
                return "png";
            }
            if (bArr[0] == 82 && bArr[1] == 73) {
                return "webp";
            }
            if (bArr[0] == 71 && bArr[1] == 73) {
                return "gif";
            }
        }
        return "undefined";
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        FileTree.deleteContents(this.mRootDirectory);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    /* renamed from: commit  reason: collision with other method in class */
    public FileBinaryResource mo21751commit(String str, BinaryResource binaryResource, Object obj) {
        File file = ((FileBinaryResource) binaryResource).getFile();
        File contentFileFor = getContentFileFor(str);
        try {
            FileUtils.rename(file, contentFileFor);
            if (contentFileFor.exists()) {
                contentFileFor.setLastModified(this.mClock.now());
            }
            return FileBinaryResource.createOrNull(contentFileFor);
        } catch (FileUtils.RenameException e) {
            Throwable cause = e.getCause();
            this.mCacheErrorLogger.logError(cause == null ? CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER : cause instanceof FileUtils.ParentDirNotFoundException ? CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND : cause instanceof FileNotFoundException ? CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND : CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER, TAG, "commit", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) {
        return query(str, false);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    /* renamed from: createTemporary  reason: collision with other method in class */
    public FileBinaryResource mo21752createTemporary(String str, Object obj) {
        FileInfo fileInfo = new FileInfo(FileType.TEMP, str);
        File subdirectory = getSubdirectory(fileInfo.resourceId);
        if (!subdirectory.exists()) {
            mkdirs(subdirectory, "createTemporary");
        }
        try {
            return FileBinaryResource.createOrNull(fileInfo.createTempFile(subdirectory));
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "createTemporary", e);
            throw e;
        }
    }

    @VisibleForTesting
    File getContentFileFor(String str) {
        FileInfo fileInfo = new FileInfo(FileType.CONTENT, str);
        return fileInfo.toFile(getSubdirectory(fileInfo.resourceId));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() {
        List<DiskStorage.Entry> mo21753getEntries = mo21753getEntries();
        DiskStorage.DiskDumpInfo diskDumpInfo = new DiskStorage.DiskDumpInfo();
        for (DiskStorage.Entry entry : mo21753getEntries) {
            DiskStorage.DiskDumpInfoEntry dumpCacheEntry = dumpCacheEntry(entry);
            String str = dumpCacheEntry.type;
            if (!diskDumpInfo.typeCounts.containsKey(str)) {
                diskDumpInfo.typeCounts.put(str, 0);
            }
            diskDumpInfo.typeCounts.put(str, Integer.valueOf(diskDumpInfo.typeCounts.get(str).intValue() + 1));
            diskDumpInfo.entries.add(dumpCacheEntry);
        }
        return diskDumpInfo;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    /* renamed from: getEntries  reason: collision with other method in class */
    public List<DiskStorage.Entry> mo21753getEntries() {
        EntriesCollector entriesCollector = new EntriesCollector();
        FileTree.walkFileTree(this.mVersionDirectory, entriesCollector);
        return entriesCollector.getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    /* renamed from: getResource  reason: collision with other method in class */
    public FileBinaryResource mo21754getResource(String str, Object obj) {
        File contentFileFor = getContentFileFor(str);
        if (contentFileFor.exists()) {
            contentFileFor.setLastModified(this.mClock.now());
            return FileBinaryResource.createOrNull(contentFileFor);
        }
        return null;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        return doRemove(((EntryImpl) entry).mo21755getResource().getFile());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) {
        return doRemove(getContentFileFor(str));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String str, Object obj) {
        return query(str, true);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void updateResource(String str, BinaryResource binaryResource, WriterCallback writerCallback, Object obj) {
        File file = ((FileBinaryResource) binaryResource).getFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                writerCallback.write(countingOutputStream);
                countingOutputStream.flush();
                long count = countingOutputStream.getCount();
                fileOutputStream.close();
                if (file.length() == count) {
                    return;
                }
                throw new IncompleteFileException(count, file.length());
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, TAG, "updateResource", e);
            throw e;
        }
    }
}
