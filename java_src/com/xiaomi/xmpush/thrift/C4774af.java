package com.xiaomi.xmpush.thrift;

import com.github.moduth.blockcanary.p215b.C3947a;
import com.p219mi.live.openlivesdk.C4093a;
import com.xiaomi.mipush.sdk.Constants;
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
import org.p248a.p283b.p284a.C5359a;
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
/* renamed from: com.xiaomi.xmpush.thrift.af */
/* loaded from: classes.dex */
public class C4774af implements Serializable, Cloneable, AbstractC5358a<C4774af, EnumC4775a> {

    /* renamed from: x */
    public static final Map<EnumC4775a, C5360b> f19732x;

    /* renamed from: a */
    public String f19736a;

    /* renamed from: b */
    public C4828u f19737b;

    /* renamed from: c */
    public String f19738c;

    /* renamed from: d */
    public String f19739d;

    /* renamed from: e */
    public String f19740e;

    /* renamed from: f */
    public String f19741f;

    /* renamed from: g */
    public String f19742g;

    /* renamed from: h */
    public String f19743h;

    /* renamed from: i */
    public String f19744i;

    /* renamed from: j */
    public String f19745j;

    /* renamed from: k */
    public String f19746k;

    /* renamed from: l */
    public String f19747l;

    /* renamed from: m */
    public int f19748m;

    /* renamed from: n */
    public int f19749n;

    /* renamed from: o */
    public String f19750o;

    /* renamed from: p */
    public String f19751p;

    /* renamed from: q */
    public String f19752q;

    /* renamed from: r */
    public String f19753r;

    /* renamed from: s */
    public int f19754s;

    /* renamed from: t */
    public EnumC4827t f19755t;

    /* renamed from: u */
    public Map<String, String> f19756u;

    /* renamed from: w */
    public String f19758w;

    /* renamed from: y */
    private static final C5378j f19733y = new C5378j("XmPushActionRegistration");

    /* renamed from: z */
    private static final C5370b f19734z = new C5370b(C4093a.f17096c, (byte) 11, 1);

    /* renamed from: A */
    private static final C5370b f19710A = new C5370b("target", (byte) 12, 2);

    /* renamed from: B */
    private static final C5370b f19711B = new C5370b("id", (byte) 11, 3);

    /* renamed from: C */
    private static final C5370b f19712C = new C5370b("appId", (byte) 11, 4);

    /* renamed from: D */
    private static final C5370b f19713D = new C5370b("appVersion", (byte) 11, 5);

    /* renamed from: E */
    private static final C5370b f19714E = new C5370b("packageName", (byte) 11, 6);

    /* renamed from: F */
    private static final C5370b f19715F = new C5370b(Constants.EXTRA_KEY_TOKEN, (byte) 11, 7);

    /* renamed from: G */
    private static final C5370b f19716G = new C5370b("deviceId", (byte) 11, 8);

    /* renamed from: H */
    private static final C5370b f19717H = new C5370b("aliasName", (byte) 11, 9);

    /* renamed from: I */
    private static final C5370b f19718I = new C5370b("sdkVersion", (byte) 11, 10);

    /* renamed from: J */
    private static final C5370b f19719J = new C5370b("regId", (byte) 11, 11);

    /* renamed from: K */
    private static final C5370b f19720K = new C5370b("pushSdkVersionName", (byte) 11, 12);

    /* renamed from: L */
    private static final C5370b f19721L = new C5370b("pushSdkVersionCode", (byte) 8, 13);

    /* renamed from: M */
    private static final C5370b f19722M = new C5370b("appVersionCode", (byte) 8, 14);

    /* renamed from: N */
    private static final C5370b f19723N = new C5370b("androidId", (byte) 11, 15);

    /* renamed from: O */
    private static final C5370b f19724O = new C5370b(C3947a.f16895f, (byte) 11, 16);

    /* renamed from: P */
    private static final C5370b f19725P = new C5370b("serial", (byte) 11, 17);

    /* renamed from: Q */
    private static final C5370b f19726Q = new C5370b("imeiMd5", (byte) 11, 18);

    /* renamed from: R */
    private static final C5370b f19727R = new C5370b("spaceId", (byte) 8, 19);

    /* renamed from: S */
    private static final C5370b f19728S = new C5370b("reason", (byte) 8, 20);

    /* renamed from: T */
    private static final C5370b f19729T = new C5370b("connectionAttrs", (byte) 13, 100);

    /* renamed from: U */
    private static final C5370b f19730U = new C5370b("cleanOldRegInfo", (byte) 2, 101);

    /* renamed from: V */
    private static final C5370b f19731V = new C5370b("oldRegId", (byte) 11, 102);

    /* renamed from: W */
    private BitSet f19735W = new BitSet(4);

    /* renamed from: v */
    public boolean f19757v = false;

    /* renamed from: com.xiaomi.xmpush.thrift.af$a */
    /* loaded from: classes2.dex */
    public enum EnumC4775a {
        DEBUG(1, C4093a.f17096c),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        APP_VERSION(5, "appVersion"),
        PACKAGE_NAME(6, "packageName"),
        TOKEN(7, Constants.EXTRA_KEY_TOKEN),
        DEVICE_ID(8, "deviceId"),
        ALIAS_NAME(9, "aliasName"),
        SDK_VERSION(10, "sdkVersion"),
        REG_ID(11, "regId"),
        PUSH_SDK_VERSION_NAME(12, "pushSdkVersionName"),
        PUSH_SDK_VERSION_CODE(13, "pushSdkVersionCode"),
        APP_VERSION_CODE(14, "appVersionCode"),
        ANDROID_ID(15, "androidId"),
        IMEI(16, C3947a.f16895f),
        SERIAL(17, "serial"),
        IMEI_MD5(18, "imeiMd5"),
        SPACE_ID(19, "spaceId"),
        REASON(20, "reason"),
        CONNECTION_ATTRS(100, "connectionAttrs"),
        CLEAN_OLD_REG_INFO(101, "cleanOldRegInfo"),
        OLD_REG_ID(102, "oldRegId");
        

        /* renamed from: x */
        private static final Map<String, EnumC4775a> f19783x = new HashMap();

        /* renamed from: y */
        private final short f19784y;

        /* renamed from: z */
        private final String f19785z;

        static {
            Iterator it2 = EnumSet.allOf(EnumC4775a.class).iterator();
            while (it2.hasNext()) {
                EnumC4775a enumC4775a = (EnumC4775a) it2.next();
                f19783x.put(enumC4775a.m3633a(), enumC4775a);
            }
        }

        EnumC4775a(short s, String str) {
            this.f19784y = s;
            this.f19785z = str;
        }

        /* renamed from: a */
        public String m3633a() {
            return this.f19785z;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC4775a.class);
        enumMap.put((EnumMap) EnumC4775a.DEBUG, (EnumC4775a) new C5360b(C4093a.f17096c, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.TARGET, (EnumC4775a) new C5360b("target", (byte) 2, new C5365g((byte) 12, C4828u.class)));
        enumMap.put((EnumMap) EnumC4775a.ID, (EnumC4775a) new C5360b("id", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.APP_ID, (EnumC4775a) new C5360b("appId", (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.APP_VERSION, (EnumC4775a) new C5360b("appVersion", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.PACKAGE_NAME, (EnumC4775a) new C5360b("packageName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.TOKEN, (EnumC4775a) new C5360b(Constants.EXTRA_KEY_TOKEN, (byte) 1, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.DEVICE_ID, (EnumC4775a) new C5360b("deviceId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.ALIAS_NAME, (EnumC4775a) new C5360b("aliasName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.SDK_VERSION, (EnumC4775a) new C5360b("sdkVersion", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.REG_ID, (EnumC4775a) new C5360b("regId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.PUSH_SDK_VERSION_NAME, (EnumC4775a) new C5360b("pushSdkVersionName", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.PUSH_SDK_VERSION_CODE, (EnumC4775a) new C5360b("pushSdkVersionCode", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4775a.APP_VERSION_CODE, (EnumC4775a) new C5360b("appVersionCode", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4775a.ANDROID_ID, (EnumC4775a) new C5360b("androidId", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.IMEI, (EnumC4775a) new C5360b(C3947a.f16895f, (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.SERIAL, (EnumC4775a) new C5360b("serial", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.IMEI_MD5, (EnumC4775a) new C5360b("imeiMd5", (byte) 2, new C5361c((byte) 11)));
        enumMap.put((EnumMap) EnumC4775a.SPACE_ID, (EnumC4775a) new C5360b("spaceId", (byte) 2, new C5361c((byte) 8)));
        enumMap.put((EnumMap) EnumC4775a.REASON, (EnumC4775a) new C5360b("reason", (byte) 2, new C5359a((byte) 16, EnumC4827t.class)));
        enumMap.put((EnumMap) EnumC4775a.CONNECTION_ATTRS, (EnumC4775a) new C5360b("connectionAttrs", (byte) 2, new C5363e((byte) 13, new C5361c((byte) 11), new C5361c((byte) 11))));
        enumMap.put((EnumMap) EnumC4775a.CLEAN_OLD_REG_INFO, (EnumC4775a) new C5360b("cleanOldRegInfo", (byte) 2, new C5361c((byte) 2)));
        enumMap.put((EnumMap) EnumC4775a.OLD_REG_ID, (EnumC4775a) new C5360b("oldRegId", (byte) 2, new C5361c((byte) 11)));
        f19732x = Collections.unmodifiableMap(enumMap);
        C5360b.m1284a(C4774af.class, f19732x);
    }

    /* renamed from: a */
    public C4774af m3679a(int i) {
        this.f19748m = i;
        m3675a(true);
        return this;
    }

    /* renamed from: a */
    public C4774af m3677a(EnumC4827t enumC4827t) {
        this.f19755t = enumC4827t;
        return this;
    }

    /* renamed from: a */
    public C4774af m3676a(String str) {
        this.f19738c = str;
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
                m3634z();
                return;
            }
            switch (mo1240i.f22438c) {
                case 1:
                    if (mo1240i.f22437b == 11) {
                        this.f19736a = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 2:
                    if (mo1240i.f22437b == 12) {
                        this.f19737b = new C4828u();
                        this.f19737b.mo1286a(abstractC5373e);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 3:
                    if (mo1240i.f22437b == 11) {
                        this.f19738c = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 4:
                    if (mo1240i.f22437b == 11) {
                        this.f19739d = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 5:
                    if (mo1240i.f22437b == 11) {
                        this.f19740e = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 6:
                    if (mo1240i.f22437b == 11) {
                        this.f19741f = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 7:
                    if (mo1240i.f22437b == 11) {
                        this.f19742g = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 8:
                    if (mo1240i.f22437b == 11) {
                        this.f19743h = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 9:
                    if (mo1240i.f22437b == 11) {
                        this.f19744i = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 10:
                    if (mo1240i.f22437b == 11) {
                        this.f19745j = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 11:
                    if (mo1240i.f22437b == 11) {
                        this.f19746k = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 12:
                    if (mo1240i.f22437b == 11) {
                        this.f19747l = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 13:
                    if (mo1240i.f22437b == 8) {
                        this.f19748m = abstractC5373e.mo1232t();
                        m3675a(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 14:
                    if (mo1240i.f22437b == 8) {
                        this.f19749n = abstractC5373e.mo1232t();
                        m3670b(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 15:
                    if (mo1240i.f22437b == 11) {
                        this.f19750o = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 16:
                    if (mo1240i.f22437b == 11) {
                        this.f19751p = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 17:
                    if (mo1240i.f22437b == 11) {
                        this.f19752q = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 18:
                    if (mo1240i.f22437b == 11) {
                        this.f19753r = abstractC5373e.mo1223w();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 19:
                    if (mo1240i.f22437b == 8) {
                        this.f19754s = abstractC5373e.mo1232t();
                        m3666c(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 20:
                    if (mo1240i.f22437b == 8) {
                        this.f19755t = EnumC4827t.m3256a(abstractC5373e.mo1232t());
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 100:
                    if (mo1240i.f22437b == 13) {
                        C5372d mo1226k = abstractC5373e.mo1226k();
                        this.f19756u = new HashMap(mo1226k.f22443c * 2);
                        for (int i = 0; i < mo1226k.f22443c; i++) {
                            this.f19756u.put(abstractC5373e.mo1223w(), abstractC5373e.mo1223w());
                        }
                        abstractC5373e.mo1238l();
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 101:
                    if (mo1240i.f22437b == 2) {
                        this.f19757v = abstractC5373e.mo1235q();
                        m3663d(true);
                        break;
                    } else {
                        C5376h.m1228a(abstractC5373e, mo1240i.f22437b);
                        break;
                    }
                case 102:
                    if (mo1240i.f22437b == 11) {
                        this.f19758w = abstractC5373e.mo1223w();
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
    public void m3675a(boolean z) {
        this.f19735W.set(0, z);
    }

    /* renamed from: a */
    public boolean m3680a() {
        return this.f19736a != null;
    }

    /* renamed from: a */
    public boolean m3678a(C4774af c4774af) {
        if (c4774af == null) {
            return false;
        }
        boolean m3680a = m3680a();
        boolean m3680a2 = c4774af.m3680a();
        if ((m3680a || m3680a2) && (!m3680a || !m3680a2 || !this.f19736a.equals(c4774af.f19736a))) {
            return false;
        }
        boolean m3674b = m3674b();
        boolean m3674b2 = c4774af.m3674b();
        if ((m3674b || m3674b2) && (!m3674b || !m3674b2 || !this.f19737b.m3254a(c4774af.f19737b))) {
            return false;
        }
        boolean m3669c = m3669c();
        boolean m3669c2 = c4774af.m3669c();
        if ((m3669c || m3669c2) && (!m3669c || !m3669c2 || !this.f19738c.equals(c4774af.f19738c))) {
            return false;
        }
        boolean m3662e = m3662e();
        boolean m3662e2 = c4774af.m3662e();
        if ((m3662e || m3662e2) && (!m3662e || !m3662e2 || !this.f19739d.equals(c4774af.f19739d))) {
            return false;
        }
        boolean m3660f = m3660f();
        boolean m3660f2 = c4774af.m3660f();
        if ((m3660f || m3660f2) && (!m3660f || !m3660f2 || !this.f19740e.equals(c4774af.f19740e))) {
            return false;
        }
        boolean m3658g = m3658g();
        boolean m3658g2 = c4774af.m3658g();
        if ((m3658g || m3658g2) && (!m3658g || !m3658g2 || !this.f19741f.equals(c4774af.f19741f))) {
            return false;
        }
        boolean m3654i = m3654i();
        boolean m3654i2 = c4774af.m3654i();
        if ((m3654i || m3654i2) && (!m3654i || !m3654i2 || !this.f19742g.equals(c4774af.f19742g))) {
            return false;
        }
        boolean m3652j = m3652j();
        boolean m3652j2 = c4774af.m3652j();
        if ((m3652j || m3652j2) && (!m3652j || !m3652j2 || !this.f19743h.equals(c4774af.f19743h))) {
            return false;
        }
        boolean m3650k = m3650k();
        boolean m3650k2 = c4774af.m3650k();
        if ((m3650k || m3650k2) && (!m3650k || !m3650k2 || !this.f19744i.equals(c4774af.f19744i))) {
            return false;
        }
        boolean m3648l = m3648l();
        boolean m3648l2 = c4774af.m3648l();
        if ((m3648l || m3648l2) && (!m3648l || !m3648l2 || !this.f19745j.equals(c4774af.f19745j))) {
            return false;
        }
        boolean m3647m = m3647m();
        boolean m3647m2 = c4774af.m3647m();
        if ((m3647m || m3647m2) && (!m3647m || !m3647m2 || !this.f19746k.equals(c4774af.f19746k))) {
            return false;
        }
        boolean m3646n = m3646n();
        boolean m3646n2 = c4774af.m3646n();
        if ((m3646n || m3646n2) && (!m3646n || !m3646n2 || !this.f19747l.equals(c4774af.f19747l))) {
            return false;
        }
        boolean m3645o = m3645o();
        boolean m3645o2 = c4774af.m3645o();
        if ((m3645o || m3645o2) && (!m3645o || !m3645o2 || this.f19748m != c4774af.f19748m)) {
            return false;
        }
        boolean m3644p = m3644p();
        boolean m3644p2 = c4774af.m3644p();
        if ((m3644p || m3644p2) && (!m3644p || !m3644p2 || this.f19749n != c4774af.f19749n)) {
            return false;
        }
        boolean m3643q = m3643q();
        boolean m3643q2 = c4774af.m3643q();
        if ((m3643q || m3643q2) && (!m3643q || !m3643q2 || !this.f19750o.equals(c4774af.f19750o))) {
            return false;
        }
        boolean m3642r = m3642r();
        boolean m3642r2 = c4774af.m3642r();
        if ((m3642r || m3642r2) && (!m3642r || !m3642r2 || !this.f19751p.equals(c4774af.f19751p))) {
            return false;
        }
        boolean m3641s = m3641s();
        boolean m3641s2 = c4774af.m3641s();
        if ((m3641s || m3641s2) && (!m3641s || !m3641s2 || !this.f19752q.equals(c4774af.f19752q))) {
            return false;
        }
        boolean m3640t = m3640t();
        boolean m3640t2 = c4774af.m3640t();
        if ((m3640t || m3640t2) && (!m3640t || !m3640t2 || !this.f19753r.equals(c4774af.f19753r))) {
            return false;
        }
        boolean m3639u = m3639u();
        boolean m3639u2 = c4774af.m3639u();
        if ((m3639u || m3639u2) && (!m3639u || !m3639u2 || this.f19754s != c4774af.f19754s)) {
            return false;
        }
        boolean m3638v = m3638v();
        boolean m3638v2 = c4774af.m3638v();
        if ((m3638v || m3638v2) && (!m3638v || !m3638v2 || !this.f19755t.equals(c4774af.f19755t))) {
            return false;
        }
        boolean m3637w = m3637w();
        boolean m3637w2 = c4774af.m3637w();
        if ((m3637w || m3637w2) && (!m3637w || !m3637w2 || !this.f19756u.equals(c4774af.f19756u))) {
            return false;
        }
        boolean m3636x = m3636x();
        boolean m3636x2 = c4774af.m3636x();
        if ((m3636x || m3636x2) && (!m3636x || !m3636x2 || this.f19757v != c4774af.f19757v)) {
            return false;
        }
        boolean m3635y = m3635y();
        boolean m3635y2 = c4774af.m3635y();
        return (!m3635y && !m3635y2) || (m3635y && m3635y2 && this.f19758w.equals(c4774af.f19758w));
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C4774af c4774af) {
        int m1277a;
        int m1269a;
        int m1272a;
        int m1278a;
        int m1280a;
        int m1277a2;
        int m1277a3;
        int m1277a4;
        int m1277a5;
        int m1280a2;
        int m1280a3;
        int m1277a6;
        int m1277a7;
        int m1277a8;
        int m1277a9;
        int m1277a10;
        int m1277a11;
        int m1277a12;
        int m1277a13;
        int m1277a14;
        int m1277a15;
        int m1278a2;
        int m1277a16;
        if (!getClass().equals(c4774af.getClass())) {
            return getClass().getName().compareTo(c4774af.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3680a()).compareTo(Boolean.valueOf(c4774af.m3680a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3680a() && (m1277a16 = C5366b.m1277a(this.f19736a, c4774af.f19736a)) != 0) {
            return m1277a16;
        }
        int compareTo2 = Boolean.valueOf(m3674b()).compareTo(Boolean.valueOf(c4774af.m3674b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3674b() && (m1278a2 = C5366b.m1278a(this.f19737b, c4774af.f19737b)) != 0) {
            return m1278a2;
        }
        int compareTo3 = Boolean.valueOf(m3669c()).compareTo(Boolean.valueOf(c4774af.m3669c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3669c() && (m1277a15 = C5366b.m1277a(this.f19738c, c4774af.f19738c)) != 0) {
            return m1277a15;
        }
        int compareTo4 = Boolean.valueOf(m3662e()).compareTo(Boolean.valueOf(c4774af.m3662e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3662e() && (m1277a14 = C5366b.m1277a(this.f19739d, c4774af.f19739d)) != 0) {
            return m1277a14;
        }
        int compareTo5 = Boolean.valueOf(m3660f()).compareTo(Boolean.valueOf(c4774af.m3660f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3660f() && (m1277a13 = C5366b.m1277a(this.f19740e, c4774af.f19740e)) != 0) {
            return m1277a13;
        }
        int compareTo6 = Boolean.valueOf(m3658g()).compareTo(Boolean.valueOf(c4774af.m3658g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3658g() && (m1277a12 = C5366b.m1277a(this.f19741f, c4774af.f19741f)) != 0) {
            return m1277a12;
        }
        int compareTo7 = Boolean.valueOf(m3654i()).compareTo(Boolean.valueOf(c4774af.m3654i()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3654i() && (m1277a11 = C5366b.m1277a(this.f19742g, c4774af.f19742g)) != 0) {
            return m1277a11;
        }
        int compareTo8 = Boolean.valueOf(m3652j()).compareTo(Boolean.valueOf(c4774af.m3652j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3652j() && (m1277a10 = C5366b.m1277a(this.f19743h, c4774af.f19743h)) != 0) {
            return m1277a10;
        }
        int compareTo9 = Boolean.valueOf(m3650k()).compareTo(Boolean.valueOf(c4774af.m3650k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3650k() && (m1277a9 = C5366b.m1277a(this.f19744i, c4774af.f19744i)) != 0) {
            return m1277a9;
        }
        int compareTo10 = Boolean.valueOf(m3648l()).compareTo(Boolean.valueOf(c4774af.m3648l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3648l() && (m1277a8 = C5366b.m1277a(this.f19745j, c4774af.f19745j)) != 0) {
            return m1277a8;
        }
        int compareTo11 = Boolean.valueOf(m3647m()).compareTo(Boolean.valueOf(c4774af.m3647m()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3647m() && (m1277a7 = C5366b.m1277a(this.f19746k, c4774af.f19746k)) != 0) {
            return m1277a7;
        }
        int compareTo12 = Boolean.valueOf(m3646n()).compareTo(Boolean.valueOf(c4774af.m3646n()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m3646n() && (m1277a6 = C5366b.m1277a(this.f19747l, c4774af.f19747l)) != 0) {
            return m1277a6;
        }
        int compareTo13 = Boolean.valueOf(m3645o()).compareTo(Boolean.valueOf(c4774af.m3645o()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m3645o() && (m1280a3 = C5366b.m1280a(this.f19748m, c4774af.f19748m)) != 0) {
            return m1280a3;
        }
        int compareTo14 = Boolean.valueOf(m3644p()).compareTo(Boolean.valueOf(c4774af.m3644p()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m3644p() && (m1280a2 = C5366b.m1280a(this.f19749n, c4774af.f19749n)) != 0) {
            return m1280a2;
        }
        int compareTo15 = Boolean.valueOf(m3643q()).compareTo(Boolean.valueOf(c4774af.m3643q()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m3643q() && (m1277a5 = C5366b.m1277a(this.f19750o, c4774af.f19750o)) != 0) {
            return m1277a5;
        }
        int compareTo16 = Boolean.valueOf(m3642r()).compareTo(Boolean.valueOf(c4774af.m3642r()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m3642r() && (m1277a4 = C5366b.m1277a(this.f19751p, c4774af.f19751p)) != 0) {
            return m1277a4;
        }
        int compareTo17 = Boolean.valueOf(m3641s()).compareTo(Boolean.valueOf(c4774af.m3641s()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m3641s() && (m1277a3 = C5366b.m1277a(this.f19752q, c4774af.f19752q)) != 0) {
            return m1277a3;
        }
        int compareTo18 = Boolean.valueOf(m3640t()).compareTo(Boolean.valueOf(c4774af.m3640t()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m3640t() && (m1277a2 = C5366b.m1277a(this.f19753r, c4774af.f19753r)) != 0) {
            return m1277a2;
        }
        int compareTo19 = Boolean.valueOf(m3639u()).compareTo(Boolean.valueOf(c4774af.m3639u()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m3639u() && (m1280a = C5366b.m1280a(this.f19754s, c4774af.f19754s)) != 0) {
            return m1280a;
        }
        int compareTo20 = Boolean.valueOf(m3638v()).compareTo(Boolean.valueOf(c4774af.m3638v()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (m3638v() && (m1278a = C5366b.m1278a(this.f19755t, c4774af.f19755t)) != 0) {
            return m1278a;
        }
        int compareTo21 = Boolean.valueOf(m3637w()).compareTo(Boolean.valueOf(c4774af.m3637w()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (m3637w() && (m1272a = C5366b.m1272a(this.f19756u, c4774af.f19756u)) != 0) {
            return m1272a;
        }
        int compareTo22 = Boolean.valueOf(m3636x()).compareTo(Boolean.valueOf(c4774af.m3636x()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (m3636x() && (m1269a = C5366b.m1269a(this.f19757v, c4774af.f19757v)) != 0) {
            return m1269a;
        }
        int compareTo23 = Boolean.valueOf(m3635y()).compareTo(Boolean.valueOf(c4774af.m3635y()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (m3635y() && (m1277a = C5366b.m1277a(this.f19758w, c4774af.f19758w)) != 0) {
            return m1277a;
        }
        return 0;
    }

    /* renamed from: b */
    public C4774af m3673b(int i) {
        this.f19749n = i;
        m3670b(true);
        return this;
    }

    /* renamed from: b */
    public C4774af m3671b(String str) {
        this.f19739d = str;
        return this;
    }

    @Override // org.p248a.p283b.AbstractC5358a
    /* renamed from: b */
    public void mo1285b(AbstractC5373e abstractC5373e) {
        m3634z();
        abstractC5373e.mo1250a(f19733y);
        if (this.f19736a != null && m3680a()) {
            abstractC5373e.mo1254a(f19734z);
            abstractC5373e.mo1256a(this.f19736a);
            abstractC5373e.mo1247b();
        }
        if (this.f19737b != null && m3674b()) {
            abstractC5373e.mo1254a(f19710A);
            this.f19737b.mo1285b(abstractC5373e);
            abstractC5373e.mo1247b();
        }
        if (this.f19738c != null) {
            abstractC5373e.mo1254a(f19711B);
            abstractC5373e.mo1256a(this.f19738c);
            abstractC5373e.mo1247b();
        }
        if (this.f19739d != null) {
            abstractC5373e.mo1254a(f19712C);
            abstractC5373e.mo1256a(this.f19739d);
            abstractC5373e.mo1247b();
        }
        if (this.f19740e != null && m3660f()) {
            abstractC5373e.mo1254a(f19713D);
            abstractC5373e.mo1256a(this.f19740e);
            abstractC5373e.mo1247b();
        }
        if (this.f19741f != null && m3658g()) {
            abstractC5373e.mo1254a(f19714E);
            abstractC5373e.mo1256a(this.f19741f);
            abstractC5373e.mo1247b();
        }
        if (this.f19742g != null) {
            abstractC5373e.mo1254a(f19715F);
            abstractC5373e.mo1256a(this.f19742g);
            abstractC5373e.mo1247b();
        }
        if (this.f19743h != null && m3652j()) {
            abstractC5373e.mo1254a(f19716G);
            abstractC5373e.mo1256a(this.f19743h);
            abstractC5373e.mo1247b();
        }
        if (this.f19744i != null && m3650k()) {
            abstractC5373e.mo1254a(f19717H);
            abstractC5373e.mo1256a(this.f19744i);
            abstractC5373e.mo1247b();
        }
        if (this.f19745j != null && m3648l()) {
            abstractC5373e.mo1254a(f19718I);
            abstractC5373e.mo1256a(this.f19745j);
            abstractC5373e.mo1247b();
        }
        if (this.f19746k != null && m3647m()) {
            abstractC5373e.mo1254a(f19719J);
            abstractC5373e.mo1256a(this.f19746k);
            abstractC5373e.mo1247b();
        }
        if (this.f19747l != null && m3646n()) {
            abstractC5373e.mo1254a(f19720K);
            abstractC5373e.mo1256a(this.f19747l);
            abstractC5373e.mo1247b();
        }
        if (m3645o()) {
            abstractC5373e.mo1254a(f19721L);
            abstractC5373e.mo1258a(this.f19748m);
            abstractC5373e.mo1247b();
        }
        if (m3644p()) {
            abstractC5373e.mo1254a(f19722M);
            abstractC5373e.mo1258a(this.f19749n);
            abstractC5373e.mo1247b();
        }
        if (this.f19750o != null && m3643q()) {
            abstractC5373e.mo1254a(f19723N);
            abstractC5373e.mo1256a(this.f19750o);
            abstractC5373e.mo1247b();
        }
        if (this.f19751p != null && m3642r()) {
            abstractC5373e.mo1254a(f19724O);
            abstractC5373e.mo1256a(this.f19751p);
            abstractC5373e.mo1247b();
        }
        if (this.f19752q != null && m3641s()) {
            abstractC5373e.mo1254a(f19725P);
            abstractC5373e.mo1256a(this.f19752q);
            abstractC5373e.mo1247b();
        }
        if (this.f19753r != null && m3640t()) {
            abstractC5373e.mo1254a(f19726Q);
            abstractC5373e.mo1256a(this.f19753r);
            abstractC5373e.mo1247b();
        }
        if (m3639u()) {
            abstractC5373e.mo1254a(f19727R);
            abstractC5373e.mo1258a(this.f19754s);
            abstractC5373e.mo1247b();
        }
        if (this.f19755t != null && m3638v()) {
            abstractC5373e.mo1254a(f19728S);
            abstractC5373e.mo1258a(this.f19755t.m3257a());
            abstractC5373e.mo1247b();
        }
        if (this.f19756u != null && m3637w()) {
            abstractC5373e.mo1254a(f19729T);
            abstractC5373e.mo1252a(new C5372d((byte) 11, (byte) 11, this.f19756u.size()));
            for (Map.Entry<String, String> entry : this.f19756u.entrySet()) {
                abstractC5373e.mo1256a(entry.getKey());
                abstractC5373e.mo1256a(entry.getValue());
            }
            abstractC5373e.mo1245d();
            abstractC5373e.mo1247b();
        }
        if (m3636x()) {
            abstractC5373e.mo1254a(f19730U);
            abstractC5373e.mo1248a(this.f19757v);
            abstractC5373e.mo1247b();
        }
        if (this.f19758w != null && m3635y()) {
            abstractC5373e.mo1254a(f19731V);
            abstractC5373e.mo1256a(this.f19758w);
            abstractC5373e.mo1247b();
        }
        abstractC5373e.mo1246c();
        abstractC5373e.mo1261a();
    }

    /* renamed from: b */
    public void m3670b(boolean z) {
        this.f19735W.set(1, z);
    }

    /* renamed from: b */
    public boolean m3674b() {
        return this.f19737b != null;
    }

    /* renamed from: c */
    public C4774af m3668c(int i) {
        this.f19754s = i;
        m3666c(true);
        return this;
    }

    /* renamed from: c */
    public C4774af m3667c(String str) {
        this.f19740e = str;
        return this;
    }

    /* renamed from: c */
    public void m3666c(boolean z) {
        this.f19735W.set(2, z);
    }

    /* renamed from: c */
    public boolean m3669c() {
        return this.f19738c != null;
    }

    /* renamed from: d */
    public C4774af m3664d(String str) {
        this.f19741f = str;
        return this;
    }

    /* renamed from: d */
    public String m3665d() {
        return this.f19739d;
    }

    /* renamed from: d */
    public void m3663d(boolean z) {
        this.f19735W.set(3, z);
    }

    /* renamed from: e */
    public C4774af m3661e(String str) {
        this.f19742g = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3662e() {
        return this.f19739d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4774af)) {
            return m3678a((C4774af) obj);
        }
        return false;
    }

    /* renamed from: f */
    public C4774af m3659f(String str) {
        this.f19743h = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3660f() {
        return this.f19740e != null;
    }

    /* renamed from: g */
    public C4774af m3657g(String str) {
        this.f19747l = str;
        return this;
    }

    /* renamed from: g */
    public boolean m3658g() {
        return this.f19741f != null;
    }

    /* renamed from: h */
    public C4774af m3655h(String str) {
        this.f19750o = str;
        return this;
    }

    /* renamed from: h */
    public String m3656h() {
        return this.f19742g;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public C4774af m3653i(String str) {
        this.f19751p = str;
        return this;
    }

    /* renamed from: i */
    public boolean m3654i() {
        return this.f19742g != null;
    }

    /* renamed from: j */
    public C4774af m3651j(String str) {
        this.f19752q = str;
        return this;
    }

    /* renamed from: j */
    public boolean m3652j() {
        return this.f19743h != null;
    }

    /* renamed from: k */
    public C4774af m3649k(String str) {
        this.f19753r = str;
        return this;
    }

    /* renamed from: k */
    public boolean m3650k() {
        return this.f19744i != null;
    }

    /* renamed from: l */
    public boolean m3648l() {
        return this.f19745j != null;
    }

    /* renamed from: m */
    public boolean m3647m() {
        return this.f19746k != null;
    }

    /* renamed from: n */
    public boolean m3646n() {
        return this.f19747l != null;
    }

    /* renamed from: o */
    public boolean m3645o() {
        return this.f19735W.get(0);
    }

    /* renamed from: p */
    public boolean m3644p() {
        return this.f19735W.get(1);
    }

    /* renamed from: q */
    public boolean m3643q() {
        return this.f19750o != null;
    }

    /* renamed from: r */
    public boolean m3642r() {
        return this.f19751p != null;
    }

    /* renamed from: s */
    public boolean m3641s() {
        return this.f19752q != null;
    }

    /* renamed from: t */
    public boolean m3640t() {
        return this.f19753r != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z2 = true;
        if (m3680a()) {
            sb.append("debug:");
            if (this.f19736a == null) {
                sb.append("null");
            } else {
                sb.append(this.f19736a);
            }
            z2 = false;
        }
        if (m3674b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f19737b == null) {
                sb.append("null");
            } else {
                sb.append(this.f19737b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f19738c == null) {
            sb.append("null");
        } else {
            sb.append(this.f19738c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f19739d == null) {
            sb.append("null");
        } else {
            sb.append(this.f19739d);
        }
        if (m3660f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f19740e == null) {
                sb.append("null");
            } else {
                sb.append(this.f19740e);
            }
        }
        if (m3658g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f19741f == null) {
                sb.append("null");
            } else {
                sb.append(this.f19741f);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f19742g == null) {
            sb.append("null");
        } else {
            sb.append(this.f19742g);
        }
        if (m3652j()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f19743h == null) {
                sb.append("null");
            } else {
                sb.append(this.f19743h);
            }
        }
        if (m3650k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f19744i == null) {
                sb.append("null");
            } else {
                sb.append(this.f19744i);
            }
        }
        if (m3648l()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f19745j == null) {
                sb.append("null");
            } else {
                sb.append(this.f19745j);
            }
        }
        if (m3647m()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f19746k == null) {
                sb.append("null");
            } else {
                sb.append(this.f19746k);
            }
        }
        if (m3646n()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.f19747l == null) {
                sb.append("null");
            } else {
                sb.append(this.f19747l);
            }
        }
        if (m3645o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f19748m);
        }
        if (m3644p()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f19749n);
        }
        if (m3643q()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.f19750o == null) {
                sb.append("null");
            } else {
                sb.append(this.f19750o);
            }
        }
        if (m3642r()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.f19751p == null) {
                sb.append("null");
            } else {
                sb.append(this.f19751p);
            }
        }
        if (m3641s()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.f19752q == null) {
                sb.append("null");
            } else {
                sb.append(this.f19752q);
            }
        }
        if (m3640t()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f19753r == null) {
                sb.append("null");
            } else {
                sb.append(this.f19753r);
            }
        }
        if (m3639u()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f19754s);
        }
        if (m3638v()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f19755t == null) {
                sb.append("null");
            } else {
                sb.append(this.f19755t);
            }
        }
        if (m3637w()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.f19756u == null) {
                sb.append("null");
            } else {
                sb.append(this.f19756u);
            }
        }
        if (m3636x()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f19757v);
        }
        if (m3635y()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.f19758w == null) {
                sb.append("null");
            } else {
                sb.append(this.f19758w);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public boolean m3639u() {
        return this.f19735W.get(2);
    }

    /* renamed from: v */
    public boolean m3638v() {
        return this.f19755t != null;
    }

    /* renamed from: w */
    public boolean m3637w() {
        return this.f19756u != null;
    }

    /* renamed from: x */
    public boolean m3636x() {
        return this.f19735W.get(3);
    }

    /* renamed from: y */
    public boolean m3635y() {
        return this.f19758w != null;
    }

    /* renamed from: z */
    public void m3634z() {
        if (this.f19738c == null) {
            throw new C5374f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f19739d == null) {
            throw new C5374f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f19742g != null) {
            return;
        }
        throw new C5374f("Required field 'token' was not present! Struct: " + toString());
    }
}
