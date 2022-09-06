package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.ECI;
import com.google.zxing.common.reedsolomon.GF256;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "UTF-8";

    private Encoder() {
    }

    static void append8BitBytes(String str, BitArray bitArray, String str2) {
        try {
            for (byte b : str.getBytes(str2)) {
                bitArray.appendBits(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    static void appendAlphanumericBytes(String str, BitArray bitArray) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(str.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            if (i + 1 < length) {
                int alphanumericCode2 = getAlphanumericCode(str.charAt(i + 1));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i++;
            }
        }
    }

    static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) {
        if (mode.equals(Mode.NUMERIC)) {
            appendNumericBytes(str, bitArray);
        } else if (mode.equals(Mode.ALPHANUMERIC)) {
            appendAlphanumericBytes(str, bitArray);
        } else if (mode.equals(Mode.BYTE)) {
            append8BitBytes(str, bitArray, str2);
        } else if (!mode.equals(Mode.KANJI)) {
            throw new WriterException(new StringBuffer().append("Invalid mode: ").append(mode).toString());
        } else {
            appendKanjiBytes(str, bitArray);
        }
    }

    private static void appendECI(ECI eci, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(eci.getValue(), 8);
    }

    static void appendKanjiBytes(String str, BitArray bitArray) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bytes[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                int i3 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i3 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.appendBits((i3 & 255) + ((i3 >> 8) * 192), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    static void appendLengthInfo(int i, int i2, Mode mode, BitArray bitArray) {
        int characterCountBits = mode.getCharacterCountBits(Version.getVersionForNumber(i2));
        if (i > (1 << characterCountBits) - 1) {
            throw new WriterException(new StringBuffer().append(i).append("is bigger than").append((1 << characterCountBits) - 1).toString());
        }
        bitArray.appendBits(i, characterCountBits);
    }

    static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendNumericBytes(String str, BitArray bitArray) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int charAt = str.charAt(i) - '0';
            if (i + 2 < length) {
                bitArray.appendBits((charAt * 100) + ((str.charAt(i + 1) - '0') * 10) + (str.charAt(i + 2) - '0'), 10);
                i += 3;
            } else if (i + 1 < length) {
                bitArray.appendBits((charAt * 10) + (str.charAt(i + 1) - '0'), 7);
                i += 2;
            } else {
                bitArray.appendBits(charAt, 4);
                i++;
            }
        }
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return 0 + MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        int i4 = 0;
        while (i4 < 8) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, i, i4, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i2) {
                i3 = i4;
            } else {
                calculateMaskPenalty = i2;
            }
            i4++;
            i2 = calculateMaskPenalty;
        }
        return i3;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    public static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return isOnlyDoubleByteKanji(str) ? Mode.KANJI : Mode.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (getAlphanumericCode(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z = true;
            }
        }
        return z ? Mode.ALPHANUMERIC : z2 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static void encode(String str, ErrorCorrectionLevel errorCorrectionLevel, QRCode qRCode) {
        encode(str, errorCorrectionLevel, null, qRCode);
    }

    public static void encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Hashtable hashtable, QRCode qRCode) {
        CharacterSetECI characterSetECIByName;
        String str2 = hashtable == null ? null : (String) hashtable.get(EncodeHintType.CHARACTER_SET);
        if (str2 == null) {
            str2 = "UTF-8";
        }
        Mode chooseMode = chooseMode(str, str2);
        BitArray bitArray = new BitArray();
        appendBytes(str, chooseMode, bitArray, str2);
        initQRCode(bitArray.getSizeInBytes(), errorCorrectionLevel, chooseMode, qRCode);
        BitArray bitArray2 = new BitArray();
        if (chooseMode == Mode.BYTE && !"UTF-8".equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
            appendECI(characterSetECIByName, bitArray2);
        }
        appendModeInfo(chooseMode, bitArray2);
        appendLengthInfo(chooseMode.equals(Mode.BYTE) ? bitArray.getSizeInBytes() : str.length(), qRCode.getVersion(), chooseMode, bitArray2);
        bitArray2.appendBitArray(bitArray);
        terminateBits(qRCode.getNumDataBytes(), bitArray2);
        BitArray bitArray3 = new BitArray();
        interleaveWithECBytes(bitArray2, qRCode.getNumTotalBytes(), qRCode.getNumDataBytes(), qRCode.getNumRSBlocks(), bitArray3);
        ByteMatrix byteMatrix = new ByteMatrix(qRCode.getMatrixWidth(), qRCode.getMatrixWidth());
        qRCode.setMaskPattern(chooseMaskPattern(bitArray3, qRCode.getECLevel(), qRCode.getVersion(), byteMatrix));
        MatrixUtil.buildMatrix(bitArray3, qRCode.getECLevel(), qRCode.getVersion(), qRCode.getMaskPattern(), byteMatrix);
        qRCode.setMatrix(byteMatrix);
        if (!qRCode.isValid()) {
            throw new WriterException(new StringBuffer().append("Invalid QR code: ").append(qRCode.toString()).toString());
        }
    }

    static byte[] generateECBytes(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        }
        new ReedSolomonEncoder(GF256.QR_CODE_FIELD).encode(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static int getAlphanumericCode(int i) {
        if (i < ALPHANUMERIC_TABLE.length) {
            return ALPHANUMERIC_TABLE[i];
        }
        return -1;
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != (i5 * (i10 + i12)) + ((i9 + i11) * i6)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
            return;
        }
        iArr[0] = i10;
        iArr2[0] = i12;
    }

    private static void initQRCode(int i, ErrorCorrectionLevel errorCorrectionLevel, Mode mode, QRCode qRCode) {
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(mode);
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            int totalCodewords = versionForNumber.getTotalCodewords();
            Version.ECBlocks eCBlocksForLevel = versionForNumber.getECBlocksForLevel(errorCorrectionLevel);
            int totalECCodewords = eCBlocksForLevel.getTotalECCodewords();
            int numBlocks = eCBlocksForLevel.getNumBlocks();
            int i3 = totalCodewords - totalECCodewords;
            if (i3 >= i + 3) {
                qRCode.setVersion(i2);
                qRCode.setNumTotalBytes(totalCodewords);
                qRCode.setNumDataBytes(i3);
                qRCode.setNumRSBlocks(numBlocks);
                qRCode.setNumECBytes(totalECCodewords);
                qRCode.setMatrixWidth(versionForNumber.getDimensionForVersion());
                return;
            }
        }
        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    static void interleaveWithECBytes(BitArray bitArray, int i, int i2, int i3, BitArray bitArray2) {
        if (bitArray.getSizeInBytes() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        Vector vector = new Vector(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            bitArray.toBytes(i7 * 8, bArr, 0, i8);
            byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
            vector.addElement(new BlockPair(bArr, generateECBytes));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, generateECBytes.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new WriterException("Data bytes does not match offset");
        }
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 < vector.size()) {
                    byte[] dataBytes = ((BlockPair) vector.elementAt(i11)).getDataBytes();
                    if (i9 < dataBytes.length) {
                        bitArray2.appendBits(dataBytes[i9], 8);
                    }
                    i10 = i11 + 1;
                }
            }
        }
        for (int i12 = 0; i12 < i5; i12++) {
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 < vector.size()) {
                    byte[] errorCorrectionBytes = ((BlockPair) vector.elementAt(i14)).getErrorCorrectionBytes();
                    if (i12 < errorCorrectionBytes.length) {
                        bitArray2.appendBits(errorCorrectionBytes[i12], 8);
                    }
                    i13 = i14 + 1;
                }
            }
        }
        if (i == bitArray2.getSizeInBytes()) {
            return;
        }
        throw new WriterException(new StringBuffer().append("Interleaving error: ").append(i).append(" and ").append(bitArray2.getSizeInBytes()).append(" differ.").toString());
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    static void terminateBits(int i, BitArray bitArray) {
        int i2 = i << 3;
        if (bitArray.getSize() > i2) {
            throw new WriterException(new StringBuffer().append("data bits cannot fit in the QR Code").append(bitArray.getSize()).append(" > ").append(i2).toString());
        }
        for (int i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i - bitArray.getSizeInBytes();
        for (int i4 = 0; i4 < sizeInBytes; i4++) {
            bitArray.appendBits((i4 & 1) == 0 ? SmileConstants.TOKEN_MISC_SHARED_STRING_LONG : 17, 8);
        }
        if (bitArray.getSize() == i2) {
            return;
        }
        throw new WriterException("Bits size does not equal capacity");
    }
}
