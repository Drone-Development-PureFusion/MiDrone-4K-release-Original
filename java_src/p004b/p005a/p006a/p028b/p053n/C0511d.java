package p004b.p005a.p006a.p028b.p053n;

import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p033e.C0289b;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
import p004b.p005a.p006a.p028b.p054o.C0528g;
/* renamed from: b.a.a.b.n.d */
/* loaded from: classes.dex */
public class C0511d<E> extends AbstractC0517a<AbstractC0266a<E>> {

    /* renamed from: a */
    int f1150a = 0;

    /* renamed from: b */
    final AbstractC0292f f1151b;

    /* renamed from: c */
    final AbstractC0510c<E> f1152c;

    /* renamed from: d */
    final C0528g f1153d;

    public C0511d(AbstractC0292f abstractC0292f, AbstractC0510c<E> abstractC0510c) {
        this.f1151b = abstractC0292f;
        this.f1152c = abstractC0510c;
        this.f1153d = new C0528g(abstractC0292f, this);
    }

    /* renamed from: e */
    private C0289b<E> m20297e(String str) {
        if (this.f1150a < 4) {
            this.f1150a++;
            this.f1153d.mo20228c("Building NOPAppender for discriminating value [" + str + "]");
        }
        C0289b<E> c0289b = new C0289b<>();
        c0289b.a(this.f1151b);
        c0289b.j();
        return c0289b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a
    /* renamed from: a */
    public AbstractC0266a<E> mo20217b(String str) {
        AbstractC0266a<E> abstractC0266a = null;
        try {
            abstractC0266a = this.f1152c.mo20301a(this.f1151b, str);
        } catch (C0346m e) {
            this.f1153d.mo20228c("Error while building appender with discriminating value [" + str + "]");
        }
        return abstractC0266a == null ? m20297e(str) : abstractC0266a;
    }

    /* renamed from: a */
    protected void m20300a(AbstractC0266a<E> abstractC0266a) {
        abstractC0266a.k();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a
    /* renamed from: a */
    protected /* synthetic */ boolean mo20222a(Object obj) {
        return m20298b((AbstractC0266a) ((AbstractC0266a) obj));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a
    /* renamed from: b */
    protected /* synthetic */ void mo20218b(Object obj) {
        m20300a((AbstractC0266a) ((AbstractC0266a) obj));
    }

    /* renamed from: b */
    protected boolean m20298b(AbstractC0266a<E> abstractC0266a) {
        return !abstractC0266a.g_();
    }
}
