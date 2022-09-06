package com.p118d.p119a.p127b.p128a;

import java.io.InputStream;
/* renamed from: com.d.a.b.a.a */
/* loaded from: classes.dex */
public class C1879a extends InputStream {

    /* renamed from: a */
    private final InputStream f6636a;

    /* renamed from: b */
    private final int f6637b;

    public C1879a(InputStream inputStream, int i) {
        this.f6636a = inputStream;
        this.f6637b = i;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f6637b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6636a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f6636a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f6636a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f6636a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.f6636a.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.f6636a.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f6636a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f6636a.skip(j);
    }
}
