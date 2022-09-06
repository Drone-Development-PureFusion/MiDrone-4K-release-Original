package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bn */
/* loaded from: classes.dex */
public class C2725bn extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9933a = 131;

    /* renamed from: c */
    public static final int f9934c = 20;
    private static final long serialVersionUID = 131;

    /* renamed from: d */
    public short f9935d;

    /* renamed from: e */
    public float f9936e;

    /* renamed from: f */
    public float f9937f;

    /* renamed from: g */
    public short f9938g;

    /* renamed from: h */
    public short f9939h;

    /* renamed from: i */
    public byte f9940i;

    /* renamed from: j */
    public byte f9941j;

    /* renamed from: k */
    public byte f9942k;

    /* renamed from: l */
    public short f9943l;

    public C2725bn() {
        this.f10260b = 131;
    }

    public C2725bn(C2770c c2770c) {
        this.f10260b = 131;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9935d = c2771d.m11049e();
        this.f9936e = c2771d.m11045i();
        this.f9937f = c2771d.m11045i();
        this.f9938g = c2771d.m11049e();
        this.f9939h = c2771d.m11049e();
        this.f9940i = c2771d.m11050d();
        this.f9941j = c2771d.m11050d();
        this.f9942k = c2771d.m11050d();
        this.f9943l = c2771d.m11049e();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 20;
        c2770c.f10263c = 131;
        c2770c.f10264d.m11057a(this.f9935d);
        c2770c.f10264d.m11060a(this.f9936e);
        c2770c.f10264d.m11060a(this.f9937f);
        c2770c.f10264d.m11057a(this.f9938g);
        c2770c.f10264d.m11057a(this.f9939h);
        c2770c.f10264d.m11055b(this.f9940i);
        c2770c.f10264d.m11055b(this.f9942k);
        c2770c.f10264d.m11057a(this.f9943l);
        return c2770c;
    }

    public String toString() {
        return "msg_SettingWaypointUplink [number=" + ((int) this.f9935d) + ", Longitude=" + this.f9936e + ", Latitude=" + this.f9937f + ", Altitude=" + ((int) this.f9938g) + ", yaw_angle=" + ((int) this.f9939h) + ", hover_time=" + ((int) this.f9940i) + ", report=" + ((int) this.f9942k) + ", Number_to_be_transmited=" + ((int) this.f9943l) + "]";
    }
}
