package com.xiaomi.xmpush.thrift;

import com.p219mi.live.openlivesdk.C4093a;
import com.xiaomi.mipush.sdk.Constants;
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
/* renamed from: com.xiaomi.xmpush.thrift.am */
/* loaded from: classes2.dex */
public class C4788am implements Serializable, Cloneable, AbstractC5358a<C4788am, EnumC4789a> {

    /* renamed from: k */
    public static final Map<EnumC4789a, C5360b> f19985k;

    /* renamed from: l */
    private static final C5378j f19986l = new C5378j("XmPushActionUnRegistration");

    /* renamed from: m */
    private static final C5370b f19987m = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: n */
    private static final C5370b f19988n = new C5370b("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C5370b f19989o = new C5370b("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C5370b f19990p = new C5370b("appId", (byte) 11, 4);

    /* renamed from: q */
    private static final C5370b f19991q = new C5370b("regId", (byte) 11, 5);

    /* renamed from: r */
    private static final C5370b f19992r = new C5370b("appVersion", (byte) 11, 6);

    /* renamed from: s */
    private static final C5370b f19993s = new C5370b("packageName", (byte) 11, 7);

    /* renamed from: t */
    private static final C5370b f19994t = new C5370b(Constants.EXTRA_KEY_TOKEN, (byte) 11, 8);

    /* renamed from: u */
    private static final C5370b f19995u = new C5370b("deviceId", (byte) 11, 9);

    /* renamed from: v */
    private static final C5370b f19996v = new C5370b("aliasName", (byte) 11, 10);

    /* renamed from: a */
    public String f19997a;

    /* renamed from: b */
    public C4828u f19998b;

    /* renamed from: c */
    public String f19999c;

    /* renamed from: d */
    public String f20000d;

    /* renamed from: e */
    public String f20001e;

    /* renamed from: f */
    public String f20002f;

    /* renamed from: g */
    public String f20003g;

    /* renamed from: h */
    public String f20004h;

    /* renamed from: i */
    public String f20005i;

    /* renamed from: j */
    public String f20006j;

    /* renamed from: com.xiaomi.xmpush.thrift.am$a */
    /* loaded from: classes2.dex */
    public enum EnumC4789a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        REG_ID(5, "regId"),
        APP_VERSION(6, "appVersion"),
        PACKAGE_NAME(7, "packageName"),
        TOKEN(8, Constants.EXTRA_KEY_TOKEN),
        DEVICE_ID(9, "deviceId"),
        ALIAS_NAME(10, "aliasName");
        

        /* renamed from: k */
        private static final Map<String, EnumC4789a> f20017k = new HashMap();

        /* renamed from: l */
        private final short f20019l;

        /* renamed from: m */
        private final String f20020m;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4789a.class).iterator();
            while (it2.hasNext()) {
                EnumC4789a enumC4789a = (EnumC4789a) it2.next();
                f20017k.put(enumC4789a.m3519a(), enumC4789a);
            }
        }

        EnumC4789a(short s, String str) {
            this.f20019l = s;
            this.f20020m = str;
        }

        /* renamed from: a */
        public String m3519a() {
            return this.f20020m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4789a.class);
        enumMap.put((EnumMap) EnumC4789a.DEBUG, (EnumC4789a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.TARGET, (EnumC4789a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4789a.ID, (EnumC4789a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.APP_ID, (EnumC4789a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.REG_ID, (EnumC4789a) new C5360b("regId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.APP_VERSION, (EnumC4789a) new C5360b("appVersion", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.PACKAGE_NAME, (EnumC4789a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.TOKEN, (EnumC4789a) new C5360b(Constants.EXTRA_KEY_TOKEN, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.DEVICE_ID, (EnumC4789a) new C5360b("deviceId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4789a.ALIAS_NAME, (EnumC4789a) new C5360b("aliasName", (byte) 2, new C5361c((byte) 11)));
        f19985k = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4788am.class, f19985k);
    }

    /* renamed from: a */
    public C4788am m3535a(String str) {
        this.f19999c = str;
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
                m3520k();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19997a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19998b = new C4828u();
                        this.f19998b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19999c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20000d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20001e = abstractC5373e.mo1223w();
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20002f = abstractC5373e.mo1223w();
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20003g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20004h = abstractC5373e.mo1223w();
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20005i = abstractC5373e.mo1223w();
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20006j = abstractC5373e.mo1223w();
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
    public boolean m3537a() {
        return this.f19997a != null;
    }

    /* renamed from: a */
    public boolean m3536a(C4788am c4788am) {
        if (c4788am == null) {
            return false;
        }
        boolean m3537a = m3537a();
        boolean m3537a2 = c4788am.m3537a();
        if ((m3537a || m3537a2) && (!m3537a || !m3537a2 || !this.f19997a.equals(c4788am.f19997a))) {
            return false;
        }
        boolean m3534b = m3534b();
        boolean m3534b2 = c4788am.m3534b();
        if ((m3534b || m3534b2) && (!m3534b || !m3534b2 || !this.f19998b.m3254a(c4788am.f19998b))) {
            return false;
        }
        boolean m3531c = m3531c();
        boolean m3531c2 = c4788am.m3531c();
        if ((m3531c || m3531c2) && (!m3531c || !m3531c2 || !this.f19999c.equals(c4788am.f19999c))) {
            return false;
        }
        boolean m3529d = m3529d();
        boolean m3529d2 = c4788am.m3529d();
        if ((m3529d || m3529d2) && (!m3529d || !m3529d2 || !this.f20000d.equals(c4788am.f20000d))) {
            return false;
        }
        boolean m3527e = m3527e();
        boolean m3527e2 = c4788am.m3527e();
        if ((m3527e || m3527e2) && (!m3527e || !m3527e2 || !this.f20001e.equals(c4788am.f20001e))) {
            return false;
        }
        boolean m3525f = m3525f();
        boolean m3525f2 = c4788am.m3525f();
        if ((m3525f || m3525f2) && (!m3525f || !m3525f2 || !this.f20002f.equals(c4788am.f20002f))) {
            return false;
        }
        boolean m3524g = m3524g();
        boolean m3524g2 = c4788am.m3524g();
        if ((m3524g || m3524g2) && (!m3524g || !m3524g2 || !this.f20003g.equals(c4788am.f20003g))) {
            return false;
        }
        boolean m3523h = m3523h();
        boolean m3523h2 = c4788am.m3523h();
        if ((m3523h || m3523h2) && (!m3523h || !m3523h2 || !this.f20004h.equals(c4788am.f20004h))) {
            return false;
        }
        boolean m3522i = m3522i();
        boolean m3522i2 = c4788am.m3522i();
        if ((m3522i || m3522i2) && (!m3522i || !m3522i2 || !this.f20005i.equals(c4788am.f20005i))) {
            return false;
        }
        boolean m3521j = m3521j();
        boolean m3521j2 = c4788am.m3521j();
        return (!m3521j && !m3521j2) || (m3521j && m3521j2 && this.f20006j.equals(c4788am.f20006j));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4788am c4788am) {
        int m1277a;
        int m1277a2;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1277a6;
        int m1277a7;
        int m1277a8;
        int m1278a;
        int m1277a9;
        if (!getClass().equals(c4788am.getClass())) {
            return getClass().getName().compareTo(c4788am.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3537a()).compareTo(Boolean.valueOf(c4788am.m3537a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3537a() && (m1277a9 = C5366b.m1277a(this.f19997a, c4788am.f19997a)) != 0) {
            return m1277a9;
        }
        int compareTo2 = Boolean.valueOf(m3534b()).compareTo(Boolean.valueOf(c4788am.m3534b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3534b() && (m1278a = C5366b.m1278a(this.f19998b, c4788am.f19998b)) != 0) {
            return m1278a;
        }
        int compareTo3 = Boolean.valueOf(m3531c()).compareTo(Boolean.valueOf(c4788am.m3531c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3531c() && (m1277a8 = C5366b.m1277a(this.f19999c, c4788am.f19999c)) != 0) {
            return m1277a8;
        }
        int compareTo4 = Boolean.valueOf(m3529d()).compareTo(Boolean.valueOf(c4788am.m3529d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3529d() && (m1277a7 = C5366b.m1277a(this.f20000d, c4788am.f20000d)) != 0) {
            return m1277a7;
        }
        int compareTo5 = Boolean.valueOf(m3527e()).compareTo(Boolean.valueOf(c4788am.m3527e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3527e() && (m1277a6 = C5366b.m1277a(this.f20001e, c4788am.f20001e)) != 0) {
            return m1277a6;
        }
        int compareTo6 = Boolean.valueOf(m3525f()).compareTo(Boolean.valueOf(c4788am.m3525f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3525f() && (m1277a5 = C5366b.m1277a(this.f20002f, c4788am.f20002f)) != 0) {
            return m1277a5;
        }
        int compareTo7 = Boolean.valueOf(m3524g()).compareTo(Boolean.valueOf(c4788am.m3524g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3524g() && (m1277a4 = C5366b.m1277a(this.f20003g, c4788am.f20003g)) != 0) {
            return m1277a4;
        }
        int compareTo8 = Boolean.valueOf(m3523h()).compareTo(Boolean.valueOf(c4788am.m3523h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3523h() && (m1277a3 = C5366b.m1277a(this.f20004h, c4788am.f20004h)) != 0) {
            return m1277a3;
        }
        int compareTo9 = Boolean.valueOf(m3522i()).compareTo(Boolean.valueOf(c4788am.m3522i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3522i() && (m1277a2 = C5366b.m1277a(this.f20005i, c4788am.f20005i)) != 0) {
            return m1277a2;
        }
        int compareTo10 = Boolean.valueOf(m3521j()).compareTo(Boolean.valueOf(c4788am.m3521j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3521j() && (m1277a = C5366b.m1277a(this.f20006j, c4788am.f20006j)) != 0) {
            return m1277a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4788am m3532b(String str) {
        this.f20000d = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3520k();
        abstractC5373e.mo1250a(f19986l);
        if (this.f19997a != null && m3537a()) {
            abstractC5373e.mo1254a(f19987m);
            abstractC5373e.mo1256a(this.f19997a);
            abstractC5373e.mo1247b();
        }
        if (this.f19998b != null && m3534b()) {
            abstractC5373e.mo1254a(f19988n);
            this.f19998b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19999c != null) {
            abstractC5373e.mo1254a(f19989o);
            abstractC5373e.mo1256a(this.f19999c);
            abstractC5373e.mo1247b();
        }
        if (this.f20000d != null) {
            abstractC5373e.mo1254a(f19990p);
            abstractC5373e.mo1256a(this.f20000d);
            abstractC5373e.mo1247b();
        }
        if (this.f20001e != null && m3527e()) {
            abstractC5373e.mo1254a(f19991q);
            abstractC5373e.mo1256a(this.f20001e);
            abstractC5373e.mo1247b();
        }
        if (this.f20002f != null && m3525f()) {
            abstractC5373e.mo1254a(f19992r);
            abstractC5373e.mo1256a(this.f20002f);
            abstractC5373e.mo1247b();
        }
        if (this.f20003g != null && m3524g()) {
            abstractC5373e.mo1254a(f19993s);
            abstractC5373e.mo1256a(this.f20003g);
            abstractC5373e.mo1247b();
        }
        if (this.f20004h != null && m3523h()) {
            abstractC5373e.mo1254a(f19994t);
            abstractC5373e.mo1256a(this.f20004h);
            abstractC5373e.mo1247b();
        }
        if (this.f20005i != null && m3522i()) {
            abstractC5373e.mo1254a(f19995u);
            abstractC5373e.mo1256a(this.f20005i);
            abstractC5373e.mo1247b();
        }
        if (this.f20006j != null && m3521j()) {
            abstractC5373e.mo1254a(f19996v);
            abstractC5373e.mo1256a(this.f20006j);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3534b() {
        return this.f19998b != null;
    }

    /* renamed from: c */
    public C4788am m3530c(String str) {
        this.f20001e = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3531c() {
        return this.f19999c != null;
    }

    /* renamed from: d */
    public C4788am m3528d(String str) {
        this.f20003g = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3529d() {
        return this.f20000d != null;
    }

    /* renamed from: e */
    public C4788am m3526e(String str) {
        this.f20004h = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3527e() {
        return this.f20001e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4788am)) {
            return m3536a((C4788am) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3525f() {
        return this.f20002f != null;
    }

    /* renamed from: g */
    public boolean m3524g() {
        return this.f20003g != null;
    }

    /* renamed from: h */
    public boolean m3523h() {
        return this.f20004h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3522i() {
        return this.f20005i != null;
    }

    /* renamed from: j */
    public boolean m3521j() {
        return this.f20006j != null;
    }

    /* renamed from: k */
    public void m3520k() {
        if (this.f19999c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f20000d != null) {
            return;
        }
        throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m3537a()) {
            sb.append("debug:");
            if (this.f19997a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19997a);
            }
            z2 = false;
        }
        if (m3534b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19998b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19998b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19999c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19999c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f20000d == null) {
            sb.append("null");
        } else {
            sb.append(this.f20000d);
        }
        if (m3527e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f20001e == null) {
                sb.append("null");
            } else {
                sb.append(this.f20001e);
            }
        }
        if (m3525f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f20002f == null) {
                sb.append("null");
            } else {
                sb.append(this.f20002f);
            }
        }
        if (m3524g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20003g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20003g);
            }
        }
        if (m3523h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f20004h == null) {
                sb.append("null");
            } else {
                sb.append(this.f20004h);
            }
        }
        if (m3522i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f20005i == null) {
                sb.append("null");
            } else {
                sb.append(this.f20005i);
            }
        }
        if (m3521j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f20006j == null) {
                sb.append("null");
            } else {
                sb.append(this.f20006j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
