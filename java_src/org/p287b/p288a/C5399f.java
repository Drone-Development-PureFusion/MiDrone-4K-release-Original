package org.p287b.p288a;

import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
/* renamed from: org.b.a.f */
/* loaded from: classes.dex */
public class C5399f<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private final AbstractC5430k<T> f22477a;

    public C5399f(AbstractC5430k<T> abstractC5430k) {
        this.f22477a = abstractC5430k;
    }

    @AbstractC5428i
    @Deprecated
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1177a(Class<T> cls) {
        return m1176a(C5403j.m1160a((Class<?>) cls));
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1176a(AbstractC5430k<T> abstractC5430k) {
        return new C5399f(abstractC5430k);
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T> AbstractC5430k<T> m1175b(Class<T> cls) {
        return m1176a(C5403j.m1160a((Class<?>) cls));
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T> AbstractC5430k<T> m1174b(T t) {
        return m1176a(C5402i.m1165b(t));
    }

    @Override // org.p287b.AbstractC5412b, org.p287b.AbstractC5430k
    /* renamed from: a */
    public void mo1070a(Object obj, AbstractC5425g abstractC5425g) {
        this.f22477a.mo1070a(obj, abstractC5425g);
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("is ").mo1083a((AbstractC5432m) this.f22477a);
    }

    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public boolean mo900a(Object obj) {
        return this.f22477a.mo900a(obj);
    }
}
