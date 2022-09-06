package org.p248a.p249a.p268i.p272d;

import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p266g.AbstractC5135b;
@AbstractC5005b
/* renamed from: org.a.a.i.d.r */
/* loaded from: classes2.dex */
public class C5263r implements AbstractC5135b, CookieSpecFactory {
    @Override // org.p248a.p249a.p266g.AbstractC5135b
    /* renamed from: a */
    public CookieSpec mo1538a(HttpContext httpContext) {
        return new C5262q();
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        return new C5262q();
    }
}
