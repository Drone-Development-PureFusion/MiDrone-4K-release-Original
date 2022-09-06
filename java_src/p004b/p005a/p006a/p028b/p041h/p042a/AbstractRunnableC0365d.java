package p004b.p005a.p006a.p028b.p041h.p042a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0363b;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.h.a.d */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC0365d<T extends AbstractRunnableC0363b> extends C0527f implements AbstractRunnableC0374k<T>, Runnable {

    /* renamed from: a */
    private final Lock f741a = new ReentrantLock();

    /* renamed from: b */
    private final Collection<T> f742b = new ArrayList();

    /* renamed from: c */
    private final AbstractC0373j<T> f743c;

    /* renamed from: d */
    private final Executor f744d;

    /* renamed from: e */
    private boolean f745e;

    /* renamed from: b.a.a.b.h.a.d$a */
    /* loaded from: classes.dex */
    private class C0367a implements AbstractRunnableC0363b {

        /* renamed from: b */
        private final T f748b;

        public C0367a(T t) {
            this.f748b = t;
        }

        @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0363b, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f748b.close();
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractRunnableC0365d.this.m20766b(this.f748b);
            try {
                this.f748b.run();
            } finally {
                AbstractRunnableC0365d.this.m20763c((AbstractRunnableC0365d) this.f748b);
            }
        }
    }

    public AbstractRunnableC0365d(AbstractC0373j<T> abstractC0373j, Executor executor) {
        this.f743c = abstractC0373j;
        this.f744d = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m20766b(T t) {
        this.f741a.lock();
        try {
            this.f742b.add(t);
        } finally {
            this.f741a.unlock();
        }
    }

    /* renamed from: c */
    private Collection<T> m20764c() {
        this.f741a.lock();
        try {
            return new ArrayList(this.f742b);
        } finally {
            this.f741a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m20763c(T t) {
        this.f741a.lock();
        try {
            this.f742b.remove(t);
        } finally {
            this.f741a.unlock();
        }
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0374k
    /* renamed from: a */
    public void mo20754a(AbstractC0364c<T> abstractC0364c) {
        for (T t : m20764c()) {
            try {
                abstractC0364c.mo20738a(t);
            } catch (RuntimeException e) {
                c(t + ": " + e);
            }
        }
    }

    /* renamed from: a */
    protected void m20767a(boolean z) {
        this.f745e = z;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0374k
    /* renamed from: a */
    public boolean mo20755a() {
        return this.f745e;
    }

    /* renamed from: a */
    protected abstract boolean mo20761a(T t);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0374k
    /* renamed from: b */
    public void mo20753b() {
        this.f743c.close();
        mo20754a((AbstractC0364c) new AbstractC0364c<T>() { // from class: b.a.a.b.h.a.d.1
            @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0364c
            /* renamed from: a */
            public void mo20738a(T t) {
                t.close();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        m20767a(true);
        try {
            d("listening on " + this.f743c);
            while (!Thread.currentThread().isInterrupted()) {
                T mo20736a = this.f743c.mo20736a();
                if (!mo20761a((AbstractRunnableC0365d<T>) mo20736a)) {
                    c(mo20736a + ": connection dropped");
                    mo20736a.close();
                } else {
                    try {
                        this.f744d.execute(new C0367a(mo20736a));
                    } catch (RejectedExecutionException e) {
                        c(mo20736a + ": connection dropped");
                        mo20736a.close();
                    }
                }
            }
        } catch (InterruptedException e2) {
        } catch (Exception e3) {
            c("listener: " + e3);
        }
        m20767a(false);
        d("shutting down");
        this.f743c.close();
    }
}
