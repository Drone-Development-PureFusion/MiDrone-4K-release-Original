package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.ar */
/* loaded from: classes.dex */
public class C2702ar extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9773a = 198;

    /* renamed from: c */
    public static final int f9774c = 10;
    private static final long serialVersionUID = 198;

    /* renamed from: d */
    public short f9775d;

    /* renamed from: e */
    public short f9776e;

    /* renamed from: f */
    public short f9777f;

    /* renamed from: g */
    public short f9778g;

    /* renamed from: h */
    public short f9779h;

    /* renamed from: i */
    public C2770c f9780i;

    public C2702ar() {
        this.f10260b = 198;
    }

    public C2702ar(C2770c c2770c) {
        this.f10260b = 198;
        this.f9780i = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9775d = c2771d.m11049e();
        this.f9776e = c2771d.m11049e();
        this.f9778g = c2771d.m11049e();
        this.f9779h = c2771d.m11049e();
        this.f9777f = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 10;
        c2770c.f10263c = 198;
        c2770c.f10264d.m11057a(this.f9775d);
        c2770c.f10264d.m11057a(this.f9776e);
        c2770c.f10264d.m11057a(this.f9778g);
        c2770c.f10264d.m11057a(this.f9779h);
        c2770c.f10264d.m11057a(this.f9777f);
        return c2770c;
    }

    public String toString() {
        return "msg_BatteryAnswerUplink [Battery_IDA=" + ((int) this.f9775d) + ", Battery_IDB=" + ((int) this.f9776e) + ", Cycle_count=" + ((int) this.f9777f) + ", Design_capacity=" + ((int) this.f9778g) + ", Full_charge_capacity=" + ((int) this.f9779h) + "]";
    }
}
