package com.mob.tools.network;

import java.io.InputStream;
/* loaded from: classes.dex */
public class ByteCounterInputStream extends InputStream {

    /* renamed from: is */
    private InputStream f17338is;
    private OnReadListener listener;
    private long readBytes;

    public ByteCounterInputStream(InputStream inputStream) {
        this.f17338is = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f17338is.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f17338is.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f17338is.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f17338is.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        int read = this.f17338is.read();
        if (read >= 0) {
            this.readBytes++;
            if (this.listener != null) {
                this.listener.onRead(this.readBytes);
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = this.f17338is.read(bArr, i, i2);
        if (read > 0) {
            this.readBytes += read;
            if (this.listener != null) {
                this.listener.onRead(this.readBytes);
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f17338is.reset();
        this.readBytes = 0L;
    }

    public void setOnInputStreamReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f17338is.skip(j);
    }
}
