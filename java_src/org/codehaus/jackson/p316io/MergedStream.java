package org.codehaus.jackson.p316io;

import java.io.InputStream;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: org.codehaus.jackson.io.MergedStream */
/* loaded from: classes2.dex */
public final class MergedStream extends InputStream {
    byte[] _buffer;
    protected final IOContext _context;
    final int _end;
    final InputStream _in;
    int _ptr;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._end = i2;
    }

    private void freeMergedBuffer() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            if (this._context == null) {
                return;
            }
            this._context.releaseReadIOBuffer(bArr);
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this._buffer != null ? this._end - this._ptr : this._in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        freeMergedBuffer();
        this._in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this._buffer == null) {
            this._in.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this._buffer == null && this._in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this._buffer != null) {
            byte[] bArr = this._buffer;
            int i = this._ptr;
            this._ptr = i + 1;
            int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (this._ptr < this._end) {
                return i2;
            }
            freeMergedBuffer();
            return i2;
        }
        return this._in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this._buffer != null) {
            int i3 = this._end - this._ptr;
            if (i2 > i3) {
                i2 = i3;
            }
            System.arraycopy(this._buffer, this._ptr, bArr, i, i2);
            this._ptr += i2;
            if (this._ptr < this._end) {
                return i2;
            }
            freeMergedBuffer();
            return i2;
        }
        return this._in.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() {
        if (this._buffer == null) {
            this._in.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long j2;
        if (this._buffer != null) {
            int i = this._end - this._ptr;
            if (i > j) {
                this._ptr += (int) j;
                return j;
            }
            freeMergedBuffer();
            j2 = i + 0;
            j -= i;
        } else {
            j2 = 0;
        }
        if (j > 0) {
            j2 += this._in.skip(j);
        }
        return j2;
    }
}
