package org.codehaus.jackson.p316io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
/* renamed from: org.codehaus.jackson.io.UTF8Writer */
/* loaded from: classes2.dex */
public final class UTF8Writer extends Writer {
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    protected final IOContext _context;
    OutputStream _out;
    byte[] _outBuffer;
    final int _outBufferEnd;
    int _surrogate = 0;
    int _outPtr = 0;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this._context = iOContext;
        this._out = outputStream;
        this._outBuffer = iOContext.allocWriteEncodingBuffer();
        this._outBufferEnd = this._outBuffer.length - 4;
    }

    private int convertSurrogate(int i) {
        int i2 = this._surrogate;
        this._surrogate = 0;
        if (i < SURR2_FIRST || i > SURR2_LAST) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
        }
        return ((i2 - SURR1_FIRST) << 10) + 65536 + (i - SURR2_FIRST);
    }

    private void throwIllegal(int i) {
        if (i > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i < SURR1_FIRST) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i > SURR1_LAST) {
            throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append */
    public Writer mo21886append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this._out != null) {
            if (this._outPtr > 0) {
                this._out.write(this._outBuffer, 0, this._outPtr);
                this._outPtr = 0;
            }
            OutputStream outputStream = this._out;
            this._out = null;
            byte[] bArr = this._outBuffer;
            if (bArr != null) {
                this._outBuffer = null;
                this._context.releaseWriteEncodingBuffer(bArr);
            }
            outputStream.close();
            int i = this._surrogate;
            this._surrogate = 0;
            if (i <= 0) {
                return;
            }
            throwIllegal(i);
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        if (this._out != null) {
            if (this._outPtr > 0) {
                this._out.write(this._outBuffer, 0, this._outPtr);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2;
        if (this._surrogate > 0) {
            i = convertSurrogate(i);
        } else if (i >= SURR1_FIRST && i <= SURR2_LAST) {
            if (i > SURR1_LAST) {
                throwIllegal(i);
            }
            this._surrogate = i;
            return;
        }
        if (this._outPtr >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, this._outPtr);
            this._outPtr = 0;
        }
        if (i < 128) {
            byte[] bArr = this._outBuffer;
            int i3 = this._outPtr;
            this._outPtr = i3 + 1;
            bArr[i3] = (byte) i;
            return;
        }
        int i4 = this._outPtr;
        if (i < 2048) {
            int i5 = i4 + 1;
            this._outBuffer[i4] = (byte) ((i >> 6) | 192);
            i2 = i5 + 1;
            this._outBuffer[i5] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            int i6 = i4 + 1;
            this._outBuffer[i4] = (byte) ((i >> 12) | 224);
            int i7 = i6 + 1;
            this._outBuffer[i6] = (byte) (((i >> 6) & 63) | 128);
            i2 = i7 + 1;
            this._outBuffer[i7] = (byte) ((i & 63) | 128);
        } else {
            if (i > 1114111) {
                throwIllegal(i);
            }
            int i8 = i4 + 1;
            this._outBuffer[i4] = (byte) ((i >> 18) | 240);
            int i9 = i8 + 1;
            this._outBuffer[i8] = (byte) (((i >> 12) & 63) | 128);
            int i10 = i9 + 1;
            this._outBuffer[i9] = (byte) (((i >> 6) & 63) | 128);
            i2 = i10 + 1;
            this._outBuffer[i10] = (byte) ((i & 63) | 128);
        }
        this._outPtr = i2;
    }

    @Override // java.io.Writer
    public void write(String str) {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        char c;
        if (i2 < 2) {
            if (i2 != 1) {
                return;
            }
            write(str.charAt(i));
            return;
        }
        if (this._surrogate > 0) {
            i2--;
            write(convertSurrogate(str.charAt(i)));
            i++;
        }
        int i3 = this._outPtr;
        byte[] bArr = this._outBuffer;
        int i4 = this._outBufferEnd;
        int i5 = i2 + i;
        int i6 = i;
        while (i6 < i5) {
            if (i3 >= i4) {
                this._out.write(bArr, 0, i3);
                i3 = 0;
            }
            int i7 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt < 128) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) charAt;
                int i9 = i5 - i7;
                int i10 = i4 - i8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int i11 = i10 + i7;
                int i12 = i8;
                int i13 = i7;
                while (i13 < i11) {
                    int i14 = i13 + 1;
                    char charAt2 = str.charAt(i13);
                    if (charAt2 >= 128) {
                        i3 = i12;
                        i6 = i14;
                        c = charAt2;
                    } else {
                        bArr[i12] = (byte) charAt2;
                        i12++;
                        i13 = i14;
                    }
                }
                int i15 = i12;
                i6 = i13;
                i3 = i15;
            } else {
                i6 = i7;
                c = charAt;
            }
            if (c < 2048) {
                int i16 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((c & '?') | 128);
            } else if (c < SURR1_FIRST || c > SURR2_LAST) {
                int i17 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((c >> 6) & 63) | 128);
                i3 = i18 + 1;
                bArr[i18] = (byte) ((c & '?') | 128);
            } else {
                if (c > SURR1_LAST) {
                    this._outPtr = i3;
                    throwIllegal(c);
                }
                this._surrogate = c;
                if (i6 >= i5) {
                    break;
                }
                int i19 = i6 + 1;
                int convertSurrogate = convertSurrogate(str.charAt(i6));
                if (convertSurrogate > 1114111) {
                    this._outPtr = i3;
                    throwIllegal(convertSurrogate);
                }
                int i20 = i3 + 1;
                bArr[i3] = (byte) ((convertSurrogate >> 18) | 240);
                int i21 = i20 + 1;
                bArr[i20] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                i3 = i22 + 1;
                bArr[i22] = (byte) ((convertSurrogate & 63) | 128);
                i6 = i19;
            }
        }
        this._outPtr = i3;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        char c;
        if (i2 < 2) {
            if (i2 != 1) {
                return;
            }
            write(cArr[i]);
            return;
        }
        if (this._surrogate > 0) {
            i2--;
            write(convertSurrogate(cArr[i]));
            i++;
        }
        int i3 = this._outPtr;
        byte[] bArr = this._outBuffer;
        int i4 = this._outBufferEnd;
        int i5 = i2 + i;
        int i6 = i;
        while (i6 < i5) {
            if (i3 >= i4) {
                this._out.write(bArr, 0, i3);
                i3 = 0;
            }
            int i7 = i6 + 1;
            char c2 = cArr[i6];
            if (c2 < 128) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) c2;
                int i9 = i5 - i7;
                int i10 = i4 - i8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int i11 = i10 + i7;
                int i12 = i8;
                int i13 = i7;
                while (i13 < i11) {
                    int i14 = i13 + 1;
                    char c3 = cArr[i13];
                    if (c3 >= 128) {
                        i3 = i12;
                        i6 = i14;
                        c = c3;
                    } else {
                        bArr[i12] = (byte) c3;
                        i12++;
                        i13 = i14;
                    }
                }
                int i15 = i12;
                i6 = i13;
                i3 = i15;
            } else {
                i6 = i7;
                c = c2;
            }
            if (c < 2048) {
                int i16 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((c & '?') | 128);
            } else if (c < SURR1_FIRST || c > SURR2_LAST) {
                int i17 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((c >> 6) & 63) | 128);
                i3 = i18 + 1;
                bArr[i18] = (byte) ((c & '?') | 128);
            } else {
                if (c > SURR1_LAST) {
                    this._outPtr = i3;
                    throwIllegal(c);
                }
                this._surrogate = c;
                if (i6 >= i5) {
                    break;
                }
                int i19 = i6 + 1;
                int convertSurrogate = convertSurrogate(cArr[i6]);
                if (convertSurrogate > 1114111) {
                    this._outPtr = i3;
                    throwIllegal(convertSurrogate);
                }
                int i20 = i3 + 1;
                bArr[i3] = (byte) ((convertSurrogate >> 18) | 240);
                int i21 = i20 + 1;
                bArr[i20] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                i3 = i22 + 1;
                bArr[i22] = (byte) ((convertSurrogate & 63) | 128);
                i6 = i19;
            }
        }
        this._outPtr = i3;
    }
}
