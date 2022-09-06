package org.p290c;

import org.p287b.AbstractC5430k;
import org.p287b.C5431l;
import org.p290c.p299b.C5553e;
import org.p290c.p299b.C5554f;
/* renamed from: org.c.c */
/* loaded from: classes.dex */
public class C5562c {
    protected C5562c() {
    }

    /* renamed from: a */
    private static String m759a(Object obj, String str) {
        return (obj == null ? "null" : obj.getClass().getName()) + "<" + str + ">";
    }

    /* renamed from: a */
    public static void m766a() {
        m757a((String) null);
    }

    @Deprecated
    /* renamed from: a */
    public static void m765a(double d, double d2) {
        m756a((String) null, d, d2);
    }

    /* renamed from: a */
    public static void m764a(double d, double d2, double d3) {
        m755a((String) null, d, d2, d3);
    }

    /* renamed from: a */
    public static void m763a(float f, float f2, float f3) {
        m722b((String) null, f, f2, f3);
    }

    /* renamed from: a */
    public static void m762a(long j, long j2) {
        m753a((String) null, j, j2);
    }

    /* renamed from: a */
    public static void m761a(Object obj) {
        m752a((String) null, obj);
    }

    /* renamed from: a */
    public static void m760a(Object obj, Object obj2) {
        m751a((String) null, obj, obj2);
    }

    /* renamed from: a */
    public static <T> void m758a(T t, AbstractC5430k<? super T> abstractC5430k) {
        m750a("", (Object) t, (AbstractC5430k) abstractC5430k);
    }

    /* renamed from: a */
    public static void m757a(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    @Deprecated
    /* renamed from: a */
    public static void m756a(String str, double d, double d2) {
        m757a("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    /* renamed from: a */
    public static void m755a(String str, double d, double d2, double d3) {
        if (!m714c(d, d2, d3)) {
            m711c(str, (Object) Double.valueOf(d2));
        }
    }

    /* renamed from: a */
    public static void m754a(String str, float f, float f2, float f3) {
        if (m713c(f, f2, f3)) {
            m701h(str, Float.valueOf(f), Float.valueOf(f2));
        }
    }

    /* renamed from: a */
    public static void m753a(String str, long j, long j2) {
        if (j == j2) {
            m711c(str, (Object) Long.valueOf(j2));
        }
    }

    /* renamed from: a */
    public static void m752a(String str, Object obj) {
        m749a(str, obj != null);
    }

    /* renamed from: a */
    public static void m751a(String str, Object obj, Object obj2) {
        if (m706e(obj, obj2)) {
            return;
        }
        if (!(obj instanceof String) || !(obj2 instanceof String)) {
            m701h(str, obj, obj2);
            return;
        }
        if (str == null) {
            str = "";
        }
        throw new C5685i(str, (String) obj, (String) obj2);
    }

    /* renamed from: a */
    public static <T> void m750a(String str, T t, AbstractC5430k<? super T> abstractC5430k) {
        C5431l.m1077a(str, t, abstractC5430k);
    }

    /* renamed from: a */
    public static void m749a(String str, boolean z) {
        if (!z) {
            m757a(str);
        }
    }

    /* renamed from: a */
    public static void m748a(String str, byte[] bArr, byte[] bArr2) {
        m703f(str, bArr, bArr2);
    }

    /* renamed from: a */
    public static void m747a(String str, char[] cArr, char[] cArr2) {
        m703f(str, cArr, cArr2);
    }

    /* renamed from: a */
    public static void m746a(String str, double[] dArr, double[] dArr2, double d) {
        new C5554f(d).a(str, dArr, dArr2);
    }

    /* renamed from: a */
    public static void m745a(String str, float[] fArr, float[] fArr2, float f) {
        new C5554f(f).a(str, fArr, fArr2);
    }

    /* renamed from: a */
    public static void m744a(String str, int[] iArr, int[] iArr2) {
        m703f(str, iArr, iArr2);
    }

    /* renamed from: a */
    public static void m743a(String str, long[] jArr, long[] jArr2) {
        m703f(str, jArr, jArr2);
    }

    /* renamed from: a */
    public static void m742a(String str, Object[] objArr, Object[] objArr2) {
        m703f(str, objArr, objArr2);
    }

    /* renamed from: a */
    public static void m741a(String str, short[] sArr, short[] sArr2) {
        m703f(str, sArr, sArr2);
    }

    /* renamed from: a */
    public static void m740a(String str, boolean[] zArr, boolean[] zArr2) {
        m703f(str, zArr, zArr2);
    }

    /* renamed from: a */
    public static void m739a(boolean z) {
        m749a((String) null, z);
    }

    /* renamed from: a */
    public static void m738a(byte[] bArr, byte[] bArr2) {
        m748a((String) null, bArr, bArr2);
    }

    /* renamed from: a */
    public static void m737a(char[] cArr, char[] cArr2) {
        m747a((String) null, cArr, cArr2);
    }

    /* renamed from: a */
    public static void m736a(double[] dArr, double[] dArr2, double d) {
        m746a((String) null, dArr, dArr2, d);
    }

    /* renamed from: a */
    public static void m735a(float[] fArr, float[] fArr2, float f) {
        m745a((String) null, fArr, fArr2, f);
    }

    /* renamed from: a */
    public static void m734a(int[] iArr, int[] iArr2) {
        m744a((String) null, iArr, iArr2);
    }

    /* renamed from: a */
    public static void m733a(long[] jArr, long[] jArr2) {
        m743a((String) null, jArr, jArr2);
    }

    /* renamed from: a */
    public static void m732a(Object[] objArr, Object[] objArr2) {
        m742a((String) null, objArr, objArr2);
    }

    /* renamed from: a */
    public static void m731a(short[] sArr, short[] sArr2) {
        m741a((String) null, sArr, sArr2);
    }

    /* renamed from: a */
    public static void m730a(boolean[] zArr, boolean[] zArr2) {
        m740a((String) null, zArr, zArr2);
    }

    /* renamed from: b */
    public static void m729b(double d, double d2, double d3) {
        m723b((String) null, d, d2, d3);
    }

    /* renamed from: b */
    public static void m728b(float f, float f2, float f3) {
        m754a((String) null, f, f2, f3);
    }

    /* renamed from: b */
    public static void m727b(long j, long j2) {
        m721b((String) null, j, j2);
    }

    /* renamed from: b */
    public static void m726b(Object obj) {
        m720b((String) null, obj);
    }

    /* renamed from: b */
    public static void m725b(Object obj, Object obj2) {
        m719b((String) null, obj, obj2);
    }

    /* renamed from: b */
    private static void m724b(String str) {
        String str2 = "";
        if (str != null) {
            str2 = str + " ";
        }
        m757a(str2 + "expected not same");
    }

    /* renamed from: b */
    public static void m723b(String str, double d, double d2, double d3) {
        if (m714c(d, d2, d3)) {
            m701h(str, Double.valueOf(d), Double.valueOf(d2));
        }
    }

    /* renamed from: b */
    public static void m722b(String str, float f, float f2, float f3) {
        if (!m713c(f, f2, f3)) {
            m711c(str, (Object) Float.valueOf(f2));
        }
    }

    /* renamed from: b */
    public static void m721b(String str, long j, long j2) {
        if (j != j2) {
            m701h(str, Long.valueOf(j), Long.valueOf(j2));
        }
    }

    /* renamed from: b */
    public static void m720b(String str, Object obj) {
        if (obj == null) {
            return;
        }
        m708d(str, obj);
    }

    /* renamed from: b */
    public static void m719b(String str, Object obj, Object obj2) {
        if (m706e(obj, obj2)) {
            m711c(str, obj2);
        }
    }

    /* renamed from: b */
    public static void m718b(String str, boolean z) {
        m749a(str, !z);
    }

    @Deprecated
    /* renamed from: b */
    public static void m717b(String str, Object[] objArr, Object[] objArr2) {
        m742a(str, objArr, objArr2);
    }

    /* renamed from: b */
    public static void m716b(boolean z) {
        m718b((String) null, z);
    }

    @Deprecated
    /* renamed from: b */
    public static void m715b(Object[] objArr, Object[] objArr2) {
        m732a(objArr, objArr2);
    }

    /* renamed from: c */
    public static void m712c(Object obj, Object obj2) {
        m710c((String) null, obj, obj2);
    }

    /* renamed from: c */
    private static void m711c(String str, Object obj) {
        String str2 = "Values should be different. ";
        if (str != null) {
            str2 = str + ". ";
        }
        m757a(str2 + "Actual: " + obj);
    }

    /* renamed from: c */
    public static void m710c(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        m702g(str, obj, obj2);
    }

    /* renamed from: c */
    private static boolean m714c(double d, double d2, double d3) {
        return Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3;
    }

    /* renamed from: c */
    private static boolean m713c(float f, float f2, float f3) {
        return Float.compare(f, f2) != 0 && Math.abs(f - f2) > f3;
    }

    /* renamed from: d */
    public static void m709d(Object obj, Object obj2) {
        m707d(null, obj, obj2);
    }

    /* renamed from: d */
    private static void m708d(String str, Object obj) {
        String str2 = "";
        if (str != null) {
            str2 = str + " ";
        }
        m757a(str2 + "expected null, but was:<" + obj + ">");
    }

    /* renamed from: d */
    public static void m707d(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            m724b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static String m705e(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + " ";
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        return valueOf.equals(valueOf2) ? str2 + "expected: " + m759a(obj, valueOf) + " but was: " + m759a(obj2, valueOf2) : str2 + "expected:<" + valueOf + "> but was:<" + valueOf2 + ">";
    }

    /* renamed from: e */
    private static boolean m706e(Object obj, Object obj2) {
        return obj == null ? obj2 == null : m704f(obj, obj2);
    }

    /* renamed from: f */
    private static void m703f(String str, Object obj, Object obj2) {
        new C5553e().a(str, obj, obj2);
    }

    /* renamed from: f */
    private static boolean m704f(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: g */
    private static void m702g(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null) {
            str2 = str + " ";
        }
        m757a(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    /* renamed from: h */
    private static void m701h(String str, Object obj, Object obj2) {
        m757a(m705e(str, obj, obj2));
    }
}
