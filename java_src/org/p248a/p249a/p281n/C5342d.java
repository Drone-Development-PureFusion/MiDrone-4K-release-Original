package org.p248a.p249a.p281n;

import java.util.LinkedList;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpProcessor;
/* renamed from: org.a.a.n.d */
/* loaded from: classes2.dex */
public class C5342d {

    /* renamed from: a */
    private C5340b<HttpRequestInterceptor> f22389a;

    /* renamed from: b */
    private C5340b<HttpResponseInterceptor> f22390b;

    C5342d() {
    }

    /* renamed from: a */
    public static C5342d m1341a() {
        return new C5342d();
    }

    /* renamed from: c */
    private C5340b<HttpRequestInterceptor> m1331c() {
        if (this.f22389a == null) {
            this.f22389a = new C5340b<>();
        }
        return this.f22389a;
    }

    /* renamed from: d */
    private C5340b<HttpResponseInterceptor> m1326d() {
        if (this.f22390b == null) {
            this.f22390b = new C5340b<>();
        }
        return this.f22390b;
    }

    /* renamed from: a */
    public C5342d m1340a(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            m1331c().m1358a((C5340b<HttpRequestInterceptor>) httpRequestInterceptor);
        }
        return this;
    }

    /* renamed from: a */
    public C5342d m1339a(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            m1326d().m1358a((C5340b<HttpResponseInterceptor>) httpResponseInterceptor);
        }
        return this;
    }

    /* renamed from: a */
    public C5342d m1338a(HttpRequestInterceptor... httpRequestInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            m1331c().m1356a(httpRequestInterceptorArr);
        }
        return this;
    }

    /* renamed from: a */
    public C5342d m1337a(HttpResponseInterceptor... httpResponseInterceptorArr) {
        if (httpResponseInterceptorArr != null) {
            m1326d().m1356a(httpResponseInterceptorArr);
        }
        return this;
    }

    /* renamed from: b */
    public C5342d m1335b(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            m1331c().m1355b((C5340b<HttpRequestInterceptor>) httpRequestInterceptor);
        }
        return this;
    }

    /* renamed from: b */
    public C5342d m1334b(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            m1326d().m1355b((C5340b<HttpResponseInterceptor>) httpResponseInterceptor);
        }
        return this;
    }

    /* renamed from: b */
    public C5342d m1333b(HttpRequestInterceptor... httpRequestInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            m1331c().m1353b(httpRequestInterceptorArr);
        }
        return this;
    }

    /* renamed from: b */
    public C5342d m1332b(HttpResponseInterceptor... httpResponseInterceptorArr) {
        if (httpResponseInterceptorArr != null) {
            m1326d().m1353b(httpResponseInterceptorArr);
        }
        return this;
    }

    /* renamed from: b */
    public HttpProcessor m1336b() {
        LinkedList<HttpResponseInterceptor> linkedList = null;
        LinkedList<HttpRequestInterceptor> m1359a = this.f22389a != null ? this.f22389a.m1359a() : null;
        if (this.f22390b != null) {
            linkedList = this.f22390b.m1359a();
        }
        return new C5344f(m1359a, linkedList);
    }

    /* renamed from: c */
    public C5342d m1330c(HttpRequestInterceptor httpRequestInterceptor) {
        return m1335b(httpRequestInterceptor);
    }

    /* renamed from: c */
    public C5342d m1329c(HttpResponseInterceptor httpResponseInterceptor) {
        return m1334b(httpResponseInterceptor);
    }

    /* renamed from: c */
    public C5342d m1328c(HttpRequestInterceptor... httpRequestInterceptorArr) {
        return m1333b(httpRequestInterceptorArr);
    }

    /* renamed from: c */
    public C5342d m1327c(HttpResponseInterceptor... httpResponseInterceptorArr) {
        return m1332b(httpResponseInterceptorArr);
    }
}
