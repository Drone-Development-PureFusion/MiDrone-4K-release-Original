package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bh */
/* loaded from: classes.dex */
public class C2719bh extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9896a = 1;

    /* renamed from: c */
    public static final int f9897c = 10;
    private static final long serialVersionUID = 1;

    /* renamed from: d */
    public short f9898d;

    /* renamed from: e */
    public short f9899e;

    /* renamed from: f */
    public short f9900f;

    /* renamed from: g */
    public short f9901g;

    /* renamed from: h */
    public short f9902h;

    public C2719bh() {
        this.f10260b = 1;
    }

    public C2719bh(C2770c c2770c) {
        this.f10260b = 1;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9898d = c2771d.m11049e();
        this.f9899e = c2771d.m11049e();
        this.f9900f = c2771d.m11049e();
        this.f9901g = c2771d.m11049e();
        this.f9902h = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 10;
        c2770c.f10263c = 1;
        c2770c.f10264d.m11057a(this.f9898d);
        c2770c.f10264d.m11057a(this.f9899e);
        c2770c.f10264d.m11057a(this.f9900f);
        c2770c.f10264d.m11057a(this.f9901g);
        c2770c.f10264d.m11057a(this.f9902h);
        return c2770c;
    }

    public String toString() {
        return "MILINK_MSG_ID_RCDATA - rc1:" + ((int) this.f9898d) + " rc2:" + ((int) this.f9899e) + " rc3:" + ((int) this.f9900f) + " rc4:" + ((int) this.f9901g) + " rc5:" + ((int) this.f9902h) + "";
    }
}
