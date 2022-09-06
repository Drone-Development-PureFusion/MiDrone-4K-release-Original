package p004b.p005a.p006a.p028b.p041h.p043b;

import javax.net.ssl.SSLSocket;
/* renamed from: b.a.a.b.h.b.i */
/* loaded from: classes.dex */
public class C0387i implements AbstractC0385g {

    /* renamed from: a */
    private final SSLSocket f798a;

    public C0387i(SSLSocket sSLSocket) {
        this.f798a = sSLSocket;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: a */
    public void mo20696a(boolean z) {
        this.f798a.setNeedClientAuth(z);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: a */
    public void mo20695a(String[] strArr) {
        this.f798a.setEnabledProtocols(strArr);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: a */
    public String[] mo20697a() {
        return this.f798a.getEnabledProtocols();
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: b */
    public void mo20693b(boolean z) {
        this.f798a.setWantClientAuth(z);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: b */
    public void mo20692b(String[] strArr) {
        this.f798a.setEnabledCipherSuites(strArr);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: b */
    public String[] mo20694b() {
        return this.f798a.getSupportedProtocols();
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: c */
    public String[] mo20691c() {
        return this.f798a.getEnabledCipherSuites();
    }

    @Override // p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0385g
    /* renamed from: d */
    public String[] mo20690d() {
        return this.f798a.getSupportedCipherSuites();
    }
}
