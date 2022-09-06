package org.p248a.p249a.p268i;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.HttpConnectionMetricsImpl;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p267h.C5137b;
import org.p248a.p249a.p268i.p273e.C5274b;
import org.p248a.p249a.p268i.p273e.C5275c;
import org.p248a.p249a.p268i.p275g.C5294c;
import org.p248a.p249a.p268i.p275g.C5295d;
import org.p248a.p249a.p268i.p275g.C5296e;
import org.p248a.p249a.p268i.p275g.C5297f;
import org.p248a.p249a.p268i.p275g.C5306o;
import org.p248a.p249a.p268i.p275g.C5307p;
import org.p248a.p249a.p268i.p275g.C5308q;
import org.p248a.p249a.p268i.p275g.C5309r;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
import org.p248a.p249a.p282o.C5355e;
@AbstractC5006c
/* renamed from: org.a.a.i.a */
/* loaded from: classes2.dex */
public class C5146a implements HttpConnection, HttpInetConnection {

    /* renamed from: a */
    private final C5308q f21811a;

    /* renamed from: b */
    private final C5309r f21812b;

    /* renamed from: c */
    private final HttpConnectionMetricsImpl f21813c;

    /* renamed from: d */
    private final ContentLengthStrategy f21814d;

    /* renamed from: e */
    private final ContentLengthStrategy f21815e;

    /* renamed from: f */
    private volatile boolean f21816f;

    /* renamed from: g */
    private volatile Socket f21817g;

    /* JADX INFO: Access modifiers changed from: protected */
    public C5146a(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, C5087c c5087c, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        C5351a.m1324a(i, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.f21811a = new C5308q(httpTransportMetricsImpl, i, -1, c5087c != null ? c5087c : C5087c.f21705a, charsetDecoder);
        this.f21812b = new C5309r(httpTransportMetricsImpl2, i, i2, charsetEncoder);
        this.f21813c = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        this.f21814d = contentLengthStrategy == null ? C5274b.f22180a : contentLengthStrategy;
        this.f21815e = contentLengthStrategy2 == null ? C5275c.f22182a : contentLengthStrategy2;
    }

    /* renamed from: b */
    private int m1929b(int i) {
        int soTimeout = this.f21817g.getSoTimeout();
        try {
            this.f21817g.setSoTimeout(i);
            return this.f21811a.m1486e();
        } finally {
            this.f21817g.setSoTimeout(soTimeout);
        }
    }

    /* renamed from: a */
    protected InputStream m1932a(long j, SessionInputBuffer sessionInputBuffer) {
        return j == -2 ? new C5294c(sessionInputBuffer) : j == -1 ? new C5306o(sessionInputBuffer) : new C5296e(sessionInputBuffer, j);
    }

    /* renamed from: a */
    protected OutputStream m1931a(long j, SessionOutputBuffer sessionOutputBuffer) {
        return j == -2 ? new C5295d(2048, sessionOutputBuffer) : j == -1 ? new C5307p(sessionOutputBuffer) : new C5297f(sessionOutputBuffer, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public OutputStream m1930a(HttpMessage httpMessage) {
        return m1931a(this.f21815e.determineLength(httpMessage), this.f21812b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1537a(Socket socket) {
        C5351a.m1321a(socket, "Socket");
        this.f21817g = socket;
        this.f21816f = true;
        this.f21811a.m1492a((InputStream) null);
        this.f21812b.m1481a((OutputStream) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m1933a(int i) {
        if (this.f21811a.m1485f()) {
            return true;
        }
        m1929b(i);
        return this.f21811a.m1485f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public InputStream mo1622b(Socket socket) {
        return socket.getInputStream();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Socket mo1632b() {
        return this.f21817g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public HttpEntity m1928b(HttpMessage httpMessage) {
        C5137b c5137b = new C5137b();
        long determineLength = this.f21814d.determineLength(httpMessage);
        InputStream m1932a = m1932a(determineLength, this.f21811a);
        if (determineLength == -2) {
            c5137b.a(true);
            c5137b.m1949a(-1L);
            c5137b.m1948a(m1932a);
        } else if (determineLength == -1) {
            c5137b.a(false);
            c5137b.m1949a(-1L);
            c5137b.m1948a(m1932a);
        } else {
            c5137b.a(false);
            c5137b.m1949a(determineLength);
            c5137b.m1948a(m1932a);
        }
        Header firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            c5137b.a(firstHeader);
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
            c5137b.b(firstHeader2);
        }
        return c5137b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public OutputStream mo1621c(Socket socket) {
        return socket.getOutputStream();
    }

    public void close() {
        if (!this.f21816f) {
            return;
        }
        this.f21816f = false;
        Socket socket = this.f21817g;
        try {
            this.f21811a.m1484g();
            this.f21812b.flush();
            try {
                try {
                    socket.shutdownOutput();
                } catch (IOException e) {
                }
                try {
                    socket.shutdownInput();
                } catch (IOException e2) {
                }
            } catch (UnsupportedOperationException e3) {
            }
        } finally {
            socket.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void m1927d() {
        C5352b.m1312a(this.f21816f, "Connection is not open");
        if (!this.f21811a.m1493a()) {
            this.f21811a.m1492a(mo1622b(this.f21817g));
        }
        if (!this.f21812b.m1482a()) {
            this.f21812b.m1481a(mo1621c(this.f21817g));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public SessionInputBuffer m1926e() {
        return this.f21811a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public SessionOutputBuffer m1925f() {
        return this.f21812b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void m1924g() {
        this.f21812b.flush();
    }

    public InetAddress getLocalAddress() {
        if (this.f21817g != null) {
            return this.f21817g.getLocalAddress();
        }
        return null;
    }

    public int getLocalPort() {
        if (this.f21817g != null) {
            return this.f21817g.getLocalPort();
        }
        return -1;
    }

    public HttpConnectionMetrics getMetrics() {
        return this.f21813c;
    }

    public InetAddress getRemoteAddress() {
        if (this.f21817g != null) {
            return this.f21817g.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        if (this.f21817g != null) {
            return this.f21817g.getPort();
        }
        return -1;
    }

    public int getSocketTimeout() {
        if (this.f21817g != null) {
            try {
                return this.f21817g.getSoTimeout();
            } catch (SocketException e) {
                return -1;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m1923h() {
        this.f21813c.incrementRequestCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public void m1922i() {
        this.f21813c.incrementResponseCount();
    }

    public boolean isOpen() {
        return this.f21816f;
    }

    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            return m1929b(1) < 0;
        } catch (SocketTimeoutException e) {
            return false;
        } catch (IOException e2) {
            return true;
        }
    }

    public void setSocketTimeout(int i) {
        if (this.f21817g != null) {
            try {
                this.f21817g.setSoTimeout(i);
            } catch (SocketException e) {
            }
        }
    }

    public void shutdown() {
        this.f21816f = false;
        Socket socket = this.f21817g;
        if (socket != null) {
            socket.close();
        }
    }

    public String toString() {
        if (this.f21817g != null) {
            StringBuilder sb = new StringBuilder();
            SocketAddress remoteSocketAddress = this.f21817g.getRemoteSocketAddress();
            SocketAddress localSocketAddress = this.f21817g.getLocalSocketAddress();
            if (remoteSocketAddress != null && localSocketAddress != null) {
                C5355e.m1298a(sb, localSocketAddress);
                sb.append("<->");
                C5355e.m1298a(sb, remoteSocketAddress);
            }
            return sb.toString();
        }
        return "[Not bound]";
    }
}
