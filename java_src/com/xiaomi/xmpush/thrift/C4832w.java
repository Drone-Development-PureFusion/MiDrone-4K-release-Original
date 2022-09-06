package com.xiaomi.xmpush.thrift;

import com.fimi.soul.utils.p211a.C3628c;
import com.p219mi.live.openlivesdk.C4093a;
import com.tencent.open.SocialConstants;
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
import org.p248a.p283b.p284a.C5363e;
import org.p248a.p283b.p284a.C5365g;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5370b;
import org.p248a.p283b.p285b.C5372d;
import org.p248a.p283b.p285b.C5374f;
import org.p248a.p283b.p285b.C5376h;
import org.p248a.p283b.p285b.C5378j;
/* renamed from: com.xiaomi.xmpush.thrift.w */
/* loaded from: classes2.dex */
public class C4832w implements Serializable, Cloneable, AbstractC5358a<C4832w, EnumC4833a> {

    /* renamed from: u */
    public static final Map<EnumC4833a, C5360b> f20547u;

    /* renamed from: a */
    public String f20554a;

    /* renamed from: b */
    public C4828u f20555b;

    /* renamed from: c */
    public String f20556c;

    /* renamed from: d */
    public String f20557d;

    /* renamed from: e */
    public long f20558e;

    /* renamed from: f */
    public String f20559f;

    /* renamed from: g */
    public String f20560g;

    /* renamed from: h */
    public C4782aj f20561h;

    /* renamed from: i */
    public String f20562i;

    /* renamed from: j */
    public String f20563j;

    /* renamed from: l */
    public String f20565l;

    /* renamed from: m */
    public String f20566m;

    /* renamed from: n */
    public String f20567n;

    /* renamed from: o */
    public short f20568o;

    /* renamed from: p */
    public short f20569p;

    /* renamed from: q */
    public String f20570q;

    /* renamed from: r */
    public String f20571r;

    /* renamed from: s */
    public int f20572s;

    /* renamed from: t */
    public Map<String, String> f20573t;

    /* renamed from: v */
    private static final C5378j f20548v = new C5378j("XmPushActionAckMessage");

    /* renamed from: w */
    private static final C5370b f20549w = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: x */
    private static final C5370b f20550x = new C5370b("target", (byte) 12, 2);

    /* renamed from: y */
    private static final C5370b f20551y = new C5370b("id", (byte) 11, 3);

    /* renamed from: z */
    private static final C5370b f20552z = new C5370b("appId", (byte) 11, 4);

    /* renamed from: A */
    private static final C5370b f20531A = new C5370b("messageTs", (byte) 10, 5);

    /* renamed from: B */
    private static final C5370b f20532B = new C5370b("topic", (byte) 11, 6);

    /* renamed from: C */
    private static final C5370b f20533C = new C5370b("aliasName", (byte) 11, 7);

    /* renamed from: D */
    private static final C5370b f20534D = new C5370b(SocialConstants.TYPE_REQUEST, (byte) 12, 8);

    /* renamed from: E */
    private static final C5370b f20535E = new C5370b("packageName", (byte) 11, 9);

    /* renamed from: F */
    private static final C5370b f20536F = new C5370b("category", (byte) 11, 10);

    /* renamed from: G */
    private static final C5370b f20537G = new C5370b("isOnline", (byte) 2, 11);

    /* renamed from: H */
    private static final C5370b f20538H = new C5370b("regId", (byte) 11, 12);

    /* renamed from: I */
    private static final C5370b f20539I = new C5370b("callbackUrl", (byte) 11, 13);

    /* renamed from: J */
    private static final C5370b f20540J = new C5370b("userAccount", (byte) 11, 14);

    /* renamed from: K */
    private static final C5370b f20541K = new C5370b("deviceStatus", (byte) 6, 15);

    /* renamed from: L */
    private static final C5370b f20542L = new C5370b("geoMsgStatus", (byte) 6, 16);

    /* renamed from: M */
    private static final C5370b f20543M = new C5370b("imeiMd5", (byte) 11, 20);

    /* renamed from: N */
    private static final C5370b f20544N = new C5370b("deviceId", (byte) 11, 21);

    /* renamed from: O */
    private static final C5370b f20545O = new C5370b(C3628c.C3629a.f14773f, (byte) 8, 22);

    /* renamed from: P */
    private static final C5370b f20546P = new C5370b("extra", (byte) 13, 23);

    /* renamed from: Q */
    private BitSet f20553Q = new BitSet(5);

    /* renamed from: k */
    public boolean f20564k = false;

    /* renamed from: com.xiaomi.xmpush.thrift.w$a */
    /* loaded from: classes2.dex */
    public enum EnumC4833a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        MESSAGE_TS(5, "messageTs"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        REQUEST(8, SocialConstants.TYPE_REQUEST),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category"),
        IS_ONLINE(11, "isOnline"),
        REG_ID(12, "regId"),
        CALLBACK_URL(13, "callbackUrl"),
        USER_ACCOUNT(14, "userAccount"),
        DEVICE_STATUS(15, "deviceStatus"),
        GEO_MSG_STATUS(16, "geoMsgStatus"),
        IMEI_MD5(20, "imeiMd5"),
        DEVICE_ID(21, "deviceId"),
        PASS_THROUGH(22, C3628c.C3629a.f14773f),
        EXTRA(23, "extra");
        

        /* renamed from: u */
        private static final Map<String, EnumC4833a> f20594u = new HashMap();

        /* renamed from: v */
        private final short f20596v;

        /* renamed from: w */
        private final String f20597w;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4833a.class).iterator();
            while (it2.hasNext()) {
                EnumC4833a enumC4833a = (EnumC4833a) it2.next();
                f20594u.put(enumC4833a.m3198a(), enumC4833a);
            }
        }

        EnumC4833a(short s, String str) {
            this.f20596v = s;
            this.f20597w = str;
        }

        /* renamed from: a */
        public String m3198a() {
            return this.f20597w;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4833a.class);
        enumMap.put((EnumMap) EnumC4833a.DEBUG, (EnumC4833a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.TARGET, (EnumC4833a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4833a.ID, (EnumC4833a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.APP_ID, (EnumC4833a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.MESSAGE_TS, (EnumC4833a) new C5360b("messageTs", (byte) 1, new C5361c((byte) 10)));
        enumMap.put((EnumMap) EnumC4833a.TOPIC, (EnumC4833a) new C5360b("topic", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.ALIAS_NAME, (EnumC4833a) new C5360b("aliasName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.REQUEST, (EnumC4833a) new C5360b(SocialConstants.TYPE_REQUEST, (byte) 2, new C5365g((byte) 12, C4782aj.class)));
        enumMap.put((EnumMap) EnumC4833a.PACKAGE_NAME, (EnumC4833a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.CATEGORY, (EnumC4833a) new C5360b("category", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.IS_ONLINE, (EnumC4833a) new C5360b("isOnline", (byte) 2, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4833a.REG_ID, (EnumC4833a) new C5360b("regId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.CALLBACK_URL, (EnumC4833a) new C5360b("callbackUrl", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.USER_ACCOUNT, (EnumC4833a) new C5360b("userAccount", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.DEVICE_STATUS, (EnumC4833a) new C5360b("deviceStatus", (byte) 2, new C5361c((byte) 6)));
        enumMap.put((EnumMap) EnumC4833a.GEO_MSG_STATUS, (EnumC4833a) new C5360b("geoMsgStatus", (byte) 2, new C5361c((byte) 6)));
        enumMap.put((EnumMap) EnumC4833a.IMEI_MD5, (EnumC4833a) new C5360b("imeiMd5", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.DEVICE_ID, (EnumC4833a) new C5360b("deviceId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4833a.PASS_THROUGH, (EnumC4833a) new C5360b(C3628c.C3629a.f14773f, (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4833a.EXTRA, (EnumC4833a) new C5360b("extra", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        f20547u = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4832w.class, f20547u);
    }

    /* renamed from: a */
    public C4832w m3232a(long j) {
        this.f20558e = j;
        m3228a(true);
        return this;
    }

    /* renamed from: a */
    public C4832w m3230a(String str) {
        this.f20556c = str;
        return this;
    }

    /* renamed from: a */
    public C4832w m3229a(short s) {
        this.f20568o = s;
        m3220c(true);
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
                if (!m3216e()) {
                    throw new C5374f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m3199u();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f20554a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f20555b = new C4828u();
                        this.f20555b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f20556c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f20557d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 10) {
                        this.f20558e = abstractC5373e.mo1231u();
                        m3228a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 11) {
                        this.f20559f = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 11) {
                        this.f20560g = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b == 12) {
                        this.f20561h = new C4782aj();
                        this.f20561h.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b == 11) {
                        this.f20562i = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 11) {
                        this.f20563j = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                    if (mo1240i.f22437b == 2) {
                        this.f20564k = abstractC5373e.mo1235q();
                        m3223b(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 12:
                    if (mo1240i.f22437b == 11) {
                        this.f20565l = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 13:
                    if (mo1240i.f22437b == 11) {
                        this.f20566m = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 14:
                    if (mo1240i.f22437b == 11) {
                        this.f20567n = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 15:
                    if (mo1240i.f22437b == 6) {
                        this.f20568o = abstractC5373e.mo1233s();
                        m3220c(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 16:
                    if (mo1240i.f22437b == 6) {
                        this.f20569p = abstractC5373e.mo1233s();
                        m3217d(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                    break;
                case 20:
                    if (mo1240i.f22437b == 11) {
                        this.f20570q = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 21:
                    if (mo1240i.f22437b == 11) {
                        this.f20571r = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 22:
                    if (mo1240i.f22437b == 8) {
                        this.f20572s = abstractC5373e.mo1232t();
                        m3215e(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 23:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k = abstractC5373e.mo1226k();
                        this.f20573t = new HashMap(mo1226k.f22443c * 2);
                        for (int i = 0; i < mo1226k.f22443c; i++) {
                            this.f20573t.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
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
    public void m3228a(boolean z) {
        this.f20553Q.set(0, z);
    }

    /* renamed from: a */
    public boolean m3233a() {
        return this.f20554a != null;
    }

    /* renamed from: a */
    public boolean m3231a(C4832w c4832w) {
        if (c4832w == null) {
            return false;
        }
        boolean m3233a = m3233a();
        boolean m3233a2 = c4832w.m3233a();
        if ((m3233a || m3233a2) && (!m3233a || !m3233a2 || !this.f20554a.equals(c4832w.f20554a))) {
            return false;
        }
        boolean m3227b = m3227b();
        boolean m3227b2 = c4832w.m3227b();
        if ((m3227b || m3227b2) && (!m3227b || !m3227b2 || !this.f20555b.m3254a(c4832w.f20555b))) {
            return false;
        }
        boolean m3222c = m3222c();
        boolean m3222c2 = c4832w.m3222c();
        if ((m3222c || m3222c2) && (!m3222c || !m3222c2 || !this.f20556c.equals(c4832w.f20556c))) {
            return false;
        }
        boolean m3219d = m3219d();
        boolean m3219d2 = c4832w.m3219d();
        if (((m3219d || m3219d2) && (!m3219d || !m3219d2 || !this.f20557d.equals(c4832w.f20557d))) || this.f20558e != c4832w.f20558e) {
            return false;
        }
        boolean m3214f = m3214f();
        boolean m3214f2 = c4832w.m3214f();
        if ((m3214f || m3214f2) && (!m3214f || !m3214f2 || !this.f20559f.equals(c4832w.f20559f))) {
            return false;
        }
        boolean m3213g = m3213g();
        boolean m3213g2 = c4832w.m3213g();
        if ((m3213g || m3213g2) && (!m3213g || !m3213g2 || !this.f20560g.equals(c4832w.f20560g))) {
            return false;
        }
        boolean m3212h = m3212h();
        boolean m3212h2 = c4832w.m3212h();
        if ((m3212h || m3212h2) && (!m3212h || !m3212h2 || !this.f20561h.m3593a(c4832w.f20561h))) {
            return false;
        }
        boolean m3211i = m3211i();
        boolean m3211i2 = c4832w.m3211i();
        if ((m3211i || m3211i2) && (!m3211i || !m3211i2 || !this.f20562i.equals(c4832w.f20562i))) {
            return false;
        }
        boolean m3210j = m3210j();
        boolean m3210j2 = c4832w.m3210j();
        if ((m3210j || m3210j2) && (!m3210j || !m3210j2 || !this.f20563j.equals(c4832w.f20563j))) {
            return false;
        }
        boolean m3209k = m3209k();
        boolean m3209k2 = c4832w.m3209k();
        if ((m3209k || m3209k2) && (!m3209k || !m3209k2 || this.f20564k != c4832w.f20564k)) {
            return false;
        }
        boolean m3208l = m3208l();
        boolean m3208l2 = c4832w.m3208l();
        if ((m3208l || m3208l2) && (!m3208l || !m3208l2 || !this.f20565l.equals(c4832w.f20565l))) {
            return false;
        }
        boolean m3207m = m3207m();
        boolean m3207m2 = c4832w.m3207m();
        if ((m3207m || m3207m2) && (!m3207m || !m3207m2 || !this.f20566m.equals(c4832w.f20566m))) {
            return false;
        }
        boolean m3206n = m3206n();
        boolean m3206n2 = c4832w.m3206n();
        if ((m3206n || m3206n2) && (!m3206n || !m3206n2 || !this.f20567n.equals(c4832w.f20567n))) {
            return false;
        }
        boolean m3205o = m3205o();
        boolean m3205o2 = c4832w.m3205o();
        if ((m3205o || m3205o2) && (!m3205o || !m3205o2 || this.f20568o != c4832w.f20568o)) {
            return false;
        }
        boolean m3204p = m3204p();
        boolean m3204p2 = c4832w.m3204p();
        if ((m3204p || m3204p2) && (!m3204p || !m3204p2 || this.f20569p != c4832w.f20569p)) {
            return false;
        }
        boolean m3203q = m3203q();
        boolean m3203q2 = c4832w.m3203q();
        if ((m3203q || m3203q2) && (!m3203q || !m3203q2 || !this.f20570q.equals(c4832w.f20570q))) {
            return false;
        }
        boolean m3202r = m3202r();
        boolean m3202r2 = c4832w.m3202r();
        if ((m3202r || m3202r2) && (!m3202r || !m3202r2 || !this.f20571r.equals(c4832w.f20571r))) {
            return false;
        }
        boolean m3201s = m3201s();
        boolean m3201s2 = c4832w.m3201s();
        if ((m3201s || m3201s2) && (!m3201s || !m3201s2 || this.f20572s != c4832w.f20572s)) {
            return false;
        }
        boolean m3200t = m3200t();
        boolean m3200t2 = c4832w.m3200t();
        return (!m3200t && !m3200t2) || (m3200t && m3200t2 && this.f20573t.equals(c4832w.f20573t));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4832w c4832w) {
        int m1272a;
        int m1280a;
        int m1277a;
        int m1277a2;
        int m1270a;
        int m1270a2;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1269a;
        int m1277a6;
        int m1277a7;
        int m1278a;
        int m1277a8;
        int m1277a9;
        int m1279a;
        int m1277a10;
        int m1277a11;
        int m1278a2;
        int m1277a12;
        if (!getClass().equals(c4832w.getClass())) {
            return getClass().getName().compareTo(c4832w.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3233a()).compareTo(Boolean.valueOf(c4832w.m3233a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3233a() && (m1277a12 = C5366b.m1277a(this.f20554a, c4832w.f20554a)) != 0) {
            return m1277a12;
        }
        int compareTo2 = Boolean.valueOf(m3227b()).compareTo(Boolean.valueOf(c4832w.m3227b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3227b() && (m1278a2 = C5366b.m1278a(this.f20555b, c4832w.f20555b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3222c()).compareTo(Boolean.valueOf(c4832w.m3222c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3222c() && (m1277a11 = C5366b.m1277a(this.f20556c, c4832w.f20556c)) != 0) {
            return m1277a11;
        }
        int compareTo4 = Boolean.valueOf(m3219d()).compareTo(Boolean.valueOf(c4832w.m3219d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3219d() && (m1277a10 = C5366b.m1277a(this.f20557d, c4832w.f20557d)) != 0) {
            return m1277a10;
        }
        int compareTo5 = Boolean.valueOf(m3216e()).compareTo(Boolean.valueOf(c4832w.m3216e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3216e() && (m1279a = C5366b.m1279a(this.f20558e, c4832w.f20558e)) != 0) {
            return m1279a;
        }
        int compareTo6 = Boolean.valueOf(m3214f()).compareTo(Boolean.valueOf(c4832w.m3214f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3214f() && (m1277a9 = C5366b.m1277a(this.f20559f, c4832w.f20559f)) != 0) {
            return m1277a9;
        }
        int compareTo7 = Boolean.valueOf(m3213g()).compareTo(Boolean.valueOf(c4832w.m3213g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3213g() && (m1277a8 = C5366b.m1277a(this.f20560g, c4832w.f20560g)) != 0) {
            return m1277a8;
        }
        int compareTo8 = Boolean.valueOf(m3212h()).compareTo(Boolean.valueOf(c4832w.m3212h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3212h() && (m1278a = C5366b.m1278a(this.f20561h, c4832w.f20561h)) != 0) {
            return m1278a;
        }
        int compareTo9 = Boolean.valueOf(m3211i()).compareTo(Boolean.valueOf(c4832w.m3211i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3211i() && (m1277a7 = C5366b.m1277a(this.f20562i, c4832w.f20562i)) != 0) {
            return m1277a7;
        }
        int compareTo10 = Boolean.valueOf(m3210j()).compareTo(Boolean.valueOf(c4832w.m3210j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3210j() && (m1277a6 = C5366b.m1277a(this.f20563j, c4832w.f20563j)) != 0) {
            return m1277a6;
        }
        int compareTo11 = Boolean.valueOf(m3209k()).compareTo(Boolean.valueOf(c4832w.m3209k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3209k() && (m1269a = C5366b.m1269a(this.f20564k, c4832w.f20564k)) != 0) {
            return m1269a;
        }
        int compareTo12 = Boolean.valueOf(m3208l()).compareTo(Boolean.valueOf(c4832w.m3208l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m3208l() && (m1277a5 = C5366b.m1277a(this.f20565l, c4832w.f20565l)) != 0) {
            return m1277a5;
        }
        int compareTo13 = Boolean.valueOf(m3207m()).compareTo(Boolean.valueOf(c4832w.m3207m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m3207m() && (m1277a4 = C5366b.m1277a(this.f20566m, c4832w.f20566m)) != 0) {
            return m1277a4;
        }
        int compareTo14 = Boolean.valueOf(m3206n()).compareTo(Boolean.valueOf(c4832w.m3206n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m3206n() && (m1277a3 = C5366b.m1277a(this.f20567n, c4832w.f20567n)) != 0) {
            return m1277a3;
        }
        int compareTo15 = Boolean.valueOf(m3205o()).compareTo(Boolean.valueOf(c4832w.m3205o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m3205o() && (m1270a2 = C5366b.m1270a(this.f20568o, c4832w.f20568o)) != 0) {
            return m1270a2;
        }
        int compareTo16 = Boolean.valueOf(m3204p()).compareTo(Boolean.valueOf(c4832w.m3204p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m3204p() && (m1270a = C5366b.m1270a(this.f20569p, c4832w.f20569p)) != 0) {
            return m1270a;
        }
        int compareTo17 = Boolean.valueOf(m3203q()).compareTo(Boolean.valueOf(c4832w.m3203q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m3203q() && (m1277a2 = C5366b.m1277a(this.f20570q, c4832w.f20570q)) != 0) {
            return m1277a2;
        }
        int compareTo18 = Boolean.valueOf(m3202r()).compareTo(Boolean.valueOf(c4832w.m3202r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m3202r() && (m1277a = C5366b.m1277a(this.f20571r, c4832w.f20571r)) != 0) {
            return m1277a;
        }
        int compareTo19 = Boolean.valueOf(m3201s()).compareTo(Boolean.valueOf(c4832w.m3201s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m3201s() && (m1280a = C5366b.m1280a(this.f20572s, c4832w.f20572s)) != 0) {
            return m1280a;
        }
        int compareTo20 = Boolean.valueOf(m3200t()).compareTo(Boolean.valueOf(c4832w.m3200t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (m3200t() && (m1272a = C5366b.m1272a(this.f20573t, c4832w.f20573t)) != 0) {
            return m1272a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4832w m3225b(String str) {
        this.f20557d = str;
        return this;
    }

    /* renamed from: b */
    public C4832w m3224b(short s) {
        this.f20569p = s;
        m3217d(true);
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3199u();
        abstractC5373e.mo1250a(f20548v);
        if (this.f20554a != null && m3233a()) {
            abstractC5373e.mo1254a(f20549w);
            abstractC5373e.mo1256a(this.f20554a);
            abstractC5373e.mo1247b();
        }
        if (this.f20555b != null && m3227b()) {
            abstractC5373e.mo1254a(f20550x);
            this.f20555b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20556c != null) {
            abstractC5373e.mo1254a(f20551y);
            abstractC5373e.mo1256a(this.f20556c);
            abstractC5373e.mo1247b();
        }
        if (this.f20557d != null) {
            abstractC5373e.mo1254a(f20552z);
            abstractC5373e.mo1256a(this.f20557d);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1254a(f20531A);
        abstractC5373e.mo1257a(this.f20558e);
        abstractC5373e.mo1247b();
        if (this.f20559f != null && m3214f()) {
            abstractC5373e.mo1254a(f20532B);
            abstractC5373e.mo1256a(this.f20559f);
            abstractC5373e.mo1247b();
        }
        if (this.f20560g != null && m3213g()) {
            abstractC5373e.mo1254a(f20533C);
            abstractC5373e.mo1256a(this.f20560g);
            abstractC5373e.mo1247b();
        }
        if (this.f20561h != null && m3212h()) {
            abstractC5373e.mo1254a(f20534D);
            this.f20561h.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f20562i != null && m3211i()) {
            abstractC5373e.mo1254a(f20535E);
            abstractC5373e.mo1256a(this.f20562i);
            abstractC5373e.mo1247b();
        }
        if (this.f20563j != null && m3210j()) {
            abstractC5373e.mo1254a(f20536F);
            abstractC5373e.mo1256a(this.f20563j);
            abstractC5373e.mo1247b();
        }
        if (m3209k()) {
            abstractC5373e.mo1254a(f20537G);
            abstractC5373e.mo1248a(this.f20564k);
            abstractC5373e.mo1247b();
        }
        if (this.f20565l != null && m3208l()) {
            abstractC5373e.mo1254a(f20538H);
            abstractC5373e.mo1256a(this.f20565l);
            abstractC5373e.mo1247b();
        }
        if (this.f20566m != null && m3207m()) {
            abstractC5373e.mo1254a(f20539I);
            abstractC5373e.mo1256a(this.f20566m);
            abstractC5373e.mo1247b();
        }
        if (this.f20567n != null && m3206n()) {
            abstractC5373e.mo1254a(f20540J);
            abstractC5373e.mo1256a(this.f20567n);
            abstractC5373e.mo1247b();
        }
        if (m3205o()) {
            abstractC5373e.mo1254a(f20541K);
            abstractC5373e.mo1249a(this.f20568o);
            abstractC5373e.mo1247b();
        }
        if (m3204p()) {
            abstractC5373e.mo1254a(f20542L);
            abstractC5373e.mo1249a(this.f20569p);
            abstractC5373e.mo1247b();
        }
        if (this.f20570q != null && m3203q()) {
            abstractC5373e.mo1254a(f20543M);
            abstractC5373e.mo1256a(this.f20570q);
            abstractC5373e.mo1247b();
        }
        if (this.f20571r != null && m3202r()) {
            abstractC5373e.mo1254a(f20544N);
            abstractC5373e.mo1256a(this.f20571r);
            abstractC5373e.mo1247b();
        }
        if (m3201s()) {
            abstractC5373e.mo1254a(f20545O);
            abstractC5373e.mo1258a(this.f20572s);
            abstractC5373e.mo1247b();
        }
        if (this.f20573t != null && m3200t()) {
            abstractC5373e.mo1254a(f20546P);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f20573t.size()));
            for (Map.Entry<String, String> entry : this.f20573t.entrySet()) {
                abstractC5373e.mo1256a(entry.getKey());
                abstractC5373e.mo1256a(entry.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3223b(boolean z) {
        this.f20553Q.set(1, z);
    }

    /* renamed from: b */
    public boolean m3227b() {
        return this.f20555b != null;
    }

    /* renamed from: c */
    public C4832w m3221c(String str) {
        this.f20559f = str;
        return this;
    }

    /* renamed from: c */
    public void m3220c(boolean z) {
        this.f20553Q.set(2, z);
    }

    /* renamed from: c */
    public boolean m3222c() {
        return this.f20556c != null;
    }

    /* renamed from: d */
    public C4832w m3218d(String str) {
        this.f20560g = str;
        return this;
    }

    /* renamed from: d */
    public void m3217d(boolean z) {
        this.f20553Q.set(3, z);
    }

    /* renamed from: d */
    public boolean m3219d() {
        return this.f20557d != null;
    }

    /* renamed from: e */
    public void m3215e(boolean z) {
        this.f20553Q.set(4, z);
    }

    /* renamed from: e */
    public boolean m3216e() {
        return this.f20553Q.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4832w)) {
            return m3231a((C4832w) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3214f() {
        return this.f20559f != null;
    }

    /* renamed from: g */
    public boolean m3213g() {
        return this.f20560g != null;
    }

    /* renamed from: h */
    public boolean m3212h() {
        return this.f20561h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m3211i() {
        return this.f20562i != null;
    }

    /* renamed from: j */
    public boolean m3210j() {
        return this.f20563j != null;
    }

    /* renamed from: k */
    public boolean m3209k() {
        return this.f20553Q.get(1);
    }

    /* renamed from: l */
    public boolean m3208l() {
        return this.f20565l != null;
    }

    /* renamed from: m */
    public boolean m3207m() {
        return this.f20566m != null;
    }

    /* renamed from: n */
    public boolean m3206n() {
        return this.f20567n != null;
    }

    /* renamed from: o */
    public boolean m3205o() {
        return this.f20553Q.get(2);
    }

    /* renamed from: p */
    public boolean m3204p() {
        return this.f20553Q.get(3);
    }

    /* renamed from: q */
    public boolean m3203q() {
        return this.f20570q != null;
    }

    /* renamed from: r */
    public boolean m3202r() {
        return this.f20571r != null;
    }

    /* renamed from: s */
    public boolean m3201s() {
        return this.f20553Q.get(4);
    }

    /* renamed from: t */
    public boolean m3200t() {
        return this.f20573t != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (m3233a()) {
            sb.append("debug:");
            if (this.f20554a == null) {
                sb.append("null");
            } else {
                sb.append(this.f20554a);
            }
            z2 = false;
        }
        if (m3227b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f20555b == null) {
                sb.append("null");
            } else {
                sb.append(this.f20555b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f20556c == null) {
            sb.append("null");
        } else {
            sb.append(this.f20556c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f20557d == null) {
            sb.append("null");
        } else {
            sb.append(this.f20557d);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f20558e);
        if (m3214f()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f20559f == null) {
                sb.append("null");
            } else {
                sb.append(this.f20559f);
            }
        }
        if (m3213g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f20560g == null) {
                sb.append("null");
            } else {
                sb.append(this.f20560g);
            }
        }
        if (m3212h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f20561h == null) {
                sb.append("null");
            } else {
                sb.append(this.f20561h);
            }
        }
        if (m3211i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f20562i == null) {
                sb.append("null");
            } else {
                sb.append(this.f20562i);
            }
        }
        if (m3210j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f20563j == null) {
                sb.append("null");
            } else {
                sb.append(this.f20563j);
            }
        }
        if (m3209k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f20564k);
        }
        if (m3208l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f20565l == null) {
                sb.append("null");
            } else {
                sb.append(this.f20565l);
            }
        }
        if (m3207m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.f20566m == null) {
                sb.append("null");
            } else {
                sb.append(this.f20566m);
            }
        }
        if (m3206n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f20567n == null) {
                sb.append("null");
            } else {
                sb.append(this.f20567n);
            }
        }
        if (m3205o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f20568o);
        }
        if (m3204p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f20569p);
        }
        if (m3203q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f20570q == null) {
                sb.append("null");
            } else {
                sb.append(this.f20570q);
            }
        }
        if (m3202r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f20571r == null) {
                sb.append("null");
            } else {
                sb.append(this.f20571r);
            }
        }
        if (m3201s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f20572s);
        }
        if (m3200t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f20573t == null) {
                sb.append("null");
            } else {
                sb.append(this.f20573t);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public void m3199u() {
        if (this.f20556c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f20557d != null) {
            return;
        }
        throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
    }
}
