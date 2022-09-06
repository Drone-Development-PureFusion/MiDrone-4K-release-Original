package com.amap.api.services.core;

import com.amap.api.services.core.AbstractRunnableC1188ax;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* renamed from: com.amap.api.services.core.av */
/* loaded from: classes.dex */
public final class C1186av {

    /* renamed from: a */
    private static C1186av f4044a = null;

    /* renamed from: b */
    private ExecutorService f4045b;

    /* renamed from: c */
    private ConcurrentHashMap<AbstractRunnableC1188ax, Future<?>> f4046c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private AbstractRunnableC1188ax.AbstractC1189a f4047d = new C1187aw(this);

    private C1186av(int i) {
        try {
            this.f4045b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static synchronized C1186av m17187a(int i) {
        C1186av c1186av;
        synchronized (C1186av.class) {
            if (f4044a == null) {
                f4044a = new C1186av(i);
            }
            c1186av = f4044a;
        }
        return c1186av;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m17185a(AbstractRunnableC1188ax abstractRunnableC1188ax, boolean z) {
        try {
            Future<?> remove = this.f4046c.remove(abstractRunnableC1188ax);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } finally {
        }
    }
}
