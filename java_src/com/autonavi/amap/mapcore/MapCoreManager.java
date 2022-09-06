package com.autonavi.amap.mapcore;

import android.util.Log;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class MapCoreManager {
    static MapCoreManager mapCoreManager;
    private Hashtable<Integer, MapCore> mapCoreTable = new Hashtable<>();

    static {
        try {
            System.loadLibrary("gdinamapv4sdk752");
            System.loadLibrary("gdinamapv4sdk752ex");
        } catch (Exception e) {
        }
    }

    private MapCoreManager() {
    }

    private void OnMapDataRequired(int i, String[] strArr, int i2) {
        Log.i("mapcore", "OnMapDataRequired instance: " + i2);
        if (i2 != 0) {
            MapCore mapCore = getMapCore(i2);
            if (mapCore == null) {
                return;
            }
            mapCore.OnMapDataRequired(i, strArr);
            return;
        }
        Log.i("mapcore", "instance is 0:  tilesNames: " + strArr.length);
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Log.i("mapcore", "instance is 0:  tilesNames: " + strArr[i3]);
        }
        for (Integer num : this.mapCoreTable.keySet()) {
            MapCore mapCore2 = this.mapCoreTable.get(num);
            if (mapCore2 != null) {
                mapCore2.OnMapDataRequired(i, strArr);
            }
        }
    }

    private void OnMapLabelsRequired(int[] iArr, int i, int i2) {
        MapCore mapCore;
        Log.i("mapcore", "OnMapLabelsRequired instance: " + i2);
        if (i2 != 0 && (mapCore = getMapCore(i2)) != null) {
            mapCore.OnMapLabelsRequired(iArr, i);
        }
        Log.i("mapcore", "OnMapLabelsRequired instance is :" + i2 + "  chars: " + iArr.length + "  size: " + i);
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Log.i("mapcore", "OnMapLabelsRequired instance is : " + i2 + " chars: " + iArr[i3]);
        }
    }

    public static MapCoreManager getInstance() {
        if (mapCoreManager == null) {
            mapCoreManager = new MapCoreManager();
        }
        return mapCoreManager;
    }

    private void onIndoorBuildingActivity(byte[] bArr, int i) {
        MapCore mapCore;
        if (i == 0 || (mapCore = getMapCore(i)) == null) {
            return;
        }
        mapCore.onIndoorBuildingActivity(bArr);
    }

    private void onIndoorDataRequired(int i, String[] strArr, int[] iArr, int[] iArr2, int i2) {
        MapCore mapCore;
        if (i2 == 0 || (mapCore = getMapCore(i2)) == null) {
            return;
        }
        mapCore.onIndoorDataRequired(i, strArr, iArr, iArr2);
    }

    public MapCore getMapCore(int i) {
        return this.mapCoreTable.get(Integer.valueOf(i));
    }

    public int getMapCoreSize() {
        return this.mapCoreTable.size();
    }

    public void putMapCore(int i, MapCore mapCore) {
        this.mapCoreTable.put(Integer.valueOf(i), mapCore);
    }

    public void removeMapCore(int i) {
        this.mapCoreTable.remove(Integer.valueOf(i));
    }
}
