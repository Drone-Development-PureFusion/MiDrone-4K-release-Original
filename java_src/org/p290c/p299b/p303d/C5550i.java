package org.p290c.p299b.p303d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p069c.p071b.AbstractC0618i;
import p069c.p072c.AbstractC0626a;
/* renamed from: org.c.b.d.i */
/* loaded from: classes2.dex */
public class C5550i extends C5539e {
    public C5550i(Class<?> cls) {
        super(m801a(cls));
    }

    /* renamed from: a */
    public static AbstractC0618i m801a(Class<?> cls) {
        try {
            Method method = cls.getMethod(AbstractC0626a.f1413a, new Class[0]);
            if (Modifier.isStatic(method.getModifiers())) {
                return (AbstractC0618i) method.invoke(null, new Object[0]);
            }
            throw new Exception(cls.getName() + ".suite() must be static");
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
