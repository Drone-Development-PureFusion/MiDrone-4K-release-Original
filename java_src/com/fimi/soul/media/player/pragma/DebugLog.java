package com.fimi.soul.media.player.pragma;

import android.util.Log;
import java.util.Locale;
/* loaded from: classes.dex */
public class DebugLog {
    public static final boolean ENABLE_DEBUG = true;
    public static final boolean ENABLE_ERROR = true;
    public static final boolean ENABLE_INFO = true;
    public static final boolean ENABLE_VERBOSE = true;
    public static final boolean ENABLE_WARN = true;

    /* renamed from: d */
    public static int m9918d(String str, String str2) {
        return Log.d(str, str2);
    }

    /* renamed from: d */
    public static int m9917d(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    public static int dfmt(String str, String str2, Object... objArr) {
        return Log.d(str, String.format(Locale.US, str2, objArr));
    }

    /* renamed from: e */
    public static int m9916e(String str, String str2) {
        return Log.e(str, str2);
    }

    /* renamed from: e */
    public static int m9915e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }

    public static int efmt(String str, String str2, Object... objArr) {
        return Log.e(str, String.format(Locale.US, str2, objArr));
    }

    /* renamed from: i */
    public static int m9914i(String str, String str2) {
        return Log.i(str, str2);
    }

    /* renamed from: i */
    public static int m9913i(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    public static int ifmt(String str, String str2, Object... objArr) {
        return Log.i(str, String.format(Locale.US, str2, objArr));
    }

    public static void printCause(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        printStackTrace(th);
    }

    public static void printStackTrace(Throwable th) {
        th.printStackTrace();
    }

    /* renamed from: v */
    public static int m9912v(String str, String str2) {
        return Log.v(str, str2);
    }

    /* renamed from: v */
    public static int m9911v(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    public static int vfmt(String str, String str2, Object... objArr) {
        return Log.v(str, String.format(Locale.US, str2, objArr));
    }

    /* renamed from: w */
    public static int m9910w(String str, String str2) {
        return Log.w(str, str2);
    }

    /* renamed from: w */
    public static int m9909w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }

    public static int wfmt(String str, String str2, Object... objArr) {
        return Log.w(str, String.format(Locale.US, str2, objArr));
    }
}
