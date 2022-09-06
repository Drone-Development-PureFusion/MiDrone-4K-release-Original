package org.p248a.p249a.p268i.p269a;

import java.nio.charset.Charset;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p251b.AbstractC5011c;
@AbstractC5005b
/* renamed from: org.a.a.i.a.b */
/* loaded from: classes2.dex */
public class C5148b implements AbstractC5011c, AuthSchemeFactory {

    /* renamed from: a */
    private final Charset f21819a;

    public C5148b() {
        this(null);
    }

    public C5148b(Charset charset) {
        this.f21819a = charset;
    }

    @Override // org.p248a.p249a.p251b.AbstractC5011c
    /* renamed from: a */
    public AuthScheme mo1811a(HttpContext httpContext) {
        return new C5149c(this.f21819a);
    }

    public AuthScheme newInstance(HttpParams httpParams) {
        return new C5149c();
    }
}
