package p004b.p005a.p006a.p007a.p024m;

import java.util.Map;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p053n.AbstractC0509b;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.m.c */
/* loaded from: classes.dex */
public class C0224c extends AbstractC0509b<AbstractC0231d> {

    /* renamed from: b */
    private String f348b;

    /* renamed from: c */
    private String f349c;

    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0513f
    /* renamed from: a */
    public String mo20296a() {
        return this.f348b;
    }

    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0513f
    /* renamed from: a */
    public String mo20295a(AbstractC0231d abstractC0231d) {
        String str;
        Map<String, String> mo21210l = abstractC0231d.mo21210l();
        return (mo21210l == null || (str = mo21210l.get(this.f348b)) == null) ? this.f349c : str;
    }

    /* renamed from: a */
    public void m21266a(String str) {
        this.f348b = str;
    }

    /* renamed from: b */
    public String m21265b() {
        return this.f349c;
    }

    /* renamed from: b */
    public void m21264b(String str) {
        this.f349c = str;
    }

    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0509b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        int i = 0;
        if (C0589u.m20054e(this.f348b)) {
            c("The \"Key\" property must be set");
            i = 1;
        }
        if (C0589u.m20054e(this.f349c)) {
            i++;
            c("The \"DefaultValue\" property must be set");
        }
        if (i == 0) {
            this.f1149a = true;
        }
    }
}
