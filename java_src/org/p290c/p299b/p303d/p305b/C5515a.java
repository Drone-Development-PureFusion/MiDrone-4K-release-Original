package org.p290c.p299b.p303d.p305b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.p290c.AbstractC5684h;
import org.p290c.AbstractC5691l;
import org.p290c.p308d.AbstractC5573f;
import org.p290c.p308d.AbstractC5582l;
import org.p290c.p312f.p313a.AbstractC5639c;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.b.d.b.a */
/* loaded from: classes.dex */
public class C5515a {

    /* renamed from: a */
    public static final C5515a f22587a = m878a().m866a(new C5518b()).m866a(new C5523g()).m866a(new C5522f()).m866a(new C5520d()).m865b();

    /* renamed from: b */
    public static final C5515a f22588b = m874b().m866a(new C5521e()).m866a(new C5522f()).m866a(new C5519c()).m865b();

    /* renamed from: c */
    public static final C5515a f22589c = m878a().m868a().m866a(new C5518b()).m866a(new C5523g()).m866a(new C5522f()).m866a(new C5525i()).m865b();

    /* renamed from: d */
    public static final C5515a f22590d = m874b().m868a().m866a(new C5521e()).m866a(new C5522f()).m866a(new C5524h()).m865b();

    /* renamed from: e */
    private final Class<? extends Annotation> f22591e;

    /* renamed from: f */
    private final boolean f22592f;

    /* renamed from: g */
    private final List<AbstractC5526j> f22593g;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.c.b.d.b.a$a */
    /* loaded from: classes2.dex */
    public static class C5517a {

        /* renamed from: a */
        private final Class<? extends Annotation> f22594a;

        /* renamed from: b */
        private boolean f22595b;

        /* renamed from: c */
        private final List<AbstractC5526j> f22596c;

        private C5517a(Class<? extends Annotation> cls) {
            this.f22594a = cls;
            this.f22595b = false;
            this.f22596c = new ArrayList();
        }

        /* renamed from: a */
        C5517a m868a() {
            this.f22595b = true;
            return this;
        }

        /* renamed from: a */
        C5517a m866a(AbstractC5526j abstractC5526j) {
            this.f22596c.add(abstractC5526j);
            return this;
        }

        /* renamed from: b */
        C5515a m865b() {
            return new C5515a(this);
        }
    }

    /* renamed from: org.c.b.d.b.a$b */
    /* loaded from: classes2.dex */
    private static final class C5518b implements AbstractC5526j {
        private C5518b() {
        }

        /* renamed from: a */
        private boolean m862a(AbstractC5639c<?> abstractC5639c) {
            return Modifier.isPublic(abstractC5639c.mo443f().getModifiers());
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!m862a(abstractC5639c)) {
                list.add(new C5527b(abstractC5639c, cls, "must be declared in a public class."));
            }
        }
    }

    /* renamed from: org.c.b.d.b.a$c */
    /* loaded from: classes2.dex */
    private static final class C5519c implements AbstractC5526j {
        private C5519c() {
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!C5515a.m871d(abstractC5639c)) {
                list.add(new C5527b(abstractC5639c, cls, "must implement MethodRule or TestRule."));
            }
        }
    }

    /* renamed from: org.c.b.d.b.a$d */
    /* loaded from: classes2.dex */
    private static final class C5520d implements AbstractC5526j {
        private C5520d() {
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!C5515a.m870e(abstractC5639c)) {
                list.add(new C5527b(abstractC5639c, cls, "must implement TestRule."));
            }
        }
    }

    /* renamed from: org.c.b.d.b.a$e */
    /* loaded from: classes2.dex */
    private static final class C5521e implements AbstractC5526j {
        private C5521e() {
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            boolean m869f = C5515a.m869f(abstractC5639c);
            boolean z = abstractC5639c.a((Class<Annotation>) AbstractC5684h.class) != null;
            if (abstractC5639c.m457g()) {
                if (!m869f && z) {
                    return;
                }
                list.add(new C5527b(abstractC5639c, cls, C5515a.m869f(abstractC5639c) ? "must not be static." : "must not be static or it must be annotated with @ClassRule."));
            }
        }
    }

    /* renamed from: org.c.b.d.b.a$f */
    /* loaded from: classes2.dex */
    private static final class C5522f implements AbstractC5526j {
        private C5522f() {
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!abstractC5639c.m456h()) {
                list.add(new C5527b(abstractC5639c, cls, "must be public."));
            }
        }
    }

    /* renamed from: org.c.b.d.b.a$g */
    /* loaded from: classes2.dex */
    private static final class C5523g implements AbstractC5526j {
        private C5523g() {
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!abstractC5639c.m457g()) {
                list.add(new C5527b(abstractC5639c, cls, "must be static."));
            }
        }
    }

    /* renamed from: org.c.b.d.b.a$h */
    /* loaded from: classes2.dex */
    private static final class C5524h implements AbstractC5526j {
        private C5524h() {
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!C5515a.m871d(abstractC5639c)) {
                list.add(new C5527b(abstractC5639c, cls, "must return an implementation of MethodRule or TestRule."));
            }
        }
    }

    /* renamed from: org.c.b.d.b.a$i */
    /* loaded from: classes2.dex */
    private static final class C5525i implements AbstractC5526j {
        private C5525i() {
        }

        @Override // org.p290c.p299b.p303d.p305b.C5515a.AbstractC5526j
        /* renamed from: a */
        public void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!C5515a.m870e(abstractC5639c)) {
                list.add(new C5527b(abstractC5639c, cls, "must return an implementation of TestRule."));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.c.b.d.b.a$j */
    /* loaded from: classes2.dex */
    public interface AbstractC5526j {
        /* renamed from: a */
        void mo861a(AbstractC5639c<?> abstractC5639c, Class<? extends Annotation> cls, List<Throwable> list);
    }

    C5515a(C5517a c5517a) {
        this.f22591e = c5517a.f22594a;
        this.f22592f = c5517a.f22595b;
        this.f22593g = c5517a.f22596c;
    }

    /* renamed from: a */
    private static C5517a m878a() {
        return new C5517a(AbstractC5684h.class);
    }

    /* renamed from: a */
    private void m876a(AbstractC5639c<?> abstractC5639c, List<Throwable> list) {
        for (AbstractC5526j abstractC5526j : this.f22593g) {
            abstractC5526j.mo861a(abstractC5639c, this.f22591e, list);
        }
    }

    /* renamed from: b */
    private static C5517a m874b() {
        return new C5517a(AbstractC5691l.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m871d(AbstractC5639c<?> abstractC5639c) {
        return m869f(abstractC5639c) || m870e(abstractC5639c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m870e(AbstractC5639c<?> abstractC5639c) {
        return AbstractC5582l.class.isAssignableFrom(abstractC5639c.mo444e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static boolean m869f(AbstractC5639c<?> abstractC5639c) {
        return AbstractC5573f.class.isAssignableFrom(abstractC5639c.mo444e());
    }

    /* renamed from: a */
    public void m875a(C5648k c5648k, List<Throwable> list) {
        for (AbstractC5639c<?> abstractC5639c : this.f22592f ? c5648k.m417b(this.f22591e) : c5648k.m413c(this.f22591e)) {
            m876a(abstractC5639c, list);
        }
    }
}
