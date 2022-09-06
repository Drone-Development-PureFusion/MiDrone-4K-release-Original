package p004b.p005a.p006a.p007a.p014f;

import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0232e;
import p004b.p005a.p006a.p007a.p025n.C0243p;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p033e.C0291d;
import p004b.p005a.p006a.p028b.p034f.AbstractC0295c;
/* renamed from: b.a.a.a.f.b */
/* loaded from: classes.dex */
public class C0153b implements AbstractC0295c<AbstractC0231d> {

    /* renamed from: a */
    static final String f234a = "<br />&nbsp;&nbsp;&nbsp;&nbsp;";

    @Override // p004b.p005a.p006a.p028b.p034f.AbstractC0295c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo21006a(StringBuilder sb, AbstractC0231d abstractC0231d) {
        sb.append("<tr><td class=\"Exception\" colspan=\"6\">");
        for (AbstractC0232e mo21214h = abstractC0231d.mo21214h(); mo21214h != null; mo21214h = mo21214h.mo21167e()) {
            m21416a(sb, mo21214h);
        }
        sb.append("</td></tr>");
    }

    /* renamed from: a */
    void m21416a(StringBuilder sb, AbstractC0232e abstractC0232e) {
        m21415b(sb, abstractC0232e);
        int mo21168d = abstractC0232e.mo21168d();
        C0243p[] mo21169c = abstractC0232e.mo21169c();
        for (int i = 0; i < mo21169c.length - mo21168d; i++) {
            C0243p c0243p = mo21169c[i];
            sb.append(f234a);
            sb.append(C0291d.m21021a(c0243p.toString()));
            sb.append(C0359h.f706c);
        }
        if (mo21168d > 0) {
            sb.append(f234a);
            sb.append("\t... ").append(mo21168d).append(" common frames omitted").append(C0359h.f706c);
        }
    }

    /* renamed from: b */
    public void m21415b(StringBuilder sb, AbstractC0232e abstractC0232e) {
        if (abstractC0232e.mo21168d() > 0) {
            sb.append("<br />").append(C0359h.f718o);
        }
        sb.append(abstractC0232e.mo21170b()).append(": ").append(C0291d.m21021a(abstractC0232e.mo21172a()));
        sb.append(C0359h.f706c);
    }
}
