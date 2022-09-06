package org.p248a.p249a.p252c.p253a;

import java.net.InetAddress;
import java.util.Collection;
import org.apache.http.HttpHost;
/* renamed from: org.a.a.c.a.c */
/* loaded from: classes2.dex */
public class C5019c implements Cloneable {

    /* renamed from: a */
    public static final C5019c f21485a = new C5020a().m2277a();

    /* renamed from: b */
    private final boolean f21486b;

    /* renamed from: c */
    private final HttpHost f21487c;

    /* renamed from: d */
    private final InetAddress f21488d;

    /* renamed from: e */
    private final boolean f21489e;

    /* renamed from: f */
    private final String f21490f;

    /* renamed from: g */
    private final boolean f21491g;

    /* renamed from: h */
    private final boolean f21492h;

    /* renamed from: i */
    private final boolean f21493i;

    /* renamed from: j */
    private final int f21494j;

    /* renamed from: k */
    private final boolean f21495k;

    /* renamed from: l */
    private final Collection<String> f21496l;

    /* renamed from: m */
    private final Collection<String> f21497m;

    /* renamed from: n */
    private final int f21498n;

    /* renamed from: o */
    private final int f21499o;

    /* renamed from: p */
    private final int f21500p;

    /* renamed from: org.a.a.c.a.c$a */
    /* loaded from: classes2.dex */
    public static class C5020a {

        /* renamed from: a */
        private boolean f21501a;

        /* renamed from: b */
        private HttpHost f21502b;

        /* renamed from: c */
        private InetAddress f21503c;

        /* renamed from: e */
        private String f21505e;

        /* renamed from: h */
        private boolean f21508h;

        /* renamed from: k */
        private Collection<String> f21511k;

        /* renamed from: l */
        private Collection<String> f21512l;

        /* renamed from: d */
        private boolean f21504d = true;

        /* renamed from: f */
        private boolean f21506f = true;

        /* renamed from: i */
        private int f21509i = 50;

        /* renamed from: g */
        private boolean f21507g = true;

        /* renamed from: j */
        private boolean f21510j = true;

        /* renamed from: m */
        private int f21513m = -1;

        /* renamed from: n */
        private int f21514n = -1;

        /* renamed from: o */
        private int f21515o = -1;

        C5020a() {
        }

        /* renamed from: a */
        public C5020a m2276a(int i) {
            this.f21509i = i;
            return this;
        }

        /* renamed from: a */
        public C5020a m2275a(String str) {
            this.f21505e = str;
            return this;
        }

        /* renamed from: a */
        public C5020a m2274a(InetAddress inetAddress) {
            this.f21503c = inetAddress;
            return this;
        }

        /* renamed from: a */
        public C5020a m2273a(Collection<String> collection) {
            this.f21511k = collection;
            return this;
        }

        /* renamed from: a */
        public C5020a m2272a(HttpHost httpHost) {
            this.f21502b = httpHost;
            return this;
        }

        /* renamed from: a */
        public C5020a m2271a(boolean z) {
            this.f21501a = z;
            return this;
        }

        /* renamed from: a */
        public C5019c m2277a() {
            return new C5019c(this.f21501a, this.f21502b, this.f21503c, this.f21504d, this.f21505e, this.f21506f, this.f21507g, this.f21508h, this.f21509i, this.f21510j, this.f21511k, this.f21512l, this.f21513m, this.f21514n, this.f21515o);
        }

        /* renamed from: b */
        public C5020a m2270b(int i) {
            this.f21513m = i;
            return this;
        }

        /* renamed from: b */
        public C5020a m2269b(Collection<String> collection) {
            this.f21512l = collection;
            return this;
        }

        /* renamed from: b */
        public C5020a m2268b(boolean z) {
            this.f21504d = z;
            return this;
        }

        /* renamed from: c */
        public C5020a m2267c(int i) {
            this.f21514n = i;
            return this;
        }

        /* renamed from: c */
        public C5020a m2266c(boolean z) {
            this.f21506f = z;
            return this;
        }

        /* renamed from: d */
        public C5020a m2265d(int i) {
            this.f21515o = i;
            return this;
        }

        /* renamed from: d */
        public C5020a m2264d(boolean z) {
            this.f21507g = z;
            return this;
        }

        /* renamed from: e */
        public C5020a m2263e(boolean z) {
            this.f21508h = z;
            return this;
        }

        /* renamed from: f */
        public C5020a m2262f(boolean z) {
            this.f21510j = z;
            return this;
        }
    }

    C5019c(boolean z, HttpHost httpHost, InetAddress inetAddress, boolean z2, String str, boolean z3, boolean z4, boolean z5, int i, boolean z6, Collection<String> collection, Collection<String> collection2, int i2, int i3, int i4) {
        this.f21486b = z;
        this.f21487c = httpHost;
        this.f21488d = inetAddress;
        this.f21489e = z2;
        this.f21490f = str;
        this.f21491g = z3;
        this.f21492h = z4;
        this.f21493i = z5;
        this.f21494j = i;
        this.f21495k = z6;
        this.f21496l = collection;
        this.f21497m = collection2;
        this.f21498n = i2;
        this.f21499o = i3;
        this.f21500p = i4;
    }

    /* renamed from: a */
    public static C5020a m2294a(C5019c c5019c) {
        return new C5020a().m2271a(c5019c.m2295a()).m2272a(c5019c.m2293b()).m2274a(c5019c.m2292c()).m2268b(c5019c.m2291d()).m2275a(c5019c.m2290e()).m2266c(c5019c.m2289f()).m2264d(c5019c.m2288g()).m2263e(c5019c.m2287h()).m2276a(c5019c.m2286i()).m2262f(c5019c.m2285j()).m2273a(c5019c.m2284k()).m2269b(c5019c.m2283l()).m2270b(c5019c.m2282m()).m2267c(c5019c.m2281n()).m2265d(c5019c.m2280o());
    }

    /* renamed from: q */
    public static C5020a m2278q() {
        return new C5020a();
    }

    /* renamed from: a */
    public boolean m2295a() {
        return this.f21486b;
    }

    /* renamed from: b */
    public HttpHost m2293b() {
        return this.f21487c;
    }

    /* renamed from: c */
    public InetAddress m2292c() {
        return this.f21488d;
    }

    /* renamed from: d */
    public boolean m2291d() {
        return this.f21489e;
    }

    /* renamed from: e */
    public String m2290e() {
        return this.f21490f;
    }

    /* renamed from: f */
    public boolean m2289f() {
        return this.f21491g;
    }

    /* renamed from: g */
    public boolean m2288g() {
        return this.f21492h;
    }

    /* renamed from: h */
    public boolean m2287h() {
        return this.f21493i;
    }

    /* renamed from: i */
    public int m2286i() {
        return this.f21494j;
    }

    /* renamed from: j */
    public boolean m2285j() {
        return this.f21495k;
    }

    /* renamed from: k */
    public Collection<String> m2284k() {
        return this.f21496l;
    }

    /* renamed from: l */
    public Collection<String> m2283l() {
        return this.f21497m;
    }

    /* renamed from: m */
    public int m2282m() {
        return this.f21498n;
    }

    /* renamed from: n */
    public int m2281n() {
        return this.f21499o;
    }

    /* renamed from: o */
    public int m2280o() {
        return this.f21500p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public C5019c clone() {
        return (C5019c) super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", expectContinueEnabled=").append(this.f21486b);
        sb.append(", proxy=").append(this.f21487c);
        sb.append(", localAddress=").append(this.f21488d);
        sb.append(", staleConnectionCheckEnabled=").append(this.f21489e);
        sb.append(", cookieSpec=").append(this.f21490f);
        sb.append(", redirectsEnabled=").append(this.f21491g);
        sb.append(", relativeRedirectsAllowed=").append(this.f21492h);
        sb.append(", maxRedirects=").append(this.f21494j);
        sb.append(", circularRedirectsAllowed=").append(this.f21493i);
        sb.append(", authenticationEnabled=").append(this.f21495k);
        sb.append(", targetPreferredAuthSchemes=").append(this.f21496l);
        sb.append(", proxyPreferredAuthSchemes=").append(this.f21497m);
        sb.append(", connectionRequestTimeout=").append(this.f21498n);
        sb.append(", connectTimeout=").append(this.f21499o);
        sb.append(", socketTimeout=").append(this.f21500p);
        sb.append("]");
        return sb.toString();
    }
}
