package p004b.p005a.p006a.p028b.p054o;

import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0541a;
import p004b.p005a.p006a.p028b.p055p.C0542b;
import p004b.p005a.p006a.p028b.p055p.C0553m;
/* renamed from: b.a.a.b.o.g */
/* loaded from: classes.dex */
public class C0528g implements AbstractC0526e {

    /* renamed from: a */
    protected AbstractC0292f f1192a;

    /* renamed from: b */
    final Object f1193b;

    /* renamed from: c */
    private int f1194c = 0;

    public C0528g(AbstractC0292f abstractC0292f, Object obj) {
        this.f1192a = abstractC0292f;
        this.f1193b = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo20234a() {
        return this.f1193b;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20233a(AbstractC0292f abstractC0292f) {
        if (this.f1192a == null) {
            this.f1192a = abstractC0292f;
        } else if (this.f1192a == abstractC0292f) {
        } else {
            throw new IllegalStateException("Context has been already set");
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20232a(AbstractC0547g abstractC0547g) {
        if (this.f1192a != null) {
            AbstractC0551k mo20997n = this.f1192a.mo20997n();
            if (mo20997n == null) {
                return;
            }
            mo20997n.mo20188a(abstractC0547g);
            return;
        }
        int i = this.f1194c;
        this.f1194c = i + 1;
        if (i != 0) {
            return;
        }
        System.out.println("LOGBACK: No context given for " + this);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20231a(String str, Throwable th) {
        mo20232a(new C0541a(str, mo20234a(), th));
    }

    /* renamed from: b */
    public AbstractC0551k m20230b() {
        if (this.f1192a == null) {
            return null;
        }
        return this.f1192a.mo20997n();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: b */
    public void mo20229b(String str, Throwable th) {
        mo20232a(new C0542b(str, mo20234a(), th));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20228c(String str) {
        mo20232a(new C0541a(str, mo20234a()));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20227c(String str, Throwable th) {
        mo20232a(new C0553m(str, mo20234a(), th));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: d */
    public void mo20226d(String str) {
        mo20232a(new C0542b(str, mo20234a()));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: e */
    public void mo20225e(String str) {
        mo20232a(new C0553m(str, mo20234a()));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: h_ */
    public AbstractC0292f mo20224h_() {
        return this.f1192a;
    }
}
