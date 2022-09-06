package com.google.zxing.client.result;

import com.github.moduth.blockcanary.p215b.C3947a;
import com.google.zxing.Result;
import java.util.Vector;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
final class AddressBookAUResultParser extends ResultParser {
    AddressBookAUResultParser() {
    }

    private static String[] matchMultipleValuePrefix(String str, int i, String str2, boolean z) {
        Vector vector = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String matchSinglePrefixedField = matchSinglePrefixedField(new StringBuffer().append(str).append(i2).append(C0359h.f671A).toString(), str2, C5122l.f21761a, z);
            if (matchSinglePrefixedField == null) {
                break;
            }
            if (vector == null) {
                vector = new Vector(i);
            }
            vector.addElement(matchSinglePrefixedField);
        }
        if (vector == null) {
            return null;
        }
        return toStringArray(vector);
    }

    public static AddressBookParsedResult parse(Result result) {
        String text = result.getText();
        if (text == null || text.indexOf("MEMORY") < 0 || text.indexOf(C3947a.f16890a) < 0) {
            return null;
        }
        String matchSinglePrefixedField = matchSinglePrefixedField("NAME1:", text, C5122l.f21761a, true);
        String matchSinglePrefixedField2 = matchSinglePrefixedField("NAME2:", text, C5122l.f21761a, true);
        String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, text, true);
        String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, text, true);
        String matchSinglePrefixedField3 = matchSinglePrefixedField("MEMORY:", text, C5122l.f21761a, false);
        String matchSinglePrefixedField4 = matchSinglePrefixedField("ADD:", text, C5122l.f21761a, true);
        return new AddressBookParsedResult(maybeWrap(matchSinglePrefixedField), matchSinglePrefixedField2, matchMultipleValuePrefix, matchMultipleValuePrefix2, matchSinglePrefixedField3, matchSinglePrefixedField4 == null ? null : new String[]{matchSinglePrefixedField4}, null, null, null, null);
    }
}
