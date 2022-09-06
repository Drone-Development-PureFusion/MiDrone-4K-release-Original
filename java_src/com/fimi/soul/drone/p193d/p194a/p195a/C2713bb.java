package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bb */
/* loaded from: classes.dex */
public class C2713bb extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9845a = 4;

    /* renamed from: c */
    public static final int f9846c = 16;
    private static final long serialVersionUID = 4;

    /* renamed from: d */
    public float f9847d;

    /* renamed from: e */
    public float f9848e;

    /* renamed from: f */
    public float f9849f;

    /* renamed from: g */
    public byte f9850g;

    /* renamed from: h */
    public float f9851h;

    /* renamed from: i */
    public C2770c f9852i;

    /* renamed from: j */
    public byte f9853j;

    public C2713bb() {
        this.f10260b = 4;
    }

    public C2713bb(C2770c c2770c) {
        this.f10260b = 4;
        this.f9852i = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9847d = c2771d.m11045i();
        this.f9848e = c2771d.m11045i();
        this.f9849f = c2771d.m11044j();
        this.f9850g = c2771d.m11050d();
        this.f9851h = c2771d.m11045i();
        this.f9853j = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        return null;
    }

    public String toString() {
        return "msg_MessionState [HomeLongitude=" + this.f9847d + ", HomeLatitude=" + this.f9848e + ", HomeAltitude=" + this.f9849f + ", CurrentWaypoint=" + ((int) this.f9850g) + "]";
    }
}
