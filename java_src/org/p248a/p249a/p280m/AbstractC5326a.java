package org.p248a.p249a.p280m;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p259d.AbstractC5082c;
import org.p248a.p249a.p280m.AbstractC5334e;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
@AbstractC5007d
/* renamed from: org.a.a.m.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5326a<T, C, E extends AbstractC5334e<T, C>> implements AbstractC5332c<T, E>, AbstractC5333d<T> {

    /* renamed from: b */
    private final AbstractC5331b<T, C> f22339b;

    /* renamed from: h */
    private volatile boolean f22345h;

    /* renamed from: i */
    private volatile int f22346i;

    /* renamed from: j */
    private volatile int f22347j;

    /* renamed from: a */
    private final Lock f22338a = new ReentrantLock();

    /* renamed from: c */
    private final Map<T, AbstractC5338i<T, C, E>> f22340c = new HashMap();

    /* renamed from: d */
    private final Set<E> f22341d = new HashSet();

    /* renamed from: e */
    private final LinkedList<E> f22342e = new LinkedList<>();

    /* renamed from: f */
    private final LinkedList<AbstractFutureC5336g<E>> f22343f = new LinkedList<>();

    /* renamed from: g */
    private final Map<T, Integer> f22344g = new HashMap();

    public AbstractC5326a(AbstractC5331b<T, C> abstractC5331b, int i, int i2) {
        this.f22339b = (AbstractC5331b) C5351a.m1321a(abstractC5331b, "Connection factory");
        this.f22346i = C5351a.m1317b(i, "Max per route value");
        this.f22347j = C5351a.m1317b(i2, "Max total value");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public E m1421a(T t, Object obj, long j, TimeUnit timeUnit, AbstractFutureC5336g<E> abstractFutureC5336g) {
        Date date = null;
        if (j > 0) {
            date = new Date(System.currentTimeMillis() + timeUnit.toMillis(j));
        }
        this.f22338a.lock();
        try {
            AbstractC5338i m1412c = m1412c(t);
            E e = null;
            while (e == null) {
                C5352b.m1312a(!this.f22345h, "Connection pool shut down");
                while (true) {
                    e = (E) m1412c.m1369b(obj);
                    if (e != null && (e.mo1393e() || e.mo1396a(System.currentTimeMillis()))) {
                        e.mo1392f();
                        this.f22342e.remove(e);
                        m1412c.m1372a(e, false);
                    }
                }
                if (e != null) {
                    this.f22342e.remove(e);
                    this.f22341d.add(e);
                    return e;
                }
                int m1411d = m1411d(t);
                int max = Math.max(0, (m1412c.m1364e() + 1) - m1411d);
                if (max > 0) {
                    for (int i = 0; i < max; i++) {
                        AbstractC5334e m1363f = m1412c.m1363f();
                        if (m1363f == null) {
                            break;
                        }
                        m1363f.mo1392f();
                        this.f22342e.remove(m1363f);
                        m1412c.m1373a((AbstractC5338i) m1363f);
                    }
                }
                if (m1412c.m1364e() < m1411d) {
                    int max2 = Math.max(this.f22347j - this.f22341d.size(), 0);
                    if (max2 > 0) {
                        if (this.f22342e.size() > max2 - 1 && !this.f22342e.isEmpty()) {
                            E removeLast = this.f22342e.removeLast();
                            removeLast.mo1392f();
                            m1412c(removeLast.m1390h()).m1373a((AbstractC5338i) removeLast);
                        }
                        E e2 = (E) m1412c.m1366c(this.f22339b.mo1407a(t));
                        this.f22341d.add(e2);
                        return e2;
                    }
                }
                m1412c.m1371a((AbstractFutureC5336g) abstractFutureC5336g);
                this.f22343f.add(abstractFutureC5336g);
                boolean m1381a = abstractFutureC5336g.m1381a(date);
                m1412c.m1368b((AbstractFutureC5336g) abstractFutureC5336g);
                this.f22343f.remove(abstractFutureC5336g);
                if (!m1381a && date != null && date.getTime() <= System.currentTimeMillis()) {
                    break;
                }
            }
            throw new TimeoutException("Timeout waiting for connection");
        } finally {
            this.f22338a.unlock();
        }
    }

    /* renamed from: c */
    private AbstractC5338i<T, C, E> m1412c(final T t) {
        AbstractC5338i<T, C, E> abstractC5338i = this.f22340c.get(t);
        if (abstractC5338i == null) {
            AbstractC5338i<T, C, E> abstractC5338i2 = (AbstractC5338i<T, C, E>) new AbstractC5338i<T, C, E>(t) { // from class: org.a.a.m.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // org.p248a.p249a.p280m.AbstractC5338i
                /* renamed from: a */
                protected E mo1374a(C c) {
                    return (E) AbstractC5326a.this.mo1422a((AbstractC5326a) t, (Object) c);
                }
            };
            this.f22340c.put(t, abstractC5338i2);
            return abstractC5338i2;
        }
        return abstractC5338i;
    }

    /* renamed from: d */
    private int m1411d(T t) {
        Integer num = this.f22344g.get(t);
        return num != null ? num.intValue() : this.f22346i;
    }

    /* renamed from: g */
    private void m1409g() {
        Iterator<Map.Entry<T, AbstractC5338i<T, C, E>>> it2 = this.f22340c.entrySet().iterator();
        while (it2.hasNext()) {
            AbstractC5338i<T, C, E> value = it2.next().getValue();
            if (value.m1364e() + value.m1367c() == 0) {
                it2.remove();
            }
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5332c
    /* renamed from: a */
    public Future<E> mo1406a(final T t, final Object obj, AbstractC5082c<E> abstractC5082c) {
        C5351a.m1321a(t, "Route");
        C5352b.m1312a(!this.f22345h, "Connection pool shut down");
        return new AbstractFutureC5336g<E>(this.f22338a, abstractC5082c) { // from class: org.a.a.m.a.2
            @Override // org.p248a.p249a.p280m.AbstractFutureC5336g
            /* renamed from: a */
            public E mo1380b(long j, TimeUnit timeUnit) {
                E e = (E) AbstractC5326a.this.m1421a(t, obj, j, timeUnit, this);
                AbstractC5326a.this.m1419a((AbstractC5326a) e);
                return e;
            }
        };
    }

    /* renamed from: a */
    protected abstract E mo1422a(T t, C c);

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: a */
    public C5337h mo1403a(T t) {
        C5351a.m1321a(t, "Route");
        this.f22338a.lock();
        try {
            AbstractC5338i<T, C, E> m1412c = m1412c(t);
            return new C5337h(m1412c.m1370b(), m1412c.m1367c(), m1412c.m1365d(), m1411d(t));
        } finally {
            this.f22338a.unlock();
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: a */
    public void mo1404a(int i) {
        C5351a.m1317b(i, "Max value");
        this.f22338a.lock();
        try {
            this.f22347j = i;
        } finally {
            this.f22338a.unlock();
        }
    }

    /* renamed from: a */
    public void m1423a(long j, TimeUnit timeUnit) {
        long j2 = 0;
        C5351a.m1321a(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        if (millis >= 0) {
            j2 = millis;
        }
        final long currentTimeMillis = System.currentTimeMillis() - j2;
        m1417a((AbstractC5335f) new AbstractC5335f<T, C>() { // from class: org.a.a.m.a.3
            @Override // org.p248a.p249a.p280m.AbstractC5335f
            /* renamed from: a */
            public void mo1383a(AbstractC5334e<T, C> abstractC5334e) {
                if (abstractC5334e.m1385m() <= currentTimeMillis) {
                    abstractC5334e.mo1392f();
                }
            }
        });
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: a */
    public void mo1402a(T t, int i) {
        C5351a.m1321a(t, "Route");
        C5351a.m1317b(i, "Max per route value");
        this.f22338a.lock();
        try {
            this.f22344g.put(t, Integer.valueOf(i));
        } finally {
            this.f22338a.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p248a.p249a.p280m.AbstractC5332c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1405a(Object obj, boolean z) {
        m1418a((AbstractC5326a<T, C, E>) ((AbstractC5334e) obj), z);
    }

    /* renamed from: a */
    protected void m1419a(E e) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m1418a(E e, boolean z) {
        this.f22338a.lock();
        try {
            if (this.f22341d.remove(e)) {
                AbstractC5338i m1412c = m1412c(e.m1390h());
                m1412c.m1372a(e, z);
                if (!z || this.f22345h) {
                    e.mo1392f();
                } else {
                    this.f22342e.addFirst(e);
                    m1414b((AbstractC5326a<T, C, E>) e);
                }
                AbstractFutureC5336g<E> m1362g = m1412c.m1362g();
                if (m1362g != null) {
                    this.f22343f.remove(m1362g);
                } else {
                    m1362g = this.f22343f.poll();
                }
                if (m1362g != null) {
                    m1362g.m1382a();
                }
            }
        } finally {
            this.f22338a.unlock();
        }
    }

    /* renamed from: a */
    protected void m1417a(AbstractC5335f<T, C> abstractC5335f) {
        this.f22338a.lock();
        try {
            Iterator<E> it2 = this.f22342e.iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                abstractC5335f.mo1383a(next);
                if (next.mo1393e()) {
                    m1412c(next.m1390h()).m1373a((AbstractC5338i<T, C, E>) next);
                    it2.remove();
                }
            }
            m1409g();
        } finally {
            this.f22338a.unlock();
        }
    }

    /* renamed from: a */
    public boolean m1424a() {
        return this.f22345h;
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: b */
    public int mo1400b(T t) {
        C5351a.m1321a(t, "Route");
        this.f22338a.lock();
        try {
            return m1411d(t);
        } finally {
            this.f22338a.unlock();
        }
    }

    /* renamed from: b */
    public Future<E> m1415b(T t, Object obj) {
        return mo1406a(t, obj, null);
    }

    /* renamed from: b */
    public void m1416b() {
        if (this.f22345h) {
            return;
        }
        this.f22345h = true;
        this.f22338a.lock();
        try {
            Iterator<E> it2 = this.f22342e.iterator();
            while (it2.hasNext()) {
                it2.next().mo1392f();
            }
            for (E e : this.f22341d) {
                e.mo1392f();
            }
            for (AbstractC5338i<T, C, E> abstractC5338i : this.f22340c.values()) {
                abstractC5338i.m1361h();
            }
            this.f22340c.clear();
            this.f22341d.clear();
            this.f22342e.clear();
        } finally {
            this.f22338a.unlock();
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: b */
    public void mo1401b(int i) {
        C5351a.m1317b(i, "Max per route value");
        this.f22338a.lock();
        try {
            this.f22346i = i;
        } finally {
            this.f22338a.unlock();
        }
    }

    /* renamed from: b */
    protected void m1414b(E e) {
    }

    /* renamed from: b */
    protected void m1413b(AbstractC5335f<T, C> abstractC5335f) {
        this.f22338a.lock();
        try {
            for (E e : this.f22341d) {
                abstractC5335f.mo1383a(e);
            }
        } finally {
            this.f22338a.unlock();
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: c */
    public int mo1399c() {
        this.f22338a.lock();
        try {
            return this.f22347j;
        } finally {
            this.f22338a.unlock();
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: d */
    public int mo1398d() {
        this.f22338a.lock();
        try {
            return this.f22346i;
        } finally {
            this.f22338a.unlock();
        }
    }

    @Override // org.p248a.p249a.p280m.AbstractC5333d
    /* renamed from: e */
    public C5337h mo1397e() {
        this.f22338a.lock();
        try {
            return new C5337h(this.f22341d.size(), this.f22343f.size(), this.f22342e.size(), this.f22347j);
        } finally {
            this.f22338a.unlock();
        }
    }

    /* renamed from: f */
    public void m1410f() {
        final long currentTimeMillis = System.currentTimeMillis();
        m1417a((AbstractC5335f) new AbstractC5335f<T, C>() { // from class: org.a.a.m.a.4
            @Override // org.p248a.p249a.p280m.AbstractC5335f
            /* renamed from: a */
            public void mo1383a(AbstractC5334e<T, C> abstractC5334e) {
                if (abstractC5334e.mo1396a(currentTimeMillis)) {
                    abstractC5334e.mo1392f();
                }
            }
        });
    }

    public String toString() {
        return "[leased: " + this.f22341d + "][available: " + this.f22342e + "][pending: " + this.f22343f + "]";
    }
}
