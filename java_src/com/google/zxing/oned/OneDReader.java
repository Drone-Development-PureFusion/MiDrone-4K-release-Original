package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Enumeration;
import java.util.Hashtable;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* loaded from: classes.dex */
public abstract class OneDReader implements Reader {
    protected static final int INTEGER_MATH_SHIFT = 8;
    protected static final int PATTERN_MATCH_RESULT_SCALE_FACTOR = 256;

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00eb, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f3, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Result doDecode(BinaryBitmap binaryBitmap, Hashtable hashtable) {
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i = height >> 1;
        boolean z = hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, height >> (z ? 8 : 5));
        int i2 = z ? height : 15;
        BitArray bitArray2 = bitArray;
        Hashtable hashtable2 = hashtable;
        loop0: for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (i3 + 1) >> 1;
            if (!((i3 & 1) == 0)) {
                i4 = -i4;
            }
            int i5 = i + (i4 * max);
            if (i5 < 0 || i5 >= height) {
                break;
            }
            try {
                bitArray2 = binaryBitmap.getBlackRow(i5, bitArray2);
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < 2) {
                        if (i7 == 1) {
                            bitArray2.reverse();
                            if (hashtable2 != null && hashtable2.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                                Hashtable hashtable3 = new Hashtable();
                                Enumeration keys = hashtable2.keys();
                                while (keys.hasMoreElements()) {
                                    Object nextElement = keys.nextElement();
                                    if (!nextElement.equals(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                                        hashtable3.put(nextElement, hashtable2.get(nextElement));
                                    }
                                }
                                hashtable2 = hashtable3;
                            }
                        }
                        try {
                            Result decodeRow = decodeRow(i5, bitArray2, hashtable2);
                            if (i7 != 1) {
                                break loop0;
                            }
                            decodeRow.putMetadata(ResultMetadataType.ORIENTATION, new Integer((int) Opcodes.GETFIELD));
                            ResultPoint[] resultPoints = decodeRow.getResultPoints();
                            resultPoints[0] = new ResultPoint((width - resultPoints[0].getX()) - 1.0f, resultPoints[0].getY());
                            resultPoints[1] = new ResultPoint((width - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                            break loop0;
                        } catch (ReaderException e) {
                            i6 = i7 + 1;
                        }
                    }
                }
            } catch (NotFoundException e2) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int patternMatchVariance(int[] iArr, int[] iArr2, int i) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i3 += iArr[i4];
            i2 += iArr2[i4];
        }
        if (i3 < i2) {
            return Integer.MAX_VALUE;
        }
        int i5 = (i3 << 8) / i2;
        int i6 = (i * i5) >> 8;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr[i8] << 8;
            int i10 = iArr2[i8] * i5;
            int i11 = i9 > i10 ? i9 - i10 : i10 - i9;
            if (i11 > i6) {
                return Integer.MAX_VALUE;
            }
            i7 += i11;
        }
        return i7 / i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void recordPattern(BitArray bitArray, int i, int[] iArr) {
        int i2;
        boolean z;
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = 0;
        }
        int size = bitArray.getSize();
        if (i >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z2 = !bitArray.get(i);
        int i4 = 0;
        while (true) {
            if (i >= size) {
                i2 = i4;
                break;
            }
            if (bitArray.get(i) ^ z2) {
                iArr[i4] = iArr[i4] + 1;
                z = z2;
            } else {
                i2 = i4 + 1;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z2;
                i4 = i2;
            }
            i++;
            z2 = z;
        }
        if (i2 == length) {
            return;
        }
        if (i2 != length - 1 || i != size) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Hashtable hashtable) {
        try {
            return doDecode(binaryBitmap, hashtable);
        } catch (NotFoundException e) {
            if (!(hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER)) || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result doDecode = doDecode(rotateCounterClockwise, hashtable);
            Hashtable resultMetadata = doDecode.getResultMetadata();
            doDecode.putMetadata(ResultMetadataType.ORIENTATION, new Integer((resultMetadata == null || !resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) ? 270 : (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360));
            ResultPoint[] resultPoints = doDecode.getResultPoints();
            int height = rotateCounterClockwise.getHeight();
            for (int i = 0; i < resultPoints.length; i++) {
                resultPoints[i] = new ResultPoint((height - resultPoints[i].getY()) - 1.0f, resultPoints[i].getX());
            }
            return doDecode;
        }
    }

    public abstract Result decodeRow(int i, BitArray bitArray, Hashtable hashtable);

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
