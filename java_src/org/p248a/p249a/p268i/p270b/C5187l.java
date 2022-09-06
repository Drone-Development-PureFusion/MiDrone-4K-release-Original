package org.p248a.p249a.p268i.p270b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.b.l */
/* loaded from: classes.dex */
public class C5187l implements HttpRequestRetryHandler {

    /* renamed from: a */
    public static final C5187l f21954a = new C5187l();

    /* renamed from: b */
    private final int f21955b;

    /* renamed from: c */
    private final boolean f21956c;

    /* renamed from: d */
    private final Set<Class<? extends IOException>> f21957d;

    public C5187l() {
        this(3, false);
    }

    public C5187l(int i, boolean z) {
        this(i, z, Arrays.asList(InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class));
    }

    protected C5187l(int i, boolean z, Collection<Class<? extends IOException>> collection) {
        this.f21955b = i;
        this.f21956c = z;
        this.f21957d = new HashSet();
        for (Class<? extends IOException> cls : collection) {
            this.f21957d.add(cls);
        }
    }

    /* renamed from: a */
    public boolean m1761a() {
        return this.f21956c;
    }

    /* renamed from: a */
    protected boolean mo1760a(HttpRequest httpRequest) {
        return !(httpRequest instanceof HttpEntityEnclosingRequest);
    }

    /* renamed from: b */
    public int m1759b() {
        return this.f21955b;
    }

    @Deprecated
    /* renamed from: b */
    protected boolean m1758b(HttpRequest httpRequest) {
        HttpRequest original = httpRequest instanceof RequestWrapper ? ((RequestWrapper) httpRequest).getOriginal() : httpRequest;
        return (original instanceof HttpUriRequest) && ((HttpUriRequest) original).isAborted();
    }

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        C5351a.m1321a(iOException, "Exception parameter");
        C5351a.m1321a(httpContext, "HTTP context");
        if (i <= this.f21955b && !this.f21957d.contains(iOException.getClass())) {
            for (Class<? extends IOException> cls : this.f21957d) {
                if (cls.isInstance(iOException)) {
                    return false;
                }
            }
            C5057a m2176a = C5057a.m2176a(httpContext);
            HttpRequest q = m2176a.q();
            if (m1758b(q)) {
                return false;
            }
            if (mo1760a(q)) {
                return true;
            }
            return !m2176a.r() || this.f21956c;
        }
        return false;
    }
}
