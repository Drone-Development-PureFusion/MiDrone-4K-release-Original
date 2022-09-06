package com.facebook.binaryresource;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class ByteArrayBinaryResource implements BinaryResource {
    private final byte[] mBytes;

    public ByteArrayBinaryResource(byte[] bArr) {
        this.mBytes = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() {
        return new ByteArrayInputStream(this.mBytes);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] read() {
        return this.mBytes;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.mBytes.length;
    }
}
