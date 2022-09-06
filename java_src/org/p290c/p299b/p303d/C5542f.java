package org.p290c.p299b.p303d;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p310a.AbstractC5595a;
import org.p290c.p309e.p310a.AbstractC5599b;
import org.p290c.p309e.p310a.AbstractC5601d;
import org.p290c.p309e.p310a.C5600c;
import org.p290c.p309e.p310a.C5602e;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5608c;
@Deprecated
/* renamed from: org.c.b.d.f */
/* loaded from: classes.dex */
public class C5542f extends AbstractC5634l implements AbstractC5599b, AbstractC5601d {

    /* renamed from: a */
    private final List<Method> f22621a = m829a();

    /* renamed from: b */
    private C5551j f22622b;

    public C5542f(Class<?> cls) {
        this.f22622b = new C5551j(cls);
        m825b();
    }

    /* renamed from: a */
    private void m826a(C5608c c5608c, C5619c c5619c, Throwable th) {
        c5608c.m560b(c5619c);
        c5608c.m568a(new C5605a(c5619c, th));
        c5608c.m556d(c5619c);
    }

    /* renamed from: a */
    protected List<Method> m829a() {
        return this.f22622b.m800a();
    }

    /* renamed from: a */
    protected C5552k m828a(Method method) {
        return new C5552k(method, this.f22622b);
    }

    /* renamed from: a */
    protected void m827a(Method method, C5608c c5608c) {
        C5619c m821c = m821c(method);
        try {
            new C5545g(m818f(), m828a(method), c5608c, m821c).m815a();
        } catch (InvocationTargetException e) {
            m826a(c5608c, m821c, e.getCause());
        } catch (Exception e2) {
            m826a(c5608c, m821c, e2);
        }
    }

    @Override // org.p290c.p309e.p310a.AbstractC5599b
    /* renamed from: a */
    public void mo344a(AbstractC5595a abstractC5595a) {
        Iterator<Method> it2 = this.f22621a.iterator();
        while (it2.hasNext()) {
            if (!abstractC5595a.mo579a(m821c(it2.next()))) {
                it2.remove();
            }
        }
        if (this.f22621a.isEmpty()) {
            throw new C5600c();
        }
    }

    @Override // org.p290c.p309e.p310a.AbstractC5601d
    /* renamed from: a */
    public void mo342a(final C5602e c5602e) {
        Collections.sort(this.f22621a, new Comparator<Method>() { // from class: org.c.b.d.f.2
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Method method, Method method2) {
                return c5602e.compare(C5542f.this.m821c(method), C5542f.this.m821c(method2));
            }
        });
    }

    @Override // org.p290c.p309e.AbstractC5634l
    /* renamed from: a */
    public void mo341a(final C5608c c5608c) {
        new C5510a(c5608c, this.f22622b, mo327d(), new Runnable() { // from class: org.c.b.d.f.1
            @Override // java.lang.Runnable
            public void run() {
                C5542f.this.m823b(c5608c);
            }
        }).m891b();
    }

    /* renamed from: b */
    protected String m824b(Method method) {
        return method.getName();
    }

    /* renamed from: b */
    protected void m825b() {
        C5549h c5549h = new C5549h(this.f22622b);
        c5549h.m804c();
        c5549h.m803d();
    }

    /* renamed from: b */
    protected void m823b(C5608c c5608c) {
        for (Method method : this.f22621a) {
            m827a(method, c5608c);
        }
    }

    /* renamed from: c */
    protected C5619c m821c(Method method) {
        return C5619c.m548a(m817g().m791e(), m824b(method), m820d(method));
    }

    /* renamed from: c */
    protected Annotation[] m822c() {
        return this.f22622b.m791e().getAnnotations();
    }

    @Override // org.p290c.p309e.AbstractC5634l, org.p290c.p309e.AbstractC5604b
    /* renamed from: d */
    public C5619c mo327d() {
        C5619c m543a = C5619c.m543a(m819e(), m822c());
        for (Method method : this.f22621a) {
            m543a.m542a(m821c(method));
        }
        return m543a;
    }

    /* renamed from: d */
    protected Annotation[] m820d(Method method) {
        return method.getAnnotations();
    }

    /* renamed from: e */
    protected String m819e() {
        return m817g().m790f();
    }

    /* renamed from: f */
    protected Object m818f() {
        return m817g().m792d().newInstance(new Object[0]);
    }

    /* renamed from: g */
    protected C5551j m817g() {
        return this.f22622b;
    }
}
