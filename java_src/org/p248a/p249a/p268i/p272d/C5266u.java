package org.p248a.p249a.p268i.p272d;

import java.util.Collection;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.AbstractC5135b;
@AbstractC5005b
/* renamed from: org.a.a.i.d.u */
/* loaded from: classes2.dex */
public class C5266u implements AbstractC5135b, CookieSpecFactory {

    /* renamed from: a */
    private final String[] f22166a;

    public C5266u() {
        this(null);
    }

    public C5266u(String[] strArr) {
        this.f22166a = strArr;
    }

    @Override // org.p248a.p249a.p266g.AbstractC5135b
    /* renamed from: a */
    public CookieSpec mo1538a(HttpContext httpContext) {
        return new C5267v(this.f22166a);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams != null) {
            Collection collection = (Collection) httpParams.getParameter("http.protocol.cookie-datepatterns");
            return new C5267v(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null);
        }
        return new C5267v();
    }
}
