package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.i */
/* loaded from: classes.dex */
public class C2751i extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10101a = 39;

    /* renamed from: c */
    public static final int f10102c = 25;
    private static final long serialVersionUID = 39;

    /* renamed from: d */
    public byte f10103d;

    /* renamed from: e */
    public byte f10104e;

    /* renamed from: f */
    public short f10105f;

    /* renamed from: g */
    public short f10106g;

    /* renamed from: h */
    public short f10107h;

    /* renamed from: i */
    public short f10108i;

    /* renamed from: j */
    public short f10109j;

    /* renamed from: k */
    public short f10110k;

    /* renamed from: l */
    public C2770c f10111l;

    public C2751i() {
        this.f10260b = 39;
    }

    public C2751i(C2770c c2770c) {
        this.f10260b = 39;
        this.f10111l = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11051c(3);
        this.f10104e = c2771d.m11050d();
        this.f10105f = c2771d.m11049e();
        this.f10106g = c2771d.m11049e();
        this.f10107h = c2771d.m11049e();
        this.f10108i = c2771d.m11049e();
        this.f10109j = c2771d.m11049e();
        this.f10110k = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 25;
        c2770c.f10263c = 39;
        return c2770c;
    }

    public String toString() {
        return "CompassInfoDwonLink{compassOneX=" + ((int) this.f10105f) + ", compassOneY=" + ((int) this.f10106g) + ", compassOneZ=" + ((int) this.f10107h) + ", compassTwoX=" + ((int) this.f10108i) + ", compassTwoY=" + ((int) this.f10109j) + ", compassTwoZ=" + ((int) this.f10110k) + ", miLinkPacket=" + this.f10111l + C0359h.f726w;
    }
}
