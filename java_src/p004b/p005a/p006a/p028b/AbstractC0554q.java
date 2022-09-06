package p004b.p005a.p006a.p028b;

import java.util.List;
import p004b.p005a.p006a.p028b.p032d.AbstractC0286c;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p054o.C0532k;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.C0553m;
/* renamed from: b.a.a.b.q */
/* loaded from: classes.dex */
public abstract class AbstractC0554q<E> extends C0527f implements AbstractC0266a<E> {

    /* renamed from: l */
    static final int f1219l = 3;

    /* renamed from: k */
    protected String f1225k;

    /* renamed from: j */
    protected boolean f1224j = false;

    /* renamed from: a */
    private ThreadLocal<Boolean> f1220a = new ThreadLocal<>();

    /* renamed from: b */
    private C0532k<E> f1221b = new C0532k<>();

    /* renamed from: c */
    private int f1222c = 0;

    /* renamed from: d */
    private int f1223d = 0;

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: a */
    public void mo20165a(AbstractC0286c<E> abstractC0286c) {
        this.f1221b.mo20165a(abstractC0286c);
    }

    /* renamed from: a */
    protected abstract void mo20164a(E e);

    @Override // p004b.p005a.p006a.p028b.AbstractC0266a
    /* renamed from: b_ */
    public void mo20163b_(String str) {
        this.f1225k = str;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0266a
    /* renamed from: d */
    public void mo20162d(E e) {
        try {
            if (Boolean.TRUE.equals(this.f1220a.get())) {
                return;
            }
            this.f1220a.set(Boolean.TRUE);
            if (this.f1224j) {
                if (mo20161e((AbstractC0554q<E>) e) == EnumC0533l.DENY) {
                    return;
                }
                mo20164a((AbstractC0554q<E>) e);
                return;
            }
            int i = this.f1222c;
            this.f1222c = i + 1;
            if (i < 3) {
                a((AbstractC0547g) new C0553m("Attempted to append to non started appender [" + this.f1225k + "].", this));
            }
        } catch (Exception e2) {
            int i2 = this.f1223d;
            this.f1223d = i2 + 1;
            if (i2 < 3) {
                a("Appender [" + this.f1225k + "] failed to append.", e2);
            }
        } finally {
            this.f1220a.set(Boolean.FALSE);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: e */
    public EnumC0533l mo20161e(E e) {
        return this.f1221b.mo20161e(e);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: f_ */
    public List<AbstractC0286c<E>> mo20160f_() {
        return this.f1221b.mo20160f_();
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0266a
    /* renamed from: g */
    public String mo20159g() {
        return this.f1225k;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f1224j;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: h */
    public void mo20157h() {
        this.f1221b.mo20157h();
    }

    /* renamed from: j */
    public void mo20156j() {
        this.f1224j = true;
    }

    /* renamed from: k */
    public void mo20155k() {
        this.f1224j = false;
    }

    public String toString() {
        return getClass().getName() + "[" + this.f1225k + "]";
    }
}
