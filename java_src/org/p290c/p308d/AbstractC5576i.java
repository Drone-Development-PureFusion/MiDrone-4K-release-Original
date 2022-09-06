package org.p290c.p308d;

import java.util.concurrent.TimeUnit;
import org.p290c.C5592e;
import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.d.i */
/* loaded from: classes2.dex */
public abstract class AbstractC5576i implements AbstractC5582l {

    /* renamed from: a */
    private final C5578a f22661a;

    /* renamed from: b */
    private volatile long f22662b;

    /* renamed from: c */
    private volatile long f22663c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.c.d.i$a */
    /* loaded from: classes2.dex */
    public static class C5578a {
        C5578a() {
        }

        /* renamed from: a */
        public long m637a() {
            return System.nanoTime();
        }
    }

    /* renamed from: org.c.d.i$b */
    /* loaded from: classes2.dex */
    private class C5579b extends AbstractC5583m {
        private C5579b() {
        }

        @Override // org.p290c.p308d.AbstractC5583m
        /* renamed from: a */
        protected void mo621a(Throwable th, C5619c c5619c) {
            AbstractC5576i.this.m639c();
            AbstractC5576i.this.m647a(AbstractC5576i.this.m648a(), th, c5619c);
        }

        @Override // org.p290c.p308d.AbstractC5583m
        /* renamed from: a */
        protected void mo614a(C5619c c5619c) {
            AbstractC5576i.this.m642b();
        }

        @Override // org.p290c.p308d.AbstractC5583m
        /* renamed from: a */
        protected void mo612a(C5592e c5592e, C5619c c5619c) {
            AbstractC5576i.this.m639c();
            AbstractC5576i.this.m645a(AbstractC5576i.this.m648a(), c5592e, c5619c);
        }

        @Override // org.p290c.p308d.AbstractC5583m
        /* renamed from: b */
        protected void mo610b(C5619c c5619c) {
            AbstractC5576i.this.m641b(AbstractC5576i.this.m648a(), c5619c);
        }

        @Override // org.p290c.p308d.AbstractC5583m
        /* renamed from: c */
        protected void mo607c(C5619c c5619c) {
            AbstractC5576i.this.m639c();
            AbstractC5576i.this.m646a(AbstractC5576i.this.m648a(), c5619c);
        }
    }

    public AbstractC5576i() {
        this(new C5578a());
    }

    AbstractC5576i(C5578a c5578a) {
        this.f22661a = c5578a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long m648a() {
        if (this.f22662b == 0) {
            throw new IllegalStateException("Test has not started");
        }
        long j = this.f22663c;
        if (j == 0) {
            j = this.f22661a.m637a();
        }
        return j - this.f22662b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m642b() {
        this.f22662b = this.f22661a.m637a();
        this.f22663c = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m639c() {
        this.f22663c = this.f22661a.m637a();
    }

    /* renamed from: a */
    public long m644a(TimeUnit timeUnit) {
        return timeUnit.convert(m648a(), TimeUnit.NANOSECONDS);
    }

    @Override // org.p290c.p308d.AbstractC5582l
    /* renamed from: a */
    public final AbstractC5647j mo587a(AbstractC5647j abstractC5647j, C5619c c5619c) {
        return new C5579b().a(abstractC5647j, c5619c);
    }

    /* renamed from: a */
    protected void m647a(long j, Throwable th, C5619c c5619c) {
    }

    /* renamed from: a */
    protected void m646a(long j, C5619c c5619c) {
    }

    /* renamed from: a */
    protected void m645a(long j, C5592e c5592e, C5619c c5619c) {
    }

    /* renamed from: b */
    protected void m641b(long j, C5619c c5619c) {
    }
}
