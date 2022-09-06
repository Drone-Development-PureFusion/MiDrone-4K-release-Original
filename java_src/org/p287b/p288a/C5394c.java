package org.p287b.p288a;

import java.util.ArrayList;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
import org.p287b.AbstractC5434o;
/* renamed from: org.b.a.c */
/* loaded from: classes.dex */
public class C5394c<T> extends AbstractC5434o<T> {

    /* renamed from: a */
    private final AbstractC5430k<? super T> f22469a;

    /* renamed from: org.b.a.c$a */
    /* loaded from: classes2.dex */
    public static final class C5395a<X> {

        /* renamed from: a */
        private final AbstractC5430k<? super X> f22470a;

        public C5395a(AbstractC5430k<? super X> abstractC5430k) {
            this.f22470a = abstractC5430k;
        }

        /* renamed from: a */
        public C5394c<X> m1182a(AbstractC5430k<? super X> abstractC5430k) {
            return new C5394c(this.f22470a).m1187a((AbstractC5430k) abstractC5430k);
        }
    }

    /* renamed from: org.b.a.c$b */
    /* loaded from: classes2.dex */
    public static final class C5396b<X> {

        /* renamed from: a */
        private final AbstractC5430k<? super X> f22471a;

        public C5396b(AbstractC5430k<? super X> abstractC5430k) {
            this.f22471a = abstractC5430k;
        }

        /* renamed from: a */
        public C5394c<X> m1181a(AbstractC5430k<? super X> abstractC5430k) {
            return new C5394c(this.f22471a).m1186b(abstractC5430k);
        }
    }

    public C5394c(AbstractC5430k<? super T> abstractC5430k) {
        this.f22469a = abstractC5430k;
    }

    @AbstractC5428i
    /* renamed from: c */
    public static <LHS> C5395a<LHS> m1185c(AbstractC5430k<? super LHS> abstractC5430k) {
        return new C5395a<>(abstractC5430k);
    }

    @AbstractC5428i
    /* renamed from: d */
    public static <LHS> C5396b<LHS> m1184d(AbstractC5430k<? super LHS> abstractC5430k) {
        return new C5396b<>(abstractC5430k);
    }

    /* renamed from: e */
    private ArrayList<AbstractC5430k<? super T>> m1183e(AbstractC5430k<? super T> abstractC5430k) {
        ArrayList<AbstractC5430k<? super T>> arrayList = new ArrayList<>();
        arrayList.add(this.f22469a);
        arrayList.add(abstractC5430k);
        return arrayList;
    }

    /* renamed from: a */
    public C5394c<T> m1187a(AbstractC5430k<? super T> abstractC5430k) {
        return new C5394c<>(new C5392a(m1183e(abstractC5430k)));
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1083a((AbstractC5432m) this.f22469a);
    }

    /* renamed from: b */
    public C5394c<T> m1186b(AbstractC5430k<? super T> abstractC5430k) {
        return new C5394c<>(new C5393b(m1183e(abstractC5430k)));
    }

    @Override // org.p287b.AbstractC5434o
    /* renamed from: b */
    protected boolean mo1071b(T t, AbstractC5425g abstractC5425g) {
        if (!this.f22469a.mo900a(t)) {
            this.f22469a.mo1070a(t, abstractC5425g);
            return false;
        }
        return true;
    }
}
