package com.xiaomi.xmpush.thrift;

import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.Serializable;
import java.util.ArrayList;
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
import org.p248a.p283b.p284a.C5362d;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5371c;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.m */
/* loaded from: classes2.dex */
public class C4814m implements Serializable, Cloneable, AbstractC5358a<C4814m, EnumC4815a> {

    /* renamed from: d */
    public static final Map<EnumC4815a, C5360b> f20304d;

    /* renamed from: e */
    private static final C5378j f20305e = new C5378j("LocationInfo");

    /* renamed from: f */
    private static final C5370b f20306f = new C5370b("wifiList", (byte) 15, 1);

    /* renamed from: g */
    private static final C5370b f20307g = new C5370b("cellList", (byte) 15, 2);

    /* renamed from: h */
    private static final C5370b f20308h = new C5370b(GeocodeSearch.GPS, (byte) 12, 3);

    /* renamed from: a */
    public List<C4830v> f20309a;

    /* renamed from: b */
    public List<C4797b> f20310b;

    /* renamed from: c */
    public C4807i f20311c;

    /* renamed from: com.xiaomi.xmpush.thrift.m$a */
    /* loaded from: classes2.dex */
    public enum EnumC4815a {
        WIFI_LIST(1, "wifiList"),
        CELL_LIST(2, "cellList"),
        GPS(3, GeocodeSearch.GPS);
        

        /* renamed from: d */
        private static final Map<String, EnumC4815a> f20315d = new HashMap();

        /* renamed from: e */
        private final short f20317e;

        /* renamed from: f */
        private final String f20318f;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4815a.class).iterator();
            while (it2.hasNext()) {
                EnumC4815a enumC4815a = (EnumC4815a) it2.next();
                f20315d.put(enumC4815a.m3357a(), enumC4815a);
            }
        }

        EnumC4815a(short s, String str) {
            this.f20317e = s;
            this.f20318f = str;
        }

        /* renamed from: a */
        public String m3357a() {
            return this.f20318f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4815a.class);
        enumMap.put((EnumMap) EnumC4815a.WIFI_LIST, (EnumC4815a) new C5360b("wifiList", (byte) 2, new C5362d((byte) 15, new C5365g((byte) 12, C4830v.class))));
        enumMap.put((EnumMap) EnumC4815a.CELL_LIST, (EnumC4815a) new C5360b("cellList", (byte) 2, new C5362d((byte) 15, new C5365g((byte) 12, C4797b.class))));
        enumMap.put((EnumMap) EnumC4815a.GPS, (EnumC4815a) new C5360b(GeocodeSearch.GPS, (byte) 2, new C5365g((byte) 12, C4807i.class)));
        f20304d = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4814m.class, f20304d);
    }

    /* renamed from: a */
    public C4814m m3365a(C4807i c4807i) {
        this.f20311c = c4807i;
        return this;
    }

    /* renamed from: a */
    public C4814m m3363a(List<C4830v> list) {
        this.f20309a = list;
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
                m3358d();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f20309a = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            C4830v c4830v = new C4830v();
                            c4830v.mo1286a(abstractC5373e);
                            this.f20309a.add(c4830v);
                        }
                        abstractC5373e.mo1237n();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m2 = abstractC5373e.mo1225m();
                        this.f20310b = new ArrayList(mo1225m2.f22440b);
                        for (int i2 = 0; i2 < mo1225m2.f22440b; i2++) {
                            C4797b c4797b = new C4797b();
                            c4797b.mo1286a(abstractC5373e);
                            this.f20310b.add(c4797b);
                        }
                        abstractC5373e.mo1237n();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 12) {
                        this.f20311c = new C4807i();
                        this.f20311c.mo1286a(abstractC5373e);
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
    public boolean m3366a() {
        return this.f20309a != null;
    }

    /* renamed from: a */
    public boolean m3364a(C4814m c4814m) {
        if (c4814m == null) {
            return false;
        }
        boolean m3366a = m3366a();
        boolean m3366a2 = c4814m.m3366a();
        if ((m3366a || m3366a2) && (!m3366a || !m3366a2 || !this.f20309a.equals(c4814m.f20309a))) {
            return false;
        }
        boolean m3362b = m3362b();
        boolean m3362b2 = c4814m.m3362b();
        if ((m3362b || m3362b2) && (!m3362b || !m3362b2 || !this.f20310b.equals(c4814m.f20310b))) {
            return false;
        }
        boolean m3359c = m3359c();
        boolean m3359c2 = c4814m.m3359c();
        return (!m3359c && !m3359c2) || (m3359c && m3359c2 && this.f20311c.m3428a(c4814m.f20311c));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4814m c4814m) {
        int m1278a;
        int m1273a;
        int m1273a2;
        if (!getClass().equals(c4814m.getClass())) {
            return getClass().getName().compareTo(c4814m.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3366a()).compareTo(Boolean.valueOf(c4814m.m3366a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3366a() && (m1273a2 = C5366b.m1273a(this.f20309a, c4814m.f20309a)) != 0) {
            return m1273a2;
        }
        int compareTo2 = Boolean.valueOf(m3362b()).compareTo(Boolean.valueOf(c4814m.m3362b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3362b() && (m1273a = C5366b.m1273a(this.f20310b, c4814m.f20310b)) != 0) {
            return m1273a;
        }
        int compareTo3 = Boolean.valueOf(m3359c()).compareTo(Boolean.valueOf(c4814m.m3359c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3359c() && (m1278a = C5366b.m1278a(this.f20311c, c4814m.f20311c)) != 0) {
            return m1278a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4814m m3360b(List<C4797b> list) {
        this.f20310b = list;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3358d();
        abstractC5373e.mo1250a(f20305e);
        if (this.f20309a != null && m3366a()) {
            abstractC5373e.mo1254a(f20306f);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f20309a.size()));
            for (C4830v c4830v : this.f20309a) {
                c4830v.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        if (this.f20310b != null && m3362b()) {
            abstractC5373e.mo1254a(f20307g);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f20310b.size()));
            for (C4797b c4797b : this.f20310b) {
                c4797b.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        if (this.f20311c != null && m3359c()) {
            abstractC5373e.mo1254a(f20308h);
            this.f20311c.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3362b() {
        return this.f20310b != null;
    }

    /* renamed from: c */
    public boolean m3359c() {
        return this.f20311c != null;
    }

    /* renamed from: d */
    public void m3358d() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4814m)) {
            return m3364a((C4814m) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("LocationInfo(");
        boolean z2 = true;
        if (m3366a()) {
            sb.append("wifiList:");
            if (this.f20309a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20309a);
            }
            z2 = false;
        }
        if (m3362b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("cellList:");
            if (this.f20310b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20310b);
            }
        } else {
            z = z2;
        }
        if (m3359c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("gps:");
            if (this.f20311c == null) {
                sb.append("null");
            } else {
                sb.append(this.f20311c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
