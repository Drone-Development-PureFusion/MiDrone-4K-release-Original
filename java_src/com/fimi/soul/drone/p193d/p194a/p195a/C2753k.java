package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.k */
/* loaded from: classes.dex */
public class C2753k extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10120a = 134;

    /* renamed from: c */
    public static final int f10121c = 7;
    private static final long serialVersionUID = 134;

    /* renamed from: d */
    public byte f10122d;

    /* renamed from: e */
    public byte f10123e;

    /* renamed from: f */
    public float f10124f;

    /* renamed from: g */
    public byte f10125g;

    public C2753k() {
        this.f10260b = 134;
    }

    public C2753k(C2770c c2770c) {
        this.f10260b = 134;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10122d = c2771d.m11050d();
        this.f10123e = c2771d.m11050d();
        this.f10124f = c2771d.m11045i();
        this.f10125g = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 7;
        c2770c.f10263c = 134;
        c2770c.f10264d.m11055b(this.f10122d);
        c2770c.f10264d.m11055b(this.f10123e);
        c2770c.f10264d.m11060a(this.f10124f);
        c2770c.f10264d.m11055b(this.f10125g);
        return c2770c;
    }

    public String toString() {
        return "DroneRTHMessage{Packet_sequence=" + ((int) this.f10122d) + ", cmdID=" + ((int) this.f10123e) + ", height=" + this.f10124f + ", report=" + ((int) this.f10125g) + C0359h.f726w;
    }
}
