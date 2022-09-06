package p004b.p005a.p006a.p028b.p051m;

import java.io.File;
import java.util.Date;
import p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0471a;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
import p004b.p005a.p006a.p028b.p051m.p052a.C0489o;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.m.j */
/* loaded from: classes.dex */
public abstract class AbstractC0503j<E> extends C0527f implements AbstractC0502i<E> {

    /* renamed from: d */
    protected C0504k<E> f1127d;

    /* renamed from: f */
    protected String f1129f;

    /* renamed from: g */
    protected C0489o f1130g;

    /* renamed from: j */
    protected long f1133j;

    /* renamed from: e */
    protected AbstractC0471a f1128e = null;

    /* renamed from: h */
    protected long f1131h = -1;

    /* renamed from: i */
    protected Date f1132i = null;

    /* renamed from: k */
    protected boolean f1134k = false;

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0502i
    /* renamed from: a */
    public void mo20326a(long j) {
        this.f1131h = j;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0502i
    /* renamed from: a */
    public void mo20325a(C0504k<E> c0504k) {
        this.f1127d = c0504k;
    }

    /* renamed from: a */
    public void m20324a(Date date) {
        this.f1132i = date;
    }

    /* renamed from: b */
    public String mo20323b() {
        return this.f1127d.f1137c.m20387a((Object) this.f1132i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m20322b(long j) {
        this.f1132i.setTime(j);
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0502i
    /* renamed from: e */
    public String mo20321e() {
        return this.f1129f;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0502i
    /* renamed from: f */
    public AbstractC0471a mo20320f() {
        return this.f1128e;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0502i
    /* renamed from: g */
    public long mo20319g() {
        return this.f1131h >= 0 ? this.f1131h : System.currentTimeMillis();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f1134k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m20318h() {
        this.f1133j = this.f1130g.m20365a(this.f1132i);
    }

    /* renamed from: j */
    public void mo20156j() {
        C0477f m20383b = this.f1127d.f1114j.m20383b();
        if (m20383b == null) {
            throw new IllegalStateException("FileNamePattern [" + this.f1127d.f1114j.m20380d() + "] does not contain a valid DateToken");
        }
        this.f1130g = new C0489o();
        this.f1130g.m20366a(m20383b.m20410a());
        d("The date pattern is '" + m20383b.m20410a() + "' from file name pattern '" + this.f1127d.f1114j.m20380d() + "'.");
        this.f1130g.m20367a(this);
        m20324a(new Date(mo20319g()));
        if (this.f1127d.n() != null) {
            File file = new File(this.f1127d.n());
            if (file.exists() && file.canRead()) {
                m20324a(new Date(file.lastModified()));
            }
        }
        d("Setting initial period to " + this.f1132i);
        m20318h();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f1134k = false;
    }
}
