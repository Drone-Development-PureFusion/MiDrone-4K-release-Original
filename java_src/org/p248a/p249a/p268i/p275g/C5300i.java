package org.p248a.p249a.p268i.p275g;

import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.i.g.i */
/* loaded from: classes2.dex */
public class C5300i extends AbstractC5293b<HttpRequest> {
    public C5300i(SessionOutputBuffer sessionOutputBuffer) {
        this(sessionOutputBuffer, null);
    }

    public C5300i(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    @Override // org.p248a.p249a.p268i.p275g.AbstractC5293b
    /* renamed from: a */
    protected void mo1494a(HttpMessage httpMessage) {
        this.f22247c.formatRequestLine(this.f22246b, ((HttpRequest) httpMessage).getRequestLine());
        this.f22245a.writeLine(this.f22246b);
    }
}
