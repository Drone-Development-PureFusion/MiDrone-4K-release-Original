package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.x */
/* loaded from: classes.dex */
public class C2766x extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10225a = 41;

    /* renamed from: c */
    public static final int f10226c = 25;
    private static final long serialVersionUID = 41;

    /* renamed from: d */
    public byte f10227d;

    /* renamed from: e */
    public byte f10228e;

    /* renamed from: f */
    public short f10229f;

    /* renamed from: g */
    public short f10230g;

    /* renamed from: h */
    public short f10231h;

    /* renamed from: i */
    public short f10232i;

    /* renamed from: j */
    public short f10233j;

    /* renamed from: k */
    public short f10234k;

    /* renamed from: l */
    public byte f10235l;

    /* renamed from: m */
    public C2770c f10236m;

    public C2766x() {
        this.f10260b = 41;
    }

    public C2766x(C2770c c2770c) {
        this.f10260b = 41;
        this.f10236m = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11051c(3);
        this.f10228e = c2771d.m11050d();
        this.f10229f = c2771d.m11049e();
        this.f10230g = c2771d.m11049e();
        this.f10231h = c2771d.m11049e();
        this.f10232i = c2771d.m11049e();
        this.f10233j = c2771d.m11049e();
        this.f10234k = c2771d.m11049e();
        c2771d.m11051c(24);
        this.f10235l = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 25;
        c2770c.f10263c = 41;
        return c2770c;
    }

    public String toString() {
        return "IMUInfoDwonLink{gyroX=" + ((int) this.f10229f) + ", gyroY=" + ((int) this.f10230g) + ", gyroZ=" + ((int) this.f10231h) + ", accelX=" + ((int) this.f10232i) + ", accelY=" + ((int) this.f10233j) + ", accelZ=" + ((int) this.f10234k) + ", CMD_ACK=" + ((int) this.f10235l) + ", miLinkPacket=" + this.f10236m + C0359h.f726w;
    }
}
