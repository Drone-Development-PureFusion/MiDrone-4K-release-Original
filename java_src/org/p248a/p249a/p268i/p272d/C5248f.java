package org.p248a.p249a.p268i.p272d;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.C5134a;
import org.p248a.p249a.p282o.C5351a;
import p004b.p005a.p006a.p028b.C0359h;
@AbstractC5005b
/* renamed from: org.a.a.i.d.f */
/* loaded from: classes2.dex */
public class C5248f implements CookieAttributeHandler {
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (domain == null) {
            return false;
        }
        if (host.equals(domain)) {
            return true;
        }
        if (!domain.startsWith(".")) {
            domain = C0359h.f677G + domain;
        }
        return host.endsWith(domain) || host.equals(domain.substring(1));
    }

    public void parse(SetCookie setCookie, String str) {
        C5351a.m1321a(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if (str.trim().length() == 0) {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
        setCookie.setDomain(str);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (domain == null) {
            throw new C5134a("Cookie domain may not be null");
        }
        if (!host.contains(".")) {
            if (host.equals(domain)) {
                return;
            }
            throw new C5134a("Illegal domain attribute \"" + domain + "\". Domain of origin: \"" + host + "\"");
        } else if (host.endsWith(domain)) {
        } else {
            if (domain.startsWith(".")) {
                domain = domain.substring(1, domain.length());
            }
            if (host.equals(domain)) {
                return;
            }
            throw new C5134a("Illegal domain attribute \"" + domain + "\". Domain of origin: \"" + host + "\"");
        }
    }
}
