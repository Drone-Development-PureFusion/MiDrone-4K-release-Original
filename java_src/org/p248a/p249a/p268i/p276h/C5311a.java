package org.p248a.p249a.p268i.p276h;

import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.p248a.p249a.AbstractC5079d;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p260e.C5091f;
import org.p248a.p249a.p268i.C5206c;
import org.p248a.p249a.p268i.C5233d;
import org.p248a.p249a.p279l.C5324a;
import org.p248a.p249a.p280m.AbstractC5331b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.h.a */
/* loaded from: classes.dex */
public class C5311a implements AbstractC5331b<HttpHost, HttpClientConnection> {

    /* renamed from: a */
    private final SocketFactory f22313a;

    /* renamed from: b */
    private final SSLSocketFactory f22314b;

    /* renamed from: c */
    private final int f22315c;

    /* renamed from: d */
    private final C5091f f22316d;

    /* renamed from: e */
    private final AbstractC5079d<? extends HttpClientConnection> f22317e;

    public C5311a() {
        this(null, null, 0, C5091f.f21712a, C5084a.f21692a);
    }

    public C5311a(int i, C5091f c5091f, C5084a c5084a) {
        this(null, null, i, c5091f, c5084a);
    }

    public C5311a(SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, int i, C5091f c5091f, C5084a c5084a) {
        this.f22313a = socketFactory;
        this.f22314b = sSLSocketFactory;
        this.f22315c = i;
        this.f22316d = c5091f == null ? C5091f.f21712a : c5091f;
        this.f22317e = new C5233d(c5084a == null ? C5084a.f21692a : c5084a);
    }

    @Deprecated
    public C5311a(SSLSocketFactory sSLSocketFactory, HttpParams httpParams) {
        C5351a.m1321a(httpParams, "HTTP params");
        this.f22313a = null;
        this.f22314b = sSLSocketFactory;
        this.f22315c = httpParams.getIntParameter("http.connection.timeout", 0);
        this.f22316d = C5324a.m1428a(httpParams);
        this.f22317e = new C5233d(C5324a.m1426c(httpParams));
    }

    public C5311a(C5091f c5091f, C5084a c5084a) {
        this(null, null, 0, c5091f, c5084a);
    }

    @Deprecated
    public C5311a(HttpParams httpParams) {
        this((SSLSocketFactory) null, httpParams);
    }

    @Deprecated
    /* renamed from: a */
    protected HttpClientConnection m1474a(Socket socket, HttpParams httpParams) {
        C5206c c5206c = new C5206c(httpParams.getIntParameter("http.socket.buffer-size", 8192));
        c5206c.mo1537a(socket);
        return c5206c;
    }

    @Override // org.p248a.p249a.p280m.AbstractC5331b
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public HttpClientConnection mo1407a(HttpHost httpHost) {
        Socket socket;
        String schemeName = httpHost.getSchemeName();
        Socket socket2 = null;
        if (UriUtil.HTTP_SCHEME.equalsIgnoreCase(schemeName)) {
            socket2 = this.f22313a != null ? this.f22313a.createSocket() : new Socket();
        }
        if (UriUtil.HTTPS_SCHEME.equalsIgnoreCase(schemeName)) {
            socket = (this.f22314b != null ? this.f22314b : SSLSocketFactory.getDefault()).createSocket();
        } else {
            socket = socket2;
        }
        if (socket == null) {
            throw new IOException(schemeName + " scheme is not supported");
        }
        String hostName = httpHost.getHostName();
        int port = httpHost.getPort();
        if (port == -1) {
            if (httpHost.getSchemeName().equalsIgnoreCase(UriUtil.HTTP_SCHEME)) {
                port = 80;
            } else if (httpHost.getSchemeName().equalsIgnoreCase(UriUtil.HTTPS_SCHEME)) {
                port = 443;
            }
        }
        socket.setSoTimeout(this.f22316d.m2039a());
        socket.connect(new InetSocketAddress(hostName, port), this.f22315c);
        socket.setTcpNoDelay(this.f22316d.m2034e());
        int m2036c = this.f22316d.m2036c();
        if (m2036c >= 0) {
            socket.setSoLinger(m2036c > 0, m2036c);
        }
        socket.setKeepAlive(this.f22316d.m2035d());
        return this.f22317e.mo1534a(socket);
    }
}
