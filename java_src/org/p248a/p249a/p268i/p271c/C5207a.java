package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import com.facebook.common.util.UriUtil;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.LangUtils;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5004a;
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
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
@AbstractC5007d
/* renamed from: org.a.a.i.c.a */
/* loaded from: classes2.dex */
public class C5207a implements Closeable, AbstractC5125d {

    /* renamed from: a */
    private static final String f22054a = "HttpClient";

    /* renamed from: b */
    private final C5219l f22055b;

    /* renamed from: c */
    private final AbstractC5127e<HttpRoute, AbstractC5130h> f22056c;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: d */
    private AbstractC5130h f22057d;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: e */
    private HttpRoute f22058e;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: f */
    private Object f22059f;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: g */
    private long f22060g;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: h */
    private long f22061h;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: i */
    private boolean f22062i;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: j */
    private C5091f f22063j;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: k */
    private C5084a f22064k;

    /* renamed from: l */
    private final AtomicBoolean f22065l;

    public C5207a() {
        this(m1653g(), null, null, null);
    }

    public C5207a(AbstractC5086b<AbstractC5104a> abstractC5086b) {
        this(abstractC5086b, null, null, null);
    }

    public C5207a(AbstractC5086b<AbstractC5104a> abstractC5086b, AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e) {
        this(abstractC5086b, abstractC5127e, null, null);
    }

    public C5207a(AbstractC5086b<AbstractC5104a> abstractC5086b, AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e, AbstractC5131i abstractC5131i, AbstractC5103b abstractC5103b) {
        this.f22055b = new C5219l(abstractC5086b, abstractC5131i, abstractC5103b);
        this.f22056c = abstractC5127e == null ? C5224q.f22101a : abstractC5127e;
        this.f22061h = Long.MAX_VALUE;
        this.f22063j = C5091f.f21712a;
        this.f22064k = C5084a.f21692a;
        this.f22065l = new AtomicBoolean(false);
    }

    /* renamed from: g */
    private static C5089d<AbstractC5104a> m1653g() {
        return C5090e.m2042a().m2041a(UriUtil.HTTP_SCHEME, C5106c.m2018a()).m2041a(UriUtil.HTTPS_SCHEME, C5115g.m1993a()).m2040b();
    }

    /* renamed from: h */
    private void m1652h() {
        if (this.f22057d != null) {
            if (Log.isLoggable(f22054a, 3)) {
                Log.d(f22054a, "Closing connection");
            }
            try {
                this.f22057d.close();
            } catch (IOException e) {
                if (Log.isLoggable(f22054a, 3)) {
                    Log.d(f22054a, "I/O exception closing connection", e);
                }
            }
            this.f22057d = null;
        }
    }

    /* renamed from: i */
    private void m1651i() {
        if (this.f22057d != null) {
            if (Log.isLoggable(f22054a, 3)) {
                Log.d(f22054a, "Shutting down connection");
            }
            try {
                this.f22057d.shutdown();
            } catch (IOException e) {
                if (Log.isLoggable(f22054a, 3)) {
                    Log.d(f22054a, "I/O exception shutting down connection", e);
                }
            }
            this.f22057d = null;
        }
    }

    /* renamed from: j */
    private void m1650j() {
        if (this.f22057d == null || System.currentTimeMillis() < this.f22061h) {
            return;
        }
        if (Log.isLoggable(f22054a, 3)) {
            Log.d(f22054a, "Connection expired @ " + new Date(this.f22061h));
        }
        m1652h();
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public final AbstractC5094a mo1604a(final HttpRoute httpRoute, final Object obj) {
        C5351a.m1321a(httpRoute, "Route");
        return new AbstractC5094a() { // from class: org.a.a.i.c.a.1
            @Override // org.p248a.p249a.p261f.AbstractC5094a
            /* renamed from: a */
            public HttpClientConnection mo1594a(long j, TimeUnit timeUnit) {
                return C5207a.this.m1658b(httpRoute, obj);
            }

            @Override // org.p248a.p249a.p259d.AbstractC5081b
            /* renamed from: a */
            public boolean mo1532a() {
                return false;
            }
        };
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public synchronized void mo1618a() {
        if (!this.f22065l.get() && !this.f22062i) {
            m1650j();
        }
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public synchronized void mo1617a(long j, TimeUnit timeUnit) {
        long j2 = 0;
        synchronized (this) {
            C5351a.m1321a(timeUnit, "Time unit");
            if (!this.f22065l.get() && !this.f22062i) {
                long millis = timeUnit.toMillis(j);
                if (millis >= 0) {
                    j2 = millis;
                }
                if (this.f22060g <= System.currentTimeMillis() - j2) {
                    m1652h();
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void m1660a(C5084a c5084a) {
        if (c5084a == null) {
            c5084a = C5084a.f21692a;
        }
        this.f22064k = c5084a;
    }

    /* renamed from: a */
    public synchronized void m1659a(C5091f c5091f) {
        if (c5091f == null) {
            c5091f = C5091f.f21712a;
        }
        this.f22063j = c5091f;
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public synchronized void mo1612a(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit) {
        boolean z = false;
        synchronized (this) {
            C5351a.m1321a(httpClientConnection, C5083e.f21675j);
            if (httpClientConnection == this.f22057d) {
                z = true;
            }
            C5352b.m1312a(z, "Connection not obtained from this manager");
            if (Log.isLoggable(f22054a, 3)) {
                Log.d(f22054a, "Releasing connection " + httpClientConnection);
            }
            if (!this.f22065l.get()) {
                this.f22060g = System.currentTimeMillis();
                if (!this.f22057d.isOpen()) {
                    this.f22057d = null;
                    this.f22058e = null;
                    this.f22057d = null;
                    this.f22061h = Long.MAX_VALUE;
                } else {
                    this.f22059f = obj;
                    if (Log.isLoggable(f22054a, 3)) {
                        Log.d(f22054a, "Connection can be kept alive " + (j > 0 ? "for " + j + " " + timeUnit : "indefinitely"));
                    }
                    if (j > 0) {
                        this.f22061h = this.f22060g + timeUnit.toMillis(j);
                    } else {
                        this.f22061h = Long.MAX_VALUE;
                    }
                }
                this.f22062i = false;
            }
        }
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public void mo1611a(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) {
        C5351a.m1321a(httpClientConnection, C5083e.f21675j);
        C5351a.m1321a(httpRoute, "HTTP route");
        C5352b.m1312a(httpClientConnection == this.f22057d, "Connection not obtained from this manager");
        this.f22055b.m1628a(this.f22057d, httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost(), httpRoute.getLocalAddress() != null ? new InetSocketAddress(httpRoute.getLocalAddress(), 0) : null, i, this.f22063j, httpContext);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: a */
    public void mo1610a(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) {
        C5351a.m1321a(httpClientConnection, C5083e.f21675j);
        C5351a.m1321a(httpRoute, "HTTP route");
        C5352b.m1312a(httpClientConnection == this.f22057d, "Connection not obtained from this manager");
        this.f22055b.m1627a(this.f22057d, httpRoute.getTargetHost(), httpContext);
    }

    /* renamed from: b */
    synchronized HttpClientConnection m1658b(HttpRoute httpRoute, Object obj) {
        AbstractC5130h abstractC5130h;
        boolean z = true;
        synchronized (this) {
            C5352b.m1312a(!this.f22065l.get(), "Connection manager has been shut down");
            if (Log.isLoggable(f22054a, 3)) {
                Log.d(f22054a, "Get connection for route " + httpRoute);
            }
            if (this.f22062i) {
                z = false;
            }
            C5352b.m1312a(z, "Connection is still allocated");
            if (!LangUtils.equals(this.f22058e, httpRoute) || !LangUtils.equals(this.f22059f, obj)) {
                m1652h();
            }
            this.f22058e = httpRoute;
            this.f22059f = obj;
            m1650j();
            if (this.f22057d == null) {
                this.f22057d = this.f22056c.mo1620a(httpRoute, this.f22064k);
            }
            this.f22062i = true;
            abstractC5130h = this.f22057d;
        }
        return abstractC5130h;
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: b */
    public synchronized void mo1603b() {
        if (this.f22065l.compareAndSet(false, true)) {
            m1651i();
        }
    }

    @Override // org.p248a.p249a.p261f.AbstractC5125d
    /* renamed from: b */
    public void mo1602b(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) {
    }

    /* renamed from: c */
    HttpRoute m1657c() {
        return this.f22058e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        mo1603b();
    }

    /* renamed from: d */
    Object m1656d() {
        return this.f22059f;
    }

    /* renamed from: e */
    public synchronized C5091f m1655e() {
        return this.f22063j;
    }

    /* renamed from: f */
    public synchronized C5084a m1654f() {
        return this.f22064k;
    }

    protected void finalize() {
        try {
            mo1603b();
        } finally {
            super.finalize();
        }
    }
}
