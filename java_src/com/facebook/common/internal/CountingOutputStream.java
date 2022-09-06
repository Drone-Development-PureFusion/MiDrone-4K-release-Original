package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class CountingOutputStream extends FilterOutputStream {
    private long mCount = 0;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    public long getCount() {
        return this.mCount;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        this.out.write(i);
        this.mCount++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.mCount += i2;
    }
}
