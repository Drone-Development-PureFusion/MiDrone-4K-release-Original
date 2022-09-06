package org.p290c.p312f;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.p290c.AbstractC5436a;
import org.p290c.AbstractC5635f;
import org.p290c.AbstractC5690k;
import org.p290c.AbstractC5691l;
import org.p290c.AbstractC5692m;
import org.p290c.p299b.p303d.p304a.AbstractC5513c;
import org.p290c.p299b.p303d.p305b.C5515a;
import org.p290c.p299b.p303d.p306c.C5529a;
import org.p290c.p299b.p303d.p306c.C5530b;
import org.p290c.p299b.p303d.p306c.C5531c;
import org.p290c.p299b.p303d.p306c.C5535d;
import org.p290c.p299b.p303d.p306c.C5536e;
import org.p290c.p299b.p303d.p306c.C5537f;
import org.p290c.p308d.AbstractC5573f;
import org.p290c.p308d.AbstractC5582l;
import org.p290c.p308d.C5575h;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p311b.C5608c;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5640d;
/* renamed from: org.c.f.b */
/* loaded from: classes.dex */
public class C5653b extends AbstractC5665f<C5640d> {

    /* renamed from: a */
    private final ConcurrentHashMap<C5640d, C5619c> f22758a = new ConcurrentHashMap<>();

    public C5653b(Class<?> cls) {
        super(cls);
    }

    /* renamed from: a */
    private Class<? extends Throwable> m392a(AbstractC5692m abstractC5692m) {
        if (abstractC5692m == null || abstractC5692m.m279a() == AbstractC5692m.C5693a.class) {
            return null;
        }
        return abstractC5692m.m279a();
    }

    /* renamed from: a */
    private AbstractC5647j m395a(C5640d c5640d, List<AbstractC5582l> list, Object obj, AbstractC5647j abstractC5647j) {
        for (AbstractC5573f abstractC5573f : m381e(obj)) {
            if (!list.contains(abstractC5573f)) {
                abstractC5647j = abstractC5573f.mo603a(abstractC5647j, c5640d, obj);
            }
        }
        return abstractC5647j;
    }

    /* renamed from: a */
    private AbstractC5647j m394a(C5640d c5640d, List<AbstractC5582l> list, AbstractC5647j abstractC5647j) {
        return list.isEmpty() ? abstractC5647j : new C5575h(abstractC5647j, list, mo311d(c5640d));
    }

    /* renamed from: b */
    private boolean m388b(AbstractC5692m abstractC5692m) {
        return m392a(abstractC5692m) != null;
    }

    /* renamed from: c */
    private long m384c(AbstractC5692m abstractC5692m) {
        if (abstractC5692m == null) {
            return 0L;
        }
        return abstractC5692m.m278b();
    }

    /* renamed from: e */
    private List<AbstractC5573f> m381e(Object obj) {
        return m399a(obj);
    }

    /* renamed from: e */
    private AbstractC5647j m379e(C5640d c5640d, Object obj, AbstractC5647j abstractC5647j) {
        List<AbstractC5582l> m391b = m391b(obj);
        return m394a(c5640d, m391b, m395a(c5640d, m391b, obj, abstractC5647j));
    }

    /* renamed from: i */
    private void m376i(List<Throwable> list) {
        C5515a.f22590d.m875a(g(), list);
    }

    /* renamed from: j */
    private boolean m375j() {
        return g().m412d().getConstructors().length == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public List<C5640d> mo400a() {
        return g().m417b(AbstractC5692m.class);
    }

    /* renamed from: a */
    protected List<AbstractC5573f> m399a(Object obj) {
        List<AbstractC5573f> m416b = g().m416b(obj, AbstractC5691l.class, AbstractC5573f.class);
        m416b.addAll(g().m423a(obj, AbstractC5691l.class, AbstractC5573f.class));
        return m416b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public AbstractC5647j mo398a(C5640d c5640d) {
        try {
            Object a = new AbstractC5513c() { // from class: org.c.f.b.1
                @Override // org.p290c.p299b.p303d.p304a.AbstractC5513c
                /* renamed from: b */
                protected Object mo374b() {
                    return C5653b.this.mo373b();
                }
            }.a();
            return m379e(c5640d, a, m382d(c5640d, a, m385c(c5640d, a, m389b(c5640d, a, m396a(c5640d, a, mo397a(c5640d, a))))));
        } catch (Throwable th) {
            return new C5530b(th);
        }
    }

    /* renamed from: a */
    protected AbstractC5647j mo397a(C5640d c5640d, Object obj) {
        return new C5535d(c5640d, obj);
    }

    /* renamed from: a */
    protected AbstractC5647j m396a(C5640d c5640d, Object obj, AbstractC5647j abstractC5647j) {
        AbstractC5692m abstractC5692m = (AbstractC5692m) c5640d.mo424a((Class<Annotation>) AbstractC5692m.class);
        return m388b(abstractC5692m) ? new C5529a(abstractC5647j, m392a(abstractC5692m)) : abstractC5647j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: a */
    public void mo345a(List<Throwable> list) {
        super.mo345a(list);
        m383d(list);
        mo372b(list);
        m377g(list);
        mo370h(list);
        m376i(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo316a(C5640d c5640d, C5608c c5608c) {
        C5619c mo311d = mo311d(c5640d);
        if (mo331c(c5640d)) {
            c5608c.m558c(mo311d);
        } else {
            a(mo398a(c5640d), mo311d, c5608c);
        }
    }

    /* renamed from: b */
    protected Object mo373b() {
        return g().m408f().newInstance(new Object[0]);
    }

    /* renamed from: b */
    protected List<AbstractC5582l> m391b(Object obj) {
        List<AbstractC5582l> m416b = g().m416b(obj, AbstractC5691l.class, AbstractC5582l.class);
        m416b.addAll(g().m423a(obj, AbstractC5691l.class, AbstractC5582l.class));
        return m416b;
    }

    @Deprecated
    /* renamed from: b */
    protected AbstractC5647j m389b(C5640d c5640d, Object obj, AbstractC5647j abstractC5647j) {
        long m384c = m384c((AbstractC5692m) c5640d.mo424a((Class<Annotation>) AbstractC5692m.class));
        return m384c <= 0 ? abstractC5647j : C5531c.m855b().m851a(m384c, TimeUnit.MILLISECONDS).m849a(abstractC5647j);
    }

    /* renamed from: b */
    protected void mo372b(List<Throwable> list) {
        m380e(list);
        m378f(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: b */
    public boolean mo331c(C5640d c5640d) {
        return c5640d.mo424a((Class<Annotation>) AbstractC5690k.class) != null;
    }

    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: c */
    protected List<C5640d> mo312c() {
        return mo400a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public C5619c mo311d(C5640d c5640d) {
        C5619c c5619c = this.f22758a.get(c5640d);
        if (c5619c == null) {
            C5619c m548a = C5619c.m548a(g().m412d(), mo371d(c5640d), c5640d.mo425a());
            this.f22758a.putIfAbsent(c5640d, m548a);
            return m548a;
        }
        return c5619c;
    }

    /* renamed from: c */
    protected AbstractC5647j m385c(C5640d c5640d, Object obj, AbstractC5647j abstractC5647j) {
        List<C5640d> m417b = g().m417b(AbstractC5635f.class);
        return m417b.isEmpty() ? abstractC5647j : new C5537f(abstractC5647j, m417b, obj);
    }

    /* renamed from: c */
    protected void mo387c(List<Throwable> list) {
        a(AbstractC5692m.class, false, list);
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    protected String mo371d(C5640d c5640d) {
        return c5640d.mo450b();
    }

    /* renamed from: d */
    protected AbstractC5647j m382d(C5640d c5640d, Object obj, AbstractC5647j abstractC5647j) {
        List<C5640d> m417b = g().m417b(AbstractC5436a.class);
        return m417b.isEmpty() ? abstractC5647j : new C5536e(abstractC5647j, m417b, obj);
    }

    /* renamed from: d */
    protected void m383d(List<Throwable> list) {
        if (g().m405h()) {
            list.add(new Exception("The inner class " + g().m410e() + " is not static."));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void m380e(List<Throwable> list) {
        if (!m375j()) {
            list.add(new Exception("Test class should have exactly one public constructor"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void m378f(List<Throwable> list) {
        if (g().m405h() || !m375j() || g().m408f().getParameterTypes().length == 0) {
            return;
        }
        list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
    }

    @Deprecated
    /* renamed from: g */
    protected void m377g(List<Throwable> list) {
        a(AbstractC5436a.class, false, list);
        a(AbstractC5635f.class, false, list);
        mo387c(list);
        if (mo400a().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void mo370h(List<Throwable> list) {
        C5515a.f22588b.m875a(g(), list);
    }
}
