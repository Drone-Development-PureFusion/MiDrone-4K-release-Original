package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.bq */
/* loaded from: classes.dex */
public class C2728bq extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9957a = 132;

    /* renamed from: c */
    public static final int f9958c = 12;
    private static final long serialVersionUID = 132;

    /* renamed from: d */
    public short f9959d;

    /* renamed from: e */
    public float f9960e;

    /* renamed from: f */
    public float f9961f;

    /* renamed from: g */
    public byte f9962g;

    /* renamed from: h */
    public byte f9963h;

    public C2728bq() {
        this.f10260b = 132;
    }

    public C2728bq(C2770c c2770c) {
        this.f10260b = 132;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9959d = c2771d.m11049e();
        this.f9960e = c2771d.m11045i();
        this.f9961f = c2771d.m11045i();
        this.f9962g = c2771d.m11050d();
        this.f9963h = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 12;
        c2770c.f10263c = 132;
        c2770c.f10264d.m11057a(this.f9959d);
        c2770c.f10264d.m11060a(this.f9960e);
        c2770c.f10264d.m11060a(this.f9961f);
        c2770c.f10264d.m11055b(this.f9962g);
        c2770c.f10264d.m11055b(this.f9963h);
        return c2770c;
    }

    public String toString() {
        return "msg_forbiddenpointUplink{number=" + ((int) this.f9959d) + ", Longitude=" + this.f9960e + ", Latitude=" + this.f9961f + ", Altitude=" + ((int) this.f9962g) + ", Operation_code=" + ((int) this.f9963h) + C0359h.f726w;
    }
}
