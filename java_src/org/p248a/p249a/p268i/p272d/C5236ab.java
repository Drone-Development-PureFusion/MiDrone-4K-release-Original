package org.p248a.p249a.p268i.p272d;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.C5134a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.d.ab */
/* loaded from: classes2.dex */
public class C5236ab extends AbstractC5234a {
    public void parse(SetCookie setCookie, String str) {
        C5351a.m1321a(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        if (str.trim().length() == 0) {
            throw new MalformedCookieException("Blank value for version attribute");
        }
        try {
            setCookie.setVersion(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            throw new MalformedCookieException("Invalid version: " + e.getMessage());
        }
    }

    @Override // org.p248a.p249a.p268i.p272d.AbstractC5234a
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        if (cookie.getVersion() < 0) {
            throw new C5134a("Cookie version may not be negative");
        }
    }
}
