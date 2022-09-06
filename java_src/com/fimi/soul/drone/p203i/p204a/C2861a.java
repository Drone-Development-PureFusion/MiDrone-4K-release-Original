package com.fimi.soul.drone.p203i.p204a;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.a.a */
/* loaded from: classes.dex */
public class C2861a extends C2822e {

    /* renamed from: b */
    public byte f10651b;

    /* renamed from: c */
    public byte f10652c;

    /* renamed from: d */
    public byte f10653d;

    /* renamed from: e */
    public short f10654e;

    /* renamed from: f */
    public short f10655f;

    /* renamed from: g */
    public short f10656g;

    /* renamed from: h */
    public short f10657h;

    /* renamed from: i */
    public float f10658i;

    /* renamed from: j */
    public float f10659j;

    /* renamed from: k */
    public byte f10660k;

    public C2861a(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10743a() {
        return this.f10651b;
    }

    /* renamed from: a */
    public void m10742a(byte b, byte b2, byte b3, short s, short s2, short s3, short s4, float f, float f2, byte b4) {
        this.f10651b = b;
        this.f10652c = b2;
        this.f10653d = b3;
        this.f10654e = s;
        this.f10655f = s2;
        this.f10656g = s3;
        this.f10657h = s4;
        this.f10658i = f;
        this.f10659j = f2;
        this.f10660k = b4;
        this.f10431a.mo11220a(C2678d.EnumC2679a.TAKEPHOTOBACKDATA);
    }

    /* renamed from: b */
    public byte m10741b() {
        return this.f10660k;
    }

    /* renamed from: c */
    public float m10740c() {
        return this.f10659j;
    }

    /* renamed from: d */
    public short m10739d() {
        return this.f10657h;
    }

    /* renamed from: e */
    public float m10738e() {
        return this.f10658i;
    }

    /* renamed from: f */
    public short m10737f() {
        return this.f10655f;
    }

    /* renamed from: g */
    public short m10736g() {
        return this.f10656g;
    }

    /* renamed from: h */
    public short m10735h() {
        return this.f10654e;
    }

    /* renamed from: i */
    public byte m10734i() {
        return this.f10653d;
    }

    /* renamed from: j */
    public byte m10733j() {
        return this.f10652c;
    }

    public String toString() {
        return "DroneTakePhotoBean{packPacket_sequence=" + ((int) this.f10651b) + ", CMD_ID=" + ((int) this.f10652c) + ", Mode=" + ((int) this.f10653d) + ", Route_Length=" + ((int) this.f10654e) + ", Climb_Angle=" + ((int) this.f10655f) + ", Route_Speed=" + ((int) this.f10656g) + ", Start_point_Altitude=" + ((int) this.f10657h) + ", Start_point_Longitude=" + this.f10658i + ", Start_point_Latitude=" + this.f10659j + ", report=" + ((int) this.f10660k) + C0359h.f726w;
    }
}
