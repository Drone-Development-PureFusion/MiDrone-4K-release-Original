package org.codehaus.jackson.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import org.codehaus.jackson.util.BufferRecycler;
/* loaded from: classes2.dex */
public final class ByteArrayBuilder extends OutputStream {
    static final int DEFAULT_BLOCK_ARRAY_SIZE = 40;
    private static final int INITIAL_BLOCK_SIZE = 500;
    private static final int MAX_BLOCK_SIZE = 262144;
    private static final byte[] NO_BYTES = new byte[0];
    private final BufferRecycler _bufferRecycler;
    private byte[] _currBlock;
    private int _currBlockPtr;
    private final LinkedList<byte[]> _pastBlocks;
    private int _pastLen;

    public ByteArrayBuilder() {
        this((BufferRecycler) null);
    }

    public ByteArrayBuilder(int i) {
        this(null, i);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler, int i) {
        this._pastBlocks = new LinkedList<>();
        this._bufferRecycler = bufferRecycler;
        if (bufferRecycler == null) {
            this._currBlock = new byte[i];
        } else {
            this._currBlock = bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER);
        }
    }

    private void _allocMore() {
        int i = 262144;
        this._pastLen += this._currBlock.length;
        int max = Math.max(this._pastLen >> 1, 1000);
        if (max <= 262144) {
            i = max;
        }
        this._pastBlocks.add(this._currBlock);
        this._currBlock = new byte[i];
        this._currBlockPtr = 0;
    }

    public void append(int i) {
        if (this._currBlockPtr >= this._currBlock.length) {
            _allocMore();
        }
        byte[] bArr = this._currBlock;
        int i2 = this._currBlockPtr;
        this._currBlockPtr = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void appendThreeBytes(int i) {
        if (this._currBlockPtr + 2 >= this._currBlock.length) {
            append(i >> 16);
            append(i >> 8);
            append(i);
            return;
        }
        byte[] bArr = this._currBlock;
        int i2 = this._currBlockPtr;
        this._currBlockPtr = i2 + 1;
        bArr[i2] = (byte) (i >> 16);
        byte[] bArr2 = this._currBlock;
        int i3 = this._currBlockPtr;
        this._currBlockPtr = i3 + 1;
        bArr2[i3] = (byte) (i >> 8);
        byte[] bArr3 = this._currBlock;
        int i4 = this._currBlockPtr;
        this._currBlockPtr = i4 + 1;
        bArr3[i4] = (byte) i;
    }

    public void appendTwoBytes(int i) {
        if (this._currBlockPtr + 1 >= this._currBlock.length) {
            append(i >> 8);
            append(i);
            return;
        }
        byte[] bArr = this._currBlock;
        int i2 = this._currBlockPtr;
        this._currBlockPtr = i2 + 1;
        bArr[i2] = (byte) (i >> 8);
        byte[] bArr2 = this._currBlock;
        int i3 = this._currBlockPtr;
        this._currBlockPtr = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public byte[] completeAndCoalesce(int i) {
        this._currBlockPtr = i;
        return toByteArray();
    }

    public byte[] finishCurrentSegment() {
        _allocMore();
        return this._currBlock;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public byte[] getCurrentSegment() {
        return this._currBlock;
    }

    public int getCurrentSegmentLength() {
        return this._currBlockPtr;
    }

    public void release() {
        reset();
        if (this._bufferRecycler == null || this._currBlock == null) {
            return;
        }
        this._bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER, this._currBlock);
        this._currBlock = null;
    }

    public void reset() {
        this._pastLen = 0;
        this._currBlockPtr = 0;
        if (!this._pastBlocks.isEmpty()) {
            this._pastBlocks.clear();
        }
    }

    public byte[] resetAndGetFirstSegment() {
        reset();
        return this._currBlock;
    }

    public void setCurrentSegmentLength(int i) {
        this._currBlockPtr = i;
    }

    public byte[] toByteArray() {
        int i = this._pastLen + this._currBlockPtr;
        if (i == 0) {
            return NO_BYTES;
        }
        byte[] bArr = new byte[i];
        Iterator<byte[]> it2 = this._pastBlocks.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            byte[] next = it2.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this._currBlock, 0, bArr, i2, this._currBlockPtr);
        int i3 = this._currBlockPtr + i2;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this._pastBlocks.isEmpty()) {
            reset();
        }
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        append(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this._currBlock.length - this._currBlockPtr, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this._currBlock, this._currBlockPtr, min);
                i += min;
                this._currBlockPtr += min;
                i2 -= min;
            }
            if (i2 <= 0) {
                return;
            }
            _allocMore();
        }
    }
}
