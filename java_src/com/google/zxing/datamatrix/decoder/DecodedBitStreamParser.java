package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final int ANSIX12_ENCODE = 4;
    private static final int ASCII_ENCODE = 1;
    private static final int BASE256_ENCODE = 6;
    private static final int C40_ENCODE = 2;
    private static final int EDIFACT_ENCODE = 5;
    private static final int PAD_ENCODE = 0;
    private static final int TEXT_ENCODE = 3;
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', C5122l.f21763c, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] C40_SHIFT2_SET_CHARS = {'!', '\"', '#', C0359h.f679I, C0359h.f721r, '&', C0359h.f729z, C0359h.f722s, C0359h.f723t, '*', SignatureVisitor.EXTENDS, C0359h.f727x, '-', C0359h.f677G, '/', C0359h.f671A, ';', '<', SignatureVisitor.INSTANCEOF, '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', C5122l.f21763c, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT3_SET_CHARS = {C0359h.f729z, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', C0359h.f725v, '|', C0359h.f726w, '~', 127};

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(byte[] bArr) {
        BitSource bitSource = new BitSource(bArr);
        StringBuffer stringBuffer = new StringBuffer(100);
        StringBuffer stringBuffer2 = new StringBuffer(0);
        Vector vector = new Vector(1);
        int i = 1;
        do {
            if (i == 1) {
                i = decodeAsciiSegment(bitSource, stringBuffer, stringBuffer2);
            } else {
                switch (i) {
                    case 2:
                        decodeC40Segment(bitSource, stringBuffer);
                        break;
                    case 3:
                        decodeTextSegment(bitSource, stringBuffer);
                        break;
                    case 4:
                        decodeAnsiX12Segment(bitSource, stringBuffer);
                        break;
                    case 5:
                        decodeEdifactSegment(bitSource, stringBuffer);
                        break;
                    case 6:
                        decodeBase256Segment(bitSource, stringBuffer, vector);
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                i = 1;
            }
            if (i != 0) {
            }
            if (stringBuffer2.length() > 0) {
                stringBuffer.append(stringBuffer2.toString());
            }
            String stringBuffer3 = stringBuffer.toString();
            if (vector.isEmpty()) {
                vector = null;
            }
            return new DecoderResult(bArr, stringBuffer3, vector, null);
        } while (bitSource.available() > 0);
        if (stringBuffer2.length() > 0) {
        }
        String stringBuffer32 = stringBuffer.toString();
        if (vector.isEmpty()) {
        }
        return new DecoderResult(bArr, stringBuffer32, vector, null);
    }

    private static void decodeAnsiX12Segment(BitSource bitSource, StringBuffer stringBuffer) {
        int readBits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    stringBuffer.append(C5122l.f21761a);
                } else if (i2 == 1) {
                    stringBuffer.append('*');
                } else if (i2 == 2) {
                    stringBuffer.append('>');
                } else if (i2 == 3) {
                    stringBuffer.append(C5122l.f21763c);
                } else if (i2 < 14) {
                    stringBuffer.append((char) (i2 + 44));
                } else if (i2 >= 40) {
                    throw FormatException.getFormatInstance();
                } else {
                    stringBuffer.append((char) (i2 + 51));
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static int decodeAsciiSegment(BitSource bitSource, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        boolean z = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            }
            if (readBits <= 128) {
                stringBuffer.append((char) ((z ? readBits + 128 : readBits) - 1));
                return 1;
            } else if (readBits == 129) {
                return 0;
            } else {
                if (readBits <= 229) {
                    int i = readBits - 130;
                    if (i < 10) {
                        stringBuffer.append('0');
                    }
                    stringBuffer.append(i);
                } else if (readBits == 230) {
                    return 2;
                } else {
                    if (readBits == 231) {
                        return 6;
                    }
                    if (readBits != 232 && readBits != 233 && readBits != 234) {
                        if (readBits == 235) {
                            z = true;
                        } else if (readBits == 236) {
                            stringBuffer.append("[)>\u001e05\u001d");
                            stringBuffer2.insert(0, "\u001e\u0004");
                        } else if (readBits == 237) {
                            stringBuffer.append("[)>\u001e06\u001d");
                            stringBuffer2.insert(0, "\u001e\u0004");
                        } else if (readBits == 238) {
                            return 4;
                        } else {
                            if (readBits == 239) {
                                return 3;
                            }
                            if (readBits == 240) {
                                return 5;
                            }
                            if (readBits != 241 && readBits >= 242) {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return 1;
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuffer stringBuffer, Vector vector) {
        int readBits = bitSource.readBits(8);
        if (readBits == 0) {
            readBits = bitSource.available() / 8;
        } else if (readBits >= 250) {
            readBits = ((readBits - 249) * 250) + bitSource.readBits(8);
        }
        byte[] bArr = new byte[readBits];
        for (int i = 0; i < readBits; i++) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i] = unrandomize255State(bitSource.readBits(8), i);
        }
        vector.addElement(bArr);
        try {
            stringBuffer.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(new StringBuffer().append("Platform does not support required encoding: ").append(e).toString());
        }
    }

    private static void decodeC40Segment(BitSource bitSource, StringBuffer stringBuffer) {
        int readBits;
        boolean z;
        int i;
        int[] iArr = new int[3];
        boolean z2 = false;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            int i2 = 0;
            int i3 = 0;
            while (i2 < 3) {
                int i4 = iArr[i2];
                switch (i3) {
                    case 0:
                        if (i4 >= 3) {
                            if (!z2) {
                                stringBuffer.append(C40_BASIC_SET_CHARS[i4]);
                                int i5 = i3;
                                z = z2;
                                i = i5;
                                break;
                            } else {
                                stringBuffer.append((char) (C40_BASIC_SET_CHARS[i4] + 128));
                                i = i3;
                                z = false;
                                break;
                            }
                        } else {
                            z = z2;
                            i = i4 + 1;
                            break;
                        }
                    case 1:
                        if (z2) {
                            stringBuffer.append((char) (i4 + 128));
                            z2 = false;
                        } else {
                            stringBuffer.append(i4);
                        }
                        z = z2;
                        i = 0;
                        break;
                    case 2:
                        if (i4 < 27) {
                            if (z2) {
                                stringBuffer.append((char) (C40_SHIFT2_SET_CHARS[i4] + 128));
                                z2 = false;
                            } else {
                                stringBuffer.append(C40_SHIFT2_SET_CHARS[i4]);
                            }
                        } else if (i4 == 27) {
                            throw FormatException.getFormatInstance();
                        } else {
                            if (i4 != 30) {
                                throw FormatException.getFormatInstance();
                            }
                            z2 = true;
                        }
                        z = z2;
                        i = 0;
                        break;
                    case 3:
                        if (z2) {
                            stringBuffer.append((char) (i4 + 224));
                            z2 = false;
                        } else {
                            stringBuffer.append((char) (i4 + 96));
                        }
                        z = z2;
                        i = 0;
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                i2++;
                int i6 = i;
                z2 = z;
                i3 = i6;
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void decodeEdifactSegment(BitSource bitSource, StringBuffer stringBuffer) {
        boolean z = false;
        while (bitSource.available() > 16) {
            int i = 0;
            while (i < 4) {
                int readBits = bitSource.readBits(6);
                boolean z2 = readBits == 11111 ? true : z;
                if (!z2) {
                    stringBuffer.append((readBits & 32) == 0 ? readBits | 64 : readBits);
                }
                i++;
                z = z2;
            }
            if (z || bitSource.available() <= 0) {
                return;
            }
            while (bitSource.available() > 16) {
            }
        }
    }

    private static void decodeTextSegment(BitSource bitSource, StringBuffer stringBuffer) {
        int readBits;
        boolean z;
        int i;
        int[] iArr = new int[3];
        boolean z2 = false;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            int i2 = 0;
            int i3 = 0;
            while (i2 < 3) {
                int i4 = iArr[i2];
                switch (i3) {
                    case 0:
                        if (i4 >= 3) {
                            if (!z2) {
                                stringBuffer.append(TEXT_BASIC_SET_CHARS[i4]);
                                int i5 = i3;
                                z = z2;
                                i = i5;
                                break;
                            } else {
                                stringBuffer.append((char) (TEXT_BASIC_SET_CHARS[i4] + 128));
                                i = i3;
                                z = false;
                                break;
                            }
                        } else {
                            z = z2;
                            i = i4 + 1;
                            break;
                        }
                    case 1:
                        if (z2) {
                            stringBuffer.append((char) (i4 + 128));
                            z2 = false;
                        } else {
                            stringBuffer.append(i4);
                        }
                        z = z2;
                        i = 0;
                        break;
                    case 2:
                        if (i4 < 27) {
                            if (z2) {
                                stringBuffer.append((char) (C40_SHIFT2_SET_CHARS[i4] + 128));
                                z2 = false;
                            } else {
                                stringBuffer.append(C40_SHIFT2_SET_CHARS[i4]);
                            }
                        } else if (i4 == 27) {
                            throw FormatException.getFormatInstance();
                        } else {
                            if (i4 != 30) {
                                throw FormatException.getFormatInstance();
                            }
                            z2 = true;
                        }
                        z = z2;
                        i = 0;
                        break;
                    case 3:
                        if (z2) {
                            stringBuffer.append((char) (TEXT_SHIFT3_SET_CHARS[i4] + 128));
                            z2 = false;
                        } else {
                            stringBuffer.append(TEXT_SHIFT3_SET_CHARS[i4]);
                        }
                        z = z2;
                        i = 0;
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                i2++;
                int i6 = i;
                z2 = z;
                i3 = i6;
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static byte unrandomize255State(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        if (i3 < 0) {
            i3 += 256;
        }
        return (byte) i3;
    }
}
