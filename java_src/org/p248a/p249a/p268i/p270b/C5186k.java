package org.p248a.p249a.p268i.p270b;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.b.k */
/* loaded from: classes2.dex */
public class C5186k implements ConnectionKeepAliveStrategy {

    /* renamed from: a */
    public static final C5186k f21953a = new C5186k();

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        C5351a.m1321a(httpResponse, "HTTP response");
        HeaderElementIterator basicHeaderElementIterator = new BasicHeaderElementIterator(httpResponse.headerIterator("Keep-Alive"));
        while (basicHeaderElementIterator.hasNext()) {
            HeaderElement nextElement = basicHeaderElementIterator.nextElement();
            String name = nextElement.getName();
            String value = nextElement.getValue();
            if (value != null && name.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value) * 1000;
                } catch (NumberFormatException e) {
                }
            }
        }
        return -1L;
    }
}
