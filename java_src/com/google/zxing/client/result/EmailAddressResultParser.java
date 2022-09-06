package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Hashtable;
/* loaded from: classes.dex */
final class EmailAddressResultParser extends ResultParser {
    EmailAddressResultParser() {
    }

    public static EmailAddressParsedResult parse(Result result) {
        String str;
        String str2;
        String str3 = null;
        String text = result.getText();
        if (text == null) {
            return null;
        }
        if (!text.startsWith("mailto:") && !text.startsWith("MAILTO:")) {
            if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress(text)) {
                return null;
            }
            return new EmailAddressParsedResult(text, null, null, new StringBuffer().append("mailto:").append(text).toString());
        }
        String substring = text.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        Hashtable parseNameValuePairs = parseNameValuePairs(text);
        if (parseNameValuePairs != null) {
            str = substring.length() == 0 ? (String) parseNameValuePairs.get("to") : substring;
            str2 = (String) parseNameValuePairs.get("subject");
            str3 = (String) parseNameValuePairs.get("body");
        } else {
            str = substring;
            str2 = null;
        }
        return new EmailAddressParsedResult(str, str2, str3, text);
    }
}
