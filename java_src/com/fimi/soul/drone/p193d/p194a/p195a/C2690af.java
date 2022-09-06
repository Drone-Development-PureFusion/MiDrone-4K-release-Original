package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.af */
/* loaded from: classes.dex */
public class C2690af extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9655a = 11;

    /* renamed from: c */
    public static final int f9656c = 3;
    private static final long serialVersionUID = 11;

    /* renamed from: d */
    public byte f9657d;

    /* renamed from: e */
    public byte f9658e;

    /* renamed from: f */
    public byte f9659f;

    /* renamed from: g */
    public byte f9660g;

    /* renamed from: h */
    public byte f9661h;

    /* renamed from: i */
    public byte f9662i;

    /* renamed from: j */
    public byte f9663j;

    public C2690af() {
        this.f10260b = 11;
    }

    public C2690af(C2770c c2770c) {
        this.f10260b = 11;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9657d = c2771d.m11050d();
        this.f9658e = c2771d.m11050d();
        this.f9659f = c2771d.m11050d();
        this.f9660g = c2771d.m11050d();
        this.f9661h = c2771d.m11050d();
        this.f9662i = c2771d.m11050d();
        this.f9663j = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = 11;
        return c2770c;
    }

    public String toString() {
        return "NewDroneModel{CtrlType=" + ((int) this.f9657d) + ", CtrlMode=" + ((int) this.f9658e) + ", WP_SPA=" + ((int) this.f9659f) + C0359h.f726w;
    }
}
