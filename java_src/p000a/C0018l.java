package p000a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: a.l */
/* loaded from: classes.dex */
public class C0018l<TResult> {

    /* renamed from: e */
    private boolean f53e;

    /* renamed from: f */
    private boolean f54f;

    /* renamed from: g */
    private TResult f55g;

    /* renamed from: h */
    private Exception f56h;

    /* renamed from: a */
    public static final ExecutorService f49a = C0012h.m21632a();

    /* renamed from: c */
    private static final Executor f51c = C0012h.m21631b();

    /* renamed from: b */
    public static final Executor f50b = C0001b.m21665b();

    /* renamed from: d */
    private final Object f52d = new Object();

    /* renamed from: i */
    private List<AbstractC0016j<TResult, Void>> f57i = new ArrayList();

    /* renamed from: a.l$a */
    /* loaded from: classes.dex */
    public class C0030a {
        private C0030a() {
        }

        /* renamed from: a */
        public C0018l<TResult> m21575a() {
            return C0018l.this;
        }

        /* renamed from: a */
        public boolean m21574a(Exception exc) {
            boolean z = true;
            synchronized (C0018l.this.f52d) {
                if (C0018l.this.f53e) {
                    z = false;
                } else {
                    C0018l.this.f53e = true;
                    C0018l.this.f56h = exc;
                    C0018l.this.f52d.notifyAll();
                    C0018l.this.m21584k();
                }
            }
            return z;
        }

        /* renamed from: a */
        public boolean m21573a(TResult tresult) {
            boolean z = true;
            synchronized (C0018l.this.f52d) {
                if (C0018l.this.f53e) {
                    z = false;
                } else {
                    C0018l.this.f53e = true;
                    C0018l.this.f55g = tresult;
                    C0018l.this.f52d.notifyAll();
                    C0018l.this.m21584k();
                }
            }
            return z;
        }

        /* renamed from: b */
        public void m21571b(Exception exc) {
            if (!m21574a(exc)) {
                throw new IllegalStateException("Cannot set the error on a completed task.");
            }
        }

        /* renamed from: b */
        public void m21570b(TResult tresult) {
            if (!m21573a((C0030a) tresult)) {
                throw new IllegalStateException("Cannot set the result of a completed task.");
            }
        }

        /* renamed from: b */
        public boolean m21572b() {
            boolean z = true;
            synchronized (C0018l.this.f52d) {
                if (C0018l.this.f53e) {
                    z = false;
                } else {
                    C0018l.this.f53e = true;
                    C0018l.this.f54f = true;
                    C0018l.this.f52d.notifyAll();
                    C0018l.this.m21584k();
                }
            }
            return z;
        }

        /* renamed from: c */
        public void m21569c() {
            if (!m21572b()) {
                throw new IllegalStateException("Cannot cancel a completed task.");
            }
        }
    }

    private C0018l() {
    }

    /* renamed from: a */
    public static <TResult> C0018l<TResult>.C0030a m21621a() {
        C0018l c0018l = new C0018l();
        c0018l.getClass();
        return new C0030a();
    }

    /* renamed from: a */
    public static <TResult> C0018l<TResult> m21613a(Exception exc) {
        C0030a m21621a = m21621a();
        m21621a.m21571b(exc);
        return m21621a.m21575a();
    }

    /* renamed from: a */
    public static <TResult> C0018l<TResult> m21612a(TResult tresult) {
        C0030a m21621a = m21621a();
        m21621a.m21570b((C0030a) tresult);
        return m21621a.m21575a();
    }

    /* renamed from: a */
    public static C0018l<Void> m21611a(Collection<? extends C0018l<?>> collection) {
        if (collection.size() == 0) {
            return m21612a((Object) null);
        }
        final C0030a m21621a = m21621a();
        final ArrayList arrayList = new ArrayList();
        final Object obj = new Object();
        final AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (C0018l<?> c0018l : collection) {
            c0018l.m21620a(new AbstractC0016j<Object, Void>() { // from class: a.l.4
                @Override // p000a.AbstractC0016j
                /* renamed from: a */
                public Void mo21799then(C0018l<Object> c0018l2) {
                    if (c0018l2.m21594d()) {
                        synchronized (obj) {
                            arrayList.add(c0018l2.m21589f());
                        }
                    }
                    if (c0018l2.m21599c()) {
                        atomicBoolean.set(true);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        if (arrayList.size() != 0) {
                            if (arrayList.size() == 1) {
                                m21621a.m21571b((Exception) arrayList.get(0));
                            } else {
                                m21621a.m21571b((Exception) new C0000a(String.format("There were %d exceptions.", Integer.valueOf(arrayList.size())), (Throwable[]) arrayList.toArray(new Throwable[arrayList.size()])));
                            }
                        } else if (atomicBoolean.get()) {
                            m21621a.m21569c();
                        } else {
                            m21621a.m21570b((C0030a) null);
                        }
                    }
                    return null;
                }
            });
        }
        return m21621a.m21575a();
    }

    /* renamed from: a */
    public static <TResult> C0018l<TResult> m21610a(Callable<TResult> callable) {
        return m21607a(callable, f49a);
    }

    /* renamed from: a */
    public static <TResult> C0018l<TResult> m21607a(final Callable<TResult> callable, Executor executor) {
        final C0030a m21621a = m21621a();
        executor.execute(new Runnable() { // from class: a.l.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C0030a.this.m21570b((C0030a) callable.call());
                } catch (Exception e) {
                    C0030a.this.m21571b(e);
                }
            }
        });
        return m21621a.m21575a();
    }

    /* renamed from: b */
    public static <TResult> C0018l<TResult> m21600b(Callable<TResult> callable) {
        return m21607a(callable, f51c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static <TContinuationResult, TResult> void m21596c(final C0018l<TContinuationResult>.C0030a c0030a, final AbstractC0016j<TResult, TContinuationResult> abstractC0016j, final C0018l<TResult> c0018l, Executor executor) {
        executor.execute(new Runnable() { // from class: a.l.10
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c0030a.m21570b((C0030a) AbstractC0016j.this.mo21799then(c0018l));
                } catch (Exception e) {
                    c0030a.m21571b(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static <TContinuationResult, TResult> void m21591d(final C0018l<TContinuationResult>.C0030a c0030a, final AbstractC0016j<TResult, C0018l<TContinuationResult>> abstractC0016j, final C0018l<TResult> c0018l, Executor executor) {
        executor.execute(new Runnable() { // from class: a.l.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C0018l c0018l2 = (C0018l) AbstractC0016j.this.mo21799then(c0018l);
                    if (c0018l2 == null) {
                        c0030a.m21570b((C0030a) null);
                    } else {
                        c0018l2.m21620a((AbstractC0016j) new AbstractC0016j<TContinuationResult, Void>() { // from class: a.l.2.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // p000a.AbstractC0016j
                            /* renamed from: a */
                            public Void mo21799then(C0018l<TContinuationResult> c0018l3) {
                                if (c0018l3.m21599c()) {
                                    c0030a.m21569c();
                                    return null;
                                } else if (c0018l3.m21594d()) {
                                    c0030a.m21571b(c0018l3.m21589f());
                                    return null;
                                } else {
                                    c0030a.m21570b((C0030a) c0018l3.m21590e());
                                    return null;
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    c0030a.m21571b(e);
                }
            }
        });
    }

    /* renamed from: h */
    public static <TResult> C0018l<TResult> m21587h() {
        C0030a m21621a = m21621a();
        m21621a.m21569c();
        return m21621a.m21575a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m21584k() {
        synchronized (this.f52d) {
            for (AbstractC0016j<TResult, Void> abstractC0016j : this.f57i) {
                try {
                    abstractC0016j.mo21799then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f57i = null;
        }
    }

    /* renamed from: a */
    public <TContinuationResult> C0018l<TContinuationResult> m21620a(AbstractC0016j<TResult, TContinuationResult> abstractC0016j) {
        return m21619a(abstractC0016j, f51c);
    }

    /* renamed from: a */
    public <TContinuationResult> C0018l<TContinuationResult> m21619a(final AbstractC0016j<TResult, TContinuationResult> abstractC0016j, final Executor executor) {
        boolean m21606b;
        final C0030a m21621a = m21621a();
        synchronized (this.f52d) {
            m21606b = m21606b();
            if (!m21606b) {
                this.f57i.add(new AbstractC0016j<TResult, Void>() { // from class: a.l.6
                    @Override // p000a.AbstractC0016j
                    /* renamed from: a */
                    public Void mo21799then(C0018l<TResult> c0018l) {
                        C0018l.m21596c(m21621a, abstractC0016j, c0018l, executor);
                        return null;
                    }
                });
            }
        }
        if (m21606b) {
            m21596c(m21621a, abstractC0016j, this, executor);
        }
        return m21621a.m21575a();
    }

    /* renamed from: a */
    public C0018l<Void> m21609a(Callable<Boolean> callable, AbstractC0016j<Void, C0018l<Void>> abstractC0016j) {
        return m21608a(callable, abstractC0016j, f51c);
    }

    /* renamed from: a */
    public C0018l<Void> m21608a(final Callable<Boolean> callable, final AbstractC0016j<Void, C0018l<Void>> abstractC0016j, final Executor executor) {
        final C0015i c0015i = new C0015i();
        c0015i.m21626a(new AbstractC0016j<Void, C0018l<Void>>() { // from class: a.l.5
            @Override // p000a.AbstractC0016j
            /* renamed from: a */
            public C0018l<Void> mo21799then(C0018l<Void> c0018l) {
                return ((Boolean) callable.call()).booleanValue() ? C0018l.m21612a((Object) null).m21592d(abstractC0016j, executor).m21592d((AbstractC0016j) c0015i.m21627a(), executor) : C0018l.m21612a((Object) null);
            }
        });
        return m21585j().m21604b((AbstractC0016j) c0015i.m21627a(), executor);
    }

    /* renamed from: b */
    public <TContinuationResult> C0018l<TContinuationResult> m21605b(AbstractC0016j<TResult, C0018l<TContinuationResult>> abstractC0016j) {
        return m21604b(abstractC0016j, f51c);
    }

    /* renamed from: b */
    public <TContinuationResult> C0018l<TContinuationResult> m21604b(final AbstractC0016j<TResult, C0018l<TContinuationResult>> abstractC0016j, final Executor executor) {
        boolean m21606b;
        final C0030a m21621a = m21621a();
        synchronized (this.f52d) {
            m21606b = m21606b();
            if (!m21606b) {
                this.f57i.add(new AbstractC0016j<TResult, Void>() { // from class: a.l.7
                    @Override // p000a.AbstractC0016j
                    /* renamed from: a */
                    public Void mo21799then(C0018l<TResult> c0018l) {
                        C0018l.m21591d(m21621a, abstractC0016j, c0018l, executor);
                        return null;
                    }
                });
            }
        }
        if (m21606b) {
            m21591d(m21621a, abstractC0016j, this, executor);
        }
        return m21621a.m21575a();
    }

    /* renamed from: b */
    public boolean m21606b() {
        boolean z;
        synchronized (this.f52d) {
            z = this.f53e;
        }
        return z;
    }

    /* renamed from: c */
    public <TContinuationResult> C0018l<TContinuationResult> m21598c(AbstractC0016j<TResult, TContinuationResult> abstractC0016j) {
        return m21597c(abstractC0016j, f51c);
    }

    /* renamed from: c */
    public <TContinuationResult> C0018l<TContinuationResult> m21597c(final AbstractC0016j<TResult, TContinuationResult> abstractC0016j, Executor executor) {
        return m21604b(new AbstractC0016j<TResult, C0018l<TContinuationResult>>() { // from class: a.l.8
            @Override // p000a.AbstractC0016j
            /* renamed from: a */
            public C0018l<TContinuationResult> mo21799then(C0018l<TResult> c0018l) {
                return c0018l.m21594d() ? C0018l.m21613a(c0018l.m21589f()) : c0018l.m21599c() ? C0018l.m21587h() : c0018l.m21620a((AbstractC0016j) abstractC0016j);
            }
        }, executor);
    }

    /* renamed from: c */
    public boolean m21599c() {
        boolean z;
        synchronized (this.f52d) {
            z = this.f54f;
        }
        return z;
    }

    /* renamed from: d */
    public <TContinuationResult> C0018l<TContinuationResult> m21593d(AbstractC0016j<TResult, C0018l<TContinuationResult>> abstractC0016j) {
        return m21592d(abstractC0016j, f51c);
    }

    /* renamed from: d */
    public <TContinuationResult> C0018l<TContinuationResult> m21592d(final AbstractC0016j<TResult, C0018l<TContinuationResult>> abstractC0016j, Executor executor) {
        return m21604b(new AbstractC0016j<TResult, C0018l<TContinuationResult>>() { // from class: a.l.9
            @Override // p000a.AbstractC0016j
            /* renamed from: a */
            public C0018l<TContinuationResult> mo21799then(C0018l<TResult> c0018l) {
                return c0018l.m21594d() ? C0018l.m21613a(c0018l.m21589f()) : c0018l.m21599c() ? C0018l.m21587h() : c0018l.m21605b(abstractC0016j);
            }
        }, executor);
    }

    /* renamed from: d */
    public boolean m21594d() {
        boolean z;
        synchronized (this.f52d) {
            z = this.f56h != null;
        }
        return z;
    }

    /* renamed from: e */
    public TResult m21590e() {
        TResult tresult;
        synchronized (this.f52d) {
            tresult = this.f55g;
        }
        return tresult;
    }

    /* renamed from: f */
    public Exception m21589f() {
        Exception exc;
        synchronized (this.f52d) {
            exc = this.f56h;
        }
        return exc;
    }

    /* renamed from: g */
    public void m21588g() {
        synchronized (this.f52d) {
            if (!m21606b()) {
                this.f52d.wait();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public <TOut> C0018l<TOut> m21586i() {
        return this;
    }

    /* renamed from: j */
    public C0018l<Void> m21585j() {
        return m21605b((AbstractC0016j<TResult, C0018l<Void>>) new AbstractC0016j<TResult, C0018l<Void>>() { // from class: a.l.1
            @Override // p000a.AbstractC0016j
            /* renamed from: a */
            public C0018l<Void> mo21799then(C0018l<TResult> c0018l) {
                return c0018l.m21599c() ? C0018l.m21587h() : c0018l.m21594d() ? C0018l.m21613a(c0018l.m21589f()) : C0018l.m21612a((Object) null);
            }
        });
    }
}
