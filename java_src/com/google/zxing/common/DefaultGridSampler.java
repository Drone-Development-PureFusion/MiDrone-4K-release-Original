package com.google.zxing.common;

import com.google.zxing.NotFoundException;
/* loaded from: classes.dex */
public final class DefaultGridSampler extends GridSampler {
    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return sampleGrid(bitMatrix, i, PerspectiveTransform.quadrilateralToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i, PerspectiveTransform perspectiveTransform) {
        BitMatrix bitMatrix2 = new BitMatrix(i);
        float[] fArr = new float[i << 1];
        for (int i2 = 0; i2 < i; i2++) {
            int length = fArr.length;
            float f = i2 + 0.5f;
            for (int i3 = 0; i3 < length; i3 += 2) {
                fArr[i3] = (i3 >> 1) + 0.5f;
                fArr[i3 + 1] = f;
            }
            perspectiveTransform.transformPoints(fArr);
            checkAndNudgePoints(bitMatrix, fArr);
            for (int i4 = 0; i4 < length; i4 += 2) {
                try {
                    if (bitMatrix.get((int) fArr[i4], (int) fArr[i4 + 1])) {
                        bitMatrix2.set(i4 >> 1, i2);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bitMatrix2;
    }
}
