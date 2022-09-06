package com.xiaomi.push.thrift;

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
/* renamed from: com.xiaomi.push.thrift.c */
/* loaded from: classes2.dex */
public class C4704c implements Serializable, Cloneable, AbstractC5358a<C4704c, EnumC4705a> {

    /* renamed from: d */
    public static final Map<EnumC4705a, C5360b> f19315d;

    /* renamed from: e */
    private static final C5378j f19316e = new C5378j("StatsEvents");

    /* renamed from: f */
    private static final C5370b f19317f = new C5370b("uuid", (byte) 11, 1);

    /* renamed from: g */
    private static final C5370b f19318g = new C5370b("operator", (byte) 11, 2);

    /* renamed from: h */
    private static final C5370b f19319h = new C5370b("events", (byte) 15, 3);

    /* renamed from: a */
    public String f19320a;

    /* renamed from: b */
    public String f19321b;

    /* renamed from: c */
    public List<C4702b> f19322c;

    /* renamed from: com.xiaomi.push.thrift.c$a */
    /* loaded from: classes2.dex */
    public enum EnumC4705a {
        UUID(1, "uuid"),
        OPERATOR(2, "operator"),
        EVENTS(3, "events");
        

        /* renamed from: d */
        private static final Map<String, EnumC4705a> f19326d = new HashMap();

        /* renamed from: e */
        private final short f19328e;

        /* renamed from: f */
        private final String f19329f;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4705a.class).iterator();
            while (it2.hasNext()) {
                EnumC4705a enumC4705a = (EnumC4705a) it2.next();
                f19326d.put(enumC4705a.m4038a(), enumC4705a);
            }
        }

        EnumC4705a(short s, String str) {
            this.f19328e = s;
            this.f19329f = str;
        }

        /* renamed from: a */
        public String m4038a() {
            return this.f19329f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4705a.class);
        enumMap.put((EnumMap) EnumC4705a.UUID, (EnumC4705a) new C5360b("uuid", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4705a.OPERATOR, (EnumC4705a) new C5360b("operator", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4705a.EVENTS, (EnumC4705a) new C5360b("events", (byte) 1, new C5362d((byte) 15, new C5365g((byte) 12, C4702b.class))));
        f19315d = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4704c.class, f19315d);
    }

    public C4704c() {
    }

    public C4704c(String str, List<C4702b> list) {
        this();
        this.f19320a = str;
        this.f19322c = list;
    }

    /* renamed from: a */
    public C4704c m4043a(String str) {
        this.f19321b = str;
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
                m4039d();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f19320a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 11) {
                        this.f19321b = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f19322c = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            C4702b c4702b = new C4702b();
                            c4702b.mo1286a(abstractC5373e);
                            this.f19322c.add(c4702b);
                        }
                        abstractC5373e.mo1237n();
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
    public boolean m4045a() {
        return this.f19320a != null;
    }

    /* renamed from: a */
    public boolean m4044a(C4704c c4704c) {
        if (c4704c == null) {
            return false;
        }
        boolean m4045a = m4045a();
        boolean m4045a2 = c4704c.m4045a();
        if ((m4045a || m4045a2) && (!m4045a || !m4045a2 || !this.f19320a.equals(c4704c.f19320a))) {
            return false;
        }
        boolean m4042b = m4042b();
        boolean m4042b2 = c4704c.m4042b();
        if ((m4042b || m4042b2) && (!m4042b || !m4042b2 || !this.f19321b.equals(c4704c.f19321b))) {
            return false;
        }
        boolean m4040c = m4040c();
        boolean m4040c2 = c4704c.m4040c();
        return (!m4040c && !m4040c2) || (m4040c && m4040c2 && this.f19322c.equals(c4704c.f19322c));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4704c c4704c) {
        int m1273a;
        int m1277a;
        int m1277a2;
        if (!getClass().equals(c4704c.getClass())) {
            return getClass().getName().compareTo(c4704c.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m4045a()).compareTo(Boolean.valueOf(c4704c.m4045a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m4045a() && (m1277a2 = C5366b.m1277a(this.f19320a, c4704c.f19320a)) != 0) {
            return m1277a2;
        }
        int compareTo2 = Boolean.valueOf(m4042b()).compareTo(Boolean.valueOf(c4704c.m4042b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m4042b() && (m1277a = C5366b.m1277a(this.f19321b, c4704c.f19321b)) != 0) {
            return m1277a;
        }
        int compareTo3 = Boolean.valueOf(m4040c()).compareTo(Boolean.valueOf(c4704c.m4040c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m4040c() && (m1273a = C5366b.m1273a(this.f19322c, c4704c.f19322c)) != 0) {
            return m1273a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m4039d();
        abstractC5373e.mo1250a(f19316e);
        if (this.f19320a != null) {
            abstractC5373e.mo1254a(f19317f);
            abstractC5373e.mo1256a(this.f19320a);
            abstractC5373e.mo1247b();
        }
        if (this.f19321b != null && m4042b()) {
            abstractC5373e.mo1254a(f19318g);
            abstractC5373e.mo1256a(this.f19321b);
            abstractC5373e.mo1247b();
        }
        if (this.f19322c != null) {
            abstractC5373e.mo1254a(f19319h);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f19322c.size()));
            for (C4702b c4702b : this.f19322c) {
                c4702b.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m4042b() {
        return this.f19321b != null;
    }

    /* renamed from: c */
    public boolean m4040c() {
        return this.f19322c != null;
    }

    /* renamed from: d */
    public void m4039d() {
        if (this.f19320a == null) {
            throw new C5374f("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f19322c != null) {
            return;
        }
        throw new C5374f("Required field 'events' was not present! Struct: " + toString());
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4704c)) {
            return m4044a((C4704c) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f19320a == null) {
            sb.append("null");
        } else {
            sb.append(this.f19320a);
        }
        if (m4042b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f19321b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19321b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f19322c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19322c);
        }
        sb.append(")");
        return sb.toString();
    }
}
