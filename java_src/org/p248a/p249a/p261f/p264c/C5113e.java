package org.p248a.p249a.p261f.p264c;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.p248a.p249a.p282o.C5351a;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: org.a.a.f.c.e */
/* loaded from: classes2.dex */
public final class C5113e {

    /* renamed from: a */
    private final String f21738a;

    /* renamed from: b */
    private final X509Certificate[] f21739b;

    public C5113e(String str, X509Certificate[] x509CertificateArr) {
        this.f21738a = (String) C5351a.m1321a(str, "Private key type");
        this.f21739b = x509CertificateArr;
    }

    /* renamed from: a */
    public String m1996a() {
        return this.f21738a;
    }

    /* renamed from: b */
    public X509Certificate[] m1995b() {
        return this.f21739b;
    }

    public String toString() {
        return this.f21738a + C0359h.f671A + Arrays.toString(this.f21739b);
    }
}
