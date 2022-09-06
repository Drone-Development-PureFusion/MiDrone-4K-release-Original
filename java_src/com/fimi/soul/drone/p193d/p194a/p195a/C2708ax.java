package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.ax */
/* loaded from: classes.dex */
public class C2708ax extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9810a = 192;

    /* renamed from: c */
    public static final int f9811c = 2;
    private static final long serialVersionUID = 192;

    /* renamed from: d */
    public byte f9812d;

    /* renamed from: e */
    public byte f9813e;

    public C2708ax() {
        this.f10260b = 192;
    }

    public C2708ax(C2770c c2770c) {
        this.f10260b = 192;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9812d = c2771d.m11050d();
        this.f9813e = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 2;
        c2770c.f10263c = 192;
        c2770c.f10264d.m11055b(this.f9812d);
        c2770c.f10264d.m11055b(this.f9813e);
        return c2770c;
    }

    public String toString() {
        return "msg_GoupOrderUplink [MILINK_MSG_ID_RCDATA=192+Packet_sequence=" + ((int) this.f9812d) + ", target_ID=" + ((int) this.f9813e) + "]";
    }
}
