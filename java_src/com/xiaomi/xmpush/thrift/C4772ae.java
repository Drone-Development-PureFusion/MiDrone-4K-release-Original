package com.xiaomi.xmpush.thrift;

import com.fimi.soul.utils.p211a.C3628c;
import com.p219mi.live.openlivesdk.C4093a;
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
/* renamed from: com.xiaomi.xmpush.thrift.ae */
/* loaded from: classes2.dex */
public class C4772ae implements Serializable, Cloneable, AbstractC5358a<C4772ae, EnumC4773a> {

    /* renamed from: l */
    public static final Map<EnumC4773a, C5360b> f19670l;

    /* renamed from: m */
    private static final C5378j f19671m = new C5378j("XmPushActionNotification");

    /* renamed from: n */
    private static final C5370b f19672n = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: o */
    private static final C5370b f19673o = new C5370b("target", (byte) 12, 2);

    /* renamed from: p */
    private static final C5370b f19674p = new C5370b("id", (byte) 11, 3);

    /* renamed from: q */
    private static final C5370b f19675q = new C5370b("appId", (byte) 11, 4);

    /* renamed from: r */
    private static final C5370b f19676r = new C5370b("type", (byte) 11, 5);

    /* renamed from: s */
    private static final C5370b f19677s = new C5370b("requireAck", (byte) 2, 6);

    /* renamed from: t */
    private static final C5370b f19678t = new C5370b(C3628c.C3629a.f14771d, (byte) 11, 7);

    /* renamed from: u */
    private static final C5370b f19679u = new C5370b("extra", (byte) 13, 8);

    /* renamed from: v */
    private static final C5370b f19680v = new C5370b("packageName", (byte) 11, 9);

    /* renamed from: w */
    private static final C5370b f19681w = new C5370b("category", (byte) 11, 10);

    /* renamed from: x */
    private static final C5370b f19682x = new C5370b("binaryExtra", (byte) 11, 14);

    /* renamed from: a */
    public String f19683a;

    /* renamed from: b */
    public C4828u f19684b;

    /* renamed from: c */
    public String f19685c;

    /* renamed from: d */
    public String f19686d;

    /* renamed from: e */
    public String f19687e;

    /* renamed from: f */
    public boolean f19688f;

    /* renamed from: g */
    public String f19689g;

    /* renamed from: h */
    public Map<String, String> f19690h;

    /* renamed from: i */
    public String f19691i;

    /* renamed from: j */
    public String f19692j;

    /* renamed from: k */
    public ByteBuffer f19693k;

    /* renamed from: y */
    private BitSet f19694y;

    /* renamed from: com.xiaomi.xmpush.thrift.ae$a */
    /* loaded from: classes2.dex */
    public enum EnumC4773a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        TYPE(5, "type"),
        REQUIRE_ACK(6, "requireAck"),
        PAYLOAD(7, C3628c.C3629a.f14771d),
        EXTRA(8, "extra"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category"),
        BINARY_EXTRA(14, "binaryExtra");
        

        /* renamed from: l */
        private static final Map<String, EnumC4773a> f19706l = new HashMap();

        /* renamed from: m */
        private final short f19708m;

        /* renamed from: n */
        private final String f19709n;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4773a.class).iterator();
            while (it2.hasNext()) {
                EnumC4773a enumC4773a = (EnumC4773a) it2.next();
                f19706l.put(enumC4773a.m3681a(), enumC4773a);
            }
        }

        EnumC4773a(short s, String str) {
            this.f19708m = s;
            this.f19709n = str;
        }

        /* renamed from: a */
        public String m3681a() {
            return this.f19709n;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4773a.class);
        enumMap.put((EnumMap) EnumC4773a.DEBUG, (EnumC4773a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4773a.TARGET, (EnumC4773a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4773a.ID, (EnumC4773a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4773a.APP_ID, (EnumC4773a) new C5360b("appId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4773a.TYPE, (EnumC4773a) new C5360b("type", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4773a.REQUIRE_ACK, (EnumC4773a) new C5360b("requireAck", (byte) 1, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4773a.PAYLOAD, (EnumC4773a) new C5360b(C3628c.C3629a.f14771d, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4773a.EXTRA, (EnumC4773a) new C5360b("extra", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4773a.PACKAGE_NAME, (EnumC4773a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4773a.CATEGORY, (EnumC4773a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4773a.BINARY_EXTRA, (EnumC4773a) new C5360b("binaryExtra", (byte) 2, new C5361c((byte) 11)));
        f19670l = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4772ae.class, f19670l);
    }

    public C4772ae() {
        this.f19694y = new BitSet(1);
        this.f19688f = true;
    }

    public C4772ae(String str, boolean z) {
        this();
        this.f19685c = str;
        this.f19688f = z;
        m3697b(true);
    }

    /* renamed from: a */
    public C4772ae m3706a(String str) {
        this.f19685c = str;
        return this;
    }

    /* renamed from: a */
    public C4772ae m3704a(ByteBuffer byteBuffer) {
        this.f19693k = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public C4772ae m3703a(Map<String, String> map) {
        this.f19690h = map;
        return this;
    }

    /* renamed from: a */
    public C4772ae m3702a(boolean z) {
        this.f19688f = z;
        m3697b(true);
        return this;
    }

    /* renamed from: a */
    public C4772ae m3701a(byte[] bArr) {
        m3704a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public void m3705a(String str, String str2) {
        if (this.f19690h == null) {
            this.f19690h = new HashMap();
        }
        this.f19690h.put(str, str2);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3690g()) {
                    throw new C5374f("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m3682o();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f19683a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f19684b = new C4828u();
                        this.f19684b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f19685c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f19686d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f19687e = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 2) {
                        this.f19688f = abstractC5373e.mo1235q();
                        m3697b(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 11) {
                        this.f19689g = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k = abstractC5373e.mo1226k();
                        this.f19690h = new HashMap(mo1226k.f22443c * 2);
                        for (int i = 0; i < mo1226k.f22443c; i++) {
                            this.f19690h.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b == 11) {
                        this.f19691i = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 11) {
                        this.f19692j = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                case 12:
                case 13:
                default:
                    C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                    break;
                case 14:
                    if (mo1240i.f22437b == 11) {
                        this.f19693k = abstractC5373e.mo1222x();
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
    public boolean m3708a() {
        return this.f19683a != null;
    }

    /* renamed from: a */
    public boolean m3707a(C4772ae c4772ae) {
        if (c4772ae == null) {
            return false;
        }
        boolean m3708a = m3708a();
        boolean m3708a2 = c4772ae.m3708a();
        if ((m3708a || m3708a2) && (!m3708a || !m3708a2 || !this.f19683a.equals(c4772ae.f19683a))) {
            return false;
        }
        boolean m3700b = m3700b();
        boolean m3700b2 = c4772ae.m3700b();
        if ((m3700b || m3700b2) && (!m3700b || !m3700b2 || !this.f19684b.m3254a(c4772ae.f19684b))) {
            return false;
        }
        boolean m3694d = m3694d();
        boolean m3694d2 = c4772ae.m3694d();
        if ((m3694d || m3694d2) && (!m3694d || !m3694d2 || !this.f19685c.equals(c4772ae.f19685c))) {
            return false;
        }
        boolean m3692e = m3692e();
        boolean m3692e2 = c4772ae.m3692e();
        if ((m3692e || m3692e2) && (!m3692e || !m3692e2 || !this.f19686d.equals(c4772ae.f19686d))) {
            return false;
        }
        boolean m3691f = m3691f();
        boolean m3691f2 = c4772ae.m3691f();
        if (((m3691f || m3691f2) && (!m3691f || !m3691f2 || !this.f19687e.equals(c4772ae.f19687e))) || this.f19688f != c4772ae.f19688f) {
            return false;
        }
        boolean m3689h = m3689h();
        boolean m3689h2 = c4772ae.m3689h();
        if ((m3689h || m3689h2) && (!m3689h || !m3689h2 || !this.f19689g.equals(c4772ae.f19689g))) {
            return false;
        }
        boolean m3687j = m3687j();
        boolean m3687j2 = c4772ae.m3687j();
        if ((m3687j || m3687j2) && (!m3687j || !m3687j2 || !this.f19690h.equals(c4772ae.f19690h))) {
            return false;
        }
        boolean m3686k = m3686k();
        boolean m3686k2 = c4772ae.m3686k();
        if ((m3686k || m3686k2) && (!m3686k || !m3686k2 || !this.f19691i.equals(c4772ae.f19691i))) {
            return false;
        }
        boolean m3685l = m3685l();
        boolean m3685l2 = c4772ae.m3685l();
        if ((m3685l || m3685l2) && (!m3685l || !m3685l2 || !this.f19692j.equals(c4772ae.f19692j))) {
            return false;
        }
        boolean m3683n = m3683n();
        boolean m3683n2 = c4772ae.m3683n();
        return (!m3683n && !m3683n2) || (m3683n && m3683n2 && this.f19693k.equals(c4772ae.f19693k));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4772ae c4772ae) {
        int m1278a;
        int m1277a;
        int m1277a2;
        int m1272a;
        int m1277a3;
        int m1269a;
        int m1277a4;
        int m1277a5;
        int m1277a6;
        int m1278a2;
        int m1277a7;
        if (!getClass().equals(c4772ae.getClass())) {
            return getClass().getName().compareTo(c4772ae.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3708a()).compareTo(Boolean.valueOf(c4772ae.m3708a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3708a() && (m1277a7 = C5366b.m1277a(this.f19683a, c4772ae.f19683a)) != 0) {
            return m1277a7;
        }
        int compareTo2 = Boolean.valueOf(m3700b()).compareTo(Boolean.valueOf(c4772ae.m3700b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3700b() && (m1278a2 = C5366b.m1278a(this.f19684b, c4772ae.f19684b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3694d()).compareTo(Boolean.valueOf(c4772ae.m3694d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3694d() && (m1277a6 = C5366b.m1277a(this.f19685c, c4772ae.f19685c)) != 0) {
            return m1277a6;
        }
        int compareTo4 = Boolean.valueOf(m3692e()).compareTo(Boolean.valueOf(c4772ae.m3692e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3692e() && (m1277a5 = C5366b.m1277a(this.f19686d, c4772ae.f19686d)) != 0) {
            return m1277a5;
        }
        int compareTo5 = Boolean.valueOf(m3691f()).compareTo(Boolean.valueOf(c4772ae.m3691f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3691f() && (m1277a4 = C5366b.m1277a(this.f19687e, c4772ae.f19687e)) != 0) {
            return m1277a4;
        }
        int compareTo6 = Boolean.valueOf(m3690g()).compareTo(Boolean.valueOf(c4772ae.m3690g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3690g() && (m1269a = C5366b.m1269a(this.f19688f, c4772ae.f19688f)) != 0) {
            return m1269a;
        }
        int compareTo7 = Boolean.valueOf(m3689h()).compareTo(Boolean.valueOf(c4772ae.m3689h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3689h() && (m1277a3 = C5366b.m1277a(this.f19689g, c4772ae.f19689g)) != 0) {
            return m1277a3;
        }
        int compareTo8 = Boolean.valueOf(m3687j()).compareTo(Boolean.valueOf(c4772ae.m3687j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3687j() && (m1272a = C5366b.m1272a(this.f19690h, c4772ae.f19690h)) != 0) {
            return m1272a;
        }
        int compareTo9 = Boolean.valueOf(m3686k()).compareTo(Boolean.valueOf(c4772ae.m3686k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3686k() && (m1277a2 = C5366b.m1277a(this.f19691i, c4772ae.f19691i)) != 0) {
            return m1277a2;
        }
        int compareTo10 = Boolean.valueOf(m3685l()).compareTo(Boolean.valueOf(c4772ae.m3685l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3685l() && (m1277a = C5366b.m1277a(this.f19692j, c4772ae.f19692j)) != 0) {
            return m1277a;
        }
        int compareTo11 = Boolean.valueOf(m3683n()).compareTo(Boolean.valueOf(c4772ae.m3683n()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3683n() && (m1278a = C5366b.m1278a(this.f19693k, c4772ae.f19693k)) != 0) {
            return m1278a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4772ae m3698b(String str) {
        this.f19686d = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3682o();
        abstractC5373e.mo1250a(f19671m);
        if (this.f19683a != null && m3708a()) {
            abstractC5373e.mo1254a(f19672n);
            abstractC5373e.mo1256a(this.f19683a);
            abstractC5373e.mo1247b();
        }
        if (this.f19684b != null && m3700b()) {
            abstractC5373e.mo1254a(f19673o);
            this.f19684b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19685c != null) {
            abstractC5373e.mo1254a(f19674p);
            abstractC5373e.mo1256a(this.f19685c);
            abstractC5373e.mo1247b();
        }
        if (this.f19686d != null && m3692e()) {
            abstractC5373e.mo1254a(f19675q);
            abstractC5373e.mo1256a(this.f19686d);
            abstractC5373e.mo1247b();
        }
        if (this.f19687e != null && m3691f()) {
            abstractC5373e.mo1254a(f19676r);
            abstractC5373e.mo1256a(this.f19687e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f19677s);
        abstractC5373e.mo1248a(this.f19688f);
        abstractC5373e.mo1247b();
        if (this.f19689g != null && m3689h()) {
            abstractC5373e.mo1254a(f19678t);
            abstractC5373e.mo1256a(this.f19689g);
            abstractC5373e.mo1247b();
        }
        if (this.f19690h != null && m3687j()) {
            abstractC5373e.mo1254a(f19679u);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f19690h.size()));
            for (Map.Entry<String, String> entry : this.f19690h.entrySet()) {
                abstractC5373e.mo1256a(entry.getKey());
                abstractC5373e.mo1256a(entry.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        if (this.f19691i != null && m3686k()) {
            abstractC5373e.mo1254a(f19680v);
            abstractC5373e.mo1256a(this.f19691i);
            abstractC5373e.mo1247b();
        }
        if (this.f19692j != null && m3685l()) {
            abstractC5373e.mo1254a(f19681w);
            abstractC5373e.mo1256a(this.f19692j);
            abstractC5373e.mo1247b();
        }
        if (this.f19693k != null && m3683n()) {
            abstractC5373e.mo1254a(f19682x);
            abstractC5373e.mo1255a(this.f19693k);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3697b(boolean z) {
        this.f19694y.set(0, z);
    }

    /* renamed from: b */
    public boolean m3700b() {
        return this.f19684b != null;
    }

    /* renamed from: c */
    public C4772ae m3695c(String str) {
        this.f19687e = str;
        return this;
    }

    /* renamed from: c */
    public String m3696c() {
        return this.f19685c;
    }

    /* renamed from: d */
    public C4772ae m3693d(String str) {
        this.f19691i = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3694d() {
        return this.f19685c != null;
    }

    /* renamed from: e */
    public boolean m3692e() {
        return this.f19686d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4772ae)) {
            return m3707a((C4772ae) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3691f() {
        return this.f19687e != null;
    }

    /* renamed from: g */
    public boolean m3690g() {
        return this.f19694y.get(0);
    }

    /* renamed from: h */
    public boolean m3689h() {
        return this.f19689g != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public Map<String, String> m3688i() {
        return this.f19690h;
    }

    /* renamed from: j */
    public boolean m3687j() {
        return this.f19690h != null;
    }

    /* renamed from: k */
    public boolean m3686k() {
        return this.f19691i != null;
    }

    /* renamed from: l */
    public boolean m3685l() {
        return this.f19692j != null;
    }

    /* renamed from: m */
    public byte[] m3684m() {
        m3704a(C5366b.m1266c(this.f19693k));
        return this.f19693k.array();
    }

    /* renamed from: n */
    public boolean m3683n() {
        return this.f19693k != null;
    }

    /* renamed from: o */
    public void m3682o() {
        if (this.f19685c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m3708a()) {
            sb.append("debug:");
            if (this.f19683a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19683a);
            }
            z2 = false;
        }
        if (m3700b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19684b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19684b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19685c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19685c);
        }
        if (m3692e()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f19686d == null) {
                sb.append("null");
            } else {
                sb.append(this.f19686d);
            }
        }
        if (m3691f()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f19687e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19687e);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f19688f);
        if (m3689h()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f19689g == null) {
                sb.append("null");
            } else {
                sb.append(this.f19689g);
            }
        }
        if (m3687j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f19690h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19690h);
            }
        }
        if (m3686k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19691i == null) {
                sb.append("null");
            } else {
                sb.append(this.f19691i);
            }
        }
        if (m3685l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f19692j == null) {
                sb.append("null");
            } else {
                sb.append(this.f19692j);
            }
        }
        if (m3683n()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f19693k == null) {
                sb.append("null");
            } else {
                C5366b.m1275a(this.f19693k, sb);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
