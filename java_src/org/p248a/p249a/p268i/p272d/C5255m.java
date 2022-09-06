package org.p248a.p249a.p268i.p272d;

import java.util.Collection;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.AbstractC5135b;
@AbstractC5005b
/* renamed from: org.a.a.i.d.m */
/* loaded from: classes2.dex */
public class C5255m implements AbstractC5135b, CookieSpecFactory {

    /* renamed from: a */
    private final String[] f22156a;

    /* renamed from: b */
    private final EnumC5256a f22157b;

    /* renamed from: org.a.a.i.d.m$a */
    /* loaded from: classes2.dex */
    public enum EnumC5256a {
        SECURITYLEVEL_DEFAULT,
        SECURITYLEVEL_IE_MEDIUM
    }

    public C5255m() {
        this(null, EnumC5256a.SECURITYLEVEL_DEFAULT);
    }

    public C5255m(String[] strArr) {
        this(null, EnumC5256a.SECURITYLEVEL_DEFAULT);
    }

    public C5255m(String[] strArr, EnumC5256a enumC5256a) {
        this.f22156a = strArr;
        this.f22157b = enumC5256a;
    }

    @Override // org.p248a.p249a.p266g.AbstractC5135b
    /* renamed from: a */
    public CookieSpec mo1538a(HttpContext httpContext) {
        return new C5257n(this.f22156a);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams != null) {
            Collection collection = (Collection) httpParams.getParameter("http.protocol.cookie-datepatterns");
            return new C5257n(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null, this.f22157b);
        }
        return new C5257n(null, this.f22157b);
    }
}
