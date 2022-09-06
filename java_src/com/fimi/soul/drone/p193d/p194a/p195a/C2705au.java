package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.au */
/* loaded from: classes.dex */
public class C2705au extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9789a = 193;

    /* renamed from: c */
    public static final int f9790c = 22;
    private static final long serialVersionUID = 193;

    /* renamed from: d */
    public byte f9791d;

    /* renamed from: e */
    public byte f9792e;

    /* renamed from: f */
    public char f9793f;

    /* renamed from: g */
    public short f9794g;

    /* renamed from: h */
    public long f9795h;

    /* renamed from: i */
    public long f9796i;

    /* renamed from: j */
    public long f9797j;

    /* renamed from: k */
    public long f9798k;

    /* renamed from: l */
    public C2770c f9799l;

    public C2705au() {
        this.f10260b = 193;
    }

    public C2705au(C2770c c2770c) {
        this.f10260b = 193;
        this.f9799l = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9791d = c2771d.m11050d();
        this.f9792e = c2771d.m11050d();
        this.f9793f = c2771d.m11042l();
        this.f9794g = c2771d.m11049e();
        this.f9795h = c2771d.m11041m();
        this.f9796i = c2771d.m11041m();
        this.f9797j = c2771d.m11041m();
        this.f9798k = c2771d.m11041m();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 22;
        c2770c.f10263c = 193;
        c2770c.f10264d.m11055b(this.f9791d);
        c2770c.f10264d.m11055b(this.f9792e);
        c2770c.f10264d.m11062a(this.f9793f);
        c2770c.f10264d.m11057a(this.f9794g);
        c2770c.f10264d.m11058a(this.f9795h);
        c2770c.f10264d.m11058a(this.f9796i);
        c2770c.f10264d.m11058a(this.f9797j);
        c2770c.f10264d.m11058a(this.f9798k);
        return c2770c;
    }

    public String toString() {
        return "msg_FCAnswerDownlink{type=" + ((int) this.f9791d) + ", Model=" + ((int) this.f9792e) + ", FC_hardware_version=" + this.f9793f + ", Software_version=" + ((int) this.f9794g) + ", IDA=" + this.f9795h + ", IDB=" + this.f9796i + ", IDC=" + this.f9797j + ", reserve=" + this.f9798k + C0359h.f726w;
    }
}
