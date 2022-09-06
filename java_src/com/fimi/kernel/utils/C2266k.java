package com.fimi.kernel.utils;

import android.content.Context;
import android.util.Log;
import com.tencent.p227mm.sdk.platformtools.LocaleUtil;
import java.util.Calendar;
/* renamed from: com.fimi.kernel.utils.k */
/* loaded from: classes.dex */
public class C2266k {

    /* renamed from: a */
    public static boolean f7544a = false;

    /* renamed from: b */
    public static boolean f7545b = false;

    /* renamed from: c */
    public static boolean f7546c = false;

    /* renamed from: d */
    public static long f7547d = 0;

    /* renamed from: a */
    public static void m12952a() {
        f7544a = true;
        f7545b = true;
        f7546c = true;
    }

    /* renamed from: a */
    public static void m12951a(Context context) {
        m12945a(context.getClass().getSimpleName());
    }

    /* renamed from: a */
    public static void m12950a(Context context, String str) {
        m12944a(context.getClass().getSimpleName(), str);
    }

    /* renamed from: a */
    public static void m12949a(Context context, String str, boolean z) {
        m12943a(context.getClass().getSimpleName(), str, z);
    }

    /* renamed from: a */
    public static void m12948a(Class<?> cls) {
        m12945a(cls.getSimpleName());
    }

    /* renamed from: a */
    public static void m12947a(Class<?> cls, String str) {
        m12944a(cls.getSimpleName(), str);
    }

    /* renamed from: a */
    public static void m12946a(Class<?> cls, String str, boolean z) {
        m12943a(cls.getSimpleName(), str, z);
    }

    /* renamed from: a */
    public static void m12945a(String str) {
        f7547d = Calendar.getInstance().getTimeInMillis();
        Log.d(str, "日志计时开始：" + f7547d);
    }

    /* renamed from: a */
    public static void m12944a(String str, String str2) {
        if (f7544a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: a */
    public static void m12943a(String str, String str2, boolean z) {
        Log.d(str, str2 + ":" + (Calendar.getInstance().getTimeInMillis() - f7547d) + LocaleUtil.MALAY);
    }

    /* renamed from: a */
    public static void m12942a(boolean z) {
        f7544a = z;
    }

    /* renamed from: a */
    public static void m12941a(boolean z, boolean z2, boolean z3) {
        f7544a = z;
        f7545b = z2;
        f7546c = z3;
    }

    /* renamed from: b */
    public static void m12940b() {
        f7544a = false;
        f7545b = false;
        f7546c = false;
    }

    /* renamed from: b */
    public static void m12939b(Context context, String str) {
        m12937b(context.getClass().getSimpleName(), str);
    }

    /* renamed from: b */
    public static void m12938b(Class<?> cls, String str) {
        m12937b(cls.getSimpleName(), str);
    }

    /* renamed from: b */
    public static void m12937b(String str, String str2) {
        Log.i(str, str2);
    }

    /* renamed from: b */
    public static void m12936b(boolean z) {
        f7545b = z;
    }

    /* renamed from: c */
    public static void m12935c(Context context, String str) {
        m12933c(context.getClass().getSimpleName(), str);
    }

    /* renamed from: c */
    public static void m12934c(Class<?> cls, String str) {
        m12933c(cls.getSimpleName(), str);
    }

    /* renamed from: c */
    public static void m12933c(String str, String str2) {
        Log.e(str, str2);
    }

    /* renamed from: c */
    public static void m12932c(boolean z) {
        f7546c = z;
    }
}
