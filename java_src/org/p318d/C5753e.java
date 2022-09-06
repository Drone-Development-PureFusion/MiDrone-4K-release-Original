package org.p318d;

import java.io.Closeable;
import java.util.Map;
import org.p318d.p320b.C5737i;
import org.p318d.p320b.C5741m;
import org.p318d.p321c.C5746b;
import org.p318d.p322d.AbstractC5751c;
/* renamed from: org.d.e */
/* loaded from: classes2.dex */
public class C5753e {

    /* renamed from: a */
    static final String f23058a = "http://www.slf4j.org/codes.html#null_MDCA";

    /* renamed from: b */
    static final String f23059b = "http://www.slf4j.org/codes.html#no_static_mdc_binder";

    /* renamed from: c */
    static AbstractC5751c f23060c;

    /* renamed from: org.d.e$a */
    /* loaded from: classes2.dex */
    public static class C5755a implements Closeable {

        /* renamed from: a */
        private final String f23061a;

        private C5755a(String str) {
            this.f23061a = str;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            C5753e.m15b(this.f23061a);
        }
    }

    static {
        try {
            f23060c = m12d();
        } catch (Exception e) {
            C5741m.m123a("MDC binding unsuccessful.", e);
        } catch (NoClassDefFoundError e2) {
            f23060c = new C5737i();
            String message = e2.getMessage();
            if (message == null || !message.contains("StaticMDCBinder")) {
                throw e2;
            }
            C5741m.m119c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
            C5741m.m119c("Defaulting to no-operation MDCAdapter implementation.");
            C5741m.m119c("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
        }
    }

    private C5753e() {
    }

    /* renamed from: a */
    public static String m19a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (f23060c != null) {
            return f23060c.mo24b(str);
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    /* renamed from: a */
    public static void m20a() {
        if (f23060c == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        f23060c.mo28a();
    }

    /* renamed from: a */
    public static void m18a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (f23060c == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        f23060c.mo26a(str, str2);
    }

    /* renamed from: a */
    public static void m17a(Map<String, String> map) {
        if (f23060c == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        f23060c.mo25a(map);
    }

    /* renamed from: b */
    public static Map<String, String> m16b() {
        if (f23060c == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        return f23060c.mo23d();
    }

    /* renamed from: b */
    public static C5755a m14b(String str, String str2) {
        m18a(str, str2);
        return new C5755a(str);
    }

    /* renamed from: b */
    public static void m15b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (f23060c == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        f23060c.mo27a(str);
    }

    /* renamed from: c */
    public static AbstractC5751c m13c() {
        return f23060c;
    }

    /* renamed from: d */
    private static AbstractC5751c m12d() {
        try {
            return C5746b.getSingleton().m54a();
        } catch (NoSuchMethodError e) {
            return C5746b.f23027a.m54a();
        }
    }
}
