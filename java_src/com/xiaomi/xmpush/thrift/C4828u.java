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
/* renamed from: com.xiaomi.xmpush.thrift.u */
/* loaded from: classes2.dex */
public class C4828u implements Serializable, Cloneable, AbstractC5358a<C4828u, EnumC4829a> {

    /* renamed from: f */
    public static final Map<EnumC4829a, C5360b> f20493f;

    /* renamed from: g */
    private static final C5378j f20494g = new C5378j("Target");

    /* renamed from: h */
    private static final C5370b f20495h = new C5370b("channelId", (byte) 10, 1);

    /* renamed from: i */
    private static final C5370b f20496i = new C5370b("userId", (byte) 11, 2);

    /* renamed from: j */
    private static final C5370b f20497j = new C5370b("server", (byte) 11, 3);

    /* renamed from: k */
    private static final C5370b f20498k = new C5370b("resource", (byte) 11, 4);

    /* renamed from: l */
    private static final C5370b f20499l = new C5370b("isPreview", (byte) 2, 5);

    /* renamed from: b */
    public String f20501b;

    /* renamed from: m */
    private BitSet f20505m = new BitSet(2);

    /* renamed from: a */
    public long f20500a = 5;

    /* renamed from: c */
    public String f20502c = "xiaomi.com";

    /* renamed from: d */
    public String f20503d = "";

    /* renamed from: e */
    public boolean f20504e = false;

    /* renamed from: com.xiaomi.xmpush.thrift.u$a */
    /* loaded from: classes2.dex */
    public enum EnumC4829a {
        CHANNEL_ID(1, "channelId"),
        USER_ID(2, "userId"),
        SERVER(3, "server"),
        RESOURCE(4, "resource"),
        IS_PREVIEW(5, "isPreview");
        

        /* renamed from: f */
        private static final Map<String, EnumC4829a> f20511f = new HashMap();

        /* renamed from: g */
        private final short f20513g;

        /* renamed from: h */
        private final String f20514h;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4829a.class).iterator();
            while (it2.hasNext()) {
                EnumC4829a enumC4829a = (EnumC4829a) it2.next();
                f20511f.put(enumC4829a.m3245a(), enumC4829a);
            }
        }

        EnumC4829a(short s, String str) {
            this.f20513g = s;
            this.f20514h = str;
        }

        /* renamed from: a */
        public String m3245a() {
            return this.f20514h;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4829a.class);
        enumMap.put((EnumMap) EnumC4829a.CHANNEL_ID, (EnumC4829a) new C5360b("channelId", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4829a.USER_ID, (EnumC4829a) new C5360b("userId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4829a.SERVER, (EnumC4829a) new C5360b("server", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4829a.RESOURCE, (EnumC4829a) new C5360b("resource", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4829a.IS_PREVIEW, (EnumC4829a) new C5360b("isPreview", (byte) 2, new C5361c((byte) 2)));
        f20493f = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4828u.class, f20493f);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                if (!m3255a()) {
                    throw new C5374f("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                m3246f();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b != 10) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20500a = abstractC5373e.mo1231u();
                        m3253a(true);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20501b = abstractC5373e.mo1223w();
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20502c = abstractC5373e.mo1223w();
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b != 11) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20503d = abstractC5373e.mo1223w();
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b != 2) {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    } else {
                        this.f20504e = abstractC5373e.mo1235q();
                        m3250b(true);
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
    public void m3253a(boolean z) {
        this.f20505m.set(0, z);
    }

    /* renamed from: a */
    public boolean m3255a() {
        return this.f20505m.get(0);
    }

    /* renamed from: a */
    public boolean m3254a(C4828u c4828u) {
        if (c4828u != null && this.f20500a == c4828u.f20500a) {
            boolean m3252b = m3252b();
            boolean m3252b2 = c4828u.m3252b();
            if ((m3252b || m3252b2) && (!m3252b || !m3252b2 || !this.f20501b.equals(c4828u.f20501b))) {
                return false;
            }
            boolean m3249c = m3249c();
            boolean m3249c2 = c4828u.m3249c();
            if ((m3249c || m3249c2) && (!m3249c || !m3249c2 || !this.f20502c.equals(c4828u.f20502c))) {
                return false;
            }
            boolean m3248d = m3248d();
            boolean m3248d2 = c4828u.m3248d();
            if ((m3248d || m3248d2) && (!m3248d || !m3248d2 || !this.f20503d.equals(c4828u.f20503d))) {
                return false;
            }
            boolean m3247e = m3247e();
            boolean m3247e2 = c4828u.m3247e();
            return (!m3247e && !m3247e2) || (m3247e && m3247e2 && this.f20504e == c4828u.f20504e);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4828u c4828u) {
        int m1269a;
        int m1277a;
        int m1277a2;
        int m1277a3;
        int m1279a;
        if (!getClass().equals(c4828u.getClass())) {
            return getClass().getName().compareTo(c4828u.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3255a()).compareTo(Boolean.valueOf(c4828u.m3255a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3255a() && (m1279a = C5366b.m1279a(this.f20500a, c4828u.f20500a)) != 0) {
            return m1279a;
        }
        int compareTo2 = Boolean.valueOf(m3252b()).compareTo(Boolean.valueOf(c4828u.m3252b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3252b() && (m1277a3 = C5366b.m1277a(this.f20501b, c4828u.f20501b)) != 0) {
            return m1277a3;
        }
        int compareTo3 = Boolean.valueOf(m3249c()).compareTo(Boolean.valueOf(c4828u.m3249c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3249c() && (m1277a2 = C5366b.m1277a(this.f20502c, c4828u.f20502c)) != 0) {
            return m1277a2;
        }
        int compareTo4 = Boolean.valueOf(m3248d()).compareTo(Boolean.valueOf(c4828u.m3248d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3248d() && (m1277a = C5366b.m1277a(this.f20503d, c4828u.f20503d)) != 0) {
            return m1277a;
        }
        int compareTo5 = Boolean.valueOf(m3247e()).compareTo(Boolean.valueOf(c4828u.m3247e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3247e() && (m1269a = C5366b.m1269a(this.f20504e, c4828u.f20504e)) != 0) {
            return m1269a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3246f();
        abstractC5373e.mo1250a(f20494g);
        abstractC5373e.mo1254a(f20495h);
        abstractC5373e.mo1257a(this.f20500a);
        abstractC5373e.mo1247b();
        if (this.f20501b != null) {
            abstractC5373e.mo1254a(f20496i);
            abstractC5373e.mo1256a(this.f20501b);
            abstractC5373e.mo1247b();
        }
        if (this.f20502c != null && m3249c()) {
            abstractC5373e.mo1254a(f20497j);
            abstractC5373e.mo1256a(this.f20502c);
            abstractC5373e.mo1247b();
        }
        if (this.f20503d != null && m3248d()) {
            abstractC5373e.mo1254a(f20498k);
            abstractC5373e.mo1256a(this.f20503d);
            abstractC5373e.mo1247b();
        }
        if (m3247e()) {
            abstractC5373e.mo1254a(f20499l);
            abstractC5373e.mo1248a(this.f20504e);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3250b(boolean z) {
        this.f20505m.set(1, z);
    }

    /* renamed from: b */
    public boolean m3252b() {
        return this.f20501b != null;
    }

    /* renamed from: c */
    public boolean m3249c() {
        return this.f20502c != null;
    }

    /* renamed from: d */
    public boolean m3248d() {
        return this.f20503d != null;
    }

    /* renamed from: e */
    public boolean m3247e() {
        return this.f20505m.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4828u)) {
            return m3254a((C4828u) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void m3246f() {
        if (this.f20501b == null) {
            throw new C5374f("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f20500a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f20501b == null) {
            sb.append("null");
        } else {
            sb.append(this.f20501b);
        }
        if (m3249c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f20502c == null) {
                sb.append("null");
            } else {
                sb.append(this.f20502c);
            }
        }
        if (m3248d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f20503d == null) {
                sb.append("null");
            } else {
                sb.append(this.f20503d);
            }
        }
        if (m3247e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f20504e);
        }
        sb.append(")");
        return sb.toString();
    }
}
