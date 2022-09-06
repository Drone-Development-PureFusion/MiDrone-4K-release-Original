package org.p248a.p249a.p268i.p272d;

import java.util.Date;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p258f.C5068b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.d.g */
/* loaded from: classes2.dex */
public class C5249g extends AbstractC5234a {

    /* renamed from: a */
    private final String[] f22148a;

    public C5249g(String[] strArr) {
        C5351a.m1321a(strArr, "Array of date patterns");
        this.f22148a = strArr;
    }

    public void parse(SetCookie setCookie, String str) {
        C5351a.m1321a(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        Date m2153a = C5068b.m2153a(str, this.f22148a);
        if (m2153a == null) {
            throw new MalformedCookieException("Unable to parse expires attribute: " + str);
        }
        setCookie.setExpiryDate(m2153a);
    }
}
