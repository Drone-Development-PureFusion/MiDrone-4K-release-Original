package org.p290c.p299b.p303d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.p290c.p299b.C5500b;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5608c;
import org.p290c.p312f.p313a.C5652l;
@Deprecated
/* renamed from: org.c.b.d.g */
/* loaded from: classes.dex */
public class C5545g {

    /* renamed from: a */
    private final Object f22627a;

    /* renamed from: b */
    private final C5608c f22628b;

    /* renamed from: c */
    private final C5619c f22629c;

    /* renamed from: d */
    private C5552k f22630d;

    public C5545g(Object obj, C5552k c5552k, C5608c c5608c, C5619c c5619c) {
        this.f22627a = obj;
        this.f22628b = c5608c;
        this.f22629c = c5619c;
        this.f22630d = c5552k;
    }

    /* renamed from: a */
    private void m814a(final long j) {
        m813a(new Runnable() { // from class: org.c.b.d.g.1
            @Override // java.lang.Runnable
            public void run() {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                Future submit = newSingleThreadExecutor.submit(new Callable<Object>() { // from class: org.c.b.d.g.1.1
                    @Override // java.util.concurrent.Callable
                    public Object call() {
                        C5545g.this.m810c();
                        return null;
                    }
                });
                newSingleThreadExecutor.shutdown();
                try {
                    if (!newSingleThreadExecutor.awaitTermination(j, TimeUnit.MILLISECONDS)) {
                        newSingleThreadExecutor.shutdownNow();
                    }
                    submit.get(0L, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    C5545g.this.m812a(new C5652l(j, TimeUnit.MILLISECONDS));
                } catch (Exception e2) {
                    C5545g.this.m812a(e2);
                }
            }
        });
    }

    /* renamed from: d */
    private void m809d() {
        try {
            try {
                for (Method method : this.f22630d.m783e()) {
                    method.invoke(this.f22627a, new Object[0]);
                }
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        } catch (C5500b e2) {
            throw new C5528c();
        } catch (Throwable th) {
            m812a(th);
            throw new C5528c();
        }
    }

    /* renamed from: e */
    private void m808e() {
        for (Method method : this.f22630d.m782f()) {
            try {
                method.invoke(this.f22627a, new Object[0]);
            } catch (InvocationTargetException e) {
                m812a(e.getTargetException());
            } catch (Throwable th) {
                m812a(th);
            }
        }
    }

    /* renamed from: a */
    public void m815a() {
        if (this.f22630d.m789a()) {
            this.f22628b.m558c(this.f22629c);
            return;
        }
        this.f22628b.m560b(this.f22629c);
        try {
            long m786b = this.f22630d.m786b();
            if (m786b > 0) {
                m814a(m786b);
            } else {
                m811b();
            }
        } finally {
            this.f22628b.m556d(this.f22629c);
        }
    }

    /* renamed from: a */
    public void m813a(Runnable runnable) {
        try {
            try {
                m809d();
                runnable.run();
                m808e();
            } catch (C5528c e) {
                m808e();
            } catch (Exception e2) {
                throw new RuntimeException("test should never throw an exception to this level");
            }
        } catch (Throwable th) {
            m808e();
            throw th;
        }
    }

    /* renamed from: a */
    protected void m812a(Throwable th) {
        this.f22628b.m568a(new C5605a(this.f22629c, th));
    }

    /* renamed from: b */
    public void m811b() {
        m813a(new Runnable() { // from class: org.c.b.d.g.2
            @Override // java.lang.Runnable
            public void run() {
                C5545g.this.m810c();
            }
        });
    }

    /* renamed from: c */
    protected void m810c() {
        try {
            this.f22630d.m788a(this.f22627a);
            if (!this.f22630d.m784d()) {
                return;
            }
            m812a(new AssertionError("Expected exception: " + this.f22630d.m785c().getName()));
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof C5500b) {
                return;
            }
            if (!this.f22630d.m784d()) {
                m812a(targetException);
            } else if (!this.f22630d.m787a(targetException)) {
            } else {
                m812a(new Exception("Unexpected exception, expected<" + this.f22630d.m785c().getName() + "> but was<" + targetException.getClass().getName() + ">", targetException));
            }
        } catch (Throwable th) {
            m812a(th);
        }
    }
}
