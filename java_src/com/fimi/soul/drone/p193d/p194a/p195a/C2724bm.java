package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bm */
/* loaded from: classes.dex */
public class C2724bm extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9929a = 198;

    /* renamed from: c */
    public static final int f9930c = 2;
    private static final long serialVersionUID = 198;

    /* renamed from: d */
    public byte f9931d;

    /* renamed from: e */
    public byte f9932e;

    public C2724bm() {
        this.f10260b = 198;
    }

    public C2724bm(C2770c c2770c) {
        this.f10260b = 198;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9931d = c2771d.m11050d();
        this.f9932e = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 2;
        c2770c.f10263c = 198;
        c2770c.f10264d.m11055b(this.f9931d);
        c2770c.f10264d.m11055b(this.f9932e);
        return c2770c;
    }

    public String toString() {
        return "msg_RequestbatteryDownlink [MILINK_MSG_ID_RCDATA=198+APP_version=" + ((int) this.f9931d) + ", reserve=" + ((int) this.f9932e) + "]";
    }
}
