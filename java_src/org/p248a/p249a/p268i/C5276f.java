package org.p248a.p249a.p268i;

import java.net.Socket;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentLengthStrategy;
import org.p248a.p249a.AbstractC5079d;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p277j.AbstractC5319c;
@AbstractC5005b
/* renamed from: org.a.a.i.f */
/* loaded from: classes2.dex */
public class C5276f implements AbstractC5079d<C5272e> {

    /* renamed from: a */
    public static final C5276f f22184a = new C5276f();

    /* renamed from: b */
    private final C5084a f22185b;

    /* renamed from: c */
    private final ContentLengthStrategy f22186c;

    /* renamed from: d */
    private final ContentLengthStrategy f22187d;

    /* renamed from: e */
    private final AbstractC5318b<HttpRequest> f22188e;

    /* renamed from: f */
    private final AbstractC5319c<HttpResponse> f22189f;

    public C5276f() {
        this(null, null, null, null, null);
    }

    public C5276f(C5084a c5084a) {
        this(c5084a, null, null, null, null);
    }

    public C5276f(C5084a c5084a, AbstractC5318b<HttpRequest> abstractC5318b, AbstractC5319c<HttpResponse> abstractC5319c) {
        this(c5084a, null, null, abstractC5318b, abstractC5319c);
    }

    public C5276f(C5084a c5084a, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, AbstractC5318b<HttpRequest> abstractC5318b, AbstractC5319c<HttpResponse> abstractC5319c) {
        this.f22185b = c5084a == null ? C5084a.f21692a : c5084a;
        this.f22186c = contentLengthStrategy;
        this.f22187d = contentLengthStrategy2;
        this.f22188e = abstractC5318b;
        this.f22189f = abstractC5319c;
    }

    @Override // org.p248a.p249a.AbstractC5079d
    /* renamed from: b */
    public C5272e mo1534a(Socket socket) {
        C5272e c5272e = new C5272e(this.f22185b.m2068a(), this.f22185b.m2066b(), C5167b.m1806a(this.f22185b), C5167b.m1805b(this.f22185b), this.f22185b.m2062f(), this.f22186c, this.f22187d, this.f22188e, this.f22189f);
        c5272e.mo1537a(socket);
        return c5272e;
    }
}
