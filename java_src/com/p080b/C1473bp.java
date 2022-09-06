package com.p080b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.p080b.C1536dp;
import com.tencent.p227mm.sdk.platformtools.Util;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.p051m.p052a.C0485k;
/* renamed from: com.b.bp */
/* loaded from: classes.dex */
public class C1473bp {

    /* renamed from: a */
    private static Context f5138a;

    /* renamed from: w */
    private static String f5160w;

    /* renamed from: x */
    private static String f5161x;

    /* renamed from: b */
    private static String f5139b = "提示信息";

    /* renamed from: c */
    private static String f5140c = "确认";

    /* renamed from: d */
    private static String f5141d = "取消";

    /* renamed from: e */
    private static String f5142e = "";

    /* renamed from: f */
    private static String f5143f = "";

    /* renamed from: g */
    private static String f5144g = "";

    /* renamed from: h */
    private static boolean f5145h = false;

    /* renamed from: i */
    private static long f5146i = 0;

    /* renamed from: j */
    private static long f5147j = 0;

    /* renamed from: k */
    private static boolean f5148k = false;

    /* renamed from: l */
    private static int f5149l = 0;

    /* renamed from: m */
    private static boolean f5150m = false;

    /* renamed from: n */
    private static int f5151n = 0;

    /* renamed from: o */
    private static boolean f5152o = false;

    /* renamed from: p */
    private static String f5153p = "1";

    /* renamed from: q */
    private static String f5154q = "1";

    /* renamed from: r */
    private static int f5155r = -1;

    /* renamed from: s */
    private static long f5156s = 0;

    /* renamed from: t */
    private static String f5157t = "0";

    /* renamed from: u */
    private static int f5158u = -1;

    /* renamed from: v */
    private static long f5159v = 0;

    /* renamed from: y */
    private static String f5162y = "0";

    /* renamed from: z */
    private static boolean f5163z = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.bp$a */
    /* loaded from: classes.dex */
    public static class C1474a {

        /* renamed from: a */
        String f5164a = "0";

        /* renamed from: b */
        String f5165b = "0";

        /* renamed from: c */
        String f5166c = "0";

        C1474a() {
        }
    }

    /* renamed from: a */
    private static String m16051a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) ? "" : jSONObject.optString(str);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AuthUtil", "parse2String");
            return "";
        }
    }

    /* renamed from: a */
    public static synchronized void m16052a(String str) {
        synchronized (C1473bp.class) {
            f5162y = str;
        }
    }

    /* renamed from: a */
    public static boolean m16055a() {
        return f5145h;
    }

    /* renamed from: a */
    public static synchronized boolean m16054a(Context context) {
        boolean z;
        synchronized (C1473bp.class) {
            f5138a = context;
            z = false;
            C1536dp.C1537a m15644a = C1536dp.m15644a(context, C1514cx.m15729a("2.4.1"), "callamappro;fast;sdkupdate;sdkcoordinate;locate;opflag;exception;amappushflag");
            if (m15644a != null) {
                z = m16053a(m15644a);
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m16053a(C1536dp.C1537a c1537a) {
        try {
            JSONObject jSONObject = c1537a.f5491b;
            if (jSONObject != null && jSONObject.has("opflag")) {
                f5153p = jSONObject.getString("opflag");
            }
            JSONObject jSONObject2 = c1537a.f5492c;
            if (jSONObject2 != null) {
                if (jSONObject2.has("callamapflag")) {
                    f5154q = jSONObject2.getString("callamapflag");
                }
                if (jSONObject2.has("count")) {
                    f5155r = jSONObject2.getInt("count");
                }
                if (jSONObject2.has("nowtime")) {
                    f5156s = jSONObject2.getLong("nowtime");
                }
                if (f5155r != -1 && f5156s != 0) {
                    if (!C1477bs.m16015a(f5156s, C1476br.m16021b(f5138a, "pref", "nowtime", 0L))) {
                        m16049b(f5138a);
                    }
                }
            }
            JSONObject jSONObject3 = c1537a.f5490a;
            if (jSONObject3 != null) {
                if (jSONObject3.has("amappushflag")) {
                    f5157t = jSONObject3.getString("amappushflag");
                }
                if (jSONObject3.has("count")) {
                    f5158u = jSONObject3.getInt("count");
                }
                if (jSONObject3.has("nowtime")) {
                    f5159v = jSONObject3.getLong("nowtime");
                }
                if (f5158u != -1 && f5159v != 0) {
                    if (!C1477bs.m16015a(f5159v, C1476br.m16021b(f5138a, "pref", "pushSerTime", 0L))) {
                        m16046c(f5138a);
                    }
                }
            }
            JSONObject jSONObject4 = c1537a.f5495f;
            if (jSONObject4 != null) {
                if (jSONObject4.has("f")) {
                    f5162y = m16051a(jSONObject4, "f");
                    if ("1".equals(f5162y)) {
                        long m16021b = C1476br.m16021b(f5138a, "abcd", "abc", 0L);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (elapsedRealtime - m16021b > Util.MILLSECONDS_OF_HOUR) {
                            C1476br.m16024a(f5138a, "abcd", "abc", elapsedRealtime);
                        }
                        if (elapsedRealtime > m16021b && elapsedRealtime - m16021b < Util.MILLSECONDS_OF_HOUR) {
                            f5162y = "0";
                        }
                        if (elapsedRealtime < m16021b) {
                            f5162y = "0";
                            C1476br.m16024a(f5138a, "abcd", "abc", elapsedRealtime);
                        }
                    } else {
                        f5162y = "0";
                    }
                }
                if (jSONObject4.has("a")) {
                    f5139b = m16051a(jSONObject4, "a");
                }
                if (jSONObject4.has("o")) {
                    f5140c = m16051a(jSONObject4, "o");
                }
                if (jSONObject4.has("c")) {
                    f5141d = m16051a(jSONObject4, "c");
                }
                if (jSONObject4.has(C0485k.f1074a)) {
                    f5142e = m16051a(jSONObject4, C0485k.f1074a);
                }
                if (jSONObject4.has("u")) {
                    f5143f = m16051a(jSONObject4, "u");
                }
                if (jSONObject4.has("t")) {
                    f5144g = m16051a(jSONObject4, "t");
                }
                if (("".equals(f5142e) || f5142e == null) && ("".equals(f5143f) || f5143f == null)) {
                    f5162y = "0";
                }
            }
            C1549dv m15729a = C1514cx.m15729a("2.4.1");
            C1536dp.C1537a.C1540c c1540c = c1537a.f5497h;
            if (c1540c != null) {
                String str = c1540c.f5504b;
                String str2 = c1540c.f5503a;
                String str3 = c1540c.f5505c;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    new C1578x(f5138a, null, m15729a).m15437a();
                } else {
                    new C1578x(f5138a, new C1579y(str2, str, str3), m15729a).m15437a();
                }
            } else {
                new C1578x(f5138a, null, m15729a).m15437a();
            }
            C1536dp.C1537a.C1539b c1539b = c1537a.f5498i;
            if (c1539b != null) {
                f5160w = c1539b.f5501a;
                f5161x = c1539b.f5502b;
                if (!TextUtils.isEmpty(f5160w) && !TextUtils.isEmpty(f5161x)) {
                    new C1547du(f5138a, "loc", f5160w, f5161x).m15584a();
                }
            }
            C1536dp.C1537a.C1538a c1538a = c1537a.f5496g;
            if (c1538a != null) {
                boolean z = c1538a.f5499a;
                C1549dv m15729a2 = C1514cx.m15729a("2.4.1");
                m15729a2.m15579a(z);
                C1488c.m15879a(f5138a, m15729a2);
            }
            JSONObject jSONObject5 = c1537a.f5493d;
            if (jSONObject5 == null) {
                return true;
            }
            C1474a m16048b = m16048b(jSONObject5, "fs");
            if (m16048b != null) {
                f5148k = m16048b.f5166c.equals("1");
                f5149l = Integer.parseInt(m16048b.f5165b);
            }
            C1474a m16048b2 = m16048b(jSONObject5, "us");
            if (m16048b2 != null) {
                f5150m = m16048b2.f5166c.equals("1");
                f5152o = !m16048b2.f5164a.equals("0");
                f5151n = Integer.parseInt(m16048b2.f5165b);
            }
            C1474a m16048b3 = m16048b(jSONObject5, "rs");
            if (m16048b3 == null) {
                return true;
            }
            f5145h = m16048b3.f5166c.equals("1");
            if (f5145h) {
                f5147j = C1477bs.m15997b();
            }
            f5146i = Integer.parseInt(m16048b3.f5165b) * 1000;
            return true;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AuthUtil", "loadconfig");
            f5162y = "0";
            return false;
        }
    }

    /* renamed from: b */
    public static long m16050b() {
        return f5146i;
    }

    /* renamed from: b */
    private static C1474a m16048b(JSONObject jSONObject, String str) {
        C1474a c1474a;
        Throwable th;
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str) && (jSONObject2 = jSONObject.getJSONObject(str)) != null) {
                    c1474a = new C1474a();
                    try {
                        if (jSONObject2.has("b")) {
                            c1474a.f5164a = m16051a(jSONObject2, "b");
                        }
                        if (jSONObject2.has("t")) {
                            c1474a.f5165b = m16051a(jSONObject2, "t");
                        }
                        if (!jSONObject2.has("st")) {
                            return c1474a;
                        }
                        c1474a.f5166c = m16051a(jSONObject2, "st");
                        return c1474a;
                    } catch (Throwable th2) {
                        th = th2;
                        C1514cx.m15728a(th, "AuthUtil", "getLocateObj");
                        return c1474a;
                    }
                }
            } catch (Throwable th3) {
                c1474a = null;
                th = th3;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static void m16049b(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            if (f5156s == 0) {
                edit.remove("nowtime");
            } else {
                edit.putLong("nowtime", f5156s);
            }
            if (f5155r == -1) {
                edit.remove("count");
            } else {
                edit.putInt("count", 0);
            }
            C1476br.m16023a(edit);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    /* renamed from: c */
    public static long m16047c() {
        return f5147j;
    }

    /* renamed from: c */
    private static void m16046c(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            if (f5159v == 0) {
                edit.remove("pushSerTime");
            } else {
                edit.putLong("pushSerTime", f5159v);
            }
            if (f5158u == -1) {
                edit.remove("pushCount");
            } else {
                edit.putInt("pushCount", 0);
            }
            C1476br.m16023a(edit);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    /* renamed from: d */
    public static boolean m16045d() {
        return f5148k;
    }

    /* renamed from: e */
    public static int m16044e() {
        return f5149l;
    }

    /* renamed from: f */
    public static boolean m16043f() {
        return f5150m;
    }

    /* renamed from: g */
    public static int m16042g() {
        return f5151n;
    }

    /* renamed from: h */
    public static boolean m16041h() {
        return f5152o;
    }

    /* renamed from: i */
    public static boolean m16040i() {
        boolean equals = "1".equals(f5153p);
        C1443av.f5007a = equals;
        return equals;
    }

    /* renamed from: j */
    public static String m16039j() {
        return f5139b;
    }

    /* renamed from: k */
    public static String m16038k() {
        return f5140c;
    }

    /* renamed from: l */
    public static String m16037l() {
        return f5141d;
    }

    /* renamed from: m */
    public static String m16036m() {
        return f5142e;
    }

    /* renamed from: n */
    public static String m16035n() {
        return f5143f;
    }

    /* renamed from: o */
    public static String m16034o() {
        return f5144g;
    }

    /* renamed from: p */
    public static boolean m16033p() {
        if (!"1".equals(f5154q)) {
            return false;
        }
        if (f5155r == -1 || f5156s == 0) {
            return true;
        }
        if (!C1477bs.m16015a(f5156s, C1476br.m16021b(f5138a, "pref", "nowtime", 0L))) {
            m16049b(f5138a);
            C1476br.m16025a(f5138a, "pref", "count", 1);
            return true;
        }
        int m16022b = C1476br.m16022b(f5138a, "pref", "count", 0);
        if (m16022b >= f5155r) {
            return false;
        }
        C1476br.m16025a(f5138a, "pref", "count", m16022b + 1);
        return true;
    }

    /* renamed from: q */
    public static boolean m16032q() {
        if (!"1".equals(f5157t)) {
            return false;
        }
        if (f5158u == -1 || f5159v == 0) {
            return true;
        }
        if (!C1477bs.m16015a(f5159v, C1476br.m16021b(f5138a, "pref", "pushSerTime", 0L))) {
            m16046c(f5138a);
            C1476br.m16025a(f5138a, "pref", "pushCount", 1);
            return true;
        }
        int m16022b = C1476br.m16022b(f5138a, "pref", "pushCount", 0);
        if (m16022b >= f5158u) {
            return false;
        }
        C1476br.m16025a(f5138a, "pref", "pushCount", m16022b + 1);
        return true;
    }

    /* renamed from: r */
    public static synchronized boolean m16031r() {
        boolean equals;
        synchronized (C1473bp.class) {
            equals = "1".equals(f5162y);
        }
        return equals;
    }
}
