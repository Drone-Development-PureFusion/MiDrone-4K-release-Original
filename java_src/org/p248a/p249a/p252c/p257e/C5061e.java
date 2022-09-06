package org.p248a.p249a.p252c.p257e;

import android.util.Log;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.c.e.e */
/* loaded from: classes2.dex */
public class C5061e implements HttpRequestInterceptor {

    /* renamed from: a */
    private static final String f21581a = "HttpClient";

    /* renamed from: b */
    private static final String f21582b = "Proxy-Connection";

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "HTTP request");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            httpRequest.setHeader(f21582b, "Keep-Alive");
            return;
        }
        RouteInfo m2175b = C5057a.m2176a(httpContext).m2175b();
        if (m2175b == null) {
            if (!Log.isLoggable(f21581a, 3)) {
                return;
            }
            Log.d(f21581a, "Connection route not set in the context");
            return;
        }
        if ((m2175b.getHopCount() == 1 || m2175b.isTunnelled()) && !httpRequest.containsHeader(C5083e.f21675j)) {
            httpRequest.addHeader(C5083e.f21675j, "Keep-Alive");
        }
        if (m2175b.getHopCount() != 2 || m2175b.isTunnelled() || httpRequest.containsHeader(f21582b)) {
            return;
        }
        httpRequest.addHeader(f21582b, "Keep-Alive");
    }
}
