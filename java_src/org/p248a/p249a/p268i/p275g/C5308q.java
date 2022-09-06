package org.p248a.p249a.p268i.p275g;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p249a.C5093f;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p277j.AbstractC5317a;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
@AbstractC5006c
/* renamed from: org.a.a.i.g.q */
/* loaded from: classes2.dex */
public class C5308q implements AbstractC5317a, SessionInputBuffer {

    /* renamed from: a */
    private final HttpTransportMetricsImpl f22292a;

    /* renamed from: b */
    private final byte[] f22293b;

    /* renamed from: c */
    private final ByteArrayBuffer f22294c;

    /* renamed from: d */
    private final int f22295d;

    /* renamed from: e */
    private final C5087c f22296e;

    /* renamed from: f */
    private final CharsetDecoder f22297f;

    /* renamed from: g */
    private InputStream f22298g;

    /* renamed from: h */
    private int f22299h;

    /* renamed from: i */
    private int f22300i;

    /* renamed from: j */
    private CharBuffer f22301j;

    public C5308q(HttpTransportMetricsImpl httpTransportMetricsImpl, int i) {
        this(httpTransportMetricsImpl, i, i, null, null);
    }

    public C5308q(HttpTransportMetricsImpl httpTransportMetricsImpl, int i, int i2, C5087c c5087c, CharsetDecoder charsetDecoder) {
        C5351a.m1321a(httpTransportMetricsImpl, "HTTP transport metrcis");
        C5351a.m1324a(i, "Buffer size");
        this.f22292a = httpTransportMetricsImpl;
        this.f22293b = new byte[i];
        this.f22299h = 0;
        this.f22300i = 0;
        this.f22295d = i2 < 0 ? 512 : i2;
        this.f22296e = c5087c == null ? C5087c.f21705a : c5087c;
        this.f22294c = new ByteArrayBuffer(i);
        this.f22297f = charsetDecoder;
    }

    /* renamed from: a */
    private int m1491a(CoderResult coderResult, CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.f22301j.flip();
        int remaining = this.f22301j.remaining();
        while (this.f22301j.hasRemaining()) {
            charArrayBuffer.append(this.f22301j.get());
        }
        this.f22301j.compact();
        return remaining;
    }

    /* renamed from: a */
    private int m1490a(CharArrayBuffer charArrayBuffer) {
        int length = this.f22294c.length();
        if (length > 0) {
            if (this.f22294c.byteAt(length - 1) == 10) {
                length--;
            }
            if (length > 0 && this.f22294c.byteAt(length - 1) == 13) {
                length--;
            }
        }
        if (this.f22297f == null) {
            charArrayBuffer.append(this.f22294c, 0, length);
        } else {
            length = m1488a(charArrayBuffer, ByteBuffer.wrap(this.f22294c.buffer(), 0, length));
        }
        this.f22294c.clear();
        return length;
    }

    /* renamed from: a */
    private int m1489a(CharArrayBuffer charArrayBuffer, int i) {
        int i2 = this.f22299h;
        this.f22299h = i + 1;
        if (i > i2 && this.f22293b[i - 1] == 13) {
            i--;
        }
        int i3 = i - i2;
        if (this.f22297f == null) {
            charArrayBuffer.append(this.f22293b, i2, i3);
            return i3;
        }
        return m1488a(charArrayBuffer, ByteBuffer.wrap(this.f22293b, i2, i3));
    }

    /* renamed from: a */
    private int m1488a(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) {
        int i = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.f22301j == null) {
            this.f22301j = CharBuffer.allocate(1024);
        }
        this.f22297f.reset();
        while (byteBuffer.hasRemaining()) {
            i += m1491a(this.f22297f.decode(byteBuffer, this.f22301j, true), charArrayBuffer, byteBuffer);
        }
        int m1491a = i + m1491a(this.f22297f.flush(this.f22301j), charArrayBuffer, byteBuffer);
        this.f22301j.clear();
        return m1491a;
    }

    /* renamed from: a */
    private int m1487a(byte[] bArr, int i, int i2) {
        C5352b.m1313a(this.f22298g, "Input stream");
        return this.f22298g.read(bArr, i, i2);
    }

    /* renamed from: h */
    private int m1483h() {
        for (int i = this.f22299h; i < this.f22300i; i++) {
            if (this.f22293b[i] == 10) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void m1492a(InputStream inputStream) {
        this.f22298g = inputStream;
    }

    /* renamed from: a */
    public boolean m1493a() {
        return this.f22298g != null;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5317a
    /* renamed from: b */
    public int mo1469b() {
        return this.f22293b.length;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5317a
    /* renamed from: c */
    public int mo1468c() {
        return this.f22300i - this.f22299h;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5317a
    /* renamed from: d */
    public int mo1467d() {
        return mo1469b() - mo1468c();
    }

    /* renamed from: e */
    public int m1486e() {
        if (this.f22299h > 0) {
            int i = this.f22300i - this.f22299h;
            if (i > 0) {
                System.arraycopy(this.f22293b, this.f22299h, this.f22293b, 0, i);
            }
            this.f22299h = 0;
            this.f22300i = i;
        }
        int i2 = this.f22300i;
        int m1487a = m1487a(this.f22293b, i2, this.f22293b.length - i2);
        if (m1487a == -1) {
            return -1;
        }
        this.f22300i = i2 + m1487a;
        this.f22292a.incrementBytesTransferred(m1487a);
        return m1487a;
    }

    /* renamed from: f */
    public boolean m1485f() {
        return this.f22299h < this.f22300i;
    }

    /* renamed from: g */
    public void m1484g() {
        this.f22299h = 0;
        this.f22300i = 0;
    }

    public HttpTransportMetrics getMetrics() {
        return this.f22292a;
    }

    public boolean isDataAvailable(int i) {
        return m1485f();
    }

    public int read() {
        while (!m1485f()) {
            if (m1486e() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.f22293b;
        int i = this.f22299h;
        this.f22299h = i + 1;
        return bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    public int read(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return 0;
        }
        if (m1485f()) {
            int min = Math.min(i2, this.f22300i - this.f22299h);
            System.arraycopy(this.f22293b, this.f22299h, bArr, i, min);
            this.f22299h += min;
            return min;
        } else if (i2 > this.f22295d) {
            int m1487a = m1487a(bArr, i, i2);
            if (m1487a <= 0) {
                return m1487a;
            }
            this.f22292a.incrementBytesTransferred(m1487a);
            return m1487a;
        } else {
            while (!m1485f()) {
                if (m1486e() == -1) {
                    return -1;
                }
            }
            int min2 = Math.min(i2, this.f22300i - this.f22299h);
            System.arraycopy(this.f22293b, this.f22299h, bArr, i, min2);
            this.f22299h += min2;
            return min2;
        }
    }

    public int readLine(CharArrayBuffer charArrayBuffer) {
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        boolean z = true;
        int i = 0;
        while (z) {
            int m1483h = m1483h();
            if (m1483h == -1) {
                if (m1485f()) {
                    this.f22294c.append(this.f22293b, this.f22299h, this.f22300i - this.f22299h);
                    this.f22299h = this.f22300i;
                }
                i = m1486e();
                if (i == -1) {
                    z = false;
                }
            } else if (this.f22294c.isEmpty()) {
                return m1489a(charArrayBuffer, m1483h);
            } else {
                this.f22294c.append(this.f22293b, this.f22299h, (m1483h + 1) - this.f22299h);
                this.f22299h = m1483h + 1;
                z = false;
            }
            int m2052a = this.f22296e.m2052a();
            if (m2052a > 0 && this.f22294c.length() >= m2052a) {
                throw new C5093f("Maximum line length limit exceeded");
            }
        }
        if (i != -1 || !this.f22294c.isEmpty()) {
            return m1490a(charArrayBuffer);
        }
        return -1;
    }

    public String readLine() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }
}
