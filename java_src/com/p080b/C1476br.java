package com.p080b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.lang.reflect.Method;
/* renamed from: com.b.br */
/* loaded from: classes.dex */
public class C1476br {

    /* renamed from: a */
    private static Method f5167a;

    /* renamed from: a */
    public static void m16025a(Context context, String str, String str2, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            m16023a(edit);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "SPUtil", "setPrefsInt");
        }
    }

    /* renamed from: a */
    public static void m16024a(Context context, String str, String str2, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            m16023a(edit);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "SPUtil", "setPrefsLong");
        }
    }

    /* renamed from: a */
    public static void m16023a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
            return;
        }
        try {
            if (f5167a == null) {
                f5167a = SharedPreferences.Editor.class.getDeclaredMethod("apply", new Class[0]);
            }
            f5167a.invoke(editor, new Object[0]);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "SPUtil", "applySharedPreference");
            editor.commit();
        }
    }

    /* renamed from: b */
    public static int m16022b(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "SPUtil", "getPrefsInt");
            return i;
        }
    }

    /* renamed from: b */
    public static long m16021b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "SPUtil", "getPrefsLong");
            return j;
        }
    }
}
