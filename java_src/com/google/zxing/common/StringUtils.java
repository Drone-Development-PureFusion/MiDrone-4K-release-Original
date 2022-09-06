package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Hashtable;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = System.getProperty("file.encoding");
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF-8";

    static {
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Hashtable hashtable) {
        boolean z;
        int i;
        boolean z2;
        String str;
        if (hashtable == null || (str = (String) hashtable.get(DecodeHintType.CHARACTER_SET)) == null) {
            if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
                return "UTF-8";
            }
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            boolean z3 = false;
            boolean z4 = false;
            int i4 = 0;
            boolean z5 = false;
            int i5 = 0;
            boolean z6 = true;
            boolean z7 = true;
            boolean z8 = true;
            while (i4 < length && (z8 || z7 || z6)) {
                int i6 = bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if (i6 < 128 || i6 > 191) {
                    z = i2 > 0 ? false : z6;
                    if (i6 >= 192 && i6 <= 253) {
                        int i7 = i2;
                        int i8 = i6;
                        while ((i8 & 64) != 0) {
                            i8 <<= 1;
                            i7++;
                        }
                        i2 = i7;
                        z4 = true;
                    }
                } else if (i2 > 0) {
                    i2--;
                    z = z6;
                } else {
                    z = z6;
                }
                if ((i6 == 194 || i6 == 195) && i4 < length - 1 && (i = bArr[i4 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) <= 191 && ((i6 == 194 && i >= 160) || (i6 == 195 && i >= 128))) {
                    z3 = true;
                }
                if (i6 >= 127 && i6 <= 159) {
                    z8 = false;
                }
                if (i6 >= 161 && i6 <= 223 && !z5) {
                    i3++;
                }
                boolean z9 = (z5 || !((i6 >= 240 && i6 <= 255) || i6 == 128 || i6 == 160)) ? z7 : false;
                if ((i6 < 129 || i6 > 159) && (i6 < 224 || i6 > 239)) {
                    z2 = false;
                } else if (z5) {
                    z2 = false;
                } else {
                    z2 = true;
                    if (i4 >= bArr.length - 1) {
                        z9 = false;
                    } else {
                        int i9 = bArr[i4 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                        if (i9 < 64 || i9 > 252) {
                            z9 = false;
                        } else {
                            i5++;
                        }
                    }
                }
                boolean z10 = z2;
                z7 = z9;
                i4++;
                z5 = z10;
                i5 = i5;
                z6 = z;
            }
            if (i2 > 0) {
                z6 = false;
            }
            return (!z7 || !ASSUME_SHIFT_JIS) ? (!z6 || !z4) ? (!z7 || (i5 < 3 && i3 * 20 <= length)) ? (z3 || !z8) ? PLATFORM_DEFAULT_ENCODING : ISO88591 : SHIFT_JIS : "UTF-8" : SHIFT_JIS;
        }
        return str;
    }
}
