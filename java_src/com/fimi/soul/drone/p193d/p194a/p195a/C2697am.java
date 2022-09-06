package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.am */
/* loaded from: classes.dex */
public class C2697am extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9716a = 106;

    /* renamed from: c */
    public static final int f9717c = 1;
    private static final long serialVersionUID = 106;

    /* renamed from: d */
    public byte f9718d;

    public C2697am() {
        this.f10260b = 106;
    }

    public C2697am(C2770c c2770c) {
        this.f10260b = 106;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9718d = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 1;
        c2770c.f10263c = 106;
        c2770c.f10264d.m11055b(this.f9718d);
        return c2770c;
    }
}
