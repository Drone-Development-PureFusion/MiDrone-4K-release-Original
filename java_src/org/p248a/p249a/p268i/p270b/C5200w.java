package org.p248a.p249a.p268i.p270b;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p251b.AbstractC5011c;
import org.p248a.p249a.p251b.C5012d;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5036c;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p256d.C5055a;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p260e.AbstractC5086b;
import org.p248a.p249a.p261f.AbstractC5125d;
import org.p248a.p249a.p266g.AbstractC5135b;
import org.p248a.p249a.p268i.p274f.AbstractC5278b;
import org.p248a.p249a.p281n.C5339a;
import org.p248a.p249a.p282o.C5351a;
/* JADX INFO: Access modifiers changed from: package-private */
@AbstractC5007d
/* renamed from: org.a.a.i.b.w */
/* loaded from: classes2.dex */
public class C5200w extends AbstractC5183h {

    /* renamed from: a */
    private static final String f22035a = "HttpClient";

    /* renamed from: b */
    private final AbstractC5278b f22036b;

    /* renamed from: c */
    private final AbstractC5125d f22037c;

    /* renamed from: d */
    private final HttpRoutePlanner f22038d;

    /* renamed from: e */
    private final AbstractC5086b<AbstractC5135b> f22039e;

    /* renamed from: f */
    private final AbstractC5086b<AbstractC5011c> f22040f;

    /* renamed from: g */
    private final CookieStore f22041g;

    /* renamed from: h */
    private final CredentialsProvider f22042h;

    /* renamed from: i */
    private final C5019c f22043i;

    /* renamed from: j */
    private final List<Closeable> f22044j;

    public C5200w(AbstractC5278b abstractC5278b, AbstractC5125d abstractC5125d, HttpRoutePlanner httpRoutePlanner, AbstractC5086b<AbstractC5135b> abstractC5086b, AbstractC5086b<AbstractC5011c> abstractC5086b2, CookieStore cookieStore, CredentialsProvider credentialsProvider, C5019c c5019c, List<Closeable> list) {
        C5351a.m1321a(abstractC5278b, "HTTP client exec chain");
        C5351a.m1321a(abstractC5125d, "HTTP connection manager");
        C5351a.m1321a(httpRoutePlanner, "HTTP route planner");
        this.f22036b = abstractC5278b;
        this.f22037c = abstractC5125d;
        this.f22038d = httpRoutePlanner;
        this.f22039e = abstractC5086b;
        this.f22040f = abstractC5086b2;
        this.f22041g = cookieStore;
        this.f22042h = credentialsProvider;
        this.f22043i = c5019c;
        this.f22044j = list;
    }

    /* renamed from: a */
    private void m1666a(C5057a c5057a) {
        if (c5057a.getAttribute(C5057a.f21574i) == null) {
            c5057a.setAttribute(C5057a.f21574i, new C5012d());
        }
        if (c5057a.getAttribute(C5057a.f21575j) == null) {
            c5057a.setAttribute(C5057a.f21575j, new C5012d());
        }
        if (c5057a.getAttribute(C5057a.f21577l) == null) {
            c5057a.setAttribute(C5057a.f21577l, this.f22040f);
        }
        if (c5057a.getAttribute(C5057a.f21568c) == null) {
            c5057a.setAttribute(C5057a.f21568c, this.f22039e);
        }
        if (c5057a.getAttribute(C5057a.f21571f) == null) {
            c5057a.setAttribute(C5057a.f21571f, this.f22041g);
        }
        if (c5057a.getAttribute(C5057a.f21572g) == null) {
            c5057a.setAttribute(C5057a.f21572g, this.f22042h);
        }
        if (c5057a.getAttribute(C5057a.f21578m) == null) {
            c5057a.setAttribute(C5057a.f21578m, this.f22043i);
        }
    }

    /* renamed from: c */
    private HttpRoute m1664c(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.f22038d.determineRoute(httpHost == null ? (HttpHost) httpRequest.getParams().getParameter("http.default-host") : httpHost, httpRequest, httpContext);
    }

    @Override // org.p248a.p249a.p268i.p270b.AbstractC5183h
    /* renamed from: a */
    protected AbstractC5035b mo1661a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(httpRequest, "HTTP request");
        AbstractC5039f abstractC5039f = httpRequest instanceof AbstractC5039f ? (AbstractC5039f) httpRequest : null;
        try {
            HttpRequest m2221a = C5047n.m2221a(httpRequest);
            if (httpContext == null) {
                httpContext = new C5339a();
            }
            C5057a m2176a = C5057a.m2176a(httpContext);
            C5019c mo2224l_ = httpRequest instanceof AbstractC5036c ? ((AbstractC5036c) httpRequest).mo2224l_() : null;
            if (mo2224l_ == null) {
                mo2224l_ = C5055a.m2185a(httpRequest.getParams());
            }
            if (mo2224l_ != null) {
                m2176a.m2181a(mo2224l_);
            }
            m1666a(m2176a);
            return this.f22036b.mo1511a(m1664c(httpHost, m2221a, m2176a), m2221a, m2176a, abstractC5039f);
        } catch (HttpException e) {
            throw new ClientProtocolException(e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22037c.mo1603b();
        if (this.f22044j != null) {
            for (Closeable closeable : this.f22044j) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    Log.e(f22035a, e.getMessage(), e);
                }
            }
        }
    }

    public ClientConnectionManager getConnectionManager() {
        return new ClientConnectionManager() { // from class: org.a.a.i.b.w.1
            public void closeExpiredConnections() {
                C5200w.this.f22037c.mo1618a();
            }

            public void closeIdleConnections(long j, TimeUnit timeUnit) {
                C5200w.this.f22037c.mo1617a(j, timeUnit);
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
                C5200w.this.f22037c.mo1603b();
            }
        };
    }

    public HttpParams getParams() {
        throw new UnsupportedOperationException();
    }
}
