package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.j */
/* loaded from: classes.dex */
public class C2752j extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10112a = 37;

    /* renamed from: c */
    public static final int f10113c = 25;
    private static final long serialVersionUID = 37;

    /* renamed from: d */
    public byte f10114d;

    /* renamed from: e */
    public byte f10115e;

    /* renamed from: f */
    public short f10116f;

    /* renamed from: g */
    public short f10117g;

    /* renamed from: h */
    public short f10118h;

    /* renamed from: i */
    public C2770c f10119i;

    public C2752j() {
        this.f10260b = 37;
    }

    public C2752j(C2770c c2770c) {
        this.f10260b = 37;
        this.f10119i = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11051c(3);
        this.f10115e = c2771d.m11050d();
        this.f10116f = c2771d.m11049e();
        this.f10117g = c2771d.m11049e();
        this.f10118h = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 25;
        c2770c.f10263c = 37;
        return c2770c;
    }

    public String toString() {
        return "CompassInfoDwonLink{compassOneX=" + ((int) this.f10116f) + ", compassOneY=" + ((int) this.f10117g) + ", compassOneZ=" + ((int) this.f10118h) + ", miLinkPacket=" + this.f10119i + C0359h.f726w;
    }
}
