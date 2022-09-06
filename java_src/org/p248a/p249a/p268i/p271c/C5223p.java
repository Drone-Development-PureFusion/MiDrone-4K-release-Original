package org.p248a.p249a.p268i.p271c;

import java.io.IOException;
import java.io.OutputStream;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.i.c.p */
/* loaded from: classes2.dex */
class C5223p extends OutputStream {

    /* renamed from: a */
    private final OutputStream f22099a;

    /* renamed from: b */
    private final C5232u f22100b;

    public C5223p(OutputStream outputStream, C5232u c5232u) {
        this.f22099a = outputStream;
        this.f22100b = c5232u;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f22099a.close();
        } catch (IOException e) {
            this.f22100b.m1577a("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            this.f22099a.flush();
        } catch (IOException e) {
            this.f22100b.m1577a("[flush] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        try {
            this.f22100b.m1579a(i);
        } catch (IOException e) {
            this.f22100b.m1577a("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            this.f22100b.m1575a(bArr);
            this.f22099a.write(bArr);
        } catch (IOException e) {
            this.f22100b.m1577a("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        try {
            this.f22100b.m1574a(bArr, i, i2);
            this.f22099a.write(bArr, i, i2);
        } catch (IOException e) {
            this.f22100b.m1577a("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
