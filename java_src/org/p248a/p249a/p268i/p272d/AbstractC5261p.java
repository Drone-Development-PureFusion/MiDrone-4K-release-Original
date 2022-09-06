package org.p248a.p249a.p268i.p272d;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.p */
/* loaded from: classes2.dex */
public abstract class AbstractC5261p extends AbstractC5244b {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static String m1549a(CookieOrigin cookieOrigin) {
        String path = cookieOrigin.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            if (lastIndexOf == 0) {
                lastIndexOf = 1;
            }
            return path.substring(0, lastIndexOf);
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static String m1547b(CookieOrigin cookieOrigin) {
        return cookieOrigin.getHost();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public List<Cookie> mo1548a(HeaderElement[] headerElementArr, CookieOrigin cookieOrigin) {
        ArrayList arrayList = new ArrayList(headerElementArr.length);
        for (HeaderElement headerElement : headerElementArr) {
            String name = headerElement.getName();
            String value = headerElement.getValue();
            if (name == null || name.length() == 0) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            C5246d c5246d = new C5246d(name, value);
            c5246d.setPath(m1549a(cookieOrigin));
            c5246d.setDomain(m1547b(cookieOrigin));
            NameValuePair[] parameters = headerElement.getParameters();
            for (int length = parameters.length - 1; length >= 0; length--) {
                NameValuePair nameValuePair = parameters[length];
                String lowerCase = nameValuePair.getName().toLowerCase(Locale.ENGLISH);
                c5246d.m1554a(lowerCase, nameValuePair.getValue());
                CookieAttributeHandler a = a(lowerCase);
                if (a != null) {
                    a.parse(c5246d, nameValuePair.getValue());
                }
            }
            arrayList.add(c5246d);
        }
        return arrayList;
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        for (CookieAttributeHandler cookieAttributeHandler : a()) {
            if (!cookieAttributeHandler.match(cookie, cookieOrigin)) {
                return false;
            }
        }
        return true;
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        for (CookieAttributeHandler cookieAttributeHandler : a()) {
            cookieAttributeHandler.validate(cookie, cookieOrigin);
        }
    }
}
