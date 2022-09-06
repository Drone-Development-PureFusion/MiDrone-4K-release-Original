package org.p248a.p249a.p252c.p257e;

import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p253a.C5018b;
import org.p248a.p249a.p260e.AbstractC5086b;
import org.p248a.p249a.p266g.AbstractC5135b;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5356f;
@AbstractC5005b
/* renamed from: org.a.a.c.e.c */
/* loaded from: classes2.dex */
public class C5059c implements HttpRequestInterceptor {

    /* renamed from: a */
    private static final String f21579a = "HttpClient";

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        URI uri;
        Header versionHeader;
        boolean z = false;
        C5351a.m1321a(httpRequest, "HTTP request");
        C5351a.m1321a(httpContext, "HTTP context");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            return;
        }
        C5057a m2176a = C5057a.m2176a(httpContext);
        CookieStore m2171d = m2176a.m2171d();
        if (m2171d == null) {
            if (!Log.isLoggable(f21579a, 3)) {
                return;
            }
            Log.d(f21579a, "Cookie store not specified in HTTP context");
            return;
        }
        AbstractC5086b<AbstractC5135b> m2168g = m2176a.m2168g();
        if (m2168g == null) {
            if (!Log.isLoggable(f21579a, 3)) {
                return;
            }
            Log.d(f21579a, "CookieSpec registry not specified in HTTP context");
            return;
        }
        HttpHost t = m2176a.t();
        if (t == null) {
            if (!Log.isLoggable(f21579a, 3)) {
                return;
            }
            Log.d(f21579a, "Target host not set in the context");
            return;
        }
        RouteInfo m2175b = m2176a.m2175b();
        if (m2175b == null) {
            if (!Log.isLoggable(f21579a, 3)) {
                return;
            }
            Log.d(f21579a, "Connection route not set in the context");
            return;
        }
        String m2290e = m2176a.m2161n().m2290e();
        String str = m2290e == null ? C5018b.f21483d : m2290e;
        if (Log.isLoggable(f21579a, 3)) {
            Log.d(f21579a, "CookieSpec selected: " + str);
        }
        if (httpRequest instanceof HttpUriRequest) {
            uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            try {
                uri = new URI(httpRequest.getRequestLine().getUri());
            } catch (URISyntaxException e) {
                uri = null;
            }
        }
        String path = uri != null ? uri.getPath() : null;
        String hostName = t.getHostName();
        int port = t.getPort();
        if (port < 0) {
            port = m2175b.getTargetHost().getPort();
        }
        if (port < 0) {
            port = 0;
        }
        if (C5356f.m1297a(path)) {
            path = "/";
        }
        CookieOrigin cookieOrigin = new CookieOrigin(hostName, port, path, m2175b.isSecure());
        AbstractC5135b mo2043a = m2168g.mo2043a(str);
        if (mo2043a == null) {
            throw new HttpException("Unsupported cookie policy: " + str);
        }
        CookieSpec mo1538a = mo2043a.mo1538a(m2176a);
        ArrayList<Cookie> arrayList = new ArrayList(m2171d.getCookies());
        ArrayList<Cookie> arrayList2 = new ArrayList();
        Date date = new Date();
        for (Cookie cookie : arrayList) {
            if (!cookie.isExpired(date)) {
                if (mo1538a.match(cookie, cookieOrigin)) {
                    if (Log.isLoggable(f21579a, 3)) {
                        Log.d(f21579a, "Cookie " + cookie + " match " + cookieOrigin);
                    }
                    arrayList2.add(cookie);
                }
            } else if (Log.isLoggable(f21579a, 3)) {
                Log.d(f21579a, "Cookie " + cookie + " expired");
            }
        }
        if (!arrayList2.isEmpty()) {
            for (Header header : mo1538a.formatCookies(arrayList2)) {
                httpRequest.addHeader(header);
            }
        }
        int version = mo1538a.getVersion();
        if (version > 0) {
            for (Cookie cookie2 : arrayList2) {
                if (version != cookie2.getVersion() || !(cookie2 instanceof SetCookie2)) {
                    z = true;
                }
            }
            if (z && (versionHeader = mo1538a.getVersionHeader()) != null) {
                httpRequest.addHeader(versionHeader);
            }
        }
        httpContext.setAttribute(C5057a.f21569d, mo1538a);
        httpContext.setAttribute(C5057a.f21570e, cookieOrigin);
    }
}
