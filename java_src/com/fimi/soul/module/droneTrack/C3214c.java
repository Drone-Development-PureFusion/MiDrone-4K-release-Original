package com.fimi.soul.module.droneTrack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.fimi.soul.module.droneTrack.c */
/* loaded from: classes.dex */
public class C3214c {

    /* renamed from: a */
    private static ExecutorService f12342a;

    /* renamed from: a */
    public static synchronized ExecutorService m9089a() {
        ExecutorService executorService;
        synchronized (C3214c.class) {
            if (f12342a == null) {
                synchronized (C3214c.class) {
                    if (f12342a == null) {
                        f12342a = Executors.newCachedThreadPool();
                    }
                }
            }
            executorService = f12342a;
        }
        return executorService;
    }

    /* renamed from: a */
    public static void m9088a(Runnable runnable) {
        m9089a().execute(runnable);
    }

    /* renamed from: b */
    public static void m9087b() {
        if (f12342a != null) {
            f12342a.shutdownNow();
            f12342a = null;
        }
    }

    /* renamed from: b */
    public static void m9086b(Runnable runnable) {
        m9089a().execute(runnable);
    }
}
