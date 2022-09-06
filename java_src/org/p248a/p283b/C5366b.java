package org.p248a.p283b;

import com.p078a.p079a.AbstractC0735l;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/* renamed from: org.a.b.b */
/* loaded from: classes2.dex */
public final class C5366b {

    /* renamed from: a */
    private static final Comparator f22419a = new C5367a();

    /* renamed from: org.a.b.b$a */
    /* loaded from: classes2.dex */
    private static class C5367a implements Comparator {
        private C5367a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? C5366b.m1273a((List) obj, (List) obj2) : obj instanceof Set ? C5366b.m1271a((Set) obj, (Set) obj2) : obj instanceof Map ? C5366b.m1272a((Map) obj, (Map) obj2) : obj instanceof byte[] ? C5366b.m1268a((byte[]) obj, (byte[]) obj2) : C5366b.m1278a((Comparable) obj, (Comparable) obj2);
        }
    }

    /* renamed from: a */
    public static int m1282a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1281a(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        return d2 < d ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1280a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1279a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1278a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: a */
    public static int m1277a(String str, String str2) {
        return str.compareTo(str2);
    }

    /* renamed from: a */
    public static int m1274a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i, remaining);
        return remaining;
    }

    /* renamed from: a */
    public static int m1273a(List list, List list2) {
        int m1280a = m1280a(list.size(), list2.size());
        if (m1280a != 0) {
            return m1280a;
        }
        for (int i = 0; i < list.size(); i++) {
            int compare = f22419a.compare(list.get(i), list2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1272a(Map map, Map map2) {
        int m1280a = m1280a(map.size(), map2.size());
        if (m1280a != 0) {
            return m1280a;
        }
        TreeMap treeMap = new TreeMap(f22419a);
        treeMap.putAll(map);
        Iterator it2 = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f22419a);
        treeMap2.putAll(map2);
        Iterator it3 = treeMap2.entrySet().iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Map.Entry entry2 = (Map.Entry) it3.next();
            int compare = f22419a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f22419a.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1271a(Set set, Set set2) {
        int m1280a = m1280a(set.size(), set2.size());
        if (m1280a != 0) {
            return m1280a;
        }
        TreeSet treeSet = new TreeSet(f22419a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f22419a);
        treeSet2.addAll(set2);
        Iterator it2 = treeSet.iterator();
        Iterator it3 = treeSet2.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            int compare = f22419a.compare(it2.next(), it3.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1270a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1269a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static int m1268a(byte[] bArr, byte[] bArr2) {
        int m1280a = m1280a(bArr.length, bArr2.length);
        if (m1280a != 0) {
            return m1280a;
        }
        for (int i = 0; i < bArr.length; i++) {
            int m1282a = m1282a(bArr[i], bArr2[i]);
            if (m1282a != 0) {
                return m1282a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static String m1283a(byte b) {
        return Integer.toHexString((b | 256) & AbstractC0735l.f1814e).toUpperCase().substring(1);
    }

    /* renamed from: a */
    public static void m1275a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
        for (int i2 = arrayOffset; i2 < i; i2++) {
            if (i2 > arrayOffset) {
                sb.append(" ");
            }
            sb.append(m1283a(array[i2]));
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    /* renamed from: a */
    public static byte[] m1276a(ByteBuffer byteBuffer) {
        if (m1267b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        m1274a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* renamed from: b */
    public static boolean m1267b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: c */
    public static ByteBuffer m1266c(ByteBuffer byteBuffer) {
        return m1267b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m1276a(byteBuffer));
    }
}
