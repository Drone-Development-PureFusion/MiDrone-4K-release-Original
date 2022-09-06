package com.tencent.p227mm.algorithm;

import java.util.Arrays;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p249a.p261f.p264c.C5122l;
/* renamed from: com.tencent.mm.algorithm.Base64 */
/* loaded from: classes.dex */
public class Base64 {

    /* renamed from: a */
    private static final char[] f17740a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* renamed from: b */
    private static final int[] f17741b;

    static {
        int[] iArr = new int[256];
        f17741b = iArr;
        Arrays.fill(iArr, -1);
        int length = f17740a.length;
        for (int i = 0; i < length; i++) {
            f17741b[f17740a[i]] = i;
        }
        f17741b[61] = 0;
    }

    public static final byte[] decode(String str) {
        int length = str != null ? str.length() : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (f17741b[str.charAt(i2)] < 0) {
                i++;
            }
        }
        if ((length - i) % 4 != 0) {
            return null;
        }
        int i3 = length;
        int i4 = 0;
        while (i3 > 1) {
            i3--;
            if (f17741b[str.charAt(i3)] > 0) {
                break;
            } else if (str.charAt(i3) == '=') {
                i4++;
            }
        }
        int i5 = (((length - i) * 6) >> 3) - i4;
        byte[] bArr = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = 0;
            int i9 = i7;
            int i10 = 0;
            while (i10 < 4) {
                int i11 = i9 + 1;
                int i12 = f17741b[str.charAt(i9)];
                if (i12 >= 0) {
                    i8 |= i12 << (18 - (i10 * 6));
                } else {
                    i10--;
                }
                i10++;
                i9 = i11;
            }
            int i13 = i6 + 1;
            bArr[i6] = (byte) (i8 >> 16);
            if (i13 < i5) {
                int i14 = i13 + 1;
                bArr[i13] = (byte) (i8 >> 8);
                if (i14 < i5) {
                    i13 = i14 + 1;
                    bArr[i14] = (byte) i8;
                } else {
                    i13 = i14;
                }
            }
            i6 = i13;
            i7 = i9;
        }
        return bArr;
    }

    public static final byte[] decode(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        for (byte b : bArr) {
            if (f17741b[b & SmileConstants.BYTE_MARKER_END_OF_CONTENT] < 0) {
                i++;
            }
        }
        if ((length - i) % 4 != 0) {
            return null;
        }
        int i2 = length;
        int i3 = 0;
        while (i2 > 1) {
            i2--;
            if (f17741b[bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT] > 0) {
                break;
            } else if (bArr[i2] == 61) {
                i3++;
            }
        }
        int i4 = (((length - i) * 6) >> 3) - i3;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = 0;
            int i8 = i6;
            int i9 = 0;
            while (i9 < 4) {
                int i10 = i8 + 1;
                int i11 = f17741b[bArr[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT];
                if (i11 >= 0) {
                    i7 |= i11 << (18 - (i9 * 6));
                } else {
                    i9--;
                }
                i9++;
                i8 = i10;
            }
            int i12 = i5 + 1;
            bArr2[i5] = (byte) (i7 >> 16);
            if (i12 < i4) {
                int i13 = i12 + 1;
                bArr2[i12] = (byte) (i7 >> 8);
                if (i13 < i4) {
                    i12 = i13 + 1;
                    bArr2[i13] = (byte) i7;
                } else {
                    i12 = i13;
                }
            }
            i5 = i12;
            i6 = i8;
        }
        return bArr2;
    }

    public static final byte[] decode(char[] cArr) {
        int length = cArr != null ? cArr.length : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (f17741b[cArr[i2]] < 0) {
                i++;
            }
        }
        if ((length - i) % 4 != 0) {
            return null;
        }
        int i3 = length;
        int i4 = 0;
        while (i3 > 1) {
            i3--;
            if (f17741b[cArr[i3]] > 0) {
                break;
            } else if (cArr[i3] == '=') {
                i4++;
            }
        }
        int i5 = (((length - i) * 6) >> 3) - i4;
        byte[] bArr = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = 0;
            int i9 = i7;
            int i10 = 0;
            while (i10 < 4) {
                int i11 = i9 + 1;
                int i12 = f17741b[cArr[i9]];
                if (i12 >= 0) {
                    i8 |= i12 << (18 - (i10 * 6));
                } else {
                    i10--;
                }
                i10++;
                i9 = i11;
            }
            int i13 = i6 + 1;
            bArr[i6] = (byte) (i8 >> 16);
            if (i13 < i5) {
                int i14 = i13 + 1;
                bArr[i13] = (byte) (i8 >> 8);
                if (i14 < i5) {
                    i13 = i14 + 1;
                    bArr[i14] = (byte) i8;
                } else {
                    i13 = i14;
                }
            }
            i6 = i13;
            i7 = i9;
        }
        return bArr;
    }

    public static final byte[] decodeFast(String str) {
        int i = 0;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && f17741b[str.charAt(i3) & 255] < 0) {
            i3++;
        }
        int i4 = i2;
        while (i4 > 0 && f17741b[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        int i5 = str.charAt(i4) == '=' ? str.charAt(i4 + (-1)) == '=' ? 2 : 1 : 0;
        int i6 = (i4 - i3) + 1;
        int i7 = length > 76 ? (str.charAt(76) == '\r' ? i6 / 78 : 0) << 1 : 0;
        int i8 = (((i6 - i7) * 6) >> 3) - i5;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i11 < i9) {
            int i12 = i3 + 1;
            int i13 = i12 + 1;
            int i14 = (f17741b[str.charAt(i3)] << 18) | (f17741b[str.charAt(i12)] << 12);
            int i15 = i13 + 1;
            int i16 = (f17741b[str.charAt(i13)] << 6) | i14;
            i3 = i15 + 1;
            int i17 = i16 | f17741b[str.charAt(i15)];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            i11 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i7 > 0 && (i10 = i10 + 1) == 19) {
                i3 += 2;
                i10 = 0;
            }
        }
        if (i11 < i8) {
            int i20 = 0;
            for (int i21 = i3; i21 <= i4 - i5; i21++) {
                i++;
                i20 = (f17741b[str.charAt(i21)] << (18 - (i * 6))) | i20;
            }
            int i22 = 16;
            for (int i23 = i11; i23 < i8; i23++) {
                bArr[i23] = (byte) (i20 >> i22);
                i22 -= 8;
            }
        }
        return bArr;
    }

    public static final byte[] decodeFast(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && f17741b[bArr[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT] < 0) {
            i3++;
        }
        int i4 = i2;
        while (i4 > 0 && f17741b[bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT] < 0) {
            i4--;
        }
        int i5 = bArr[i4] == 61 ? bArr[i4 + (-1)] == 61 ? 2 : 1 : 0;
        int i6 = (i4 - i3) + 1;
        int i7 = length > 76 ? (bArr[76] == 13 ? i6 / 78 : 0) << 1 : 0;
        int i8 = (((i6 - i7) * 6) >> 3) - i5;
        byte[] bArr2 = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i11 < i9) {
            int i12 = i3 + 1;
            int i13 = i12 + 1;
            int i14 = (f17741b[bArr[i3]] << 18) | (f17741b[bArr[i12]] << 12);
            int i15 = i13 + 1;
            int i16 = (f17741b[bArr[i13]] << 6) | i14;
            i3 = i15 + 1;
            int i17 = i16 | f17741b[bArr[i15]];
            int i18 = i11 + 1;
            bArr2[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr2[i18] = (byte) (i17 >> 8);
            i11 = i19 + 1;
            bArr2[i19] = (byte) i17;
            if (i7 > 0 && (i10 = i10 + 1) == 19) {
                i3 += 2;
                i10 = 0;
            }
        }
        if (i11 < i8) {
            int i20 = 0;
            for (int i21 = i3; i21 <= i4 - i5; i21++) {
                i++;
                i20 = (f17741b[bArr[i21]] << (18 - (i * 6))) | i20;
            }
            int i22 = 16;
            for (int i23 = i11; i23 < i8; i23++) {
                bArr2[i23] = (byte) (i20 >> i22);
                i22 -= 8;
            }
        }
        return bArr2;
    }

    public static final byte[] decodeFast(char[] cArr) {
        int i = 0;
        int length = cArr.length;
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && f17741b[cArr[i3]] < 0) {
            i3++;
        }
        int i4 = i2;
        while (i4 > 0 && f17741b[cArr[i4]] < 0) {
            i4--;
        }
        int i5 = cArr[i4] == '=' ? cArr[i4 + (-1)] == '=' ? 2 : 1 : 0;
        int i6 = (i4 - i3) + 1;
        int i7 = length > 76 ? (cArr[76] == '\r' ? i6 / 78 : 0) << 1 : 0;
        int i8 = (((i6 - i7) * 6) >> 3) - i5;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i11 < i9) {
            int i12 = i3 + 1;
            int i13 = i12 + 1;
            int i14 = (f17741b[cArr[i3]] << 18) | (f17741b[cArr[i12]] << 12);
            int i15 = i13 + 1;
            int i16 = (f17741b[cArr[i13]] << 6) | i14;
            i3 = i15 + 1;
            int i17 = i16 | f17741b[cArr[i15]];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            i11 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i7 > 0 && (i10 = i10 + 1) == 19) {
                i3 += 2;
                i10 = 0;
            }
        }
        if (i11 < i8) {
            int i20 = 0;
            for (int i21 = i3; i21 <= i4 - i5; i21++) {
                i++;
                i20 = (f17741b[cArr[i21]] << (18 - (i * 6))) | i20;
            }
            int i22 = 16;
            for (int i23 = i11; i23 < i8; i23++) {
                bArr[i23] = (byte) (i20 >> i22);
                i22 -= 8;
            }
        }
        return bArr;
    }

    public static final byte[] encodeToByte(byte[] bArr, boolean z) {
        int i = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i2 = (length / 3) * 3;
        int i3 = (((length - 1) / 3) + 1) << 2;
        int i4 = i3 + (z ? ((i3 - 1) / 76) << 1 : 0);
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i2) {
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | ((bArr[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16);
            i7 = i9 + 1;
            int i11 = i10 | (bArr[i9] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            int i12 = i6 + 1;
            bArr2[i6] = (byte) f17740a[(i11 >>> 18) & 63];
            int i13 = i12 + 1;
            bArr2[i12] = (byte) f17740a[(i11 >>> 12) & 63];
            int i14 = i13 + 1;
            bArr2[i13] = (byte) f17740a[(i11 >>> 6) & 63];
            i6 = i14 + 1;
            bArr2[i14] = (byte) f17740a[i11 & 63];
            if (z && (i5 = i5 + 1) == 19 && i6 < i4 - 2) {
                int i15 = i6 + 1;
                bArr2[i6] = 13;
                bArr2[i15] = 10;
                i6 = i15 + 1;
                i5 = 0;
            }
        }
        int i16 = length - i2;
        if (i16 > 0) {
            int i17 = (bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 10;
            if (i16 == 2) {
                i = (bArr[length - 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 2;
            }
            int i18 = i | i17;
            bArr2[i4 - 4] = (byte) f17740a[i18 >> 12];
            bArr2[i4 - 3] = (byte) f17740a[(i18 >>> 6) & 63];
            bArr2[i4 - 2] = i16 == 2 ? (byte) f17740a[i18 & 63] : (byte) 61;
            bArr2[i4 - 1] = 61;
        }
        return bArr2;
    }

    public static final char[] encodeToChar(byte[] bArr, boolean z) {
        int i = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i2 = (length / 3) * 3;
        int i3 = (((length - 1) / 3) + 1) << 2;
        int i4 = i3 + (z ? ((i3 - 1) / 76) << 1 : 0);
        char[] cArr = new char[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i2) {
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | ((bArr[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16);
            i7 = i9 + 1;
            int i11 = i10 | (bArr[i9] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            int i12 = i6 + 1;
            cArr[i6] = f17740a[(i11 >>> 18) & 63];
            int i13 = i12 + 1;
            cArr[i12] = f17740a[(i11 >>> 12) & 63];
            int i14 = i13 + 1;
            cArr[i13] = f17740a[(i11 >>> 6) & 63];
            i6 = i14 + 1;
            cArr[i14] = f17740a[i11 & 63];
            if (z && (i5 = i5 + 1) == 19 && i6 < i4 - 2) {
                int i15 = i6 + 1;
                cArr[i6] = C5122l.f21761a;
                cArr[i15] = '\n';
                i6 = i15 + 1;
                i5 = 0;
            }
        }
        int i16 = length - i2;
        if (i16 > 0) {
            int i17 = (bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 10;
            if (i16 == 2) {
                i = (bArr[length - 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 2;
            }
            int i18 = i | i17;
            cArr[i4 - 4] = f17740a[i18 >> 12];
            cArr[i4 - 3] = f17740a[(i18 >>> 6) & 63];
            cArr[i4 - 2] = i16 == 2 ? f17740a[i18 & 63] : '=';
            cArr[i4 - 1] = SignatureVisitor.INSTANCEOF;
        }
        return cArr;
    }

    public static final String encodeToString(byte[] bArr, boolean z) {
        return new String(encodeToChar(bArr, z));
    }
}
