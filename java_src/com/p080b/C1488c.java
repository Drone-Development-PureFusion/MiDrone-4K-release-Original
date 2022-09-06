package com.p080b;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
/* renamed from: com.b.c */
/* loaded from: classes.dex */
public class C1488c extends C1450b implements Thread.UncaughtExceptionHandler {

    /* renamed from: e */
    private static ExecutorService f5289e;

    /* renamed from: d */
    private Context f5290d;

    /* renamed from: com.b.c$a */
    /* loaded from: classes.dex */
    private static class C1490a implements AbstractC1427ap {

        /* renamed from: a */
        private Context f5295a;

        C1490a(Context context) {
            this.f5295a = context;
        }

        @Override // com.p080b.AbstractC1427ap
        /* renamed from: a */
        public void mo15870a() {
            try {
                C1557g.m15540b(this.f5295a);
            } catch (Throwable th) {
                C1450b.m16187a(th, "LogNetListener", "onNetCompleted");
            }
        }
    }

    private C1488c(Context context, C1549dv c1549dv) {
        this.f5290d = context;
        C1425ao.m16337a(new C1490a(context));
        m15871c();
    }

    /* renamed from: a */
    public static synchronized C1488c m15879a(Context context, C1549dv c1549dv) {
        C1488c c1488c;
        synchronized (C1488c.class) {
            if (c1549dv == null) {
                throw new C1532dl("sdk info is null");
            }
            if (c1549dv.m15580a() == null || "".equals(c1549dv.m15580a())) {
                throw new C1532dl("sdk name is invalid");
            }
            if (C1450b.f5023a == null) {
                C1450b.f5023a = new C1488c(context, c1549dv);
            } else {
                C1450b.f5023a.f5025c = false;
            }
            C1450b.f5023a.mo15878a(context, c1549dv, C1450b.f5023a.f5025c);
            c1488c = (C1488c) C1450b.f5023a;
        }
        return c1488c;
    }

    /* renamed from: a */
    public static synchronized void m15880a() {
        synchronized (C1488c.class) {
            try {
                if (f5289e != null) {
                    f5289e.shutdown();
                }
                if (C1450b.f5023a != null && Thread.getDefaultUncaughtExceptionHandler() == C1450b.f5023a && C1450b.f5023a.f5024b != null) {
                    Thread.setDefaultUncaughtExceptionHandler(C1450b.f5023a.f5024b);
                }
                C1450b.f5023a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static synchronized ExecutorService m15874b() {
        ExecutorService executorService;
        synchronized (C1488c.class) {
            if (f5289e == null || f5289e.isShutdown()) {
                f5289e = Executors.newSingleThreadExecutor();
            }
            executorService = f5289e;
        }
        return executorService;
    }

    /* renamed from: b */
    public static void m15873b(C1549dv c1549dv, String str) {
        if (C1450b.f5023a != null) {
            C1450b.f5023a.mo15876a(c1549dv, str);
        }
    }

    /* renamed from: b */
    public static void m15872b(Throwable th, String str, String str2) {
        if (C1450b.f5023a != null) {
            C1450b.f5023a.mo15875a(th, 1, str, str2);
        }
    }

    /* renamed from: c */
    private void m15871c() {
        try {
            this.f5024b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f5024b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f5025c = true;
            } else if (this.f5024b.toString().indexOf("com.amap.api") != -1) {
                this.f5025c = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f5025c = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p080b.C1450b
    /* renamed from: a */
    public void mo15878a(final Context context, final C1549dv c1549dv, final boolean z) {
        try {
            ExecutorService m15874b = m15874b();
            if (m15874b == null || m15874b.isShutdown()) {
                return;
            }
            m15874b.submit(new Runnable() { // from class: com.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            new C1572r(context, true).m15461a(c1549dv);
                        }
                        if (!z) {
                            return;
                        }
                        synchronized (Looper.getMainLooper()) {
                            C1574t c1574t = new C1574t(context);
                            C1576v c1576v = new C1576v();
                            c1576v.m15440c(true);
                            c1576v.m15444a(true);
                            c1576v.m15442b(true);
                            c1574t.m15452a(c1576v);
                        }
                        C1557g.m15545a(C1488c.this.f5290d);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p080b.C1450b
    /* renamed from: a */
    public void mo15876a(C1549dv c1549dv, String str) {
        C1557g.m15543a(this.f5290d, c1549dv, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p080b.C1450b
    /* renamed from: a */
    public void mo15875a(Throwable th, int i, String str, String str2) {
        C1557g.m15542a(this.f5290d, th, i, str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        mo15875a(th, 0, null, null);
        if (this.f5024b == null) {
            return;
        }
        this.f5024b.uncaughtException(thread, th);
    }
}
