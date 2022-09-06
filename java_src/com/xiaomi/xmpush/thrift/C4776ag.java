package com.xiaomi.xmpush.thrift;

import com.p219mi.live.openlivesdk.C4093a;
import com.tencent.open.SocialConstants;
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
/* renamed from: com.xiaomi.xmpush.thrift.ag */
/* loaded from: classes2.dex */
public class C4776ag implements Serializable, Cloneable, AbstractC5358a<C4776ag, EnumC4777a> {

    /* renamed from: k */
    public static final Map<EnumC4777a, C5360b> f19786k;

    /* renamed from: l */
    private static final C5378j f19787l = new C5378j("XmPushActionRegistrationResult");

    /* renamed from: m */
    private static final C5370b f19788m = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: n */
    private static final C5370b f19789n = new C5370b("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C5370b f19790o = new C5370b("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C5370b f19791p = new C5370b("appId", (byte) 11, 4);

    /* renamed from: q */
    private static final C5370b f19792q = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 5);

    /* renamed from: r */
    private static final C5370b f19793r = new C5370b("errorCode", (byte) 10, 6);

    /* renamed from: s */
    private static final C5370b f19794s = new C5370b("reason", (byte) 11, 7);

    /* renamed from: t */
    private static final C5370b f19795t = new C5370b("regId", (byte) 11, 8);

    /* renamed from: u */
    private static final C5370b f19796u = new C5370b("regSecret", (byte) 11, 9);

    /* renamed from: v */
    private static final C5370b f19797v = new C5370b("packageName", (byte) 11, 10);

    /* renamed from: a */
    public String f19798a;

    /* renamed from: b */
    public C4828u f19799b;

    /* renamed from: c */
    public String f19800c;

    /* renamed from: d */
    public String f19801d;

    /* renamed from: e */
    public C4774af f19802e;

    /* renamed from: f */
    public long f19803f;

    /* renamed from: g */
    public String f19804g;

    /* renamed from: h */
    public String f19805h;

    /* renamed from: i */
    public String f19806i;

    /* renamed from: j */
    public String f19807j;

    /* renamed from: w */
    private BitSet f19808w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.ag$a */
    /* loaded from: classes2.dex */
    public enum EnumC4777a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        REQUEST(5, SocialConstants.TYPE_REQUEST),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        REG_ID(8, "regId"),
        REG_SECRET(9, "regSecret"),
        PACKAGE_NAME(10, "packageName");
        

        /* renamed from: k */
        private static final Map<String, EnumC4777a> f19819k = new HashMap();

        /* renamed from: l */
        private final short f19821l;

        /* renamed from: m */
        private final String f19822m;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4777a.class).iterator();
            while (it2.hasNext()) {
                EnumC4777a enumC4777a = (EnumC4777a) it2.next();
                f19819k.put(enumC4777a.m3618a(), enumC4777a);
            }
        }

        EnumC4777a(short s, String str) {
            this.f19821l = s;
            this.f19822m = str;
        }

        /* renamed from: a */
        public String m3618a() {
            return this.f19822m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4777a.class);
        enumMap.put((EnumMap) EnumC4777a.DEBUG, (EnumC4777a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4777a.TARGET, (EnumC4777a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4777a.ID, (EnumC4777a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4777a.APP_ID, (EnumC4777a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4777a.REQUEST, (EnumC4777a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4774af.class)));
        enumMap.put((EnumMap) EnumC4777a.ERROR_CODE, (EnumC4777a) new C5360b("errorCode", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4777a.REASON, (EnumC4777a) new C5360b("reason", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4777a.REG_ID, (EnumC4777a) new C5360b("regId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4777a.REG_SECRET, (EnumC4777a) new C5360b("regSecret", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4777a.PACKAGE_NAME, (EnumC4777a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        f19786k = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4776ag.class, f19786k);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3624f()) {
                    throw new C5374f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3619k();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19798a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19799b = new C4828u();
                        this.f19799b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19800c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19801d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19802e = new C4774af();
                        this.f19802e.mo1286a(abstractC5373e);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19803f = abstractC5373e.mo1231u();
                        m3630a(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19804g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19805h = abstractC5373e.mo1223w();
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19806i = abstractC5373e.mo1223w();
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19807j = abstractC5373e.mo1223w();
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
    public void m3630a(boolean z) {
        this.f19808w.set(0, z);
    }

    /* renamed from: a */
    public boolean m3632a() {
        return this.f19798a != null;
    }

    /* renamed from: a */
    public boolean m3631a(C4776ag c4776ag) {
        if (c4776ag == null) {
            return false;
        }
        boolean m3632a = m3632a();
        boolean m3632a2 = c4776ag.m3632a();
        if ((m3632a || m3632a2) && (!m3632a || !m3632a2 || !this.f19798a.equals(c4776ag.f19798a))) {
            return false;
        }
        boolean m3629b = m3629b();
        boolean m3629b2 = c4776ag.m3629b();
        if ((m3629b || m3629b2) && (!m3629b || !m3629b2 || !this.f19799b.m3254a(c4776ag.f19799b))) {
            return false;
        }
        boolean m3627c = m3627c();
        boolean m3627c2 = c4776ag.m3627c();
        if ((m3627c || m3627c2) && (!m3627c || !m3627c2 || !this.f19800c.equals(c4776ag.f19800c))) {
            return false;
        }
        boolean m3626d = m3626d();
        boolean m3626d2 = c4776ag.m3626d();
        if ((m3626d || m3626d2) && (!m3626d || !m3626d2 || !this.f19801d.equals(c4776ag.f19801d))) {
            return false;
        }
        boolean m3625e = m3625e();
        boolean m3625e2 = c4776ag.m3625e();
        if (((m3625e || m3625e2) && (!m3625e || !m3625e2 || !this.f19802e.m3678a(c4776ag.f19802e))) || this.f19803f != c4776ag.f19803f) {
            return false;
        }
        boolean m3623g = m3623g();
        boolean m3623g2 = c4776ag.m3623g();
        if ((m3623g || m3623g2) && (!m3623g || !m3623g2 || !this.f19804g.equals(c4776ag.f19804g))) {
            return false;
        }
        boolean m3622h = m3622h();
        boolean m3622h2 = c4776ag.m3622h();
        if ((m3622h || m3622h2) && (!m3622h || !m3622h2 || !this.f19805h.equals(c4776ag.f19805h))) {
            return false;
        }
        boolean m3621i = m3621i();
        boolean m3621i2 = c4776ag.m3621i();
        if ((m3621i || m3621i2) && (!m3621i || !m3621i2 || !this.f19806i.equals(c4776ag.f19806i))) {
            return false;
        }
        boolean m3620j = m3620j();
        boolean m3620j2 = c4776ag.m3620j();
        return (!m3620j && !m3620j2) || (m3620j && m3620j2 && this.f19807j.equals(c4776ag.f19807j));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4776ag c4776ag) {
        int m1277a;
        int m1277a2;
        int m1277a3;
        int m1277a4;
        int m1279a;
        int m1278a;
        int m1277a5;
        int m1277a6;
        int m1278a2;
        int m1277a7;
        if (!getClass().equals(c4776ag.getClass())) {
            return getClass().getName().compareTo(c4776ag.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3632a()).compareTo(Boolean.valueOf(c4776ag.m3632a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3632a() && (m1277a7 = C5366b.m1277a(this.f19798a, c4776ag.f19798a)) != 0) {
            return m1277a7;
        }
        int compareTo2 = Boolean.valueOf(m3629b()).compareTo(Boolean.valueOf(c4776ag.m3629b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3629b() && (m1278a2 = C5366b.m1278a(this.f19799b, c4776ag.f19799b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3627c()).compareTo(Boolean.valueOf(c4776ag.m3627c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3627c() && (m1277a6 = C5366b.m1277a(this.f19800c, c4776ag.f19800c)) != 0) {
            return m1277a6;
        }
        int compareTo4 = Boolean.valueOf(m3626d()).compareTo(Boolean.valueOf(c4776ag.m3626d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3626d() && (m1277a5 = C5366b.m1277a(this.f19801d, c4776ag.f19801d)) != 0) {
            return m1277a5;
        }
        int compareTo5 = Boolean.valueOf(m3625e()).compareTo(Boolean.valueOf(c4776ag.m3625e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3625e() && (m1278a = C5366b.m1278a(this.f19802e, c4776ag.f19802e)) != 0) {
            return m1278a;
        }
        int compareTo6 = Boolean.valueOf(m3624f()).compareTo(Boolean.valueOf(c4776ag.m3624f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3624f() && (m1279a = C5366b.m1279a(this.f19803f, c4776ag.f19803f)) != 0) {
            return m1279a;
        }
        int compareTo7 = Boolean.valueOf(m3623g()).compareTo(Boolean.valueOf(c4776ag.m3623g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3623g() && (m1277a4 = C5366b.m1277a(this.f19804g, c4776ag.f19804g)) != 0) {
            return m1277a4;
        }
        int compareTo8 = Boolean.valueOf(m3622h()).compareTo(Boolean.valueOf(c4776ag.m3622h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3622h() && (m1277a3 = C5366b.m1277a(this.f19805h, c4776ag.f19805h)) != 0) {
            return m1277a3;
        }
        int compareTo9 = Boolean.valueOf(m3621i()).compareTo(Boolean.valueOf(c4776ag.m3621i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3621i() && (m1277a2 = C5366b.m1277a(this.f19806i, c4776ag.f19806i)) != 0) {
            return m1277a2;
        }
        int compareTo10 = Boolean.valueOf(m3620j()).compareTo(Boolean.valueOf(c4776ag.m3620j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3620j() && (m1277a = C5366b.m1277a(this.f19807j, c4776ag.f19807j)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3619k();
        abstractC5373e.mo1250a(f19787l);
        if (this.f19798a != null && m3632a()) {
            abstractC5373e.mo1254a(f19788m);
            abstractC5373e.mo1256a(this.f19798a);
            abstractC5373e.mo1247b();
        }
        if (this.f19799b != null && m3629b()) {
            abstractC5373e.mo1254a(f19789n);
            this.f19799b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19800c != null) {
            abstractC5373e.mo1254a(f19790o);
            abstractC5373e.mo1256a(this.f19800c);
            abstractC5373e.mo1247b();
        }
        if (this.f19801d != null) {
            abstractC5373e.mo1254a(f19791p);
            abstractC5373e.mo1256a(this.f19801d);
            abstractC5373e.mo1247b();
        }
        if (this.f19802e != null && m3625e()) {
            abstractC5373e.mo1254a(f19792q);
            this.f19802e.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f19793r);
        abstractC5373e.mo1257a(this.f19803f);
        abstractC5373e.mo1247b();
        if (this.f19804g != null && m3623g()) {
            abstractC5373e.mo1254a(f19794s);
            abstractC5373e.mo1256a(this.f19804g);
            abstractC5373e.mo1247b();
        }
        if (this.f19805h != null && m3622h()) {
            abstractC5373e.mo1254a(f19795t);
            abstractC5373e.mo1256a(this.f19805h);
            abstractC5373e.mo1247b();
        }
        if (this.f19806i != null && m3621i()) {
            abstractC5373e.mo1254a(f19796u);
            abstractC5373e.mo1256a(this.f19806i);
            abstractC5373e.mo1247b();
        }
        if (this.f19807j != null && m3620j()) {
            abstractC5373e.mo1254a(f19797v);
            abstractC5373e.mo1256a(this.f19807j);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3629b() {
        return this.f19799b != null;
    }

    /* renamed from: c */
    public boolean m3627c() {
        return this.f19800c != null;
    }

    /* renamed from: d */
    public boolean m3626d() {
        return this.f19801d != null;
    }

    /* renamed from: e */
    public boolean m3625e() {
        return this.f19802e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4776ag)) {
            return m3631a((C4776ag) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3624f() {
        return this.f19808w.get(0);
    }

    /* renamed from: g */
    public boolean m3623g() {
        return this.f19804g != null;
    }

    /* renamed from: h */
    public boolean m3622h() {
        return this.f19805h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3621i() {
        return this.f19806i != null;
    }

    /* renamed from: j */
    public boolean m3620j() {
        return this.f19807j != null;
    }

    /* renamed from: k */
    public void m3619k() {
        if (this.f19800c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f19801d != null) {
            return;
        }
        throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m3632a()) {
            sb.append("debug:");
            if (this.f19798a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19798a);
            }
            z2 = false;
        }
        if (m3629b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19799b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19799b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19800c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19800c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f19801d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19801d);
        }
        if (m3625e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f19802e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19802e);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f19803f);
        if (m3623g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f19804g == null) {
                sb.append("null");
            } else {
                sb.append(this.f19804g);
            }
        }
        if (m3622h()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f19805h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19805h);
            }
        }
        if (m3621i()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f19806i == null) {
                sb.append("null");
            } else {
                sb.append(this.f19806i);
            }
        }
        if (m3620j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19807j == null) {
                sb.append("null");
            } else {
                sb.append(this.f19807j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
