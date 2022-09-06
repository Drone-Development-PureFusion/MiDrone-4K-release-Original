package com.p080b;

import java.io.UnsupportedEncodingException;
/* renamed from: com.b.w */
/* loaded from: classes.dex */
class C1577w {
    C1577w() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m15439a(String str) {
        byte[] bytes;
        if (str == null) {
            return null;
        }
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        String m15606a = C1544dr.m15606a(bytes);
        return ((char) ((m15606a.length() % 26) + 65)) + m15606a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m15438b(String str) {
        return str.length() < 2 ? "" : C1544dr.m15607a(str.substring(1));
    }
}
