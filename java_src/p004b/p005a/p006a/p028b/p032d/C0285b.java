package p004b.p005a.p006a.p028b.p032d;

import p004b.p005a.p006a.p028b.p030b.AbstractC0271b;
import p004b.p005a.p006a.p028b.p030b.C0270a;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.b.d.b */
/* loaded from: classes.dex */
public class C0285b<E> extends AbstractC0284a<E> {

    /* renamed from: a */
    AbstractC0271b<E> f511a;

    @Override // p004b.p005a.p006a.p028b.p032d.AbstractC0286c
    /* renamed from: a */
    public EnumC0533l mo21040a(E e) {
        if (!g_() || !this.f511a.g_()) {
            return EnumC0533l.NEUTRAL;
        }
        try {
            return this.f511a.mo21090a((AbstractC0271b<E>) e) ? this.f509b : this.f510c;
        } catch (C0270a e2) {
            a("Evaluator " + this.f511a.mo21089a() + " threw an exception", e2);
            return EnumC0533l.NEUTRAL;
        }
    }

    /* renamed from: a */
    public void m21042a(AbstractC0271b<E> abstractC0271b) {
        this.f511a = abstractC0271b;
    }

    /* renamed from: d */
    public AbstractC0271b<E> m21041d() {
        return this.f511a;
    }

    @Override // p004b.p005a.p006a.p028b.p032d.AbstractC0286c, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f511a != null) {
            super.j();
        } else {
            c("No evaluator set for filter " + e());
        }
    }
}
