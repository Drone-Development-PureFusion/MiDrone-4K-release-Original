package p004b.p005a.p006a.p028b.p041h.p042a;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f;
import p004b.p005a.p006a.p028b.p041h.p043b.C0379a;
import p004b.p005a.p006a.p028b.p041h.p043b.C0388j;
import p004b.p005a.p006a.p028b.p041h.p043b.C0391m;
/* renamed from: b.a.a.b.h.a.i */
/* loaded from: classes.dex */
public abstract class AbstractC0372i<E> extends AbstractC0361a<E> implements AbstractC0384f {

    /* renamed from: c */
    private C0388j f754c;

    /* renamed from: d */
    private ServerSocketFactory f755d;

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: a */
    public void mo20588a(C0388j c0388j) {
        this.f754c = c0388j;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0361a
    /* renamed from: d */
    protected ServerSocketFactory mo20756d() {
        return this.f755d;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: f */
    public C0388j mo20586f() {
        if (this.f754c == null) {
            this.f754c = new C0388j();
        }
        return this.f754c;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0361a, p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        try {
            SSLContext a = mo20586f().a(this);
            C0391m m20689a = mo20586f().m20689a();
            m20689a.a(h_());
            this.f755d = new C0379a(m20689a, a.getServerSocketFactory());
            super.mo20156j();
        } catch (Exception e) {
            a(e.getMessage(), e);
        }
    }
}
