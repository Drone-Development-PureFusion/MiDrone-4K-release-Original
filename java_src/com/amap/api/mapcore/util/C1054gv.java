package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* renamed from: com.amap.api.mapcore.util.gv */
/* loaded from: classes.dex */
public class C1054gv implements Closeable {

    /* renamed from: a */
    private final InputStream f3301a;

    /* renamed from: b */
    private final Charset f3302b;

    /* renamed from: c */
    private byte[] f3303c;

    /* renamed from: d */
    private int f3304d;

    /* renamed from: e */
    private int f3305e;

    public C1054gv(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(C1056gw.f3307a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f3301a = inputStream;
        this.f3302b = charset;
        this.f3303c = new byte[i];
    }

    public C1054gv(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: b */
    private void m17774b() {
        int read = this.f3301a.read(this.f3303c, 0, this.f3303c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f3304d = 0;
        this.f3305e = read;
    }

    /* renamed from: a */
    public String m17776a() {
        int i;
        String byteArrayOutputStream;
        synchronized (this.f3301a) {
            if (this.f3303c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f3304d >= this.f3305e) {
                m17774b();
            }
            int i2 = this.f3304d;
            while (true) {
                if (i2 == this.f3305e) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((this.f3305e - this.f3304d) + 80) { // from class: com.amap.api.mapcore.util.gv.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, C1054gv.this.f3302b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream2.write(this.f3303c, this.f3304d, this.f3305e - this.f3304d);
                        this.f3305e = -1;
                        m17774b();
                        i = this.f3304d;
                        while (i != this.f3305e) {
                            if (this.f3303c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.f3304d) {
                        byteArrayOutputStream2.write(this.f3303c, this.f3304d, i - this.f3304d);
                    }
                    this.f3304d = i + 1;
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                } else if (this.f3303c[i2] == 10) {
                    byteArrayOutputStream = new String(this.f3303c, this.f3304d, ((i2 == this.f3304d || this.f3303c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.f3304d, this.f3302b.name());
                    this.f3304d = i2 + 1;
                } else {
                    i2++;
                }
            }
            return byteArrayOutputStream;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f3301a) {
            if (this.f3303c != null) {
                this.f3303c = null;
                this.f3301a.close();
            }
        }
    }
}
