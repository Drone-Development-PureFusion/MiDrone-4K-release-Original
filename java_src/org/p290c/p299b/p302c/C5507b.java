package org.p290c.p299b.p302c;

import org.p290c.p299b.p303d.C5514b;
import org.p290c.p309e.AbstractC5627i;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.p310a.AbstractC5595a;
import org.p290c.p309e.p310a.C5600c;
/* renamed from: org.c.b.c.b */
/* loaded from: classes2.dex */
public final class C5507b extends AbstractC5627i {

    /* renamed from: a */
    private final AbstractC5627i f22575a;

    /* renamed from: b */
    private final AbstractC5595a f22576b;

    public C5507b(AbstractC5627i abstractC5627i, AbstractC5595a abstractC5595a) {
        this.f22575a = abstractC5627i;
        this.f22576b = abstractC5595a;
    }

    @Override // org.p290c.p309e.AbstractC5627i
    /* renamed from: a */
    public AbstractC5634l mo489a() {
        try {
            AbstractC5634l mo489a = this.f22575a.mo489a();
            this.f22576b.mo582a(mo489a);
            return mo489a;
        } catch (C5600c e) {
            return new C5514b(AbstractC5595a.class, new Exception(String.format("No tests found matching %s from %s", this.f22576b.mo580a(), this.f22575a.toString())));
        }
    }
}
