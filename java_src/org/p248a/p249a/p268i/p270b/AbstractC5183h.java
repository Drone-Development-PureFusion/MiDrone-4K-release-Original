package org.p248a.p249a.p268i.p270b;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p258f.C5077i;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5354d;
@AbstractC5007d
/* renamed from: org.a.a.i.b.h */
/* loaded from: classes2.dex */
public abstract class AbstractC5183h implements Closeable, HttpClient {

    /* renamed from: a */
    private static final String f21951a = "HttpClient";

    /* renamed from: b */
    private static HttpHost m1766b(HttpUriRequest httpUriRequest) {
        HttpHost httpHost = null;
        URI uri = httpUriRequest.getURI();
        if (!uri.isAbsolute() || (httpHost = C5077i.m2097b(uri)) != null) {
            return httpHost;
        }
        throw new ClientProtocolException("URI does not specify a valid host name: " + uri);
    }

    /* renamed from: a */
    public AbstractC5035b execute(HttpHost httpHost, HttpRequest httpRequest) {
        return mo1661a(httpHost, httpRequest, null);
    }

    /* renamed from: a */
    protected abstract AbstractC5035b mo1661a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext);

    /* renamed from: a */
    public AbstractC5035b execute(HttpUriRequest httpUriRequest) {
        return execute(httpUriRequest, (HttpContext) null);
    }

    /* renamed from: a */
    public AbstractC5035b execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        C5351a.m1321a(httpUriRequest, "HTTP request");
        return mo1661a(m1766b(httpUriRequest), httpUriRequest, httpContext);
    }

    /* renamed from: b */
    public AbstractC5035b execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return mo1661a(httpHost, httpRequest, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        C5351a.m1321a(responseHandler, "Response handler");
        AbstractC5035b execute = execute(httpHost, httpRequest, httpContext);
        try {
            T t = (T) responseHandler.handleResponse(execute);
            C5354d.m1303b(execute.getEntity());
            return t;
        } catch (Exception e) {
            try {
                C5354d.m1303b(execute.getEntity());
            } catch (Exception e2) {
                if (Log.isLoggable(f21951a, 5)) {
                    Log.w(f21951a, "Error consuming content after an exception.", e2);
                }
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            if (!(e instanceof IOException)) {
                throw new UndeclaredThrowableException(e);
            }
            throw ((IOException) e);
        }
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpUriRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) execute(m1766b(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }
}
