package org.p290c.p299b.p301b;

import java.lang.Throwable;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
import org.p287b.AbstractC5435p;
/* renamed from: org.c.b.b.b */
/* loaded from: classes.dex */
public class C5502b<T extends Throwable> extends AbstractC5435p<T> {

    /* renamed from: a */
    private final AbstractC5430k<? extends Throwable> f22568a;

    public C5502b(AbstractC5430k<? extends Throwable> abstractC5430k) {
        this.f22568a = abstractC5430k;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T extends Throwable> AbstractC5430k<T> m908a(AbstractC5430k<? extends Throwable> abstractC5430k) {
        return new C5502b(abstractC5430k);
    }

    /* renamed from: a */
    protected void m909a(T t, AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("cause ");
        this.f22568a.mo1070a(t.getCause(), abstractC5425g);
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("exception with cause ");
        abstractC5425g.mo1083a((AbstractC5432m) this.f22568a);
    }

    /* renamed from: a */
    protected boolean m910a(T t) {
        return this.f22568a.mo900a(t.getCause());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5435p
    /* renamed from: b */
    protected /* synthetic */ void mo902b(Object obj, AbstractC5425g abstractC5425g) {
        m909a((C5502b<T>) ((Throwable) obj), abstractC5425g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5435p
    /* renamed from: b */
    protected /* synthetic */ boolean mo903b(Object obj) {
        return m910a((C5502b<T>) ((Throwable) obj));
    }
}
