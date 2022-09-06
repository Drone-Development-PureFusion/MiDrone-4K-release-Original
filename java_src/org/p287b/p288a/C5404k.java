package org.p287b.p288a;

import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
/* renamed from: org.b.a.k */
/* loaded from: classes.dex */
public class C5404k<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private final AbstractC5430k<T> f22483a;

    public C5404k(AbstractC5430k<T> abstractC5430k) {
        this.f22483a = abstractC5430k;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1157a(AbstractC5430k<T> abstractC5430k) {
        return new C5404k(abstractC5430k);
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T> AbstractC5430k<T> m1156b(T t) {
        return m1157a(C5402i.m1165b(t));
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("not ").mo1083a((AbstractC5432m) this.f22483a);
    }

    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public boolean mo900a(Object obj) {
        return !this.f22483a.mo900a(obj);
    }
}
