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
import org.p248a.p283b.p284a.C5363e;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5372d;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.x */
/* loaded from: classes2.dex */
public class C4834x implements Serializable, Cloneable, AbstractC5358a<C4834x, EnumC4835a> {

    /* renamed from: l */
    public static final Map<EnumC4835a, C5360b> f20598l;

    /* renamed from: m */
    private static final C5378j f20599m = new C5378j("XmPushActionAckNotification");

    /* renamed from: n */
    private static final C5370b f20600n = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: o */
    private static final C5370b f20601o = new C5370b("target", (byte) 12, 2);

    /* renamed from: p */
    private static final C5370b f20602p = new C5370b("id", (byte) 11, 3);

    /* renamed from: q */
    private static final C5370b f20603q = new C5370b("appId", (byte) 11, 4);

    /* renamed from: r */
    private static final C5370b f20604r = new C5370b("type", (byte) 11, 5);

    /* renamed from: s */
    private static final C5370b f20605s = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 6);

    /* renamed from: t */
    private static final C5370b f20606t = new C5370b("errorCode", (byte) 10, 7);

    /* renamed from: u */
    private static final C5370b f20607u = new C5370b("reason", (byte) 11, 8);

    /* renamed from: v */
    private static final C5370b f20608v = new C5370b("extra", (byte) 13, 9);

    /* renamed from: w */
    private static final C5370b f20609w = new C5370b("packageName", (byte) 11, 10);

    /* renamed from: x */
    private static final C5370b f20610x = new C5370b("category", (byte) 11, 11);

    /* renamed from: a */
    public String f20611a;

    /* renamed from: b */
    public C4828u f20612b;

    /* renamed from: c */
    public String f20613c;

    /* renamed from: d */
    public String f20614d;

    /* renamed from: e */
    public String f20615e;

    /* renamed from: f */
    public C4772ae f20616f;

    /* renamed from: g */
    public long f20617g;

    /* renamed from: h */
    public String f20618h;

    /* renamed from: i */
    public Map<String, String> f20619i;

    /* renamed from: j */
    public String f20620j;

    /* renamed from: k */
    public String f20621k;

    /* renamed from: y */
    private BitSet f20622y = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.x$a */
    /* loaded from: classes2.dex */
    public enum EnumC4835a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        TYPE(5, "type"),
        REQUEST(6, SocialConstants.TYPE_REQUEST),
        ERROR_CODE(7, "errorCode"),
        REASON(8, "reason"),
        EXTRA(9, "extra"),
        PACKAGE_NAME(10, "packageName"),
        CATEGORY(11, "category");
        

        /* renamed from: l */
        private static final Map<String, EnumC4835a> f20634l = new HashMap();

        /* renamed from: m */
        private final short f20636m;

        /* renamed from: n */
        private final String f20637n;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4835a.class).iterator();
            while (it2.hasNext()) {
                EnumC4835a enumC4835a = (EnumC4835a) it2.next();
                f20634l.put(enumC4835a.m3181a(), enumC4835a);
            }
        }

        EnumC4835a(short s, String str) {
            this.f20636m = s;
            this.f20637n = str;
        }

        /* renamed from: a */
        public String m3181a() {
            return this.f20637n;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4835a.class);
        enumMap.put((EnumMap) EnumC4835a.DEBUG, (EnumC4835a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4835a.TARGET, (EnumC4835a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4835a.ID, (EnumC4835a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4835a.APP_ID, (EnumC4835a) new C5360b("appId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4835a.TYPE, (EnumC4835a) new C5360b("type", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4835a.REQUEST, (EnumC4835a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4772ae.class)));
        enumMap.put((EnumMap) EnumC4835a.ERROR_CODE, (EnumC4835a) new C5360b("errorCode", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4835a.REASON, (EnumC4835a) new C5360b("reason", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4835a.EXTRA, (EnumC4835a) new C5360b("extra", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4835a.PACKAGE_NAME, (EnumC4835a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4835a.CATEGORY, (EnumC4835a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f20598l = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4834x.class, f20598l);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3187h()) {
                    throw new C5374f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3182m();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f20611a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f20612b = new C4828u();
                        this.f20612b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f20613c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f20614d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f20615e = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 12) {
                        this.f20616f = new C4772ae();
                        this.f20616f.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 10) {
                        this.f20617g = abstractC5373e.mo1231u();
                        m3195a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b == 11) {
                        this.f20618h = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k = abstractC5373e.mo1226k();
                        this.f20619i = new HashMap(mo1226k.f22443c * 2);
                        for (int i = 0; i < mo1226k.f22443c; i++) {
                            this.f20619i.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 11) {
                        this.f20620j = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                    if (mo1240i.f22437b == 11) {
                        this.f20621k = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
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
    public void m3195a(boolean z) {
        this.f20622y.set(0, z);
    }

    /* renamed from: a */
    public boolean m3197a() {
        return this.f20611a != null;
    }

    /* renamed from: a */
    public boolean m3196a(C4834x c4834x) {
        if (c4834x == null) {
            return false;
        }
        boolean m3197a = m3197a();
        boolean m3197a2 = c4834x.m3197a();
        if ((m3197a || m3197a2) && (!m3197a || !m3197a2 || !this.f20611a.equals(c4834x.f20611a))) {
            return false;
        }
        boolean m3194b = m3194b();
        boolean m3194b2 = c4834x.m3194b();
        if ((m3194b || m3194b2) && (!m3194b || !m3194b2 || !this.f20612b.m3254a(c4834x.f20612b))) {
            return false;
        }
        boolean m3191d = m3191d();
        boolean m3191d2 = c4834x.m3191d();
        if ((m3191d || m3191d2) && (!m3191d || !m3191d2 || !this.f20613c.equals(c4834x.f20613c))) {
            return false;
        }
        boolean m3190e = m3190e();
        boolean m3190e2 = c4834x.m3190e();
        if ((m3190e || m3190e2) && (!m3190e || !m3190e2 || !this.f20614d.equals(c4834x.f20614d))) {
            return false;
        }
        boolean m3189f = m3189f();
        boolean m3189f2 = c4834x.m3189f();
        if ((m3189f || m3189f2) && (!m3189f || !m3189f2 || !this.f20615e.equals(c4834x.f20615e))) {
            return false;
        }
        boolean m3188g = m3188g();
        boolean m3188g2 = c4834x.m3188g();
        if (((m3188g || m3188g2) && (!m3188g || !m3188g2 || !this.f20616f.m3707a(c4834x.f20616f))) || this.f20617g != c4834x.f20617g) {
            return false;
        }
        boolean m3186i = m3186i();
        boolean m3186i2 = c4834x.m3186i();
        if ((m3186i || m3186i2) && (!m3186i || !m3186i2 || !this.f20618h.equals(c4834x.f20618h))) {
            return false;
        }
        boolean m3185j = m3185j();
        boolean m3185j2 = c4834x.m3185j();
        if ((m3185j || m3185j2) && (!m3185j || !m3185j2 || !this.f20619i.equals(c4834x.f20619i))) {
            return false;
        }
        boolean m3184k = m3184k();
        boolean m3184k2 = c4834x.m3184k();
        if ((m3184k || m3184k2) && (!m3184k || !m3184k2 || !this.f20620j.equals(c4834x.f20620j))) {
            return false;
        }
        boolean m3183l = m3183l();
        boolean m3183l2 = c4834x.m3183l();
        return (!m3183l && !m3183l2) || (m3183l && m3183l2 && this.f20621k.equals(c4834x.f20621k));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4834x c4834x) {
        int m1277a;
        int m1277a2;
        int m1272a;
        int m1277a3;
        int m1279a;
        int m1278a;
        int m1277a4;
        int m1277a5;
        int m1277a6;
        int m1278a2;
        int m1277a7;
        if (!getClass().equals(c4834x.getClass())) {
            return getClass().getName().compareTo(c4834x.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3197a()).compareTo(Boolean.valueOf(c4834x.m3197a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3197a() && (m1277a7 = C5366b.m1277a(this.f20611a, c4834x.f20611a)) != 0) {
            return m1277a7;
        }
        int compareTo2 = Boolean.valueOf(m3194b()).compareTo(Boolean.valueOf(c4834x.m3194b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3194b() && (m1278a2 = C5366b.m1278a(this.f20612b, c4834x.f20612b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3191d()).compareTo(Boolean.valueOf(c4834x.m3191d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3191d() && (m1277a6 = C5366b.m1277a(this.f20613c, c4834x.f20613c)) != 0) {
            return m1277a6;
        }
        int compareTo4 = Boolean.valueOf(m3190e()).compareTo(Boolean.valueOf(c4834x.m3190e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3190e() && (m1277a5 = C5366b.m1277a(this.f20614d, c4834x.f20614d)) != 0) {
            return m1277a5;
        }
        int compareTo5 = Boolean.valueOf(m3189f()).compareTo(Boolean.valueOf(c4834x.m3189f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3189f() && (m1277a4 = C5366b.m1277a(this.f20615e, c4834x.f20615e)) != 0) {
            return m1277a4;
        }
        int compareTo6 = Boolean.valueOf(m3188g()).compareTo(Boolean.valueOf(c4834x.m3188g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3188g() && (m1278a = C5366b.m1278a(this.f20616f, c4834x.f20616f)) != 0) {
            return m1278a;
        }
        int compareTo7 = Boolean.valueOf(m3187h()).compareTo(Boolean.valueOf(c4834x.m3187h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3187h() && (m1279a = C5366b.m1279a(this.f20617g, c4834x.f20617g)) != 0) {
            return m1279a;
        }
        int compareTo8 = Boolean.valueOf(m3186i()).compareTo(Boolean.valueOf(c4834x.m3186i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3186i() && (m1277a3 = C5366b.m1277a(this.f20618h, c4834x.f20618h)) != 0) {
            return m1277a3;
        }
        int compareTo9 = Boolean.valueOf(m3185j()).compareTo(Boolean.valueOf(c4834x.m3185j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3185j() && (m1272a = C5366b.m1272a(this.f20619i, c4834x.f20619i)) != 0) {
            return m1272a;
        }
        int compareTo10 = Boolean.valueOf(m3184k()).compareTo(Boolean.valueOf(c4834x.m3184k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3184k() && (m1277a2 = C5366b.m1277a(this.f20620j, c4834x.f20620j)) != 0) {
            return m1277a2;
        }
        int compareTo11 = Boolean.valueOf(m3183l()).compareTo(Boolean.valueOf(c4834x.m3183l()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3183l() && (m1277a = C5366b.m1277a(this.f20621k, c4834x.f20621k)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3182m();
        abstractC5373e.mo1250a(f20599m);
        if (this.f20611a != null && m3197a()) {
            abstractC5373e.mo1254a(f20600n);
            abstractC5373e.mo1256a(this.f20611a);
            abstractC5373e.mo1247b();
        }
        if (this.f20612b != null && m3194b()) {
            abstractC5373e.mo1254a(f20601o);
            this.f20612b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20613c != null) {
            abstractC5373e.mo1254a(f20602p);
            abstractC5373e.mo1256a(this.f20613c);
            abstractC5373e.mo1247b();
        }
        if (this.f20614d != null && m3190e()) {
            abstractC5373e.mo1254a(f20603q);
            abstractC5373e.mo1256a(this.f20614d);
            abstractC5373e.mo1247b();
        }
        if (this.f20615e != null && m3189f()) {
            abstractC5373e.mo1254a(f20604r);
            abstractC5373e.mo1256a(this.f20615e);
            abstractC5373e.mo1247b();
        }
        if (this.f20616f != null && m3188g()) {
            abstractC5373e.mo1254a(f20605s);
            this.f20616f.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f20606t);
        abstractC5373e.mo1257a(this.f20617g);
        abstractC5373e.mo1247b();
        if (this.f20618h != null && m3186i()) {
            abstractC5373e.mo1254a(f20607u);
            abstractC5373e.mo1256a(this.f20618h);
            abstractC5373e.mo1247b();
        }
        if (this.f20619i != null && m3185j()) {
            abstractC5373e.mo1254a(f20608v);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f20619i.size()));
            for (Map.Entry<String, String> entry : this.f20619i.entrySet()) {
                abstractC5373e.mo1256a(entry.getKey());
                abstractC5373e.mo1256a(entry.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        if (this.f20620j != null && m3184k()) {
            abstractC5373e.mo1254a(f20609w);
            abstractC5373e.mo1256a(this.f20620j);
            abstractC5373e.mo1247b();
        }
        if (this.f20621k != null && m3183l()) {
            abstractC5373e.mo1254a(f20610x);
            abstractC5373e.mo1256a(this.f20621k);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3194b() {
        return this.f20612b != null;
    }

    /* renamed from: c */
    public String m3192c() {
        return this.f20613c;
    }

    /* renamed from: d */
    public boolean m3191d() {
        return this.f20613c != null;
    }

    /* renamed from: e */
    public boolean m3190e() {
        return this.f20614d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4834x)) {
            return m3196a((C4834x) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3189f() {
        return this.f20615e != null;
    }

    /* renamed from: g */
    public boolean m3188g() {
        return this.f20616f != null;
    }

    /* renamed from: h */
    public boolean m3187h() {
        return this.f20622y.get(0);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3186i() {
        return this.f20618h != null;
    }

    /* renamed from: j */
    public boolean m3185j() {
        return this.f20619i != null;
    }

    /* renamed from: k */
    public boolean m3184k() {
        return this.f20620j != null;
    }

    /* renamed from: l */
    public boolean m3183l() {
        return this.f20621k != null;
    }

    /* renamed from: m */
    public void m3182m() {
        if (this.f20613c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m3197a()) {
            sb.append("debug:");
            if (this.f20611a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20611a);
            }
            z2 = false;
        }
        if (m3194b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f20612b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20612b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f20613c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20613c);
        }
        if (m3190e()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f20614d == null) {
                sb.append("null");
            } else {
                sb.append(this.f20614d);
            }
        }
        if (m3189f()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f20615e == null) {
                sb.append("null");
            } else {
                sb.append(this.f20615e);
            }
        }
        if (m3188g()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f20616f == null) {
                sb.append("null");
            } else {
                sb.append(this.f20616f);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f20617g);
        if (m3186i()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f20618h == null) {
                sb.append("null");
            } else {
                sb.append(this.f20618h);
            }
        }
        if (m3185j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f20619i == null) {
                sb.append("null");
            } else {
                sb.append(this.f20619i);
            }
        }
        if (m3184k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20620j == null) {
                sb.append("null");
            } else {
                sb.append(this.f20620j);
            }
        }
        if (m3183l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f20621k == null) {
                sb.append("null");
            } else {
                sb.append(this.f20621k);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
