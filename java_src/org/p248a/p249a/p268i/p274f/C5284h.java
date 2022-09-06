package org.p248a.p249a.p268i.p274f;

import android.util.Log;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.RedirectException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p251b.C5012d;
import org.p248a.p249a.p252c.AbstractC5056e;
import org.p248a.p249a.p252c.p253a.C5019c;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p252c.p258f.C5077i;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5354d;
@AbstractC5007d
/* renamed from: org.a.a.i.f.h */
/* loaded from: classes2.dex */
public class C5284h implements AbstractC5278b {

    /* renamed from: a */
    private static final String f22222a = "HttpClient";

    /* renamed from: b */
    private final AbstractC5278b f22223b;

    /* renamed from: c */
    private final AbstractC5056e f22224c;

    /* renamed from: d */
    private final HttpRoutePlanner f22225d;

    public C5284h(AbstractC5278b abstractC5278b, HttpRoutePlanner httpRoutePlanner, AbstractC5056e abstractC5056e) {
        C5351a.m1321a(abstractC5278b, "HTTP client request executor");
        C5351a.m1321a(httpRoutePlanner, "HTTP route planner");
        C5351a.m1321a(abstractC5056e, "HTTP redirect strategy");
        this.f22223b = abstractC5278b;
        this.f22225d = httpRoutePlanner;
        this.f22224c = abstractC5056e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0167, code lost:
        return r6;
     */
    @Override // org.p248a.p249a.p268i.p274f.AbstractC5278b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC5035b mo1511a(HttpRoute httpRoute, C5047n c5047n, C5057a c5057a, AbstractC5039f abstractC5039f) {
        AuthScheme m2302c;
        C5351a.m1321a(httpRoute, "HTTP route");
        C5351a.m1321a(c5047n, "HTTP request");
        C5351a.m1321a(c5057a, "HTTP context");
        List<URI> m2172c = c5057a.m2172c();
        if (m2172c != null) {
            m2172c.clear();
        }
        C5019c m2161n = c5057a.m2161n();
        int m2286i = m2161n.m2286i() > 0 ? m2161n.m2286i() : 50;
        int i = 0;
        HttpEntityEnclosingRequest httpEntityEnclosingRequest = c5047n;
        while (true) {
            AbstractC5035b mo1511a = this.f22223b.mo1511a(httpRoute, httpEntityEnclosingRequest, c5057a, abstractC5039f);
            try {
                if (!m2161n.m2289f() || !this.f22224c.mo1756a(httpEntityEnclosingRequest, mo1511a, c5057a)) {
                    break;
                } else if (i >= m2286i) {
                    throw new RedirectException("Maximum redirects (" + m2286i + ") exceeded");
                } else {
                    int i2 = i + 1;
                    HttpUriRequest mo1755b = this.f22224c.mo1755b(httpEntityEnclosingRequest, mo1511a, c5057a);
                    if (!mo1755b.headerIterator().hasNext()) {
                        mo1755b.setHeaders(c5047n.m2223a().getAllHeaders());
                    }
                    httpEntityEnclosingRequest = C5047n.m2221a((HttpRequest) mo1755b);
                    if (httpEntityEnclosingRequest instanceof HttpEntityEnclosingRequest) {
                        C5286j.m1517a(httpEntityEnclosingRequest);
                    }
                    URI uri = httpEntityEnclosingRequest.getURI();
                    HttpHost m2097b = C5077i.m2097b(uri);
                    if (m2097b == null) {
                        throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
                    }
                    if (!httpRoute.getTargetHost().equals(m2097b)) {
                        C5012d m2164k = c5057a.m2164k();
                        if (m2164k != null) {
                            if (Log.isLoggable(f22222a, 3)) {
                                Log.d(f22222a, "Resetting target auth state");
                            }
                            m2164k.m2310a();
                        }
                        C5012d m2163l = c5057a.m2163l();
                        if (m2163l != null && (m2302c = m2163l.m2302c()) != null && m2302c.isConnectionBased()) {
                            if (Log.isLoggable(f22222a, 3)) {
                                Log.d(f22222a, "Resetting proxy auth state");
                            }
                            m2163l.m2310a();
                        }
                    }
                    httpRoute = this.f22225d.determineRoute(m2097b, httpEntityEnclosingRequest, c5057a);
                    if (Log.isLoggable(f22222a, 3)) {
                        Log.d(f22222a, "Redirecting to '" + uri + "' via " + httpRoute);
                    }
                    C5354d.m1303b(mo1511a.getEntity());
                    i = i2;
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (HttpException e2) {
                try {
                    C5354d.m1303b(mo1511a.getEntity());
                } catch (IOException e3) {
                    if (Log.isLoggable(f22222a, 3)) {
                        Log.d(f22222a, "I/O error while releasing connection", e3);
                    }
                } finally {
                    mo1511a.close();
                }
                throw e2;
            } catch (IOException e4) {
                throw e4;
            }
        }
    }
}
