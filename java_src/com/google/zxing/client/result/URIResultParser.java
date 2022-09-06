package com.google.zxing.client.result;

import com.google.zxing.Result;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class URIResultParser extends ResultParser {
    private URIResultParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBasicallyValidURI(String str) {
        int indexOf;
        if (str == null || str.indexOf(32) >= 0 || str.indexOf(10) >= 0 || (indexOf = str.indexOf(46)) >= str.length() - 2) {
            return false;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf < 0 && indexOf2 < 0) {
            return false;
        }
        if (indexOf2 >= 0) {
            if (indexOf < 0 || indexOf > indexOf2) {
                for (int i = 0; i < indexOf2; i++) {
                    char charAt = str.charAt(i);
                    if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                        return false;
                    }
                }
            } else if (indexOf2 >= str.length() - 2) {
                return false;
            } else {
                for (int i2 = indexOf2 + 1; i2 < indexOf2 + 3; i2++) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < '0' || charAt2 > '9') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static URIParsedResult parse(Result result) {
        String text = result.getText();
        if (text != null && text.startsWith("URL:")) {
            text = text.substring(4);
        }
        if (!isBasicallyValidURI(text)) {
            return null;
        }
        return new URIParsedResult(text, null);
    }
}
