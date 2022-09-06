package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.SecureHashUtil;
import com.tencent.p227mm.sdk.platformtools.LocaleUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes.dex */
public class DiskStorageCache implements FileCache, DiskTrimmable {
    public static final int START_OF_VERSIONING = 1;
    private static final double TRIMMING_LOWER_BOUND = 0.02d;
    private static final long UNINITIALIZED = -1;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final Clock mClock;
    private final long mDefaultCacheSizeLimit;
    private final long mLowDiskSpaceCacheSizeLimit;
    private final DiskStorageSupplier mStorageSupplier;
    private static final Class<?> TAG = DiskStorageCache.class;
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper mStatFsHelper = StatFsHelper.getInstance();
    @GuardedBy("mLock")
    private long mCacheSizeLastUpdateTime = UNINITIALIZED;
    private final CacheStats mCacheStats = new CacheStats();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class CacheStats {
        private boolean mInitialized = false;
        private long mSize = DiskStorageCache.UNINITIALIZED;
        private long mCount = DiskStorageCache.UNINITIALIZED;

        CacheStats() {
        }

        public synchronized long getCount() {
            return this.mCount;
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized void increment(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.mCount += j2;
            }
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.mCount = DiskStorageCache.UNINITIALIZED;
            this.mSize = DiskStorageCache.UNINITIALIZED;
        }

        public synchronized void set(long j, long j2) {
            this.mCount = j2;
            this.mSize = j;
            this.mInitialized = true;
        }
    }

    /* loaded from: classes.dex */
    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class TimestampComparator implements Comparator<DiskStorage.Entry> {
        private final long threshold;

        public TimestampComparator(long j) {
            this.threshold = j;
        }

        @Override // java.util.Comparator
        public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
            long j = 0;
            long timestamp = entry.getTimestamp() <= this.threshold ? entry.getTimestamp() : 0L;
            if (entry2.getTimestamp() <= this.threshold) {
                j = entry2.getTimestamp();
            }
            if (timestamp < j) {
                return -1;
            }
            return j > timestamp ? 1 : 0;
        }
    }

    public DiskStorageCache(DiskStorageSupplier diskStorageSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry) {
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        this.mDefaultCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mStorageSupplier = diskStorageSupplier;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheSizeLimitMinimum = params.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = cacheErrorLogger;
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        this.mClock = SystemClock.get();
    }

    @GuardedBy("mLock")
    private void calcFileCacheSize() {
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = UNINITIALIZED;
        long now = this.mClock.now();
        long j3 = now + FUTURE_TIMESTAMP_THRESHOLD_MS;
        try {
            long j4 = 0;
            int i5 = 0;
            for (DiskStorage.Entry entry : this.mStorageSupplier.get().mo21753getEntries()) {
                int i6 = i5 + 1;
                j4 += entry.getSize();
                if (entry.getTimestamp() > j3) {
                    j = Math.max(entry.getTimestamp() - now, j2);
                    i = (int) (i4 + entry.getSize());
                    i2 = i3 + 1;
                    z = true;
                } else {
                    long j5 = j2;
                    i = i4;
                    i2 = i3;
                    j = j5;
                    z = z2;
                }
                z2 = z;
                i5 = i6;
                i3 = i2;
                i4 = i;
                j2 = j;
            }
            if (z2) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + LocaleUtil.MALAY, null);
            }
            this.mCacheStats.set(j4, i5);
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
        }
    }

    private BinaryResource commitResource(String str, CacheKey cacheKey, BinaryResource binaryResource) {
        BinaryResource mo21751commit;
        synchronized (this.mLock) {
            mo21751commit = this.mStorageSupplier.get().mo21751commit(str, binaryResource, cacheKey);
            this.mCacheStats.increment(mo21751commit.size(), 1L);
        }
        return mo21751commit;
    }

    private BinaryResource createTemporaryResource(String str, CacheKey cacheKey) {
        maybeEvictFilesInCacheDir();
        return this.mStorageSupplier.get().mo21752createTemporary(str, cacheKey);
    }

    private void deleteTemporaryResource(BinaryResource binaryResource) {
        if (!(binaryResource instanceof FileBinaryResource)) {
            return;
        }
        File file = ((FileBinaryResource) binaryResource).getFile();
        if (!file.exists()) {
            return;
        }
        FLog.m13805e(TAG, "Temp file still on disk: %s ", file);
        if (file.delete()) {
            return;
        }
        FLog.m13805e(TAG, "Failed to delete temp file: %s", file);
    }

    @GuardedBy("mLock")
    private void evictAboveSize(long j, CacheEventListener.EvictionReason evictionReason) {
        long j2;
        int i;
        DiskStorage diskStorage = this.mStorageSupplier.get();
        try {
            Collection<DiskStorage.Entry> sortedEntries = getSortedEntries(diskStorage.mo21753getEntries());
            long size = this.mCacheStats.getSize() - j;
            int i2 = 0;
            long j3 = 0;
            Iterator<DiskStorage.Entry> it2 = sortedEntries.iterator();
            while (true) {
                j2 = j3;
                i = i2;
                if (!it2.hasNext()) {
                    break;
                }
                DiskStorage.Entry next = it2.next();
                if (j2 > size) {
                    break;
                }
                long remove = diskStorage.remove(next);
                if (remove > 0) {
                    j3 = j2 + remove;
                    i2 = i + 1;
                } else {
                    i2 = i;
                    j3 = j2;
                }
            }
            this.mCacheStats.increment(-j2, -i);
            diskStorage.purgeUnexpectedResources();
            reportEviction(evictionReason, i, j2);
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new TimestampComparator(this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS));
        return arrayList;
    }

    private void maybeEvictFilesInCacheDir() {
        synchronized (this.mLock) {
            boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            if (size > this.mCacheSizeLimit) {
                evictAboveSize((this.mCacheSizeLimit * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private boolean maybeUpdateFileCacheSize() {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (!this.mCacheStats.isInitialized() || this.mCacheSizeLastUpdateTime == UNINITIALIZED || elapsedRealtime - this.mCacheSizeLastUpdateTime > FILECACHE_SIZE_UPDATE_PERIOD_MS) {
            calcFileCacheSize();
            this.mCacheSizeLastUpdateTime = elapsedRealtime;
            return true;
        }
        return false;
    }

    private void reportEviction(CacheEventListener.EvictionReason evictionReason, int i, long j) {
        this.mCacheEventListener.onEviction(evictionReason, i, j);
    }

    private void trimBy(double d) {
        synchronized (this.mLock) {
            try {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
                long size = this.mCacheStats.getSize();
                evictAboveSize(size - ((long) (size * d)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + e.getMessage(), e);
            }
        }
    }

    @GuardedBy("mLock")
    private void updateFileCacheSizeLimit() {
        if (this.mStatFsHelper.testLowDiskSpace(StatFsHelper.StorageType.INTERNAL, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize())) {
            this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        } else {
            this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.mLock) {
            try {
                this.mStorageSupplier.get().clearAll();
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e.getMessage(), e);
            }
            this.mCacheStats.reset();
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long clearOldEntries(long j) {
        long max;
        int i;
        long j2;
        long j3 = 0;
        synchronized (this.mLock) {
            try {
                long now = this.mClock.now();
                DiskStorage diskStorage = this.mStorageSupplier.get();
                int i2 = 0;
                long j4 = 0;
                for (DiskStorage.Entry entry : diskStorage.mo21753getEntries()) {
                    long max2 = Math.max(1L, Math.abs(now - entry.getTimestamp()));
                    if (max2 >= j) {
                        long remove = diskStorage.remove(entry);
                        if (remove > 0) {
                            j2 = j4 + remove;
                            i = i2 + 1;
                        } else {
                            long j5 = j4;
                            i = i2;
                            j2 = j5;
                        }
                        max = j3;
                    } else {
                        max = Math.max(j3, max2);
                        long j6 = j4;
                        i = i2;
                        j2 = j6;
                    }
                    j3 = max;
                    int i3 = i;
                    j4 = j2;
                    i2 = i3;
                }
                diskStorage.purgeUnexpectedResources();
                if (i2 > 0) {
                    maybeUpdateFileCacheSize();
                    this.mCacheStats.increment(-j4, -i2);
                    reportEviction(CacheEventListener.EvictionReason.CONTENT_STALE, i2, j4);
                }
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
            }
        }
        return j3;
    }

    @Override // com.facebook.cache.disk.FileCache
    public DiskStorage.DiskDumpInfo getDumpInfo() {
        return this.mStorageSupplier.get().getDumpInfo();
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource getResource(CacheKey cacheKey) {
        BinaryResource mo21754getResource;
        try {
            synchronized (this.mLock) {
                mo21754getResource = this.mStorageSupplier.get().mo21754getResource(getResourceId(cacheKey), cacheKey);
                if (mo21754getResource == null) {
                    this.mCacheEventListener.onMiss();
                } else {
                    this.mCacheEventListener.onHit();
                }
            }
            return mo21754getResource;
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);
            this.mCacheEventListener.onReadException();
            return null;
        }
    }

    @VisibleForTesting
    String getResourceId(CacheKey cacheKey) {
        try {
            return SecureHashUtil.makeSHA1HashBase64(cacheKey.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        return this.mCacheStats.getSize();
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(CacheKey cacheKey) {
        try {
            return this.mStorageSupplier.get().contains(getResourceId(cacheKey), cacheKey);
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) {
        this.mCacheEventListener.onWriteAttempt();
        String resourceId = getResourceId(cacheKey);
        try {
            BinaryResource createTemporaryResource = createTemporaryResource(resourceId, cacheKey);
            this.mStorageSupplier.get().updateResource(resourceId, createTemporaryResource, writerCallback, cacheKey);
            BinaryResource commitResource = commitResource(resourceId, cacheKey, createTemporaryResource);
            deleteTemporaryResource(createTemporaryResource);
            return commitResource;
        } catch (IOException e) {
            this.mCacheEventListener.onWriteException();
            FLog.m13818d(TAG, "Failed inserting a file into the cache", (Throwable) e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        try {
            return this.mStorageSupplier.get().isEnabled();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean probe(CacheKey cacheKey) {
        boolean z;
        try {
            synchronized (this.mLock) {
                z = this.mStorageSupplier.get().touch(getResourceId(cacheKey), cacheKey);
            }
            return z;
        } catch (IOException e) {
            this.mCacheEventListener.onReadException();
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void remove(CacheKey cacheKey) {
        synchronized (this.mLock) {
            try {
                this.mStorageSupplier.get().remove(getResourceId(cacheKey));
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + e.getMessage(), e);
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToMinimum() {
        synchronized (this.mLock) {
            maybeUpdateFileCacheSize();
            long size = this.mCacheStats.getSize();
            if (this.mCacheSizeLimitMinimum <= 0 || size <= 0 || size < this.mCacheSizeLimitMinimum) {
                return;
            }
            double d = 1.0d - (this.mCacheSizeLimitMinimum / size);
            if (d > TRIMMING_LOWER_BOUND) {
                trimBy(d);
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }
}
