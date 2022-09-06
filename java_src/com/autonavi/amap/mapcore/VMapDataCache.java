package com.autonavi.amap.mapcore;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class VMapDataCache {
    private static final int MAXSIZE = 400;
    private static VMapDataCache instance;
    HashMap<String, VMapDataRecoder> vMapDataHs = new HashMap<>();
    ArrayList<String> vMapDataList = new ArrayList<>();
    HashMap<String, VMapDataRecoder> vCancelMapDataHs = new HashMap<>();
    ArrayList<String> vCancelMapDataList = new ArrayList<>();

    public static VMapDataCache getInstance() {
        if (instance == null) {
            instance = new VMapDataCache();
        }
        return instance;
    }

    static String getKey(String str, int i) {
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i;
    }

    public synchronized VMapDataRecoder getCancelRecoder(String str, int i) {
        VMapDataRecoder vMapDataRecoder;
        vMapDataRecoder = this.vCancelMapDataHs.get(getKey(str, i));
        if (vMapDataRecoder != null) {
            if ((System.currentTimeMillis() / 1000) - vMapDataRecoder.mcreateTime > 10) {
                vMapDataRecoder = null;
            }
        }
        return vMapDataRecoder;
    }

    public synchronized VMapDataRecoder getRecoder(String str, int i) {
        VMapDataRecoder vMapDataRecoder;
        vMapDataRecoder = this.vMapDataHs.get(getKey(str, i));
        if (vMapDataRecoder != null) {
            vMapDataRecoder.times++;
        }
        return vMapDataRecoder;
    }

    public int getSize() {
        return this.vMapDataHs.size();
    }

    public synchronized VMapDataRecoder putCancelRecoder(byte[] bArr, String str, int i) {
        VMapDataRecoder vMapDataRecoder = null;
        synchronized (this) {
            if (getRecoder(str, i) == null) {
                VMapDataRecoder vMapDataRecoder2 = new VMapDataRecoder(str, i);
                if (vMapDataRecoder2.mGridName != null) {
                    if (this.vCancelMapDataHs.size() > MAXSIZE) {
                        this.vCancelMapDataHs.remove(this.vMapDataList.get(0));
                        this.vCancelMapDataList.remove(0);
                    }
                    this.vCancelMapDataHs.put(getKey(str, i), vMapDataRecoder2);
                    this.vCancelMapDataList.add(getKey(str, i));
                    vMapDataRecoder = vMapDataRecoder2;
                }
            }
        }
        return vMapDataRecoder;
    }

    public synchronized VMapDataRecoder putRecoder(byte[] bArr, String str, int i) {
        VMapDataRecoder vMapDataRecoder;
        vMapDataRecoder = new VMapDataRecoder(str, i);
        if (vMapDataRecoder.mGridName == null) {
            vMapDataRecoder = null;
        } else {
            if (this.vMapDataHs.size() > MAXSIZE) {
                this.vMapDataHs.remove(this.vMapDataList.get(0));
                this.vMapDataList.remove(0);
            }
            this.vMapDataHs.put(getKey(str, i), vMapDataRecoder);
            this.vMapDataList.add(getKey(str, i));
        }
        return vMapDataRecoder;
    }

    public synchronized void reset() {
        this.vMapDataHs.clear();
        this.vMapDataList.clear();
        this.vCancelMapDataHs.clear();
        this.vCancelMapDataList.clear();
    }
}
