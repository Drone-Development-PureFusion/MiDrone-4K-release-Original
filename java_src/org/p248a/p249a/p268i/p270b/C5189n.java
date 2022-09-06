package org.p248a.p249a.p268i.p270b;

import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.AbstractC5066f;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.b.n */
/* loaded from: classes2.dex */
public class C5189n implements AbstractC5066f {

    /* renamed from: a */
    private final int f21962a;

    /* renamed from: b */
    private final long f21963b;

    public C5189n() {
        this(1, 1000);
    }

    public C5189n(int i, int i2) {
        C5351a.m1324a(i, "Max retries");
        C5351a.m1324a(i2, "Retry interval");
        this.f21962a = i;
        this.f21963b = i2;
    }

    @Override // org.p248a.p249a.p252c.AbstractC5066f
    /* renamed from: a */
    public long mo1753a() {
        return this.f21963b;
    }

    @Override // org.p248a.p249a.p252c.AbstractC5066f
    /* renamed from: a */
    public boolean mo1752a(HttpResponse httpResponse, int i, HttpContext httpContext) {
        return i <= this.f21962a && httpResponse.getStatusLine().getStatusCode() == 503;
    }
}
