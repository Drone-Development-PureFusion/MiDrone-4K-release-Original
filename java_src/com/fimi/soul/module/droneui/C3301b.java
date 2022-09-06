package com.fimi.soul.module.droneui;
/* renamed from: com.fimi.soul.module.droneui.b */
/* loaded from: classes.dex */
public class C3301b {

    /* renamed from: a */
    static double f12817a = 6378137.0d;

    /* renamed from: b */
    static double f12818b = 6356725.0d;

    /* renamed from: c */
    double f12819c;

    /* renamed from: d */
    double f12820d;

    /* renamed from: e */
    double f12821e;

    /* renamed from: f */
    double f12822f;

    /* renamed from: g */
    double f12823g;

    /* renamed from: h */
    double f12824h;

    /* renamed from: i */
    double f12825i;

    /* renamed from: j */
    double f12826j;

    /* renamed from: k */
    double f12827k;

    /* renamed from: l */
    double f12828l;

    /* renamed from: m */
    double f12829m;

    /* renamed from: n */
    double f12830n;

    public C3301b(double d, double d2) {
        this.f12819c = (int) d;
        this.f12820d = (int) ((d - this.f12819c) * 60.0d);
        this.f12821e = ((d - this.f12819c) - (this.f12820d / 60.0d)) * 3600.0d;
        this.f12822f = (int) d2;
        this.f12823g = (int) ((d2 - this.f12822f) * 60.0d);
        this.f12824h = ((d2 - this.f12822f) - (this.f12823g / 60.0d)) * 3600.0d;
        this.f12825i = d;
        this.f12826j = d2;
        this.f12827k = (3.141592653589793d * d) / 180.0d;
        this.f12828l = (3.141592653589793d * d2) / 180.0d;
        this.f12829m = f12818b + (((f12817a - f12818b) * (90.0d - this.f12826j)) / 90.0d);
        this.f12830n = this.f12829m * Math.cos(this.f12828l);
    }

    /* renamed from: a */
    public static double m8789a(C3301b c3301b, C3301b c3301b2) {
        double atan = (Math.atan(Math.abs(((c3301b2.f12827k - c3301b.f12827k) * c3301b.f12830n) / ((c3301b2.f12828l - c3301b.f12828l) * c3301b.f12829m))) * 180.0d) / 3.141592653589793d;
        double d = c3301b2.f12825i - c3301b.f12825i;
        double d2 = c3301b2.f12826j - c3301b.f12826j;
        return (d <= 0.0d || d2 > 0.0d) ? (d > 0.0d || d2 >= 0.0d) ? (d >= 0.0d || d2 < 0.0d) ? atan : (90.0d - atan) + 270.0d : atan + 180.0d : (90.0d - atan) + 90.0d;
    }

    /* renamed from: a */
    public static C3301b m8791a(double d, double d2, double d3, double d4) {
        return m8790a(new C3301b(d, d2), d3, d4);
    }

    /* renamed from: a */
    public static C3301b m8790a(C3301b c3301b, double d, double d2) {
        return new C3301b((((((d * 1000.0d) * Math.sin((d2 * 3.141592653589793d) / 180.0d)) / c3301b.f12830n) + c3301b.f12827k) * 180.0d) / 3.141592653589793d, (((((d * 1000.0d) * Math.cos((d2 * 3.141592653589793d) / 180.0d)) / c3301b.f12829m) + c3301b.f12828l) * 180.0d) / 3.141592653589793d);
    }
}
