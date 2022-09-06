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
/* renamed from: org.a.a.i.d */
/* loaded from: classes2.dex */
public class C5233d implements AbstractC5079d<C5206c> {

    /* renamed from: a */
    public static final C5233d f22123a = new C5233d();

    /* renamed from: b */
    private final C5084a f22124b;

    /* renamed from: c */
    private final ContentLengthStrategy f22125c;

    /* renamed from: d */
    private final ContentLengthStrategy f22126d;

    /* renamed from: e */
    private final AbstractC5319c<HttpRequest> f22127e;

    /* renamed from: f */
    private final AbstractC5318b<HttpResponse> f22128f;

    public C5233d() {
        this(null, null, null, null, null);
    }

    public C5233d(C5084a c5084a) {
        this(c5084a, null, null, null, null);
    }

    public C5233d(C5084a c5084a, AbstractC5319c<HttpRequest> abstractC5319c, AbstractC5318b<HttpResponse> abstractC5318b) {
        this(c5084a, null, null, abstractC5319c, abstractC5318b);
    }

    public C5233d(C5084a c5084a, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, AbstractC5319c<HttpRequest> abstractC5319c, AbstractC5318b<HttpResponse> abstractC5318b) {
        this.f22124b = c5084a == null ? C5084a.f21692a : c5084a;
        this.f22125c = contentLengthStrategy;
        this.f22126d = contentLengthStrategy2;
        this.f22127e = abstractC5319c;
        this.f22128f = abstractC5318b;
    }

    @Override // org.p248a.p249a.AbstractC5079d
    /* renamed from: b */
    public C5206c mo1534a(Socket socket) {
        C5206c c5206c = new C5206c(this.f22124b.m2068a(), this.f22124b.m2066b(), C5167b.m1806a(this.f22124b), C5167b.m1805b(this.f22124b), this.f22124b.m2062f(), this.f22125c, this.f22126d, this.f22127e, this.f22128f);
        c5206c.mo1537a(socket);
        return c5206c;
    }
}
