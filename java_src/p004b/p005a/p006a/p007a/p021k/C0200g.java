package p004b.p005a.p006a.p007a.p021k;

import java.util.List;
import java.util.TimeZone;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p057r.C0568b;
/* renamed from: b.a.a.a.k.g */
/* loaded from: classes.dex */
public class C0200g extends AbstractC0198e {

    /* renamed from: a */
    long f328a = -1;

    /* renamed from: b */
    String f329b = null;

    /* renamed from: c */
    C0568b f330c = null;

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        return this.f330c.m20122a(abstractC0231d.mo21208n());
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        String d = d();
        if (d == null) {
            d = C0359h.f712i;
        }
        String str = d.equals(C0359h.f711h) ? C0359h.f712i : d;
        try {
            this.f330c = new C0568b(str);
        } catch (IllegalArgumentException e) {
            c("Could not instantiate SimpleDateFormat with pattern " + str, e);
            this.f330c = new C0568b(C0359h.f712i);
        }
        List<String> e2 = e();
        if (e2 == null || e2.size() <= 1) {
            return;
        }
        this.f330c.m20121a(TimeZone.getTimeZone(e2.get(1)));
    }
}
