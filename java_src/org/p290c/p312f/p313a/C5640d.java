package org.p290c.p312f.p313a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import org.p290c.p299b.p303d.p304a.AbstractC5513c;
/* renamed from: org.c.f.a.d */
/* loaded from: classes.dex */
public class C5640d extends AbstractC5639c<C5640d> {

    /* renamed from: a */
    private final Method f22743a;

    public C5640d(Method method) {
        if (method == null) {
            throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
        }
        this.f22743a = method;
    }

    /* renamed from: j */
    private Class<?>[] m441j() {
        return this.f22743a.getParameterTypes();
    }

    /* renamed from: a */
    public Object m455a(final Object obj, final Object... objArr) {
        return new AbstractC5513c() { // from class: org.c.f.a.d.1
            @Override // org.p290c.p299b.p303d.p304a.AbstractC5513c
            /* renamed from: b */
            protected Object mo374b() {
                return C5640d.this.f22743a.invoke(obj, objArr);
            }
        }.a();
    }

    @Override // org.p290c.p312f.p313a.AbstractC5637a
    /* renamed from: a */
    public <T extends Annotation> T mo424a(Class<T> cls) {
        return (T) this.f22743a.getAnnotation(cls);
    }

    /* renamed from: a */
    public void m451a(boolean z, List<Throwable> list) {
        m447b(z, list);
        if (this.f22743a.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.f22743a.getName() + " should have no parameters"));
        }
    }

    @Deprecated
    /* renamed from: a */
    public boolean m454a(Type type) {
        return m441j().length == 0 && (type instanceof Class) && ((Class) type).isAssignableFrom(this.f22743a.getReturnType());
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo453a(C5640d c5640d) {
        if (c5640d.mo450b().equals(mo450b()) && c5640d.m441j().length == m441j().length) {
            for (int i = 0; i < c5640d.m441j().length; i++) {
                if (!c5640d.m441j()[i].equals(m441j()[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5637a
    /* renamed from: a */
    public Annotation[] mo425a() {
        return this.f22743a.getAnnotations();
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: b */
    public String mo450b() {
        return this.f22743a.getName();
    }

    /* renamed from: b */
    public void m449b(List<Throwable> list) {
        new C5644g(this.f22743a).m433a(list);
    }

    /* renamed from: b */
    public void m447b(boolean z, List<Throwable> list) {
        if (g() != z) {
            list.add(new Exception("Method " + this.f22743a.getName() + "() " + (z ? "should" : "should not") + " be static"));
        }
        if (!h()) {
            list.add(new Exception("Method " + this.f22743a.getName() + "() should be public"));
        }
        if (this.f22743a.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.f22743a.getName() + "() should be void"));
        }
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: c */
    protected int mo446c() {
        return this.f22743a.getModifiers();
    }

    /* renamed from: d */
    public Method m445d() {
        return this.f22743a;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: e */
    public Class<?> mo444e() {
        return m442i();
    }

    public boolean equals(Object obj) {
        if (!C5640d.class.isInstance(obj)) {
            return false;
        }
        return ((C5640d) obj).f22743a.equals(this.f22743a);
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: f */
    public Class<?> mo443f() {
        return this.f22743a.getDeclaringClass();
    }

    public int hashCode() {
        return this.f22743a.hashCode();
    }

    /* renamed from: i */
    public Class<?> m442i() {
        return this.f22743a.getReturnType();
    }

    public String toString() {
        return this.f22743a.toString();
    }
}
