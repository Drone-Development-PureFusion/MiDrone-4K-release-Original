package org.p248a.p249a.p281n;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpDateGenerator;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5007d
/* renamed from: org.a.a.n.i */
/* loaded from: classes2.dex */
public class C5347i implements HttpRequestInterceptor {

    /* renamed from: a */
    private static final HttpDateGenerator f22394a = new HttpDateGenerator();

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "HTTP request");
        if (!(httpRequest instanceof HttpEntityEnclosingRequest) || httpRequest.containsHeader("Date")) {
            return;
        }
        httpRequest.setHeader("Date", f22394a.getCurrentDate());
    }
}
