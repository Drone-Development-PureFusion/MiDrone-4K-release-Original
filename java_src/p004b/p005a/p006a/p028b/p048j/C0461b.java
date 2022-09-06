package p004b.p005a.p006a.p028b.p048j;

import p004b.p005a.p006a.p028b.AbstractC0540p;
import p004b.p005a.p006a.p028b.p057r.C0585s;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.j.b */
/* loaded from: classes.dex */
public class C0461b extends AbstractC0540p {

    /* renamed from: a */
    String f1016a;

    /* renamed from: a */
    public String m20452a() {
        return this.f1016a;
    }

    /* renamed from: a */
    public void m20451a(String str) {
        this.f1016a = str;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0538q
    /* renamed from: b */
    public String mo20209b() {
        if (!C0589u.m20054e(this.f1016a)) {
            return a(C0585s.m20079a(this.f1016a) != null);
        }
        c("The \"resource\" property must be set.");
        return null;
    }
}
