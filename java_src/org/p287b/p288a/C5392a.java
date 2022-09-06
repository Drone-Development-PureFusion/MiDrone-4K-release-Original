package org.p287b.p288a;

import java.util.ArrayList;
import java.util.Arrays;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5427h;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
/* renamed from: org.b.a.a */
/* loaded from: classes.dex */
public class C5392a<T> extends AbstractC5427h<T> {

    /* renamed from: a */
    private final Iterable<AbstractC5430k<? super T>> f22468a;

    public C5392a(Iterable<AbstractC5430k<? super T>> iterable) {
        this.f22468a = iterable;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1201a(Iterable<AbstractC5430k<? super T>> iterable) {
        return new C5392a(iterable);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1200a(AbstractC5430k<? super T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        return m1201a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1199a(AbstractC5430k<? super T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        return m1201a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1198a(AbstractC5430k<? super T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3, AbstractC5430k<? super T> abstractC5430k4) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        arrayList.add(abstractC5430k4);
        return m1201a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1197a(AbstractC5430k<? super T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3, AbstractC5430k<? super T> abstractC5430k4, AbstractC5430k<? super T> abstractC5430k5) {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        arrayList.add(abstractC5430k4);
        arrayList.add(abstractC5430k5);
        return m1201a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1196a(AbstractC5430k<? super T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3, AbstractC5430k<? super T> abstractC5430k4, AbstractC5430k<? super T> abstractC5430k5, AbstractC5430k<? super T> abstractC5430k6) {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        arrayList.add(abstractC5430k4);
        arrayList.add(abstractC5430k5);
        arrayList.add(abstractC5430k6);
        return m1201a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1195a(AbstractC5430k<? super T>... abstractC5430kArr) {
        return m1201a((Iterable) Arrays.asList(abstractC5430kArr));
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1082b("(", " and ", ")", this.f22468a);
    }

    @Override // org.p287b.AbstractC5427h
    /* renamed from: b */
    public boolean mo1081b(Object obj, AbstractC5425g abstractC5425g) {
        for (AbstractC5430k<? super T> abstractC5430k : this.f22468a) {
            if (!abstractC5430k.mo900a(obj)) {
                abstractC5425g.mo1083a((AbstractC5432m) abstractC5430k).mo1086a(" ");
                abstractC5430k.mo1070a(obj, abstractC5425g);
                return false;
            }
        }
        return true;
    }
}
