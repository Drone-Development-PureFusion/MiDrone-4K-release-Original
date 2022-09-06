package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.au */
/* loaded from: classes.dex */
public class C0788au extends AbstractC0785ar {

    /* renamed from: a */
    public int f2127a;

    /* renamed from: b */
    public int f2128b;

    /* renamed from: c */
    public float f2129c;

    public C0788au(int i, float f, int i2, int i3) {
        super(i);
        this.f2127a = 0;
        this.f2128b = 0;
        this.f2129c = 0.0f;
        this.f2129c = f;
        this.f2127a = i2;
        this.f2128b = i3;
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        IPoint iPoint;
        IPoint iPoint2 = null;
        int i = this.f2127a;
        int i2 = this.f2128b;
        if (i > 0 || i2 > 0) {
            iPoint = new IPoint();
            iPoint2 = new IPoint();
            win2geo(mapProjection, i, i2, iPoint);
            mapProjection.setGeoCenter(iPoint.f4730x, iPoint.f4731y);
        } else {
            iPoint = null;
        }
        mapProjection.setMapAngle(this.f2129c + mapProjection.getMapAngle());
        mapProjection.recalculate();
        if (i > 0 || i2 > 0) {
            win2geo(mapProjection, i, i2, iPoint2);
            mapProjection.setGeoCenter((iPoint.f4730x * 2) - iPoint2.f4730x, (iPoint.f4731y * 2) - iPoint2.f4731y);
            mapProjection.recalculate();
        }
    }
}
