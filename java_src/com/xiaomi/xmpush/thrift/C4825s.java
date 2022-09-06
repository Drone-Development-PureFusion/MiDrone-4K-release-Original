package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5366b;
import org.p248a.p283b.p284a.C5360b;
import org.p248a.p283b.p284a.C5364f;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5377i;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.s */
/* loaded from: classes2.dex */
public class C4825s implements Serializable, Cloneable, AbstractC5358a<C4825s, EnumC4826a> {

    /* renamed from: b */
    public static final Map<EnumC4826a, C5360b> f20479b;

    /* renamed from: c */
    private static final C5378j f20480c = new C5378j("RegisteredGeoFencing");

    /* renamed from: d */
    private static final C5370b f20481d = new C5370b("geoFencings", (byte) 14, 1);

    /* renamed from: a */
    public Set<C4809j> f20482a;

    /* renamed from: com.xiaomi.xmpush.thrift.s$a */
    /* loaded from: classes2.dex */
    public enum EnumC4826a {
        GEO_FENCINGS(1, "geoFencings");
        

        /* renamed from: b */
        private static final Map<String, EnumC4826a> f20484b = new HashMap();

        /* renamed from: c */
        private final short f20486c;

        /* renamed from: d */
        private final String f20487d;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4826a.class).iterator();
            while (it2.hasNext()) {
                EnumC4826a enumC4826a = (EnumC4826a) it2.next();
                f20484b.put(enumC4826a.m3258a(), enumC4826a);
            }
        }

        EnumC4826a(short s, String str) {
            this.f20486c = s;
            this.f20487d = str;
        }

        /* renamed from: a */
        public String m3258a() {
            return this.f20487d;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4826a.class);
        enumMap.put((EnumMap) EnumC4826a.GEO_FENCINGS, (EnumC4826a) new C5360b("geoFencings", (byte) 1, new C5364f((byte) 14, new C5365g((byte) 12, C4809j.class))));
        f20479b = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4825s.class, f20479b);
    }

    /* renamed from: a */
    public C4825s m3262a(Set<C4809j> set) {
        this.f20482a = set;
        return this;
    }

    /* renamed from: a */
    public Set<C4809j> m3264a() {
        return this.f20482a;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3259c();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 14) {
                        C5377i mo1224o = abstractC5373e.mo1224o();
                        this.f20482a = new HashSet(mo1224o.f22448b * 2);
                        for (int i = 0; i < mo1224o.f22448b; i++) {
                            C4809j c4809j = new C4809j();
                            c4809j.mo1286a(abstractC5373e);
                            this.f20482a.add(c4809j);
                        }
                        abstractC5373e.mo1236p();
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
    public boolean m3263a(C4825s c4825s) {
        if (c4825s == null) {
            return false;
        }
        boolean m3261b = m3261b();
        boolean m3261b2 = c4825s.m3261b();
        return (!m3261b && !m3261b2) || (m3261b && m3261b2 && this.f20482a.equals(c4825s.f20482a));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4825s c4825s) {
        int m1271a;
        if (!getClass().equals(c4825s.getClass())) {
            return getClass().getName().compareTo(c4825s.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3261b()).compareTo(Boolean.valueOf(c4825s.m3261b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3261b() && (m1271a = C5366b.m1271a(this.f20482a, c4825s.f20482a)) != 0) {
            return m1271a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3259c();
        abstractC5373e.mo1250a(f20480c);
        if (this.f20482a != null) {
            abstractC5373e.mo1254a(f20481d);
            abstractC5373e.mo1251a(new C5377i((byte) 12, this.f20482a.size()));
            for (C4809j c4809j : this.f20482a) {
                c4809j.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1243f();
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3261b() {
        return this.f20482a != null;
    }

    /* renamed from: c */
    public void m3259c() {
        if (this.f20482a == null) {
            throw new C5374f("Required field 'geoFencings' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4825s)) {
            return m3263a((C4825s) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RegisteredGeoFencing(");
        sb.append("geoFencings:");
        if (this.f20482a == null) {
            sb.append("null");
        } else {
            sb.append(this.f20482a);
        }
        sb.append(")");
        return sb.toString();
    }
}
