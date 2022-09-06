package com.p080b;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* renamed from: com.b.ak */
/* loaded from: classes.dex */
public class C1419ak implements Closeable {

    /* renamed from: a */
    private final InputStream f4881a;

    /* renamed from: b */
    private final Charset f4882b;

    /* renamed from: c */
    private byte[] f4883c;

    /* renamed from: d */
    private int f4884d;

    /* renamed from: e */
    private int f4885e;

    public C1419ak(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(C1421al.f4887a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4881a = inputStream;
        this.f4882b = charset;
        this.f4883c = new byte[i];
    }

    public C1419ak(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: b */
    private void m16348b() {
        int read = this.f4881a.read(this.f4883c, 0, this.f4883c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f4884d = 0;
        this.f4885e = read;
    }

    /* renamed from: a */
    public String m16350a() {
        int i;
        String byteArrayOutputStream;
        synchronized (this.f4881a) {
            if (this.f4883c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f4884d >= this.f4885e) {
                m16348b();
            }
            int i2 = this.f4884d;
            while (true) {
                if (i2 == this.f4885e) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((this.f4885e - this.f4884d) + 80) { // from class: com.b.ak.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, C1419ak.this.f4882b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream2.write(this.f4883c, this.f4884d, this.f4885e - this.f4884d);
                        this.f4885e = -1;
                        m16348b();
                        i = this.f4884d;
                        while (i != this.f4885e) {
                            if (this.f4883c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.f4884d) {
                        byteArrayOutputStream2.write(this.f4883c, this.f4884d, i - this.f4884d);
                    }
                    this.f4884d = i + 1;
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                } else if (this.f4883c[i2] == 10) {
                    byteArrayOutputStream = new String(this.f4883c, this.f4884d, ((i2 == this.f4884d || this.f4883c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.f4884d, this.f4882b.name());
                    this.f4884d = i2 + 1;
                } else {
                    i2++;
                }
            }
            return byteArrayOutputStream;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f4881a) {
            if (this.f4883c != null) {
                this.f4883c = null;
                this.f4881a.close();
            }
        }
    }
}
