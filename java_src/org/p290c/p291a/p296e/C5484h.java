package org.p290c.p291a.p296e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p290c.C5562c;
import org.p290c.C5564d;
import org.p290c.p291a.p296e.p297a.C5469b;
import org.p290c.p291a.p296e.p297a.C5472e;
import org.p290c.p299b.C5500b;
import org.p290c.p312f.C5653b;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.a.e.h */
/* loaded from: classes2.dex */
public class C5484h extends C5653b {

    /* renamed from: org.c.a.e.h$a */
    /* loaded from: classes2.dex */
    public static class C5485a extends AbstractC5647j {

        /* renamed from: b */
        private final C5640d f22546b;

        /* renamed from: c */
        private final C5648k f22547c;

        /* renamed from: a */
        private int f22545a = 0;

        /* renamed from: d */
        private List<C5500b> f22548d = new ArrayList();

        public C5485a(C5640d c5640d, C5648k c5648k) {
            this.f22546b = c5640d;
            this.f22547c = c5648k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public AbstractC5647j m932a(final C5640d c5640d, final C5469b c5469b, final Object obj) {
            return new AbstractC5647j() { // from class: org.c.a.e.h.a.2
                @Override // org.p290c.p312f.p313a.AbstractC5647j
                /* renamed from: a */
                public void mo318a() {
                    Object[] m974e = c5469b.m974e();
                    if (!C5485a.this.m927d()) {
                        C5564d.m684a(m974e);
                    }
                    c5640d.m455a(obj, m974e);
                }
            };
        }

        /* renamed from: c */
        private C5648k m929c() {
            return this.f22547c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public boolean m927d() {
            AbstractC5489i abstractC5489i = (AbstractC5489i) this.f22546b.m445d().getAnnotation(AbstractC5489i.class);
            if (abstractC5489i == null) {
                return false;
            }
            return abstractC5489i.m926a();
        }

        @Override // org.p290c.p312f.p313a.AbstractC5647j
        /* renamed from: a */
        public void mo318a() {
            m936a(C5469b.m982a(this.f22546b.m445d(), m929c()));
            boolean z = this.f22546b.mo424a((Class<Annotation>) AbstractC5489i.class) != null;
            if (this.f22545a != 0 || !z) {
                return;
            }
            C5562c.m757a("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.f22548d);
        }

        /* renamed from: a */
        protected void m937a(Throwable th, Object... objArr) {
            if (objArr.length == 0) {
                throw th;
            }
            throw new C5472e(th, this.f22546b.mo450b(), objArr);
        }

        /* renamed from: a */
        protected void m936a(C5469b c5469b) {
            if (!c5469b.m985a()) {
                m930b(c5469b);
            } else {
                m928c(c5469b);
            }
        }

        /* renamed from: a */
        protected void m933a(C5500b c5500b) {
            this.f22548d.add(c5500b);
        }

        /* renamed from: b */
        protected void m931b() {
            this.f22545a++;
        }

        /* renamed from: b */
        protected void m930b(C5469b c5469b) {
            for (AbstractC5481g abstractC5481g : c5469b.m976c()) {
                m936a(c5469b.m980a(abstractC5481g));
            }
        }

        /* renamed from: c */
        protected void m928c(final C5469b c5469b) {
            new C5653b(m929c().m412d()) { // from class: org.c.a.e.h.a.1
                @Override // org.p290c.p312f.C5653b
                /* renamed from: a */
                public AbstractC5647j mo398a(C5640d c5640d) {
                    final AbstractC5647j mo398a = super.mo398a(c5640d);
                    return new AbstractC5647j() { // from class: org.c.a.e.h.a.1.1
                        @Override // org.p290c.p312f.p313a.AbstractC5647j
                        /* renamed from: a */
                        public void mo318a() {
                            try {
                                mo398a.mo318a();
                                C5485a.this.m931b();
                            } catch (C5500b e) {
                                C5485a.this.m933a(e);
                            } catch (Throwable th) {
                                C5485a.this.m937a(th, c5469b.m979a(C5485a.this.m927d()));
                            }
                        }
                    };
                }

                @Override // org.p290c.p312f.C5653b
                /* renamed from: a */
                protected AbstractC5647j mo397a(C5640d c5640d, Object obj) {
                    return C5485a.this.m932a(c5640d, c5469b, obj);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.p290c.p312f.C5653b, org.p290c.p312f.AbstractC5665f
                /* renamed from: a */
                public void mo345a(List<Throwable> list) {
                }

                @Override // org.p290c.p312f.C5653b
                /* renamed from: b */
                public Object mo373b() {
                    Object[] m975d = c5469b.m975d();
                    if (!C5485a.this.m927d()) {
                        C5564d.m684a(m975d);
                    }
                    return g().m408f().newInstance(m975d);
                }
            }.mo398a(this.f22546b).mo318a();
        }
    }

    public C5484h(Class<?> cls) {
        super(cls);
    }

    /* renamed from: a */
    private void m940a(Class<? extends AbstractC5479e> cls, List<Throwable> list) {
        Constructor<?>[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
            return;
        }
        Class<?>[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length == 0 || parameterTypes[0].equals(C5648k.class)) {
            return;
        }
        list.add(new Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a single TestClass instance"));
    }

    /* renamed from: i */
    private void m939i(List<Throwable> list) {
        Field[] declaredFields;
        for (Field field : g().m412d().getDeclaredFields()) {
            if (field.getAnnotation(AbstractC5465a.class) != null || field.getAnnotation(AbstractC5474b.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
    }

    /* renamed from: j */
    private void m938j(List<Throwable> list) {
        Method[] declaredMethods;
        for (Method method : g().m412d().getDeclaredMethods()) {
            if (method.getAnnotation(AbstractC5465a.class) != null || method.getAnnotation(AbstractC5474b.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be static"));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be public"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.C5653b
    /* renamed from: a */
    public List<C5640d> mo400a() {
        ArrayList arrayList = new ArrayList(super.mo400a());
        List<C5640d> m417b = g().m417b(AbstractC5489i.class);
        arrayList.removeAll(m417b);
        arrayList.addAll(m417b);
        return arrayList;
    }

    @Override // org.p290c.p312f.C5653b
    /* renamed from: a */
    public AbstractC5647j mo398a(C5640d c5640d) {
        return new C5485a(c5640d, g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.C5653b, org.p290c.p312f.AbstractC5665f
    /* renamed from: a */
    public void mo345a(List<Throwable> list) {
        super.mo345a(list);
        m939i(list);
        m938j(list);
    }

    @Override // org.p290c.p312f.C5653b
    /* renamed from: b */
    protected void mo372b(List<Throwable> list) {
        e(list);
    }

    @Override // org.p290c.p312f.C5653b
    /* renamed from: c */
    protected void mo387c(List<Throwable> list) {
        for (C5640d c5640d : mo400a()) {
            if (c5640d.mo424a((Class<Annotation>) AbstractC5489i.class) != null) {
                c5640d.m447b(false, list);
                c5640d.m449b(list);
            } else {
                c5640d.m451a(false, list);
            }
            Iterator<C5478d> it2 = C5478d.m955a(c5640d.m445d()).iterator();
            while (it2.hasNext()) {
                AbstractC5480f abstractC5480f = (AbstractC5480f) it2.next().m947d(AbstractC5480f.class);
                if (abstractC5480f != null) {
                    m940a(abstractC5480f.m944a(), list);
                }
            }
        }
    }
}
