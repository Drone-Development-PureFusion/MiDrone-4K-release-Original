package org.p248a.p249a.p268i.p270b;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5036c;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p261f.AbstractC5125d;
import org.p248a.p249a.p268i.C5291g;
import org.p248a.p249a.p268i.p274f.C5282f;
import org.p248a.p249a.p281n.C5339a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5007d
/* renamed from: org.a.a.i.b.y */
/* loaded from: classes2.dex */
class C5203y extends AbstractC5183h {

    /* renamed from: a */
    private final AbstractC5125d f22047a;

    /* renamed from: b */
    private final C5282f f22048b;

    /* renamed from: c */
    private final HttpParams f22049c = new BasicHttpParams();

    public C5203y(AbstractC5125d abstractC5125d) {
        this.f22047a = (AbstractC5125d) C5351a.m1321a(abstractC5125d, "HTTP connection manager");
        this.f22048b = new C5282f(new HttpRequestExecutor(), abstractC5125d, C5291g.f22236a, C5186k.f21953a);
    }

    @Override // org.p248a.p249a.p268i.p270b.AbstractC5183h
    /* renamed from: a */
    protected AbstractC5035b mo1661a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpHost, "Target host");
        C5351a.m1321a(httpRequest, "HTTP request");
        AbstractC5039f abstractC5039f = httpRequest instanceof AbstractC5039f ? (AbstractC5039f) httpRequest : null;
        try {
            C5047n m2221a = C5047n.m2221a(httpRequest);
            if (httpContext == null) {
                httpContext = new C5339a();
            }
            C5057a m2176a = C5057a.m2176a(httpContext);
            HttpRoute httpRoute = new HttpRoute(httpHost);
            C5019c mo2224l_ = httpRequest instanceof AbstractC5036c ? ((AbstractC5036c) httpRequest).mo2224l_() : null;
            if (mo2224l_ != null) {
                m2176a.m2181a(mo2224l_);
            }
            return this.f22048b.mo1511a(httpRoute, m2221a, m2176a, abstractC5039f);
        } catch (HttpException e) {
            throw new ClientProtocolException(e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22047a.mo1603b();
    }

    public ClientConnectionManager getConnectionManager() {
        return new ClientConnectionManager() { // from class: org.a.a.i.b.y.1
            public void closeExpiredConnections() {
                C5203y.this.f22047a.mo1618a();
            }

            public void closeIdleConnections(long j, TimeUnit timeUnit) {
                C5203y.this.f22047a.mo1617a(j, timeUnit);
            }

            public SchemeRegistry getSchemeRegistry() {
                throw new UnsupportedOperationException();
            }

            public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
                throw new UnsupportedOperationException();
            }

            public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
                throw new UnsupportedOperationException();
            }

            public void shutdown() {
                C5203y.this.f22047a.mo1603b();
            }
        };
    }

    public HttpParams getParams() {
        return this.f22049c;
    }
}
