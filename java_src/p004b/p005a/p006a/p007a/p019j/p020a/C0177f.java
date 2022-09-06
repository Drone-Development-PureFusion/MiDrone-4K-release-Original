package p004b.p005a.p006a.p007a.p019j.p020a;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f;
import p004b.p005a.p006a.p028b.p041h.p043b.C0379a;
import p004b.p005a.p006a.p028b.p041h.p043b.C0388j;
import p004b.p005a.p006a.p028b.p041h.p043b.C0391m;
/* renamed from: b.a.a.a.j.a.f */
/* loaded from: classes.dex */
public class C0177f extends C0179h implements AbstractC0384f {

    /* renamed from: b */
    private C0388j f271b;

    /* renamed from: c */
    private ServerSocketFactory f272c;

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: a */
    public void mo20588a(C0388j c0388j) {
        this.f271b = c0388j;
    }

    @Override // p004b.p005a.p006a.p007a.p019j.p020a.C0179h
    /* renamed from: e */
    protected ServerSocketFactory mo21367e() {
        if (this.f272c == null) {
            SSLContext a = mo20586f().a(this);
            C0391m m20689a = mo20586f().m20689a();
            m20689a.a(h_());
            this.f272c = new C0379a(m20689a, a.getServerSocketFactory());
        }
        return this.f272c;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0384f
    /* renamed from: f */
    public C0388j mo20586f() {
        if (this.f271b == null) {
            this.f271b = new C0388j();
        }
        return this.f271b;
    }
}
