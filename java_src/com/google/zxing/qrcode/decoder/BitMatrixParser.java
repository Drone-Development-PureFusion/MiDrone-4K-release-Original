package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes.dex */
final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    private int copyBit(int i, int i2, int i3) {
        return this.bitMatrix.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() {
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask forReference = DataMask.forReference(readFormatInformation.getDataMask());
        int height = this.bitMatrix.getHeight();
        forReference.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i = height - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            for (int i5 = 0; i5 < height; i5++) {
                int i6 = z ? (height - 1) - i5 : i5;
                for (int i7 = 0; i7 < 2; i7++) {
                    if (!buildFunctionPattern.get(i - i7, i6)) {
                        i2++;
                        i3 <<= 1;
                        if (this.bitMatrix.get(i - i7, i6)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4++;
                            i2 = 0;
                        }
                    }
                }
            }
            i -= 2;
            z = !z;
        }
        if (i4 != readVersion.getTotalCodewords()) {
            throw FormatException.getFormatInstance();
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormatInformation readFormatInformation() {
        int i = 0;
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = copyBit(i3, 8, i2);
        }
        int copyBit = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            copyBit = copyBit(8, i4, copyBit);
        }
        int height = this.bitMatrix.getHeight();
        int i5 = height - 8;
        for (int i6 = height - 1; i6 >= i5; i6--) {
            i = copyBit(i6, 8, i);
        }
        for (int i7 = height - 7; i7 < height; i7++) {
            i = copyBit(8, i7, i);
        }
        this.parsedFormatInfo = FormatInformation.decodeFormatInformation(copyBit, i);
        if (this.parsedFormatInfo == null) {
            throw FormatException.getFormatInstance();
        }
        return this.parsedFormatInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Version readVersion() {
        int i = 0;
        if (this.parsedVersion != null) {
            return this.parsedVersion;
        }
        int height = this.bitMatrix.getHeight();
        int i2 = (height - 17) >> 2;
        if (i2 <= 6) {
            return Version.getVersionForNumber(i2);
        }
        int i3 = height - 11;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i3; i6--) {
                i4 = copyBit(i6, i5, i4);
            }
        }
        this.parsedVersion = Version.decodeVersionInformation(i4);
        if (this.parsedVersion != null && this.parsedVersion.getDimensionForVersion() == height) {
            return this.parsedVersion;
        }
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = height - 9; i8 >= i3; i8--) {
                i = copyBit(i7, i8, i);
            }
        }
        this.parsedVersion = Version.decodeVersionInformation(i);
        if (this.parsedVersion != null && this.parsedVersion.getDimensionForVersion() == height) {
            return this.parsedVersion;
        }
        throw FormatException.getFormatInstance();
    }
}
