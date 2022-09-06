package com.autonavi.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.amap.api.maps.MapsInitializer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    public static void copy(Context context, String str, File file) {
        file.delete();
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!deleteFile(listFiles[i])) {
                    return false;
                } else {
                    listFiles[i].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    public static String getExternalStroragePath(Context context) {
        String str;
        int i = Build.VERSION.SDK_INT;
        if (i >= 12) {
            try {
                StorageManager storageManager = (StorageManager) context.getSystemService("storage");
                Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
                Method method2 = StorageManager.class.getMethod("getVolumeState", String.class);
                Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
                Boolean.valueOf(false);
                String str2 = "";
                String str3 = "";
                int length = objArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str = null;
                        break;
                    }
                    Object obj = objArr[i2];
                    Method method3 = obj.getClass().getMethod("getPath", new Class[0]);
                    Method method4 = obj.getClass().getMethod("isRemovable", new Class[0]);
                    String str4 = (String) method3.invoke(obj, new Object[0]);
                    String str5 = (String) method2.invoke(storageManager, method3.invoke(obj, new Object[0]));
                    Boolean bool = (Boolean) method4.invoke(obj, new Object[0]);
                    if (str4.toLowerCase().contains("private")) {
                        str5 = str3;
                        str4 = str2;
                    } else if (!bool.booleanValue()) {
                        continue;
                    } else if (str4 == null || str5 == null || !str5.equals("mounted")) {
                        str5 = str3;
                        str4 = str2;
                    } else if (i <= 18) {
                        str = str4;
                    } else {
                        try {
                            File[] externalFilesDirs = context.getExternalFilesDirs(null);
                            if (externalFilesDirs == null) {
                                str4 = null;
                            } else if (externalFilesDirs.length > 1) {
                                str4 = externalFilesDirs[1].getAbsolutePath();
                            }
                            str = str4;
                        } catch (Exception e) {
                            str = str4;
                        }
                    }
                    i2++;
                    str3 = str5;
                    str2 = str4;
                }
                if (i <= 18) {
                    return (str != null || str2 == null || str3 == null || !str3.equals("mounted")) ? str : str2;
                }
                if (str2 != null && str3 != null && str3.equals("mounted")) {
                    str = str2;
                }
                return str;
            } catch (Throwable th) {
            }
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().toString();
        }
        return null;
    }

    public static String getMapBaseStorage(Context context) {
        String str = "map_base_path";
        if (Build.VERSION.SDK_INT > 18) {
            str = "map_base_path_v44";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        String string = (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.trim().length() <= 0) ? sharedPreferences.getString(str, "") : MapsInitializer.sdcardDir;
        if (string != null && string.length() > 2) {
            File file = new File(string);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (file.canWrite()) {
                    return string;
                }
                String file2 = context.getCacheDir().toString();
                if (file2 != null && file2.length() > 2 && new File(file2).isDirectory()) {
                    return file2;
                }
            }
        }
        String externalStroragePath = getExternalStroragePath(context);
        if (externalStroragePath != null && externalStroragePath.length() > 2) {
            String str2 = externalStroragePath + File.separator + MapTilsCacheAndResManager.AUTONAVI_PATH;
            File file3 = new File(str2);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, str2);
                edit.commit();
                createNoMediaFileIfNotExist(str2);
                return str2;
            }
        }
        String file4 = context.getCacheDir().toString();
        if (file4 == null || file4.length() <= 2) {
            return file4;
        }
        String str3 = file4 + File.separator + MapTilsCacheAndResManager.AUTONAVI_PATH;
        File file5 = new File(str3);
        if (!file5.exists()) {
            file5.mkdir();
        }
        if (file5.isDirectory()) {
        }
        return str3;
    }

    public static byte[] readFileContents(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        try {
            if (bArr != null) {
                if (bArr.length != 0) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
