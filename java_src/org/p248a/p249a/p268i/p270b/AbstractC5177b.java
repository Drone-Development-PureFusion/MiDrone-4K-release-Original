package org.p248a.p249a.p268i.p270b;

import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p251b.AbstractC5011c;
import org.p248a.p249a.p251b.C5009a;
import org.p248a.p249a.p252c.AbstractC5016a;
import org.p248a.p249a.p252c.AbstractC5021b;
import org.p248a.p249a.p252c.p253a.C5017a;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p260e.AbstractC5086b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.b.b */
/* loaded from: classes2.dex */
abstract class AbstractC5177b implements AbstractC5021b {

    /* renamed from: a */
    private static final String f21943a = "HttpClient";

    /* renamed from: b */
    private static final List<String> f21944b = Collections.unmodifiableList(Arrays.asList(C5017a.f21478d, C5017a.f21479e, C5017a.f21477c, C5017a.f21476b, C5017a.f21475a));

    /* renamed from: c */
    private final int f21945c;

    /* renamed from: d */
    private final String f21946d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5177b(int i, String str) {
        this.f21945c = i;
        this.f21946d = str;
    }

    /* renamed from: a */
    abstract Collection<String> mo1785a(C5019c c5019c);

    @Override // org.p248a.p249a.p252c.AbstractC5021b
    /* renamed from: a */
    public Queue<C5009a> mo1786a(Map<String, Header> map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        C5351a.m1321a(map, "Map of auth challenges");
        C5351a.m1321a(httpHost, C5083e.f21691z);
        C5351a.m1321a(httpResponse, "HTTP response");
        C5351a.m1321a(httpContext, "HTTP context");
        C5057a m2176a = C5057a.m2176a(httpContext);
        LinkedList linkedList = new LinkedList();
        AbstractC5086b<AbstractC5011c> m2167h = m2176a.m2167h();
        if (m2167h == null) {
            if (Log.isLoggable(f21943a, 3)) {
                Log.d(f21943a, "Auth scheme registry not set in the context");
            }
            return linkedList;
        }
        CredentialsProvider m2166i = m2176a.m2166i();
        if (m2166i == null) {
            if (Log.isLoggable(f21943a, 3)) {
                Log.d(f21943a, "Credentials provider not set in the context");
            }
            return linkedList;
        }
        Collection<String> mo1785a = mo1785a(m2176a.m2161n());
        if (mo1785a == null) {
            mo1785a = f21944b;
        }
        if (Log.isLoggable(f21943a, 3)) {
            Log.d(f21943a, "Authentication schemes in the order of preference: " + mo1785a);
        }
        for (String str : mo1785a) {
            Header header = map.get(str.toLowerCase(Locale.ENGLISH));
            if (header != null) {
                AbstractC5011c mo2043a = m2167h.mo2043a(str);
                if (mo2043a != null) {
                    AuthScheme mo1811a = mo2043a.mo1811a(httpContext);
                    mo1811a.processChallenge(header);
                    Credentials credentials = m2166i.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort(), mo1811a.getRealm(), mo1811a.getSchemeName()));
                    if (credentials != null) {
                        linkedList.add(new C5009a(mo1811a, credentials));
                    }
                } else if (Log.isLoggable(f21943a, 5)) {
                    Log.w(f21943a, "Authentication scheme " + str + " not supported");
                }
            } else if (Log.isLoggable(f21943a, 3)) {
                Log.d(f21943a, "Challenge for " + str + " authentication scheme not available");
            }
        }
        return linkedList;
    }

    @Override // org.p248a.p249a.p252c.AbstractC5021b
    /* renamed from: a */
    public void mo1783a(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        C5351a.m1321a(httpHost, C5083e.f21691z);
        C5351a.m1321a(authScheme, "Auth scheme");
        C5351a.m1321a(httpContext, "HTTP context");
        C5057a m2176a = C5057a.m2176a(httpContext);
        if (m1782a(authScheme)) {
            AbstractC5016a m2165j = m2176a.m2165j();
            if (m2165j == null) {
                m2165j = new C5178c();
                m2176a.m2180a(m2165j);
            }
            if (Log.isLoggable(f21943a, 3)) {
                Log.d(f21943a, "Caching '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
            }
            m2165j.mo1777a(httpHost, authScheme);
        }
    }

    @Override // org.p248a.p249a.p252c.AbstractC5021b
    /* renamed from: a */
    public boolean mo1784a(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        C5351a.m1321a(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == this.f21945c;
    }

    /* renamed from: a */
    protected boolean m1782a(AuthScheme authScheme) {
        if (authScheme == null || !authScheme.isComplete()) {
            return false;
        }
        String schemeName = authScheme.getSchemeName();
        return schemeName.equalsIgnoreCase(C5017a.f21475a) || schemeName.equalsIgnoreCase(C5017a.f21476b);
    }

    @Override // org.p248a.p249a.p252c.AbstractC5021b
    /* renamed from: b */
    public Map<String, Header> mo1781b(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        CharArrayBuffer charArrayBuffer;
        int i;
        C5351a.m1321a(httpResponse, "HTTP response");
        FormattedHeader[] headers = httpResponse.getHeaders(this.f21946d);
        HashMap hashMap = new HashMap(headers.length);
        for (FormattedHeader formattedHeader : headers) {
            if (formattedHeader instanceof FormattedHeader) {
                charArrayBuffer = formattedHeader.getBuffer();
                i = formattedHeader.getValuePos();
            } else {
                String value = formattedHeader.getValue();
                if (value == null) {
                    throw new MalformedChallengeException("Header value is null");
                }
                CharArrayBuffer charArrayBuffer2 = new CharArrayBuffer(value.length());
                charArrayBuffer2.append(value);
                charArrayBuffer = charArrayBuffer2;
                i = 0;
            }
            while (i < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(i))) {
                i++;
            }
            int i2 = i;
            while (i2 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(i2))) {
                i2++;
            }
            hashMap.put(charArrayBuffer.substring(i, i2).toLowerCase(Locale.ENGLISH), formattedHeader);
        }
        return hashMap;
    }

    @Override // org.p248a.p249a.p252c.AbstractC5021b
    /* renamed from: b */
    public void mo1780b(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        C5351a.m1321a(httpHost, C5083e.f21691z);
        C5351a.m1321a(httpContext, "HTTP context");
        AbstractC5016a m2165j = C5057a.m2176a(httpContext).m2165j();
        if (m2165j != null) {
            if (Log.isLoggable(f21943a, 3)) {
                Log.d(f21943a, "Clearing cached auth scheme for " + httpHost);
            }
            m2165j.mo1776b(httpHost);
        }
    }
}
