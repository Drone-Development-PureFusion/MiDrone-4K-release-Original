package org.p287b;

import org.p287b.p289b.C5414b;
/* renamed from: org.b.j */
/* loaded from: classes2.dex */
public abstract class AbstractC5429j<T, U> extends AbstractC5434o<T> {

    /* renamed from: a */
    private static final C5414b f22500a = new C5414b("featureValueOf", 1, 0);

    /* renamed from: b */
    private final AbstractC5430k<? super U> f22501b;

    /* renamed from: c */
    private final String f22502c;

    /* renamed from: d */
    private final String f22503d;

    public AbstractC5429j(AbstractC5430k<? super U> abstractC5430k, String str, String str2) {
        super(f22500a);
        this.f22501b = abstractC5430k;
        this.f22502c = str;
        this.f22503d = str2;
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public final void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a(this.f22502c).mo1086a(" ").mo1083a((AbstractC5432m) this.f22501b);
    }

    /* renamed from: b */
    protected abstract U m1080b(T t);

    @Override // org.p287b.AbstractC5434o
    /* renamed from: b */
    protected boolean mo1071b(T t, AbstractC5425g abstractC5425g) {
        U m1080b = m1080b(t);
        if (!this.f22501b.mo900a(m1080b)) {
            abstractC5425g.mo1086a(this.f22503d).mo1086a(" ");
            this.f22501b.mo1070a(m1080b, abstractC5425g);
            return false;
        }
        return true;
    }
}
