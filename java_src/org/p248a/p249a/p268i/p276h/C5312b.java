package org.p248a.p249a.p268i.p276h;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p260e.C5091f;
import org.p248a.p249a.p280m.AbstractC5326a;
import org.p248a.p249a.p280m.AbstractC5331b;
@AbstractC5007d
/* renamed from: org.a.a.i.h.b */
/* loaded from: classes.dex */
public class C5312b extends AbstractC5326a<HttpHost, HttpClientConnection, C5313c> {

    /* renamed from: a */
    private static final AtomicLong f22318a = new AtomicLong();

    public C5312b() {
        super(new C5311a(C5091f.f21712a, C5084a.f21692a), 2, 20);
    }

    public C5312b(C5091f c5091f, C5084a c5084a) {
        super(new C5311a(c5091f, c5084a), 2, 20);
    }

    public C5312b(AbstractC5331b<HttpHost, HttpClientConnection> abstractC5331b) {
        super(abstractC5331b, 2, 20);
    }

    @Deprecated
    public C5312b(HttpParams httpParams) {
        super(new C5311a(httpParams), 2, 20);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p280m.AbstractC5326a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public C5313c mo1422a(HttpHost httpHost, HttpClientConnection httpClientConnection) {
        return new C5313c(Long.toString(f22318a.getAndIncrement()), httpHost, httpClientConnection);
    }
}
