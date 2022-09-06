package com.tencent.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* renamed from: com.tencent.stat.common.p */
/* loaded from: classes2.dex */
public class C4425p {

    /* renamed from: a */
    private static SharedPreferences f18468a = null;

    /* renamed from: a */
    public static int m5154a(Context context, String str, int i) {
        return m5155a(context).getInt(C4420k.m5195b(context, "" + str), i);
    }

    /* renamed from: a */
    public static long m5153a(Context context, String str, long j) {
        return m5155a(context).getLong(C4420k.m5195b(context, "" + str), j);
    }

    /* renamed from: a */
    static synchronized SharedPreferences m5155a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C4425p.class) {
            if (f18468a == null) {
                f18468a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f18468a;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static String m5152a(Context context, String str, String str2) {
        return m5155a(context).getString(C4420k.m5195b(context, "" + str), str2);
    }

    /* renamed from: b */
    public static void m5151b(Context context, String str, int i) {
        String m5195b = C4420k.m5195b(context, "" + str);
        SharedPreferences.Editor edit = m5155a(context).edit();
        edit.putInt(m5195b, i);
        edit.commit();
    }

    /* renamed from: b */
    public static void m5150b(Context context, String str, long j) {
        String m5195b = C4420k.m5195b(context, "" + str);
        SharedPreferences.Editor edit = m5155a(context).edit();
        edit.putLong(m5195b, j);
        edit.commit();
    }

    /* renamed from: b */
    public static void m5149b(Context context, String str, String str2) {
        String m5195b = C4420k.m5195b(context, "" + str);
        SharedPreferences.Editor edit = m5155a(context).edit();
        edit.putString(m5195b, str2);
        edit.commit();
    }
}
