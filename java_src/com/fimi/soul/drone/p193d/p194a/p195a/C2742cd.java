package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.cd */
/* loaded from: classes.dex */
public class C2742cd extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10050a = 202;

    /* renamed from: c */
    public static final int f10051c = 2;
    private static final long serialVersionUID = 202;

    /* renamed from: d */
    public byte f10052d;

    /* renamed from: e */
    public byte f10053e;

    public C2742cd() {
        this.f10260b = 202;
    }

    public C2742cd(C2770c c2770c) {
        this.f10260b = 202;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10052d = c2771d.m11050d();
        this.f10053e = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 2;
        c2770c.f10263c = 202;
        c2770c.f10264d.m11055b(this.f10052d);
        c2770c.f10264d.m11055b(this.f10053e);
        return c2770c;
    }

    public String toString() {
        return "updatedronefinishback [report=" + ((int) this.f10053e) + "]";
    }
}
