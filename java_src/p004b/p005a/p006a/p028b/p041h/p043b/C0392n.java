package p004b.p005a.p006a.p028b.p041h.p043b;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
/* renamed from: b.a.a.b.h.b.n */
/* loaded from: classes.dex */
public class C0392n {

    /* renamed from: a */
    private String f817a;

    /* renamed from: b */
    private String f818b;

    /* renamed from: a */
    public SecureRandom m20649a() {
        try {
            return m20645c() != null ? SecureRandom.getInstance(m20647b(), m20645c()) : SecureRandom.getInstance(m20647b());
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("no such secure random algorithm: " + m20647b());
        } catch (NoSuchProviderException e2) {
            throw new NoSuchProviderException("no such secure random provider: " + m20645c());
        }
    }

    /* renamed from: a */
    public void m20648a(String str) {
        this.f817a = str;
    }

    /* renamed from: b */
    public String m20647b() {
        return this.f817a == null ? AbstractC0383e.f796d : this.f817a;
    }

    /* renamed from: b */
    public void m20646b(String str) {
        this.f818b = str;
    }

    /* renamed from: c */
    public String m20645c() {
        return this.f818b;
    }
}
