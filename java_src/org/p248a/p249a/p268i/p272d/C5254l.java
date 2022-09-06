package org.p248a.p249a.p268i.p272d;

import com.tencent.open.GameAppOperation;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p253a.C5018b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.l */
/* loaded from: classes2.dex */
public class C5254l implements CookieSpec {

    /* renamed from: a */
    private final String[] f22151a;

    /* renamed from: b */
    private final boolean f22152b;

    /* renamed from: c */
    private C5242ah f22153c;

    /* renamed from: d */
    private C5235aa f22154d;

    /* renamed from: e */
    private C5257n f22155e;

    public C5254l() {
        this(null, false);
    }

    public C5254l(String[] strArr, boolean z) {
        this.f22151a = strArr == null ? null : (String[]) strArr.clone();
        this.f22152b = z;
    }

    /* renamed from: a */
    private C5242ah m1553a() {
        if (this.f22153c == null) {
            this.f22153c = new C5242ah(this.f22151a, this.f22152b);
        }
        return this.f22153c;
    }

    /* renamed from: b */
    private C5235aa m1552b() {
        if (this.f22154d == null) {
            this.f22154d = new C5235aa(this.f22151a, this.f22152b);
        }
        return this.f22154d;
    }

    /* renamed from: c */
    private C5257n m1551c() {
        if (this.f22155e == null) {
            this.f22155e = new C5257n(this.f22151a);
        }
        return this.f22155e;
    }

    public List<Header> formatCookies(List<Cookie> list) {
        C5351a.m1321a(list, "List of cookies");
        int i = Integer.MAX_VALUE;
        boolean z = true;
        for (Cookie cookie : list) {
            if (!(cookie instanceof SetCookie2)) {
                z = false;
            }
            i = cookie.getVersion() < i ? cookie.getVersion() : i;
        }
        return i > 0 ? z ? m1553a().formatCookies(list) : m1552b().formatCookies(list) : m1551c().formatCookies(list);
    }

    public int getVersion() {
        return m1553a().getVersion();
    }

    public Header getVersionHeader() {
        return m1553a().getVersionHeader();
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        return cookie.getVersion() > 0 ? cookie instanceof SetCookie2 ? m1553a().match(cookie, cookieOrigin) : m1552b().match(cookie, cookieOrigin) : m1551c().match(cookie, cookieOrigin);
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) {
        CharArrayBuffer charArrayBuffer;
        ParserCursor parserCursor;
        C5351a.m1321a(header, "Header");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
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
        if (!z && z2) {
            return "Set-Cookie2".equals(header.getName()) ? m1553a().mo1548a(elements, cookieOrigin) : m1552b().a(elements, cookieOrigin);
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
        return m1551c().a(new HeaderElement[]{c5265t.m1545a(charArrayBuffer, parserCursor)}, cookieOrigin);
    }

    public String toString() {
        return C5018b.f21483d;
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() <= 0) {
            m1551c().validate(cookie, cookieOrigin);
        } else if (cookie instanceof SetCookie2) {
            m1553a().validate(cookie, cookieOrigin);
        } else {
            m1552b().validate(cookie, cookieOrigin);
        }
    }
}
