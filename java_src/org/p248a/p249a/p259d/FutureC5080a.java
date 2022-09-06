package org.p248a.p249a.p259d;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.p248a.p249a.p282o.C5351a;
/* renamed from: org.a.a.d.a */
/* loaded from: classes2.dex */
public class FutureC5080a<T> implements Future<T>, AbstractC5081b {

    /* renamed from: a */
    private final AbstractC5082c<T> f21632a;

    /* renamed from: b */
    private volatile boolean f21633b;

    /* renamed from: c */
    private volatile boolean f21634c;

    /* renamed from: d */
    private volatile T f21635d;

    /* renamed from: e */
    private volatile Exception f21636e;

    public FutureC5080a(AbstractC5082c<T> abstractC5082c) {
        this.f21632a = abstractC5082c;
    }

    /* renamed from: b */
    private T m2072b() {
        if (this.f21636e != null) {
            throw new ExecutionException(this.f21636e);
        }
        return this.f21635d;
    }

    @Override // org.p248a.p249a.p259d.AbstractC5081b
    /* renamed from: a */
    public boolean mo1532a() {
        return cancel(true);
    }

    /* renamed from: a */
    public boolean m2074a(Exception exc) {
        boolean z = true;
        synchronized (this) {
            if (this.f21633b) {
                z = false;
            } else {
                this.f21633b = true;
                this.f21636e = exc;
                notifyAll();
                if (this.f21632a != null) {
                    this.f21632a.m2070a(exc);
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m2073a(T t) {
        boolean z = true;
        synchronized (this) {
            if (this.f21633b) {
                z = false;
            } else {
                this.f21633b = true;
                this.f21635d = t;
                notifyAll();
                if (this.f21632a != null) {
                    this.f21632a.m2069a((AbstractC5082c<T>) t);
                }
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (this.f21633b) {
                z2 = false;
            } else {
                this.f21633b = true;
                this.f21634c = true;
                notifyAll();
                if (this.f21632a != null) {
                    this.f21632a.m2071a();
                }
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() {
        while (!this.f21633b) {
            wait();
        }
        return m2072b();
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j, TimeUnit timeUnit) {
        T m2072b;
        C5351a.m1321a(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        long currentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        if (!this.f21633b) {
            if (millis <= 0) {
                throw new TimeoutException();
            }
            long j2 = millis;
            do {
                wait(j2);
                if (this.f21633b) {
                    m2072b = m2072b();
                } else {
                    j2 = millis - (System.currentTimeMillis() - currentTimeMillis);
                }
            } while (j2 > 0);
            throw new TimeoutException();
        }
        m2072b = m2072b();
        return m2072b;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f21634c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f21633b;
    }
}
