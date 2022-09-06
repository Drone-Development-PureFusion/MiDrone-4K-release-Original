package com.xiaomi.xmpush.thrift;

import com.fimi.soul.utils.p211a.C3628c;
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
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5372d;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.r */
/* loaded from: classes2.dex */
public class C4823r implements Serializable, Cloneable, AbstractC5358a<C4823r, EnumC4824a> {

    /* renamed from: m */
    public static final Map<EnumC4824a, C5360b> f20436m;

    /* renamed from: n */
    private static final C5378j f20437n = new C5378j("PushMetaInfo");

    /* renamed from: o */
    private static final C5370b f20438o = new C5370b("id", (byte) 11, 1);

    /* renamed from: p */
    private static final C5370b f20439p = new C5370b("messageTs", (byte) 10, 2);

    /* renamed from: q */
    private static final C5370b f20440q = new C5370b("topic", (byte) 11, 3);

    /* renamed from: r */
    private static final C5370b f20441r = new C5370b("title", (byte) 11, 4);

    /* renamed from: s */
    private static final C5370b f20442s = new C5370b("description", (byte) 11, 5);

    /* renamed from: t */
    private static final C5370b f20443t = new C5370b("notifyType", (byte) 8, 6);

    /* renamed from: u */
    private static final C5370b f20444u = new C5370b("url", (byte) 11, 7);

    /* renamed from: v */
    private static final C5370b f20445v = new C5370b(C3628c.C3629a.f14773f, (byte) 8, 8);

    /* renamed from: w */
    private static final C5370b f20446w = new C5370b("notifyId", (byte) 8, 9);

    /* renamed from: x */
    private static final C5370b f20447x = new C5370b("extra", (byte) 13, 10);

    /* renamed from: y */
    private static final C5370b f20448y = new C5370b("internal", (byte) 13, 11);

    /* renamed from: z */
    private static final C5370b f20449z = new C5370b("ignoreRegInfo", (byte) 2, 12);

    /* renamed from: A */
    private BitSet f20450A;

    /* renamed from: a */
    public String f20451a;

    /* renamed from: b */
    public long f20452b;

    /* renamed from: c */
    public String f20453c;

    /* renamed from: d */
    public String f20454d;

    /* renamed from: e */
    public String f20455e;

    /* renamed from: f */
    public int f20456f;

    /* renamed from: g */
    public String f20457g;

    /* renamed from: h */
    public int f20458h;

    /* renamed from: i */
    public int f20459i;

    /* renamed from: j */
    public Map<String, String> f20460j;

    /* renamed from: k */
    public Map<String, String> f20461k;

    /* renamed from: l */
    public boolean f20462l;

    /* renamed from: com.xiaomi.xmpush.thrift.r$a */
    /* loaded from: classes2.dex */
    public enum EnumC4824a {
        ID(1, "id"),
        MESSAGE_TS(2, "messageTs"),
        TOPIC(3, "topic"),
        TITLE(4, "title"),
        DESCRIPTION(5, "description"),
        NOTIFY_TYPE(6, "notifyType"),
        URL(7, "url"),
        PASS_THROUGH(8, C3628c.C3629a.f14773f),
        NOTIFY_ID(9, "notifyId"),
        EXTRA(10, "extra"),
        INTERNAL(11, "internal"),
        IGNORE_REG_INFO(12, "ignoreRegInfo");
        

        /* renamed from: m */
        private static final Map<String, EnumC4824a> f20475m = new HashMap();

        /* renamed from: n */
        private final short f20477n;

        /* renamed from: o */
        private final String f20478o;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4824a.class).iterator();
            while (it2.hasNext()) {
                EnumC4824a enumC4824a = (EnumC4824a) it2.next();
                f20475m.put(enumC4824a.m3265a(), enumC4824a);
            }
        }

        EnumC4824a(short s, String str) {
            this.f20477n = s;
            this.f20478o = str;
        }

        /* renamed from: a */
        public String m3265a() {
            return this.f20478o;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4824a.class);
        enumMap.put((EnumMap) EnumC4824a.ID, (EnumC4824a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4824a.MESSAGE_TS, (EnumC4824a) new C5360b("messageTs", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4824a.TOPIC, (EnumC4824a) new C5360b("topic", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4824a.TITLE, (EnumC4824a) new C5360b("title", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4824a.DESCRIPTION, (EnumC4824a) new C5360b("description", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4824a.NOTIFY_TYPE, (EnumC4824a) new C5360b("notifyType", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4824a.URL, (EnumC4824a) new C5360b("url", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4824a.PASS_THROUGH, (EnumC4824a) new C5360b(C3628c.C3629a.f14773f, (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4824a.NOTIFY_ID, (EnumC4824a) new C5360b("notifyId", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4824a.EXTRA, (EnumC4824a) new C5360b("extra", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4824a.INTERNAL, (EnumC4824a) new C5360b("internal", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4824a.IGNORE_REG_INFO, (EnumC4824a) new C5360b("ignoreRegInfo", (byte) 2, new C5361c((byte) 2)));
        f20436m = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4823r.class, f20436m);
    }

    public C4823r() {
        this.f20450A = new BitSet(5);
        this.f20462l = false;
    }

    public C4823r(C4823r c4823r) {
        this.f20450A = new BitSet(5);
        this.f20450A.clear();
        this.f20450A.or(c4823r.f20450A);
        if (c4823r.m3293c()) {
            this.f20451a = c4823r.f20451a;
        }
        this.f20452b = c4823r.f20452b;
        if (c4823r.m3283g()) {
            this.f20453c = c4823r.f20453c;
        }
        if (c4823r.m3281i()) {
            this.f20454d = c4823r.f20454d;
        }
        if (c4823r.m3279k()) {
            this.f20455e = c4823r.f20455e;
        }
        this.f20456f = c4823r.f20456f;
        if (c4823r.m3276n()) {
            this.f20457g = c4823r.f20457g;
        }
        this.f20458h = c4823r.f20458h;
        this.f20459i = c4823r.f20459i;
        if (c4823r.m3270t()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : c4823r.f20460j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f20460j = hashMap;
        }
        if (c4823r.m3269u()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : c4823r.f20461k.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f20461k = hashMap2;
        }
        this.f20462l = c4823r.f20462l;
    }

    /* renamed from: a */
    public C4823r m3305a() {
        return new C4823r(this);
    }

    /* renamed from: a */
    public C4823r m3304a(int i) {
        this.f20456f = i;
        m3294b(true);
        return this;
    }

    /* renamed from: a */
    public C4823r m3302a(String str) {
        this.f20451a = str;
        return this;
    }

    /* renamed from: a */
    public C4823r m3300a(Map<String, String> map) {
        this.f20460j = map;
        return this;
    }

    /* renamed from: a */
    public void m3301a(String str, String str2) {
        if (this.f20460j == null) {
            this.f20460j = new HashMap();
        }
        this.f20460j.put(str, str2);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3286e()) {
                    throw new C5374f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m3266x();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f20451a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 10) {
                        this.f20452b = abstractC5373e.mo1231u();
                        m3299a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f20453c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f20454d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f20455e = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 8) {
                        this.f20456f = abstractC5373e.mo1232t();
                        m3294b(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 11) {
                        this.f20457g = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b == 8) {
                        this.f20458h = abstractC5373e.mo1232t();
                        m3290c(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b == 8) {
                        this.f20459i = abstractC5373e.mo1232t();
                        m3287d(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k = abstractC5373e.mo1226k();
                        this.f20460j = new HashMap(mo1226k.f22443c * 2);
                        for (int i = 0; i < mo1226k.f22443c; i++) {
                            this.f20460j.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k2 = abstractC5373e.mo1226k();
                        this.f20461k = new HashMap(mo1226k2.f22443c * 2);
                        for (int i2 = 0; i2 < mo1226k2.f22443c; i2++) {
                            this.f20461k.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 12:
                    if (mo1240i.f22437b == 2) {
                        this.f20462l = abstractC5373e.mo1235q();
                        m3285e(true);
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
    public void m3299a(boolean z) {
        this.f20450A.set(0, z);
    }

    /* renamed from: a */
    public boolean m3303a(C4823r c4823r) {
        if (c4823r == null) {
            return false;
        }
        boolean m3293c = m3293c();
        boolean m3293c2 = c4823r.m3293c();
        if (((m3293c || m3293c2) && (!m3293c || !m3293c2 || !this.f20451a.equals(c4823r.f20451a))) || this.f20452b != c4823r.f20452b) {
            return false;
        }
        boolean m3283g = m3283g();
        boolean m3283g2 = c4823r.m3283g();
        if ((m3283g || m3283g2) && (!m3283g || !m3283g2 || !this.f20453c.equals(c4823r.f20453c))) {
            return false;
        }
        boolean m3281i = m3281i();
        boolean m3281i2 = c4823r.m3281i();
        if ((m3281i || m3281i2) && (!m3281i || !m3281i2 || !this.f20454d.equals(c4823r.f20454d))) {
            return false;
        }
        boolean m3279k = m3279k();
        boolean m3279k2 = c4823r.m3279k();
        if ((m3279k || m3279k2) && (!m3279k || !m3279k2 || !this.f20455e.equals(c4823r.f20455e))) {
            return false;
        }
        boolean m3277m = m3277m();
        boolean m3277m2 = c4823r.m3277m();
        if ((m3277m || m3277m2) && (!m3277m || !m3277m2 || this.f20456f != c4823r.f20456f)) {
            return false;
        }
        boolean m3276n = m3276n();
        boolean m3276n2 = c4823r.m3276n();
        if ((m3276n || m3276n2) && (!m3276n || !m3276n2 || !this.f20457g.equals(c4823r.f20457g))) {
            return false;
        }
        boolean m3274p = m3274p();
        boolean m3274p2 = c4823r.m3274p();
        if ((m3274p || m3274p2) && (!m3274p || !m3274p2 || this.f20458h != c4823r.f20458h)) {
            return false;
        }
        boolean m3272r = m3272r();
        boolean m3272r2 = c4823r.m3272r();
        if ((m3272r || m3272r2) && (!m3272r || !m3272r2 || this.f20459i != c4823r.f20459i)) {
            return false;
        }
        boolean m3270t = m3270t();
        boolean m3270t2 = c4823r.m3270t();
        if ((m3270t || m3270t2) && (!m3270t || !m3270t2 || !this.f20460j.equals(c4823r.f20460j))) {
            return false;
        }
        boolean m3269u = m3269u();
        boolean m3269u2 = c4823r.m3269u();
        if ((m3269u || m3269u2) && (!m3269u || !m3269u2 || !this.f20461k.equals(c4823r.f20461k))) {
            return false;
        }
        boolean m3267w = m3267w();
        boolean m3267w2 = c4823r.m3267w();
        return (!m3267w && !m3267w2) || (m3267w && m3267w2 && this.f20462l == c4823r.f20462l);
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4823r c4823r) {
        int m1269a;
        int m1272a;
        int m1272a2;
        int m1280a;
        int m1280a2;
        int m1277a;
        int m1280a3;
        int m1277a2;
        int m1277a3;
        int m1277a4;
        int m1279a;
        int m1277a5;
        if (!getClass().equals(c4823r.getClass())) {
            return getClass().getName().compareTo(c4823r.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3293c()).compareTo(Boolean.valueOf(c4823r.m3293c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3293c() && (m1277a5 = C5366b.m1277a(this.f20451a, c4823r.f20451a)) != 0) {
            return m1277a5;
        }
        int compareTo2 = Boolean.valueOf(m3286e()).compareTo(Boolean.valueOf(c4823r.m3286e()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3286e() && (m1279a = C5366b.m1279a(this.f20452b, c4823r.f20452b)) != 0) {
            return m1279a;
        }
        int compareTo3 = Boolean.valueOf(m3283g()).compareTo(Boolean.valueOf(c4823r.m3283g()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3283g() && (m1277a4 = C5366b.m1277a(this.f20453c, c4823r.f20453c)) != 0) {
            return m1277a4;
        }
        int compareTo4 = Boolean.valueOf(m3281i()).compareTo(Boolean.valueOf(c4823r.m3281i()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3281i() && (m1277a3 = C5366b.m1277a(this.f20454d, c4823r.f20454d)) != 0) {
            return m1277a3;
        }
        int compareTo5 = Boolean.valueOf(m3279k()).compareTo(Boolean.valueOf(c4823r.m3279k()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3279k() && (m1277a2 = C5366b.m1277a(this.f20455e, c4823r.f20455e)) != 0) {
            return m1277a2;
        }
        int compareTo6 = Boolean.valueOf(m3277m()).compareTo(Boolean.valueOf(c4823r.m3277m()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3277m() && (m1280a3 = C5366b.m1280a(this.f20456f, c4823r.f20456f)) != 0) {
            return m1280a3;
        }
        int compareTo7 = Boolean.valueOf(m3276n()).compareTo(Boolean.valueOf(c4823r.m3276n()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3276n() && (m1277a = C5366b.m1277a(this.f20457g, c4823r.f20457g)) != 0) {
            return m1277a;
        }
        int compareTo8 = Boolean.valueOf(m3274p()).compareTo(Boolean.valueOf(c4823r.m3274p()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3274p() && (m1280a2 = C5366b.m1280a(this.f20458h, c4823r.f20458h)) != 0) {
            return m1280a2;
        }
        int compareTo9 = Boolean.valueOf(m3272r()).compareTo(Boolean.valueOf(c4823r.m3272r()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3272r() && (m1280a = C5366b.m1280a(this.f20459i, c4823r.f20459i)) != 0) {
            return m1280a;
        }
        int compareTo10 = Boolean.valueOf(m3270t()).compareTo(Boolean.valueOf(c4823r.m3270t()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3270t() && (m1272a2 = C5366b.m1272a(this.f20460j, c4823r.f20460j)) != 0) {
            return m1272a2;
        }
        int compareTo11 = Boolean.valueOf(m3269u()).compareTo(Boolean.valueOf(c4823r.m3269u()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3269u() && (m1272a = C5366b.m1272a(this.f20461k, c4823r.f20461k)) != 0) {
            return m1272a;
        }
        int compareTo12 = Boolean.valueOf(m3267w()).compareTo(Boolean.valueOf(c4823r.m3267w()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m3267w() && (m1269a = C5366b.m1269a(this.f20462l, c4823r.f20462l)) != 0) {
            return m1269a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4823r m3297b(int i) {
        this.f20458h = i;
        m3290c(true);
        return this;
    }

    /* renamed from: b */
    public C4823r m3295b(String str) {
        this.f20453c = str;
        return this;
    }

    /* renamed from: b */
    public String m3298b() {
        return this.f20451a;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3266x();
        abstractC5373e.mo1250a(f20437n);
        if (this.f20451a != null) {
            abstractC5373e.mo1254a(f20438o);
            abstractC5373e.mo1256a(this.f20451a);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f20439p);
        abstractC5373e.mo1257a(this.f20452b);
        abstractC5373e.mo1247b();
        if (this.f20453c != null && m3283g()) {
            abstractC5373e.mo1254a(f20440q);
            abstractC5373e.mo1256a(this.f20453c);
            abstractC5373e.mo1247b();
        }
        if (this.f20454d != null && m3281i()) {
            abstractC5373e.mo1254a(f20441r);
            abstractC5373e.mo1256a(this.f20454d);
            abstractC5373e.mo1247b();
        }
        if (this.f20455e != null && m3279k()) {
            abstractC5373e.mo1254a(f20442s);
            abstractC5373e.mo1256a(this.f20455e);
            abstractC5373e.mo1247b();
        }
        if (m3277m()) {
            abstractC5373e.mo1254a(f20443t);
            abstractC5373e.mo1258a(this.f20456f);
            abstractC5373e.mo1247b();
        }
        if (this.f20457g != null && m3276n()) {
            abstractC5373e.mo1254a(f20444u);
            abstractC5373e.mo1256a(this.f20457g);
            abstractC5373e.mo1247b();
        }
        if (m3274p()) {
            abstractC5373e.mo1254a(f20445v);
            abstractC5373e.mo1258a(this.f20458h);
            abstractC5373e.mo1247b();
        }
        if (m3272r()) {
            abstractC5373e.mo1254a(f20446w);
            abstractC5373e.mo1258a(this.f20459i);
            abstractC5373e.mo1247b();
        }
        if (this.f20460j != null && m3270t()) {
            abstractC5373e.mo1254a(f20447x);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f20460j.size()));
            for (Map.Entry<String, String> entry : this.f20460j.entrySet()) {
                abstractC5373e.mo1256a(entry.getKey());
                abstractC5373e.mo1256a(entry.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        if (this.f20461k != null && m3269u()) {
            abstractC5373e.mo1254a(f20448y);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f20461k.size()));
            for (Map.Entry<String, String> entry2 : this.f20461k.entrySet()) {
                abstractC5373e.mo1256a(entry2.getKey());
                abstractC5373e.mo1256a(entry2.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        if (m3267w()) {
            abstractC5373e.mo1254a(f20449z);
            abstractC5373e.mo1248a(this.f20462l);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3294b(boolean z) {
        this.f20450A.set(1, z);
    }

    /* renamed from: c */
    public C4823r m3292c(int i) {
        this.f20459i = i;
        m3287d(true);
        return this;
    }

    /* renamed from: c */
    public C4823r m3291c(String str) {
        this.f20454d = str;
        return this;
    }

    /* renamed from: c */
    public void m3290c(boolean z) {
        this.f20450A.set(2, z);
    }

    /* renamed from: c */
    public boolean m3293c() {
        return this.f20451a != null;
    }

    /* renamed from: d */
    public long m3289d() {
        return this.f20452b;
    }

    /* renamed from: d */
    public C4823r m3288d(String str) {
        this.f20455e = str;
        return this;
    }

    /* renamed from: d */
    public void m3287d(boolean z) {
        this.f20450A.set(3, z);
    }

    /* renamed from: e */
    public void m3285e(boolean z) {
        this.f20450A.set(4, z);
    }

    /* renamed from: e */
    public boolean m3286e() {
        return this.f20450A.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4823r)) {
            return m3303a((C4823r) obj);
        }
        return false;
    }

    /* renamed from: f */
    public String m3284f() {
        return this.f20453c;
    }

    /* renamed from: g */
    public boolean m3283g() {
        return this.f20453c != null;
    }

    /* renamed from: h */
    public String m3282h() {
        return this.f20454d;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3281i() {
        return this.f20454d != null;
    }

    /* renamed from: j */
    public String m3280j() {
        return this.f20455e;
    }

    /* renamed from: k */
    public boolean m3279k() {
        return this.f20455e != null;
    }

    /* renamed from: l */
    public int m3278l() {
        return this.f20456f;
    }

    /* renamed from: m */
    public boolean m3277m() {
        return this.f20450A.get(1);
    }

    /* renamed from: n */
    public boolean m3276n() {
        return this.f20457g != null;
    }

    /* renamed from: o */
    public int m3275o() {
        return this.f20458h;
    }

    /* renamed from: p */
    public boolean m3274p() {
        return this.f20450A.get(2);
    }

    /* renamed from: q */
    public int m3273q() {
        return this.f20459i;
    }

    /* renamed from: r */
    public boolean m3272r() {
        return this.f20450A.get(3);
    }

    /* renamed from: s */
    public Map<String, String> m3271s() {
        return this.f20460j;
    }

    /* renamed from: t */
    public boolean m3270t() {
        return this.f20460j != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f20451a == null) {
            sb.append("null");
        } else {
            sb.append(this.f20451a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f20452b);
        if (m3283g()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f20453c == null) {
                sb.append("null");
            } else {
                sb.append(this.f20453c);
            }
        }
        if (m3281i()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f20454d == null) {
                sb.append("null");
            } else {
                sb.append(this.f20454d);
            }
        }
        if (m3279k()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f20455e == null) {
                sb.append("null");
            } else {
                sb.append(this.f20455e);
            }
        }
        if (m3277m()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f20456f);
        }
        if (m3276n()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f20457g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20457g);
            }
        }
        if (m3274p()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f20458h);
        }
        if (m3272r()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f20459i);
        }
        if (m3270t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f20460j == null) {
                sb.append("null");
            } else {
                sb.append(this.f20460j);
            }
        }
        if (m3269u()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f20461k == null) {
                sb.append("null");
            } else {
                sb.append(this.f20461k);
            }
        }
        if (m3267w()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f20462l);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public boolean m3269u() {
        return this.f20461k != null;
    }

    /* renamed from: v */
    public boolean m3268v() {
        return this.f20462l;
    }

    /* renamed from: w */
    public boolean m3267w() {
        return this.f20450A.get(4);
    }

    /* renamed from: x */
    public void m3266x() {
        if (this.f20451a == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
