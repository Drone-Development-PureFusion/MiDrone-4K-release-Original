package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.aw */
/* loaded from: classes.dex */
public class C2707aw extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9806a = 144;

    /* renamed from: c */
    public static final int f9807c = 3;
    private static final long serialVersionUID = 144;

    /* renamed from: d */
    public short f9808d;

    /* renamed from: e */
    public byte f9809e;

    public C2707aw() {
        this.f10260b = 144;
    }

    public C2707aw(C2770c c2770c) {
        this.f10260b = 144;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9808d = c2771d.m11049e();
        this.f9809e = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = 144;
        c2770c.f10264d.m11057a(this.f9808d);
        c2770c.f10264d.m11055b(this.f9809e);
        return c2770c;
    }

    public String toString() {
        return "msg_Gohome [Packet_sequence=" + ((int) this.f9808d) + "]";
    }
}
