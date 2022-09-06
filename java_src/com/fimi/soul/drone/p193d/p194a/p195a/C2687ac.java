package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import java.io.Serializable;
/* renamed from: com.fimi.soul.drone.d.a.a.ac */
/* loaded from: classes.dex */
public class C2687ac extends AbstractC2769b implements Serializable {

    /* renamed from: a */
    static final byte f9624a = 10;

    /* renamed from: c */
    static final byte f9625c = 108;

    /* renamed from: d */
    static final byte f9626d = 1;

    /* renamed from: e */
    static final byte f9627e = 11;

    /* renamed from: f */
    static final byte f9628f = 1;

    /* renamed from: g */
    public static final byte f9629g = 8;

    /* renamed from: h */
    public static final byte f9630h = 9;

    /* renamed from: i */
    byte f9631i = 8;

    /* renamed from: j */
    byte f9632j = f9627e;

    /* renamed from: k */
    public byte f9633k;

    /* renamed from: l */
    public byte f9634l;

    /* renamed from: m */
    public byte f9635m;

    /* renamed from: n */
    public byte f9636n;

    /* renamed from: o */
    public byte f9637o;

    public C2687ac() {
        this.f10260b = 108;
    }

    /* renamed from: a */
    public void m11186a(byte b) {
        this.f9631i = b;
    }

    /* renamed from: a */
    public void m11185a(C2770c c2770c) {
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9634l = c2771d.m11050d();
        this.f9635m = c2771d.m11050d();
        this.f9636n = c2771d.m11050d();
        this.f9637o = c2771d.m11050d();
    }

    /* renamed from: a */
    public void m11184a(boolean z) {
        if (z) {
            this.f9632j = f9627e;
        } else {
            this.f9632j = (byte) 1;
        }
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 108;
        c2770c.f10262b = 10;
        c2770c.f10264d.m11055b(this.f9632j);
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b(this.f9631i);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }
}
