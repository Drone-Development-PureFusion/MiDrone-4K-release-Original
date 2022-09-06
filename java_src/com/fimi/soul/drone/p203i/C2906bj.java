package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.bj */
/* loaded from: classes.dex */
public class C2906bj extends C2822e {

    /* renamed from: b */
    public byte f10907b;

    /* renamed from: c */
    public short f10908c;

    /* renamed from: d */
    public byte f10909d;

    public C2906bj(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public short m10363a() {
        return this.f10908c;
    }

    /* renamed from: a */
    public void m10362a(byte b, short s, byte b2) {
        this.f10907b = b;
        this.f10908c = s;
        this.f10909d = b2;
        this.f10431a.mo11220a(C2678d.EnumC2679a.UPDATEDRONEREPORT);
    }

    /* renamed from: b */
    public byte m10361b() {
        return this.f10909d;
    }

    /* renamed from: c */
    public byte m10360c() {
        return this.f10907b;
    }

    public String toString() {
        return "UpdateDronerepory{target_ID=" + ((int) this.f10907b) + ", Packet_sequence=" + ((int) this.f10908c) + ", report=" + ((int) this.f10909d) + C0359h.f726w;
    }
}
