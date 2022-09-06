package com.xiaomi.xmpush.thrift;

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
/* renamed from: com.xiaomi.xmpush.thrift.ad */
/* loaded from: classes2.dex */
public class C4770ad implements Serializable, Cloneable, AbstractC5358a<C4770ad, EnumC4771a> {

    /* renamed from: d */
    public static final Map<EnumC4771a, C5360b> f19654d;

    /* renamed from: e */
    private static final C5378j f19655e = new C5378j("XmPushActionNormalConfig");

    /* renamed from: f */
    private static final C5370b f19656f = new C5370b("normalConfigs", (byte) 15, 1);

    /* renamed from: g */
    private static final C5370b f19657g = new C5370b("appId", (byte) 10, 4);

    /* renamed from: h */
    private static final C5370b f19658h = new C5370b("packageName", (byte) 11, 5);

    /* renamed from: a */
    public List<C4816n> f19659a;

    /* renamed from: b */
    public long f19660b;

    /* renamed from: c */
    public String f19661c;

    /* renamed from: i */
    private BitSet f19662i = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.ad$a */
    /* loaded from: classes2.dex */
    public enum EnumC4771a {
        NORMAL_CONFIGS(1, "normalConfigs"),
        APP_ID(4, "appId"),
        PACKAGE_NAME(5, "packageName");
        

        /* renamed from: d */
        private static final Map<String, EnumC4771a> f19666d = new HashMap();

        /* renamed from: e */
        private final short f19668e;

        /* renamed from: f */
        private final String f19669f;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4771a.class).iterator();
            while (it2.hasNext()) {
                EnumC4771a enumC4771a = (EnumC4771a) it2.next();
                f19666d.put(enumC4771a.m3709a(), enumC4771a);
            }
        }

        EnumC4771a(short s, String str) {
            this.f19668e = s;
            this.f19669f = str;
        }

        /* renamed from: a */
        public String m3709a() {
            return this.f19669f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4771a.class);
        enumMap.put((EnumMap) EnumC4771a.NORMAL_CONFIGS, (EnumC4771a) new C5360b("normalConfigs", (byte) 1, new C5362d((byte) 15, new C5365g((byte) 12, C4816n.class))));
        enumMap.put((EnumMap) EnumC4771a.APP_ID, (EnumC4771a) new C5360b("appId", (byte) 2, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4771a.PACKAGE_NAME, (EnumC4771a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        f19654d = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4770ad.class, f19654d);
    }

    /* renamed from: a */
    public List<C4816n> m3717a() {
        return this.f19659a;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3710e();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 15) {
                        C5371c mo1225m = abstractC5373e.mo1225m();
                        this.f19659a = new ArrayList(mo1225m.f22440b);
                        for (int i = 0; i < mo1225m.f22440b; i++) {
                            C4816n c4816n = new C4816n();
                            c4816n.mo1286a(abstractC5373e);
                            this.f19659a.add(c4816n);
                        }
                        abstractC5373e.mo1237n();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                case 3:
                default:
                    C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                    break;
                case 4:
                    if (mo1240i.f22437b == 10) {
                        this.f19660b = abstractC5373e.mo1231u();
                        m3715a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f19661c = abstractC5373e.mo1223w();
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
    public void m3715a(boolean z) {
        this.f19662i.set(0, z);
    }

    /* renamed from: a */
    public boolean m3716a(C4770ad c4770ad) {
        if (c4770ad == null) {
            return false;
        }
        boolean m3714b = m3714b();
        boolean m3714b2 = c4770ad.m3714b();
        if ((m3714b || m3714b2) && (!m3714b || !m3714b2 || !this.f19659a.equals(c4770ad.f19659a))) {
            return false;
        }
        boolean m3712c = m3712c();
        boolean m3712c2 = c4770ad.m3712c();
        if ((m3712c || m3712c2) && (!m3712c || !m3712c2 || this.f19660b != c4770ad.f19660b)) {
            return false;
        }
        boolean m3711d = m3711d();
        boolean m3711d2 = c4770ad.m3711d();
        return (!m3711d && !m3711d2) || (m3711d && m3711d2 && this.f19661c.equals(c4770ad.f19661c));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4770ad c4770ad) {
        int m1277a;
        int m1279a;
        int m1273a;
        if (!getClass().equals(c4770ad.getClass())) {
            return getClass().getName().compareTo(c4770ad.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3714b()).compareTo(Boolean.valueOf(c4770ad.m3714b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3714b() && (m1273a = C5366b.m1273a(this.f19659a, c4770ad.f19659a)) != 0) {
            return m1273a;
        }
        int compareTo2 = Boolean.valueOf(m3712c()).compareTo(Boolean.valueOf(c4770ad.m3712c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3712c() && (m1279a = C5366b.m1279a(this.f19660b, c4770ad.f19660b)) != 0) {
            return m1279a;
        }
        int compareTo3 = Boolean.valueOf(m3711d()).compareTo(Boolean.valueOf(c4770ad.m3711d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3711d() && (m1277a = C5366b.m1277a(this.f19661c, c4770ad.f19661c)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3710e();
        abstractC5373e.mo1250a(f19655e);
        if (this.f19659a != null) {
            abstractC5373e.mo1254a(f19656f);
            abstractC5373e.mo1253a(new C5371c((byte) 12, this.f19659a.size()));
            for (C4816n c4816n : this.f19659a) {
                c4816n.mo1285b(abstractC5373e);
            }
            abstractC5373e.mo1244e();
            abstractC5373e.mo1247b();
        }
        if (m3712c()) {
            abstractC5373e.mo1254a(f19657g);
            abstractC5373e.mo1257a(this.f19660b);
            abstractC5373e.mo1247b();
        }
        if (this.f19661c != null && m3711d()) {
            abstractC5373e.mo1254a(f19658h);
            abstractC5373e.mo1256a(this.f19661c);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3714b() {
        return this.f19659a != null;
    }

    /* renamed from: c */
    public boolean m3712c() {
        return this.f19662i.get(0);
    }

    /* renamed from: d */
    public boolean m3711d() {
        return this.f19661c != null;
    }

    /* renamed from: e */
    public void m3710e() {
        if (this.f19659a == null) {
            throw new C5374f("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4770ad)) {
            return m3716a((C4770ad) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f19659a == null) {
            sb.append("null");
        } else {
            sb.append(this.f19659a);
        }
        if (m3712c()) {
            sb.append(", ");
            sb.append("appId:");
            sb.append(this.f19660b);
        }
        if (m3711d()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19661c == null) {
                sb.append("null");
            } else {
                sb.append(this.f19661c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
