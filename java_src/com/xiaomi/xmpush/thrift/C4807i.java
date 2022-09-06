package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5366b;
import org.p248a.p283b.p284a.C5360b;
import org.p248a.p283b.p284a.C5361c;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.i */
/* loaded from: classes2.dex */
public class C4807i implements Serializable, Cloneable, AbstractC5358a<C4807i, EnumC4808a> {

    /* renamed from: e */
    public static final Map<EnumC4808a, C5360b> f20231e;

    /* renamed from: f */
    private static final C5378j f20232f = new C5378j("GPS");

    /* renamed from: g */
    private static final C5370b f20233g = new C5370b("location", (byte) 12, 1);

    /* renamed from: h */
    private static final C5370b f20234h = new C5370b("provider", (byte) 11, 2);

    /* renamed from: i */
    private static final C5370b f20235i = new C5370b("period", (byte) 10, 3);

    /* renamed from: j */
    private static final C5370b f20236j = new C5370b("accuracy", (byte) 4, 4);

    /* renamed from: a */
    public C4812l f20237a;

    /* renamed from: b */
    public String f20238b;

    /* renamed from: c */
    public long f20239c;

    /* renamed from: d */
    public double f20240d;

    /* renamed from: k */
    private BitSet f20241k = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.i$a */
    /* loaded from: classes2.dex */
    public enum EnumC4808a {
        LOCATION(1, "location"),
        PROVIDER(2, "provider"),
        PERIOD(3, "period"),
        ACCURACY(4, "accuracy");
        

        /* renamed from: e */
        private static final Map<String, EnumC4808a> f20246e = new HashMap();

        /* renamed from: f */
        private final short f20248f;

        /* renamed from: g */
        private final String f20249g;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4808a.class).iterator();
            while (it2.hasNext()) {
                EnumC4808a enumC4808a = (EnumC4808a) it2.next();
                f20246e.put(enumC4808a.m3418a(), enumC4808a);
            }
        }

        EnumC4808a(short s, String str) {
            this.f20248f = s;
            this.f20249g = str;
        }

        /* renamed from: a */
        public String m3418a() {
            return this.f20249g;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4808a.class);
        enumMap.put((EnumMap) EnumC4808a.LOCATION, (EnumC4808a) new C5360b("location", (byte) 1, new C5365g((byte) 12, C4812l.class)));
        enumMap.put((EnumMap) EnumC4808a.PROVIDER, (EnumC4808a) new C5360b("provider", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4808a.PERIOD, (EnumC4808a) new C5360b("period", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4808a.ACCURACY, (EnumC4808a) new C5360b("accuracy", (byte) 2, new C5361c((byte) 4)));
        f20231e = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4807i.class, f20231e);
    }

    /* renamed from: a */
    public C4807i m3430a(double d) {
        this.f20240d = d;
        m3422b(true);
        return this;
    }

    /* renamed from: a */
    public C4807i m3429a(long j) {
        this.f20239c = j;
        m3425a(true);
        return this;
    }

    /* renamed from: a */
    public C4807i m3427a(C4812l c4812l) {
        this.f20237a = c4812l;
        return this;
    }

    /* renamed from: a */
    public C4807i m3426a(String str) {
        this.f20238b = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3419e();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20237a = new C4812l();
                        this.f20237a.mo1286a(abstractC5373e);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20238b = abstractC5373e.mo1223w();
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20239c = abstractC5373e.mo1231u();
                        m3425a(true);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 4) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20240d = abstractC5373e.mo1230v();
                        m3422b(true);
                        break;
                    }
                default:
                    C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                    break;
            }
            abstractC5373e.mo1239j();
        }
    }

    /* renamed from: a */
    public void m3425a(boolean z) {
        this.f20241k.set(0, z);
    }

    /* renamed from: a */
    public boolean m3431a() {
        return this.f20237a != null;
    }

    /* renamed from: a */
    public boolean m3428a(C4807i c4807i) {
        if (c4807i == null) {
            return false;
        }
        boolean m3431a = m3431a();
        boolean m3431a2 = c4807i.m3431a();
        if ((m3431a || m3431a2) && (!m3431a || !m3431a2 || !this.f20237a.m3376a(c4807i.f20237a))) {
            return false;
        }
        boolean m3424b = m3424b();
        boolean m3424b2 = c4807i.m3424b();
        if ((m3424b || m3424b2) && (!m3424b || !m3424b2 || !this.f20238b.equals(c4807i.f20238b))) {
            return false;
        }
        boolean m3421c = m3421c();
        boolean m3421c2 = c4807i.m3421c();
        if ((m3421c || m3421c2) && (!m3421c || !m3421c2 || this.f20239c != c4807i.f20239c)) {
            return false;
        }
        boolean m3420d = m3420d();
        boolean m3420d2 = c4807i.m3420d();
        return (!m3420d && !m3420d2) || (m3420d && m3420d2 && this.f20240d == c4807i.f20240d);
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4807i c4807i) {
        int m1281a;
        int m1279a;
        int m1277a;
        int m1278a;
        if (!getClass().equals(c4807i.getClass())) {
            return getClass().getName().compareTo(c4807i.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3431a()).compareTo(Boolean.valueOf(c4807i.m3431a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3431a() && (m1278a = C5366b.m1278a(this.f20237a, c4807i.f20237a)) != 0) {
            return m1278a;
        }
        int compareTo2 = Boolean.valueOf(m3424b()).compareTo(Boolean.valueOf(c4807i.m3424b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3424b() && (m1277a = C5366b.m1277a(this.f20238b, c4807i.f20238b)) != 0) {
            return m1277a;
        }
        int compareTo3 = Boolean.valueOf(m3421c()).compareTo(Boolean.valueOf(c4807i.m3421c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3421c() && (m1279a = C5366b.m1279a(this.f20239c, c4807i.f20239c)) != 0) {
            return m1279a;
        }
        int compareTo4 = Boolean.valueOf(m3420d()).compareTo(Boolean.valueOf(c4807i.m3420d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3420d() && (m1281a = C5366b.m1281a(this.f20240d, c4807i.f20240d)) != 0) {
            return m1281a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3419e();
        abstractC5373e.mo1250a(f20232f);
        if (this.f20237a != null) {
            abstractC5373e.mo1254a(f20233g);
            this.f20237a.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20238b != null && m3424b()) {
            abstractC5373e.mo1254a(f20234h);
            abstractC5373e.mo1256a(this.f20238b);
            abstractC5373e.mo1247b();
        }
        if (m3421c()) {
            abstractC5373e.mo1254a(f20235i);
            abstractC5373e.mo1257a(this.f20239c);
            abstractC5373e.mo1247b();
        }
        if (m3420d()) {
            abstractC5373e.mo1254a(f20236j);
            abstractC5373e.mo1259a(this.f20240d);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3422b(boolean z) {
        this.f20241k.set(1, z);
    }

    /* renamed from: b */
    public boolean m3424b() {
        return this.f20238b != null;
    }

    /* renamed from: c */
    public boolean m3421c() {
        return this.f20241k.get(0);
    }

    /* renamed from: d */
    public boolean m3420d() {
        return this.f20241k.get(1);
    }

    /* renamed from: e */
    public void m3419e() {
        if (this.f20237a == null) {
            throw new C5374f("Required field 'location' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4807i)) {
            return m3428a((C4807i) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GPS(");
        sb.append("location:");
        if (this.f20237a == null) {
            sb.append("null");
        } else {
            sb.append(this.f20237a);
        }
        if (m3424b()) {
            sb.append(", ");
            sb.append("provider:");
            if (this.f20238b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20238b);
            }
        }
        if (m3421c()) {
            sb.append(", ");
            sb.append("period:");
            sb.append(this.f20239c);
        }
        if (m3420d()) {
            sb.append(", ");
            sb.append("accuracy:");
            sb.append(this.f20240d);
        }
        sb.append(")");
        return sb.toString();
    }
}
