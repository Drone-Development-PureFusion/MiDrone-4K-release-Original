package com.p078a.p079a;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;
/* renamed from: com.a.a.d */
/* loaded from: classes.dex */
public class C0725d {

    /* renamed from: a */
    private static final int f1781a = 4;

    /* renamed from: b */
    private static final Map<C0721ab, Class<?>> f1782b = new ConcurrentHashMap();

    /* renamed from: com.a.a.d$a */
    /* loaded from: classes.dex */
    public static final class C0726a {

        /* renamed from: a */
        public static final int f1783a = 0;

        /* renamed from: b */
        public static final int f1784b = 1;

        /* renamed from: c */
        public static final int f1785c = 2;

        /* renamed from: d */
        public static final C0726a f1786d = new C0726a(0);

        /* renamed from: e */
        public static final C0726a f1787e = new C0726a(1);

        /* renamed from: f */
        public static final C0726a f1788f = new C0726a(2);

        /* renamed from: g */
        private final int f1789g;

        private C0726a(int i) {
            this.f1789g = i;
        }

        /* renamed from: a */
        public int m19245a() {
            return this.f1789g;
        }
    }

    static {
        m19251a(C0723b.class);
        m19251a(C0729g.class);
        m19251a(C0734k.class);
        m19251a(C0733j.class);
        m19251a(C0740p.class);
    }

    /* renamed from: a */
    public static AbstractC0749x m19252a(C0721ab c0721ab) {
        Class<?> cls = f1782b.get(c0721ab);
        if (cls != null) {
            return (AbstractC0749x) cls.newInstance();
        }
        C0737n c0737n = new C0737n();
        c0737n.m19228a(c0721ab);
        return c0737n;
    }

    /* renamed from: a */
    public static void m19251a(Class<?> cls) {
        try {
            f1782b.put(((AbstractC0749x) cls.newInstance()).mo19165a(), cls);
        } catch (ClassCastException e) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (InstantiationException e3) {
            throw new RuntimeException(cls + " is not a concrete class");
        }
    }

    /* renamed from: a */
    public static byte[] m19247a(AbstractC0749x[] abstractC0749xArr) {
        boolean z = abstractC0749xArr.length > 0 && (abstractC0749xArr[abstractC0749xArr.length + (-1)] instanceof C0736m);
        int length = z ? abstractC0749xArr.length - 1 : abstractC0749xArr.length;
        int i = length * 4;
        for (AbstractC0749x abstractC0749x : abstractC0749xArr) {
            i += abstractC0749x.mo19160f().m19277b();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(abstractC0749xArr[i3].mo19165a().m19281a(), 0, bArr, i2, 2);
            System.arraycopy(abstractC0749xArr[i3].mo19160f().m19281a(), 0, bArr, i2 + 2, 2);
            byte[] mo19161e = abstractC0749xArr[i3].mo19161e();
            System.arraycopy(mo19161e, 0, bArr, i2 + 4, mo19161e.length);
            i2 += mo19161e.length + 4;
        }
        if (z) {
            byte[] mo19161e2 = abstractC0749xArr[abstractC0749xArr.length - 1].mo19161e();
            System.arraycopy(mo19161e2, 0, bArr, i2, mo19161e2.length);
        }
        return bArr;
    }

    /* renamed from: a */
    public static AbstractC0749x[] m19250a(byte[] bArr) {
        return m19248a(bArr, true, C0726a.f1786d);
    }

    /* renamed from: a */
    public static AbstractC0749x[] m19249a(byte[] bArr, boolean z) {
        return m19248a(bArr, z, C0726a.f1786d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static AbstractC0749x[] m19248a(byte[] bArr, boolean z, C0726a c0726a) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i > bArr.length - 4) {
                break;
            }
            C0721ab c0721ab = new C0721ab(bArr, i);
            int m19277b = new C0721ab(bArr, i + 2).m19277b();
            if (i + 4 + m19277b > bArr.length) {
                switch (c0726a.m19245a()) {
                    case 0:
                        throw new ZipException("bad extra field starting at " + i + ".  Block length of " + m19277b + " bytes exceeds remaining data of " + ((bArr.length - i) - 4) + " bytes.");
                    case 1:
                        break;
                    case 2:
                        C0736m c0736m = new C0736m();
                        if (z) {
                            c0736m.mo19164a(bArr, i, bArr.length - i);
                        } else {
                            c0736m.mo19217b(bArr, i, bArr.length - i);
                        }
                        arrayList.add(c0736m);
                        break;
                    default:
                        throw new ZipException("unknown UnparseableExtraField key: " + c0726a.m19245a());
                }
            } else {
                try {
                    AbstractC0749x m19252a = m19252a(c0721ab);
                    if (z || !(m19252a instanceof AbstractC0724c)) {
                        m19252a.mo19164a(bArr, i + 4, m19277b);
                    } else {
                        ((AbstractC0724c) m19252a).mo19217b(bArr, i + 4, m19277b);
                    }
                    arrayList.add(m19252a);
                    i = m19277b + 4 + i;
                } catch (IllegalAccessException e) {
                    throw new ZipException(e.getMessage());
                } catch (InstantiationException e2) {
                    throw new ZipException(e2.getMessage());
                }
            }
        }
        return (AbstractC0749x[]) arrayList.toArray(new AbstractC0749x[arrayList.size()]);
    }

    /* renamed from: b */
    public static byte[] m19246b(AbstractC0749x[] abstractC0749xArr) {
        boolean z = abstractC0749xArr.length > 0 && (abstractC0749xArr[abstractC0749xArr.length + (-1)] instanceof C0736m);
        int length = z ? abstractC0749xArr.length - 1 : abstractC0749xArr.length;
        int i = length * 4;
        for (AbstractC0749x abstractC0749x : abstractC0749xArr) {
            i += abstractC0749x.mo19162d().m19277b();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(abstractC0749xArr[i3].mo19165a().m19281a(), 0, bArr, i2, 2);
            System.arraycopy(abstractC0749xArr[i3].mo19162d().m19281a(), 0, bArr, i2 + 2, 2);
            byte[] mo19163c = abstractC0749xArr[i3].mo19163c();
            System.arraycopy(mo19163c, 0, bArr, i2 + 4, mo19163c.length);
            i2 += mo19163c.length + 4;
        }
        if (z) {
            byte[] mo19163c2 = abstractC0749xArr[abstractC0749xArr.length - 1].mo19163c();
            System.arraycopy(mo19163c2, 0, bArr, i2, mo19163c2.length);
        }
        return bArr;
    }
}
