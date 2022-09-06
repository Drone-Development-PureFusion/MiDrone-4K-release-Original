package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.ae */
/* loaded from: classes.dex */
public class C2689ae extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9648a = 138;

    /* renamed from: c */
    public static final int f9649c = 8;
    private static final long serialVersionUID = 138;

    /* renamed from: d */
    public byte f9650d;

    /* renamed from: e */
    public byte f9651e;

    /* renamed from: f */
    public byte f9652f;

    /* renamed from: g */
    public byte f9653g;

    /* renamed from: h */
    public C2770c f9654h;

    public C2689ae() {
        this.f10260b = 138;
    }

    public C2689ae(C2770c c2770c) {
        this.f10260b = 138;
        this.f9654h = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11050d();
        this.f9650d = c2771d.m11050d();
        this.f9651e = c2771d.m11050d();
        this.f9652f = c2771d.m11050d();
        this.f9653g = c2771d.m11050d();
        c2771d.m11050d();
        c2771d.m11050d();
        c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        return null;
    }

    public String toString() {
        return "MsgEmergency{targetId=" + ((int) this.f9650d) + ", sourceId=" + ((int) this.f9651e) + ", cmdId=" + ((int) this.f9652f) + ", cmdCode=" + ((int) this.f9653g) + C0359h.f726w;
    }
}
