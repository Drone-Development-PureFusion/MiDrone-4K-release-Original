package com.xiaomi.xmpush.thrift;

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
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.ac */
/* loaded from: classes2.dex */
public class C4768ac implements Serializable, Cloneable, AbstractC5358a<C4768ac, EnumC4769a> {

    /* renamed from: b */
    public static final Map<EnumC4769a, C5360b> f19645b;

    /* renamed from: c */
    private static final C5378j f19646c = new C5378j("XmPushActionCustomConfig");

    /* renamed from: d */
    private static final C5370b f19647d = new C5370b("customConfigs", (byte) 15, 1);

    /* renamed from: a */
    public List<C4819p> f19648a;

    /* renamed from: com.xiaomi.xmpush.thrift.ac$a */
    /* loaded from: classes2.dex */
    public enum EnumC4769a {
        CUSTOM_CONFIGS(1, "customConfigs");
        

        /* renamed from: b */
        private static final Map<String, EnumC4769a> f19650b = new HashMap();

        /* renamed from: c */
        private final short f19652c;

        /* renamed from: d */
        private final String f19653d;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4769a.class).iterator();
            while (it2.hasNext()) {
                EnumC4769a enumC4769a = (EnumC4769a) it2.next();
                f19650b.put(enumC4769a.m3718a(), enumC4769a);
            }
        }

        EnumC4769a(short s, String str) {
            this.f19652c = s;
            this.f19653d = str;
        }

        /* renamed from: a */
        public String m3718a() {
            return this.f19653d;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4769a.class);
        enumMap.put((EnumMap) EnumC4769a.CUSTOM_CONFIGS, (EnumC4769a) new C5360b("customConfigs", (byte) 1, new C5362d((byte) 15, new C5365g((byte) 12, C4819p.class))));
        f19645b = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4768ac.class, f19645b);
    }

    /* renamed from: a */
    public List<C4819p> m3723a() {
        return this.f19648a;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3719c();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f19648a = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            C4819p c4819p = new C4819p();
                            c4819p.mo1286a(abstractC5373e);
                            this.f19648a.add(c4819p);
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
    public boolean m3722a(C4768ac c4768ac) {
        if (c4768ac == null) {
            return false;
        }
        boolean m3721b = m3721b();
        boolean m3721b2 = c4768ac.m3721b();
        return (!m3721b && !m3721b2) || (m3721b && m3721b2 && this.f19648a.equals(c4768ac.f19648a));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4768ac c4768ac) {
        int m1273a;
        if (!getClass().equals(c4768ac.getClass())) {
            return getClass().getName().compareTo(c4768ac.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3721b()).compareTo(Boolean.valueOf(c4768ac.m3721b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3721b() && (m1273a = C5366b.m1273a(this.f19648a, c4768ac.f19648a)) != 0) {
            return m1273a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3719c();
        abstractC5373e.mo1250a(f19646c);
        if (this.f19648a != null) {
            abstractC5373e.mo1254a(f19647d);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f19648a.size()));
            for (C4819p c4819p : this.f19648a) {
                c4819p.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3721b() {
        return this.f19648a != null;
    }

    /* renamed from: c */
    public void m3719c() {
        if (this.f19648a == null) {
            throw new C5374f("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4768ac)) {
            return m3722a((C4768ac) obj);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f19648a == null) {
            sb.append("null");
        } else {
            sb.append(this.f19648a);
        }
        sb.append(")");
        return sb.toString();
    }
}
