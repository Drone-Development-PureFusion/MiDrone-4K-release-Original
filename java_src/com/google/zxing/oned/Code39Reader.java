package com.google.zxing.oned;

import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.module.setting.newhand.C3530b;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public final class Code39Reader extends OneDReader {
    private final boolean extendedMode;
    private final boolean usingCheckDigit;
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final int[] CHARACTER_ENCODINGS = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, C2427e.f8176F, 67, 322, 19, TiffUtil.TIFF_TAG_ORIENTATION, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, JfifUtil.MARKER_RST0, 133, 388, SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING, 148, 168, Opcodes.IF_ICMPGE, 138, 42};
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[39];

    public Code39Reader() {
        this.usingCheckDigit = false;
        this.extendedMode = false;
    }

    public Code39Reader(boolean z) {
        this.usingCheckDigit = z;
        this.extendedMode = false;
    }

    public Code39Reader(boolean z, boolean z2) {
        this.usingCheckDigit = z;
        this.extendedMode = z2;
    }

    private static String decodeExtended(StringBuffer stringBuffer) {
        char c;
        int i;
        int length = stringBuffer.length();
        StringBuffer stringBuffer2 = new StringBuffer(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = stringBuffer.charAt(i2);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                char charAt2 = stringBuffer.charAt(i2 + 1);
                switch (charAt) {
                    case '$':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            c = (char) (charAt2 - '@');
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case '%':
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
                    case C3530b.f14178o /* 43 */:
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            c = (char) (charAt2 + C5122l.f21763c);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case '/':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            c = (char) (charAt2 - ' ');
                            break;
                        } else if (charAt2 != 'Z') {
                            throw FormatException.getFormatInstance();
                        } else {
                            c = C0359h.f671A;
                            break;
                        }
                    default:
                        c = 0;
                        break;
                }
                stringBuffer2.append(c);
                i = i2 + 1;
            } else {
                stringBuffer2.append(charAt);
                i = i2;
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
        int[] iArr = new int[9];
        int length = iArr.length;
        boolean z = false;
        int i2 = 0;
        for (int i3 = i; i3 < size; i3++) {
            if (bitArray.get(i3) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i - ((i3 - i) / 2)), i, false)) {
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

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (iArr[i7] > i2) {
                    i4 |= 1 << ((length - 1) - i7);
                    i6++;
                    i5 += i8;
                }
            }
            if (i6 == 3) {
                int i9 = i6;
                for (int i10 = 0; i10 < length && i9 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (iArr[i10] > i2) {
                        i9--;
                        if ((i11 << 1) >= i5) {
                            return -1;
                        }
                    }
                }
                return i4;
            } else if (i6 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
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
        int[] iArr = new int[9];
        while (true) {
            recordPattern(bitArray, i2, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char patternToChar = patternToChar(narrowWidePattern);
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
                int i6 = 0;
                for (int i7 : iArr) {
                    i6 += i7;
                }
                int i8 = (i5 - i2) - i6;
                if (i5 != size && i8 / 2 < i6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.usingCheckDigit) {
                    int length = stringBuffer.length() - 1;
                    int i9 = 0;
                    for (int i10 = 0; i10 < length; i10++) {
                        i9 += ALPHABET_STRING.indexOf(stringBuffer.charAt(i10));
                    }
                    if (stringBuffer.charAt(length) != ALPHABET[i9 % 43]) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    stringBuffer.deleteCharAt(length);
                }
                if (stringBuffer.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                return new Result(this.extendedMode ? decodeExtended(stringBuffer) : stringBuffer.toString(), null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, i), new ResultPoint((i2 + i5) / 2.0f, i)}, BarcodeFormat.CODE_39);
            }
            i2 = i5;
        }
    }
}
