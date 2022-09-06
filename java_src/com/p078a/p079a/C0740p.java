package com.p078a.p079a;

import java.util.zip.ZipException;
/* renamed from: com.a.a.p */
/* loaded from: classes.dex */
public class C0740p implements AbstractC0724c {

    /* renamed from: b */
    private static final String f1830b = "Zip64 extended information must contain both size values in the local file header.";

    /* renamed from: d */
    private C0744t f1832d;

    /* renamed from: e */
    private C0744t f1833e;

    /* renamed from: f */
    private C0744t f1834f;

    /* renamed from: g */
    private C0756z f1835g;

    /* renamed from: h */
    private byte[] f1836h;

    /* renamed from: a */
    static final C0721ab f1829a = new C0721ab(1);

    /* renamed from: c */
    private static final byte[] f1831c = new byte[0];

    public C0740p() {
    }

    public C0740p(C0744t c0744t, C0744t c0744t2) {
        this(c0744t, c0744t2, null, null);
    }

    public C0740p(C0744t c0744t, C0744t c0744t2, C0744t c0744t3, C0756z c0756z) {
        this.f1832d = c0744t;
        this.f1833e = c0744t2;
        this.f1834f = c0744t3;
        this.f1835g = c0756z;
    }

    /* renamed from: a */
    private int m19220a(byte[] bArr) {
        int i;
        if (this.f1832d != null) {
            System.arraycopy(this.f1832d.m19211a(), 0, bArr, 0, 8);
            i = 8;
        } else {
            i = 0;
        }
        if (this.f1833e != null) {
            System.arraycopy(this.f1833e.m19211a(), 0, bArr, i, 8);
            return i + 8;
        }
        return i;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public C0721ab mo19165a() {
        return f1829a;
    }

    /* renamed from: a */
    public void m19223a(C0744t c0744t) {
        this.f1832d = c0744t;
    }

    /* renamed from: a */
    public void m19222a(C0756z c0756z) {
        this.f1835g = c0756z;
    }

    /* renamed from: a */
    public void m19221a(boolean z, boolean z2, boolean z3, boolean z4) {
        int i;
        if (this.f1836h != null) {
            int i2 = (z4 ? 4 : 0) + (z ? 8 : 0) + (z2 ? 8 : 0) + (z3 ? 8 : 0);
            if (this.f1836h.length != i2) {
                throw new ZipException("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + i2 + " but is " + this.f1836h.length);
            }
            if (z) {
                this.f1832d = new C0744t(this.f1836h, 0);
                i = 8;
            } else {
                i = 0;
            }
            if (z2) {
                this.f1833e = new C0744t(this.f1836h, i);
                i += 8;
            }
            if (z3) {
                this.f1834f = new C0744t(this.f1836h, i);
                i += 8;
            }
            if (!z4) {
                return;
            }
            this.f1835g = new C0756z(this.f1836h, i);
            int i3 = i + 4;
        }
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public void mo19164a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 < 16) {
            throw new ZipException(f1830b);
        }
        this.f1832d = new C0744t(bArr, i);
        int i3 = i + 8;
        this.f1833e = new C0744t(bArr, i3);
        int i4 = i3 + 8;
        int i5 = i2 - 16;
        if (i5 >= 8) {
            this.f1834f = new C0744t(bArr, i4);
            i4 += 8;
            i5 -= 8;
        }
        if (i5 < 4) {
            return;
        }
        this.f1835g = new C0756z(bArr, i4);
        int i6 = i4 + 4;
        int i7 = i5 - 4;
    }

    /* renamed from: b */
    public C0744t m19219b() {
        return this.f1832d;
    }

    /* renamed from: b */
    public void m19218b(C0744t c0744t) {
        this.f1833e = c0744t;
    }

    @Override // com.p078a.p079a.AbstractC0724c
    /* renamed from: b */
    public void mo19217b(byte[] bArr, int i, int i2) {
        this.f1836h = new byte[i2];
        System.arraycopy(bArr, i, this.f1836h, 0, i2);
        if (i2 >= 28) {
            mo19164a(bArr, i, i2);
        } else if (i2 != 24) {
            if (i2 % 8 != 4) {
                return;
            }
            this.f1835g = new C0756z(bArr, (i + i2) - 4);
        } else {
            this.f1832d = new C0744t(bArr, i);
            int i3 = i + 8;
            this.f1833e = new C0744t(bArr, i3);
            this.f1834f = new C0744t(bArr, i3 + 8);
        }
    }

    /* renamed from: c */
    public void m19216c(C0744t c0744t) {
        this.f1834f = c0744t;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: c */
    public byte[] mo19163c() {
        byte[] bArr = new byte[mo19162d().m19277b()];
        int m19220a = m19220a(bArr);
        if (this.f1834f != null) {
            System.arraycopy(this.f1834f.m19211a(), 0, bArr, m19220a, 8);
            m19220a += 8;
        }
        if (this.f1835g != null) {
            System.arraycopy(this.f1835g.m19130a(), 0, bArr, m19220a, 4);
            int i = m19220a + 4;
        }
        return bArr;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: d */
    public C0721ab mo19162d() {
        int i = 8;
        int i2 = 0;
        int i3 = (this.f1832d != null ? 8 : 0) + (this.f1833e != null ? 8 : 0);
        if (this.f1834f == null) {
            i = 0;
        }
        int i4 = i3 + i;
        if (this.f1835g != null) {
            i2 = 4;
        }
        return new C0721ab(i4 + i2);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: e */
    public byte[] mo19161e() {
        if (this.f1832d == null && this.f1833e == null) {
            return f1831c;
        }
        if (this.f1832d == null || this.f1833e == null) {
            throw new IllegalArgumentException(f1830b);
        }
        byte[] bArr = new byte[16];
        m19220a(bArr);
        return bArr;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: f */
    public C0721ab mo19160f() {
        return new C0721ab(this.f1832d != null ? 16 : 0);
    }

    /* renamed from: g */
    public C0744t m19215g() {
        return this.f1833e;
    }

    /* renamed from: h */
    public C0744t m19214h() {
        return this.f1834f;
    }

    /* renamed from: i */
    public C0756z m19213i() {
        return this.f1835g;
    }
}
