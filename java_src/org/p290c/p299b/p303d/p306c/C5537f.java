package org.p290c.p299b.p303d.p306c;

import java.util.List;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5640d;
/* renamed from: org.c.b.d.c.f */
/* loaded from: classes.dex */
public class C5537f extends AbstractC5647j {

    /* renamed from: a */
    private final AbstractC5647j f22615a;

    /* renamed from: b */
    private final Object f22616b;

    /* renamed from: c */
    private final List<C5640d> f22617c;

    public C5537f(AbstractC5647j abstractC5647j, List<C5640d> list, Object obj) {
        this.f22615a = abstractC5647j;
        this.f22617c = list;
        this.f22616b = obj;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5647j
    /* renamed from: a */
    public void mo318a() {
        for (C5640d c5640d : this.f22617c) {
            c5640d.m455a(this.f22616b, new Object[0]);
        }
        this.f22615a.mo318a();
    }
}
