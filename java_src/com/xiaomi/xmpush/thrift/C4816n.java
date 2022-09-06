package com.xiaomi.xmpush.thrift;

import com.tencent.open.GameAppOperation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5366b;
import org.p248a.p283b.p284a.C5359a;
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
/* renamed from: com.xiaomi.xmpush.thrift.n */
/* loaded from: classes2.dex */
public class C4816n implements Serializable, Cloneable, AbstractC5358a<C4816n, EnumC4817a> {

    /* renamed from: d */
    public static final Map<EnumC4817a, C5360b> f20319d;

    /* renamed from: e */
    private static final C5378j f20320e = new C5378j("NormalConfig");

    /* renamed from: f */
    private static final C5370b f20321f = new C5370b(GameAppOperation.QQFAV_DATALINE_VERSION, (byte) 8, 1);

    /* renamed from: g */
    private static final C5370b f20322g = new C5370b("configItems", (byte) 15, 2);

    /* renamed from: h */
    private static final C5370b f20323h = new C5370b("type", (byte) 8, 3);

    /* renamed from: a */
    public int f20324a;

    /* renamed from: b */
    public List<C4819p> f20325b;

    /* renamed from: c */
    public EnumC4804f f20326c;

    /* renamed from: i */
    private BitSet f20327i = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.n$a */
    /* loaded from: classes2.dex */
    public enum EnumC4817a {
        VERSION(1, GameAppOperation.QQFAV_DATALINE_VERSION),
        CONFIG_ITEMS(2, "configItems"),
        TYPE(3, "type");
        

        /* renamed from: d */
        private static final Map<String, EnumC4817a> f20331d = new HashMap();

        /* renamed from: e */
        private final short f20333e;

        /* renamed from: f */
        private final String f20334f;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4817a.class).iterator();
            while (it2.hasNext()) {
                EnumC4817a enumC4817a = (EnumC4817a) it2.next();
                f20331d.put(enumC4817a.m3347a(), enumC4817a);
            }
        }

        EnumC4817a(short s, String str) {
            this.f20333e = s;
            this.f20334f = str;
        }

        /* renamed from: a */
        public String m3347a() {
            return this.f20334f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4817a.class);
        enumMap.put((EnumMap) EnumC4817a.VERSION, (EnumC4817a) new C5360b(GameAppOperation.QQFAV_DATALINE_VERSION, (byte) 1, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4817a.CONFIG_ITEMS, (EnumC4817a) new C5360b("configItems", (byte) 1, new C5362d((byte) 15, new C5365g((byte) 12, C4819p.class))));
        enumMap.put((EnumMap) EnumC4817a.TYPE, (EnumC4817a) new C5360b("type", (byte) 1, new C5359a((byte) 16, EnumC4804f.class)));
        f20319d = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4816n.class, f20319d);
    }

    /* renamed from: a */
    public int m3356a() {
        return this.f20324a;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3353b()) {
                    throw new C5374f("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m3348f();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 8) {
                        this.f20324a = abstractC5373e.mo1232t();
                        m3354a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f20325b = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            C4819p c4819p = new C4819p();
                            c4819p.mo1286a(abstractC5373e);
                            this.f20325b.add(c4819p);
                        }
                        abstractC5373e.mo1237n();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 8) {
                        this.f20326c = EnumC4804f.m3435a(abstractC5373e.mo1232t());
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
    public void m3354a(boolean z) {
        this.f20327i.set(0, z);
    }

    /* renamed from: a */
    public boolean m3355a(C4816n c4816n) {
        if (c4816n != null && this.f20324a == c4816n.f20324a) {
            boolean m3351c = m3351c();
            boolean m3351c2 = c4816n.m3351c();
            if ((m3351c || m3351c2) && (!m3351c || !m3351c2 || !this.f20325b.equals(c4816n.f20325b))) {
                return false;
            }
            boolean m3349e = m3349e();
            boolean m3349e2 = c4816n.m3349e();
            return (!m3349e && !m3349e2) || (m3349e && m3349e2 && this.f20326c.equals(c4816n.f20326c));
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4816n c4816n) {
        int m1278a;
        int m1273a;
        int m1280a;
        if (!getClass().equals(c4816n.getClass())) {
            return getClass().getName().compareTo(c4816n.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3353b()).compareTo(Boolean.valueOf(c4816n.m3353b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3353b() && (m1280a = C5366b.m1280a(this.f20324a, c4816n.f20324a)) != 0) {
            return m1280a;
        }
        int compareTo2 = Boolean.valueOf(m3351c()).compareTo(Boolean.valueOf(c4816n.m3351c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3351c() && (m1273a = C5366b.m1273a(this.f20325b, c4816n.f20325b)) != 0) {
            return m1273a;
        }
        int compareTo3 = Boolean.valueOf(m3349e()).compareTo(Boolean.valueOf(c4816n.m3349e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3349e() && (m1278a = C5366b.m1278a(this.f20326c, c4816n.f20326c)) != 0) {
            return m1278a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3348f();
        abstractC5373e.mo1250a(f20320e);
        abstractC5373e.mo1254a(f20321f);
        abstractC5373e.mo1258a(this.f20324a);
        abstractC5373e.mo1247b();
        if (this.f20325b != null) {
            abstractC5373e.mo1254a(f20322g);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f20325b.size()));
            for (C4819p c4819p : this.f20325b) {
                c4819p.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        if (this.f20326c != null) {
            abstractC5373e.mo1254a(f20323h);
            abstractC5373e.mo1258a(this.f20326c.m3436a());
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3353b() {
        return this.f20327i.get(0);
    }

    /* renamed from: c */
    public boolean m3351c() {
        return this.f20325b != null;
    }

    /* renamed from: d */
    public EnumC4804f m3350d() {
        return this.f20326c;
    }

    /* renamed from: e */
    public boolean m3349e() {
        return this.f20326c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4816n)) {
            return m3355a((C4816n) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void m3348f() {
        if (this.f20325b == null) {
            throw new C5374f("Required field 'configItems' was not present! Struct: " + toString());
        }
        if (this.f20326c != null) {
            return;
        }
        throw new C5374f("Required field 'type' was not present! Struct: " + toString());
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f20324a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f20325b == null) {
            sb.append("null");
        } else {
            sb.append(this.f20325b);
        }
        sb.append(", ");
        sb.append("type:");
        if (this.f20326c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20326c);
        }
        sb.append(")");
        return sb.toString();
    }
}
