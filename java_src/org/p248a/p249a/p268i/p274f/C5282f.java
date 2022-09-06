package org.p248a.p249a.p268i.p274f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p252c.p257e.C5061e;
import org.p248a.p249a.p252c.p258f.C5077i;
import org.p248a.p249a.p261f.AbstractC5094a;
import org.p248a.p249a.p261f.AbstractC5125d;
import org.p248a.p249a.p268i.p271c.C5212e;
import org.p248a.p249a.p281n.C5341c;
import org.p248a.p249a.p281n.C5344f;
import org.p248a.p249a.p281n.C5346h;
import org.p248a.p249a.p281n.C5348j;
import org.p248a.p249a.p281n.C5349k;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5357g;
@AbstractC5005b
/* renamed from: org.a.a.i.f.f */
/* loaded from: classes2.dex */
public class C5282f implements AbstractC5278b {

    /* renamed from: a */
    private final HttpRequestExecutor f22214a;

    /* renamed from: b */
    private final AbstractC5125d f22215b;

    /* renamed from: c */
    private final ConnectionReuseStrategy f22216c;

    /* renamed from: d */
    private final ConnectionKeepAliveStrategy f22217d;

    /* renamed from: e */
    private final HttpProcessor f22218e = new C5344f(new C5346h(), new C5348j(), new C5061e(), new C5349k(C5357g.m1293a("Apache-HttpClient", "org.apache.http.client", getClass())));

    public C5282f(HttpRequestExecutor httpRequestExecutor, AbstractC5125d abstractC5125d, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        C5351a.m1321a(httpRequestExecutor, "HTTP request executor");
        C5351a.m1321a(abstractC5125d, "Client connection manager");
        C5351a.m1321a(connectionReuseStrategy, "Connection reuse strategy");
        C5351a.m1321a(connectionKeepAliveStrategy, "Connection keep alive strategy");
        this.f22214a = httpRequestExecutor;
        this.f22215b = abstractC5125d;
        this.f22216c = connectionReuseStrategy;
        this.f22217d = connectionKeepAliveStrategy;
    }

    /* renamed from: a */
    static void m1521a(C5047n c5047n, HttpRoute httpRoute) {
        try {
            URI uri = c5047n.getURI();
            if (uri == null) {
                return;
            }
            c5047n.m2222a(uri.isAbsolute() ? C5077i.m2098a(uri, (HttpHost) null, true) : C5077i.m2103a(uri));
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid URI: " + c5047n.getRequestLine().getUri(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1 A[Catch: e -> 0x005a, HttpException -> 0x012c, IOException -> 0x0137, RuntimeException -> 0x013c, TryCatch #3 {IOException -> 0x0137, e -> 0x005a, HttpException -> 0x012c, RuntimeException -> 0x013c, blocks: (B:47:0x0049, B:49:0x004f, B:50:0x0059, B:51:0x0088, B:17:0x008b, B:19:0x0091, B:21:0x0099, B:23:0x00a1, B:25:0x00a7, B:26:0x00aa, B:28:0x00b2, B:30:0x00be, B:32:0x00d1, B:33:0x00d5, B:35:0x0101, B:36:0x010f, B:38:0x0115, B:40:0x0131, B:42:0x011b, B:44:0x0128), top: B:46:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0101 A[Catch: e -> 0x005a, HttpException -> 0x012c, IOException -> 0x0137, RuntimeException -> 0x013c, TryCatch #3 {IOException -> 0x0137, e -> 0x005a, HttpException -> 0x012c, RuntimeException -> 0x013c, blocks: (B:47:0x0049, B:49:0x004f, B:50:0x0059, B:51:0x0088, B:17:0x008b, B:19:0x0091, B:21:0x0099, B:23:0x00a1, B:25:0x00a7, B:26:0x00aa, B:28:0x00b2, B:30:0x00be, B:32:0x00d1, B:33:0x00d5, B:35:0x0101, B:36:0x010f, B:38:0x0115, B:40:0x0131, B:42:0x011b, B:44:0x0128), top: B:46:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128 A[Catch: e -> 0x005a, HttpException -> 0x012c, IOException -> 0x0137, RuntimeException -> 0x013c, TRY_LEAVE, TryCatch #3 {IOException -> 0x0137, e -> 0x005a, HttpException -> 0x012c, RuntimeException -> 0x013c, blocks: (B:47:0x0049, B:49:0x004f, B:50:0x0059, B:51:0x0088, B:17:0x008b, B:19:0x0091, B:21:0x0099, B:23:0x00a1, B:25:0x00a7, B:26:0x00aa, B:28:0x00b2, B:30:0x00be, B:32:0x00d1, B:33:0x00d5, B:35:0x0101, B:36:0x010f, B:38:0x0115, B:40:0x0131, B:42:0x011b, B:44:0x0128), top: B:46:0x0049 }] */
    @Override // org.p248a.p249a.p268i.p274f.AbstractC5278b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC5035b mo1511a(HttpRoute httpRoute, C5047n c5047n, C5057a c5057a, AbstractC5039f abstractC5039f) {
        Object obj;
        HttpResponse execute;
        HttpEntity entity;
        C5351a.m1321a(httpRoute, "HTTP route");
        C5351a.m1321a(c5047n, "HTTP request");
        C5351a.m1321a(c5057a, "HTTP context");
        m1521a(c5047n, httpRoute);
        AbstractC5094a mo1604a = this.f22215b.mo1604a(httpRoute, (Object) null);
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
            C5279c c5279c = new C5279c(this.f22215b, mo1594a);
            if (abstractC5039f != null) {
                try {
                    if (abstractC5039f.isAborted()) {
                        c5279c.close();
                        throw new C5285i("Request aborted");
                    }
                    abstractC5039f.mo2231a(c5279c);
                } catch (IOException e) {
                    c5279c.abortConnection();
                    throw e;
                } catch (C5212e e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e2);
                    throw interruptedIOException;
                } catch (HttpException e3) {
                    c5279c.abortConnection();
                    throw e3;
                } catch (RuntimeException e4) {
                    c5279c.abortConnection();
                    throw e4;
                }
            }
            if (!mo1594a.isOpen()) {
                int m2281n = m2161n.m2281n();
                AbstractC5125d abstractC5125d = this.f22215b;
                if (m2281n <= 0) {
                    m2281n = 0;
                }
                abstractC5125d.mo1611a(mo1594a, httpRoute, m2281n, c5057a);
                this.f22215b.mo1602b(mo1594a, httpRoute, c5057a);
            }
            int m2280o = m2161n.m2280o();
            if (m2280o >= 0) {
                mo1594a.setSocketTimeout(m2280o);
            }
            HttpUriRequest m2223a = c5047n.m2223a();
            if (m2223a instanceof HttpUriRequest) {
                URI uri = m2223a.getURI();
                if (uri.isAbsolute()) {
                    obj = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
                    if (obj == null) {
                        obj = httpRoute.getTargetHost();
                    }
                    c5057a.setAttribute(C5341c.f22386q, obj);
                    c5057a.setAttribute(C5341c.f22384o, c5047n);
                    c5057a.setAttribute(C5341c.f22383n, mo1594a);
                    c5057a.setAttribute(C5057a.f21566a, httpRoute);
                    this.f22218e.process(c5047n, c5057a);
                    execute = this.f22214a.execute(c5047n, mo1594a, c5057a);
                    this.f22218e.process(execute, c5057a);
                    if (!this.f22216c.keepAlive(execute, c5057a)) {
                        c5279c.m1531a(this.f22217d.getKeepAliveDuration(execute, c5057a), TimeUnit.MILLISECONDS);
                        c5279c.m1528c();
                    } else {
                        c5279c.m1527d();
                    }
                    entity = execute.getEntity();
                    if (entity == null && entity.isStreaming()) {
                        return new C5280d(execute, c5279c);
                    }
                    c5279c.releaseConnection();
                    return new C5280d(execute, null);
                }
            }
            obj = null;
            if (obj == null) {
            }
            c5057a.setAttribute(C5341c.f22386q, obj);
            c5057a.setAttribute(C5341c.f22384o, c5047n);
            c5057a.setAttribute(C5341c.f22383n, mo1594a);
            c5057a.setAttribute(C5057a.f21566a, httpRoute);
            this.f22218e.process(c5047n, c5057a);
            execute = this.f22214a.execute(c5047n, mo1594a, c5057a);
            this.f22218e.process(execute, c5057a);
            if (!this.f22216c.keepAlive(execute, c5057a)) {
            }
            entity = execute.getEntity();
            if (entity == null) {
            }
            c5279c.releaseConnection();
            return new C5280d(execute, null);
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            throw new C5285i("Request aborted", e5);
        } catch (ExecutionException e6) {
            e = e6;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new C5285i("Request execution failed", e);
        }
    }
}
