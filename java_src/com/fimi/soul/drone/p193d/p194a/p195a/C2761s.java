package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.s */
/* loaded from: classes.dex */
public class C2761s extends AbstractC2769b {

    /* renamed from: a */
    public C2770c f10183a;

    /* renamed from: c */
    private int f10184c;

    /* renamed from: d */
    private int f10185d;

    /* renamed from: e */
    private short f10186e;

    /* renamed from: f */
    private int f10187f;

    public C2761s(C2770c c2770c) {
        this.f10183a = c2770c;
        this.f10260b = 9;
        mo11074a(c2770c.f10264d);
    }

    /* renamed from: a */
    public int m11078a() {
        return this.f10184c;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10184c = c2771d.m11048f();
        this.f10185d = c2771d.m11048f();
        this.f10186e = c2771d.m11049e();
        this.f10187f = c2771d.m11048f();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        return new C2770c();
    }

    /* renamed from: c */
    public int m11077c() {
        return this.f10185d;
    }

    /* renamed from: d */
    public int m11076d() {
        return this.f10187f;
    }

    /* renamed from: e */
    public short m11075e() {
        return this.f10186e;
    }

    public String toString() {
        return "selfError" + this.f10184c;
    }
}
