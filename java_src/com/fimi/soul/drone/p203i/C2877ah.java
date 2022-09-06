package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.ah */
/* loaded from: classes.dex */
public class C2877ah extends C2822e {

    /* renamed from: b */
    private double f10746b;

    /* renamed from: c */
    private double f10747c;

    /* renamed from: d */
    private double f10748d;

    /* renamed from: e */
    private int f10749e;

    /* renamed from: f */
    private float f10750f;

    /* renamed from: g */
    private byte f10751g;

    public C2877ah() {
    }

    public C2877ah(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public float m10616a() {
        return this.f10750f;
    }

    /* renamed from: a */
    public void m10615a(double d) {
        this.f10746b = d;
    }

    /* renamed from: a */
    public void m10614a(double d, double d2, double d3, int i, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f10747c = d;
        this.f10746b = d2;
        this.f10748d = d3;
        this.f10749e = i;
        this.f10751g = b5;
    }

    /* renamed from: a */
    public void m10613a(double d, double d2, double d3, int i, float f, byte b) {
        this.f10747c = d;
        this.f10746b = d2;
        this.f10748d = d3;
        this.f10749e = i;
        this.f10750f = f;
        this.f10751g = b;
        this.f10431a.mo11220a(C2678d.EnumC2679a.HOMEPOINT);
    }

    /* renamed from: b */
    public double m10612b() {
        return this.f10746b;
    }

    /* renamed from: c */
    public double m10611c() {
        return this.f10747c;
    }

    /* renamed from: d */
    public double m10610d() {
        return this.f10748d;
    }

    /* renamed from: e */
    public int m10609e() {
        return this.f10749e;
    }

    /* renamed from: f */
    public boolean m10608f() {
        return (this.f10751g & 15) == 1;
    }

    /* renamed from: g */
    public boolean m10607g() {
        return ((this.f10751g & 240) >> 4) == 1;
    }
}
