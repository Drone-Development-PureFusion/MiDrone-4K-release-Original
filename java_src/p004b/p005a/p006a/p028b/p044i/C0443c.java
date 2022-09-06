package p004b.p005a.p006a.p028b.p044i;

import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
/* renamed from: b.a.a.b.i.c */
/* loaded from: classes.dex */
public class C0443c {
    /* renamed from: a */
    public static <E> void m20499a(AbstractC0292f abstractC0292f, AbstractC0431b<E> abstractC0431b) {
        for (AbstractC0431b<E> abstractC0431b2 = abstractC0431b; abstractC0431b2 != null; abstractC0431b2 = abstractC0431b2.m20542b()) {
            if (abstractC0431b2 instanceof AbstractC0526e) {
                ((AbstractC0526e) abstractC0431b2).mo20233a(abstractC0292f);
            }
        }
    }

    /* renamed from: a */
    public static <E> void m20498a(AbstractC0431b<E> abstractC0431b) {
        for (AbstractC0431b<E> abstractC0431b2 = abstractC0431b; abstractC0431b2 != null; abstractC0431b2 = abstractC0431b2.m20542b()) {
            if (abstractC0431b2 instanceof AbstractC0412a) {
                AbstractC0412a abstractC0412a = (AbstractC0412a) abstractC0431b2;
                m20498a(abstractC0412a.f920a);
                abstractC0412a.j();
            } else if (abstractC0431b2 instanceof AbstractC0449d) {
                ((AbstractC0449d) abstractC0431b2).mo20156j();
            }
        }
    }

    /* renamed from: b */
    public static <E> AbstractC0431b<E> m20497b(AbstractC0431b<E> abstractC0431b) {
        while (abstractC0431b != null) {
            AbstractC0431b<E> m20542b = abstractC0431b.m20542b();
            if (m20542b == null) {
                break;
            }
            abstractC0431b = m20542b;
        }
        return abstractC0431b;
    }
}
