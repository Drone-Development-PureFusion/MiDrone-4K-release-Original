package org.p290c.p308d;

import org.p290c.p299b.C5500b;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5640d;
@Deprecated
/* renamed from: org.c.d.n */
/* loaded from: classes.dex */
public class C5585n implements AbstractC5573f {
    @Override // org.p290c.p308d.AbstractC5573f
    /* renamed from: a */
    public AbstractC5647j mo603a(final AbstractC5647j abstractC5647j, final C5640d c5640d, Object obj) {
        return new AbstractC5647j() { // from class: org.c.d.n.1
            @Override // org.p290c.p312f.p313a.AbstractC5647j
            /* renamed from: a */
            public void mo318a() {
                C5585n.this.m602b(c5640d);
                try {
                    try {
                        abstractC5647j.mo318a();
                        C5585n.this.m604a(c5640d);
                    } catch (C5500b e) {
                        throw e;
                    } catch (Throwable th) {
                        C5585n.this.m605a(th, c5640d);
                        throw th;
                    }
                } finally {
                    C5585n.this.m601c(c5640d);
                }
            }
        };
    }

    /* renamed from: a */
    public void m605a(Throwable th, C5640d c5640d) {
    }

    /* renamed from: a */
    public void m604a(C5640d c5640d) {
    }

    /* renamed from: b */
    public void m602b(C5640d c5640d) {
    }

    /* renamed from: c */
    public void m601c(C5640d c5640d) {
    }
}
