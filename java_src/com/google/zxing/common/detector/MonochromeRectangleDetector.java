package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes.dex */
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0065 A[EDGE_INSN: B:57:0x0065->B:36:0x0065 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x002b A[EDGE_INSN: B:74:0x002b->B:15:0x002b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] blackWhiteRange(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7 = (i3 + i4) >> 1;
        int i8 = i7;
        while (i8 >= i3) {
            if (z) {
                if (!this.image.get(i8, i)) {
                    i6 = i8;
                    while (true) {
                        i6--;
                        if (i6 < i3) {
                            break;
                        } else if (z) {
                            if (this.image.get(i6, i)) {
                                break;
                            }
                        } else if (this.image.get(i, i6)) {
                            break;
                        }
                    }
                    int i9 = i8 - i6;
                    if (i6 >= i3 || i9 > i2) {
                        break;
                        break;
                    }
                    i8 = i6;
                } else {
                    i8--;
                }
            } else if (!this.image.get(i, i8)) {
                i6 = i8;
                while (true) {
                    i6--;
                    if (i6 < i3) {
                    }
                }
                int i92 = i8 - i6;
                if (i6 >= i3) {
                    break;
                }
                i8 = i6;
            } else {
                i8--;
            }
        }
        int i10 = i8 + 1;
        int i11 = i7;
        while (i11 < i4) {
            if (z) {
                if (!this.image.get(i11, i)) {
                    i5 = i11;
                    while (true) {
                        i5++;
                        if (i5 >= i4) {
                            break;
                        } else if (z) {
                            if (this.image.get(i5, i)) {
                                break;
                            }
                        } else if (this.image.get(i, i5)) {
                            break;
                        }
                    }
                    int i12 = i5 - i11;
                    if (i5 < i4 || i12 > i2) {
                        break;
                        break;
                    }
                    i11 = i5;
                } else {
                    i11++;
                }
            } else if (!this.image.get(i, i11)) {
                i5 = i11;
                while (true) {
                    i5++;
                    if (i5 >= i4) {
                    }
                }
                int i122 = i5 - i11;
                if (i5 < i4) {
                    break;
                }
                i11 = i5;
            } else {
                i11++;
            }
        }
        int i13 = i11 - 1;
        if (i13 > i10) {
            return new int[]{i10, i13};
        }
        return null;
    }

    private ResultPoint findCornerFromCenter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i5;
        int[] iArr = null;
        while (i11 < i8 && i11 >= i7 && i10 < i4 && i10 >= i3) {
            int[] blackWhiteRange = i2 == 0 ? blackWhiteRange(i11, i9, i3, i4, true) : blackWhiteRange(i10, i9, i7, i8, false);
            if (blackWhiteRange == null) {
                if (iArr == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i2 == 0) {
                    int i12 = i11 - i6;
                    if (iArr[0] >= i) {
                        return new ResultPoint(iArr[1], i12);
                    }
                    if (iArr[1] <= i) {
                        return new ResultPoint(iArr[0], i12);
                    }
                    return new ResultPoint(i6 > 0 ? iArr[0] : iArr[1], i12);
                }
                int i13 = i10 - i2;
                if (iArr[0] >= i5) {
                    return new ResultPoint(i13, iArr[1]);
                }
                if (iArr[1] <= i5) {
                    return new ResultPoint(i13, iArr[0]);
                }
                return new ResultPoint(i13, i2 < 0 ? iArr[0] : iArr[1]);
            }
            i10 += i2;
            iArr = blackWhiteRange;
            i11 += i6;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = height >> 1;
        int i2 = width >> 1;
        int max = Math.max(1, height / 256);
        int max2 = Math.max(1, width / 256);
        int y = ((int) findCornerFromCenter(i2, 0, 0, width, i, -max, 0, height, i2 >> 1).getY()) - 1;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i2, -max2, 0, width, i, 0, y, height, i >> 1);
        int x = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i2, max2, x, width, i, 0, y, height, i >> 1);
        int x2 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i2, 0, x, x2, i, max, y, height, i2 >> 1);
        return new ResultPoint[]{findCornerFromCenter(i2, 0, x, x2, i, -max, y, ((int) findCornerFromCenter3.getY()) + 1, i2 >> 2), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }
}
