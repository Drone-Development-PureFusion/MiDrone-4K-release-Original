package org.p248a.p249a.p268i.p271c;

import com.facebook.common.util.UriUtil;
import java.net.InetAddress;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p261f.AbstractC5131i;
import org.p248a.p249a.p261f.C5132j;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.c.j */
/* loaded from: classes2.dex */
public class C5217j implements HttpRoutePlanner {

    /* renamed from: a */
    private final AbstractC5131i f22085a;

    public C5217j(AbstractC5131i abstractC5131i) {
        this.f22085a = abstractC5131i == null ? C5218k.f22086a : abstractC5131i;
    }

    /* renamed from: a */
    protected HttpHost mo1581a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return null;
    }

    public HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "Request");
        if (httpHost == null) {
            throw new ProtocolException("Target host is not specified");
        }
        C5019c m2161n = C5057a.m2176a(httpContext).m2161n();
        InetAddress m2292c = m2161n.m2292c();
        HttpHost m2293b = m2161n.m2293b();
        if (m2293b == null) {
            m2293b = mo1581a(httpHost, httpRequest, httpContext);
        }
        if (httpHost.getPort() <= 0) {
            try {
                httpHost = new HttpHost(httpHost.getHostName(), this.f22085a.mo1630a(httpHost), httpHost.getSchemeName());
            } catch (C5132j e) {
                throw new HttpException(e.getMessage());
            }
        }
        boolean equalsIgnoreCase = httpHost.getSchemeName().equalsIgnoreCase(UriUtil.HTTPS_SCHEME);
        return m2293b == null ? new HttpRoute(httpHost, m2292c, equalsIgnoreCase) : new HttpRoute(httpHost, m2292c, m2293b, equalsIgnoreCase);
    }
}
