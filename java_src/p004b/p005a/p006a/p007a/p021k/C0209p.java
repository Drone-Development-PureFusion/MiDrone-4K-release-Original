package p004b.p005a.p006a.p007a.p021k;

import java.util.Map;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.k.p */
/* loaded from: classes.dex */
public class C0209p extends AbstractC0198e {

    /* renamed from: a */
    private String f332a;

    /* renamed from: b */
    private String f333b = "";

    /* renamed from: a */
    private String m21293a(Map<String, String> map) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append(", ");
                z = z2;
            }
            sb.append(entry.getKey()).append(SignatureVisitor.INSTANCEOF).append(entry.getValue());
            z2 = z;
        }
        return sb.toString();
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        Map<String, String> mo21210l = abstractC0231d.mo21210l();
        if (mo21210l == null) {
            return this.f333b;
        }
        if (this.f332a == null) {
            return m21293a(mo21210l);
        }
        String str = abstractC0231d.mo21210l().get(this.f332a);
        return str == null ? this.f333b : str;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        String[] m20055d = C0589u.m20055d(d());
        this.f332a = m20055d[0];
        if (m20055d[1] != null) {
            this.f333b = m20055d[1];
        }
        super.j();
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f332a = null;
        super.k();
    }
}
