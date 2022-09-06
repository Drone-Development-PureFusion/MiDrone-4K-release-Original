package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.aa */
/* loaded from: classes.dex */
public class C2685aa extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9610a = 38;

    /* renamed from: c */
    public static final int f9611c = 25;
    private static final long serialVersionUID = 38;

    /* renamed from: d */
    public byte f9612d;

    /* renamed from: e */
    public byte f9613e;

    /* renamed from: f */
    public int f9614f;

    /* renamed from: g */
    public byte f9615g;

    /* renamed from: h */
    public C2770c f9616h;

    public C2685aa() {
        this.f10260b = 38;
    }

    public C2685aa(C2770c c2770c) {
        this.f10260b = 38;
        this.f9616h = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11051c(3);
        this.f9613e = c2771d.m11050d();
        this.f9614f = c2771d.m11048f();
        c2771d.m11051c(24);
        this.f9615g = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 25;
        c2770c.f10263c = 38;
        return c2770c;
    }

    public String toString() {
        return "IMUWorkStateInfoDwonLink{imuWorkState=" + (this.f9614f & 255) + ", CMD_ACK=" + ((int) this.f9615g) + ", miLinkPacket=" + this.f9616h + C0359h.f726w;
    }
}
