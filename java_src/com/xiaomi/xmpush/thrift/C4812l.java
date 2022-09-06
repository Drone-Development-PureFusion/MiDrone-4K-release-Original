package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.p248a.p249a.C5083e;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5366b;
import org.p248a.p283b.p284a.C5360b;
import org.p248a.p283b.p284a.C5361c;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.l */
/* loaded from: classes2.dex */
public class C4812l implements Serializable, Cloneable, AbstractC5358a<C4812l, EnumC4813a> {

    /* renamed from: c */
    public static final Map<EnumC4813a, C5360b> f20291c;

    /* renamed from: d */
    private static final C5378j f20292d = new C5378j(C5083e.f21644H);

    /* renamed from: e */
    private static final C5370b f20293e = new C5370b("longitude", (byte) 4, 1);

    /* renamed from: f */
    private static final C5370b f20294f = new C5370b("latitude", (byte) 4, 2);

    /* renamed from: a */
    public double f20295a;

    /* renamed from: b */
    public double f20296b;

    /* renamed from: g */
    private BitSet f20297g = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.l$a */
    /* loaded from: classes2.dex */
    public enum EnumC4813a {
        LONGITUDE(1, "longitude"),
        LATITUDE(2, "latitude");
        

        /* renamed from: c */
        private static final Map<String, EnumC4813a> f20300c = new HashMap();

        /* renamed from: d */
        private final short f20302d;

        /* renamed from: e */
        private final String f20303e;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4813a.class).iterator();
            while (it2.hasNext()) {
                EnumC4813a enumC4813a = (EnumC4813a) it2.next();
                f20300c.put(enumC4813a.m3367a(), enumC4813a);
            }
        }

        EnumC4813a(short s, String str) {
            this.f20302d = s;
            this.f20303e = str;
        }

        /* renamed from: a */
        public String m3367a() {
            return this.f20303e;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4813a.class);
        enumMap.put((EnumMap) EnumC4813a.LONGITUDE, (EnumC4813a) new C5360b("longitude", (byte) 1, new C5361c((byte) 4)));
        enumMap.put((EnumMap) EnumC4813a.LATITUDE, (EnumC4813a) new C5360b("latitude", (byte) 1, new C5361c((byte) 4)));
        f20291c = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4812l.class, f20291c);
    }

    /* renamed from: a */
    public double m3378a() {
        return this.f20295a;
    }

    /* renamed from: a */
    public C4812l m3377a(double d) {
        this.f20295a = d;
        m3375a(true);
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
                if (!m3374b()) {
                    throw new C5374f("Required field 'longitude' was not found in serialized data! Struct: " + toString());
                }
                if (!m3369d()) {
                    throw new C5374f("Required field 'latitude' was not found in serialized data! Struct: " + toString());
                }
                m3368e();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 4) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20295a = abstractC5373e.mo1230v();
                        m3375a(true);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 4) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20296b = abstractC5373e.mo1230v();
                        m3371b(true);
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
    public void m3375a(boolean z) {
        this.f20297g.set(0, z);
    }

    /* renamed from: a */
    public boolean m3376a(C4812l c4812l) {
        return c4812l != null && this.f20295a == c4812l.f20295a && this.f20296b == c4812l.f20296b;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4812l c4812l) {
        int m1281a;
        int m1281a2;
        if (!getClass().equals(c4812l.getClass())) {
            return getClass().getName().compareTo(c4812l.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3374b()).compareTo(Boolean.valueOf(c4812l.m3374b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3374b() && (m1281a2 = C5366b.m1281a(this.f20295a, c4812l.f20295a)) != 0) {
            return m1281a2;
        }
        int compareTo2 = Boolean.valueOf(m3369d()).compareTo(Boolean.valueOf(c4812l.m3369d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3369d() && (m1281a = C5366b.m1281a(this.f20296b, c4812l.f20296b)) != 0) {
            return m1281a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4812l m3373b(double d) {
        this.f20296b = d;
        m3371b(true);
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3368e();
        abstractC5373e.mo1250a(f20292d);
        abstractC5373e.mo1254a(f20293e);
        abstractC5373e.mo1259a(this.f20295a);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1254a(f20294f);
        abstractC5373e.mo1259a(this.f20296b);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3371b(boolean z) {
        this.f20297g.set(1, z);
    }

    /* renamed from: b */
    public boolean m3374b() {
        return this.f20297g.get(0);
    }

    /* renamed from: c */
    public double m3370c() {
        return this.f20296b;
    }

    /* renamed from: d */
    public boolean m3369d() {
        return this.f20297g.get(1);
    }

    /* renamed from: e */
    public void m3368e() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4812l)) {
            return m3376a((C4812l) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Location(longitude:" + this.f20295a + ", latitude:" + this.f20296b + ")";
    }
}
