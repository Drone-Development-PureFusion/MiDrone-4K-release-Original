package com.amap.api.services.core;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* renamed from: com.amap.api.services.core.bo */
/* loaded from: classes.dex */
public class C1219bo implements Closeable {

    /* renamed from: a */
    private final InputStream f4127a;

    /* renamed from: b */
    private final Charset f4128b;

    /* renamed from: c */
    private byte[] f4129c;

    /* renamed from: d */
    private int f4130d;

    /* renamed from: e */
    private int f4131e;

    public C1219bo(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(C1221bp.f4133a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4127a = inputStream;
        this.f4128b = charset;
        this.f4129c = new byte[i];
    }

    public C1219bo(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: b */
    private void m17072b() {
        int read = this.f4127a.read(this.f4129c, 0, this.f4129c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f4130d = 0;
        this.f4131e = read;
    }

    /* renamed from: a */
    public String m17074a() {
        int i;
        String byteArrayOutputStream;
        synchronized (this.f4127a) {
            if (this.f4129c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f4130d >= this.f4131e) {
                m17072b();
            }
            int i2 = this.f4130d;
            while (true) {
                if (i2 == this.f4131e) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((this.f4131e - this.f4130d) + 80) { // from class: com.amap.api.services.core.bo.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, C1219bo.this.f4128b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream2.write(this.f4129c, this.f4130d, this.f4131e - this.f4130d);
                        this.f4131e = -1;
                        m17072b();
                        i = this.f4130d;
                        while (i != this.f4131e) {
                            if (this.f4129c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.f4130d) {
                        byteArrayOutputStream2.write(this.f4129c, this.f4130d, i - this.f4130d);
                    }
                    this.f4130d = i + 1;
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                } else if (this.f4129c[i2] == 10) {
                    byteArrayOutputStream = new String(this.f4129c, this.f4130d, ((i2 == this.f4130d || this.f4129c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.f4130d, this.f4128b.name());
                    this.f4130d = i2 + 1;
                } else {
                    i2++;
                }
            }
            return byteArrayOutputStream;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f4127a) {
            if (this.f4129c != null) {
                this.f4129c = null;
                this.f4127a.close();
            }
        }
    }
}
