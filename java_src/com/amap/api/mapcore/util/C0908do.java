package com.amap.api.mapcore.util;

import com.amap.api.maps.model.LatLng;
/* renamed from: com.amap.api.mapcore.util.do */
/* loaded from: classes.dex */
public class C0908do extends C0902di {

    /* renamed from: c */
    public double f2788c;

    /* renamed from: w */
    public double f2789w;

    /* renamed from: a */
    public double f2786a = 0.0d;

    /* renamed from: b */
    public double f2787b = 0.0d;

    /* renamed from: x */
    public double f2790x = 0.0d;

    /* renamed from: y */
    public double f2791y = 0.0d;

    public C0908do(LatLng latLng) {
        this.f2788c = 0.0d;
        this.f2789w = 0.0d;
        this.f2788c = latLng.longitude;
        this.f2789w = latLng.latitude;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: a */
    protected void mo18508a(float f, C0907dn c0907dn) {
        this.f2790x = this.f2786a;
        this.f2791y = this.f2787b;
        if (this.f2786a != this.f2788c) {
            this.f2790x = this.f2786a + ((this.f2788c - this.f2786a) * f);
        }
        if (this.f2787b != this.f2789w) {
            this.f2791y = this.f2787b + ((this.f2789w - this.f2787b) * f);
        }
        c0907dn.f2780a = this.f2790x;
        c0907dn.f2781b = this.f2791y;
    }
}
