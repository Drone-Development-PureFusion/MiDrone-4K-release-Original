package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bw */
/* loaded from: classes.dex */
public class C2734bw extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10009a = 200;

    /* renamed from: c */
    public static final int f10010c = 6;
    private static final long serialVersionUID = 200;

    /* renamed from: d */
    public byte f10011d;

    /* renamed from: e */
    public byte f10012e;

    /* renamed from: f */
    public int f10013f;

    public C2734bw() {
        this.f10260b = 200;
    }

    public C2734bw(C2770c c2770c) {
        this.f10260b = 200;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10011d = c2771d.m11050d();
        this.f10012e = c2771d.m11050d();
        this.f10013f = c2771d.m11048f();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 6;
        c2770c.f10263c = 200;
        c2770c.f10264d.m11055b(this.f10011d);
        c2770c.f10264d.m11055b(this.f10012e);
        c2770c.f10264d.m11054b(this.f10013f);
        return c2770c;
    }

    public String toString() {
        return "updateDroneOrder [Packet_sequence=" + ((int) this.f10011d) + ", target_ID=" + ((int) this.f10012e) + ", length=" + this.f10013f + "]";
    }
}
