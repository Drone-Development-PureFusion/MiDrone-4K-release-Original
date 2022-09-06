package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class Code39Writer extends UPCEANWriter {
    private static void toIntArray(int i, int[] iArr) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < 9) {
                iArr[i3] = ((1 << i3) & i) == 0 ? 1 : 2;
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.zxing.oned.UPCEANWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Hashtable hashtable) {
        if (barcodeFormat != BarcodeFormat.CODE_39) {
            throw new IllegalArgumentException(new StringBuffer().append("Can only encode CODE_39, but got ").append(barcodeFormat).toString());
        }
        return super.encode(str, barcodeFormat, i, i2, hashtable);
    }

    @Override // com.google.zxing.oned.UPCEANWriter
    public byte[] encode(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException(new StringBuffer().append("Requested contents should be less than 80 digits long, but got ").append(length).toString());
        }
        int[] iArr = new int[9];
        int i = length + 25;
        int i2 = 0;
        while (i2 < length) {
            toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2))], iArr);
            int i3 = i;
            for (int i4 : iArr) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        byte[] bArr = new byte[i];
        toIntArray(Code39Reader.CHARACTER_ENCODINGS[39], iArr);
        int appendPattern = appendPattern(bArr, 0, iArr, 1);
        int[] iArr2 = {1};
        int appendPattern2 = appendPattern(bArr, appendPattern, iArr2, 0) + appendPattern;
        for (int i5 = length - 1; i5 >= 0; i5--) {
            toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i5))], iArr);
            int appendPattern3 = appendPattern2 + appendPattern(bArr, appendPattern2, iArr, 1);
            appendPattern2 = appendPattern3 + appendPattern(bArr, appendPattern3, iArr2, 0);
        }
        toIntArray(Code39Reader.CHARACTER_ENCODINGS[39], iArr);
        int appendPattern4 = appendPattern(bArr, appendPattern2, iArr, 1) + appendPattern2;
        return bArr;
    }
}
