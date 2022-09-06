package org.p248a.p249a.p268i.p275g;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p268i.C5310h;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p278k.C5323d;
@AbstractC5005b
/* renamed from: org.a.a.i.g.h */
/* loaded from: classes2.dex */
public class C5299h implements AbstractC5318b<HttpRequest> {

    /* renamed from: a */
    public static final C5299h f22276a = new C5299h();

    /* renamed from: b */
    private final LineParser f22277b;

    /* renamed from: c */
    private final HttpRequestFactory f22278c;

    public C5299h() {
        this(null, null);
    }

    public C5299h(LineParser lineParser, HttpRequestFactory httpRequestFactory) {
        this.f22277b = lineParser == null ? C5323d.f22336b : lineParser;
        this.f22278c = httpRequestFactory == null ? C5310h.f22309a : httpRequestFactory;
    }

    @Override // org.p248a.p249a.p277j.AbstractC5318b
    /* renamed from: a */
    public HttpMessageParser mo1466a(SessionInputBuffer sessionInputBuffer, C5087c c5087c) {
        return new C5298g(sessionInputBuffer, this.f22277b, this.f22278c, c5087c);
    }
}
