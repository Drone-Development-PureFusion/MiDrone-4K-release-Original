package p004b.p005a.p006a.p028b;

import java.util.List;
import p004b.p005a.p006a.p028b.p032d.AbstractC0286c;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p054o.C0532k;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.C0553m;
/* renamed from: b.a.a.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC0269b<E> extends C0527f implements AbstractC0266a<E> {

    /* renamed from: h */
    static final int f470h = 5;

    /* renamed from: g */
    protected String f476g;

    /* renamed from: f */
    protected boolean f475f = false;

    /* renamed from: a */
    private boolean f471a = false;

    /* renamed from: b */
    private C0532k<E> f472b = new C0532k<>();

    /* renamed from: c */
    private int f473c = 0;

    /* renamed from: d */
    private int f474d = 0;

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: a */
    public void mo20165a(AbstractC0286c<E> abstractC0286c) {
        this.f472b.mo20165a(abstractC0286c);
    }

    /* renamed from: a */
    protected abstract void mo20289a(E e);

    @Override // p004b.p005a.p006a.p028b.AbstractC0266a
    /* renamed from: b_ */
    public void mo20163b_(String str) {
        this.f476g = str;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0266a
    /* renamed from: d */
    public synchronized void mo20162d(E e) {
        if (!this.f471a) {
            try {
                this.f471a = true;
                if (!this.f475f) {
                    int i = this.f473c;
                    this.f473c = i + 1;
                    if (i < 5) {
                        a((AbstractC0547g) new C0553m("Attempted to append to non started appender [" + this.f476g + "].", this));
                    }
                    this.f471a = false;
                } else if (mo20161e((AbstractC0269b<E>) e) == EnumC0533l.DENY) {
                    this.f471a = false;
                } else {
                    mo20289a((AbstractC0269b<E>) e);
                    this.f471a = false;
                }
            } catch (Exception e2) {
                int i2 = this.f474d;
                this.f474d = i2 + 1;
                if (i2 < 5) {
                    a("Appender [" + this.f476g + "] failed to append.", e2);
                }
                this.f471a = false;
            }
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: e */
    public EnumC0533l mo20161e(E e) {
        return this.f472b.mo20161e(e);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: f_ */
    public List<AbstractC0286c<E>> mo20160f_() {
        return this.f472b.mo20160f_();
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0266a
    /* renamed from: g */
    public String mo20159g() {
        return this.f476g;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f475f;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: h */
    public void mo20157h() {
        this.f472b.mo20157h();
    }

    /* renamed from: j */
    public void mo20156j() {
        this.f475f = true;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f475f = false;
    }

    public String toString() {
        return getClass().getName() + "[" + this.f476g + "]";
    }
}
