package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import org.p248a.p249a.p261f.p264c.C5122l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class VCardResultParser extends ResultParser {
    private VCardResultParser() {
    }

    private static String decodeQuotedPrintable(String str, String str2) {
        char charAt;
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            switch (charAt2) {
                case '\n':
                case '\r':
                    break;
                case '=':
                    if (i < length - 2 && (charAt = str.charAt(i + 1)) != '\r' && charAt != '\n') {
                        try {
                            byteArrayOutputStream.write((toHexValue(charAt) * 16) + toHexValue(str.charAt(i + 2)));
                        } catch (IllegalArgumentException e) {
                        }
                        i += 2;
                        break;
                    }
                    break;
                default:
                    maybeAppendFragment(byteArrayOutputStream, str2, stringBuffer);
                    stringBuffer.append(charAt2);
                    break;
            }
            i++;
        }
        maybeAppendFragment(byteArrayOutputStream, str2, stringBuffer);
        return stringBuffer.toString();
    }

    private static String formatAddress(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == ';') {
                stringBuffer.append(C5122l.f21763c);
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString().trim();
    }

    private static void formatNames(String[] strArr) {
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                String[] strArr2 = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int indexOf = str.indexOf(59, i3);
                    if (indexOf > 0) {
                        strArr2[i2] = str.substring(i3, indexOf);
                        i2++;
                        i3 = indexOf + 1;
                    }
                }
                strArr2[i2] = str.substring(i3);
                StringBuffer stringBuffer = new StringBuffer(100);
                maybeAppendComponent(strArr2, 3, stringBuffer);
                maybeAppendComponent(strArr2, 1, stringBuffer);
                maybeAppendComponent(strArr2, 2, stringBuffer);
                maybeAppendComponent(strArr2, 0, stringBuffer);
                maybeAppendComponent(strArr2, 4, stringBuffer);
                strArr[i] = stringBuffer.toString().trim();
            }
        }
    }

    private static boolean isLikeVCardDate(String str) {
        if (str != null && !isStringOfDigits(str, 8)) {
            return str.length() == 10 && str.charAt(4) == '-' && str.charAt(7) == '-' && isSubstringOfDigits(str, 0, 4) && isSubstringOfDigits(str, 5, 2) && isSubstringOfDigits(str, 8, 2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String matchSingleVCardPrefixedField(String str, String str2, boolean z) {
        String[] matchVCardPrefixedField = matchVCardPrefixedField(str, str2, z);
        if (matchVCardPrefixedField == null) {
            return null;
        }
        return matchVCardPrefixedField[0];
    }

    private static String[] matchVCardPrefixedField(String str, String str2, boolean z) {
        String str3;
        int indexOf;
        Vector vector;
        int i;
        boolean z2;
        Vector vector2 = null;
        int i2 = 0;
        int length = str2.length();
        while (i2 < length) {
            int indexOf2 = str2.indexOf(str, i2);
            if (indexOf2 < 0) {
                break;
            } else if (indexOf2 <= 0 || str2.charAt(indexOf2 - 1) == '\n') {
                i2 = str.length() + indexOf2;
                if (str2.charAt(i2) == ':' || str2.charAt(i2) == ';') {
                    int i3 = i2;
                    while (str2.charAt(i3) != ':') {
                        i3++;
                    }
                    boolean z3 = false;
                    if (i3 > i2) {
                        int i4 = i2;
                        str3 = null;
                        for (int i5 = i2 + 1; i5 <= i3; i5++) {
                            if (str2.charAt(i5) == ';' || str2.charAt(i5) == ':') {
                                String substring = str2.substring(i4 + 1, i5);
                                int indexOf3 = substring.indexOf(61);
                                if (indexOf3 >= 0) {
                                    String substring2 = substring.substring(0, indexOf3);
                                    String substring3 = substring.substring(indexOf3 + 1);
                                    if (substring2.equalsIgnoreCase("ENCODING")) {
                                        if (substring3.equalsIgnoreCase("QUOTED-PRINTABLE")) {
                                            z2 = true;
                                            z3 = z2;
                                            i4 = i5;
                                        }
                                    } else if (substring2.equalsIgnoreCase("CHARSET")) {
                                        str3 = substring3;
                                        z2 = z3;
                                        z3 = z2;
                                        i4 = i5;
                                    }
                                }
                                z2 = z3;
                                z3 = z2;
                                i4 = i5;
                            }
                        }
                    } else {
                        str3 = null;
                    }
                    int i6 = i3 + 1;
                    int i7 = i6;
                    while (true) {
                        indexOf = str2.indexOf(10, i7);
                        if (indexOf < 0) {
                            break;
                        } else if (indexOf < str2.length() - 1 && (str2.charAt(indexOf + 1) == ' ' || str2.charAt(indexOf + 1) == '\t')) {
                            i7 = indexOf + 2;
                        } else if (!z3 || (str2.charAt(indexOf - 1) != '=' && str2.charAt(indexOf - 2) != '=')) {
                            break;
                        } else {
                            i7 = indexOf + 1;
                        }
                    }
                    if (indexOf < 0) {
                        vector = vector2;
                        i = length;
                    } else if (indexOf > i6) {
                        if (vector2 == null) {
                            vector2 = new Vector(1);
                        }
                        if (str2.charAt(indexOf - 1) == '\r') {
                            indexOf--;
                        }
                        String substring4 = str2.substring(i6, indexOf);
                        if (z) {
                            substring4 = substring4.trim();
                        }
                        vector2.addElement(z3 ? decodeQuotedPrintable(substring4, str3) : stripContinuationCRLF(substring4));
                        int i8 = indexOf + 1;
                        vector = vector2;
                        i = i8;
                    } else {
                        int i9 = indexOf + 1;
                        vector = vector2;
                        i = i9;
                    }
                    i2 = i;
                    vector2 = vector;
                }
            } else {
                i2 = indexOf2 + 1;
            }
        }
        if (vector2 == null || vector2.isEmpty()) {
            return null;
        }
        return toStringArray(vector2);
    }

    private static void maybeAppendComponent(String[] strArr, int i, StringBuffer stringBuffer) {
        if (strArr[i] != null) {
            stringBuffer.append(C5122l.f21763c);
            stringBuffer.append(strArr[i]);
        }
    }

    private static void maybeAppendFragment(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuffer stringBuffer) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException e) {
                    str2 = new String(byteArray);
                }
            }
            byteArrayOutputStream.reset();
            stringBuffer.append(str2);
        }
    }

    public static AddressBookParsedResult parse(Result result) {
        String text = result.getText();
        if (text == null || !text.startsWith("BEGIN:VCARD")) {
            return null;
        }
        String[] matchVCardPrefixedField = matchVCardPrefixedField("FN", text, true);
        if (matchVCardPrefixedField == null) {
            matchVCardPrefixedField = matchVCardPrefixedField("N", text, true);
            formatNames(matchVCardPrefixedField);
        }
        String[] matchVCardPrefixedField2 = matchVCardPrefixedField("TEL", text, true);
        String[] matchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", text, true);
        String matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NOTE", text, false);
        String[] matchVCardPrefixedField4 = matchVCardPrefixedField("ADR", text, true);
        if (matchVCardPrefixedField4 != null) {
            for (int i = 0; i < matchVCardPrefixedField4.length; i++) {
                matchVCardPrefixedField4[i] = formatAddress(matchVCardPrefixedField4[i]);
            }
        }
        String matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("ORG", text, true);
        String matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("BDAY", text, true);
        if (!isLikeVCardDate(matchSingleVCardPrefixedField3)) {
            matchSingleVCardPrefixedField3 = null;
        }
        return new AddressBookParsedResult(matchVCardPrefixedField, null, matchVCardPrefixedField2, matchVCardPrefixedField3, matchSingleVCardPrefixedField, matchVCardPrefixedField4, matchSingleVCardPrefixedField2, matchSingleVCardPrefixedField3, matchSingleVCardPrefixedField("TITLE", text, true), matchSingleVCardPrefixedField("URL", text, true));
    }

    private static String stripContinuationCRLF(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z = false;
        for (int i = 0; i < length; i++) {
            if (z) {
                z = false;
            } else {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case '\n':
                        z = true;
                        continue;
                    case 11:
                    case '\f':
                    default:
                        stringBuffer.append(charAt);
                        z = false;
                        continue;
                    case '\r':
                        z = false;
                        continue;
                }
            }
        }
        return stringBuffer.toString();
    }

    private static int toHexValue(char c) {
        if (c < '0' || c > '9') {
            if (c >= 'A' && c <= 'F') {
                return (c - 'A') + 10;
            }
            if (c >= 'a' && c <= 'f') {
                return (c - 'a') + 10;
            }
            throw new IllegalArgumentException();
        }
        return c - '0';
    }
}
