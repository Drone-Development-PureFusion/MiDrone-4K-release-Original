package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.bg */
/* loaded from: classes.dex */
public class C2903bg extends C2822e {

    /* renamed from: b */
    public byte f10900b;

    /* renamed from: c */
    public byte f10901c;

    public C2903bg(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10373a() {
        return this.f10901c;
    }

    /* renamed from: a */
    public void m10372a(byte b, byte b2) {
        this.f10901c = b;
        this.f10900b = b2;
        this.f10431a.mo11220a(C2678d.EnumC2679a.UPDATEDRONEFINISHREPORTCRC);
    }

    /* renamed from: b */
    public byte m10371b() {
        return this.f10900b;
    }
}
