package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import com.facebook.common.util.UriUtil;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p260e.AbstractC5086b;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p260e.C5089d;
import org.p248a.p249a.p260e.C5090e;
import org.p248a.p249a.p260e.C5091f;
import org.p248a.p249a.p261f.AbstractC5094a;
import org.p248a.p249a.p261f.AbstractC5103b;
import org.p248a.p249a.p261f.AbstractC5125d;
import org.p248a.p249a.p261f.AbstractC5127e;
import org.p248a.p249a.p261f.AbstractC5130h;
import org.p248a.p249a.p261f.AbstractC5131i;
import org.p248a.p249a.p261f.p263b.AbstractC5104a;
import org.p248a.p249a.p261f.p263b.C5106c;
import org.p248a.p249a.p261f.p264c.C5115g;
import org.p248a.p249a.p280m.AbstractC5331b;
import org.p248a.p249a.p280m.AbstractC5333d;
import org.p248a.p249a.p280m.C5337h;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
@AbstractC5007d
/* renamed from: org.a.a.i.c.r */
/* loaded from: classes2.dex */
public class C5225r implements Closeable, AbstractC5125d, AbstractC5333d<HttpRoute> {

    /* renamed from: a */
    private static final String f22105a = "HttpClient";

    /* renamed from: b */
    private final C5227a f22106b;

    /* renamed from: c */
    private final C5209b f22107c;

    /* renamed from: d */
    private final C5219l f22108d;

    /* renamed from: e */
    private final AtomicBoolean f22109e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.c.r$a */
    /* loaded from: classes2.dex */
    public static class C5227a {

        /* renamed from: a */
        private final Map<HttpHost, C5091f> f22112a = new ConcurrentHashMap();

        /* renamed from: b */
        private final Map<HttpHost, C5084a> f22113b = new ConcurrentHashMap();

        /* renamed from: c */
        private volatile C5091f f22114c;

        /* renamed from: d */
        private volatile C5084a f22115d;

        C5227a() {
        }

        /* renamed from: a */
        public C5091f m1593a() {
            return this.f22114c;
        }

        /* renamed from: a */
        public C5091f m1590a(HttpHost httpHost) {
            return this.f22112a.get(httpHost);
        }

        /* renamed from: a */
        public void m1592a(C5084a c5084a) {
            this.f22115d = c5084a;
        }

        /* renamed from: a */
        public void m1591a(C5091f c5091f) {
            this.f22114c = c5091f;
        }

        /* renamed from: a */
        public void m1589a(HttpHost httpHost, C5084a c5084a) {
            this.f22113b.put(httpHost, c5084a);
        }

        /* renamed from: a */
        public void m1588a(HttpHost httpHost, C5091f c5091f) {
            this.f22112a.put(httpHost, c5091f);
        }

        /* renamed from: b */
        public C5084a m1587b() {
            return this.f22115d;
        }

        /* renamed from: b */
        public C5084a m1586b(HttpHost httpHost) {
            return this.f22113b.get(httpHost);
        }
    }

    /* renamed from: org.a.a.i.c.r$b */
    /* loaded from: classes2.dex */
    static class C5228b implements AbstractC5331b<HttpRoute, AbstractC5130h> {

        /* renamed from: a */
        private final C5227a f22116a;

        /* renamed from: b */
        private final AbstractC5127e<HttpRoute, AbstractC5130h> f22117b;

        C5228b(C5227a c5227a, AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e) {
            this.f22116a = c5227a == null ? new C5227a() : c5227a;
            this.f22117b = abstractC5127e == null ? C5224q.f22101a : abstractC5127e;
        }

        @Override // org.p248a.p249a.p280m.AbstractC5331b
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AbstractC5130h mo1407a(HttpRoute httpRoute) {
            C5084a c5084a = null;
            if (httpRoute.getProxyHost() != null) {
                c5084a = this.f22116a.m1586b(httpRoute.getProxyHost());
            }
            if (c5084a == null) {
                c5084a = this.f22116a.m1586b(httpRoute.getTargetHost());
            }
            if (c5084a == null) {
                c5084a = this.f22116a.m1587b();
            }
            if (c5084a == null) {
                c5084a = C5084a.f21692a;
            }
            return this.f22117b.mo1620a(httpRoute, c5084a);
        }
    }

    public C5225r() {
        this(m1595h());
    }

    public C5225r(long j, TimeUnit timeUnit) {
        this(m1595h(), null, null, null, j, timeUnit);
    }

    public C5225r(C5089d<AbstractC5104a> c5089d) {
        this(c5089d, null, null);
    }

    public C5225r(C5089d<AbstractC5104a> c5089d, AbstractC5103b abstractC5103b) {
        this(c5089d, null, abstractC5103b);
    }

    public C5225r(C5089d<AbstractC5104a> c5089d, AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e) {
        this(c5089d, abstractC5127e, null);
    }

    public C5225r(C5089d<AbstractC5104a> c5089d, AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e, AbstractC5103b abstractC5103b) {
        this(c5089d, abstractC5127e, null, abstractC5103b, -1L, TimeUnit.MILLISECONDS);
    }

    public C5225r(C5089d<AbstractC5104a> c5089d, AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e, AbstractC5131i abstractC5131i, AbstractC5103b abstractC5103b, long j, TimeUnit timeUnit) {
        this.f22106b = new C5227a();
        this.f22107c = new C5209b(new C5228b(this.f22106b, abstractC5127e), 2, 20, j, timeUnit);
        this.f22108d = new C5219l(c5089d, abstractC5131i, abstractC5103b);
        this.f22109e = new AtomicBoolean(false);
    }

    public C5225r(AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e) {
        this(m1595h(), abstractC5127e, null);
    }

    C5225r(C5209b c5209b, AbstractC5086b<AbstractC5104a> abstractC5086b, AbstractC5131i abstractC5131i, AbstractC5103b abstractC5103b) {
        this.f22106b = new C5227a();
        this.f22107c = c5209b;
        this.f22108d = new C5219l(abstractC5086b, abstractC5131i, abstractC5103b);
        this.f22109e = new AtomicBoolean(false);
    }

    /* renamed from: a */
    private String m1613a(C5210c c5210c) {
        StringBuilder sb = new StringBuilder();
        sb.append("[id: ").append(c5210c.g()).append("]");
        sb.append("[route: ").append(c5210c.h()).append("]");
        Object l = c5210c.l();
        if (l != null) {
            sb.append("[state: ").append(l).append("]");
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String m1599b(HttpRoute httpRoute, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("[route: ").append(httpRoute).append("]");
        if (obj != null) {
            sb.append("[state: ").append(obj).append("]");
        }
        return sb.toString();
    }

    /* renamed from: c */
    private String m1598c(HttpRoute httpRoute) {
        StringBuilder sb = new StringBuilder();
        C5337h e = this.f22107c.e();
        C5337h a = this.f22107c.a((C5209b) httpRoute);
        sb.append("[total kept alive: ").append(e.m1377c()).append("; ");
        sb.append("route allocated: ").append(a.m1379a() + a.m1377c());
        sb.append(" of ").append(a.m1376d()).append("; ");
        sb.append("total allocated: ").append(e.m1379a() + e.m1377c());
        sb.append(" of ").append(e.m1376d()).append("]");
        return sb.toString();
    }

    /* renamed from: h */
    private static C5089d<AbstractC5104a> m1595h() {
        return C5090e.m2042a().m2041a(UriUtil.HTTP_SCHEME, C5106c.m2018a()).m2041a(UriUtil.HTTPS_SCHEME, C5115g.m1993a()).m2040b();
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo1400b(HttpRoute httpRoute) {
        return this.f22107c.b((C5209b) httpRoute);
    }

    /* renamed from: a */
    public C5091f m1609a(HttpHost httpHost) {
        return this.f22106b.m1590a(httpHost);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public AbstractC5094a mo1604a(HttpRoute httpRoute, Object obj) {
        C5351a.m1321a(httpRoute, "HTTP route");
        if (Log.isLoggable(f22105a, 3)) {
            Log.d(f22105a, "Connection request: " + m1599b(httpRoute, obj) + m1598c(httpRoute));
        }
        final Future<C5210c> a = this.f22107c.a(httpRoute, obj, null);
        return new AbstractC5094a() { // from class: org.a.a.i.c.r.1
            @Override // org.p248a.p249a.p261f.AbstractC5094a
            /* renamed from: a */
            public HttpClientConnection mo1594a(long j, TimeUnit timeUnit) {
                return C5225r.this.m1616a(a, j, timeUnit);
            }

            @Override // org.p248a.p249a.p259d.AbstractC5081b
            /* renamed from: a */
            public boolean mo1532a() {
                return a.cancel(true);
            }
        };
    }

    /* renamed from: a */
    protected HttpClientConnection m1616a(Future<C5210c> future, long j, TimeUnit timeUnit) {
        try {
            C5210c c5210c = future.get(j, timeUnit);
            if (c5210c == null || future.isCancelled()) {
                throw new InterruptedException();
            }
            C5352b.m1312a(c5210c.i() != null, "Pool entry with no connection");
            if (Log.isLoggable(f22105a, 3)) {
                Log.d(f22105a, "Connection leased: " + m1613a(c5210c) + m1598c(c5210c.h()));
            }
            return C5211d.m1643a(c5210c);
        } catch (TimeoutException e) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public void mo1618a() {
        if (Log.isLoggable(f22105a, 3)) {
            Log.d(f22105a, "Closing expired connections");
        }
        this.f22107c.f();
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: a */
    public void mo1404a(int i) {
        this.f22107c.a(i);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public void mo1617a(long j, TimeUnit timeUnit) {
        if (Log.isLoggable(f22105a, 3)) {
            Log.d(f22105a, "Closing connections idle longer than " + j + " " + timeUnit);
        }
        this.f22107c.a(j, timeUnit);
    }

    /* renamed from: a */
    public void m1615a(C5084a c5084a) {
        this.f22106b.m1592a(c5084a);
    }

    /* renamed from: a */
    public void m1614a(C5091f c5091f) {
        this.f22106b.m1591a(c5091f);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public void mo1612a(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit) {
        boolean z = true;
        C5351a.m1321a(httpClientConnection, "Managed connection");
        synchronized (httpClientConnection) {
            C5210c m1641b = C5211d.m1641b(httpClientConnection);
            if (m1641b == null) {
                return;
            }
            AbstractC5130h i = m1641b.i();
            if (i.isOpen()) {
                m1641b.a(obj);
                if (timeUnit == null) {
                    timeUnit = TimeUnit.MILLISECONDS;
                }
                m1641b.a(j, timeUnit);
                if (Log.isLoggable(f22105a, 3)) {
                    Log.d(f22105a, "Connection " + m1613a(m1641b) + " can be kept alive " + (j > 0 ? "for " + (j / 1000.0d) + " seconds" : "indefinitely"));
                }
            }
            C5209b c5209b = this.f22107c;
            if (!i.isOpen() || !m1641b.m1647b()) {
                z = false;
            }
            c5209b.a((C5209b) m1641b, z);
            if (Log.isLoggable(f22105a, 3)) {
                Log.d(f22105a, "Connection released: " + m1613a(m1641b) + m1598c(m1641b.h()));
            }
        }
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public void mo1611a(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) {
        AbstractC5130h i2;
        C5351a.m1321a(httpClientConnection, "Managed Connection");
        C5351a.m1321a(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            i2 = C5211d.m1642a(httpClientConnection).i();
        }
        HttpHost proxyHost = httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost();
        InetSocketAddress inetSocketAddress = httpRoute.getLocalAddress() != null ? new InetSocketAddress(httpRoute.getLocalAddress(), 0) : null;
        C5091f m1590a = this.f22106b.m1590a(proxyHost);
        if (m1590a == null) {
            m1590a = this.f22106b.m1593a();
        }
        if (m1590a == null) {
            m1590a = C5091f.f21712a;
        }
        this.f22108d.m1628a(i2, proxyHost, inetSocketAddress, i, m1590a, httpContext);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public void mo1610a(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) {
        AbstractC5130h i;
        C5351a.m1321a(httpClientConnection, "Managed Connection");
        C5351a.m1321a(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            i = C5211d.m1642a(httpClientConnection).i();
        }
        this.f22108d.m1627a(i, httpRoute.getTargetHost(), httpContext);
    }

    /* renamed from: a */
    public void m1608a(HttpHost httpHost, C5084a c5084a) {
        this.f22106b.m1589a(httpHost, c5084a);
    }

    /* renamed from: a */
    public void m1607a(HttpHost httpHost, C5091f c5091f) {
        this.f22106b.m1588a(httpHost, c5091f);
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo1402a(HttpRoute httpRoute, int i) {
        this.f22107c.a((C5209b) httpRoute, i);
    }

    /* renamed from: b */
    public C5084a m1601b(HttpHost httpHost) {
        return this.f22106b.m1586b(httpHost);
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public C5337h mo1403a(HttpRoute httpRoute) {
        return this.f22107c.a((C5209b) httpRoute);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: b */
    public void mo1603b() {
        if (this.f22109e.compareAndSet(false, true)) {
            if (Log.isLoggable(f22105a, 3)) {
                Log.d(f22105a, "Connection manager is shutting down");
            }
            try {
                this.f22107c.b();
            } catch (IOException e) {
                Log.d(f22105a, "I/O exception shutting down connection manager", e);
            }
            if (!Log.isLoggable(f22105a, 3)) {
                return;
            }
            Log.d(f22105a, "Connection manager shut down");
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: b */
    public void mo1401b(int i) {
        this.f22107c.b(i);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: b */
    public void mo1602b(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) {
        C5351a.m1321a(httpClientConnection, "Managed Connection");
        C5351a.m1321a(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            C5211d.m1642a(httpClientConnection).m1648a();
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: c */
    public int mo1399c() {
        return this.f22107c.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        mo1603b();
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: d */
    public int mo1398d() {
        return this.f22107c.d();
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: e */
    public C5337h mo1397e() {
        return this.f22107c.e();
    }

    /* renamed from: f */
    public C5091f m1597f() {
        return this.f22106b.m1593a();
    }

    protected void finalize() {
        try {
            mo1603b();
        } finally {
            super.finalize();
        }
    }

    /* renamed from: g */
    public C5084a m1596g() {
        return this.f22106b.m1587b();
    }
}
