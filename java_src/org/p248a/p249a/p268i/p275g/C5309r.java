package org.p248a.p249a.p268i.p275g;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p277j.AbstractC5317a;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
@AbstractC5006c
/* renamed from: org.a.a.i.g.r */
/* loaded from: classes2.dex */
public class C5309r implements AbstractC5317a, SessionOutputBuffer {

    /* renamed from: a */
    private static final byte[] f22302a = {13, 10};

    /* renamed from: b */
    private final HttpTransportMetricsImpl f22303b;

    /* renamed from: c */
    private final ByteArrayBuffer f22304c;

    /* renamed from: d */
    private final int f22305d;

    /* renamed from: e */
    private final CharsetEncoder f22306e;

    /* renamed from: f */
    private OutputStream f22307f;

    /* renamed from: g */
    private ByteBuffer f22308g;

    public C5309r(HttpTransportMetricsImpl httpTransportMetricsImpl, int i) {
        this(httpTransportMetricsImpl, i, i, null);
    }

    public C5309r(HttpTransportMetricsImpl httpTransportMetricsImpl, int i, int i2, CharsetEncoder charsetEncoder) {
        C5351a.m1324a(i, "Buffer size");
        C5351a.m1321a(httpTransportMetricsImpl, "HTTP transport metrcis");
        this.f22303b = httpTransportMetricsImpl;
        this.f22304c = new ByteArrayBuffer(i);
        this.f22305d = i2 < 0 ? 0 : i2;
        this.f22306e = charsetEncoder;
    }

    /* renamed from: a */
    private void m1480a(CharBuffer charBuffer) {
        if (!charBuffer.hasRemaining()) {
            return;
        }
        if (this.f22308g == null) {
            this.f22308g = ByteBuffer.allocate(1024);
        }
        this.f22306e.reset();
        while (charBuffer.hasRemaining()) {
            m1479a(this.f22306e.encode(charBuffer, this.f22308g, true));
        }
        m1479a(this.f22306e.flush(this.f22308g));
        this.f22308g.clear();
    }

    /* renamed from: a */
    private void m1479a(CoderResult coderResult) {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.f22308g.flip();
        while (this.f22308g.hasRemaining()) {
            write(this.f22308g.get());
        }
        this.f22308g.compact();
    }

    /* renamed from: a */
    private void m1478a(byte[] bArr, int i, int i2) {
        C5352b.m1313a(this.f22307f, "Output stream");
        this.f22307f.write(bArr, i, i2);
    }

    /* renamed from: e */
    private void m1477e() {
        if (this.f22307f != null) {
            this.f22307f.flush();
        }
    }

    /* renamed from: f */
    private void m1476f() {
        int length = this.f22304c.length();
        if (length > 0) {
            m1478a(this.f22304c.buffer(), 0, length);
            this.f22304c.clear();
            this.f22303b.incrementBytesTransferred(length);
        }
    }

    /* renamed from: a */
    public void m1481a(OutputStream outputStream) {
        this.f22307f = outputStream;
    }

    /* renamed from: a */
    public boolean m1482a() {
        return this.f22307f != null;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5317a
    /* renamed from: b */
    public int mo1469b() {
        return this.f22304c.capacity();
    }

    @Override // org.p248a.p249a.p277j.AbstractC5317a
    /* renamed from: c */
    public int mo1468c() {
        return this.f22304c.length();
    }

    @Override // org.p248a.p249a.p277j.AbstractC5317a
    /* renamed from: d */
    public int mo1467d() {
        return mo1469b() - mo1468c();
    }

    public void flush() {
        m1476f();
        m1477e();
    }

    public HttpTransportMetrics getMetrics() {
        return this.f22303b;
    }

    public void write(int i) {
        if (this.f22305d <= 0) {
            m1476f();
            this.f22307f.write(i);
            return;
        }
        if (this.f22304c.isFull()) {
            m1476f();
        }
        this.f22304c.append(i);
    }

    public void write(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        if (i2 > this.f22305d || i2 > this.f22304c.capacity()) {
            m1476f();
            m1478a(bArr, i, i2);
            this.f22303b.incrementBytesTransferred(i2);
            return;
        }
        if (i2 > this.f22304c.capacity() - this.f22304c.length()) {
            m1476f();
        }
        this.f22304c.append(bArr, i, i2);
    }

    public void writeLine(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 0) {
            if (this.f22306e == null) {
                for (int i = 0; i < str.length(); i++) {
                    write(str.charAt(i));
                }
            } else {
                m1480a(CharBuffer.wrap(str));
            }
        }
        write(f22302a);
    }

    public void writeLine(CharArrayBuffer charArrayBuffer) {
        int i = 0;
        if (charArrayBuffer == null) {
            return;
        }
        if (this.f22306e == null) {
            int length = charArrayBuffer.length();
            while (length > 0) {
                int min = Math.min(this.f22304c.capacity() - this.f22304c.length(), length);
                if (min > 0) {
                    this.f22304c.append(charArrayBuffer, i, min);
                }
                if (this.f22304c.isFull()) {
                    m1476f();
                }
                i += min;
                length -= min;
            }
        } else {
            m1480a(CharBuffer.wrap(charArrayBuffer.buffer(), 0, charArrayBuffer.length()));
        }
        write(f22302a);
    }
}
