package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class Code128Writer extends UPCEANWriter {
    @Override // com.google.zxing.oned.UPCEANWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Hashtable hashtable) {
        if (barcodeFormat != BarcodeFormat.CODE_128) {
            throw new IllegalArgumentException(new StringBuffer().append("Can only encode CODE_128, but got ").append(barcodeFormat).toString());
        }
        return super.encode(str, barcodeFormat, i, i2, hashtable);
    }

    @Override // com.google.zxing.oned.UPCEANWriter
    public byte[] encode(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException(new StringBuffer().append("Requested contents should be less than 80 digits long, but got ").append(length).toString());
        }
        int i = 35;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i;
            for (int i4 : Code128Reader.CODE_PATTERNS[str.charAt(i2) - ' ']) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        byte[] bArr = new byte[i];
        int appendPattern = appendPattern(bArr, 0, Code128Reader.CODE_PATTERNS[104], 1);
        int i5 = 104;
        for (int i6 = 0; i6 < length; i6++) {
            i5 += (str.charAt(i6) - ' ') * (i6 + 1);
            appendPattern += appendPattern(bArr, appendPattern, Code128Reader.CODE_PATTERNS[str.charAt(i6) - ' '], 1);
        }
        int appendPattern2 = appendPattern(bArr, appendPattern, Code128Reader.CODE_PATTERNS[i5 % 103], 1) + appendPattern;
        int appendPattern3 = appendPattern2 + appendPattern(bArr, appendPattern2, Code128Reader.CODE_PATTERNS[106], 1);
        return bArr;
    }
}
