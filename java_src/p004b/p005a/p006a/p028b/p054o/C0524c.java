package p004b.p005a.p006a.p028b.p054o;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p004b.p005a.p006a.p028b.AbstractC0266a;
/* renamed from: b.a.a.b.o.c */
/* loaded from: classes.dex */
public class C0524c<E> implements AbstractC0523b<E> {

    /* renamed from: a */
    static final long f1185a = System.currentTimeMillis();

    /* renamed from: b */
    private final CopyOnWriteArrayList<AbstractC0266a<E>> f1186b = new CopyOnWriteArrayList<>();

    /* renamed from: a */
    public int m20250a(E e) {
        int i = 0;
        Iterator<AbstractC0266a<E>> it2 = this.f1186b.iterator();
        while (true) {
            int i2 = i;
            if (it2.hasNext()) {
                it2.next().mo20162d((AbstractC0266a<E>) e);
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: a */
    public void mo20251a(AbstractC0266a<E> abstractC0266a) {
        if (abstractC0266a == null) {
            throw new IllegalArgumentException("Null argument disallowed");
        }
        this.f1186b.addIfAbsent(abstractC0266a);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: a_ */
    public AbstractC0266a<E> mo20249a_(String str) {
        if (str == null) {
            return null;
        }
        Iterator<AbstractC0266a<E>> it2 = this.f1186b.iterator();
        while (it2.hasNext()) {
            AbstractC0266a<E> next = it2.next();
            if (str.equals(next.mo20159g())) {
                return next;
            }
        }
        return null;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: b */
    public boolean mo20248b(AbstractC0266a<E> abstractC0266a) {
        if (abstractC0266a == null) {
            return false;
        }
        Iterator<AbstractC0266a<E>> it2 = this.f1186b.iterator();
        while (it2.hasNext()) {
            if (it2.next() == abstractC0266a) {
                return true;
            }
        }
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: b */
    public boolean mo20247b(String str) {
        boolean z;
        if (str == null) {
            return false;
        }
        Iterator<AbstractC0266a<E>> it2 = this.f1186b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            AbstractC0266a<E> next = it2.next();
            if (str.equals(next.mo20159g())) {
                z = this.f1186b.remove(next);
                break;
            }
        }
        return z;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: c */
    public boolean mo20246c(AbstractC0266a<E> abstractC0266a) {
        if (abstractC0266a == null) {
            return false;
        }
        return this.f1186b.remove(abstractC0266a);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: e */
    public void mo20245e() {
        Iterator<AbstractC0266a<E>> it2 = this.f1186b.iterator();
        while (it2.hasNext()) {
            it2.next().k();
        }
        this.f1186b.clear();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: f */
    public Iterator<AbstractC0266a<E>> mo20244f() {
        return this.f1186b.iterator();
    }
}
