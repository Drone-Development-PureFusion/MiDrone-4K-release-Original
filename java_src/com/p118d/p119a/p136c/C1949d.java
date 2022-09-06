package com.p118d.p119a.p136c;

import android.util.Log;
import com.p118d.p119a.p127b.C1914d;
/* renamed from: com.d.a.c.d */
/* loaded from: classes.dex */
public final class C1949d {

    /* renamed from: a */
    private static final String f6942a = "%1$s\n%2$s";

    /* renamed from: b */
    private static volatile boolean f6943b = false;

    /* renamed from: c */
    private static volatile boolean f6944c = true;

    private C1949d() {
    }

    @Deprecated
    /* renamed from: a */
    public static void m13856a() {
        m13848b(true);
    }

    /* renamed from: a */
    private static void m13855a(int i, Throwable th, String str, Object... objArr) {
        if (!f6944c) {
            return;
        }
        String format = objArr.length > 0 ? String.format(str, objArr) : str;
        if (th != null) {
            if (format == null) {
                format = th.getMessage();
            }
            format = String.format(f6942a, format, Log.getStackTraceString(th));
        }
        Log.println(i, C1914d.f6766a, format);
    }

    /* renamed from: a */
    public static void m13854a(String str, Object... objArr) {
        if (f6943b) {
            m13855a(3, null, str, objArr);
        }
    }

    /* renamed from: a */
    public static void m13853a(Throwable th) {
        m13855a(6, th, null, new Object[0]);
    }

    /* renamed from: a */
    public static void m13852a(Throwable th, String str, Object... objArr) {
        m13855a(6, th, str, objArr);
    }

    /* renamed from: a */
    public static void m13851a(boolean z) {
        f6943b = z;
    }

    @Deprecated
    /* renamed from: b */
    public static void m13850b() {
        m13848b(false);
    }

    /* renamed from: b */
    public static void m13849b(String str, Object... objArr) {
        m13855a(4, null, str, objArr);
    }

    /* renamed from: b */
    public static void m13848b(boolean z) {
        f6944c = z;
    }

    /* renamed from: c */
    public static void m13847c(String str, Object... objArr) {
        m13855a(5, null, str, objArr);
    }

    /* renamed from: d */
    public static void m13846d(String str, Object... objArr) {
        m13855a(6, null, str, objArr);
    }
}
