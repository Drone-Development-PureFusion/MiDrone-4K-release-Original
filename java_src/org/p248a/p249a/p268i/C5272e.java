package org.p248a.p249a.p268i;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p268i.p273e.C5273a;
import org.p248a.p249a.p268i.p275g.C5299h;
import org.p248a.p249a.p268i.p275g.C5305n;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p277j.AbstractC5319c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.e */
/* loaded from: classes2.dex */
public class C5272e extends C5146a implements HttpServerConnection {

    /* renamed from: a */
    private final HttpMessageParser f22176a;

    /* renamed from: b */
    private final HttpMessageWriter f22177b;

    public C5272e(int i) {
        this(i, i, null, null, null, null, null, null, null);
    }

    public C5272e(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, C5087c c5087c, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, AbstractC5318b<HttpRequest> abstractC5318b, AbstractC5319c<HttpResponse> abstractC5319c) {
        super(i, i2, charsetDecoder, charsetEncoder, c5087c, contentLengthStrategy != null ? contentLengthStrategy : C5273a.f22178a, contentLengthStrategy2);
        this.f22176a = (abstractC5318b == null ? C5299h.f22276a : abstractC5318b).mo1466a(e(), c5087c);
        this.f22177b = (abstractC5319c == null ? C5305n.f22286a : abstractC5319c).mo1465a(f());
    }

    public C5272e(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, C5087c c5087c) {
        this(i, i, charsetDecoder, charsetEncoder, c5087c, null, null, null, null);
    }

    @Override // org.p248a.p249a.p268i.C5146a
    /* renamed from: a */
    public void mo1537a(Socket socket) {
        super.mo1537a(socket);
    }

    /* renamed from: a */
    protected void m1536a(HttpRequest httpRequest) {
    }

    /* renamed from: a */
    protected void m1535a(HttpResponse httpResponse) {
    }

    public void flush() {
        d();
        g();
    }

    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        C5351a.m1321a(httpEntityEnclosingRequest, "HTTP request");
        d();
        httpEntityEnclosingRequest.setEntity(b((HttpMessage) httpEntityEnclosingRequest));
    }

    public HttpRequest receiveRequestHeader() {
        d();
        HttpRequest httpRequest = (HttpRequest) this.f22176a.parse();
        m1536a(httpRequest);
        h();
        return httpRequest;
    }

    public void sendResponseEntity(HttpResponse httpResponse) {
        C5351a.m1321a(httpResponse, "HTTP response");
        d();
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            return;
        }
        OutputStream a = a((HttpMessage) httpResponse);
        entity.writeTo(a);
        a.close();
    }

    public void sendResponseHeader(HttpResponse httpResponse) {
        C5351a.m1321a(httpResponse, "HTTP response");
        d();
        this.f22177b.write(httpResponse);
        m1535a(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            i();
        }
    }
}
