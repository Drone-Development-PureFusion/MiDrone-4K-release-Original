package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.Collections;
import com.google.zxing.common.Comparator;
import java.util.Hashtable;
import java.util.Vector;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    private static final int INTEGER_MATH_SHIFT = 8;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final Vector possibleCenters;
    private final ResultPointCallback resultPointCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CenterComparator implements Comparator {
        private final float average;

        public CenterComparator(float f) {
            this.average = f;
        }

        @Override // com.google.zxing.common.Comparator
        public int compare(Object obj, Object obj2) {
            if (((FinderPattern) obj2).getCount() != ((FinderPattern) obj).getCount()) {
                return ((FinderPattern) obj2).getCount() - ((FinderPattern) obj).getCount();
            }
            float abs = Math.abs(((FinderPattern) obj2).getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(((FinderPattern) obj).getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FurthestFromAverageComparator implements Comparator {
        private final float average;

        public FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        @Override // com.google.zxing.common.Comparator
        public int compare(Object obj, Object obj2) {
            float abs = Math.abs(((FinderPattern) obj2).getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(((FinderPattern) obj).getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new Vector();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r2.get(r1, r13) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
        if (r4[0] > r14) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.get(r1, r13) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
        if (r2.get(r1, r13) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
        if (r4[3] >= r14) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007c, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0089, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008b, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0091, code lost:
        if (r2.get(r1, r13) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0095, code lost:
        if (r4[4] >= r14) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a2, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ba, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= r15) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c0, code lost:
        if (foundPatternCross(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r2.get(r13, r1) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
        if (r4[0] > r14) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.get(r13, r1) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
        if (r2.get(r13, r1) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
        if (r4[3] >= r14) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007c, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0089, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008b, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0091, code lost:
        if (r2.get(r13, r1) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0095, code lost:
        if (r4[4] >= r14) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a2, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bc, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= (r15 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c2, code lost:
        if (foundPatternCross(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    private int findRowSkip() {
        int size = this.possibleCenters.size();
        if (size <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        int i = 0;
        while (i < size) {
            FinderPattern finderPattern2 = (FinderPattern) this.possibleCenters.elementAt(i);
            if (finderPattern2.getCount() < 2) {
                finderPattern2 = finderPattern;
            } else if (finderPattern != null) {
                this.hasSkipped = true;
                return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
            }
            i++;
            finderPattern = finderPattern2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean foundPatternCross(int[] iArr) {
        boolean z = true;
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i >= 7) {
            int i4 = (i << 8) / 7;
            int i5 = i4 / 2;
            if (Math.abs(i4 - (iArr[0] << 8)) >= i5 || Math.abs(i4 - (iArr[1] << 8)) >= i5 || Math.abs((i4 * 3) - (iArr[2] << 8)) >= i5 * 3 || Math.abs(i4 - (iArr[3] << 8)) >= i5 || Math.abs(i4 - (iArr[4] << 8)) >= i5) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int[] getCrossCheckStateCount() {
        this.crossCheckStateCount[0] = 0;
        this.crossCheckStateCount[1] = 0;
        this.crossCheckStateCount[2] = 0;
        this.crossCheckStateCount[3] = 0;
        this.crossCheckStateCount[4] = 0;
        return this.crossCheckStateCount;
    }

    private boolean haveMultiplyConfirmedCenters() {
        float f;
        float f2 = 0.0f;
        int size = this.possibleCenters.size();
        int i = 0;
        float f3 = 0.0f;
        int i2 = 0;
        while (i < size) {
            FinderPattern finderPattern = (FinderPattern) this.possibleCenters.elementAt(i);
            if (finderPattern.getCount() >= 2) {
                i2++;
                f = finderPattern.getEstimatedModuleSize() + f3;
            } else {
                f = f3;
            }
            i++;
            i2 = i2;
            f3 = f;
        }
        if (i2 < 3) {
            return false;
        }
        float f4 = f3 / size;
        for (int i3 = 0; i3 < size; i3++) {
            f2 += Math.abs(((FinderPattern) this.possibleCenters.elementAt(i3)).getEstimatedModuleSize() - f4);
        }
        return f2 <= 0.05f * f3;
    }

    private FinderPattern[] selectBestPatterns() {
        float f = 0.0f;
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size > 3) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i = 0; i < size; i++) {
                float estimatedModuleSize = ((FinderPattern) this.possibleCenters.elementAt(i)).getEstimatedModuleSize();
                f3 += estimatedModuleSize;
                f2 += estimatedModuleSize * estimatedModuleSize;
            }
            float f4 = f3 / size;
            Collections.insertionSort(this.possibleCenters, new FurthestFromAverageComparator(f4));
            float max = Math.max(0.2f * f4, (float) Math.sqrt((f2 / size) - (f4 * f4)));
            int i2 = 0;
            while (i2 < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(((FinderPattern) this.possibleCenters.elementAt(i2)).getEstimatedModuleSize() - f4) > max) {
                    this.possibleCenters.removeElementAt(i2);
                    i2--;
                }
                i2++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            for (int i3 = 0; i3 < this.possibleCenters.size(); i3++) {
                f += ((FinderPattern) this.possibleCenters.elementAt(i3)).getEstimatedModuleSize();
            }
            Collections.insertionSort(this.possibleCenters, new CenterComparator(f / this.possibleCenters.size()));
            this.possibleCenters.setSize(3);
        }
        return new FinderPattern[]{(FinderPattern) this.possibleCenters.elementAt(0), (FinderPattern) this.possibleCenters.elementAt(1), (FinderPattern) this.possibleCenters.elementAt(2)};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinderPatternInfo find(Hashtable hashtable) {
        int i;
        int i2;
        boolean z;
        boolean z2 = hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i3 = (height * 3) / SmileConstants.TOKEN_MISC_LONG_TEXT_UNICODE;
        int i4 = (i3 < 3 || z2) ? 3 : i3;
        int[] iArr = new int[5];
        int i5 = i4 - 1;
        boolean z3 = false;
        int i6 = i4;
        while (i5 < height && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i7 = 0;
            int i8 = 0;
            while (i7 < width) {
                if (this.image.get(i7, i5)) {
                    if ((i8 & 1) == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if ((i8 & 1) != 0) {
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 != 4) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else if (!foundPatternCross(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i8 = 3;
                } else if (handlePossibleCenter(iArr, i5, i7)) {
                    if (this.hasSkipped) {
                        z = haveMultiplyConfirmedCenters();
                    } else {
                        int findRowSkip = findRowSkip();
                        if (findRowSkip > iArr[2]) {
                            i2 = i5 + ((findRowSkip - iArr[2]) - 2);
                            i = width - 1;
                        } else {
                            i = i7;
                            i2 = i5;
                        }
                        i5 = i2;
                        i7 = i;
                        z = z3;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    z3 = z;
                    i6 = 2;
                    i8 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i8 = 3;
                }
                i7++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i5, width)) {
                i6 = iArr[0];
                if (this.hasSkipped) {
                    z3 = haveMultiplyConfirmedCenters();
                }
            }
            i5 += i6;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitMatrix getImage() {
        return this.image;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Vector getPossibleCenters() {
        return this.possibleCenters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handlePossibleCenter(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[2], i3);
        if (!Float.isNaN(crossCheckVertical)) {
            float crossCheckHorizontal = crossCheckHorizontal((int) centerFromEnd, (int) crossCheckVertical, iArr[2], i3);
            if (!Float.isNaN(crossCheckHorizontal)) {
                float f = i3 / 7.0f;
                int size = this.possibleCenters.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    FinderPattern finderPattern = (FinderPattern) this.possibleCenters.elementAt(i4);
                    if (finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                        finderPattern.incrementCount();
                        z = true;
                        break;
                    }
                    i4++;
                }
                if (!z) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
                    this.possibleCenters.addElement(finderPattern2);
                    if (this.resultPointCallback != null) {
                        this.resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
