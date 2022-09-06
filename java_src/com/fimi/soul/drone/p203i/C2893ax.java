package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.ax */
/* loaded from: classes.dex */
public class C2893ax extends C2822e {

    /* renamed from: b */
    public int f10856b;

    /* renamed from: c */
    public int f10857c;

    /* renamed from: d */
    public int f10858d;

    public C2893ax(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public int m10451a() {
        return this.f10856b;
    }

    /* renamed from: a */
    public void m10450a(int i, int i2, int i3) {
        this.f10856b = i;
        this.f10857c = i2;
        this.f10858d = i3;
        this.f10431a.mo11220a(C2678d.EnumC2679a.RELEASECHAIN);
    }

    /* renamed from: b */
    public int m10449b() {
        return this.f10857c;
    }

    /* renamed from: c */
    public int m10448c() {
        return this.f10858d;
    }

    public String toString() {
        return "ReleaseChainVariable{targetID=" + this.f10856b + ", state=" + this.f10857c + ", report=" + this.f10858d + C0359h.f726w;
    }
}
