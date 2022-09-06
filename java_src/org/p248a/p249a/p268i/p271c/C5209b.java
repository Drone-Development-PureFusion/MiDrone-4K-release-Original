package org.p248a.p249a.p268i.p271c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.conn.routing.HttpRoute;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p261f.AbstractC5130h;
import org.p248a.p249a.p280m.AbstractC5326a;
import org.p248a.p249a.p280m.AbstractC5331b;
@AbstractC5007d
/* renamed from: org.a.a.i.c.b */
/* loaded from: classes2.dex */
class C5209b extends AbstractC5326a<HttpRoute, AbstractC5130h, C5210c> {

    /* renamed from: a */
    private static final AtomicLong f22069a = new AtomicLong();

    /* renamed from: b */
    private final long f22070b;

    /* renamed from: c */
    private final TimeUnit f22071c;

    public C5209b(AbstractC5331b<HttpRoute, AbstractC5130h> abstractC5331b, int i, int i2, long j, TimeUnit timeUnit) {
        super(abstractC5331b, i, i2);
        this.f22070b = j;
        this.f22071c = timeUnit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p280m.AbstractC5326a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public C5210c mo1422a(HttpRoute httpRoute, AbstractC5130h abstractC5130h) {
        return new C5210c(Long.toString(f22069a.getAndIncrement()), httpRoute, abstractC5130h, this.f22070b, this.f22071c);
    }
}
