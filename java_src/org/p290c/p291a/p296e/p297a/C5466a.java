package org.p290c.p291a.p296e.p297a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.p290c.C5564d;
import org.p290c.p291a.p296e.AbstractC5465a;
import org.p290c.p291a.p296e.AbstractC5474b;
import org.p290c.p291a.p296e.AbstractC5479e;
import org.p290c.p291a.p296e.AbstractC5481g;
import org.p290c.p291a.p296e.C5478d;
import org.p290c.p312f.p313a.C5638b;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.a.e.a.a */
/* loaded from: classes.dex */
public class C5466a extends AbstractC5479e {

    /* renamed from: a */
    private final C5648k f22534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.c.a.e.a.a$a */
    /* loaded from: classes.dex */
    public static class C5468a extends AbstractC5481g {

        /* renamed from: a */
        private final C5640d f22535a;

        private C5468a(C5640d c5640d) {
            this.f22535a = c5640d;
        }

        @Override // org.p290c.p291a.p296e.AbstractC5481g
        /* renamed from: a */
        public Object mo942a() {
            try {
                return this.f22535a.m455a((Object) null, new Object[0]);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (IllegalArgumentException e2) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (Throwable th) {
                AbstractC5465a abstractC5465a = (AbstractC5465a) this.f22535a.mo424a((Class<Annotation>) AbstractC5465a.class);
                C5564d.m685a(abstractC5465a == null || !C5466a.m988b(abstractC5465a.m996b(), th));
                throw new AbstractC5481g.C5483a(th);
            }
        }

        @Override // org.p290c.p291a.p296e.AbstractC5481g
        /* renamed from: b */
        public String mo941b() {
            return this.f22535a.mo450b();
        }
    }

    public C5466a(C5648k c5648k) {
        this.f22534a = c5648k;
    }

    /* renamed from: a */
    private Object m994a(Field field) {
        try {
            return field.get(null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        } catch (IllegalArgumentException e2) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        }
    }

    /* renamed from: a */
    private void m995a(Class<?> cls, C5478d c5478d, String str, List<AbstractC5481g> list, Object obj) {
        if (cls.isArray()) {
            m992a(c5478d, str, list, obj);
        } else if (!Iterable.class.isAssignableFrom(cls)) {
        } else {
            m993a(c5478d, str, list, (Iterable) obj);
        }
    }

    /* renamed from: a */
    private void m993a(C5478d c5478d, String str, List<AbstractC5481g> list, Iterable<?> iterable) {
        int i = 0;
        for (Object obj : iterable) {
            if (c5478d.m957a(obj)) {
                list.add(AbstractC5481g.m943a(str + "[" + i + "]", obj));
            }
            i++;
        }
    }

    /* renamed from: a */
    private void m992a(C5478d c5478d, String str, List<AbstractC5481g> list, Object obj) {
        for (int i = 0; i < Array.getLength(obj); i++) {
            Object obj2 = Array.get(obj, i);
            if (c5478d.m957a(obj2)) {
                list.add(AbstractC5481g.m943a(str + "[" + i + "]", obj2));
            }
        }
    }

    /* renamed from: a */
    private void m991a(C5478d c5478d, List<AbstractC5481g> list) {
        Iterator<C5640d> it2 = mo968b(c5478d).iterator();
        while (it2.hasNext()) {
            C5640d next = it2.next();
            Class<?> m442i = next.m442i();
            if ((m442i.isArray() && c5478d.m950b(m442i.getComponentType())) || Iterable.class.isAssignableFrom(m442i)) {
                try {
                    m995a(m442i, c5478d, next.mo450b(), list, next.m455a((Object) null, new Object[0]));
                } finally {
                }
            }
        }
    }

    /* renamed from: b */
    private void m989b(C5478d c5478d, List<AbstractC5481g> list) {
        for (C5640d c5640d : mo965e(c5478d)) {
            if (c5478d.m959a(c5640d.mo444e())) {
                list.add(new C5468a(c5640d));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m988b(Class<?>[] clsArr, Object obj) {
        for (Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m987c(C5478d c5478d, List<AbstractC5481g> list) {
        for (Field field : mo966d(c5478d)) {
            m995a(field.getType(), c5478d, field.getName(), list, m994a(field));
        }
    }

    /* renamed from: d */
    private void m986d(C5478d c5478d, List<AbstractC5481g> list) {
        for (Field field : mo967c(c5478d)) {
            Object m994a = m994a(field);
            if (c5478d.m957a(m994a)) {
                list.add(AbstractC5481g.m943a(field.getName(), m994a));
            }
        }
    }

    @Override // org.p290c.p291a.p296e.AbstractC5479e
    /* renamed from: a */
    public List<AbstractC5481g> mo945a(C5478d c5478d) {
        ArrayList arrayList = new ArrayList();
        m986d(c5478d, arrayList);
        m987c(c5478d, arrayList);
        m989b(c5478d, arrayList);
        m991a(c5478d, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Collection<C5640d> mo968b(C5478d c5478d) {
        return this.f22534a.m417b(AbstractC5474b.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public Collection<Field> mo967c(C5478d c5478d) {
        List<C5638b> m413c = this.f22534a.m413c(AbstractC5465a.class);
        ArrayList arrayList = new ArrayList();
        for (C5638b c5638b : m413c) {
            arrayList.add(c5638b.m459d());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public Collection<Field> mo966d(C5478d c5478d) {
        List<C5638b> m413c = this.f22534a.m413c(AbstractC5474b.class);
        ArrayList arrayList = new ArrayList();
        for (C5638b c5638b : m413c) {
            arrayList.add(c5638b.m459d());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public Collection<C5640d> mo965e(C5478d c5478d) {
        return this.f22534a.m417b(AbstractC5465a.class);
    }
}
