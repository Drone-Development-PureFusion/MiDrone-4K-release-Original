package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.bg */
/* loaded from: classes.dex */
public class C2718bg extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9883a = 129;

    /* renamed from: c */
    public static final int f9884c = 19;
    private static final long serialVersionUID = 129;

    /* renamed from: d */
    public byte f9885d;

    /* renamed from: e */
    public byte f9886e;

    /* renamed from: f */
    public float f9887f;

    /* renamed from: g */
    public float f9888g;

    /* renamed from: h */
    public short f9889h;

    /* renamed from: i */
    public short f9890i;

    /* renamed from: j */
    public byte f9891j;

    /* renamed from: k */
    public byte f9892k;

    /* renamed from: l */
    public byte f9893l;

    /* renamed from: m */
    public byte f9894m;

    /* renamed from: n */
    public byte f9895n;

    public C2718bg() {
        this.f10260b = 129;
    }

    public C2718bg(C2770c c2770c) {
        this.f10260b = 129;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9885d = c2771d.m11050d();
        this.f9886e = c2771d.m11050d();
        this.f9887f = c2771d.m11045i();
        this.f9888g = c2771d.m11045i();
        this.f9889h = c2771d.m11049e();
        this.f9890i = c2771d.m11049e();
        this.f9891j = c2771d.m11050d();
        this.f9892k = c2771d.m11050d();
        this.f9893l = c2771d.m11050d();
        this.f9894m = c2771d.m11050d();
        this.f9895n = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 19;
        c2770c.f10263c = 129;
        return c2770c;
    }

    public String toString() {
        return "msg_PosionUplink_poi{PacketSequence=" + ((int) this.f9885d) + ", Opration_Code=" + ((int) this.f9886e) + ", POI_Longitude=" + this.f9887f + ", POI_Latitude=" + this.f9888g + ", POI_Altitude=" + ((int) this.f9889h) + ", Radius=" + ((int) this.f9890i) + ", speek=" + ((int) this.f9891j) + ", Start_Point_Pole_Angle=" + ((int) this.f9892k) + ", Paral=" + ((int) this.f9893l) + ", yaw_mode=" + ((int) this.f9894m) + ", report=" + ((int) this.f9895n) + C0359h.f726w;
    }
}
