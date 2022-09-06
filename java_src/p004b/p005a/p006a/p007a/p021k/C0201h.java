package p004b.p005a.p006a.p007a.p021k;

import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p044i.AbstractC0431b;
import p004b.p005a.p006a.p028b.p044i.AbstractC0456k;
import p004b.p005a.p006a.p028b.p044i.C0443c;
/* renamed from: b.a.a.a.k.h */
/* loaded from: classes.dex */
public class C0201h implements AbstractC0456k<AbstractC0231d> {
    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0456k
    /* renamed from: a */
    public void mo20460a(AbstractC0431b<AbstractC0231d> abstractC0431b) {
        if (abstractC0431b == null) {
            throw new IllegalArgumentException("cannot process empty chain");
        }
        if (m21302b(abstractC0431b)) {
            return;
        }
        C0443c.m20497b(abstractC0431b).m20541b(new C0202i());
    }

    /* renamed from: b */
    public boolean m21302b(AbstractC0431b abstractC0431b) {
        while (abstractC0431b != null) {
            if (abstractC0431b instanceof AbstractC0193ab) {
                return true;
            }
            abstractC0431b = abstractC0431b.m20542b();
        }
        return false;
    }
}
