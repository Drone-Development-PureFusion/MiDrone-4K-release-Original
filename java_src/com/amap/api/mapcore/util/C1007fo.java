package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
/* renamed from: com.amap.api.mapcore.util.fo */
/* loaded from: classes.dex */
public class C1007fo extends C1002fl implements Thread.UncaughtExceptionHandler {

    /* renamed from: e */
    private static ExecutorService f3174e;

    /* renamed from: d */
    private Context f3175d;

    /* renamed from: com.amap.api.mapcore.util.fo$a */
    /* loaded from: classes.dex */
    private static class C1009a implements AbstractC1071hb {

        /* renamed from: a */
        private Context f3180a;

        C1009a(Context context) {
            this.f3180a = context;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1071hb
        /* renamed from: a */
        public void mo17712a() {
            try {
                C1003fm.m18021b(this.f3180a);
            } catch (Throwable th) {
                C1002fl.m18028a(th, "LogNetListener", "onNetCompleted");
            }
        }
    }

    private C1007fo(Context context, C0996fh c0996fh) {
        this.f3175d = context;
        C1069ha.m17722a(new C1009a(context));
        m18009d();
    }

    /* renamed from: a */
    public static synchronized C1007fo m18018a() {
        C1007fo c1007fo;
        synchronized (C1007fo.class) {
            c1007fo = (C1007fo) C1002fl.f3157a;
        }
        return c1007fo;
    }

    /* renamed from: a */
    public static synchronized C1007fo m18017a(Context context, C0996fh c0996fh) {
        C1007fo c1007fo;
        synchronized (C1007fo.class) {
            if (c0996fh == null) {
                throw new C0975ex("sdk info is null");
            }
            if (c0996fh.m18074a() == null || "".equals(c0996fh.m18074a())) {
                throw new C0975ex("sdk name is invalid");
            }
            if (C1002fl.f3157a == null) {
                C1002fl.f3157a = new C1007fo(context, c0996fh);
            } else {
                C1002fl.f3157a.f3159c = false;
            }
            C1002fl.f3157a.mo18016a(context, c0996fh, C1002fl.f3157a.f3159c);
            c1007fo = (C1007fo) C1002fl.f3157a;
        }
        return c1007fo;
    }

    /* renamed from: b */
    public static synchronized void m18013b() {
        synchronized (C1007fo.class) {
            try {
                if (f3174e != null) {
                    f3174e.shutdown();
                }
                if (C1002fl.f3157a != null && Thread.getDefaultUncaughtExceptionHandler() == C1002fl.f3157a && C1002fl.f3157a.f3158b != null) {
                    Thread.setDefaultUncaughtExceptionHandler(C1002fl.f3157a.f3158b);
                }
                C1002fl.f3157a = null;
            }
        }
    }

    /* renamed from: b */
    public static void m18012b(Throwable th, String str, String str2) {
        if (C1002fl.f3157a != null) {
            C1002fl.f3157a.mo18014a(th, 1, str, str2);
        }
    }

    /* renamed from: c */
    public static synchronized ExecutorService m18011c() {
        ExecutorService executorService;
        synchronized (C1007fo.class) {
            if (f3174e == null || f3174e.isShutdown()) {
                f3174e = Executors.newSingleThreadExecutor();
            }
            executorService = f3174e;
        }
        return executorService;
    }

    /* renamed from: d */
    private void m18009d() {
        try {
            this.f3158b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f3158b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f3159c = true;
            } else {
                String obj = this.f3158b.toString();
                if (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.amap.loc") == -1) {
                    Thread.setDefaultUncaughtExceptionHandler(this);
                    this.f3159c = true;
                } else {
                    this.f3159c = false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.C1002fl
    /* renamed from: a */
    protected void mo18016a(final Context context, final C0996fh c0996fh, final boolean z) {
        try {
            ExecutorService m18011c = m18011c();
            if (m18011c == null || m18011c.isShutdown()) {
                return;
            }
            m18011c.submit(new Runnable() { // from class: com.amap.api.mapcore.util.fo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            new C1027ge(context, true).m17929a(c0996fh);
                        }
                        if (!z) {
                            return;
                        }
                        synchronized (Looper.getMainLooper()) {
                            C1028gf c1028gf = new C1028gf(context);
                            C1029gg c1029gg = new C1029gg();
                            c1029gg.m17920c(true);
                            c1029gg.m17924a(true);
                            c1029gg.m17922b(true);
                            c1028gf.m17926a(c1029gg);
                        }
                        C1003fm.m18026a(C1007fo.this.f3175d);
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

    @Override // com.amap.api.mapcore.util.C1002fl
    /* renamed from: a */
    protected void mo18014a(Throwable th, int i, String str, String str2) {
        C1003fm.m18023a(this.f3175d, th, i, str, str2);
    }

    /* renamed from: c */
    public void m18010c(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            mo18014a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        mo18014a(th, 0, null, null);
        if (this.f3158b == null) {
            return;
        }
        try {
            Thread.setDefaultUncaughtExceptionHandler(this.f3158b);
        } catch (Throwable th2) {
        }
        this.f3158b.uncaughtException(thread, th);
    }
}
