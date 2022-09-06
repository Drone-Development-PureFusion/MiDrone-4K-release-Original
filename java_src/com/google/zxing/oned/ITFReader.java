package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class ITFReader extends OneDReader {
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;

    /* renamed from: N */
    private static final int f17082N = 1;

    /* renamed from: W */
    private static final int f17083W = 3;
    private int narrowLineWidth = -1;
    private static final int[] DEFAULT_ALLOWED_LENGTHS = {6, 10, 12, 14, 44};
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN_REVERSED = {1, 1, 3};
    static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    private static int decodeDigit(int[] iArr) {
        int i = 107;
        int i2 = -1;
        int length = PATTERNS.length;
        int i3 = 0;
        while (i3 < length) {
            int patternMatchVariance = patternMatchVariance(iArr, PATTERNS[i3], 204);
            if (patternMatchVariance < i) {
                i2 = i3;
            } else {
                patternMatchVariance = i;
            }
            i3++;
            i = patternMatchVariance;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void decodeMiddle(BitArray bitArray, int i, int i2, StringBuffer stringBuffer) {
        int i3;
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        for (int i4 = i; i4 < i2; i4 = i3) {
            recordPattern(bitArray, i4, iArr);
            for (int i5 = 0; i5 < 5; i5++) {
                int i6 = i5 << 1;
                iArr2[i5] = iArr[i6];
                iArr3[i5] = iArr[i6 + 1];
            }
            stringBuffer.append((char) (decodeDigit(iArr2) + 48));
            stringBuffer.append((char) (decodeDigit(iArr3) + 48));
            i3 = i4;
            for (int i7 : iArr) {
                i3 += i7;
            }
        }
    }

    private static int[] findGuardPattern(BitArray bitArray, int i, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i2 = i;
        int i3 = 0;
        boolean z = false;
        while (i < size) {
            if (bitArray.get(i) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (patternMatchVariance(iArr2, iArr, 204) < 107) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    for (int i4 = 2; i4 < length; i4++) {
                        iArr2[i4 - 2] = iArr2[i4];
                    }
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(BitArray bitArray) {
        int size = bitArray.getSize();
        int i = 0;
        while (i < size && !bitArray.get(i)) {
            i++;
        }
        if (i == size) {
            throw NotFoundException.getNotFoundInstance();
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void validateQuietZone(BitArray bitArray, int i) {
        int i2 = this.narrowLineWidth * 10;
        for (int i3 = i - 1; i2 > 0 && i3 >= 0 && !bitArray.get(i3); i3--) {
            i2--;
        }
    }

    int[] decodeEnd(BitArray bitArray) {
        bitArray.reverse();
        try {
            int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), END_PATTERN_REVERSED);
            validateQuietZone(bitArray, findGuardPattern[0]);
            int i = findGuardPattern[0];
            findGuardPattern[0] = bitArray.getSize() - findGuardPattern[1];
            findGuardPattern[1] = bitArray.getSize() - i;
            return findGuardPattern;
        } finally {
            bitArray.reverse();
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        boolean z;
        int[] decodeStart = decodeStart(bitArray);
        int[] decodeEnd = decodeEnd(bitArray);
        StringBuffer stringBuffer = new StringBuffer(20);
        decodeMiddle(bitArray, decodeStart[1], decodeEnd[0], stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        int[] iArr = hashtable != null ? (int[]) hashtable.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = stringBuffer2.length();
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                z = false;
                break;
            } else if (length == iArr[i2]) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            throw FormatException.getFormatInstance();
        }
        return new Result(stringBuffer2, null, new ResultPoint[]{new ResultPoint(decodeStart[1], i), new ResultPoint(decodeEnd[0], i)}, BarcodeFormat.ITF);
    }

    int[] decodeStart(BitArray bitArray) {
        int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        this.narrowLineWidth = (findGuardPattern[1] - findGuardPattern[0]) >> 2;
        validateQuietZone(bitArray, findGuardPattern[0]);
        return findGuardPattern;
    }
}
