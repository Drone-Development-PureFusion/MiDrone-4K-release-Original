package p004b.p005a.p006a.p007a.p021k;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.C0228a;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p030b.AbstractC0271b;
import p004b.p005a.p006a.p028b.p030b.C0270a;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.C0541a;
/* renamed from: b.a.a.a.k.b */
/* loaded from: classes.dex */
public class C0195b extends AbstractC0198e {

    /* renamed from: a */
    public static final String f323a = "Caller+";

    /* renamed from: b */
    int f324b = 5;

    /* renamed from: c */
    List<AbstractC0271b<AbstractC0231d>> f325c = null;

    /* renamed from: d */
    final int f326d = 4;

    /* renamed from: e */
    int f327e = 0;

    /* renamed from: a */
    private void m21305a(AbstractC0271b<AbstractC0231d> abstractC0271b) {
        if (this.f325c == null) {
            this.f325c = new ArrayList();
        }
        this.f325c.add(abstractC0271b);
    }

    /* renamed from: a */
    protected String m21307a() {
        return f323a;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        boolean z;
        AbstractC0271b<AbstractC0231d> abstractC0271b;
        StringBuilder sb = new StringBuilder();
        if (this.f325c != null) {
            int i = 0;
            while (true) {
                if (i >= this.f325c.size()) {
                    z = false;
                    break;
                }
                try {
                } catch (C0270a e) {
                    this.f327e++;
                    if (this.f327e < 4) {
                        a("Exception thrown for evaluator named [" + abstractC0271b.mo21089a() + "]", e);
                    } else if (this.f327e == 4) {
                        C0541a c0541a = new C0541a("Exception thrown for evaluator named [" + abstractC0271b.mo21089a() + "].", this, e);
                        c0541a.a(new C0541a("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
                        a((AbstractC0547g) c0541a);
                    }
                }
                if (this.f325c.get(i).mo21090a((AbstractC0271b<AbstractC0231d>) abstractC0231d)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                return "";
            }
        }
        StackTraceElement[] mo21213i = abstractC0231d.mo21213i();
        if (mo21213i == null || mo21213i.length <= 0) {
            return C0228a.f353c;
        }
        int length = this.f324b < mo21213i.length ? this.f324b : mo21213i.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(m21307a());
            sb.append(i2);
            sb.append("\t at ");
            sb.append(mo21213i[i2]);
            sb.append(C0359h.f706c);
        }
        return sb.toString();
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        AbstractC0271b<AbstractC0231d> abstractC0271b;
        String d = d();
        if (d == null) {
            return;
        }
        try {
            this.f324b = Integer.parseInt(d);
        } catch (NumberFormatException e) {
            a("Failed to parse depth option [" + d + "]", e);
        }
        List<String> e2 = e();
        if (e2 == null || e2.size() <= 1) {
            return;
        }
        int size = e2.size();
        for (int i = 1; i < size; i++) {
            String str = e2.get(i);
            AbstractC0292f h_ = h_();
            if (h_ != null && (abstractC0271b = (AbstractC0271b) ((Map) h_.mo20998f(C0359h.f715l)).get(str)) != null) {
                m21305a(abstractC0271b);
            }
        }
    }
}
