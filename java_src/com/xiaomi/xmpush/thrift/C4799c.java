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
/* renamed from: com.xiaomi.xmpush.thrift.c */
/* loaded from: classes2.dex */
public class C4799c implements Serializable, Cloneable, AbstractC5358a<C4799c, EnumC4800a> {

    /* renamed from: b */
    public static final Map<EnumC4800a, C5360b> f20129b;

    /* renamed from: c */
    private static final C5378j f20130c = new C5378j("ClientUploadData");

    /* renamed from: d */
    private static final C5370b f20131d = new C5370b("uploadDataItems", (byte) 15, 1);

    /* renamed from: a */
    public List<C4801d> f20132a;

    /* renamed from: com.xiaomi.xmpush.thrift.c$a */
    /* loaded from: classes2.dex */
    public enum EnumC4800a {
        UPLOAD_DATA_ITEMS(1, "uploadDataItems");
        

        /* renamed from: b */
        private static final Map<String, EnumC4800a> f20134b = new HashMap();

        /* renamed from: c */
        private final short f20136c;

        /* renamed from: d */
        private final String f20137d;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4800a.class).iterator();
            while (it2.hasNext()) {
                EnumC4800a enumC4800a = (EnumC4800a) it2.next();
                f20134b.put(enumC4800a.m3452a(), enumC4800a);
            }
        }

        EnumC4800a(short s, String str) {
            this.f20136c = s;
            this.f20137d = str;
        }

        /* renamed from: a */
        public String m3452a() {
            return this.f20137d;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4800a.class);
        enumMap.put((EnumMap) EnumC4800a.UPLOAD_DATA_ITEMS, (EnumC4800a) new C5360b("uploadDataItems", (byte) 1, new C5362d((byte) 15, new C5365g((byte) 12, C4801d.class))));
        f20129b = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4799c.class, f20129b);
    }

    /* renamed from: a */
    public int m3458a() {
        if (this.f20132a == null) {
            return 0;
        }
        return this.f20132a.size();
    }

    /* renamed from: a */
    public void m3456a(C4801d c4801d) {
        if (this.f20132a == null) {
            this.f20132a = new ArrayList();
        }
        this.f20132a.add(c4801d);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3453c();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f20132a = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            C4801d c4801d = new C4801d();
                            c4801d.mo1286a(abstractC5373e);
                            this.f20132a.add(c4801d);
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
    public boolean m3457a(C4799c c4799c) {
        if (c4799c == null) {
            return false;
        }
        boolean m3455b = m3455b();
        boolean m3455b2 = c4799c.m3455b();
        return (!m3455b && !m3455b2) || (m3455b && m3455b2 && this.f20132a.equals(c4799c.f20132a));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4799c c4799c) {
        int m1273a;
        if (!getClass().equals(c4799c.getClass())) {
            return getClass().getName().compareTo(c4799c.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3455b()).compareTo(Boolean.valueOf(c4799c.m3455b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3455b() && (m1273a = C5366b.m1273a(this.f20132a, c4799c.f20132a)) != 0) {
            return m1273a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3453c();
        abstractC5373e.mo1250a(f20130c);
        if (this.f20132a != null) {
            abstractC5373e.mo1254a(f20131d);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f20132a.size()));
            for (C4801d c4801d : this.f20132a) {
                c4801d.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3455b() {
        return this.f20132a != null;
    }

    /* renamed from: c */
    public void m3453c() {
        if (this.f20132a == null) {
            throw new C5374f("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4799c)) {
            return m3457a((C4799c) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f20132a == null) {
            sb.append("null");
        } else {
            sb.append(this.f20132a);
        }
        sb.append(")");
        return sb.toString();
    }
}
