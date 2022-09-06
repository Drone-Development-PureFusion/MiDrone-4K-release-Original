package org.p248a.p249a.p281n;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.n.k */
/* loaded from: classes2.dex */
public class C5349k implements HttpRequestInterceptor {

    /* renamed from: a */
    private final String f22395a;

    public C5349k() {
        this(null);
    }

    public C5349k(String str) {
        this.f22395a = str;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader(C5083e.f21661Y)) {
            String str = null;
            HttpParams params = httpRequest.getParams();
            if (params != null) {
                str = (String) params.getParameter("http.useragent");
            }
            if (str == null) {
                str = this.f22395a;
            }
            if (str == null) {
                return;
            }
            httpRequest.addHeader(C5083e.f21661Y, str);
        }
    }
}
