package org.p248a.p249a.p268i.p273e;

import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.e.c */
/* loaded from: classes2.dex */
public class C5275c implements ContentLengthStrategy {

    /* renamed from: a */
    public static final C5275c f22182a = new C5275c();

    /* renamed from: b */
    private final int f22183b;

    public C5275c() {
        this(-1);
    }

    public C5275c(int i) {
        this.f22183b = i;
    }

    public long determineLength(HttpMessage httpMessage) {
        C5351a.m1321a(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader(C5083e.f21659W);
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if ("chunked".equalsIgnoreCase(value)) {
                if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    return -2L;
                }
                throw new ProtocolException("Chunked transfer encoding not allowed for " + httpMessage.getProtocolVersion());
            } else if (!"identity".equalsIgnoreCase(value)) {
                throw new ProtocolException("Unsupported transfer encoding: " + value);
            } else {
                return -1L;
            }
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
        if (firstHeader2 == null) {
            return this.f22183b;
        }
        String value2 = firstHeader2.getValue();
        try {
            long parseLong = Long.parseLong(value2);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new ProtocolException("Negative content length: " + value2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Invalid content length: " + value2);
        }
    }
}
