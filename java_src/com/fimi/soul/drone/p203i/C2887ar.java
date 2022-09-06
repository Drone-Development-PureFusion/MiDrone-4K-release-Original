package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.ar */
/* loaded from: classes.dex */
public class C2887ar extends C2822e {

    /* renamed from: b */
    private byte f10817b;

    /* renamed from: c */
    private byte f10818c;

    /* renamed from: d */
    private byte f10819d;

    public C2887ar(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10496a() {
        return this.f10817b;
    }

    /* renamed from: a */
    public void m10495a(byte b, byte b2, byte b3) {
        this.f10817b = b;
        this.f10819d = b2;
        this.f10818c = b3;
        this.f10431a.mo11220a(C2678d.EnumC2679a.PowerBatteryProgress);
    }

    /* renamed from: b */
    public byte m10494b() {
        return this.f10818c;
    }

    /* renamed from: c */
    public byte m10493c() {
        return this.f10819d;
    }
}
