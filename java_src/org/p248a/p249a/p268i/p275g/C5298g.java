package org.p248a.p249a.p268i.p275g;

import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p268i.C5310h;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.g */
/* loaded from: classes.dex */
public class C5298g extends AbstractC5292a<HttpRequest> {

    /* renamed from: b */
    private final HttpRequestFactory f22274b;

    /* renamed from: c */
    private final CharArrayBuffer f22275c;

    public C5298g(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, (LineParser) null, (HttpRequestFactory) null, C5087c.f21705a);
    }

    public C5298g(SessionInputBuffer sessionInputBuffer, C5087c c5087c) {
        this(sessionInputBuffer, (LineParser) null, (HttpRequestFactory) null, c5087c);
    }

    public C5298g(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpRequestFactory httpRequestFactory, C5087c c5087c) {
        super(sessionInputBuffer, lineParser, c5087c);
        this.f22274b = httpRequestFactory == null ? C5310h.f22309a : httpRequestFactory;
        this.f22275c = new CharArrayBuffer(128);
    }

    @Deprecated
    public C5298g(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpRequestFactory httpRequestFactory, HttpParams httpParams) {
        super(sessionInputBuffer, lineParser, httpParams);
        this.f22274b = (HttpRequestFactory) C5351a.m1321a(httpRequestFactory, "Request factory");
        this.f22275c = new CharArrayBuffer(128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p268i.p275g.AbstractC5292a
    /* renamed from: a */
    public HttpRequest mo1495b(SessionInputBuffer sessionInputBuffer) {
        this.f22275c.clear();
        if (sessionInputBuffer.readLine(this.f22275c) == -1) {
            throw new ConnectionClosedException("Client closed connection");
        }
        return this.f22274b.newHttpRequest(this.f22239a.parseRequestLine(this.f22275c, new ParserCursor(0, this.f22275c.length())));
    }
}
