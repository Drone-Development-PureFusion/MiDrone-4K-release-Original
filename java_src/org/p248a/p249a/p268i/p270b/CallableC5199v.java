package org.p248a.p249a.p268i.p270b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p259d.AbstractC5082c;
/* renamed from: org.a.a.i.b.v */
/* loaded from: classes2.dex */
class CallableC5199v<V> implements Callable<V> {

    /* renamed from: a */
    private final HttpUriRequest f22025a;

    /* renamed from: b */
    private final HttpClient f22026b;

    /* renamed from: c */
    private final AtomicBoolean f22027c = new AtomicBoolean(false);

    /* renamed from: d */
    private final long f22028d = System.currentTimeMillis();

    /* renamed from: e */
    private long f22029e = -1;

    /* renamed from: f */
    private long f22030f = -1;

    /* renamed from: g */
    private final HttpContext f22031g;

    /* renamed from: h */
    private final ResponseHandler<V> f22032h;

    /* renamed from: i */
    private final AbstractC5082c<V> f22033i;

    /* renamed from: j */
    private final C5193q f22034j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC5199v(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler<V> responseHandler, AbstractC5082c<V> abstractC5082c, C5193q c5193q) {
        this.f22026b = httpClient;
        this.f22032h = responseHandler;
        this.f22025a = httpUriRequest;
        this.f22031g = httpContext;
        this.f22033i = abstractC5082c;
        this.f22034j = c5193q;
    }

    /* renamed from: a */
    public long m1670a() {
        return this.f22028d;
    }

    /* renamed from: b */
    public long m1669b() {
        return this.f22029e;
    }

    /* renamed from: c */
    public long m1668c() {
        return this.f22030f;
    }

    @Override // java.util.concurrent.Callable
    public V call() {
        if (!this.f22027c.get()) {
            try {
                this.f22034j.m1749a().incrementAndGet();
                this.f22029e = System.currentTimeMillis();
                try {
                    this.f22034j.m1748b().decrementAndGet();
                    V v = (V) this.f22026b.execute(this.f22025a, this.f22032h, this.f22031g);
                    this.f22030f = System.currentTimeMillis();
                    this.f22034j.m1747c().m1732a(this.f22029e);
                    if (this.f22033i != null) {
                        this.f22033i.m2069a((AbstractC5082c<V>) v);
                    }
                    return v;
                } catch (Exception e) {
                    this.f22034j.m1746d().m1732a(this.f22029e);
                    this.f22030f = System.currentTimeMillis();
                    if (this.f22033i != null) {
                        this.f22033i.m2070a(e);
                    }
                    throw e;
                }
            } finally {
                this.f22034j.m1745e().m1732a(this.f22029e);
                this.f22034j.m1744f().m1732a(this.f22029e);
                this.f22034j.m1749a().decrementAndGet();
            }
        }
        throw new IllegalStateException("call has been cancelled for request " + this.f22025a.getURI());
    }

    /* renamed from: d */
    public void m1667d() {
        this.f22027c.set(true);
        if (this.f22033i != null) {
            this.f22033i.m2071a();
        }
    }
}
