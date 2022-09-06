package org.p290c.p291a.p296e.p298b;

import java.util.ArrayList;
import java.util.List;
import org.p290c.p291a.p296e.AbstractC5479e;
import org.p290c.p291a.p296e.AbstractC5481g;
import org.p290c.p291a.p296e.C5478d;
/* renamed from: org.c.a.e.b.b */
/* loaded from: classes.dex */
public class C5476b extends AbstractC5479e {
    @Override // org.p290c.p291a.p296e.AbstractC5479e
    /* renamed from: a */
    public List<AbstractC5481g> mo945a(C5478d c5478d) {
        ArrayList arrayList = new ArrayList();
        for (int i : ((AbstractC5475a) c5478d.m946e(AbstractC5475a.class)).m962a()) {
            arrayList.add(AbstractC5481g.m943a("ints", Integer.valueOf(i)));
        }
        return arrayList;
    }
}
