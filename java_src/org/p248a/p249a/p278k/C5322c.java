package org.p248a.p249a.p278k;

import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.message.LineFormatter;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p261f.p264c.C5122l;
import org.p248a.p249a.p282o.C5351a;
import p004b.p005a.p006a.p028b.C0359h;
@AbstractC5005b
/* renamed from: org.a.a.k.c */
/* loaded from: classes.dex */
public class C5322c implements LineFormatter {
    @Deprecated

    /* renamed from: a */
    public static final C5322c f22333a = new C5322c();

    /* renamed from: b */
    public static final C5322c f22334b = new C5322c();

    /* renamed from: a */
    public static String m1445a(Header header, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = f22334b;
        }
        return lineFormatter.formatHeader((CharArrayBuffer) null, header).toString();
    }

    /* renamed from: a */
    public static String m1443a(ProtocolVersion protocolVersion, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = f22334b;
        }
        return lineFormatter.appendProtocolVersion((CharArrayBuffer) null, protocolVersion).toString();
    }

    /* renamed from: a */
    public static String m1442a(RequestLine requestLine, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = f22334b;
        }
        return lineFormatter.formatRequestLine((CharArrayBuffer) null, requestLine).toString();
    }

    /* renamed from: a */
    public static String m1441a(StatusLine statusLine, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = f22334b;
        }
        return lineFormatter.formatStatusLine((CharArrayBuffer) null, statusLine).toString();
    }

    /* renamed from: a */
    protected int m1444a(ProtocolVersion protocolVersion) {
        return protocolVersion.getProtocol().length() + 4;
    }

    /* renamed from: a */
    protected CharArrayBuffer m1440a(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer != null) {
            charArrayBuffer.clear();
            return charArrayBuffer;
        }
        return new CharArrayBuffer(64);
    }

    /* renamed from: a */
    protected void m1439a(CharArrayBuffer charArrayBuffer, Header header) {
        String name = header.getName();
        String value = header.getValue();
        int length = name.length() + 2;
        if (value != null) {
            length += value.length();
        }
        charArrayBuffer.ensureCapacity(length);
        charArrayBuffer.append(name);
        charArrayBuffer.append(": ");
        if (value != null) {
            charArrayBuffer.append(value);
        }
    }

    /* renamed from: a */
    protected void m1438a(CharArrayBuffer charArrayBuffer, RequestLine requestLine) {
        String method = requestLine.getMethod();
        String uri = requestLine.getUri();
        charArrayBuffer.ensureCapacity(method.length() + 1 + uri.length() + 1 + m1444a(requestLine.getProtocolVersion()));
        charArrayBuffer.append(method);
        charArrayBuffer.append((char) C5122l.f21763c);
        charArrayBuffer.append(uri);
        charArrayBuffer.append((char) C5122l.f21763c);
        appendProtocolVersion(charArrayBuffer, requestLine.getProtocolVersion());
    }

    /* renamed from: a */
    protected void m1437a(CharArrayBuffer charArrayBuffer, StatusLine statusLine) {
        int m1444a = m1444a(statusLine.getProtocolVersion()) + 1 + 3 + 1;
        String reasonPhrase = statusLine.getReasonPhrase();
        if (reasonPhrase != null) {
            m1444a += reasonPhrase.length();
        }
        charArrayBuffer.ensureCapacity(m1444a);
        appendProtocolVersion(charArrayBuffer, statusLine.getProtocolVersion());
        charArrayBuffer.append((char) C5122l.f21763c);
        charArrayBuffer.append(Integer.toString(statusLine.getStatusCode()));
        charArrayBuffer.append((char) C5122l.f21763c);
        if (reasonPhrase != null) {
            charArrayBuffer.append(reasonPhrase);
        }
    }

    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion) {
        C5351a.m1321a(protocolVersion, "Protocol version");
        int m1444a = m1444a(protocolVersion);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(m1444a);
        } else {
            charArrayBuffer.ensureCapacity(m1444a);
        }
        charArrayBuffer.append(protocolVersion.getProtocol());
        charArrayBuffer.append('/');
        charArrayBuffer.append(Integer.toString(protocolVersion.getMajor()));
        charArrayBuffer.append((char) C0359h.f677G);
        charArrayBuffer.append(Integer.toString(protocolVersion.getMinor()));
        return charArrayBuffer;
    }

    public CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        C5351a.m1321a(header, "Header");
        if (header instanceof FormattedHeader) {
            return ((FormattedHeader) header).getBuffer();
        }
        CharArrayBuffer m1440a = m1440a(charArrayBuffer);
        m1439a(m1440a, header);
        return m1440a;
    }

    public CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine) {
        C5351a.m1321a(requestLine, "Request line");
        CharArrayBuffer m1440a = m1440a(charArrayBuffer);
        m1438a(m1440a, requestLine);
        return m1440a;
    }

    public CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine) {
        C5351a.m1321a(statusLine, "Status line");
        CharArrayBuffer m1440a = m1440a(charArrayBuffer);
        m1437a(m1440a, statusLine);
        return m1440a;
    }
}
