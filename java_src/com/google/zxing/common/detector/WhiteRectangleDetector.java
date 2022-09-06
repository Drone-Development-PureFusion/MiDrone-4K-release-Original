package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 40;
    private final int height;
    private final BitMatrix image;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        return x < ((float) (this.width / 2)) ? new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)} : new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private static int distanceL2(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return round((float) Math.sqrt((f5 * f5) + (f6 * f6)));
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int distanceL2 = distanceL2(f, f2, f3, f4);
        float f5 = (f3 - f) / distanceL2;
        float f6 = (f4 - f2) / distanceL2;
        for (int i = 0; i < distanceL2; i++) {
            int round = round((i * f5) + f);
            int round2 = round((i * f6) + f2);
            if (this.image.get(round, round2)) {
                return new ResultPoint(round, round2);
            }
        }
        return null;
    }

    private static int round(float f) {
        return (int) (0.5f + f);
    }

    public ResultPoint[] detect() {
        int i;
        int i2;
        int i3;
        int i4;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        boolean z = false;
        int i5 = (this.width - 40) >> 1;
        int i6 = (this.width + 40) >> 1;
        int i7 = (this.height - 40) >> 1;
        int i8 = (this.height + 40) >> 1;
        boolean z2 = false;
        boolean z3 = true;
        while (true) {
            if (!z3) {
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            boolean z4 = true;
            boolean z5 = false;
            while (z4 && i6 < this.width) {
                z4 = containsBlackPoint(i7, i8, i6, false);
                if (z4) {
                    i6++;
                    z5 = true;
                }
            }
            if (i6 >= this.width) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            boolean z6 = true;
            while (z6 && i8 < this.height) {
                z6 = containsBlackPoint(i5, i6, i8, true);
                if (z6) {
                    i8++;
                    z5 = true;
                }
            }
            if (i8 >= this.height) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            boolean z7 = true;
            while (z7 && i5 >= 0) {
                z7 = containsBlackPoint(i7, i8, i5, false);
                if (z7) {
                    i5--;
                    z5 = true;
                }
            }
            if (i5 < 0) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            z3 = z5;
            boolean z8 = true;
            while (z8 && i7 >= 0) {
                z8 = containsBlackPoint(i5, i6, i7, true);
                if (z8) {
                    i7--;
                    z3 = true;
                }
            }
            if (i7 < 0) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            } else if (z3) {
                z2 = true;
            }
        }
        if (z || !z2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i9 = i - i3;
        int i10 = 1;
        ResultPoint resultPoint4 = null;
        while (true) {
            if (i10 >= i9) {
                resultPoint = resultPoint4;
                break;
            }
            resultPoint4 = getBlackPointOnSegment(i3, i2 - i10, i3 + i10, i2);
            if (resultPoint4 != null) {
                resultPoint = resultPoint4;
                break;
            }
            i10++;
        }
        if (resultPoint == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = 1;
        ResultPoint resultPoint5 = null;
        while (true) {
            if (i11 >= i9) {
                resultPoint2 = resultPoint5;
                break;
            }
            resultPoint5 = getBlackPointOnSegment(i3, i4 + i11, i3 + i11, i4);
            if (resultPoint5 != null) {
                resultPoint2 = resultPoint5;
                break;
            }
            i11++;
        }
        if (resultPoint2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = 1;
        ResultPoint resultPoint6 = null;
        while (true) {
            if (i12 >= i9) {
                resultPoint3 = resultPoint6;
                break;
            }
            resultPoint6 = getBlackPointOnSegment(i, i4 + i12, i - i12, i4);
            if (resultPoint6 != null) {
                resultPoint3 = resultPoint6;
                break;
            }
            i12++;
        }
        if (resultPoint3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint7 = null;
        for (int i13 = 1; i13 < i9; i13++) {
            resultPoint7 = getBlackPointOnSegment(i, i2 - i13, i - i13, i2);
            if (resultPoint7 != null) {
                break;
            }
        }
        if (resultPoint7 != null) {
            return centerEdges(resultPoint7, resultPoint, resultPoint3, resultPoint2);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
