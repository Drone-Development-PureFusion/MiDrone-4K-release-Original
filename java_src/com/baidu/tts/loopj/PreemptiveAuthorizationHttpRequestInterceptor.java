package com.baidu.tts.loopj;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p281n.C5341c;
/* loaded from: classes.dex */
public class PreemptiveAuthorizationHttpRequestInterceptor implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Credentials credentials;
        AuthState authState = (AuthState) httpContext.getAttribute(C5057a.f21574i);
        CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute(C5057a.f21572g);
        HttpHost httpHost = (HttpHost) httpContext.getAttribute(C5341c.f22386q);
        if (authState.getAuthScheme() != null || (credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()))) == null) {
            return;
        }
        authState.setAuthScheme(new BasicScheme());
        authState.setCredentials(credentials);
    }
}
