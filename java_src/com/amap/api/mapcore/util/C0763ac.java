package com.amap.api.mapcore.util;

import android.util.Pair;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapMessage;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.ac */
/* loaded from: classes.dex */
public class C0763ac extends AbstractC0766af {
    @Override // com.autonavi.amap.mapcore.MapMessage
    public void mergeCameraUpdateDelegate(MapMessage mapMessage) {
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        Pair<Float, IPoint> m18350a = C0945eh.m18350a(this, mapProjection, this.mapConfig);
        mapProjection.setMapZoomer(((Float) m18350a.first).floatValue());
        mapProjection.setGeoCenter(((IPoint) m18350a.second).f4730x, ((IPoint) m18350a.second).f4731y);
        mapProjection.setCameraHeaderAngle(0.0f);
        mapProjection.setMapAngle(0.0f);
    }
}
