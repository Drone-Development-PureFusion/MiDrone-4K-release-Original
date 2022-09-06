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
/* renamed from: com.xiaomi.xmpush.thrift.y */
/* loaded from: classes2.dex */
public class C4836y implements Serializable, Cloneable, AbstractC5358a<C4836y, EnumC4837a> {

    /* renamed from: c */
    public static final Map<EnumC4837a, C5360b> f20638c;

    /* renamed from: d */
    private static final C5378j f20639d = new C5378j("XmPushActionCheckClientInfo");

    /* renamed from: e */
    private static final C5370b f20640e = new C5370b("miscConfigVersion", (byte) 8, 1);

    /* renamed from: f */
    private static final C5370b f20641f = new C5370b("pluginConfigVersion", (byte) 8, 2);

    /* renamed from: a */
    public int f20642a;

    /* renamed from: b */
    public int f20643b;

    /* renamed from: g */
    private BitSet f20644g = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.y$a */
    /* loaded from: classes2.dex */
    public enum EnumC4837a {
        MISC_CONFIG_VERSION(1, "miscConfigVersion"),
        PLUGIN_CONFIG_VERSION(2, "pluginConfigVersion");
        

        /* renamed from: c */
        private static final Map<String, EnumC4837a> f20647c = new HashMap();

        /* renamed from: d */
        private final short f20649d;

        /* renamed from: e */
        private final String f20650e;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4837a.class).iterator();
            while (it2.hasNext()) {
                EnumC4837a enumC4837a = (EnumC4837a) it2.next();
                f20647c.put(enumC4837a.m3171a(), enumC4837a);
            }
        }

        EnumC4837a(short s, String str) {
            this.f20649d = s;
            this.f20650e = str;
        }

        /* renamed from: a */
        public String m3171a() {
            return this.f20650e;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4837a.class);
        enumMap.put((EnumMap) EnumC4837a.MISC_CONFIG_VERSION, (EnumC4837a) new C5360b("miscConfigVersion", (byte) 1, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4837a.PLUGIN_CONFIG_VERSION, (EnumC4837a) new C5360b("pluginConfigVersion", (byte) 1, new C5361c((byte) 8)));
        f20638c = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4836y.class, f20638c);
    }

    /* renamed from: a */
    public C4836y m3179a(int i) {
        this.f20642a = i;
        m3177a(true);
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
                if (!m3180a()) {
                    throw new C5374f("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!m3176b()) {
                    throw new C5374f("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                m3172c();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20642a = abstractC5373e.mo1232t();
                        m3177a(true);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20643b = abstractC5373e.mo1232t();
                        m3173b(true);
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
    public void m3177a(boolean z) {
        this.f20644g.set(0, z);
    }

    /* renamed from: a */
    public boolean m3180a() {
        return this.f20644g.get(0);
    }

    /* renamed from: a */
    public boolean m3178a(C4836y c4836y) {
        return c4836y != null && this.f20642a == c4836y.f20642a && this.f20643b == c4836y.f20643b;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4836y c4836y) {
        int m1280a;
        int m1280a2;
        if (!getClass().equals(c4836y.getClass())) {
            return getClass().getName().compareTo(c4836y.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3180a()).compareTo(Boolean.valueOf(c4836y.m3180a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3180a() && (m1280a2 = C5366b.m1280a(this.f20642a, c4836y.f20642a)) != 0) {
            return m1280a2;
        }
        int compareTo2 = Boolean.valueOf(m3176b()).compareTo(Boolean.valueOf(c4836y.m3176b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3176b() && (m1280a = C5366b.m1280a(this.f20643b, c4836y.f20643b)) != 0) {
            return m1280a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4836y m3175b(int i) {
        this.f20643b = i;
        m3173b(true);
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3172c();
        abstractC5373e.mo1250a(f20639d);
        abstractC5373e.mo1254a(f20640e);
        abstractC5373e.mo1258a(this.f20642a);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1254a(f20641f);
        abstractC5373e.mo1258a(this.f20643b);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3173b(boolean z) {
        this.f20644g.set(1, z);
    }

    /* renamed from: b */
    public boolean m3176b() {
        return this.f20644g.get(1);
    }

    /* renamed from: c */
    public void m3172c() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4836y)) {
            return m3178a((C4836y) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f20642a + ", pluginConfigVersion:" + this.f20643b + ")";
    }
}
