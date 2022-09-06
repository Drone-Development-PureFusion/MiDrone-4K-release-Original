package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.ah */
/* loaded from: classes.dex */
public class C2692ah extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9673a = 7;

    /* renamed from: c */
    public static final int f9674c = 11;
    private static final long serialVersionUID = 7;

    /* renamed from: d */
    public byte f9675d;

    /* renamed from: e */
    public short f9676e;

    /* renamed from: f */
    public float f9677f;

    /* renamed from: g */
    public float f9678g;

    /* renamed from: h */
    public byte f9679h;

    /* renamed from: i */
    public short f9680i;

    /* renamed from: j */
    public byte f9681j;

    /* renamed from: k */
    public byte f9682k;

    /* renamed from: l */
    public byte f9683l;

    /* renamed from: m */
    public byte f9684m;

    /* renamed from: n */
    public short f9685n;

    /* renamed from: o */
    public short f9686o;

    /* renamed from: p */
    public short f9687p;

    public C2692ah() {
        this.f10260b = 7;
    }

    public C2692ah(C2770c c2770c) {
        this.f10260b = 7;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9675d = c2771d.m11050d();
        this.f9676e = c2771d.m11049e();
        this.f9677f = c2771d.m11045i();
        this.f9678g = c2771d.m11045i();
        this.f9679h = c2771d.m11050d();
        this.f9680i = c2771d.m11049e();
        this.f9681j = c2771d.m11050d();
        this.f9682k = c2771d.m11050d();
        this.f9683l = c2771d.m11050d();
        this.f9684m = c2771d.m11050d();
        this.f9685n = c2771d.m11049e();
        this.f9686o = c2771d.m11049e();
        this.f9687p = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 11;
        c2770c.f10263c = 7;
        c2770c.f10264d.m11057a(this.f9676e);
        c2770c.f10264d.m11060a(this.f9677f);
        c2770c.f10264d.m11060a(this.f9678g);
        c2770c.f10264d.m11055b(this.f9679h);
        return c2770c;
    }

    public String toString() {
        return "NoFlyArea{Opration_code=" + ((int) this.f9675d) + ", number=" + ((int) this.f9676e) + ", Forbiden_Longitude=" + this.f9677f + ", Forbiden_Latitude=" + this.f9678g + ", type=" + ((int) this.f9679h) + ", radius=" + ((int) this.f9680i) + ", SafetyZoneState=" + ((int) this.f9681j) + ", NFZ_Function_State=" + ((int) this.f9682k) + ", Vehicle_State=" + ((int) this.f9683l) + ", NFZ_Type=" + ((int) this.f9684m) + ", HeightLimit=" + ((int) this.f9685n) + ", WFZRadius=" + ((int) this.f9686o) + ", HeightLimitRadius=" + ((int) this.f9687p) + C0359h.f726w;
    }
}
