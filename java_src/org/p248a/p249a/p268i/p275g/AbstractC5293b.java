package org.p248a.p249a.p268i.p275g;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p278k.C5322c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.b */
/* loaded from: classes.dex */
public abstract class AbstractC5293b<T extends HttpMessage> implements HttpMessageWriter {

    /* renamed from: a */
    protected final SessionOutputBuffer f22245a;

    /* renamed from: b */
    protected final CharArrayBuffer f22246b;

    /* renamed from: c */
    protected final LineFormatter f22247c;

    public AbstractC5293b(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        this.f22245a = (SessionOutputBuffer) C5351a.m1321a(sessionOutputBuffer, "Session input buffer");
        this.f22247c = lineFormatter == null ? C5322c.f22334b : lineFormatter;
        this.f22246b = new CharArrayBuffer(128);
    }

    @Deprecated
    public AbstractC5293b(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter, HttpParams httpParams) {
        C5351a.m1321a(sessionOutputBuffer, "Session input buffer");
        this.f22245a = sessionOutputBuffer;
        this.f22246b = new CharArrayBuffer(128);
        this.f22247c = lineFormatter == null ? C5322c.f22334b : lineFormatter;
    }

    /* renamed from: a */
    protected abstract void mo1494a(HttpMessage httpMessage);

    public void write(HttpMessage httpMessage) {
        C5351a.m1321a(httpMessage, "HTTP message");
        mo1494a(httpMessage);
        HeaderIterator headerIterator = httpMessage.headerIterator();
        while (headerIterator.hasNext()) {
            this.f22245a.writeLine(this.f22247c.formatHeader(this.f22246b, headerIterator.nextHeader()));
        }
        this.f22246b.clear();
        this.f22245a.writeLine(this.f22246b);
    }
}
