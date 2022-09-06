package p004b.p005a.p006a.p028b.p041h.p043b;

import javax.net.ssl.KeyManagerFactory;
/* renamed from: b.a.a.b.h.b.c */
/* loaded from: classes.dex */
public class C0381c {

    /* renamed from: a */
    private String f787a;

    /* renamed from: b */
    private String f788b;

    /* renamed from: a */
    public KeyManagerFactory m20712a() {
        return m20708c() != null ? KeyManagerFactory.getInstance(m20710b(), m20708c()) : KeyManagerFactory.getInstance(m20710b());
    }

    /* renamed from: a */
    public void m20711a(String str) {
        this.f787a = str;
    }

    /* renamed from: b */
    public String m20710b() {
        return this.f787a == null ? KeyManagerFactory.getDefaultAlgorithm() : this.f787a;
    }

    /* renamed from: b */
    public void m20709b(String str) {
        this.f788b = str;
    }

    /* renamed from: c */
    public String m20708c() {
        return this.f788b;
    }
}
