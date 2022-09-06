package com.google.zxing.common.reedsolomon;
/* loaded from: classes.dex */
public final class ReedSolomonDecoder {
    private final GF256 field;

    public ReedSolomonDecoder(GF256 gf256) {
        this.field = gf256;
    }

    private int[] findErrorLocations(GF256Poly gF256Poly) {
        int degree = gF256Poly.getDegree();
        if (degree == 1) {
            return new int[]{gF256Poly.getCoefficient(1)};
        }
        int[] iArr = new int[degree];
        int i = 0;
        for (int i2 = 1; i2 < 256 && i < degree; i2++) {
            if (gF256Poly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == degree) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] findErrorMagnitudes(GF256Poly gF256Poly, int[] iArr, boolean z) {
        int i;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int inverse = this.field.inverse(iArr[i2]);
            int i3 = 1;
            int i4 = 0;
            while (i4 < length) {
                if (i2 != i4) {
                    int multiply = this.field.multiply(iArr[i4], inverse);
                    i = this.field.multiply(i3, (multiply & 1) == 0 ? multiply | 1 : multiply & (-2));
                } else {
                    i = i3;
                }
                i4++;
                i3 = i;
            }
            iArr2[i2] = this.field.multiply(gF256Poly.evaluateAt(inverse), this.field.inverse(i3));
            if (z) {
                iArr2[i2] = this.field.multiply(iArr2[i2], inverse);
            }
        }
        return iArr2;
    }

    private GF256Poly[] runEuclideanAlgorithm(GF256Poly gF256Poly, GF256Poly gF256Poly2, int i) {
        if (gF256Poly.getDegree() >= gF256Poly2.getDegree()) {
            gF256Poly2 = gF256Poly;
            gF256Poly = gF256Poly2;
        }
        GF256Poly one = this.field.getOne();
        GF256Poly zero = this.field.getZero();
        GF256Poly zero2 = this.field.getZero();
        GF256Poly one2 = this.field.getOne();
        while (gF256Poly.getDegree() >= i / 2) {
            if (gF256Poly.isZero()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            GF256Poly zero3 = this.field.getZero();
            int inverse = this.field.inverse(gF256Poly.getCoefficient(gF256Poly.getDegree()));
            GF256Poly gF256Poly3 = zero3;
            GF256Poly gF256Poly4 = gF256Poly2;
            while (gF256Poly4.getDegree() >= gF256Poly.getDegree() && !gF256Poly4.isZero()) {
                int degree = gF256Poly4.getDegree() - gF256Poly.getDegree();
                int multiply = this.field.multiply(gF256Poly4.getCoefficient(gF256Poly4.getDegree()), inverse);
                gF256Poly3 = gF256Poly3.addOrSubtract(this.field.buildMonomial(degree, multiply));
                gF256Poly4 = gF256Poly4.addOrSubtract(gF256Poly.multiplyByMonomial(degree, multiply));
            }
            GF256Poly addOrSubtract = gF256Poly3.multiply(zero).addOrSubtract(one);
            gF256Poly2 = gF256Poly;
            gF256Poly = gF256Poly4;
            one = zero;
            zero = addOrSubtract;
            GF256Poly gF256Poly5 = one2;
            one2 = gF256Poly3.multiply(one2).addOrSubtract(zero2);
            zero2 = gF256Poly5;
        }
        int coefficient = one2.getCoefficient(0);
        if (coefficient == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int inverse2 = this.field.inverse(coefficient);
        return new GF256Poly[]{one2.multiply(inverse2), gF256Poly.multiply(inverse2)};
    }

    public void decode(int[] iArr, int i) {
        GF256Poly gF256Poly = new GF256Poly(this.field, iArr);
        int[] iArr2 = new int[i];
        boolean equals = this.field.equals(GF256.DATA_MATRIX_FIELD);
        int i2 = 0;
        boolean z = true;
        while (i2 < i) {
            int evaluateAt = gF256Poly.evaluateAt(this.field.exp(equals ? i2 + 1 : i2));
            iArr2[(iArr2.length - 1) - i2] = evaluateAt;
            i2++;
            z = evaluateAt != 0 ? false : z;
        }
        if (z) {
            return;
        }
        GF256Poly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new GF256Poly(this.field, iArr2), i);
        GF256Poly gF256Poly2 = runEuclideanAlgorithm[0];
        GF256Poly gF256Poly3 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(gF256Poly2);
        int[] findErrorMagnitudes = findErrorMagnitudes(gF256Poly3, findErrorLocations, equals);
        for (int i3 = 0; i3 < findErrorLocations.length; i3++) {
            int length = (iArr.length - 1) - this.field.log(findErrorLocations[i3]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = GF256.addOrSubtract(iArr[length], findErrorMagnitudes[i3]);
        }
    }
}
