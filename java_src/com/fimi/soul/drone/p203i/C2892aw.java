package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.aw */
/* loaded from: classes.dex */
public class C2892aw extends C2822e {

    /* renamed from: b */
    public int f10848b;

    /* renamed from: c */
    public float f10849c;

    /* renamed from: d */
    public float f10850d;

    /* renamed from: e */
    public double f10851e;

    /* renamed from: f */
    public double f10852f;

    /* renamed from: g */
    public double f10853g;

    /* renamed from: h */
    public double f10854h;

    /* renamed from: i */
    public int f10855i = 0;

    public C2892aw(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public int m10460a() {
        return this.f10848b;
    }

    /* renamed from: a */
    public void m10459a(int i, float f, float f2, double d, double d2, double d3, double d4, int i2) {
        this.f10848b = i;
        this.f10849c = f;
        this.f10850d = f2;
        this.f10851e = d;
        this.f10852f = d2;
        this.f10853g = d3;
        this.f10854h = d4;
        this.f10855i = i2;
        this.f10431a.mo11220a(C2678d.EnumC2679a.RECEIVERPOINTS);
    }

    /* renamed from: b */
    public double m10458b() {
        return this.f10849c;
    }

    /* renamed from: c */
    public double m10457c() {
        return this.f10850d;
    }

    /* renamed from: d */
    public double m10456d() {
        return this.f10851e;
    }

    /* renamed from: e */
    public double m10455e() {
        return this.f10852f;
    }

    /* renamed from: f */
    public double m10454f() {
        return this.f10853g;
    }

    /* renamed from: g */
    public double m10453g() {
        return this.f10854h;
    }

    /* renamed from: h */
    public int m10452h() {
        return this.f10855i;
    }

    public String toString() {
        return "Receivepoints [number=" + this.f10848b + ", Longitude=" + this.f10849c + ", Latitude=" + this.f10850d + ", Altitude=" + this.f10851e + ", yaw_angle=" + this.f10852f + ", hover_time=" + this.f10853g + ", speed=" + this.f10854h + ", Number_to_be_transmited=" + this.f10855i + "]";
    }
}
