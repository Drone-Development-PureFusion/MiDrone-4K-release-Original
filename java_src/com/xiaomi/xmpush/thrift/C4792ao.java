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
/* renamed from: com.xiaomi.xmpush.thrift.ao */
/* loaded from: classes2.dex */
public class C4792ao implements Serializable, Cloneable, AbstractC5358a<C4792ao, EnumC4793a> {

    /* renamed from: h */
    public static final Map<EnumC4793a, C5360b> f20052h;

    /* renamed from: i */
    private static final C5378j f20053i = new C5378j("XmPushActionUnSubscription");

    /* renamed from: j */
    private static final C5370b f20054j = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: k */
    private static final C5370b f20055k = new C5370b("target", (byte) 12, 2);

    /* renamed from: l */
    private static final C5370b f20056l = new C5370b("id", (byte) 11, 3);

    /* renamed from: m */
    private static final C5370b f20057m = new C5370b("appId", (byte) 11, 4);

    /* renamed from: n */
    private static final C5370b f20058n = new C5370b("topic", (byte) 11, 5);

    /* renamed from: o */
    private static final C5370b f20059o = new C5370b("packageName", (byte) 11, 6);

    /* renamed from: p */
    private static final C5370b f20060p = new C5370b("category", (byte) 11, 7);

    /* renamed from: a */
    public String f20061a;

    /* renamed from: b */
    public C4828u f20062b;

    /* renamed from: c */
    public String f20063c;

    /* renamed from: d */
    public String f20064d;

    /* renamed from: e */
    public String f20065e;

    /* renamed from: f */
    public String f20066f;

    /* renamed from: g */
    public String f20067g;

    /* renamed from: com.xiaomi.xmpush.thrift.ao$a */
    /* loaded from: classes2.dex */
    public enum EnumC4793a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        TOPIC(5, "topic"),
        PACKAGE_NAME(6, "packageName"),
        CATEGORY(7, "category");
        

        /* renamed from: h */
        private static final Map<String, EnumC4793a> f20075h = new HashMap();

        /* renamed from: i */
        private final short f20077i;

        /* renamed from: j */
        private final String f20078j;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4793a.class).iterator();
            while (it2.hasNext()) {
                EnumC4793a enumC4793a = (EnumC4793a) it2.next();
                f20075h.put(enumC4793a.m3490a(), enumC4793a);
            }
        }

        EnumC4793a(short s, String str) {
            this.f20077i = s;
            this.f20078j = str;
        }

        /* renamed from: a */
        public String m3490a() {
            return this.f20078j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4793a.class);
        enumMap.put((EnumMap) EnumC4793a.DEBUG, (EnumC4793a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4793a.TARGET, (EnumC4793a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4793a.ID, (EnumC4793a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4793a.APP_ID, (EnumC4793a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4793a.TOPIC, (EnumC4793a) new C5360b("topic", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4793a.PACKAGE_NAME, (EnumC4793a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4793a.CATEGORY, (EnumC4793a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f20052h = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4792ao.class, f20052h);
    }

    /* renamed from: a */
    public C4792ao m3503a(String str) {
        this.f20063c = str;
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
                m3491h();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20061a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20062b = new C4828u();
                        this.f20062b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20063c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20064d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20065e = abstractC5373e.mo1223w();
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20066f = abstractC5373e.mo1223w();
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20067g = abstractC5373e.mo1223w();
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
    public boolean m3505a() {
        return this.f20061a != null;
    }

    /* renamed from: a */
    public boolean m3504a(C4792ao c4792ao) {
        if (c4792ao == null) {
            return false;
        }
        boolean m3505a = m3505a();
        boolean m3505a2 = c4792ao.m3505a();
        if ((m3505a || m3505a2) && (!m3505a || !m3505a2 || !this.f20061a.equals(c4792ao.f20061a))) {
            return false;
        }
        boolean m3502b = m3502b();
        boolean m3502b2 = c4792ao.m3502b();
        if ((m3502b || m3502b2) && (!m3502b || !m3502b2 || !this.f20062b.m3254a(c4792ao.f20062b))) {
            return false;
        }
        boolean m3499c = m3499c();
        boolean m3499c2 = c4792ao.m3499c();
        if ((m3499c || m3499c2) && (!m3499c || !m3499c2 || !this.f20063c.equals(c4792ao.f20063c))) {
            return false;
        }
        boolean m3497d = m3497d();
        boolean m3497d2 = c4792ao.m3497d();
        if ((m3497d || m3497d2) && (!m3497d || !m3497d2 || !this.f20064d.equals(c4792ao.f20064d))) {
            return false;
        }
        boolean m3495e = m3495e();
        boolean m3495e2 = c4792ao.m3495e();
        if ((m3495e || m3495e2) && (!m3495e || !m3495e2 || !this.f20065e.equals(c4792ao.f20065e))) {
            return false;
        }
        boolean m3493f = m3493f();
        boolean m3493f2 = c4792ao.m3493f();
        if ((m3493f || m3493f2) && (!m3493f || !m3493f2 || !this.f20066f.equals(c4792ao.f20066f))) {
            return false;
        }
        boolean m3492g = m3492g();
        boolean m3492g2 = c4792ao.m3492g();
        return (!m3492g && !m3492g2) || (m3492g && m3492g2 && this.f20067g.equals(c4792ao.f20067g));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4792ao c4792ao) {
        int m1277a;
        int m1277a2;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1278a;
        int m1277a6;
        if (!getClass().equals(c4792ao.getClass())) {
            return getClass().getName().compareTo(c4792ao.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3505a()).compareTo(Boolean.valueOf(c4792ao.m3505a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3505a() && (m1277a6 = C5366b.m1277a(this.f20061a, c4792ao.f20061a)) != 0) {
            return m1277a6;
        }
        int compareTo2 = Boolean.valueOf(m3502b()).compareTo(Boolean.valueOf(c4792ao.m3502b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3502b() && (m1278a = C5366b.m1278a(this.f20062b, c4792ao.f20062b)) != 0) {
            return m1278a;
        }
        int compareTo3 = Boolean.valueOf(m3499c()).compareTo(Boolean.valueOf(c4792ao.m3499c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3499c() && (m1277a5 = C5366b.m1277a(this.f20063c, c4792ao.f20063c)) != 0) {
            return m1277a5;
        }
        int compareTo4 = Boolean.valueOf(m3497d()).compareTo(Boolean.valueOf(c4792ao.m3497d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3497d() && (m1277a4 = C5366b.m1277a(this.f20064d, c4792ao.f20064d)) != 0) {
            return m1277a4;
        }
        int compareTo5 = Boolean.valueOf(m3495e()).compareTo(Boolean.valueOf(c4792ao.m3495e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3495e() && (m1277a3 = C5366b.m1277a(this.f20065e, c4792ao.f20065e)) != 0) {
            return m1277a3;
        }
        int compareTo6 = Boolean.valueOf(m3493f()).compareTo(Boolean.valueOf(c4792ao.m3493f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3493f() && (m1277a2 = C5366b.m1277a(this.f20066f, c4792ao.f20066f)) != 0) {
            return m1277a2;
        }
        int compareTo7 = Boolean.valueOf(m3492g()).compareTo(Boolean.valueOf(c4792ao.m3492g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3492g() && (m1277a = C5366b.m1277a(this.f20067g, c4792ao.f20067g)) != 0) {
            return m1277a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4792ao m3500b(String str) {
        this.f20064d = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3491h();
        abstractC5373e.mo1250a(f20053i);
        if (this.f20061a != null && m3505a()) {
            abstractC5373e.mo1254a(f20054j);
            abstractC5373e.mo1256a(this.f20061a);
            abstractC5373e.mo1247b();
        }
        if (this.f20062b != null && m3502b()) {
            abstractC5373e.mo1254a(f20055k);
            this.f20062b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20063c != null) {
            abstractC5373e.mo1254a(f20056l);
            abstractC5373e.mo1256a(this.f20063c);
            abstractC5373e.mo1247b();
        }
        if (this.f20064d != null) {
            abstractC5373e.mo1254a(f20057m);
            abstractC5373e.mo1256a(this.f20064d);
            abstractC5373e.mo1247b();
        }
        if (this.f20065e != null) {
            abstractC5373e.mo1254a(f20058n);
            abstractC5373e.mo1256a(this.f20065e);
            abstractC5373e.mo1247b();
        }
        if (this.f20066f != null && m3493f()) {
            abstractC5373e.mo1254a(f20059o);
            abstractC5373e.mo1256a(this.f20066f);
            abstractC5373e.mo1247b();
        }
        if (this.f20067g != null && m3492g()) {
            abstractC5373e.mo1254a(f20060p);
            abstractC5373e.mo1256a(this.f20067g);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3502b() {
        return this.f20062b != null;
    }

    /* renamed from: c */
    public C4792ao m3498c(String str) {
        this.f20065e = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3499c() {
        return this.f20063c != null;
    }

    /* renamed from: d */
    public C4792ao m3496d(String str) {
        this.f20066f = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3497d() {
        return this.f20064d != null;
    }

    /* renamed from: e */
    public C4792ao m3494e(String str) {
        this.f20067g = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3495e() {
        return this.f20065e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4792ao)) {
            return m3504a((C4792ao) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3493f() {
        return this.f20066f != null;
    }

    /* renamed from: g */
    public boolean m3492g() {
        return this.f20067g != null;
    }

    /* renamed from: h */
    public void m3491h() {
        if (this.f20063c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f20064d == null) {
            throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f20065e != null) {
            return;
        }
        throw new C5374f("Required field 'topic' was not present! Struct: " + toString());
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m3505a()) {
            sb.append("debug:");
            if (this.f20061a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20061a);
            }
            z2 = false;
        }
        if (m3502b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f20062b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20062b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f20063c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20063c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f20064d == null) {
            sb.append("null");
        } else {
            sb.append(this.f20064d);
        }
        sb.append(", ");
        sb.append("topic:");
        if (this.f20065e == null) {
            sb.append("null");
        } else {
            sb.append(this.f20065e);
        }
        if (m3493f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20066f == null) {
                sb.append("null");
            } else {
                sb.append(this.f20066f);
            }
        }
        if (m3492g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f20067g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20067g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
