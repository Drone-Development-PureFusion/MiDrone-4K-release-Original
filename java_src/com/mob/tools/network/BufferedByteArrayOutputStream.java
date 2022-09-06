package com.mob.tools.network;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class BufferedByteArrayOutputStream extends ByteArrayOutputStream {
    public BufferedByteArrayOutputStream() {
    }

    public BufferedByteArrayOutputStream(int i) {
        super(i);
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public int getBufferSize() {
        return this.buf.length;
    }

    public boolean switchBuffer(byte[] bArr) {
        if (bArr == null || bArr.length != this.buf.length) {
            return false;
        }
        byte[] bArr2 = this.buf;
        this.buf = bArr;
        return true;
    }

    public void write(ByteBuffer byteBuffer) {
        write(byteBuffer, byteBuffer.limit());
    }

    public void write(ByteBuffer byteBuffer, int i) {
        if (this.buf.length - this.count >= i) {
            byteBuffer.get(this.buf, this.count, i);
            this.count += i;
            return;
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        write(bArr);
    }
}
