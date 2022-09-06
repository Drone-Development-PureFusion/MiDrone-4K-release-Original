package org.p248a.p249a.p280m;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p259d.AbstractC5082c;
import org.p248a.p249a.p282o.C5351a;
/* JADX INFO: Access modifiers changed from: package-private */
@AbstractC5007d
/* renamed from: org.a.a.m.g */
/* loaded from: classes2.dex */
public abstract class AbstractFutureC5336g<T> implements Future<T> {

    /* renamed from: a */
    private final Lock f22365a;

    /* renamed from: b */
    private final AbstractC5082c<T> f22366b;

    /* renamed from: c */
    private final Condition f22367c;

    /* renamed from: d */
    private volatile boolean f22368d;

    /* renamed from: e */
    private volatile boolean f22369e;

    /* renamed from: f */
    private T f22370f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractFutureC5336g(Lock lock, AbstractC5082c<T> abstractC5082c) {
        this.f22365a = lock;
        this.f22367c = lock.newCondition();
        this.f22366b = abstractC5082c;
    }

    /* renamed from: a */
    public void m1382a() {
        this.f22365a.lock();
        try {
            this.f22367c.signalAll();
        } finally {
            this.f22365a.unlock();
        }
    }

    /* renamed from: a */
    public boolean m1381a(Date date) {
        boolean z;
        this.f22365a.lock();
        try {
            if (this.f22368d) {
                throw new InterruptedException("Operation interrupted");
            }
            if (date != null) {
                z = this.f22367c.awaitUntil(date);
            } else {
                this.f22367c.await();
                z = true;
            }
            if (!this.f22368d) {
                return z;
            }
            throw new InterruptedException("Operation interrupted");
        } finally {
            this.f22365a.unlock();
        }
    }

    /* renamed from: b */
    protected abstract T mo1380b(long j, TimeUnit timeUnit);

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f22365a.lock();
        try {
            if (this.f22369e) {
                return false;
            }
            this.f22369e = true;
            this.f22368d = true;
            if (this.f22366b != null) {
                this.f22366b.m2071a();
            }
            this.f22367c.signalAll();
            return true;
        } finally {
            this.f22365a.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public T get() {
        try {
            return get(0L, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            throw new ExecutionException(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        T t;
        C5351a.m1321a(timeUnit, "Time unit");
        this.f22365a.lock();
        try {
            try {
                if (this.f22369e) {
                    t = this.f22370f;
                } else {
                    this.f22370f = mo1380b(j, timeUnit);
                    this.f22369e = true;
                    if (this.f22366b != null) {
                        this.f22366b.m2069a((AbstractC5082c<T>) this.f22370f);
                    }
                    t = this.f22370f;
                }
                return t;
            } catch (IOException e) {
                this.f22369e = true;
                this.f22370f = null;
                if (this.f22366b != null) {
                    this.f22366b.m2070a((Exception) e);
                }
                throw new ExecutionException(e);
            }
        } finally {
            this.f22365a.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f22368d;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f22369e;
    }
}
