package com.google.zxing.qrcode;

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
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.detector.Detector;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r3 != r7) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        r7 = r4 - r8[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r7 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        r2 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r2 <= r4) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r10.get(r2, r3) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        if (r2 > r4) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
        if (((r2 - r4) % r7) == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
        r8 = ((r2 - r4) / r7) + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        if (r7 != 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
        r4 = r4 - r0;
        r3 = r3 - r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
        if ((((r8 - 1) * r7) + r4) >= r6) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
        if ((((r8 - 1) * r7) + r3) < r5) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
        r5 = new com.google.zxing.common.BitMatrix(r8);
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
        if (r2 >= r8) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
        r6 = r3 + (r2 * r7);
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008c, code lost:
        if (r0 >= r8) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
        if (r10.get((r0 * r7) + r4, r6) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:
        r5.set(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009a, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007b, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007c, code lost:
        r0 = r7 >> 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BitMatrix extractPureBits(BitMatrix bitMatrix) {
        int i = 1;
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int min = Math.min(height, width);
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        if (topLeftOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i2 = topLeftOnBit[0];
        int i3 = topLeftOnBit[1];
        while (i2 < min && i3 < min && bitMatrix.get(i2, i3)) {
            i2++;
            i3++;
        }
        throw NotFoundException.getNotFoundInstance();
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
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(hashtable);
            decode = this.decoder.decode(detect.getBits(), hashtable);
            points = detect.getPoints();
        } else {
            decode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), hashtable);
            points = NO_POINTS;
        }
        Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
        if (decode.getByteSegments() != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, decode.getByteSegments());
        }
        if (decode.getECLevel() != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, decode.getECLevel().toString());
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Decoder getDecoder() {
        return this.decoder;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
