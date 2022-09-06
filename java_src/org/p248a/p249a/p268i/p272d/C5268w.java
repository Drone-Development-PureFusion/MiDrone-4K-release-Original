package org.p248a.p249a.p268i.p272d;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;
import org.p248a.p249a.p252c.p258f.C5074f;
import org.p318d.AbstractC5756f;
/* renamed from: org.a.a.i.d.w */
/* loaded from: classes2.dex */
public class C5268w implements CookieAttributeHandler {

    /* renamed from: a */
    private final CookieAttributeHandler f22169a;

    /* renamed from: b */
    private Set<String> f22170b;

    /* renamed from: c */
    private Set<String> f22171c;

    public C5268w(CookieAttributeHandler cookieAttributeHandler) {
        this.f22169a = cookieAttributeHandler;
    }

    /* renamed from: a */
    private boolean m1542a(Cookie cookie) {
        int indexOf;
        String domain = cookie.getDomain();
        if (domain.startsWith(".")) {
            domain = domain.substring(1);
        }
        String m2143a = C5074f.m2143a(domain);
        if ((this.f22170b == null || !this.f22170b.contains(m2143a)) && this.f22171c != null) {
            while (!this.f22171c.contains(m2143a)) {
                if (m2143a.startsWith("*.")) {
                    m2143a = m2143a.substring(2);
                }
                if (m2143a.indexOf(46) != -1) {
                    m2143a = AbstractC5756f.f23062a + m2143a.substring(indexOf);
                    if (m2143a.length() <= 0) {
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m1543a(Collection<String> collection) {
        this.f22171c = new HashSet(collection);
    }

    /* renamed from: b */
    public void m1541b(Collection<String> collection) {
        this.f22170b = new HashSet(collection);
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        if (m1542a(cookie)) {
            return false;
        }
        return this.f22169a.match(cookie, cookieOrigin);
    }

    public void parse(SetCookie setCookie, String str) {
        this.f22169a.parse(setCookie, str);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        this.f22169a.validate(cookie, cookieOrigin);
    }
}
