package org.p248a.p249a.p281n;

import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestInterceptorList;
import org.apache.http.protocol.HttpResponseInterceptorList;
import org.p248a.p249a.p250a.AbstractC5007d;
@AbstractC5007d
/* renamed from: org.a.a.n.f */
/* loaded from: classes.dex */
public final class C5344f implements HttpProcessor {

    /* renamed from: a */
    private final HttpRequestInterceptor[] f22391a;

    /* renamed from: b */
    private final HttpResponseInterceptor[] f22392b;

    public C5344f(List<HttpRequestInterceptor> list, List<HttpResponseInterceptor> list2) {
        if (list != null) {
            this.f22391a = (HttpRequestInterceptor[]) list.toArray(new HttpRequestInterceptor[list.size()]);
        } else {
            this.f22391a = new HttpRequestInterceptor[0];
        }
        if (list2 != null) {
            this.f22392b = (HttpResponseInterceptor[]) list2.toArray(new HttpResponseInterceptor[list2.size()]);
        } else {
            this.f22392b = new HttpResponseInterceptor[0];
        }
    }

    @Deprecated
    public C5344f(HttpRequestInterceptorList httpRequestInterceptorList, HttpResponseInterceptorList httpResponseInterceptorList) {
        if (httpRequestInterceptorList != null) {
            int requestInterceptorCount = httpRequestInterceptorList.getRequestInterceptorCount();
            this.f22391a = new HttpRequestInterceptor[requestInterceptorCount];
            for (int i = 0; i < requestInterceptorCount; i++) {
                this.f22391a[i] = httpRequestInterceptorList.getRequestInterceptor(i);
            }
        } else {
            this.f22391a = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorList == null) {
            this.f22392b = new HttpResponseInterceptor[0];
            return;
        }
        int responseInterceptorCount = httpResponseInterceptorList.getResponseInterceptorCount();
        this.f22392b = new HttpResponseInterceptor[responseInterceptorCount];
        for (int i2 = 0; i2 < responseInterceptorCount; i2++) {
            this.f22392b[i2] = httpResponseInterceptorList.getResponseInterceptor(i2);
        }
    }

    public C5344f(HttpRequestInterceptor... httpRequestInterceptorArr) {
        this(httpRequestInterceptorArr, (HttpResponseInterceptor[]) null);
    }

    public C5344f(HttpRequestInterceptor[] httpRequestInterceptorArr, HttpResponseInterceptor[] httpResponseInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            int length = httpRequestInterceptorArr.length;
            this.f22391a = new HttpRequestInterceptor[length];
            System.arraycopy(httpRequestInterceptorArr, 0, this.f22391a, 0, length);
        } else {
            this.f22391a = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorArr == null) {
            this.f22392b = new HttpResponseInterceptor[0];
            return;
        }
        int length2 = httpResponseInterceptorArr.length;
        this.f22392b = new HttpResponseInterceptor[length2];
        System.arraycopy(httpResponseInterceptorArr, 0, this.f22392b, 0, length2);
    }

    public C5344f(HttpResponseInterceptor... httpResponseInterceptorArr) {
        this((HttpRequestInterceptor[]) null, httpResponseInterceptorArr);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        for (HttpRequestInterceptor httpRequestInterceptor : this.f22391a) {
            httpRequestInterceptor.process(httpRequest, httpContext);
        }
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        for (HttpResponseInterceptor httpResponseInterceptor : this.f22392b) {
            httpResponseInterceptor.process(httpResponse, httpContext);
        }
    }
}
