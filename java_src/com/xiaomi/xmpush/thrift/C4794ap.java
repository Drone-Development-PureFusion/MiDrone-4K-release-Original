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
/* renamed from: com.xiaomi.xmpush.thrift.ap */
/* loaded from: classes2.dex */
public class C4794ap implements Serializable, Cloneable, AbstractC5358a<C4794ap, EnumC4795a> {

    /* renamed from: k */
    public static final Map<EnumC4795a, C5360b> f20079k;

    /* renamed from: l */
    private static final C5378j f20080l = new C5378j("XmPushActionUnSubscriptionResult");

    /* renamed from: m */
    private static final C5370b f20081m = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: n */
    private static final C5370b f20082n = new C5370b("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C5370b f20083o = new C5370b("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C5370b f20084p = new C5370b("appId", (byte) 11, 4);

    /* renamed from: q */
    private static final C5370b f20085q = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 5);

    /* renamed from: r */
    private static final C5370b f20086r = new C5370b("errorCode", (byte) 10, 6);

    /* renamed from: s */
    private static final C5370b f20087s = new C5370b("reason", (byte) 11, 7);

    /* renamed from: t */
    private static final C5370b f20088t = new C5370b("topic", (byte) 11, 8);

    /* renamed from: u */
    private static final C5370b f20089u = new C5370b("packageName", (byte) 11, 9);

    /* renamed from: v */
    private static final C5370b f20090v = new C5370b("category", (byte) 11, 10);

    /* renamed from: a */
    public String f20091a;

    /* renamed from: b */
    public C4828u f20092b;

    /* renamed from: c */
    public String f20093c;

    /* renamed from: d */
    public String f20094d;

    /* renamed from: e */
    public C4792ao f20095e;

    /* renamed from: f */
    public long f20096f;

    /* renamed from: g */
    public String f20097g;

    /* renamed from: h */
    public String f20098h;

    /* renamed from: i */
    public String f20099i;

    /* renamed from: j */
    public String f20100j;

    /* renamed from: w */
    private BitSet f20101w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.ap$a */
    /* loaded from: classes2.dex */
    public enum EnumC4795a {
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
        private static final Map<String, EnumC4795a> f20112k = new HashMap();

        /* renamed from: l */
        private final short f20114l;

        /* renamed from: m */
        private final String f20115m;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4795a.class).iterator();
            while (it2.hasNext()) {
                EnumC4795a enumC4795a = (EnumC4795a) it2.next();
                f20112k.put(enumC4795a.m3473a(), enumC4795a);
            }
        }

        EnumC4795a(short s, String str) {
            this.f20114l = s;
            this.f20115m = str;
        }

        /* renamed from: a */
        public String m3473a() {
            return this.f20115m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4795a.class);
        enumMap.put((EnumMap) EnumC4795a.DEBUG, (EnumC4795a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4795a.TARGET, (EnumC4795a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4795a.ID, (EnumC4795a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4795a.APP_ID, (EnumC4795a) new C5360b("appId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4795a.REQUEST, (EnumC4795a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4792ao.class)));
        enumMap.put((EnumMap) EnumC4795a.ERROR_CODE, (EnumC4795a) new C5360b("errorCode", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4795a.REASON, (EnumC4795a) new C5360b("reason", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4795a.TOPIC, (EnumC4795a) new C5360b("topic", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4795a.PACKAGE_NAME, (EnumC4795a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4795a.CATEGORY, (EnumC4795a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f20079k = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4794ap.class, f20079k);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3474m();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20091a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20092b = new C4828u();
                        this.f20092b.mo1286a(abstractC5373e);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20093c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20094d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20095e = new C4792ao();
                        this.f20095e.mo1286a(abstractC5373e);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20096f = abstractC5373e.mo1231u();
                        m3487a(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20097g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20098h = abstractC5373e.mo1223w();
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20099i = abstractC5373e.mo1223w();
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20100j = abstractC5373e.mo1223w();
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
    public void m3487a(boolean z) {
        this.f20101w.set(0, z);
    }

    /* renamed from: a */
    public boolean m3489a() {
        return this.f20091a != null;
    }

    /* renamed from: a */
    public boolean m3488a(C4794ap c4794ap) {
        if (c4794ap == null) {
            return false;
        }
        boolean m3489a = m3489a();
        boolean m3489a2 = c4794ap.m3489a();
        if ((m3489a || m3489a2) && (!m3489a || !m3489a2 || !this.f20091a.equals(c4794ap.f20091a))) {
            return false;
        }
        boolean m3486b = m3486b();
        boolean m3486b2 = c4794ap.m3486b();
        if ((m3486b || m3486b2) && (!m3486b || !m3486b2 || !this.f20092b.m3254a(c4794ap.f20092b))) {
            return false;
        }
        boolean m3484c = m3484c();
        boolean m3484c2 = c4794ap.m3484c();
        if ((m3484c || m3484c2) && (!m3484c || !m3484c2 || !this.f20093c.equals(c4794ap.f20093c))) {
            return false;
        }
        boolean m3483d = m3483d();
        boolean m3483d2 = c4794ap.m3483d();
        if ((m3483d || m3483d2) && (!m3483d || !m3483d2 || !this.f20094d.equals(c4794ap.f20094d))) {
            return false;
        }
        boolean m3482e = m3482e();
        boolean m3482e2 = c4794ap.m3482e();
        if ((m3482e || m3482e2) && (!m3482e || !m3482e2 || !this.f20095e.m3504a(c4794ap.f20095e))) {
            return false;
        }
        boolean m3481f = m3481f();
        boolean m3481f2 = c4794ap.m3481f();
        if ((m3481f || m3481f2) && (!m3481f || !m3481f2 || this.f20096f != c4794ap.f20096f)) {
            return false;
        }
        boolean m3480g = m3480g();
        boolean m3480g2 = c4794ap.m3480g();
        if ((m3480g || m3480g2) && (!m3480g || !m3480g2 || !this.f20097g.equals(c4794ap.f20097g))) {
            return false;
        }
        boolean m3478i = m3478i();
        boolean m3478i2 = c4794ap.m3478i();
        if ((m3478i || m3478i2) && (!m3478i || !m3478i2 || !this.f20098h.equals(c4794ap.f20098h))) {
            return false;
        }
        boolean m3477j = m3477j();
        boolean m3477j2 = c4794ap.m3477j();
        if ((m3477j || m3477j2) && (!m3477j || !m3477j2 || !this.f20099i.equals(c4794ap.f20099i))) {
            return false;
        }
        boolean m3475l = m3475l();
        boolean m3475l2 = c4794ap.m3475l();
        return (!m3475l && !m3475l2) || (m3475l && m3475l2 && this.f20100j.equals(c4794ap.f20100j));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4794ap c4794ap) {
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
        if (!getClass().equals(c4794ap.getClass())) {
            return getClass().getName().compareTo(c4794ap.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3489a()).compareTo(Boolean.valueOf(c4794ap.m3489a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3489a() && (m1277a7 = C5366b.m1277a(this.f20091a, c4794ap.f20091a)) != 0) {
            return m1277a7;
        }
        int compareTo2 = Boolean.valueOf(m3486b()).compareTo(Boolean.valueOf(c4794ap.m3486b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3486b() && (m1278a2 = C5366b.m1278a(this.f20092b, c4794ap.f20092b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3484c()).compareTo(Boolean.valueOf(c4794ap.m3484c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3484c() && (m1277a6 = C5366b.m1277a(this.f20093c, c4794ap.f20093c)) != 0) {
            return m1277a6;
        }
        int compareTo4 = Boolean.valueOf(m3483d()).compareTo(Boolean.valueOf(c4794ap.m3483d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3483d() && (m1277a5 = C5366b.m1277a(this.f20094d, c4794ap.f20094d)) != 0) {
            return m1277a5;
        }
        int compareTo5 = Boolean.valueOf(m3482e()).compareTo(Boolean.valueOf(c4794ap.m3482e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3482e() && (m1278a = C5366b.m1278a(this.f20095e, c4794ap.f20095e)) != 0) {
            return m1278a;
        }
        int compareTo6 = Boolean.valueOf(m3481f()).compareTo(Boolean.valueOf(c4794ap.m3481f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3481f() && (m1279a = C5366b.m1279a(this.f20096f, c4794ap.f20096f)) != 0) {
            return m1279a;
        }
        int compareTo7 = Boolean.valueOf(m3480g()).compareTo(Boolean.valueOf(c4794ap.m3480g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3480g() && (m1277a4 = C5366b.m1277a(this.f20097g, c4794ap.f20097g)) != 0) {
            return m1277a4;
        }
        int compareTo8 = Boolean.valueOf(m3478i()).compareTo(Boolean.valueOf(c4794ap.m3478i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3478i() && (m1277a3 = C5366b.m1277a(this.f20098h, c4794ap.f20098h)) != 0) {
            return m1277a3;
        }
        int compareTo9 = Boolean.valueOf(m3477j()).compareTo(Boolean.valueOf(c4794ap.m3477j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3477j() && (m1277a2 = C5366b.m1277a(this.f20099i, c4794ap.f20099i)) != 0) {
            return m1277a2;
        }
        int compareTo10 = Boolean.valueOf(m3475l()).compareTo(Boolean.valueOf(c4794ap.m3475l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3475l() && (m1277a = C5366b.m1277a(this.f20100j, c4794ap.f20100j)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3474m();
        abstractC5373e.mo1250a(f20080l);
        if (this.f20091a != null && m3489a()) {
            abstractC5373e.mo1254a(f20081m);
            abstractC5373e.mo1256a(this.f20091a);
            abstractC5373e.mo1247b();
        }
        if (this.f20092b != null && m3486b()) {
            abstractC5373e.mo1254a(f20082n);
            this.f20092b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20093c != null) {
            abstractC5373e.mo1254a(f20083o);
            abstractC5373e.mo1256a(this.f20093c);
            abstractC5373e.mo1247b();
        }
        if (this.f20094d != null && m3483d()) {
            abstractC5373e.mo1254a(f20084p);
            abstractC5373e.mo1256a(this.f20094d);
            abstractC5373e.mo1247b();
        }
        if (this.f20095e != null && m3482e()) {
            abstractC5373e.mo1254a(f20085q);
            this.f20095e.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (m3481f()) {
            abstractC5373e.mo1254a(f20086r);
            abstractC5373e.mo1257a(this.f20096f);
            abstractC5373e.mo1247b();
        }
        if (this.f20097g != null && m3480g()) {
            abstractC5373e.mo1254a(f20087s);
            abstractC5373e.mo1256a(this.f20097g);
            abstractC5373e.mo1247b();
        }
        if (this.f20098h != null && m3478i()) {
            abstractC5373e.mo1254a(f20088t);
            abstractC5373e.mo1256a(this.f20098h);
            abstractC5373e.mo1247b();
        }
        if (this.f20099i != null && m3477j()) {
            abstractC5373e.mo1254a(f20089u);
            abstractC5373e.mo1256a(this.f20099i);
            abstractC5373e.mo1247b();
        }
        if (this.f20100j != null && m3475l()) {
            abstractC5373e.mo1254a(f20090v);
            abstractC5373e.mo1256a(this.f20100j);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3486b() {
        return this.f20092b != null;
    }

    /* renamed from: c */
    public boolean m3484c() {
        return this.f20093c != null;
    }

    /* renamed from: d */
    public boolean m3483d() {
        return this.f20094d != null;
    }

    /* renamed from: e */
    public boolean m3482e() {
        return this.f20095e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4794ap)) {
            return m3488a((C4794ap) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3481f() {
        return this.f20101w.get(0);
    }

    /* renamed from: g */
    public boolean m3480g() {
        return this.f20097g != null;
    }

    /* renamed from: h */
    public String m3479h() {
        return this.f20098h;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3478i() {
        return this.f20098h != null;
    }

    /* renamed from: j */
    public boolean m3477j() {
        return this.f20099i != null;
    }

    /* renamed from: k */
    public String m3476k() {
        return this.f20100j;
    }

    /* renamed from: l */
    public boolean m3475l() {
        return this.f20100j != null;
    }

    /* renamed from: m */
    public void m3474m() {
        if (this.f20093c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m3489a()) {
            sb.append("debug:");
            if (this.f20091a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20091a);
            }
            z2 = false;
        }
        if (m3486b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f20092b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20092b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f20093c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20093c);
        }
        if (m3483d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f20094d == null) {
                sb.append("null");
            } else {
                sb.append(this.f20094d);
            }
        }
        if (m3482e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f20095e == null) {
                sb.append("null");
            } else {
                sb.append(this.f20095e);
            }
        }
        if (m3481f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f20096f);
        }
        if (m3480g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f20097g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20097g);
            }
        }
        if (m3478i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f20098h == null) {
                sb.append("null");
            } else {
                sb.append(this.f20098h);
            }
        }
        if (m3477j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20099i == null) {
                sb.append("null");
            } else {
                sb.append(this.f20099i);
            }
        }
        if (m3475l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f20100j == null) {
                sb.append("null");
            } else {
                sb.append(this.f20100j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
