package org.p248a.p249a.p268i;

import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.i */
/* loaded from: classes2.dex */
public class C5314i implements HttpResponseFactory {

    /* renamed from: a */
    public static final C5314i f22319a = new C5314i();

    /* renamed from: b */
    protected final ReasonPhraseCatalog f22320b;

    public C5314i() {
        this(C5315j.f22321a);
    }

    public C5314i(ReasonPhraseCatalog reasonPhraseCatalog) {
        this.f22320b = (ReasonPhraseCatalog) C5351a.m1321a(reasonPhraseCatalog, "Reason phrase catalog");
    }

    /* renamed from: a */
    protected Locale m1471a(HttpContext httpContext) {
        return Locale.getDefault();
    }

    public HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i, HttpContext httpContext) {
        C5351a.m1321a(protocolVersion, "HTTP version");
        Locale m1471a = m1471a(httpContext);
        return new BasicHttpResponse(new BasicStatusLine(protocolVersion, i, this.f22320b.getReason(i, m1471a)), this.f22320b, m1471a);
    }

    public HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext) {
        C5351a.m1321a(statusLine, "Status line");
        return new BasicHttpResponse(statusLine, this.f22320b, m1471a(httpContext));
    }
}
