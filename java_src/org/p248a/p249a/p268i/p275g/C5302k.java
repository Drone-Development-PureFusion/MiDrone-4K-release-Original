package org.p248a.p249a.p268i.p275g;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.NoHttpResponseException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p268i.C5314i;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.k */
/* loaded from: classes.dex */
public class C5302k extends AbstractC5292a<HttpResponse> {

    /* renamed from: b */
    private final HttpResponseFactory f22281b;

    /* renamed from: c */
    private final CharArrayBuffer f22282c;

    public C5302k(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, (LineParser) null, (HttpResponseFactory) null, C5087c.f21705a);
    }

    public C5302k(SessionInputBuffer sessionInputBuffer, C5087c c5087c) {
        this(sessionInputBuffer, (LineParser) null, (HttpResponseFactory) null, c5087c);
    }

    public C5302k(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, C5087c c5087c) {
        super(sessionInputBuffer, lineParser, c5087c);
        this.f22281b = httpResponseFactory == null ? C5314i.f22319a : httpResponseFactory;
        this.f22282c = new CharArrayBuffer(128);
    }

    @Deprecated
    public C5302k(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        super(sessionInputBuffer, lineParser, httpParams);
        this.f22281b = (HttpResponseFactory) C5351a.m1321a(httpResponseFactory, "Response factory");
        this.f22282c = new CharArrayBuffer(128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p268i.p275g.AbstractC5292a
    /* renamed from: a */
    public HttpResponse mo1495b(SessionInputBuffer sessionInputBuffer) {
        this.f22282c.clear();
        if (sessionInputBuffer.readLine(this.f22282c) == -1) {
            throw new NoHttpResponseException("The target server failed to respond");
        }
        return this.f22281b.newHttpResponse(this.f22239a.parseStatusLine(this.f22282c, new ParserCursor(0, this.f22282c.length())), (HttpContext) null);
    }
}
