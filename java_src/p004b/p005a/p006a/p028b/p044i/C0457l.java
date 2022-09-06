package p004b.p005a.p006a.p028b.p044i;

import java.util.List;
import java.util.regex.Pattern;
/* renamed from: b.a.a.b.i.l */
/* loaded from: classes.dex */
public class C0457l<E> extends AbstractC0412a<E> {

    /* renamed from: b */
    Pattern f1011b;

    /* renamed from: c */
    String f1012c;

    /* renamed from: d */
    String f1013d;

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0412a
    /* renamed from: a */
    protected String mo20459a(E e, String str) {
        return !this.f995h ? str : this.f1011b.matcher(str).replaceAll(this.f1013d);
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        List<String> e = e();
        if (e == null) {
            c("at least two options are expected whereas you have declared none");
            return;
        }
        int size = e.size();
        if (size < 2) {
            c("at least two options are expected whereas you have declared only " + size + "as [" + e + "]");
            return;
        }
        this.f1012c = e.get(0);
        this.f1011b = Pattern.compile(this.f1012c);
        this.f1013d = e.get(1);
        super.j();
    }
}
