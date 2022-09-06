package org.p248a.p249a.p252c.p255c;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.HeaderGroup;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p254b.C5030h;
import org.p248a.p249a.p252c.p258f.C5076h;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.c.c.p */
/* loaded from: classes2.dex */
public class C5051p {

    /* renamed from: a */
    private String f21557a;

    /* renamed from: b */
    private ProtocolVersion f21558b;

    /* renamed from: c */
    private URI f21559c;

    /* renamed from: d */
    private HeaderGroup f21560d;

    /* renamed from: e */
    private HttpEntity f21561e;

    /* renamed from: f */
    private LinkedList<NameValuePair> f21562f;

    /* renamed from: g */
    private C5019c f21563g;

    /* renamed from: org.a.a.c.c.p$a */
    /* loaded from: classes2.dex */
    static class C5052a extends AbstractC5038e {

        /* renamed from: a */
        private final String f21564a;

        C5052a(String str) {
            this.f21564a = str;
        }

        @Override // org.p248a.p249a.p252c.p255c.AbstractC5046m
        public String getMethod() {
            return this.f21564a;
        }
    }

    /* renamed from: org.a.a.c.c.p$b */
    /* loaded from: classes2.dex */
    static class C5053b extends AbstractC5046m {

        /* renamed from: a */
        private final String f21565a;

        C5053b(String str) {
            this.f21565a = str;
        }

        @Override // org.p248a.p249a.p252c.p255c.AbstractC5046m
        public String getMethod() {
            return this.f21565a;
        }
    }

    C5051p() {
        this(null);
    }

    C5051p(String str) {
        this.f21557a = str;
    }

    /* renamed from: a */
    public static C5051p m2219a() {
        return new C5051p("GET");
    }

    /* renamed from: a */
    public static C5051p m2218a(String str) {
        C5351a.m1315b(str, "HTTP method");
        return new C5051p(str);
    }

    /* renamed from: a */
    public static C5051p m2212a(HttpRequest httpRequest) {
        C5351a.m1321a(httpRequest, "HTTP request");
        return new C5051p().m2204b(httpRequest);
    }

    /* renamed from: b */
    public static C5051p m2208b() {
        return new C5051p(C5041h.f21543a);
    }

    /* renamed from: b */
    private C5051p m2204b(HttpRequest httpRequest) {
        if (httpRequest != null) {
            this.f21557a = httpRequest.getRequestLine().getMethod();
            this.f21558b = httpRequest.getRequestLine().getProtocolVersion();
            if (httpRequest instanceof HttpUriRequest) {
                this.f21559c = ((HttpUriRequest) httpRequest).getURI();
            } else {
                this.f21559c = URI.create(httpRequest.getRequestLine().getUri());
            }
            if (this.f21560d == null) {
                this.f21560d = new HeaderGroup();
            }
            this.f21560d.clear();
            this.f21560d.setHeaders(httpRequest.getAllHeaders());
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                this.f21561e = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            } else {
                this.f21561e = null;
            }
            if (httpRequest instanceof AbstractC5036c) {
                this.f21563g = ((AbstractC5036c) httpRequest).mo2224l_();
            } else {
                this.f21563g = null;
            }
            this.f21562f = null;
        }
        return this;
    }

    /* renamed from: c */
    public static C5051p m2203c() {
        return new C5051p("POST");
    }

    /* renamed from: d */
    public static C5051p m2199d() {
        return new C5051p(C5045l.f21547a);
    }

    /* renamed from: e */
    public static C5051p m2197e() {
        return new C5051p("DELETE");
    }

    /* renamed from: f */
    public static C5051p m2195f() {
        return new C5051p(C5050o.f21556a);
    }

    /* renamed from: g */
    public static C5051p m2193g() {
        return new C5051p(C5042i.f21544a);
    }

    /* renamed from: a */
    public C5051p m2217a(String str, String str2) {
        if (this.f21560d == null) {
            this.f21560d = new HeaderGroup();
        }
        this.f21560d.addHeader(new BasicHeader(str, str2));
        return this;
    }

    /* renamed from: a */
    public C5051p m2216a(URI uri) {
        this.f21559c = uri;
        return this;
    }

    /* renamed from: a */
    public C5051p m2215a(C5019c c5019c) {
        this.f21563g = c5019c;
        return this;
    }

    /* renamed from: a */
    public C5051p m2214a(Header header) {
        if (this.f21560d == null) {
            this.f21560d = new HeaderGroup();
        }
        this.f21560d.addHeader(header);
        return this;
    }

    /* renamed from: a */
    public C5051p m2213a(HttpEntity httpEntity) {
        this.f21561e = httpEntity;
        return this;
    }

    /* renamed from: a */
    public C5051p m2211a(NameValuePair nameValuePair) {
        C5351a.m1321a(nameValuePair, "Name value pair");
        if (this.f21562f == null) {
            this.f21562f = new LinkedList<>();
        }
        this.f21562f.add(nameValuePair);
        return this;
    }

    /* renamed from: a */
    public C5051p m2210a(ProtocolVersion protocolVersion) {
        this.f21558b = protocolVersion;
        return this;
    }

    /* renamed from: a */
    public C5051p m2209a(NameValuePair... nameValuePairArr) {
        for (NameValuePair nameValuePair : nameValuePairArr) {
            m2211a(nameValuePair);
        }
        return this;
    }

    /* renamed from: b */
    public C5051p m2207b(String str) {
        this.f21559c = str != null ? URI.create(str) : null;
        return this;
    }

    /* renamed from: b */
    public C5051p m2206b(String str, String str2) {
        if (this.f21560d == null) {
            this.f21560d = new HeaderGroup();
        }
        this.f21560d.updateHeader(new BasicHeader(str, str2));
        return this;
    }

    /* renamed from: b */
    public C5051p m2205b(Header header) {
        if (this.f21560d == null) {
            this.f21560d = new HeaderGroup();
        }
        this.f21560d.removeHeader(header);
        return this;
    }

    /* renamed from: c */
    public C5051p m2201c(String str, String str2) {
        return m2211a((NameValuePair) new BasicNameValuePair(str, str2));
    }

    /* renamed from: c */
    public C5051p m2200c(Header header) {
        if (this.f21560d == null) {
            this.f21560d = new HeaderGroup();
        }
        this.f21560d.updateHeader(header);
        return this;
    }

    /* renamed from: c */
    public Header m2202c(String str) {
        if (this.f21560d != null) {
            return this.f21560d.getFirstHeader(str);
        }
        return null;
    }

    /* renamed from: d */
    public Header m2198d(String str) {
        if (this.f21560d != null) {
            return this.f21560d.getLastHeader(str);
        }
        return null;
    }

    /* renamed from: e */
    public Header[] m2196e(String str) {
        if (this.f21560d != null) {
            return this.f21560d.getHeaders(str);
        }
        return null;
    }

    /* renamed from: f */
    public C5051p m2194f(String str) {
        if (str != null && this.f21560d != null) {
            HeaderIterator it2 = this.f21560d.iterator();
            while (it2.hasNext()) {
                if (str.equalsIgnoreCase(it2.nextHeader().getName())) {
                    it2.remove();
                }
            }
        }
        return this;
    }

    /* renamed from: h */
    public String m2192h() {
        return this.f21557a;
    }

    /* renamed from: i */
    public ProtocolVersion m2191i() {
        return this.f21558b;
    }

    /* renamed from: j */
    public URI m2190j() {
        return this.f21559c;
    }

    /* renamed from: k */
    public HttpEntity m2189k() {
        return this.f21561e;
    }

    /* renamed from: l */
    public List<NameValuePair> m2188l() {
        return this.f21562f != null ? new ArrayList(this.f21562f) : new ArrayList();
    }

    /* renamed from: m */
    public C5019c m2187m() {
        return this.f21563g;
    }

    /* renamed from: n */
    public HttpUriRequest m2186n() {
        URI uri;
        AbstractC5046m abstractC5046m;
        URI create = this.f21559c != null ? this.f21559c : URI.create("/");
        HttpEntity httpEntity = this.f21561e;
        if (this.f21562f == null || this.f21562f.isEmpty()) {
            uri = create;
        } else if (httpEntity != null || (!"POST".equalsIgnoreCase(this.f21557a) && !C5045l.f21547a.equalsIgnoreCase(this.f21557a))) {
            try {
                uri = new C5076h(create).m2127b(this.f21562f).m2138a();
            } catch (URISyntaxException e) {
                uri = create;
            }
        } else {
            httpEntity = new C5030h(this.f21562f, Charset.forName("ISO-8859-1"));
            uri = create;
        }
        if (httpEntity == null) {
            abstractC5046m = new C5053b(this.f21557a);
        } else {
            C5052a c5052a = new C5052a(this.f21557a);
            c5052a.setEntity(httpEntity);
            abstractC5046m = c5052a;
        }
        abstractC5046m.m2227a(this.f21558b);
        abstractC5046m.m2229a(uri);
        if (this.f21560d != null) {
            abstractC5046m.setHeaders(this.f21560d.getAllHeaders());
        }
        abstractC5046m.m2228a(this.f21563g);
        return abstractC5046m;
    }
}
