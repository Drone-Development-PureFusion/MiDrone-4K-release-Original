package org.p290c.p299b.p303d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.p290c.AbstractC5436a;
import org.p290c.AbstractC5490b;
import org.p290c.AbstractC5635f;
import org.p290c.AbstractC5672g;
import org.p290c.AbstractC5692m;
@Deprecated
/* renamed from: org.c.b.d.h */
/* loaded from: classes.dex */
public class C5549h {

    /* renamed from: a */
    private final List<Throwable> f22635a = new ArrayList();

    /* renamed from: b */
    private C5551j f22636b;

    public C5549h(C5551j c5551j) {
        this.f22636b = c5551j;
    }

    /* renamed from: a */
    private void m806a(Class<? extends Annotation> cls, boolean z) {
        for (Method method : this.f22636b.m799a(cls)) {
            if (Modifier.isStatic(method.getModifiers()) != z) {
                this.f22635a.add(new Exception("Method " + method.getName() + "() " + (z ? "should" : "should not") + " be static"));
            }
            if (!Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                this.f22635a.add(new Exception("Class " + method.getDeclaringClass().getName() + " should be public"));
            }
            if (!Modifier.isPublic(method.getModifiers())) {
                this.f22635a.add(new Exception("Method " + method.getName() + " should be public"));
            }
            if (method.getReturnType() != Void.TYPE) {
                this.f22635a.add(new Exception("Method " + method.getName() + " should be void"));
            }
            if (method.getParameterTypes().length != 0) {
                this.f22635a.add(new Exception("Method " + method.getName() + " should have no parameters"));
            }
        }
    }

    /* renamed from: a */
    public void m807a() {
        m806a(AbstractC5436a.class, false);
        m806a(AbstractC5635f.class, false);
        m806a(AbstractC5692m.class, false);
        if (this.f22636b.m799a(AbstractC5692m.class).size() == 0) {
            this.f22635a.add(new Exception("No runnable methods"));
        }
    }

    /* renamed from: b */
    public void m805b() {
        m806a(AbstractC5672g.class, true);
        m806a(AbstractC5490b.class, true);
    }

    /* renamed from: c */
    public List<Throwable> m804c() {
        m802e();
        m805b();
        m807a();
        return this.f22635a;
    }

    /* renamed from: d */
    public void m803d() {
        if (!this.f22635a.isEmpty()) {
            throw new C5538d(this.f22635a);
        }
    }

    /* renamed from: e */
    public void m802e() {
        try {
            this.f22636b.m792d();
        } catch (Exception e) {
            this.f22635a.add(new Exception("Test class should have public zero-argument constructor", e));
        }
    }
}
