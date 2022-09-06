package org.p248a.p249a.p268i.p272d;

import java.util.Collection;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.AbstractC5135b;
@AbstractC5005b
/* renamed from: org.a.a.i.d.z */
/* loaded from: classes2.dex */
public class C5271z implements AbstractC5135b, CookieSpecFactory {

    /* renamed from: a */
    private final String[] f22174a;

    /* renamed from: b */
    private final boolean f22175b;

    public C5271z() {
        this(null, false);
    }

    public C5271z(String[] strArr, boolean z) {
        this.f22174a = strArr;
        this.f22175b = z;
    }

    @Override // org.p248a.p249a.p266g.AbstractC5135b
    /* renamed from: a */
    public CookieSpec mo1538a(HttpContext httpContext) {
        return new C5235aa(this.f22174a, this.f22175b);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams != null) {
            Collection collection = (Collection) httpParams.getParameter("http.protocol.cookie-datepatterns");
            return new C5235aa(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null, httpParams.getBooleanParameter("http.protocol.single-cookie-header", false));
        }
        return new C5235aa();
    }
}
