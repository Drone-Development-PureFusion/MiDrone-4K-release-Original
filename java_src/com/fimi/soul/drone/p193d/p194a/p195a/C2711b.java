package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.b */
/* loaded from: classes.dex */
public class C2711b extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9836a = 152;

    /* renamed from: c */
    public static final int f9837c = 4;
    private static final long serialVersionUID = 152;

    /* renamed from: d */
    public short f9838d;

    /* renamed from: e */
    public byte f9839e;

    /* renamed from: f */
    public byte f9840f;

    public C2711b() {
        this.f10260b = 152;
    }

    public C2711b(C2770c c2770c) {
        this.f10260b = 152;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9838d = c2771d.m11049e();
        this.f9839e = c2771d.m11050d();
        this.f9840f = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 4;
        c2770c.f10263c = 152;
        c2770c.f10264d.m11057a(this.f9838d);
        c2770c.f10264d.m11055b(this.f9839e);
        c2770c.f10264d.m11055b(this.f9840f);
        return c2770c;
    }

    public String toString() {
        return "BeginFollowmeback{Packet_sequence=" + ((int) this.f9838d) + ", cmd=" + ((int) this.f9839e) + ", report=" + ((int) this.f9840f) + C0359h.f726w;
    }
}
