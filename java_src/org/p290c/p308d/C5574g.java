package org.p290c.p308d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.d.g */
/* loaded from: classes2.dex */
public class C5574g implements AbstractC5582l {

    /* renamed from: a */
    private static final C5574g f22658a = new C5574g(Collections.emptyList());

    /* renamed from: b */
    private List<AbstractC5582l> f22659b;

    private C5574g(List<AbstractC5582l> list) {
        this.f22659b = list;
    }

    /* renamed from: a */
    public static C5574g m652a() {
        return f22658a;
    }

    /* renamed from: a */
    public static C5574g m651a(AbstractC5582l abstractC5582l) {
        return m652a().m650b(abstractC5582l);
    }

    @Override // org.p290c.p308d.AbstractC5582l
    /* renamed from: a */
    public AbstractC5647j mo587a(AbstractC5647j abstractC5647j, C5619c c5619c) {
        for (AbstractC5582l abstractC5582l : this.f22659b) {
            abstractC5647j = abstractC5582l.mo587a(abstractC5647j, c5619c);
        }
        return abstractC5647j;
    }

    /* renamed from: b */
    public C5574g m650b(AbstractC5582l abstractC5582l) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC5582l);
        arrayList.addAll(this.f22659b);
        return new C5574g(arrayList);
    }
}
