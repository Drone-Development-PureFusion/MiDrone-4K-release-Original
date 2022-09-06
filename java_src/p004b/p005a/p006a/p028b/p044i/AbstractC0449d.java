package p004b.p005a.p006a.p028b.p044i;

import java.util.List;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
/* renamed from: b.a.a.b.i.d */
/* loaded from: classes.dex */
public abstract class AbstractC0449d<E> extends AbstractC0451f<E> implements AbstractC0526e, AbstractC0534m {

    /* renamed from: a */
    private List<String> f993a;

    /* renamed from: g */
    C0527f f994g = new C0527f(this);

    /* renamed from: h */
    protected boolean f995h = false;

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20233a(AbstractC0292f abstractC0292f) {
        this.f994g.mo20233a(abstractC0292f);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20232a(AbstractC0547g abstractC0547g) {
        this.f994g.mo20232a(abstractC0547g);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20231a(String str, Throwable th) {
        this.f994g.mo20231a(str, th);
    }

    /* renamed from: a */
    public void m20493a(List<String> list) {
        this.f993a = list;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: b */
    public void mo20229b(String str, Throwable th) {
        this.f994g.mo20229b(str, th);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20228c(String str) {
        this.f994g.mo20228c(str);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20227c(String str, Throwable th) {
        this.f994g.mo20227c(str, th);
    }

    /* renamed from: d */
    public String m20492d() {
        if (this.f993a == null || this.f993a.size() == 0) {
            return null;
        }
        return this.f993a.get(0);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: d */
    public void mo20226d(String str) {
        this.f994g.mo20226d(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public List<String> m20491e() {
        return this.f993a;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: e */
    public void mo20225e(String str) {
        this.f994g.mo20225e(str);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f995h;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: h_ */
    public AbstractC0292f mo20224h_() {
        return this.f994g.mo20224h_();
    }

    /* renamed from: j */
    public void mo20156j() {
        this.f995h = true;
    }

    /* renamed from: k */
    public void mo20155k() {
        this.f995h = false;
    }
}
