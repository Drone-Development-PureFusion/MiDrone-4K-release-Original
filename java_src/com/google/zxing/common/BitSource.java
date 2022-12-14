package com.google.zxing.common;

import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int readBits(int i) {
        int i2;
        int i3;
        if (i < 1 || i > 32) {
            throw new IllegalArgumentException();
        }
        if (this.bitOffset > 0) {
            int i4 = 8 - this.bitOffset;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            int i7 = (((255 >> (8 - i5)) << i6) & this.bytes[this.byteOffset]) >> i6;
            int i8 = i - i5;
            this.bitOffset = i5 + this.bitOffset;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset++;
            }
            i2 = i7;
            i3 = i8;
        } else {
            i2 = 0;
            i3 = i;
        }
        if (i3 <= 0) {
            return i2;
        }
        while (i3 >= 8) {
            i2 = (i2 << 8) | (this.bytes[this.byteOffset] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            this.byteOffset++;
            i3 -= 8;
        }
        if (i3 <= 0) {
            return i2;
        }
        int i9 = 8 - i3;
        int i10 = (i2 << i3) | ((((255 >> i9) << i9) & this.bytes[this.byteOffset]) >> i9);
        this.bitOffset = i3 + this.bitOffset;
        return i10;
    }
}
