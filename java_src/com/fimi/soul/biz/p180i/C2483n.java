package com.fimi.soul.biz.p180i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.module.p207b.C3053b;
/* renamed from: com.fimi.soul.biz.i.n */
/* loaded from: classes.dex */
public class C2483n implements C2678d.AbstractC2680b, C3053b.AbstractC3055b {

    /* renamed from: a */
    private C2657a f8560a;

    /* renamed from: b */
    private C2486p f8561b;

    /* renamed from: c */
    private C2475f f8562c;

    /* renamed from: d */
    private C2481l f8563d;

    public C2483n(C2657a c2657a) {
        this.f8560a = c2657a;
        c2657a.mo11219a(this);
        C3053b.m9841a().m9840a(this);
        this.f8561b = new C2486p(c2657a);
        this.f8562c = new C2475f(c2657a);
        this.f8563d = new C2481l(c2657a);
    }

    /* renamed from: a */
    public void m11997a() {
        this.f8560a.mo11214b(this);
    }

    @Override // com.fimi.soul.module.p207b.C3053b.AbstractC3055b
    /* renamed from: a */
    public void mo9837a(int i) {
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case RECEIVERWAYPOINTS:
                this.f8561b.m11984a();
                return;
            case UPWAYPOINT:
                c2657a.mo11220a(C2678d.EnumC2679a.SHOWOUTTIMEPROBAR);
                this.f8561b.mo11981a(C2472d.m12036p().m12042j());
                return;
            case READWAYPOINT:
                this.f8561b.m11980b(1);
                return;
            case RECEIVERPOINTS:
                C3074a.m9756a().m9754a("130");
                this.f8561b.m11982a(c2657a.mo11210o());
                return;
            case ASSIGNWAYPOINT:
                this.f8562c.mo11981a(C2472d.m12036p().m12042j());
                return;
            case READFLYTO:
                this.f8562c.m12023a();
                return;
            case INTERESTWAYPOINT:
                this.f8563d.mo11981a(C2472d.m12036p().m12042j());
                return;
            case READPOI:
                this.f8563d.m11998a();
                return;
            default:
                return;
        }
    }
}
