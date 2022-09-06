package org.p248a.p249a.p268i.p271c;

import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p261f.AbstractC5130h;
import org.p248a.p249a.p268i.C5206c;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p277j.AbstractC5319c;
@AbstractC5006c
/* renamed from: org.a.a.i.c.h */
/* loaded from: classes2.dex */
public class C5215h extends C5206c implements AbstractC5130h, HttpContext {

    /* renamed from: a */
    private final String f22081a;

    /* renamed from: b */
    private final Map<String, Object> f22082b;

    /* renamed from: c */
    private volatile boolean f22083c;

    public C5215h(String str, int i) {
        this(str, i, i, null, null, null, null, null, null, null);
    }

    public C5215h(String str, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, C5087c c5087c, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, AbstractC5319c<HttpRequest> abstractC5319c, AbstractC5318b<HttpResponse> abstractC5318b) {
        super(i, i2, charsetDecoder, charsetEncoder, c5087c, contentLengthStrategy, contentLengthStrategy2, abstractC5319c, abstractC5318b);
        this.f22081a = str;
        this.f22082b = new ConcurrentHashMap();
    }

    @Override // org.p248a.p249a.p261f.AbstractC5130h
    /* renamed from: a */
    public String mo1633a() {
        return this.f22081a;
    }

    @Override // org.p248a.p249a.p268i.C5206c, org.p248a.p249a.p268i.C5146a
    /* renamed from: a */
    public void mo1537a(Socket socket) {
        if (this.f22083c) {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        } else {
            super.mo1537a(socket);
        }
    }

    @Override // org.p248a.p249a.p268i.C5146a, org.p248a.p249a.p261f.AbstractC5130h
    /* renamed from: b */
    public Socket mo1632b() {
        return super.b();
    }

    @Override // org.p248a.p249a.p261f.AbstractC5130h
    /* renamed from: c */
    public SSLSession mo1631c() {
        Socket b = super.b();
        if (b instanceof SSLSocket) {
            return ((SSLSocket) b).getSession();
        }
        return null;
    }

    public Object getAttribute(String str) {
        return this.f22082b.get(str);
    }

    public Object removeAttribute(String str) {
        return this.f22082b.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        this.f22082b.put(str, obj);
    }

    @Override // org.p248a.p249a.p268i.C5146a
    public void shutdown() {
        this.f22083c = true;
        super.shutdown();
    }
}
