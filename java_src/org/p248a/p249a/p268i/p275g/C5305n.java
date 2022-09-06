package org.p248a.p249a.p268i.p275g;

import org.apache.http.HttpResponse;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p277j.AbstractC5319c;
import org.p248a.p249a.p278k.C5322c;
@AbstractC5005b
/* renamed from: org.a.a.i.g.n */
/* loaded from: classes2.dex */
public class C5305n implements AbstractC5319c<HttpResponse> {

    /* renamed from: a */
    public static final C5305n f22286a = new C5305n();

    /* renamed from: b */
    private final LineFormatter f22287b;

    public C5305n() {
        this(null);
    }

    public C5305n(LineFormatter lineFormatter) {
        this.f22287b = lineFormatter == null ? C5322c.f22334b : lineFormatter;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5319c
    /* renamed from: a */
    public HttpMessageWriter mo1465a(SessionOutputBuffer sessionOutputBuffer) {
        return new C5304m(sessionOutputBuffer, this.f22287b);
    }
}
