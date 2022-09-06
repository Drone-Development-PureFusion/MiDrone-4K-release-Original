package com.google.zxing.client.result;

import com.google.zxing.Result;
/* loaded from: classes.dex */
final class URLTOResultParser {
    private URLTOResultParser() {
    }

    public static URIParsedResult parse(Result result) {
        int indexOf;
        String str = null;
        String text = result.getText();
        if (text != null) {
            if ((!text.startsWith("urlto:") && !text.startsWith("URLTO:")) || (indexOf = text.indexOf(58, 6)) < 0) {
                return null;
            }
            if (indexOf > 6) {
                str = text.substring(6, indexOf);
            }
            return new URIParsedResult(text.substring(indexOf + 1), str);
        }
        return null;
    }
}
