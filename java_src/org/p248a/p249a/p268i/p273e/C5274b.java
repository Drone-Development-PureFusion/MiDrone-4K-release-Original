package org.p248a.p249a.p268i.p273e;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.e.b */
/* loaded from: classes2.dex */
public class C5274b implements ContentLengthStrategy {

    /* renamed from: a */
    public static final C5274b f22180a = new C5274b();

    /* renamed from: b */
    private final int f22181b;

    public C5274b() {
        this(-1);
    }

    public C5274b(int i) {
        this.f22181b = i;
    }

    public long determineLength(HttpMessage httpMessage) {
        long j;
        C5351a.m1321a(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader(C5083e.f21659W);
        if (firstHeader != null) {
            try {
                HeaderElement[] elements = firstHeader.getElements();
                int length = elements.length;
                return (!"identity".equalsIgnoreCase(firstHeader.getValue()) && length > 0 && "chunked".equalsIgnoreCase(elements[length + (-1)].getName())) ? -2L : -1L;
            } catch (ParseException e) {
                throw new ProtocolException("Invalid Transfer-Encoding header value: " + firstHeader, e);
            }
        } else if (httpMessage.getFirstHeader("Content-Length") == null) {
            return this.f22181b;
        } else {
            Header[] headers = httpMessage.getHeaders("Content-Length");
            int length2 = headers.length - 1;
            while (true) {
                if (length2 < 0) {
                    j = -1;
                    break;
                }
                try {
                    j = Long.parseLong(headers[length2].getValue());
                    break;
                } catch (NumberFormatException e2) {
                    length2--;
                }
            }
            if (j < 0) {
                return -1L;
            }
            return j;
        }
    }
}
