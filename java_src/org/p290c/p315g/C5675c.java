package org.p290c.p315g;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.p290c.p312f.p313a.AbstractC5637a;
import org.p290c.p312f.p313a.C5638b;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.g.c */
/* loaded from: classes.dex */
public final class C5675c implements AbstractC5682e {

    /* renamed from: a */
    private static final List<AbstractC5677a<?>> f22789a = Arrays.asList(new C5678b(), new C5680d(), new C5679c());

    /* renamed from: org.c.g.c$a */
    /* loaded from: classes.dex */
    private static abstract class AbstractC5677a<T extends AbstractC5637a> {

        /* renamed from: a */
        private static final C5674b f22790a = new C5674b();

        private AbstractC5677a() {
        }

        /* renamed from: a */
        private List<Exception> m305a(T t) {
            ArrayList arrayList = new ArrayList();
            for (Annotation annotation : t.mo425a()) {
                AbstractC5683f abstractC5683f = (AbstractC5683f) annotation.annotationType().getAnnotation(AbstractC5683f.class);
                if (abstractC5683f != null) {
                    arrayList.addAll(mo300a(f22790a.m306a(abstractC5683f), t));
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        abstract Iterable<T> mo301a(C5648k c5648k);

        /* renamed from: a */
        abstract List<Exception> mo300a(AbstractC5673a abstractC5673a, T t);

        /* renamed from: b */
        public List<Exception> m304b(C5648k c5648k) {
            ArrayList arrayList = new ArrayList();
            for (T t : mo301a(c5648k)) {
                arrayList.addAll(m305a((AbstractC5677a<T>) t));
            }
            return arrayList;
        }
    }

    /* renamed from: org.c.g.c$b */
    /* loaded from: classes.dex */
    private static class C5678b extends AbstractC5677a<C5648k> {
        private C5678b() {
            super();
        }

        @Override // org.p290c.p315g.C5675c.AbstractC5677a
        /* renamed from: a */
        Iterable<C5648k> mo301a(C5648k c5648k) {
            return Collections.singletonList(c5648k);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.p290c.p315g.C5675c.AbstractC5677a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public List<Exception> mo300a(AbstractC5673a abstractC5673a, C5648k c5648k) {
            return abstractC5673a.m307a(c5648k);
        }
    }

    /* renamed from: org.c.g.c$c */
    /* loaded from: classes.dex */
    private static class C5679c extends AbstractC5677a<C5638b> {
        private C5679c() {
            super();
        }

        @Override // org.p290c.p315g.C5675c.AbstractC5677a
        /* renamed from: a */
        Iterable<C5638b> mo301a(C5648k c5648k) {
            return c5648k.m414c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.p290c.p315g.C5675c.AbstractC5677a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public List<Exception> mo300a(AbstractC5673a abstractC5673a, C5638b c5638b) {
            return abstractC5673a.m309a(c5638b);
        }
    }

    /* renamed from: org.c.g.c$d */
    /* loaded from: classes.dex */
    private static class C5680d extends AbstractC5677a<C5640d> {
        private C5680d() {
            super();
        }

        @Override // org.p290c.p315g.C5675c.AbstractC5677a
        /* renamed from: a */
        Iterable<C5640d> mo301a(C5648k c5648k) {
            return c5648k.m418b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.p290c.p315g.C5675c.AbstractC5677a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public List<Exception> mo300a(AbstractC5673a abstractC5673a, C5640d c5640d) {
            return abstractC5673a.mo308a(c5640d);
        }
    }

    @Override // org.p290c.p315g.AbstractC5682e
    /* renamed from: a */
    public List<Exception> mo298a(C5648k c5648k) {
        ArrayList arrayList = new ArrayList();
        for (AbstractC5677a<?> abstractC5677a : f22789a) {
            arrayList.addAll(abstractC5677a.m304b(c5648k));
        }
        return arrayList;
    }
}
