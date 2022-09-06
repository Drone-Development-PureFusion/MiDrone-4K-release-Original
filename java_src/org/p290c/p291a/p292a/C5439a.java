package org.p290c.p291a.p292a;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p310a.AbstractC5595a;
import org.p290c.p309e.p310a.C5600c;
import org.p290c.p312f.C5670g;
import org.p290c.p312f.p313a.AbstractC5645h;
import org.p290c.p312f.p313a.C5642e;
/* renamed from: org.c.a.a.a */
/* loaded from: classes.dex */
public class C5439a extends C5670g {

    /* renamed from: org.c.a.a.a$a */
    /* loaded from: classes.dex */
    public static class C5440a extends AbstractC5595a {

        /* renamed from: b */
        private final Set<Class<?>> f22512b;

        /* renamed from: c */
        private final Set<Class<?>> f22513c;

        /* renamed from: d */
        private final boolean f22514d;

        /* renamed from: e */
        private final boolean f22515e;

        /* JADX INFO: Access modifiers changed from: protected */
        public C5440a(boolean z, Set<Class<?>> set, boolean z2, Set<Class<?>> set2) {
            this.f22514d = z;
            this.f22515e = z2;
            this.f22512b = m1054a(set);
            this.f22513c = m1054a(set2);
        }

        /* renamed from: a */
        private static Set<Class<?>> m1054a(Set<Class<?>> set) {
            HashSet hashSet = new HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            hashSet.remove(null);
            return hashSet;
        }

        /* renamed from: a */
        public static C5440a m1055a(Class<?> cls) {
            return m1051a(true, (Class<?>[]) new Class[]{cls});
        }

        /* renamed from: a */
        public static C5440a m1052a(boolean z, Set<Class<?>> set, boolean z2, Set<Class<?>> set2) {
            return new C5440a(z, set, z2, set2);
        }

        /* renamed from: a */
        public static C5440a m1051a(boolean z, Class<?>... clsArr) {
            if (m1044c(clsArr)) {
                throw new NullPointerException("has null category");
            }
            return m1052a(z, C5439a.m1060b(clsArr), true, null);
        }

        /* renamed from: a */
        public static C5440a m1050a(Class<?>... clsArr) {
            return m1051a(true, clsArr);
        }

        /* renamed from: a */
        private boolean m1053a(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> cls : set2) {
                if (C5439a.m1062b(set, cls)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        public static C5440a m1049b(Class<?> cls) {
            return m1047b(true, (Class<?>[]) new Class[]{cls});
        }

        /* renamed from: b */
        public static C5440a m1047b(boolean z, Class<?>... clsArr) {
            if (m1044c(clsArr)) {
                throw new NullPointerException("has null category");
            }
            return m1052a(true, null, z, C5439a.m1060b(clsArr));
        }

        /* renamed from: b */
        public static C5440a m1046b(Class<?>... clsArr) {
            return m1047b(true, clsArr);
        }

        /* renamed from: b */
        private boolean m1048b(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> cls : set2) {
                if (!C5439a.m1062b(set, cls)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: c */
        private boolean m1045c(C5619c c5619c) {
            Set<Class<?>> m1043d = m1043d(c5619c);
            if (m1043d.isEmpty()) {
                return this.f22512b.isEmpty();
            }
            if (!this.f22513c.isEmpty()) {
                if (this.f22515e) {
                    if (m1053a(m1043d, this.f22513c)) {
                        return false;
                    }
                } else if (m1048b(m1043d, this.f22513c)) {
                    return false;
                }
            }
            if (this.f22512b.isEmpty()) {
                return true;
            }
            return this.f22514d ? m1053a(m1043d, this.f22512b) : m1048b(m1043d, this.f22512b);
        }

        /* renamed from: c */
        private static boolean m1044c(Class<?>... clsArr) {
            if (clsArr == null) {
                return false;
            }
            for (Class<?> cls : clsArr) {
                if (cls == null) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: d */
        private static Set<Class<?>> m1043d(C5619c c5619c) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, m1041f(c5619c));
            Collections.addAll(hashSet, m1041f(m1042e(c5619c)));
            return hashSet;
        }

        /* renamed from: e */
        private static C5619c m1042e(C5619c c5619c) {
            Class<?> m533i = c5619c.m533i();
            if (m533i == null) {
                return null;
            }
            return C5619c.m550a(m533i);
        }

        /* renamed from: f */
        private static Class<?>[] m1041f(C5619c c5619c) {
            if (c5619c == null) {
                return new Class[0];
            }
            AbstractC5443b abstractC5443b = (AbstractC5443b) c5619c.m540b(AbstractC5443b.class);
            return abstractC5443b == null ? new Class[0] : abstractC5443b.m1036a();
        }

        @Override // org.p290c.p309e.p310a.AbstractC5595a
        /* renamed from: a */
        public String mo580a() {
            return toString();
        }

        @Override // org.p290c.p309e.p310a.AbstractC5595a
        /* renamed from: a */
        public boolean mo579a(C5619c c5619c) {
            if (m1045c(c5619c)) {
                return true;
            }
            Iterator<C5619c> it2 = c5619c.m541b().iterator();
            while (it2.hasNext()) {
                if (mo579a(it2.next())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder append = new StringBuilder("categories ").append(this.f22512b.isEmpty() ? "[all]" : this.f22512b);
            if (!this.f22513c.isEmpty()) {
                append.append(" - ").append(this.f22513c);
            }
            return append.toString();
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: org.c.a.a.a$b */
    /* loaded from: classes.dex */
    public @interface AbstractC5441b {
        /* renamed from: a */
        Class<?>[] m1040a() default {};

        /* renamed from: b */
        boolean m1039b() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: org.c.a.a.a$c */
    /* loaded from: classes.dex */
    public @interface AbstractC5442c {
        /* renamed from: a */
        Class<?>[] m1038a() default {};

        /* renamed from: b */
        boolean m1037b() default true;
    }

    public C5439a(Class<?> cls, AbstractC5645h abstractC5645h) {
        super(cls, abstractC5645h);
        try {
            a(C5440a.m1052a(m1059c(cls), m1063b(cls), m1056e(cls), m1057d(cls)));
            m1065a(d());
        } catch (C5600c e) {
            throw new C5642e(e);
        }
    }

    /* renamed from: a */
    private static void m1065a(C5619c c5619c) {
        if (!m1058c(c5619c)) {
            m1061b(c5619c);
        }
        Iterator<C5619c> it2 = c5619c.m541b().iterator();
        while (it2.hasNext()) {
            m1065a(it2.next());
        }
    }

    /* renamed from: b */
    private static Set<Class<?>> m1063b(Class<?> cls) {
        AbstractC5442c abstractC5442c = (AbstractC5442c) cls.getAnnotation(AbstractC5442c.class);
        return m1060b(abstractC5442c == null ? null : abstractC5442c.m1038a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Set<Class<?>> m1060b(Class<?>... clsArr) {
        HashSet hashSet = new HashSet();
        if (clsArr != null) {
            Collections.addAll(hashSet, clsArr);
        }
        return hashSet;
    }

    /* renamed from: b */
    private static void m1061b(C5619c c5619c) {
        Iterator<C5619c> it2 = c5619c.m541b().iterator();
        while (it2.hasNext()) {
            C5619c next = it2.next();
            if (next.m540b(AbstractC5443b.class) != null) {
                throw new C5642e("Category annotations on Parameterized classes are not supported on individual methods.");
            }
            m1061b(next);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m1062b(Set<Class<?>> set, Class<?> cls) {
        for (Class<?> cls2 : set) {
            if (cls.isAssignableFrom(cls2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m1059c(Class<?> cls) {
        AbstractC5442c abstractC5442c = (AbstractC5442c) cls.getAnnotation(AbstractC5442c.class);
        return abstractC5442c == null || abstractC5442c.m1037b();
    }

    /* renamed from: c */
    private static boolean m1058c(C5619c c5619c) {
        Iterator<C5619c> it2 = c5619c.m541b().iterator();
        while (it2.hasNext()) {
            if (it2.next().m533i() == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static Set<Class<?>> m1057d(Class<?> cls) {
        AbstractC5441b abstractC5441b = (AbstractC5441b) cls.getAnnotation(AbstractC5441b.class);
        return m1060b(abstractC5441b == null ? null : abstractC5441b.m1040a());
    }

    /* renamed from: e */
    private static boolean m1056e(Class<?> cls) {
        AbstractC5441b abstractC5441b = (AbstractC5441b) cls.getAnnotation(AbstractC5441b.class);
        return abstractC5441b == null || abstractC5441b.m1039b();
    }
}
