package com.amap.api.services.core;
/* renamed from: com.amap.api.services.core.at */
/* loaded from: classes.dex */
class C1184at {
    C1184at() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m17189a(String str) {
        if (str == null) {
            return null;
        }
        String m17280b = C1163aa.m17280b(str.getBytes());
        return ((char) ((m17280b.length() % 26) + 65)) + m17280b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m17188b(String str) {
        return str.length() < 2 ? "" : C1163aa.m17285a(str.substring(1));
    }
}
