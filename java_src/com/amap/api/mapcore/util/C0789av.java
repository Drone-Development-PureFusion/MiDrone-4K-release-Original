package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.av */
/* loaded from: classes.dex */
public class C0789av extends AbstractC0785ar {

    /* renamed from: a */
    public float f2130a;

    /* renamed from: b */
    public int f2131b;

    /* renamed from: c */
    public int f2132c;

    public C0789av(int i, float f, int i2, int i3) {
        super(i);
        this.f2130a = 0.0f;
        this.f2131b = 0;
        this.f2132c = 0;
        this.f2130a = f;
        this.f2131b = i2;
        this.f2132c = i3;
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        IPoint iPoint;
        IPoint iPoint2 = null;
        int i = this.f2131b;
        int i2 = this.f2132c;
        if (i > 0 || i2 > 0) {
            iPoint = new IPoint();
            iPoint2 = new IPoint();
            win2geo(mapProjection, i, i2, iPoint);
            mapProjection.setGeoCenter(iPoint.f4730x, iPoint.f4731y);
        } else {
            iPoint = null;
        }
        mapProjection.setMapZoomer(this.f2130a + mapProjection.getMapZoomer());
        mapProjection.recalculate();
        if (i > 0 || i2 > 0) {
            win2geo(mapProjection, i, i2, iPoint2);
            mapProjection.setGeoCenter((iPoint.f4730x * 2) - iPoint2.f4730x, (iPoint.f4731y * 2) - iPoint2.f4731y);
            mapProjection.recalculate();
        }
    }
}
