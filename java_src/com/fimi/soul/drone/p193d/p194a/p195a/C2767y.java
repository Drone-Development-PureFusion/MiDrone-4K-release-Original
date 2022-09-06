package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.y */
/* loaded from: classes.dex */
public class C2767y extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10237a = 48;

    /* renamed from: c */
    public static final int f10238c = 25;
    private static final long serialVersionUID = 48;

    /* renamed from: d */
    public byte f10239d;

    /* renamed from: e */
    public byte f10240e;

    /* renamed from: f */
    public short f10241f;

    /* renamed from: g */
    public short f10242g;

    /* renamed from: h */
    public short f10243h;

    /* renamed from: i */
    public short f10244i;

    /* renamed from: j */
    public short f10245j;

    /* renamed from: k */
    public short f10246k;

    /* renamed from: l */
    public byte f10247l;

    /* renamed from: m */
    public C2770c f10248m;

    public C2767y() {
        this.f10260b = 48;
    }

    public C2767y(C2770c c2770c) {
        this.f10260b = 48;
        this.f10248m = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11051c(3);
        this.f10240e = c2771d.m11050d();
        this.f10241f = c2771d.m11049e();
        this.f10242g = c2771d.m11049e();
        this.f10243h = c2771d.m11049e();
        this.f10244i = c2771d.m11049e();
        this.f10245j = c2771d.m11049e();
        this.f10246k = c2771d.m11049e();
        c2771d.m11051c(24);
        this.f10247l = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 25;
        c2770c.f10263c = 48;
        return c2770c;
    }

    public String toString() {
        return "IMUInfoDwonLink{gyroX=" + ((int) this.f10241f) + ", gyroY=" + ((int) this.f10242g) + ", gyroZ=" + ((int) this.f10243h) + ", accelX=" + ((int) this.f10244i) + ", accelY=" + ((int) this.f10245j) + ", accelZ=" + ((int) this.f10246k) + ", CMD_ACK=" + ((int) this.f10247l) + ", miLinkPacket=" + this.f10248m + C0359h.f726w;
    }
}
