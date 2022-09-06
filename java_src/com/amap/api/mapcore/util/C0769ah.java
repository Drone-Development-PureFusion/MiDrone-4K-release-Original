package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.MapMessage;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.ah */
/* loaded from: classes.dex */
public class C0769ah extends AbstractC0766af {
    @Override // com.autonavi.amap.mapcore.MapMessage
    public void mergeCameraUpdateDelegate(MapMessage mapMessage) {
        mapMessage.zoom += this.f2026d;
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        this.zoom = mapProjection.getMapZoomer() + this.f2026d;
        this.zoom = C0945eh.m18340a(this.mapConfig, this.zoom);
        a(mapProjection);
    }
}
