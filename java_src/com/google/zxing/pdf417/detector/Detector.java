package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class Detector {
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;
    private static final int SKEW_THRESHOLD = 2;
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] START_PATTERN_REVERSE = {3, 1, 1, 1, 1, 1, 1, 8};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static final int[] STOP_PATTERN_REVERSE = {1, 2, 1, 1, 1, 3, 1, 1, 7};
    private final BinaryBitmap image;

    public Detector(BinaryBitmap binaryBitmap) {
        this.image = binaryBitmap;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, float f) {
        return ((((round(ResultPoint.distance(resultPoint, resultPoint2) / f) + round(ResultPoint.distance(resultPoint3, resultPoint4) / f)) >> 1) + 8) / 17) * 17;
    }

    private static float computeModuleWidth(ResultPoint[] resultPointArr) {
        return (((ResultPoint.distance(resultPointArr[0], resultPointArr[4]) + ResultPoint.distance(resultPointArr[1], resultPointArr[5])) / 34.0f) + ((ResultPoint.distance(resultPointArr[6], resultPointArr[2]) + ResultPoint.distance(resultPointArr[7], resultPointArr[3])) / 36.0f)) / 2.0f;
    }

    private static void correctCodeWordVertices(ResultPoint[] resultPointArr, boolean z) {
        float y = resultPointArr[4].getY() - resultPointArr[6].getY();
        if (z) {
            y = -y;
        }
        if (y > 2.0f) {
            float x = resultPointArr[4].getX() - resultPointArr[0].getX();
            resultPointArr[4] = new ResultPoint(resultPointArr[4].getX(), ((x * (resultPointArr[6].getY() - resultPointArr[0].getY())) / (resultPointArr[6].getX() - resultPointArr[0].getX())) + resultPointArr[4].getY());
        } else if ((-y) > 2.0f) {
            float x2 = resultPointArr[2].getX() - resultPointArr[6].getX();
            float x3 = resultPointArr[2].getX() - resultPointArr[4].getX();
            resultPointArr[6] = new ResultPoint(resultPointArr[6].getX(), resultPointArr[6].getY() - ((x2 * (resultPointArr[2].getY() - resultPointArr[4].getY())) / x3));
        }
        float y2 = resultPointArr[7].getY() - resultPointArr[5].getY();
        if (z) {
            y2 = -y2;
        }
        if (y2 > 2.0f) {
            float x4 = resultPointArr[5].getX() - resultPointArr[1].getX();
            resultPointArr[5] = new ResultPoint(resultPointArr[5].getX(), ((x4 * (resultPointArr[7].getY() - resultPointArr[1].getY())) / (resultPointArr[7].getX() - resultPointArr[1].getX())) + resultPointArr[5].getY());
        } else if ((-y2) <= 2.0f) {
        } else {
            float x5 = resultPointArr[3].getX() - resultPointArr[7].getX();
            float x6 = resultPointArr[3].getX() - resultPointArr[5].getX();
            resultPointArr[7] = new ResultPoint(resultPointArr[7].getX(), resultPointArr[7].getY() - ((x5 * (resultPointArr[3].getY() - resultPointArr[5].getY())) / x6));
        }
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i4 = 0;
        int i5 = i;
        boolean z2 = z;
        for (int i6 = i; i6 < i + i3; i6++) {
            if (bitMatrix.get(i6, i2) ^ z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (patternMatchVariance(iArr2, iArr, 204) < 107) {
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
                z2 = !z2;
            }
        }
        return null;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix) {
        boolean z;
        int[] findGuardPattern;
        int[] findGuardPattern2;
        int[] findGuardPattern3;
        int[] findGuardPattern4;
        boolean z2 = false;
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        int i = 0;
        while (true) {
            if (i >= height) {
                z = false;
                break;
            }
            if (findGuardPattern(bitMatrix, 0, i, width, false, START_PATTERN) != null) {
                resultPointArr[0] = new ResultPoint(findGuardPattern4[0], i);
                resultPointArr[4] = new ResultPoint(findGuardPattern4[1], i);
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            int i2 = height - 1;
            while (true) {
                if (i2 <= 0) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i2, width, false, START_PATTERN) != null) {
                    resultPointArr[1] = new ResultPoint(findGuardPattern3[0], i2);
                    resultPointArr[5] = new ResultPoint(findGuardPattern3[1], i2);
                    z = true;
                    break;
                }
                i2--;
            }
        }
        if (z) {
            int i3 = 0;
            while (true) {
                if (i3 >= height) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i3, width, false, STOP_PATTERN) != null) {
                    resultPointArr[2] = new ResultPoint(findGuardPattern2[1], i3);
                    resultPointArr[6] = new ResultPoint(findGuardPattern2[0], i3);
                    z = true;
                    break;
                }
                i3++;
            }
        }
        if (z) {
            int i4 = height - 1;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i4, width, false, STOP_PATTERN) != null) {
                    resultPointArr[3] = new ResultPoint(findGuardPattern[1], i4);
                    resultPointArr[7] = new ResultPoint(findGuardPattern[0], i4);
                    z2 = true;
                    break;
                }
                i4--;
            }
        } else {
            z2 = z;
        }
        if (z2) {
            return resultPointArr;
        }
        return null;
    }

    private static ResultPoint[] findVertices180(BitMatrix bitMatrix) {
        boolean z;
        int[] findGuardPattern;
        int[] findGuardPattern2;
        int[] findGuardPattern3;
        int[] findGuardPattern4;
        boolean z2 = true;
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth() >> 1;
        ResultPoint[] resultPointArr = new ResultPoint[8];
        int i = height - 1;
        while (true) {
            if (i <= 0) {
                z = false;
                break;
            }
            if (findGuardPattern(bitMatrix, width, i, width, true, START_PATTERN_REVERSE) != null) {
                resultPointArr[0] = new ResultPoint(findGuardPattern4[1], i);
                resultPointArr[4] = new ResultPoint(findGuardPattern4[0], i);
                z = true;
                break;
            }
            i--;
        }
        if (z) {
            int i2 = 0;
            while (true) {
                if (i2 >= height) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, width, i2, width, true, START_PATTERN_REVERSE) != null) {
                    resultPointArr[1] = new ResultPoint(findGuardPattern3[1], i2);
                    resultPointArr[5] = new ResultPoint(findGuardPattern3[0], i2);
                    z = true;
                    break;
                }
                i2++;
            }
        }
        if (z) {
            int i3 = height - 1;
            while (true) {
                if (i3 <= 0) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i3, width, false, STOP_PATTERN_REVERSE) != null) {
                    resultPointArr[2] = new ResultPoint(findGuardPattern2[0], i3);
                    resultPointArr[6] = new ResultPoint(findGuardPattern2[1], i3);
                    z = true;
                    break;
                }
                i3--;
            }
        }
        if (z) {
            int i4 = 0;
            while (true) {
                if (i4 >= height) {
                    z2 = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i4, width, false, STOP_PATTERN_REVERSE) != null) {
                    resultPointArr[3] = new ResultPoint(findGuardPattern[0], i4);
                    resultPointArr[7] = new ResultPoint(findGuardPattern[1], i4);
                    break;
                }
                i4++;
            }
        } else {
            z2 = z;
        }
        if (z2) {
            return resultPointArr;
        }
        return null;
    }

    private static int patternMatchVariance(int[] iArr, int[] iArr2, int i) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i3 += iArr[i4];
            i2 += iArr2[i4];
        }
        if (i3 < i2) {
            return Integer.MAX_VALUE;
        }
        int i5 = (i3 << 8) / i2;
        int i6 = (i * i5) >> 8;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr[i8] << 8;
            int i10 = iArr2[i8] * i5;
            int i11 = i9 > i10 ? i9 - i10 : i10 - i9;
            if (i11 > i6) {
                return Integer.MAX_VALUE;
            }
            i7 += i11;
        }
        return i7 / i3;
    }

    private static int round(float f) {
        return (int) (0.5f + f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, 0.0f, 0.0f, i, 0.0f, i, i, 0.0f, i, resultPoint.getX(), resultPoint.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    public DetectorResult detect() {
        return detect(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DetectorResult detect(Hashtable hashtable) {
        ResultPoint[] resultPointArr;
        BitMatrix blackMatrix = this.image.getBlackMatrix();
        ResultPoint[] findVertices = findVertices(blackMatrix);
        if (findVertices == null) {
            findVertices = findVertices180(blackMatrix);
            if (findVertices != null) {
                correctCodeWordVertices(findVertices, true);
                resultPointArr = findVertices;
                if (resultPointArr != null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float computeModuleWidth = computeModuleWidth(resultPointArr);
                if (computeModuleWidth < 1.0f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int computeDimension = computeDimension(resultPointArr[4], resultPointArr[6], resultPointArr[5], resultPointArr[7], computeModuleWidth);
                if (computeDimension >= 1) {
                    return new DetectorResult(sampleGrid(blackMatrix, resultPointArr[4], resultPointArr[5], resultPointArr[6], resultPointArr[7], computeDimension), new ResultPoint[]{resultPointArr[4], resultPointArr[5], resultPointArr[6], resultPointArr[7]});
                }
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            correctCodeWordVertices(findVertices, false);
        }
        resultPointArr = findVertices;
        if (resultPointArr != null) {
        }
    }
}
