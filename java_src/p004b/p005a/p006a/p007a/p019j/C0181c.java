package p004b.p005a.p006a.p007a.p019j;

import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p007a.C0139c;
import p004b.p005a.p006a.p007a.C0156g;
import p004b.p005a.p006a.p007a.p009b.C0137b;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.AbstractC0459j;
import p004b.p005a.p006a.p028b.p030b.AbstractC0271b;
import p004b.p005a.p006a.p028b.p033e.C0288a;
import p004b.p005a.p006a.p028b.p041h.AbstractC0398e;
import p004b.p005a.p006a.p028b.p044i.AbstractC0456k;
/* renamed from: b.a.a.a.j.c */
/* loaded from: classes.dex */
public class C0181c extends AbstractC0398e<AbstractC0231d> {

    /* renamed from: a */
    static final String f282a = "%logger{20} - %m";

    /* renamed from: u */
    private boolean f283u = false;

    public C0181c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0181c(AbstractC0271b<AbstractC0231d> abstractC0271b) {
        this.f842p = abstractC0271b;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0398e
    /* renamed from: a */
    protected AbstractC0459j<AbstractC0231d> mo20627a(String str) {
        if (str == null) {
            str = f282a;
        }
        C0156g c0156g = new C0156g();
        c0156g.a(h_());
        c0156g.f(str);
        c0156g.a((AbstractC0456k) null);
        c0156g.j();
        return c0156g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0398e
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo20632a(C0288a<AbstractC0231d> c0288a, AbstractC0231d abstractC0231d) {
        if (this.f283u) {
            abstractC0231d.mo21213i();
        }
        abstractC0231d.mo20213o();
        c0288a.m21032a((C0288a<AbstractC0231d>) abstractC0231d);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0398e
    /* renamed from: a */
    protected void mo20631a(C0288a<AbstractC0231d> c0288a, StringBuffer stringBuffer) {
        int m21026e = c0288a.m21026e();
        for (int i = 0; i < m21026e; i++) {
            stringBuffer.append(this.f836j.mo20455a((AbstractC0459j<E>) c0288a.m21029c()));
        }
    }

    /* renamed from: a */
    public void m21359a(boolean z) {
        this.f283u = z;
    }

    /* renamed from: a */
    public boolean m21362a() {
        return this.f283u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0398e
    /* renamed from: a */
    public boolean mo20622b(AbstractC0231d abstractC0231d) {
        AbstractC5756f mo21211k = abstractC0231d.mo21211k();
        if (mo21211k == null) {
            return false;
        }
        return mo21211k.mo5c(C0139c.f158e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0398e
    /* renamed from: b */
    public C0156g mo20613f_(String str) {
        C0156g c0156g = new C0156g();
        c0156g.f(str + "%nopex");
        return c0156g;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0398e, p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f842p == null) {
            C0137b c0137b = new C0137b();
            c0137b.a(h_());
            c0137b.b("onError");
            c0137b.j();
            this.f842p = c0137b;
        }
        super.mo20156j();
    }
}
