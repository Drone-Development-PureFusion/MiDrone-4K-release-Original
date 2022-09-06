package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.by */
/* loaded from: classes.dex */
public class C2736by extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10019a = 199;

    /* renamed from: c */
    public static final int f10020c = 2;
    private static final long serialVersionUID = 199;

    /* renamed from: d */
    public byte f10021d;

    /* renamed from: e */
    public byte f10022e;

    public C2736by() {
        this.f10260b = 199;
    }

    public C2736by(C2770c c2770c) {
        this.f10260b = 199;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10021d = c2771d.m11050d();
        this.f10022e = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 2;
        c2770c.f10263c = 199;
        c2770c.f10264d.m11055b(this.f10021d);
        c2770c.f10264d.m11055b(this.f10022e);
        return c2770c;
    }

    public String toString() {
        return "updateOrderbackreport [Packet_sequence=, target_ID=" + ((int) this.f10021d) + ", report=" + ((int) this.f10022e) + "]";
    }
}
