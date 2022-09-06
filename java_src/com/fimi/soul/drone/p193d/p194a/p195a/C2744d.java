package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.d */
/* loaded from: classes.dex */
public class C2744d extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10057a = 102;

    /* renamed from: c */
    public static final int f10058c = 4;
    private static final long serialVersionUID = 102;

    /* renamed from: d */
    public byte f10059d;

    /* renamed from: e */
    public byte f10060e;

    /* renamed from: f */
    public byte f10061f;

    /* renamed from: g */
    public byte f10062g;

    public C2744d() {
        this.f10260b = 102;
    }

    public C2744d(C2770c c2770c) {
        this.f10260b = 102;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10059d = c2771d.m11050d();
        this.f10060e = c2771d.m11050d();
        this.f10061f = c2771d.m11050d();
        this.f10062g = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 4;
        c2770c.f10263c = 102;
        c2770c.f10264d.m11055b(this.f10059d);
        c2770c.f10264d.m11055b(this.f10060e);
        c2770c.f10264d.m11055b(this.f10061f);
        c2770c.f10264d.m11055b(this.f10062g);
        return c2770c;
    }
}
