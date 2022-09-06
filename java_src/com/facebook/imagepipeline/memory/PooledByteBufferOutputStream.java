package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public abstract class PooledByteBufferOutputStream extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            Throwables.propagate(e);
        }
    }

    public abstract int size();

    /* renamed from: toByteBuffer */
    public abstract PooledByteBuffer mo21797toByteBuffer();
}
