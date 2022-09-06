package org.p290c.p291a.p296e.p297a;

import java.util.ArrayList;
import java.util.List;
import org.p290c.p291a.p296e.AbstractC5479e;
import org.p290c.p291a.p296e.AbstractC5481g;
import org.p290c.p291a.p296e.C5478d;
/* renamed from: org.c.a.e.a.d */
/* loaded from: classes2.dex */
public class C5471d extends AbstractC5479e {

    /* renamed from: a */
    private Class<?> f22539a;

    public C5471d(Class<?> cls) {
        this.f22539a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p290c.p291a.p296e.AbstractC5479e
    /* renamed from: a */
    public List<AbstractC5481g> mo945a(C5478d c5478d) {
        Object[] enumConstants = this.f22539a.getEnumConstants();
        ArrayList arrayList = new ArrayList();
        for (Object[] objArr : enumConstants) {
            arrayList.add(AbstractC5481g.m943a(objArr.toString(), objArr));
        }
        return arrayList;
    }
}
