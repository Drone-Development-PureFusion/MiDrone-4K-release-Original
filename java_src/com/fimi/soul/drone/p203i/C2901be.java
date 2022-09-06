package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.be */
/* loaded from: classes.dex */
public class C2901be extends C2822e {

    /* renamed from: b */
    private double f10891b;

    /* renamed from: c */
    private double f10892c;

    /* renamed from: d */
    private double f10893d;

    /* renamed from: e */
    private double f10894e;

    /* renamed from: f */
    private double f10895f;

    /* renamed from: g */
    private byte f10896g;

    /* renamed from: h */
    private double f10897h;

    public C2901be(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10383a() {
        return this.f10896g;
    }

    /* renamed from: a */
    public void m10382a(double d, double d2, double d3, double d4, double d5, byte b, double d6) {
        this.f10891b = d;
        this.f10892c = d2;
        this.f10893d = d3;
        this.f10894e = d4;
        this.f10895f = d5;
        this.f10896g = b;
        this.f10897h = d6;
        this.f10431a.mo11220a(C2678d.EnumC2679a.GPS_FIX);
    }

    /* renamed from: b */
    public double m10381b() {
        return this.f10897h;
    }

    /* renamed from: c */
    public double m10380c() {
        return this.f10891b;
    }

    /* renamed from: d */
    public double m10379d() {
        return this.f10892c;
    }

    /* renamed from: e */
    public double m10378e() {
        return this.f10893d;
    }

    /* renamed from: f */
    public double m10377f() {
        return this.f10894e;
    }

    /* renamed from: g */
    public double m10376g() {
        return this.f10895f;
    }

    public String toString() {
        return "TelWaypoint [GPSLatitude=" + this.f10891b + ", GPSLongitude=" + this.f10892c + ", GPSAltitude=" + this.f10893d + ", GPSSpeed=" + this.f10894e + ", GPSBearing=" + this.f10895f + ", number=" + ((int) this.f10896g) + ", accuracy=" + this.f10897h + "]";
    }
}
