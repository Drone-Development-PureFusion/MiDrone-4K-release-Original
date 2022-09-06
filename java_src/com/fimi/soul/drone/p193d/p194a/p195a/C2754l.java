package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import java.io.Serializable;
/* renamed from: com.fimi.soul.drone.d.a.a.l */
/* loaded from: classes.dex */
public class C2754l extends AbstractC2769b implements Serializable {

    /* renamed from: e */
    private byte[] f10129e;

    /* renamed from: f */
    private byte f10130f;

    /* renamed from: g */
    private byte f10131g;

    /* renamed from: h */
    private byte f10132h;

    /* renamed from: i */
    private byte f10133i;

    /* renamed from: k */
    private byte f10135k;

    /* renamed from: l */
    private byte f10136l;

    /* renamed from: m */
    private byte f10137m;

    /* renamed from: a */
    public final int f10126a = 136;

    /* renamed from: c */
    private byte f10127c = 19;

    /* renamed from: d */
    private byte[] f10128d = new byte[2];

    /* renamed from: j */
    private byte f10134j = 0;

    /* renamed from: n */
    private boolean f10138n = false;

    /* renamed from: o */
    private boolean f10139o = true;

    /* renamed from: p */
    private boolean f10140p = false;

    public C2754l() {
        this.f10260b = 136;
    }

    /* renamed from: o */
    private C2770c m11111o() {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 136;
        if (this.f10139o) {
            c2770c.f10262b = 19;
            if (this.f10129e != null && this.f10129e.length > 0) {
                for (byte b : this.f10129e) {
                    c2770c.f10264d.m11055b(b);
                }
            }
        } else {
            c2770c.f10262b = 10;
            c2770c.f10264d.m11055b((byte) 0);
            c2770c.f10264d.m11055b((byte) 0);
            c2770c.f10264d.m11055b((byte) 13);
            c2770c.f10264d.m11055b((byte) 1);
            c2770c.f10264d.m11055b(this.f10134j);
            c2770c.f10264d.m11055b((byte) 0);
            c2770c.f10264d.m11055b((byte) 0);
            c2770c.f10264d.m11055b((byte) 0);
            c2770c.f10264d.m11055b(this.f10136l);
            c2770c.f10264d.m11055b((byte) 0);
        }
        return c2770c;
    }

    /* renamed from: p */
    private C2770c m11110p() {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 136;
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 13);
        if (this.f10139o) {
            c2770c.f10264d.m11055b((byte) 0);
            if (this.f10140p) {
                c2770c.f10262b = 26;
                c2770c.f10264d.m11055b((byte) 0);
            } else {
                c2770c.f10262b = 36;
                c2770c.f10264d.m11055b((byte) 1);
            }
        } else {
            c2770c.f10262b = 10;
            c2770c.f10264d.m11055b((byte) 1);
            c2770c.f10264d.m11055b((byte) 0);
        }
        c2770c.f10264d.m11055b(this.f10128d[0]);
        c2770c.f10264d.m11055b(this.f10128d[1]);
        if (!this.f10139o) {
            c2770c.f10264d.m11055b((byte) 0);
            c2770c.f10264d.m11055b((byte) 0);
            c2770c.f10264d.m11055b((byte) 0);
        } else if (this.f10129e != null && this.f10129e.length > 0) {
            for (byte b : this.f10129e) {
                c2770c.f10264d.m11055b(b);
            }
        }
        return c2770c;
    }

    /* renamed from: a */
    public void m11137a(byte b) {
        this.f10127c = b;
    }

    /* renamed from: a */
    public void m11136a(C2770c c2770c) {
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10131g = c2771d.m11050d();
        this.f10130f = c2771d.m11050d();
        this.f10132h = c2771d.m11050d();
        this.f10133i = c2771d.m11050d();
        this.f10134j = c2771d.m11050d();
        this.f10128d[0] = c2771d.m11050d();
        this.f10128d[1] = c2771d.m11050d();
        this.f10135k = c2771d.m11050d();
        this.f10136l = c2771d.m11050d();
        this.f10137m = c2771d.m11050d();
        byte[] bArr = {this.f10131g, this.f10130f, this.f10132h, this.f10133i, m11115k(), this.f10128d[0], this.f10128d[1], this.f10135k, this.f10136l, this.f10137m};
    }

    /* renamed from: a */
    public void m11135a(boolean z) {
        this.f10138n = z;
    }

    /* renamed from: a */
    public void m11134a(byte[] bArr) {
        this.f10128d = bArr;
    }

    /* renamed from: a */
    public boolean m11138a() {
        return this.f10138n;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        return this.f10138n ? m11110p() : m11111o();
    }

    /* renamed from: b */
    public void m11133b(byte b) {
        this.f10133i = b;
    }

    /* renamed from: b */
    public void m11132b(boolean z) {
        this.f10140p = z;
    }

    /* renamed from: b */
    public void m11131b(byte[] bArr) {
        this.f10129e = bArr;
    }

    /* renamed from: c */
    public void m11129c(byte b) {
        this.f10130f = b;
    }

    /* renamed from: c */
    public void m11128c(boolean z) {
        this.f10139o = z;
    }

    /* renamed from: c */
    public boolean m11130c() {
        return this.f10140p;
    }

    /* renamed from: d */
    public void m11126d(byte b) {
        this.f10132h = b;
    }

    /* renamed from: d */
    public boolean m11127d() {
        return this.f10139o;
    }

    /* renamed from: e */
    public byte m11125e() {
        return this.f10127c;
    }

    /* renamed from: e */
    public void m11124e(byte b) {
        this.f10134j = b;
    }

    /* renamed from: f */
    public void m11122f(byte b) {
        this.f10135k = b;
    }

    /* renamed from: f */
    public byte[] m11123f() {
        return this.f10128d;
    }

    /* renamed from: g */
    public byte m11121g() {
        return this.f10133i;
    }

    /* renamed from: g */
    public void m11120g(byte b) {
        this.f10136l = b;
    }

    /* renamed from: h */
    public void m11118h(byte b) {
        this.f10137m = b;
    }

    /* renamed from: h */
    public byte[] m11119h() {
        return this.f10129e;
    }

    /* renamed from: i */
    public byte m11117i() {
        return this.f10130f;
    }

    /* renamed from: j */
    public byte m11116j() {
        return this.f10132h;
    }

    /* renamed from: k */
    public byte m11115k() {
        return this.f10134j;
    }

    /* renamed from: l */
    public byte m11114l() {
        return this.f10135k;
    }

    /* renamed from: m */
    public byte m11113m() {
        return this.f10136l;
    }

    /* renamed from: n */
    public byte m11112n() {
        return this.f10137m;
    }
}
