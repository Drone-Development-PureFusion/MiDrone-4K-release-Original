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
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.p */
/* loaded from: classes2.dex */
public class C4819p implements Serializable, Cloneable, AbstractC5358a<C4819p, EnumC4820a> {

    /* renamed from: h */
    public static final Map<EnumC4820a, C5360b> f20377h;

    /* renamed from: i */
    private static final C5378j f20378i = new C5378j("OnlineConfigItem");

    /* renamed from: j */
    private static final C5370b f20379j = new C5370b("key", (byte) 8, 1);

    /* renamed from: k */
    private static final C5370b f20380k = new C5370b("type", (byte) 8, 2);

    /* renamed from: l */
    private static final C5370b f20381l = new C5370b("clear", (byte) 2, 3);

    /* renamed from: m */
    private static final C5370b f20382m = new C5370b("intValue", (byte) 8, 4);

    /* renamed from: n */
    private static final C5370b f20383n = new C5370b("longValue", (byte) 10, 5);

    /* renamed from: o */
    private static final C5370b f20384o = new C5370b("stringValue", (byte) 11, 6);

    /* renamed from: p */
    private static final C5370b f20385p = new C5370b("boolValue", (byte) 2, 7);

    /* renamed from: a */
    public int f20386a;

    /* renamed from: b */
    public int f20387b;

    /* renamed from: c */
    public boolean f20388c;

    /* renamed from: d */
    public int f20389d;

    /* renamed from: e */
    public long f20390e;

    /* renamed from: f */
    public String f20391f;

    /* renamed from: g */
    public boolean f20392g;

    /* renamed from: q */
    private BitSet f20393q = new BitSet(6);

    /* renamed from: com.xiaomi.xmpush.thrift.p$a */
    /* loaded from: classes2.dex */
    public enum EnumC4820a {
        KEY(1, "key"),
        TYPE(2, "type"),
        CLEAR(3, "clear"),
        INT_VALUE(4, "intValue"),
        LONG_VALUE(5, "longValue"),
        STRING_VALUE(6, "stringValue"),
        BOOL_VALUE(7, "boolValue");
        

        /* renamed from: h */
        private static final Map<String, EnumC4820a> f20401h = new HashMap();

        /* renamed from: i */
        private final short f20403i;

        /* renamed from: j */
        private final String f20404j;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4820a.class).iterator();
            while (it2.hasNext()) {
                EnumC4820a enumC4820a = (EnumC4820a) it2.next();
                f20401h.put(enumC4820a.m3324a(), enumC4820a);
            }
        }

        EnumC4820a(short s, String str) {
            this.f20403i = s;
            this.f20404j = str;
        }

        /* renamed from: a */
        public String m3324a() {
            return this.f20404j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4820a.class);
        enumMap.put((EnumMap) EnumC4820a.KEY, (EnumC4820a) new C5360b("key", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4820a.TYPE, (EnumC4820a) new C5360b("type", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4820a.CLEAR, (EnumC4820a) new C5360b("clear", (byte) 2, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4820a.INT_VALUE, (EnumC4820a) new C5360b("intValue", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4820a.LONG_VALUE, (EnumC4820a) new C5360b("longValue", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4820a.STRING_VALUE, (EnumC4820a) new C5360b("stringValue", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4820a.BOOL_VALUE, (EnumC4820a) new C5360b("boolValue", (byte) 2, new C5361c((byte) 2)));
        f20377h = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4819p.class, f20377h);
    }

    /* renamed from: a */
    public int m3346a() {
        return this.f20386a;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3325n();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20386a = abstractC5373e.mo1232t();
                        m3344a(true);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20387b = abstractC5373e.mo1232t();
                        m3341b(true);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 2) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20388c = abstractC5373e.mo1235q();
                        m3339c(true);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20389d = abstractC5373e.mo1232t();
                        m3337d(true);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20390e = abstractC5373e.mo1231u();
                        m3335e(true);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20391f = abstractC5373e.mo1223w();
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 2) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20392g = abstractC5373e.mo1235q();
                        m3333f(true);
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
    public void m3344a(boolean z) {
        this.f20393q.set(0, z);
    }

    /* renamed from: a */
    public boolean m3345a(C4819p c4819p) {
        if (c4819p == null) {
            return false;
        }
        boolean m3343b = m3343b();
        boolean m3343b2 = c4819p.m3343b();
        if ((m3343b || m3343b2) && (!m3343b || !m3343b2 || this.f20386a != c4819p.f20386a)) {
            return false;
        }
        boolean m3338d = m3338d();
        boolean m3338d2 = c4819p.m3338d();
        if ((m3338d || m3338d2) && (!m3338d || !m3338d2 || this.f20387b != c4819p.f20387b)) {
            return false;
        }
        boolean m3336e = m3336e();
        boolean m3336e2 = c4819p.m3336e();
        if ((m3336e || m3336e2) && (!m3336e || !m3336e2 || this.f20388c != c4819p.f20388c)) {
            return false;
        }
        boolean m3332g = m3332g();
        boolean m3332g2 = c4819p.m3332g();
        if ((m3332g || m3332g2) && (!m3332g || !m3332g2 || this.f20389d != c4819p.f20389d)) {
            return false;
        }
        boolean m3330i = m3330i();
        boolean m3330i2 = c4819p.m3330i();
        if ((m3330i || m3330i2) && (!m3330i || !m3330i2 || this.f20390e != c4819p.f20390e)) {
            return false;
        }
        boolean m3328k = m3328k();
        boolean m3328k2 = c4819p.m3328k();
        if ((m3328k || m3328k2) && (!m3328k || !m3328k2 || !this.f20391f.equals(c4819p.f20391f))) {
            return false;
        }
        boolean m3326m = m3326m();
        boolean m3326m2 = c4819p.m3326m();
        return (!m3326m && !m3326m2) || (m3326m && m3326m2 && this.f20392g == c4819p.f20392g);
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4819p c4819p) {
        int m1269a;
        int m1277a;
        int m1279a;
        int m1280a;
        int m1269a2;
        int m1280a2;
        int m1280a3;
        if (!getClass().equals(c4819p.getClass())) {
            return getClass().getName().compareTo(c4819p.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3343b()).compareTo(Boolean.valueOf(c4819p.m3343b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3343b() && (m1280a3 = C5366b.m1280a(this.f20386a, c4819p.f20386a)) != 0) {
            return m1280a3;
        }
        int compareTo2 = Boolean.valueOf(m3338d()).compareTo(Boolean.valueOf(c4819p.m3338d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3338d() && (m1280a2 = C5366b.m1280a(this.f20387b, c4819p.f20387b)) != 0) {
            return m1280a2;
        }
        int compareTo3 = Boolean.valueOf(m3336e()).compareTo(Boolean.valueOf(c4819p.m3336e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3336e() && (m1269a2 = C5366b.m1269a(this.f20388c, c4819p.f20388c)) != 0) {
            return m1269a2;
        }
        int compareTo4 = Boolean.valueOf(m3332g()).compareTo(Boolean.valueOf(c4819p.m3332g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3332g() && (m1280a = C5366b.m1280a(this.f20389d, c4819p.f20389d)) != 0) {
            return m1280a;
        }
        int compareTo5 = Boolean.valueOf(m3330i()).compareTo(Boolean.valueOf(c4819p.m3330i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3330i() && (m1279a = C5366b.m1279a(this.f20390e, c4819p.f20390e)) != 0) {
            return m1279a;
        }
        int compareTo6 = Boolean.valueOf(m3328k()).compareTo(Boolean.valueOf(c4819p.m3328k()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3328k() && (m1277a = C5366b.m1277a(this.f20391f, c4819p.f20391f)) != 0) {
            return m1277a;
        }
        int compareTo7 = Boolean.valueOf(m3326m()).compareTo(Boolean.valueOf(c4819p.m3326m()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3326m() && (m1269a = C5366b.m1269a(this.f20392g, c4819p.f20392g)) != 0) {
            return m1269a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3325n();
        abstractC5373e.mo1250a(f20378i);
        if (m3343b()) {
            abstractC5373e.mo1254a(f20379j);
            abstractC5373e.mo1258a(this.f20386a);
            abstractC5373e.mo1247b();
        }
        if (m3338d()) {
            abstractC5373e.mo1254a(f20380k);
            abstractC5373e.mo1258a(this.f20387b);
            abstractC5373e.mo1247b();
        }
        if (m3336e()) {
            abstractC5373e.mo1254a(f20381l);
            abstractC5373e.mo1248a(this.f20388c);
            abstractC5373e.mo1247b();
        }
        if (m3332g()) {
            abstractC5373e.mo1254a(f20382m);
            abstractC5373e.mo1258a(this.f20389d);
            abstractC5373e.mo1247b();
        }
        if (m3330i()) {
            abstractC5373e.mo1254a(f20383n);
            abstractC5373e.mo1257a(this.f20390e);
            abstractC5373e.mo1247b();
        }
        if (this.f20391f != null && m3328k()) {
            abstractC5373e.mo1254a(f20384o);
            abstractC5373e.mo1256a(this.f20391f);
            abstractC5373e.mo1247b();
        }
        if (m3326m()) {
            abstractC5373e.mo1254a(f20385p);
            abstractC5373e.mo1248a(this.f20392g);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3341b(boolean z) {
        this.f20393q.set(1, z);
    }

    /* renamed from: b */
    public boolean m3343b() {
        return this.f20393q.get(0);
    }

    /* renamed from: c */
    public int m3340c() {
        return this.f20387b;
    }

    /* renamed from: c */
    public void m3339c(boolean z) {
        this.f20393q.set(2, z);
    }

    /* renamed from: d */
    public void m3337d(boolean z) {
        this.f20393q.set(3, z);
    }

    /* renamed from: d */
    public boolean m3338d() {
        return this.f20393q.get(1);
    }

    /* renamed from: e */
    public void m3335e(boolean z) {
        this.f20393q.set(4, z);
    }

    /* renamed from: e */
    public boolean m3336e() {
        return this.f20393q.get(2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4819p)) {
            return m3345a((C4819p) obj);
        }
        return false;
    }

    /* renamed from: f */
    public int m3334f() {
        return this.f20389d;
    }

    /* renamed from: f */
    public void m3333f(boolean z) {
        this.f20393q.set(5, z);
    }

    /* renamed from: g */
    public boolean m3332g() {
        return this.f20393q.get(3);
    }

    /* renamed from: h */
    public long m3331h() {
        return this.f20390e;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3330i() {
        return this.f20393q.get(4);
    }

    /* renamed from: j */
    public String m3329j() {
        return this.f20391f;
    }

    /* renamed from: k */
    public boolean m3328k() {
        return this.f20391f != null;
    }

    /* renamed from: l */
    public boolean m3327l() {
        return this.f20392g;
    }

    /* renamed from: m */
    public boolean m3326m() {
        return this.f20393q.get(5);
    }

    /* renamed from: n */
    public void m3325n() {
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m3343b()) {
            sb.append("key:");
            sb.append(this.f20386a);
            z2 = false;
        }
        if (m3338d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f20387b);
            z2 = false;
        }
        if (m3336e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f20388c);
            z2 = false;
        }
        if (m3332g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f20389d);
            z2 = false;
        }
        if (m3330i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f20390e);
            z2 = false;
        }
        if (m3328k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f20391f == null) {
                sb.append("null");
            } else {
                sb.append(this.f20391f);
            }
        } else {
            z = z2;
        }
        if (m3326m()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f20392g);
        }
        sb.append(")");
        return sb.toString();
    }
}
