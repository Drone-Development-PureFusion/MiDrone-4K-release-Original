package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.bb */
/* loaded from: classes.dex */
public class C2898bb extends C2822e {

    /* renamed from: b */
    private short f10869b;

    /* renamed from: c */
    private byte f10870c;

    public C2898bb(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10427a() {
        return this.f10870c;
    }

    /* renamed from: a */
    public void m10426a(byte b) {
        this.f10870c = b;
    }

    /* renamed from: a */
    public void m10425a(short s, byte b) {
        this.f10870c = b;
        this.f10869b = s;
        this.f10431a.mo11220a(C2678d.EnumC2679a.SENDHOVERWAYPOINT);
    }

    /* renamed from: b */
    public short m10424b() {
        return this.f10869b;
    }

    /* renamed from: c */
    public void m10423c() {
        this.f10869b = (short) 0;
    }
}
