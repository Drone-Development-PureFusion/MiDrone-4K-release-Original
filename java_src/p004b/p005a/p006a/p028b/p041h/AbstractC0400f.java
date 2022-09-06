package p004b.p005a.p006a.p028b.p041h;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f;
import p004b.p005a.p006a.p028b.p041h.p043b.C0380b;
import p004b.p005a.p006a.p028b.p041h.p043b.C0388j;
import p004b.p005a.p006a.p028b.p041h.p043b.C0391m;
/* renamed from: b.a.a.b.h.f */
/* loaded from: classes.dex */
public abstract class AbstractC0400f<E> extends AbstractRunnableC0378b<E> implements AbstractC0384f {

    /* renamed from: d */
    private C0388j f854d;

    /* renamed from: e */
    private SocketFactory f855e;

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: a */
    public void mo20588a(C0388j c0388j) {
        this.f854d = c0388j;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b
    /* renamed from: b */
    protected SocketFactory mo20587b() {
        return this.f855e;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: f */
    public C0388j mo20586f() {
        if (this.f854d == null) {
            this.f854d = new C0388j();
        }
        return this.f854d;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b, p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        try {
            SSLContext a = mo20586f().a(this);
            C0391m m20689a = mo20586f().m20689a();
            m20689a.a(h_());
            this.f855e = new C0380b(m20689a, a.getSocketFactory());
            super.mo20156j();
        } catch (Exception e) {
            a(e.getMessage(), e);
        }
    }
}
