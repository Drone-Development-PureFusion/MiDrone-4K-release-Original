package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.e */
/* loaded from: classes.dex */
public class C2910e extends C2822e {

    /* renamed from: b */
    public short f10940b;

    /* renamed from: c */
    public short f10941c;

    /* renamed from: d */
    public short f10942d;

    /* renamed from: e */
    public short f10943e;

    /* renamed from: f */
    public short f10944f;

    public C2910e() {
    }

    public C2910e(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public short m10326a() {
        return this.f10940b;
    }

    /* renamed from: a */
    public void m10325a(short s, short s2, short s3, short s4, short s5) {
        this.f10940b = s;
        this.f10941c = s2;
        this.f10942d = s5;
        this.f10943e = s3;
        this.f10944f = s4;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.BATTERYINFO);
        }
    }

    /* renamed from: b */
    public short m10324b() {
        return this.f10941c;
    }

    /* renamed from: c */
    public short m10323c() {
        return this.f10942d;
    }

    /* renamed from: d */
    public short m10322d() {
        return this.f10943e;
    }

    /* renamed from: e */
    public short m10321e() {
        return this.f10944f;
    }
}
