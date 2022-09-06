package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private byte[] luminances = null;
    private int[] buckets = null;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int estimateBlackPoint(int[] iArr) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (iArr[i8] > i5) {
                i5 = iArr[i8];
                i6 = i8;
            }
            if (iArr[i8] > i7) {
                i7 = iArr[i8];
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i4 < length) {
            int i11 = i4 - i6;
            int i12 = i11 * iArr[i4] * i11;
            if (i12 > i9) {
                i3 = i4;
            } else {
                i12 = i9;
                i3 = i10;
            }
            i4++;
            i10 = i3;
            i9 = i12;
        }
        if (i6 > i10) {
            i = i10;
            i10 = i6;
        } else {
            i = i6;
        }
        if (i10 - i <= (length >> 4)) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i13 = i10 - 1;
        int i14 = -1;
        int i15 = i10 - 1;
        while (i15 > i) {
            int i16 = i15 - i;
            int i17 = i16 * i16 * (i10 - i15) * (i7 - iArr[i15]);
            if (i17 > i14) {
                i2 = i15;
            } else {
                i17 = i14;
                i2 = i13;
            }
            i15--;
            i13 = i2;
            i14 = i17;
        }
        return i13 << 3;
    }

    private void initArrays(int i) {
        if (this.luminances == null || this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        if (this.buckets == null) {
            this.buckets = new int[32];
            return;
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.buckets[i2] = 0;
        }
    }

    @Override // com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            byte[] row = luminanceSource.getRow((height * i2) / 5, this.luminances);
            int i3 = (width << 2) / 5;
            for (int i4 = width / 5; i4 < i3; i4++) {
                int i5 = (row[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
            i = i2 + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i6 = 0; i6 < height; i6++) {
            int i7 = i6 * width;
            for (int i8 = 0; i8 < width; i8++) {
                if ((matrix[i7 + i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) < estimateBlackPoint) {
                    bitMatrix.set(i8, i6);
                }
            }
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Binarizer
    public BitArray getBlackRow(int i, BitArray bitArray) {
        int i2 = 1;
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i, this.luminances);
        int[] iArr = this.buckets;
        for (int i3 = 0; i3 < width; i3++) {
            int i4 = (row[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        int i5 = row[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        int i6 = row[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        int i7 = i5;
        while (i2 < width - 1) {
            int i8 = row[i2 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (((((i6 << 2) - i7) - i8) >> 1) < estimateBlackPoint) {
                bitArray.set(i2);
            }
            i2++;
            i7 = i6;
            i6 = i8;
        }
        return bitArray;
    }
}
