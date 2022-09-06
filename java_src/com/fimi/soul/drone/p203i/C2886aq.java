package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.aq */
/* loaded from: classes.dex */
public class C2886aq extends C2822e {

    /* renamed from: b */
    private double f10809b;

    /* renamed from: c */
    private byte f10810c;

    /* renamed from: d */
    private float f10811d;

    /* renamed from: e */
    private float f10812e;

    /* renamed from: f */
    private double f10813f;

    /* renamed from: g */
    private double f10814g;

    /* renamed from: h */
    private byte f10815h;

    /* renamed from: i */
    private short f10816i;

    public C2886aq() {
    }

    public C2886aq(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public short m10506a() {
        return this.f10816i;
    }

    /* renamed from: a */
    public void m10505a(double d, byte b, float f, float f2, double d2, double d3, byte b2) {
        this.f10809b = d;
        this.f10810c = b;
        this.f10811d = f;
        this.f10812e = f2;
        this.f10814g = d3;
        this.f10815h = b2;
        this.f10813f = d2;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.HEARDDAY);
        }
    }

    /* renamed from: a */
    public void m10504a(short s) {
        this.f10816i = s;
    }

    /* renamed from: b */
    public byte m10503b() {
        return this.f10815h;
    }

    /* renamed from: c */
    public double m10502c() {
        return this.f10809b;
    }

    /* renamed from: d */
    public byte m10501d() {
        return this.f10810c;
    }

    /* renamed from: e */
    public float m10500e() {
        return this.f10811d;
    }

    /* renamed from: f */
    public float m10499f() {
        return this.f10812e;
    }

    /* renamed from: g */
    public double m10498g() {
        return this.f10813f;
    }

    /* renamed from: h */
    public double m10497h() {
        return this.f10814g;
    }

    public String toString() {
        return "Pert{flighttime=" + this.f10809b + ", SatelliteNumber=" + ((int) this.f10810c) + ", CurrentLongitude=" + this.f10811d + ", CurrentLatitude=" + this.f10812e + ", Height=" + this.f10813f + ", Distance=" + this.f10814g + ", RFsignalstrength=" + ((int) this.f10815h) + C0359h.f726w;
    }
}
