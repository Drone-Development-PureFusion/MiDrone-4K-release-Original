package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import com.fimi.soul.drone.p203i.C2875af;
/* renamed from: com.fimi.soul.drone.d.a.a.av */
/* loaded from: classes.dex */
public class C2706av extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9800a = 16;

    /* renamed from: c */
    public static final int f9801c = 112;

    /* renamed from: d */
    public static final int f9802d = 113;

    /* renamed from: g */
    private static final int f9803g = 3;

    /* renamed from: e */
    public C2770c f9804e;

    /* renamed from: f */
    private C2875af f9805f;

    public C2706av(int i) {
        this.f10260b = i;
    }

    public C2706av(C2770c c2770c, int i) {
        this.f10260b = i;
        this.f9804e = c2770c;
        mo11074a(c2770c.f10264d);
    }

    /* renamed from: a */
    public C2875af m11182a() {
        return this.f9805f;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        this.f9805f = new C2875af(null);
        c2771d.m11052c();
        c2771d.m11050d();
        this.f9805f.m10649a(c2771d.m11050d());
        this.f9805f.m10648a(c2771d.m11050d());
        this.f9805f.m10646b(c2771d.m11050d());
    }

    /* renamed from: a */
    public void m11181a(C2875af c2875af) {
        this.f9805f = c2875af;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 3;
        c2770c.f10263c = this.f10260b;
        c2770c.f10264d.m11055b(this.f9805f.m10650a());
        c2770c.f10264d.m11055b((byte) this.f9805f.m10647b());
        c2770c.f10264d.m11055b(this.f9805f.m10645c());
        return c2770c;
    }
}
