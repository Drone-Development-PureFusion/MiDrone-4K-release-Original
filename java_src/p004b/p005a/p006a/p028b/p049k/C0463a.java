package p004b.p005a.p006a.p028b.p049k;

import p004b.p005a.p006a.p028b.AbstractC0269b;
import p004b.p005a.p006a.p028b.p033e.C0288a;
/* renamed from: b.a.a.b.k.a */
/* loaded from: classes.dex */
public class C0463a<E> extends AbstractC0269b<E> {

    /* renamed from: a */
    C0288a<E> f1022a;

    /* renamed from: b */
    int f1023b = 512;

    /* renamed from: a */
    public int m20441a() {
        if (g_()) {
            return this.f1022a.m21026e();
        }
        return 0;
    }

    /* renamed from: a */
    public E m20440a(int i) {
        if (g_()) {
            return this.f1022a.m21033a(i);
        }
        return null;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a */
    protected void mo20289a(E e) {
        if (!g_()) {
            return;
        }
        this.f1022a.m21032a((C0288a<E>) e);
    }

    /* renamed from: b */
    public void m20439b() {
        this.f1022a.m21034a();
    }

    /* renamed from: b */
    public void m20438b(int i) {
        this.f1023b = i;
    }

    /* renamed from: d */
    public int m20437d() {
        return this.f1023b;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f1022a = new C0288a<>(this.f1023b);
        super.mo20156j();
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f1022a = null;
        super.mo20155k();
    }
}
