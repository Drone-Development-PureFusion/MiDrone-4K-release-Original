package com.p113c.p115b;
/* renamed from: com.c.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC1828b<T> extends AbstractC1830d<T, Integer> {
    public AbstractC1828b(String str) {
        super(Integer.class, str);
    }

    /* renamed from: a */
    public abstract void mo14464a(T t, int i);

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void m14463a(T t, Integer num) {
        m14463a((AbstractC1828b<T>) t, Integer.valueOf(num.intValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p113c.p115b.AbstractC1830d
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo14456a(Object obj, Integer num) {
        m14463a((AbstractC1828b<T>) obj, num);
    }
}
