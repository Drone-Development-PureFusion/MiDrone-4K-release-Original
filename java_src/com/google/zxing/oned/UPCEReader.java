package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes.dex */
public final class UPCEReader extends UPCEANReader {
    private static final int[] MIDDLE_END_PATTERN = {1, 1, 1, 1, 1, 1};
    private static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] decodeMiddleCounters = new int[4];

    public static String convertUPCEtoUPCA(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuffer stringBuffer = new StringBuffer(12);
        stringBuffer.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                stringBuffer.append(cArr, 0, 2);
                stringBuffer.append(c);
                stringBuffer.append("0000");
                stringBuffer.append(cArr, 2, 3);
                break;
            case '3':
                stringBuffer.append(cArr, 0, 3);
                stringBuffer.append("00000");
                stringBuffer.append(cArr, 3, 2);
                break;
            case '4':
                stringBuffer.append(cArr, 0, 4);
                stringBuffer.append("00000");
                stringBuffer.append(cArr[4]);
                break;
            default:
                stringBuffer.append(cArr, 0, 5);
                stringBuffer.append("0000");
                stringBuffer.append(c);
                break;
        }
        stringBuffer.append(str.charAt(7));
        return stringBuffer.toString();
    }

    private static void determineNumSysAndCheckDigit(StringBuffer stringBuffer, int i) {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == NUMSYS_AND_CHECK_DIGIT_PATTERNS[i2][i3]) {
                    stringBuffer.insert(0, (char) (i2 + 48));
                    stringBuffer.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.zxing.oned.UPCEANReader
    public boolean checkChecksum(String str) {
        return super.checkChecksum(convertUPCEtoUPCA(str));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int[] decodeEnd(BitArray bitArray, int i) {
        return findGuardPattern(bitArray, i, true, MIDDLE_END_PATTERN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuffer stringBuffer) {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < size) {
            int decodeDigit = decodeDigit(bitArray, iArr2, i, L_AND_G_PATTERNS);
            stringBuffer.append((char) ((decodeDigit % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            int i6 = decodeDigit >= 10 ? (1 << (5 - i2)) | i3 : i3;
            i2++;
            i3 = i6;
            i = i4;
        }
        determineNumSysAndCheckDigit(stringBuffer, i3);
        return i;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_E;
    }
}
