package p000a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: a.b */
/* loaded from: classes.dex */
final class C0001b {

    /* renamed from: c */
    static final long f3c = 1;

    /* renamed from: e */
    private final Executor f6e = new ExecutorC0003a();

    /* renamed from: d */
    private static final C0001b f4d = new C0001b();

    /* renamed from: f */
    private static final int f5f = Runtime.getRuntime().availableProcessors();

    /* renamed from: a */
    static final int f1a = f5f + 1;

    /* renamed from: b */
    static final int f2b = (f5f * 2) + 1;

    /* renamed from: a.b$a */
    /* loaded from: classes.dex */
    private static class ExecutorC0003a implements Executor {
        private ExecutorC0003a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private C0001b() {
    }

    /* renamed from: a */
    public static ExecutorService m21668a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f1a, f2b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        m21666a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static ExecutorService m21667a(ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f1a, f2b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        m21666a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m21666a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    /* renamed from: b */
    public static Executor m21665b() {
        return f4d.f6e;
    }
}
