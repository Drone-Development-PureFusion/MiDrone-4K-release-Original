package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class ITFWriter extends UPCEANWriter {
    @Override // com.google.zxing.oned.UPCEANWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Hashtable hashtable) {
        if (barcodeFormat != BarcodeFormat.ITF) {
            throw new IllegalArgumentException(new StringBuffer().append("Can only encode ITF, but got ").append(barcodeFormat).toString());
        }
        return super.encode(str, barcodeFormat, i, i2, hashtable);
    }

    @Override // com.google.zxing.oned.UPCEANWriter
    public byte[] encode(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException(new StringBuffer().append("Requested contents should be less than 80 digits long, but got ").append(length).toString());
        }
        byte[] bArr = new byte[(length * 9) + 9];
        int appendPattern = appendPattern(bArr, 0, new int[]{1, 1, 1, 1}, 1);
        for (int i = 0; i < length; i += 2) {
            int digit = Character.digit(str.charAt(i), 10);
            int digit2 = Character.digit(str.charAt(i + 1), 10);
            int[] iArr = new int[18];
            for (int i2 = 0; i2 < 5; i2++) {
                iArr[i2 << 1] = ITFReader.PATTERNS[digit][i2];
                iArr[(i2 << 1) + 1] = ITFReader.PATTERNS[digit2][i2];
            }
            appendPattern += appendPattern(bArr, appendPattern, iArr, 1);
        }
        int appendPattern2 = appendPattern(bArr, appendPattern, new int[]{3, 1, 1}, 1) + appendPattern;
        return bArr;
    }
}
