package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.ak */
/* loaded from: classes.dex */
public class C2695ak extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9707a = 204;

    /* renamed from: c */
    public static final int f9708c = 3;
    private static final long serialVersionUID = 204;

    /* renamed from: d */
    public byte f9709d;

    /* renamed from: e */
    public byte f9710e;

    /* renamed from: f */
    public byte f9711f;

    public C2695ak() {
        this.f10260b = 204;
    }

    public C2695ak(C2770c c2770c) {
        this.f10260b = 204;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9709d = c2771d.m11050d();
        this.f9710e = c2771d.m11050d();
        this.f9711f = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = 204;
        c2770c.f10264d.m11055b(this.f9709d);
        c2770c.f10264d.m11055b(this.f9710e);
        c2770c.f10264d.m11055b(this.f9711f);
        return c2770c;
    }
}
