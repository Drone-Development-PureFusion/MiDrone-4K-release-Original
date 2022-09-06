package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.u */
/* loaded from: classes.dex */
public class C2763u extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10197a = 133;

    /* renamed from: c */
    public static final int f10198c = 16;
    private static final long serialVersionUID = 133;

    /* renamed from: d */
    public byte f10199d;

    /* renamed from: e */
    public byte f10200e;

    /* renamed from: f */
    public float f10201f;

    /* renamed from: g */
    public float f10202g;

    /* renamed from: h */
    public short f10203h;

    /* renamed from: i */
    public byte f10204i;

    /* renamed from: j */
    public byte f10205j;

    /* renamed from: k */
    public byte f10206k;

    /* renamed from: l */
    public byte f10207l;

    public C2763u() {
        this.f10260b = 133;
    }

    public C2763u(C2770c c2770c) {
        this.f10260b = 133;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10199d = c2771d.m11050d();
        this.f10200e = c2771d.m11050d();
        this.f10201f = c2771d.m11045i();
        this.f10202g = c2771d.m11045i();
        this.f10203h = c2771d.m11049e();
        this.f10204i = c2771d.m11050d();
        this.f10205j = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 16;
        c2770c.f10263c = 133;
        c2770c.f10264d.m11057a(this.f10199d);
        c2770c.f10264d.m11060a(this.f10201f);
        c2770c.f10264d.m11060a(this.f10202g);
        c2770c.f10264d.m11057a(this.f10203h);
        c2770c.f10264d.m11055b(this.f10204i);
        c2770c.f10264d.m11055b(this.f10205j);
        c2770c.f10264d.m11055b(this.f10206k);
        c2770c.f10264d.m11055b(this.f10207l);
        return c2770c;
    }
}
