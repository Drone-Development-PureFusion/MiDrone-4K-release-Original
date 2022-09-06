package org.p290c.p308d;

import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
import org.p287b.C5422d;
import org.p287b.C5433n;
import org.p290c.C5562c;
import org.p290c.p299b.p301b.C5502b;
import org.p290c.p299b.p301b.C5503c;
import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.d.c */
/* loaded from: classes.dex */
public class C5568c implements AbstractC5582l {

    /* renamed from: a */
    private final C5570d f22651a = new C5570d();

    /* renamed from: b */
    private String f22652b = "Expected test to throw %s";

    /* renamed from: org.c.d.c$a */
    /* loaded from: classes2.dex */
    private class C5569a extends AbstractC5647j {

        /* renamed from: b */
        private final AbstractC5647j f22654b;

        public C5569a(AbstractC5647j abstractC5647j) {
            this.f22654b = abstractC5647j;
        }

        @Override // org.p290c.p312f.p313a.AbstractC5647j
        /* renamed from: a */
        public void mo318a() {
            try {
                this.f22654b.mo318a();
                if (!C5568c.this.m662d()) {
                    return;
                }
                C5568c.this.m661e();
            } catch (Throwable th) {
                C5568c.this.m672a(th);
            }
        }
    }

    private C5568c() {
    }

    /* renamed from: a */
    public static C5568c m675a() {
        return new C5568c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m672a(Throwable th) {
        if (m662d()) {
            C5562c.m758a(th, (AbstractC5430k<? super Throwable>) this.f22651a.m657b());
            return;
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m662d() {
        return this.f22651a.m659a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m661e() {
        C5562c.m757a(m660f());
    }

    /* renamed from: f */
    private String m660f() {
        return String.format(this.f22652b, C5433n.m1073b((AbstractC5432m) this.f22651a.m657b()));
    }

    /* renamed from: a */
    public C5568c m673a(String str) {
        this.f22652b = str;
        return this;
    }

    @Override // org.p290c.p308d.AbstractC5582l
    /* renamed from: a */
    public AbstractC5647j mo587a(AbstractC5647j abstractC5647j, C5619c c5619c) {
        return new C5569a(abstractC5647j);
    }

    /* renamed from: a */
    public void m674a(Class<? extends Throwable> cls) {
        m671a(C5422d.m1097d((Class<?>) cls));
    }

    /* renamed from: a */
    public void m671a(AbstractC5430k<?> abstractC5430k) {
        this.f22651a.m658a(abstractC5430k);
    }

    @Deprecated
    /* renamed from: b */
    public C5568c m668b() {
        return this;
    }

    /* renamed from: b */
    public void m667b(String str) {
        m666b(C5422d.m1111b(str));
    }

    /* renamed from: b */
    public void m666b(AbstractC5430k<String> abstractC5430k) {
        m671a(C5503c.m904a(abstractC5430k));
    }

    @Deprecated
    /* renamed from: c */
    public C5568c m664c() {
        return this;
    }

    /* renamed from: c */
    public void m663c(AbstractC5430k<? extends Throwable> abstractC5430k) {
        m671a(C5502b.m908a(abstractC5430k));
    }
}
