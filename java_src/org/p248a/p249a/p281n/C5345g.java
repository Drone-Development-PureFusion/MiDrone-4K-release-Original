package org.p248a.p249a.p281n;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.n.g */
/* loaded from: classes2.dex */
public class C5345g implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "HTTP request");
        if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && !httpRequest.containsHeader(C5083e.f21675j)) {
            httpRequest.addHeader(C5083e.f21675j, "Keep-Alive");
        }
    }
}
