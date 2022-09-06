package org.p248a.p249a.p268i;

import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p268i.p275g.C5301j;
import org.p248a.p249a.p268i.p275g.C5303l;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p277j.AbstractC5319c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.c */
/* loaded from: classes2.dex */
public class C5206c extends C5146a implements HttpClientConnection {

    /* renamed from: a */
    private final HttpMessageParser f22052a;

    /* renamed from: b */
    private final HttpMessageWriter f22053b;

    public C5206c(int i) {
        this(i, i, null, null, null, null, null, null, null);
    }

    public C5206c(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, C5087c c5087c, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, AbstractC5319c<HttpRequest> abstractC5319c, AbstractC5318b<HttpResponse> abstractC5318b) {
        super(i, i2, charsetDecoder, charsetEncoder, c5087c, contentLengthStrategy, contentLengthStrategy2);
        this.f22053b = (abstractC5319c == null ? C5301j.f22279a : abstractC5319c).mo1465a(f());
        this.f22052a = (abstractC5318b == null ? C5303l.f22283a : abstractC5318b).mo1466a(e(), c5087c);
    }

    public C5206c(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, C5087c c5087c) {
        this(i, i, charsetDecoder, charsetEncoder, c5087c, null, null, null, null);
    }

    @Override // org.p248a.p249a.p268i.C5146a
    /* renamed from: a */
    public void mo1537a(Socket socket) {
        super.mo1537a(socket);
    }

    /* renamed from: a */
    protected void mo1624a(HttpRequest httpRequest) {
    }

    /* renamed from: a */
    protected void mo1623a(HttpResponse httpResponse) {
    }

    public void flush() {
        d();
        g();
    }

    public boolean isResponseAvailable(int i) {
        d();
        try {
            return a(i);
        } catch (SocketTimeoutException e) {
            return false;
        }
    }

    public void receiveResponseEntity(HttpResponse httpResponse) {
        C5351a.m1321a(httpResponse, "HTTP response");
        d();
        httpResponse.setEntity(b((HttpMessage) httpResponse));
    }

    public HttpResponse receiveResponseHeader() {
        d();
        HttpResponse httpResponse = (HttpResponse) this.f22052a.parse();
        mo1623a(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            i();
        }
        return httpResponse;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        C5351a.m1321a(httpEntityEnclosingRequest, "HTTP request");
        d();
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity == null) {
            return;
        }
        OutputStream a = a((HttpMessage) httpEntityEnclosingRequest);
        entity.writeTo(a);
        a.close();
    }

    public void sendRequestHeader(HttpRequest httpRequest) {
        C5351a.m1321a(httpRequest, "HTTP request");
        d();
        this.f22053b.write(httpRequest);
        mo1624a(httpRequest);
        h();
    }
}
