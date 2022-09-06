package org.p290c.p291a.p294c;

import java.util.List;
import org.p290c.p309e.C5629j;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5606b;
/* renamed from: org.c.a.c.a */
/* loaded from: classes2.dex */
class C5458a {

    /* renamed from: a */
    private final List<C5605a> f22529a;

    public C5458a(List<C5605a> list) {
        this.f22529a = list;
    }

    /* renamed from: a */
    public C5629j m1007a() {
        C5629j c5629j = new C5629j();
        C5606b m477g = c5629j.m477g();
        for (C5605a c5605a : this.f22529a) {
            try {
                m477g.mo476a(c5605a);
            } catch (Exception e) {
                throw new RuntimeException("I can't believe this happened");
            }
        }
        return c5629j;
    }
}
