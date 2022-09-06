package com.google.zxing.common.reedsolomon;
/* loaded from: classes.dex */
public final class GF256 {
    private final int[] expTable = new int[256];
    private final int[] logTable = new int[256];
    private final GF256Poly one;
    private final GF256Poly zero;
    public static final GF256 QR_CODE_FIELD = new GF256(285);
    public static final GF256 DATA_MATRIX_FIELD = new GF256(301);

    private GF256(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 256; i3++) {
            this.expTable[i3] = i2;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= i;
            }
        }
        for (int i4 = 0; i4 < 255; i4++) {
            this.logTable[this.expTable[i4]] = i4;
        }
        this.zero = new GF256Poly(this, new int[]{0});
        this.one = new GF256Poly(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int addOrSubtract(int i, int i2) {
        return i ^ i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GF256Poly buildMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new GF256Poly(this, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int exp(int i) {
        return this.expTable[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GF256Poly getOne() {
        return this.one;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GF256Poly getZero() {
        return this.zero;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int inverse(int i) {
        if (i == 0) {
            throw new ArithmeticException();
        }
        return this.expTable[255 - this.logTable[i]];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int log(int i) {
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return this.logTable[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int multiply(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int i3 = this.logTable[i] + this.logTable[i2];
        return this.expTable[(i3 >>> 8) + (i3 & 255)];
    }
}
