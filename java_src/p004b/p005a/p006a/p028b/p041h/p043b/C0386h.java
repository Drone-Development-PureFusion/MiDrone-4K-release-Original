package p004b.p005a.p006a.p028b.p041h.p043b;

import javax.net.ssl.SSLServerSocket;
/* renamed from: b.a.a.b.h.b.h */
/* loaded from: classes.dex */
public class C0386h implements AbstractC0385g {

    /* renamed from: a */
    private final SSLServerSocket f797a;

    public C0386h(SSLServerSocket sSLServerSocket) {
        this.f797a = sSLServerSocket;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: a */
    public void mo20696a(boolean z) {
        this.f797a.setNeedClientAuth(z);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: a */
    public void mo20695a(String[] strArr) {
        this.f797a.setEnabledProtocols(strArr);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: a */
    public String[] mo20697a() {
        return this.f797a.getEnabledProtocols();
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: b */
    public void mo20693b(boolean z) {
        this.f797a.setWantClientAuth(z);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: b */
    public void mo20692b(String[] strArr) {
        this.f797a.setEnabledCipherSuites(strArr);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: b */
    public String[] mo20694b() {
        return this.f797a.getSupportedProtocols();
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: c */
    public String[] mo20691c() {
        return this.f797a.getEnabledCipherSuites();
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: d */
    public String[] mo20690d() {
        return this.f797a.getSupportedCipherSuites();
    }
}
