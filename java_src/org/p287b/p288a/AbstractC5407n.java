package org.p287b.p288a;

import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.n */
/* loaded from: classes2.dex */
abstract class AbstractC5407n<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private final Iterable<AbstractC5430k<? super T>> f22485a;

    public AbstractC5407n(Iterable<AbstractC5430k<? super T>> iterable) {
        this.f22485a = iterable;
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public abstract void mo905a(AbstractC5425g abstractC5425g);

    /* renamed from: a */
    public void mo1148a(AbstractC5425g abstractC5425g, String str) {
        abstractC5425g.mo1082b("(", " " + str + " ", ")", this.f22485a);
    }

    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public abstract boolean mo900a(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m1149a(Object obj, boolean z) {
        for (AbstractC5430k<? super T> abstractC5430k : this.f22485a) {
            if (abstractC5430k.mo900a(obj) == z) {
                return z;
            }
        }
        return !z;
    }
}
