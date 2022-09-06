package com.xiaomi.xmpush.thrift;

import com.p219mi.live.openlivesdk.C4093a;
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
import org.p248a.p283b.p284a.C5361c;
import org.p248a.p283b.p284a.C5362d;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5371c;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.z */
/* loaded from: classes2.dex */
public class C4838z implements Serializable, Cloneable, AbstractC5358a<C4838z, EnumC4839a> {

    /* renamed from: i */
    public static final Map<EnumC4839a, C5360b> f20651i;

    /* renamed from: j */
    private static final C5378j f20652j = new C5378j("XmPushActionCommand");

    /* renamed from: k */
    private static final C5370b f20653k = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: l */
    private static final C5370b f20654l = new C5370b("target", (byte) 12, 2);

    /* renamed from: m */
    private static final C5370b f20655m = new C5370b("id", (byte) 11, 3);

    /* renamed from: n */
    private static final C5370b f20656n = new C5370b("appId", (byte) 11, 4);

    /* renamed from: o */
    private static final C5370b f20657o = new C5370b("cmdName", (byte) 11, 5);

    /* renamed from: p */
    private static final C5370b f20658p = new C5370b("cmdArgs", (byte) 15, 6);

    /* renamed from: q */
    private static final C5370b f20659q = new C5370b("packageName", (byte) 11, 7);

    /* renamed from: r */
    private static final C5370b f20660r = new C5370b("category", (byte) 11, 9);

    /* renamed from: a */
    public String f20661a;

    /* renamed from: b */
    public C4828u f20662b;

    /* renamed from: c */
    public String f20663c;

    /* renamed from: d */
    public String f20664d;

    /* renamed from: e */
    public String f20665e;

    /* renamed from: f */
    public List<String> f20666f;

    /* renamed from: g */
    public String f20667g;

    /* renamed from: h */
    public String f20668h;

    /* renamed from: com.xiaomi.xmpush.thrift.z$a */
    /* loaded from: classes2.dex */
    public enum EnumC4839a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        CMD_NAME(5, "cmdName"),
        CMD_ARGS(6, "cmdArgs"),
        PACKAGE_NAME(7, "packageName"),
        CATEGORY(9, "category");
        

        /* renamed from: i */
        private static final Map<String, EnumC4839a> f20677i = new HashMap();

        /* renamed from: j */
        private final short f20679j;

        /* renamed from: k */
        private final String f20680k;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4839a.class).iterator();
            while (it2.hasNext()) {
                EnumC4839a enumC4839a = (EnumC4839a) it2.next();
                f20677i.put(enumC4839a.m3153a(), enumC4839a);
            }
        }

        EnumC4839a(short s, String str) {
            this.f20679j = s;
            this.f20680k = str;
        }

        /* renamed from: a */
        public String m3153a() {
            return this.f20680k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4839a.class);
        enumMap.put((EnumMap) EnumC4839a.DEBUG, (EnumC4839a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4839a.TARGET, (EnumC4839a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4839a.ID, (EnumC4839a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4839a.APP_ID, (EnumC4839a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4839a.CMD_NAME, (EnumC4839a) new C5360b("cmdName", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4839a.CMD_ARGS, (EnumC4839a) new C5360b("cmdArgs", (byte) 2, new C5362d((byte) 15, new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4839a.PACKAGE_NAME, (EnumC4839a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4839a.CATEGORY, (EnumC4839a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f20651i = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4838z.class, f20651i);
    }

    /* renamed from: a */
    public C4838z m3168a(String str) {
        this.f20663c = str;
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
                m3154i();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f20661a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f20662b = new C4828u();
                        this.f20662b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f20663c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f20664d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f20665e = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f20666f = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            this.f20666f.add(abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1237n();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 11) {
                        this.f20667g = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                default:
                    C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                    break;
                case 9:
                    if (mo1240i.f22437b == 11) {
                        this.f20668h = abstractC5373e.mo1223w();
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
    public boolean m3170a() {
        return this.f20661a != null;
    }

    /* renamed from: a */
    public boolean m3169a(C4838z c4838z) {
        if (c4838z == null) {
            return false;
        }
        boolean m3170a = m3170a();
        boolean m3170a2 = c4838z.m3170a();
        if ((m3170a || m3170a2) && (!m3170a || !m3170a2 || !this.f20661a.equals(c4838z.f20661a))) {
            return false;
        }
        boolean m3167b = m3167b();
        boolean m3167b2 = c4838z.m3167b();
        if ((m3167b || m3167b2) && (!m3167b || !m3167b2 || !this.f20662b.m3254a(c4838z.f20662b))) {
            return false;
        }
        boolean m3164c = m3164c();
        boolean m3164c2 = c4838z.m3164c();
        if ((m3164c || m3164c2) && (!m3164c || !m3164c2 || !this.f20663c.equals(c4838z.f20663c))) {
            return false;
        }
        boolean m3162d = m3162d();
        boolean m3162d2 = c4838z.m3162d();
        if ((m3162d || m3162d2) && (!m3162d || !m3162d2 || !this.f20664d.equals(c4838z.f20664d))) {
            return false;
        }
        boolean m3160e = m3160e();
        boolean m3160e2 = c4838z.m3160e();
        if ((m3160e || m3160e2) && (!m3160e || !m3160e2 || !this.f20665e.equals(c4838z.f20665e))) {
            return false;
        }
        boolean m3158f = m3158f();
        boolean m3158f2 = c4838z.m3158f();
        if ((m3158f || m3158f2) && (!m3158f || !m3158f2 || !this.f20666f.equals(c4838z.f20666f))) {
            return false;
        }
        boolean m3156g = m3156g();
        boolean m3156g2 = c4838z.m3156g();
        if ((m3156g || m3156g2) && (!m3156g || !m3156g2 || !this.f20667g.equals(c4838z.f20667g))) {
            return false;
        }
        boolean m3155h = m3155h();
        boolean m3155h2 = c4838z.m3155h();
        return (!m3155h && !m3155h2) || (m3155h && m3155h2 && this.f20668h.equals(c4838z.f20668h));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4838z c4838z) {
        int m1277a;
        int m1277a2;
        int m1273a;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1278a;
        int m1277a6;
        if (!getClass().equals(c4838z.getClass())) {
            return getClass().getName().compareTo(c4838z.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3170a()).compareTo(Boolean.valueOf(c4838z.m3170a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3170a() && (m1277a6 = C5366b.m1277a(this.f20661a, c4838z.f20661a)) != 0) {
            return m1277a6;
        }
        int compareTo2 = Boolean.valueOf(m3167b()).compareTo(Boolean.valueOf(c4838z.m3167b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3167b() && (m1278a = C5366b.m1278a(this.f20662b, c4838z.f20662b)) != 0) {
            return m1278a;
        }
        int compareTo3 = Boolean.valueOf(m3164c()).compareTo(Boolean.valueOf(c4838z.m3164c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3164c() && (m1277a5 = C5366b.m1277a(this.f20663c, c4838z.f20663c)) != 0) {
            return m1277a5;
        }
        int compareTo4 = Boolean.valueOf(m3162d()).compareTo(Boolean.valueOf(c4838z.m3162d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3162d() && (m1277a4 = C5366b.m1277a(this.f20664d, c4838z.f20664d)) != 0) {
            return m1277a4;
        }
        int compareTo5 = Boolean.valueOf(m3160e()).compareTo(Boolean.valueOf(c4838z.m3160e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3160e() && (m1277a3 = C5366b.m1277a(this.f20665e, c4838z.f20665e)) != 0) {
            return m1277a3;
        }
        int compareTo6 = Boolean.valueOf(m3158f()).compareTo(Boolean.valueOf(c4838z.m3158f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3158f() && (m1273a = C5366b.m1273a(this.f20666f, c4838z.f20666f)) != 0) {
            return m1273a;
        }
        int compareTo7 = Boolean.valueOf(m3156g()).compareTo(Boolean.valueOf(c4838z.m3156g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3156g() && (m1277a2 = C5366b.m1277a(this.f20667g, c4838z.f20667g)) != 0) {
            return m1277a2;
        }
        int compareTo8 = Boolean.valueOf(m3155h()).compareTo(Boolean.valueOf(c4838z.m3155h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3155h() && (m1277a = C5366b.m1277a(this.f20668h, c4838z.f20668h)) != 0) {
            return m1277a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4838z m3165b(String str) {
        this.f20664d = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3154i();
        abstractC5373e.mo1250a(f20652j);
        if (this.f20661a != null && m3170a()) {
            abstractC5373e.mo1254a(f20653k);
            abstractC5373e.mo1256a(this.f20661a);
            abstractC5373e.mo1247b();
        }
        if (this.f20662b != null && m3167b()) {
            abstractC5373e.mo1254a(f20654l);
            this.f20662b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20663c != null) {
            abstractC5373e.mo1254a(f20655m);
            abstractC5373e.mo1256a(this.f20663c);
            abstractC5373e.mo1247b();
        }
        if (this.f20664d != null) {
            abstractC5373e.mo1254a(f20656n);
            abstractC5373e.mo1256a(this.f20664d);
            abstractC5373e.mo1247b();
        }
        if (this.f20665e != null) {
            abstractC5373e.mo1254a(f20657o);
            abstractC5373e.mo1256a(this.f20665e);
            abstractC5373e.mo1247b();
        }
        if (this.f20666f != null && m3158f()) {
            abstractC5373e.mo1254a(f20658p);
            abstractC5373e.mo1253a(new C5371c((byte) 11, this.f20666f.size()));
            for (String str : this.f20666f) {
                abstractC5373e.mo1256a(str);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        if (this.f20667g != null && m3156g()) {
            abstractC5373e.mo1254a(f20659q);
            abstractC5373e.mo1256a(this.f20667g);
            abstractC5373e.mo1247b();
        }
        if (this.f20668h != null && m3155h()) {
            abstractC5373e.mo1254a(f20660r);
            abstractC5373e.mo1256a(this.f20668h);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3167b() {
        return this.f20662b != null;
    }

    /* renamed from: c */
    public C4838z m3163c(String str) {
        this.f20665e = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3164c() {
        return this.f20663c != null;
    }

    /* renamed from: d */
    public void m3161d(String str) {
        if (this.f20666f == null) {
            this.f20666f = new ArrayList();
        }
        this.f20666f.add(str);
    }

    /* renamed from: d */
    public boolean m3162d() {
        return this.f20664d != null;
    }

    /* renamed from: e */
    public C4838z m3159e(String str) {
        this.f20667g = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3160e() {
        return this.f20665e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4838z)) {
            return m3169a((C4838z) obj);
        }
        return false;
    }

    /* renamed from: f */
    public C4838z m3157f(String str) {
        this.f20668h = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3158f() {
        return this.f20666f != null;
    }

    /* renamed from: g */
    public boolean m3156g() {
        return this.f20667g != null;
    }

    /* renamed from: h */
    public boolean m3155h() {
        return this.f20668h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public void m3154i() {
        if (this.f20663c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f20664d == null) {
            throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f20665e != null) {
            return;
        }
        throw new C5374f("Required field 'cmdName' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z2 = true;
        if (m3170a()) {
            sb.append("debug:");
            if (this.f20661a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20661a);
            }
            z2 = false;
        }
        if (m3167b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f20662b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20662b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f20663c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20663c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f20664d == null) {
            sb.append("null");
        } else {
            sb.append(this.f20664d);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f20665e == null) {
            sb.append("null");
        } else {
            sb.append(this.f20665e);
        }
        if (m3158f()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f20666f == null) {
                sb.append("null");
            } else {
                sb.append(this.f20666f);
            }
        }
        if (m3156g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20667g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20667g);
            }
        }
        if (m3155h()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f20668h == null) {
                sb.append("null");
            } else {
                sb.append(this.f20668h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
