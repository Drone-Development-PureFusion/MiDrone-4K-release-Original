package org.p248a.p249a.p268i.p270b;

import android.net.SSLCertificateSocketFactory;
import com.facebook.common.util.UriUtil;
import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p251b.AbstractC5011c;
import org.p248a.p249a.p252c.AbstractC5021b;
import org.p248a.p249a.p252c.AbstractC5031c;
import org.p248a.p249a.p252c.AbstractC5054d;
import org.p248a.p249a.p252c.AbstractC5056e;
import org.p248a.p249a.p252c.AbstractC5066f;
import org.p248a.p249a.p252c.p253a.C5017a;
import org.p248a.p249a.p252c.p253a.C5018b;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p257e.C5058b;
import org.p248a.p249a.p252c.p257e.C5059c;
import org.p248a.p249a.p252c.p257e.C5060d;
import org.p248a.p249a.p252c.p257e.C5061e;
import org.p248a.p249a.p252c.p257e.C5062f;
import org.p248a.p249a.p252c.p257e.C5063g;
import org.p248a.p249a.p252c.p257e.C5064h;
import org.p248a.p249a.p252c.p257e.C5065i;
import org.p248a.p249a.p260e.AbstractC5086b;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p260e.C5090e;
import org.p248a.p249a.p260e.C5091f;
import org.p248a.p249a.p261f.AbstractC5125d;
import org.p248a.p249a.p261f.AbstractC5131i;
import org.p248a.p249a.p261f.p263b.AbstractC5105b;
import org.p248a.p249a.p261f.p263b.C5106c;
import org.p248a.p249a.p261f.p264c.C5115g;
import org.p248a.p249a.p266g.AbstractC5135b;
import org.p248a.p249a.p268i.C5291g;
import org.p248a.p249a.p268i.C5316k;
import org.p248a.p249a.p268i.p269a.C5148b;
import org.p248a.p249a.p268i.p269a.C5150d;
import org.p248a.p249a.p268i.p269a.C5163i;
import org.p248a.p249a.p268i.p271c.C5216i;
import org.p248a.p249a.p268i.p271c.C5217j;
import org.p248a.p249a.p268i.p271c.C5218k;
import org.p248a.p249a.p268i.p271c.C5225r;
import org.p248a.p249a.p268i.p271c.C5230t;
import org.p248a.p249a.p268i.p272d.C5241ag;
import org.p248a.p249a.p268i.p272d.C5253k;
import org.p248a.p249a.p268i.p272d.C5255m;
import org.p248a.p249a.p268i.p272d.C5263r;
import org.p248a.p249a.p268i.p272d.C5266u;
import org.p248a.p249a.p268i.p272d.C5271z;
import org.p248a.p249a.p268i.p274f.AbstractC5278b;
import org.p248a.p249a.p268i.p274f.C5277a;
import org.p248a.p249a.p268i.p274f.C5281e;
import org.p248a.p249a.p268i.p274f.C5283g;
import org.p248a.p249a.p268i.p274f.C5284h;
import org.p248a.p249a.p268i.p274f.C5288l;
import org.p248a.p249a.p268i.p274f.C5289m;
import org.p248a.p249a.p281n.C5342d;
import org.p248a.p249a.p281n.C5346h;
import org.p248a.p249a.p281n.C5348j;
import org.p248a.p249a.p281n.C5349k;
import org.p248a.p249a.p282o.C5356f;
import org.p248a.p249a.p282o.C5357g;
@AbstractC5006c
/* renamed from: org.a.a.i.b.s */
/* loaded from: classes2.dex */
public class C5196s {

    /* renamed from: a */
    static final String f21980a;

    /* renamed from: A */
    private CredentialsProvider f21981A;

    /* renamed from: B */
    private String f21982B;

    /* renamed from: C */
    private HttpHost f21983C;

    /* renamed from: D */
    private Collection<? extends Header> f21984D;

    /* renamed from: E */
    private C5091f f21985E;

    /* renamed from: F */
    private C5084a f21986F;

    /* renamed from: G */
    private C5019c f21987G;

    /* renamed from: H */
    private boolean f21988H;

    /* renamed from: I */
    private boolean f21989I;

    /* renamed from: J */
    private boolean f21990J;

    /* renamed from: K */
    private boolean f21991K;

    /* renamed from: L */
    private boolean f21992L;

    /* renamed from: M */
    private boolean f21993M;

    /* renamed from: N */
    private boolean f21994N;

    /* renamed from: O */
    private int f21995O = 0;

    /* renamed from: P */
    private int f21996P = 0;

    /* renamed from: Q */
    private List<Closeable> f21997Q;

    /* renamed from: b */
    private HttpRequestExecutor f21998b;

    /* renamed from: c */
    private X509HostnameVerifier f21999c;

    /* renamed from: d */
    private AbstractC5105b f22000d;

    /* renamed from: e */
    private SSLContext f22001e;

    /* renamed from: f */
    private AbstractC5125d f22002f;

    /* renamed from: g */
    private AbstractC5131i f22003g;

    /* renamed from: h */
    private ConnectionReuseStrategy f22004h;

    /* renamed from: i */
    private ConnectionKeepAliveStrategy f22005i;

    /* renamed from: j */
    private AbstractC5021b f22006j;

    /* renamed from: k */
    private AbstractC5021b f22007k;

    /* renamed from: l */
    private UserTokenHandler f22008l;

    /* renamed from: m */
    private HttpProcessor f22009m;

    /* renamed from: n */
    private LinkedList<HttpRequestInterceptor> f22010n;

    /* renamed from: o */
    private LinkedList<HttpRequestInterceptor> f22011o;

    /* renamed from: p */
    private LinkedList<HttpResponseInterceptor> f22012p;

    /* renamed from: q */
    private LinkedList<HttpResponseInterceptor> f22013q;

    /* renamed from: r */
    private HttpRequestRetryHandler f22014r;

    /* renamed from: s */
    private HttpRoutePlanner f22015s;

    /* renamed from: t */
    private AbstractC5056e f22016t;

    /* renamed from: u */
    private AbstractC5054d f22017u;

    /* renamed from: v */
    private AbstractC5031c f22018v;

    /* renamed from: w */
    private AbstractC5066f f22019w;

    /* renamed from: x */
    private AbstractC5086b<AbstractC5011c> f22020x;

    /* renamed from: y */
    private AbstractC5086b<AbstractC5135b> f22021y;

    /* renamed from: z */
    private CookieStore f22022z;

    static {
        C5357g m1294a = C5357g.m1294a("org.apache.http.client", C5196s.class.getClassLoader());
        f21980a = "Apache-HttpClient/" + (m1294a != null ? m1294a.m1289c() : C5357g.f22396a) + " (java 1.5)";
    }

    protected C5196s() {
    }

    /* renamed from: a */
    public static C5196s m1727a() {
        return new C5196s();
    }

    /* renamed from: b */
    private static String[] m1693b(String str) {
        if (C5356f.m1296b(str)) {
            return null;
        }
        return str.split(" *, *");
    }

    /* renamed from: a */
    public final C5196s m1726a(int i) {
        this.f21995O = i;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1724a(String str) {
        this.f21982B = str;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1723a(Collection<? extends Header> collection) {
        this.f21984D = collection;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1722a(SSLContext sSLContext) {
        this.f22001e = sSLContext;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1721a(C5019c c5019c) {
        this.f21987G = c5019c;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1720a(AbstractC5021b abstractC5021b) {
        this.f22006j = abstractC5021b;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1719a(AbstractC5031c abstractC5031c) {
        this.f22018v = abstractC5031c;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1718a(AbstractC5054d abstractC5054d) {
        this.f22017u = abstractC5054d;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1717a(AbstractC5056e abstractC5056e) {
        this.f22016t = abstractC5056e;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1716a(AbstractC5066f abstractC5066f) {
        this.f22019w = abstractC5066f;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1715a(C5084a c5084a) {
        this.f21986F = c5084a;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1714a(AbstractC5086b<AbstractC5011c> abstractC5086b) {
        this.f22020x = abstractC5086b;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1713a(C5091f c5091f) {
        this.f21985E = c5091f;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1712a(AbstractC5105b abstractC5105b) {
        this.f22000d = abstractC5105b;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1711a(AbstractC5125d abstractC5125d) {
        this.f22002f = abstractC5125d;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1710a(AbstractC5131i abstractC5131i) {
        this.f22003g = abstractC5131i;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1708a(ConnectionReuseStrategy connectionReuseStrategy) {
        this.f22004h = connectionReuseStrategy;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1707a(HttpHost httpHost) {
        this.f21983C = httpHost;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1706a(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            if (this.f22010n == null) {
                this.f22010n = new LinkedList<>();
            }
            this.f22010n.addFirst(httpRequestInterceptor);
        }
        return this;
    }

    /* renamed from: a */
    public final C5196s m1705a(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            if (this.f22012p == null) {
                this.f22012p = new LinkedList<>();
            }
            this.f22012p.addFirst(httpResponseInterceptor);
        }
        return this;
    }

    /* renamed from: a */
    public final C5196s m1704a(CookieStore cookieStore) {
        this.f22022z = cookieStore;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1703a(CredentialsProvider credentialsProvider) {
        this.f21981A = credentialsProvider;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1702a(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.f22014r = httpRequestRetryHandler;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1701a(UserTokenHandler userTokenHandler) {
        this.f22008l = userTokenHandler;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1700a(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        this.f22005i = connectionKeepAliveStrategy;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1699a(HttpRoutePlanner httpRoutePlanner) {
        this.f22015s = httpRoutePlanner;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1698a(X509HostnameVerifier x509HostnameVerifier) {
        this.f21999c = x509HostnameVerifier;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1697a(HttpProcessor httpProcessor) {
        this.f22009m = httpProcessor;
        return this;
    }

    /* renamed from: a */
    public final C5196s m1696a(HttpRequestExecutor httpRequestExecutor) {
        this.f21998b = httpRequestExecutor;
        return this;
    }

    /* renamed from: a */
    protected AbstractC5278b m1709a(AbstractC5278b abstractC5278b) {
        return abstractC5278b;
    }

    /* renamed from: a */
    protected void m1725a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        if (this.f21997Q == null) {
            this.f21997Q = new ArrayList();
        }
        this.f21997Q.add(closeable);
    }

    /* renamed from: b */
    public final C5196s m1695b() {
        this.f21994N = true;
        return this;
    }

    /* renamed from: b */
    public final C5196s m1694b(int i) {
        this.f21996P = i;
        return this;
    }

    /* renamed from: b */
    public final C5196s m1692b(AbstractC5021b abstractC5021b) {
        this.f22007k = abstractC5021b;
        return this;
    }

    /* renamed from: b */
    public final C5196s m1691b(AbstractC5086b<AbstractC5135b> abstractC5086b) {
        this.f22021y = abstractC5086b;
        return this;
    }

    /* renamed from: b */
    public final C5196s m1689b(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            if (this.f22011o == null) {
                this.f22011o = new LinkedList<>();
            }
            this.f22011o.addLast(httpRequestInterceptor);
        }
        return this;
    }

    /* renamed from: b */
    public final C5196s m1688b(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            if (this.f22013q == null) {
                this.f22013q = new LinkedList<>();
            }
            this.f22013q.addLast(httpResponseInterceptor);
        }
        return this;
    }

    /* renamed from: b */
    protected AbstractC5278b m1690b(AbstractC5278b abstractC5278b) {
        return abstractC5278b;
    }

    /* renamed from: c */
    public final C5196s m1687c() {
        this.f21992L = true;
        return this;
    }

    /* renamed from: d */
    public final C5196s m1686d() {
        this.f21991K = true;
        return this;
    }

    /* renamed from: e */
    public final C5196s m1685e() {
        this.f21993M = true;
        return this;
    }

    /* renamed from: f */
    public final C5196s m1684f() {
        this.f21990J = true;
        return this;
    }

    /* renamed from: g */
    public final C5196s m1683g() {
        this.f21989I = true;
        return this;
    }

    /* renamed from: h */
    public final C5196s m1682h() {
        this.f21988H = true;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b3  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC5183h m1681i() {
        C5288l c5288l;
        String str;
        ArrayList arrayList = null;
        HttpRequestExecutor httpRequestExecutor = this.f21998b;
        if (httpRequestExecutor == null) {
            httpRequestExecutor = new HttpRequestExecutor();
        }
        AbstractC5125d abstractC5125d = this.f22002f;
        C5225r c5225r = abstractC5125d;
        if (abstractC5125d == null) {
            Object obj = this.f22000d;
            if (obj == null) {
                String[] m1693b = this.f21988H ? m1693b(System.getProperty("https.protocols")) : null;
                String[] m1693b2 = this.f21988H ? m1693b(System.getProperty("https.cipherSuites")) : null;
                X509HostnameVerifier x509HostnameVerifier = this.f21999c;
                X509HostnameVerifier x509HostnameVerifier2 = x509HostnameVerifier == null ? C5115g.f21744e : x509HostnameVerifier;
                obj = this.f22001e != null ? new C5115g(this.f22001e, m1693b, m1693b2, x509HostnameVerifier2) : this.f21988H ? new C5115g((SSLSocketFactory) SSLCertificateSocketFactory.getDefault(0), m1693b, m1693b2, x509HostnameVerifier2) : new C5115g((SSLSocketFactory) SSLCertificateSocketFactory.getDefault(0), x509HostnameVerifier2);
            }
            C5225r c5225r2 = new C5225r(C5090e.m2042a().m2041a(UriUtil.HTTP_SCHEME, C5106c.m2018a()).m2041a(UriUtil.HTTPS_SCHEME, obj).m2040b());
            if (this.f21985E != null) {
                c5225r2.m1614a(this.f21985E);
            }
            if (this.f21986F != null) {
                c5225r2.m1615a(this.f21986F);
            }
            if (this.f21988H && "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
                int parseInt = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                c5225r2.mo1401b(parseInt);
                c5225r2.mo1404a(parseInt * 2);
            }
            if (this.f21995O > 0) {
                c5225r2.mo1404a(this.f21995O);
            }
            c5225r = c5225r2;
            if (this.f21996P > 0) {
                c5225r2.mo1401b(this.f21996P);
                c5225r = c5225r2;
            }
        }
        ConnectionReuseStrategy connectionReuseStrategy = this.f22004h;
        if (connectionReuseStrategy == null) {
            if (this.f21988H) {
                connectionReuseStrategy = "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")) ? C5291g.f22236a : C5316k.f22323a;
            } else {
                connectionReuseStrategy = C5291g.f22236a;
            }
        }
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy = this.f22005i;
        if (connectionKeepAliveStrategy == null) {
            connectionKeepAliveStrategy = C5186k.f21953a;
        }
        AbstractC5021b abstractC5021b = this.f22006j;
        if (abstractC5021b == null) {
            abstractC5021b = C5176ah.f21942a;
        }
        AbstractC5021b abstractC5021b2 = this.f22007k;
        if (abstractC5021b2 == null) {
            abstractC5021b2 = C5170ab.f21926a;
        }
        UserTokenHandler userTokenHandler = this.f22008l;
        if (userTokenHandler == null) {
            userTokenHandler = !this.f21994N ? C5190o.f21964a : C5205z.f22051a;
        }
        AbstractC5278b m1709a = m1709a(new C5281e(httpRequestExecutor, c5225r, connectionReuseStrategy, connectionKeepAliveStrategy, abstractC5021b, abstractC5021b2, userTokenHandler));
        HttpProcessor httpProcessor = this.f22009m;
        if (httpProcessor == null) {
            String str2 = this.f21982B;
            if (str2 == null) {
                if (this.f21988H) {
                    str2 = System.getProperty("http.agent");
                }
                if (str2 == null) {
                    str = f21980a;
                    C5342d m1341a = C5342d.m1341a();
                    if (this.f22010n != null) {
                        Iterator<HttpRequestInterceptor> it2 = this.f22010n.iterator();
                        while (it2.hasNext()) {
                            m1341a.m1340a(it2.next());
                        }
                    }
                    if (this.f22012p != null) {
                        Iterator<HttpResponseInterceptor> it3 = this.f22012p.iterator();
                        while (it3.hasNext()) {
                            m1341a.m1339a(it3.next());
                        }
                    }
                    m1341a.m1328c(new C5062f(this.f21984D), new C5346h(), new C5348j(), new C5061e(), new C5349k(str), new C5063g());
                    if (!this.f21992L) {
                        m1341a.m1330c(new C5059c());
                    }
                    if (!this.f21991K) {
                        m1341a.m1330c(new C5058b());
                    }
                    if (!this.f21993M) {
                        m1341a.m1330c(new C5060d());
                    }
                    if (!this.f21992L) {
                        m1341a.m1329c(new C5065i());
                    }
                    if (!this.f21991K) {
                        m1341a.m1329c(new C5064h());
                    }
                    if (this.f22011o != null) {
                        Iterator<HttpRequestInterceptor> it4 = this.f22011o.iterator();
                        while (it4.hasNext()) {
                            m1341a.m1335b(it4.next());
                        }
                    }
                    if (this.f22013q != null) {
                        Iterator<HttpResponseInterceptor> it5 = this.f22013q.iterator();
                        while (it5.hasNext()) {
                            m1341a.m1334b(it5.next());
                        }
                    }
                    httpProcessor = m1341a.m1336b();
                }
            }
            str = str2;
            C5342d m1341a2 = C5342d.m1341a();
            if (this.f22010n != null) {
            }
            if (this.f22012p != null) {
            }
            m1341a2.m1328c(new C5062f(this.f21984D), new C5346h(), new C5348j(), new C5061e(), new C5349k(str), new C5063g());
            if (!this.f21992L) {
            }
            if (!this.f21991K) {
            }
            if (!this.f21993M) {
            }
            if (!this.f21992L) {
            }
            if (!this.f21991K) {
            }
            if (this.f22011o != null) {
            }
            if (this.f22013q != null) {
            }
            httpProcessor = m1341a2.m1336b();
        }
        AbstractC5278b m1690b = m1690b(new C5283g(m1709a, httpProcessor));
        if (!this.f21990J) {
            HttpRequestRetryHandler httpRequestRetryHandler = this.f22014r;
            if (httpRequestRetryHandler == null) {
                httpRequestRetryHandler = C5187l.f21954a;
            }
            c5288l = new C5288l(m1690b, httpRequestRetryHandler);
        } else {
            c5288l = m1690b;
        }
        HttpRoutePlanner httpRoutePlanner = this.f22015s;
        if (httpRoutePlanner == null) {
            AbstractC5131i abstractC5131i = this.f22003g;
            if (abstractC5131i == null) {
                abstractC5131i = C5218k.f22086a;
            }
            httpRoutePlanner = this.f21983C != null ? new C5216i(this.f21983C, abstractC5131i) : this.f21988H ? new C5230t(abstractC5131i, ProxySelector.getDefault()) : new C5217j(abstractC5131i);
        }
        C5284h c5284h = c5288l;
        if (!this.f21989I) {
            AbstractC5056e abstractC5056e = this.f22016t;
            if (abstractC5056e == null) {
                abstractC5056e = C5188m.f21959b;
            }
            c5284h = new C5284h(c5288l, httpRoutePlanner, abstractC5056e);
        }
        AbstractC5066f abstractC5066f = this.f22019w;
        C5289m c5289m = c5284h;
        if (abstractC5066f != null) {
            c5289m = new C5289m(c5284h, abstractC5066f);
        }
        AbstractC5031c abstractC5031c = this.f22018v;
        AbstractC5054d abstractC5054d = this.f22017u;
        AbstractC5278b c5277a = (abstractC5031c == null || abstractC5054d == null) ? c5289m : new C5277a(c5289m, abstractC5054d, abstractC5031c);
        AbstractC5086b abstractC5086b = this.f22020x;
        if (abstractC5086b == null) {
            abstractC5086b = C5090e.m2042a().m2041a(C5017a.f21475a, new C5148b()).m2041a(C5017a.f21476b, new C5150d()).m2041a(C5017a.f21477c, new C5163i()).m2040b();
        }
        AbstractC5086b abstractC5086b2 = this.f22021y;
        if (abstractC5086b2 == null) {
            abstractC5086b2 = C5090e.m2042a().m2041a(C5018b.f21483d, new C5253k()).m2041a(C5018b.f21482c, new C5241ag()).m2041a(C5018b.f21480a, new C5255m()).m2041a(C5018b.f21481b, new C5266u()).m2041a(C5018b.f21484e, new C5263r()).m2041a("rfc2109", new C5271z()).m2041a("rfc2965", new C5241ag()).m2040b();
        }
        CookieStore cookieStore = this.f22022z;
        if (cookieStore == null) {
            cookieStore = new C5179d();
        }
        CredentialsProvider credentialsProvider = this.f21981A;
        if (credentialsProvider == null) {
            credentialsProvider = this.f21988H ? new C5175ag() : new C5180e();
        }
        C5019c c5019c = this.f21987G != null ? this.f21987G : C5019c.f21485a;
        if (this.f21997Q != null) {
            arrayList = new ArrayList(this.f21997Q);
        }
        return new C5200w(c5277a, c5225r, httpRoutePlanner, abstractC5086b2, abstractC5086b, cookieStore, credentialsProvider, c5019c, arrayList);
    }
}
