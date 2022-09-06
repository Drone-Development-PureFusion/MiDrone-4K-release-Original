package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.bh */
/* loaded from: classes.dex */
public class C2904bh extends C2822e {

    /* renamed from: b */
    public byte f10902b;

    /* renamed from: c */
    public byte f10903c;

    /* renamed from: d */
    public byte f10904d;

    public C2904bh(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10370a() {
        return this.f10902b;
    }

    /* renamed from: a */
    public void m10369a(byte b, byte b2, byte b3) {
        this.f10902b = b;
        this.f10903c = b2;
        this.f10904d = b3;
        this.f10431a.mo11220a(C2678d.EnumC2679a.UPDATEDRONEOBJECTREPORT);
    }

    /* renamed from: b */
    public byte m10368b() {
        return this.f10903c;
    }

    /* renamed from: c */
    public byte m10367c() {
        return this.f10904d;
    }
}
