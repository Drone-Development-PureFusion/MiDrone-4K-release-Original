package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bx */
/* loaded from: classes.dex */
public class C2735bx extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10014a = 199;

    /* renamed from: c */
    public static final int f10015c = 3;
    private static final long serialVersionUID = 199;

    /* renamed from: d */
    public byte f10016d;

    /* renamed from: e */
    public byte f10017e;

    /* renamed from: f */
    public byte f10018f;

    public C2735bx() {
        this.f10260b = 199;
    }

    public C2735bx(C2770c c2770c) {
        this.f10260b = 199;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = 199;
        c2770c.f10264d.m11055b(this.f10016d);
        c2770c.f10264d.m11055b(this.f10017e);
        c2770c.f10264d.m11055b(this.f10018f);
        return c2770c;
    }

    public String toString() {
        return "updateOrder [Packet_sequence=, target_ID=" + ((int) this.f10016d) + "]";
    }
}
