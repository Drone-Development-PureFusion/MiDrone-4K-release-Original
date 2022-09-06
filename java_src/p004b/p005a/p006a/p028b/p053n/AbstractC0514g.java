package p004b.p005a.p006a.p028b.p053n;

import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.AbstractC0269b;
import p004b.p005a.p006a.p028b.p057r.C0576j;
/* renamed from: b.a.a.b.n.g */
/* loaded from: classes.dex */
public abstract class AbstractC0514g<E> extends AbstractC0269b<E> {

    /* renamed from: a */
    protected C0511d<E> f1155a;

    /* renamed from: b */
    AbstractC0510c<E> f1156b;

    /* renamed from: c */
    C0576j f1157c = new C0576j(1800000);

    /* renamed from: d */
    int f1158d = Integer.MAX_VALUE;

    /* renamed from: e */
    AbstractC0513f<E> f1159e;

    /* renamed from: a */
    public C0576j m20294a() {
        return this.f1157c;
    }

    /* renamed from: a */
    public void m20293a(int i) {
        this.f1158d = i;
    }

    /* renamed from: a */
    public void m20292a(AbstractC0510c<E> abstractC0510c) {
        this.f1156b = abstractC0510c;
    }

    /* renamed from: a */
    public void mo20291a(AbstractC0513f<E> abstractC0513f) {
        this.f1159e = abstractC0513f;
    }

    /* renamed from: a */
    public void m20290a(C0576j c0576j) {
        this.f1157c = c0576j;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a */
    protected void mo20289a(E e) {
        if (!g_()) {
            return;
        }
        String mo20295a = this.f1159e.mo20295a(e);
        long mo20286c = mo20286c((AbstractC0514g<E>) e);
        AbstractC0266a<E> a = this.f1155a.a(mo20295a, mo20286c);
        if (mo20287b(e)) {
            this.f1155a.d(mo20295a);
        }
        this.f1155a.a(mo20286c);
        a.mo20162d((AbstractC0266a<E>) e);
    }

    /* renamed from: b */
    public int m20288b() {
        return this.f1158d;
    }

    /* renamed from: b */
    protected abstract boolean mo20287b(E e);

    /* renamed from: c */
    protected abstract long mo20286c(E e);

    /* renamed from: d */
    public AbstractC0513f<E> m20285d() {
        return this.f1159e;
    }

    /* renamed from: e */
    public C0511d<E> m20284e() {
        return this.f1155a;
    }

    /* renamed from: f */
    public String m20283f() {
        if (this.f1159e != null) {
            return this.f1159e.mo20296a();
        }
        return null;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        int i = 0;
        if (this.f1159e == null) {
            c("Missing discriminator. Aborting");
            i = 1;
        }
        if (!this.f1159e.g_()) {
            c("Discriminator has not started successfully. Aborting");
            i++;
        }
        if (this.f1156b == null) {
            c("AppenderFactory has not been set. Aborting");
            i++;
        } else {
            this.f1155a = new C0511d<>(this.f1190s, this.f1156b);
            this.f1155a.a(this.f1158d);
            this.f1155a.b(this.f1157c.m20105b());
        }
        if (i == 0) {
            super.mo20156j();
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        for (AbstractC0266a<E> abstractC0266a : this.f1155a.c()) {
            abstractC0266a.k();
        }
    }
}
