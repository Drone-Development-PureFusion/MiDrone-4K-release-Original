package org.p248a.p249a.p268i.p274f;

import android.util.Log;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.conn.routing.HttpRoute;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.f.l */
/* loaded from: classes2.dex */
public class C5288l implements AbstractC5278b {

    /* renamed from: a */
    private static final String f22229a = "HttpClient";

    /* renamed from: b */
    private final AbstractC5278b f22230b;

    /* renamed from: c */
    private final HttpRequestRetryHandler f22231c;

    public C5288l(AbstractC5278b abstractC5278b, HttpRequestRetryHandler httpRequestRetryHandler) {
        C5351a.m1321a(abstractC5278b, "HTTP request executor");
        C5351a.m1321a(httpRequestRetryHandler, "HTTP request retry handler");
        this.f22230b = abstractC5278b;
        this.f22231c = httpRequestRetryHandler;
    }

    @Override // org.p248a.p249a.p268i.p274f.AbstractC5278b
    /* renamed from: a */
    public AbstractC5035b mo1511a(HttpRoute httpRoute, C5047n c5047n, C5057a c5057a, AbstractC5039f abstractC5039f) {
        int i;
        C5351a.m1321a(httpRoute, "HTTP route");
        C5351a.m1321a(c5047n, "HTTP request");
        C5351a.m1321a(c5057a, "HTTP context");
        Header[] allHeaders = c5047n.getAllHeaders();
        int i2 = 1;
        while (true) {
            try {
                i = i2;
                return this.f22230b.mo1511a(httpRoute, c5047n, c5057a, abstractC5039f);
            } catch (IOException e) {
                if (abstractC5039f != null && abstractC5039f.isAborted()) {
                    if (Log.isLoggable(f22229a, 3)) {
                        Log.d(f22229a, "Request has been aborted");
                    }
                    throw e;
                } else if (!this.f22231c.retryRequest(e, i, c5057a)) {
                    if (!(e instanceof NoHttpResponseException)) {
                        throw e;
                    }
                    NoHttpResponseException noHttpResponseException = new NoHttpResponseException(httpRoute.getTargetHost().toHostString() + " failed to respond");
                    noHttpResponseException.setStackTrace(e.getStackTrace());
                    throw noHttpResponseException;
                } else {
                    if (Log.isLoggable(f22229a, 4)) {
                        Log.i(f22229a, "I/O exception (" + e.getClass().getName() + ") caught when processing request to " + httpRoute + ": " + e.getMessage());
                    }
                    if (Log.isLoggable(f22229a, 3)) {
                        Log.d(f22229a, e.getMessage(), e);
                    }
                    if (!C5286j.m1516a((HttpRequest) c5047n)) {
                        if (Log.isLoggable(f22229a, 3)) {
                            Log.d(f22229a, "Cannot retry non-repeatable request");
                        }
                        new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity").initCause(e);
                    }
                    c5047n.setHeaders(allHeaders);
                    if (Log.isLoggable(f22229a, 4)) {
                        Log.i(f22229a, "Retrying request to " + httpRoute);
                    }
                    i2 = i + 1;
                }
            }
        }
    }
}
