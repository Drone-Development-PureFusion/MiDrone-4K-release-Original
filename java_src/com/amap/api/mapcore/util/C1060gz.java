package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.gz */
/* loaded from: classes.dex */
public class C1060gz {

    /* renamed from: a */
    private C1069ha f3312a;

    /* renamed from: b */
    private AbstractC1075hd f3313b;

    /* renamed from: com.amap.api.mapcore.util.gz$a */
    /* loaded from: classes.dex */
    public interface AbstractC1061a {
        /* renamed from: a */
        void mo17754a(Throwable th);

        /* renamed from: a */
        void mo17753a(byte[] bArr, long j);

        /* renamed from: d */
        void mo17752d();

        /* renamed from: e */
        void mo17751e();
    }

    public C1060gz(AbstractC1075hd abstractC1075hd) {
        this(abstractC1075hd, 0L, -1L);
    }

    public C1060gz(AbstractC1075hd abstractC1075hd, long j, long j2) {
        this.f3313b = abstractC1075hd;
        this.f3312a = new C1069ha(this.f3313b.f3367f, this.f3313b.f3368g, abstractC1075hd.f3369h == null ? null : abstractC1075hd.f3369h);
        this.f3312a.m17713b(j2);
        this.f3312a.m17723a(j);
    }

    /* renamed from: a */
    public void m17756a() {
        this.f3312a.m17724a();
    }

    /* renamed from: a */
    public void m17755a(AbstractC1061a abstractC1061a) {
        this.f3312a.m17720a(this.f3313b.mo17697c(), this.f3313b.mo17702a(), this.f3313b.mo17699b(), abstractC1061a);
    }
}
