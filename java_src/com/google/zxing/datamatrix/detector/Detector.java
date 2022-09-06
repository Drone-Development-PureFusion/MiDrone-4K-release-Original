package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.Collections;
import com.google.zxing.common.Comparator;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
/* loaded from: classes.dex */
public final class Detector {
    private static final Integer[] INTEGERS = {new Integer(0), new Integer(1), new Integer(2), new Integer(3), new Integer(4)};
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.zxing.datamatrix.detector.Detector$1 */
    /* loaded from: classes.dex */
    public static class C40791 {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ResultPointsAndTransitions {
        private final ResultPoint from;

        /* renamed from: to */
        private final ResultPoint f17081to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.f17081to = resultPoint2;
            this.transitions = i;
        }

        ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i, C40791 c40791) {
            this(resultPoint, resultPoint2, i);
        }

        public ResultPoint getFrom() {
            return this.from;
        }

        public ResultPoint getTo() {
            return this.f17081to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return new StringBuffer().append(this.from).append("/").append(this.f17081to).append('/').append(this.transitions).toString();
        }
    }

    /* loaded from: classes.dex */
    private static class ResultPointsAndTransitionsComparator implements Comparator {
        private ResultPointsAndTransitionsComparator() {
        }

        ResultPointsAndTransitionsComparator(C40791 c40791) {
            this();
        }

        @Override // com.google.zxing.common.Comparator
        public int compare(Object obj, Object obj2) {
            return ((ResultPointsAndTransitions) obj).getTransitions() - ((ResultPointsAndTransitions) obj2).getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float distance = distance(resultPoint, resultPoint2) / i;
        int distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint((((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance) + resultPoint4.getX(), (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)) + resultPoint4.getY());
        float distance3 = distance(resultPoint, resultPoint2) / i;
        int distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint((((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3) + resultPoint4.getX(), (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)) + resultPoint4.getY());
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        } else if (!isValid(resultPoint6)) {
            return null;
        } else {
            return resultPoint6;
        }
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return round((float) Math.sqrt(((resultPoint.getX() - resultPoint2.getX()) * (resultPoint.getX() - resultPoint2.getX())) + ((resultPoint.getY() - resultPoint2.getY()) * (resultPoint.getY() - resultPoint2.getY()))));
    }

    private static void increment(Hashtable hashtable, ResultPoint resultPoint) {
        Integer num = (Integer) hashtable.get(resultPoint);
        hashtable.put(resultPoint, num == null ? INTEGERS[1] : INTEGERS[num.intValue() + 1]);
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.width) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.height);
    }

    private static int round(float f) {
        return (int) (0.5f + f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, 0.5f, 0.5f, i - 0.5f, 0.5f, i - 0.5f, i - 0.5f, 0.5f, i - 0.5f, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int i;
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        if (!z) {
            y2 = x2;
            x2 = y2;
            y = x;
            x = y;
        }
        int abs = Math.abs(y2 - y);
        int abs2 = Math.abs(x2 - x);
        int i2 = (-abs) >> 1;
        int i3 = x < x2 ? 1 : -1;
        int i4 = y < y2 ? 1 : -1;
        int i5 = 0;
        boolean z2 = this.image.get(z ? x : y, z ? y : x);
        int i6 = x;
        int i7 = i2;
        while (true) {
            if (y == y2) {
                i = i5;
                break;
            }
            boolean z3 = this.image.get(z ? i6 : y, z ? y : i6);
            if (z3 != z2) {
                i5++;
                z2 = z3;
            }
            int i8 = i7 + abs2;
            if (i8 > 0) {
                if (i6 == x2) {
                    i = i5;
                    break;
                }
                i6 += i3;
                i8 -= abs;
            }
            y += i4;
            i7 = i8;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i, null);
    }

    public DetectorResult detect() {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint3 = detect[0];
        ResultPoint resultPoint4 = detect[1];
        ResultPoint resultPoint5 = detect[2];
        ResultPoint resultPoint6 = detect[3];
        Vector vector = new Vector(4);
        vector.addElement(transitionsBetween(resultPoint3, resultPoint4));
        vector.addElement(transitionsBetween(resultPoint3, resultPoint5));
        vector.addElement(transitionsBetween(resultPoint4, resultPoint6));
        vector.addElement(transitionsBetween(resultPoint5, resultPoint6));
        Collections.insertionSort(vector, new ResultPointsAndTransitionsComparator(null));
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) vector.elementAt(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) vector.elementAt(1);
        Hashtable hashtable = new Hashtable();
        increment(hashtable, resultPointsAndTransitions.getFrom());
        increment(hashtable, resultPointsAndTransitions.getTo());
        increment(hashtable, resultPointsAndTransitions2.getFrom());
        increment(hashtable, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint7 = null;
        ResultPoint resultPoint8 = null;
        ResultPoint resultPoint9 = null;
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            ResultPoint resultPoint10 = (ResultPoint) keys.nextElement();
            if (((Integer) hashtable.get(resultPoint10)).intValue() == 2) {
                resultPoint = resultPoint10;
                resultPoint10 = resultPoint9;
                resultPoint2 = resultPoint7;
            } else if (resultPoint7 == null) {
                resultPoint = resultPoint8;
                ResultPoint resultPoint11 = resultPoint9;
                resultPoint2 = resultPoint10;
                resultPoint10 = resultPoint11;
            } else {
                resultPoint = resultPoint8;
                resultPoint2 = resultPoint7;
            }
            resultPoint8 = resultPoint;
            resultPoint7 = resultPoint2;
            resultPoint9 = resultPoint10;
        }
        if (resultPoint7 == null || resultPoint8 == null || resultPoint9 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr = {resultPoint7, resultPoint8, resultPoint9};
        ResultPoint.orderBestPatterns(resultPointArr);
        ResultPoint resultPoint12 = resultPointArr[0];
        ResultPoint resultPoint13 = resultPointArr[1];
        ResultPoint resultPoint14 = resultPointArr[2];
        ResultPoint resultPoint15 = !hashtable.containsKey(resultPoint3) ? resultPoint3 : !hashtable.containsKey(resultPoint4) ? resultPoint4 : !hashtable.containsKey(resultPoint5) ? resultPoint5 : resultPoint6;
        int min = Math.min(transitionsBetween(resultPoint14, resultPoint15).getTransitions(), transitionsBetween(resultPoint12, resultPoint15).getTransitions());
        if ((min & 1) == 1) {
            min++;
        }
        ResultPoint correctTopRight = correctTopRight(resultPoint13, resultPoint12, resultPoint14, resultPoint15, min + 2);
        if (correctTopRight == null) {
            correctTopRight = resultPoint15;
        }
        int max = Math.max(transitionsBetween(resultPoint14, correctTopRight).getTransitions(), transitionsBetween(resultPoint12, correctTopRight).getTransitions()) + 1;
        if ((max & 1) == 1) {
            max++;
        }
        return new DetectorResult(sampleGrid(this.image, resultPoint14, resultPoint13, resultPoint12, correctTopRight, max), new ResultPoint[]{resultPoint14, resultPoint13, resultPoint12, correctTopRight});
    }
}
