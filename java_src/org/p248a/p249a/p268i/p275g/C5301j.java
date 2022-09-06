package org.p248a.p249a.p268i.p275g;

import org.apache.http.HttpRequest;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p277j.AbstractC5319c;
import org.p248a.p249a.p278k.C5322c;
@AbstractC5005b
/* renamed from: org.a.a.i.g.j */
/* loaded from: classes2.dex */
public class C5301j implements AbstractC5319c<HttpRequest> {

    /* renamed from: a */
    public static final C5301j f22279a = new C5301j();

    /* renamed from: b */
    private final LineFormatter f22280b;

    public C5301j() {
        this(null);
    }

    public C5301j(LineFormatter lineFormatter) {
        this.f22280b = lineFormatter == null ? C5322c.f22334b : lineFormatter;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5319c
    /* renamed from: a */
    public HttpMessageWriter mo1465a(SessionOutputBuffer sessionOutputBuffer) {
        return new C5300i(sessionOutputBuffer, this.f22280b);
    }
}
