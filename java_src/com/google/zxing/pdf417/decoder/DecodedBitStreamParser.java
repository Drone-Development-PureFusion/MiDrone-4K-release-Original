package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
final class DecodedBitStreamParser {

    /* renamed from: AL */
    private static final int f17084AL = 28;
    private static final int ALPHA = 0;

    /* renamed from: AS */
    private static final int f17085AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;

    /* renamed from: LL */
    private static final int f17086LL = 27;
    private static final int LOWER = 1;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int MIXED = 2;

    /* renamed from: ML */
    private static final int f17087ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;

    /* renamed from: PL */
    private static final int f17088PL = 25;

    /* renamed from: PS */
    private static final int f17089PS = 29;
    private static final int PUNCT = 3;
    private static final int PUNCT_SHIFT = 4;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = {';', '<', '>', '@', '[', '\\', C0359h.f726w, '_', '`', '~', '!', C5122l.f21761a, '\t', C0359h.f727x, C0359h.f671A, '\n', '-', C0359h.f677G, C0359h.f679I, '/', '\"', '|', '*', C0359h.f722s, C0359h.f723t, '?', C0359h.f725v, C0359h.f726w, C0359h.f729z};
    private static final char[] MIXED_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', C5122l.f21761a, '\t', C0359h.f727x, C0359h.f671A, '#', '-', C0359h.f677G, C0359h.f679I, '/', SignatureVisitor.EXTENDS, C0359h.f721r, '*', SignatureVisitor.INSTANCEOF, '^'};
    private static final String[] EXP900 = {"000000000000000000000000000000000000000000001", "000000000000000000000000000000000000000000900", "000000000000000000000000000000000000000810000", "000000000000000000000000000000000000729000000", "000000000000000000000000000000000656100000000", "000000000000000000000000000000590490000000000", "000000000000000000000000000531441000000000000", "000000000000000000000000478296900000000000000", "000000000000000000000430467210000000000000000", "000000000000000000387420489000000000000000000", "000000000000000348678440100000000000000000000", "000000000000313810596090000000000000000000000", "000000000282429536481000000000000000000000000", "000000254186582832900000000000000000000000000", "000228767924549610000000000000000000000000000", "205891132094649000000000000000000000000000000"};

    private DecodedBitStreamParser() {
    }

    private static StringBuffer add(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(5);
        StringBuffer stringBuffer2 = new StringBuffer(5);
        StringBuffer stringBuffer3 = new StringBuffer(str.length());
        for (int i = 0; i < str.length(); i++) {
            stringBuffer3.append('0');
        }
        int i2 = 0;
        for (int length = str.length() - 3; length > -1; length -= 3) {
            stringBuffer.setLength(0);
            stringBuffer.append(str.charAt(length));
            stringBuffer.append(str.charAt(length + 1));
            stringBuffer.append(str.charAt(length + 2));
            stringBuffer2.setLength(0);
            stringBuffer2.append(str2.charAt(length));
            stringBuffer2.append(str2.charAt(length + 1));
            stringBuffer2.append(str2.charAt(length + 2));
            int parseInt = Integer.parseInt(stringBuffer.toString());
            int parseInt2 = Integer.parseInt(stringBuffer2.toString());
            int i3 = ((parseInt + parseInt2) + i2) % 1000;
            i2 = (i2 + (parseInt + parseInt2)) / 1000;
            stringBuffer3.setCharAt(length + 2, (char) ((i3 % 10) + 48));
            stringBuffer3.setCharAt(length + 1, (char) (((i3 / 10) % 10) + 48));
            stringBuffer3.setCharAt(length, (char) ((i3 / 100) + 48));
        }
        return stringBuffer3;
    }

    private static int byteCompaction(int i, int[] iArr, int i2, StringBuffer stringBuffer) {
        if (i == BYTE_COMPACTION_MODE_LATCH) {
            int i3 = 0;
            long j = 0;
            char[] cArr = new char[6];
            int[] iArr2 = new int[6];
            boolean z = false;
            while (i2 < iArr[0] && !z) {
                int i4 = i2 + 1;
                int i5 = iArr[i2];
                if (i5 < 900) {
                    iArr2[i3] = i5;
                    i3++;
                    j = (j * 900) + i5;
                    i2 = i4;
                } else if (i5 == 900 || i5 == BYTE_COMPACTION_MODE_LATCH || i5 == NUMERIC_COMPACTION_MODE_LATCH || i5 == BYTE_COMPACTION_MODE_LATCH_6 || i5 == BEGIN_MACRO_PDF417_CONTROL_BLOCK || i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i5 == MACRO_PDF417_TERMINATOR) {
                    i2 = i4 - 1;
                    z = true;
                } else {
                    i2 = i4;
                }
                if (i3 % 5 == 0 && i3 > 0) {
                    for (int i6 = 0; i6 < 6; i6++) {
                        cArr[5 - i6] = (char) (j % 256);
                        j >>= 8;
                    }
                    stringBuffer.append(cArr);
                    i3 = 0;
                }
            }
            for (int i7 = (i3 / 5) * 5; i7 < i3; i7++) {
                stringBuffer.append((char) iArr2[i7]);
            }
        } else if (i == BYTE_COMPACTION_MODE_LATCH_6) {
            int i8 = 0;
            long j2 = 0;
            boolean z2 = false;
            while (i2 < iArr[0] && !z2) {
                int i9 = i2 + 1;
                int i10 = iArr[i2];
                if (i10 < 900) {
                    i8++;
                    j2 = (j2 * 900) + i10;
                    i2 = i9;
                } else if (i10 == 900 || i10 == BYTE_COMPACTION_MODE_LATCH || i10 == NUMERIC_COMPACTION_MODE_LATCH || i10 == BYTE_COMPACTION_MODE_LATCH_6 || i10 == BEGIN_MACRO_PDF417_CONTROL_BLOCK || i10 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i10 == MACRO_PDF417_TERMINATOR) {
                    i2 = i9 - 1;
                    z2 = true;
                } else {
                    i2 = i9;
                }
                if (i8 % 5 == 0 && i8 > 0) {
                    char[] cArr2 = new char[6];
                    int i11 = 0;
                    while (i11 < 6) {
                        cArr2[5 - i11] = (char) (255 & j2);
                        i11++;
                        j2 >>= 8;
                    }
                    stringBuffer.append(cArr2);
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DecoderResult decode(int[] iArr) {
        int byteCompaction;
        StringBuffer stringBuffer = new StringBuffer(100);
        int i = 2;
        int i2 = iArr[1];
        while (i < iArr[0]) {
            switch (i2) {
                case 900:
                    byteCompaction = textCompaction(iArr, i, stringBuffer);
                    break;
                case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                    byteCompaction = byteCompaction(i2, iArr, i, stringBuffer);
                    break;
                case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                    byteCompaction = numericCompaction(iArr, i, stringBuffer);
                    break;
                case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /* 913 */:
                    byteCompaction = byteCompaction(i2, iArr, i, stringBuffer);
                    break;
                case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                    byteCompaction = byteCompaction(i2, iArr, i, stringBuffer);
                    break;
                default:
                    byteCompaction = textCompaction(iArr, i - 1, stringBuffer);
                    break;
            }
            if (byteCompaction >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i = byteCompaction + 1;
            i2 = iArr[byteCompaction];
        }
        return new DecoderResult(null, stringBuffer.toString(), null, null);
    }

    private static String decodeBase900toBase10(int[] iArr, int i) {
        String str;
        int i2 = 0;
        StringBuffer stringBuffer = null;
        while (i2 < i) {
            StringBuffer multiply = multiply(EXP900[(i - i2) - 1], iArr[i2]);
            if (stringBuffer != null) {
                multiply = add(stringBuffer.toString(), multiply.toString());
            }
            i2++;
            stringBuffer = multiply;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= stringBuffer.length()) {
                str = null;
                break;
            } else if (stringBuffer.charAt(i3) == '1') {
                str = stringBuffer.toString().substring(i3 + 1);
                break;
            } else {
                i3++;
            }
        }
        return str == null ? stringBuffer.toString() : str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuffer stringBuffer) {
        char c;
        char c2 = 0;
        char c3 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            switch (c3) {
                case 0:
                    if (i3 < 26) {
                        c = (char) (i3 + 65);
                        break;
                    } else if (i3 == 26) {
                        c = C5122l.f21763c;
                        break;
                    } else if (i3 == 27) {
                        c3 = 1;
                        c = 0;
                        break;
                    } else if (i3 == 28) {
                        c3 = 2;
                        c = 0;
                        break;
                    } else if (i3 == 29) {
                        c = 0;
                        char c4 = c3;
                        c3 = 4;
                        c2 = c4;
                        break;
                    } else {
                        if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            stringBuffer.append((char) iArr2[i2]);
                            c = 0;
                            break;
                        }
                        c = 0;
                        break;
                    }
                case 1:
                    if (i3 < 26) {
                        c = (char) (i3 + 97);
                        break;
                    } else if (i3 == 26) {
                        c = C5122l.f21763c;
                        break;
                    } else if (i3 == 28) {
                        c = 0;
                        c3 = 0;
                        break;
                    } else if (i3 == 28) {
                        c3 = 2;
                        c = 0;
                        break;
                    } else if (i3 == 29) {
                        c = 0;
                        char c5 = c3;
                        c3 = 4;
                        c2 = c5;
                        break;
                    } else {
                        if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            stringBuffer.append((char) iArr2[i2]);
                            c = 0;
                            break;
                        }
                        c = 0;
                        break;
                    }
                case 2:
                    if (i3 < 25) {
                        c = MIXED_CHARS[i3];
                        break;
                    } else if (i3 == 25) {
                        c3 = 3;
                        c = 0;
                        break;
                    } else if (i3 == 26) {
                        c = C5122l.f21763c;
                        break;
                    } else if (i3 == 27) {
                        c = 0;
                        break;
                    } else if (i3 == 28) {
                        c = 0;
                        c3 = 0;
                        break;
                    } else if (i3 == 29) {
                        c = 0;
                        char c6 = c3;
                        c3 = 4;
                        c2 = c6;
                        break;
                    } else {
                        if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            stringBuffer.append((char) iArr2[i2]);
                            c = 0;
                            break;
                        }
                        c = 0;
                        break;
                    }
                case 3:
                    if (i3 < 29) {
                        c = PUNCT_CHARS[i3];
                        break;
                    } else if (i3 == 29) {
                        c = 0;
                        c3 = 0;
                        break;
                    } else {
                        if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            stringBuffer.append((char) iArr2[i2]);
                            c = 0;
                            break;
                        }
                        c = 0;
                        break;
                    }
                case 4:
                    if (i3 < 29) {
                        c = PUNCT_CHARS[i3];
                        c3 = c2;
                        break;
                    } else if (i3 == 29) {
                        c = 0;
                        c3 = 0;
                        break;
                    } else {
                        c = 0;
                        c3 = c2;
                        break;
                    }
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                stringBuffer.append(c);
            }
        }
    }

    private static StringBuffer multiply(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            stringBuffer.append('0');
        }
        int i3 = i / 100;
        int i4 = (i / 10) % 10;
        int i5 = i % 10;
        StringBuffer stringBuffer2 = stringBuffer;
        int i6 = 0;
        while (i6 < i5) {
            i6++;
            stringBuffer2 = add(stringBuffer2.toString(), str);
        }
        int i7 = 0;
        while (i7 < i4) {
            i7++;
            stringBuffer2 = add(stringBuffer2.toString(), new StringBuffer().append(str).append('0').toString().substring(1));
        }
        for (int i8 = 0; i8 < i3; i8++) {
            stringBuffer2 = add(stringBuffer2.toString(), new StringBuffer().append(str).append("00").toString().substring(2));
        }
        return stringBuffer2;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuffer stringBuffer) {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
                i = i3;
            } else if (i4 == 900 || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == BEGIN_MACRO_PDF417_CONTROL_BLOCK || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                i = i3 - 1;
                z = true;
            } else {
                i = i3;
            }
            if (i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) {
                stringBuffer.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
        }
        return i;
    }

    private static int textCompaction(int[] iArr, int i, StringBuffer stringBuffer) {
        int[] iArr2 = new int[iArr[0] << 1];
        int[] iArr3 = new int[iArr[0] << 1];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
                i = i3;
            } else {
                switch (i4) {
                    case 900:
                        i = i3 - 1;
                        z = true;
                        continue;
                    case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        i = i3 - 1;
                        z = true;
                        continue;
                    case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                        i = i3 - 1;
                        z = true;
                        continue;
                    case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /* 913 */:
                        iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                        iArr3[i2] = i4;
                        i2++;
                        i = i3;
                        continue;
                    case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                        i = i3 - 1;
                        z = true;
                        continue;
                    default:
                        i = i3;
                        continue;
                }
            }
        }
        decodeTextCompaction(iArr2, iArr3, i2, stringBuffer);
        return i;
    }
}
