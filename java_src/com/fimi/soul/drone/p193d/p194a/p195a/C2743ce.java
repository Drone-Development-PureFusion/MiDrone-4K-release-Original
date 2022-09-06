package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.ce */
/* loaded from: classes.dex */
public class C2743ce extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10054a = 203;

    /* renamed from: c */
    public static final int f10055c = 1;
    private static final long serialVersionUID = 203;

    /* renamed from: d */
    public byte f10056d;

    public C2743ce() {
        this.f10260b = 203;
    }

    public C2743ce(C2770c c2770c) {
        this.f10260b = 203;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10056d = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 1;
        c2770c.f10263c = 203;
        c2770c.f10264d.m11055b(this.f10056d);
        return c2770c;
    }

    public String toString() {
        return "updatedronefinishbackCRC [report=" + ((int) this.f10056d) + "]";
    }
}
