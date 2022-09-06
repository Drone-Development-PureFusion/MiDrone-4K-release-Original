package com.amap.api.services.core;

import com.amap.api.services.core.C1166ad;
/* renamed from: com.amap.api.services.core.c */
/* loaded from: classes.dex */
public class C1232c {

    /* renamed from: a */
    public static final String[] f4155a = {"com.amap.api.services"};

    /* renamed from: a */
    public static C1166ad m17037a(boolean z) {
        try {
            return new C1166ad.C1168a("sea", "2.5.0", "AMAP SDK Android Search 2.5.0").m17254a(f4155a).m17255a(z).m17258a();
        } catch (C1258v e) {
            C1233d.m17031a(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    /* renamed from: a */
    public static String m17038a() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restapi.amap.com/v3" : "https://restapi.amap.com/v3";
    }

    /* renamed from: b */
    public static String m17036b() {
        return ServiceSettings.getInstance().getLanguage();
    }
}
