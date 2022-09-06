package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Hashtable;
import java.util.Vector;
/* loaded from: classes.dex */
final class SMSMMSResultParser extends ResultParser {
    private SMSMMSResultParser() {
    }

    private static void addNumberVia(Vector vector, Vector vector2, String str) {
        String str2 = null;
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            vector.addElement(str);
            vector2.addElement(null);
            return;
        }
        vector.addElement(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            str2 = substring.substring(4);
        }
        vector2.addElement(str2);
    }

    public static SMSParsedResult parse(Result result) {
        String str;
        String str2 = null;
        String text = result.getText();
        if (text == null) {
            return null;
        }
        if (!text.startsWith("sms:") && !text.startsWith("SMS:") && !text.startsWith("mms:") && !text.startsWith("MMS:")) {
            return null;
        }
        Hashtable parseNameValuePairs = parseNameValuePairs(text);
        boolean z = false;
        if (parseNameValuePairs == null || parseNameValuePairs.isEmpty()) {
            str = null;
        } else {
            str2 = (String) parseNameValuePairs.get("body");
            str = (String) parseNameValuePairs.get("subject");
            z = true;
        }
        int indexOf = text.indexOf(63, 4);
        String substring = (indexOf < 0 || !z) ? text.substring(4) : text.substring(4, indexOf);
        int i = -1;
        Vector vector = new Vector(1);
        Vector vector2 = new Vector(1);
        while (true) {
            int i2 = i;
            i = substring.indexOf(44, i2 + 1);
            if (i <= i2) {
                addNumberVia(vector, vector2, substring.substring(i2 + 1));
                return new SMSParsedResult(toStringArray(vector), toStringArray(vector2), str, str2);
            }
            addNumberVia(vector, vector2, substring.substring(i2 + 1, i));
        }
    }
}
