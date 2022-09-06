package com.fimi.soul.drone.p193d.p194a.p195a;

import android.util.Log;
import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.z */
/* loaded from: classes.dex */
public class C2768z extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10249a = 40;

    /* renamed from: c */
    public static final int f10250c = 19;
    private static final long serialVersionUID = 40;

    /* renamed from: d */
    public byte f10251d;

    /* renamed from: e */
    public byte f10252e;

    /* renamed from: f */
    public short f10253f;

    /* renamed from: g */
    public short f10254g;

    /* renamed from: h */
    public short f10255h;

    /* renamed from: i */
    public short f10256i;

    /* renamed from: j */
    public short f10257j;

    /* renamed from: k */
    public short f10258k;

    /* renamed from: l */
    public C2770c f10259l;

    public C2768z() {
        this.f10260b = 40;
    }

    public C2768z(C2770c c2770c) {
        this.f10260b = 40;
        this.f10259l = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10251d = c2771d.m11050d();
        this.f10252e = c2771d.m11050d();
        c2771d.m11051c(7);
        this.f10253f = c2771d.m11049e();
        this.f10254g = c2771d.m11049e();
        this.f10255h = c2771d.m11049e();
        this.f10256i = c2771d.m11049e();
        this.f10257j = c2771d.m11049e();
        this.f10258k = c2771d.m11049e();
        Log.e("IMU1", "gyroX:" + ((int) this.f10253f) + "gyroY:" + ((int) this.f10254g) + "gyroZ:" + ((int) this.f10255h) + "accelX:" + ((int) this.f10256i) + "accelY:" + ((int) this.f10257j) + "accelZ:" + ((int) this.f10258k) + "++++");
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 19;
        c2770c.f10263c = 40;
        return c2770c;
    }

    public String toString() {
        return "IMUInfoDwonLink{gyroX=" + ((int) this.f10253f) + ", gyroY=" + ((int) this.f10254g) + ", gyroZ=" + ((int) this.f10255h) + ", accelX=" + ((int) this.f10256i) + ", accelY=" + ((int) this.f10257j) + ", accelZ=" + ((int) this.f10258k) + ", miLinkPacket=" + this.f10259l + C0359h.f726w;
    }
}
