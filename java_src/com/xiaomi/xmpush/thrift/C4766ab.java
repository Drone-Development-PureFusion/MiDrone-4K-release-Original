package com.xiaomi.xmpush.thrift;

import com.tencent.tauth.AuthActivity;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5366b;
import org.p248a.p283b.p284a.C5359a;
import org.p248a.p283b.p284a.C5360b;
import org.p248a.p283b.p284a.C5361c;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.ab */
/* loaded from: classes.dex */
public class C4766ab implements Serializable, Cloneable, AbstractC5358a<C4766ab, EnumC4767a> {

    /* renamed from: i */
    public static final Map<EnumC4767a, C5360b> f19614i;

    /* renamed from: j */
    private static final C5378j f19615j = new C5378j("XmPushActionContainer");

    /* renamed from: k */
    private static final C5370b f19616k = new C5370b(AuthActivity.ACTION_KEY, (byte) 8, 1);

    /* renamed from: l */
    private static final C5370b f19617l = new C5370b("encryptAction", (byte) 2, 2);

    /* renamed from: m */
    private static final C5370b f19618m = new C5370b("isRequest", (byte) 2, 3);

    /* renamed from: n */
    private static final C5370b f19619n = new C5370b("pushAction", (byte) 11, 4);

    /* renamed from: o */
    private static final C5370b f19620o = new C5370b("appid", (byte) 11, 5);

    /* renamed from: p */
    private static final C5370b f19621p = new C5370b("packageName", (byte) 11, 6);

    /* renamed from: q */
    private static final C5370b f19622q = new C5370b("target", (byte) 12, 7);

    /* renamed from: r */
    private static final C5370b f19623r = new C5370b("metaInfo", (byte) 12, 8);

    /* renamed from: a */
    public EnumC4763a f19624a;

    /* renamed from: d */
    public ByteBuffer f19627d;

    /* renamed from: e */
    public String f19628e;

    /* renamed from: f */
    public String f19629f;

    /* renamed from: g */
    public C4828u f19630g;

    /* renamed from: h */
    public C4823r f19631h;

    /* renamed from: s */
    private BitSet f19632s = new BitSet(2);

    /* renamed from: b */
    public boolean f19625b = true;

    /* renamed from: c */
    public boolean f19626c = true;

    /* renamed from: com.xiaomi.xmpush.thrift.ab$a */
    /* loaded from: classes2.dex */
    public enum EnumC4767a {
        ACTION(1, AuthActivity.ACTION_KEY),
        ENCRYPT_ACTION(2, "encryptAction"),
        IS_REQUEST(3, "isRequest"),
        PUSH_ACTION(4, "pushAction"),
        APPID(5, "appid"),
        PACKAGE_NAME(6, "packageName"),
        TARGET(7, "target"),
        META_INFO(8, "metaInfo");
        

        /* renamed from: i */
        private static final Map<String, EnumC4767a> f19641i = new HashMap();

        /* renamed from: j */
        private final short f19643j;

        /* renamed from: k */
        private final String f19644k;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4767a.class).iterator();
            while (it2.hasNext()) {
                EnumC4767a enumC4767a = (EnumC4767a) it2.next();
                f19641i.put(enumC4767a.m3724a(), enumC4767a);
            }
        }

        EnumC4767a(short s, String str) {
            this.f19643j = s;
            this.f19644k = str;
        }

        /* renamed from: a */
        public String m3724a() {
            return this.f19644k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4767a.class);
        enumMap.put((EnumMap) EnumC4767a.ACTION, (EnumC4767a) new C5360b(AuthActivity.ACTION_KEY, (byte) 1, new C5359a((byte) 16, EnumC4763a.class)));
        enumMap.put((EnumMap) EnumC4767a.ENCRYPT_ACTION, (EnumC4767a) new C5360b("encryptAction", (byte) 1, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4767a.IS_REQUEST, (EnumC4767a) new C5360b("isRequest", (byte) 1, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4767a.PUSH_ACTION, (EnumC4767a) new C5360b("pushAction", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4767a.APPID, (EnumC4767a) new C5360b("appid", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4767a.PACKAGE_NAME, (EnumC4767a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4767a.TARGET, (EnumC4767a) new C5360b("target", (byte) 1, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4767a.META_INFO, (EnumC4767a) new C5360b("metaInfo", (byte) 2, new C5365g((byte) 12, C4823r.class)));
        f19614i = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4766ab.class, f19614i);
    }

    /* renamed from: a */
    public EnumC4763a m3751a() {
        return this.f19624a;
    }

    /* renamed from: a */
    public C4766ab m3750a(EnumC4763a enumC4763a) {
        this.f19624a = enumC4763a;
        return this;
    }

    /* renamed from: a */
    public C4766ab m3748a(C4823r c4823r) {
        this.f19631h = c4823r;
        return this;
    }

    /* renamed from: a */
    public C4766ab m3747a(C4828u c4828u) {
        this.f19630g = c4828u;
        return this;
    }

    /* renamed from: a */
    public C4766ab m3746a(String str) {
        this.f19628e = str;
        return this;
    }

    /* renamed from: a */
    public C4766ab m3745a(ByteBuffer byteBuffer) {
        this.f19627d = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public C4766ab m3744a(boolean z) {
        this.f19625b = z;
        m3740b(true);
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
                if (!m3737d()) {
                    throw new C5374f("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!m3735e()) {
                    throw new C5374f("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m3725o();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19624a = EnumC4763a.m3771a(abstractC5373e.mo1232t());
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 2) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19625b = abstractC5373e.mo1235q();
                        m3740b(true);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 2) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19626c = abstractC5373e.mo1235q();
                        m3736d(true);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19627d = abstractC5373e.mo1222x();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19628e = abstractC5373e.mo1223w();
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19629f = abstractC5373e.mo1223w();
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19630g = new C4828u();
                        this.f19630g.mo1286a(abstractC5373e);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 12) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19631h = new C4823r();
                        this.f19631h.mo1286a(abstractC5373e);
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
    public boolean m3749a(C4766ab c4766ab) {
        if (c4766ab == null) {
            return false;
        }
        boolean m3743b = m3743b();
        boolean m3743b2 = c4766ab.m3743b();
        if (((m3743b || m3743b2) && (!m3743b || !m3743b2 || !this.f19624a.equals(c4766ab.f19624a))) || this.f19625b != c4766ab.f19625b || this.f19626c != c4766ab.f19626c) {
            return false;
        }
        boolean m3733g = m3733g();
        boolean m3733g2 = c4766ab.m3733g();
        if ((m3733g || m3733g2) && (!m3733g || !m3733g2 || !this.f19627d.equals(c4766ab.f19627d))) {
            return false;
        }
        boolean m3731i = m3731i();
        boolean m3731i2 = c4766ab.m3731i();
        if ((m3731i || m3731i2) && (!m3731i || !m3731i2 || !this.f19628e.equals(c4766ab.f19628e))) {
            return false;
        }
        boolean m3729k = m3729k();
        boolean m3729k2 = c4766ab.m3729k();
        if ((m3729k || m3729k2) && (!m3729k || !m3729k2 || !this.f19629f.equals(c4766ab.f19629f))) {
            return false;
        }
        boolean m3728l = m3728l();
        boolean m3728l2 = c4766ab.m3728l();
        if ((m3728l || m3728l2) && (!m3728l || !m3728l2 || !this.f19630g.m3254a(c4766ab.f19630g))) {
            return false;
        }
        boolean m3726n = m3726n();
        boolean m3726n2 = c4766ab.m3726n();
        return (!m3726n && !m3726n2) || (m3726n && m3726n2 && this.f19631h.m3303a(c4766ab.f19631h));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4766ab c4766ab) {
        int m1278a;
        int m1278a2;
        int m1277a;
        int m1277a2;
        int m1278a3;
        int m1269a;
        int m1269a2;
        int m1278a4;
        if (!getClass().equals(c4766ab.getClass())) {
            return getClass().getName().compareTo(c4766ab.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3743b()).compareTo(Boolean.valueOf(c4766ab.m3743b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3743b() && (m1278a4 = C5366b.m1278a(this.f19624a, c4766ab.f19624a)) != 0) {
            return m1278a4;
        }
        int compareTo2 = Boolean.valueOf(m3737d()).compareTo(Boolean.valueOf(c4766ab.m3737d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3737d() && (m1269a2 = C5366b.m1269a(this.f19625b, c4766ab.f19625b)) != 0) {
            return m1269a2;
        }
        int compareTo3 = Boolean.valueOf(m3735e()).compareTo(Boolean.valueOf(c4766ab.m3735e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3735e() && (m1269a = C5366b.m1269a(this.f19626c, c4766ab.f19626c)) != 0) {
            return m1269a;
        }
        int compareTo4 = Boolean.valueOf(m3733g()).compareTo(Boolean.valueOf(c4766ab.m3733g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3733g() && (m1278a3 = C5366b.m1278a(this.f19627d, c4766ab.f19627d)) != 0) {
            return m1278a3;
        }
        int compareTo5 = Boolean.valueOf(m3731i()).compareTo(Boolean.valueOf(c4766ab.m3731i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3731i() && (m1277a2 = C5366b.m1277a(this.f19628e, c4766ab.f19628e)) != 0) {
            return m1277a2;
        }
        int compareTo6 = Boolean.valueOf(m3729k()).compareTo(Boolean.valueOf(c4766ab.m3729k()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3729k() && (m1277a = C5366b.m1277a(this.f19629f, c4766ab.f19629f)) != 0) {
            return m1277a;
        }
        int compareTo7 = Boolean.valueOf(m3728l()).compareTo(Boolean.valueOf(c4766ab.m3728l()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3728l() && (m1278a2 = C5366b.m1278a(this.f19630g, c4766ab.f19630g)) != 0) {
            return m1278a2;
        }
        int compareTo8 = Boolean.valueOf(m3726n()).compareTo(Boolean.valueOf(c4766ab.m3726n()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3726n() && (m1278a = C5366b.m1278a(this.f19631h, c4766ab.f19631h)) != 0) {
            return m1278a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4766ab m3741b(String str) {
        this.f19629f = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3725o();
        abstractC5373e.mo1250a(f19615j);
        if (this.f19624a != null) {
            abstractC5373e.mo1254a(f19616k);
            abstractC5373e.mo1258a(this.f19624a.m3772a());
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f19617l);
        abstractC5373e.mo1248a(this.f19625b);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1254a(f19618m);
        abstractC5373e.mo1248a(this.f19626c);
        abstractC5373e.mo1247b();
        if (this.f19627d != null) {
            abstractC5373e.mo1254a(f19619n);
            abstractC5373e.mo1255a(this.f19627d);
            abstractC5373e.mo1247b();
        }
        if (this.f19628e != null && m3731i()) {
            abstractC5373e.mo1254a(f19620o);
            abstractC5373e.mo1256a(this.f19628e);
            abstractC5373e.mo1247b();
        }
        if (this.f19629f != null && m3729k()) {
            abstractC5373e.mo1254a(f19621p);
            abstractC5373e.mo1256a(this.f19629f);
            abstractC5373e.mo1247b();
        }
        if (this.f19630g != null) {
            abstractC5373e.mo1254a(f19622q);
            this.f19630g.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19631h != null && m3726n()) {
            abstractC5373e.mo1254a(f19623r);
            this.f19631h.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3740b(boolean z) {
        this.f19632s.set(0, z);
    }

    /* renamed from: b */
    public boolean m3743b() {
        return this.f19624a != null;
    }

    /* renamed from: c */
    public C4766ab m3738c(boolean z) {
        this.f19626c = z;
        m3736d(true);
        return this;
    }

    /* renamed from: c */
    public boolean m3739c() {
        return this.f19625b;
    }

    /* renamed from: d */
    public void m3736d(boolean z) {
        this.f19632s.set(1, z);
    }

    /* renamed from: d */
    public boolean m3737d() {
        return this.f19632s.get(0);
    }

    /* renamed from: e */
    public boolean m3735e() {
        return this.f19632s.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4766ab)) {
            return m3749a((C4766ab) obj);
        }
        return false;
    }

    /* renamed from: f */
    public byte[] m3734f() {
        m3745a(C5366b.m1266c(this.f19627d));
        return this.f19627d.array();
    }

    /* renamed from: g */
    public boolean m3733g() {
        return this.f19627d != null;
    }

    /* renamed from: h */
    public String m3732h() {
        return this.f19628e;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3731i() {
        return this.f19628e != null;
    }

    /* renamed from: j */
    public String m3730j() {
        return this.f19629f;
    }

    /* renamed from: k */
    public boolean m3729k() {
        return this.f19629f != null;
    }

    /* renamed from: l */
    public boolean m3728l() {
        return this.f19630g != null;
    }

    /* renamed from: m */
    public C4823r m3727m() {
        return this.f19631h;
    }

    /* renamed from: n */
    public boolean m3726n() {
        return this.f19631h != null;
    }

    /* renamed from: o */
    public void m3725o() {
        if (this.f19624a == null) {
            throw new C5374f("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f19627d == null) {
            throw new C5374f("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f19630g != null) {
            return;
        }
        throw new C5374f("Required field 'target' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f19624a == null) {
            sb.append("null");
        } else {
            sb.append(this.f19624a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f19625b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f19626c);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f19627d == null) {
            sb.append("null");
        } else {
            C5366b.m1275a(this.f19627d, sb);
        }
        if (m3731i()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f19628e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19628e);
            }
        }
        if (m3729k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19629f == null) {
                sb.append("null");
            } else {
                sb.append(this.f19629f);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f19630g == null) {
            sb.append("null");
        } else {
            sb.append(this.f19630g);
        }
        if (m3726n()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f19631h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19631h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
