package org.p287b.p289b;

import java.lang.reflect.Method;
/* renamed from: org.b.b.b */
/* loaded from: classes2.dex */
public class C5414b {

    /* renamed from: a */
    private final String f22489a;

    /* renamed from: b */
    private final int f22490b;

    /* renamed from: c */
    private final int f22491c;

    public C5414b(String str, int i, int i2) {
        this.f22489a = str;
        this.f22490b = i;
        this.f22491c = i2;
    }

    /* renamed from: a */
    public Class<?> m1140a(Class<?> cls) {
        Method[] declaredMethods;
        while (cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                if (m1139a(method)) {
                    return m1138b(method);
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for " + this.f22489a + "() method.");
    }

    /* renamed from: a */
    protected boolean m1139a(Method method) {
        return method.getName().equals(this.f22489a) && method.getParameterTypes().length == this.f22490b && !method.isSynthetic();
    }

    /* renamed from: b */
    protected Class<?> m1138b(Method method) {
        return method.getParameterTypes()[this.f22491c];
    }
}
