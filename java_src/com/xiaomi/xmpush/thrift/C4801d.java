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
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.d */
/* loaded from: classes2.dex */
public class C4801d implements Serializable, Cloneable, AbstractC5358a<C4801d, EnumC4802a> {

    /* renamed from: h */
    public static final Map<EnumC4802a, C5360b> f20138h;

    /* renamed from: i */
    private static final C5378j f20139i = new C5378j("ClientUploadDataItem");

    /* renamed from: j */
    private static final C5370b f20140j = new C5370b("channel", (byte) 11, 1);

    /* renamed from: k */
    private static final C5370b f20141k = new C5370b("data", (byte) 11, 2);

    /* renamed from: l */
    private static final C5370b f20142l = new C5370b("name", (byte) 11, 3);

    /* renamed from: m */
    private static final C5370b f20143m = new C5370b("counter", (byte) 10, 4);

    /* renamed from: n */
    private static final C5370b f20144n = new C5370b("timestamp", (byte) 10, 5);

    /* renamed from: o */
    private static final C5370b f20145o = new C5370b("fromSdk", (byte) 2, 6);

    /* renamed from: p */
    private static final C5370b f20146p = new C5370b("category", (byte) 11, 7);

    /* renamed from: a */
    public String f20147a;

    /* renamed from: b */
    public String f20148b;

    /* renamed from: c */
    public String f20149c;

    /* renamed from: d */
    public long f20150d;

    /* renamed from: e */
    public long f20151e;

    /* renamed from: f */
    public boolean f20152f;

    /* renamed from: g */
    public String f20153g;

    /* renamed from: q */
    private BitSet f20154q = new BitSet(3);

    /* renamed from: com.xiaomi.xmpush.thrift.d$a */
    /* loaded from: classes2.dex */
    public enum EnumC4802a {
        CHANNEL(1, "channel"),
        DATA(2, "data"),
        NAME(3, "name"),
        COUNTER(4, "counter"),
        TIMESTAMP(5, "timestamp"),
        FROM_SDK(6, "fromSdk"),
        CATEGORY(7, "category");
        

        /* renamed from: h */
        private static final Map<String, EnumC4802a> f20162h = new HashMap();

        /* renamed from: i */
        private final short f20164i;

        /* renamed from: j */
        private final String f20165j;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4802a.class).iterator();
            while (it2.hasNext()) {
                EnumC4802a enumC4802a = (EnumC4802a) it2.next();
                f20162h.put(enumC4802a.m3438a(), enumC4802a);
            }
        }

        EnumC4802a(short s, String str) {
            this.f20164i = s;
            this.f20165j = str;
        }

        /* renamed from: a */
        public String m3438a() {
            return this.f20165j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4802a.class);
        enumMap.put((EnumMap) EnumC4802a.CHANNEL, (EnumC4802a) new C5360b("channel", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4802a.DATA, (EnumC4802a) new C5360b("data", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4802a.NAME, (EnumC4802a) new C5360b("name", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4802a.COUNTER, (EnumC4802a) new C5360b("counter", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4802a.TIMESTAMP, (EnumC4802a) new C5360b("timestamp", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4802a.FROM_SDK, (EnumC4802a) new C5360b("fromSdk", (byte) 2, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4802a.CATEGORY, (EnumC4802a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f20138h = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4801d.class, f20138h);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3439h();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20147a = abstractC5373e.mo1223w();
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20148b = abstractC5373e.mo1223w();
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20149c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20150d = abstractC5373e.mo1231u();
                        m3449a(true);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20151e = abstractC5373e.mo1231u();
                        m3446b(true);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b != 2) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20152f = abstractC5373e.mo1235q();
                        m3444c(true);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20153g = abstractC5373e.mo1223w();
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
    public void m3449a(boolean z) {
        this.f20154q.set(0, z);
    }

    /* renamed from: a */
    public boolean m3451a() {
        return this.f20147a != null;
    }

    /* renamed from: a */
    public boolean m3450a(C4801d c4801d) {
        if (c4801d == null) {
            return false;
        }
        boolean m3451a = m3451a();
        boolean m3451a2 = c4801d.m3451a();
        if ((m3451a || m3451a2) && (!m3451a || !m3451a2 || !this.f20147a.equals(c4801d.f20147a))) {
            return false;
        }
        boolean m3448b = m3448b();
        boolean m3448b2 = c4801d.m3448b();
        if ((m3448b || m3448b2) && (!m3448b || !m3448b2 || !this.f20148b.equals(c4801d.f20148b))) {
            return false;
        }
        boolean m3445c = m3445c();
        boolean m3445c2 = c4801d.m3445c();
        if ((m3445c || m3445c2) && (!m3445c || !m3445c2 || !this.f20149c.equals(c4801d.f20149c))) {
            return false;
        }
        boolean m3443d = m3443d();
        boolean m3443d2 = c4801d.m3443d();
        if ((m3443d || m3443d2) && (!m3443d || !m3443d2 || this.f20150d != c4801d.f20150d)) {
            return false;
        }
        boolean m3442e = m3442e();
        boolean m3442e2 = c4801d.m3442e();
        if ((m3442e || m3442e2) && (!m3442e || !m3442e2 || this.f20151e != c4801d.f20151e)) {
            return false;
        }
        boolean m3441f = m3441f();
        boolean m3441f2 = c4801d.m3441f();
        if ((m3441f || m3441f2) && (!m3441f || !m3441f2 || this.f20152f != c4801d.f20152f)) {
            return false;
        }
        boolean m3440g = m3440g();
        boolean m3440g2 = c4801d.m3440g();
        return (!m3440g && !m3440g2) || (m3440g && m3440g2 && this.f20153g.equals(c4801d.f20153g));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4801d c4801d) {
        int m1277a;
        int m1269a;
        int m1279a;
        int m1279a2;
        int m1277a2;
        int m1277a3;
        int m1277a4;
        if (!getClass().equals(c4801d.getClass())) {
            return getClass().getName().compareTo(c4801d.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3451a()).compareTo(Boolean.valueOf(c4801d.m3451a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3451a() && (m1277a4 = C5366b.m1277a(this.f20147a, c4801d.f20147a)) != 0) {
            return m1277a4;
        }
        int compareTo2 = Boolean.valueOf(m3448b()).compareTo(Boolean.valueOf(c4801d.m3448b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3448b() && (m1277a3 = C5366b.m1277a(this.f20148b, c4801d.f20148b)) != 0) {
            return m1277a3;
        }
        int compareTo3 = Boolean.valueOf(m3445c()).compareTo(Boolean.valueOf(c4801d.m3445c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3445c() && (m1277a2 = C5366b.m1277a(this.f20149c, c4801d.f20149c)) != 0) {
            return m1277a2;
        }
        int compareTo4 = Boolean.valueOf(m3443d()).compareTo(Boolean.valueOf(c4801d.m3443d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3443d() && (m1279a2 = C5366b.m1279a(this.f20150d, c4801d.f20150d)) != 0) {
            return m1279a2;
        }
        int compareTo5 = Boolean.valueOf(m3442e()).compareTo(Boolean.valueOf(c4801d.m3442e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3442e() && (m1279a = C5366b.m1279a(this.f20151e, c4801d.f20151e)) != 0) {
            return m1279a;
        }
        int compareTo6 = Boolean.valueOf(m3441f()).compareTo(Boolean.valueOf(c4801d.m3441f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3441f() && (m1269a = C5366b.m1269a(this.f20152f, c4801d.f20152f)) != 0) {
            return m1269a;
        }
        int compareTo7 = Boolean.valueOf(m3440g()).compareTo(Boolean.valueOf(c4801d.m3440g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3440g() && (m1277a = C5366b.m1277a(this.f20153g, c4801d.f20153g)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3439h();
        abstractC5373e.mo1250a(f20139i);
        if (this.f20147a != null && m3451a()) {
            abstractC5373e.mo1254a(f20140j);
            abstractC5373e.mo1256a(this.f20147a);
            abstractC5373e.mo1247b();
        }
        if (this.f20148b != null && m3448b()) {
            abstractC5373e.mo1254a(f20141k);
            abstractC5373e.mo1256a(this.f20148b);
            abstractC5373e.mo1247b();
        }
        if (this.f20149c != null && m3445c()) {
            abstractC5373e.mo1254a(f20142l);
            abstractC5373e.mo1256a(this.f20149c);
            abstractC5373e.mo1247b();
        }
        if (m3443d()) {
            abstractC5373e.mo1254a(f20143m);
            abstractC5373e.mo1257a(this.f20150d);
            abstractC5373e.mo1247b();
        }
        if (m3442e()) {
            abstractC5373e.mo1254a(f20144n);
            abstractC5373e.mo1257a(this.f20151e);
            abstractC5373e.mo1247b();
        }
        if (m3441f()) {
            abstractC5373e.mo1254a(f20145o);
            abstractC5373e.mo1248a(this.f20152f);
            abstractC5373e.mo1247b();
        }
        if (this.f20153g != null && m3440g()) {
            abstractC5373e.mo1254a(f20146p);
            abstractC5373e.mo1256a(this.f20153g);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3446b(boolean z) {
        this.f20154q.set(1, z);
    }

    /* renamed from: b */
    public boolean m3448b() {
        return this.f20148b != null;
    }

    /* renamed from: c */
    public void m3444c(boolean z) {
        this.f20154q.set(2, z);
    }

    /* renamed from: c */
    public boolean m3445c() {
        return this.f20149c != null;
    }

    /* renamed from: d */
    public boolean m3443d() {
        return this.f20154q.get(0);
    }

    /* renamed from: e */
    public boolean m3442e() {
        return this.f20154q.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4801d)) {
            return m3450a((C4801d) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3441f() {
        return this.f20154q.get(2);
    }

    /* renamed from: g */
    public boolean m3440g() {
        return this.f20153g != null;
    }

    /* renamed from: h */
    public void m3439h() {
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m3451a()) {
            sb.append("channel:");
            if (this.f20147a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20147a);
            }
            z2 = false;
        }
        if (m3448b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f20148b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20148b);
            }
            z2 = false;
        }
        if (m3445c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f20149c == null) {
                sb.append("null");
            } else {
                sb.append(this.f20149c);
            }
            z2 = false;
        }
        if (m3443d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f20150d);
            z2 = false;
        }
        if (m3442e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f20151e);
            z2 = false;
        }
        if (m3441f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f20152f);
        } else {
            z = z2;
        }
        if (m3440g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f20153g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20153g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
