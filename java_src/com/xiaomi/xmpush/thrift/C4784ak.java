package com.xiaomi.xmpush.thrift;

import com.p219mi.live.openlivesdk.C4093a;
import java.io.Serializable;
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
/* renamed from: com.xiaomi.xmpush.thrift.ak */
/* loaded from: classes2.dex */
public class C4784ak implements Serializable, Cloneable, AbstractC5358a<C4784ak, EnumC4785a> {

    /* renamed from: h */
    public static final Map<EnumC4785a, C5360b> f19921h;

    /* renamed from: i */
    private static final C5378j f19922i = new C5378j("XmPushActionSubscription");

    /* renamed from: j */
    private static final C5370b f19923j = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: k */
    private static final C5370b f19924k = new C5370b("target", (byte) 12, 2);

    /* renamed from: l */
    private static final C5370b f19925l = new C5370b("id", (byte) 11, 3);

    /* renamed from: m */
    private static final C5370b f19926m = new C5370b("appId", (byte) 11, 4);

    /* renamed from: n */
    private static final C5370b f19927n = new C5370b("topic", (byte) 11, 5);

    /* renamed from: o */
    private static final C5370b f19928o = new C5370b("packageName", (byte) 11, 6);

    /* renamed from: p */
    private static final C5370b f19929p = new C5370b("category", (byte) 11, 7);

    /* renamed from: a */
    public String f19930a;

    /* renamed from: b */
    public C4828u f19931b;

    /* renamed from: c */
    public String f19932c;

    /* renamed from: d */
    public String f19933d;

    /* renamed from: e */
    public String f19934e;

    /* renamed from: f */
    public String f19935f;

    /* renamed from: g */
    public String f19936g;

    /* renamed from: com.xiaomi.xmpush.thrift.ak$a */
    /* loaded from: classes2.dex */
    public enum EnumC4785a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        TOPIC(5, "topic"),
        PACKAGE_NAME(6, "packageName"),
        CATEGORY(7, "category");
        

        /* renamed from: h */
        private static final Map<String, EnumC4785a> f19944h = new HashMap();

        /* renamed from: i */
        private final short f19946i;

        /* renamed from: j */
        private final String f19947j;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4785a.class).iterator();
            while (it2.hasNext()) {
                EnumC4785a enumC4785a = (EnumC4785a) it2.next();
                f19944h.put(enumC4785a.m3555a(), enumC4785a);
            }
        }

        EnumC4785a(short s, String str) {
            this.f19946i = s;
            this.f19947j = str;
        }

        /* renamed from: a */
        public String m3555a() {
            return this.f19947j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4785a.class);
        enumMap.put((EnumMap) EnumC4785a.DEBUG, (EnumC4785a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4785a.TARGET, (EnumC4785a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4785a.ID, (EnumC4785a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4785a.APP_ID, (EnumC4785a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4785a.TOPIC, (EnumC4785a) new C5360b("topic", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4785a.PACKAGE_NAME, (EnumC4785a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4785a.CATEGORY, (EnumC4785a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f19921h = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4784ak.class, f19921h);
    }

    /* renamed from: a */
    public C4784ak m3568a(String str) {
        this.f19932c = str;
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
                m3556h();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19930a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19931b = new C4828u();
                        this.f19931b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19932c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19933d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19934e = abstractC5373e.mo1223w();
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19935f = abstractC5373e.mo1223w();
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19936g = abstractC5373e.mo1223w();
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
    public boolean m3570a() {
        return this.f19930a != null;
    }

    /* renamed from: a */
    public boolean m3569a(C4784ak c4784ak) {
        if (c4784ak == null) {
            return false;
        }
        boolean m3570a = m3570a();
        boolean m3570a2 = c4784ak.m3570a();
        if ((m3570a || m3570a2) && (!m3570a || !m3570a2 || !this.f19930a.equals(c4784ak.f19930a))) {
            return false;
        }
        boolean m3567b = m3567b();
        boolean m3567b2 = c4784ak.m3567b();
        if ((m3567b || m3567b2) && (!m3567b || !m3567b2 || !this.f19931b.m3254a(c4784ak.f19931b))) {
            return false;
        }
        boolean m3564c = m3564c();
        boolean m3564c2 = c4784ak.m3564c();
        if ((m3564c || m3564c2) && (!m3564c || !m3564c2 || !this.f19932c.equals(c4784ak.f19932c))) {
            return false;
        }
        boolean m3562d = m3562d();
        boolean m3562d2 = c4784ak.m3562d();
        if ((m3562d || m3562d2) && (!m3562d || !m3562d2 || !this.f19933d.equals(c4784ak.f19933d))) {
            return false;
        }
        boolean m3560e = m3560e();
        boolean m3560e2 = c4784ak.m3560e();
        if ((m3560e || m3560e2) && (!m3560e || !m3560e2 || !this.f19934e.equals(c4784ak.f19934e))) {
            return false;
        }
        boolean m3558f = m3558f();
        boolean m3558f2 = c4784ak.m3558f();
        if ((m3558f || m3558f2) && (!m3558f || !m3558f2 || !this.f19935f.equals(c4784ak.f19935f))) {
            return false;
        }
        boolean m3557g = m3557g();
        boolean m3557g2 = c4784ak.m3557g();
        return (!m3557g && !m3557g2) || (m3557g && m3557g2 && this.f19936g.equals(c4784ak.f19936g));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4784ak c4784ak) {
        int m1277a;
        int m1277a2;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1278a;
        int m1277a6;
        if (!getClass().equals(c4784ak.getClass())) {
            return getClass().getName().compareTo(c4784ak.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3570a()).compareTo(Boolean.valueOf(c4784ak.m3570a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3570a() && (m1277a6 = C5366b.m1277a(this.f19930a, c4784ak.f19930a)) != 0) {
            return m1277a6;
        }
        int compareTo2 = Boolean.valueOf(m3567b()).compareTo(Boolean.valueOf(c4784ak.m3567b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3567b() && (m1278a = C5366b.m1278a(this.f19931b, c4784ak.f19931b)) != 0) {
            return m1278a;
        }
        int compareTo3 = Boolean.valueOf(m3564c()).compareTo(Boolean.valueOf(c4784ak.m3564c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3564c() && (m1277a5 = C5366b.m1277a(this.f19932c, c4784ak.f19932c)) != 0) {
            return m1277a5;
        }
        int compareTo4 = Boolean.valueOf(m3562d()).compareTo(Boolean.valueOf(c4784ak.m3562d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3562d() && (m1277a4 = C5366b.m1277a(this.f19933d, c4784ak.f19933d)) != 0) {
            return m1277a4;
        }
        int compareTo5 = Boolean.valueOf(m3560e()).compareTo(Boolean.valueOf(c4784ak.m3560e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3560e() && (m1277a3 = C5366b.m1277a(this.f19934e, c4784ak.f19934e)) != 0) {
            return m1277a3;
        }
        int compareTo6 = Boolean.valueOf(m3558f()).compareTo(Boolean.valueOf(c4784ak.m3558f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3558f() && (m1277a2 = C5366b.m1277a(this.f19935f, c4784ak.f19935f)) != 0) {
            return m1277a2;
        }
        int compareTo7 = Boolean.valueOf(m3557g()).compareTo(Boolean.valueOf(c4784ak.m3557g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3557g() && (m1277a = C5366b.m1277a(this.f19936g, c4784ak.f19936g)) != 0) {
            return m1277a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4784ak m3565b(String str) {
        this.f19933d = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3556h();
        abstractC5373e.mo1250a(f19922i);
        if (this.f19930a != null && m3570a()) {
            abstractC5373e.mo1254a(f19923j);
            abstractC5373e.mo1256a(this.f19930a);
            abstractC5373e.mo1247b();
        }
        if (this.f19931b != null && m3567b()) {
            abstractC5373e.mo1254a(f19924k);
            this.f19931b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19932c != null) {
            abstractC5373e.mo1254a(f19925l);
            abstractC5373e.mo1256a(this.f19932c);
            abstractC5373e.mo1247b();
        }
        if (this.f19933d != null) {
            abstractC5373e.mo1254a(f19926m);
            abstractC5373e.mo1256a(this.f19933d);
            abstractC5373e.mo1247b();
        }
        if (this.f19934e != null) {
            abstractC5373e.mo1254a(f19927n);
            abstractC5373e.mo1256a(this.f19934e);
            abstractC5373e.mo1247b();
        }
        if (this.f19935f != null && m3558f()) {
            abstractC5373e.mo1254a(f19928o);
            abstractC5373e.mo1256a(this.f19935f);
            abstractC5373e.mo1247b();
        }
        if (this.f19936g != null && m3557g()) {
            abstractC5373e.mo1254a(f19929p);
            abstractC5373e.mo1256a(this.f19936g);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3567b() {
        return this.f19931b != null;
    }

    /* renamed from: c */
    public C4784ak m3563c(String str) {
        this.f19934e = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3564c() {
        return this.f19932c != null;
    }

    /* renamed from: d */
    public C4784ak m3561d(String str) {
        this.f19935f = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3562d() {
        return this.f19933d != null;
    }

    /* renamed from: e */
    public C4784ak m3559e(String str) {
        this.f19936g = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3560e() {
        return this.f19934e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4784ak)) {
            return m3569a((C4784ak) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3558f() {
        return this.f19935f != null;
    }

    /* renamed from: g */
    public boolean m3557g() {
        return this.f19936g != null;
    }

    /* renamed from: h */
    public void m3556h() {
        if (this.f19932c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f19933d == null) {
            throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f19934e != null) {
            return;
        }
        throw new C5374f("Required field 'topic' was not present! Struct: " + toString());
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m3570a()) {
            sb.append("debug:");
            if (this.f19930a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19930a);
            }
            z2 = false;
        }
        if (m3567b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19931b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19931b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19932c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19932c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f19933d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19933d);
        }
        sb.append(", ");
        sb.append("topic:");
        if (this.f19934e == null) {
            sb.append("null");
        } else {
            sb.append(this.f19934e);
        }
        if (m3558f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19935f == null) {
                sb.append("null");
            } else {
                sb.append(this.f19935f);
            }
        }
        if (m3557g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f19936g == null) {
                sb.append("null");
            } else {
                sb.append(this.f19936g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
