package p004b.p005a.p006a.p007a.p021k;

import com.fimi.soul.utils.C3686n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0232e;
import p004b.p005a.p006a.p007a.p025n.C0243p;
import p004b.p005a.p006a.p007a.p025n.C0245r;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p030b.AbstractC0271b;
import p004b.p005a.p006a.p028b.p030b.C0270a;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.C0541a;
/* renamed from: b.a.a.a.k.ac */
/* loaded from: classes.dex */
public class C0194ac extends AbstractC0193ab {

    /* renamed from: a */
    protected static final int f319a = 2048;

    /* renamed from: b */
    int f320b;

    /* renamed from: c */
    List<AbstractC0271b<AbstractC0231d>> f321c = null;

    /* renamed from: d */
    int f322d = 0;

    /* renamed from: a */
    private void m21313a(AbstractC0271b<AbstractC0231d> abstractC0271b) {
        if (this.f321c == null) {
            this.f321c = new ArrayList();
        }
        this.f321c.add(abstractC0271b);
    }

    /* renamed from: a */
    private void m21311a(StringBuilder sb, AbstractC0232e abstractC0232e) {
        sb.append(abstractC0232e.mo21170b()).append(": ").append(abstractC0232e.mo21172a());
    }

    /* renamed from: a */
    private void m21310a(StringBuilder sb, String str, int i, AbstractC0232e abstractC0232e) {
        if (abstractC0232e == null) {
            return;
        }
        m21308b(sb, str, i, abstractC0232e);
        sb.append(C0359h.f706c);
        m21312a(sb, i, abstractC0232e);
        AbstractC0232e[] mo21166f = abstractC0232e.mo21166f();
        if (mo21166f != null) {
            for (AbstractC0232e abstractC0232e2 : mo21166f) {
                m21310a(sb, C0359h.f719p, i + 1, abstractC0232e2);
            }
        }
        m21310a(sb, C0359h.f718o, i, abstractC0232e.mo21167e());
    }

    /* renamed from: b */
    private void m21308b(StringBuilder sb, String str, int i, AbstractC0232e abstractC0232e) {
        C0245r.m21184a(sb, i - 1);
        if (str != null) {
            sb.append(str);
        }
        m21311a(sb, abstractC0232e);
    }

    /* renamed from: a */
    protected String mo21284a(AbstractC0232e abstractC0232e) {
        StringBuilder sb = new StringBuilder(2048);
        m21310a(sb, null, 1, abstractC0232e);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m21312a(StringBuilder sb, int i, AbstractC0232e abstractC0232e) {
        C0243p[] mo21169c = abstractC0232e.mo21169c();
        int mo21168d = abstractC0232e.mo21168d();
        boolean z = this.f320b > mo21169c.length;
        int length = z ? mo21169c.length : this.f320b;
        if (mo21168d > 0 && z) {
            length -= mo21168d;
        }
        for (int i2 = 0; i2 < length; i2++) {
            C0245r.m21184a(sb, i);
            sb.append(mo21169c[i2]);
            mo21300a(sb, mo21169c[i2]);
            sb.append(C0359h.f706c);
        }
        if (mo21168d <= 0 || !z) {
            return;
        }
        C0245r.m21184a(sb, i);
        sb.append("... ").append(abstractC0232e.mo21168d()).append(" common frames omitted").append(C0359h.f706c);
    }

    /* renamed from: a */
    protected void mo21300a(StringBuilder sb, C0243p c0243p) {
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: b */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        AbstractC0271b<AbstractC0231d> abstractC0271b;
        boolean z = false;
        AbstractC0232e mo21214h = abstractC0231d.mo21214h();
        if (mo21214h == null) {
            return "";
        }
        if (this.f321c != null) {
            int i = 0;
            while (true) {
                if (i >= this.f321c.size()) {
                    z = true;
                    break;
                }
                try {
                } catch (C0270a e) {
                    this.f322d++;
                    if (this.f322d < 4) {
                        a("Exception thrown for evaluator named [" + abstractC0271b.mo21089a() + "]", e);
                    } else if (this.f322d == 4) {
                        C0541a c0541a = new C0541a("Exception thrown for evaluator named [" + abstractC0271b.mo21089a() + "].", this, e);
                        c0541a.a(new C0541a("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
                        a((AbstractC0547g) c0541a);
                    }
                }
                if (this.f321c.get(i).mo21090a((AbstractC0271b<AbstractC0231d>) abstractC0231d)) {
                    break;
                }
                i++;
            }
            if (!z) {
                return "";
            }
        }
        return mo21284a(mo21214h);
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        String d = d();
        if (d == null) {
            this.f320b = Integer.MAX_VALUE;
        } else {
            String lowerCase = d.toLowerCase();
            if (C3686n.f15036au.equals(lowerCase)) {
                this.f320b = Integer.MAX_VALUE;
            } else if ("short".equals(lowerCase)) {
                this.f320b = 1;
            } else {
                try {
                    this.f320b = Integer.parseInt(lowerCase);
                } catch (NumberFormatException e) {
                    c("Could not parse [" + lowerCase + "] as an integer");
                    this.f320b = Integer.MAX_VALUE;
                }
            }
        }
        List<String> e2 = e();
        if (e2 != null && e2.size() > 1) {
            int size = e2.size();
            for (int i = 1; i < size; i++) {
                m21313a((AbstractC0271b) ((Map) h_().mo20998f(C0359h.f715l)).get(e2.get(i)));
            }
        }
        super.j();
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f321c = null;
        super.k();
    }
}
