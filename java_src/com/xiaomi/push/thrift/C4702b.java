package com.xiaomi.push.thrift;

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
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.push.thrift.b */
/* loaded from: classes2.dex */
public class C4702b implements Serializable, Cloneable, AbstractC5358a<C4702b, EnumC4703a> {

    /* renamed from: k */
    public static final Map<EnumC4703a, C5360b> f19278k;

    /* renamed from: l */
    private static final C5378j f19279l = new C5378j("StatsEvent");

    /* renamed from: m */
    private static final C5370b f19280m = new C5370b("chid", (byte) 3, 1);

    /* renamed from: n */
    private static final C5370b f19281n = new C5370b("type", (byte) 8, 2);

    /* renamed from: o */
    private static final C5370b f19282o = new C5370b("value", (byte) 8, 3);

    /* renamed from: p */
    private static final C5370b f19283p = new C5370b("connpt", (byte) 11, 4);

    /* renamed from: q */
    private static final C5370b f19284q = new C5370b("host", (byte) 11, 5);

    /* renamed from: r */
    private static final C5370b f19285r = new C5370b("subvalue", (byte) 8, 6);

    /* renamed from: s */
    private static final C5370b f19286s = new C5370b("annotation", (byte) 11, 7);

    /* renamed from: t */
    private static final C5370b f19287t = new C5370b("user", (byte) 11, 8);

    /* renamed from: u */
    private static final C5370b f19288u = new C5370b(C3628c.C3629a.f14776i, (byte) 8, 9);

    /* renamed from: v */
    private static final C5370b f19289v = new C5370b("clientIp", (byte) 8, 10);

    /* renamed from: a */
    public byte f19290a;

    /* renamed from: b */
    public int f19291b;

    /* renamed from: c */
    public int f19292c;

    /* renamed from: d */
    public String f19293d;

    /* renamed from: e */
    public String f19294e;

    /* renamed from: f */
    public int f19295f;

    /* renamed from: g */
    public String f19296g;

    /* renamed from: h */
    public String f19297h;

    /* renamed from: i */
    public int f19298i;

    /* renamed from: j */
    public int f19299j;

    /* renamed from: w */
    private BitSet f19300w = new BitSet(6);

    /* renamed from: com.xiaomi.push.thrift.b$a */
    /* loaded from: classes2.dex */
    public enum EnumC4703a {
        CHID(1, "chid"),
        TYPE(2, "type"),
        VALUE(3, "value"),
        CONNPT(4, "connpt"),
        HOST(5, "host"),
        SUBVALUE(6, "subvalue"),
        ANNOTATION(7, "annotation"),
        USER(8, "user"),
        TIME(9, C3628c.C3629a.f14776i),
        CLIENT_IP(10, "clientIp");
        

        /* renamed from: k */
        private static final Map<String, EnumC4703a> f19311k = new HashMap();

        /* renamed from: l */
        private final short f19313l;

        /* renamed from: m */
        private final String f19314m;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4703a.class).iterator();
            while (it2.hasNext()) {
                EnumC4703a enumC4703a = (EnumC4703a) it2.next();
                f19311k.put(enumC4703a.m4046a(), enumC4703a);
            }
        }

        EnumC4703a(short s, String str) {
            this.f19313l = s;
            this.f19314m = str;
        }

        /* renamed from: a */
        public String m4046a() {
            return this.f19314m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4703a.class);
        enumMap.put((EnumMap) EnumC4703a.CHID, (EnumC4703a) new C5360b("chid", (byte) 1, new C5361c((byte) 3)));
        enumMap.put((EnumMap) EnumC4703a.TYPE, (EnumC4703a) new C5360b("type", (byte) 1, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4703a.VALUE, (EnumC4703a) new C5360b("value", (byte) 1, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4703a.CONNPT, (EnumC4703a) new C5360b("connpt", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4703a.HOST, (EnumC4703a) new C5360b("host", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4703a.SUBVALUE, (EnumC4703a) new C5360b("subvalue", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4703a.ANNOTATION, (EnumC4703a) new C5360b("annotation", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4703a.USER, (EnumC4703a) new C5360b("user", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4703a.TIME, (EnumC4703a) new C5360b(C3628c.C3629a.f14776i, (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4703a.CLIENT_IP, (EnumC4703a) new C5360b("clientIp", (byte) 2, new C5361c((byte) 8)));
        f19278k = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4702b.class, f19278k);
    }

    /* renamed from: a */
    public C4702b m4074a(byte b) {
        this.f19290a = b;
        m4070a(true);
        return this;
    }

    /* renamed from: a */
    public C4702b m4073a(int i) {
        this.f19291b = i;
        m4065b(true);
        return this;
    }

    /* renamed from: a */
    public C4702b m4071a(String str) {
        this.f19293d = str;
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
                if (!m4075a()) {
                    throw new C5374f("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!m4069b()) {
                    throw new C5374f("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (!m4064c()) {
                    throw new C5374f("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
                m4047k();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 3) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19290a = abstractC5373e.mo1234r();
                        m4070a(true);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19291b = abstractC5373e.mo1232t();
                        m4065b(true);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19292c = abstractC5373e.mo1232t();
                        m4061c(true);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19293d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19294e = abstractC5373e.mo1223w();
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19295f = abstractC5373e.mo1232t();
                        m4057d(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19296g = abstractC5373e.mo1223w();
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19297h = abstractC5373e.mo1223w();
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19298i = abstractC5373e.mo1232t();
                        m4054e(true);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f19299j = abstractC5373e.mo1232t();
                        m4052f(true);
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
    public void m4070a(boolean z) {
        this.f19300w.set(0, z);
    }

    /* renamed from: a */
    public boolean m4075a() {
        return this.f19300w.get(0);
    }

    /* renamed from: a */
    public boolean m4072a(C4702b c4702b) {
        if (c4702b != null && this.f19290a == c4702b.f19290a && this.f19291b == c4702b.f19291b && this.f19292c == c4702b.f19292c) {
            boolean m4060d = m4060d();
            boolean m4060d2 = c4702b.m4060d();
            if ((m4060d || m4060d2) && (!m4060d || !m4060d2 || !this.f19293d.equals(c4702b.f19293d))) {
                return false;
            }
            boolean m4056e = m4056e();
            boolean m4056e2 = c4702b.m4056e();
            if ((m4056e || m4056e2) && (!m4056e || !m4056e2 || !this.f19294e.equals(c4702b.f19294e))) {
                return false;
            }
            boolean m4053f = m4053f();
            boolean m4053f2 = c4702b.m4053f();
            if ((m4053f || m4053f2) && (!m4053f || !m4053f2 || this.f19295f != c4702b.f19295f)) {
                return false;
            }
            boolean m4051g = m4051g();
            boolean m4051g2 = c4702b.m4051g();
            if ((m4051g || m4051g2) && (!m4051g || !m4051g2 || !this.f19296g.equals(c4702b.f19296g))) {
                return false;
            }
            boolean m4050h = m4050h();
            boolean m4050h2 = c4702b.m4050h();
            if ((m4050h || m4050h2) && (!m4050h || !m4050h2 || !this.f19297h.equals(c4702b.f19297h))) {
                return false;
            }
            boolean m4049i = m4049i();
            boolean m4049i2 = c4702b.m4049i();
            if ((m4049i || m4049i2) && (!m4049i || !m4049i2 || this.f19298i != c4702b.f19298i)) {
                return false;
            }
            boolean m4048j = m4048j();
            boolean m4048j2 = c4702b.m4048j();
            return (!m4048j && !m4048j2) || (m4048j && m4048j2 && this.f19299j == c4702b.f19299j);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4702b c4702b) {
        int m1280a;
        int m1280a2;
        int m1277a;
        int m1277a2;
        int m1280a3;
        int m1277a3;
        int m1277a4;
        int m1280a4;
        int m1280a5;
        int m1282a;
        if (!getClass().equals(c4702b.getClass())) {
            return getClass().getName().compareTo(c4702b.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m4075a()).compareTo(Boolean.valueOf(c4702b.m4075a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m4075a() && (m1282a = C5366b.m1282a(this.f19290a, c4702b.f19290a)) != 0) {
            return m1282a;
        }
        int compareTo2 = Boolean.valueOf(m4069b()).compareTo(Boolean.valueOf(c4702b.m4069b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m4069b() && (m1280a5 = C5366b.m1280a(this.f19291b, c4702b.f19291b)) != 0) {
            return m1280a5;
        }
        int compareTo3 = Boolean.valueOf(m4064c()).compareTo(Boolean.valueOf(c4702b.m4064c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m4064c() && (m1280a4 = C5366b.m1280a(this.f19292c, c4702b.f19292c)) != 0) {
            return m1280a4;
        }
        int compareTo4 = Boolean.valueOf(m4060d()).compareTo(Boolean.valueOf(c4702b.m4060d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m4060d() && (m1277a4 = C5366b.m1277a(this.f19293d, c4702b.f19293d)) != 0) {
            return m1277a4;
        }
        int compareTo5 = Boolean.valueOf(m4056e()).compareTo(Boolean.valueOf(c4702b.m4056e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m4056e() && (m1277a3 = C5366b.m1277a(this.f19294e, c4702b.f19294e)) != 0) {
            return m1277a3;
        }
        int compareTo6 = Boolean.valueOf(m4053f()).compareTo(Boolean.valueOf(c4702b.m4053f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m4053f() && (m1280a3 = C5366b.m1280a(this.f19295f, c4702b.f19295f)) != 0) {
            return m1280a3;
        }
        int compareTo7 = Boolean.valueOf(m4051g()).compareTo(Boolean.valueOf(c4702b.m4051g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m4051g() && (m1277a2 = C5366b.m1277a(this.f19296g, c4702b.f19296g)) != 0) {
            return m1277a2;
        }
        int compareTo8 = Boolean.valueOf(m4050h()).compareTo(Boolean.valueOf(c4702b.m4050h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m4050h() && (m1277a = C5366b.m1277a(this.f19297h, c4702b.f19297h)) != 0) {
            return m1277a;
        }
        int compareTo9 = Boolean.valueOf(m4049i()).compareTo(Boolean.valueOf(c4702b.m4049i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m4049i() && (m1280a2 = C5366b.m1280a(this.f19298i, c4702b.f19298i)) != 0) {
            return m1280a2;
        }
        int compareTo10 = Boolean.valueOf(m4048j()).compareTo(Boolean.valueOf(c4702b.m4048j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m4048j() && (m1280a = C5366b.m1280a(this.f19299j, c4702b.f19299j)) != 0) {
            return m1280a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4702b m4068b(int i) {
        this.f19292c = i;
        m4061c(true);
        return this;
    }

    /* renamed from: b */
    public C4702b m4066b(String str) {
        this.f19294e = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m4047k();
        abstractC5373e.mo1250a(f19279l);
        abstractC5373e.mo1254a(f19280m);
        abstractC5373e.mo1260a(this.f19290a);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1254a(f19281n);
        abstractC5373e.mo1258a(this.f19291b);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1254a(f19282o);
        abstractC5373e.mo1258a(this.f19292c);
        abstractC5373e.mo1247b();
        if (this.f19293d != null) {
            abstractC5373e.mo1254a(f19283p);
            abstractC5373e.mo1256a(this.f19293d);
            abstractC5373e.mo1247b();
        }
        if (this.f19294e != null && m4056e()) {
            abstractC5373e.mo1254a(f19284q);
            abstractC5373e.mo1256a(this.f19294e);
            abstractC5373e.mo1247b();
        }
        if (m4053f()) {
            abstractC5373e.mo1254a(f19285r);
            abstractC5373e.mo1258a(this.f19295f);
            abstractC5373e.mo1247b();
        }
        if (this.f19296g != null && m4051g()) {
            abstractC5373e.mo1254a(f19286s);
            abstractC5373e.mo1256a(this.f19296g);
            abstractC5373e.mo1247b();
        }
        if (this.f19297h != null && m4050h()) {
            abstractC5373e.mo1254a(f19287t);
            abstractC5373e.mo1256a(this.f19297h);
            abstractC5373e.mo1247b();
        }
        if (m4049i()) {
            abstractC5373e.mo1254a(f19288u);
            abstractC5373e.mo1258a(this.f19298i);
            abstractC5373e.mo1247b();
        }
        if (m4048j()) {
            abstractC5373e.mo1254a(f19289v);
            abstractC5373e.mo1258a(this.f19299j);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m4065b(boolean z) {
        this.f19300w.set(1, z);
    }

    /* renamed from: b */
    public boolean m4069b() {
        return this.f19300w.get(1);
    }

    /* renamed from: c */
    public C4702b m4063c(int i) {
        this.f19295f = i;
        m4057d(true);
        return this;
    }

    /* renamed from: c */
    public C4702b m4062c(String str) {
        this.f19296g = str;
        return this;
    }

    /* renamed from: c */
    public void m4061c(boolean z) {
        this.f19300w.set(2, z);
    }

    /* renamed from: c */
    public boolean m4064c() {
        return this.f19300w.get(2);
    }

    /* renamed from: d */
    public C4702b m4059d(int i) {
        this.f19298i = i;
        m4054e(true);
        return this;
    }

    /* renamed from: d */
    public C4702b m4058d(String str) {
        this.f19297h = str;
        return this;
    }

    /* renamed from: d */
    public void m4057d(boolean z) {
        this.f19300w.set(3, z);
    }

    /* renamed from: d */
    public boolean m4060d() {
        return this.f19293d != null;
    }

    /* renamed from: e */
    public C4702b m4055e(int i) {
        this.f19299j = i;
        m4052f(true);
        return this;
    }

    /* renamed from: e */
    public void m4054e(boolean z) {
        this.f19300w.set(4, z);
    }

    /* renamed from: e */
    public boolean m4056e() {
        return this.f19294e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4702b)) {
            return m4072a((C4702b) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void m4052f(boolean z) {
        this.f19300w.set(5, z);
    }

    /* renamed from: f */
    public boolean m4053f() {
        return this.f19300w.get(3);
    }

    /* renamed from: g */
    public boolean m4051g() {
        return this.f19296g != null;
    }

    /* renamed from: h */
    public boolean m4050h() {
        return this.f19297h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m4049i() {
        return this.f19300w.get(4);
    }

    /* renamed from: j */
    public boolean m4048j() {
        return this.f19300w.get(5);
    }

    /* renamed from: k */
    public void m4047k() {
        if (this.f19293d == null) {
            throw new C5374f("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f19290a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f19291b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f19292c);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f19293d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19293d);
        }
        if (m4056e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f19294e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19294e);
            }
        }
        if (m4053f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f19295f);
        }
        if (m4051g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f19296g == null) {
                sb.append("null");
            } else {
                sb.append(this.f19296g);
            }
        }
        if (m4050h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f19297h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19297h);
            }
        }
        if (m4049i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f19298i);
        }
        if (m4048j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f19299j);
        }
        sb.append(")");
        return sb.toString();
    }
}
