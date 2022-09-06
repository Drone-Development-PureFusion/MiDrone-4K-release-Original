package com.google.zxing.client.result;

import com.google.zxing.Result;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import p004b.p005a.p006a.p028b.C0359h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static final char[] ATEXT_SYMBOLS = {'@', C0359h.f677G, '!', '#', C0359h.f679I, C0359h.f721r, '&', C0359h.f729z, '*', SignatureVisitor.EXTENDS, '-', '/', SignatureVisitor.INSTANCEOF, '?', '^', '_', '`', C0359h.f725v, '|', C0359h.f726w, '~'};

    EmailDoCoMoResultParser() {
    }

    private static boolean isAtextSymbol(char c) {
        for (int i = 0; i < ATEXT_SYMBOLS.length; i++) {
            if (c == ATEXT_SYMBOLS[i]) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBasicallyValidEmailAddress(String str) {
        if (str == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt < '0' || charAt > '9') && !isAtextSymbol(charAt)))) {
                return false;
            }
            if (charAt == '@') {
                if (z) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }

    public static EmailAddressParsedResult parse(Result result) {
        String[] matchDoCoMoPrefixedField;
        String text = result.getText();
        if (text == null || !text.startsWith("MATMSG:") || (matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("TO:", text, true)) == null) {
            return null;
        }
        String str = matchDoCoMoPrefixedField[0];
        if (!isBasicallyValidEmailAddress(str)) {
            return null;
        }
        return new EmailAddressParsedResult(str, matchSingleDoCoMoPrefixedField("SUB:", text, false), matchSingleDoCoMoPrefixedField("BODY:", text, false), new StringBuffer().append("mailto:").append(str).toString());
    }
}
