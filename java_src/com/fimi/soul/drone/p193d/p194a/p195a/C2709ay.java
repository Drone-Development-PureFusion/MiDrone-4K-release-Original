package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.ay */
/* loaded from: classes.dex */
public class C2709ay extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9814a = 2;

    /* renamed from: c */
    public static final int f9815c = 19;
    private static final long serialVersionUID = 2;

    /* renamed from: d */
    public C2770c f9816d;

    /* renamed from: e */
    public byte f9817e;

    /* renamed from: f */
    public byte f9818f;

    /* renamed from: g */
    public byte f9819g;

    /* renamed from: h */
    public byte f9820h;

    /* renamed from: i */
    public byte f9821i;

    /* renamed from: j */
    public short f9822j;

    /* renamed from: k */
    public short f9823k;

    /* renamed from: l */
    public short f9824l;

    /* renamed from: m */
    public byte f9825m;

    /* renamed from: n */
    public byte f9826n;

    /* renamed from: o */
    public short f9827o;

    /* renamed from: p */
    public short f9828p;

    /* renamed from: q */
    public byte f9829q;

    /* renamed from: r */
    public byte f9830r;

    public C2709ay() {
        this.f10260b = 2;
    }

    public C2709ay(C2770c c2770c) {
        this.f10260b = 2;
        this.f9816d = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9817e = c2771d.m11050d();
        this.f9818f = c2771d.m11050d();
        this.f9819g = c2771d.m11050d();
        this.f9820h = c2771d.m11050d();
        this.f9821i = c2771d.m11050d();
        this.f9822j = c2771d.m11049e();
        this.f9823k = c2771d.m11049e();
        this.f9824l = c2771d.m11049e();
        this.f9825m = c2771d.m11050d();
        this.f9826n = c2771d.m11050d();
        this.f9827o = c2771d.m11049e();
        this.f9828p = c2771d.m11049e();
        this.f9829q = c2771d.m11050d();
        this.f9830r = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 19;
        c2770c.f10263c = 2;
        c2770c.f10264d.m11055b(this.f9817e);
        c2770c.f10264d.m11055b(this.f9818f);
        c2770c.f10264d.m11055b(this.f9819g);
        c2770c.f10264d.m11055b(this.f9820h);
        c2770c.f10264d.m11055b(this.f9821i);
        c2770c.f10264d.m11057a(this.f9822j);
        c2770c.f10264d.m11057a(this.f9823k);
        c2770c.f10264d.m11057a(this.f9824l);
        c2770c.f10264d.m11055b(this.f9825m);
        c2770c.f10264d.m11055b(this.f9826n);
        c2770c.f10264d.m11057a(this.f9827o);
        c2770c.f10264d.m11057a(this.f9828p);
        c2770c.f10264d.m11055b(this.f9829q);
        c2770c.f10264d.m11055b(this.f9830r);
        return c2770c;
    }

    public String toString() {
        return "msg_Heartbeat{Heartbeat=" + ((int) this.f9817e) + ", ThrottleStick=" + ((int) this.f9818f) + ", RollStick=" + ((int) this.f9819g) + ", PitchStick=" + ((int) this.f9820h) + ", YawStick=" + ((int) this.f9821i) + ", RollAngle=" + ((int) this.f9822j) + ", PitchAngle=" + ((int) this.f9823k) + ", HeadingAngle=" + ((int) this.f9824l) + ", DisarmCount=" + ((int) this.f9825m) + ", FlightMode=" + ((int) this.f9826n) + ", GroundSpeed=" + ((int) this.f9827o) + ", DownVelocity=" + ((int) this.f9828p) + ", rcReceiver=" + ((int) this.f9829q) + ", takeoffTag=" + ((int) this.f9830r) + C0359h.f726w;
    }
}
