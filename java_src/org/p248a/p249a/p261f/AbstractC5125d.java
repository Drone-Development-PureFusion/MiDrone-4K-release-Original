package org.p248a.p249a.p261f;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpContext;
/* renamed from: org.a.a.f.d */
/* loaded from: classes2.dex */
public interface AbstractC5125d {
    /* renamed from: a */
    AbstractC5094a mo1604a(HttpRoute httpRoute, Object obj);

    /* renamed from: a */
    void mo1618a();

    /* renamed from: a */
    void mo1617a(long j, TimeUnit timeUnit);

    /* renamed from: a */
    void mo1612a(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit);

    /* renamed from: a */
    void mo1611a(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext);

    /* renamed from: a */
    void mo1610a(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext);

    /* renamed from: b */
    void mo1603b();

    /* renamed from: b */
    void mo1602b(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext);
}
