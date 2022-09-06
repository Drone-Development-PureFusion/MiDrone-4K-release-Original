package com.xiaomi.xmpush.thrift;

import com.p219mi.live.openlivesdk.C4093a;
import com.tencent.open.SocialConstants;
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
/* renamed from: com.xiaomi.xmpush.thrift.aa */
/* loaded from: classes2.dex */
public class C4764aa implements Serializable, Cloneable, AbstractC5358a<C4764aa, EnumC4765a> {

    /* renamed from: l */
    public static final Map<EnumC4765a, C5360b> f19574l;

    /* renamed from: m */
    private static final C5378j f19575m = new C5378j("XmPushActionCommandResult");

    /* renamed from: n */
    private static final C5370b f19576n = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: o */
    private static final C5370b f19577o = new C5370b("target", (byte) 12, 2);

    /* renamed from: p */
    private static final C5370b f19578p = new C5370b("id", (byte) 11, 3);

    /* renamed from: q */
    private static final C5370b f19579q = new C5370b("appId", (byte) 11, 4);

    /* renamed from: r */
    private static final C5370b f19580r = new C5370b("cmdName", (byte) 11, 5);

    /* renamed from: s */
    private static final C5370b f19581s = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 6);

    /* renamed from: t */
    private static final C5370b f19582t = new C5370b("errorCode", (byte) 10, 7);

    /* renamed from: u */
    private static final C5370b f19583u = new C5370b("reason", (byte) 11, 8);

    /* renamed from: v */
    private static final C5370b f19584v = new C5370b("packageName", (byte) 11, 9);

    /* renamed from: w */
    private static final C5370b f19585w = new C5370b("cmdArgs", (byte) 15, 10);

    /* renamed from: x */
    private static final C5370b f19586x = new C5370b("category", (byte) 11, 12);

    /* renamed from: a */
    public String f19587a;

    /* renamed from: b */
    public C4828u f19588b;

    /* renamed from: c */
    public String f19589c;

    /* renamed from: d */
    public String f19590d;

    /* renamed from: e */
    public String f19591e;

    /* renamed from: f */
    public C4838z f19592f;

    /* renamed from: g */
    public long f19593g;

    /* renamed from: h */
    public String f19594h;

    /* renamed from: i */
    public String f19595i;

    /* renamed from: j */
    public List<String> f19596j;

    /* renamed from: k */
    public String f19597k;

    /* renamed from: y */
    private BitSet f19598y = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.aa$a */
    /* loaded from: classes2.dex */
    public enum EnumC4765a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        CMD_NAME(5, "cmdName"),
        REQUEST(6, SocialConstants.TYPE_REQUEST),
        ERROR_CODE(7, "errorCode"),
        REASON(8, "reason"),
        PACKAGE_NAME(9, "packageName"),
        CMD_ARGS(10, "cmdArgs"),
        CATEGORY(12, "category");
        

        /* renamed from: l */
        private static final Map<String, EnumC4765a> f19610l = new HashMap();

        /* renamed from: m */
        private final short f19612m;

        /* renamed from: n */
        private final String f19613n;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4765a.class).iterator();
            while (it2.hasNext()) {
                EnumC4765a enumC4765a = (EnumC4765a) it2.next();
                f19610l.put(enumC4765a.m3752a(), enumC4765a);
            }
        }

        EnumC4765a(short s, String str) {
            this.f19612m = s;
            this.f19613n = str;
        }

        /* renamed from: a */
        public String m3752a() {
            return this.f19613n;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4765a.class);
        enumMap.put((EnumMap) EnumC4765a.DEBUG, (EnumC4765a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4765a.TARGET, (EnumC4765a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4765a.ID, (EnumC4765a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4765a.APP_ID, (EnumC4765a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4765a.CMD_NAME, (EnumC4765a) new C5360b("cmdName", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4765a.REQUEST, (EnumC4765a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4838z.class)));
        enumMap.put((EnumMap) EnumC4765a.ERROR_CODE, (EnumC4765a) new C5360b("errorCode", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4765a.REASON, (EnumC4765a) new C5360b("reason", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4765a.PACKAGE_NAME, (EnumC4765a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4765a.CMD_ARGS, (EnumC4765a) new C5360b("cmdArgs", (byte) 2, new C5362d((byte) 15, new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4765a.CATEGORY, (EnumC4765a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f19574l = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4764aa.class, f19574l);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3760h()) {
                    throw new C5374f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3753o();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f19587a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f19588b = new C4828u();
                        this.f19588b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f19589c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f19590d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f19591e = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 12) {
                        this.f19592f = new C4838z();
                        this.f19592f.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 10) {
                        this.f19593g = abstractC5373e.mo1231u();
                        m3768a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b == 11) {
                        this.f19594h = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b == 11) {
                        this.f19595i = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f19596j = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            this.f19596j.add(abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1237n();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                default:
                    C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                    break;
                case 12:
                    if (mo1240i.f22437b == 11) {
                        this.f19597k = abstractC5373e.mo1223w();
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
    public void m3768a(boolean z) {
        this.f19598y.set(0, z);
    }

    /* renamed from: a */
    public boolean m3770a() {
        return this.f19587a != null;
    }

    /* renamed from: a */
    public boolean m3769a(C4764aa c4764aa) {
        if (c4764aa == null) {
            return false;
        }
        boolean m3770a = m3770a();
        boolean m3770a2 = c4764aa.m3770a();
        if ((m3770a || m3770a2) && (!m3770a || !m3770a2 || !this.f19587a.equals(c4764aa.f19587a))) {
            return false;
        }
        boolean m3767b = m3767b();
        boolean m3767b2 = c4764aa.m3767b();
        if ((m3767b || m3767b2) && (!m3767b || !m3767b2 || !this.f19588b.m3254a(c4764aa.f19588b))) {
            return false;
        }
        boolean m3765c = m3765c();
        boolean m3765c2 = c4764aa.m3765c();
        if ((m3765c || m3765c2) && (!m3765c || !m3765c2 || !this.f19589c.equals(c4764aa.f19589c))) {
            return false;
        }
        boolean m3764d = m3764d();
        boolean m3764d2 = c4764aa.m3764d();
        if ((m3764d || m3764d2) && (!m3764d || !m3764d2 || !this.f19590d.equals(c4764aa.f19590d))) {
            return false;
        }
        boolean m3762f = m3762f();
        boolean m3762f2 = c4764aa.m3762f();
        if ((m3762f || m3762f2) && (!m3762f || !m3762f2 || !this.f19591e.equals(c4764aa.f19591e))) {
            return false;
        }
        boolean m3761g = m3761g();
        boolean m3761g2 = c4764aa.m3761g();
        if (((m3761g || m3761g2) && (!m3761g || !m3761g2 || !this.f19592f.m3169a(c4764aa.f19592f))) || this.f19593g != c4764aa.f19593g) {
            return false;
        }
        boolean m3759i = m3759i();
        boolean m3759i2 = c4764aa.m3759i();
        if ((m3759i || m3759i2) && (!m3759i || !m3759i2 || !this.f19594h.equals(c4764aa.f19594h))) {
            return false;
        }
        boolean m3758j = m3758j();
        boolean m3758j2 = c4764aa.m3758j();
        if ((m3758j || m3758j2) && (!m3758j || !m3758j2 || !this.f19595i.equals(c4764aa.f19595i))) {
            return false;
        }
        boolean m3756l = m3756l();
        boolean m3756l2 = c4764aa.m3756l();
        if ((m3756l || m3756l2) && (!m3756l || !m3756l2 || !this.f19596j.equals(c4764aa.f19596j))) {
            return false;
        }
        boolean m3754n = m3754n();
        boolean m3754n2 = c4764aa.m3754n();
        return (!m3754n && !m3754n2) || (m3754n && m3754n2 && this.f19597k.equals(c4764aa.f19597k));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4764aa c4764aa) {
        int m1277a;
        int m1273a;
        int m1277a2;
        int m1277a3;
        int m1279a;
        int m1278a;
        int m1277a4;
        int m1277a5;
        int m1277a6;
        int m1278a2;
        int m1277a7;
        if (!getClass().equals(c4764aa.getClass())) {
            return getClass().getName().compareTo(c4764aa.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3770a()).compareTo(Boolean.valueOf(c4764aa.m3770a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3770a() && (m1277a7 = C5366b.m1277a(this.f19587a, c4764aa.f19587a)) != 0) {
            return m1277a7;
        }
        int compareTo2 = Boolean.valueOf(m3767b()).compareTo(Boolean.valueOf(c4764aa.m3767b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3767b() && (m1278a2 = C5366b.m1278a(this.f19588b, c4764aa.f19588b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3765c()).compareTo(Boolean.valueOf(c4764aa.m3765c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3765c() && (m1277a6 = C5366b.m1277a(this.f19589c, c4764aa.f19589c)) != 0) {
            return m1277a6;
        }
        int compareTo4 = Boolean.valueOf(m3764d()).compareTo(Boolean.valueOf(c4764aa.m3764d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3764d() && (m1277a5 = C5366b.m1277a(this.f19590d, c4764aa.f19590d)) != 0) {
            return m1277a5;
        }
        int compareTo5 = Boolean.valueOf(m3762f()).compareTo(Boolean.valueOf(c4764aa.m3762f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3762f() && (m1277a4 = C5366b.m1277a(this.f19591e, c4764aa.f19591e)) != 0) {
            return m1277a4;
        }
        int compareTo6 = Boolean.valueOf(m3761g()).compareTo(Boolean.valueOf(c4764aa.m3761g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3761g() && (m1278a = C5366b.m1278a(this.f19592f, c4764aa.f19592f)) != 0) {
            return m1278a;
        }
        int compareTo7 = Boolean.valueOf(m3760h()).compareTo(Boolean.valueOf(c4764aa.m3760h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3760h() && (m1279a = C5366b.m1279a(this.f19593g, c4764aa.f19593g)) != 0) {
            return m1279a;
        }
        int compareTo8 = Boolean.valueOf(m3759i()).compareTo(Boolean.valueOf(c4764aa.m3759i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3759i() && (m1277a3 = C5366b.m1277a(this.f19594h, c4764aa.f19594h)) != 0) {
            return m1277a3;
        }
        int compareTo9 = Boolean.valueOf(m3758j()).compareTo(Boolean.valueOf(c4764aa.m3758j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3758j() && (m1277a2 = C5366b.m1277a(this.f19595i, c4764aa.f19595i)) != 0) {
            return m1277a2;
        }
        int compareTo10 = Boolean.valueOf(m3756l()).compareTo(Boolean.valueOf(c4764aa.m3756l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3756l() && (m1273a = C5366b.m1273a(this.f19596j, c4764aa.f19596j)) != 0) {
            return m1273a;
        }
        int compareTo11 = Boolean.valueOf(m3754n()).compareTo(Boolean.valueOf(c4764aa.m3754n()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3754n() && (m1277a = C5366b.m1277a(this.f19597k, c4764aa.f19597k)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3753o();
        abstractC5373e.mo1250a(f19575m);
        if (this.f19587a != null && m3770a()) {
            abstractC5373e.mo1254a(f19576n);
            abstractC5373e.mo1256a(this.f19587a);
            abstractC5373e.mo1247b();
        }
        if (this.f19588b != null && m3767b()) {
            abstractC5373e.mo1254a(f19577o);
            this.f19588b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19589c != null) {
            abstractC5373e.mo1254a(f19578p);
            abstractC5373e.mo1256a(this.f19589c);
            abstractC5373e.mo1247b();
        }
        if (this.f19590d != null) {
            abstractC5373e.mo1254a(f19579q);
            abstractC5373e.mo1256a(this.f19590d);
            abstractC5373e.mo1247b();
        }
        if (this.f19591e != null) {
            abstractC5373e.mo1254a(f19580r);
            abstractC5373e.mo1256a(this.f19591e);
            abstractC5373e.mo1247b();
        }
        if (this.f19592f != null && m3761g()) {
            abstractC5373e.mo1254a(f19581s);
            this.f19592f.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f19582t);
        abstractC5373e.mo1257a(this.f19593g);
        abstractC5373e.mo1247b();
        if (this.f19594h != null && m3759i()) {
            abstractC5373e.mo1254a(f19583u);
            abstractC5373e.mo1256a(this.f19594h);
            abstractC5373e.mo1247b();
        }
        if (this.f19595i != null && m3758j()) {
            abstractC5373e.mo1254a(f19584v);
            abstractC5373e.mo1256a(this.f19595i);
            abstractC5373e.mo1247b();
        }
        if (this.f19596j != null && m3756l()) {
            abstractC5373e.mo1254a(f19585w);
            abstractC5373e.mo1253a(new C5371c((byte) 11, this.f19596j.size()));
            for (String str : this.f19596j) {
                abstractC5373e.mo1256a(str);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        if (this.f19597k != null && m3754n()) {
            abstractC5373e.mo1254a(f19586x);
            abstractC5373e.mo1256a(this.f19597k);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3767b() {
        return this.f19588b != null;
    }

    /* renamed from: c */
    public boolean m3765c() {
        return this.f19589c != null;
    }

    /* renamed from: d */
    public boolean m3764d() {
        return this.f19590d != null;
    }

    /* renamed from: e */
    public String m3763e() {
        return this.f19591e;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4764aa)) {
            return m3769a((C4764aa) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3762f() {
        return this.f19591e != null;
    }

    /* renamed from: g */
    public boolean m3761g() {
        return this.f19592f != null;
    }

    /* renamed from: h */
    public boolean m3760h() {
        return this.f19598y.get(0);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3759i() {
        return this.f19594h != null;
    }

    /* renamed from: j */
    public boolean m3758j() {
        return this.f19595i != null;
    }

    /* renamed from: k */
    public List<String> m3757k() {
        return this.f19596j;
    }

    /* renamed from: l */
    public boolean m3756l() {
        return this.f19596j != null;
    }

    /* renamed from: m */
    public String m3755m() {
        return this.f19597k;
    }

    /* renamed from: n */
    public boolean m3754n() {
        return this.f19597k != null;
    }

    /* renamed from: o */
    public void m3753o() {
        if (this.f19589c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f19590d == null) {
            throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f19591e != null) {
            return;
        }
        throw new C5374f("Required field 'cmdName' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z2 = true;
        if (m3770a()) {
            sb.append("debug:");
            if (this.f19587a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19587a);
            }
            z2 = false;
        }
        if (m3767b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19588b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19588b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19589c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19589c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f19590d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19590d);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f19591e == null) {
            sb.append("null");
        } else {
            sb.append(this.f19591e);
        }
        if (m3761g()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f19592f == null) {
                sb.append("null");
            } else {
                sb.append(this.f19592f);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f19593g);
        if (m3759i()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f19594h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19594h);
            }
        }
        if (m3758j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19595i == null) {
                sb.append("null");
            } else {
                sb.append(this.f19595i);
            }
        }
        if (m3756l()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f19596j == null) {
                sb.append("null");
            } else {
                sb.append(this.f19596j);
            }
        }
        if (m3754n()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f19597k == null) {
                sb.append("null");
            } else {
                sb.append(this.f19597k);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
