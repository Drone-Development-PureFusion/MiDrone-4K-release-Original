package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
/* renamed from: com.android.volley.h */
/* loaded from: classes.dex */
public class C1327h extends Thread {

    /* renamed from: a */
    private final BlockingQueue<AbstractC1333n<?>> f4560a;

    /* renamed from: b */
    private final AbstractC1326g f4561b;

    /* renamed from: c */
    private final AbstractC1317b f4562c;

    /* renamed from: d */
    private final AbstractC1344q f4563d;

    /* renamed from: e */
    private volatile boolean f4564e = false;

    public C1327h(BlockingQueue<AbstractC1333n<?>> blockingQueue, AbstractC1326g abstractC1326g, AbstractC1317b abstractC1317b, AbstractC1344q abstractC1344q) {
        this.f4560a = blockingQueue;
        this.f4561b = abstractC1326g;
        this.f4562c = abstractC1317b;
        this.f4563d = abstractC1344q;
    }

    @TargetApi(14)
    /* renamed from: a */
    private void m16739a(AbstractC1333n<?> abstractC1333n) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(abstractC1333n.m16717d());
        }
    }

    /* renamed from: a */
    private void m16738a(AbstractC1333n<?> abstractC1333n, C1384u c1384u) {
        this.f4563d.mo16684a(abstractC1333n, abstractC1333n.m16728a(c1384u));
    }

    /* renamed from: a */
    public void m16740a() {
        this.f4564e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                AbstractC1333n<?> take = this.f4560a.take();
                try {
                    take.m16726a("network-queue-take");
                    if (take.mo16661m()) {
                        take.m16720b("network-discard-cancelled");
                    } else {
                        m16739a(take);
                        C1329j mo16671a = this.f4561b.mo16671a(take);
                        take.m16726a("network-http-complete");
                        if (!mo16671a.f4568d || !take.m16736B()) {
                            C1341p<?> mo13155a = take.mo13155a(mo16671a);
                            take.m16726a("network-parse-complete");
                            if (take.m16704w() && mo13155a.f4619b != null) {
                                this.f4562c.mo16584a(take.m16711j(), mo13155a.f4619b);
                                take.m16726a("network-cache-written");
                            }
                            take.m16737A();
                            this.f4563d.mo16686a(take, mo13155a);
                        } else {
                            take.m16720b("not-modified");
                        }
                    }
                } catch (C1384u e) {
                    e.m16570a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m16738a(take, e);
                } catch (Exception e2) {
                    C1385v.m16566a(e2, "Unhandled exception %s", e2.toString());
                    C1384u c1384u = new C1384u(e2);
                    c1384u.m16570a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f4563d.mo16684a(take, c1384u);
                }
            } catch (InterruptedException e3) {
                if (this.f4564e) {
                    return;
                }
            }
        }
    }
}
