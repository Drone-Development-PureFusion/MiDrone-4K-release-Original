package org.p287b;

import org.p287b.p289b.C5414b;
/* renamed from: org.b.p */
/* loaded from: classes2.dex */
public abstract class AbstractC5435p<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private static final C5414b f22507a = new C5414b("matchesSafely", 1, 0);

    /* renamed from: b */
    private final Class<?> f22508b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC5435p() {
        this(f22507a);
    }

    protected AbstractC5435p(Class<?> cls) {
        this.f22508b = cls;
    }

    protected AbstractC5435p(C5414b c5414b) {
        this.f22508b = c5414b.m1140a(getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5412b, org.p287b.AbstractC5430k
    /* renamed from: a */
    public final void mo1070a(Object obj, AbstractC5425g abstractC5425g) {
        if (obj == 0) {
            super.mo1070a(obj, abstractC5425g);
        } else if (!this.f22508b.isInstance(obj)) {
            abstractC5425g.mo1086a("was a ").mo1086a(obj.getClass().getName()).mo1086a(" (").mo1087a(obj).mo1086a(")");
        } else {
            mo902b(obj, abstractC5425g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public final boolean mo900a(Object obj) {
        return obj != 0 && this.f22508b.isInstance(obj) && mo903b(obj);
    }

    /* renamed from: b */
    protected void mo902b(T t, AbstractC5425g abstractC5425g) {
        super.mo1070a(t, abstractC5425g);
    }

    /* renamed from: b */
    protected abstract boolean mo903b(T t);
}
