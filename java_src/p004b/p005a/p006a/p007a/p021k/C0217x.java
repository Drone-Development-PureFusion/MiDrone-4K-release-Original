package p004b.p005a.p006a.p007a.p021k;

import p004b.p005a.p006a.p007a.p025n.AbstractC0232e;
import p004b.p005a.p006a.p007a.p025n.C0245r;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.a.k.x */
/* loaded from: classes.dex */
public class C0217x extends C0202i {
    @Override // p004b.p005a.p006a.p007a.p021k.C0194ac
    /* renamed from: a */
    protected String mo21284a(AbstractC0232e abstractC0232e) {
        StringBuilder sb = new StringBuilder(2048);
        m21283a(sb, null, 1, abstractC0232e);
        return sb.toString();
    }

    /* renamed from: a */
    protected void m21283a(StringBuilder sb, String str, int i, AbstractC0232e abstractC0232e) {
        if (abstractC0232e.mo21167e() != null) {
            m21283a(sb, str, i, abstractC0232e.mo21167e());
            str = null;
        }
        C0245r.m21184a(sb, i - 1);
        if (str != null) {
            sb.append(str);
        }
        C0245r.m21174c(sb, abstractC0232e);
        sb.append(C0359h.f706c);
        a(sb, i, abstractC0232e);
        AbstractC0232e[] mo21166f = abstractC0232e.mo21166f();
        if (mo21166f != null) {
            for (AbstractC0232e abstractC0232e2 : mo21166f) {
                m21283a(sb, C0359h.f719p, i + 1, abstractC0232e2);
            }
        }
    }
}
