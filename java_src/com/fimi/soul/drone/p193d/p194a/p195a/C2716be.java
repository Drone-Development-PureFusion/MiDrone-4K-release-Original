package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.be */
/* loaded from: classes.dex */
public class C2716be extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9869a = 129;

    /* renamed from: c */
    public static final int f9870c = 11;
    private static final long serialVersionUID = 129;

    /* renamed from: d */
    public byte f9871d;

    /* renamed from: e */
    public int f9872e;

    /* renamed from: f */
    public int f9873f;

    /* renamed from: g */
    public short f9874g;

    public C2716be() {
        this.f10260b = 129;
    }

    public C2716be(C2770c c2770c) {
        this.f10260b = 129;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9871d = c2771d.m11050d();
        this.f9872e = c2771d.m11048f();
        this.f9873f = c2771d.m11048f();
        this.f9874g = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 11;
        c2770c.f10263c = 129;
        c2770c.f10264d.m11055b(this.f9871d);
        c2770c.f10264d.m11054b(this.f9872e);
        c2770c.f10264d.m11054b(this.f9873f);
        c2770c.f10264d.m11057a(this.f9874g);
        return c2770c;
    }

    public String toString() {
        return "msg_PosionUpLink [MILINK_MSG_ID_RCDATA=129+PacketSequence=" + ((int) this.f9871d) + ", HomeLongitude=" + this.f9872e + ", HomeLatitude=" + this.f9873f + ", HomeAltitude=" + ((int) this.f9874g) + "]";
    }
}
