package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class DataMatrixReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static BitMatrix extractPureBits(BitMatrix bitMatrix) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int min = Math.min(height, width);
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        if (topLeftOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = topLeftOnBit[0];
        int i2 = topLeftOnBit[1];
        int i3 = i;
        while (i3 < min && i2 < min && bitMatrix.get(i3, i2)) {
            i3++;
        }
        int i4 = i3 - topLeftOnBit[0];
        int i5 = width - 1;
        while (i5 >= 0 && !bitMatrix.get(i5, i2)) {
            i5--;
        }
        if (i5 < 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i5 + 1;
        if ((i6 - i3) % i4 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7 = ((i6 - i3) / i4) + 2;
        int i8 = i2 + i4;
        int i9 = i3 - (i4 >> 1);
        int i10 = i8 - (i4 >> 1);
        if (((i7 - 1) * i4) + i9 >= width || ((i7 - 1) * i4) + i10 >= height) {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix bitMatrix2 = new BitMatrix(i7);
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = i10 + (i11 * i4);
            for (int i13 = 0; i13 < i7; i13++) {
                if (bitMatrix.get((i13 * i4) + i9, i12)) {
                    bitMatrix2.set(i13, i11);
                }
            }
        }
        return bitMatrix2;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Hashtable hashtable) {
        DecoderResult decode;
        ResultPoint[] points;
        if (hashtable == null || !hashtable.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect();
            decode = this.decoder.decode(detect.getBits());
            points = detect.getPoints();
        } else {
            decode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()));
            points = NO_POINTS;
        }
        Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.DATA_MATRIX);
        if (decode.getByteSegments() != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, decode.getByteSegments());
        }
        if (decode.getECLevel() != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, decode.getECLevel().toString());
        }
        return result;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
