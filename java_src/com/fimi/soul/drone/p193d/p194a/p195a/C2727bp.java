package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.bp */
/* loaded from: classes.dex */
public class C2727bp extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9948a = 6;

    /* renamed from: c */
    public static final int f9949c = 18;
    private static final long serialVersionUID = 6;

    /* renamed from: d */
    public float f9950d;

    /* renamed from: e */
    public float f9951e;

    /* renamed from: f */
    public float f9952f;

    /* renamed from: g */
    public short f9953g;

    /* renamed from: h */
    public short f9954h;

    /* renamed from: i */
    public byte f9955i;

    /* renamed from: j */
    public short f9956j;

    public C2727bp() {
        this.f10260b = 6;
    }

    public C2727bp(C2770c c2770c) {
        this.f10260b = 6;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 18;
        c2770c.f10263c = 6;
        c2770c.f10264d.m11060a(this.f9950d);
        c2770c.f10264d.m11060a(this.f9951e);
        c2770c.f10264d.m11059a((int) this.f9952f);
        c2770c.f10264d.m11057a(this.f9953g);
        c2770c.f10264d.m11057a(this.f9954h);
        c2770c.f10264d.m11055b(this.f9955i);
        c2770c.f10264d.m11057a(this.f9956j);
        return c2770c;
    }

    public String toString() {
        return "msg_followme [Packet_Sequence=Packet_Sequence, GCSLongitude=" + this.f9950d + ", GCSLatitude=" + this.f9951e + ", HomeAltitude=" + this.f9952f + ", ground_speed=" + ((int) this.f9953g) + ", ground_course=" + ((int) this.f9954h) + ", SatelliteNumber=" + ((int) this.f9955i) + ", accuracy=" + ((int) this.f9956j) + "]";
    }
}
