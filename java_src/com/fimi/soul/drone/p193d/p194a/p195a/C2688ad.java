package com.fimi.soul.drone.p193d.p194a.p195a;

import android.util.Log;
import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.ad */
/* loaded from: classes.dex */
public class C2688ad extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9638a = 138;

    /* renamed from: c */
    public static final int f9639c = 12;
    private static final long serialVersionUID = 138;

    /* renamed from: d */
    public byte f9640d;

    /* renamed from: e */
    public byte f9641e;

    /* renamed from: f */
    public byte f9642f;

    /* renamed from: g */
    public byte f9643g;

    /* renamed from: h */
    public short f9644h;

    /* renamed from: i */
    public byte f9645i;

    /* renamed from: j */
    public byte f9646j;

    /* renamed from: k */
    public C2770c f9647k;

    public C2688ad() {
        this.f10260b = 138;
    }

    public C2688ad(C2770c c2770c) {
        this.f10260b = 138;
        this.f9647k = c2770c;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        c2771d.m11050d();
        this.f9640d = c2771d.m11050d();
        this.f9641e = c2771d.m11050d();
        this.f9642f = c2771d.m11050d();
        this.f9643g = c2771d.m11050d();
        this.f9644h = c2771d.m11049e();
        this.f9645i = c2771d.m11050d();
        c2771d.m11050d();
        c2771d.m11050d();
        c2771d.m11050d();
        this.f9646j = c2771d.m11050d();
        Log.i("istep", "unpack " + toString());
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 12;
        c2770c.f10263c = 138;
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b(this.f9640d);
        c2770c.f10264d.m11055b(this.f9641e);
        c2770c.f10264d.m11055b(this.f9642f);
        c2770c.f10264d.m11055b(this.f9643g);
        c2770c.f10264d.m11057a(this.f9644h);
        c2770c.f10264d.m11055b(this.f9645i);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        Log.i("istep", "pack " + toString());
        return c2770c;
    }

    public String toString() {
        return "MsgBrightnessSetting{targetId=" + ((int) this.f9640d) + ", sourceId=" + ((int) this.f9641e) + ", cmdId=" + ((int) this.f9642f) + ", cmdCode=" + ((int) this.f9643g) + ", brightness=" + ((int) this.f9644h) + ", model=" + ((int) this.f9645i) + ", report=" + ((int) this.f9646j) + C0359h.f726w;
    }
}
