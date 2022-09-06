package com.p118d.p119a.p120a.p121a.p122a.p123a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* renamed from: com.d.a.a.a.a.a.c */
/* loaded from: classes.dex */
class C1858c implements Closeable {

    /* renamed from: a */
    private static final byte f6597a = 13;

    /* renamed from: b */
    private static final byte f6598b = 10;

    /* renamed from: c */
    private final InputStream f6599c;

    /* renamed from: d */
    private final Charset f6600d;

    /* renamed from: e */
    private byte[] f6601e;

    /* renamed from: f */
    private int f6602f;

    /* renamed from: g */
    private int f6603g;

    public C1858c(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(C1860d.f6605a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f6599c = inputStream;
        this.f6600d = charset;
        this.f6601e = new byte[i];
    }

    public C1858c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: b */
    private void m14225b() {
        int read = this.f6599c.read(this.f6601e, 0, this.f6601e.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f6602f = 0;
        this.f6603g = read;
    }

    /* renamed from: a */
    public String m14227a() {
        int i;
        String byteArrayOutputStream;
        synchronized (this.f6599c) {
            if (this.f6601e == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f6602f >= this.f6603g) {
                m14225b();
            }
            int i2 = this.f6602f;
            while (true) {
                if (i2 == this.f6603g) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((this.f6603g - this.f6602f) + 80) { // from class: com.d.a.a.a.a.a.c.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, C1858c.this.f6600d.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream2.write(this.f6601e, this.f6602f, this.f6603g - this.f6602f);
                        this.f6603g = -1;
                        m14225b();
                        i = this.f6602f;
                        while (i != this.f6603g) {
                            if (this.f6601e[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.f6602f) {
                        byteArrayOutputStream2.write(this.f6601e, this.f6602f, i - this.f6602f);
                    }
                    this.f6602f = i + 1;
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                } else if (this.f6601e[i2] == 10) {
                    byteArrayOutputStream = new String(this.f6601e, this.f6602f, ((i2 == this.f6602f || this.f6601e[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.f6602f, this.f6600d.name());
                    this.f6602f = i2 + 1;
                } else {
                    i2++;
                }
            }
            return byteArrayOutputStream;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f6599c) {
            if (this.f6601e != null) {
                this.f6601e = null;
                this.f6599c.close();
            }
        }
    }
}
