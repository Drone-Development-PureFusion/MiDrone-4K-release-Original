package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
final class MultiDexExtractor {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private static Method sApplyMethod;

    static {
        try {
            sApplyMethod = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e) {
            sApplyMethod = null;
        }
    }

    MultiDexExtractor() {
    }

    private static void apply(SharedPreferences.Editor editor) {
        if (sApplyMethod != null) {
            try {
                sApplyMethod.invoke(editor, new Object[0]);
                return;
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
        editor.commit();
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w(TAG, "Failed to close resource", e);
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(str, EXTRACTED_SUFFIX, file.getParentFile());
        Log.i(TAG, "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            Log.i(TAG, "Renaming to " + file.getPath());
            if (createTempFile.renameTo(file)) {
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } finally {
            closeQuietly(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == NO_VALUE ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == NO_VALUE ? zipCrc - 1 : zipCrc;
    }

    private static boolean isModified(Context context, File file, long j) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        return (multiDexPreferences.getLong(KEY_TIME_STAMP, NO_VALUE) == getTimeStamp(file) && multiDexPreferences.getLong(KEY_CRC, NO_VALUE) == j) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<File> load(Context context, ApplicationInfo applicationInfo, File file, boolean z) {
        List<File> performExtractions;
        Log.i(TAG, "MultiDexExtractor.load(" + applicationInfo.sourceDir + ", " + z + ")");
        File file2 = new File(applicationInfo.sourceDir);
        long zipCrc = getZipCrc(file2);
        if (z || isModified(context, file2, zipCrc)) {
            Log.i(TAG, "Detected that extraction must be performed.");
            performExtractions = performExtractions(file2, file);
            putStoredApkInfo(context, getTimeStamp(file2), zipCrc, performExtractions.size() + 1);
        } else {
            try {
                performExtractions = loadExistingExtractions(context, file2, file);
            } catch (IOException e) {
                Log.w(TAG, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                performExtractions = performExtractions(file2, file);
                putStoredApkInfo(context, getTimeStamp(file2), zipCrc, performExtractions.size() + 1);
            }
        }
        Log.i(TAG, "load found " + performExtractions.size() + " secondary dex files");
        return performExtractions;
    }

    private static List<File> loadExistingExtractions(Context context, File file, File file2) {
        Log.i(TAG, "loading existing secondary dex files");
        String str = file.getName() + EXTRACTED_NAME_EXT;
        int i = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 2; i2 <= i; i2++) {
            File file3 = new File(file2, str + i2 + EXTRACTED_SUFFIX);
            if (!file3.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
            }
            arrayList.add(file3);
            if (!verifyZipFile(file3)) {
                Log.i(TAG, "Invalid zip file: " + file3);
                throw new IOException("Invalid ZIP file.");
            }
        }
        return arrayList;
    }

    private static void mkdirChecked(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e(TAG, "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e(TAG, "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create cache directory " + file.getPath());
        }
    }

    private static List<File> performExtractions(File file, File file2) {
        String str = file.getName() + EXTRACTED_NAME_EXT;
        prepareDexDir(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry(DEX_PREFIX + 2 + DEX_SUFFIX);
            int i = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i + EXTRACTED_SUFFIX);
                arrayList.add(file3);
                Log.i(TAG, "Extraction is needed for file " + file3);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    int i3 = i2 + 1;
                    extract(zipFile, entry, file3, str);
                    boolean verifyZipFile = verifyZipFile(file3);
                    Log.i(TAG, "Extraction " + (verifyZipFile ? "success" : "failed") + " - length " + file3.getAbsolutePath() + ": " + file3.length());
                    if (!verifyZipFile) {
                        file3.delete();
                        if (file3.exists()) {
                            Log.w(TAG, "Failed to delete corrupted secondary dex '" + file3.getPath() + "'");
                            z = verifyZipFile;
                            i2 = i3;
                        }
                    }
                    z = verifyZipFile;
                    i2 = i3;
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                int i4 = i + 1;
                entry = zipFile.getEntry(DEX_PREFIX + i4 + DEX_SUFFIX);
                i = i4;
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w(TAG, "Failed to close resource", e);
            }
        }
    }

    private static void prepareDexDir(File file, final String str) {
        mkdirChecked(file.getParentFile());
        mkdirChecked(file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: android.support.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return !file2.getName().startsWith(str);
            }
        });
        if (listFiles == null) {
            Log.w(TAG, "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : listFiles) {
            Log.i(TAG, "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                Log.w(TAG, "Failed to delete old file " + file2.getPath());
            } else {
                Log.i(TAG, "Deleted old file " + file2.getPath());
            }
        }
    }

    private static void putStoredApkInfo(Context context, long j, long j2, int i) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(KEY_TIME_STAMP, j);
        edit.putLong(KEY_CRC, j2);
        edit.putInt(KEY_DEX_NUMBER, i);
        apply(edit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean verifyZipFile(File file) {
        try {
            try {
                new ZipFile(file).close();
                return true;
            } catch (IOException e) {
                Log.w(TAG, "Failed to close zip file: " + file.getAbsolutePath());
                return false;
            }
        } catch (ZipException e2) {
            Log.w(TAG, "File " + file.getAbsolutePath() + " is not a valid zip file.", e2);
            return false;
        } catch (IOException e3) {
            Log.w(TAG, "Got an IOException trying to open zip file: " + file.getAbsolutePath(), e3);
            return false;
        }
    }
}
