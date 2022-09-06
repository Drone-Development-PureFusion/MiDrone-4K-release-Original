package org.p248a.p249a.p252c.p254b;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
/* renamed from: org.a.a.c.b.c */
/* loaded from: classes2.dex */
public class C5024c extends InputStream {

    /* renamed from: a */
    private InputStream f21518a;

    /* renamed from: org.a.a.c.b.c$a */
    /* loaded from: classes2.dex */
    static class C5025a extends InflaterInputStream {

        /* renamed from: a */
        private boolean f21519a = false;

        public C5025a(InputStream inputStream, Inflater inflater) {
            super(inputStream, inflater);
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f21519a) {
                return;
            }
            this.f21519a = true;
            this.inf.end();
            super.close();
        }
    }

    public C5024c(InputStream inputStream) {
        int inflate;
        byte[] bArr = new byte[6];
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, bArr.length);
        int read = pushbackInputStream.read(bArr);
        if (read == -1) {
            throw new IOException("Unable to read the response");
        }
        byte[] bArr2 = new byte[1];
        Inflater inflater = new Inflater();
        while (true) {
            try {
                inflate = inflater.inflate(bArr2);
                if (inflate != 0) {
                    break;
                } else if (inflater.finished()) {
                    throw new IOException("Unable to read the response");
                } else {
                    if (inflater.needsDictionary()) {
                        break;
                    } else if (inflater.needsInput()) {
                        inflater.setInput(bArr);
                    }
                }
            } catch (DataFormatException e) {
                pushbackInputStream.unread(bArr, 0, read);
                this.f21518a = new C5025a(pushbackInputStream, new Inflater(true));
                return;
            } finally {
                inflater.end();
            }
        }
        if (inflate == -1) {
            throw new IOException("Unable to read the response");
        }
        pushbackInputStream.unread(bArr, 0, read);
        this.f21518a = new C5025a(pushbackInputStream, new Inflater());
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f21518a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f21518a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f21518a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f21518a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f21518a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.f21518a.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.f21518a.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f21518a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f21518a.skip(j);
    }
}
