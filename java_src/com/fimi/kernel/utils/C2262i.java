package com.fimi.kernel.utils;
/* renamed from: com.fimi.kernel.utils.i */
/* loaded from: classes.dex */
public class C2262i {
    /* renamed from: a */
    public static String m12963a(String str) {
        if (!m12962b(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length());
        for (int i = 0; i <= str.length() - 1; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuffer.append("&quot;");
                    break;
                case '&':
                    stringBuffer.append("&amp;");
                    break;
                case '<':
                    stringBuffer.append("&lt;");
                    break;
                case '>':
                    stringBuffer.append("&gt;");
                    break;
                default:
                    stringBuffer.append(charAt);
                    break;
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static boolean m12962b(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i <= str.length() - 1; i++) {
            switch (str.charAt(i)) {
                case '\"':
                    z = true;
                    break;
                case '&':
                    z = true;
                    break;
                case '<':
                    z = true;
                    break;
                case '>':
                    z = true;
                    break;
            }
        }
        return z;
    }
}
