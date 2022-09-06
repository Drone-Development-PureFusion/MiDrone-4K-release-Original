package org.p290c.p308d;

import java.util.ArrayList;
import java.util.List;
import org.p287b.AbstractC5430k;
import org.p287b.C5422d;
import org.p290c.p307c.C5563a;
/* renamed from: org.c.d.d */
/* loaded from: classes2.dex */
class C5570d {

    /* renamed from: a */
    private final List<AbstractC5430k<?>> f22655a = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private AbstractC5430k<Throwable> m656b(AbstractC5430k<?> abstractC5430k) {
        return abstractC5430k;
    }

    /* renamed from: c */
    private AbstractC5430k<Throwable> m655c() {
        return this.f22655a.size() == 1 ? m656b(this.f22655a.get(0)) : C5422d.m1127a((Iterable) m654d());
    }

    /* renamed from: d */
    private List<AbstractC5430k<? super Throwable>> m654d() {
        return new ArrayList(this.f22655a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m658a(AbstractC5430k<?> abstractC5430k) {
        this.f22655a.add(abstractC5430k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m659a() {
        return !this.f22655a.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public AbstractC5430k<Throwable> m657b() {
        return C5563a.m692e(m655c());
    }
}
