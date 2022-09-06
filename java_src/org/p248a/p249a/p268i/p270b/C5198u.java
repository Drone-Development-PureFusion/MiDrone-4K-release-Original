package org.p248a.p249a.p268i.p270b;

import java.util.concurrent.FutureTask;
import org.apache.http.client.methods.HttpUriRequest;
/* renamed from: org.a.a.i.b.u */
/* loaded from: classes2.dex */
public class C5198u<V> extends FutureTask<V> {

    /* renamed from: a */
    private final HttpUriRequest f22023a;

    /* renamed from: b */
    private final CallableC5199v<V> f22024b;

    public C5198u(HttpUriRequest httpUriRequest, CallableC5199v<V> callableC5199v) {
        super(callableC5199v);
        this.f22023a = httpUriRequest;
        this.f22024b = callableC5199v;
    }

    /* renamed from: a */
    public long m1675a() {
        return this.f22024b.m1670a();
    }

    /* renamed from: b */
    public long m1674b() {
        return this.f22024b.m1669b();
    }

    /* renamed from: c */
    public long m1673c() {
        if (isDone()) {
            return this.f22024b.m1668c();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f22024b.m1667d();
        if (z) {
            this.f22023a.abort();
        }
        return super.cancel(z);
    }

    /* renamed from: d */
    public long m1672d() {
        if (isDone()) {
            return m1673c() - m1674b();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    /* renamed from: e */
    public long m1671e() {
        if (isDone()) {
            return m1673c() - m1675a();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    public String toString() {
        return this.f22023a.getRequestLine().getUri();
    }
}
