package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.e */
/* loaded from: classes.dex */
public class C2745e extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10063a = 5;

    /* renamed from: c */
    public static final int f10064c = 16;
    private static final long serialVersionUID = 5;

    /* renamed from: d */
    public byte f10065d;

    /* renamed from: e */
    public byte f10066e;

    /* renamed from: f */
    public byte f10067f;

    /* renamed from: g */
    public byte f10068g;

    /* renamed from: h */
    public byte f10069h;

    /* renamed from: i */
    public byte f10070i;

    /* renamed from: j */
    public short f10071j;

    /* renamed from: k */
    public short f10072k;

    /* renamed from: l */
    public byte f10073l;

    /* renamed from: m */
    public byte f10074m;

    /* renamed from: n */
    public byte f10075n;

    /* renamed from: o */
    public byte f10076o;

    /* renamed from: p */
    public byte f10077p;

    /* renamed from: q */
    public byte f10078q;

    /* renamed from: r */
    public C2770c f10079r;

    public C2745e() {
        this.f10260b = 5;
    }

    public C2745e(C2770c c2770c) {
        this.f10260b = 5;
        this.f10079r = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10065d = c2771d.m11050d();
        this.f10066e = c2771d.m11050d();
        this.f10067f = c2771d.m11050d();
        this.f10068g = c2771d.m11050d();
        this.f10069h = c2771d.m11050d();
        this.f10070i = c2771d.m11050d();
        this.f10071j = c2771d.m11049e();
        this.f10072k = c2771d.m11049e();
        this.f10073l = c2771d.m11050d();
        this.f10074m = c2771d.m11050d();
        this.f10075n = c2771d.m11050d();
        this.f10076o = c2771d.m11050d();
        this.f10077p = c2771d.m11050d();
        this.f10078q = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 16;
        c2770c.f10263c = 5;
        return null;
    }

    public String toString() {
        return "CellDwonLink{Cell_1_Voltage=" + ((int) this.f10065d) + ", Cell_2_Voltage=" + ((int) this.f10066e) + ", Cell_3_Voltage=" + ((int) this.f10067f) + ", Cell_4_Voltage=" + ((int) this.f10068g) + ", Cell_5_Voltage=" + ((int) this.f10069h) + ", Cell_6_Voltage=" + ((int) this.f10070i) + ", Current_Capacity=" + ((int) this.f10071j) + ", Current=" + ((int) this.f10072k) + ", battery_temperature=" + ((int) this.f10073l) + ", battery_temperature1=" + ((int) this.f10074m) + ", batteryLevel=" + ((int) this.f10075n) + ", battery_param_err=" + ((int) this.f10076o) + ", battery_over_discharge=" + ((int) this.f10077p) + ", RCNoUpdateCnt=" + ((int) this.f10078q) + ", miLinkPacket=" + this.f10079r + C0359h.f726w;
    }
}
