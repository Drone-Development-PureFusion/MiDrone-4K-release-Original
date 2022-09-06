package org.p248a.p249a.p281n;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.n.b */
/* loaded from: classes2.dex */
final class C5340b<E> {

    /* renamed from: a */
    private final LinkedList<E> f22381a = new LinkedList<>();

    /* renamed from: b */
    private final Map<Class<?>, E> f22382b = new HashMap();

    /* renamed from: c */
    private void m1352c(E e) {
        E remove = this.f22382b.remove(e.getClass());
        if (remove != null) {
            this.f22381a.remove(remove);
        }
        this.f22382b.put(e.getClass(), e);
    }

    /* renamed from: a */
    public LinkedList<E> m1359a() {
        return new LinkedList<>(this.f22381a);
    }

    /* renamed from: a */
    public C5340b<E> m1358a(E e) {
        if (e != null) {
            m1352c(e);
            this.f22381a.addFirst(e);
        }
        return this;
    }

    /* renamed from: a */
    public C5340b<E> m1357a(Collection<E> collection) {
        if (collection != null) {
            for (E e : collection) {
                m1358a((C5340b<E>) e);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C5340b<E> m1356a(E... eArr) {
        if (eArr != null) {
            for (E e : eArr) {
                m1358a((C5340b<E>) e);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C5340b<E> m1355b(E e) {
        if (e != null) {
            m1352c(e);
            this.f22381a.addLast(e);
        }
        return this;
    }

    /* renamed from: b */
    public C5340b<E> m1354b(Collection<E> collection) {
        if (collection != null) {
            for (E e : collection) {
                m1355b((C5340b<E>) e);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C5340b<E> m1353b(E... eArr) {
        if (eArr != null) {
            for (E e : eArr) {
                m1355b((C5340b<E>) e);
            }
        }
        return this;
    }
}
