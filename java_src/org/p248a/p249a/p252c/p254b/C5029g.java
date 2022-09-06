package org.p248a.p249a.p252c.p254b;

import java.io.InputStream;
import org.p248a.p249a.p250a.AbstractC5006c;
/* JADX INFO: Access modifiers changed from: package-private */
@AbstractC5006c
/* renamed from: org.a.a.c.b.g */
/* loaded from: classes2.dex */
public class C5029g extends InputStream {

    /* renamed from: a */
    private final InputStream f21531a;

    /* renamed from: b */
    private final AbstractC5022a f21532b;

    /* renamed from: c */
    private InputStream f21533c;

    public C5029g(InputStream inputStream, AbstractC5022a abstractC5022a) {
        this.f21531a = inputStream;
        this.f21532b = abstractC5022a;
    }

    /* renamed from: a */
    private void m2234a() {
        if (this.f21533c == null) {
            this.f21533c = this.f21532b.mo2235a(this.f21531a);
        }
    }

    @Override // java.io.InputStream
    public int available() {
        m2234a();
        return this.f21533c.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f21533c != null) {
                this.f21533c.close();
            }
        } finally {
            this.f21531a.close();
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        m2234a();
        return this.f21533c.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        m2234a();
        return this.f21533c.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        m2234a();
        return this.f21533c.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        m2234a();
        return this.f21533c.skip(j);
    }
}
