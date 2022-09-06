package p004b.p005a.p006a.p028b.p051m;

import java.io.File;
import java.util.Date;
import p004b.p005a.p006a.p028b.p051m.p052a.C0492q;
/* renamed from: b.a.a.b.m.a */
/* loaded from: classes.dex */
public class C0470a<E> extends AbstractC0503j<E> {
    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0505l
    /* renamed from: a */
    public boolean mo20305a(File file, E e) {
        long g = g();
        if (g >= this.f1133j) {
            Date date = this.f1132i;
            d("Elapsed period: " + date);
            this.f1129f = this.f1127d.f1137c.m20387a((Object) date);
            b(g);
            h();
            return true;
        }
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0503j, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        super.mo20156j();
        this.f1128e = new C0492q(this.f1127d.f1114j, this.f1130g);
        this.f1128e.a(this.f1190s);
        this.f1134k = true;
    }

    public String toString() {
        return "c.q.l.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy";
    }
}
