package org.p287b.p288a;

import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5427h;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.j */
/* loaded from: classes.dex */
public class C5403j extends AbstractC5427h<Object> {

    /* renamed from: a */
    private final Class<?> f22481a;

    /* renamed from: b */
    private final Class<?> f22482b;

    public C5403j(Class<?> cls) {
        this.f22481a = cls;
        this.f22482b = m1158c(cls);
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1160a(Class<?> cls) {
        return new C5403j(cls);
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T> AbstractC5430k<T> m1159b(Class<T> cls) {
        return new C5403j(cls);
    }

    /* renamed from: c */
    private static Class<?> m1158c(Class<?> cls) {
        return Boolean.TYPE.equals(cls) ? Boolean.class : Byte.TYPE.equals(cls) ? Byte.class : Character.TYPE.equals(cls) ? Character.class : Double.TYPE.equals(cls) ? Double.class : Float.TYPE.equals(cls) ? Float.class : Integer.TYPE.equals(cls) ? Integer.class : Long.TYPE.equals(cls) ? Long.class : Short.TYPE.equals(cls) ? Short.class : cls;
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("an instance of ").mo1086a(this.f22481a.getName());
    }

    @Override // org.p287b.AbstractC5427h
    /* renamed from: b */
    protected boolean mo1081b(Object obj, AbstractC5425g abstractC5425g) {
        if (obj == null) {
            abstractC5425g.mo1086a("null");
            return false;
        } else if (this.f22482b.isInstance(obj)) {
            return true;
        } else {
            abstractC5425g.mo1087a(obj).mo1086a(" is a " + obj.getClass().getName());
            return false;
        }
    }
}
