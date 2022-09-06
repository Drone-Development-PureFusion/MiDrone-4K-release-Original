package org.p290c.p312f;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.p290c.AbstractC5490b;
import org.p290c.AbstractC5672g;
import org.p290c.AbstractC5684h;
import org.p290c.p299b.C5500b;
import org.p290c.p299b.p303d.p304a.C5511a;
import org.p290c.p299b.p303d.p305b.C5515a;
import org.p290c.p299b.p303d.p306c.C5536e;
import org.p290c.p299b.p303d.p306c.C5537f;
import org.p290c.p308d.AbstractC5582l;
import org.p290c.p308d.C5575h;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p310a.AbstractC5595a;
import org.p290c.p309e.p310a.AbstractC5599b;
import org.p290c.p309e.p310a.AbstractC5601d;
import org.p290c.p309e.p310a.C5600c;
import org.p290c.p309e.p310a.C5602e;
import org.p290c.p309e.p311b.C5608c;
import org.p290c.p309e.p311b.C5617d;
import org.p290c.p312f.p313a.AbstractC5646i;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p312f.p313a.C5642e;
import org.p290c.p312f.p313a.C5648k;
import org.p290c.p315g.AbstractC5682e;
import org.p290c.p315g.C5675c;
import org.p290c.p315g.C5681d;
/* renamed from: org.c.f.f */
/* loaded from: classes.dex */
public abstract class AbstractC5665f<T> extends AbstractC5634l implements AbstractC5599b, AbstractC5601d {

    /* renamed from: a */
    private static final List<AbstractC5682e> f22773a = Arrays.asList(new C5675c(), new C5681d());

    /* renamed from: c */
    private final C5648k f22775c;

    /* renamed from: b */
    private final Object f22774b = new Object();

    /* renamed from: d */
    private volatile Collection<T> f22776d = null;

    /* renamed from: e */
    private volatile AbstractC5646i f22777e = new AbstractC5646i() { // from class: org.c.f.f.1
        @Override // org.p290c.p312f.p313a.AbstractC5646i
        /* renamed from: a */
        public void mo320a() {
        }

        @Override // org.p290c.p312f.p313a.AbstractC5646i
        /* renamed from: a */
        public void mo319a(Runnable runnable) {
            runnable.run();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC5665f(Class<?> cls) {
        this.f22775c = m347a(cls);
        m336b();
    }

    /* renamed from: a */
    private boolean m348a() {
        for (T t : m321j()) {
            if (!mo331c((AbstractC5665f<T>) t)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m343a(AbstractC5595a abstractC5595a, T t) {
        return abstractC5595a.mo579a(mo311d((AbstractC5665f<T>) t));
    }

    /* renamed from: b */
    private Comparator<? super T> m334b(final C5602e c5602e) {
        return (Comparator<T>) new Comparator<T>() { // from class: org.c.f.f.4
            @Override // java.util.Comparator
            public int compare(T t, T t2) {
                return c5602e.compare(AbstractC5665f.this.mo311d((AbstractC5665f) t), AbstractC5665f.this.mo311d((AbstractC5665f) t2));
            }
        };
    }

    /* renamed from: b */
    private void m336b() {
        ArrayList arrayList = new ArrayList();
        mo345a(arrayList);
        if (!arrayList.isEmpty()) {
            throw new C5642e(arrayList);
        }
    }

    /* renamed from: b */
    private void m335b(List<Throwable> list) {
        if (m323g().m412d() != null) {
            for (AbstractC5682e abstractC5682e : f22773a) {
                list.addAll(abstractC5682e.mo298a(m323g()));
            }
        }
    }

    /* renamed from: c */
    private AbstractC5647j m328c(AbstractC5647j abstractC5647j) {
        List<AbstractC5582l> m325e = m325e();
        return m325e.isEmpty() ? abstractC5647j : new C5575h(abstractC5647j, m325e, mo327d());
    }

    /* renamed from: c */
    private void m330c(List<Throwable> list) {
        C5515a.f22587a.m875a(m323g(), list);
        C5515a.f22589c.m875a(m323g(), list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m326d(final C5608c c5608c) {
        AbstractC5646i abstractC5646i = this.f22777e;
        try {
            for (final T t : m321j()) {
                abstractC5646i.mo319a(new Runnable() { // from class: org.c.f.f.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC5665f.this.mo316a((AbstractC5665f) t, c5608c);
                    }
                });
            }
        } finally {
            abstractC5646i.mo320a();
        }
    }

    /* renamed from: j */
    private Collection<T> m321j() {
        if (this.f22776d == null) {
            synchronized (this.f22774b) {
                if (this.f22776d == null) {
                    this.f22776d = Collections.unmodifiableCollection(mo312c());
                }
            }
        }
        return this.f22776d;
    }

    /* renamed from: a */
    protected AbstractC5647j m339a(AbstractC5647j abstractC5647j) {
        List<C5640d> m417b = this.f22775c.m417b(AbstractC5672g.class);
        return m417b.isEmpty() ? abstractC5647j : new C5537f(abstractC5647j, m417b, null);
    }

    /* renamed from: a */
    protected C5648k m347a(Class<?> cls) {
        return new C5648k(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m346a(Class<? extends Annotation> cls, boolean z, List<Throwable> list) {
        for (C5640d c5640d : m323g().m417b(cls)) {
            c5640d.m451a(z, list);
        }
    }

    /* renamed from: a */
    protected abstract void mo316a(T t, C5608c c5608c);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo345a(List<Throwable> list) {
        m346a(AbstractC5672g.class, true, list);
        m346a(AbstractC5490b.class, true, list);
        m330c(list);
        m335b(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p290c.p309e.p310a.AbstractC5599b
    /* renamed from: a */
    public void mo344a(AbstractC5595a abstractC5595a) {
        synchronized (this.f22774b) {
            ArrayList arrayList = new ArrayList(m321j());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (m343a(abstractC5595a, (AbstractC5595a) next)) {
                    try {
                        abstractC5595a.mo582a(next);
                    } catch (C5600c e) {
                        it2.remove();
                    }
                } else {
                    it2.remove();
                }
            }
            this.f22776d = Collections.unmodifiableCollection(arrayList);
            if (this.f22776d.isEmpty()) {
                throw new C5600c();
            }
        }
    }

    @Override // org.p290c.p309e.p310a.AbstractC5601d
    /* renamed from: a */
    public void mo342a(C5602e c5602e) {
        synchronized (this.f22774b) {
            for (T t : m321j()) {
                c5602e.m578a(t);
            }
            ArrayList arrayList = new ArrayList(m321j());
            Collections.sort(arrayList, m334b(c5602e));
            this.f22776d = Collections.unmodifiableCollection(arrayList);
        }
    }

    @Override // org.p290c.p309e.AbstractC5634l
    /* renamed from: a */
    public void mo341a(C5608c c5608c) {
        C5511a c5511a = new C5511a(c5608c, mo327d());
        try {
            mo333b(c5608c).mo318a();
        } catch (C5500b e) {
            c5511a.m886a(e);
        } catch (C5617d e2) {
            throw e2;
        } catch (Throwable th) {
            c5511a.m887a(th);
        }
    }

    /* renamed from: a */
    public void m340a(AbstractC5646i abstractC5646i) {
        this.f22777e = abstractC5646i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m338a(AbstractC5647j abstractC5647j, C5619c c5619c, C5608c c5608c) {
        C5511a c5511a = new C5511a(c5608c, c5619c);
        c5511a.m884b();
        try {
            try {
                abstractC5647j.mo318a();
                c5511a.m888a();
            } catch (C5500b e) {
                c5511a.m886a(e);
                c5511a.m888a();
            } catch (Throwable th) {
                c5511a.m887a(th);
                c5511a.m888a();
            }
        } catch (Throwable th2) {
            c5511a.m888a();
            throw th2;
        }
    }

    /* renamed from: b */
    protected AbstractC5647j mo333b(C5608c c5608c) {
        AbstractC5647j m329c = m329c(c5608c);
        return !m348a() ? m328c(m332b(m339a(m329c))) : m329c;
    }

    /* renamed from: b */
    protected AbstractC5647j m332b(AbstractC5647j abstractC5647j) {
        List<C5640d> m417b = this.f22775c.m417b(AbstractC5490b.class);
        return m417b.isEmpty() ? abstractC5647j : new C5536e(abstractC5647j, m417b, null);
    }

    /* renamed from: c */
    protected abstract List<T> mo312c();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public AbstractC5647j m329c(final C5608c c5608c) {
        return new AbstractC5647j() { // from class: org.c.f.f.2
            @Override // org.p290c.p312f.p313a.AbstractC5647j
            /* renamed from: a */
            public void mo318a() {
                AbstractC5665f.this.m326d(c5608c);
            }
        };
    }

    /* renamed from: c */
    protected boolean mo331c(T t) {
        return false;
    }

    @Override // org.p290c.p309e.AbstractC5634l, org.p290c.p309e.AbstractC5604b
    /* renamed from: d */
    public C5619c mo327d() {
        C5619c m543a = C5619c.m543a(mo324f(), mo322i());
        for (T t : m321j()) {
            m543a.m542a(mo311d((AbstractC5665f<T>) t));
        }
        return m543a;
    }

    /* renamed from: d */
    protected abstract C5619c mo311d(T t);

    /* renamed from: e */
    protected List<AbstractC5582l> m325e() {
        List<AbstractC5582l> m416b = this.f22775c.m416b(null, AbstractC5684h.class, AbstractC5582l.class);
        m416b.addAll(this.f22775c.m423a((Object) null, AbstractC5684h.class, AbstractC5582l.class));
        return m416b;
    }

    /* renamed from: f */
    protected String mo324f() {
        return this.f22775c.m410e();
    }

    /* renamed from: g */
    public final C5648k m323g() {
        return this.f22775c;
    }

    /* renamed from: i */
    protected Annotation[] mo322i() {
        return this.f22775c.mo425a();
    }
}
