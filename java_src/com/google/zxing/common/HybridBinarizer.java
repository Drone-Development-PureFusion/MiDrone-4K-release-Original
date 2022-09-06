package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int MINIMUM_DIMENSION = 40;
    private BitMatrix matrix = null;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private void binarizeEntireImage() {
        if (this.matrix == null) {
            LuminanceSource luminanceSource = getLuminanceSource();
            if (luminanceSource.getWidth() < 40 || luminanceSource.getHeight() < 40) {
                this.matrix = super.getBlackMatrix();
                return;
            }
            byte[] matrix = luminanceSource.getMatrix();
            int width = luminanceSource.getWidth();
            int height = luminanceSource.getHeight();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = height >> 3;
            if ((height & 7) != 0) {
                i2++;
            }
            int[][] calculateBlackPoints = calculateBlackPoints(matrix, i, i2, width, height);
            this.matrix = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i, i2, width, height, calculateBlackPoints, this.matrix);
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, i2, i);
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            if (i6 + 8 >= i4) {
                i6 = i4 - 8;
            }
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = i7 << 3;
                if (i8 + 8 >= i3) {
                    i8 = i3 - 8;
                }
                int i9 = 0;
                int i10 = 255;
                int i11 = 0;
                int i12 = 0;
                while (i12 < 8) {
                    int i13 = ((i6 + i12) * i3) + i8;
                    int i14 = i9;
                    int i15 = 0;
                    while (i15 < 8) {
                        int i16 = bArr[i13 + i15] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                        i14 += i16;
                        if (i16 < i10) {
                            i10 = i16;
                        }
                        if (i16 <= i11) {
                            i16 = i11;
                        }
                        i15++;
                        i11 = i16;
                    }
                    i12++;
                    i9 = i14;
                }
                iArr[i5][i7] = i11 - i10 > 24 ? i9 >> 6 : i11 == 0 ? 1 : i10 >> 1;
            }
        }
        return iArr;
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = 0;
        while (i5 < i2) {
            int i6 = i5 << 3;
            if (i6 + 8 >= i4) {
                i6 = i4 - 8;
            }
            int i7 = 0;
            while (i7 < i) {
                int i8 = i7 << 3;
                if (i8 + 8 >= i3) {
                    i8 = i3 - 8;
                }
                int i9 = i7 > 1 ? i7 : 2;
                int i10 = i9 < i + (-2) ? i9 : i - 3;
                int i11 = i5 > 1 ? i5 : 2;
                if (i11 >= i2 - 2) {
                    i11 = i2 - 3;
                }
                int i12 = 0;
                for (int i13 = -2; i13 <= 2; i13++) {
                    int[] iArr2 = iArr[i11 + i13];
                    i12 = i12 + iArr2[i10 - 2] + iArr2[i10 - 1] + iArr2[i10] + iArr2[i10 + 1] + iArr2[i10 + 2];
                }
                threshold8x8Block(bArr, i8, i6, i12 / 25, i3, bitMatrix);
                i7++;
            }
            i5++;
        }
    }

    private static void threshold8x8Block(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i2 + i5) * i4) + i;
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i6 + i7] & 255) < i3) {
                    bitMatrix.set(i + i7, i2 + i5);
                }
            }
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() {
        binarizeEntireImage();
        return this.matrix;
    }
}
