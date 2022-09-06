package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.av */
/* loaded from: classes.dex */
public class C2891av extends C2822e {

    /* renamed from: b */
    public volatile int f10839b;

    /* renamed from: c */
    public float f10840c;

    /* renamed from: d */
    public float f10841d;

    /* renamed from: e */
    public double f10842e;

    /* renamed from: f */
    public double f10843f;

    /* renamed from: g */
    public double f10844g;

    /* renamed from: h */
    public double f10845h;

    /* renamed from: i */
    public double f10846i;

    /* renamed from: j */
    private byte f10847j;

    public C2891av(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public int m10470a() {
        return this.f10839b;
    }

    /* renamed from: a */
    public void m10469a(int i, float f, float f2, double d, double d2, double d3, double d4, double d5, byte b) {
        this.f10839b = i;
        this.f10840c = f;
        this.f10841d = f2;
        this.f10842e = d;
        this.f10843f = d2;
        this.f10844g = d3;
        this.f10845h = d4;
        this.f10846i = d5;
        this.f10847j = b;
        this.f10431a.mo11220a(C2678d.EnumC2679a.RECEIVERWAYPOINTS);
    }

    /* renamed from: b */
    public double m10468b() {
        return this.f10840c;
    }

    /* renamed from: c */
    public double m10467c() {
        return this.f10841d;
    }

    /* renamed from: d */
    public double m10466d() {
        return this.f10842e;
    }

    /* renamed from: e */
    public double m10465e() {
        return this.f10843f;
    }

    /* renamed from: f */
    public double m10464f() {
        return this.f10844g;
    }

    /* renamed from: g */
    public double m10463g() {
        return this.f10845h;
    }

    /* renamed from: h */
    public double m10462h() {
        return this.f10846i;
    }

    /* renamed from: i */
    public byte m10461i() {
        return this.f10847j;
    }

    public String toString() {
        return "Receivepoint [number=" + this.f10839b + ", Longitude=" + this.f10840c + ", Latitude=" + this.f10841d + ", Altitude=" + this.f10842e + ", yaw_angle=" + this.f10843f + ", hover_time=" + this.f10844g + ", report=" + this.f10845h + ", Number_to_be_transmited=" + this.f10846i + "]";
    }
}
