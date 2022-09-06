package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.tencent.p227mm.sdk.contact.RContact;
import java.util.Hashtable;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
final class UPCEANExtensionSupport {
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuffer decodeRowStringBuffer = new StringBuffer();
    private static final int[] EXTENSION_START_PATTERN = {1, 1, 2};
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    private static int determineCheckDigit(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == CHECK_DIGIT_ENCODINGS[i2]) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += str.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += str.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    private static Integer parseExtension2String(String str) {
        return Integer.valueOf(str);
    }

    private static String parseExtension5String(String str) {
        String str2 = null;
        switch (str.charAt(0)) {
            case '0':
                str2 = "拢";
                break;
            case Opcodes.SALOAD /* 53 */:
                str2 = RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR;
                break;
            case Opcodes.DSTORE /* 57 */:
                if ("99991".equals(str)) {
                    return "0.00";
                }
                if ("99990".equals(str)) {
                    return "Used";
                }
                break;
            default:
                str2 = "";
                break;
        }
        int parseInt = Integer.parseInt(str.substring(1));
        return new StringBuffer().append(str2).append(parseInt / 100).append(C0359h.f677G).append(parseInt % 100).toString();
    }

    private static Hashtable parseExtensionString(String str) {
        ResultMetadataType resultMetadataType;
        Object parseExtension5String;
        switch (str.length()) {
            case 2:
                resultMetadataType = ResultMetadataType.ISSUE_NUMBER;
                parseExtension5String = parseExtension2String(str);
                break;
            case 3:
            case 4:
            default:
                return null;
            case 5:
                resultMetadataType = ResultMetadataType.SUGGESTED_PRICE;
                parseExtension5String = parseExtension5String(str);
                break;
        }
        if (parseExtension5String != null) {
            Hashtable hashtable = new Hashtable(1);
            hashtable.put(resultMetadataType, parseExtension5String);
            return hashtable;
        }
        return null;
    }

    int decodeMiddle(BitArray bitArray, int[] iArr, StringBuffer stringBuffer) {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5 && i < size) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i, UPCEANReader.L_AND_G_PATTERNS);
            stringBuffer.append((char) ((decodeDigit % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            int i6 = decodeDigit >= 10 ? (1 << (4 - i2)) | i3 : i3;
            if (i2 != 4) {
                while (i4 < size && !bitArray.get(i4)) {
                    i4++;
                }
                while (i4 < size && bitArray.get(i4)) {
                    i4++;
                }
            }
            i2++;
            i3 = i6;
            i = i4;
        }
        if (stringBuffer.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (extensionChecksum(stringBuffer.toString()) == determineCheckDigit(i3)) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Result decodeRow(int i, BitArray bitArray, int i2) {
        int[] findGuardPattern = UPCEANReader.findGuardPattern(bitArray, i2, false, EXTENSION_START_PATTERN);
        StringBuffer stringBuffer = this.decodeRowStringBuffer;
        stringBuffer.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, findGuardPattern, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        Hashtable parseExtensionString = parseExtensionString(stringBuffer2);
        Result result = new Result(stringBuffer2, null, new ResultPoint[]{new ResultPoint((findGuardPattern[1] + findGuardPattern[0]) / 2.0f, i), new ResultPoint(decodeMiddle, i)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }
}
