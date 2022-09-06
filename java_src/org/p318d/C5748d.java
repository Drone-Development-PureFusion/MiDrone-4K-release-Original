package org.p318d;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.p318d.p319a.C5726e;
import org.p318d.p320b.C5736h;
import org.p318d.p320b.C5739k;
import org.p318d.p320b.C5740l;
import org.p318d.p320b.C5741m;
import org.p318d.p321c.C5745a;
/* renamed from: org.d.d */
/* loaded from: classes2.dex */
public final class C5748d {

    /* renamed from: a */
    static final String f23030a = "http://www.slf4j.org/codes.html";

    /* renamed from: b */
    static final String f23031b = "http://www.slf4j.org/codes.html#StaticLoggerBinder";

    /* renamed from: c */
    static final String f23032c = "http://www.slf4j.org/codes.html#multiple_bindings";

    /* renamed from: d */
    static final String f23033d = "http://www.slf4j.org/codes.html#null_LF";

    /* renamed from: e */
    static final String f23034e = "http://www.slf4j.org/codes.html#version_mismatch";

    /* renamed from: f */
    static final String f23035f = "http://www.slf4j.org/codes.html#substituteLogger";

    /* renamed from: g */
    static final String f23036g = "http://www.slf4j.org/codes.html#loggerNameMismatch";

    /* renamed from: h */
    static final String f23037h = "http://www.slf4j.org/codes.html#replay";

    /* renamed from: i */
    static final String f23038i = "http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: j */
    static final String f23039j = "org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: k */
    static final int f23040k = 0;

    /* renamed from: l */
    static final int f23041l = 1;

    /* renamed from: m */
    static final int f23042m = 2;

    /* renamed from: n */
    static final int f23043n = 3;

    /* renamed from: o */
    static final int f23044o = 4;

    /* renamed from: t */
    static final String f23049t = "java.vendor.url";

    /* renamed from: p */
    static volatile int f23045p = 0;

    /* renamed from: q */
    static C5740l f23046q = new C5740l();

    /* renamed from: r */
    static C5736h f23047r = new C5736h();

    /* renamed from: s */
    static final String f23048s = "slf4j.detectLoggerNameMismatch";

    /* renamed from: u */
    static boolean f23050u = C5741m.m121b(f23048s);

    /* renamed from: v */
    private static final String[] f23051v = {"1.6", "1.7"};

    /* renamed from: w */
    private static String f23052w = "org/slf4j/impl/StaticLoggerBinder.class";

    private C5748d() {
    }

    /* renamed from: a */
    public static AbstractC5744c m50a(Class<?> cls) {
        Class<?> m125a;
        AbstractC5744c m48a = m48a(cls.getName());
        if (f23050u && (m125a = C5741m.m125a()) != null && m49a(cls, m125a)) {
            C5741m.m119c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", m48a.mo88d(), m125a.getName()));
            C5741m.m119c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return m48a;
    }

    /* renamed from: a */
    public static AbstractC5744c m48a(String str) {
        return m40c().mo126e(str);
    }

    /* renamed from: a */
    static void m52a() {
        f23045p = 0;
    }

    /* renamed from: a */
    private static void m51a(int i) {
        C5741m.m119c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        C5741m.m119c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        C5741m.m119c("See also http://www.slf4j.org/codes.html#replay");
    }

    /* renamed from: a */
    static void m47a(Throwable th) {
        f23045p = 2;
        C5741m.m123a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* renamed from: a */
    private static void m45a(C5726e c5726e) {
        if (c5726e == null) {
            return;
        }
        C5739k m167i = c5726e.m167i();
        String mo88d = m167i.mo88d();
        if (m167i.m134c()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (m167i.m133e()) {
            return;
        }
        if (m167i.m135b()) {
            m167i.m137a(c5726e);
        } else {
            C5741m.m119c(mo88d);
        }
    }

    /* renamed from: a */
    private static void m44a(C5726e c5726e, int i) {
        if (c5726e.m167i().m135b()) {
            m51a(i);
        } else if (c5726e.m167i().m133e()) {
        } else {
            m34h();
        }
    }

    /* renamed from: a */
    private static boolean m49a(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    /* renamed from: a */
    private static boolean m46a(Set<URL> set) {
        return set.size() > 1;
    }

    /* renamed from: b */
    static Set<URL> m43b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = C5748d.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f23052w) : classLoader.getResources(f23052w);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e) {
            C5741m.m123a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    /* renamed from: b */
    private static void m41b(Set<URL> set) {
        if (m46a(set)) {
            C5741m.m119c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it2 = set.iterator();
            while (it2.hasNext()) {
                C5741m.m119c("Found binding in [" + it2.next() + "]");
            }
            C5741m.m119c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /* renamed from: b */
    private static boolean m42b(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    /* renamed from: c */
    public static AbstractC5721a m40c() {
        if (f23045p == 0) {
            synchronized (C5748d.class) {
                if (f23045p == 0) {
                    f23045p = 1;
                    m38d();
                }
            }
        }
        switch (f23045p) {
            case 1:
                return f23046q;
            case 2:
                throw new IllegalStateException(f23039j);
            case 3:
                return C5745a.m57a().mo30d();
            case 4:
                return f23047r;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }

    /* renamed from: c */
    private static void m39c(Set<URL> set) {
        if (set == null || !m46a(set)) {
            return;
        }
        C5741m.m119c("Actual binding is of type [" + C5745a.m57a().mo29e() + "]");
    }

    /* renamed from: d */
    private static final void m38d() {
        m37e();
        if (f23045p == 3) {
            m33i();
        }
    }

    /* renamed from: e */
    private static final void m37e() {
        Set<URL> set = null;
        try {
            if (!m32j()) {
                set = m43b();
                m41b(set);
            }
            C5745a.m57a();
            f23045p = 3;
            m39c(set);
            m36f();
            m35g();
            f23046q.m127e();
        } catch (Exception e) {
            m47a(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        } catch (NoClassDefFoundError e2) {
            if (!m42b(e2.getMessage())) {
                m47a(e2);
                throw e2;
            }
            f23045p = 4;
            C5741m.m119c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            C5741m.m119c("Defaulting to no-operation (NOP) logger implementation");
            C5741m.m119c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f23045p = 2;
                C5741m.m119c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                C5741m.m119c("Your binding is version 1.5.5 or earlier.");
                C5741m.m119c("Upgrade your binding to version 1.6.x.");
            }
            throw e3;
        }
    }

    /* renamed from: f */
    private static void m36f() {
        synchronized (f23046q) {
            f23046q.m128d();
            for (C5739k c5739k : f23046q.m130b()) {
                c5739k.m136a(m48a(c5739k.mo88d()));
            }
        }
    }

    /* renamed from: g */
    private static void m35g() {
        LinkedBlockingQueue<C5726e> m129c = f23046q.m129c();
        int size = m129c.size();
        int i = 0;
        ArrayList<C5726e> arrayList = new ArrayList(128);
        while (m129c.drainTo(arrayList, 128) != 0) {
            int i2 = i;
            for (C5726e c5726e : arrayList) {
                m45a(c5726e);
                int i3 = i2 + 1;
                if (i2 == 0) {
                    m44a(c5726e, size);
                }
                i2 = i3;
            }
            arrayList.clear();
            i = i2;
        }
    }

    /* renamed from: h */
    private static void m34h() {
        C5741m.m119c("The following set of substitute loggers may have been accessed");
        C5741m.m119c("during the initialization phase. Logging calls during this");
        C5741m.m119c("phase were not honored. However, subsequent logging calls to these");
        C5741m.m119c("loggers will work as normally expected.");
        C5741m.m119c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* renamed from: i */
    private static final void m33i() {
        boolean z = false;
        try {
            String str = C5745a.f23020a;
            for (String str2 : f23051v) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            C5741m.m119c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f23051v).toString());
            C5741m.m119c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError e) {
        } catch (Throwable th) {
            C5741m.m123a("Unexpected problem occured during version sanity check", th);
        }
    }

    /* renamed from: j */
    private static boolean m32j() {
        String m124a = C5741m.m124a(f23049t);
        if (m124a == null) {
            return false;
        }
        return m124a.toLowerCase().contains("android");
    }
}
