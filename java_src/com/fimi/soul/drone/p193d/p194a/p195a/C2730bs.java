package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bs */
/* loaded from: classes.dex */
public class C2730bs extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9970a = 99;

    /* renamed from: c */
    public static final int f9971c = 5;
    private static final long serialVersionUID = 99;

    /* renamed from: d */
    public byte f9972d;

    /* renamed from: e */
    public byte f9973e;

    /* renamed from: f */
    public byte f9974f;

    /* renamed from: g */
    public byte f9975g;

    /* renamed from: h */
    public byte f9976h;

    /* renamed from: i */
    public byte f9977i;

    public C2730bs() {
        this.f10260b = 99;
    }

    public C2730bs(C2770c c2770c) {
        this.f10260b = 99;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9972d = c2771d.m11050d();
        this.f9973e = c2771d.m11050d();
        this.f9974f = c2771d.m11050d();
        this.f9975g = c2771d.m11050d();
        this.f9976h = c2771d.m11050d();
        this.f9977i = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 5;
        c2770c.f10263c = 99;
        c2770c.f10264d.m11055b(this.f9972d);
        c2770c.f10264d.m11055b(this.f9973e);
        c2770c.f10264d.m11055b(this.f9974f);
        c2770c.f10264d.m11055b(this.f9975g);
        c2770c.f10264d.m11055b(this.f9976h);
        return c2770c;
    }

    public String toString() {
        return "msg_remotecontrol [ number1=" + ((int) this.f9972d) + ", number2=" + ((int) this.f9973e) + ", number3=" + ((int) this.f9974f) + ", number4=" + ((int) this.f9975g) + ", number5=" + ((int) this.f9976h) + "]";
    }
}
