package org.p248a.p249a.p268i.p272d;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.C5134a;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5356f;
@AbstractC5005b
/* renamed from: org.a.a.i.d.i */
/* loaded from: classes2.dex */
public class C5251i implements CookieAttributeHandler {
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        String path = cookieOrigin.getPath();
        String path2 = cookie.getPath();
        if (path2 == null) {
            path2 = "/";
        }
        if (path2.length() > 1 && path2.endsWith("/")) {
            path2 = path2.substring(0, path2.length() - 1);
        }
        boolean startsWith = path.startsWith(path2);
        return (!startsWith || path.length() == path2.length() || path2.endsWith("/")) ? startsWith : path.charAt(path2.length()) == '/';
    }

    public void parse(SetCookie setCookie, String str) {
        C5351a.m1321a(setCookie, "Cookie");
        if (C5356f.m1296b(str)) {
            str = "/";
        }
        setCookie.setPath(str);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        if (!match(cookie, cookieOrigin)) {
            throw new C5134a("Illegal path attribute \"" + cookie.getPath() + "\". Path of origin: \"" + cookieOrigin.getPath() + "\"");
        }
    }
}
