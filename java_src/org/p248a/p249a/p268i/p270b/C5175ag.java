package org.p248a.p249a.p268i.p270b;

import com.facebook.common.util.UriUtil;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p252c.p253a.C5017a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5007d
/* renamed from: org.a.a.i.b.ag */
/* loaded from: classes2.dex */
public class C5175ag implements CredentialsProvider {

    /* renamed from: a */
    private static final Map<String, String> f21940a = new ConcurrentHashMap();

    /* renamed from: b */
    private final C5180e f21941b = new C5180e();

    static {
        f21940a.put(C5017a.f21475a.toUpperCase(Locale.ENGLISH), C5017a.f21475a);
        f21940a.put(C5017a.f21476b.toUpperCase(Locale.ENGLISH), C5017a.f21476b);
        f21940a.put(C5017a.f21477c.toUpperCase(Locale.ENGLISH), C5017a.f21477c);
        f21940a.put(C5017a.f21478d.toUpperCase(Locale.ENGLISH), "SPNEGO");
        f21940a.put(C5017a.f21479e.toUpperCase(Locale.ENGLISH), C5017a.f21479e);
    }

    /* renamed from: a */
    private static String m1788a(String str) {
        if (str == null) {
            return null;
        }
        String str2 = f21940a.get(str);
        return str2 == null ? str : str2;
    }

    /* renamed from: a */
    private static PasswordAuthentication m1787a(AuthScope authScope, Authenticator.RequestorType requestorType) {
        String host = authScope.getHost();
        int port = authScope.getPort();
        return Authenticator.requestPasswordAuthentication(host, null, port, port == 443 ? UriUtil.HTTPS_SCHEME : UriUtil.HTTP_SCHEME, null, m1788a(authScope.getScheme()), null, requestorType);
    }

    public void clear() {
        this.f21941b.clear();
    }

    public Credentials getCredentials(AuthScope authScope) {
        C5351a.m1321a(authScope, "Auth scope");
        Credentials credentials = this.f21941b.getCredentials(authScope);
        if (credentials != null) {
            return credentials;
        }
        if (authScope.getHost() != null) {
            PasswordAuthentication m1787a = m1787a(authScope, Authenticator.RequestorType.SERVER);
            PasswordAuthentication m1787a2 = m1787a == null ? m1787a(authScope, Authenticator.RequestorType.PROXY) : m1787a;
            if (m1787a2 != null) {
                String property = System.getProperty("http.auth.ntlm.domain");
                return property != null ? new NTCredentials(m1787a2.getUserName(), new String(m1787a2.getPassword()), (String) null, property) : C5017a.f21477c.equalsIgnoreCase(authScope.getScheme()) ? new NTCredentials(m1787a2.getUserName(), new String(m1787a2.getPassword()), (String) null, (String) null) : new UsernamePasswordCredentials(m1787a2.getUserName(), new String(m1787a2.getPassword()));
            }
        }
        return null;
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        this.f21941b.setCredentials(authScope, credentials);
    }
}
