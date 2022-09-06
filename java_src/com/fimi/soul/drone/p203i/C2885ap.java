package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.ap */
/* loaded from: classes.dex */
public class C2885ap extends C2822e {

    /* renamed from: b */
    private short f10808b;

    public C2885ap(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public short m10509a() {
        return this.f10808b;
    }

    /* renamed from: a */
    public void m10508a(short s) {
        this.f10808b = s;
        this.f10431a.mo11220a(C2678d.EnumC2679a.PauseWaypoint);
    }

    /* renamed from: b */
    public void m10507b() {
        this.f10808b = (short) 0;
    }
}
