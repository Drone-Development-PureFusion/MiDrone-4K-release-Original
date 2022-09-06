package org.p248a.p249a.p268i.p275g;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.p */
/* loaded from: classes2.dex */
public class C5307p extends OutputStream {

    /* renamed from: a */
    private final SessionOutputBuffer f22290a;

    /* renamed from: b */
    private boolean f22291b = false;

    public C5307p(SessionOutputBuffer sessionOutputBuffer) {
        this.f22290a = (SessionOutputBuffer) C5351a.m1321a(sessionOutputBuffer, "Session output buffer");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f22291b) {
            this.f22291b = true;
            this.f22290a.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f22290a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (this.f22291b) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.f22290a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.f22291b) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.f22290a.write(bArr, i, i2);
    }
}
