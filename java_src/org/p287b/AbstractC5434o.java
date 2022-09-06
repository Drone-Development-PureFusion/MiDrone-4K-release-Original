package org.p287b;

import org.p287b.AbstractC5425g;
import org.p287b.p289b.C5414b;
/* renamed from: org.b.o */
/* loaded from: classes2.dex */
public abstract class AbstractC5434o<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private static final C5414b f22505a = new C5414b("matchesSafely", 2, 0);

    /* renamed from: b */
    private final Class<?> f22506b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC5434o() {
        this(f22505a);
    }

    protected AbstractC5434o(Class<?> cls) {
        this.f22506b = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC5434o(C5414b c5414b) {
        this.f22506b = c5414b.m1140a(getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5412b, org.p287b.AbstractC5430k
    /* renamed from: a */
    public final void mo1070a(Object obj, AbstractC5425g abstractC5425g) {
        if (obj == 0 || !this.f22506b.isInstance(obj)) {
            super.mo1070a(obj, abstractC5425g);
        } else {
            mo1071b(obj, abstractC5425g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public final boolean mo900a(Object obj) {
        return obj != 0 && this.f22506b.isInstance(obj) && mo1071b(obj, new AbstractC5425g.C5426a());
    }

    /* renamed from: b */
    protected abstract boolean mo1071b(T t, AbstractC5425g abstractC5425g);
}
