package com.p078a.p079a;
/* renamed from: com.a.a.f */
/* loaded from: classes.dex */
public final class C0728f {

    /* renamed from: a */
    public static final int f1791a = 2048;

    /* renamed from: b */
    private static final int f1792b = 1;

    /* renamed from: c */
    private static final int f1793c = 8;

    /* renamed from: d */
    private static final int f1794d = 64;

    /* renamed from: e */
    private boolean f1795e = false;

    /* renamed from: f */
    private boolean f1796f = false;

    /* renamed from: g */
    private boolean f1797g = false;

    /* renamed from: h */
    private boolean f1798h = false;

    /* renamed from: a */
    public static C0728f m19242a(byte[] bArr, int i) {
        boolean z = true;
        int m19278a = C0721ab.m19278a(bArr, i);
        C0728f c0728f = new C0728f();
        c0728f.m19240b((m19278a & 8) != 0);
        c0728f.m19243a((m19278a & 2048) != 0);
        c0728f.m19236d((m19278a & 64) != 0);
        if ((m19278a & 1) == 0) {
            z = false;
        }
        c0728f.m19238c(z);
        return c0728f;
    }

    /* renamed from: a */
    public void m19243a(boolean z) {
        this.f1795e = z;
    }

    /* renamed from: a */
    public boolean m19244a() {
        return this.f1795e;
    }

    /* renamed from: b */
    public void m19240b(boolean z) {
        this.f1796f = z;
    }

    /* renamed from: b */
    public boolean m19241b() {
        return this.f1796f;
    }

    /* renamed from: c */
    public void m19238c(boolean z) {
        this.f1797g = z;
    }

    /* renamed from: c */
    public boolean m19239c() {
        return this.f1797g;
    }

    /* renamed from: d */
    public void m19236d(boolean z) {
        this.f1798h = z;
        if (z) {
            m19238c(true);
        }
    }

    /* renamed from: d */
    public boolean m19237d() {
        return this.f1797g && this.f1798h;
    }

    /* renamed from: e */
    public byte[] m19235e() {
        int i = 0;
        int i2 = (this.f1797g ? 1 : 0) | (this.f1795e ? 2048 : 0) | (this.f1796f ? 8 : 0);
        if (this.f1798h) {
            i = 64;
        }
        return C0721ab.m19280a(i2 | i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0728f)) {
            return false;
        }
        C0728f c0728f = (C0728f) obj;
        return c0728f.f1797g == this.f1797g && c0728f.f1798h == this.f1798h && c0728f.f1795e == this.f1795e && c0728f.f1796f == this.f1796f;
    }

    public int hashCode() {
        int i = 1;
        int i2 = ((this.f1795e ? 1 : 0) + (((this.f1798h ? 1 : 0) + ((this.f1797g ? 1 : 0) * 17)) * 13)) * 7;
        if (!this.f1796f) {
            i = 0;
        }
        return (i2 + i) * 3;
    }
}
