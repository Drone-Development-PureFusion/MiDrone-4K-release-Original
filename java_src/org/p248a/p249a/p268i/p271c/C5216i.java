package org.p248a.p249a.p268i.p271c;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p261f.AbstractC5131i;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.c.i */
/* loaded from: classes2.dex */
public class C5216i extends C5217j {

    /* renamed from: a */
    private final HttpHost f22084a;

    public C5216i(HttpHost httpHost) {
        this(httpHost, null);
    }

    public C5216i(HttpHost httpHost, AbstractC5131i abstractC5131i) {
        super(abstractC5131i);
        this.f22084a = (HttpHost) C5351a.m1321a(httpHost, "Proxy host");
    }

    @Override // org.p248a.p249a.p268i.p271c.C5217j
    /* renamed from: a */
    protected HttpHost mo1581a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.f22084a;
    }
}
