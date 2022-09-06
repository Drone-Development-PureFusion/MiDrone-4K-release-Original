package com.p118d.p119a.p127b;

import com.p118d.p119a.p127b.p133e.AbstractC1926a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.d.a.b.f */
/* loaded from: classes.dex */
public class C1930f {

    /* renamed from: a */
    final C1921e f6861a;

    /* renamed from: b */
    private Executor f6862b;

    /* renamed from: c */
    private Executor f6863c;

    /* renamed from: e */
    private final Map<Integer, String> f6865e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f */
    private final Map<String, ReentrantLock> f6866f = new WeakHashMap();

    /* renamed from: g */
    private final AtomicBoolean f6867g = new AtomicBoolean(false);

    /* renamed from: h */
    private final AtomicBoolean f6868h = new AtomicBoolean(false);

    /* renamed from: i */
    private final AtomicBoolean f6869i = new AtomicBoolean(false);

    /* renamed from: j */
    private final Object f6870j = new Object();

    /* renamed from: d */
    private Executor f6864d = C1877a.m14202a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1930f(C1921e c1921e) {
        this.f6861a = c1921e;
        this.f6862b = c1921e.f6806g;
        this.f6863c = c1921e.f6807h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m13899h() {
        if (!this.f6861a.f6808i && ((ExecutorService) this.f6862b).isShutdown()) {
            this.f6862b = m13898i();
        }
        if (this.f6861a.f6809j || !((ExecutorService) this.f6863c).isShutdown()) {
            return;
        }
        this.f6863c = m13898i();
    }

    /* renamed from: i */
    private Executor m13898i() {
        return C1877a.m14201a(this.f6861a.f6810k, this.f6861a.f6811l, this.f6861a.f6812m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m13917a(AbstractC1926a abstractC1926a) {
        return this.f6865e.get(Integer.valueOf(abstractC1926a.mo13919f()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public ReentrantLock m13911a(String str) {
        ReentrantLock reentrantLock = this.f6866f.get(str);
        if (reentrantLock == null) {
            ReentrantLock reentrantLock2 = new ReentrantLock();
            this.f6866f.put(str, reentrantLock2);
            return reentrantLock2;
        }
        return reentrantLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m13918a() {
        this.f6867g.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m13916a(AbstractC1926a abstractC1926a, String str) {
        this.f6865e.put(Integer.valueOf(abstractC1926a.mo13919f()), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m13914a(final RunnableC1938h runnableC1938h) {
        this.f6864d.execute(new Runnable() { // from class: com.d.a.b.f.1
            @Override // java.lang.Runnable
            public void run() {
                File mo14221a = C1930f.this.f6861a.f6814o.mo14221a(runnableC1938h.m13891a());
                boolean z = mo14221a != null && mo14221a.exists();
                C1930f.this.m13899h();
                if (z) {
                    C1930f.this.f6863c.execute(runnableC1938h);
                } else {
                    C1930f.this.f6862b.execute(runnableC1938h);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m13913a(RunnableC1943i runnableC1943i) {
        m13899h();
        this.f6863c.execute(runnableC1943i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m13912a(Runnable runnable) {
        this.f6864d.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m13910a(boolean z) {
        this.f6868h.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m13909b() {
        this.f6867g.set(false);
        synchronized (this.f6870j) {
            this.f6870j.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m13908b(AbstractC1926a abstractC1926a) {
        this.f6865e.remove(Integer.valueOf(abstractC1926a.mo13919f()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m13906b(boolean z) {
        this.f6869i.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m13905c() {
        if (!this.f6861a.f6808i) {
            ((ExecutorService) this.f6862b).shutdownNow();
        }
        if (!this.f6861a.f6809j) {
            ((ExecutorService) this.f6863c).shutdownNow();
        }
        this.f6865e.clear();
        this.f6866f.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public AtomicBoolean m13903d() {
        return this.f6867g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Object m13902e() {
        return this.f6870j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean m13901f() {
        return this.f6868h.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m13900g() {
        return this.f6869i.get();
    }
}
