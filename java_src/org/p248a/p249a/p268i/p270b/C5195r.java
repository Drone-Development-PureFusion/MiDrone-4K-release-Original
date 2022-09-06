package org.p248a.p249a.p268i.p270b;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p259d.AbstractC5082c;
@AbstractC5007d
/* renamed from: org.a.a.i.b.r */
/* loaded from: classes2.dex */
public class C5195r implements Closeable {

    /* renamed from: a */
    private final HttpClient f21976a;

    /* renamed from: b */
    private final ExecutorService f21977b;

    /* renamed from: c */
    private final C5193q f21978c = new C5193q();

    /* renamed from: d */
    private final AtomicBoolean f21979d = new AtomicBoolean(false);

    public C5195r(HttpClient httpClient, ExecutorService executorService) {
        this.f21976a = httpClient;
        this.f21977b = executorService;
    }

    /* renamed from: a */
    public C5193q m1730a() {
        return this.f21978c;
    }

    /* renamed from: a */
    public <T> C5198u<T> m1729a(HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler<T> responseHandler) {
        return m1728a(httpUriRequest, httpContext, responseHandler, null);
    }

    /* renamed from: a */
    public <T> C5198u<T> m1728a(HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler<T> responseHandler, AbstractC5082c<T> abstractC5082c) {
        if (this.f21979d.get()) {
            throw new IllegalStateException("Close has been called on this httpclient instance.");
        }
        this.f21978c.m1748b().incrementAndGet();
        C5198u<T> c5198u = new C5198u<>(httpUriRequest, new CallableC5199v(this.f21976a, httpUriRequest, httpContext, responseHandler, abstractC5082c, this.f21978c));
        this.f21977b.execute(c5198u);
        return c5198u;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f21979d.set(true);
        this.f21977b.shutdownNow();
        if (this.f21976a instanceof Closeable) {
            this.f21976a.close();
        }
    }
}
