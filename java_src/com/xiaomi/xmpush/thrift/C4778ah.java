package com.xiaomi.xmpush.thrift;

import com.p219mi.live.openlivesdk.C4093a;
import java.io.Serializable;
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
import org.p248a.p283b.p284a.C5363e;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5372d;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.ah */
/* loaded from: classes2.dex */
public class C4778ah implements Serializable, Cloneable, AbstractC5358a<C4778ah, EnumC4779a> {

    /* renamed from: g */
    public static final Map<EnumC4779a, C5360b> f19823g;

    /* renamed from: h */
    private static final C5378j f19824h = new C5378j("XmPushActionSendFeedback");

    /* renamed from: i */
    private static final C5370b f19825i = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: j */
    private static final C5370b f19826j = new C5370b("target", (byte) 12, 2);

    /* renamed from: k */
    private static final C5370b f19827k = new C5370b("id", (byte) 11, 3);

    /* renamed from: l */
    private static final C5370b f19828l = new C5370b("appId", (byte) 11, 4);

    /* renamed from: m */
    private static final C5370b f19829m = new C5370b("feedbacks", (byte) 13, 5);

    /* renamed from: n */
    private static final C5370b f19830n = new C5370b("category", (byte) 11, 6);

    /* renamed from: a */
    public String f19831a;

    /* renamed from: b */
    public C4828u f19832b;

    /* renamed from: c */
    public String f19833c;

    /* renamed from: d */
    public String f19834d;

    /* renamed from: e */
    public Map<String, String> f19835e;

    /* renamed from: f */
    public String f19836f;

    /* renamed from: com.xiaomi.xmpush.thrift.ah$a */
    /* loaded from: classes2.dex */
    public enum EnumC4779a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        FEEDBACKS(5, "feedbacks"),
        CATEGORY(6, "category");
        

        /* renamed from: g */
        private static final Map<String, EnumC4779a> f19843g = new HashMap();

        /* renamed from: h */
        private final short f19845h;

        /* renamed from: i */
        private final String f19846i;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4779a.class).iterator();
            while (it2.hasNext()) {
                EnumC4779a enumC4779a = (EnumC4779a) it2.next();
                f19843g.put(enumC4779a.m3608a(), enumC4779a);
            }
        }

        EnumC4779a(short s, String str) {
            this.f19845h = s;
            this.f19846i = str;
        }

        /* renamed from: a */
        public String m3608a() {
            return this.f19846i;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4779a.class);
        enumMap.put((EnumMap) EnumC4779a.DEBUG, (EnumC4779a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4779a.TARGET, (EnumC4779a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4779a.ID, (EnumC4779a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4779a.APP_ID, (EnumC4779a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4779a.FEEDBACKS, (EnumC4779a) new C5360b("feedbacks", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4779a.CATEGORY, (EnumC4779a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        f19823g = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4778ah.class, f19823g);
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: a */
    public void mo1286a(AbstractC5373e abstractC5373e) {
        abstractC5373e.mo1242g();
        while (true) {
            C5370b mo1240i = abstractC5373e.mo1240i();
            if (mo1240i.f22437b == 0) {
                abstractC5373e.mo1241h();
                m3609g();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f19831a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f19832b = new C4828u();
                        this.f19832b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f19833c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f19834d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k = abstractC5373e.mo1226k();
                        this.f19835e = new HashMap(mo1226k.f22443c * 2);
                        for (int i = 0; i < mo1226k.f22443c; i++) {
                            this.f19835e.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 11) {
                        this.f19836f = abstractC5373e.mo1223w();
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
    public boolean m3617a() {
        return this.f19831a != null;
    }

    /* renamed from: a */
    public boolean m3616a(C4778ah c4778ah) {
        if (c4778ah == null) {
            return false;
        }
        boolean m3617a = m3617a();
        boolean m3617a2 = c4778ah.m3617a();
        if ((m3617a || m3617a2) && (!m3617a || !m3617a2 || !this.f19831a.equals(c4778ah.f19831a))) {
            return false;
        }
        boolean m3615b = m3615b();
        boolean m3615b2 = c4778ah.m3615b();
        if ((m3615b || m3615b2) && (!m3615b || !m3615b2 || !this.f19832b.m3254a(c4778ah.f19832b))) {
            return false;
        }
        boolean m3613c = m3613c();
        boolean m3613c2 = c4778ah.m3613c();
        if ((m3613c || m3613c2) && (!m3613c || !m3613c2 || !this.f19833c.equals(c4778ah.f19833c))) {
            return false;
        }
        boolean m3612d = m3612d();
        boolean m3612d2 = c4778ah.m3612d();
        if ((m3612d || m3612d2) && (!m3612d || !m3612d2 || !this.f19834d.equals(c4778ah.f19834d))) {
            return false;
        }
        boolean m3611e = m3611e();
        boolean m3611e2 = c4778ah.m3611e();
        if ((m3611e || m3611e2) && (!m3611e || !m3611e2 || !this.f19835e.equals(c4778ah.f19835e))) {
            return false;
        }
        boolean m3610f = m3610f();
        boolean m3610f2 = c4778ah.m3610f();
        return (!m3610f && !m3610f2) || (m3610f && m3610f2 && this.f19836f.equals(c4778ah.f19836f));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4778ah c4778ah) {
        int m1277a;
        int m1272a;
        int m1277a2;
        int m1277a3;
        int m1278a;
        int m1277a4;
        if (!getClass().equals(c4778ah.getClass())) {
            return getClass().getName().compareTo(c4778ah.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3617a()).compareTo(Boolean.valueOf(c4778ah.m3617a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3617a() && (m1277a4 = C5366b.m1277a(this.f19831a, c4778ah.f19831a)) != 0) {
            return m1277a4;
        }
        int compareTo2 = Boolean.valueOf(m3615b()).compareTo(Boolean.valueOf(c4778ah.m3615b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3615b() && (m1278a = C5366b.m1278a(this.f19832b, c4778ah.f19832b)) != 0) {
            return m1278a;
        }
        int compareTo3 = Boolean.valueOf(m3613c()).compareTo(Boolean.valueOf(c4778ah.m3613c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3613c() && (m1277a3 = C5366b.m1277a(this.f19833c, c4778ah.f19833c)) != 0) {
            return m1277a3;
        }
        int compareTo4 = Boolean.valueOf(m3612d()).compareTo(Boolean.valueOf(c4778ah.m3612d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3612d() && (m1277a2 = C5366b.m1277a(this.f19834d, c4778ah.f19834d)) != 0) {
            return m1277a2;
        }
        int compareTo5 = Boolean.valueOf(m3611e()).compareTo(Boolean.valueOf(c4778ah.m3611e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3611e() && (m1272a = C5366b.m1272a(this.f19835e, c4778ah.f19835e)) != 0) {
            return m1272a;
        }
        int compareTo6 = Boolean.valueOf(m3610f()).compareTo(Boolean.valueOf(c4778ah.m3610f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3610f() && (m1277a = C5366b.m1277a(this.f19836f, c4778ah.f19836f)) != 0) {
            return m1277a;
        }
        return 0;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3609g();
        abstractC5373e.mo1250a(f19824h);
        if (this.f19831a != null && m3617a()) {
            abstractC5373e.mo1254a(f19825i);
            abstractC5373e.mo1256a(this.f19831a);
            abstractC5373e.mo1247b();
        }
        if (this.f19832b != null && m3615b()) {
            abstractC5373e.mo1254a(f19826j);
            this.f19832b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19833c != null) {
            abstractC5373e.mo1254a(f19827k);
            abstractC5373e.mo1256a(this.f19833c);
            abstractC5373e.mo1247b();
        }
        if (this.f19834d != null) {
            abstractC5373e.mo1254a(f19828l);
            abstractC5373e.mo1256a(this.f19834d);
            abstractC5373e.mo1247b();
        }
        if (this.f19835e != null && m3611e()) {
            abstractC5373e.mo1254a(f19829m);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f19835e.size()));
            for (Map.Entry<String, String> entry : this.f19835e.entrySet()) {
                abstractC5373e.mo1256a(entry.getKey());
                abstractC5373e.mo1256a(entry.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        if (this.f19836f != null && m3610f()) {
            abstractC5373e.mo1254a(f19830n);
            abstractC5373e.mo1256a(this.f19836f);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public boolean m3615b() {
        return this.f19832b != null;
    }

    /* renamed from: c */
    public boolean m3613c() {
        return this.f19833c != null;
    }

    /* renamed from: d */
    public boolean m3612d() {
        return this.f19834d != null;
    }

    /* renamed from: e */
    public boolean m3611e() {
        return this.f19835e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4778ah)) {
            return m3616a((C4778ah) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3610f() {
        return this.f19836f != null;
    }

    /* renamed from: g */
    public void m3609g() {
        if (this.f19833c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f19834d != null) {
            return;
        }
        throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedback(");
        boolean z2 = true;
        if (m3617a()) {
            sb.append("debug:");
            if (this.f19831a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19831a);
            }
            z2 = false;
        }
        if (m3615b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19832b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19832b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19833c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19833c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f19834d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19834d);
        }
        if (m3611e()) {
            sb.append(", ");
            sb.append("feedbacks:");
            if (this.f19835e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19835e);
            }
        }
        if (m3610f()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f19836f == null) {
                sb.append("null");
            } else {
                sb.append(this.f19836f);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
