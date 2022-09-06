package org.p290c.p308d;

import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.d.e */
/* loaded from: classes2.dex */
public abstract class AbstractC5571e implements AbstractC5582l {
    /* renamed from: a */
    private AbstractC5647j m653a(final AbstractC5647j abstractC5647j) {
        return new AbstractC5647j() { // from class: org.c.d.e.1
            @Override // org.p290c.p312f.p313a.AbstractC5647j
            /* renamed from: a */
            public void mo318a() {
                AbstractC5571e.this.mo636a();
                try {
                    abstractC5647j.mo318a();
                } finally {
                    AbstractC5571e.this.mo631b();
                }
            }
        };
    }

    @Override // org.p290c.p308d.AbstractC5582l
    /* renamed from: a */
    public AbstractC5647j mo587a(AbstractC5647j abstractC5647j, C5619c c5619c) {
        return m653a(abstractC5647j);
    }

    /* renamed from: a */
    protected void mo636a() {
    }

    /* renamed from: b */
    protected void mo631b() {
    }
}
