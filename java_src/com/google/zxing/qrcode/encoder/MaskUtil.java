package com.google.zxing.qrcode.encoder;
/* loaded from: classes.dex */
public final class MaskUtil {
    private MaskUtil() {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int i;
        byte b = -1;
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i2 = 0;
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < width) {
                byte b2 = z ? array[i3][i4] : array[i4][i3];
                if (b2 == b) {
                    i = i5 + 1;
                    if (i == 5) {
                        i2 += 3;
                    } else if (i > 5) {
                        i2++;
                    }
                } else {
                    byte b3 = b2;
                    i = 1;
                    b = b3;
                }
                i4++;
                i5 = i;
            }
        }
        return i2;
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        for (int i2 = 0; i2 < height - 1; i2++) {
            for (int i3 = 0; i3 < width - 1; i3++) {
                byte b = array[i2][i3];
                if (b == array[i2][i3 + 1] && b == array[i2 + 1][i3] && b == array[i2 + 1][i3 + 1]) {
                    i += 3;
                }
            }
        }
        return i;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                if (i3 + 6 < width && array[i2][i3] == 1 && array[i2][i3 + 1] == 0 && array[i2][i3 + 2] == 1 && array[i2][i3 + 3] == 1 && array[i2][i3 + 4] == 1 && array[i2][i3 + 5] == 0 && array[i2][i3 + 6] == 1 && ((i3 + 10 < width && array[i2][i3 + 7] == 0 && array[i2][i3 + 8] == 0 && array[i2][i3 + 9] == 0 && array[i2][i3 + 10] == 0) || (i3 - 4 >= 0 && array[i2][i3 - 1] == 0 && array[i2][i3 - 2] == 0 && array[i2][i3 - 3] == 0 && array[i2][i3 - 4] == 0))) {
                    i += 40;
                }
                if (i2 + 6 < height && array[i2][i3] == 1 && array[i2 + 1][i3] == 0 && array[i2 + 2][i3] == 1 && array[i2 + 3][i3] == 1 && array[i2 + 4][i3] == 1 && array[i2 + 5][i3] == 0 && array[i2 + 6][i3] == 1 && ((i2 + 10 < height && array[i2 + 7][i3] == 0 && array[i2 + 8][i3] == 0 && array[i2 + 9][i3] == 0 && array[i2 + 10][i3] == 0) || (i2 - 4 >= 0 && array[i2 - 1][i3] == 0 && array[i2 - 2][i3] == 0 && array[i2 - 3][i3] == 0 && array[i2 - 4][i3] == 0))) {
                    i += 40;
                }
            }
        }
        return i;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                if (array[i2][i3] == 1) {
                    i++;
                }
            }
        }
        return (Math.abs((int) (((i / (byteMatrix.getHeight() * byteMatrix.getWidth())) * 100.0d) - 50.0d)) / 5) * 10;
    }

    public static boolean getDataMaskBit(int i, int i2, int i3) {
        int i4;
        if (!QRCode.isValidMaskPattern(i)) {
            throw new IllegalArgumentException("Invalid mask pattern");
        }
        switch (i) {
            case 0:
                i4 = (i3 + i2) & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i4 = ((i3 >>> 1) + (i2 / 3)) & 1;
                break;
            case 5:
                int i5 = i3 * i2;
                i4 = (i5 % 3) + (i5 & 1);
                break;
            case 6:
                int i6 = i3 * i2;
                i4 = ((i6 % 3) + (i6 & 1)) & 1;
                break;
            case 7:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException(new StringBuffer().append("Invalid mask pattern: ").append(i).toString());
        }
        return i4 == 0;
    }
}
