package org.p248a.p249a.p281n;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.n.l */
/* loaded from: classes2.dex */
public class C5350l implements HttpResponseInterceptor {
    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        C5351a.m1321a(httpResponse, "HTTP response");
        C5341c m1348b = C5341c.m1348b(httpContext);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 400 || statusCode == 408 || statusCode == 411 || statusCode == 413 || statusCode == 414 || statusCode == 503 || statusCode == 501) {
            httpResponse.setHeader(C5083e.f21675j, "Close");
            return;
        }
        Header firstHeader = httpResponse.getFirstHeader(C5083e.f21675j);
        if (firstHeader != null && "Close".equalsIgnoreCase(firstHeader.getValue())) {
            return;
        }
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
            if (entity.getContentLength() < 0 && (!entity.isChunked() || protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) {
                httpResponse.setHeader(C5083e.f21675j, "Close");
                return;
            }
        }
        HttpRequest m1345q = m1348b.m1345q();
        if (m1345q == null) {
            return;
        }
        Header firstHeader2 = m1345q.getFirstHeader(C5083e.f21675j);
        if (firstHeader2 != null) {
            httpResponse.setHeader(C5083e.f21675j, firstHeader2.getValue());
        } else if (!m1345q.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
        } else {
            httpResponse.setHeader(C5083e.f21675j, "Close");
        }
    }
}
