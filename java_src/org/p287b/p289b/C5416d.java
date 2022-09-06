package org.p287b.p289b;

import java.util.Iterator;
import org.p287b.AbstractC5432m;
/* renamed from: org.b.b.d */
/* loaded from: classes2.dex */
public class C5416d<T> implements Iterator<AbstractC5432m> {

    /* renamed from: a */
    private Iterator<T> f22493a;

    public C5416d(Iterator<T> it2) {
        this.f22493a = it2;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public AbstractC5432m next() {
        return new C5415c(this.f22493a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22493a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f22493a.remove();
    }
}
