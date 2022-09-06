package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.AbstractRunnableC1086hm;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
/* renamed from: com.amap.api.mapcore.util.hl */
/* loaded from: classes.dex */
public final class C1084hl {

    /* renamed from: a */
    private static C1084hl f3383a = null;

    /* renamed from: b */
    private ExecutorService f3384b;

    /* renamed from: c */
    private ConcurrentHashMap<AbstractRunnableC1086hm, Future<?>> f3385c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private AbstractRunnableC1086hm.AbstractC1087a f3386d = new AbstractRunnableC1086hm.AbstractC1087a() { // from class: com.amap.api.mapcore.util.hl.1
        @Override // com.amap.api.mapcore.util.AbstractRunnableC1086hm.AbstractC1087a
        /* renamed from: a */
        public void mo17656a(AbstractRunnableC1086hm abstractRunnableC1086hm) {
        }

        @Override // com.amap.api.mapcore.util.AbstractRunnableC1086hm.AbstractC1087a
        /* renamed from: b */
        public void mo17655b(AbstractRunnableC1086hm abstractRunnableC1086hm) {
            C1084hl.this.m17661a(abstractRunnableC1086hm, false);
        }

        @Override // com.amap.api.mapcore.util.AbstractRunnableC1086hm.AbstractC1087a
        /* renamed from: c */
        public void mo17654c(AbstractRunnableC1086hm abstractRunnableC1086hm) {
            C1084hl.this.m17661a(abstractRunnableC1086hm, true);
        }
    };

    private C1084hl(int i) {
        try {
            this.f3384b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static synchronized C1084hl m17665a(int i) {
        C1084hl c1084hl;
        synchronized (C1084hl.class) {
            if (f3383a == null) {
                f3383a = new C1084hl(i);
            }
            c1084hl = f3383a;
        }
        return c1084hl;
    }

    /* renamed from: a */
    public static synchronized void m17666a() {
        synchronized (C1084hl.class) {
            try {
                if (f3383a != null) {
                    f3383a.m17660b();
                    f3383a = null;
                }
            } finally {
            }
        }
    }

    /* renamed from: a */
    private synchronized void m17662a(AbstractRunnableC1086hm abstractRunnableC1086hm, Future<?> future) {
        try {
            this.f3385c.put(abstractRunnableC1086hm, future);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m17661a(AbstractRunnableC1086hm abstractRunnableC1086hm, boolean z) {
        try {
            Future<?> remove = this.f3385c.remove(abstractRunnableC1086hm);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } finally {
        }
    }

    /* renamed from: b */
    private void m17660b() {
        try {
            for (Map.Entry<AbstractRunnableC1086hm, Future<?>> entry : this.f3385c.entrySet()) {
                Future<?> future = this.f3385c.get(entry.getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.f3385c.clear();
            this.f3384b.shutdown();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "TPool", "destroy");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private synchronized boolean m17659b(AbstractRunnableC1086hm abstractRunnableC1086hm) {
        boolean z;
        z = false;
        try {
            z = this.f3385c.containsKey(abstractRunnableC1086hm);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "TPool", "contain");
            th.printStackTrace();
        }
        return z;
    }

    /* renamed from: a */
    public void m17663a(AbstractRunnableC1086hm abstractRunnableC1086hm) {
        try {
            if (m17659b(abstractRunnableC1086hm) || this.f3384b == null || this.f3384b.isShutdown()) {
                return;
            }
            abstractRunnableC1086hm.f3388d = this.f3386d;
            try {
                Future<?> submit = this.f3384b.submit(abstractRunnableC1086hm);
                if (submit == null) {
                    return;
                }
                m17662a(abstractRunnableC1086hm, submit);
            } catch (RejectedExecutionException e) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C1007fo.m18012b(th, "TPool", "addTask");
            throw new C0975ex("thread pool has exception");
        }
    }
}
