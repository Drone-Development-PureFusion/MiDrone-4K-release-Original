package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ProtocolException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p268i.C5314i;
import org.p248a.p249a.p268i.p275g.AbstractC5292a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.c.f */
/* loaded from: classes.dex */
public class C5213f extends AbstractC5292a<HttpResponse> {

    /* renamed from: b */
    private static final String f22075b = "HttpClient";

    /* renamed from: c */
    private final HttpResponseFactory f22076c;

    /* renamed from: d */
    private final CharArrayBuffer f22077d;

    public C5213f(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, (LineParser) null, (HttpResponseFactory) null, C5087c.f21705a);
    }

    public C5213f(SessionInputBuffer sessionInputBuffer, C5087c c5087c) {
        this(sessionInputBuffer, (LineParser) null, (HttpResponseFactory) null, c5087c);
    }

    public C5213f(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, C5087c c5087c) {
        super(sessionInputBuffer, lineParser, c5087c);
        this.f22076c = httpResponseFactory == null ? C5314i.f22319a : httpResponseFactory;
        this.f22077d = new CharArrayBuffer(128);
    }

    @Deprecated
    public C5213f(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        super(sessionInputBuffer, lineParser, httpParams);
        C5351a.m1321a(httpResponseFactory, "Response factory");
        this.f22076c = httpResponseFactory;
        this.f22077d = new CharArrayBuffer(128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p268i.p275g.AbstractC5292a
    /* renamed from: a */
    public HttpResponse mo1495b(SessionInputBuffer sessionInputBuffer) {
        int i = 0;
        while (true) {
            this.f22077d.clear();
            int readLine = sessionInputBuffer.readLine(this.f22077d);
            if (readLine == -1 && i == 0) {
                throw new NoHttpResponseException("The target server failed to respond");
            }
            ParserCursor parserCursor = new ParserCursor(0, this.f22077d.length());
            if (this.f22239a.hasProtocolVersion(this.f22077d, parserCursor)) {
                return this.f22076c.newHttpResponse(this.f22239a.parseStatusLine(this.f22077d, parserCursor), (HttpContext) null);
            } else if (readLine == -1 || m1634a(this.f22077d, i)) {
                break;
            } else {
                if (Log.isLoggable(f22075b, 3)) {
                    Log.d(f22075b, "Garbage in response: " + this.f22077d.toString());
                }
                i++;
            }
        }
        throw new ProtocolException("The server failed to respond with a valid HTTP response");
    }

    /* renamed from: a */
    protected boolean m1634a(CharArrayBuffer charArrayBuffer, int i) {
        return false;
    }
}
