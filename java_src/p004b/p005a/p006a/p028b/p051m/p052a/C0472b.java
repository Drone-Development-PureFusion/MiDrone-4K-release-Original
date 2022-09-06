package p004b.p005a.p006a.p028b.p051m.p052a;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
/* renamed from: b.a.a.b.m.a.b */
/* loaded from: classes.dex */
public class C0472b {

    /* renamed from: a */
    C0475e f1042a;

    public C0472b(C0475e c0475e) {
        this.f1042a = c0475e;
    }

    /* renamed from: a */
    public Future<?> m20418a(String str, String str2, String str3) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        Future<?> submit = newScheduledThreadPool.submit(new RunnableC0474d(this.f1042a, str, str2, str3));
        newScheduledThreadPool.shutdown();
        return submit;
    }
}
