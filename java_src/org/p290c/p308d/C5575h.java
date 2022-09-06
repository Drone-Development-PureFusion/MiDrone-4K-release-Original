package org.p290c.p308d;

import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.d.h */
/* loaded from: classes.dex */
public class C5575h extends AbstractC5647j {

    /* renamed from: a */
    private final AbstractC5647j f22660a;

    public C5575h(AbstractC5647j abstractC5647j, Iterable<AbstractC5582l> iterable, C5619c c5619c) {
        this.f22660a = m649a(abstractC5647j, iterable, c5619c);
    }

    /* renamed from: a */
    private static AbstractC5647j m649a(AbstractC5647j abstractC5647j, Iterable<AbstractC5582l> iterable, C5619c c5619c) {
        for (AbstractC5582l abstractC5582l : iterable) {
            abstractC5647j = abstractC5582l.mo587a(abstractC5647j, c5619c);
        }
        return abstractC5647j;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5647j
    /* renamed from: a */
    public void mo318a() {
        this.f22660a.mo318a();
    }
}
