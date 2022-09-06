package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.ca */
/* loaded from: classes.dex */
public class C2739ca extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10036a = 201;

    /* renamed from: c */
    public static final int f10037c = 4;
    private static final long serialVersionUID = 201;

    /* renamed from: d */
    public byte f10038d;

    /* renamed from: e */
    public short f10039e;

    /* renamed from: f */
    public byte f10040f;

    public C2739ca() {
        this.f10260b = 201;
    }

    public C2739ca(C2770c c2770c) {
        this.f10260b = 201;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10038d = c2771d.m11050d();
        this.f10039e = c2771d.m11049e();
        this.f10040f = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 4;
        c2770c.f10263c = 201;
        c2770c.f10264d.m11055b(this.f10038d);
        c2770c.f10264d.m11057a(this.f10039e);
        c2770c.f10264d.m11055b(this.f10040f);
        return c2770c;
    }

    public String toString() {
        return "updatedronebackreport [Packet_sequence=" + ((int) this.f10039e) + ", report=" + ((int) this.f10040f) + "]";
    }
}
