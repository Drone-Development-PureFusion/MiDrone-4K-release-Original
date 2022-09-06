package com.fimi.kernel.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.fimi.kernel.utils.x */
/* loaded from: classes.dex */
public class C2281x {

    /* renamed from: a */
    private static ExecutorService f7603a;

    /* renamed from: a */
    public static synchronized ExecutorService m12705a() {
        ExecutorService executorService;
        synchronized (C2281x.class) {
            if (f7603a == null) {
                f7603a = Executors.newCachedThreadPool();
            }
            executorService = f7603a;
        }
        return executorService;
    }

    /* renamed from: a */
    public static void m12704a(Runnable runnable) {
        m12705a().execute(runnable);
    }

    /* renamed from: b */
    public static void m12703b() {
        if (f7603a != null) {
            f7603a.shutdownNow();
            f7603a = null;
        }
    }

    /* renamed from: b */
    public static void m12702b(Runnable runnable) {
        m12705a().execute(runnable);
    }
}
