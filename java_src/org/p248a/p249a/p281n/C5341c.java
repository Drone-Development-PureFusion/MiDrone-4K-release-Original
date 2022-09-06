package org.p248a.p249a.p281n;

import org.apache.http.HttpConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.n.c */
/* loaded from: classes2.dex */
public class C5341c implements HttpContext {

    /* renamed from: n */
    public static final String f22383n = "http.connection";

    /* renamed from: o */
    public static final String f22384o = "http.request";

    /* renamed from: p */
    public static final String f22385p = "http.response";

    /* renamed from: q */
    public static final String f22386q = "http.target_host";

    /* renamed from: r */
    public static final String f22387r = "http.request_sent";

    /* renamed from: a */
    private final HttpContext f22388a;

    public C5341c() {
        this.f22388a = new C5339a();
    }

    public C5341c(HttpContext httpContext) {
        this.f22388a = httpContext;
    }

    /* renamed from: b */
    public static C5341c m1348b(HttpContext httpContext) {
        C5351a.m1321a(httpContext, "HTTP context");
        return httpContext instanceof C5341c ? (C5341c) httpContext : new C5341c(httpContext);
    }

    /* renamed from: o */
    public static C5341c m1347o() {
        return new C5341c(new C5339a());
    }

    /* renamed from: a */
    public <T> T m1351a(String str, Class<T> cls) {
        C5351a.m1321a(cls, "Attribute class");
        Object attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return cls.cast(attribute);
    }

    /* renamed from: a */
    public void m1350a(HttpHost httpHost) {
        setAttribute(f22386q, httpHost);
    }

    /* renamed from: b */
    public <T extends HttpConnection> T m1349b(Class<T> cls) {
        return (T) m1351a(f22383n, cls);
    }

    public Object getAttribute(String str) {
        return this.f22388a.getAttribute(str);
    }

    /* renamed from: p */
    public HttpConnection m1346p() {
        return (HttpConnection) m1351a(f22383n, HttpConnection.class);
    }

    /* renamed from: q */
    public HttpRequest m1345q() {
        return (HttpRequest) m1351a(f22384o, HttpRequest.class);
    }

    /* renamed from: r */
    public boolean m1344r() {
        Boolean bool = (Boolean) m1351a(f22387r, Boolean.class);
        return bool != null && bool.booleanValue();
    }

    public Object removeAttribute(String str) {
        return this.f22388a.removeAttribute(str);
    }

    /* renamed from: s */
    public HttpResponse m1343s() {
        return (HttpResponse) m1351a(f22385p, HttpResponse.class);
    }

    public void setAttribute(String str, Object obj) {
        this.f22388a.setAttribute(str, obj);
    }

    /* renamed from: t */
    public HttpHost m1342t() {
        return (HttpHost) m1351a(f22386q, HttpHost.class);
    }
}
