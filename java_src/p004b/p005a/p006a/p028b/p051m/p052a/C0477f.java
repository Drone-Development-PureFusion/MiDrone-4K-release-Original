package p004b.p005a.p006a.p028b.p051m.p052a;

import java.util.Date;
import java.util.List;
import p004b.p005a.p006a.p028b.p044i.AbstractC0449d;
import p004b.p005a.p006a.p028b.p057r.C0568b;
import p004b.p005a.p006a.p028b.p057r.C0574h;
/* renamed from: b.a.a.b.m.a.f */
/* loaded from: classes.dex */
public class C0477f<E> extends AbstractC0449d<E> implements AbstractC0486l {

    /* renamed from: a */
    public static final String f1054a = "d";

    /* renamed from: b */
    public static final String f1055b = "AUX";

    /* renamed from: c */
    public static final String f1056c = "yyyy-MM-dd";

    /* renamed from: d */
    private String f1057d;

    /* renamed from: e */
    private C0568b f1058e;

    /* renamed from: l */
    private boolean f1059l = true;

    /* renamed from: a */
    public String m20410a() {
        return this.f1057d;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null argument forbidden");
        }
        if (!(obj instanceof Date)) {
            throw new IllegalArgumentException("Cannot convert " + obj + " of type" + obj.getClass().getName());
        }
        return m20409a((Date) obj);
    }

    /* renamed from: a */
    public String m20409a(Date date) {
        return this.f1058e.m20122a(date.getTime());
    }

    @Override // p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0486l
    /* renamed from: b */
    public boolean mo20375b(Object obj) {
        return obj instanceof Date;
    }

    /* renamed from: g */
    public String m20408g() {
        return new C0574h(this.f1057d).m20110a();
    }

    /* renamed from: h */
    public boolean m20407h() {
        return this.f1059l;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f1057d = d();
        if (this.f1057d == null) {
            this.f1057d = "yyyy-MM-dd";
        }
        List<String> e = e();
        if (e != null && e.size() > 1 && f1055b.equalsIgnoreCase(e.get(1))) {
            this.f1059l = false;
        }
        this.f1058e = new C0568b(this.f1057d);
    }
}
