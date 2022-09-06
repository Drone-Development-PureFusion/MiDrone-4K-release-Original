package p004b.p005a.p006a.p007a.p025n;

import java.net.URL;
import java.security.CodeSource;
import java.util.HashMap;
/* renamed from: b.a.a.a.n.n */
/* loaded from: classes.dex */
public class C0241n {

    /* renamed from: a */
    static final C0243p[] f395a = new C0243p[0];

    /* renamed from: b */
    HashMap<String, C0229b> f396b = new HashMap<>();

    /* renamed from: a */
    private C0229b m21202a(C0243p c0243p, ClassLoader classLoader) {
        String className = c0243p.f397a.getClassName();
        C0229b c0229b = this.f396b.get(className);
        if (c0229b != null) {
            return c0229b;
        }
        Class m21196b = m21196b(classLoader, className);
        C0229b c0229b2 = new C0229b(m21197b(m21196b), m21201a(m21196b), false);
        this.f396b.put(className, c0229b2);
        return c0229b2;
    }

    /* renamed from: a */
    private Class m21200a(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            return null;
        }
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (NoClassDefFoundError e3) {
            return null;
        }
    }

    /* renamed from: a */
    private String m21199a(String str, char c) {
        int lastIndexOf = str.lastIndexOf(c);
        if (m21205a(lastIndexOf, str)) {
            return str.substring(str.lastIndexOf(c, lastIndexOf - 1) + 1);
        }
        if (lastIndexOf <= 0) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* renamed from: a */
    private boolean m21205a(int i, String str) {
        return i != -1 && i + 1 == str.length();
    }

    /* renamed from: b */
    private Class m21196b(ClassLoader classLoader, String str) {
        Class m21200a = m21200a(classLoader, str);
        if (m21200a != null) {
            return m21200a;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != classLoader) {
            m21200a = m21200a(contextClassLoader, str);
        }
        if (m21200a != null) {
            return m21200a;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (NoClassDefFoundError e3) {
            return null;
        }
    }

    /* renamed from: a */
    String m21201a(Class cls) {
        Package r0;
        String implementationVersion;
        return (cls == null || (r0 = cls.getPackage()) == null || (implementationVersion = r0.getImplementationVersion()) == null) ? "na" : implementationVersion;
    }

    /* renamed from: a */
    void m21204a(int i, C0243p[] c0243pArr, ClassLoader classLoader) {
        int length = c0243pArr.length - i;
        for (int i2 = 0; i2 < length; i2++) {
            C0243p c0243p = c0243pArr[i2];
            c0243p.m21193a(m21202a(c0243p, classLoader));
        }
    }

    /* renamed from: a */
    public void m21203a(AbstractC0232e abstractC0232e) {
        while (abstractC0232e != null) {
            m21198a(abstractC0232e.mo21169c());
            AbstractC0232e[] mo21166f = abstractC0232e.mo21166f();
            if (mo21166f != null) {
                for (AbstractC0232e abstractC0232e2 : mo21166f) {
                    m21198a(abstractC0232e2.mo21169c());
                }
            }
            abstractC0232e = abstractC0232e.mo21167e();
        }
    }

    /* renamed from: a */
    void m21198a(C0243p[] c0243pArr) {
        int m21195a = C0242o.m21195a(new Throwable("local stack reference").getStackTrace(), c0243pArr);
        int length = c0243pArr.length - m21195a;
        for (int i = 0; i < m21195a; i++) {
            C0243p c0243p = c0243pArr[length + i];
            c0243p.m21193a(m21202a(c0243p, (ClassLoader) null));
        }
        m21204a(m21195a, c0243pArr, null);
    }

    /* renamed from: b */
    String m21197b(Class cls) {
        URL location;
        if (cls != null) {
            try {
                CodeSource codeSource = cls.getProtectionDomain().getCodeSource();
                if (codeSource != null && (location = codeSource.getLocation()) != null) {
                    String url = location.toString();
                    String m21199a = m21199a(url, '/');
                    return m21199a != null ? m21199a : m21199a(url, '\\');
                }
            } catch (Exception e) {
            }
        }
        return "na";
    }
}
