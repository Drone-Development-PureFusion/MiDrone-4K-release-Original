package org.p248a.p249a.p268i.p275g;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.i.g.d */
/* loaded from: classes.dex */
public class C5295d extends OutputStream {

    /* renamed from: a */
    private final SessionOutputBuffer f22260a;

    /* renamed from: b */
    private final byte[] f22261b;

    /* renamed from: c */
    private int f22262c;

    /* renamed from: d */
    private boolean f22263d;

    /* renamed from: e */
    private boolean f22264e;

    public C5295d(int i, SessionOutputBuffer sessionOutputBuffer) {
        this.f22262c = 0;
        this.f22263d = false;
        this.f22264e = false;
        this.f22261b = new byte[i];
        this.f22260a = sessionOutputBuffer;
    }

    @Deprecated
    public C5295d(SessionOutputBuffer sessionOutputBuffer) {
        this(2048, sessionOutputBuffer);
    }

    @Deprecated
    public C5295d(SessionOutputBuffer sessionOutputBuffer, int i) {
        this(i, sessionOutputBuffer);
    }

    /* renamed from: a */
    protected void m1501a() {
        if (this.f22262c > 0) {
            this.f22260a.writeLine(Integer.toHexString(this.f22262c));
            this.f22260a.write(this.f22261b, 0, this.f22262c);
            this.f22260a.writeLine("");
            this.f22262c = 0;
        }
    }

    /* renamed from: a */
    protected void m1500a(byte[] bArr, int i, int i2) {
        this.f22260a.writeLine(Integer.toHexString(this.f22262c + i2));
        this.f22260a.write(this.f22261b, 0, this.f22262c);
        this.f22260a.write(bArr, i, i2);
        this.f22260a.writeLine("");
        this.f22262c = 0;
    }

    /* renamed from: b */
    protected void m1499b() {
        this.f22260a.writeLine("0");
        this.f22260a.writeLine("");
    }

    /* renamed from: c */
    public void m1498c() {
        if (!this.f22263d) {
            m1501a();
            m1499b();
            this.f22263d = true;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f22264e) {
            this.f22264e = true;
            m1498c();
            this.f22260a.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        m1501a();
        this.f22260a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (this.f22264e) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.f22261b[this.f22262c] = (byte) i;
        this.f22262c++;
        if (this.f22262c != this.f22261b.length) {
            return;
        }
        m1501a();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.f22264e) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (i2 >= this.f22261b.length - this.f22262c) {
            m1500a(bArr, i, i2);
            return;
        }
        System.arraycopy(bArr, i, this.f22261b, this.f22262c, i2);
        this.f22262c += i2;
    }
}
