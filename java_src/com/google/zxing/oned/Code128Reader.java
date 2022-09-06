package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final int MAX_AVG_VARIANCE = 64;
    private static final int MAX_INDIVIDUAL_VARIANCE = 179;

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) {
        recordPattern(bitArray, i, iArr);
        int i2 = 64;
        int i3 = -1;
        for (int i4 = 0; i4 < CODE_PATTERNS.length; i4++) {
            int patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], 179);
            if (patternMatchVariance < i2) {
                i3 = i4;
                i2 = patternMatchVariance;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findStartPattern(BitArray bitArray) {
        int i;
        int i2;
        boolean z;
        int size = bitArray.getSize();
        int i3 = 0;
        while (i3 < size && !bitArray.get(i3)) {
            i3++;
        }
        int[] iArr = new int[6];
        int length = iArr.length;
        int i4 = i3;
        boolean z2 = false;
        int i5 = i3;
        int i6 = 0;
        while (i4 < size) {
            if (bitArray.get(i4) ^ z2) {
                iArr[i6] = iArr[i6] + 1;
                z = z2;
                i = i6;
            } else {
                if (i6 == length - 1) {
                    int i7 = 64;
                    int i8 = -1;
                    int i9 = 103;
                    while (i9 <= 105) {
                        int patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i9], 179);
                        if (patternMatchVariance < i7) {
                            i8 = i9;
                        } else {
                            patternMatchVariance = i7;
                        }
                        i9++;
                        i7 = patternMatchVariance;
                    }
                    if (i8 >= 0 && bitArray.isRange(Math.max(0, i5 - ((i4 - i5) / 2)), i5, false)) {
                        return new int[]{i5, i4, i8};
                    }
                    i2 = iArr[0] + iArr[1] + i5;
                    for (int i10 = 2; i10 < length; i10++) {
                        iArr[i10 - 2] = iArr[i10];
                    }
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i = i6 - 1;
                } else {
                    i = i6 + 1;
                    i2 = i5;
                }
                iArr[i] = 1;
                z = !z2;
                i5 = i2;
            }
            i4++;
            z2 = z;
            i6 = i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        char c;
        char c2;
        boolean z;
        boolean z2;
        boolean z3;
        char c3;
        boolean z4;
        boolean z5;
        int[] findStartPattern = findStartPattern(bitArray);
        int i2 = findStartPattern[2];
        switch (i2) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuffer stringBuffer = new StringBuffer(20);
        int i3 = findStartPattern[0];
        int i4 = findStartPattern[1];
        int[] iArr = new int[6];
        boolean z6 = true;
        boolean z7 = false;
        boolean z8 = false;
        char c4 = c;
        int i5 = 0;
        int i6 = i2;
        int i7 = 0;
        int i8 = 0;
        int i9 = i3;
        while (!z8) {
            boolean z9 = false;
            int decodeCode = decodeCode(bitArray, iArr, i4);
            if (decodeCode != 106) {
                z6 = true;
            }
            if (decodeCode != 106) {
                i5++;
                i6 += i5 * decodeCode;
            }
            int i10 = i4;
            for (int i11 : iArr) {
                i10 += i11;
            }
            switch (decodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c4) {
                        case 'c':
                            if (decodeCode < 100) {
                                if (decodeCode < 10) {
                                    stringBuffer.append('0');
                                }
                                stringBuffer.append(decodeCode);
                                c2 = c4;
                                z = z8;
                                z2 = false;
                                z3 = z6;
                                break;
                            } else {
                                boolean z10 = decodeCode != 106 ? false : z6;
                                switch (decodeCode) {
                                    case 100:
                                        boolean z11 = z10;
                                        c2 = 'd';
                                        z = z8;
                                        z2 = false;
                                        z3 = z11;
                                        break;
                                    case 101:
                                        boolean z12 = z10;
                                        c2 = 'e';
                                        z = z8;
                                        z2 = false;
                                        z3 = z12;
                                        break;
                                    case 102:
                                        boolean z13 = z10;
                                        c2 = c4;
                                        z = z8;
                                        z2 = false;
                                        z3 = z13;
                                        break;
                                    case 103:
                                    case 104:
                                    case 105:
                                    default:
                                        boolean z14 = z10;
                                        c2 = c4;
                                        z = z8;
                                        z2 = false;
                                        z3 = z14;
                                        break;
                                    case 106:
                                        boolean z15 = z10;
                                        c2 = c4;
                                        z = true;
                                        z2 = false;
                                        z3 = z15;
                                        break;
                                }
                            }
                        case 'd':
                            if (decodeCode < 96) {
                                stringBuffer.append((char) (decodeCode + 32));
                                c2 = c4;
                                z = z8;
                                z2 = false;
                                z3 = z6;
                                break;
                            } else {
                                boolean z16 = decodeCode != 106 ? false : z6;
                                switch (decodeCode) {
                                    case 98:
                                        z9 = true;
                                        c4 = 'c';
                                        break;
                                    case 99:
                                        c4 = 'c';
                                        break;
                                    case 101:
                                        c4 = 'e';
                                        break;
                                    case 106:
                                        z8 = true;
                                        break;
                                }
                                boolean z17 = z16;
                                c2 = c4;
                                z = z8;
                                z2 = z9;
                                z3 = z17;
                                break;
                            }
                        case 'e':
                            if (decodeCode < 64) {
                                stringBuffer.append((char) (decodeCode + 32));
                                c2 = c4;
                                z = z8;
                                z2 = false;
                                z3 = z6;
                                break;
                            } else if (decodeCode < 96) {
                                stringBuffer.append((char) (decodeCode - 64));
                                c2 = c4;
                                z = z8;
                                z2 = false;
                                z3 = z6;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z6 = false;
                                }
                                switch (decodeCode) {
                                    case 96:
                                    case 97:
                                    case 101:
                                    case 102:
                                        z4 = false;
                                        z5 = z8;
                                        c3 = c4;
                                        break;
                                    case 98:
                                        z4 = true;
                                        boolean z18 = z8;
                                        c3 = 'd';
                                        z5 = z18;
                                        break;
                                    case 99:
                                        z5 = z8;
                                        c3 = 'c';
                                        z4 = false;
                                        break;
                                    case 100:
                                        z5 = z8;
                                        c3 = 'd';
                                        z4 = false;
                                        break;
                                    case 103:
                                    case 104:
                                    case 105:
                                    default:
                                        z4 = false;
                                        z5 = z8;
                                        c3 = c4;
                                        break;
                                    case 106:
                                        c3 = c4;
                                        z4 = false;
                                        z5 = true;
                                        break;
                                }
                                z = z5;
                                z3 = z6;
                                boolean z19 = z4;
                                c2 = c3;
                                z2 = z19;
                                break;
                            }
                        default:
                            c2 = c4;
                            z = z8;
                            z2 = false;
                            z3 = z6;
                            break;
                    }
                    if (z7) {
                        switch (c2) {
                            case 'c':
                                c2 = 'd';
                                continue;
                            case 'd':
                                c2 = 'e';
                                continue;
                            case 'e':
                                c2 = 'c';
                                continue;
                        }
                    }
                    z6 = z3;
                    z7 = z2;
                    z8 = z;
                    c4 = c2;
                    i7 = i8;
                    i8 = decodeCode;
                    int i12 = i4;
                    i4 = i10;
                    i9 = i12;
                    break;
            }
        }
        int size = bitArray.getSize();
        while (i4 < size && bitArray.get(i4)) {
            i4++;
        }
        if (!bitArray.isRange(i4, Math.min(size, ((i4 - i9) / 2) + i4), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        if ((i6 - (i5 * i7)) % 103 != i7) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = stringBuffer.length();
        if (length > 0 && z6) {
            if (c4 == 'c') {
                stringBuffer.delete(length - 2, length);
            } else {
                stringBuffer.delete(length - 1, length);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() != 0) {
            return new Result(stringBuffer2, null, new ResultPoint[]{new ResultPoint((findStartPattern[1] + findStartPattern[0]) / 2.0f, i), new ResultPoint((i4 + i9) / 2.0f, i)}, BarcodeFormat.CODE_128);
        }
        throw FormatException.getFormatInstance();
    }
}
