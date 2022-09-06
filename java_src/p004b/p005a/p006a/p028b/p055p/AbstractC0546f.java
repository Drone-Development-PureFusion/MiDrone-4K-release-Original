package p004b.p005a.p006a.p028b.p055p;

import java.io.PrintStream;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p057r.C0591w;
/* renamed from: b.a.a.b.p.f */
/* loaded from: classes.dex */
abstract class AbstractC0546f extends C0527f implements AbstractC0534m, AbstractC0549i {

    /* renamed from: b */
    static final long f1204b = 300;

    /* renamed from: a */
    boolean f1205a = false;

    /* renamed from: c */
    long f1206c = f1204b;

    /* renamed from: b */
    private void m20203b(AbstractC0547g abstractC0547g) {
        StringBuilder sb = new StringBuilder();
        C0591w.m20048a(sb, "", abstractC0547g);
        mo20206a().print(sb);
    }

    /* renamed from: d */
    private void m20202d() {
        if (this.f1190s == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (AbstractC0547g abstractC0547g : this.f1190s.mo20997n().mo20189a()) {
            if (currentTimeMillis - abstractC0547g.mo20194f().longValue() < this.f1206c) {
                m20203b(abstractC0547g);
            }
        }
    }

    /* renamed from: a */
    protected abstract PrintStream mo20206a();

    /* renamed from: a */
    public void mo20205a(long j) {
        this.f1206c = j;
    }

    /* renamed from: a_ */
    public void mo20190a_(AbstractC0547g abstractC0547g) {
        if (!this.f1205a) {
            return;
        }
        m20203b(abstractC0547g);
    }

    /* renamed from: b */
    public long mo20204b() {
        return this.f1206c;
    }

    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f1205a;
    }

    /* renamed from: j */
    public void mo20156j() {
        this.f1205a = true;
        if (this.f1206c > 0) {
            m20202d();
        }
    }

    /* renamed from: k */
    public void mo20155k() {
        this.f1205a = false;
    }
}
