package com.google.zxing.oned.rss.expanded;

import com.facebook.imageutils.JfifUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import it.p235a.p236a.AbstractC4863e;
import java.util.Hashtable;
import java.util.Vector;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, Opcodes.GETFIELD, Opcodes.FNEG, Opcodes.D2L, 7, 21, 63}, new int[]{Opcodes.ANEWARRAY, 145, 13, 39, Opcodes.LNEG, 140, 209, 205}, new int[]{193, Opcodes.IFGT, 49, 147, 19, 57, Opcodes.LOOKUPSWITCH, 91}, new int[]{62, Opcodes.INVOKEDYNAMIC, 136, 197, Opcodes.RET, 85, 44, 132}, new int[]{Opcodes.INVOKEINTERFACE, 133, Opcodes.NEWARRAY, Opcodes.D2I, 4, 12, 36, 108}, new int[]{113, 128, Opcodes.LRETURN, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, Opcodes.LSHR, Opcodes.IFLE, 52, Opcodes.IFGE}, new int[]{46, 138, 203, Opcodes.NEW, 139, 206, SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING, Opcodes.IF_ACMPNE}, new int[]{76, 17, 51, 153, 37, Opcodes.DDIV, 122, Opcodes.IFLT}, new int[]{43, 129, 176, 106, Opcodes.DMUL, 110, Opcodes.DNEG, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, Opcodes.RETURN}, new int[]{Opcodes.LDIV, Opcodes.INEG, 137, 200, Opcodes.GETSTATIC, 112, 125, Opcodes.IF_ICMPLE}, new int[]{70, 210, JfifUtil.MARKER_RST0, 202, 184, 130, Opcodes.PUTSTATIC, Opcodes.DREM}, new int[]{134, Opcodes.ATHROW, 151, 31, 93, 68, 204, Opcodes.ARRAYLENGTH}, new int[]{148, 22, 66, 198, Opcodes.IRETURN, 94, 71, 2}, new int[]{6, 18, 54, Opcodes.IF_ICMPGE, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, 199, Opcodes.DRETURN}, new int[]{103, 98, 83, 38, 114, 131, Opcodes.INVOKEVIRTUAL, Opcodes.IUSHR}, new int[]{Opcodes.IF_ICMPLT, 61, Opcodes.INVOKESPECIAL, 127, 170, 88, 53, Opcodes.IF_ICMPEQ}, new int[]{55, Opcodes.IF_ACMPEQ, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, Opcodes.FRETURN, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int LONGEST_SEQUENCE_SIZE = FINDER_PATTERN_SEQUENCES[FINDER_PATTERN_SEQUENCES.length - 1].length;
    private final Vector pairs = new Vector(11);
    private final int[] startEnd = new int[2];
    private final int[] currentSequence = new int[LONGEST_SEQUENCE_SIZE];

    private void adjustOddEvenCounts(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        boolean z7 = true;
        int count = count(this.oddCounts);
        int count2 = count(this.evenCounts);
        int i2 = (count + count2) - i;
        boolean z8 = (count & 1) == 1;
        boolean z9 = (count2 & 1) == 0;
        if (count > 13) {
            z = true;
            z2 = false;
        } else if (count < 4) {
            z = false;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (count2 > 13) {
            z3 = false;
            z6 = true;
        } else {
            z3 = count2 < 4;
        }
        if (i2 == 1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z5 = z2;
                z7 = z3;
                z4 = true;
            } else if (!z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z6 = true;
                z7 = z3;
                z4 = z;
                z5 = z2;
            }
        } else if (i2 == -1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                boolean z10 = z3;
                z4 = z;
                z5 = true;
                z7 = z10;
            } else if (!z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z4 = z;
                z5 = z2;
            }
        } else if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            if (z8) {
                if (!z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (count < count2) {
                    z6 = true;
                    boolean z11 = z3;
                    z4 = z;
                    z5 = true;
                    z7 = z11;
                } else {
                    z4 = true;
                    z5 = z2;
                }
            } else if (z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z7 = z3;
                z4 = z;
                z5 = z2;
            }
        }
        if (z5) {
            if (z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(this.oddCounts, this.oddRoundingErrors);
        }
        if (z4) {
            decrement(this.oddCounts, this.oddRoundingErrors);
        }
        if (z7) {
            if (z6) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(this.evenCounts, this.oddRoundingErrors);
        }
        if (z6) {
            decrement(this.evenCounts, this.evenRoundingErrors);
        }
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = (ExpandedPair) this.pairs.elementAt(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        int i = 2;
        int checksumPortion = expandedPair.getRightChar().getChecksumPortion();
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            ExpandedPair expandedPair2 = (ExpandedPair) this.pairs.elementAt(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i++;
            if (expandedPair2.getRightChar() != null) {
                checksumPortion += expandedPair2.getRightChar().getChecksumPortion();
                i++;
            }
        }
        return (checksumPortion % AbstractC4863e.f20813v) + ((i + (-4)) * AbstractC4863e.f20813v) == leftChar.getValue();
    }

    private boolean checkPairSequence(Vector vector, FinderPattern finderPattern) {
        boolean z;
        int size = vector.size() + 1;
        if (size > this.currentSequence.length) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i = 0; i < vector.size(); i++) {
            this.currentSequence[i] = ((ExpandedPair) vector.elementAt(i)).getFinderPattern().getValue();
        }
        this.currentSequence[size - 1] = finderPattern.getValue();
        for (int i2 = 0; i2 < FINDER_PATTERN_SEQUENCES.length; i2++) {
            int[] iArr = FINDER_PATTERN_SEQUENCES[i2];
            if (iArr.length >= size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z = true;
                        break;
                    } else if (this.currentSequence[i3] != iArr[i3]) {
                        z = false;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    return size == iArr.length;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Result constructResult(Vector vector) {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(vector)).parseInformation();
        ResultPoint[] resultPoints = ((ExpandedPair) vector.elementAt(0)).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = ((ExpandedPair) vector.lastElement()).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, Vector vector, int i) {
        int[] iArr = this.decodeFinderCounters;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            i = vector.isEmpty() ? 0 : ((ExpandedPair) vector.lastElement()).getFinderPattern().getStartEnd()[1];
        }
        boolean z = vector.size() % 2 != 0;
        boolean z2 = false;
        int i2 = i;
        while (i2 < size) {
            z2 = !bitArray.get(i2);
            if (!z2) {
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
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (z) {
                        reverseCounters(iArr);
                    }
                    if (isFinderPattern(iArr)) {
                        this.startEnd[0] = i5;
                        this.startEnd[1] = i6;
                        return;
                    }
                    if (z) {
                        reverseCounters(iArr);
                    }
                    i5 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                iArr[i4] = 1;
                z3 = !z3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        boolean z = bitArray.get(i);
        while (i < bitArray.size && bitArray.get(i) == z) {
            i++;
        }
        boolean z2 = !z;
        while (i < bitArray.size && bitArray.get(i) == z2) {
            i++;
        }
        return i;
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return finderPattern.getValue() != 0 || !z || !z2;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.startEnd[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            i2 = i5 + 1;
            i4 = this.startEnd[0] - i2;
            i3 = this.startEnd[1];
        } else {
            i2 = this.startEnd[0];
            int i6 = this.startEnd[1];
            while (true) {
                i6++;
                if (!bitArray.get(i6) || i6 >= bitArray.size) {
                    break;
                }
            }
            i3 = i6;
            i4 = i6 - this.startEnd[1];
        }
        int[] iArr = this.decodeFinderCounters;
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        iArr[0] = i4;
        try {
            return new FinderPattern(parseFinderValue(iArr, FINDER_PATTERNS), new int[]{i2, i3}, i2, i3, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(length - i) - 1];
            iArr[(length - i) - 1] = i2;
        }
    }

    DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) {
        int[] iArr = this.dataCharacterCounters;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
        if (z2) {
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
        float count = count(iArr) / 17;
        int[] iArr2 = this.oddCounts;
        int[] iArr3 = this.evenCounts;
        float[] fArr = this.oddRoundingErrors;
        float[] fArr2 = this.evenRoundingErrors;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f = (1.0f * iArr[i3]) / count;
            int i4 = (int) (0.5f + f);
            if (i4 < 1) {
                i4 = 1;
            } else if (i4 > 8) {
                i4 = 8;
            }
            int i5 = i3 >> 1;
            if ((i3 & 1) == 0) {
                iArr2[i5] = i4;
                fArr[i5] = f - i4;
            } else {
                iArr3[i5] = i4;
                fArr2[i5] = f - i4;
            }
        }
        adjustOddEvenCounts(17);
        int value = ((z2 ? 0 : 1) + ((finderPattern.getValue() * 4) + (z ? 0 : 2))) - 1;
        int i6 = 0;
        int length2 = iArr2.length - 1;
        int i7 = 0;
        while (length2 >= 0) {
            if (isNotA1left(finderPattern, z, z2)) {
                i7 += WEIGHTS[value][length2 * 2] * iArr2[length2];
            }
            length2--;
            i6 = iArr2[length2] + i6;
        }
        int i8 = 0;
        int i9 = 0;
        for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i8 += WEIGHTS[value][(length3 * 2) + 1] * iArr3[length3];
            }
            i9 += iArr3[length3];
        }
        int i10 = i7 + i8;
        if ((i6 & 1) != 0 || i6 > 13 || i6 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = (13 - i6) / 2;
        int i12 = SYMBOL_WIDEST[i11];
        return new DataCharacter(GSUM[i11] + (RSSUtils.getRSSvalue(iArr2, i12, true) * EVEN_TOTAL_SUBSET[i11]) + RSSUtils.getRSSvalue(iArr3, 9 - i12, false), i10);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        reset();
        decodeRow2pairs(i, bitArray);
        return constructResult(this.pairs);
    }

    Vector decodeRow2pairs(int i, BitArray bitArray) {
        while (true) {
            ExpandedPair retrieveNextPair = retrieveNextPair(bitArray, this.pairs, i);
            this.pairs.addElement(retrieveNextPair);
            if (retrieveNextPair.mayBeLast()) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                if (retrieveNextPair.mustBeLast()) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.setSize(0);
    }

    ExpandedPair retrieveNextPair(BitArray bitArray, Vector vector, int i) {
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        boolean z = vector.size() % 2 == 0;
        int i2 = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, vector, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        boolean checkPairSequence = checkPairSequence(vector, parseFoundFinderPattern);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
        try {
            dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
        } catch (NotFoundException e) {
            if (!checkPairSequence) {
                throw e;
            }
            dataCharacter = null;
        }
        return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, checkPairSequence);
    }
}
