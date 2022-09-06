package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(QRCode qRCode, int i, int i2) {
        ByteMatrix matrix = qRCode.getMatrix();
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i3 = width + 8;
        int i4 = height + 8;
        int max = Math.max(i, i3);
        int max2 = Math.max(i2, i4);
        int min = Math.min(max / i3, max2 / i4);
        int i5 = (max - (width * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i6 = (max2 - (height * min)) / 2;
        for (int i7 = 0; i7 < height; i7++) {
            int i8 = i5;
            int i9 = 0;
            while (i9 < width) {
                if (matrix.get(i9, i7) == 1) {
                    bitMatrix.setRegion(i8, i6, min, min);
                }
                i9++;
                i8 += min;
            }
            i6 += min;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Hashtable hashtable) {
        ErrorCorrectionLevel errorCorrectionLevel;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException(new StringBuffer().append("Can only encode QR_CODE, but got ").append(barcodeFormat).toString());
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Requested dimensions are too small: ").append(i).append('x').append(i2).toString());
        }
        ErrorCorrectionLevel errorCorrectionLevel2 = ErrorCorrectionLevel.f17091L;
        if (hashtable == null || (errorCorrectionLevel = (ErrorCorrectionLevel) hashtable.get(EncodeHintType.ERROR_CORRECTION)) == null) {
            errorCorrectionLevel = errorCorrectionLevel2;
        }
        QRCode qRCode = new QRCode();
        Encoder.encode(str, errorCorrectionLevel, hashtable, qRCode);
        return renderResult(qRCode, i, i2);
    }
}
