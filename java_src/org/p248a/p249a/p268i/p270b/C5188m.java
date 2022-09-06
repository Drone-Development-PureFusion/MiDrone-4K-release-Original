package org.p248a.p249a.p268i.p270b;

import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.AbstractC5056e;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p255c.C5040g;
import org.p248a.p249a.p252c.p255c.C5041h;
import org.p248a.p249a.p252c.p255c.C5051p;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p252c.p258f.C5076h;
import org.p248a.p249a.p252c.p258f.C5077i;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
import org.p248a.p249a.p282o.C5356f;
@AbstractC5005b
/* renamed from: org.a.a.i.b.m */
/* loaded from: classes.dex */
public class C5188m implements AbstractC5056e {
    @Deprecated

    /* renamed from: a */
    public static final String f21958a = "http.protocol.redirect-locations";

    /* renamed from: c */
    private static final String f21960c = "HttpClient";

    /* renamed from: b */
    public static final C5188m f21959b = new C5188m();

    /* renamed from: d */
    private static final String[] f21961d = {"GET", C5041h.f21543a};

    /* renamed from: a */
    protected URI m1757a(String str) {
        try {
            C5076h c5076h = new C5076h(new URI(str).normalize());
            String m2114h = c5076h.m2114h();
            if (m2114h != null) {
                c5076h.m2125c(m2114h.toLowerCase(Locale.ENGLISH));
            }
            if (C5356f.m1297a(c5076h.m2110j())) {
                c5076h.m2121d("/");
            }
            return c5076h.m2138a();
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid redirect URI: " + str, e);
        }
    }

    @Override // org.p248a.p249a.p252c.AbstractC5056e
    /* renamed from: a */
    public boolean mo1756a(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "HTTP request");
        C5351a.m1321a(httpResponse, "HTTP response");
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String method = httpRequest.getRequestLine().getMethod();
        Header firstHeader = httpResponse.getFirstHeader("location");
        switch (statusCode) {
            case 301:
            case 307:
                return mo1663b(method);
            case 302:
                return mo1663b(method) && firstHeader != null;
            case 303:
                return true;
            case 304:
            case 305:
            case 306:
            default:
                return false;
        }
    }

    @Override // org.p248a.p249a.p252c.AbstractC5056e
    /* renamed from: b */
    public HttpUriRequest mo1755b(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        URI m1754c = m1754c(httpRequest, httpResponse, httpContext);
        String method = httpRequest.getRequestLine().getMethod();
        if (method.equalsIgnoreCase(C5041h.f21543a)) {
            return new C5041h(m1754c);
        }
        if (!method.equalsIgnoreCase("GET") && httpResponse.getStatusLine().getStatusCode() == 307) {
            return C5051p.m2212a(httpRequest).m2216a(m1754c).m2186n();
        }
        return new C5040g(m1754c);
    }

    /* renamed from: b */
    protected boolean mo1663b(String str) {
        for (String str2 : f21961d) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public URI m1754c(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        URI uri;
        C5351a.m1321a(httpRequest, "HTTP request");
        C5351a.m1321a(httpResponse, "HTTP response");
        C5351a.m1321a(httpContext, "HTTP context");
        C5057a m2176a = C5057a.m2176a(httpContext);
        Header firstHeader = httpResponse.getFirstHeader("location");
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
        String value = firstHeader.getValue();
        if (Log.isLoggable(f21960c, 3)) {
            Log.d(f21960c, "Redirect requested to location '" + value + "'");
        }
        C5019c m2161n = m2176a.m2161n();
        URI m1757a = m1757a(value);
        try {
            if (m1757a.isAbsolute()) {
                uri = m1757a;
            } else if (!m2161n.m2288g()) {
                throw new ProtocolException("Relative redirect location '" + m1757a + "' not allowed");
            } else {
                HttpHost t = m2176a.t();
                C5352b.m1313a(t, "Target host");
                uri = C5077i.m2101a(C5077i.m2098a(new URI(httpRequest.getRequestLine().getUri()), t, false), m1757a);
            }
            C5172ad c5172ad = (C5172ad) m2176a.getAttribute("http.protocol.redirect-locations");
            if (c5172ad == null) {
                c5172ad = new C5172ad();
                httpContext.setAttribute("http.protocol.redirect-locations", c5172ad);
            }
            if (!m2161n.m2287h() && c5172ad.m1792a(uri)) {
                throw new CircularRedirectException("Circular redirect to '" + uri + "'");
            }
            c5172ad.m1790b(uri);
            return uri;
        } catch (URISyntaxException e) {
            throw new ProtocolException(e.getMessage(), e);
        }
    }
}
