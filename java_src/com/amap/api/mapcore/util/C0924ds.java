package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;
/* renamed from: com.amap.api.mapcore.util.ds */
/* loaded from: classes.dex */
public class C0924ds {

    /* renamed from: a */
    public final double f2835a;

    /* renamed from: b */
    public final double f2836b;

    /* renamed from: c */
    public final double f2837c;

    /* renamed from: d */
    public final double f2838d;

    /* renamed from: e */
    public final double f2839e;

    /* renamed from: f */
    public final double f2840f;

    public C0924ds(double d, double d2, double d3, double d4) {
        this.f2835a = d;
        this.f2836b = d3;
        this.f2837c = d2;
        this.f2838d = d4;
        this.f2839e = (d + d2) / 2.0d;
        this.f2840f = (d3 + d4) / 2.0d;
    }

    /* renamed from: a */
    public boolean m18477a(double d, double d2) {
        return this.f2835a <= d && d <= this.f2837c && this.f2836b <= d2 && d2 <= this.f2838d;
    }

    /* renamed from: a */
    public boolean m18476a(double d, double d2, double d3, double d4) {
        return d < this.f2837c && this.f2835a < d2 && d3 < this.f2838d && this.f2836b < d4;
    }

    /* renamed from: a */
    public boolean m18475a(C0924ds c0924ds) {
        return m18476a(c0924ds.f2835a, c0924ds.f2837c, c0924ds.f2836b, c0924ds.f2838d);
    }

    /* renamed from: a */
    public boolean m18474a(DPoint dPoint) {
        return m18477a(dPoint.f4726x, dPoint.f4727y);
    }

    /* renamed from: b */
    public boolean m18473b(C0924ds c0924ds) {
        return c0924ds.f2835a >= this.f2835a && c0924ds.f2837c <= this.f2837c && c0924ds.f2836b >= this.f2836b && c0924ds.f2838d <= this.f2838d;
    }
}
