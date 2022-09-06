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
/* renamed from: com.xiaomi.xmpush.thrift.al */
/* loaded from: classes2.dex */
public class C4786al implements Serializable, Cloneable, AbstractC5358a<C4786al, EnumC4787a> {

    /* renamed from: k */
    public static final Map<EnumC4787a, C5360b> f19948k;

    /* renamed from: l */
    private static final C5378j f19949l = new C5378j("XmPushActionSubscriptionResult");

    /* renamed from: m */
    private static final C5370b f19950m = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: n */
    private static final C5370b f19951n = new C5370b("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C5370b f19952o = new C5370b("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C5370b f19953p = new C5370b("appId", (byte) 11, 4);

    /* renamed from: q */
    private static final C5370b f19954q = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 5);

    /* renamed from: r */
    private static final C5370b f19955r = new C5370b("errorCode", (byte) 10, 6);

    /* renamed from: s */
    private static final C5370b f19956s = new C5370b("reason", (byte) 11, 7);

    /* renamed from: t */
    private static final C5370b f19957t = new C5370b("topic", (byte) 11, 8);

    /* renamed from: u */
    private static final C5370b f19958u = new C5370b("packageName", (byte) 11, 9);

    /* renamed from: v */
    private static final C5370b f19959v = new C5370b("category", (byte) 11, 10);

    /* renamed from: a */
    public String f19960a;

    /* renamed from: b */
    public C4828u f19961b;

    /* renamed from: c */
    public String f19962c;

    /* renamed from: d */
    public String f19963d;

    /* renamed from: e */
    public C4784ak f19964e;

    /* renamed from: f */
    public long f19965f;

    /* renamed from: g */
    public String f19966g;

    /* renamed from: h */
    public String f19967h;

    /* renamed from: i */
    public String f19968i;

    /* renamed from: j */
    public String f19969j;

    /* renamed from: w */
    private BitSet f19970w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.al$a */
    /* loaded from: classes2.dex */
    public enum EnumC4787a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        REQUEST(5, SocialConstants.TYPE_REQUEST),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        TOPIC(8, "topic"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category");
        

        /* renamed from: k */
        private static final Map<String, EnumC4787a> f19981k = new HashMap();

        /* renamed from: l */
        private final short f19983l;

        /* renamed from: m */
        private final String f19984m;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4787a.class).iterator();
            while (it2.hasNext()) {
                EnumC4787a enumC4787a = (EnumC4787a) it2.next();
                f19981k.put(enumC4787a.m3538a(), enumC4787a);
            }
        }

        EnumC4787a(short s, String str) {
            this.f19983l = s;
            this.f19984m = str;
        }

        /* renamed from: a */
        public String m3538a() {
            return this.f19984m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4787a.class);
        enumMap.put((EnumMap) EnumC4787a.DEBUG, (EnumC4787a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4787a.TARGET, (EnumC4787a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4787a.ID, (EnumC4787a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4787a.APP_ID, (EnumC4787a) new C5360b("appId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4787a.REQUEST, (EnumC4787a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4784ak.class)));
        enumMap.put((EnumMap) EnumC4787a.ERROR_CODE, (EnumC4787a) new C5360b("errorCode", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4787a.REASON, (EnumC4787a) new C5360b("reason", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4787a.TOPIC, (EnumC4787a) new C5360b("topic", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4787a.PACKAGE_NAME, (EnumC4787a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4787a.CATEGORY, (EnumC4787a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f19948k = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4786al.class, f19948k);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3539m();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19960a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19961b = new C4828u();
                        this.f19961b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19962c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19963d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19964e = new C4784ak();
                        this.f19964e.mo1286a(abstractC5373e);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19965f = abstractC5373e.mo1231u();
                        m3552a(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19966g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19967h = abstractC5373e.mo1223w();
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19968i = abstractC5373e.mo1223w();
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19969j = abstractC5373e.mo1223w();
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
    public void m3552a(boolean z) {
        this.f19970w.set(0, z);
    }

    /* renamed from: a */
    public boolean m3554a() {
        return this.f19960a != null;
    }

    /* renamed from: a */
    public boolean m3553a(C4786al c4786al) {
        if (c4786al == null) {
            return false;
        }
        boolean m3554a = m3554a();
        boolean m3554a2 = c4786al.m3554a();
        if ((m3554a || m3554a2) && (!m3554a || !m3554a2 || !this.f19960a.equals(c4786al.f19960a))) {
            return false;
        }
        boolean m3551b = m3551b();
        boolean m3551b2 = c4786al.m3551b();
        if ((m3551b || m3551b2) && (!m3551b || !m3551b2 || !this.f19961b.m3254a(c4786al.f19961b))) {
            return false;
        }
        boolean m3549c = m3549c();
        boolean m3549c2 = c4786al.m3549c();
        if ((m3549c || m3549c2) && (!m3549c || !m3549c2 || !this.f19962c.equals(c4786al.f19962c))) {
            return false;
        }
        boolean m3548d = m3548d();
        boolean m3548d2 = c4786al.m3548d();
        if ((m3548d || m3548d2) && (!m3548d || !m3548d2 || !this.f19963d.equals(c4786al.f19963d))) {
            return false;
        }
        boolean m3547e = m3547e();
        boolean m3547e2 = c4786al.m3547e();
        if ((m3547e || m3547e2) && (!m3547e || !m3547e2 || !this.f19964e.m3569a(c4786al.f19964e))) {
            return false;
        }
        boolean m3546f = m3546f();
        boolean m3546f2 = c4786al.m3546f();
        if ((m3546f || m3546f2) && (!m3546f || !m3546f2 || this.f19965f != c4786al.f19965f)) {
            return false;
        }
        boolean m3545g = m3545g();
        boolean m3545g2 = c4786al.m3545g();
        if ((m3545g || m3545g2) && (!m3545g || !m3545g2 || !this.f19966g.equals(c4786al.f19966g))) {
            return false;
        }
        boolean m3543i = m3543i();
        boolean m3543i2 = c4786al.m3543i();
        if ((m3543i || m3543i2) && (!m3543i || !m3543i2 || !this.f19967h.equals(c4786al.f19967h))) {
            return false;
        }
        boolean m3542j = m3542j();
        boolean m3542j2 = c4786al.m3542j();
        if ((m3542j || m3542j2) && (!m3542j || !m3542j2 || !this.f19968i.equals(c4786al.f19968i))) {
            return false;
        }
        boolean m3540l = m3540l();
        boolean m3540l2 = c4786al.m3540l();
        return (!m3540l && !m3540l2) || (m3540l && m3540l2 && this.f19969j.equals(c4786al.f19969j));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4786al c4786al) {
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
        if (!getClass().equals(c4786al.getClass())) {
            return getClass().getName().compareTo(c4786al.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3554a()).compareTo(Boolean.valueOf(c4786al.m3554a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3554a() && (m1277a7 = C5366b.m1277a(this.f19960a, c4786al.f19960a)) != 0) {
            return m1277a7;
        }
        int compareTo2 = Boolean.valueOf(m3551b()).compareTo(Boolean.valueOf(c4786al.m3551b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3551b() && (m1278a2 = C5366b.m1278a(this.f19961b, c4786al.f19961b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3549c()).compareTo(Boolean.valueOf(c4786al.m3549c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3549c() && (m1277a6 = C5366b.m1277a(this.f19962c, c4786al.f19962c)) != 0) {
            return m1277a6;
        }
        int compareTo4 = Boolean.valueOf(m3548d()).compareTo(Boolean.valueOf(c4786al.m3548d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3548d() && (m1277a5 = C5366b.m1277a(this.f19963d, c4786al.f19963d)) != 0) {
            return m1277a5;
        }
        int compareTo5 = Boolean.valueOf(m3547e()).compareTo(Boolean.valueOf(c4786al.m3547e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3547e() && (m1278a = C5366b.m1278a(this.f19964e, c4786al.f19964e)) != 0) {
            return m1278a;
        }
        int compareTo6 = Boolean.valueOf(m3546f()).compareTo(Boolean.valueOf(c4786al.m3546f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3546f() && (m1279a = C5366b.m1279a(this.f19965f, c4786al.f19965f)) != 0) {
            return m1279a;
        }
        int compareTo7 = Boolean.valueOf(m3545g()).compareTo(Boolean.valueOf(c4786al.m3545g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3545g() && (m1277a4 = C5366b.m1277a(this.f19966g, c4786al.f19966g)) != 0) {
            return m1277a4;
        }
        int compareTo8 = Boolean.valueOf(m3543i()).compareTo(Boolean.valueOf(c4786al.m3543i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3543i() && (m1277a3 = C5366b.m1277a(this.f19967h, c4786al.f19967h)) != 0) {
            return m1277a3;
        }
        int compareTo9 = Boolean.valueOf(m3542j()).compareTo(Boolean.valueOf(c4786al.m3542j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3542j() && (m1277a2 = C5366b.m1277a(this.f19968i, c4786al.f19968i)) != 0) {
            return m1277a2;
        }
        int compareTo10 = Boolean.valueOf(m3540l()).compareTo(Boolean.valueOf(c4786al.m3540l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3540l() && (m1277a = C5366b.m1277a(this.f19969j, c4786al.f19969j)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3539m();
        abstractC5373e.mo1250a(f19949l);
        if (this.f19960a != null && m3554a()) {
            abstractC5373e.mo1254a(f19950m);
            abstractC5373e.mo1256a(this.f19960a);
            abstractC5373e.mo1247b();
        }
        if (this.f19961b != null && m3551b()) {
            abstractC5373e.mo1254a(f19951n);
            this.f19961b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19962c != null) {
            abstractC5373e.mo1254a(f19952o);
            abstractC5373e.mo1256a(this.f19962c);
            abstractC5373e.mo1247b();
        }
        if (this.f19963d != null && m3548d()) {
            abstractC5373e.mo1254a(f19953p);
            abstractC5373e.mo1256a(this.f19963d);
            abstractC5373e.mo1247b();
        }
        if (this.f19964e != null && m3547e()) {
            abstractC5373e.mo1254a(f19954q);
            this.f19964e.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (m3546f()) {
            abstractC5373e.mo1254a(f19955r);
            abstractC5373e.mo1257a(this.f19965f);
            abstractC5373e.mo1247b();
        }
        if (this.f19966g != null && m3545g()) {
            abstractC5373e.mo1254a(f19956s);
            abstractC5373e.mo1256a(this.f19966g);
            abstractC5373e.mo1247b();
        }
        if (this.f19967h != null && m3543i()) {
            abstractC5373e.mo1254a(f19957t);
            abstractC5373e.mo1256a(this.f19967h);
            abstractC5373e.mo1247b();
        }
        if (this.f19968i != null && m3542j()) {
            abstractC5373e.mo1254a(f19958u);
            abstractC5373e.mo1256a(this.f19968i);
            abstractC5373e.mo1247b();
        }
        if (this.f19969j != null && m3540l()) {
            abstractC5373e.mo1254a(f19959v);
            abstractC5373e.mo1256a(this.f19969j);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3551b() {
        return this.f19961b != null;
    }

    /* renamed from: c */
    public boolean m3549c() {
        return this.f19962c != null;
    }

    /* renamed from: d */
    public boolean m3548d() {
        return this.f19963d != null;
    }

    /* renamed from: e */
    public boolean m3547e() {
        return this.f19964e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4786al)) {
            return m3553a((C4786al) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3546f() {
        return this.f19970w.get(0);
    }

    /* renamed from: g */
    public boolean m3545g() {
        return this.f19966g != null;
    }

    /* renamed from: h */
    public String m3544h() {
        return this.f19967h;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3543i() {
        return this.f19967h != null;
    }

    /* renamed from: j */
    public boolean m3542j() {
        return this.f19968i != null;
    }

    /* renamed from: k */
    public String m3541k() {
        return this.f19969j;
    }

    /* renamed from: l */
    public boolean m3540l() {
        return this.f19969j != null;
    }

    /* renamed from: m */
    public void m3539m() {
        if (this.f19962c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m3554a()) {
            sb.append("debug:");
            if (this.f19960a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19960a);
            }
            z2 = false;
        }
        if (m3551b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19961b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19961b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19962c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19962c);
        }
        if (m3548d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f19963d == null) {
                sb.append("null");
            } else {
                sb.append(this.f19963d);
            }
        }
        if (m3547e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f19964e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19964e);
            }
        }
        if (m3546f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f19965f);
        }
        if (m3545g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f19966g == null) {
                sb.append("null");
            } else {
                sb.append(this.f19966g);
            }
        }
        if (m3543i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f19967h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19967h);
            }
        }
        if (m3542j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19968i == null) {
                sb.append("null");
            } else {
                sb.append(this.f19968i);
            }
        }
        if (m3540l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f19969j == null) {
                sb.append("null");
            } else {
                sb.append(this.f19969j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
