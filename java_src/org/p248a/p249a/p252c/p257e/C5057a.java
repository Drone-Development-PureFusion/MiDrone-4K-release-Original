package org.p248a.p249a.p252c.p257e;

import java.net.URI;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p251b.AbstractC5011c;
import org.p248a.p249a.p251b.C5012d;
import org.p248a.p249a.p252c.AbstractC5016a;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p260e.AbstractC5086b;
import org.p248a.p249a.p266g.AbstractC5135b;
import org.p248a.p249a.p281n.C5339a;
import org.p248a.p249a.p281n.C5341c;
@AbstractC5006c
/* renamed from: org.a.a.c.e.a */
/* loaded from: classes2.dex */
public class C5057a extends C5341c {

    /* renamed from: a */
    public static final String f21566a = "http.route";

    /* renamed from: b */
    public static final String f21567b = "http.protocol.redirect-locations";

    /* renamed from: c */
    public static final String f21568c = "http.cookiespec-registry";

    /* renamed from: d */
    public static final String f21569d = "http.cookie-spec";

    /* renamed from: e */
    public static final String f21570e = "http.cookie-origin";

    /* renamed from: f */
    public static final String f21571f = "http.cookie-store";

    /* renamed from: g */
    public static final String f21572g = "http.auth.credentials-provider";

    /* renamed from: h */
    public static final String f21573h = "http.auth.auth-cache";

    /* renamed from: i */
    public static final String f21574i = "http.auth.target-scope";

    /* renamed from: j */
    public static final String f21575j = "http.auth.proxy-scope";

    /* renamed from: k */
    public static final String f21576k = "http.user-token";

    /* renamed from: l */
    public static final String f21577l = "http.authscheme-registry";

    /* renamed from: m */
    public static final String f21578m = "http.request-config";

    public C5057a() {
    }

    public C5057a(HttpContext httpContext) {
        super(httpContext);
    }

    /* renamed from: a */
    public static C5057a m2184a() {
        return new C5057a(new C5339a());
    }

    /* renamed from: a */
    public static C5057a m2176a(HttpContext httpContext) {
        return httpContext instanceof C5057a ? (C5057a) httpContext : new C5057a(httpContext);
    }

    /* renamed from: b */
    private <T> AbstractC5086b<T> m2174b(String str, Class<T> cls) {
        return (AbstractC5086b) a(str, AbstractC5086b.class);
    }

    /* renamed from: a */
    public <T> T m2183a(Class<T> cls) {
        return (T) a(f21576k, cls);
    }

    /* renamed from: a */
    public void m2182a(Object obj) {
        setAttribute(f21576k, obj);
    }

    /* renamed from: a */
    public void m2181a(C5019c c5019c) {
        setAttribute(f21578m, c5019c);
    }

    /* renamed from: a */
    public void m2180a(AbstractC5016a abstractC5016a) {
        setAttribute(f21573h, abstractC5016a);
    }

    /* renamed from: a */
    public void m2179a(AbstractC5086b<AbstractC5135b> abstractC5086b) {
        setAttribute(f21568c, abstractC5086b);
    }

    /* renamed from: a */
    public void m2178a(CookieStore cookieStore) {
        setAttribute(f21571f, cookieStore);
    }

    /* renamed from: a */
    public void m2177a(CredentialsProvider credentialsProvider) {
        setAttribute(f21572g, credentialsProvider);
    }

    /* renamed from: b */
    public RouteInfo m2175b() {
        return (RouteInfo) a(f21566a, HttpRoute.class);
    }

    /* renamed from: b */
    public void m2173b(AbstractC5086b<AbstractC5011c> abstractC5086b) {
        setAttribute(f21577l, abstractC5086b);
    }

    /* renamed from: c */
    public List<URI> m2172c() {
        return (List) a("http.protocol.redirect-locations", List.class);
    }

    /* renamed from: d */
    public CookieStore m2171d() {
        return (CookieStore) a(f21571f, CookieStore.class);
    }

    /* renamed from: e */
    public CookieSpec m2170e() {
        return (CookieSpec) a(f21569d, CookieSpec.class);
    }

    /* renamed from: f */
    public CookieOrigin m2169f() {
        return (CookieOrigin) a(f21570e, CookieOrigin.class);
    }

    /* renamed from: g */
    public AbstractC5086b<AbstractC5135b> m2168g() {
        return m2174b(f21568c, AbstractC5135b.class);
    }

    /* renamed from: h */
    public AbstractC5086b<AbstractC5011c> m2167h() {
        return m2174b(f21577l, AbstractC5011c.class);
    }

    /* renamed from: i */
    public CredentialsProvider m2166i() {
        return (CredentialsProvider) a(f21572g, CredentialsProvider.class);
    }

    /* renamed from: j */
    public AbstractC5016a m2165j() {
        return (AbstractC5016a) a(f21573h, AbstractC5016a.class);
    }

    /* renamed from: k */
    public C5012d m2164k() {
        return (C5012d) a(f21574i, C5012d.class);
    }

    /* renamed from: l */
    public C5012d m2163l() {
        return (C5012d) a(f21575j, C5012d.class);
    }

    /* renamed from: m */
    public Object m2162m() {
        return getAttribute(f21576k);
    }

    /* renamed from: n */
    public C5019c m2161n() {
        C5019c c5019c = (C5019c) a(f21578m, C5019c.class);
        return c5019c != null ? c5019c : C5019c.f21485a;
    }
}
