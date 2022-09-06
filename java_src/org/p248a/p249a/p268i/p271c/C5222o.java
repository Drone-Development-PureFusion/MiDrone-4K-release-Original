package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentLengthStrategy;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p277j.AbstractC5319c;
@AbstractC5006c
/* renamed from: org.a.a.i.c.o */
/* loaded from: classes2.dex */
class C5222o extends C5215h {

    /* renamed from: a */
    private static final String f22096a = "HttpClient";

    /* renamed from: b */
    private static final String f22097b = "Headers";

    /* renamed from: c */
    private final C5232u f22098c;

    public C5222o(String str, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, C5087c c5087c, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, AbstractC5319c<HttpRequest> abstractC5319c, AbstractC5318b<HttpResponse> abstractC5318b) {
        super(str, i, i2, charsetDecoder, charsetEncoder, c5087c, contentLengthStrategy, contentLengthStrategy2, abstractC5319c, abstractC5318b);
        this.f22098c = new C5232u(str);
    }

    @Override // org.p248a.p249a.p268i.C5206c
    /* renamed from: a */
    protected void mo1624a(HttpRequest httpRequest) {
        if (httpRequest == null || !Log.isLoggable(f22097b, 3)) {
            return;
        }
        Log.d(f22097b, a() + " >> " + httpRequest.getRequestLine().toString());
        Header[] allHeaders = httpRequest.getAllHeaders();
        int length = allHeaders.length;
        for (int i = 0; i < length; i++) {
            Log.d(f22097b, a() + " >> " + allHeaders[i].toString());
        }
    }

    @Override // org.p248a.p249a.p268i.C5206c
    /* renamed from: a */
    protected void mo1623a(HttpResponse httpResponse) {
        if (httpResponse == null || !Log.isLoggable(f22097b, 3)) {
            return;
        }
        Log.d(f22097b, a() + " << " + httpResponse.getStatusLine().toString());
        Header[] allHeaders = httpResponse.getAllHeaders();
        int length = allHeaders.length;
        for (int i = 0; i < length; i++) {
            Log.d(f22097b, a() + " << " + allHeaders[i].toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p268i.C5146a
    /* renamed from: b */
    public InputStream mo1622b(Socket socket) {
        InputStream b = super.b(socket);
        return this.f22098c.m1580a() ? new C5221n(b, this.f22098c) : b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p268i.C5146a
    /* renamed from: c */
    public OutputStream mo1621c(Socket socket) {
        OutputStream c = super.c(socket);
        return this.f22098c.m1580a() ? new C5223p(c, this.f22098c) : c;
    }

    @Override // org.p248a.p249a.p268i.C5146a
    public void close() {
        if (Log.isLoggable(f22096a, 3)) {
            Log.d(f22096a, a() + ": Close connection");
        }
        super.close();
    }

    @Override // org.p248a.p249a.p268i.p271c.C5215h, org.p248a.p249a.p268i.C5146a
    public void shutdown() {
        if (Log.isLoggable(f22096a, 3)) {
            Log.d(f22096a, a() + ": Shutdown connection");
        }
        super.shutdown();
    }
}
