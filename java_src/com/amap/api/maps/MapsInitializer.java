package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.C0985fa;
import com.amap.api.mapcore.util.C1022g;
import com.amap.api.mapcore.util.C1119p;
/* loaded from: classes.dex */
public final class MapsInitializer {
    public static String sdcardDir = "";

    /* renamed from: a */
    private static boolean f3599a = true;

    public static boolean getNetWorkEnable() {
        return f3599a;
    }

    public static String getVersion() {
        return "4.1.2";
    }

    public static void initialize(Context context) {
        C1119p.f3495a = context.getApplicationContext();
    }

    public static void loadWorldGridMap(boolean z) {
        C1022g.f3201c = z ? 0 : 1;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        C0985fa.m18153a(str);
    }

    public static void setNetWorkEnable(boolean z) {
        f3599a = z;
    }
}
