package org.p248a.p249a.p268i.p274f;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.i.f.n */
/* loaded from: classes2.dex */
public class C5290n extends HttpException {
    private static final long serialVersionUID = -8646722842745617323L;

    /* renamed from: a */
    private final HttpResponse f22235a;

    public C5290n(String str, HttpResponse httpResponse) {
        super(str);
        this.f22235a = httpResponse;
    }

    /* renamed from: a */
    public HttpResponse m1510a() {
        return this.f22235a;
    }
}
