package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.Collections;
import com.google.zxing.common.Comparator;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.util.Hashtable;
import java.util.Vector;
/* loaded from: classes.dex */
final class MultiFinderPatternFinder extends FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder$1 */
    /* loaded from: classes.dex */
    public static class C40801 {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ModuleSizeComparator implements Comparator {
        private ModuleSizeComparator() {
        }

        ModuleSizeComparator(C40801 c40801) {
            this();
        }

        @Override // com.google.zxing.common.Comparator
        public int compare(Object obj, Object obj2) {
            float estimatedModuleSize = ((FinderPattern) obj2).getEstimatedModuleSize() - ((FinderPattern) obj).getEstimatedModuleSize();
            if (estimatedModuleSize < 0.0d) {
                return -1;
            }
            return ((double) estimatedModuleSize) > 0.0d ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiFinderPatternFinder(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    MultiFinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }

    private FinderPattern[][] selectBestPatterns() {
        Vector possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size == 3) {
            return new FinderPattern[][]{new FinderPattern[]{(FinderPattern) possibleCenters.elementAt(0), (FinderPattern) possibleCenters.elementAt(1), (FinderPattern) possibleCenters.elementAt(2)}};
        }
        Collections.insertionSort(possibleCenters, new ModuleSizeComparator(null));
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 2) {
                break;
            }
            FinderPattern finderPattern = (FinderPattern) possibleCenters.elementAt(i2);
            if (finderPattern != null) {
                int i3 = i2 + 1;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size - 1) {
                        break;
                    }
                    FinderPattern finderPattern2 = (FinderPattern) possibleCenters.elementAt(i4);
                    if (finderPattern2 != null) {
                        float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) <= DIFF_MODSIZE_CUTOFF || estimatedModuleSize < DIFF_MODSIZE_CUTOFF_PERCENT) {
                            for (int i5 = i4 + 1; i5 < size; i5++) {
                                FinderPattern finderPattern3 = (FinderPattern) possibleCenters.elementAt(i5);
                                if (finderPattern3 != null) {
                                    float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                    if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) <= DIFF_MODSIZE_CUTOFF || estimatedModuleSize2 < DIFF_MODSIZE_CUTOFF_PERCENT) {
                                        FinderPattern[] finderPatternArr = {finderPattern, finderPattern2, finderPattern3};
                                        ResultPoint.orderBestPatterns(finderPatternArr);
                                        FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr);
                                        float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                        float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                        float distance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                        float estimatedModuleSize3 = ((distance + distance3) / finderPattern.getEstimatedModuleSize()) / 2.0f;
                                        if (estimatedModuleSize3 <= 180.0f && estimatedModuleSize3 >= MIN_MODULE_COUNT_PER_EDGE && Math.abs((distance - distance3) / Math.min(distance, distance3)) < 0.1f) {
                                            float sqrt = (float) Math.sqrt((distance3 * distance3) + (distance * distance));
                                            if (Math.abs((distance2 - sqrt) / Math.min(distance2, sqrt)) < 0.1f) {
                                                vector.addElement(finderPatternArr);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
        if (vector.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        FinderPattern[][] finderPatternArr2 = new FinderPattern[vector.size()];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= vector.size()) {
                return finderPatternArr2;
            }
            finderPatternArr2[i7] = (FinderPattern[]) vector.elementAt(i7);
            i6 = i7 + 1;
        }
    }

    public FinderPatternInfo[] findMulti(Hashtable hashtable) {
        int i;
        boolean z = hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER);
        BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i2 = (int) ((height / 228.0f) * 3.0f);
        int i3 = (i2 < 3 || z) ? 3 : i2;
        int[] iArr = new int[5];
        for (int i4 = i3 - 1; i4 < height; i4 += i3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i5 = 0;
            int i6 = 0;
            while (i5 < width) {
                if (image.get(i5, i4)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 != 4) {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                } else if (foundPatternCross(iArr)) {
                    if (!handlePossibleCenter(iArr, i4, i5)) {
                        do {
                            i5++;
                            if (i5 >= width) {
                                break;
                            }
                        } while (!image.get(i5, i4));
                        i = i5 - 1;
                    } else {
                        i = i5;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i5 = i;
                    i6 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i6 = 3;
                }
                i5++;
            }
            if (foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i4, width);
            }
        }
        FinderPattern[][] selectBestPatterns = selectBestPatterns();
        Vector vector = new Vector();
        for (FinderPattern[] finderPatternArr : selectBestPatterns) {
            ResultPoint.orderBestPatterns(finderPatternArr);
            vector.addElement(new FinderPatternInfo(finderPatternArr));
        }
        if (vector.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        FinderPatternInfo[] finderPatternInfoArr = new FinderPatternInfo[vector.size()];
        for (int i7 = 0; i7 < vector.size(); i7++) {
            finderPatternInfoArr[i7] = (FinderPatternInfo) vector.elementAt(i7);
        }
        return finderPatternInfoArr;
    }
}
