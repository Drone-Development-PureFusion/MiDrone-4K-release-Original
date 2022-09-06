package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class EAN8Writer extends UPCEANWriter {
    private static final int codeWidth = 67;

    @Override // com.google.zxing.oned.UPCEANWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Hashtable hashtable) {
        if (barcodeFormat != BarcodeFormat.EAN_8) {
            throw new IllegalArgumentException(new StringBuffer().append("Can only encode EAN_8, but got ").append(barcodeFormat).toString());
        }
        return super.encode(str, barcodeFormat, i, i2, hashtable);
    }

    @Override // com.google.zxing.oned.UPCEANWriter
    public byte[] encode(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException(new StringBuffer().append("Requested contents should be 8 digits long, but got ").append(str.length()).toString());
        }
        byte[] bArr = new byte[67];
        int appendPattern = appendPattern(bArr, 0, UPCEANReader.START_END_PATTERN, 1) + 0;
        for (int i = 0; i <= 3; i++) {
            appendPattern += appendPattern(bArr, appendPattern, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i, i + 1))], 0);
        }
        int appendPattern2 = appendPattern + appendPattern(bArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, 0);
        for (int i2 = 4; i2 <= 7; i2++) {
            appendPattern2 += appendPattern(bArr, appendPattern2, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i2, i2 + 1))], 1);
        }
        int appendPattern3 = appendPattern(bArr, appendPattern2, UPCEANReader.START_END_PATTERN, 1) + appendPattern2;
        return bArr;
    }
}
