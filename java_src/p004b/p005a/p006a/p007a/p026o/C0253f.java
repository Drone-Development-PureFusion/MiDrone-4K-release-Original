package p004b.p005a.p006a.p007a.p026o;

import org.p318d.AbstractC5756f;
import org.p318d.C5757g;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.o.f */
/* loaded from: classes.dex */
public class C0253f extends AbstractC0254g {

    /* renamed from: a */
    AbstractC5756f f435a;

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i
    /* renamed from: a */
    public EnumC0533l mo21125a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object[] objArr, Throwable th) {
        if (!g_()) {
            return EnumC0533l.NEUTRAL;
        }
        if (abstractC5756f != null && abstractC5756f.mo5c(this.f435a)) {
            return this.f436c;
        }
        return this.f437d;
    }

    /* renamed from: a */
    public void m21144a(String str) {
        if (str != null) {
            this.f435a = C5757g.m2a(str);
        }
    }

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f435a != null) {
            super.j();
        } else {
            c("The marker property must be set for [" + f() + "]");
        }
    }
}
