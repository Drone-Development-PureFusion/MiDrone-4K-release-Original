package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes.dex */
public class NativePooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private CloseableReference<NativeMemoryChunk> mBufRef;
    private int mCount;
    private final NativeMemoryChunkPool mPool;

    /* loaded from: classes.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public NativePooledByteBufferOutputStream(NativeMemoryChunkPool nativeMemoryChunkPool) {
        this(nativeMemoryChunkPool, nativeMemoryChunkPool.getMinBufferSize());
    }

    public NativePooledByteBufferOutputStream(NativeMemoryChunkPool nativeMemoryChunkPool, int i) {
        Preconditions.checkArgument(i > 0);
        this.mPool = (NativeMemoryChunkPool) Preconditions.checkNotNull(nativeMemoryChunkPool);
        this.mCount = 0;
        this.mBufRef = CloseableReference.m13748of(this.mPool.get(i), this.mPool);
    }

    private void ensureValid() {
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    @VisibleForTesting
    void realloc(int i) {
        ensureValid();
        if (i <= this.mBufRef.get().getSize()) {
            return;
        }
        NativeMemoryChunk nativeMemoryChunk = this.mPool.get(i);
        this.mBufRef.get().copy(0, nativeMemoryChunk, 0, this.mCount);
        this.mBufRef.close();
        this.mBufRef = CloseableReference.m13748of(nativeMemoryChunk, this.mPool);
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferOutputStream
    public int size() {
        return this.mCount;
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferOutputStream
    /* renamed from: toByteBuffer */
    public NativePooledByteBuffer mo21797toByteBuffer() {
        ensureValid();
        return new NativePooledByteBuffer(this.mBufRef, this.mCount);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        ensureValid();
        realloc(this.mCount + i2);
        this.mBufRef.get().write(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }
}
