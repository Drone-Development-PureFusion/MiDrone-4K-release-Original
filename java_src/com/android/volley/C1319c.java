package com.android.volley;

import android.os.Process;
import com.android.volley.AbstractC1317b;
import java.util.concurrent.BlockingQueue;
/* renamed from: com.android.volley.c */
/* loaded from: classes.dex */
public class C1319c extends Thread {

    /* renamed from: a */
    private static final boolean f4537a = C1385v.f4718b;

    /* renamed from: b */
    private final BlockingQueue<AbstractC1333n<?>> f4538b;

    /* renamed from: c */
    private final BlockingQueue<AbstractC1333n<?>> f4539c;

    /* renamed from: d */
    private final AbstractC1317b f4540d;

    /* renamed from: e */
    private final AbstractC1344q f4541e;

    /* renamed from: f */
    private volatile boolean f4542f = false;

    public C1319c(BlockingQueue<AbstractC1333n<?>> blockingQueue, BlockingQueue<AbstractC1333n<?>> blockingQueue2, AbstractC1317b abstractC1317b, AbstractC1344q abstractC1344q) {
        this.f4538b = blockingQueue;
        this.f4539c = blockingQueue2;
        this.f4540d = abstractC1317b;
        this.f4541e = abstractC1344q;
    }

    /* renamed from: a */
    public void m16746a() {
        this.f4542f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f4537a) {
            C1385v.m16567a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f4540d.mo16586a();
        while (true) {
            try {
                final AbstractC1333n<?> take = this.f4538b.take();
                try {
                    take.m16726a("cache-queue-take");
                    if (take.mo16661m()) {
                        take.m16720b("cache-discard-canceled");
                    } else {
                        AbstractC1317b.C1318a mo16585a = this.f4540d.mo16585a(take.m16711j());
                        if (mo16585a == null) {
                            take.m16726a("cache-miss");
                            this.f4539c.put(take);
                        } else if (mo16585a.m16748a()) {
                            take.m16726a("cache-hit-expired");
                            take.m16732a(mo16585a);
                            this.f4539c.put(take);
                        } else {
                            take.m16726a("cache-hit");
                            C1341p<?> mo13155a = take.mo13155a(new C1329j(mo16585a.f4530a, mo16585a.f4536g));
                            take.m16726a("cache-hit-parsed");
                            if (!mo16585a.m16747b()) {
                                this.f4541e.mo16686a(take, mo13155a);
                            } else {
                                take.m16726a("cache-hit-refresh-needed");
                                take.m16732a(mo16585a);
                                mo13155a.f4621d = true;
                                this.f4541e.mo16685a(take, mo13155a, new Runnable() { // from class: com.android.volley.c.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            C1319c.this.f4539c.put(take);
                                        } catch (InterruptedException e) {
                                        }
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e) {
                    C1385v.m16566a(e, "Unhandled exception %s", e.toString());
                }
            } catch (InterruptedException e2) {
                if (this.f4542f) {
                    return;
                }
            }
        }
    }
}
