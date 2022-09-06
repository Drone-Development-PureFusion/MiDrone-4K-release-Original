package org.p290c.p312f.p313a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.p290c.AbstractC5635f;
import org.p290c.AbstractC5672g;
import org.p290c.C5562c;
import org.p290c.p299b.C5556h;
/* renamed from: org.c.f.a.k */
/* loaded from: classes.dex */
public class C5648k implements AbstractC5637a {

    /* renamed from: a */
    private static final C5650a f22751a = new C5650a();

    /* renamed from: b */
    private static final C5651b f22752b = new C5651b();

    /* renamed from: c */
    private final Class<?> f22753c;

    /* renamed from: d */
    private final Map<Class<? extends Annotation>, List<C5640d>> f22754d;

    /* renamed from: e */
    private final Map<Class<? extends Annotation>, List<C5638b>> f22755e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.c.f.a.k$a */
    /* loaded from: classes2.dex */
    public static class C5650a implements Comparator<Field> {
        private C5650a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    /* renamed from: org.c.f.a.k$b */
    /* loaded from: classes2.dex */
    private static class C5651b implements Comparator<C5640d> {
        private C5651b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C5640d c5640d, C5640d c5640d2) {
            return C5556h.f22642b.compare(c5640d.m445d(), c5640d2.m445d());
        }
    }

    public C5648k(Class<?> cls) {
        this.f22753c = cls;
        if (cls == null || cls.getConstructors().length <= 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            m420a(linkedHashMap, linkedHashMap2);
            this.f22754d = m422a(linkedHashMap);
            this.f22755e = m422a(linkedHashMap2);
            return;
        }
        throw new IllegalArgumentException("Test class can only have one constructor");
    }

    /* renamed from: a */
    private static <T> List<T> m421a(Map<Class<? extends Annotation>, List<T>> map, Class<? extends Annotation> cls, boolean z) {
        if (!map.containsKey(cls) && z) {
            map.put(cls, new ArrayList());
        }
        List<T> list = map.get(cls);
        return list == null ? Collections.emptyList() : list;
    }

    /* renamed from: a */
    private static <T extends AbstractC5639c<T>> Map<Class<? extends Annotation>, List<T>> m422a(Map<Class<? extends Annotation>, List<T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Class<? extends Annotation>, List<T>> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    protected static <T extends AbstractC5639c<T>> void m419a(T t, Map<Class<? extends Annotation>, List<T>> map) {
        for (Annotation annotation : t.a()) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            List<T> m421a = m421a((Map) map, annotationType, true);
            if (t.m458a(m421a)) {
                return;
            }
            if (m409e(annotationType)) {
                m421a.add(0, t);
            } else {
                m421a.add(t);
            }
        }
    }

    /* renamed from: b */
    private <T> List<T> m415b(Map<?, List<T>> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (List<T> list : map.values()) {
            linkedHashSet.addAll(list);
        }
        return new ArrayList(linkedHashSet);
    }

    /* renamed from: d */
    private static Field[] m411d(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.sort(declaredFields, f22751a);
        return declaredFields;
    }

    /* renamed from: e */
    private static boolean m409e(Class<? extends Annotation> cls) {
        return cls.equals(AbstractC5635f.class) || cls.equals(AbstractC5672g.class);
    }

    /* renamed from: f */
    private static List<Class<?>> m407f(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5637a
    /* renamed from: a */
    public <T extends Annotation> T mo424a(Class<T> cls) {
        if (this.f22753c == null) {
            return null;
        }
        return (T) this.f22753c.getAnnotation(cls);
    }

    /* renamed from: a */
    public <T> List<T> m423a(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (C5638b c5638b : m413c(cls)) {
            try {
                Object m461a = c5638b.m461a(obj);
                if (cls2.isInstance(m461a)) {
                    arrayList.add(cls2.cast(m461a));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected void m420a(Map<Class<? extends Annotation>, List<C5640d>> map, Map<Class<? extends Annotation>, List<C5638b>> map2) {
        for (Class<?> cls : m407f(this.f22753c)) {
            for (Method method : C5556h.m780a(cls)) {
                m419a(new C5640d(method), map);
            }
            Field[] m411d = m411d(cls);
            for (Field field : m411d) {
                m419a(new C5638b(field), map2);
            }
        }
    }

    @Override // org.p290c.p312f.p313a.AbstractC5637a
    /* renamed from: a */
    public Annotation[] mo425a() {
        return this.f22753c == null ? new Annotation[0] : this.f22753c.getAnnotations();
    }

    /* renamed from: b */
    public List<C5640d> m418b() {
        List<C5640d> m415b = m415b(this.f22754d);
        Collections.sort(m415b, f22752b);
        return m415b;
    }

    /* renamed from: b */
    public List<C5640d> m417b(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(m421a((Map) this.f22754d, cls, false));
    }

    /* renamed from: b */
    public <T> List<T> m416b(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (C5640d c5640d : m417b(cls)) {
            try {
                if (cls2.isAssignableFrom(c5640d.m442i())) {
                    arrayList.add(cls2.cast(c5640d.m455a(obj, new Object[0])));
                }
            } catch (Throwable th) {
                throw new RuntimeException("Exception in " + c5640d.mo450b(), th);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public List<C5638b> m414c() {
        return m415b(this.f22755e);
    }

    /* renamed from: c */
    public List<C5638b> m413c(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(m421a((Map) this.f22755e, cls, false));
    }

    /* renamed from: d */
    public Class<?> m412d() {
        return this.f22753c;
    }

    /* renamed from: e */
    public String m410e() {
        return this.f22753c == null ? "null" : this.f22753c.getName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f22753c == ((C5648k) obj).f22753c;
    }

    /* renamed from: f */
    public Constructor<?> m408f() {
        Constructor<?>[] constructors = this.f22753c.getConstructors();
        C5562c.m727b(1L, constructors.length);
        return constructors[0];
    }

    /* renamed from: g */
    public boolean m406g() {
        return Modifier.isPublic(this.f22753c.getModifiers());
    }

    /* renamed from: h */
    public boolean m405h() {
        return this.f22753c.isMemberClass() && !Modifier.isStatic(this.f22753c.getModifiers());
    }

    public int hashCode() {
        if (this.f22753c == null) {
            return 0;
        }
        return this.f22753c.hashCode();
    }
}
