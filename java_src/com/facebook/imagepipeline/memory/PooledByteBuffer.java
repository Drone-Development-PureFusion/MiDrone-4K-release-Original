package com.facebook.imagepipeline.memory;

import java.io.Closeable;
/* loaded from: classes.dex */
public interface PooledByteBuffer extends Closeable {

    /* loaded from: classes.dex */
    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long getNativePtr();

    boolean isClosed();

    byte read(int i);

    void read(int i, byte[] bArr, int i2, int i3);

    int size();
}
