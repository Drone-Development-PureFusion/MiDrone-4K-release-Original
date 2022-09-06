package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.al */
/* loaded from: classes.dex */
public class C2696al extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9712a = 204;

    /* renamed from: c */
    public static final int f9713c = 2;
    private static final long serialVersionUID = 204;

    /* renamed from: d */
    public byte f9714d;

    /* renamed from: e */
    public byte f9715e;

    public C2696al() {
        this.f10260b = 204;
    }

    public C2696al(C2770c c2770c) {
        this.f10260b = 204;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9714d = c2771d.m11050d();
        this.f9715e = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 2;
        c2770c.f10263c = 204;
        c2770c.f10264d.m11055b(this.f9714d);
        c2770c.f10264d.m11055b(this.f9715e);
        return c2770c;
    }
}
