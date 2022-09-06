package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.as */
/* loaded from: classes.dex */
public class C0786as extends AbstractC0785ar {

    /* renamed from: a */
    public float f2124a;

    public C0786as(int i, float f) {
        super(i);
        this.f2124a = 0.0f;
        this.f2124a = f;
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        float f = 0.0f;
        float cameraHeaderAngle = mapProjection.getCameraHeaderAngle() + this.f2124a;
        if (cameraHeaderAngle >= 0.0f) {
            f = cameraHeaderAngle > 65.0f ? 65.0f : (mapProjection.getCameraHeaderAngle() <= 40.0f || cameraHeaderAngle <= 40.0f || mapProjection.getCameraHeaderAngle() <= cameraHeaderAngle) ? cameraHeaderAngle : 40.0f;
        }
        mapProjection.setCameraHeaderAngle(f);
        mapProjection.recalculate();
    }
}
