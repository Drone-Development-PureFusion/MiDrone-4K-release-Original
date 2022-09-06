package org.p287b.p288a;

import java.util.ArrayList;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
import org.p287b.AbstractC5434o;
/* renamed from: org.b.a.h */
/* loaded from: classes.dex */
public class C5401h<T> extends AbstractC5434o<Iterable<? super T>> {

    /* renamed from: a */
    private final AbstractC5430k<? super T> f22479a;

    public C5401h(AbstractC5430k<? super T> abstractC5430k) {
        this.f22479a = abstractC5430k;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<Iterable<? super T>> m1170a(AbstractC5430k<? super T> abstractC5430k) {
        return new C5401h(abstractC5430k);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<Iterable<T>> m1169a(T... tArr) {
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(m1167b(t));
        }
        return C5392a.m1201a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<Iterable<T>> m1168a(AbstractC5430k<? super T>... abstractC5430kArr) {
        ArrayList arrayList = new ArrayList(abstractC5430kArr.length);
        for (AbstractC5430k<? super T> abstractC5430k : abstractC5430kArr) {
            arrayList.add(new C5401h(abstractC5430k));
        }
        return C5392a.m1201a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T> AbstractC5430k<Iterable<? super T>> m1167b(T t) {
        return new C5401h(C5402i.m1165b(t));
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("a collection containing ").mo1083a((AbstractC5432m) this.f22479a);
    }

    /* renamed from: a */
    protected boolean m1171a(Iterable<? super T> iterable, AbstractC5425g abstractC5425g) {
        boolean z = false;
        for (T t : iterable) {
            if (this.f22479a.mo900a(t)) {
                return true;
            }
            if (z) {
                abstractC5425g.mo1086a(", ");
            }
            this.f22479a.mo1070a(t, abstractC5425g);
            z = true;
        }
        return false;
    }

    @Override // org.p287b.AbstractC5434o
    /* renamed from: b */
    protected /* synthetic */ boolean mo1071b(Object obj, AbstractC5425g abstractC5425g) {
        return m1171a((Iterable) ((Iterable) obj), abstractC5425g);
    }
}
