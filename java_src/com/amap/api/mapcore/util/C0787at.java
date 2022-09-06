package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.at */
/* loaded from: classes.dex */
public class C0787at extends AbstractC0785ar {

    /* renamed from: a */
    public float f2125a;

    /* renamed from: b */
    public float f2126b;

    public C0787at(int i, float f, float f2) {
        super(i);
        this.f2125a = 0.0f;
        this.f2126b = 0.0f;
        this.f2125a = f;
        this.f2126b = f2;
    }

    @Override // com.autonavi.amap.mapcore.MapMessage
    public void runCameraUpdate(MapProjection mapProjection) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map((int) ((this.width >> 1) - ((int) this.f2125a)), (int) ((this.height >> 1) - ((int) this.f2126b)), fPoint);
        mapProjection.setMapCenter(fPoint.f4728x, fPoint.f4729y);
        mapProjection.recalculate();
    }
}
