package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* renamed from: com.android.volley.v */
/* loaded from: classes.dex */
public class C1385v {

    /* renamed from: a */
    public static String f4717a = "Volley";

    /* renamed from: b */
    public static boolean f4718b = Log.isLoggable(f4717a, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.volley.v$a */
    /* loaded from: classes.dex */
    public static class C1386a {

        /* renamed from: a */
        public static final boolean f4719a = C1385v.f4718b;

        /* renamed from: b */
        private static final long f4720b = 0;

        /* renamed from: c */
        private final List<C1387a> f4721c = new ArrayList();

        /* renamed from: d */
        private boolean f4722d = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.android.volley.v$a$a */
        /* loaded from: classes.dex */
        public static class C1387a {

            /* renamed from: a */
            public final String f4723a;

            /* renamed from: b */
            public final long f4724b;

            /* renamed from: c */
            public final long f4725c;

            public C1387a(String str, long j, long j2) {
                this.f4723a = str;
                this.f4724b = j;
                this.f4725c = j2;
            }
        }

        /* renamed from: a */
        private long m16560a() {
            if (this.f4721c.size() == 0) {
                return 0L;
            }
            return this.f4721c.get(this.f4721c.size() - 1).f4725c - this.f4721c.get(0).f4725c;
        }

        /* renamed from: a */
        public synchronized void m16559a(String str) {
            this.f4722d = true;
            long m16560a = m16560a();
            if (m16560a > 0) {
                long j = this.f4721c.get(0).f4725c;
                C1385v.m16565b("(%-4d ms) %s", Long.valueOf(m16560a), str);
                long j2 = j;
                for (C1387a c1387a : this.f4721c) {
                    long j3 = c1387a.f4725c;
                    C1385v.m16565b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c1387a.f4724b), c1387a.f4723a);
                    j2 = j3;
                }
            }
        }

        /* renamed from: a */
        public synchronized void m16558a(String str, long j) {
            if (this.f4722d) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f4721c.add(new C1387a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (!this.f4722d) {
                m16559a("Request on the loose");
                C1385v.m16563c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m16568a(String str) {
        m16565b("Changing log tag to %s", str);
        f4717a = str;
        f4718b = Log.isLoggable(f4717a, 2);
    }

    /* renamed from: a */
    public static void m16567a(String str, Object... objArr) {
        if (f4718b) {
            Log.v(f4717a, m16561e(str, objArr));
        }
    }

    /* renamed from: a */
    public static void m16566a(Throwable th, String str, Object... objArr) {
        Log.e(f4717a, m16561e(str, objArr), th);
    }

    /* renamed from: b */
    public static void m16565b(String str, Object... objArr) {
        Log.d(f4717a, m16561e(str, objArr));
    }

    /* renamed from: b */
    public static void m16564b(Throwable th, String str, Object... objArr) {
        Log.wtf(f4717a, m16561e(str, objArr), th);
    }

    /* renamed from: c */
    public static void m16563c(String str, Object... objArr) {
        Log.e(f4717a, m16561e(str, objArr));
    }

    /* renamed from: d */
    public static void m16562d(String str, Object... objArr) {
        Log.wtf(f4717a, m16561e(str, objArr));
    }

    /* renamed from: e */
    private static String m16561e(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(C1385v.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
