package com.facebook.common.logging;
/* loaded from: classes.dex */
public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    /* renamed from: d */
    public static void m13823d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(getTag(cls), str);
        }
    }

    /* renamed from: d */
    public static void m13822d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: d */
    public static void m13821d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m13820d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m13819d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m13818d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13758d(getTag(cls), str, th);
        }
    }

    /* renamed from: d */
    public static void m13817d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m13816d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13758d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m13815d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m13814d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(str, formatString(str2, obj));
        }
    }

    /* renamed from: d */
    public static void m13813d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m13812d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m13811d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13759d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m13810d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo13758d(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m13809d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m13815d(str, formatString(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m13808d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m13810d(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m13807e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13757e(getTag(cls), str);
        }
    }

    /* renamed from: e */
    public static void m13806e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13756e(getTag(cls), str, th);
        }
    }

    /* renamed from: e */
    public static void m13805e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13757e(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m13804e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13756e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m13803e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13757e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m13802e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13756e(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m13801e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13757e(str, formatString(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m13800e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13756e(str, formatString(str2, objArr), th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }

    /* renamed from: i */
    public static void m13799i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(getTag(cls), str);
        }
    }

    /* renamed from: i */
    public static void m13798i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: i */
    public static void m13797i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m13796i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m13795i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m13794i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13754i(getTag(cls), str, th);
        }
    }

    /* renamed from: i */
    public static void m13793i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: i */
    public static void m13792i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo13754i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m13791i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m13790i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(str, formatString(str2, obj));
        }
    }

    /* renamed from: i */
    public static void m13789i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m13788i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m13787i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m13786i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13754i(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m13785i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13755i(str, formatString(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m13784i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo13754i(str, formatString(str2, objArr), th);
        }
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate == null) {
            throw new IllegalArgumentException();
        }
        sHandler = loggingDelegate;
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    /* renamed from: v */
    public static void m13783v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(getTag(cls), str);
        }
    }

    /* renamed from: v */
    public static void m13782v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: v */
    public static void m13781v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m13780v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m13783v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m13779v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m13778v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13752v(getTag(cls), str, th);
        }
    }

    /* renamed from: v */
    public static void m13777v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: v */
    public static void m13776v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13752v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m13775v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m13774v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(str, formatString(str2, obj));
        }
    }

    /* renamed from: v */
    public static void m13773v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m13772v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m13771v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m13770v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13752v(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m13769v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13753v(str, formatString(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m13768v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo13752v(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m13767w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo13751w(getTag(cls), str);
        }
    }

    /* renamed from: w */
    public static void m13766w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo13750w(getTag(cls), str, th);
        }
    }

    /* renamed from: w */
    public static void m13765w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo13751w(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: w */
    public static void m13764w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m13766w(cls, formatString(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m13763w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo13751w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m13762w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo13750w(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m13761w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo13751w(str, formatString(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m13760w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo13750w(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13757e(getTag(cls), str);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo13757e(str, str2);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }
}
