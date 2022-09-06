package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bk */
/* loaded from: classes.dex */
public class C2722bk extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9910a = 197;

    /* renamed from: c */
    public static final int f9911c = 6;
    private static final long serialVersionUID = 197;

    /* renamed from: d */
    public byte f9912d;

    /* renamed from: e */
    public byte f9913e;

    /* renamed from: f */
    public byte f9914f;

    /* renamed from: g */
    public byte f9915g;

    /* renamed from: h */
    public byte f9916h;

    public C2722bk() {
        this.f10260b = 197;
    }

    public C2722bk(C2770c c2770c) {
        this.f10260b = 197;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9912d = c2771d.m11050d();
        this.f9913e = c2771d.m11050d();
        this.f9914f = c2771d.m11050d();
        this.f9915g = c2771d.m11050d();
        this.f9916h = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 6;
        c2770c.f10263c = 197;
        c2770c.f10264d.m11055b(this.f9912d);
        c2770c.f10264d.m11055b(this.f9913e);
        c2770c.f10264d.m11055b(this.f9914f);
        c2770c.f10264d.m11055b(this.f9915g);
        c2770c.f10264d.m11055b(this.f9916h);
        return c2770c;
    }

    public String toString() {
        return "msg_ReportAnswerFlightDownlink [Battery_hardware_version=" + ((int) this.f9912d) + ", Battery_software_version=" + ((int) this.f9913e) + ", Gimbal_hardware_version=" + ((int) this.f9914f) + ", Gimbal_software_version=" + ((int) this.f9915g) + ", Other_equipment_vesion=" + ((int) this.f9916h) + "]";
    }
}
