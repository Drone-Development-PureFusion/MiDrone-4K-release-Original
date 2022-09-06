package org.p248a.p249a.p268i.p271c;

import java.io.IOException;
import java.io.InputStream;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.i.c.n */
/* loaded from: classes2.dex */
class C5221n extends InputStream {

    /* renamed from: a */
    private final InputStream f22094a;

    /* renamed from: b */
    private final C5232u f22095b;

    public C5221n(InputStream inputStream, C5232u c5232u) {
        this.f22094a = inputStream;
        this.f22095b = c5232u;
    }

    @Override // java.io.InputStream
    public int available() {
        try {
            return this.f22094a.available();
        } catch (IOException e) {
            this.f22095b.m1571b("[available] I/O error : " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f22094a.close();
        } catch (IOException e) {
            this.f22095b.m1571b("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        super.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            int read = this.f22094a.read();
            if (read == -1) {
                this.f22095b.m1571b("end of stream");
            } else {
                this.f22095b.m1573b(read);
            }
            return read;
        } catch (IOException e) {
            this.f22095b.m1571b("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            int read = this.f22094a.read(bArr);
            if (read == -1) {
                this.f22095b.m1571b("end of stream");
            } else if (read > 0) {
                this.f22095b.m1569b(bArr, 0, read);
            }
            return read;
        } catch (IOException e) {
            this.f22095b.m1571b("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            int read = this.f22094a.read(bArr, i, i2);
            if (read == -1) {
                this.f22095b.m1571b("end of stream");
            } else if (read > 0) {
                this.f22095b.m1569b(bArr, i, read);
            }
            return read;
        } catch (IOException e) {
            this.f22095b.m1571b("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void reset() {
        super.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return super.skip(j);
        } catch (IOException e) {
            this.f22095b.m1571b("[skip] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
