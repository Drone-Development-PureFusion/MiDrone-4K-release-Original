package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.aq */
/* loaded from: classes.dex */
public class C2701aq extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9762a = 130;

    /* renamed from: c */
    public static final int f9763c = 19;
    private static final long serialVersionUID = 130;

    /* renamed from: d */
    public short f9764d;

    /* renamed from: e */
    public float f9765e;

    /* renamed from: f */
    public float f9766f;

    /* renamed from: g */
    public short f9767g;

    /* renamed from: h */
    public short f9768h;

    /* renamed from: i */
    public byte f9769i;

    /* renamed from: j */
    public byte f9770j;

    /* renamed from: k */
    public short f9771k;

    /* renamed from: l */
    private volatile C2770c f9772l;

    public C2701aq() {
        this.f10260b = 130;
    }

    public C2701aq(C2770c c2770c) {
        this.f9772l = c2770c;
        this.f10260b = 130;
        mo11074a(c2770c.f10264d);
    }

    /* renamed from: a */
    public C2770c m11183a() {
        return this.f9772l;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9764d = c2771d.m11049e();
        this.f9765e = c2771d.m11045i();
        this.f9766f = c2771d.m11045i();
        this.f9767g = c2771d.m11049e();
        this.f9768h = c2771d.m11049e();
        this.f9769i = c2771d.m11050d();
        this.f9770j = c2771d.m11050d();
        this.f9771k = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 19;
        c2770c.f10263c = 130;
        c2770c.f10264d.m11057a(this.f9764d);
        c2770c.f10264d.m11060a(this.f9765e);
        c2770c.f10264d.m11060a(this.f9766f);
        c2770c.f10264d.m11057a(this.f9767g);
        c2770c.f10264d.m11057a(this.f9768h);
        c2770c.f10264d.m11057a(this.f9769i);
        c2770c.f10264d.m11055b(this.f9770j);
        c2770c.f10264d.m11057a(this.f9771k);
        return c2770c;
    }

    public String toString() {
        return "msg_SettingWaypointUplink [number=" + ((int) this.f9764d) + ", Longitude=" + this.f9765e + ", Latitude=" + this.f9766f + ", Altitude=" + ((int) this.f9767g) + ", yaw_angle=" + ((int) this.f9768h) + ", hover_time=" + ((int) this.f9769i) + ", speed=" + ((int) this.f9770j) + ", Number_to_be_transmited=" + ((int) this.f9771k) + "]";
    }
}
