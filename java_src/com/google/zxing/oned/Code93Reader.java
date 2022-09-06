package com.google.zxing.oned;

import com.facebook.imageutils.TiffUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.p078a.p079a.AbstractC0735l;
import it.p235a.p236a.AbstractC4863e;
import java.util.Hashtable;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public final class Code93Reader extends OneDReader {
    private static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private static final int[] CHARACTER_ENCODINGS = {276, 328, 324, 322, 296, 292, 290, 336, TiffUtil.TIFF_TAG_ORIENTATION, 266, 424, AbstractC0735l.f1816g, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, AbstractC4863e.f20809r, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, AbstractC4863e.f20810s};
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[47];

    private static void checkChecksums(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        checkOneChecksum(stringBuffer, length - 2, 20);
        checkOneChecksum(stringBuffer, length - 1, 15);
    }

    private static void checkOneChecksum(StringBuffer stringBuffer, int i, int i2) {
        int i3 = 1;
        int i4 = i - 1;
        int i5 = 0;
        while (i4 >= 0) {
            int indexOf = (ALPHABET_STRING.indexOf(stringBuffer.charAt(i4)) * i3) + i5;
            int i6 = i3 + 1;
            if (i6 > i2) {
                i6 = 1;
            }
            i4--;
            i3 = i6;
            i5 = indexOf;
        }
        if (stringBuffer.charAt(i) != ALPHABET[i5 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String decodeExtended(StringBuffer stringBuffer) {
        int i;
        char c;
        int length = stringBuffer.length();
        StringBuffer stringBuffer2 = new StringBuffer(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = stringBuffer.charAt(i2);
            if (charAt < 'a' || charAt > 'd') {
                stringBuffer2.append(charAt);
                i = i2;
            } else {
                char charAt2 = stringBuffer.charAt(i2 + 1);
                switch (charAt) {
                    case Opcodes.LADD /* 97 */:
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            c = (char) (charAt2 - '@');
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            c = (char) (charAt2 - '&');
                            break;
                        } else if (charAt2 >= 'F' && charAt2 <= 'W') {
                            c = (char) (charAt2 - 11);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            c = (char) (charAt2 - ' ');
                            break;
                        } else if (charAt2 != 'Z') {
                            throw FormatException.getFormatInstance();
                        } else {
                            c = C0359h.f671A;
                            break;
                        }
                        break;
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            c = (char) (charAt2 + C5122l.f21763c);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        c = 0;
                        break;
                }
                stringBuffer2.append(c);
                i = i2 + 1;
            }
            i2 = i + 1;
        }
        return stringBuffer2.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray) {
        int size = bitArray.getSize();
        int i = 0;
        while (i < size && !bitArray.get(i)) {
            i++;
        }
        int[] iArr = new int[6];
        int length = iArr.length;
        boolean z = false;
        int i2 = 0;
        for (int i3 = i; i3 < size; i3++) {
            if (bitArray.get(i3) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else if (toPattern(iArr) == ASTERISK_ENCODING) {
                    return new int[]{i, i3};
                } else {
                    i += iArr[0] + iArr[1];
                    for (int i4 = 2; i4 < length; i4++) {
                        iArr[i4 - 2] = iArr[i4];
                    }
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i) {
        for (int i2 = 0; i2 < CHARACTER_ENCODINGS.length; i2++) {
            if (CHARACTER_ENCODINGS[i2] == i) {
                return ALPHABET[i2];
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toPattern(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            i++;
            i2 = iArr[i] + i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = ((iArr[i4] << 8) * 9) / i2;
            int i6 = i5 >> 8;
            int i7 = (i5 & 255) > 127 ? i6 + 1 : i6;
            if (i7 < 1 || i7 > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i8 = 0;
                while (i8 < i7) {
                    i8++;
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= i7;
            }
        }
        return i3;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        int[] findAsteriskPattern;
        int i2 = findAsteriskPattern(bitArray)[1];
        int size = bitArray.getSize();
        while (i2 < size && !bitArray.get(i2)) {
            i2++;
        }
        StringBuffer stringBuffer = new StringBuffer(20);
        int[] iArr = new int[6];
        while (true) {
            recordPattern(bitArray, i2, iArr);
            int pattern = toPattern(iArr);
            if (pattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char patternToChar = patternToChar(pattern);
            stringBuffer.append(patternToChar);
            int i3 = i2;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int i5 = i3;
            while (i5 < size && !bitArray.get(i5)) {
                i5++;
            }
            if (patternToChar == '*') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                if (i5 == size || !bitArray.get(i5)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (stringBuffer.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                checkChecksums(stringBuffer);
                stringBuffer.setLength(stringBuffer.length() - 2);
                return new Result(decodeExtended(stringBuffer), null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[0] + findAsteriskPattern[1]) / 2.0f, i), new ResultPoint((i2 + i5) / 2.0f, i)}, BarcodeFormat.CODE_93);
            }
            i2 = i5;
        }
    }
}
