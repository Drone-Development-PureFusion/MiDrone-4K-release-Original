package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
/* renamed from: com.amap.api.services.core.ay */
/* loaded from: classes.dex */
public class C1190ay implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C1190ay f4050a;

    /* renamed from: e */
    private static ExecutorService f4051e;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f4052b;

    /* renamed from: c */
    private Context f4053c;

    /* renamed from: d */
    private boolean f4054d = true;

    /* renamed from: com.amap.api.services.core.ay$a */
    /* loaded from: classes.dex */
    private static class C1192a implements AbstractC1223br {

        /* renamed from: a */
        private Context f4059a;

        C1192a(Context context) {
            this.f4059a = context;
        }

        @Override // com.amap.api.services.core.AbstractC1223br
        /* renamed from: a */
        public void mo17059a() {
            try {
                C1204bf.m17164b(this.f4059a);
            } catch (Throwable th) {
                C1190ay.m17177a(th, "LogNetListener", "onNetCompleted");
                th.printStackTrace();
            }
        }
    }

    private C1190ay(Context context, C1166ad c1166ad) {
        this.f4053c = context;
        C1222bq.m17069a(new C1192a(context));
        m17174c();
    }

    /* renamed from: a */
    public static synchronized C1190ay m17181a(Context context, C1166ad c1166ad) {
        C1190ay c1190ay;
        synchronized (C1190ay.class) {
            if (c1166ad == null) {
                throw new C1258v("sdk info is null");
            }
            if (c1166ad.m17264a() == null || "".equals(c1166ad.m17264a())) {
                throw new C1258v("sdk name is invalid");
            }
            if (f4050a == null) {
                f4050a = new C1190ay(context, c1166ad);
            } else {
                f4050a.f4054d = false;
            }
            f4050a.m17180a(context, c1166ad, f4050a.f4054d);
            c1190ay = f4050a;
        }
        return c1190ay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized ExecutorService m17182a() {
        ExecutorService executorService;
        synchronized (C1190ay.class) {
            if (f4051e == null || f4051e.isShutdown()) {
                f4051e = Executors.newSingleThreadExecutor();
            }
            executorService = f4051e;
        }
        return executorService;
    }

    /* renamed from: a */
    private void m17180a(final Context context, final C1166ad c1166ad, final boolean z) {
        try {
            ExecutorService m17182a = m17182a();
            if (m17182a == null || m17182a.isShutdown()) {
                return;
            }
            m17182a.submit(new Runnable() { // from class: com.amap.api.services.core.ay.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            new C1178an(context).m17211a(c1166ad);
                        }
                        if (!z) {
                            return;
                        }
                        synchronized (Looper.getMainLooper()) {
                            C1181aq c1181aq = new C1181aq(context);
                            C1183as c1183as = new C1183as();
                            c1183as.m17190c(true);
                            c1183as.m17194a(true);
                            c1183as.m17192b(true);
                            c1181aq.m17202a(c1183as);
                        }
                        C1204bf.m17166a(C1190ay.this.f4053c);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m17178a(Throwable th, int i, String str, String str2) {
        C1204bf.m17165a(this.f4053c, th, i, str, str2);
    }

    /* renamed from: a */
    public static void m17177a(Throwable th, String str, String str2) {
        if (f4050a != null) {
            f4050a.m17178a(th, 1, str, str2);
        }
    }

    /* renamed from: b */
    public static synchronized C1190ay m17176b() {
        C1190ay c1190ay;
        synchronized (C1190ay.class) {
            c1190ay = f4050a;
        }
        return c1190ay;
    }

    /* renamed from: c */
    private void m17174c() {
        try {
            this.f4052b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f4052b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f4054d = true;
            } else if (this.f4052b.toString().indexOf("com.amap.api") != -1) {
                this.f4054d = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f4054d = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m17175b(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            m17178a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        m17178a(th, 0, null, null);
        if (this.f4052b == null) {
            return;
        }
        this.f4052b.uncaughtException(thread, th);
    }
}
