package org.p290c.p312f.p314b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import org.p290c.p309e.p311b.C5608c;
import org.p290c.p312f.C5653b;
import org.p290c.p312f.C5661e;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5638b;
import org.p290c.p312f.p313a.C5640d;
/* renamed from: org.c.f.b.a */
/* loaded from: classes.dex */
public class C5655a extends C5653b {

    /* renamed from: a */
    private final Object[] f22760a;

    /* renamed from: b */
    private final String f22761b;

    public C5655a(C5658d c5658d) {
        super(c5658d.m362b().m412d());
        this.f22760a = c5658d.m361c().toArray(new Object[c5658d.m361c().size()]);
        this.f22761b = c5658d.m364a();
    }

    /* renamed from: j */
    private Object m369j() {
        return g().m408f().newInstance(this.f22760a);
    }

    /* renamed from: k */
    private Object m368k() {
        List<C5638b> m367l = m367l();
        if (m367l.size() != this.f22760a.length) {
            throw new Exception("Wrong number of parameters and @Parameter fields. @Parameter fields counted: " + m367l.size() + ", available parameters: " + this.f22760a.length + ".");
        }
        Object newInstance = g().m412d().newInstance();
        for (C5638b c5638b : m367l) {
            Field m459d = c5638b.m459d();
            int m351a = ((C5661e.AbstractC5662a) m459d.getAnnotation(C5661e.AbstractC5662a.class)).m351a();
            try {
                m459d.set(newInstance, this.f22760a[m351a]);
            } catch (IllegalArgumentException e) {
                throw new Exception(g().m410e() + ": Trying to set " + m459d.getName() + " with the value " + this.f22760a[m351a] + " that is not the right type (" + this.f22760a[m351a].getClass().getSimpleName() + " instead of " + m459d.getType().getSimpleName() + ").", e);
            }
        }
        return newInstance;
    }

    /* renamed from: l */
    private List<C5638b> m367l() {
        return g().m413c(C5661e.AbstractC5662a.class);
    }

    /* renamed from: m */
    private boolean m366m() {
        return !m367l().isEmpty();
    }

    @Override // org.p290c.p312f.C5653b
    /* renamed from: b */
    public Object mo373b() {
        return m366m() ? m368k() : m369j();
    }

    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: b */
    protected AbstractC5647j mo333b(C5608c c5608c) {
        return c(c5608c);
    }

    @Override // org.p290c.p312f.C5653b
    /* renamed from: b */
    protected void mo372b(List<Throwable> list) {
        e(list);
        if (m366m()) {
            f(list);
        }
    }

    @Override // org.p290c.p312f.C5653b
    /* renamed from: d */
    protected String mo371d(C5640d c5640d) {
        return c5640d.mo450b() + mo324f();
    }

    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: f */
    protected String mo324f() {
        return this.f22761b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.C5653b
    /* renamed from: h */
    public void mo370h(List<Throwable> list) {
        super.mo370h(list);
        if (m366m()) {
            List<C5638b> m367l = m367l();
            int[] iArr = new int[m367l.size()];
            for (C5638b c5638b : m367l) {
                int m351a = ((C5661e.AbstractC5662a) c5638b.m459d().getAnnotation(C5661e.AbstractC5662a.class)).m351a();
                if (m351a < 0 || m351a > m367l.size() - 1) {
                    list.add(new Exception("Invalid @Parameter value: " + m351a + ". @Parameter fields counted: " + m367l.size() + ". Please use an index between 0 and " + (m367l.size() - 1) + "."));
                } else {
                    iArr[m351a] = iArr[m351a] + 1;
                }
            }
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    list.add(new Exception("@Parameter(" + i + ") is never used."));
                } else if (i2 > 1) {
                    list.add(new Exception("@Parameter(" + i + ") is used more than once (" + i2 + ")."));
                }
            }
        }
    }

    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: i */
    protected Annotation[] mo322i() {
        return new Annotation[0];
    }
}
