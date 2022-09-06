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
/* renamed from: com.xiaomi.xmpush.thrift.b */
/* loaded from: classes2.dex */
public class C4797b implements Serializable, Cloneable, AbstractC5358a<C4797b, EnumC4798a> {

    /* renamed from: c */
    public static final Map<EnumC4798a, C5360b> f20116c;

    /* renamed from: d */
    private static final C5378j f20117d = new C5378j("Cellular");

    /* renamed from: e */
    private static final C5370b f20118e = new C5370b("id", (byte) 8, 1);

    /* renamed from: f */
    private static final C5370b f20119f = new C5370b("signalStrength", (byte) 8, 2);

    /* renamed from: a */
    public int f20120a;

    /* renamed from: b */
    public int f20121b;

    /* renamed from: g */
    private BitSet f20122g = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.b$a */
    /* loaded from: classes2.dex */
    public enum EnumC4798a {
        ID(1, "id"),
        SIGNAL_STRENGTH(2, "signalStrength");
        

        /* renamed from: c */
        private static final Map<String, EnumC4798a> f20125c = new HashMap();

        /* renamed from: d */
        private final short f20127d;

        /* renamed from: e */
        private final String f20128e;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4798a.class).iterator();
            while (it2.hasNext()) {
                EnumC4798a enumC4798a = (EnumC4798a) it2.next();
                f20125c.put(enumC4798a.m3459a(), enumC4798a);
            }
        }

        EnumC4798a(short s, String str) {
            this.f20127d = s;
            this.f20128e = str;
        }

        /* renamed from: a */
        public String m3459a() {
            return this.f20128e;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4798a.class);
        enumMap.put((EnumMap) EnumC4798a.ID, (EnumC4798a) new C5360b("id", (byte) 1, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4798a.SIGNAL_STRENGTH, (EnumC4798a) new C5360b("signalStrength", (byte) 1, new C5361c((byte) 8)));
        f20116c = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4797b.class, f20116c);
    }

    /* renamed from: a */
    public C4797b m3467a(int i) {
        this.f20120a = i;
        m3465a(true);
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
                if (!m3468a()) {
                    throw new C5374f("Required field 'id' was not found in serialized data! Struct: " + toString());
                }
                if (!m3464b()) {
                    throw new C5374f("Required field 'signalStrength' was not found in serialized data! Struct: " + toString());
                }
                m3460c();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20120a = abstractC5373e.mo1232t();
                        m3465a(true);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 8) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20121b = abstractC5373e.mo1232t();
                        m3461b(true);
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
    public void m3465a(boolean z) {
        this.f20122g.set(0, z);
    }

    /* renamed from: a */
    public boolean m3468a() {
        return this.f20122g.get(0);
    }

    /* renamed from: a */
    public boolean m3466a(C4797b c4797b) {
        return c4797b != null && this.f20120a == c4797b.f20120a && this.f20121b == c4797b.f20121b;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4797b c4797b) {
        int m1280a;
        int m1280a2;
        if (!getClass().equals(c4797b.getClass())) {
            return getClass().getName().compareTo(c4797b.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3468a()).compareTo(Boolean.valueOf(c4797b.m3468a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3468a() && (m1280a2 = C5366b.m1280a(this.f20120a, c4797b.f20120a)) != 0) {
            return m1280a2;
        }
        int compareTo2 = Boolean.valueOf(m3464b()).compareTo(Boolean.valueOf(c4797b.m3464b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3464b() && (m1280a = C5366b.m1280a(this.f20121b, c4797b.f20121b)) != 0) {
            return m1280a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4797b m3463b(int i) {
        this.f20121b = i;
        m3461b(true);
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3460c();
        abstractC5373e.mo1250a(f20117d);
        abstractC5373e.mo1254a(f20118e);
        abstractC5373e.mo1258a(this.f20120a);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1254a(f20119f);
        abstractC5373e.mo1258a(this.f20121b);
        abstractC5373e.mo1247b();
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3461b(boolean z) {
        this.f20122g.set(1, z);
    }

    /* renamed from: b */
    public boolean m3464b() {
        return this.f20122g.get(1);
    }

    /* renamed from: c */
    public void m3460c() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4797b)) {
            return m3466a((C4797b) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Cellular(id:" + this.f20120a + ", signalStrength:" + this.f20121b + ")";
    }
}
