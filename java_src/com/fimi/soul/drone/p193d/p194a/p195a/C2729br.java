package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.br */
/* loaded from: classes.dex */
public class C2729br extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9964a = 98;

    /* renamed from: c */
    public static final int f9965c = 3;
    private static final long serialVersionUID = 98;

    /* renamed from: d */
    public byte f9966d;

    /* renamed from: e */
    public byte f9967e;

    /* renamed from: f */
    public byte f9968f;

    /* renamed from: g */
    public C2770c f9969g;

    public C2729br() {
        this.f10260b = 98;
    }

    public C2729br(C2770c c2770c) {
        this.f10260b = 98;
        this.f9969g = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9966d = c2771d.m11050d();
        this.f9967e = c2771d.m11050d();
        this.f9968f = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = 98;
        c2770c.f10264d.m11055b(this.f9966d);
        c2770c.f10264d.m11055b(this.f9967e);
        c2770c.f10264d.m11055b(this.f9968f);
        return c2770c;
    }

    public String toString() {
        return "msg_sendinfocontrol [model=" + ((int) this.f9966d) + ", status=" + ((int) this.f9967e) + ", msgid=" + this.f10260b + ", pack()=" + mo11073b() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
