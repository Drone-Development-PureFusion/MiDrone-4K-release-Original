package com.github.moduth.blockcanary;

import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.github.moduth.blockcanary.m */
/* loaded from: classes.dex */
public abstract class AbstractC3970m {

    /* renamed from: a */
    static final int f16992a = 300;

    /* renamed from: c */
    long f16994c;

    /* renamed from: b */
    AtomicBoolean f16993b = new AtomicBoolean(false);

    /* renamed from: d */
    private Runnable f16995d = new Runnable() { // from class: com.github.moduth.blockcanary.m.1
        @Override // java.lang.Runnable
        public void run() {
            AbstractC3970m.this.mo6344c();
            if (AbstractC3970m.this.f16993b.get()) {
                C3961g.m6373a().postDelayed(AbstractC3970m.this.f16995d, AbstractC3970m.this.f16994c);
            }
        }
    };

    public AbstractC3970m(long j) {
        this.f16994c = 0 == j ? 300L : j;
    }

    /* renamed from: a */
    public void mo6348a() {
        if (this.f16993b.get()) {
            return;
        }
        this.f16993b.set(true);
        C3961g.m6373a().removeCallbacks(this.f16995d);
        C3961g.m6373a().postDelayed(this.f16995d, C3953c.m6385a().m6379c());
    }

    /* renamed from: c */
    abstract void mo6344c();

    /* renamed from: d */
    public void m6346d() {
        if (!this.f16993b.get()) {
            return;
        }
        this.f16993b.set(false);
        C3961g.m6373a().removeCallbacks(this.f16995d);
    }
}
