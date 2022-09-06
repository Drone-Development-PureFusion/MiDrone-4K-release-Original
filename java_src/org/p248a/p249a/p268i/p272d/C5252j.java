package org.p248a.p249a.p268i.p272d;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.d.j */
/* loaded from: classes2.dex */
public class C5252j extends AbstractC5234a {
    @Override // org.p248a.p249a.p268i.p272d.AbstractC5234a
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        return !cookie.isSecure() || cookieOrigin.isSecure();
    }

    public void parse(SetCookie setCookie, String str) {
        C5351a.m1321a(setCookie, "Cookie");
        setCookie.setSecure(true);
    }
}
