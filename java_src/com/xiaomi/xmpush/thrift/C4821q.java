package com.xiaomi.xmpush.thrift;

import com.fimi.soul.utils.p211a.C3628c;
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
/* renamed from: com.xiaomi.xmpush.thrift.q */
/* loaded from: classes2.dex */
public class C4821q implements Serializable, Cloneable, AbstractC5358a<C4821q, EnumC4822a> {

    /* renamed from: i */
    public static final Map<EnumC4822a, C5360b> f20405i;

    /* renamed from: j */
    private static final C5378j f20406j = new C5378j("PushMessage");

    /* renamed from: k */
    private static final C5370b f20407k = new C5370b("to", (byte) 12, 1);

    /* renamed from: l */
    private static final C5370b f20408l = new C5370b("id", (byte) 11, 2);

    /* renamed from: m */
    private static final C5370b f20409m = new C5370b("appId", (byte) 11, 3);

    /* renamed from: n */
    private static final C5370b f20410n = new C5370b(C3628c.C3629a.f14771d, (byte) 11, 4);

    /* renamed from: o */
    private static final C5370b f20411o = new C5370b("createAt", (byte) 10, 5);

    /* renamed from: p */
    private static final C5370b f20412p = new C5370b("ttl", (byte) 10, 6);

    /* renamed from: q */
    private static final C5370b f20413q = new C5370b("collapseKey", (byte) 11, 7);

    /* renamed from: r */
    private static final C5370b f20414r = new C5370b("packageName", (byte) 11, 8);

    /* renamed from: a */
    public C4828u f20415a;

    /* renamed from: b */
    public String f20416b;

    /* renamed from: c */
    public String f20417c;

    /* renamed from: d */
    public String f20418d;

    /* renamed from: e */
    public long f20419e;

    /* renamed from: f */
    public long f20420f;

    /* renamed from: g */
    public String f20421g;

    /* renamed from: h */
    public String f20422h;

    /* renamed from: s */
    private BitSet f20423s = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.q$a */
    /* loaded from: classes2.dex */
    public enum EnumC4822a {
        TO(1, "to"),
        ID(2, "id"),
        APP_ID(3, "appId"),
        PAYLOAD(4, C3628c.C3629a.f14771d),
        CREATE_AT(5, "createAt"),
        TTL(6, "ttl"),
        COLLAPSE_KEY(7, "collapseKey"),
        PACKAGE_NAME(8, "packageName");
        

        /* renamed from: i */
        private static final Map<String, EnumC4822a> f20432i = new HashMap();

        /* renamed from: j */
        private final short f20434j;

        /* renamed from: k */
        private final String f20435k;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4822a.class).iterator();
            while (it2.hasNext()) {
                EnumC4822a enumC4822a = (EnumC4822a) it2.next();
                f20432i.put(enumC4822a.m3306a(), enumC4822a);
            }
        }

        EnumC4822a(short s, String str) {
            this.f20434j = s;
            this.f20435k = str;
        }

        /* renamed from: a */
        public String m3306a() {
            return this.f20435k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4822a.class);
        enumMap.put((EnumMap) EnumC4822a.TO, (EnumC4822a) new C5360b("to", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4822a.ID, (EnumC4822a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4822a.APP_ID, (EnumC4822a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4822a.PAYLOAD, (EnumC4822a) new C5360b(C3628c.C3629a.f14771d, (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4822a.CREATE_AT, (EnumC4822a) new C5360b("createAt", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4822a.TTL, (EnumC4822a) new C5360b("ttl", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4822a.COLLAPSE_KEY, (EnumC4822a) new C5360b("collapseKey", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4822a.PACKAGE_NAME, (EnumC4822a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        f20405i = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4821q.class, f20405i);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3307m();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20415a = new C4828u();
                        this.f20415a.mo1286a(abstractC5373e);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20416b = abstractC5373e.mo1223w();
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20417c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20418d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20419e = abstractC5373e.mo1231u();
                        m3321a(true);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20420f = abstractC5373e.mo1231u();
                        m3318b(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20421g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20422h = abstractC5373e.mo1223w();
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
    public void m3321a(boolean z) {
        this.f20423s.set(0, z);
    }

    /* renamed from: a */
    public boolean m3323a() {
        return this.f20415a != null;
    }

    /* renamed from: a */
    public boolean m3322a(C4821q c4821q) {
        if (c4821q == null) {
            return false;
        }
        boolean m3323a = m3323a();
        boolean m3323a2 = c4821q.m3323a();
        if ((m3323a || m3323a2) && (!m3323a || !m3323a2 || !this.f20415a.m3254a(c4821q.f20415a))) {
            return false;
        }
        boolean m3317c = m3317c();
        boolean m3317c2 = c4821q.m3317c();
        if ((m3317c || m3317c2) && (!m3317c || !m3317c2 || !this.f20416b.equals(c4821q.f20416b))) {
            return false;
        }
        boolean m3315e = m3315e();
        boolean m3315e2 = c4821q.m3315e();
        if ((m3315e || m3315e2) && (!m3315e || !m3315e2 || !this.f20417c.equals(c4821q.f20417c))) {
            return false;
        }
        boolean m3313g = m3313g();
        boolean m3313g2 = c4821q.m3313g();
        if ((m3313g || m3313g2) && (!m3313g || !m3313g2 || !this.f20418d.equals(c4821q.f20418d))) {
            return false;
        }
        boolean m3311i = m3311i();
        boolean m3311i2 = c4821q.m3311i();
        if ((m3311i || m3311i2) && (!m3311i || !m3311i2 || this.f20419e != c4821q.f20419e)) {
            return false;
        }
        boolean m3310j = m3310j();
        boolean m3310j2 = c4821q.m3310j();
        if ((m3310j || m3310j2) && (!m3310j || !m3310j2 || this.f20420f != c4821q.f20420f)) {
            return false;
        }
        boolean m3309k = m3309k();
        boolean m3309k2 = c4821q.m3309k();
        if ((m3309k || m3309k2) && (!m3309k || !m3309k2 || !this.f20421g.equals(c4821q.f20421g))) {
            return false;
        }
        boolean m3308l = m3308l();
        boolean m3308l2 = c4821q.m3308l();
        return (!m3308l && !m3308l2) || (m3308l && m3308l2 && this.f20422h.equals(c4821q.f20422h));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4821q c4821q) {
        int m1277a;
        int m1277a2;
        int m1279a;
        int m1279a2;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1278a;
        if (!getClass().equals(c4821q.getClass())) {
            return getClass().getName().compareTo(c4821q.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3323a()).compareTo(Boolean.valueOf(c4821q.m3323a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3323a() && (m1278a = C5366b.m1278a(this.f20415a, c4821q.f20415a)) != 0) {
            return m1278a;
        }
        int compareTo2 = Boolean.valueOf(m3317c()).compareTo(Boolean.valueOf(c4821q.m3317c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3317c() && (m1277a5 = C5366b.m1277a(this.f20416b, c4821q.f20416b)) != 0) {
            return m1277a5;
        }
        int compareTo3 = Boolean.valueOf(m3315e()).compareTo(Boolean.valueOf(c4821q.m3315e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3315e() && (m1277a4 = C5366b.m1277a(this.f20417c, c4821q.f20417c)) != 0) {
            return m1277a4;
        }
        int compareTo4 = Boolean.valueOf(m3313g()).compareTo(Boolean.valueOf(c4821q.m3313g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3313g() && (m1277a3 = C5366b.m1277a(this.f20418d, c4821q.f20418d)) != 0) {
            return m1277a3;
        }
        int compareTo5 = Boolean.valueOf(m3311i()).compareTo(Boolean.valueOf(c4821q.m3311i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3311i() && (m1279a2 = C5366b.m1279a(this.f20419e, c4821q.f20419e)) != 0) {
            return m1279a2;
        }
        int compareTo6 = Boolean.valueOf(m3310j()).compareTo(Boolean.valueOf(c4821q.m3310j()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3310j() && (m1279a = C5366b.m1279a(this.f20420f, c4821q.f20420f)) != 0) {
            return m1279a;
        }
        int compareTo7 = Boolean.valueOf(m3309k()).compareTo(Boolean.valueOf(c4821q.m3309k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3309k() && (m1277a2 = C5366b.m1277a(this.f20421g, c4821q.f20421g)) != 0) {
            return m1277a2;
        }
        int compareTo8 = Boolean.valueOf(m3308l()).compareTo(Boolean.valueOf(c4821q.m3308l()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3308l() && (m1277a = C5366b.m1277a(this.f20422h, c4821q.f20422h)) != 0) {
            return m1277a;
        }
        return 0;
    }

    /* renamed from: b */
    public String m3320b() {
        return this.f20416b;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3307m();
        abstractC5373e.mo1250a(f20406j);
        if (this.f20415a != null && m3323a()) {
            abstractC5373e.mo1254a(f20407k);
            this.f20415a.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20416b != null) {
            abstractC5373e.mo1254a(f20408l);
            abstractC5373e.mo1256a(this.f20416b);
            abstractC5373e.mo1247b();
        }
        if (this.f20417c != null) {
            abstractC5373e.mo1254a(f20409m);
            abstractC5373e.mo1256a(this.f20417c);
            abstractC5373e.mo1247b();
        }
        if (this.f20418d != null) {
            abstractC5373e.mo1254a(f20410n);
            abstractC5373e.mo1256a(this.f20418d);
            abstractC5373e.mo1247b();
        }
        if (m3311i()) {
            abstractC5373e.mo1254a(f20411o);
            abstractC5373e.mo1257a(this.f20419e);
            abstractC5373e.mo1247b();
        }
        if (m3310j()) {
            abstractC5373e.mo1254a(f20412p);
            abstractC5373e.mo1257a(this.f20420f);
            abstractC5373e.mo1247b();
        }
        if (this.f20421g != null && m3309k()) {
            abstractC5373e.mo1254a(f20413q);
            abstractC5373e.mo1256a(this.f20421g);
            abstractC5373e.mo1247b();
        }
        if (this.f20422h != null && m3308l()) {
            abstractC5373e.mo1254a(f20414r);
            abstractC5373e.mo1256a(this.f20422h);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3318b(boolean z) {
        this.f20423s.set(1, z);
    }

    /* renamed from: c */
    public boolean m3317c() {
        return this.f20416b != null;
    }

    /* renamed from: d */
    public String m3316d() {
        return this.f20417c;
    }

    /* renamed from: e */
    public boolean m3315e() {
        return this.f20417c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4821q)) {
            return m3322a((C4821q) obj);
        }
        return false;
    }

    /* renamed from: f */
    public String m3314f() {
        return this.f20418d;
    }

    /* renamed from: g */
    public boolean m3313g() {
        return this.f20418d != null;
    }

    /* renamed from: h */
    public long m3312h() {
        return this.f20419e;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3311i() {
        return this.f20423s.get(0);
    }

    /* renamed from: j */
    public boolean m3310j() {
        return this.f20423s.get(1);
    }

    /* renamed from: k */
    public boolean m3309k() {
        return this.f20421g != null;
    }

    /* renamed from: l */
    public boolean m3308l() {
        return this.f20422h != null;
    }

    /* renamed from: m */
    public void m3307m() {
        if (this.f20416b == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f20417c == null) {
            throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f20418d != null) {
            return;
        }
        throw new C5374f("Required field 'payload' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m3323a()) {
            sb.append("to:");
            if (this.f20415a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20415a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f20416b == null) {
            sb.append("null");
        } else {
            sb.append(this.f20416b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f20417c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20417c);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f20418d == null) {
            sb.append("null");
        } else {
            sb.append(this.f20418d);
        }
        if (m3311i()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f20419e);
        }
        if (m3310j()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f20420f);
        }
        if (m3309k()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f20421g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20421g);
            }
        }
        if (m3308l()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20422h == null) {
                sb.append("null");
            } else {
                sb.append(this.f20422h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
