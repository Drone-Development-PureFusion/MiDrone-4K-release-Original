package org.p290c.p299b;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import org.p290c.AbstractC5689j;
/* renamed from: org.c.b.h */
/* loaded from: classes.dex */
public class C5556h {

    /* renamed from: a */
    public static final Comparator<Method> f22641a = new Comparator<Method>() { // from class: org.c.b.h.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Method method, Method method2) {
            int hashCode = method.getName().hashCode();
            int hashCode2 = method2.getName().hashCode();
            return hashCode != hashCode2 ? hashCode < hashCode2 ? -1 : 1 : C5556h.f22642b.compare(method, method2);
        }
    };

    /* renamed from: b */
    public static final Comparator<Method> f22642b = new Comparator<Method>() { // from class: org.c.b.h.2
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Method method, Method method2) {
            int compareTo = method.getName().compareTo(method2.getName());
            return compareTo != 0 ? compareTo : method.toString().compareTo(method2.toString());
        }
    };

    private C5556h() {
    }

    /* renamed from: a */
    private static Comparator<Method> m779a(AbstractC5689j abstractC5689j) {
        return abstractC5689j == null ? f22641a : abstractC5689j.m281a().m360a();
    }

    /* renamed from: a */
    public static Method[] m780a(Class<?> cls) {
        Comparator<Method> m779a = m779a((AbstractC5689j) cls.getAnnotation(AbstractC5689j.class));
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (m779a != null) {
            Arrays.sort(declaredMethods, m779a);
        }
        return declaredMethods;
    }
}
