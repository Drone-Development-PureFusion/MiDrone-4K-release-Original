package org.codehaus.jackson.org.objectweb.asm;
/* loaded from: classes2.dex */
public class ByteVector {

    /* renamed from: a */
    byte[] f22817a;

    /* renamed from: b */
    int f22818b;

    public ByteVector() {
        this.f22817a = new byte[64];
    }

    public ByteVector(int i) {
        this.f22817a = new byte[i];
    }

    /* renamed from: a */
    private void m269a(int i) {
        int length = this.f22817a.length * 2;
        int i2 = this.f22818b + i;
        if (length <= i2) {
            length = i2;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.f22817a, 0, bArr, 0, this.f22818b);
        this.f22817a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public ByteVector m268a(int i, int i2) {
        int i3 = this.f22818b;
        if (i3 + 2 > this.f22817a.length) {
            m269a(2);
        }
        byte[] bArr = this.f22817a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        bArr[i4] = (byte) i2;
        this.f22818b = i4 + 1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public ByteVector m267b(int i, int i2) {
        int i3 = this.f22818b;
        if (i3 + 3 > this.f22817a.length) {
            m269a(3);
        }
        byte[] bArr = this.f22817a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) i2;
        this.f22818b = i5 + 1;
        return this;
    }

    public ByteVector putByte(int i) {
        int i2 = this.f22818b;
        if (i2 + 1 > this.f22817a.length) {
            m269a(1);
        }
        this.f22817a[i2] = (byte) i;
        this.f22818b = i2 + 1;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i, int i2) {
        if (this.f22818b + i2 > this.f22817a.length) {
            m269a(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.f22817a, this.f22818b, i2);
        }
        this.f22818b += i2;
        return this;
    }

    public ByteVector putInt(int i) {
        int i2 = this.f22818b;
        if (i2 + 4 > this.f22817a.length) {
            m269a(4);
        }
        byte[] bArr = this.f22817a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        this.f22818b = i5 + 1;
        return this;
    }

    public ByteVector putLong(long j) {
        int i = this.f22818b;
        if (i + 8 > this.f22817a.length) {
            m269a(8);
        }
        byte[] bArr = this.f22817a;
        int i2 = (int) (j >>> 32);
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = (int) j;
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >>> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 8);
        bArr[i10] = (byte) i7;
        this.f22818b = i10 + 1;
        return this;
    }

    public ByteVector putShort(int i) {
        int i2 = this.f22818b;
        if (i2 + 2 > this.f22817a.length) {
            m269a(2);
        }
        byte[] bArr = this.f22817a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        this.f22818b = i3 + 1;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int i;
        byte[] bArr;
        int i2;
        int length = str.length();
        int i3 = this.f22818b;
        if (i3 + 2 + length > this.f22817a.length) {
            m269a(length + 2);
        }
        byte[] bArr2 = this.f22817a;
        int i4 = i3 + 1;
        bArr2[i3] = (byte) (length >>> 8);
        int i5 = i4 + 1;
        bArr2[i4] = (byte) length;
        int i6 = 0;
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt < 1 || charAt > 127) {
                int i7 = i6;
                for (int i8 = i6; i8 < length; i8++) {
                    char charAt2 = str.charAt(i8);
                    i7 = (charAt2 < 1 || charAt2 > 127) ? charAt2 > 2047 ? i7 + 3 : i7 + 2 : i7 + 1;
                }
                bArr2[this.f22818b] = (byte) (i7 >>> 8);
                bArr2[this.f22818b + 1] = (byte) i7;
                if (this.f22818b + 2 + i7 > bArr2.length) {
                    this.f22818b = i5;
                    m269a(i7 + 2);
                    bArr = this.f22817a;
                } else {
                    bArr = bArr2;
                }
                while (i6 < length) {
                    char charAt3 = str.charAt(i6);
                    if (charAt3 >= 1 && charAt3 <= 127) {
                        i2 = i5 + 1;
                        bArr[i5] = (byte) charAt3;
                    } else if (charAt3 > 2047) {
                        int i9 = i5 + 1;
                        bArr[i5] = (byte) (((charAt3 >> '\f') & 15) | 224);
                        int i10 = i9 + 1;
                        bArr[i9] = (byte) (((charAt3 >> 6) & 63) | 128);
                        i2 = i10 + 1;
                        bArr[i10] = (byte) ((charAt3 & '?') | 128);
                    } else {
                        int i11 = i5 + 1;
                        bArr[i5] = (byte) (((charAt3 >> 6) & 31) | 192);
                        i2 = i11 + 1;
                        bArr[i11] = (byte) ((charAt3 & '?') | 128);
                    }
                    i6++;
                    i5 = i2;
                }
                i = i5;
                this.f22818b = i;
                return this;
            }
            bArr2[i5] = (byte) charAt;
            i6++;
            i5++;
        }
        i = i5;
        this.f22818b = i;
        return this;
    }
}
