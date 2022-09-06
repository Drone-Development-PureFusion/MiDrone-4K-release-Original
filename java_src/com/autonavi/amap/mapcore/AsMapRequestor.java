package com.autonavi.amap.mapcore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AsMapRequestor implements Runnable {
    public BaseMapLoader mMapLoader;

    public AsMapRequestor(BaseMapLoader baseMapLoader) {
        this.mMapLoader = null;
        this.mMapLoader = baseMapLoader;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mMapLoader.doRequest();
        } catch (Throwable th) {
        }
    }
}
