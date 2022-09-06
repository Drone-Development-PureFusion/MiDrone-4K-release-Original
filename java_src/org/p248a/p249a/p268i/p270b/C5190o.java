package org.p248a.p249a.p268i.p270b;

import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p251b.C5012d;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p261f.AbstractC5130h;
@AbstractC5005b
/* renamed from: org.a.a.i.b.o */
/* loaded from: classes2.dex */
public class C5190o implements UserTokenHandler {

    /* renamed from: a */
    public static final C5190o f21964a = new C5190o();

    /* renamed from: a */
    private static Principal m1751a(C5012d c5012d) {
        Credentials m2301d;
        AuthScheme m2302c = c5012d.m2302c();
        if (m2302c == null || !m2302c.isComplete() || !m2302c.isConnectionBased() || (m2301d = c5012d.m2301d()) == null) {
            return null;
        }
        return m2301d.getUserPrincipal();
    }

    public Object getUserToken(HttpContext httpContext) {
        SSLSession mo1631c;
        C5057a m2176a = C5057a.m2176a(httpContext);
        Principal principal = null;
        C5012d m2164k = m2176a.m2164k();
        if (m2164k != null && (principal = m1751a(m2164k)) == null) {
            principal = m1751a(m2176a.m2163l());
        }
        if (principal == null) {
            AbstractC5130h p = m2176a.p();
            if (p.isOpen() && (p instanceof AbstractC5130h) && (mo1631c = p.mo1631c()) != null) {
                return mo1631c.getLocalPrincipal();
            }
        }
        return principal;
    }
}
