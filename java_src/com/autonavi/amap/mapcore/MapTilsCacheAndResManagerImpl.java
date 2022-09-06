package com.autonavi.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class MapTilsCacheAndResManagerImpl extends MapTilsCacheAndResManager {
    private static final int CREATE_DIR_COUNT = 5;
    private static final long Style_Update_Internal_Time = 43200000;
    private static volatile MapTilsCacheAndResManagerImpl instance = null;
    private String mCachePath;
    private Context mContext;
    private String mMapBaseDataPath;
    private String mMapExtResPath;
    private String mMapOfflinePath;
    private String mMapOnlineTilesPath;

    private MapTilsCacheAndResManagerImpl(Context context) {
        this.mContext = context;
        init();
    }

    private void addUdateRecorder(String str) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences("styles_icons_update_recorder", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        edit.commit();
    }

    static void copyAssertToTmp(Context context, String str, File file) {
        byte[] decodeAssetResData;
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || (decodeAssetResData = ResUtil.decodeAssetResData(context, str)) == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(decodeAssetResData);
            fileOutputStream.close();
        } catch (IOException e) {
        }
    }

    private synchronized void doReset() {
        instance = null;
    }

    private String getFilePreName(String str) {
        String[] split = str.split("_");
        return split[0] + "_" + split[1] + "_" + split[2];
    }

    private byte[] getStyleIconsData(String str, int i, MapTilsCacheAndResManager.RetStyleIconsFile retStyleIconsFile) {
        String filePreName = getFilePreName(str);
        MapTilsCacheAndResManager.RetStyleIconsFile retStyleIconsFile2 = new MapTilsCacheAndResManager.RetStyleIconsFile();
        setRetFile(retStyleIconsFile2, str);
        File[] listFiles = new File(this.mMapExtResPath).listFiles();
        if (listFiles != null) {
            try {
                for (File file : listFiles) {
                    if (file.getName().contains(filePreName)) {
                        setRetFile(retStyleIconsFile, file.getName());
                        if (retStyleIconsFile2.serverVersion < retStyleIconsFile.serverVersion) {
                            byte[] readFileContents = FileUtil.readFileContents(file.getAbsolutePath());
                            if (readFileContents != null && readFileContents.length > 0) {
                                if (i != 1) {
                                    return readFileContents;
                                }
                                if (readFileContents.length == Convert.getInt(readFileContents, 0) + 4) {
                                    return readFileContents;
                                }
                                FileUtil.deleteFile(file);
                            }
                        } else {
                            FileUtil.deleteFile(file);
                        }
                    }
                }
            } catch (OutOfMemoryError e) {
            }
        }
        setRetFile(retStyleIconsFile, str);
        return ResUtil.decodeAssetResData(this.mContext, "map_assets/" + str);
    }

    private void initRelease() {
        int i = 0;
        File file = new File(FileUtil.getMapBaseStorage(this.mContext));
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "data");
        if (!file2.exists()) {
            file2.mkdir();
        }
        this.mMapBaseDataPath = file2.toString() + "/";
        File file3 = new File(file2, MapTilsCacheAndResManager.MAP_DATA_OFFLINE_PATH_NAME);
        if (!file3.exists()) {
            file3.mkdir();
        }
        this.mMapOfflinePath = file3.toString() + "/";
        File file4 = new File(file2, "cache");
        int i2 = 0;
        while (!file4.exists()) {
            int i3 = i2 + 1;
            if (i2 >= 5) {
                break;
            }
            file4.mkdir();
            i2 = i3;
        }
        this.mCachePath = file4.toString() + "/";
        File file5 = new File(file4, MapTilsCacheAndResManager.MAP_TILES_PATH_NAME);
        int i4 = 0;
        while (!file5.exists()) {
            int i5 = i4 + 1;
            if (i4 >= 5) {
                break;
            }
            file5.mkdir();
            i4 = i5;
        }
        this.mMapOnlineTilesPath = file5.toString() + "/";
        File file6 = new File(file4, MapTilsCacheAndResManager.MAP_RES_EXT_PATH_NAME);
        while (!file6.exists()) {
            int i6 = i + 1;
            if (i >= 5) {
                break;
            }
            file6.mkdir();
            i = i6;
        }
        this.mMapExtResPath = file6.toString() + "/";
    }

    public static MapTilsCacheAndResManagerImpl instance(Context context) {
        if (instance == null) {
            instance = new MapTilsCacheAndResManagerImpl(context);
        }
        return instance;
    }

    private void setRetFile(MapTilsCacheAndResManager.RetStyleIconsFile retStyleIconsFile, String str) {
        if (retStyleIconsFile == null) {
            return;
        }
        retStyleIconsFile.fullName = str;
        String[] split = str.split("_|\\.");
        retStyleIconsFile.name = split[0] + "_" + split[1];
        retStyleIconsFile.clientVersion = Integer.parseInt(split[2]);
        retStyleIconsFile.serverVersion = Integer.parseInt(split[3]);
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public synchronized boolean canUpate(String str) {
        boolean z = false;
        synchronized (this) {
            long j = this.mContext.getSharedPreferences("styles_icons_update_recorder", 0).getLong(str, -1L);
            if (j <= 0 || System.currentTimeMillis() - j >= Style_Update_Internal_Time) {
                z = true;
            }
            if (z) {
                addUdateRecorder(str);
            }
        }
        return z;
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public void checkDir() {
        init();
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public void clearOnlineMapTilsCache() {
        File file = new File(this.mMapOnlineTilesPath);
        if (file.exists()) {
            FileUtil.deleteFile(file);
            init();
        }
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public String getBaseMapPath() {
        return this.mMapBaseDataPath;
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public byte[] getIconsData(String str, MapTilsCacheAndResManager.RetStyleIconsFile retStyleIconsFile) {
        try {
            return getStyleIconsData(str, 2, retStyleIconsFile);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public String getMapCachePath() {
        return this.mCachePath;
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public String getMapExtResPath() {
        return this.mMapExtResPath;
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public String getMapOfflineDataPath() {
        return this.mMapOfflinePath;
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public String getMapOnlineDataPath() {
        return this.mMapOnlineTilesPath;
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public byte[] getOtherResData(String str) {
        return ResUtil.decodeAssetResData(this.mContext, "map_assets/" + str);
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public byte[] getStyleData(String str, MapTilsCacheAndResManager.RetStyleIconsFile retStyleIconsFile) {
        try {
            return getStyleIconsData(str, 1, retStyleIconsFile);
        } catch (Throwable th) {
            return null;
        }
    }

    public void init() {
        try {
            initRelease();
        } catch (Throwable th) {
        }
    }

    void initDebug() {
    }

    public void reset() {
        doReset();
    }

    @Override // com.autonavi.amap.mapcore.MapTilsCacheAndResManager
    public void saveFile(String str, int i, int i2, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        File[] listFiles = new File(this.mMapExtResPath).listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                File file = listFiles[i3];
                if (file.getName().contains(str)) {
                    file.delete();
                    break;
                }
                i3++;
            }
        }
        FileUtil.writeDatasToFile(this.mMapExtResPath + (str + "_" + i + "_" + i2 + ".data"), bArr);
    }
}
