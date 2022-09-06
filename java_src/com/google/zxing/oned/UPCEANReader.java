package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;
/* loaded from: classes.dex */
public abstract class UPCEANReader extends OneDReader {
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 179;
    static final int[] START_END_PATTERN = {1, 1, 1};
    static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    static final int[][] L_PATTERNS = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] L_AND_G_PATTERNS = new int[20];
    private final StringBuffer decodeRowStringBuffer = new StringBuffer(20);
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();

    static {
        int i = 10;
        for (int i2 = 0; i2 < 10; i2++) {
            L_AND_G_PATTERNS[i2] = L_PATTERNS[i2];
        }
        while (true) {
            int i3 = i;
            if (i3 < 20) {
                int[] iArr = L_PATTERNS[i3 - 10];
                int[] iArr2 = new int[iArr.length];
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    iArr2[i4] = iArr[(iArr.length - i4) - 1];
                }
                L_AND_G_PATTERNS[i3] = iArr2;
                i = i3 + 1;
            } else {
                return;
            }
        }
    }

    private static boolean checkStandardUPCEANChecksum(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int charAt = str.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int charAt2 = str.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += charAt2;
        }
        return i3 % 10 == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeDigit(BitArray bitArray, int[] iArr, int i, int[][] iArr2) {
        recordPattern(bitArray, i, iArr);
        int i2 = 107;
        int i3 = -1;
        int length = iArr2.length;
        int i4 = 0;
        while (i4 < length) {
            int patternMatchVariance = patternMatchVariance(iArr, iArr2[i4], 179);
            if (patternMatchVariance < i2) {
                i3 = i4;
            } else {
                patternMatchVariance = i2;
            }
            i4++;
            i2 = patternMatchVariance;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] findGuardPattern(BitArray bitArray, int i, boolean z, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        boolean z2 = false;
        int i2 = i;
        while (i2 < size) {
            z2 = !bitArray.get(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        boolean z3 = z2;
        int i5 = i3;
        for (int i6 = i2; i6 < size; i6++) {
            if (bitArray.get(i6) ^ z3) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (patternMatchVariance(iArr2, iArr, 179) < 107) {
                    return new int[]{i5, i6};
                } else {
                    i5 += iArr2[0] + iArr2[1];
                    for (int i7 = 2; i7 < length; i7++) {
                        iArr2[i7 - 2] = iArr2[i7];
                    }
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z3 = !z3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] findStartGuardPattern(BitArray bitArray) {
        int i = 0;
        int[] iArr = null;
        boolean z = false;
        while (!z) {
            iArr = findGuardPattern(bitArray, i, false, START_END_PATTERN);
            int i2 = iArr[0];
            i = iArr[1];
            int i3 = i2 - (i - i2);
            if (i3 >= 0) {
                z = bitArray.isRange(i3, i2, false);
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkChecksum(String str) {
        return checkStandardUPCEANChecksum(str);
    }

    int[] decodeEnd(BitArray bitArray, int i) {
        return findGuardPattern(bitArray, i, false, START_END_PATTERN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuffer stringBuffer);

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        return decodeRow(i, bitArray, findStartGuardPattern(bitArray), hashtable);
    }

    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Hashtable hashtable) {
        String lookupCountryIdentifier;
        ResultPointCallback resultPointCallback = hashtable == null ? null : (ResultPointCallback) hashtable.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuffer stringBuffer = this.decodeRowStringBuffer;
        stringBuffer.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, stringBuffer);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(decodeMiddle, i));
        }
        int[] decodeEnd = decodeEnd(bitArray, decodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((decodeEnd[0] + decodeEnd[1]) / 2.0f, i));
        }
        int i2 = decodeEnd[1];
        int i3 = (i2 - decodeEnd[0]) + i2;
        if (i3 >= bitArray.getSize() || !bitArray.isRange(i2, i3, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String stringBuffer2 = stringBuffer.toString();
        if (!checkChecksum(stringBuffer2)) {
            throw ChecksumException.getChecksumInstance();
        }
        BarcodeFormat barcodeFormat = getBarcodeFormat();
        Result result = new Result(stringBuffer2, null, new ResultPoint[]{new ResultPoint((iArr[1] + iArr[0]) / 2.0f, i), new ResultPoint((decodeEnd[1] + decodeEnd[0]) / 2.0f, i)}, barcodeFormat);
        try {
            Result decodeRow = this.extensionReader.decodeRow(i, bitArray, decodeEnd[1]);
            result.putAllMetadata(decodeRow.getResultMetadata());
            result.addResultPoints(decodeRow.getResultPoints());
        } catch (ReaderException e) {
        }
        if ((BarcodeFormat.EAN_13.equals(barcodeFormat) || BarcodeFormat.UPC_A.equals(barcodeFormat)) && (lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(stringBuffer2)) != null) {
            result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
        }
        return result;
    }

    abstract BarcodeFormat getBarcodeFormat();
}
