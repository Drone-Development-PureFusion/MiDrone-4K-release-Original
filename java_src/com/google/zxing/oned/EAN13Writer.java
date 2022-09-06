package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class EAN13Writer extends UPCEANWriter {
    private static final int codeWidth = 95;

    @Override // com.google.zxing.oned.UPCEANWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Hashtable hashtable) {
        if (barcodeFormat != BarcodeFormat.EAN_13) {
            throw new IllegalArgumentException(new StringBuffer().append("Can only encode EAN_13, but got ").append(barcodeFormat).toString());
        }
        return super.encode(str, barcodeFormat, i, i2, hashtable);
    }

    @Override // com.google.zxing.oned.UPCEANWriter
    public byte[] encode(String str) {
        if (str.length() != 13) {
            throw new IllegalArgumentException(new StringBuffer().append("Requested contents should be 13 digits long, but got ").append(str.length()).toString());
        }
        int i = EAN13Reader.FIRST_DIGIT_ENCODINGS[Integer.parseInt(str.substring(0, 1))];
        byte[] bArr = new byte[95];
        int appendPattern = appendPattern(bArr, 0, UPCEANReader.START_END_PATTERN, 1) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int parseInt = Integer.parseInt(str.substring(i2, i2 + 1));
            if (((i >> (6 - i2)) & 1) == 1) {
                parseInt += 10;
            }
            appendPattern += appendPattern(bArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[parseInt], 0);
        }
        int appendPattern2 = appendPattern + appendPattern(bArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, 0);
        for (int i3 = 7; i3 <= 12; i3++) {
            appendPattern2 += appendPattern(bArr, appendPattern2, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i3, i3 + 1))], 1);
        }
        int appendPattern3 = appendPattern(bArr, appendPattern2, UPCEANReader.START_END_PATTERN, 1) + appendPattern2;
        return bArr;
    }
}
