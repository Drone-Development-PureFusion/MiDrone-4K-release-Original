package org.p248a.p249a.p268i.p270b;

import java.net.Socket;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p251b.C5012d;
import org.p248a.p249a.p252c.p253a.C5017a;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p256d.C5055a;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p252c.p257e.C5061e;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p261f.AbstractC5127e;
import org.p248a.p249a.p261f.AbstractC5130h;
import org.p248a.p249a.p267h.C5138c;
import org.p248a.p249a.p268i.C5291g;
import org.p248a.p249a.p268i.p269a.C5148b;
import org.p248a.p249a.p268i.p269a.C5150d;
import org.p248a.p249a.p268i.p269a.C5152f;
import org.p248a.p249a.p268i.p269a.C5163i;
import org.p248a.p249a.p268i.p271c.C5224q;
import org.p248a.p249a.p268i.p274f.C5290n;
import org.p248a.p249a.p279l.C5324a;
import org.p248a.p249a.p281n.C5339a;
import org.p248a.p249a.p281n.C5341c;
import org.p248a.p249a.p281n.C5344f;
import org.p248a.p249a.p281n.C5348j;
import org.p248a.p249a.p281n.C5349k;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5354d;
/* renamed from: org.a.a.i.b.ac */
/* loaded from: classes.dex */
public class C5171ac {

    /* renamed from: a */
    private final AbstractC5127e<HttpRoute, AbstractC5130h> f21927a;

    /* renamed from: b */
    private final C5084a f21928b;

    /* renamed from: c */
    private final C5019c f21929c;

    /* renamed from: d */
    private final HttpProcessor f21930d;

    /* renamed from: e */
    private final HttpRequestExecutor f21931e;

    /* renamed from: f */
    private final C5170ab f21932f;

    /* renamed from: g */
    private final C5152f f21933g;

    /* renamed from: h */
    private final C5012d f21934h;

    /* renamed from: i */
    private final AuthSchemeRegistry f21935i;

    /* renamed from: j */
    private final ConnectionReuseStrategy f21936j;

    public C5171ac() {
        this(null, null, null);
    }

    public C5171ac(C5019c c5019c) {
        this(null, null, c5019c);
    }

    public C5171ac(AbstractC5127e<HttpRoute, AbstractC5130h> abstractC5127e, C5084a c5084a, C5019c c5019c) {
        this.f21927a = abstractC5127e == null ? C5224q.f22101a : abstractC5127e;
        this.f21928b = c5084a == null ? C5084a.f21692a : c5084a;
        this.f21929c = c5019c == null ? C5019c.f21485a : c5019c;
        this.f21930d = new C5344f(new C5348j(), new C5061e(), new C5349k());
        this.f21931e = new HttpRequestExecutor();
        this.f21932f = new C5170ab();
        this.f21933g = new C5152f();
        this.f21934h = new C5012d();
        this.f21935i = new AuthSchemeRegistry();
        this.f21935i.register(C5017a.f21475a, new C5148b());
        this.f21935i.register(C5017a.f21476b, new C5150d());
        this.f21935i.register(C5017a.f21477c, new C5163i());
        this.f21936j = new C5291g();
    }

    @Deprecated
    public C5171ac(HttpParams httpParams) {
        this(null, C5324a.m1426c(httpParams), C5055a.m2185a(httpParams));
    }

    /* renamed from: a */
    public Socket m1796a(HttpHost httpHost, HttpHost httpHost2, Credentials credentials) {
        HttpResponse execute;
        C5351a.m1321a(httpHost, "Proxy host");
        C5351a.m1321a(httpHost2, "Target host");
        C5351a.m1321a(credentials, "Credentials");
        HttpHost httpHost3 = httpHost2.getPort() <= 0 ? new HttpHost(httpHost2.getHostName(), 80, httpHost2.getSchemeName()) : httpHost2;
        HttpRoute httpRoute = new HttpRoute(httpHost3, this.f21929c.m2292c(), httpHost, false, RouteInfo.TunnelType.TUNNELLED, RouteInfo.LayerType.PLAIN);
        AbstractC5130h mo1620a = this.f21927a.mo1620a(httpRoute, this.f21928b);
        C5339a c5339a = new C5339a();
        HttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", httpHost3.toHostString(), HttpVersion.HTTP_1_1);
        C5180e c5180e = new C5180e();
        c5180e.setCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()), credentials);
        c5339a.setAttribute(C5341c.f22386q, httpHost2);
        c5339a.setAttribute(C5341c.f22383n, mo1620a);
        c5339a.setAttribute(C5341c.f22384o, basicHttpRequest);
        c5339a.setAttribute(C5057a.f21566a, httpRoute);
        c5339a.setAttribute(C5057a.f21575j, this.f21934h);
        c5339a.setAttribute(C5057a.f21572g, c5180e);
        c5339a.setAttribute(C5057a.f21577l, this.f21935i);
        c5339a.setAttribute(C5057a.f21578m, this.f21929c);
        this.f21931e.preProcess(basicHttpRequest, this.f21930d, c5339a);
        while (true) {
            if (!mo1620a.isOpen()) {
                mo1620a.mo1644a(new Socket(httpHost.getHostName(), httpHost.getPort()));
            }
            this.f21933g.m1908a(basicHttpRequest, this.f21934h, c5339a);
            execute = this.f21931e.execute(basicHttpRequest, mo1620a, c5339a);
            if (execute.getStatusLine().getStatusCode() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + execute.getStatusLine());
            }
            if (!this.f21933g.m1909a(httpHost, execute, this.f21932f, this.f21934h, c5339a) || !this.f21933g.m1905b(httpHost, execute, this.f21932f, this.f21934h, c5339a)) {
                break;
            }
            if (this.f21936j.keepAlive(execute, c5339a)) {
                C5354d.m1303b(execute.getEntity());
            } else {
                mo1620a.close();
            }
            basicHttpRequest.removeHeaders(C5083e.f21650N);
        }
        if (execute.getStatusLine().getStatusCode() > 299) {
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                execute.setEntity(new C5138c(entity));
            }
            mo1620a.close();
            throw new C5290n("CONNECT refused by proxy: " + execute.getStatusLine(), execute);
        }
        return mo1620a.mo1632b();
    }

    @Deprecated
    /* renamed from: a */
    public HttpParams m1797a() {
        return new BasicHttpParams();
    }

    @Deprecated
    /* renamed from: b */
    public AuthSchemeRegistry m1795b() {
        return this.f21935i;
    }
}
