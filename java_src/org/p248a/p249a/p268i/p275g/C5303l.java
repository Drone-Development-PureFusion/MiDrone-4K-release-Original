package org.p248a.p249a.p268i.p275g;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p268i.C5314i;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p278k.C5323d;
@AbstractC5005b
/* renamed from: org.a.a.i.g.l */
/* loaded from: classes2.dex */
public class C5303l implements AbstractC5318b<HttpResponse> {

    /* renamed from: a */
    public static final C5303l f22283a = new C5303l();

    /* renamed from: b */
    private final LineParser f22284b;

    /* renamed from: c */
    private final HttpResponseFactory f22285c;

    public C5303l() {
        this(null, null);
    }

    public C5303l(LineParser lineParser, HttpResponseFactory httpResponseFactory) {
        this.f22284b = lineParser == null ? C5323d.f22336b : lineParser;
        this.f22285c = httpResponseFactory == null ? C5314i.f22319a : httpResponseFactory;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5318b
    /* renamed from: a */
    public HttpMessageParser mo1466a(SessionInputBuffer sessionInputBuffer, C5087c c5087c) {
        return new C5302k(sessionInputBuffer, this.f22284b, this.f22285c, c5087c);
    }
}
