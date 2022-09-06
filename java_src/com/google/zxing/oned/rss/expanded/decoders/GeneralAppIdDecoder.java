package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;
import com.hoho.android.usbserial.driver.UsbId;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GeneralAppIdDecoder {
    private final BitArray information;
    private final CurrentParsingState current = new CurrentParsingState();
    private final StringBuffer buffer = new StringBuffer();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    private DecodedChar decodeAlphanumeric(int i) {
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, C0359h.f679I);
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 6);
        if (extractNumericValueFromBitArray2 >= 32 && extractNumericValueFromBitArray2 < 58) {
            return new DecodedChar(i + 6, (char) (extractNumericValueFromBitArray2 + 33));
        }
        switch (extractNumericValueFromBitArray2) {
            case Opcodes.ASTORE /* 58 */:
                return new DecodedChar(i + 6, '*');
            case UsbId.ARDUINO_SERIAL_ADAPTER /* 59 */:
                return new DecodedChar(i + 6, C0359h.f727x);
            case 60:
                return new DecodedChar(i + 6, '-');
            case 61:
                return new DecodedChar(i + 6, C0359h.f677G);
            case 62:
                return new DecodedChar(i + 6, '/');
            default:
                throw new RuntimeException(new StringBuffer().append("Decoding invalid alphanumeric value: ").append(extractNumericValueFromBitArray2).toString());
        }
    }

    private DecodedChar decodeIsoIec646(int i) {
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, C0359h.f679I);
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray2 >= 64 && extractNumericValueFromBitArray2 < 90) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray2 + 1));
        }
        if (extractNumericValueFromBitArray2 >= 90 && extractNumericValueFromBitArray2 < 116) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray2 + 7));
        }
        int extractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i, 8);
        switch (extractNumericValueFromBitArray3) {
            case SmileConstants.TOKEN_MISC_BINARY_7BIT /* 232 */:
                return new DecodedChar(i + 8, '!');
            case 233:
                return new DecodedChar(i + 8, '\"');
            case 234:
                return new DecodedChar(i + 8, C0359h.f721r);
            case 235:
                return new DecodedChar(i + 8, '&');
            case SmileConstants.TOKEN_MISC_SHARED_STRING_LONG /* 236 */:
                return new DecodedChar(i + 8, C0359h.f729z);
            case 237:
                return new DecodedChar(i + 8, C0359h.f722s);
            case 238:
                return new DecodedChar(i + 8, C0359h.f723t);
            case 239:
                return new DecodedChar(i + 8, '*');
            case 240:
                return new DecodedChar(i + 8, SignatureVisitor.EXTENDS);
            case 241:
                return new DecodedChar(i + 8, C0359h.f727x);
            case 242:
                return new DecodedChar(i + 8, '-');
            case 243:
                return new DecodedChar(i + 8, C0359h.f677G);
            case 244:
                return new DecodedChar(i + 8, '/');
            case 245:
                return new DecodedChar(i + 8, C0359h.f671A);
            case 246:
                return new DecodedChar(i + 8, ';');
            case 247:
                return new DecodedChar(i + 8, '<');
            case 248:
                return new DecodedChar(i + 8, SignatureVisitor.INSTANCEOF);
            case 249:
                return new DecodedChar(i + 8, '>');
            case 250:
                return new DecodedChar(i + 8, '?');
            case 251:
                return new DecodedChar(i + 8, '_');
            case SmileConstants.INT_MARKER_END_OF_STRING /* 252 */:
                return new DecodedChar(i + 8, C5122l.f21763c);
            default:
                throw new RuntimeException(new StringBuffer().append("Decoding invalid ISO/IEC 646 value: ").append(extractNumericValueFromBitArray3).toString());
        }
    }

    private DecodedNumeric decodeNumeric(int i) {
        if (i + 7 > this.information.size) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 4);
            return extractNumericValueFromBitArray == 0 ? new DecodedNumeric(this.information.size, 10, 10) : new DecodedNumeric(this.information.size, extractNumericValueFromBitArray - 1, 10);
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        return new DecodedNumeric(i + 7, (extractNumericValueFromBitArray2 - 8) / 11, (extractNumericValueFromBitArray2 - 8) % 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int extractNumericValueFromBitArray(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        if (i2 > 32) {
            throw new IllegalArgumentException("extractNumberValueFromBitArray can't handle more than 32 bits");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean isAlphaOr646ToNumericLatch(int i) {
        if (i + 3 > this.information.size) {
            return false;
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i) {
        if (i + 1 > this.information.size) {
            return false;
        }
        for (int i2 = 0; i2 < 5 && i2 + i < this.information.size; i2++) {
            if (i2 == 2) {
                if (!this.information.get(i + 2)) {
                    return false;
                }
            } else if (this.information.get(i + i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i) {
        if (i + 1 > this.information.size) {
            return false;
        }
        for (int i2 = 0; i2 < 4 && i2 + i < this.information.size; i2++) {
            if (this.information.get(i + i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStillAlpha(int i) {
        boolean z = true;
        if (i + 5 > this.information.size) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 16) {
            return true;
        }
        if (i + 6 > this.information.size) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 6);
        if (extractNumericValueFromBitArray2 < 16 || extractNumericValueFromBitArray2 >= 63) {
            z = false;
        }
        return z;
    }

    private boolean isStillIsoIec646(int i) {
        boolean z = true;
        if (i + 5 > this.information.size) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 16) {
            return true;
        }
        if (i + 7 > this.information.size) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray2 >= 64 && extractNumericValueFromBitArray2 < 116) {
            return true;
        }
        if (i + 8 > this.information.size) {
            return false;
        }
        int extractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i, 8);
        if (extractNumericValueFromBitArray3 < 232 || extractNumericValueFromBitArray3 >= 253) {
            z = false;
        }
        return z;
    }

    private boolean isStillNumeric(int i) {
        if (i + 7 > this.information.size) {
            return i + 4 <= this.information.size;
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.information.get(i2)) {
                return true;
            }
        }
        return this.information.get(i + 3);
    }

    private BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.position)) {
            DecodedChar decodeAlphanumeric = decodeAlphanumeric(this.current.position);
            this.current.position = decodeAlphanumeric.getNewPosition();
            if (decodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.position, this.buffer.toString()), true);
            }
            this.buffer.append(decodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.position)) {
            this.current.position += 3;
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.position)) {
            if (this.current.position + 5 < this.information.size) {
                this.current.position += 5;
            } else {
                this.current.position = this.information.size;
            }
            this.current.setIsoIec646();
        }
        return new BlockParsedResult(false);
    }

    private DecodedInformation parseBlocks() {
        BlockParsedResult parseNumericBlock;
        boolean isFinished;
        do {
            int i = this.current.position;
            if (this.current.isAlpha()) {
                parseNumericBlock = parseAlphaBlock();
                isFinished = parseNumericBlock.isFinished();
            } else if (this.current.isIsoIec646()) {
                parseNumericBlock = parseIsoIec646Block();
                isFinished = parseNumericBlock.isFinished();
            } else {
                parseNumericBlock = parseNumericBlock();
                isFinished = parseNumericBlock.isFinished();
            }
            if (!(i != this.current.position) && !isFinished) {
                break;
            }
        } while (!isFinished);
        return parseNumericBlock.getDecodedInformation();
    }

    private BlockParsedResult parseIsoIec646Block() {
        while (isStillIsoIec646(this.current.position)) {
            DecodedChar decodeIsoIec646 = decodeIsoIec646(this.current.position);
            this.current.position = decodeIsoIec646.getNewPosition();
            if (decodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.position, this.buffer.toString()), true);
            }
            this.buffer.append(decodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.position)) {
            this.current.position += 3;
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.position)) {
            if (this.current.position + 5 < this.information.size) {
                this.current.position += 5;
            } else {
                this.current.position = this.information.size;
            }
            this.current.setAlpha();
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseNumericBlock() {
        while (isStillNumeric(this.current.position)) {
            DecodedNumeric decodeNumeric = decodeNumeric(this.current.position);
            this.current.position = decodeNumeric.getNewPosition();
            if (decodeNumeric.isFirstDigitFNC1()) {
                return new BlockParsedResult(decodeNumeric.isSecondDigitFNC1() ? new DecodedInformation(this.current.position, this.buffer.toString()) : new DecodedInformation(this.current.position, this.buffer.toString(), decodeNumeric.getSecondDigit()), true);
            }
            this.buffer.append(decodeNumeric.getFirstDigit());
            if (decodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.position, this.buffer.toString()), true);
            }
            this.buffer.append(decodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.position)) {
            this.current.setAlpha();
            this.current.position += 4;
        }
        return new BlockParsedResult(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String decodeAllCodes(StringBuffer stringBuffer, int i) {
        String str = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i, str);
            stringBuffer.append(FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString()));
            str = decodeGeneralPurposeField.isRemaining() ? String.valueOf(decodeGeneralPurposeField.getRemainingValue()) : null;
            if (i == decodeGeneralPurposeField.getNewPosition()) {
                return stringBuffer.toString();
            }
            i = decodeGeneralPurposeField.getNewPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedInformation decodeGeneralPurposeField(int i, String str) {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.position = i;
        DecodedInformation parseBlocks = parseBlocks();
        return (parseBlocks == null || !parseBlocks.isRemaining()) ? new DecodedInformation(this.current.position, this.buffer.toString()) : new DecodedInformation(this.current.position, this.buffer.toString(), parseBlocks.getRemainingValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int extractNumericValueFromBitArray(int i, int i2) {
        return extractNumericValueFromBitArray(this.information, i, i2);
    }
}
