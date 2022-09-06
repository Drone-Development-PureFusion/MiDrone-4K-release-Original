package com.fimi.soul.drone.p203i.p204a;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.a.c */
/* loaded from: classes.dex */
public class C2864c extends C2822e {

    /* renamed from: b */
    public byte f10667b;

    /* renamed from: c */
    public short f10668c;

    /* renamed from: d */
    public float f10669d;

    /* renamed from: e */
    public float f10670e;

    /* renamed from: f */
    public byte f10671f;

    /* renamed from: g */
    public short f10672g;

    /* renamed from: h */
    public byte f10673h = 10;

    /* renamed from: i */
    public byte f10674i;

    /* renamed from: j */
    public byte f10675j;

    /* renamed from: k */
    public byte f10676k;

    /* renamed from: l */
    public short f10677l;

    /* renamed from: m */
    public short f10678m;

    /* renamed from: n */
    public short f10679n;

    public C2864c() {
    }

    public C2864c(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10725a() {
        return this.f10667b;
    }

    /* renamed from: a */
    public void m10724a(byte b) {
        this.f10671f = b;
    }

    /* renamed from: a */
    public void m10723a(byte b, short s, float f, float f2, byte b2, short s2, byte b3, byte b4, byte b5, byte b6, short s3, short s4, short s5) {
        this.f10667b = b;
        this.f10668c = s;
        this.f10669d = f;
        this.f10670e = f2;
        this.f10671f = b2;
        this.f10672g = s2;
        this.f10673h = b3;
        this.f10674i = b4;
        this.f10675j = b5;
        this.f10676k = b6;
        this.f10677l = s3;
        this.f10678m = s4;
        this.f10679n = s5;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.NOFLYZONE);
        }
    }

    /* renamed from: a */
    public void m10722a(short s) {
        this.f10668c = s;
    }

    /* renamed from: b */
    public byte m10721b() {
        return this.f10673h;
    }

    /* renamed from: b */
    public void m10720b(short s) {
        this.f10672g = s;
    }

    /* renamed from: c */
    public short m10719c() {
        return this.f10672g;
    }

    /* renamed from: d */
    public short m10718d() {
        return this.f10668c;
    }

    /* renamed from: e */
    public byte m10717e() {
        return this.f10671f;
    }

    /* renamed from: f */
    public float m10716f() {
        return this.f10670e;
    }

    /* renamed from: g */
    public float m10715g() {
        return this.f10669d;
    }

    /* renamed from: h */
    public byte m10714h() {
        return this.f10674i;
    }

    /* renamed from: i */
    public byte m10713i() {
        return this.f10675j;
    }

    /* renamed from: j */
    public byte m10712j() {
        return this.f10676k;
    }

    /* renamed from: k */
    public short m10711k() {
        return this.f10677l;
    }

    /* renamed from: l */
    public short m10710l() {
        return this.f10678m;
    }

    /* renamed from: m */
    public short m10709m() {
        return this.f10679n;
    }

    public String toString() {
        return "FlyZone{Opration_code=" + ((int) this.f10667b) + ", number=" + ((int) this.f10668c) + ", Forbiden_Longitude=" + this.f10669d + ", Forbiden_Latitude=" + this.f10670e + ", type=" + ((int) this.f10671f) + ", radius=" + ((int) this.f10672g) + ", status=" + ((int) this.f10673h) + ", NFZ_Function_State=" + ((int) this.f10674i) + ", Vehicle_State=" + ((int) this.f10675j) + ", NFZ_Type=" + ((int) this.f10676k) + ", HeightLimit=" + ((int) this.f10677l) + ", WFZRadius=" + ((int) this.f10678m) + ", HeightLimitRadius=" + ((int) this.f10679n) + C0359h.f726w;
    }
}
