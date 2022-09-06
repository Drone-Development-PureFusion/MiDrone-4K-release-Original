package p004b.p005a.p006a.p028b.p057r;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.b.r.m */
/* loaded from: classes.dex */
public class C0579m {
    /* renamed from: a */
    public static ExecutorService m20094a() {
        return new ThreadPoolExecutor(C0359h.f697a, 32, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    /* renamed from: a */
    public static void m20093a(ExecutorService executorService) {
        executorService.shutdownNow();
    }
}
