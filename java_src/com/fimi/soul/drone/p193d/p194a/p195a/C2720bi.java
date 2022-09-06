package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bi */
/* loaded from: classes.dex */
public class C2720bi extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9903a = 130;

    /* renamed from: c */
    public static final int f9904c = 2;
    private static final long serialVersionUID = 130;

    /* renamed from: d */
    public short f9905d;

    public C2720bi() {
        this.f10260b = 130;
    }

    public C2720bi(C2770c c2770c) {
        this.f10260b = 130;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9905d = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 2;
        c2770c.f10263c = 130;
        c2770c.f10264d.m11057a(this.f9905d);
        return c2770c;
    }

    public String toString() {
        return "msg_NumberUplink [MILINK_MSG_ID_RCDATA=130+number=" + ((int) this.f9905d) + "]";
    }
}
