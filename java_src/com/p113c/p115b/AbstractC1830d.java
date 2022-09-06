package com.p113c.p115b;
/* renamed from: com.c.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC1830d<T, V> {

    /* renamed from: a */
    private final String f6434a;

    /* renamed from: b */
    private final Class<V> f6435b;

    public AbstractC1830d(Class<V> cls, String str) {
        this.f6434a = str;
        this.f6435b = cls;
    }

    /* renamed from: a */
    public static <T, V> AbstractC1830d<T, V> m14462a(Class<T> cls, Class<V> cls2, String str) {
        return new C1831e(cls, cls2, str);
    }

    /* renamed from: a */
    public abstract V mo14457a(T t);

    /* renamed from: a */
    public void mo14456a(T t, V v) {
        throw new UnsupportedOperationException("Property " + m14461b() + " is read-only");
    }

    /* renamed from: a */
    public boolean mo14459a() {
        return false;
    }

    /* renamed from: b */
    public String m14461b() {
        return this.f6434a;
    }

    /* renamed from: c */
    public Class<V> m14460c() {
        return this.f6435b;
    }
}
