package com.mob.commons;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.authorize.C4128a;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.p219mi.live.openlivesdk.C4095b;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
/* renamed from: com.mob.commons.a */
/* loaded from: classes.dex */
public class C4125a {

    /* renamed from: a */
    private static HashMap<String, Object> f17260a;

    /* renamed from: b */
    private static long f17261b;

    /* renamed from: c */
    private static long f17262c;

    /* renamed from: d */
    private static boolean f17263d;

    /* renamed from: a */
    public static long m6143a(Context context) {
        long j;
        m6123q(context);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j = Long.valueOf(String.valueOf(f17260a.get("deviceTime"))).longValue();
        } catch (Throwable th) {
            j = 0;
        }
        return ((Long) ResHelper.forceCast(f17260a.get("serverTime"), 0L)).longValue() + (elapsedRealtime - j);
    }

    /* renamed from: b */
    private static void m6140b() {
        f17260a = new HashMap<>();
        f17260a.put("in", 0);
        f17260a.put("all", 0);
        f17260a.put("aspa", 2592000L);
        f17260a.put("un", 0);
        f17260a.put("rt", 0);
        f17260a.put("rtsr", 300000);
        f17260a.put("mi", 0);
        f17260a.put("ext", 0);
        f17260a.put("bs", 0);
        f17260a.put("bsgap", 86400);
        f17260a.put("di", 0);
        f17260a.put("l", 0);
        f17260a.put("lgap", 86400);
        f17260a.put("wi", 0);
        f17260a.put("adle", 172800);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m6138b(String str) {
        try {
            f17260a = new Hashon().fromJson(str);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
    }

    /* renamed from: b */
    public static boolean m6139b(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("rt"), 0)).intValue();
    }

    /* renamed from: c */
    public static int m6137c(Context context) {
        m6123q(context);
        return ((Integer) ResHelper.forceCast(f17260a.get("rtsr"), 300)).intValue();
    }

    /* renamed from: d */
    public static boolean m6136d(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("in"), 0)).intValue();
    }

    /* renamed from: e */
    public static boolean m6135e(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("all"), 0)).intValue();
    }

    /* renamed from: f */
    public static boolean m6134f(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("un"), 0)).intValue();
    }

    /* renamed from: g */
    public static long m6133g(Context context) {
        m6123q(context);
        return ((Long) ResHelper.forceCast(f17260a.get("aspa"), 2592000L)).longValue();
    }

    /* renamed from: h */
    public static boolean m6132h(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("di"), 0)).intValue();
    }

    /* renamed from: i */
    public static boolean m6131i(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("ext"), 0)).intValue();
    }

    /* renamed from: j */
    public static boolean m6130j(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("bs"), 0)).intValue();
    }

    /* renamed from: k */
    public static int m6129k(Context context) {
        m6123q(context);
        return ((Integer) ResHelper.forceCast(f17260a.get("bsgap"), 86400)).intValue();
    }

    /* renamed from: l */
    public static boolean m6128l(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("l"), 0)).intValue();
    }

    /* renamed from: m */
    public static int m6127m(Context context) {
        m6123q(context);
        return ((Integer) ResHelper.forceCast(f17260a.get("lgap"), 86400)).intValue();
    }

    /* renamed from: n */
    public static boolean m6126n(Context context) {
        m6123q(context);
        return 1 == ((Integer) ResHelper.forceCast(f17260a.get("wi"), 0)).intValue();
    }

    /* renamed from: o */
    public static long m6125o(Context context) {
        m6123q(context);
        return (((Integer) ResHelper.forceCast(f17260a.get("adle"), 172800)).intValue() * 1000) + m6143a(context);
    }

    /* renamed from: q */
    private static synchronized void m6123q(Context context) {
        synchronized (C4125a.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (f17260a == null) {
                if (m6122r(context)) {
                    f17261b = elapsedRealtime;
                }
            } else if (elapsedRealtime - f17261b >= 60000 && m6121s(context)) {
                f17261b = elapsedRealtime;
            }
        }
    }

    /* renamed from: r */
    private static boolean m6122r(Context context) {
        String m6120t = m6120t(context);
        if (TextUtils.isEmpty(m6120t)) {
            m6140b();
            return false;
        }
        m6138b(m6120t);
        C4151f.m6017d(context, new Hashon().fromHashMap(f17260a));
        return true;
    }

    /* renamed from: s */
    private static boolean m6121s(Context context) {
        String m6016e = C4151f.m6016e(context);
        if (TextUtils.isEmpty(m6016e)) {
            return m6122r(context);
        }
        m6138b(m6016e);
        if (((Long) ResHelper.forceCast(f17260a.get("timestamp"), 0L)).longValue() - f17262c >= Util.MILLSECONDS_OF_DAY) {
            m6119u(context);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public static String m6120t(Context context) {
        HashMap fromJson;
        try {
            NetworkHelper networkHelper = new NetworkHelper();
            ArrayList<MobProduct> m6036a = C4146e.m6036a();
            if (m6036a.isEmpty()) {
                return null;
            }
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>(C4095b.f17105f, m6036a.get(0).getProductAppkey()));
            arrayList.add(new KVPair<>("plat", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]))));
            arrayList.add(new KVPair<>("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))));
            arrayList.add(new KVPair<>("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersionName", new Object[0]))));
            arrayList.add(new KVPair<>("networktype", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]))));
            String m6117a = new C4128a().m6117a(context);
            if (!TextUtils.isEmpty(m6117a)) {
                arrayList.add(new KVPair<>("duid", m6117a));
            }
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>("User-Identity", C4146e.m6035a(context, m6036a)));
            String httpGet = networkHelper.httpGet(m6118v(context), arrayList, arrayList2, networkTimeOut);
            Hashon hashon = new Hashon();
            HashMap fromJson2 = hashon.fromJson(httpGet);
            if (fromJson2 == null) {
                return null;
            }
            if (!"200".equals(String.valueOf(fromJson2.get("status")))) {
                C4151f.m6015e(context, null);
                C4151f.m6013f(context, null);
                throw new Throwable("response is illegal: " + httpGet);
            }
            String str = (String) ResHelper.forceCast(fromJson2.get("sr"));
            if (str != null && (fromJson = hashon.fromJson(Data.AES128Decode("FYsAXMqlWJLCDpnc", Base64.decode(str, 2)))) != null) {
                HashMap hashMap = (HashMap) ResHelper.forceCast(fromJson.get("cdata"));
                if (hashMap != null) {
                    String str2 = (String) ResHelper.forceCast(hashMap.get("host"));
                    int intValue = ((Integer) ResHelper.forceCast(hashMap.get("httpport"), 0)).intValue();
                    String str3 = (String) ResHelper.forceCast(hashMap.get("path"));
                    if (str2 == null || intValue == 0 || str3 == null) {
                        C4151f.m6015e(context, null);
                    } else {
                        C4151f.m6015e(context, "http://" + str2 + ":" + intValue + str3);
                    }
                } else {
                    C4151f.m6015e(context, null);
                }
                HashMap hashMap2 = (HashMap) ResHelper.forceCast(fromJson.get("cconf"));
                if (hashMap2 != null) {
                    String str4 = (String) ResHelper.forceCast(hashMap2.get("host"));
                    int intValue2 = ((Integer) ResHelper.forceCast(hashMap2.get("httpport"), 0)).intValue();
                    String str5 = (String) ResHelper.forceCast(hashMap2.get("path"));
                    if (str4 == null || intValue2 == 0 || str5 == null) {
                        C4151f.m6013f(context, null);
                    } else {
                        C4151f.m6013f(context, "http://" + str4 + ":" + intValue2 + str5);
                    }
                } else {
                    C4151f.m6013f(context, null);
                }
            }
            String str6 = (String) ResHelper.forceCast(fromJson2.get("sc"));
            if (str6 == null) {
                throw new Throwable("response is illegal: " + httpGet);
            }
            HashMap fromJson3 = hashon.fromJson(Data.AES128Decode("FYsAXMqlWJLCDpnc", Base64.decode(str6, 2)));
            if (fromJson3 == null) {
                throw new Throwable("response is illegal: " + httpGet);
            }
            long longValue = ((Long) ResHelper.forceCast(fromJson2.get("timestamp"), 0L)).longValue();
            fromJson3.put("deviceTime", Long.valueOf(SystemClock.elapsedRealtime()));
            fromJson3.put("serverTime", Long.valueOf(longValue));
            return hashon.fromHashMap(fromJson3);
        } catch (Throwable th) {
            C4151f.m6015e(context, null);
            C4151f.m6013f(context, null);
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.mob.commons.a$1] */
    /* renamed from: u */
    private static void m6119u(final Context context) {
        if (!f17263d) {
            f17263d = true;
            new Thread() { // from class: com.mob.commons.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    String m6120t = C4125a.m6120t(context);
                    if (!TextUtils.isEmpty(m6120t)) {
                        C4125a.m6138b(m6120t);
                        C4151f.m6017d(context, new Hashon().fromHashMap(C4125a.f17260a));
                    }
                    boolean unused = C4125a.f17263d = false;
                }
            }.start();
        }
    }

    /* renamed from: v */
    private static String m6118v(Context context) {
        String str = null;
        try {
            str = C4151f.m6012g(context);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        return TextUtils.isEmpty(str) ? "http://m.data.mob.com/v2/cconf" : str;
    }
}
