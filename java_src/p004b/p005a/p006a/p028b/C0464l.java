package p004b.p005a.p006a.p028b;

import java.util.HashSet;
import java.util.Set;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
/* renamed from: b.a.a.b.l */
/* loaded from: classes.dex */
public class C0464l {

    /* renamed from: a */
    private final Set<AbstractC0534m> f1024a = new HashSet();

    /* renamed from: a */
    public void m20436a() {
        for (AbstractC0534m abstractC0534m : this.f1024a) {
            if (abstractC0534m.mo20158g_()) {
                abstractC0534m.mo20155k();
            }
        }
        this.f1024a.clear();
    }

    /* renamed from: a */
    public void m20435a(AbstractC0534m abstractC0534m) {
        this.f1024a.add(abstractC0534m);
    }
}
