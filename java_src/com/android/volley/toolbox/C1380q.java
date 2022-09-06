package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
/* renamed from: com.android.volley.toolbox.q */
/* loaded from: classes.dex */
public class C1380q extends ByteArrayOutputStream {

    /* renamed from: a */
    private static final int f4707a = 256;

    /* renamed from: b */
    private final C1353d f4708b;

    public C1380q(C1353d c1353d) {
        this(c1353d, 256);
    }

    public C1380q(C1353d c1353d, int i) {
        this.f4708b = c1353d;
        this.buf = this.f4708b.m16664a(Math.max(i, 256));
    }

    /* renamed from: a */
    private void m16580a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] m16664a = this.f4708b.m16664a((this.count + i) * 2);
        System.arraycopy(this.buf, 0, m16664a, 0, this.count);
        this.f4708b.m16663a(this.buf);
        this.buf = m16664a;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4708b.m16663a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f4708b.m16663a(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        m16580a(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        m16580a(i2);
        super.write(bArr, i, i2);
    }
}
