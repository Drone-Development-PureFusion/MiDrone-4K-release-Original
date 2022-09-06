package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.bf */
/* loaded from: classes.dex */
public class C2902bf extends C2822e {

    /* renamed from: b */
    public byte f10898b;

    /* renamed from: c */
    public byte f10899c;

    public C2902bf(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10375a() {
        return this.f10898b;
    }

    /* renamed from: a */
    public void m10374a(byte b, byte b2) {
        this.f10899c = b;
        this.f10898b = b2;
        this.f10431a.mo11220a(C2678d.EnumC2679a.UPDATEDRONEFINISHREPORT);
    }
}
