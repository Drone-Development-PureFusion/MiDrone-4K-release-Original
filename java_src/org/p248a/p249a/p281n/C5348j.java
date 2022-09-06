package org.p248a.p249a.p281n;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.n.j */
/* loaded from: classes2.dex */
public class C5348j implements HttpRequestInterceptor {
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        HttpHost httpHost;
        C5351a.m1321a(httpRequest, "HTTP request");
        C5341c m1348b = C5341c.m1348b(httpContext);
        ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
        if ((!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) && !httpRequest.containsHeader(C5083e.f21691z)) {
            HttpHost m1342t = m1348b.m1342t();
            if (m1342t == null) {
                HttpInetConnection m1346p = m1348b.m1346p();
                if (m1346p instanceof HttpInetConnection) {
                    InetAddress remoteAddress = m1346p.getRemoteAddress();
                    int remotePort = m1346p.getRemotePort();
                    if (remoteAddress != null) {
                        httpHost = new HttpHost(remoteAddress.getHostName(), remotePort);
                        if (httpHost == null) {
                            if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                                return;
                            }
                            throw new ProtocolException("Target host missing");
                        }
                    }
                }
                httpHost = m1342t;
                if (httpHost == null) {
                }
            } else {
                httpHost = m1342t;
            }
            httpRequest.addHeader(C5083e.f21691z, httpHost.toHostString());
        }
    }
}
