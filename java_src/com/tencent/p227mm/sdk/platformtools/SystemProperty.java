package com.tencent.p227mm.sdk.platformtools;

import java.util.HashMap;
/* renamed from: com.tencent.mm.sdk.platformtools.SystemProperty */
/* loaded from: classes.dex */
public final class SystemProperty {

    /* renamed from: bf */
    private static final HashMap<String, String> f17866bf = new HashMap<>();

    private SystemProperty() {
    }

    public static String getProperty(String str) {
        return f17866bf.get(str);
    }

    public static void setProperty(String str, String str2) {
        f17866bf.put(str, str2);
    }
}
