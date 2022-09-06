package p069c.p071b;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.p290c.p299b.C5556h;
/* renamed from: c.b.n */
/* loaded from: classes.dex */
public class C0624n implements AbstractC0618i {

    /* renamed from: a */
    private String f1410a;

    /* renamed from: b */
    private Vector<AbstractC0618i> f1411b;

    public C0624n() {
        this.f1411b = new Vector<>(10);
    }

    public C0624n(Class<?> cls) {
        this.f1411b = new Vector<>(10);
        m19833c(cls);
    }

    public C0624n(Class<? extends AbstractC0619j> cls, String str) {
        this(cls);
        m19836b(str);
    }

    public C0624n(String str) {
        this.f1411b = new Vector<>(10);
        m19836b(str);
    }

    public C0624n(Class<?>... clsArr) {
        this.f1411b = new Vector<>(10);
        for (Class<?> cls : clsArr) {
            m19846a(m19831d(cls));
        }
    }

    public C0624n(Class<? extends AbstractC0619j>[] clsArr, String str) {
        this(clsArr);
        m19836b(str);
    }

    /* renamed from: a */
    public static AbstractC0618i m19842a(Class<?> cls, String str) {
        Object newInstance;
        try {
            Constructor<?> m19843a = m19843a(cls);
            try {
                if (m19843a.getParameterTypes().length == 0) {
                    Object newInstance2 = m19843a.newInstance(new Object[0]);
                    if (newInstance2 instanceof AbstractC0619j) {
                        ((AbstractC0619j) newInstance2).m19883e(str);
                        newInstance = newInstance2;
                    } else {
                        newInstance = newInstance2;
                    }
                } else {
                    newInstance = m19843a.newInstance(str);
                }
                return (AbstractC0618i) newInstance;
            } catch (IllegalAccessException e) {
                return m19841a("Cannot access test case: " + str + " (" + m19840a(e) + ")");
            } catch (InstantiationException e2) {
                return m19841a("Cannot instantiate test case: " + str + " (" + m19840a(e2) + ")");
            } catch (InvocationTargetException e3) {
                return m19841a("Exception in constructor: " + str + " (" + m19840a(e3.getTargetException()) + ")");
            }
        } catch (NoSuchMethodException e4) {
            return m19841a("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    /* renamed from: a */
    public static AbstractC0618i m19841a(final String str) {
        return new AbstractC0619j("warning") { // from class: c.b.n.1
            @Override // p069c.p071b.AbstractC0619j
            /* renamed from: f */
            protected void mo19829f() {
                c(str);
            }
        };
    }

    /* renamed from: a */
    private static String m19840a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static Constructor<?> m19843a(Class<?> cls) {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            return cls.getConstructor(new Class[0]);
        }
    }

    /* renamed from: a */
    private void m19838a(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (list.contains(name)) {
            return;
        }
        if (m19839a(method)) {
            list.add(name);
            m19846a(m19842a(cls, name));
        } else if (!m19835b(method)) {
        } else {
            m19846a(m19841a("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
        }
    }

    /* renamed from: a */
    private boolean m19839a(Method method) {
        return m19835b(method) && Modifier.isPublic(method.getModifiers());
    }

    /* renamed from: b */
    private boolean m19835b(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }

    /* renamed from: c */
    private void m19833c(Class<?> cls) {
        this.f1410a = cls.getName();
        try {
            m19843a(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                m19846a(m19841a("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; AbstractC0618i.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                for (Method method : C5556h.m780a(cls2)) {
                    m19838a(method, arrayList, cls);
                }
            }
            if (this.f1411b.size() != 0) {
                return;
            }
            m19846a(m19841a("No tests found in " + cls.getName()));
        } catch (NoSuchMethodException e) {
            m19846a(m19841a("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    /* renamed from: d */
    private AbstractC0618i m19831d(Class<?> cls) {
        return AbstractC0619j.class.isAssignableFrom(cls) ? new C0624n(cls.asSubclass(AbstractC0619j.class)) : m19841a(cls.getCanonicalName() + " does not extend TestCase");
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public int mo19848a() {
        int i = 0;
        Iterator<AbstractC0618i> it2 = this.f1411b.iterator();
        while (true) {
            int i2 = i;
            if (it2.hasNext()) {
                i = it2.next().mo19848a() + i2;
            } else {
                return i2;
            }
        }
    }

    /* renamed from: a */
    public AbstractC0618i m19847a(int i) {
        return this.f1411b.get(i);
    }

    /* renamed from: a */
    public void m19846a(AbstractC0618i abstractC0618i) {
        this.f1411b.add(abstractC0618i);
    }

    /* renamed from: a */
    public void mo19845a(AbstractC0618i abstractC0618i, C0622m c0622m) {
        abstractC0618i.mo19844a(c0622m);
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public void mo19844a(C0622m c0622m) {
        Iterator<AbstractC0618i> it2 = this.f1411b.iterator();
        while (it2.hasNext()) {
            AbstractC0618i next = it2.next();
            if (c0622m.m19853f()) {
                return;
            }
            mo19845a(next, c0622m);
        }
    }

    /* renamed from: b */
    public void m19837b(Class<? extends AbstractC0619j> cls) {
        m19846a(new C0624n(cls));
    }

    /* renamed from: b */
    public void m19836b(String str) {
        this.f1410a = str;
    }

    /* renamed from: c */
    public String m19834c() {
        return this.f1410a;
    }

    /* renamed from: d */
    public int m19832d() {
        return this.f1411b.size();
    }

    /* renamed from: e */
    public Enumeration<AbstractC0618i> m19830e() {
        return this.f1411b.elements();
    }

    public String toString() {
        return m19834c() != null ? m19834c() : super.toString();
    }
}
