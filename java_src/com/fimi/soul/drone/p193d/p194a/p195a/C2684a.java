package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.a */
/* loaded from: classes.dex */
public class C2684a extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9606a = 152;

    /* renamed from: c */
    public static final int f9607c = 3;
    private static final long serialVersionUID = 152;

    /* renamed from: d */
    public short f9608d;

    /* renamed from: e */
    public byte f9609e;

    public C2684a() {
        this.f10260b = 152;
    }

    public C2684a(C2770c c2770c) {
        this.f10260b = 152;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9608d = c2771d.m11049e();
        this.f9609e = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = 152;
        c2770c.f10264d.m11057a(this.f9608d);
        c2770c.f10264d.m11055b(this.f9609e);
        return c2770c;
    }

    public String toString() {
        return "BeginFollowme [Packet_sequence=" + ((int) this.f9608d) + ", Para1=" + ((int) this.f9609e) + "]";
    }
}
