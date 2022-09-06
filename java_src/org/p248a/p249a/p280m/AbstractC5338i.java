package org.p248a.p249a.p280m;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p280m.AbstractC5334e;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
@AbstractC5006c
/* renamed from: org.a.a.m.i */
/* loaded from: classes2.dex */
abstract class AbstractC5338i<T, C, E extends AbstractC5334e<T, C>> {

    /* renamed from: a */
    private final T f22375a;

    /* renamed from: b */
    private final Set<E> f22376b = new HashSet();

    /* renamed from: c */
    private final LinkedList<E> f22377c = new LinkedList<>();

    /* renamed from: d */
    private final LinkedList<AbstractFutureC5336g<E>> f22378d = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5338i(T t) {
        this.f22375a = t;
    }

    /* renamed from: a */
    public final T m1375a() {
        return this.f22375a;
    }

    /* renamed from: a */
    protected abstract E mo1374a(C c);

    /* renamed from: a */
    public void m1372a(E e, boolean z) {
        C5351a.m1321a(e, "Pool entry");
        C5352b.m1311a(this.f22376b.remove(e), "Entry %s has not been leased from this pool", e);
        if (z) {
            this.f22377c.addFirst(e);
        }
    }

    /* renamed from: a */
    public void m1371a(AbstractFutureC5336g<E> abstractFutureC5336g) {
        if (abstractFutureC5336g == null) {
            return;
        }
        this.f22378d.add(abstractFutureC5336g);
    }

    /* renamed from: a */
    public boolean m1373a(E e) {
        C5351a.m1321a(e, "Pool entry");
        return this.f22377c.remove(e) || this.f22376b.remove(e);
    }

    /* renamed from: b */
    public int m1370b() {
        return this.f22376b.size();
    }

    /* renamed from: b */
    public E m1369b(Object obj) {
        if (!this.f22377c.isEmpty()) {
            if (obj != null) {
                Iterator<E> it2 = this.f22377c.iterator();
                while (it2.hasNext()) {
                    E next = it2.next();
                    if (obj.equals(next.m1386l())) {
                        it2.remove();
                        this.f22376b.add(next);
                        return next;
                    }
                }
            }
            Iterator<E> it3 = this.f22377c.iterator();
            while (it3.hasNext()) {
                E next2 = it3.next();
                if (next2.m1386l() == null) {
                    it3.remove();
                    this.f22376b.add(next2);
                    return next2;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public void m1368b(AbstractFutureC5336g<E> abstractFutureC5336g) {
        if (abstractFutureC5336g == null) {
            return;
        }
        this.f22378d.remove(abstractFutureC5336g);
    }

    /* renamed from: c */
    public int m1367c() {
        return this.f22378d.size();
    }

    /* renamed from: c */
    public E m1366c(C c) {
        E mo1374a = mo1374a((AbstractC5338i<T, C, E>) c);
        this.f22376b.add(mo1374a);
        return mo1374a;
    }

    /* renamed from: d */
    public int m1365d() {
        return this.f22377c.size();
    }

    /* renamed from: e */
    public int m1364e() {
        return this.f22377c.size() + this.f22376b.size();
    }

    /* renamed from: f */
    public E m1363f() {
        if (!this.f22377c.isEmpty()) {
            return this.f22377c.getLast();
        }
        return null;
    }

    /* renamed from: g */
    public AbstractFutureC5336g<E> m1362g() {
        return this.f22378d.poll();
    }

    /* renamed from: h */
    public void m1361h() {
        Iterator<AbstractFutureC5336g<E>> it2 = this.f22378d.iterator();
        while (it2.hasNext()) {
            it2.next().cancel(true);
        }
        this.f22378d.clear();
        Iterator<E> it3 = this.f22377c.iterator();
        while (it3.hasNext()) {
            it3.next().mo1392f();
        }
        this.f22377c.clear();
        for (E e : this.f22376b) {
            e.mo1392f();
        }
        this.f22376b.clear();
    }

    public String toString() {
        return "[route: " + this.f22375a + "][leased: " + this.f22376b.size() + "][available: " + this.f22377c.size() + "][pending: " + this.f22378d.size() + "]";
    }
}
