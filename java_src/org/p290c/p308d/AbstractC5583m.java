package org.p290c.p308d;

import java.util.ArrayList;
import java.util.List;
import org.p290c.C5592e;
import org.p290c.p299b.C5500b;
import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5643f;
/* renamed from: org.c.d.m */
/* loaded from: classes.dex */
public abstract class AbstractC5583m implements AbstractC5582l {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m620a(Throwable th, C5619c c5619c, List<Throwable> list) {
        try {
            mo621a(th, c5619c);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m618a(C5500b c5500b, C5619c c5619c, List<Throwable> list) {
        try {
            if (c5500b instanceof C5592e) {
                mo612a((C5592e) c5500b, c5619c);
            } else {
                m619a(c5500b, c5619c);
            }
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m617a(AbstractC5583m abstractC5583m, Throwable th, C5619c c5619c, List list) {
        abstractC5583m.m620a(th, c5619c, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m613a(C5619c c5619c, List<Throwable> list) {
        try {
            mo607c(c5619c);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m609b(C5619c c5619c, List<Throwable> list) {
        try {
            mo614a(c5619c);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m606c(C5619c c5619c, List<Throwable> list) {
        try {
            mo610b(c5619c);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    @Override // org.p290c.p308d.AbstractC5582l
    /* renamed from: a */
    public AbstractC5647j mo587a(final AbstractC5647j abstractC5647j, final C5619c c5619c) {
        return new AbstractC5647j() { // from class: org.c.d.m.1
            @Override // org.p290c.p312f.p313a.AbstractC5647j
            /* renamed from: a */
            public void mo318a() {
                ArrayList arrayList = new ArrayList();
                AbstractC5583m.this.m609b(c5619c, arrayList);
                try {
                    try {
                        abstractC5647j.mo318a();
                        AbstractC5583m.this.m613a(c5619c, arrayList);
                    } catch (C5500b e) {
                        arrayList.add(e);
                        AbstractC5583m.this.m618a(e, c5619c, (List<Throwable>) arrayList);
                        AbstractC5583m.this.m606c(c5619c, arrayList);
                    }
                    C5643f.m438a(arrayList);
                } finally {
                    AbstractC5583m.this.m606c(c5619c, arrayList);
                }
            }
        };
    }

    /* renamed from: a */
    protected void mo621a(Throwable th, C5619c c5619c) {
    }

    @Deprecated
    /* renamed from: a */
    protected void m619a(C5500b c5500b, C5619c c5619c) {
    }

    /* renamed from: a */
    protected void mo614a(C5619c c5619c) {
    }

    /* renamed from: a */
    protected void mo612a(C5592e c5592e, C5619c c5619c) {
        m619a((C5500b) c5592e, c5619c);
    }

    /* renamed from: b */
    protected void mo610b(C5619c c5619c) {
    }

    /* renamed from: c */
    protected void mo607c(C5619c c5619c) {
    }
}
