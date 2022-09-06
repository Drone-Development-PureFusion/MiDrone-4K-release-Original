package p004b.p005a.p006a.p007a.p021k;

import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
/* renamed from: b.a.a.a.k.t */
/* loaded from: classes.dex */
public abstract class AbstractC0213t extends AbstractC0198e {

    /* renamed from: a */
    AbstractC0190a f335a = null;

    /* renamed from: a */
    protected abstract String mo21289a(AbstractC0231d abstractC0231d);

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: b */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        String mo21289a = mo21289a(abstractC0231d);
        return this.f335a == null ? mo21289a : this.f335a.mo21280a(mo21289a);
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        String d = d();
        if (d != null) {
            try {
                int parseInt = Integer.parseInt(d);
                if (parseInt == 0) {
                    this.f335a = new C0196c();
                } else if (parseInt > 0) {
                    this.f335a = new C0219z(parseInt);
                }
            } catch (NumberFormatException e) {
            }
        }
    }
}
