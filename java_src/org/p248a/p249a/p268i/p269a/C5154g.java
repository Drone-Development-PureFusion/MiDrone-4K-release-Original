package org.p248a.p249a.p268i.p269a;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
/* renamed from: org.a.a.i.a.g */
/* loaded from: classes2.dex */
class C5154g extends OutputStream {

    /* renamed from: a */
    private final MessageDigest f21835a;

    /* renamed from: b */
    private boolean f21836b;

    /* renamed from: c */
    private byte[] f21837c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5154g(MessageDigest messageDigest) {
        this.f21835a = messageDigest;
        this.f21835a.reset();
    }

    /* renamed from: a */
    public byte[] m1904a() {
        return this.f21837c;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f21836b) {
            return;
        }
        this.f21836b = true;
        this.f21837c = this.f21835a.digest();
        super.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (this.f21836b) {
            throw new IOException("Stream has been already closed");
        }
        this.f21835a.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.f21836b) {
            throw new IOException("Stream has been already closed");
        }
        this.f21835a.update(bArr, i, i2);
    }
}
