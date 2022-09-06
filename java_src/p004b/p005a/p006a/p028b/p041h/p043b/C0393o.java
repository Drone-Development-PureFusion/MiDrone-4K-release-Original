package p004b.p005a.p006a.p028b.p041h.p043b;

import javax.net.ssl.TrustManagerFactory;
/* renamed from: b.a.a.b.h.b.o */
/* loaded from: classes.dex */
public class C0393o {

    /* renamed from: a */
    private String f819a;

    /* renamed from: b */
    private String f820b;

    /* renamed from: a */
    public TrustManagerFactory m20644a() {
        return m20640c() != null ? TrustManagerFactory.getInstance(m20642b(), m20640c()) : TrustManagerFactory.getInstance(m20642b());
    }

    /* renamed from: a */
    public void m20643a(String str) {
        this.f819a = str;
    }

    /* renamed from: b */
    public String m20642b() {
        return this.f819a == null ? TrustManagerFactory.getDefaultAlgorithm() : this.f819a;
    }

    /* renamed from: b */
    public void m20641b(String str) {
        this.f820b = str;
    }

    /* renamed from: c */
    public String m20640c() {
        return this.f820b;
    }
}
