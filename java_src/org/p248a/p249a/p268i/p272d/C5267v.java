package org.p248a.p249a.p268i.p272d;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p253a.C5018b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.v */
/* loaded from: classes2.dex */
public class C5267v extends AbstractC5261p {

    /* renamed from: a */
    protected static final String f22167a = "EEE, dd-MMM-yy HH:mm:ss z";

    /* renamed from: b */
    private final String[] f22168b;

    public C5267v() {
        this(null);
    }

    public C5267v(String[] strArr) {
        if (strArr != null) {
            this.f22168b = (String[]) strArr.clone();
        } else {
            this.f22168b = new String[]{f22167a};
        }
        a("path", new C5251i());
        a("domain", new C5264s());
        a("max-age", new C5250h());
        a("secure", new C5252j());
        a("comment", new C5247e());
        a("expires", new C5249g(this.f22168b));
    }

    public List<Header> formatCookies(List<Cookie> list) {
        C5351a.m1320a(list, "List of cookies");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 20);
        charArrayBuffer.append("Cookie");
        charArrayBuffer.append(": ");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(new BufferedHeader(charArrayBuffer));
                return arrayList;
            }
            Cookie cookie = list.get(i2);
            if (i2 > 0) {
                charArrayBuffer.append("; ");
            }
            charArrayBuffer.append(cookie.getName());
            String value = cookie.getValue();
            if (value != null) {
                charArrayBuffer.append("=");
                charArrayBuffer.append(value);
            }
            i = i2 + 1;
        }
    }

    public int getVersion() {
        return 0;
    }

    public Header getVersionHeader() {
        return null;
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) {
        CharArrayBuffer charArrayBuffer;
        ParserCursor parserCursor;
        C5351a.m1321a(header, "Header");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        if (!header.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
        C5265t c5265t = C5265t.f22165a;
        if (header instanceof FormattedHeader) {
            charArrayBuffer = ((FormattedHeader) header).getBuffer();
            parserCursor = new ParserCursor(((FormattedHeader) header).getValuePos(), charArrayBuffer.length());
        } else {
            String value = header.getValue();
            if (value == null) {
                throw new MalformedCookieException("Header value is null");
            }
            charArrayBuffer = new CharArrayBuffer(value.length());
            charArrayBuffer.append(value);
            parserCursor = new ParserCursor(0, charArrayBuffer.length());
        }
        return a(new HeaderElement[]{c5265t.m1545a(charArrayBuffer, parserCursor)}, cookieOrigin);
    }

    public String toString() {
        return C5018b.f21481b;
    }
}
