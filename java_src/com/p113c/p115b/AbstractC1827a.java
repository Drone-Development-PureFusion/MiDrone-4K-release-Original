package com.p113c.p115b;
/* renamed from: com.c.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1827a<T> extends AbstractC1830d<T, Float> {
    public AbstractC1827a(String str) {
        super(Float.class, str);
    }

    /* renamed from: a */
    public abstract void mo14466a(T t, float f);

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void m14465a(T t, Float f) {
        mo14466a((AbstractC1827a<T>) t, f.floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p113c.p115b.AbstractC1830d
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo14456a(Object obj, Float f) {
        m14465a((AbstractC1827a<T>) obj, f);
    }
}
