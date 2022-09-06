package org.p287b;
/* renamed from: org.b.c */
/* loaded from: classes2.dex */
public abstract class AbstractC5417c<T> {

    /* renamed from: a */
    public static final C5420b<Object> f22494a = new C5420b<>();

    /* renamed from: org.b.c$a */
    /* loaded from: classes2.dex */
    private static final class C5419a<T> extends AbstractC5417c<T> {

        /* renamed from: b */
        private final T f22495b;

        /* renamed from: c */
        private final AbstractC5425g f22496c;

        private C5419a(T t, AbstractC5425g abstractC5425g) {
            super();
            this.f22495b = t;
            this.f22496c = abstractC5425g;
        }

        @Override // org.p287b.AbstractC5417c
        /* renamed from: a */
        public <U> AbstractC5417c<U> mo1132a(AbstractC5421c<? super T, U> abstractC5421c) {
            return abstractC5421c.m1130a((T) this.f22495b, this.f22496c);
        }

        @Override // org.p287b.AbstractC5417c
        /* renamed from: a */
        public boolean mo1131a(AbstractC5430k<T> abstractC5430k, String str) {
            if (abstractC5430k.mo900a(this.f22495b)) {
                return true;
            }
            this.f22496c.mo1086a(str);
            abstractC5430k.mo1070a(this.f22495b, this.f22496c);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.b.c$b */
    /* loaded from: classes2.dex */
    public static final class C5420b<T> extends AbstractC5417c<T> {
        private C5420b() {
            super();
        }

        @Override // org.p287b.AbstractC5417c
        /* renamed from: a */
        public <U> AbstractC5417c<U> mo1132a(AbstractC5421c<? super T, U> abstractC5421c) {
            return a();
        }

        @Override // org.p287b.AbstractC5417c
        /* renamed from: a */
        public boolean mo1131a(AbstractC5430k<T> abstractC5430k, String str) {
            return false;
        }
    }

    /* renamed from: org.b.c$c */
    /* loaded from: classes2.dex */
    public interface AbstractC5421c<I, O> {
        /* renamed from: a */
        AbstractC5417c<O> m1130a(I i, AbstractC5425g abstractC5425g);
    }

    private AbstractC5417c() {
    }

    /* renamed from: a */
    public static <T> AbstractC5417c<T> m1136a() {
        return f22494a;
    }

    /* renamed from: a */
    public static <T> AbstractC5417c<T> m1135a(T t, AbstractC5425g abstractC5425g) {
        return new C5419a(t, abstractC5425g);
    }

    /* renamed from: a */
    public abstract <U> AbstractC5417c<U> mo1132a(AbstractC5421c<? super T, U> abstractC5421c);

    /* renamed from: a */
    public final boolean m1134a(AbstractC5430k<T> abstractC5430k) {
        return mo1131a(abstractC5430k, "");
    }

    /* renamed from: a */
    public abstract boolean mo1131a(AbstractC5430k<T> abstractC5430k, String str);

    /* renamed from: b */
    public final <U> AbstractC5417c<U> m1133b(AbstractC5421c<? super T, U> abstractC5421c) {
        return mo1132a(abstractC5421c);
    }
}
