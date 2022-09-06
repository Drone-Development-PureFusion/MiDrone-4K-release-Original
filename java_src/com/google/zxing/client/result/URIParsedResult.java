package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class URIParsedResult extends ParsedResult {
    private final String title;
    private final String uri;

    public URIParsedResult(String str, String str2) {
        super(ParsedResultType.URI);
        this.uri = massageURI(str);
        this.title = str2;
    }

    private boolean containsUser() {
        int indexOf = this.uri.indexOf(58) + 1;
        int length = this.uri.length();
        int i = indexOf;
        while (i < length && this.uri.charAt(i) == '/') {
            i++;
        }
        int indexOf2 = this.uri.indexOf(47, i);
        if (indexOf2 >= 0) {
            length = indexOf2;
        }
        int indexOf3 = this.uri.indexOf(64, i);
        return indexOf3 >= i && indexOf3 < length;
    }

    private static boolean isColonFollowedByPortNumber(String str, int i) {
        int indexOf = str.indexOf(47, i + 1);
        int length = indexOf < 0 ? str.length() : indexOf;
        if (length <= i + 1) {
            return false;
        }
        for (int i2 = i + 1; i2 < length; i2++) {
            if (str.charAt(i2) < '0' || str.charAt(i2) > '9') {
                return false;
            }
        }
        return true;
    }

    private static String massageURI(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf >= 0 && !isColonFollowedByPortNumber(str, indexOf)) {
            return new StringBuffer().append(str.substring(0, indexOf).toLowerCase()).append(str.substring(indexOf)).toString();
        }
        return new StringBuffer().append("http://").append(str).toString();
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuffer stringBuffer = new StringBuffer(30);
        maybeAppend(this.title, stringBuffer);
        maybeAppend(this.uri, stringBuffer);
        return stringBuffer.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public String getURI() {
        return this.uri;
    }

    public boolean isPossiblyMaliciousURI() {
        return containsUser();
    }
}
