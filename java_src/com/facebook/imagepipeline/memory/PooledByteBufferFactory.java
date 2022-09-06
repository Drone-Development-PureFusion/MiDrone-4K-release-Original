package com.facebook.imagepipeline.memory;

import java.io.InputStream;
/* loaded from: classes.dex */
public interface PooledByteBufferFactory {
    /* renamed from: newByteBuffer */
    PooledByteBuffer mo21791newByteBuffer(int i);

    /* renamed from: newByteBuffer */
    PooledByteBuffer mo21792newByteBuffer(InputStream inputStream);

    /* renamed from: newByteBuffer */
    PooledByteBuffer mo21793newByteBuffer(InputStream inputStream, int i);

    /* renamed from: newByteBuffer */
    PooledByteBuffer mo21794newByteBuffer(byte[] bArr);

    /* renamed from: newOutputStream */
    PooledByteBufferOutputStream mo21795newOutputStream();

    /* renamed from: newOutputStream */
    PooledByteBufferOutputStream mo21796newOutputStream(int i);
}
