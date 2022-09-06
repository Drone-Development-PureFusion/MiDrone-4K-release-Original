package p004b.p005a.p006a.p028b.p035g.p040e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0338e;
import p004b.p005a.p006a.p028b.p035g.p039d.C0339f;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p057r.C0590v;
import p004b.p005a.p006a.p028b.p057r.EnumC0567a;
/* renamed from: b.a.a.b.g.e.f */
/* loaded from: classes.dex */
public class C0356f extends C0527f {

    /* renamed from: a */
    protected Object f665a;

    /* renamed from: b */
    protected Class<?> f666b;

    /* renamed from: c */
    protected C0355e[] f667c;

    /* renamed from: d */
    protected C0354d[] f668d;

    public C0356f(Object obj) {
        this.f665a = obj;
        this.f666b = obj.getClass();
    }

    /* renamed from: a */
    private Class<?> m20803a(Method method) {
        if (method == null) {
            return null;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            return null;
        }
        return parameterTypes[0];
    }

    /* renamed from: a */
    private boolean m20812a(Class<?> cls) {
        if (cls.isInterface()) {
            return false;
        }
        try {
            return cls.newInstance() != null;
        } catch (IllegalAccessException e) {
            return false;
        } catch (InstantiationException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m20804a(String str, Method method, Class<?>[] clsArr, Object obj) {
        Class<?> cls = obj.getClass();
        if (clsArr.length != 1) {
            c("Wrong number of parameters in setter method for property [" + str + "] in " + this.f665a.getClass().getName());
            return false;
        } else if (clsArr[0].isAssignableFrom(obj.getClass())) {
            return true;
        } else {
            c("A \"" + cls.getName() + "\" object is not assignable to a \"" + clsArr[0].getName() + "\" variable.");
            c("The class \"" + clsArr[0].getName() + "\" was loaded by ");
            c("[" + clsArr[0].getClassLoader() + "] whereas object of type ");
            c("\"" + cls.getName() + "\" was loaded by [" + cls.getClassLoader() + "].");
            return false;
        }
    }

    /* renamed from: b */
    private EnumC0567a m20796b(Method method) {
        Class<?> m20803a = m20803a(method);
        return m20803a == null ? EnumC0567a.NOT_FOUND : C0358g.m20786a(m20803a) ? EnumC0567a.AS_BASIC_PROPERTY : EnumC0567a.AS_COMPLEX_PROPERTY;
    }

    /* renamed from: g */
    private Method m20793g(String str) {
        return m20800b("add" + m20791i(str));
    }

    /* renamed from: h */
    private Method m20792h(String str) {
        C0355e m20794f = m20794f(C0353c.m20825a(str));
        if (m20794f != null) {
            return m20794f.m20818b();
        }
        return null;
    }

    /* renamed from: i */
    private String m20791i(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /* renamed from: a */
    public EnumC0567a m20811a(String str) {
        Method m20793g = m20793g(str);
        if (m20793g != null) {
            switch (m20796b(m20793g)) {
                case NOT_FOUND:
                    return EnumC0567a.NOT_FOUND;
                case AS_BASIC_PROPERTY:
                    return EnumC0567a.AS_BASIC_PROPERTY_COLLECTION;
                case AS_COMPLEX_PROPERTY:
                    return EnumC0567a.AS_COMPLEX_PROPERTY_COLLECTION;
            }
        }
        Method m20792h = m20792h(str);
        return m20792h != null ? m20796b(m20792h) : EnumC0567a.NOT_FOUND;
    }

    /* renamed from: a */
    public Class<?> m20809a(String str, EnumC0567a enumC0567a, C0339f c0339f) {
        Class<?> m20907a = c0339f.m20907a(this.f665a.getClass(), str);
        if (m20907a != null) {
            return m20907a;
        }
        Method m20810a = m20810a(str, enumC0567a);
        if (m20810a == null) {
            return null;
        }
        Class<?> m20805a = m20805a(str, m20810a);
        return m20805a == null ? m20797b(str, m20810a) : m20805a;
    }

    /* renamed from: a */
    Class<?> m20805a(String str, Method method) {
        AbstractC0338e abstractC0338e = (AbstractC0338e) m20808a(str, AbstractC0338e.class, method);
        if (abstractC0338e != null) {
            return abstractC0338e.m20908a();
        }
        return null;
    }

    /* renamed from: a */
    <T extends Annotation> T m20808a(String str, Class<T> cls, Method method) {
        if (method != null) {
            return (T) method.getAnnotation(cls);
        }
        return null;
    }

    /* renamed from: a */
    Method m20810a(String str, EnumC0567a enumC0567a) {
        String m20791i = m20791i(str);
        if (enumC0567a == EnumC0567a.AS_COMPLEX_PROPERTY_COLLECTION) {
            return m20793g(m20791i);
        }
        if (enumC0567a != EnumC0567a.AS_COMPLEX_PROPERTY) {
            throw new IllegalStateException(enumC0567a + " not allowed here");
        }
        return m20792h(m20791i);
    }

    /* renamed from: a */
    protected void m20814a() {
        try {
            this.f667c = C0353c.m20824b(this.f666b);
            this.f668d = C0353c.m20826a(this.f666b);
        } catch (C0352b e) {
            c("Failed to introspect " + this.f665a + ": " + e.getMessage());
            this.f667c = new C0355e[0];
            this.f668d = new C0354d[0];
        }
    }

    /* renamed from: a */
    public void m20813a(C0355e c0355e, String str, String str2) {
        Method m20818b = c0355e.m20818b();
        if (m20818b == null) {
            throw new C0590v("No setter for property [" + str + "].");
        }
        Class<?>[] parameterTypes = m20818b.getParameterTypes();
        if (parameterTypes.length != 1) {
            throw new C0590v("#params for setter != 1");
        }
        try {
            Object m20787a = C0358g.m20787a(this, str2, parameterTypes[0]);
            if (m20787a == null) {
                throw new C0590v("Conversion to type [" + parameterTypes[0] + "] failed.");
            }
            try {
                m20818b.invoke(this.f665a, m20787a);
            } catch (Exception e) {
                throw new C0590v(e);
            }
        } catch (Throwable th) {
            throw new C0590v("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
        }
    }

    /* renamed from: a */
    public void m20807a(String str, Object obj) {
        Method m20793g = m20793g(str);
        if (m20793g == null) {
            c("Could not find method [add" + str + "] in class [" + this.f666b.getName() + "].");
        } else if (!m20804a(str, m20793g, m20793g.getParameterTypes(), obj)) {
        } else {
            m20802a(m20793g, obj);
        }
    }

    /* renamed from: a */
    public void m20806a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        String m20825a = C0353c.m20825a(str);
        C0355e m20794f = m20794f(m20825a);
        if (m20794f == null) {
            e("No such property [" + m20825a + "] in " + this.f666b.getName() + ".");
            return;
        }
        try {
            m20813a(m20794f, m20825a, str2);
        } catch (C0590v e) {
            c("Failed to set property [" + m20825a + "] to value \"" + str2 + "\". ", e);
        }
    }

    /* renamed from: a */
    void m20802a(Method method, Object obj) {
        Class<?> cls = obj.getClass();
        try {
            method.invoke(this.f665a, obj);
        } catch (Exception e) {
            a("Could not invoke method " + method.getName() + " in class " + this.f665a.getClass().getName() + " with parameter of type " + cls.getName(), (Throwable) e);
        }
    }

    /* renamed from: b */
    public Class<?> m20801b() {
        return this.f666b;
    }

    /* renamed from: b */
    Class<?> m20797b(String str, Method method) {
        Class<?> m20803a = m20803a(method);
        if (m20803a != null && m20812a(m20803a)) {
            return m20803a;
        }
        return null;
    }

    /* renamed from: b */
    protected Method m20800b(String str) {
        if (this.f668d == null) {
            m20814a();
        }
        for (int i = 0; i < this.f668d.length; i++) {
            if (str.equals(this.f668d[i].m20823a())) {
                return this.f668d[i].m20822b();
            }
        }
        return null;
    }

    /* renamed from: b */
    public void m20799b(String str, Object obj) {
        C0355e m20794f = m20794f(C0353c.m20825a(str));
        if (m20794f == null) {
            e("Could not find PropertyDescriptor for [" + str + "] in " + this.f666b.getName());
            return;
        }
        Method m20818b = m20794f.m20818b();
        if (m20818b == null) {
            e("Not setter method for property [" + str + "] in " + this.f665a.getClass().getName());
        } else if (!m20804a(str, m20818b, m20818b.getParameterTypes(), obj)) {
        } else {
            try {
                m20802a(m20818b, obj);
            } catch (Exception e) {
                a("Could not set component " + this.f665a + " for parent component " + this.f665a, (Throwable) e);
            }
        }
    }

    /* renamed from: b */
    public void m20798b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        String m20791i = m20791i(str);
        Method m20793g = m20793g(m20791i);
        if (m20793g == null) {
            c("No adder for property [" + m20791i + "].");
            return;
        }
        Class<?>[] parameterTypes = m20793g.getParameterTypes();
        m20804a(m20791i, m20793g, parameterTypes, str2);
        try {
            if (C0358g.m20787a(this, str2, parameterTypes[0]) == null) {
                return;
            }
            m20802a(m20793g, str2);
        } catch (Throwable th) {
            a("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
        }
    }

    /* renamed from: c */
    public Object m20795c() {
        return this.f665a;
    }

    /* renamed from: f */
    protected C0355e m20794f(String str) {
        if (this.f667c == null) {
            m20814a();
        }
        for (int i = 0; i < this.f667c.length; i++) {
            if (str.equals(this.f667c[i].m20821a())) {
                return this.f667c[i];
            }
        }
        return null;
    }
}
