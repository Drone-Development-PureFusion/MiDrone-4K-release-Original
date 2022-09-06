package org.p248a.p249a.p261f.p264c;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.f.c.i */
/* loaded from: classes2.dex */
public class C5119i {
    /* renamed from: a */
    public static SSLContext m1975a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance(C5115g.f21740a);
            sSLContext.init(null, null, null);
            return sSLContext;
        } catch (KeyManagementException e) {
            throw new C5120j(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new C5120j(e2.getMessage(), e2);
        }
    }

    /* renamed from: b */
    public static SSLContext m1974b() {
        try {
            return SSLContext.getInstance("Default");
        } catch (NoSuchAlgorithmException e) {
            return m1975a();
        }
    }

    /* renamed from: c */
    public static C5116h m1973c() {
        return new C5116h();
    }
}
