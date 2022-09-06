package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.ba */
/* loaded from: classes.dex */
public class C2897ba extends C2822e {

    /* renamed from: b */
    private short f10868b;

    public C2897ba(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public short m10430a() {
        return this.f10868b;
    }

    /* renamed from: a */
    public void m10429a(short s) {
        this.f10868b = s;
        this.f10431a.mo11220a(C2678d.EnumC2679a.ResumeWaypoint);
    }

    /* renamed from: b */
    public void m10428b() {
        this.f10868b = (short) 0;
    }
}
