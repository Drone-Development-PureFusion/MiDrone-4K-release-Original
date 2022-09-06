package com.p113c.p114a;
/* renamed from: com.c.a.o */
/* loaded from: classes.dex */
public class C1816o extends C1819q {

    /* renamed from: p */
    private AbstractC1817a f6394p;

    /* renamed from: q */
    private long f6395q = -1;

    /* renamed from: com.c.a.o$a */
    /* loaded from: classes.dex */
    public interface AbstractC1817a {
        /* renamed from: a */
        void m14532a(C1816o c1816o, long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p113c.p114a.C1819q
    /* renamed from: a */
    public void mo14520a(float f) {
    }

    /* renamed from: a */
    public void m14533a(AbstractC1817a abstractC1817a) {
        this.f6394p = abstractC1817a;
    }

    @Override // com.p113c.p114a.C1819q
    /* renamed from: c */
    boolean mo14495c(long j) {
        long j2 = 0;
        if (this.f6429i == 0) {
            this.f6429i = 1;
            if (this.f6428h < 0) {
                this.f6427g = j;
            } else {
                this.f6427g = j - this.f6428h;
                this.f6428h = -1L;
            }
        }
        if (this.f6394p != null) {
            long j3 = j - this.f6427g;
            if (this.f6395q >= 0) {
                j2 = j - this.f6395q;
            }
            this.f6395q = j;
            this.f6394p.m14532a(this, j3, j2);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p113c.p114a.C1819q
    /* renamed from: n */
    public void mo14483n() {
    }
}
