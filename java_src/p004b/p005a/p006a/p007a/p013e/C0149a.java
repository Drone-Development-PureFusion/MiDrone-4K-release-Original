package p004b.p005a.p006a.p007a.p013e;

import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p032d.AbstractC0284a;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.e.a */
/* loaded from: classes.dex */
public class C0149a extends AbstractC0284a<AbstractC0231d> {

    /* renamed from: a */
    C0146d f220a;

    @Override // p004b.p005a.p006a.p028b.p032d.AbstractC0286c
    /* renamed from: a */
    public EnumC0533l mo21040a(AbstractC0231d abstractC0231d) {
        return !g_() ? EnumC0533l.NEUTRAL : abstractC0231d.mo21220b().equals(this.f220a) ? this.f509b : this.f510c;
    }

    /* renamed from: a */
    public void m21453a(C0146d c0146d) {
        this.f220a = c0146d;
    }

    @Override // p004b.p005a.p006a.p028b.p032d.AbstractC0286c, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f220a != null) {
            super.j();
        }
    }
}
