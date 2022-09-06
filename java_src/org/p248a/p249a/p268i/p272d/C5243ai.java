package org.p248a.p249a.p268i.p272d;

import com.tencent.open.GameAppOperation;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.C5134a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.d.ai */
/* loaded from: classes2.dex */
public class C5243ai implements CookieAttributeHandler {
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        return true;
    }

    public void parse(SetCookie setCookie, String str) {
        int i;
        C5351a.m1321a(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            i = -1;
        }
        if (i < 0) {
            throw new MalformedCookieException("Invalid cookie version.");
        }
        setCookie.setVersion(i);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        if (!(cookie instanceof SetCookie2) || !(cookie instanceof ClientCookie) || ((ClientCookie) cookie).containsAttribute(GameAppOperation.QQFAV_DATALINE_VERSION)) {
            return;
        }
        throw new C5134a("Violates RFC 2965. Version attribute is required.");
    }
}
