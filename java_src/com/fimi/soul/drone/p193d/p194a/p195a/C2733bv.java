package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bv */
/* loaded from: classes.dex */
public class C2733bv extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10004a = 200;

    /* renamed from: c */
    public static final int f10005c = 3;
    private static final long serialVersionUID = 200;

    /* renamed from: d */
    public byte f10006d;

    /* renamed from: e */
    public byte f10007e;

    /* renamed from: f */
    public byte f10008f;

    public C2733bv() {
        this.f10260b = 200;
    }

    public C2733bv(C2770c c2770c) {
        this.f10260b = 200;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10006d = c2771d.m11050d();
        this.f10007e = c2771d.m11050d();
        this.f10008f = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = 200;
        c2770c.f10264d.m11055b(this.f10006d);
        c2770c.f10264d.m11055b(this.f10007e);
        c2770c.f10264d.m11055b(this.f10008f);
        return c2770c;
    }

    public String toString() {
        return "updateOrderbackreport [Packet_sequence=" + ((int) this.f10006d) + ", target_ID=" + ((int) this.f10007e) + ", report=" + ((int) this.f10008f) + "]";
    }
}
