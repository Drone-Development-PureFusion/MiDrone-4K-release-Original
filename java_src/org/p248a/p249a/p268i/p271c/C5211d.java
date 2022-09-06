package org.p248a.p249a.p268i.p271c;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p261f.AbstractC5130h;
import p004b.p005a.p006a.p028b.C0359h;
@AbstractC5006c
/* renamed from: org.a.a.i.c.d */
/* loaded from: classes2.dex */
class C5211d implements AbstractC5130h, HttpContext {

    /* renamed from: a */
    private volatile C5210c f22074a;

    C5211d(C5210c c5210c) {
        this.f22074a = c5210c;
    }

    /* renamed from: a */
    public static C5210c m1642a(HttpClientConnection httpClientConnection) {
        C5210c m1639d = m1640c(httpClientConnection).m1639d();
        if (m1639d == null) {
            throw new C5212e();
        }
        return m1639d;
    }

    /* renamed from: a */
    public static HttpClientConnection m1643a(C5210c c5210c) {
        return new C5211d(c5210c);
    }

    /* renamed from: b */
    public static C5210c m1641b(HttpClientConnection httpClientConnection) {
        return m1640c(httpClientConnection).m1638e();
    }

    /* renamed from: c */
    private static C5211d m1640c(HttpClientConnection httpClientConnection) {
        if (!C5211d.class.isInstance(httpClientConnection)) {
            throw new IllegalStateException("Unexpected connection proxy class: " + httpClientConnection.getClass());
        }
        return (C5211d) C5211d.class.cast(httpClientConnection);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5130h
    /* renamed from: a */
    public String mo1633a() {
        return m1636g().mo1633a();
    }

    @Override // org.p248a.p249a.p261f.AbstractC5130h
    /* renamed from: a */
    public void mo1644a(Socket socket) {
        m1636g().mo1644a(socket);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5130h
    /* renamed from: b */
    public Socket mo1632b() {
        return m1636g().mo1632b();
    }

    @Override // org.p248a.p249a.p261f.AbstractC5130h
    /* renamed from: c */
    public SSLSession mo1631c() {
        return m1636g().mo1631c();
    }

    public void close() {
        C5210c c5210c = this.f22074a;
        if (c5210c != null) {
            c5210c.m1646c();
        }
    }

    /* renamed from: d */
    C5210c m1639d() {
        return this.f22074a;
    }

    /* renamed from: e */
    C5210c m1638e() {
        C5210c c5210c = this.f22074a;
        this.f22074a = null;
        return c5210c;
    }

    /* renamed from: f */
    AbstractC5130h m1637f() {
        C5210c c5210c = this.f22074a;
        if (c5210c == null) {
            return null;
        }
        return c5210c.i();
    }

    public void flush() {
        m1636g().flush();
    }

    /* renamed from: g */
    AbstractC5130h m1636g() {
        AbstractC5130h m1637f = m1637f();
        if (m1637f == null) {
            throw new C5212e();
        }
        return m1637f;
    }

    public Object getAttribute(String str) {
        HttpContext m1636g = m1636g();
        if (m1636g instanceof HttpContext) {
            return m1636g.getAttribute(str);
        }
        return null;
    }

    public InetAddress getLocalAddress() {
        return m1636g().getLocalAddress();
    }

    public int getLocalPort() {
        return m1636g().getLocalPort();
    }

    public HttpConnectionMetrics getMetrics() {
        return m1636g().getMetrics();
    }

    public InetAddress getRemoteAddress() {
        return m1636g().getRemoteAddress();
    }

    public int getRemotePort() {
        return m1636g().getRemotePort();
    }

    public int getSocketTimeout() {
        return m1636g().getSocketTimeout();
    }

    public boolean isOpen() {
        C5210c c5210c = this.f22074a;
        return c5210c != null && !c5210c.mo1393e();
    }

    public boolean isResponseAvailable(int i) {
        return m1636g().isResponseAvailable(i);
    }

    public boolean isStale() {
        AbstractC5130h m1637f = m1637f();
        if (m1637f != null) {
            return m1637f.isStale();
        }
        return true;
    }

    public void receiveResponseEntity(HttpResponse httpResponse) {
        m1636g().receiveResponseEntity(httpResponse);
    }

    public HttpResponse receiveResponseHeader() {
        return m1636g().receiveResponseHeader();
    }

    public Object removeAttribute(String str) {
        HttpContext m1636g = m1636g();
        if (m1636g instanceof HttpContext) {
            return m1636g.removeAttribute(str);
        }
        return null;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        m1636g().sendRequestEntity(httpEntityEnclosingRequest);
    }

    public void sendRequestHeader(HttpRequest httpRequest) {
        m1636g().sendRequestHeader(httpRequest);
    }

    public void setAttribute(String str, Object obj) {
        HttpContext m1636g = m1636g();
        if (m1636g instanceof HttpContext) {
            m1636g.setAttribute(str, obj);
        }
    }

    public void setSocketTimeout(int i) {
        m1636g().setSocketTimeout(i);
    }

    public void shutdown() {
        C5210c c5210c = this.f22074a;
        if (c5210c != null) {
            c5210c.m1645d();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CPoolProxy{");
        AbstractC5130h m1637f = m1637f();
        if (m1637f != null) {
            sb.append(m1637f);
        } else {
            sb.append("detached");
        }
        sb.append(C0359h.f726w);
        return sb.toString();
    }
}
