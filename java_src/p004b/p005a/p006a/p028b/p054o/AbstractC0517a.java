package p004b.p005a.p006a.p028b.p054o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* renamed from: b.a.a.b.o.a */
/* loaded from: classes.dex */
public abstract class AbstractC0517a<C> implements AbstractC0525d<C> {

    /* renamed from: a */
    private static final boolean f1168a = true;

    /* renamed from: e */
    public static final long f1169e = 10000;

    /* renamed from: f */
    public static final long f1170f = 1000;

    /* renamed from: g */
    protected int f1174g = Integer.MAX_VALUE;

    /* renamed from: h */
    protected long f1175h = 1800000;

    /* renamed from: i */
    LinkedHashMap<String, C0521a<C>> f1176i = new LinkedHashMap<>(32, 0.75f, true);

    /* renamed from: j */
    LinkedHashMap<String, C0521a<C>> f1177j = new LinkedHashMap<>(16, 0.75f, true);

    /* renamed from: k */
    long f1178k = 0;

    /* renamed from: b */
    private AbstractC0522b<C> f1171b = new AbstractC0522b<C>() { // from class: b.a.a.b.o.a.1
        @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a.AbstractC0522b
        /* renamed from: a */
        public boolean mo20252a(C0521a<C> c0521a, long j) {
            return AbstractC0517a.this.f1176i.size() > AbstractC0517a.this.f1174g;
        }
    };

    /* renamed from: c */
    private AbstractC0522b<C> f1172c = new AbstractC0522b<C>() { // from class: b.a.a.b.o.a.2
        @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a.AbstractC0522b
        /* renamed from: a */
        public boolean mo20252a(C0521a<C> c0521a, long j) {
            return AbstractC0517a.this.m20266a(c0521a, j);
        }
    };

    /* renamed from: d */
    private AbstractC0522b<C> f1173d = new AbstractC0522b<C>() { // from class: b.a.a.b.o.a.3
        @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a.AbstractC0522b
        /* renamed from: a */
        public boolean mo20252a(C0521a<C> c0521a, long j) {
            return AbstractC0517a.this.m20261b(c0521a, j);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b.a.a.b.o.a$a */
    /* loaded from: classes.dex */
    public static class C0521a<C> {

        /* renamed from: a */
        String f1182a;

        /* renamed from: b */
        C f1183b;

        /* renamed from: c */
        long f1184c;

        C0521a(String str, C c, long j) {
            this.f1182a = str;
            this.f1183b = c;
            this.f1184c = j;
        }

        /* renamed from: a */
        public void m20253a(long j) {
            this.f1184c = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                C0521a c0521a = (C0521a) obj;
                if (this.f1182a == null) {
                    if (c0521a.f1182a != null) {
                        return false;
                    }
                } else if (!this.f1182a.equals(c0521a.f1182a)) {
                    return false;
                }
                return this.f1183b == null ? c0521a.f1183b == null : this.f1183b.equals(c0521a.f1183b);
            }
            return false;
        }

        public int hashCode() {
            return this.f1182a.hashCode();
        }

        public String toString() {
            return "(" + this.f1182a + ", " + this.f1183b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b.a.a.b.o.a$b */
    /* loaded from: classes.dex */
    public interface AbstractC0522b<C> {
        /* renamed from: a */
        boolean mo20252a(C0521a<C> c0521a, long j);
    }

    /* renamed from: a */
    private C0521a<C> m20264a(String str) {
        C0521a<C> c0521a = this.f1176i.get(str);
        return c0521a != null ? c0521a : this.f1177j.get(str);
    }

    /* renamed from: a */
    private void m20263a(LinkedHashMap<String, C0521a<C>> linkedHashMap, long j, AbstractC0522b<C> abstractC0522b) {
        Iterator<Map.Entry<String, C0521a<C>>> it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            C0521a<C> value = it2.next().getValue();
            if (!abstractC0522b.mo20252a(value, j)) {
                return;
            }
            it2.remove();
            mo20218b((AbstractC0517a<C>) value.f1183b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20266a(C0521a<C> c0521a, long j) {
        return mo20222a((AbstractC0517a<C>) c0521a.f1183b) || c0521a.f1184c + this.f1175h < j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m20261b(C0521a c0521a, long j) {
        return c0521a.f1184c + f1169e < j;
    }

    /* renamed from: c */
    private void m20259c(long j) {
        m20263a(this.f1176i, j, this.f1172c);
    }

    /* renamed from: d */
    private void m20257d(long j) {
        m20263a(this.f1177j, j, this.f1173d);
    }

    /* renamed from: e */
    private boolean m20255e(long j) {
        if (this.f1178k + 1000 > j) {
            return true;
        }
        this.f1178k = j;
        return false;
    }

    /* renamed from: f */
    private void m20254f() {
        m20263a(this.f1176i, 0L, this.f1171b);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0525d
    /* renamed from: a */
    public int mo20243a() {
        return this.f1176i.size() + this.f1177j.size();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0525d
    /* renamed from: a */
    public synchronized C mo20241a(String str, long j) {
        C0521a<C> m20264a;
        m20264a = m20264a(str);
        if (m20264a == null) {
            m20264a = new C0521a<>(str, mo20217b(str), j);
            this.f1176i.put(str, m20264a);
        } else {
            m20264a.m20253a(j);
        }
        return m20264a.f1183b;
    }

    /* renamed from: a */
    public void m20267a(int i) {
        this.f1174g = i;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0525d
    /* renamed from: a */
    public synchronized void mo20242a(long j) {
        if (!m20255e(j)) {
            m20254f();
            m20259c(j);
            m20257d(j);
        }
    }

    /* renamed from: a */
    protected abstract boolean mo20222a(C c);

    /* renamed from: b */
    protected abstract C mo20217b(String str);

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0525d
    /* renamed from: b */
    public Set<String> mo20240b() {
        HashSet hashSet = new HashSet(this.f1176i.keySet());
        hashSet.addAll(this.f1177j.keySet());
        return hashSet;
    }

    /* renamed from: b */
    public void m20262b(long j) {
        this.f1175h = j;
    }

    /* renamed from: b */
    protected abstract void mo20218b(C c);

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0525d
    /* renamed from: c */
    public synchronized C mo20238c(String str) {
        C0521a<C> m20264a;
        m20264a = m20264a(str);
        return m20264a == null ? null : m20264a.f1183b;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0525d
    /* renamed from: c */
    public Collection<C> mo20239c() {
        ArrayList arrayList = new ArrayList();
        for (C0521a<C> c0521a : this.f1176i.values()) {
            arrayList.add(c0521a.f1183b);
        }
        for (C0521a<C> c0521a2 : this.f1177j.values()) {
            arrayList.add(c0521a2.f1183b);
        }
        return arrayList;
    }

    /* renamed from: d */
    public long m20258d() {
        return this.f1175h;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0525d
    /* renamed from: d */
    public void mo20237d(String str) {
        C0521a<C> remove = this.f1176i.remove(str);
        if (remove == null) {
            return;
        }
        this.f1177j.put(str, remove);
    }

    /* renamed from: e */
    public int m20256e() {
        return this.f1174g;
    }
}
