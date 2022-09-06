package com.tencent.stat.common;
/* renamed from: com.tencent.stat.common.e */
/* loaded from: classes2.dex */
public class C4414e {

    /* renamed from: a */
    static final byte[] f18436a = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();

    /* renamed from: a */
    public static byte[] m5226a(byte[] bArr) {
        return m5225a(bArr, f18436a);
    }

    /* renamed from: a */
    static byte[] m5225a(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length < 1 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        for (int i = 0; i < 256; i++) {
            iArr[i] = i;
            iArr2[i] = bArr2[i % length];
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + iArr[i3] + iArr2[i3]) & 255;
            int i4 = iArr[i3];
            iArr[i3] = iArr[i2];
            iArr[i2] = i4;
        }
        byte[] bArr3 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i6 = (i6 + 1) & 255;
            i5 = (i5 + iArr[i6]) & 255;
            int i8 = iArr[i6];
            iArr[i6] = iArr[i5];
            iArr[i5] = i8;
            bArr3[i7] = (byte) (iArr[(iArr[i6] + iArr[i5]) & 255] ^ bArr[i7]);
        }
        return bArr3;
    }

    /* renamed from: b */
    public static byte[] m5224b(byte[] bArr) {
        return m5223b(bArr, f18436a);
    }

    /* renamed from: b */
    static byte[] m5223b(byte[] bArr, byte[] bArr2) {
        return m5225a(bArr, bArr2);
    }
}
