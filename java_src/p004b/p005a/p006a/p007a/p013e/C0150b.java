package p004b.p005a.p006a.p007a.p013e;

import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p032d.AbstractC0286c;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.e.b */
/* loaded from: classes.dex */
public class C0150b extends AbstractC0286c<AbstractC0231d> {

    /* renamed from: a */
    C0146d f221a;

    @Override // p004b.p005a.p006a.p028b.p032d.AbstractC0286c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public EnumC0533l mo21040a(AbstractC0231d abstractC0231d) {
        if (g_() && !abstractC0231d.mo21220b().m21483a(this.f221a)) {
            return EnumC0533l.DENY;
        }
        return EnumC0533l.NEUTRAL;
    }

    /* renamed from: a */
    public void m21450a(String str) {
        this.f221a = C0146d.m21482a(str);
    }

    @Override // p004b.p005a.p006a.p028b.p032d.AbstractC0286c, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f221a != null) {
            super.mo20156j();
        }
    }
}
