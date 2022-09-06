package org.p318d.p320b;

import java.util.HashMap;
import java.util.Map;
/* renamed from: org.d.b.f */
/* loaded from: classes2.dex */
public final class C5734f {

    /* renamed from: a */
    static final char f23001a = '{';

    /* renamed from: b */
    static final char f23002b = '}';

    /* renamed from: c */
    static final String f23003c = "{}";

    /* renamed from: d */
    private static final char f23004d = '\\';

    /* renamed from: a */
    static final Throwable m141a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    /* renamed from: a */
    public static final C5732d m156a(String str, Object obj) {
        return m154a(str, new Object[]{obj});
    }

    /* renamed from: a */
    public static final C5732d m155a(String str, Object obj, Object obj2) {
        return m154a(str, new Object[]{obj, obj2});
    }

    /* renamed from: a */
    public static final C5732d m154a(String str, Object[] objArr) {
        Throwable m141a = m141a(objArr);
        if (m141a != null) {
            objArr = m139b(objArr);
        }
        return m153a(str, objArr, m141a);
    }

    /* renamed from: a */
    public static final C5732d m153a(String str, Object[] objArr, Throwable th) {
        int i = 0;
        if (str == null) {
            return new C5732d(null, objArr, th);
        }
        if (objArr == null) {
            return new C5732d(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = str.indexOf(f23003c, i2);
            if (indexOf == -1) {
                if (i2 == 0) {
                    return new C5732d(str, objArr, th);
                }
                sb.append((CharSequence) str, i2, str.length());
                return new C5732d(sb.toString(), objArr, th);
            }
            if (!m157a(str, indexOf)) {
                sb.append((CharSequence) str, i2, indexOf);
                m151a(sb, objArr[i], new HashMap());
                i2 = indexOf + 2;
            } else if (!m140b(str, indexOf)) {
                i--;
                sb.append((CharSequence) str, i2, indexOf - 1);
                sb.append('{');
                i2 = indexOf + 1;
            } else {
                sb.append((CharSequence) str, i2, indexOf - 1);
                m151a(sb, objArr[i], new HashMap());
                i2 = indexOf + 2;
            }
            i++;
        }
        sb.append((CharSequence) str, i2, str.length());
        return new C5732d(sb.toString(), objArr, th);
    }

    /* renamed from: a */
    private static void m152a(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            C5741m.m123a("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    /* renamed from: a */
    private static void m151a(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
        } else if (!obj.getClass().isArray()) {
            m152a(sb, obj);
        } else if (obj instanceof boolean[]) {
            m142a(sb, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            m150a(sb, (byte[]) obj);
        } else if (obj instanceof char[]) {
            m149a(sb, (char[]) obj);
        } else if (obj instanceof short[]) {
            m143a(sb, (short[]) obj);
        } else if (obj instanceof int[]) {
            m146a(sb, (int[]) obj);
        } else if (obj instanceof long[]) {
            m145a(sb, (long[]) obj);
        } else if (obj instanceof float[]) {
            m147a(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            m148a(sb, (double[]) obj);
        } else {
            m144a(sb, (Object[]) obj, map);
        }
    }

    /* renamed from: a */
    private static void m150a(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) bArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m149a(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(cArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m148a(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(dArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m147a(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(fArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m146a(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(iArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m145a(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(jArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m144a(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m151a(sb, objArr[i], map);
                if (i != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m143a(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) sArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m142a(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(zArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    static final boolean m157a(String str, int i) {
        return i != 0 && str.charAt(i + (-1)) == '\\';
    }

    /* renamed from: b */
    static final boolean m140b(String str, int i) {
        return i >= 2 && str.charAt(i + (-2)) == '\\';
    }

    /* renamed from: b */
    private static Object[] m139b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }
}
