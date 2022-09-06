package com.xiaomi.xmpush.thrift;

import com.tencent.p227mm.sdk.message.RMsgInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5366b;
import org.p248a.p283b.p284a.C5359a;
import org.p248a.p283b.p284a.C5360b;
import org.p248a.p283b.p284a.C5361c;
import org.p248a.p283b.p284a.C5362d;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5371c;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.j */
/* loaded from: classes2.dex */
public class C4809j implements Serializable, Cloneable, AbstractC5358a<C4809j, EnumC4810a> {

    /* renamed from: k */
    public static final Map<EnumC4810a, C5360b> f20250k;

    /* renamed from: l */
    private static final C5378j f20251l = new C5378j("GeoFencing");

    /* renamed from: m */
    private static final C5370b f20252m = new C5370b("id", (byte) 11, 1);

    /* renamed from: n */
    private static final C5370b f20253n = new C5370b("name", (byte) 11, 2);

    /* renamed from: o */
    private static final C5370b f20254o = new C5370b("appId", (byte) 10, 3);

    /* renamed from: p */
    private static final C5370b f20255p = new C5370b("packageName", (byte) 11, 4);

    /* renamed from: q */
    private static final C5370b f20256q = new C5370b(RMsgInfo.COL_CREATE_TIME, (byte) 10, 5);

    /* renamed from: r */
    private static final C5370b f20257r = new C5370b("type", (byte) 8, 6);

    /* renamed from: s */
    private static final C5370b f20258s = new C5370b("circleCenter", (byte) 12, 7);

    /* renamed from: t */
    private static final C5370b f20259t = new C5370b("circleRadius", (byte) 4, 9);

    /* renamed from: u */
    private static final C5370b f20260u = new C5370b("polygonPoints", (byte) 15, 10);

    /* renamed from: v */
    private static final C5370b f20261v = new C5370b("coordinateProvider", (byte) 8, 11);

    /* renamed from: a */
    public String f20262a;

    /* renamed from: b */
    public String f20263b;

    /* renamed from: c */
    public long f20264c;

    /* renamed from: d */
    public String f20265d;

    /* renamed from: e */
    public long f20266e;

    /* renamed from: f */
    public EnumC4811k f20267f;

    /* renamed from: g */
    public C4812l f20268g;

    /* renamed from: h */
    public double f20269h;

    /* renamed from: i */
    public List<C4812l> f20270i;

    /* renamed from: j */
    public EnumC4806h f20271j;

    /* renamed from: w */
    private BitSet f20272w = new BitSet(3);

    /* renamed from: com.xiaomi.xmpush.thrift.j$a */
    /* loaded from: classes2.dex */
    public enum EnumC4810a {
        ID(1, "id"),
        NAME(2, "name"),
        APP_ID(3, "appId"),
        PACKAGE_NAME(4, "packageName"),
        CREATE_TIME(5, RMsgInfo.COL_CREATE_TIME),
        TYPE(6, "type"),
        CIRCLE_CENTER(7, "circleCenter"),
        CIRCLE_RADIUS(9, "circleRadius"),
        POLYGON_POINTS(10, "polygonPoints"),
        COORDINATE_PROVIDER(11, "coordinateProvider");
        

        /* renamed from: k */
        private static final Map<String, EnumC4810a> f20283k = new HashMap();

        /* renamed from: l */
        private final short f20285l;

        /* renamed from: m */
        private final String f20286m;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4810a.class).iterator();
            while (it2.hasNext()) {
                EnumC4810a enumC4810a = (EnumC4810a) it2.next();
                f20283k.put(enumC4810a.m3381a(), enumC4810a);
            }
        }

        EnumC4810a(short s, String str) {
            this.f20285l = s;
            this.f20286m = str;
        }

        /* renamed from: a */
        public String m3381a() {
            return this.f20286m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4810a.class);
        enumMap.put((EnumMap) EnumC4810a.ID, (EnumC4810a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4810a.NAME, (EnumC4810a) new C5360b("name", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4810a.APP_ID, (EnumC4810a) new C5360b("appId", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4810a.PACKAGE_NAME, (EnumC4810a) new C5360b("packageName", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4810a.CREATE_TIME, (EnumC4810a) new C5360b(RMsgInfo.COL_CREATE_TIME, (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4810a.TYPE, (EnumC4810a) new C5360b("type", (byte) 1, new C5359a((byte) 16, EnumC4811k.class)));
        enumMap.put((EnumMap) EnumC4810a.CIRCLE_CENTER, (EnumC4810a) new C5360b("circleCenter", (byte) 2, new C5365g((byte) 12, C4812l.class)));
        enumMap.put((EnumMap) EnumC4810a.CIRCLE_RADIUS, (EnumC4810a) new C5360b("circleRadius", (byte) 2, new C5361c((byte) 4)));
        enumMap.put((EnumMap) EnumC4810a.POLYGON_POINTS, (EnumC4810a) new C5360b("polygonPoints", (byte) 2, new C5362d((byte) 15, new C5365g((byte) 12, C4812l.class))));
        enumMap.put((EnumMap) EnumC4810a.COORDINATE_PROVIDER, (EnumC4810a) new C5360b("coordinateProvider", (byte) 1, new C5359a((byte) 16, EnumC4806h.class)));
        f20250k = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4809j.class, f20250k);
    }

    /* renamed from: a */
    public C4809j m3416a(double d) {
        this.f20269h = d;
        m3400c(true);
        return this;
    }

    /* renamed from: a */
    public C4809j m3415a(long j) {
        this.f20264c = j;
        m3408a(true);
        return this;
    }

    /* renamed from: a */
    public C4809j m3414a(EnumC4806h enumC4806h) {
        this.f20271j = enumC4806h;
        return this;
    }

    /* renamed from: a */
    public C4809j m3412a(EnumC4811k enumC4811k) {
        this.f20267f = enumC4811k;
        return this;
    }

    /* renamed from: a */
    public C4809j m3411a(C4812l c4812l) {
        this.f20268g = c4812l;
        return this;
    }

    /* renamed from: a */
    public C4809j m3410a(String str) {
        this.f20262a = str;
        return this;
    }

    /* renamed from: a */
    public C4809j m3409a(List<C4812l> list) {
        this.f20270i = list;
        return this;
    }

    /* renamed from: a */
    public String m3417a() {
        return this.f20262a;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3397f()) {
                    throw new C5374f("Required field 'appId' was not found in serialized data! Struct: " + toString());
                }
                if (!m3393j()) {
                    throw new C5374f("Required field 'createTime' was not found in serialized data! Struct: " + toString());
                }
                m3382u();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f20262a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 11) {
                        this.f20263b = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 10) {
                        this.f20264c = abstractC5373e.mo1231u();
                        m3408a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f20265d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 10) {
                        this.f20266e = abstractC5373e.mo1231u();
                        m3403b(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 8) {
                        this.f20267f = EnumC4811k.m3379a(abstractC5373e.mo1232t());
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 12) {
                        this.f20268g = new C4812l();
                        this.f20268g.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                default:
                    C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                    break;
                case 9:
                    if (mo1240i.f22437b == 4) {
                        this.f20269h = abstractC5373e.mo1230v();
                        m3400c(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f20270i = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            C4812l c4812l = new C4812l();
                            c4812l.mo1286a(abstractC5373e);
                            this.f20270i.add(c4812l);
                        }
                        abstractC5373e.mo1237n();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                    if (mo1240i.f22437b == 8) {
                        this.f20271j = EnumC4806h.m3432a(abstractC5373e.mo1232t());
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
            }
            abstractC5373e.mo1239j();
        }
    }

    /* renamed from: a */
    public void m3408a(boolean z) {
        this.f20272w.set(0, z);
    }

    /* renamed from: a */
    public boolean m3413a(C4809j c4809j) {
        if (c4809j == null) {
            return false;
        }
        boolean m3407b = m3407b();
        boolean m3407b2 = c4809j.m3407b();
        if ((m3407b || m3407b2) && (!m3407b || !m3407b2 || !this.f20262a.equals(c4809j.f20262a))) {
            return false;
        }
        boolean m3399d = m3399d();
        boolean m3399d2 = c4809j.m3399d();
        if (((m3399d || m3399d2) && (!m3399d || !m3399d2 || !this.f20263b.equals(c4809j.f20263b))) || this.f20264c != c4809j.f20264c) {
            return false;
        }
        boolean m3395h = m3395h();
        boolean m3395h2 = c4809j.m3395h();
        if (((m3395h || m3395h2) && (!m3395h || !m3395h2 || !this.f20265d.equals(c4809j.f20265d))) || this.f20266e != c4809j.f20266e) {
            return false;
        }
        boolean m3391l = m3391l();
        boolean m3391l2 = c4809j.m3391l();
        if ((m3391l || m3391l2) && (!m3391l || !m3391l2 || !this.f20267f.equals(c4809j.f20267f))) {
            return false;
        }
        boolean m3389n = m3389n();
        boolean m3389n2 = c4809j.m3389n();
        if ((m3389n || m3389n2) && (!m3389n || !m3389n2 || !this.f20268g.m3376a(c4809j.f20268g))) {
            return false;
        }
        boolean m3387p = m3387p();
        boolean m3387p2 = c4809j.m3387p();
        if ((m3387p || m3387p2) && (!m3387p || !m3387p2 || this.f20269h != c4809j.f20269h)) {
            return false;
        }
        boolean m3385r = m3385r();
        boolean m3385r2 = c4809j.m3385r();
        if ((m3385r || m3385r2) && (!m3385r || !m3385r2 || !this.f20270i.equals(c4809j.f20270i))) {
            return false;
        }
        boolean m3383t = m3383t();
        boolean m3383t2 = c4809j.m3383t();
        return (!m3383t && !m3383t2) || (m3383t && m3383t2 && this.f20271j.equals(c4809j.f20271j));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4809j c4809j) {
        int m1278a;
        int m1273a;
        int m1281a;
        int m1278a2;
        int m1278a3;
        int m1279a;
        int m1277a;
        int m1279a2;
        int m1277a2;
        int m1277a3;
        if (!getClass().equals(c4809j.getClass())) {
            return getClass().getName().compareTo(c4809j.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3407b()).compareTo(Boolean.valueOf(c4809j.m3407b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3407b() && (m1277a3 = C5366b.m1277a(this.f20262a, c4809j.f20262a)) != 0) {
            return m1277a3;
        }
        int compareTo2 = Boolean.valueOf(m3399d()).compareTo(Boolean.valueOf(c4809j.m3399d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3399d() && (m1277a2 = C5366b.m1277a(this.f20263b, c4809j.f20263b)) != 0) {
            return m1277a2;
        }
        int compareTo3 = Boolean.valueOf(m3397f()).compareTo(Boolean.valueOf(c4809j.m3397f()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3397f() && (m1279a2 = C5366b.m1279a(this.f20264c, c4809j.f20264c)) != 0) {
            return m1279a2;
        }
        int compareTo4 = Boolean.valueOf(m3395h()).compareTo(Boolean.valueOf(c4809j.m3395h()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3395h() && (m1277a = C5366b.m1277a(this.f20265d, c4809j.f20265d)) != 0) {
            return m1277a;
        }
        int compareTo5 = Boolean.valueOf(m3393j()).compareTo(Boolean.valueOf(c4809j.m3393j()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3393j() && (m1279a = C5366b.m1279a(this.f20266e, c4809j.f20266e)) != 0) {
            return m1279a;
        }
        int compareTo6 = Boolean.valueOf(m3391l()).compareTo(Boolean.valueOf(c4809j.m3391l()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3391l() && (m1278a3 = C5366b.m1278a(this.f20267f, c4809j.f20267f)) != 0) {
            return m1278a3;
        }
        int compareTo7 = Boolean.valueOf(m3389n()).compareTo(Boolean.valueOf(c4809j.m3389n()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3389n() && (m1278a2 = C5366b.m1278a(this.f20268g, c4809j.f20268g)) != 0) {
            return m1278a2;
        }
        int compareTo8 = Boolean.valueOf(m3387p()).compareTo(Boolean.valueOf(c4809j.m3387p()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3387p() && (m1281a = C5366b.m1281a(this.f20269h, c4809j.f20269h)) != 0) {
            return m1281a;
        }
        int compareTo9 = Boolean.valueOf(m3385r()).compareTo(Boolean.valueOf(c4809j.m3385r()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3385r() && (m1273a = C5366b.m1273a(this.f20270i, c4809j.f20270i)) != 0) {
            return m1273a;
        }
        int compareTo10 = Boolean.valueOf(m3383t()).compareTo(Boolean.valueOf(c4809j.m3383t()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3383t() && (m1278a = C5366b.m1278a(this.f20271j, c4809j.f20271j)) != 0) {
            return m1278a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4809j m3406b(long j) {
        this.f20266e = j;
        m3403b(true);
        return this;
    }

    /* renamed from: b */
    public C4809j m3404b(String str) {
        this.f20263b = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3382u();
        abstractC5373e.mo1250a(f20251l);
        if (this.f20262a != null) {
            abstractC5373e.mo1254a(f20252m);
            abstractC5373e.mo1256a(this.f20262a);
            abstractC5373e.mo1247b();
        }
        if (this.f20263b != null) {
            abstractC5373e.mo1254a(f20253n);
            abstractC5373e.mo1256a(this.f20263b);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f20254o);
        abstractC5373e.mo1257a(this.f20264c);
        abstractC5373e.mo1247b();
        if (this.f20265d != null) {
            abstractC5373e.mo1254a(f20255p);
            abstractC5373e.mo1256a(this.f20265d);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f20256q);
        abstractC5373e.mo1257a(this.f20266e);
        abstractC5373e.mo1247b();
        if (this.f20267f != null) {
            abstractC5373e.mo1254a(f20257r);
            abstractC5373e.mo1258a(this.f20267f.m3380a());
            abstractC5373e.mo1247b();
        }
        if (this.f20268g != null && m3389n()) {
            abstractC5373e.mo1254a(f20258s);
            this.f20268g.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (m3387p()) {
            abstractC5373e.mo1254a(f20259t);
            abstractC5373e.mo1259a(this.f20269h);
            abstractC5373e.mo1247b();
        }
        if (this.f20270i != null && m3385r()) {
            abstractC5373e.mo1254a(f20260u);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f20270i.size()));
            for (C4812l c4812l : this.f20270i) {
                c4812l.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        if (this.f20271j != null) {
            abstractC5373e.mo1254a(f20261v);
            abstractC5373e.mo1258a(this.f20271j.m3433a());
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3403b(boolean z) {
        this.f20272w.set(1, z);
    }

    /* renamed from: b */
    public boolean m3407b() {
        return this.f20262a != null;
    }

    /* renamed from: c */
    public C4809j m3401c(String str) {
        this.f20265d = str;
        return this;
    }

    /* renamed from: c */
    public String m3402c() {
        return this.f20263b;
    }

    /* renamed from: c */
    public void m3400c(boolean z) {
        this.f20272w.set(2, z);
    }

    /* renamed from: d */
    public boolean m3399d() {
        return this.f20263b != null;
    }

    /* renamed from: e */
    public long m3398e() {
        return this.f20264c;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4809j)) {
            return m3413a((C4809j) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3397f() {
        return this.f20272w.get(0);
    }

    /* renamed from: g */
    public String m3396g() {
        return this.f20265d;
    }

    /* renamed from: h */
    public boolean m3395h() {
        return this.f20265d != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public long m3394i() {
        return this.f20266e;
    }

    /* renamed from: j */
    public boolean m3393j() {
        return this.f20272w.get(1);
    }

    /* renamed from: k */
    public EnumC4811k m3392k() {
        return this.f20267f;
    }

    /* renamed from: l */
    public boolean m3391l() {
        return this.f20267f != null;
    }

    /* renamed from: m */
    public C4812l m3390m() {
        return this.f20268g;
    }

    /* renamed from: n */
    public boolean m3389n() {
        return this.f20268g != null;
    }

    /* renamed from: o */
    public double m3388o() {
        return this.f20269h;
    }

    /* renamed from: p */
    public boolean m3387p() {
        return this.f20272w.get(2);
    }

    /* renamed from: q */
    public List<C4812l> m3386q() {
        return this.f20270i;
    }

    /* renamed from: r */
    public boolean m3385r() {
        return this.f20270i != null;
    }

    /* renamed from: s */
    public EnumC4806h m3384s() {
        return this.f20271j;
    }

    /* renamed from: t */
    public boolean m3383t() {
        return this.f20271j != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GeoFencing(");
        sb.append("id:");
        if (this.f20262a == null) {
            sb.append("null");
        } else {
            sb.append(this.f20262a);
        }
        sb.append(", ");
        sb.append("name:");
        if (this.f20263b == null) {
            sb.append("null");
        } else {
            sb.append(this.f20263b);
        }
        sb.append(", ");
        sb.append("appId:");
        sb.append(this.f20264c);
        sb.append(", ");
        sb.append("packageName:");
        if (this.f20265d == null) {
            sb.append("null");
        } else {
            sb.append(this.f20265d);
        }
        sb.append(", ");
        sb.append("createTime:");
        sb.append(this.f20266e);
        sb.append(", ");
        sb.append("type:");
        if (this.f20267f == null) {
            sb.append("null");
        } else {
            sb.append(this.f20267f);
        }
        if (m3389n()) {
            sb.append(", ");
            sb.append("circleCenter:");
            if (this.f20268g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20268g);
            }
        }
        if (m3387p()) {
            sb.append(", ");
            sb.append("circleRadius:");
            sb.append(this.f20269h);
        }
        if (m3385r()) {
            sb.append(", ");
            sb.append("polygonPoints:");
            if (this.f20270i == null) {
                sb.append("null");
            } else {
                sb.append(this.f20270i);
            }
        }
        sb.append(", ");
        sb.append("coordinateProvider:");
        if (this.f20271j == null) {
            sb.append("null");
        } else {
            sb.append(this.f20271j);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public void m3382u() {
        if (this.f20262a == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f20263b == null) {
            throw new C5374f("Required field 'name' was not present! Struct: " + toString());
        }
        if (this.f20265d == null) {
            throw new C5374f("Required field 'packageName' was not present! Struct: " + toString());
        }
        if (this.f20267f == null) {
            throw new C5374f("Required field 'type' was not present! Struct: " + toString());
        }
        if (this.f20271j != null) {
            return;
        }
        throw new C5374f("Required field 'coordinateProvider' was not present! Struct: " + toString());
    }
}
