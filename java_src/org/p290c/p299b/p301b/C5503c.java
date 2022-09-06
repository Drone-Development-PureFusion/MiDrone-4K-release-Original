package org.p290c.p299b.p301b;

import java.lang.Throwable;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
import org.p287b.AbstractC5435p;
/* renamed from: org.c.b.b.c */
/* loaded from: classes.dex */
public class C5503c<T extends Throwable> extends AbstractC5435p<T> {

    /* renamed from: a */
    private final AbstractC5430k<String> f22569a;

    public C5503c(AbstractC5430k<String> abstractC5430k) {
        this.f22569a = abstractC5430k;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T extends Throwable> AbstractC5430k<T> m904a(AbstractC5430k<String> abstractC5430k) {
        return new C5503c(abstractC5430k);
    }

    /* renamed from: a */
    protected void m906a(T t, AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("message ");
        this.f22569a.mo1070a(t.getMessage(), abstractC5425g);
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("exception with message ");
        abstractC5425g.mo1083a((AbstractC5432m) this.f22569a);
    }

    /* renamed from: a */
    protected boolean m907a(T t) {
        return this.f22569a.mo900a(t.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5435p
    /* renamed from: b */
    protected /* synthetic */ void mo902b(Object obj, AbstractC5425g abstractC5425g) {
        m906a((C5503c<T>) ((Throwable) obj), abstractC5425g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5435p
    /* renamed from: b */
    protected /* synthetic */ boolean mo903b(Object obj) {
        return m907a((C5503c<T>) ((Throwable) obj));
    }
}
