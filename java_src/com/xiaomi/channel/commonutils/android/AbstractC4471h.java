package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;
/* renamed from: com.xiaomi.channel.commonutils.android.h */
/* loaded from: classes2.dex */
public abstract class AbstractC4471h {
    /* renamed from: a */
    public static void m5072a(Context context) {
    }

    /* renamed from: a */
    public static void m5070a(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: a */
    public static boolean m5071a(Context context, String str, boolean z) {
        m5072a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    /* renamed from: b */
    public static void m5069b(Context context, String str, boolean z) {
        m5072a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }
}
