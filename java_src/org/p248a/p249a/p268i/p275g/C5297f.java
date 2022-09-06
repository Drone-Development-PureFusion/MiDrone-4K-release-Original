package org.p248a.p249a.p268i.p275g;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.f */
/* loaded from: classes2.dex */
public class C5297f extends OutputStream {

    /* renamed from: a */
    private final SessionOutputBuffer f22270a;

    /* renamed from: b */
    private final long f22271b;

    /* renamed from: c */
    private long f22272c = 0;

    /* renamed from: d */
    private boolean f22273d = false;

    public C5297f(SessionOutputBuffer sessionOutputBuffer, long j) {
        this.f22270a = (SessionOutputBuffer) C5351a.m1321a(sessionOutputBuffer, "Session output buffer");
        this.f22271b = C5351a.m1316b(j, "Content length");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f22273d) {
            this.f22273d = true;
            this.f22270a.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f22270a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (this.f22273d) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.f22272c >= this.f22271b) {
            return;
        }
        this.f22270a.write(i);
        this.f22272c++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.f22273d) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.f22272c >= this.f22271b) {
            return;
        }
        long j = this.f22271b - this.f22272c;
        if (i2 > j) {
            i2 = (int) j;
        }
        this.f22270a.write(bArr, i, i2);
        this.f22272c += i2;
    }
}
