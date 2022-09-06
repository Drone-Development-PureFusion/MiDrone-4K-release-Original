package org.p248a.p249a.p268i.p274f;

import android.util.Log;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p251b.C5012d;
import org.p248a.p249a.p251b.EnumC5010b;
import org.p248a.p249a.p252c.AbstractC5021b;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p252c.p257e.C5061e;
import org.p248a.p249a.p261f.AbstractC5094a;
import org.p248a.p249a.p261f.AbstractC5125d;
import org.p248a.p249a.p267h.C5138c;
import org.p248a.p249a.p268i.p269a.C5152f;
import org.p248a.p249a.p268i.p271c.C5212e;
import org.p248a.p249a.p281n.C5341c;
import org.p248a.p249a.p281n.C5344f;
import org.p248a.p249a.p281n.C5348j;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5354d;
@AbstractC5005b
/* renamed from: org.a.a.i.f.e */
/* loaded from: classes2.dex */
public class C5281e implements AbstractC5278b {

    /* renamed from: a */
    private static final String f22203a = "HttpClient";

    /* renamed from: b */
    private final HttpRequestExecutor f22204b;

    /* renamed from: c */
    private final AbstractC5125d f22205c;

    /* renamed from: d */
    private final ConnectionReuseStrategy f22206d;

    /* renamed from: e */
    private final ConnectionKeepAliveStrategy f22207e;

    /* renamed from: g */
    private final AbstractC5021b f22209g;

    /* renamed from: h */
    private final AbstractC5021b f22210h;

    /* renamed from: j */
    private final UserTokenHandler f22212j;

    /* renamed from: i */
    private final C5152f f22211i = new C5152f();

    /* renamed from: f */
    private final HttpProcessor f22208f = new C5344f(new C5348j(), new C5061e());

    /* renamed from: k */
    private final HttpRouteDirector f22213k = new BasicRouteDirector();

    public C5281e(HttpRequestExecutor httpRequestExecutor, AbstractC5125d abstractC5125d, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AbstractC5021b abstractC5021b, AbstractC5021b abstractC5021b2, UserTokenHandler userTokenHandler) {
        C5351a.m1321a(httpRequestExecutor, "HTTP request executor");
        C5351a.m1321a(abstractC5125d, "Client connection manager");
        C5351a.m1321a(connectionReuseStrategy, "Connection reuse strategy");
        C5351a.m1321a(connectionKeepAliveStrategy, "Connection keep alive strategy");
        C5351a.m1321a(abstractC5021b, "Target authentication strategy");
        C5351a.m1321a(abstractC5021b2, "Proxy authentication strategy");
        C5351a.m1321a(userTokenHandler, "User token handler");
        this.f22204b = httpRequestExecutor;
        this.f22205c = abstractC5125d;
        this.f22206d = connectionReuseStrategy;
        this.f22207e = connectionKeepAliveStrategy;
        this.f22209g = abstractC5021b;
        this.f22210h = abstractC5021b2;
        this.f22212j = userTokenHandler;
    }

    /* renamed from: a */
    private boolean m1525a(C5012d c5012d, C5012d c5012d2, HttpRoute httpRoute, HttpResponse httpResponse, C5057a c5057a) {
        if (c5057a.m2161n().m2285j()) {
            HttpHost t = c5057a.t();
            if (t == null) {
                t = httpRoute.getTargetHost();
            }
            HttpHost httpHost = t.getPort() < 0 ? new HttpHost(t.getHostName(), httpRoute.getTargetHost().getPort(), t.getSchemeName()) : t;
            boolean m1909a = this.f22211i.m1909a(httpHost, httpResponse, this.f22209g, c5012d, c5057a);
            HttpHost proxyHost = httpRoute.getProxyHost();
            if (proxyHost == null) {
                proxyHost = httpRoute.getTargetHost();
            }
            boolean m1909a2 = this.f22211i.m1909a(proxyHost, httpResponse, this.f22210h, c5012d2, c5057a);
            if (m1909a) {
                return this.f22211i.m1905b(httpHost, httpResponse, this.f22209g, c5012d, c5057a);
            }
            if (m1909a2) {
                return this.f22211i.m1905b(proxyHost, httpResponse, this.f22210h, c5012d2, c5057a);
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m1523a(HttpRoute httpRoute, int i, C5057a c5057a) {
        throw new HttpException("Proxy chains are not supported.");
    }

    /* renamed from: b */
    private boolean m1522b(C5012d c5012d, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, C5057a c5057a) {
        C5019c m2161n = c5057a.m2161n();
        int m2281n = m2161n.m2281n();
        HttpHost targetHost = httpRoute.getTargetHost();
        HttpHost proxyHost = httpRoute.getProxyHost();
        HttpResponse httpResponse = null;
        HttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", targetHost.toHostString(), httpRequest.getProtocolVersion());
        this.f22204b.preProcess(basicHttpRequest, this.f22208f, c5057a);
        while (httpResponse == null) {
            if (!httpClientConnection.isOpen()) {
                this.f22205c.mo1611a(httpClientConnection, httpRoute, m2281n > 0 ? m2281n : 0, c5057a);
            }
            basicHttpRequest.removeHeaders(C5083e.f21650N);
            this.f22211i.m1908a(basicHttpRequest, c5012d, c5057a);
            httpResponse = this.f22204b.execute(basicHttpRequest, httpClientConnection, c5057a);
            if (httpResponse.getStatusLine().getStatusCode() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + httpResponse.getStatusLine());
            }
            if (m2161n.m2285j() && this.f22211i.m1909a(proxyHost, httpResponse, this.f22210h, c5012d, c5057a) && this.f22211i.m1905b(proxyHost, httpResponse, this.f22210h, c5012d, c5057a)) {
                if (this.f22206d.keepAlive(httpResponse, c5057a)) {
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Connection kept alive");
                    }
                    C5354d.m1303b(httpResponse.getEntity());
                } else {
                    httpClientConnection.close();
                }
                httpResponse = null;
            }
        }
        if (httpResponse.getStatusLine().getStatusCode() > 299) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                httpResponse.setEntity(new C5138c(entity));
            }
            httpClientConnection.close();
            throw new C5290n("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
        }
        return false;
    }

    @Override // org.p248a.p249a.p268i.p274f.AbstractC5278b
    /* renamed from: a */
    public AbstractC5035b mo1511a(HttpRoute httpRoute, C5047n c5047n, C5057a c5057a, AbstractC5039f abstractC5039f) {
        C5012d c5012d;
        HttpResponse execute;
        Object obj;
        C5351a.m1321a(httpRoute, "HTTP route");
        C5351a.m1321a(c5047n, "HTTP request");
        C5351a.m1321a(c5057a, "HTTP context");
        C5012d m2164k = c5057a.m2164k();
        if (m2164k == null) {
            C5012d c5012d2 = new C5012d();
            c5057a.setAttribute(C5057a.f21574i, c5012d2);
            c5012d = c5012d2;
        } else {
            c5012d = m2164k;
        }
        C5012d m2163l = c5057a.m2163l();
        if (m2163l == null) {
            m2163l = new C5012d();
            c5057a.setAttribute(C5057a.f21575j, m2163l);
        }
        if (c5047n instanceof HttpEntityEnclosingRequest) {
            C5286j.m1517a((HttpEntityEnclosingRequest) c5047n);
        }
        Object m2162m = c5057a.m2162m();
        AbstractC5094a mo1604a = this.f22205c.mo1604a(httpRoute, m2162m);
        if (abstractC5039f != null) {
            if (abstractC5039f.isAborted()) {
                mo1604a.a();
                throw new C5285i("Request aborted");
            }
            abstractC5039f.mo2231a(mo1604a);
        }
        C5019c m2161n = c5057a.m2161n();
        try {
            int m2282m = m2161n.m2282m();
            HttpClientConnection mo1594a = mo1604a.mo1594a(m2282m > 0 ? m2282m : 0L, TimeUnit.MILLISECONDS);
            c5057a.setAttribute(C5341c.f22383n, mo1594a);
            if (m2161n.m2291d() && mo1594a.isOpen()) {
                if (Log.isLoggable(f22203a, 3)) {
                    Log.d(f22203a, "Stale connection check");
                }
                if (mo1594a.isStale()) {
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Stale connection detected");
                    }
                    mo1594a.close();
                }
            }
            C5279c c5279c = new C5279c(this.f22205c, mo1594a);
            if (abstractC5039f != null) {
                try {
                    abstractC5039f.mo2231a(c5279c);
                } catch (C5212e e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e);
                    throw interruptedIOException;
                } catch (HttpException e2) {
                    c5279c.abortConnection();
                    throw e2;
                } catch (IOException e3) {
                    c5279c.abortConnection();
                    throw e3;
                } catch (RuntimeException e4) {
                    c5279c.abortConnection();
                    throw e4;
                }
            }
            int i = 1;
            while (true) {
                if (i > 1 && !C5286j.m1516a((HttpRequest) c5047n)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (abstractC5039f != null && abstractC5039f.isAborted()) {
                    throw new C5285i("Request aborted");
                }
                if (!mo1594a.isOpen()) {
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Opening connection " + httpRoute);
                    }
                    try {
                        m1524a(m2163l, mo1594a, httpRoute, (HttpRequest) c5047n, c5057a);
                    } catch (C5290n e5) {
                        if (Log.isLoggable(f22203a, 3)) {
                            Log.d(f22203a, e5.getMessage());
                        }
                        execute = e5.m1510a();
                        if (m2162m == null) {
                            obj = this.f22212j.getUserToken(c5057a);
                            c5057a.setAttribute(C5057a.f21576k, obj);
                        } else {
                            obj = m2162m;
                        }
                        if (obj != null) {
                            c5279c.m1530a(obj);
                        }
                        HttpEntity entity = execute.getEntity();
                        if (entity != null && entity.isStreaming()) {
                            return new C5280d(execute, c5279c);
                        }
                        c5279c.releaseConnection();
                        return new C5280d(execute, null);
                    }
                }
                int m2280o = m2161n.m2280o();
                if (m2280o >= 0) {
                    mo1594a.setSocketTimeout(m2280o);
                }
                if (abstractC5039f != null && abstractC5039f.isAborted()) {
                    throw new C5285i("Request aborted");
                }
                if (Log.isLoggable(f22203a, 3)) {
                    Log.d(f22203a, "Executing request " + c5047n.getRequestLine());
                }
                if (!c5047n.containsHeader("Authorization")) {
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Target auth state: " + c5012d.m2303b());
                    }
                    this.f22211i.m1908a(c5047n, c5012d, c5057a);
                }
                if (!c5047n.containsHeader(C5083e.f21650N) && !httpRoute.isTunnelled()) {
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Proxy auth state: " + m2163l.m2303b());
                    }
                    this.f22211i.m1908a(c5047n, m2163l, c5057a);
                }
                execute = this.f22204b.execute(c5047n, mo1594a, c5057a);
                if (this.f22206d.keepAlive(execute, c5057a)) {
                    long keepAliveDuration = this.f22207e.getKeepAliveDuration(execute, c5057a);
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Connection can be kept alive " + (keepAliveDuration > 0 ? "for " + keepAliveDuration + " " + TimeUnit.MILLISECONDS : "indefinitely"));
                    }
                    c5279c.m1531a(keepAliveDuration, TimeUnit.MILLISECONDS);
                    c5279c.m1528c();
                } else {
                    c5279c.m1527d();
                }
                if (!m1525a(c5012d, m2163l, httpRoute, execute, c5057a)) {
                    break;
                }
                HttpEntity entity2 = execute.getEntity();
                if (c5279c.m1529b()) {
                    C5354d.m1303b(entity2);
                } else {
                    mo1594a.close();
                    if (m2163l.m2303b() == EnumC5010b.SUCCESS && m2163l.m2302c() != null && m2163l.m2302c().isConnectionBased()) {
                        if (Log.isLoggable(f22203a, 3)) {
                            Log.d(f22203a, "Resetting proxy auth state");
                        }
                        m2163l.m2310a();
                    }
                    if (c5012d.m2303b() == EnumC5010b.SUCCESS && c5012d.m2302c() != null && c5012d.m2302c().isConnectionBased()) {
                        if (Log.isLoggable(f22203a, 3)) {
                            Log.d(f22203a, "Resetting target auth state");
                        }
                        c5012d.m2310a();
                    }
                }
                HttpRequest m2223a = c5047n.m2223a();
                if (!m2223a.containsHeader("Authorization")) {
                    c5047n.removeHeaders("Authorization");
                }
                if (!m2223a.containsHeader(C5083e.f21650N)) {
                    c5047n.removeHeaders(C5083e.f21650N);
                }
                i++;
            }
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            throw new C5285i("Request aborted", e6);
        } catch (ExecutionException e7) {
            e = e7;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new C5285i("Request execution failed", e);
        }
    }

    /* renamed from: a */
    void m1524a(C5012d c5012d, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, C5057a c5057a) {
        int nextStep;
        int m2281n = c5057a.m2161n().m2281n();
        RouteTracker routeTracker = new RouteTracker(httpRoute);
        do {
            HttpRoute route = routeTracker.toRoute();
            nextStep = this.f22213k.nextStep(httpRoute, route);
            switch (nextStep) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + route);
                case 0:
                    this.f22205c.mo1602b(httpClientConnection, httpRoute, c5057a);
                    continue;
                case 1:
                    this.f22205c.mo1611a(httpClientConnection, httpRoute, m2281n > 0 ? m2281n : 0, c5057a);
                    routeTracker.connectTarget(httpRoute.isSecure());
                    continue;
                case 2:
                    this.f22205c.mo1611a(httpClientConnection, httpRoute, m2281n > 0 ? m2281n : 0, c5057a);
                    routeTracker.connectProxy(httpRoute.getProxyHost(), false);
                    continue;
                case 3:
                    boolean m1522b = m1522b(c5012d, httpClientConnection, httpRoute, httpRequest, c5057a);
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Tunnel to target created.");
                    }
                    routeTracker.tunnelTarget(m1522b);
                    continue;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean m1523a = m1523a(httpRoute, hopCount, c5057a);
                    if (Log.isLoggable(f22203a, 3)) {
                        Log.d(f22203a, "Tunnel to proxy created.");
                    }
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(hopCount), m1523a);
                    continue;
                case 5:
                    this.f22205c.mo1610a(httpClientConnection, httpRoute, c5057a);
                    routeTracker.layerProtocol(httpRoute.isSecure());
                    continue;
                default:
                    throw new IllegalStateException("Unknown step indicator " + nextStep + " from RouteDirector.");
            }
        } while (nextStep > 0);
    }
}
