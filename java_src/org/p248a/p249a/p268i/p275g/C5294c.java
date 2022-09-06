package org.p248a.p249a.p268i.p275g;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.C5133g;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p277j.AbstractC5317a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.c */
/* loaded from: classes2.dex */
public class C5294c extends InputStream {

    /* renamed from: a */
    private static final int f22248a = 1;

    /* renamed from: b */
    private static final int f22249b = 2;

    /* renamed from: c */
    private static final int f22250c = 3;

    /* renamed from: d */
    private static final int f22251d = 2048;

    /* renamed from: e */
    private final SessionInputBuffer f22252e;

    /* renamed from: h */
    private int f22255h;

    /* renamed from: j */
    private boolean f22257j = false;

    /* renamed from: k */
    private boolean f22258k = false;

    /* renamed from: l */
    private Header[] f22259l = new Header[0];

    /* renamed from: i */
    private int f22256i = 0;

    /* renamed from: f */
    private final CharArrayBuffer f22253f = new CharArrayBuffer(16);

    /* renamed from: g */
    private int f22254g = 1;

    public C5294c(SessionInputBuffer sessionInputBuffer) {
        this.f22252e = (SessionInputBuffer) C5351a.m1321a(sessionInputBuffer, "Session input buffer");
    }

    /* renamed from: b */
    private void m1504b() {
        this.f22255h = m1503c();
        if (this.f22255h < 0) {
            throw new MalformedChunkCodingException("Negative chunk size");
        }
        this.f22254g = 2;
        this.f22256i = 0;
        if (this.f22255h != 0) {
            return;
        }
        this.f22257j = true;
        m1502d();
    }

    /* renamed from: c */
    private int m1503c() {
        switch (this.f22254g) {
            case 1:
                break;
            case 2:
            default:
                throw new IllegalStateException("Inconsistent codec state");
            case 3:
                this.f22253f.clear();
                if (this.f22252e.readLine(this.f22253f) != -1) {
                    if (this.f22253f.isEmpty()) {
                        this.f22254g = 1;
                        break;
                    } else {
                        throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
                    }
                } else {
                    return 0;
                }
        }
        this.f22253f.clear();
        if (this.f22252e.readLine(this.f22253f) != -1) {
            int indexOf = this.f22253f.indexOf(59);
            if (indexOf < 0) {
                indexOf = this.f22253f.length();
            }
            try {
                return Integer.parseInt(this.f22253f.substringTrimmed(0, indexOf), 16);
            } catch (NumberFormatException e) {
                throw new MalformedChunkCodingException("Bad chunk header");
            }
        }
        return 0;
    }

    /* renamed from: d */
    private void m1502d() {
        try {
            this.f22259l = AbstractC5292a.m1507a(this.f22252e, -1, -1, null);
        } catch (HttpException e) {
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + e.getMessage());
            malformedChunkCodingException.initCause(e);
            throw malformedChunkCodingException;
        }
    }

    /* renamed from: a */
    public Header[] m1505a() {
        return (Header[]) this.f22259l.clone();
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.f22252e instanceof AbstractC5317a) {
            return Math.min(this.f22252e.mo1468c(), this.f22255h - this.f22256i);
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f22258k) {
            try {
                if (this.f22257j) {
                }
                do {
                } while (read(new byte[2048]) >= 0);
            } finally {
                this.f22257j = true;
                this.f22258k = true;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f22258k) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.f22257j) {
            return -1;
        }
        if (this.f22254g != 2) {
            m1504b();
            if (this.f22257j) {
                return -1;
            }
        }
        int read = this.f22252e.read();
        if (read != -1) {
            this.f22256i++;
            if (this.f22256i >= this.f22255h) {
                this.f22254g = 3;
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f22258k) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.f22257j) {
            return -1;
        }
        if (this.f22254g != 2) {
            m1504b();
            if (this.f22257j) {
                return -1;
            }
        }
        int read = this.f22252e.read(bArr, i, Math.min(i2, this.f22255h - this.f22256i));
        if (read == -1) {
            this.f22257j = true;
            throw new C5133g("Truncated chunk ( expected size: " + this.f22255h + "; actual size: " + this.f22256i + ")");
        }
        this.f22256i += read;
        if (this.f22256i >= this.f22255h) {
            this.f22254g = 3;
        }
        return read;
    }
}
