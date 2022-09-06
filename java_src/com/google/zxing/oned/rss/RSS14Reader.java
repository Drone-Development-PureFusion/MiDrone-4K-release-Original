package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* loaded from: classes.dex */
public final class RSS14Reader extends AbstractRSSReader {
    private final Vector possibleLeftPairs = new Vector();
    private final Vector possibleRightPairs = new Vector();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, Opcodes.IF_ICMPLT, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    private static void addOrTally(Vector vector, Pair pair) {
        boolean z;
        if (pair == null) {
            return;
        }
        Enumeration elements = vector.elements();
        while (true) {
            if (!elements.hasMoreElements()) {
                z = false;
                break;
            }
            Pair pair2 = (Pair) elements.nextElement();
            if (pair2.getValue() == pair.getValue()) {
                pair2.incrementCount();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        vector.addElement(pair);
    }

    private void adjustOddEvenCounts(boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        boolean z8 = true;
        int count = count(this.oddCounts);
        int count2 = count(this.evenCounts);
        int i2 = (count + count2) - i;
        boolean z9 = (count & 1) == (z ? 1 : 0);
        boolean z10 = (count2 & 1) == 1;
        if (z) {
            if (count > 12) {
                z2 = true;
                z3 = false;
            } else if (count < 4) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (count2 > 12) {
                z4 = false;
                z7 = true;
            } else {
                if (count2 < 4) {
                    z4 = true;
                }
                z4 = false;
            }
        } else {
            if (count > 11) {
                z2 = true;
                z3 = false;
            } else if (count < 5) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (count2 > 10) {
                z4 = false;
                z7 = true;
            } else {
                if (count2 < 4) {
                    z4 = true;
                }
                z4 = false;
            }
        }
        if (i2 == 1) {
            if (z9) {
                if (z10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z6 = z3;
                z8 = z4;
                z5 = true;
            } else if (!z10) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z7 = true;
                z8 = z4;
                z5 = z2;
                z6 = z3;
            }
        } else if (i2 == -1) {
            if (z9) {
                if (z10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                boolean z11 = z4;
                z5 = z2;
                z6 = true;
                z8 = z11;
            } else if (!z10) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z5 = z2;
                z6 = z3;
            }
        } else if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            if (z9) {
                if (!z10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (count < count2) {
                    z7 = true;
                    boolean z12 = z4;
                    z5 = z2;
                    z6 = true;
                    z8 = z12;
                } else {
                    z5 = true;
                    z6 = z3;
                }
            } else if (z10) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z8 = z4;
                z5 = z2;
                z6 = z3;
            }
        }
        if (z6) {
            if (z5) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(this.oddCounts, this.oddRoundingErrors);
        }
        if (z5) {
            decrement(this.oddCounts, this.oddRoundingErrors);
        }
        if (z8) {
            if (z7) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(this.evenCounts, this.oddRoundingErrors);
        }
        if (z7) {
            decrement(this.evenCounts, this.evenRoundingErrors);
        }
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int value = pair.getFinderPattern().getValue();
        int value2 = pair2.getFinderPattern().getValue();
        if ((value != 0 || value2 != 8) && value == 8 && value2 == 0) {
        }
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value3 = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value3 > 72) {
            value3--;
        }
        if (value3 > 8) {
            value3--;
        }
        return checksumPortion == value3;
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String valueOf = String.valueOf((4537077 * pair.getValue()) + pair2.getValue());
        StringBuffer stringBuffer = new StringBuffer(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            stringBuffer.append('0');
        }
        stringBuffer.append(valueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int charAt = stringBuffer.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                charAt *= 3;
            }
            i += charAt;
        }
        int i3 = 10 - (i % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        stringBuffer.append(i3);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(String.valueOf(stringBuffer.toString()), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS14);
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) {
        int[] iArr = this.dataCharacterCounters;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
        if (z) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], iArr);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, iArr);
            int i = 0;
            for (int length = iArr.length - 1; i < length; length--) {
                int i2 = iArr[i];
                iArr[i] = iArr[length];
                iArr[length] = i2;
                i++;
            }
        }
        int i3 = z ? 16 : 15;
        float count = count(iArr) / i3;
        int[] iArr2 = this.oddCounts;
        int[] iArr3 = this.evenCounts;
        float[] fArr = this.oddRoundingErrors;
        float[] fArr2 = this.evenRoundingErrors;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f = iArr[i4] / count;
            int i5 = (int) (0.5f + f);
            if (i5 < 1) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 >> 1;
            if ((i4 & 1) == 0) {
                iArr2[i6] = i5;
                fArr[i6] = f - i5;
            } else {
                iArr3[i6] = i5;
                fArr2[i6] = f - i5;
            }
        }
        adjustOddEvenCounts(z, i3);
        int length2 = iArr2.length - 1;
        int i7 = 0;
        int i8 = 0;
        while (length2 >= 0) {
            int i9 = (i7 * 9) + iArr2[length2];
            length2--;
            i7 = i9;
            i8 = iArr2[length2] + i8;
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + iArr3[length3];
            i11 += iArr3[length3];
        }
        int i12 = i7 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i13 = (10 - i11) / 2;
            int i14 = INSIDE_ODD_WIDEST[i13];
            return new DataCharacter(RSSUtils.getRSSvalue(iArr2, i14, true) + (RSSUtils.getRSSvalue(iArr3, 9 - i14, false) * INSIDE_ODD_TOTAL_SUBSET[i13]) + INSIDE_GSUM[i13], i12);
        } else if ((i8 & 1) != 0 || i8 > 12 || i8 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i15 = (12 - i8) / 2;
            int i16 = OUTSIDE_ODD_WIDEST[i15];
            return new DataCharacter((RSSUtils.getRSSvalue(iArr2, i16, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i15]) + RSSUtils.getRSSvalue(iArr3, 9 - i16, true) + OUTSIDE_GSUM[i15], i12);
        }
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i, Hashtable hashtable) {
        try {
            int[] findFinderPattern = findFinderPattern(bitArray, 0, z);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z, findFinderPattern);
            ResultPointCallback resultPointCallback = hashtable == null ? null : (ResultPointCallback) hashtable.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float f = (findFinderPattern[0] + findFinderPattern[1]) / 2.0f;
                if (z) {
                    f = (bitArray.getSize() - 1) - f;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f, i));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private int[] findFinderPattern(BitArray bitArray, int i, boolean z) {
        int[] iArr = this.decodeFinderCounters;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
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
        boolean z3 = z2;
        int i3 = i2;
        int i4 = 0;
        for (int i5 = i2; i5 < size; i5++) {
            if (bitArray.get(i5) ^ z3) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else if (isFinderPattern(iArr)) {
                    return new int[]{i3, i5};
                } else {
                    i3 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                z3 = !z3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) {
        int i2;
        boolean z2 = bitArray.get(iArr[0]);
        int i3 = iArr[0] - 1;
        while (i3 >= 0 && (bitArray.get(i3) ^ z2)) {
            i3--;
        }
        int i4 = i3 + 1;
        int i5 = iArr[0] - i4;
        int[] iArr2 = this.decodeFinderCounters;
        for (int length = iArr2.length - 1; length > 0; length--) {
            iArr2[length] = iArr2[length - 1];
        }
        iArr2[0] = i5;
        int parseFinderValue = parseFinderValue(iArr2, FINDER_PATTERNS);
        int i6 = iArr[1];
        if (z) {
            i2 = (bitArray.getSize() - 1) - i4;
            i6 = (bitArray.getSize() - 1) - i6;
        } else {
            i2 = i4;
        }
        return new FinderPattern(parseFinderValue, new int[]{i4, iArr[1]}, i2, i6, i);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, hashtable));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, hashtable));
        bitArray.reverse();
        int size = this.possibleLeftPairs.size();
        int size2 = this.possibleRightPairs.size();
        for (int i2 = 0; i2 < size; i2++) {
            Pair pair = (Pair) this.possibleLeftPairs.elementAt(i2);
            if (pair.getCount() > 1) {
                for (int i3 = 0; i3 < size2; i3++) {
                    Pair pair2 = (Pair) this.possibleRightPairs.elementAt(i3);
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.setSize(0);
        this.possibleRightPairs.setSize(0);
    }
}
