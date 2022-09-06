package org.p287b.p288a;

import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.l */
/* loaded from: classes.dex */
public class C5405l<T> extends AbstractC5412b<T> {
    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1155a(Class<T> cls) {
        return new C5405l();
    }

    @AbstractC5428i
    /* renamed from: b */
    public static AbstractC5430k<Object> m1154b() {
        return new C5405l();
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T> AbstractC5430k<T> m1153b(Class<T> cls) {
        return C5404k.m1157a(m1155a((Class) cls));
    }

    @AbstractC5428i
    /* renamed from: c */
    public static AbstractC5430k<Object> m1152c() {
        return C5404k.m1157a((AbstractC5430k) m1154b());
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("null");
    }

    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public boolean mo900a(Object obj) {
        return obj == null;
    }
}
