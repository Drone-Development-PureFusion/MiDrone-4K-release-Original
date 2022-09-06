package p004b.p005a.p006a.p028b.p054o;

import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0541a;
import p004b.p005a.p006a.p028b.p055p.C0542b;
import p004b.p005a.p006a.p028b.p055p.C0553m;
/* renamed from: b.a.a.b.o.f */
/* loaded from: classes.dex */
public class C0527f implements AbstractC0526e {

    /* renamed from: a */
    private int f1189a;

    /* renamed from: s */
    protected AbstractC0292f f1190s;

    /* renamed from: t */
    final Object f1191t;

    public C0527f() {
        this.f1189a = 0;
        this.f1191t = this;
    }

    public C0527f(AbstractC0526e abstractC0526e) {
        this.f1189a = 0;
        this.f1191t = abstractC0526e;
    }

    /* renamed from: B */
    public AbstractC0551k m20236B() {
        if (this.f1190s == null) {
            return null;
        }
        return this.f1190s.mo20997n();
    }

    /* renamed from: C */
    protected Object m20235C() {
        return this.f1191t;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20233a(AbstractC0292f abstractC0292f) {
        if (this.f1190s == null) {
            this.f1190s = abstractC0292f;
        } else if (this.f1190s == abstractC0292f) {
        } else {
            throw new IllegalStateException("Context has been already set");
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20232a(AbstractC0547g abstractC0547g) {
        if (this.f1190s != null) {
            AbstractC0551k mo20997n = this.f1190s.mo20997n();
            if (mo20997n == null) {
                return;
            }
            mo20997n.mo20188a(abstractC0547g);
            return;
        }
        int i = this.f1189a;
        this.f1189a = i + 1;
        if (i != 0) {
            return;
        }
        System.out.println("LOGBACK: No context given for " + this);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20231a(String str, Throwable th) {
        mo20232a(new C0541a(str, m20235C(), th));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: b */
    public void mo20229b(String str, Throwable th) {
        mo20232a(new C0542b(str, m20235C(), th));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20228c(String str) {
        mo20232a(new C0541a(str, m20235C()));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20227c(String str, Throwable th) {
        mo20232a(new C0553m(str, m20235C(), th));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: d */
    public void mo20226d(String str) {
        mo20232a(new C0542b(str, m20235C()));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: e */
    public void mo20225e(String str) {
        mo20232a(new C0553m(str, m20235C()));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: h_ */
    public AbstractC0292f mo20224h_() {
        return this.f1190s;
    }
}
