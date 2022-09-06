package com.mining.app.zxing.p222b;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* renamed from: com.mining.app.zxing.b.f */
/* loaded from: classes.dex */
public final class C4115f {

    /* renamed from: a */
    private static final int f17206a = 300;

    /* renamed from: c */
    private final Activity f17208c;

    /* renamed from: b */
    private final ScheduledExecutorService f17207b = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC4117a());

    /* renamed from: d */
    private ScheduledFuture<?> f17209d = null;

    /* renamed from: com.mining.app.zxing.b.f$a */
    /* loaded from: classes.dex */
    private static final class ThreadFactoryC4117a implements ThreadFactory {
        private ThreadFactoryC4117a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public C4115f(Activity activity) {
        this.f17208c = activity;
        m6150a();
    }

    /* renamed from: c */
    private void m6148c() {
        if (this.f17209d != null) {
            this.f17209d.cancel(true);
            this.f17209d = null;
        }
    }

    /* renamed from: a */
    public void m6150a() {
        m6148c();
        this.f17209d = this.f17207b.schedule(new DialogInterface$OnCancelListenerC4114e(this.f17208c), 300L, TimeUnit.SECONDS);
    }

    /* renamed from: b */
    public void m6149b() {
        m6148c();
        this.f17207b.shutdown();
    }
}
