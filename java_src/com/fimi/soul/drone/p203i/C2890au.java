package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.au */
/* loaded from: classes.dex */
public class C2890au extends C2822e {

    /* renamed from: b */
    public double f10828b;

    /* renamed from: c */
    public int f10829c;

    /* renamed from: d */
    public float f10830d;

    /* renamed from: e */
    public float f10831e;

    /* renamed from: f */
    public double f10832f;

    /* renamed from: g */
    public short f10833g;

    /* renamed from: h */
    public int f10834h;

    /* renamed from: i */
    public int f10835i;

    /* renamed from: j */
    public byte f10836j;

    /* renamed from: k */
    public byte f10837k;

    /* renamed from: l */
    public byte f10838l;

    public C2890au(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10482a() {
        return this.f10838l;
    }

    /* renamed from: a */
    public void m10481a(double d, int i, float f, float f2, double d2, short s, int i2, int i3, byte b, byte b2, byte b3) {
        this.f10828b = d;
        this.f10829c = i;
        this.f10830d = f;
        this.f10831e = f2;
        this.f10832f = d2;
        this.f10833g = s;
        this.f10834h = i2 & 255;
        this.f10835i = i3 & 255;
        this.f10836j = b;
        this.f10837k = b2;
        this.f10838l = b3;
        this.f10431a.mo11220a(C2678d.EnumC2679a.RETURNINTERESTWAYPOIT);
    }

    /* renamed from: b */
    public byte m10480b() {
        return this.f10837k;
    }

    /* renamed from: c */
    public byte m10479c() {
        return this.f10836j;
    }

    /* renamed from: d */
    public int m10478d() {
        return this.f10835i;
    }

    /* renamed from: e */
    public int m10477e() {
        return this.f10834h;
    }

    /* renamed from: f */
    public short m10476f() {
        return this.f10833g;
    }

    /* renamed from: g */
    public double m10475g() {
        return this.f10832f;
    }

    /* renamed from: h */
    public float m10474h() {
        return this.f10831e;
    }

    /* renamed from: i */
    public float m10473i() {
        return this.f10830d;
    }

    /* renamed from: j */
    public int m10472j() {
        return this.f10829c;
    }

    /* renamed from: k */
    public double m10471k() {
        return this.f10828b;
    }

    public String toString() {
        return "ReceiveSettingPoint{PacketSequence=" + this.f10828b + ", Opration_Code=" + this.f10829c + ", POI_Longitude=" + this.f10830d + ", POI_Latitude=" + this.f10831e + ", POI_Altitude=" + this.f10832f + ", Radius=" + ((int) this.f10833g) + ", speek=" + this.f10834h + ", Start_Point_Pole_Angle=" + this.f10835i + ", Paral=" + ((int) this.f10836j) + ", yaw_mode=" + ((int) this.f10837k) + ", report=" + ((int) this.f10838l) + C0359h.f726w;
    }
}
