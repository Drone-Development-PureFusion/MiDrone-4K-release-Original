package com.xiaomi.xmpush.thrift;

import com.p219mi.live.openlivesdk.C4093a;
import com.tencent.p227mm.sdk.message.RMsgInfoDB;
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
/* renamed from: com.xiaomi.xmpush.thrift.aj */
/* loaded from: classes2.dex */
public class C4782aj implements Serializable, Cloneable, AbstractC5358a<C4782aj, EnumC4783a> {

    /* renamed from: m */
    public static final Map<EnumC4783a, C5360b> f19878m;

    /* renamed from: n */
    private static final C5378j f19879n = new C5378j("XmPushActionSendMessage");

    /* renamed from: o */
    private static final C5370b f19880o = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: p */
    private static final C5370b f19881p = new C5370b("target", (byte) 12, 2);

    /* renamed from: q */
    private static final C5370b f19882q = new C5370b("id", (byte) 11, 3);

    /* renamed from: r */
    private static final C5370b f19883r = new C5370b("appId", (byte) 11, 4);

    /* renamed from: s */
    private static final C5370b f19884s = new C5370b("packageName", (byte) 11, 5);

    /* renamed from: t */
    private static final C5370b f19885t = new C5370b("topic", (byte) 11, 6);

    /* renamed from: u */
    private static final C5370b f19886u = new C5370b("aliasName", (byte) 11, 7);

    /* renamed from: v */
    private static final C5370b f19887v = new C5370b(RMsgInfoDB.TABLE, (byte) 12, 8);

    /* renamed from: w */
    private static final C5370b f19888w = new C5370b("needAck", (byte) 2, 9);

    /* renamed from: x */
    private static final C5370b f19889x = new C5370b("params", (byte) 13, 10);

    /* renamed from: y */
    private static final C5370b f19890y = new C5370b("category", (byte) 11, 11);

    /* renamed from: z */
    private static final C5370b f19891z = new C5370b("userAccount", (byte) 11, 12);

    /* renamed from: a */
    public String f19893a;

    /* renamed from: b */
    public C4828u f19894b;

    /* renamed from: c */
    public String f19895c;

    /* renamed from: d */
    public String f19896d;

    /* renamed from: e */
    public String f19897e;

    /* renamed from: f */
    public String f19898f;

    /* renamed from: g */
    public String f19899g;

    /* renamed from: h */
    public C4821q f19900h;

    /* renamed from: j */
    public Map<String, String> f19902j;

    /* renamed from: k */
    public String f19903k;

    /* renamed from: l */
    public String f19904l;

    /* renamed from: A */
    private BitSet f19892A = new BitSet(1);

    /* renamed from: i */
    public boolean f19901i = true;

    /* renamed from: com.xiaomi.xmpush.thrift.aj$a */
    /* loaded from: classes2.dex */
    public enum EnumC4783a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        PACKAGE_NAME(5, "packageName"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        MESSAGE(8, RMsgInfoDB.TABLE),
        NEED_ACK(9, "needAck"),
        PARAMS(10, "params"),
        CATEGORY(11, "category"),
        USER_ACCOUNT(12, "userAccount");
        

        /* renamed from: m */
        private static final Map<String, EnumC4783a> f19917m = new HashMap();

        /* renamed from: n */
        private final short f19919n;

        /* renamed from: o */
        private final String f19920o;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4783a.class).iterator();
            while (it2.hasNext()) {
                EnumC4783a enumC4783a = (EnumC4783a) it2.next();
                f19917m.put(enumC4783a.m3571a(), enumC4783a);
            }
        }

        EnumC4783a(short s, String str) {
            this.f19919n = s;
            this.f19920o = str;
        }

        /* renamed from: a */
        public String m3571a() {
            return this.f19920o;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4783a.class);
        enumMap.put((EnumMap) EnumC4783a.DEBUG, (EnumC4783a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4783a.TARGET, (EnumC4783a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4783a.ID, (EnumC4783a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4783a.APP_ID, (EnumC4783a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4783a.PACKAGE_NAME, (EnumC4783a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4783a.TOPIC, (EnumC4783a) new C5360b("topic", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4783a.ALIAS_NAME, (EnumC4783a) new C5360b("aliasName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4783a.MESSAGE, (EnumC4783a) new C5360b(RMsgInfoDB.TABLE, (byte) 2, new C5365g((byte) 12, C4821q.class)));
        enumMap.put((EnumMap) EnumC4783a.NEED_ACK, (EnumC4783a) new C5360b("needAck", (byte) 2, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4783a.PARAMS, (EnumC4783a) new C5360b("params", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4783a.CATEGORY, (EnumC4783a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4783a.USER_ACCOUNT, (EnumC4783a) new C5360b("userAccount", (byte) 2, new C5361c((byte) 11)));
        f19878m = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4782aj.class, f19878m);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3572t();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f19893a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f19894b = new C4828u();
                        this.f19894b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f19895c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f19896d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f19897e = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 11) {
                        this.f19898f = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 11) {
                        this.f19899g = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b == 12) {
                        this.f19900h = new C4821q();
                        this.f19900h.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b == 2) {
                        this.f19901i = abstractC5373e.mo1235q();
                        m3592a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k = abstractC5373e.mo1226k();
                        this.f19902j = new HashMap(mo1226k.f22443c * 2);
                        for (int i = 0; i < mo1226k.f22443c; i++) {
                            this.f19902j.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                    if (mo1240i.f22437b == 11) {
                        this.f19903k = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 12:
                    if (mo1240i.f22437b == 11) {
                        this.f19904l = abstractC5373e.mo1223w();
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
    public void m3592a(boolean z) {
        this.f19892A.set(0, z);
    }

    /* renamed from: a */
    public boolean m3594a() {
        return this.f19893a != null;
    }

    /* renamed from: a */
    public boolean m3593a(C4782aj c4782aj) {
        if (c4782aj == null) {
            return false;
        }
        boolean m3594a = m3594a();
        boolean m3594a2 = c4782aj.m3594a();
        if ((m3594a || m3594a2) && (!m3594a || !m3594a2 || !this.f19893a.equals(c4782aj.f19893a))) {
            return false;
        }
        boolean m3591b = m3591b();
        boolean m3591b2 = c4782aj.m3591b();
        if ((m3591b || m3591b2) && (!m3591b || !m3591b2 || !this.f19894b.m3254a(c4782aj.f19894b))) {
            return false;
        }
        boolean m3588d = m3588d();
        boolean m3588d2 = c4782aj.m3588d();
        if ((m3588d || m3588d2) && (!m3588d || !m3588d2 || !this.f19895c.equals(c4782aj.f19895c))) {
            return false;
        }
        boolean m3586f = m3586f();
        boolean m3586f2 = c4782aj.m3586f();
        if ((m3586f || m3586f2) && (!m3586f || !m3586f2 || !this.f19896d.equals(c4782aj.f19896d))) {
            return false;
        }
        boolean m3585g = m3585g();
        boolean m3585g2 = c4782aj.m3585g();
        if ((m3585g || m3585g2) && (!m3585g || !m3585g2 || !this.f19897e.equals(c4782aj.f19897e))) {
            return false;
        }
        boolean m3583i = m3583i();
        boolean m3583i2 = c4782aj.m3583i();
        if ((m3583i || m3583i2) && (!m3583i || !m3583i2 || !this.f19898f.equals(c4782aj.f19898f))) {
            return false;
        }
        boolean m3581k = m3581k();
        boolean m3581k2 = c4782aj.m3581k();
        if ((m3581k || m3581k2) && (!m3581k || !m3581k2 || !this.f19899g.equals(c4782aj.f19899g))) {
            return false;
        }
        boolean m3579m = m3579m();
        boolean m3579m2 = c4782aj.m3579m();
        if ((m3579m || m3579m2) && (!m3579m || !m3579m2 || !this.f19900h.m3322a(c4782aj.f19900h))) {
            return false;
        }
        boolean m3578n = m3578n();
        boolean m3578n2 = c4782aj.m3578n();
        if ((m3578n || m3578n2) && (!m3578n || !m3578n2 || this.f19901i != c4782aj.f19901i)) {
            return false;
        }
        boolean m3577o = m3577o();
        boolean m3577o2 = c4782aj.m3577o();
        if ((m3577o || m3577o2) && (!m3577o || !m3577o2 || !this.f19902j.equals(c4782aj.f19902j))) {
            return false;
        }
        boolean m3575q = m3575q();
        boolean m3575q2 = c4782aj.m3575q();
        if ((m3575q || m3575q2) && (!m3575q || !m3575q2 || !this.f19903k.equals(c4782aj.f19903k))) {
            return false;
        }
        boolean m3573s = m3573s();
        boolean m3573s2 = c4782aj.m3573s();
        return (!m3573s && !m3573s2) || (m3573s && m3573s2 && this.f19904l.equals(c4782aj.f19904l));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4782aj c4782aj) {
        int m1277a;
        int m1277a2;
        int m1272a;
        int m1269a;
        int m1278a;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1277a6;
        int m1277a7;
        int m1278a2;
        int m1277a8;
        if (!getClass().equals(c4782aj.getClass())) {
            return getClass().getName().compareTo(c4782aj.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3594a()).compareTo(Boolean.valueOf(c4782aj.m3594a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3594a() && (m1277a8 = C5366b.m1277a(this.f19893a, c4782aj.f19893a)) != 0) {
            return m1277a8;
        }
        int compareTo2 = Boolean.valueOf(m3591b()).compareTo(Boolean.valueOf(c4782aj.m3591b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3591b() && (m1278a2 = C5366b.m1278a(this.f19894b, c4782aj.f19894b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3588d()).compareTo(Boolean.valueOf(c4782aj.m3588d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3588d() && (m1277a7 = C5366b.m1277a(this.f19895c, c4782aj.f19895c)) != 0) {
            return m1277a7;
        }
        int compareTo4 = Boolean.valueOf(m3586f()).compareTo(Boolean.valueOf(c4782aj.m3586f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3586f() && (m1277a6 = C5366b.m1277a(this.f19896d, c4782aj.f19896d)) != 0) {
            return m1277a6;
        }
        int compareTo5 = Boolean.valueOf(m3585g()).compareTo(Boolean.valueOf(c4782aj.m3585g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3585g() && (m1277a5 = C5366b.m1277a(this.f19897e, c4782aj.f19897e)) != 0) {
            return m1277a5;
        }
        int compareTo6 = Boolean.valueOf(m3583i()).compareTo(Boolean.valueOf(c4782aj.m3583i()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3583i() && (m1277a4 = C5366b.m1277a(this.f19898f, c4782aj.f19898f)) != 0) {
            return m1277a4;
        }
        int compareTo7 = Boolean.valueOf(m3581k()).compareTo(Boolean.valueOf(c4782aj.m3581k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3581k() && (m1277a3 = C5366b.m1277a(this.f19899g, c4782aj.f19899g)) != 0) {
            return m1277a3;
        }
        int compareTo8 = Boolean.valueOf(m3579m()).compareTo(Boolean.valueOf(c4782aj.m3579m()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3579m() && (m1278a = C5366b.m1278a(this.f19900h, c4782aj.f19900h)) != 0) {
            return m1278a;
        }
        int compareTo9 = Boolean.valueOf(m3578n()).compareTo(Boolean.valueOf(c4782aj.m3578n()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3578n() && (m1269a = C5366b.m1269a(this.f19901i, c4782aj.f19901i)) != 0) {
            return m1269a;
        }
        int compareTo10 = Boolean.valueOf(m3577o()).compareTo(Boolean.valueOf(c4782aj.m3577o()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3577o() && (m1272a = C5366b.m1272a(this.f19902j, c4782aj.f19902j)) != 0) {
            return m1272a;
        }
        int compareTo11 = Boolean.valueOf(m3575q()).compareTo(Boolean.valueOf(c4782aj.m3575q()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3575q() && (m1277a2 = C5366b.m1277a(this.f19903k, c4782aj.f19903k)) != 0) {
            return m1277a2;
        }
        int compareTo12 = Boolean.valueOf(m3573s()).compareTo(Boolean.valueOf(c4782aj.m3573s()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m3573s() && (m1277a = C5366b.m1277a(this.f19904l, c4782aj.f19904l)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3572t();
        abstractC5373e.mo1250a(f19879n);
        if (this.f19893a != null && m3594a()) {
            abstractC5373e.mo1254a(f19880o);
            abstractC5373e.mo1256a(this.f19893a);
            abstractC5373e.mo1247b();
        }
        if (this.f19894b != null && m3591b()) {
            abstractC5373e.mo1254a(f19881p);
            this.f19894b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19895c != null) {
            abstractC5373e.mo1254a(f19882q);
            abstractC5373e.mo1256a(this.f19895c);
            abstractC5373e.mo1247b();
        }
        if (this.f19896d != null) {
            abstractC5373e.mo1254a(f19883r);
            abstractC5373e.mo1256a(this.f19896d);
            abstractC5373e.mo1247b();
        }
        if (this.f19897e != null && m3585g()) {
            abstractC5373e.mo1254a(f19884s);
            abstractC5373e.mo1256a(this.f19897e);
            abstractC5373e.mo1247b();
        }
        if (this.f19898f != null && m3583i()) {
            abstractC5373e.mo1254a(f19885t);
            abstractC5373e.mo1256a(this.f19898f);
            abstractC5373e.mo1247b();
        }
        if (this.f19899g != null && m3581k()) {
            abstractC5373e.mo1254a(f19886u);
            abstractC5373e.mo1256a(this.f19899g);
            abstractC5373e.mo1247b();
        }
        if (this.f19900h != null && m3579m()) {
            abstractC5373e.mo1254a(f19887v);
            this.f19900h.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (m3578n()) {
            abstractC5373e.mo1254a(f19888w);
            abstractC5373e.mo1248a(this.f19901i);
            abstractC5373e.mo1247b();
        }
        if (this.f19902j != null && m3577o()) {
            abstractC5373e.mo1254a(f19889x);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f19902j.size()));
            for (Map.Entry<String, String> entry : this.f19902j.entrySet()) {
                abstractC5373e.mo1256a(entry.getKey());
                abstractC5373e.mo1256a(entry.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        if (this.f19903k != null && m3575q()) {
            abstractC5373e.mo1254a(f19890y);
            abstractC5373e.mo1256a(this.f19903k);
            abstractC5373e.mo1247b();
        }
        if (this.f19904l != null && m3573s()) {
            abstractC5373e.mo1254a(f19891z);
            abstractC5373e.mo1256a(this.f19904l);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3591b() {
        return this.f19894b != null;
    }

    /* renamed from: c */
    public String m3589c() {
        return this.f19895c;
    }

    /* renamed from: d */
    public boolean m3588d() {
        return this.f19895c != null;
    }

    /* renamed from: e */
    public String m3587e() {
        return this.f19896d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4782aj)) {
            return m3593a((C4782aj) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3586f() {
        return this.f19896d != null;
    }

    /* renamed from: g */
    public boolean m3585g() {
        return this.f19897e != null;
    }

    /* renamed from: h */
    public String m3584h() {
        return this.f19898f;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3583i() {
        return this.f19898f != null;
    }

    /* renamed from: j */
    public String m3582j() {
        return this.f19899g;
    }

    /* renamed from: k */
    public boolean m3581k() {
        return this.f19899g != null;
    }

    /* renamed from: l */
    public C4821q m3580l() {
        return this.f19900h;
    }

    /* renamed from: m */
    public boolean m3579m() {
        return this.f19900h != null;
    }

    /* renamed from: n */
    public boolean m3578n() {
        return this.f19892A.get(0);
    }

    /* renamed from: o */
    public boolean m3577o() {
        return this.f19902j != null;
    }

    /* renamed from: p */
    public String m3576p() {
        return this.f19903k;
    }

    /* renamed from: q */
    public boolean m3575q() {
        return this.f19903k != null;
    }

    /* renamed from: r */
    public String m3574r() {
        return this.f19904l;
    }

    /* renamed from: s */
    public boolean m3573s() {
        return this.f19904l != null;
    }

    /* renamed from: t */
    public void m3572t() {
        if (this.f19895c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f19896d != null) {
            return;
        }
        throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m3594a()) {
            sb.append("debug:");
            if (this.f19893a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19893a);
            }
            z2 = false;
        }
        if (m3591b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19894b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19894b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19895c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19895c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f19896d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19896d);
        }
        if (m3585g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19897e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19897e);
            }
        }
        if (m3583i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f19898f == null) {
                sb.append("null");
            } else {
                sb.append(this.f19898f);
            }
        }
        if (m3581k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f19899g == null) {
                sb.append("null");
            } else {
                sb.append(this.f19899g);
            }
        }
        if (m3579m()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f19900h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19900h);
            }
        }
        if (m3578n()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f19901i);
        }
        if (m3577o()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f19902j == null) {
                sb.append("null");
            } else {
                sb.append(this.f19902j);
            }
        }
        if (m3575q()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f19903k == null) {
                sb.append("null");
            } else {
                sb.append(this.f19903k);
            }
        }
        if (m3573s()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f19904l == null) {
                sb.append("null");
            } else {
                sb.append(this.f19904l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
