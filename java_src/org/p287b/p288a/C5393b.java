package org.p287b.p288a;

import java.util.ArrayList;
import java.util.Arrays;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.b */
/* loaded from: classes.dex */
public class C5393b<T> extends AbstractC5407n<T> {
    public C5393b(Iterable<AbstractC5430k<? super T>> iterable) {
        super(iterable);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> C5393b<T> m1194a(Iterable<AbstractC5430k<? super T>> iterable) {
        return new C5393b<>(iterable);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> C5393b<T> m1193a(AbstractC5430k<T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        return m1194a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> C5393b<T> m1192a(AbstractC5430k<T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        return m1194a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> C5393b<T> m1191a(AbstractC5430k<T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3, AbstractC5430k<? super T> abstractC5430k4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        arrayList.add(abstractC5430k4);
        return m1194a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> C5393b<T> m1190a(AbstractC5430k<T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3, AbstractC5430k<? super T> abstractC5430k4, AbstractC5430k<? super T> abstractC5430k5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        arrayList.add(abstractC5430k4);
        arrayList.add(abstractC5430k5);
        return m1194a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> C5393b<T> m1189a(AbstractC5430k<T> abstractC5430k, AbstractC5430k<? super T> abstractC5430k2, AbstractC5430k<? super T> abstractC5430k3, AbstractC5430k<? super T> abstractC5430k4, AbstractC5430k<? super T> abstractC5430k5, AbstractC5430k<? super T> abstractC5430k6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC5430k);
        arrayList.add(abstractC5430k2);
        arrayList.add(abstractC5430k3);
        arrayList.add(abstractC5430k4);
        arrayList.add(abstractC5430k5);
        arrayList.add(abstractC5430k6);
        return m1194a((Iterable) arrayList);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> C5393b<T> m1188a(AbstractC5430k<? super T>... abstractC5430kArr) {
        return m1194a((Iterable) Arrays.asList(abstractC5430kArr));
    }

    @Override // org.p287b.p288a.AbstractC5407n, org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        mo1148a(abstractC5425g, "or");
    }

    @Override // org.p287b.p288a.AbstractC5407n
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1148a(AbstractC5425g abstractC5425g, String str) {
        super.mo1148a(abstractC5425g, str);
    }

    @Override // org.p287b.p288a.AbstractC5407n, org.p287b.AbstractC5430k
    /* renamed from: a */
    public boolean mo900a(Object obj) {
        return a(obj, true);
    }
}
