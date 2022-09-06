package org.p248a.p249a.p252c.p257e;

import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.c.e.f */
/* loaded from: classes2.dex */
public class C5062f implements HttpRequestInterceptor {

    /* renamed from: a */
    private final Collection<? extends Header> f21583a;

    public C5062f() {
        this(null);
    }

    public C5062f(Collection<? extends Header> collection) {
        this.f21583a = collection;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "HTTP request");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            return;
        }
        Collection<? extends Header> collection = (Collection) httpRequest.getParams().getParameter("http.default-headers");
        if (collection == null) {
            collection = this.f21583a;
        }
        if (collection == null) {
            return;
        }
        for (Header header : collection) {
            httpRequest.addHeader(header);
        }
    }
}
