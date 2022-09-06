package p004b.p005a.p006a.p028b.p057r;

import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import p004b.p005a.p006a.p028b.AbstractC0292f;
/* renamed from: b.a.a.b.r.s */
/* loaded from: classes.dex */
public class C0585s {

    /* renamed from: a */
    static final String f1306a = "Caught Exception while in Loader.getResource. This may be innocuous.";

    /* renamed from: b */
    public static final String f1307b = "logback.ignoreTCL";

    /* renamed from: c */
    private static boolean f1308c;

    /* renamed from: d */
    private static boolean f1309d;

    static {
        f1308c = false;
        f1309d = false;
        String m20060a = C0589u.m20060a(f1307b, (String) null);
        if (m20060a != null) {
            f1308c = Boolean.valueOf(m20060a).booleanValue();
        }
        f1309d = ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: b.a.a.b.r.s.1
            @Override // java.security.PrivilegedAction
            /* renamed from: a */
            public Boolean run() {
                try {
                    AccessController.checkPermission(new RuntimePermission("getClassLoader"));
                    return true;
                } catch (SecurityException e) {
                    return false;
                }
            }
        })).booleanValue();
    }

    /* renamed from: a */
    public static Class<?> m20078a(String str, AbstractC0292f abstractC0292f) {
        return m20080a(abstractC0292f).loadClass(str);
    }

    /* renamed from: a */
    public static ClassLoader m20082a() {
        return Thread.currentThread().getContextClassLoader();
    }

    /* renamed from: a */
    public static ClassLoader m20081a(final Class<?> cls) {
        if (!f1309d) {
            return null;
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: b.a.a.b.r.s.2
            @Override // java.security.PrivilegedAction
            /* renamed from: a */
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    /* renamed from: a */
    public static ClassLoader m20080a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        return m20076b(obj.getClass());
    }

    /* renamed from: a */
    public static URL m20079a(String str) {
        return m20074b(str, m20076b(C0585s.class));
    }

    /* renamed from: a */
    public static Set<URL> m20077a(String str, ClassLoader classLoader) {
        HashSet hashSet = new HashSet();
        Enumeration<URL> resources = classLoader.getResources(str);
        while (resources.hasMoreElements()) {
            hashSet.add(resources.nextElement());
        }
        return hashSet;
    }

    /* renamed from: b */
    public static Class<?> m20075b(String str) {
        if (f1308c) {
            return Class.forName(str);
        }
        try {
            return m20082a().loadClass(str);
        } catch (Throwable th) {
            return Class.forName(str);
        }
    }

    /* renamed from: b */
    public static ClassLoader m20076b(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    /* renamed from: b */
    public static URL m20074b(String str, ClassLoader classLoader) {
        try {
            return classLoader.getResource(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
