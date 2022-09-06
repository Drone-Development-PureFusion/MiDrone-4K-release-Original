package p004b.p005a.p006a.p028b.p057r;

import java.util.Properties;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p029a.C0268b;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0537p;
import p004b.p005a.p006a.p028b.p054o.C0539r;
import p004b.p005a.p006a.p028b.p056q.C0558b;
/* renamed from: b.a.a.b.r.u */
/* loaded from: classes.dex */
public class C0589u {

    /* renamed from: a */
    static final String f1313a = "${";

    /* renamed from: b */
    static final char f1314b = '}';

    /* renamed from: c */
    static final String f1315c = ":-";

    /* renamed from: d */
    static final int f1316d = 2;

    /* renamed from: e */
    static final int f1317e = 1;

    /* renamed from: f */
    static final int f1318f = 2;

    /* renamed from: g */
    static final String f1319g = "_IS_UNDEFINED";

    /* renamed from: a */
    public static Object m20064a(String str, Class<?> cls, AbstractC0292f abstractC0292f) {
        return m20062a(str, cls, C0585s.m20080a(abstractC0292f));
    }

    /* renamed from: a */
    public static Object m20063a(String str, Class<?> cls, AbstractC0292f abstractC0292f, Class<?> cls2, Object obj) {
        return m20061a(str, cls, C0585s.m20080a(abstractC0292f), cls2, obj);
    }

    /* renamed from: a */
    public static Object m20062a(String str, Class<?> cls, ClassLoader classLoader) {
        return m20061a(str, cls, classLoader, (Class<?>) null, (Object) null);
    }

    /* renamed from: a */
    public static Object m20061a(String str, Class<?> cls, ClassLoader classLoader, Class<?> cls2, Object obj) {
        if (str == null) {
            throw new NullPointerException();
        }
        try {
            Class<?> loadClass = classLoader.loadClass(str);
            if (!cls.isAssignableFrom(loadClass)) {
                throw new C0583q(cls, loadClass);
            }
            return cls2 == null ? loadClass.newInstance() : loadClass.getConstructor(cls2).newInstance(obj);
        } catch (C0583q e) {
            throw e;
        } catch (Throwable th) {
            throw new C0577k("Failed to instantiate type " + str, th);
        }
    }

    /* renamed from: a */
    public static String m20067a(String str) {
        try {
            return System.getenv(str);
        } catch (SecurityException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m20066a(String str, AbstractC0537p abstractC0537p) {
        return m20065a(str, abstractC0537p, (AbstractC0537p) null);
    }

    /* renamed from: a */
    public static String m20065a(String str, AbstractC0537p abstractC0537p, AbstractC0537p abstractC0537p2) {
        try {
            return C0558b.m20143a(str, abstractC0537p, abstractC0537p2);
        } catch (C0539r e) {
            throw new IllegalArgumentException("Failed to parse input [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static String m20060a(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (SecurityException e) {
            return str2;
        }
    }

    /* renamed from: a */
    public static Properties m20070a() {
        try {
            return System.getProperties();
        } catch (SecurityException e) {
            return new Properties();
        }
    }

    /* renamed from: a */
    public static void m20069a(AbstractC0526e abstractC0526e, String str, String str2) {
        try {
            System.setProperty(str, str2);
        } catch (SecurityException e) {
            abstractC0526e.mo20231a("Failed to set system property [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m20068a(AbstractC0526e abstractC0526e, Properties properties) {
        for (String str : properties.keySet()) {
            m20069a(abstractC0526e, str, properties.getProperty(str));
        }
    }

    /* renamed from: a */
    public static boolean m20059a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        String trim = str.trim();
        if ("true".equalsIgnoreCase(trim)) {
            return true;
        }
        if (!"false".equalsIgnoreCase(trim)) {
            return z;
        }
        return false;
    }

    /* renamed from: b */
    public static String m20058b(String str) {
        try {
            return C0268b.m21094a().m21092a(str, (String) null);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m20057b(String str, AbstractC0537p abstractC0537p, AbstractC0537p abstractC0537p2) {
        String mo20211a = abstractC0537p.mo20211a(str);
        if (mo20211a == null && abstractC0537p2 != null) {
            mo20211a = abstractC0537p2.mo20211a(str);
        }
        if (mo20211a == null) {
            mo20211a = m20060a(str, (String) null);
        }
        return mo20211a == null ? m20067a(str) : mo20211a;
    }

    /* renamed from: c */
    public static String m20056c(String str) {
        try {
            String property = System.getProperty(str);
            return property == null ? m20058b(str) : property;
        } catch (SecurityException e) {
            return null;
        }
    }

    /* renamed from: d */
    public static String[] m20055d(String str) {
        String[] strArr = new String[2];
        if (str != null) {
            strArr[0] = str;
            int indexOf = str.indexOf(":-");
            if (indexOf != -1) {
                strArr[0] = str.substring(0, indexOf);
                strArr[1] = str.substring(indexOf + 2);
            }
        }
        return strArr;
    }

    /* renamed from: e */
    public static boolean m20054e(String str) {
        return str == null || "".equals(str);
    }
}
