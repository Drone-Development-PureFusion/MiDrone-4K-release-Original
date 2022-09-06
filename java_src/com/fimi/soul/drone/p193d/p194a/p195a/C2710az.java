package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.az */
/* loaded from: classes.dex */
public class C2710az extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9831a = 147;

    /* renamed from: c */
    public static final int f9832c = 4;
    private static final long serialVersionUID = 147;

    /* renamed from: d */
    public short f9833d;

    /* renamed from: e */
    public byte f9834e;

    /* renamed from: f */
    public byte f9835f;

    public C2710az() {
        this.f10260b = 147;
    }

    public C2710az(C2770c c2770c) {
        this.f10260b = 147;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9833d = c2771d.m11049e();
        this.f9834e = c2771d.m11050d();
        this.f9835f = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 4;
        c2770c.f10263c = 147;
        c2770c.f10264d.m11057a(this.f9833d);
        c2770c.f10264d.m11055b(this.f9834e);
        c2770c.f10264d.m11055b(this.f9835f);
        return c2770c;
    }

    public String toString() {
        return "msg_Gohome [Packet_sequence=" + ((int) this.f9833d) + "]";
    }
}
