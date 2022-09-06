package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.cb */
/* loaded from: classes.dex */
public class C2740cb extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10041a = 202;

    /* renamed from: c */
    public static final int f10042c = 4;
    private static final long serialVersionUID = 202;

    /* renamed from: d */
    public byte f10043d;

    /* renamed from: e */
    public int f10044e;

    /* renamed from: f */
    public byte f10045f;

    public C2740cb() {
        this.f10260b = 202;
    }

    public C2740cb(C2770c c2770c) {
        this.f10260b = 202;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10043d = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 4;
        c2770c.f10263c = 202;
        c2770c.f10264d.m11055b(this.f10043d);
        c2770c.f10264d.m11055b(this.f10045f);
        c2770c.f10264d.m11055b(this.f10045f);
        c2770c.f10264d.m11055b(this.f10045f);
        return c2770c;
    }
}
