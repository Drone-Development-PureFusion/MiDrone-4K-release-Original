package p004b.p005a.p006a.p028b.p048j;

import java.io.File;
import p004b.p005a.p006a.p028b.AbstractC0540p;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.j.a */
/* loaded from: classes.dex */
public class C0460a extends AbstractC0540p {

    /* renamed from: a */
    String f1015a;

    /* renamed from: a */
    public String m20454a() {
        return this.f1015a;
    }

    /* renamed from: a */
    public void m20453a(String str) {
        this.f1015a = str;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0538q
    /* renamed from: b */
    public String mo20209b() {
        if (C0589u.m20054e(this.f1015a)) {
            c("The \"path\" property must be set.");
            return null;
        }
        return a(new File(this.f1015a).exists());
    }
}
