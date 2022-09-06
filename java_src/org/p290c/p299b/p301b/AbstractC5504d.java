package org.p290c.p299b.p301b;

import java.lang.reflect.Method;
import org.p287b.AbstractC5412b;
import org.p290c.p299b.C5556h;
@Deprecated
/* renamed from: org.c.b.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC5504d<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private Class<?> f22570a;

    protected AbstractC5504d() {
        this.f22570a = m901a(getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected AbstractC5504d(Class<T> cls) {
        this.f22570a = cls;
    }

    /* renamed from: a */
    private static Class<?> m901a(Class<?> cls) {
        Method[] m780a;
        while (cls != Object.class) {
            for (Method method : C5556h.m780a(cls)) {
                if (m899a(method)) {
                    return method.getParameterTypes()[0];
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for matchesSafely() method.");
    }

    /* renamed from: a */
    private static boolean m899a(Method method) {
        return method.getName().equals("matchesSafely") && method.getParameterTypes().length == 1 && !method.isSynthetic();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public final boolean mo900a(Object obj) {
        return obj != 0 && this.f22570a.isInstance(obj) && m898b(obj);
    }

    /* renamed from: b */
    public abstract boolean m898b(T t);
}
