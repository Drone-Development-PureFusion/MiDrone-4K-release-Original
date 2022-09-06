package com.xiaomi.xmpush.thrift;

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
/* renamed from: com.xiaomi.xmpush.thrift.v */
/* loaded from: classes2.dex */
public class C4830v implements Serializable, Cloneable, AbstractC5358a<C4830v, EnumC4831a> {

    /* renamed from: d */
    public static final Map<EnumC4831a, C5360b> f20515d;

    /* renamed from: e */
    private static final C5378j f20516e = new C5378j("Wifi");

    /* renamed from: f */
    private static final C5370b f20517f = new C5370b("macAddress", (byte) 11, 1);

    /* renamed from: g */
    private static final C5370b f20518g = new C5370b("signalStrength", (byte) 8, 2);

    /* renamed from: h */
    private static final C5370b f20519h = new C5370b("ssid", (byte) 11, 3);

    /* renamed from: a */
    public String f20520a;

    /* renamed from: b */
    public int f20521b;

    /* renamed from: c */
    public String f20522c;

    /* renamed from: i */
    private BitSet f20523i = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.v$a */
    /* loaded from: classes2.dex */
    public enum EnumC4831a {
        MAC_ADDRESS(1, "macAddress"),
        SIGNAL_STRENGTH(2, "signalStrength"),
        SSID(3, "ssid");
        

        /* renamed from: d */
        private static final Map<String, EnumC4831a> f20527d = new HashMap();

        /* renamed from: e */
        private final short f20529e;

        /* renamed from: f */
        private final String f20530f;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4831a.class).iterator();
            while (it2.hasNext()) {
                EnumC4831a enumC4831a = (EnumC4831a) it2.next();
                f20527d.put(enumC4831a.m3234a(), enumC4831a);
            }
        }

        EnumC4831a(short s, String str) {
            this.f20529e = s;
            this.f20530f = str;
        }

        /* renamed from: a */
        public String m3234a() {
            return this.f20530f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4831a.class);
        enumMap.put((EnumMap) EnumC4831a.MAC_ADDRESS, (EnumC4831a) new C5360b("macAddress", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4831a.SIGNAL_STRENGTH, (EnumC4831a) new C5360b("signalStrength", (byte) 1, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4831a.SSID, (EnumC4831a) new C5360b("ssid", (byte) 2, new C5361c((byte) 11)));
        f20515d = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4830v.class, f20515d);
    }

    /* renamed from: a */
    public C4830v m3243a(int i) {
        this.f20521b = i;
        m3240a(true);
        return this;
    }

    /* renamed from: a */
    public C4830v m3241a(String str) {
        this.f20520a = str;
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
                if (!m3239b()) {
                    throw new C5374f("Required field 'signalStrength' was not found in serialized data! Struct: " + toString());
                }
                m3235d();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20520a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20521b = abstractC5373e.mo1232t();
                        m3240a(true);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20522c = abstractC5373e.mo1223w();
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
    public void m3240a(boolean z) {
        this.f20523i.set(0, z);
    }

    /* renamed from: a */
    public boolean m3244a() {
        return this.f20520a != null;
    }

    /* renamed from: a */
    public boolean m3242a(C4830v c4830v) {
        if (c4830v == null) {
            return false;
        }
        boolean m3244a = m3244a();
        boolean m3244a2 = c4830v.m3244a();
        if (((m3244a || m3244a2) && (!m3244a || !m3244a2 || !this.f20520a.equals(c4830v.f20520a))) || this.f20521b != c4830v.f20521b) {
            return false;
        }
        boolean m3236c = m3236c();
        boolean m3236c2 = c4830v.m3236c();
        return (!m3236c && !m3236c2) || (m3236c && m3236c2 && this.f20522c.equals(c4830v.f20522c));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4830v c4830v) {
        int m1277a;
        int m1280a;
        int m1277a2;
        if (!getClass().equals(c4830v.getClass())) {
            return getClass().getName().compareTo(c4830v.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3244a()).compareTo(Boolean.valueOf(c4830v.m3244a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3244a() && (m1277a2 = C5366b.m1277a(this.f20520a, c4830v.f20520a)) != 0) {
            return m1277a2;
        }
        int compareTo2 = Boolean.valueOf(m3239b()).compareTo(Boolean.valueOf(c4830v.m3239b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3239b() && (m1280a = C5366b.m1280a(this.f20521b, c4830v.f20521b)) != 0) {
            return m1280a;
        }
        int compareTo3 = Boolean.valueOf(m3236c()).compareTo(Boolean.valueOf(c4830v.m3236c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3236c() && (m1277a = C5366b.m1277a(this.f20522c, c4830v.f20522c)) != 0) {
            return m1277a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4830v m3237b(String str) {
        this.f20522c = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3235d();
        abstractC5373e.mo1250a(f20516e);
        if (this.f20520a != null) {
            abstractC5373e.mo1254a(f20517f);
            abstractC5373e.mo1256a(this.f20520a);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f20518g);
        abstractC5373e.mo1258a(this.f20521b);
        abstractC5373e.mo1247b();
        if (this.f20522c != null && m3236c()) {
            abstractC5373e.mo1254a(f20519h);
            abstractC5373e.mo1256a(this.f20522c);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3239b() {
        return this.f20523i.get(0);
    }

    /* renamed from: c */
    public boolean m3236c() {
        return this.f20522c != null;
    }

    /* renamed from: d */
    public void m3235d() {
        if (this.f20520a == null) {
            throw new C5374f("Required field 'macAddress' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4830v)) {
            return m3242a((C4830v) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Wifi(");
        sb.append("macAddress:");
        if (this.f20520a == null) {
            sb.append("null");
        } else {
            sb.append(this.f20520a);
        }
        sb.append(", ");
        sb.append("signalStrength:");
        sb.append(this.f20521b);
        if (m3236c()) {
            sb.append(", ");
            sb.append("ssid:");
            if (this.f20522c == null) {
                sb.append("null");
            } else {
                sb.append(this.f20522c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
