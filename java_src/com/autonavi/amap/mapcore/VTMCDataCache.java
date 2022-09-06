package com.autonavi.amap.mapcore;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class VTMCDataCache {
    public static final int MAXSIZE = 500;
    public static final int MAX_EXPIREDTIME = 300;
    private static VTMCDataCache instance;
    static Hashtable<String, VTmcData> vtmcHs = new Hashtable<>();
    static ArrayList<String> vtmcList = new ArrayList<>();
    public int mNewestTimeStamp = 0;

    private void deleteData(String str) {
        vtmcHs.remove(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < vtmcList.size()) {
                if (vtmcList.get(i2).equals(str)) {
                    vtmcList.remove(i2);
                    return;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static VTMCDataCache getInstance() {
        if (instance == null) {
            instance = new VTMCDataCache();
        }
        return instance;
    }

    public synchronized VTmcData getData(String str, boolean z) {
        VTmcData vTmcData;
        vTmcData = vtmcHs.get(str);
        if (!z) {
            if (vTmcData == null) {
                vTmcData = null;
            } else if (((int) (System.currentTimeMillis() / 1000)) - vTmcData.createTime > 300) {
                vTmcData = null;
            } else if (this.mNewestTimeStamp > vTmcData.timeStamp) {
                vTmcData = null;
            }
        }
        return vTmcData;
    }

    public int getSize() {
        return vtmcList.size();
    }

    public synchronized VTmcData putData(byte[] bArr) {
        VTmcData vTmcData;
        VTmcData vTmcData2 = new VTmcData(bArr);
        if (this.mNewestTimeStamp < vTmcData2.timeStamp) {
            this.mNewestTimeStamp = vTmcData2.timeStamp;
        }
        vTmcData = vtmcHs.get(vTmcData2.girdName);
        if (vTmcData != null) {
            if (vTmcData.eTag.equals(vTmcData2.eTag)) {
                vTmcData.updateTimeStamp(this.mNewestTimeStamp);
            } else {
                deleteData(vTmcData2.girdName);
            }
        }
        if (vtmcList.size() > 500) {
            vtmcHs.remove(vtmcList.get(0));
            vtmcList.remove(0);
        }
        vtmcHs.put(vTmcData2.girdName, vTmcData2);
        vtmcList.add(vTmcData2.girdName);
        vTmcData = vTmcData2;
        return vTmcData;
    }

    public void reset() {
        vtmcList.clear();
        vtmcHs.clear();
    }
}
