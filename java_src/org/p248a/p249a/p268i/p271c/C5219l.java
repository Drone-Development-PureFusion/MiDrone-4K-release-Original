package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p260e.AbstractC5086b;
import org.p248a.p249a.p260e.C5091f;
import org.p248a.p249a.p261f.AbstractC5103b;
import org.p248a.p249a.p261f.AbstractC5130h;
import org.p248a.p249a.p261f.AbstractC5131i;
import org.p248a.p249a.p261f.C5132j;
import org.p248a.p249a.p261f.p263b.AbstractC5104a;
import org.p248a.p249a.p261f.p263b.AbstractC5105b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.c.l */
/* loaded from: classes2.dex */
class C5219l {

    /* renamed from: a */
    static final String f22087a = "http.socket-factory-registry";

    /* renamed from: b */
    private static final String f22088b = "HttpClient";

    /* renamed from: c */
    private final AbstractC5086b<AbstractC5104a> f22089c;

    /* renamed from: d */
    private final AbstractC5131i f22090d;

    /* renamed from: e */
    private final AbstractC5103b f22091e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5219l(AbstractC5086b<AbstractC5104a> abstractC5086b, AbstractC5131i abstractC5131i, AbstractC5103b abstractC5103b) {
        C5351a.m1321a(abstractC5086b, "Socket factory registry");
        this.f22089c = abstractC5086b;
        this.f22090d = abstractC5131i == null ? C5218k.f22086a : abstractC5131i;
        this.f22091e = abstractC5103b == null ? C5229s.f22118a : abstractC5103b;
    }

    /* renamed from: a */
    private static String m1629a(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
        return "Connect to " + (httpHost != null ? httpHost.toHostString() : "remote host") + ((inetAddressArr == null || inetAddressArr.length <= 0) ? "" : " " + Arrays.asList(inetAddressArr)) + ((iOException == null || iOException.getMessage() == null) ? " timed out" : " failed: " + iOException.getMessage());
    }

    /* renamed from: a */
    private AbstractC5086b<AbstractC5104a> m1626a(HttpContext httpContext) {
        AbstractC5086b<AbstractC5104a> abstractC5086b = (AbstractC5086b) httpContext.getAttribute(f22087a);
        return abstractC5086b == null ? this.f22089c : abstractC5086b;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0115 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1628a(AbstractC5130h abstractC5130h, HttpHost httpHost, InetSocketAddress inetSocketAddress, int i, C5091f c5091f, HttpContext httpContext) {
        AbstractC5104a mo2043a = m1626a(httpContext).mo2043a(httpHost.getSchemeName());
        if (mo2043a == null) {
            throw new C5132j(httpHost.getSchemeName() + " protocol is not supported");
        }
        InetAddress[] mo1584a = this.f22091e.mo1584a(httpHost.getHostName());
        int mo1630a = this.f22090d.mo1630a(httpHost);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= mo1584a.length) {
                return;
            }
            InetAddress inetAddress = mo1584a[i3];
            boolean z = i3 == mo1584a.length + (-1);
            Socket mo1987a = mo2043a.mo1987a(httpContext);
            mo1987a.setSoTimeout(c5091f.m2039a());
            mo1987a.setReuseAddress(c5091f.m2037b());
            mo1987a.setTcpNoDelay(c5091f.m2034e());
            mo1987a.setKeepAlive(c5091f.m2035d());
            int m2036c = c5091f.m2036c();
            if (m2036c >= 0) {
                mo1987a.setSoLinger(m2036c > 0, m2036c);
            }
            abstractC5130h.mo1644a(mo1987a);
            InetSocketAddress inetSocketAddress2 = new InetSocketAddress(inetAddress, mo1630a);
            if (Log.isLoggable(f22088b, 3)) {
                Log.d(f22088b, "Connecting to " + inetSocketAddress2);
            }
            try {
                abstractC5130h.mo1644a(mo2043a.mo1992a(i, mo1987a, httpHost, inetSocketAddress2, inetSocketAddress, httpContext));
                if (!Log.isLoggable(f22088b, 3)) {
                    return;
                }
                Log.d(f22088b, "Connection established " + abstractC5130h);
                return;
            } catch (ConnectException e) {
                if (z) {
                    if (!"Connection timed out".equals(e.getMessage())) {
                        throw new HttpHostConnectException(httpHost, e);
                    }
                    ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException(m1629a(e, httpHost, mo1584a));
                    connectTimeoutException.initCause(e);
                    throw connectTimeoutException;
                }
                if (!Log.isLoggable(f22088b, 3)) {
                    Log.d(f22088b, "Connect to " + inetSocketAddress2 + " timed out. Connection will be retried using another IP address");
                }
                i2 = i3 + 1;
            } catch (SocketTimeoutException e2) {
                if (z) {
                    new ConnectTimeoutException(m1629a(e2, httpHost, mo1584a)).initCause(e2);
                }
                if (!Log.isLoggable(f22088b, 3)) {
                }
                i2 = i3 + 1;
            }
            i2 = i3 + 1;
        }
    }

    /* renamed from: a */
    public void m1627a(AbstractC5130h abstractC5130h, HttpHost httpHost, HttpContext httpContext) {
        AbstractC5104a mo2043a = m1626a(C5057a.m2176a(httpContext)).mo2043a(httpHost.getSchemeName());
        if (mo2043a == null) {
            throw new C5132j(httpHost.getSchemeName() + " protocol is not supported");
        }
        if (!(mo2043a instanceof AbstractC5105b)) {
            throw new C5132j(httpHost.getSchemeName() + " protocol does not support connection upgrade");
        }
        abstractC5130h.mo1644a(((AbstractC5105b) mo2043a).mo1990a(abstractC5130h.mo1632b(), httpHost.getHostName(), this.f22090d.mo1630a(httpHost), httpContext));
    }
}
