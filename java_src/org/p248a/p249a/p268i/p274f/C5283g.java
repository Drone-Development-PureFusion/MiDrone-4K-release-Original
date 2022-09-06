package org.p248a.p249a.p268i.p274f;

import android.util.Log;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpProcessor;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p252c.p258f.C5077i;
import org.p248a.p249a.p268i.p270b.C5180e;
import org.p248a.p249a.p281n.C5341c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.f.g */
/* loaded from: classes2.dex */
public class C5283g implements AbstractC5278b {

    /* renamed from: a */
    private static final String f22219a = "HttpClient";

    /* renamed from: b */
    private final AbstractC5278b f22220b;

    /* renamed from: c */
    private final HttpProcessor f22221c;

    public C5283g(AbstractC5278b abstractC5278b, HttpProcessor httpProcessor) {
        C5351a.m1321a(abstractC5278b, "HTTP client request executor");
        C5351a.m1321a(httpProcessor, "HTTP protocol processor");
        this.f22220b = abstractC5278b;
        this.f22221c = httpProcessor;
    }

    @Override // org.p248a.p249a.p268i.p274f.AbstractC5278b
    /* renamed from: a */
    public AbstractC5035b mo1511a(HttpRoute httpRoute, C5047n c5047n, C5057a c5057a, AbstractC5039f abstractC5039f) {
        URI uri;
        String userInfo;
        C5351a.m1321a(httpRoute, "HTTP route");
        C5351a.m1321a(c5047n, "HTTP request");
        C5351a.m1321a(c5057a, "HTTP context");
        HttpUriRequest m2223a = c5047n.m2223a();
        if (m2223a instanceof HttpUriRequest) {
            uri = m2223a.getURI();
        } else {
            String uri2 = m2223a.getRequestLine().getUri();
            try {
                uri = URI.create(uri2);
            } catch (IllegalArgumentException e) {
                if (Log.isLoggable(f22219a, 3)) {
                    Log.d(f22219a, "Unable to parse '" + uri2 + "' as a valid URI; request URI and Host header may be inconsistent", e);
                }
                uri = null;
            }
        }
        c5047n.m2222a(uri);
        m1520a(c5047n, httpRoute);
        HttpHost httpHost = (HttpHost) c5047n.getParams().getParameter("http.virtual-host");
        if (httpHost != null && httpHost.getPort() == -1) {
            int port = httpRoute.getTargetHost().getPort();
            if (port != -1) {
                httpHost = new HttpHost(httpHost.getHostName(), port, httpHost.getSchemeName());
            }
            if (Log.isLoggable(f22219a, 3)) {
                Log.d(f22219a, "Using virtual host" + httpHost);
            }
        }
        if (httpHost == null) {
            httpHost = (uri == null || !uri.isAbsolute() || uri.getHost() == null) ? null : new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        }
        HttpHost targetHost = httpHost == null ? httpRoute.getTargetHost() : httpHost;
        if (uri != null && (userInfo = uri.getUserInfo()) != null) {
            CredentialsProvider m2166i = c5057a.m2166i();
            if (m2166i == null) {
                m2166i = new C5180e();
                c5057a.m2177a(m2166i);
            }
            m2166i.setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()), new UsernamePasswordCredentials(userInfo));
        }
        c5057a.setAttribute(C5341c.f22386q, targetHost);
        c5057a.setAttribute(C5057a.f21566a, httpRoute);
        c5057a.setAttribute(C5341c.f22384o, c5047n);
        this.f22221c.process(c5047n, c5057a);
        AbstractC5035b mo1511a = this.f22220b.mo1511a(httpRoute, c5047n, c5057a, abstractC5039f);
        try {
            c5057a.setAttribute(C5341c.f22385p, mo1511a);
            this.f22221c.process(mo1511a, c5057a);
            return mo1511a;
        } catch (HttpException e2) {
            mo1511a.close();
            throw e2;
        } catch (IOException e3) {
            mo1511a.close();
            throw e3;
        } catch (RuntimeException e4) {
            mo1511a.close();
            throw e4;
        }
    }

    /* renamed from: a */
    void m1520a(C5047n c5047n, HttpRoute httpRoute) {
        try {
            URI uri = c5047n.getURI();
            if (uri == null) {
                return;
            }
            c5047n.m2222a((httpRoute.getProxyHost() == null || httpRoute.isTunnelled()) ? uri.isAbsolute() ? C5077i.m2098a(uri, (HttpHost) null, true) : C5077i.m2103a(uri) : !uri.isAbsolute() ? C5077i.m2098a(uri, httpRoute.getTargetHost(), true) : C5077i.m2103a(uri));
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid URI: " + c5047n.getRequestLine().getUri(), e);
        }
    }
}
