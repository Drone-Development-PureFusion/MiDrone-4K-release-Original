package com.google.p217a.p218a;

import java.io.InputStream;
import java.util.Vector;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.google.a.a.b */
/* loaded from: classes.dex */
public final class C3991b {

    /* renamed from: a */
    private final byte[] f17059a;

    /* renamed from: b */
    private int f17060b;

    /* renamed from: c */
    private int f17061c;

    /* renamed from: d */
    private int f17062d;

    /* renamed from: e */
    private final InputStream f17063e;

    /* renamed from: f */
    private int f17064f;

    /* renamed from: g */
    private int f17065g;

    /* renamed from: h */
    private int f17066h;

    /* renamed from: i */
    private int f17067i;

    /* renamed from: j */
    private int f17068j;

    /* renamed from: k */
    private int f17069k;

    private C3991b(InputStream inputStream) {
        this.f17066h = Integer.MAX_VALUE;
        this.f17068j = 64;
        this.f17069k = 67108864;
        this.f17059a = new byte[4096];
        this.f17060b = 0;
        this.f17062d = 0;
        this.f17063e = inputStream;
    }

    private C3991b(byte[] bArr, int i, int i2) {
        this.f17066h = Integer.MAX_VALUE;
        this.f17068j = 64;
        this.f17069k = 67108864;
        this.f17059a = bArr;
        this.f17060b = i + i2;
        this.f17062d = i;
        this.f17063e = null;
    }

    /* renamed from: a */
    public static C3991b m6302a(InputStream inputStream) {
        return new C3991b(inputStream);
    }

    /* renamed from: a */
    public static C3991b m6300a(byte[] bArr, int i, int i2) {
        return new C3991b(bArr, i, i2);
    }

    /* renamed from: a */
    private boolean m6301a(boolean z) {
        if (this.f17062d < this.f17060b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.f17065g + this.f17060b == this.f17066h) {
            if (!z) {
                return false;
            }
            throw C3994d.m6230a();
        }
        this.f17065g += this.f17060b;
        this.f17062d = 0;
        this.f17060b = this.f17063e == null ? -1 : this.f17063e.read(this.f17059a);
        if (this.f17060b == 0 || this.f17060b < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f17060b + "\nThe InputStream implementation is buggy.");
        }
        if (this.f17060b == -1) {
            this.f17060b = 0;
            if (!z) {
                return false;
            }
            throw C3994d.m6230a();
        }
        m6280p();
        int i = this.f17065g + this.f17060b + this.f17061c;
        if (i <= this.f17069k && i >= 0) {
            return true;
        }
        throw C3994d.m6223h();
    }

    /* renamed from: p */
    private void m6280p() {
        this.f17060b += this.f17061c;
        int i = this.f17065g + this.f17060b;
        if (i <= this.f17066h) {
            this.f17061c = 0;
            return;
        }
        this.f17061c = i - this.f17066h;
        this.f17060b -= this.f17061c;
    }

    /* renamed from: a */
    public int m6305a() {
        if (m6282n()) {
            this.f17064f = 0;
            return 0;
        }
        this.f17064f = m6286j();
        if (this.f17064f != 0) {
            return this.f17064f;
        }
        throw C3994d.m6227d();
    }

    /* renamed from: a */
    public void m6304a(int i) {
        if (this.f17064f != i) {
            throw C3994d.m6226e();
        }
    }

    /* renamed from: a */
    public void m6303a(AbstractC3995e abstractC3995e) {
        int m6286j = m6286j();
        if (this.f17067i >= this.f17068j) {
            throw C3994d.m6224g();
        }
        int m6296c = m6296c(m6286j);
        this.f17067i++;
        abstractC3995e.mo4530a(this);
        m6304a(0);
        this.f17067i--;
        m6294d(m6296c);
    }

    /* renamed from: b */
    public void m6299b() {
        int m6305a;
        do {
            m6305a = m6305a();
            if (m6305a == 0) {
                return;
            }
        } while (m6298b(m6305a));
    }

    /* renamed from: b */
    public boolean m6298b(int i) {
        switch (C3996f.m6217a(i)) {
            case 0:
                m6293e();
                return true;
            case 1:
                m6283m();
                return true;
            case 2:
                m6290f(m6286j());
                return true;
            case 3:
                m6299b();
                m6304a(C3996f.m6216a(C3996f.m6215b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m6284l();
                return true;
            default:
                throw C3994d.m6225f();
        }
    }

    /* renamed from: c */
    public int m6296c(int i) {
        if (i < 0) {
            throw C3994d.m6229b();
        }
        int i2 = this.f17065g + this.f17062d + i;
        int i3 = this.f17066h;
        if (i2 > i3) {
            throw C3994d.m6230a();
        }
        this.f17066h = i2;
        m6280p();
        return i3;
    }

    /* renamed from: c */
    public long m6297c() {
        return m6285k();
    }

    /* renamed from: d */
    public long m6295d() {
        return m6285k();
    }

    /* renamed from: d */
    public void m6294d(int i) {
        this.f17066h = i;
        m6280p();
    }

    /* renamed from: e */
    public int m6293e() {
        return m6286j();
    }

    /* renamed from: e */
    public byte[] m6292e(int i) {
        if (i < 0) {
            throw C3994d.m6229b();
        }
        if (this.f17065g + this.f17062d + i > this.f17066h) {
            m6290f((this.f17066h - this.f17065g) - this.f17062d);
            throw C3994d.m6230a();
        } else if (i <= this.f17060b - this.f17062d) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f17059a, this.f17062d, bArr, 0, i);
            this.f17062d += i;
            return bArr;
        } else if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.f17060b - this.f17062d;
            System.arraycopy(this.f17059a, this.f17062d, bArr2, 0, i2);
            this.f17062d = this.f17060b;
            m6301a(true);
            while (i - i2 > this.f17060b) {
                System.arraycopy(this.f17059a, 0, bArr2, i2, this.f17060b);
                i2 += this.f17060b;
                this.f17062d = this.f17060b;
                m6301a(true);
            }
            System.arraycopy(this.f17059a, 0, bArr2, i2, i - i2);
            this.f17062d = i - i2;
            return bArr2;
        } else {
            int i3 = this.f17062d;
            int i4 = this.f17060b;
            this.f17065g += this.f17060b;
            this.f17062d = 0;
            this.f17060b = 0;
            Vector vector = new Vector();
            int i5 = i - (i4 - i3);
            while (i5 > 0) {
                byte[] bArr3 = new byte[Math.min(i5, 4096)];
                int i6 = 0;
                while (i6 < bArr3.length) {
                    int read = this.f17063e == null ? -1 : this.f17063e.read(bArr3, i6, bArr3.length - i6);
                    if (read == -1) {
                        throw C3994d.m6230a();
                    }
                    this.f17065g += read;
                    i6 += read;
                }
                vector.addElement(bArr3);
                i5 -= bArr3.length;
            }
            byte[] bArr4 = new byte[i];
            int i7 = i4 - i3;
            System.arraycopy(this.f17059a, i3, bArr4, 0, i7);
            int i8 = i7;
            for (int i9 = 0; i9 < vector.size(); i9++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i9);
                System.arraycopy(bArr5, 0, bArr4, i8, bArr5.length);
                i8 += bArr5.length;
            }
            return bArr4;
        }
    }

    /* renamed from: f */
    public void m6290f(int i) {
        if (i < 0) {
            throw C3994d.m6229b();
        }
        if (this.f17065g + this.f17062d + i > this.f17066h) {
            m6290f((this.f17066h - this.f17065g) - this.f17062d);
            throw C3994d.m6230a();
        } else if (i <= this.f17060b - this.f17062d) {
            this.f17062d += i;
        } else {
            int i2 = this.f17060b - this.f17062d;
            this.f17065g += this.f17060b;
            this.f17062d = 0;
            this.f17060b = 0;
            int i3 = i2;
            while (i3 < i) {
                int skip = this.f17063e == null ? -1 : (int) this.f17063e.skip(i - i3);
                if (skip <= 0) {
                    throw C3994d.m6230a();
                }
                i3 += skip;
                this.f17065g = skip + this.f17065g;
            }
        }
    }

    /* renamed from: f */
    public boolean m6291f() {
        return m6286j() != 0;
    }

    /* renamed from: g */
    public String m6289g() {
        int m6286j = m6286j();
        if (m6286j > this.f17060b - this.f17062d || m6286j <= 0) {
            return new String(m6292e(m6286j), "UTF-8");
        }
        String str = new String(this.f17059a, this.f17062d, m6286j, "UTF-8");
        this.f17062d = m6286j + this.f17062d;
        return str;
    }

    /* renamed from: h */
    public C3990a m6288h() {
        int m6286j = m6286j();
        if (m6286j > this.f17060b - this.f17062d || m6286j <= 0) {
            return C3990a.m6308a(m6292e(m6286j));
        }
        C3990a m6307a = C3990a.m6307a(this.f17059a, this.f17062d, m6286j);
        this.f17062d = m6286j + this.f17062d;
        return m6307a;
    }

    /* renamed from: i */
    public int m6287i() {
        return m6286j();
    }

    /* renamed from: j */
    public int m6286j() {
        byte m6281o = m6281o();
        if (m6281o >= 0) {
            return m6281o;
        }
        int i = m6281o & Byte.MAX_VALUE;
        byte m6281o2 = m6281o();
        if (m6281o2 >= 0) {
            return i | (m6281o2 << 7);
        }
        int i2 = i | ((m6281o2 & Byte.MAX_VALUE) << 7);
        byte m6281o3 = m6281o();
        if (m6281o3 >= 0) {
            return i2 | (m6281o3 << 14);
        }
        int i3 = i2 | ((m6281o3 & Byte.MAX_VALUE) << 14);
        byte m6281o4 = m6281o();
        if (m6281o4 >= 0) {
            return i3 | (m6281o4 << 21);
        }
        int i4 = i3 | ((m6281o4 & Byte.MAX_VALUE) << 21);
        byte m6281o5 = m6281o();
        int i5 = i4 | (m6281o5 << 28);
        if (m6281o5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (m6281o() >= 0) {
                return i5;
            }
        }
        throw C3994d.m6228c();
    }

    /* renamed from: k */
    public long m6285k() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m6281o = m6281o();
            j |= (m6281o & Byte.MAX_VALUE) << i;
            if ((m6281o & 128) == 0) {
                return j;
            }
        }
        throw C3994d.m6228c();
    }

    /* renamed from: l */
    public int m6284l() {
        return (m6281o() & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((m6281o() & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | ((m6281o() & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((m6281o() & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24);
    }

    /* renamed from: m */
    public long m6283m() {
        byte m6281o = m6281o();
        byte m6281o2 = m6281o();
        return ((m6281o2 & 255) << 8) | (m6281o & 255) | ((m6281o() & 255) << 16) | ((m6281o() & 255) << 24) | ((m6281o() & 255) << 32) | ((m6281o() & 255) << 40) | ((m6281o() & 255) << 48) | ((m6281o() & 255) << 56);
    }

    /* renamed from: n */
    public boolean m6282n() {
        return this.f17062d == this.f17060b && !m6301a(false);
    }

    /* renamed from: o */
    public byte m6281o() {
        if (this.f17062d == this.f17060b) {
            m6301a(true);
        }
        byte[] bArr = this.f17059a;
        int i = this.f17062d;
        this.f17062d = i + 1;
        return bArr[i];
    }
}
