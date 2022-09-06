package com.p080b;
/* renamed from: com.b.an */
/* loaded from: classes.dex */
public class C1423an {

    /* renamed from: a */
    private C1425ao f4890a;

    /* renamed from: b */
    private AbstractC1428aq f4891b;

    /* renamed from: com.b.an$a */
    /* loaded from: classes.dex */
    public interface AbstractC1424a {
        /* renamed from: a */
        void mo15431a(Throwable th);

        /* renamed from: a */
        void mo15430a(byte[] bArr, long j);

        /* renamed from: b */
        void mo15429b();

        /* renamed from: c */
        void mo15428c();
    }

    public C1423an(AbstractC1428aq abstractC1428aq) {
        this(abstractC1428aq, 0L, -1L);
    }

    public C1423an(AbstractC1428aq abstractC1428aq, long j, long j2) {
        this.f4891b = abstractC1428aq;
        this.f4890a = new C1425ao(this.f4891b.f4903a, this.f4891b.f4904b, abstractC1428aq.f4905c == null ? null : abstractC1428aq.f4905c);
        this.f4890a.m16330b(j2);
        this.f4890a.m16338a(j);
    }

    /* renamed from: a */
    public void m16339a(AbstractC1424a abstractC1424a) {
        this.f4890a.m16336a(this.f4891b.mo15503c(), this.f4891b.mo15505a(), this.f4891b.mo15504b(), abstractC1424a);
    }
}
