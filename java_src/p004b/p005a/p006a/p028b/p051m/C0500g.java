package p004b.p005a.p006a.p028b.p051m;

import java.io.File;
import java.util.Date;
import p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0347n;
import p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0471a;
import p004b.p005a.p006a.p028b.p051m.p052a.C0479h;
import p004b.p005a.p006a.p028b.p051m.p052a.C0491p;
import p004b.p005a.p006a.p028b.p051m.p052a.EnumC0473c;
import p004b.p005a.p006a.p028b.p057r.C0580n;
@AbstractC0347n
/* renamed from: b.a.a.b.m.g */
/* loaded from: classes.dex */
public class C0500g<E> extends AbstractC0503j<E> {

    /* renamed from: b */
    C0580n f1118b;

    /* renamed from: c */
    String f1119c;

    /* renamed from: l */
    private int f1120l;

    /* renamed from: a */
    int f1117a = 0;

    /* renamed from: m */
    private int f1121m = 1;

    /* renamed from: a */
    private String m20332a(Date date, int i) {
        return this.f1127d.f1114j.m20384a(this.f1132i, Integer.valueOf(i));
    }

    /* renamed from: a */
    protected AbstractC0471a m20334a() {
        return new C0491p(this.f1127d.f1114j, this.f1130g);
    }

    /* renamed from: a */
    void m20333a(String str) {
        File[] m20398a = C0479h.m20398a(new File(mo20323b()).getParentFile(), str);
        if (m20398a == null || m20398a.length == 0) {
            this.f1117a = 0;
            return;
        }
        this.f1117a = C0479h.m20395a(m20398a, str);
        if (this.f1127d.n() == null && this.f1127d.f1113i == EnumC0473c.NONE) {
            return;
        }
        this.f1117a++;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0505l
    /* renamed from: a */
    public boolean mo20305a(File file, E e) {
        long g = g();
        if (g >= this.f1133j) {
            this.f1129f = this.f1127d.f1137c.m20384a(this.f1132i, Integer.valueOf(this.f1117a));
            this.f1117a = 0;
            b(g);
            h();
            return true;
        }
        int i = this.f1120l + 1;
        this.f1120l = i;
        if ((i & this.f1121m) != this.f1121m) {
            return false;
        }
        if (this.f1121m < 15) {
            this.f1121m = (this.f1121m << 1) + 1;
        }
        if (file.length() < this.f1118b.m20092a()) {
            return false;
        }
        this.f1129f = this.f1127d.f1137c.m20384a(this.f1132i, Integer.valueOf(this.f1117a));
        this.f1117a++;
        return true;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0503j, p004b.p005a.p006a.p028b.p051m.AbstractC0502i
    /* renamed from: b */
    public String mo20323b() {
        return this.f1127d.f1137c.m20384a(this.f1132i, Integer.valueOf(this.f1117a));
    }

    /* renamed from: b */
    public void m20331b(String str) {
        this.f1119c = str;
        this.f1118b = C0580n.m20091a(str);
    }

    /* renamed from: d */
    public String m20330d() {
        return this.f1119c;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0503j, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        super.mo20156j();
        this.f1128e = m20334a();
        this.f1128e.a(this.f1190s);
        m20333a(C0479h.m20397a(this.f1127d.f1114j.m20385a(this.f1132i)));
        this.f1134k = true;
    }
}
