package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.ab */
/* loaded from: classes.dex */
public class C2686ab extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9617a = 36;

    /* renamed from: c */
    public static final int f9618c = 25;
    private static final long serialVersionUID = 36;

    /* renamed from: d */
    public byte f9619d;

    /* renamed from: e */
    public byte f9620e;

    /* renamed from: f */
    public int f9621f;

    /* renamed from: g */
    public byte f9622g;

    /* renamed from: h */
    public C2770c f9623h;

    public C2686ab() {
        this.f10260b = 36;
    }

    public C2686ab(C2770c c2770c) {
        this.f10260b = 36;
        this.f9623h = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11051c(3);
        this.f9620e = c2771d.m11050d();
        this.f9621f = c2771d.m11048f();
        c2771d.m11051c(24);
        this.f9622g = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 25;
        c2770c.f10263c = 36;
        return c2770c;
    }

    public String toString() {
        return "IMUWorkStateInfoDwonLink{imuWorkState=" + (this.f9621f & 255) + ", miLinkPacket=" + this.f9623h + ", CMD_ACK=" + ((int) this.f9622g) + C0359h.f726w;
    }
}
