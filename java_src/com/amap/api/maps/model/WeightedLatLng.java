package com.amap.api.maps.model;

import com.amap.api.mapcore.util.C0945eh;
import com.autonavi.amap.mapcore.DPoint;
/* loaded from: classes.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* renamed from: a */
    private DPoint f3817a;
    public final double intensity;
    public final LatLng latLng;

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }

    public WeightedLatLng(LatLng latLng, double d) {
        if (latLng == null) {
            throw new IllegalArgumentException("latLng can not null");
        }
        this.latLng = latLng;
        this.f3817a = C0945eh.m18346a(latLng);
        if (d >= 0.0d) {
            this.intensity = d;
        } else {
            this.intensity = 1.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DPoint getPoint() {
        return this.f3817a;
    }
}
