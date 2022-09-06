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
/* renamed from: com.xiaomi.xmpush.thrift.ai */
/* loaded from: classes2.dex */
public class C4780ai implements Serializable, Cloneable, AbstractC5358a<C4780ai, EnumC4781a> {

    /* renamed from: i */
    public static final Map<EnumC4781a, C5360b> f19847i;

    /* renamed from: j */
    private static final C5378j f19848j = new C5378j("XmPushActionSendFeedbackResult");

    /* renamed from: k */
    private static final C5370b f19849k = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: l */
    private static final C5370b f19850l = new C5370b("target", (byte) 12, 2);

    /* renamed from: m */
    private static final C5370b f19851m = new C5370b("id", (byte) 11, 3);

    /* renamed from: n */
    private static final C5370b f19852n = new C5370b("appId", (byte) 11, 4);

    /* renamed from: o */
    private static final C5370b f19853o = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 5);

    /* renamed from: p */
    private static final C5370b f19854p = new C5370b("errorCode", (byte) 10, 6);

    /* renamed from: q */
    private static final C5370b f19855q = new C5370b("reason", (byte) 11, 7);

    /* renamed from: r */
    private static final C5370b f19856r = new C5370b("category", (byte) 11, 8);

    /* renamed from: a */
    public String f19857a;

    /* renamed from: b */
    public C4828u f19858b;

    /* renamed from: c */
    public String f19859c;

    /* renamed from: d */
    public String f19860d;

    /* renamed from: e */
    public C4778ah f19861e;

    /* renamed from: f */
    public long f19862f;

    /* renamed from: g */
    public String f19863g;

    /* renamed from: h */
    public String f19864h;

    /* renamed from: s */
    private BitSet f19865s = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.ai$a */
    /* loaded from: classes2.dex */
    public enum EnumC4781a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        REQUEST(5, SocialConstants.TYPE_REQUEST),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        CATEGORY(8, "category");
        

        /* renamed from: i */
        private static final Map<String, EnumC4781a> f19874i = new HashMap();

        /* renamed from: j */
        private final short f19876j;

        /* renamed from: k */
        private final String f19877k;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4781a.class).iterator();
            while (it2.hasNext()) {
                EnumC4781a enumC4781a = (EnumC4781a) it2.next();
                f19874i.put(enumC4781a.m3595a(), enumC4781a);
            }
        }

        EnumC4781a(short s, String str) {
            this.f19876j = s;
            this.f19877k = str;
        }

        /* renamed from: a */
        public String m3595a() {
            return this.f19877k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4781a.class);
        enumMap.put((EnumMap) EnumC4781a.DEBUG, (EnumC4781a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4781a.TARGET, (EnumC4781a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4781a.ID, (EnumC4781a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4781a.APP_ID, (EnumC4781a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4781a.REQUEST, (EnumC4781a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4778ah.class)));
        enumMap.put((EnumMap) EnumC4781a.ERROR_CODE, (EnumC4781a) new C5360b("errorCode", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4781a.REASON, (EnumC4781a) new C5360b("reason", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4781a.CATEGORY, (EnumC4781a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f19847i = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4780ai.class, f19847i);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3599f()) {
                    throw new C5374f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3596i();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19857a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19858b = new C4828u();
                        this.f19858b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19859c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19860d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19861e = new C4778ah();
                        this.f19861e.mo1286a(abstractC5373e);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19862f = abstractC5373e.mo1231u();
                        m3605a(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19863g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19864h = abstractC5373e.mo1223w();
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
    public void m3605a(boolean z) {
        this.f19865s.set(0, z);
    }

    /* renamed from: a */
    public boolean m3607a() {
        return this.f19857a != null;
    }

    /* renamed from: a */
    public boolean m3606a(C4780ai c4780ai) {
        if (c4780ai == null) {
            return false;
        }
        boolean m3607a = m3607a();
        boolean m3607a2 = c4780ai.m3607a();
        if ((m3607a || m3607a2) && (!m3607a || !m3607a2 || !this.f19857a.equals(c4780ai.f19857a))) {
            return false;
        }
        boolean m3604b = m3604b();
        boolean m3604b2 = c4780ai.m3604b();
        if ((m3604b || m3604b2) && (!m3604b || !m3604b2 || !this.f19858b.m3254a(c4780ai.f19858b))) {
            return false;
        }
        boolean m3602c = m3602c();
        boolean m3602c2 = c4780ai.m3602c();
        if ((m3602c || m3602c2) && (!m3602c || !m3602c2 || !this.f19859c.equals(c4780ai.f19859c))) {
            return false;
        }
        boolean m3601d = m3601d();
        boolean m3601d2 = c4780ai.m3601d();
        if ((m3601d || m3601d2) && (!m3601d || !m3601d2 || !this.f19860d.equals(c4780ai.f19860d))) {
            return false;
        }
        boolean m3600e = m3600e();
        boolean m3600e2 = c4780ai.m3600e();
        if (((m3600e || m3600e2) && (!m3600e || !m3600e2 || !this.f19861e.m3616a(c4780ai.f19861e))) || this.f19862f != c4780ai.f19862f) {
            return false;
        }
        boolean m3598g = m3598g();
        boolean m3598g2 = c4780ai.m3598g();
        if ((m3598g || m3598g2) && (!m3598g || !m3598g2 || !this.f19863g.equals(c4780ai.f19863g))) {
            return false;
        }
        boolean m3597h = m3597h();
        boolean m3597h2 = c4780ai.m3597h();
        return (!m3597h && !m3597h2) || (m3597h && m3597h2 && this.f19864h.equals(c4780ai.f19864h));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4780ai c4780ai) {
        int m1277a;
        int m1277a2;
        int m1279a;
        int m1278a;
        int m1277a3;
        int m1277a4;
        int m1278a2;
        int m1277a5;
        if (!getClass().equals(c4780ai.getClass())) {
            return getClass().getName().compareTo(c4780ai.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3607a()).compareTo(Boolean.valueOf(c4780ai.m3607a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3607a() && (m1277a5 = C5366b.m1277a(this.f19857a, c4780ai.f19857a)) != 0) {
            return m1277a5;
        }
        int compareTo2 = Boolean.valueOf(m3604b()).compareTo(Boolean.valueOf(c4780ai.m3604b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3604b() && (m1278a2 = C5366b.m1278a(this.f19858b, c4780ai.f19858b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3602c()).compareTo(Boolean.valueOf(c4780ai.m3602c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3602c() && (m1277a4 = C5366b.m1277a(this.f19859c, c4780ai.f19859c)) != 0) {
            return m1277a4;
        }
        int compareTo4 = Boolean.valueOf(m3601d()).compareTo(Boolean.valueOf(c4780ai.m3601d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3601d() && (m1277a3 = C5366b.m1277a(this.f19860d, c4780ai.f19860d)) != 0) {
            return m1277a3;
        }
        int compareTo5 = Boolean.valueOf(m3600e()).compareTo(Boolean.valueOf(c4780ai.m3600e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3600e() && (m1278a = C5366b.m1278a(this.f19861e, c4780ai.f19861e)) != 0) {
            return m1278a;
        }
        int compareTo6 = Boolean.valueOf(m3599f()).compareTo(Boolean.valueOf(c4780ai.m3599f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3599f() && (m1279a = C5366b.m1279a(this.f19862f, c4780ai.f19862f)) != 0) {
            return m1279a;
        }
        int compareTo7 = Boolean.valueOf(m3598g()).compareTo(Boolean.valueOf(c4780ai.m3598g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3598g() && (m1277a2 = C5366b.m1277a(this.f19863g, c4780ai.f19863g)) != 0) {
            return m1277a2;
        }
        int compareTo8 = Boolean.valueOf(m3597h()).compareTo(Boolean.valueOf(c4780ai.m3597h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3597h() && (m1277a = C5366b.m1277a(this.f19864h, c4780ai.f19864h)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3596i();
        abstractC5373e.mo1250a(f19848j);
        if (this.f19857a != null && m3607a()) {
            abstractC5373e.mo1254a(f19849k);
            abstractC5373e.mo1256a(this.f19857a);
            abstractC5373e.mo1247b();
        }
        if (this.f19858b != null && m3604b()) {
            abstractC5373e.mo1254a(f19850l);
            this.f19858b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19859c != null) {
            abstractC5373e.mo1254a(f19851m);
            abstractC5373e.mo1256a(this.f19859c);
            abstractC5373e.mo1247b();
        }
        if (this.f19860d != null) {
            abstractC5373e.mo1254a(f19852n);
            abstractC5373e.mo1256a(this.f19860d);
            abstractC5373e.mo1247b();
        }
        if (this.f19861e != null && m3600e()) {
            abstractC5373e.mo1254a(f19853o);
            this.f19861e.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f19854p);
        abstractC5373e.mo1257a(this.f19862f);
        abstractC5373e.mo1247b();
        if (this.f19863g != null && m3598g()) {
            abstractC5373e.mo1254a(f19855q);
            abstractC5373e.mo1256a(this.f19863g);
            abstractC5373e.mo1247b();
        }
        if (this.f19864h != null && m3597h()) {
            abstractC5373e.mo1254a(f19856r);
            abstractC5373e.mo1256a(this.f19864h);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3604b() {
        return this.f19858b != null;
    }

    /* renamed from: c */
    public boolean m3602c() {
        return this.f19859c != null;
    }

    /* renamed from: d */
    public boolean m3601d() {
        return this.f19860d != null;
    }

    /* renamed from: e */
    public boolean m3600e() {
        return this.f19861e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4780ai)) {
            return m3606a((C4780ai) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3599f() {
        return this.f19865s.get(0);
    }

    /* renamed from: g */
    public boolean m3598g() {
        return this.f19863g != null;
    }

    /* renamed from: h */
    public boolean m3597h() {
        return this.f19864h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public void m3596i() {
        if (this.f19859c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f19860d != null) {
            return;
        }
        throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m3607a()) {
            sb.append("debug:");
            if (this.f19857a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19857a);
            }
            z2 = false;
        }
        if (m3604b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19858b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19858b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19859c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19859c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f19860d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19860d);
        }
        if (m3600e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f19861e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19861e);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f19862f);
        if (m3598g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f19863g == null) {
                sb.append("null");
            } else {
                sb.append(this.f19863g);
            }
        }
        if (m3597h()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f19864h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19864h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
