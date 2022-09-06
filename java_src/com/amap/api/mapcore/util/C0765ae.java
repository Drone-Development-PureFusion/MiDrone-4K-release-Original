package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapMessage;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.ae */
/* loaded from: classes.dex */
public class C0765ae extends AbstractC0766af {
    /* renamed from: a */
    public void m19111a(MapProjection mapProjection, int i, int i2, IPoint iPoint) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        mapProjection.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void mergeCameraUpdateDelegate(MapMessage mapMessage) {
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        float f = this.f2024b;
        float f2 = this.f2025c;
        float f3 = f + (this.width / 2.0f);
        float f4 = f2 + (this.height / 2.0f);
        IPoint iPoint = new IPoint();
        m19111a(mapProjection, (int) f3, (int) f4, iPoint);
        mapProjection.setGeoCenter(iPoint.f4730x, iPoint.f4731y);
    }
}
