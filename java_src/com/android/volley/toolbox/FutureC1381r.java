package com.android.volley.toolbox;

import com.android.volley.AbstractC1333n;
import com.android.volley.C1341p;
import com.android.volley.C1384u;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* renamed from: com.android.volley.toolbox.r */
/* loaded from: classes.dex */
public class FutureC1381r<T> implements C1341p.AbstractC1342a, C1341p.AbstractC1343b<T>, Future<T> {

    /* renamed from: a */
    private AbstractC1333n<?> f4709a;

    /* renamed from: b */
    private boolean f4710b = false;

    /* renamed from: c */
    private T f4711c;

    /* renamed from: d */
    private C1384u f4712d;

    private FutureC1381r() {
    }

    /* renamed from: a */
    public static <E> FutureC1381r<E> m16579a() {
        return new FutureC1381r<>();
    }

    /* renamed from: a */
    private synchronized T m16577a(Long l) {
        T t;
        if (this.f4712d != null) {
            throw new ExecutionException(this.f4712d);
        }
        if (this.f4710b) {
            t = this.f4711c;
        } else {
            if (l == null) {
                wait(0L);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.f4712d != null) {
                throw new ExecutionException(this.f4712d);
            }
            if (!this.f4710b) {
                throw new TimeoutException();
            }
            t = this.f4711c;
        }
        return t;
    }

    /* renamed from: a */
    public void m16578a(AbstractC1333n<?> abstractC1333n) {
        this.f4709a = abstractC1333n;
    }

    @Override // com.android.volley.C1341p.AbstractC1342a
    /* renamed from: a */
    public synchronized void mo7531a(C1384u c1384u) {
        this.f4712d = c1384u;
        notifyAll();
    }

    @Override // com.android.volley.C1341p.AbstractC1343b
    /* renamed from: a */
    public synchronized void mo13137a(T t) {
        this.f4710b = true;
        this.f4711c = t;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.f4709a != null && !isDone()) {
                this.f4709a.m16709l();
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        try {
            return m16577a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return m16577a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.f4709a == null) {
            return false;
        }
        return this.f4709a.mo16661m();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f4710b && this.f4712d == null) {
            if (!isCancelled()) {
                z = false;
            }
        }
        z = true;
        return z;
    }
}
