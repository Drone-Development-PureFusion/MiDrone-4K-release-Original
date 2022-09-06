package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Hashtable;
import java.util.Vector;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public abstract class ResultParser {
    private static void appendKeyValue(String str, int i, int i2, Hashtable hashtable) {
        int indexOf = str.indexOf(61, i);
        if (indexOf >= 0) {
            hashtable.put(str.substring(i, indexOf), urlDecode(str.substring(indexOf + 1, i2)));
        }
    }

    private static int findFirstEscape(char[] cArr) {
        int length = cArr.length;
        int i = 0;
        while (i < length) {
            char c = cArr[i];
            if (c == '+' || c == '%') {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isStringOfDigits(String str, int i) {
        if (str != null && i == str.length()) {
            for (int i2 = 0; i2 < i; i2++) {
                char charAt = str.charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isSubstringOfDigits(String str, int i, int i2) {
        int i3;
        if (str != null && str.length() >= (i3 = i + i2)) {
            while (i < i3) {
                char charAt = str.charAt(i);
                if (charAt < '0' || charAt > '9') {
                    return false;
                }
                i++;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] matchPrefixedField(String str, String str2, char c, boolean z) {
        int length = str2.length();
        int i = 0;
        Vector vector = null;
        while (i < length) {
            int indexOf = str2.indexOf(str, i);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z2 = false;
            Vector vector2 = vector;
            int i2 = length2;
            while (!z2) {
                int indexOf2 = str2.indexOf(c, i2);
                if (indexOf2 < 0) {
                    i2 = str2.length();
                    z2 = true;
                } else if (str2.charAt(indexOf2 - 1) == '\\') {
                    i2 = indexOf2 + 1;
                } else {
                    if (vector2 == null) {
                        vector2 = new Vector(3);
                    }
                    String unescapeBackslash = unescapeBackslash(str2.substring(length2, indexOf2));
                    if (z) {
                        unescapeBackslash = unescapeBackslash.trim();
                    }
                    vector2.addElement(unescapeBackslash);
                    i2 = indexOf2 + 1;
                    z2 = true;
                }
            }
            int i3 = i2;
            vector = vector2;
            i = i3;
        }
        if (vector == null || vector.isEmpty()) {
            return null;
        }
        return toStringArray(vector);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String matchSinglePrefixedField(String str, String str2, char c, boolean z) {
        String[] matchPrefixedField = matchPrefixedField(str, str2, c, z);
        if (matchPrefixedField == null) {
            return null;
        }
        return matchPrefixedField[0];
    }

    protected static void maybeAppend(String str, StringBuffer stringBuffer) {
        if (str != null) {
            stringBuffer.append('\n');
            stringBuffer.append(str);
        }
    }

    protected static void maybeAppend(String[] strArr, StringBuffer stringBuffer) {
        if (strArr != null) {
            for (String str : strArr) {
                stringBuffer.append('\n');
                stringBuffer.append(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] maybeWrap(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    private static int parseHexDigit(char c) {
        if (c >= 'a') {
            if (c <= 'f') {
                return (c - 'a') + 10;
            }
        } else if (c >= 'A') {
            if (c <= 'F') {
                return (c - 'A') + 10;
            }
        } else if (c >= '0' && c <= '9') {
            return c - '0';
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Hashtable parseNameValuePairs(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        Hashtable hashtable = new Hashtable(3);
        int i = indexOf + 1;
        while (true) {
            int indexOf2 = str.indexOf(38, i);
            if (indexOf2 < 0) {
                appendKeyValue(str, i, str.length(), hashtable);
                return hashtable;
            }
            appendKeyValue(str, i, indexOf2, hashtable);
            i = indexOf2 + 1;
        }
    }

    public static ParsedResult parseResult(Result result) {
        URIParsedResult parse = BookmarkDoCoMoResultParser.parse(result);
        if (parse != null) {
            return parse;
        }
        AddressBookParsedResult parse2 = AddressBookDoCoMoResultParser.parse(result);
        if (parse2 != null) {
            return parse2;
        }
        EmailAddressParsedResult parse3 = EmailDoCoMoResultParser.parse(result);
        if (parse3 != null) {
            return parse3;
        }
        AddressBookParsedResult parse4 = AddressBookAUResultParser.parse(result);
        if (parse4 != null) {
            return parse4;
        }
        AddressBookParsedResult parse5 = VCardResultParser.parse(result);
        if (parse5 != null) {
            return parse5;
        }
        AddressBookParsedResult parse6 = BizcardResultParser.parse(result);
        if (parse6 != null) {
            return parse6;
        }
        CalendarParsedResult parse7 = VEventResultParser.parse(result);
        if (parse7 != null) {
            return parse7;
        }
        EmailAddressParsedResult parse8 = EmailAddressResultParser.parse(result);
        if (parse8 != null) {
            return parse8;
        }
        TelParsedResult parse9 = TelResultParser.parse(result);
        if (parse9 != null) {
            return parse9;
        }
        SMSParsedResult parse10 = SMSMMSResultParser.parse(result);
        if (parse10 != null) {
            return parse10;
        }
        SMSParsedResult parse11 = SMSTOMMSTOResultParser.parse(result);
        if (parse11 != null) {
            return parse11;
        }
        GeoParsedResult parse12 = GeoResultParser.parse(result);
        if (parse12 != null) {
            return parse12;
        }
        WifiParsedResult parse13 = WifiResultParser.parse(result);
        if (parse13 != null) {
            return parse13;
        }
        URIParsedResult parse14 = URLTOResultParser.parse(result);
        if (parse14 != null) {
            return parse14;
        }
        URIParsedResult parse15 = URIResultParser.parse(result);
        if (parse15 != null) {
            return parse15;
        }
        ISBNParsedResult parse16 = ISBNResultParser.parse(result);
        if (parse16 != null) {
            return parse16;
        }
        ProductParsedResult parse17 = ProductResultParser.parse(result);
        if (parse17 != null) {
            return parse17;
        }
        ExpandedProductParsedResult parse18 = ExpandedProductResultParser.parse(result);
        return parse18 == null ? new TextParsedResult(result.getText(), null) : parse18;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] toStringArray(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    protected static String unescapeBackslash(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(92)) < 0) {
            return str;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length - 1);
        stringBuffer.append(str.toCharArray(), 0, indexOf);
        boolean z = false;
        for (int i = indexOf; i < length; i++) {
            char charAt = str.charAt(i);
            if (z || charAt != '\\') {
                stringBuffer.append(charAt);
                z = false;
            } else {
                z = true;
            }
        }
        return stringBuffer.toString();
    }

    private static String urlDecode(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int findFirstEscape = findFirstEscape(charArray);
        if (findFirstEscape < 0) {
            return str;
        }
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer(length - 2);
        stringBuffer.append(charArray, 0, findFirstEscape);
        while (findFirstEscape < length) {
            char c = charArray[findFirstEscape];
            if (c == '+') {
                stringBuffer.append(C5122l.f21763c);
            } else if (c != '%') {
                stringBuffer.append(c);
            } else if (findFirstEscape >= length - 2) {
                stringBuffer.append(C0359h.f721r);
            } else {
                int i = findFirstEscape + 1;
                int parseHexDigit = parseHexDigit(charArray[i]);
                findFirstEscape = i + 1;
                int parseHexDigit2 = parseHexDigit(charArray[findFirstEscape]);
                if (parseHexDigit < 0 || parseHexDigit2 < 0) {
                    stringBuffer.append(C0359h.f721r);
                    stringBuffer.append(charArray[findFirstEscape - 1]);
                    stringBuffer.append(charArray[findFirstEscape]);
                }
                stringBuffer.append((char) ((parseHexDigit << 4) + parseHexDigit2));
            }
            findFirstEscape++;
        }
        return stringBuffer.toString();
    }
}
