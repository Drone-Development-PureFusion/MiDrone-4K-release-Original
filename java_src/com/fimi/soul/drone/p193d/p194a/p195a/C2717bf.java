package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bf */
/* loaded from: classes.dex */
public class C2717bf extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9875a = 128;

    /* renamed from: c */
    public static final int f9876c = 13;
    private static final long serialVersionUID = 128;

    /* renamed from: d */
    public byte f9877d;

    /* renamed from: e */
    public double f9878e;

    /* renamed from: f */
    public double f9879f;

    /* renamed from: g */
    public short f9880g;

    /* renamed from: h */
    public byte f9881h;

    /* renamed from: i */
    public byte f9882i;

    public C2717bf() {
        this.f10260b = 128;
    }

    public C2717bf(C2770c c2770c) {
        this.f10260b = 128;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9877d = c2771d.m11050d();
        this.f9878e = c2771d.m11045i();
        this.f9879f = c2771d.m11045i();
        this.f9880g = c2771d.m11049e();
        this.f9881h = c2771d.m11050d();
        this.f9882i = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 13;
        c2770c.f10263c = 128;
        c2770c.f10264d.m11055b(this.f9877d);
        c2770c.f10264d.m11061a(this.f9878e);
        c2770c.f10264d.m11061a(this.f9879f);
        c2770c.f10264d.m11057a(this.f9880g);
        c2770c.f10264d.m11055b(this.f9881h);
        c2770c.f10264d.m11055b(this.f9882i);
        return c2770c;
    }

    public String toString() {
        return "msg_PosionUplink_home [MILINK_MSG_ID_RCDATA=128+PacketSequence=" + ((int) this.f9877d) + ", HomeLongitude=" + this.f9878e + ", HomeLatitude=" + this.f9879f + ", HomeAltitude=" + ((int) this.f9880g) + ", reserve=" + ((int) this.f9881h) + ", reserve2=" + ((int) this.f9882i) + "]";
    }
}
