package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class CodaBarReader extends OneDReader {
    private static final int minCharacterLength = 6;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCDTN";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 37, 81, 84, 21, 26, 41, 11, 14, 26, 41};
    private static final char[] STARTEND_ENCODING = {'E', '*', 'A', 'B', 'C', 'D', 'T', 'N'};

    private static boolean arrayContains(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static int[] findAsteriskPattern(BitArray bitArray) {
        int size = bitArray.getSize();
        int i = 0;
        while (i < size && !bitArray.get(i)) {
            i++;
        }
        int[] iArr = new int[7];
        int length = iArr.length;
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i2 < size) {
            if (bitArray.get(i2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == length - 1) {
                    try {
                        if (arrayContains(STARTEND_ENCODING, toNarrowWidePattern(iArr)) && bitArray.isRange(Math.max(0, i - ((i2 - i) / 2)), i, false)) {
                            return new int[]{i, i2};
                        }
                    } catch (IllegalArgumentException e) {
                    }
                    i += iArr[0] + iArr[1];
                    for (int i4 = 2; i4 < length; i4++) {
                        iArr[i4 - 2] = iArr[i4];
                    }
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            i2++;
            i = i;
            i3 = i3;
            z = z;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (iArr[i3] < i) {
                i = iArr[i3];
            }
            if (iArr[i3] > i2) {
                i2 = iArr[i3];
            }
        }
        do {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (iArr[i6] > i2) {
                    i4 |= 1 << ((length - 1) - i6);
                    i5++;
                }
            }
            if (i5 == 2 || i5 == 3) {
                for (int i7 = 0; i7 < CHARACTER_ENCODINGS.length; i7++) {
                    if (CHARACTER_ENCODINGS[i7] == i4) {
                        return ALPHABET[i7];
                    }
                }
            }
            i2--;
        } while (i2 > i);
        return '!';
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        int[] findAsteriskPattern = findAsteriskPattern(bitArray);
        findAsteriskPattern[1] = 0;
        int i2 = findAsteriskPattern[1];
        int size = bitArray.getSize();
        while (i2 < size && !bitArray.get(i2)) {
            i2++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int[] iArr = {0, 0, 0, 0, 0, 0, 0};
            recordPattern(bitArray, i2, iArr);
            char narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern == '!') {
                throw NotFoundException.getNotFoundInstance();
            }
            stringBuffer.append(narrowWidePattern);
            int i3 = i2;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int i5 = i3;
            while (i5 < size && !bitArray.get(i5)) {
                i5++;
            }
            if (i5 >= size) {
                int i6 = 0;
                for (int i7 : iArr) {
                    i6 += i7;
                }
                int i8 = (i5 - i2) - i6;
                if (i5 != size && i8 / 2 < i6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (stringBuffer.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                char charAt = stringBuffer.charAt(0);
                if (!arrayContains(STARTEND_ENCODING, charAt)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int i9 = 1;
                while (i9 < stringBuffer.length()) {
                    if (stringBuffer.charAt(i9) == charAt && i9 + 1 != stringBuffer.length()) {
                        stringBuffer.delete(i9 + 1, stringBuffer.length() - 1);
                        i9 = stringBuffer.length();
                    }
                    i9++;
                }
                if (stringBuffer.length() <= 6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                stringBuffer.deleteCharAt(0);
                return new Result(stringBuffer.toString(), null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, i), new ResultPoint((i2 + i5) / 2.0f, i)}, BarcodeFormat.CODABAR);
            }
            i2 = i5;
        }
    }
}
