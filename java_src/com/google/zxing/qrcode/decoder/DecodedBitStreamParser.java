package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', C5122l.f21763c, C0359h.f679I, C0359h.f721r, '*', SignatureVisitor.EXTENDS, '-', C0359h.f677G, '/', C0359h.f671A};

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Hashtable hashtable) {
        Mode forBits;
        boolean z;
        Vector vector = null;
        BitSource bitSource = new BitSource(bArr);
        StringBuffer stringBuffer = new StringBuffer(50);
        boolean z2 = false;
        Vector vector2 = new Vector(1);
        CharacterSetECI characterSetECI = null;
        while (true) {
            if (bitSource.available() < 4) {
                forBits = Mode.TERMINATOR;
            } else {
                try {
                    forBits = Mode.forBits(bitSource.readBits(4));
                } catch (IllegalArgumentException e) {
                    throw FormatException.getFormatInstance();
                }
            }
            if (forBits.equals(Mode.TERMINATOR)) {
                z = z2;
            } else if (forBits.equals(Mode.FNC1_FIRST_POSITION) || forBits.equals(Mode.FNC1_SECOND_POSITION)) {
                z = true;
            } else if (forBits.equals(Mode.STRUCTURED_APPEND)) {
                bitSource.readBits(16);
                z = z2;
            } else if (forBits.equals(Mode.ECI)) {
                characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                if (characterSetECI == null) {
                    throw FormatException.getFormatInstance();
                }
                z = z2;
            } else {
                int readBits = bitSource.readBits(forBits.getCharacterCountBits(version));
                if (forBits.equals(Mode.NUMERIC)) {
                    decodeNumericSegment(bitSource, stringBuffer, readBits);
                    z = z2;
                } else if (forBits.equals(Mode.ALPHANUMERIC)) {
                    decodeAlphanumericSegment(bitSource, stringBuffer, readBits, z2);
                    z = z2;
                } else if (forBits.equals(Mode.BYTE)) {
                    decodeByteSegment(bitSource, stringBuffer, readBits, characterSetECI, vector2, hashtable);
                    z = z2;
                } else if (!forBits.equals(Mode.KANJI)) {
                    throw FormatException.getFormatInstance();
                } else {
                    decodeKanjiSegment(bitSource, stringBuffer, readBits);
                    z = z2;
                }
            }
            if (forBits.equals(Mode.TERMINATOR)) {
                String stringBuffer2 = stringBuffer.toString();
                if (!vector2.isEmpty()) {
                    vector = vector2;
                }
                return new DecoderResult(bArr, stringBuffer2, vector, errorCorrectionLevel);
            }
            z2 = z;
        }
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuffer stringBuffer, int i, boolean z) {
        while (i > 1) {
            int readBits = bitSource.readBits(11);
            stringBuffer.append(toAlphaNumericChar(readBits / 45));
            stringBuffer.append(toAlphaNumericChar(readBits % 45));
            i -= 2;
        }
        if (i == 1) {
            stringBuffer.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            for (int length = stringBuffer.length(); length < stringBuffer.length(); length++) {
                if (stringBuffer.charAt(length) == '%') {
                    if (length >= stringBuffer.length() - 1 || stringBuffer.charAt(length + 1) != '%') {
                        stringBuffer.setCharAt(length, (char) 29);
                    } else {
                        stringBuffer.deleteCharAt(length + 1);
                    }
                }
            }
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuffer stringBuffer, int i, CharacterSetECI characterSetECI, Vector vector, Hashtable hashtable) {
        byte[] bArr = new byte[i];
        if ((i << 3) > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) bitSource.readBits(8);
        }
        try {
            stringBuffer.append(new String(bArr, characterSetECI == null ? StringUtils.guessEncoding(bArr, hashtable) : characterSetECI.getEncodingName()));
            vector.addElement(bArr);
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuffer stringBuffer, int i) {
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int readBits = bitSource.readBits(13);
            int i3 = (readBits % 192) | ((readBits / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i--;
            i2 += 2;
        }
        try {
            stringBuffer.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuffer stringBuffer, int i) {
        while (i >= 3) {
            int readBits = bitSource.readBits(10);
            if (readBits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            stringBuffer.append(toAlphaNumericChar(readBits / 100));
            stringBuffer.append(toAlphaNumericChar((readBits / 10) % 10));
            stringBuffer.append(toAlphaNumericChar(readBits % 10));
            i -= 3;
        }
        if (i == 2) {
            int readBits2 = bitSource.readBits(7);
            if (readBits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            stringBuffer.append(toAlphaNumericChar(readBits2 / 10));
            stringBuffer.append(toAlphaNumericChar(readBits2 % 10));
        } else if (i != 1) {
        } else {
            int readBits3 = bitSource.readBits(4);
            if (readBits3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            stringBuffer.append(toAlphaNumericChar(readBits3));
        }
    }

    private static int parseECIValue(BitSource bitSource) {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return ((readBits & 63) << 8) | bitSource.readBits(8);
        } else if ((readBits & 224) != 192) {
            throw new IllegalArgumentException(new StringBuffer().append("Bad ECI bits starting with byte ").append(readBits).toString());
        } else {
            return ((readBits & 31) << 16) | bitSource.readBits(16);
        }
    }

    private static char toAlphaNumericChar(int i) {
        if (i >= ALPHANUMERIC_CHARS.length) {
            throw FormatException.getFormatInstance();
        }
        return ALPHANUMERIC_CHARS[i];
    }
}
