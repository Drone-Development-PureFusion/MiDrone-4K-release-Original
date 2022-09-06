package org.p287b.p288a;

import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
import org.p287b.AbstractC5434o;
/* renamed from: org.b.a.e */
/* loaded from: classes.dex */
public class C5398e<T> extends AbstractC5434o<Iterable<T>> {

    /* renamed from: a */
    private final AbstractC5430k<? super T> f22476a;

    public C5398e(AbstractC5430k<? super T> abstractC5430k) {
        this.f22476a = abstractC5430k;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <U> AbstractC5430k<Iterable<U>> m1178a(AbstractC5430k<U> abstractC5430k) {
        return new C5398e(abstractC5430k);
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("every item is ").mo1083a((AbstractC5432m) this.f22476a);
    }

    /* renamed from: a */
    public boolean m1179a(Iterable<T> iterable, AbstractC5425g abstractC5425g) {
        for (T t : iterable) {
            if (!this.f22476a.mo900a(t)) {
                abstractC5425g.mo1086a("an item ");
                this.f22476a.mo1070a(t, abstractC5425g);
                return false;
            }
        }
        return true;
    }

    @Override // org.p287b.AbstractC5434o
    /* renamed from: b */
    public /* synthetic */ boolean mo1071b(Object obj, AbstractC5425g abstractC5425g) {
        return m1179a((Iterable) ((Iterable) obj), abstractC5425g);
    }
}
