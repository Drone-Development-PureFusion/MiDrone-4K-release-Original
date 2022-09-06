package org.p248a.p249a.p268i.p272d;

import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.C5134a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.d.s */
/* loaded from: classes2.dex */
public class C5264s extends C5248f {
    /* renamed from: a */
    private static boolean m1546a(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        return upperCase.endsWith(".COM") || upperCase.endsWith(".EDU") || upperCase.endsWith(".NET") || upperCase.endsWith(".GOV") || upperCase.endsWith(".MIL") || upperCase.endsWith(".ORG") || upperCase.endsWith(".INT");
    }

    @Override // org.p248a.p249a.p268i.p272d.C5248f
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (domain == null) {
            return false;
        }
        return host.endsWith(domain);
    }

    @Override // org.p248a.p249a.p268i.p272d.C5248f
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        super.validate(cookie, cookieOrigin);
        String host = cookieOrigin.getHost();
        String domain = cookie.getDomain();
        if (host.contains(".")) {
            int countTokens = new StringTokenizer(domain, ".").countTokens();
            if (m1546a(domain)) {
                if (countTokens >= 2) {
                    return;
                }
                throw new C5134a("Domain attribute \"" + domain + "\" violates the Netscape cookie specification for special domains");
            } else if (countTokens >= 3) {
            } else {
                throw new C5134a("Domain attribute \"" + domain + "\" violates the Netscape cookie specification");
            }
        }
    }
}
