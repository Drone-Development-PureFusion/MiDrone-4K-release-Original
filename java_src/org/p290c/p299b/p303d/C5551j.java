package org.p290c.p299b.p303d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p290c.AbstractC5490b;
import org.p290c.AbstractC5635f;
import org.p290c.AbstractC5672g;
import org.p290c.AbstractC5692m;
import org.p290c.p299b.C5556h;
@Deprecated
/* renamed from: org.c.b.d.j */
/* loaded from: classes.dex */
public class C5551j {

    /* renamed from: a */
    private final Class<?> f22637a;

    public C5551j(Class<?> cls) {
        this.f22637a = cls;
    }

    /* renamed from: a */
    private boolean m798a(Method method, Method method2) {
        if (method2.getName().equals(method.getName()) && method2.getParameterTypes().length == method.getParameterTypes().length) {
            for (int i = 0; i < method2.getParameterTypes().length; i++) {
                if (!method2.getParameterTypes()[i].equals(method.getParameterTypes()[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m797a(Method method, List<Method> list) {
        for (Method method2 : list) {
            if (m798a(method, method2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m795b(Class<? extends Annotation> cls) {
        return cls.equals(AbstractC5635f.class) || cls.equals(AbstractC5672g.class);
    }

    /* renamed from: c */
    private List<Class<?>> m793c(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<Method> m800a() {
        return m799a(AbstractC5692m.class);
    }

    /* renamed from: a */
    public List<Method> m799a(Class<? extends Annotation> cls) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls2 : m793c(this.f22637a)) {
            Method[] m780a = C5556h.m780a(cls2);
            for (Method method : m780a) {
                if (method.getAnnotation(cls) != null && !m797a(method, arrayList)) {
                    arrayList.add(method);
                }
            }
        }
        if (m795b(cls)) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public List<Method> m796b() {
        return m799a(AbstractC5672g.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public List<Method> m794c() {
        return m799a(AbstractC5490b.class);
    }

    /* renamed from: d */
    public Constructor<?> m792d() {
        return this.f22637a.getConstructor(new Class[0]);
    }

    /* renamed from: e */
    public Class<?> m791e() {
        return this.f22637a;
    }

    /* renamed from: f */
    public String m790f() {
        return this.f22637a.getName();
    }
}
