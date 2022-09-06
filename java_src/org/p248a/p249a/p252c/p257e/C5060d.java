package org.p248a.p249a.p252c.p257e;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p251b.C5012d;
import org.p248a.p249a.p251b.EnumC5010b;
import org.p248a.p249a.p252c.AbstractC5016a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.c.e.d */
/* loaded from: classes2.dex */
public class C5060d implements HttpRequestInterceptor {

    /* renamed from: a */
    private static final String f21580a = "HttpClient";

    /* renamed from: a */
    private void m2160a(HttpHost httpHost, AuthScheme authScheme, C5012d c5012d, CredentialsProvider credentialsProvider) {
        String schemeName = authScheme.getSchemeName();
        if (Log.isLoggable(f21580a, 3)) {
            Log.d(f21580a, "Re-using cached '" + schemeName + "' auth scheme for " + httpHost);
        }
        Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort(), AuthScope.ANY_REALM, schemeName));
        if (credentials == null) {
            if (!Log.isLoggable(f21580a, 3)) {
                return;
            }
            Log.d(f21580a, "No credentials for preemptive authentication");
            return;
        }
        if ("BASIC".equalsIgnoreCase(authScheme.getSchemeName())) {
            c5012d.m2308a(EnumC5010b.CHALLENGED);
        } else {
            c5012d.m2308a(EnumC5010b.SUCCESS);
        }
        c5012d.m2306a(authScheme, credentials);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        AuthScheme mo1778a;
        AuthScheme mo1778a2;
        C5351a.m1321a(httpRequest, "HTTP request");
        C5351a.m1321a(httpContext, "HTTP context");
        C5057a m2176a = C5057a.m2176a(httpContext);
        AbstractC5016a m2165j = m2176a.m2165j();
        if (m2165j == null) {
            if (!Log.isLoggable(f21580a, 3)) {
                return;
            }
            Log.d(f21580a, "Auth cache not set in the context");
            return;
        }
        CredentialsProvider m2166i = m2176a.m2166i();
        if (m2166i == null) {
            if (!Log.isLoggable(f21580a, 3)) {
                return;
            }
            Log.d(f21580a, "Credentials provider not set in the context");
            return;
        }
        RouteInfo m2175b = m2176a.m2175b();
        if (m2175b == null) {
            if (!Log.isLoggable(f21580a, 3)) {
                return;
            }
            Log.d(f21580a, "Route info not set in the context");
            return;
        }
        HttpHost t = m2176a.t();
        if (t == null) {
            if (!Log.isLoggable(f21580a, 3)) {
                return;
            }
            Log.d(f21580a, "Target host not set in the context");
            return;
        }
        HttpHost httpHost = t.getPort() < 0 ? new HttpHost(t.getHostName(), m2175b.getTargetHost().getPort(), t.getSchemeName()) : t;
        C5012d m2164k = m2176a.m2164k();
        if (m2164k != null && m2164k.m2303b() == EnumC5010b.UNCHALLENGED && (mo1778a2 = m2165j.mo1778a(httpHost)) != null) {
            m2160a(httpHost, mo1778a2, m2164k, m2166i);
        }
        HttpHost proxyHost = m2175b.getProxyHost();
        C5012d m2163l = m2176a.m2163l();
        if (proxyHost == null || m2163l == null || m2163l.m2303b() != EnumC5010b.UNCHALLENGED || (mo1778a = m2165j.mo1778a(proxyHost)) == null) {
            return;
        }
        m2160a(proxyHost, mo1778a, m2163l, m2166i);
    }
}
