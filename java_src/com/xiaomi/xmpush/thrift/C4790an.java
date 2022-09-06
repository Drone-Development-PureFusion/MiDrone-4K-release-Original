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
/* renamed from: com.xiaomi.xmpush.thrift.an */
/* loaded from: classes2.dex */
public class C4790an implements Serializable, Cloneable, AbstractC5358a<C4790an, EnumC4791a> {

    /* renamed from: i */
    public static final Map<EnumC4791a, C5360b> f20021i;

    /* renamed from: j */
    private static final C5378j f20022j = new C5378j("XmPushActionUnRegistrationResult");

    /* renamed from: k */
    private static final C5370b f20023k = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: l */
    private static final C5370b f20024l = new C5370b("target", (byte) 12, 2);

    /* renamed from: m */
    private static final C5370b f20025m = new C5370b("id", (byte) 11, 3);

    /* renamed from: n */
    private static final C5370b f20026n = new C5370b("appId", (byte) 11, 4);

    /* renamed from: o */
    private static final C5370b f20027o = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 5);

    /* renamed from: p */
    private static final C5370b f20028p = new C5370b("errorCode", (byte) 10, 6);

    /* renamed from: q */
    private static final C5370b f20029q = new C5370b("reason", (byte) 11, 7);

    /* renamed from: r */
    private static final C5370b f20030r = new C5370b("packageName", (byte) 11, 8);

    /* renamed from: a */
    public String f20031a;

    /* renamed from: b */
    public C4828u f20032b;

    /* renamed from: c */
    public String f20033c;

    /* renamed from: d */
    public String f20034d;

    /* renamed from: e */
    public C4788am f20035e;

    /* renamed from: f */
    public long f20036f;

    /* renamed from: g */
    public String f20037g;

    /* renamed from: h */
    public String f20038h;

    /* renamed from: s */
    private BitSet f20039s = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.an$a */
    /* loaded from: classes2.dex */
    public enum EnumC4791a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        REQUEST(5, SocialConstants.TYPE_REQUEST),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        PACKAGE_NAME(8, "packageName");
        

        /* renamed from: i */
        private static final Map<String, EnumC4791a> f20048i = new HashMap();

        /* renamed from: j */
        private final short f20050j;

        /* renamed from: k */
        private final String f20051k;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4791a.class).iterator();
            while (it2.hasNext()) {
                EnumC4791a enumC4791a = (EnumC4791a) it2.next();
                f20048i.put(enumC4791a.m3506a(), enumC4791a);
            }
        }

        EnumC4791a(short s, String str) {
            this.f20050j = s;
            this.f20051k = str;
        }

        /* renamed from: a */
        public String m3506a() {
            return this.f20051k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4791a.class);
        enumMap.put((EnumMap) EnumC4791a.DEBUG, (EnumC4791a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4791a.TARGET, (EnumC4791a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4791a.ID, (EnumC4791a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4791a.APP_ID, (EnumC4791a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4791a.REQUEST, (EnumC4791a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4788am.class)));
        enumMap.put((EnumMap) EnumC4791a.ERROR_CODE, (EnumC4791a) new C5360b("errorCode", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4791a.REASON, (EnumC4791a) new C5360b("reason", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4791a.PACKAGE_NAME, (EnumC4791a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        f20021i = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4790an.class, f20021i);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3510f()) {
                    throw new C5374f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3507i();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20031a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20032b = new C4828u();
                        this.f20032b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20033c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20034d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20035e = new C4788am();
                        this.f20035e.mo1286a(abstractC5373e);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20036f = abstractC5373e.mo1231u();
                        m3516a(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20037g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20038h = abstractC5373e.mo1223w();
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
    public void m3516a(boolean z) {
        this.f20039s.set(0, z);
    }

    /* renamed from: a */
    public boolean m3518a() {
        return this.f20031a != null;
    }

    /* renamed from: a */
    public boolean m3517a(C4790an c4790an) {
        if (c4790an == null) {
            return false;
        }
        boolean m3518a = m3518a();
        boolean m3518a2 = c4790an.m3518a();
        if ((m3518a || m3518a2) && (!m3518a || !m3518a2 || !this.f20031a.equals(c4790an.f20031a))) {
            return false;
        }
        boolean m3515b = m3515b();
        boolean m3515b2 = c4790an.m3515b();
        if ((m3515b || m3515b2) && (!m3515b || !m3515b2 || !this.f20032b.m3254a(c4790an.f20032b))) {
            return false;
        }
        boolean m3513c = m3513c();
        boolean m3513c2 = c4790an.m3513c();
        if ((m3513c || m3513c2) && (!m3513c || !m3513c2 || !this.f20033c.equals(c4790an.f20033c))) {
            return false;
        }
        boolean m3512d = m3512d();
        boolean m3512d2 = c4790an.m3512d();
        if ((m3512d || m3512d2) && (!m3512d || !m3512d2 || !this.f20034d.equals(c4790an.f20034d))) {
            return false;
        }
        boolean m3511e = m3511e();
        boolean m3511e2 = c4790an.m3511e();
        if (((m3511e || m3511e2) && (!m3511e || !m3511e2 || !this.f20035e.m3536a(c4790an.f20035e))) || this.f20036f != c4790an.f20036f) {
            return false;
        }
        boolean m3509g = m3509g();
        boolean m3509g2 = c4790an.m3509g();
        if ((m3509g || m3509g2) && (!m3509g || !m3509g2 || !this.f20037g.equals(c4790an.f20037g))) {
            return false;
        }
        boolean m3508h = m3508h();
        boolean m3508h2 = c4790an.m3508h();
        return (!m3508h && !m3508h2) || (m3508h && m3508h2 && this.f20038h.equals(c4790an.f20038h));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4790an c4790an) {
        int m1277a;
        int m1277a2;
        int m1279a;
        int m1278a;
        int m1277a3;
        int m1277a4;
        int m1278a2;
        int m1277a5;
        if (!getClass().equals(c4790an.getClass())) {
            return getClass().getName().compareTo(c4790an.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3518a()).compareTo(Boolean.valueOf(c4790an.m3518a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3518a() && (m1277a5 = C5366b.m1277a(this.f20031a, c4790an.f20031a)) != 0) {
            return m1277a5;
        }
        int compareTo2 = Boolean.valueOf(m3515b()).compareTo(Boolean.valueOf(c4790an.m3515b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3515b() && (m1278a2 = C5366b.m1278a(this.f20032b, c4790an.f20032b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3513c()).compareTo(Boolean.valueOf(c4790an.m3513c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3513c() && (m1277a4 = C5366b.m1277a(this.f20033c, c4790an.f20033c)) != 0) {
            return m1277a4;
        }
        int compareTo4 = Boolean.valueOf(m3512d()).compareTo(Boolean.valueOf(c4790an.m3512d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3512d() && (m1277a3 = C5366b.m1277a(this.f20034d, c4790an.f20034d)) != 0) {
            return m1277a3;
        }
        int compareTo5 = Boolean.valueOf(m3511e()).compareTo(Boolean.valueOf(c4790an.m3511e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3511e() && (m1278a = C5366b.m1278a(this.f20035e, c4790an.f20035e)) != 0) {
            return m1278a;
        }
        int compareTo6 = Boolean.valueOf(m3510f()).compareTo(Boolean.valueOf(c4790an.m3510f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3510f() && (m1279a = C5366b.m1279a(this.f20036f, c4790an.f20036f)) != 0) {
            return m1279a;
        }
        int compareTo7 = Boolean.valueOf(m3509g()).compareTo(Boolean.valueOf(c4790an.m3509g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3509g() && (m1277a2 = C5366b.m1277a(this.f20037g, c4790an.f20037g)) != 0) {
            return m1277a2;
        }
        int compareTo8 = Boolean.valueOf(m3508h()).compareTo(Boolean.valueOf(c4790an.m3508h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3508h() && (m1277a = C5366b.m1277a(this.f20038h, c4790an.f20038h)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3507i();
        abstractC5373e.mo1250a(f20022j);
        if (this.f20031a != null && m3518a()) {
            abstractC5373e.mo1254a(f20023k);
            abstractC5373e.mo1256a(this.f20031a);
            abstractC5373e.mo1247b();
        }
        if (this.f20032b != null && m3515b()) {
            abstractC5373e.mo1254a(f20024l);
            this.f20032b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20033c != null) {
            abstractC5373e.mo1254a(f20025m);
            abstractC5373e.mo1256a(this.f20033c);
            abstractC5373e.mo1247b();
        }
        if (this.f20034d != null) {
            abstractC5373e.mo1254a(f20026n);
            abstractC5373e.mo1256a(this.f20034d);
            abstractC5373e.mo1247b();
        }
        if (this.f20035e != null && m3511e()) {
            abstractC5373e.mo1254a(f20027o);
            this.f20035e.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f20028p);
        abstractC5373e.mo1257a(this.f20036f);
        abstractC5373e.mo1247b();
        if (this.f20037g != null && m3509g()) {
            abstractC5373e.mo1254a(f20029q);
            abstractC5373e.mo1256a(this.f20037g);
            abstractC5373e.mo1247b();
        }
        if (this.f20038h != null && m3508h()) {
            abstractC5373e.mo1254a(f20030r);
            abstractC5373e.mo1256a(this.f20038h);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3515b() {
        return this.f20032b != null;
    }

    /* renamed from: c */
    public boolean m3513c() {
        return this.f20033c != null;
    }

    /* renamed from: d */
    public boolean m3512d() {
        return this.f20034d != null;
    }

    /* renamed from: e */
    public boolean m3511e() {
        return this.f20035e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4790an)) {
            return m3517a((C4790an) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3510f() {
        return this.f20039s.get(0);
    }

    /* renamed from: g */
    public boolean m3509g() {
        return this.f20037g != null;
    }

    /* renamed from: h */
    public boolean m3508h() {
        return this.f20038h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public void m3507i() {
        if (this.f20033c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f20034d != null) {
            return;
        }
        throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m3518a()) {
            sb.append("debug:");
            if (this.f20031a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20031a);
            }
            z2 = false;
        }
        if (m3515b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f20032b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20032b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f20033c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20033c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f20034d == null) {
            sb.append("null");
        } else {
            sb.append(this.f20034d);
        }
        if (m3511e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f20035e == null) {
                sb.append("null");
            } else {
                sb.append(this.f20035e);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f20036f);
        if (m3509g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f20037g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20037g);
            }
        }
        if (m3508h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20038h == null) {
                sb.append("null");
            } else {
                sb.append(this.f20038h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
