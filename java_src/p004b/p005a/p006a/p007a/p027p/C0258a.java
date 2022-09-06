package p004b.p005a.p006a.p007a.p027p;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p015g.C0157a;
import p004b.p005a.p006a.p028b.p029a.AbstractC0267a;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0542b;
import p004b.p005a.p006a.p028b.p057r.C0585s;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.p.a */
/* loaded from: classes.dex */
public class C0258a {

    /* renamed from: a */
    public static final String f452a = "logback.xml";

    /* renamed from: b */
    public static final String f453b = "logback.configurationFile";

    /* renamed from: c */
    public static final String f454c = "logback.statusListenerClass";

    /* renamed from: f */
    private static final String f455f = AbstractC0267a.m21095c();

    /* renamed from: d */
    final ClassLoader f456d = C0585s.m20080a(this);

    /* renamed from: e */
    final C0151f f457e;

    public C0258a(C0151f c0151f) {
        this.f457e = c0151f;
    }

    /* renamed from: a */
    private InputStream m21120a(String str, ClassLoader classLoader, boolean z) {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (z) {
            String str2 = null;
            if (resourceAsStream != null) {
                str2 = str;
            }
            m21121a(str, classLoader, str2);
        }
        return resourceAsStream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* renamed from: a */
    private URL m21119a(boolean z) {
        URL url;
        String str = 0;
        String str2 = null;
        String str3 = null;
        String m20056c = C0589u.m20056c(f453b);
        try {
            if (m20056c != null) {
                try {
                    File file = new File(m20056c);
                    if (!file.exists() || !file.isFile()) {
                        url = new URL(m20056c);
                    } else {
                        if (z) {
                            m21121a(m20056c, this.f456d, m20056c);
                        }
                        url = file.toURI().toURL();
                    }
                    if (!z) {
                        return url;
                    }
                    ClassLoader classLoader = this.f456d;
                    if (url != null) {
                        str2 = url.toString();
                    }
                    m21121a(m20056c, classLoader, str2);
                    return url;
                } catch (MalformedURLException e) {
                    URL m20074b = C0585s.m20074b(m20056c, this.f456d);
                    if (m20074b != null) {
                        if (!z) {
                            return m20074b;
                        }
                        ClassLoader classLoader2 = this.f456d;
                        if (m20074b != null) {
                            str3 = m20074b.toString();
                        }
                        m21121a(m20056c, classLoader2, str3);
                        return m20074b;
                    } else if (z) {
                        m21121a(m20056c, this.f456d, m20074b != null ? m20074b.toString() : null);
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            if (z) {
                ClassLoader classLoader3 = this.f456d;
                if (0 != 0) {
                    str = str.toString();
                }
                m21121a(m20056c, classLoader3, str);
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m21121a(String str, ClassLoader classLoader, String str2) {
        AbstractC0551k n = this.f457e.n();
        if (str2 == null) {
            n.mo20188a(new C0542b("Could NOT find resource [" + str + "]", this.f457e));
        } else {
            n.mo20188a(new C0542b("Found resource [" + str + "] at [" + str2 + "]", this.f457e));
        }
    }

    /* renamed from: b */
    private InputStream m21118b(boolean z) {
        return m21120a(f455f + "/" + f452a, this.f456d, z);
    }

    /* renamed from: a */
    public void m21122a() {
        InputStream m21118b;
        C0265h.m21103a(this.f457e);
        boolean z = false;
        C0157a c0157a = new C0157a();
        c0157a.a(this.f457e);
        URL m21119a = m21119a(true);
        if (m21119a != null) {
            c0157a.a(m21119a);
            z = true;
        }
        if (z || (m21118b = m21118b(true)) == null) {
            return;
        }
        c0157a.a(m21118b);
    }
}
