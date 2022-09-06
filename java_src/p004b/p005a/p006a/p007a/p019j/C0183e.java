package p004b.p005a.p006a.p007a.p019j;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f;
import p004b.p005a.p006a.p028b.p041h.p043b.C0380b;
import p004b.p005a.p006a.p028b.p041h.p043b.C0388j;
import p004b.p005a.p006a.p028b.p041h.p043b.C0391m;
/* renamed from: b.a.a.a.j.e */
/* loaded from: classes.dex */
public class C0183e extends RunnableC0188j implements AbstractC0384f {

    /* renamed from: a */
    private C0388j f286a;

    /* renamed from: b */
    private SocketFactory f287b;

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: a */
    public void mo20588a(C0388j c0388j) {
        this.f286a = c0388j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p007a.p019j.RunnableC0188j, p004b.p005a.p006a.p007a.p019j.AbstractC0180b
    /* renamed from: a */
    public boolean mo21337a() {
        try {
            SSLContext a = mo20586f().a(this);
            C0391m m20689a = mo20586f().m20689a();
            m20689a.a(h_());
            this.f287b = new C0380b(m20689a, a.getSocketFactory());
            return super.mo21337a();
        } catch (Exception e) {
            a(e.getMessage(), e);
            return false;
        }
    }

    @Override // p004b.p005a.p006a.p007a.p019j.RunnableC0188j
    /* renamed from: e */
    protected SocketFactory mo21326e() {
        return this.f287b;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: f */
    public C0388j mo20586f() {
        if (this.f286a == null) {
            this.f286a = new C0388j();
        }
        return this.f286a;
    }
}
