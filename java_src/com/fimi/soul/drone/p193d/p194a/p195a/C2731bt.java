package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bt */
/* loaded from: classes.dex */
public class C2731bt extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9978a = 100;

    /* renamed from: c */
    public static final int f9979c = 11;
    private static final long serialVersionUID = 100;

    /* renamed from: d */
    public byte f9980d;

    /* renamed from: e */
    public byte f9981e;

    /* renamed from: f */
    public byte f9982f;

    /* renamed from: g */
    public byte f9983g;

    /* renamed from: h */
    public byte f9984h;

    /* renamed from: i */
    public byte f9985i;

    /* renamed from: j */
    public byte f9986j;

    /* renamed from: k */
    public byte f9987k;

    /* renamed from: l */
    public byte f9988l;

    /* renamed from: m */
    public byte f9989m;

    /* renamed from: n */
    public byte f9990n;

    /* renamed from: o */
    public C2770c f9991o;

    public C2731bt() {
        this.f10260b = 100;
    }

    public C2731bt(C2770c c2770c) {
        this.f9991o = c2770c;
        this.f10260b = 100;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9980d = c2771d.m11050d();
        this.f9981e = c2771d.m11050d();
        this.f9982f = c2771d.m11050d();
        this.f9983g = c2771d.m11050d();
        this.f9984h = c2771d.m11050d();
        this.f9985i = c2771d.m11050d();
        this.f9986j = c2771d.m11050d();
        this.f9987k = c2771d.m11050d();
        this.f9988l = c2771d.m11050d();
        this.f9989m = c2771d.m11050d();
        this.f9990n = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 11;
        c2770c.f10263c = 100;
        c2770c.f10264d.m11055b(this.f9980d);
        c2770c.f10264d.m11055b(this.f9981e);
        c2770c.f10264d.m11055b(this.f9982f);
        c2770c.f10264d.m11055b(this.f9983g);
        c2770c.f10264d.m11055b(this.f9984h);
        c2770c.f10264d.m11055b(this.f9985i);
        c2770c.f10264d.m11055b(this.f9986j);
        c2770c.f10264d.m11055b(this.f9987k);
        c2770c.f10264d.m11055b(this.f9988l);
        c2770c.f10264d.m11055b(this.f9989m);
        c2770c.f10264d.m11055b(this.f9990n);
        return c2770c;
    }

    public String toString() {
        return "msg_simulatorINfo [ADC0=" + ((int) this.f9980d) + ", ADC1=" + ((int) this.f9981e) + ", ADC2=" + ((int) this.f9982f) + ", ADC3=" + ((int) this.f9983g) + ", ADC4=" + ((int) this.f9984h) + ", ADC5=" + ((int) this.f9985i) + ", battery=" + ((int) this.f9986j) + ", switch1=" + ((int) this.f9987k) + ", switch2=" + ((int) this.f9988l) + ", left3=" + ((int) this.f9989m) + ", right3=" + ((int) this.f9990n) + "]";
    }
}
