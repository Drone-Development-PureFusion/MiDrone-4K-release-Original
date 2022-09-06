package org.p290c.p299b.p302c;

import java.util.Comparator;
import org.p290c.p309e.AbstractC5627i;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p310a.C5602e;
/* renamed from: org.c.b.c.c */
/* loaded from: classes2.dex */
public class C5508c extends AbstractC5627i {

    /* renamed from: a */
    private final AbstractC5627i f22577a;

    /* renamed from: b */
    private final Comparator<C5619c> f22578b;

    public C5508c(AbstractC5627i abstractC5627i, Comparator<C5619c> comparator) {
        this.f22577a = abstractC5627i;
        this.f22578b = comparator;
    }

    @Override // org.p290c.p309e.AbstractC5627i
    /* renamed from: a */
    public AbstractC5634l mo489a() {
        AbstractC5634l mo489a = this.f22577a.mo489a();
        new C5602e(this.f22578b).m578a(mo489a);
        return mo489a;
    }
}
