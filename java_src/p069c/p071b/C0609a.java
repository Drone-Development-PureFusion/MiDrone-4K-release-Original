package p069c.p071b;
@Deprecated
/* renamed from: c.b.a */
/* loaded from: classes.dex */
public class C0609a {
    /* renamed from: a */
    public static void m19973a(byte b, byte b2) {
        m19964a((String) null, b, b2);
    }

    /* renamed from: a */
    public static void m19972a(char c, char c2) {
        m19963a((String) null, c, c2);
    }

    /* renamed from: a */
    public static void m19971a(double d, double d2, double d3) {
        m19962a((String) null, d, d2, d3);
    }

    /* renamed from: a */
    public static void m19970a(float f, float f2, float f3) {
        m19961a((String) null, f, f2, f3);
    }

    /* renamed from: a */
    public static void m19969a(int i, int i2) {
        m19960a((String) null, i, i2);
    }

    /* renamed from: a */
    public static void m19968a(long j, long j2) {
        m19959a((String) null, j, j2);
    }

    /* renamed from: a */
    public static void m19967a(Object obj) {
        m19958a((String) null, obj);
    }

    /* renamed from: a */
    public static void m19966a(Object obj, Object obj2) {
        m19957a((String) null, obj, obj2);
    }

    /* renamed from: a */
    public static void m19965a(String str) {
        if (str == null) {
            throw new C0610b();
        }
        throw new C0610b(str);
    }

    /* renamed from: a */
    public static void m19964a(String str, byte b, byte b2) {
        m19957a(str, Byte.valueOf(b), Byte.valueOf(b2));
    }

    /* renamed from: a */
    public static void m19963a(String str, char c, char c2) {
        m19957a(str, Character.valueOf(c), Character.valueOf(c2));
    }

    /* renamed from: a */
    public static void m19962a(String str, double d, double d2, double d3) {
        if (Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3) {
            m19937e(str, new Double(d), new Double(d2));
        }
    }

    /* renamed from: a */
    public static void m19961a(String str, float f, float f2, float f3) {
        if (Float.compare(f, f2) != 0 && Math.abs(f - f2) > f3) {
            m19937e(str, new Float(f), new Float(f2));
        }
    }

    /* renamed from: a */
    public static void m19960a(String str, int i, int i2) {
        m19957a(str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: a */
    public static void m19959a(String str, long j, long j2) {
        m19957a(str, Long.valueOf(j), Long.valueOf(j2));
    }

    /* renamed from: a */
    public static void m19958a(String str, Object obj) {
        m19953a(str, obj != null);
    }

    /* renamed from: a */
    public static void m19957a(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj != null && obj.equals(obj2)) {
            return;
        }
        m19937e(str, obj, obj2);
    }

    /* renamed from: a */
    public static void m19956a(String str, String str2) {
        m19955a((String) null, str, str2);
    }

    /* renamed from: a */
    public static void m19955a(String str, String str2, String str3) {
        if (str2 == null && str3 == null) {
            return;
        }
        if (str2 != null && str2.equals(str3)) {
            return;
        }
        if (str == null) {
            str = "";
        }
        throw new C0612d(str, str2, str3);
    }

    /* renamed from: a */
    public static void m19954a(String str, short s, short s2) {
        m19957a(str, Short.valueOf(s), Short.valueOf(s2));
    }

    /* renamed from: a */
    public static void m19953a(String str, boolean z) {
        if (!z) {
            m19965a(str);
        }
    }

    /* renamed from: a */
    public static void m19952a(String str, boolean z, boolean z2) {
        m19957a(str, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static void m19951a(short s, short s2) {
        m19954a((String) null, s, s2);
    }

    /* renamed from: a */
    public static void m19950a(boolean z) {
        m19953a((String) null, z);
    }

    /* renamed from: a */
    public static void m19949a(boolean z, boolean z2) {
        m19952a((String) null, z, z2);
    }

    /* renamed from: b */
    public static void m19948b(Object obj) {
        if (obj != null) {
            m19945b("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    /* renamed from: b */
    public static void m19947b(Object obj, Object obj2) {
        m19944b(null, obj, obj2);
    }

    /* renamed from: b */
    public static void m19946b(String str) {
        m19965a((str != null ? str + " " : "") + "expected not same");
    }

    /* renamed from: b */
    public static void m19945b(String str, Object obj) {
        m19953a(str, obj == null);
    }

    /* renamed from: b */
    public static void m19944b(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        m19939d(str, obj, obj2);
    }

    /* renamed from: b */
    public static void m19943b(String str, boolean z) {
        m19953a(str, !z);
    }

    /* renamed from: b */
    public static void m19942b(boolean z) {
        m19943b((String) null, z);
    }

    /* renamed from: c */
    public static void m19941c(Object obj, Object obj2) {
        m19940c(null, obj, obj2);
    }

    /* renamed from: c */
    public static void m19940c(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            m19946b(str);
        }
    }

    /* renamed from: d */
    public static void m19939d(String str, Object obj, Object obj2) {
        m19965a((str != null ? str + " " : "") + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    /* renamed from: e */
    public static void m19938e() {
        m19965a((String) null);
    }

    /* renamed from: e */
    public static void m19937e(String str, Object obj, Object obj2) {
        m19965a(m19936f(str, obj, obj2));
    }

    /* renamed from: f */
    public static String m19936f(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && str.length() > 0) {
            str2 = str + " ";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }
}
