package org.p248a.p249a.p268i.p272d;

import com.tencent.open.GameAppOperation;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p253a.C5018b;
import org.p248a.p249a.p252c.p258f.C5068b;
import org.p248a.p249a.p268i.p272d.C5255m;
import org.p248a.p249a.p278k.C5320a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.n */
/* loaded from: classes2.dex */
public class C5257n extends AbstractC5261p {

    /* renamed from: a */
    private static final String[] f22161a = {C5068b.f21586a, C5068b.f21587b, C5068b.f21588c, "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};

    /* renamed from: b */
    private final String[] f22162b;

    public C5257n() {
        this(null, C5255m.EnumC5256a.SECURITYLEVEL_DEFAULT);
    }

    public C5257n(String[] strArr) {
        this(strArr, C5255m.EnumC5256a.SECURITYLEVEL_DEFAULT);
    }

    public C5257n(String[] strArr, C5255m.EnumC5256a enumC5256a) {
        if (strArr != null) {
            this.f22162b = (String[]) strArr.clone();
        } else {
            this.f22162b = f22161a;
        }
        switch (enumC5256a) {
            case SECURITYLEVEL_DEFAULT:
                a("path", new C5251i());
                break;
            case SECURITYLEVEL_IE_MEDIUM:
                a("path", new C5251i() { // from class: org.a.a.i.d.n.1
                    @Override // org.p248a.p249a.p268i.p272d.C5251i
                    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
                    }
                });
                break;
            default:
                throw new RuntimeException("Unknown security level");
        }
        a("domain", new C5248f());
        a("max-age", new C5250h());
        a("secure", new C5252j());
        a("comment", new C5247e());
        a("expires", new C5249g(this.f22162b));
        a(GameAppOperation.QQFAV_DATALINE_VERSION, new C5260o());
    }

    /* renamed from: c */
    private static boolean m1550c(String str) {
        return str != null && str.startsWith("\"") && str.endsWith("\"");
    }

    public List<Header> formatCookies(List<Cookie> list) {
        C5351a.m1320a(list, "List of cookies");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 20);
        charArrayBuffer.append("Cookie");
        charArrayBuffer.append(": ");
        for (int i = 0; i < list.size(); i++) {
            Cookie cookie = list.get(i);
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            String name = cookie.getName();
            String value = cookie.getValue();
            if (cookie.getVersion() <= 0 || m1550c(value)) {
                charArrayBuffer.append(name);
                charArrayBuffer.append("=");
                if (value != null) {
                    charArrayBuffer.append(value);
                }
            } else {
                C5320a.f22325b.formatHeaderElement(charArrayBuffer, new BasicHeaderElement(name, value), false);
            }
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
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
        HeaderElement[] headerElementArr;
        C5351a.m1321a(header, "Header");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        if (!header.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
        HeaderElement[] elements = header.getElements();
        boolean z = false;
        boolean z2 = false;
        for (HeaderElement headerElement : elements) {
            if (headerElement.getParameterByName(GameAppOperation.QQFAV_DATALINE_VERSION) != null) {
                z2 = true;
            }
            if (headerElement.getParameterByName("expires") != null) {
                z = true;
            }
        }
        if (z || !z2) {
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
            headerElementArr = new HeaderElement[]{c5265t.m1545a(charArrayBuffer, parserCursor)};
        } else {
            headerElementArr = elements;
        }
        return a(headerElementArr, cookieOrigin);
    }

    public String toString() {
        return C5018b.f21480a;
    }
}
