package org.p248a.p249a.p268i;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.g */
/* loaded from: classes2.dex */
public class C5291g implements ConnectionReuseStrategy {

    /* renamed from: a */
    public static final C5291g f22236a = new C5291g();

    /* renamed from: a */
    private boolean m1508a(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    /* renamed from: a */
    protected TokenIterator m1509a(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        boolean z = true;
        C5351a.m1321a(httpResponse, "HTTP response");
        C5351a.m1321a(httpContext, "HTTP context");
        ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
        Header firstHeader = httpResponse.getFirstHeader(C5083e.f21659W);
        if (firstHeader != null) {
            if (!"chunked".equalsIgnoreCase(firstHeader.getValue())) {
                return false;
            }
        } else if (m1508a(httpResponse)) {
            Header[] headers = httpResponse.getHeaders("Content-Length");
            if (headers.length != 1) {
                return false;
            }
            try {
                if (Integer.parseInt(headers[0].getValue()) < 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        HeaderIterator headerIterator = httpResponse.headerIterator(C5083e.f21675j);
        if (!headerIterator.hasNext()) {
            headerIterator = httpResponse.headerIterator("Proxy-Connection");
        }
        if (headerIterator.hasNext()) {
            try {
                TokenIterator m1509a = m1509a(headerIterator);
                boolean z2 = false;
                while (m1509a.hasNext()) {
                    String nextToken = m1509a.nextToken();
                    if ("Close".equalsIgnoreCase(nextToken)) {
                        return false;
                    }
                    if ("Keep-Alive".equalsIgnoreCase(nextToken)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    return true;
                }
            } catch (ParseException e2) {
                return false;
            }
        }
        if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
            z = false;
        }
        return z;
    }
}
