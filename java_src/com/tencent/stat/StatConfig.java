package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.C4425p;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* loaded from: classes2.dex */
public class StatConfig {

    /* renamed from: n */
    private static String f18320n;

    /* renamed from: o */
    private static String f18321o;

    /* renamed from: e */
    private static StatLogger f18311e = C4420k.m5197b();

    /* renamed from: a */
    static C4408b f18307a = new C4408b(2);

    /* renamed from: b */
    static C4408b f18308b = new C4408b(1);

    /* renamed from: f */
    private static StatReportStrategy f18312f = StatReportStrategy.APP_LAUNCH;

    /* renamed from: g */
    private static boolean f18313g = true;

    /* renamed from: h */
    private static int f18314h = 30000;

    /* renamed from: i */
    private static int f18315i = 1024;

    /* renamed from: j */
    private static int f18316j = 30;

    /* renamed from: k */
    private static int f18317k = 3;

    /* renamed from: l */
    private static int f18318l = 30;

    /* renamed from: c */
    static String f18309c = "__HIBERNATE__";

    /* renamed from: m */
    private static String f18319m = null;

    /* renamed from: d */
    static String f18310d = "";

    /* renamed from: p */
    private static int f18322p = 1440;

    /* renamed from: q */
    private static int f18323q = 1024;

    /* renamed from: r */
    private static boolean f18324r = true;

    /* renamed from: s */
    private static long f18325s = 0;

    /* renamed from: t */
    private static long f18326t = 300000;
    public static boolean isAutoExceptionCaught = true;

    /* renamed from: u */
    private static String f18327u = "http://pingma.qq.com:80/mstat/report";

    /* renamed from: v */
    private static int f18328v = 0;

    /* renamed from: w */
    private static volatile int f18329w = 0;

    /* renamed from: x */
    private static int f18330x = 20;

    /* renamed from: y */
    private static int f18331y = 0;

    /* renamed from: z */
    private static boolean f18332z = false;

    /* renamed from: A */
    private static int f18304A = 4096;

    /* renamed from: B */
    private static boolean f18305B = false;

    /* renamed from: C */
    private static String f18306C = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m5300a() {
        return f18316j;
    }

    /* renamed from: a */
    static String m5297a(Context context) {
        return C4420k.m5188d(C4425p.m5152a(context, "_mta_ky_tag_", (String) null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m5292a(String str, String str2) {
        try {
            String string = f18308b.f18406b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f18311e.m5233w(th);
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized void m5299a(int i) {
        synchronized (StatConfig.class) {
            f18329w = i;
        }
    }

    /* renamed from: a */
    static void m5296a(Context context, String str) {
        if (str != null) {
            C4425p.m5149b(context, "_mta_ky_tag_", C4420k.m5191c(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5295a(C4408b c4408b) {
        if (c4408b.f18405a == f18308b.f18405a) {
            f18308b = c4408b;
            m5287b(f18308b.f18406b);
        } else if (c4408b.f18405a != f18307a.f18405a) {
        } else {
            f18307a = c4408b;
        }
    }

    /* renamed from: a */
    static void m5294a(C4408b c4408b, JSONObject jSONObject) {
        boolean z;
        boolean z2 = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(next);
                    z = c4408b.f18408d != i ? true : z2;
                    c4408b.f18408d = i;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        c4408b.f18406b = new JSONObject(string);
                    }
                    z = z2;
                } else {
                    if (next.equalsIgnoreCase(C0413a.f922b)) {
                        c4408b.f18407c = jSONObject.getString(C0413a.f922b);
                    }
                    z = z2;
                }
                z2 = z;
            }
            if (!z2) {
                return;
            }
            C4436n m5134a = C4436n.m5134a(C4426d.m5148a());
            if (m5134a != null) {
                m5134a.m5132a(c4408b);
            }
            if (c4408b.f18405a != f18308b.f18405a) {
                return;
            }
            m5287b(c4408b.f18406b);
            m5285c(c4408b.f18406b);
        } catch (JSONException e) {
            f18311e.m5237e((Exception) e);
        } catch (Throwable th) {
            f18311e.m5236e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5291a(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(f18308b.f18405a))) {
                    m5294a(f18308b, jSONObject.getJSONObject(next));
                } else if (next.equalsIgnoreCase(Integer.toString(f18307a.f18405a))) {
                    m5294a(f18307a, jSONObject.getJSONObject(next));
                } else if (!next.equalsIgnoreCase("rs")) {
                    return;
                } else {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(next));
                    if (statReportStrategy != null) {
                        f18312f = statReportStrategy;
                        f18311e.m5238d("Change to ReportStrategy:" + statReportStrategy.name());
                    }
                }
            }
        } catch (JSONException e) {
            f18311e.m5237e((Exception) e);
        }
    }

    /* renamed from: a */
    static void m5290a(boolean z) {
        StatNativeCrashReport.setNativeCrashDebugEnable(z);
    }

    /* renamed from: a */
    static boolean m5298a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    /* renamed from: a */
    private static boolean m5293a(String str) {
        if (str == null) {
            return false;
        }
        if (f18320n == null) {
            f18320n = str;
            return true;
        } else if (f18320n.contains(str)) {
            return false;
        } else {
            f18320n += "|" + str;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static HttpHost m5289b() {
        if (f18319m == null || f18319m.length() <= 0) {
            return null;
        }
        String str = f18319m;
        String[] split = str.split(":");
        int i = 80;
        if (split.length == 2) {
            str = split[0];
            i = Integer.parseInt(split[1]);
        }
        return new HttpHost(str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m5288b(int i) {
        if (i < 0) {
            return;
        }
        f18331y = i;
    }

    /* renamed from: b */
    static void m5287b(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy == null) {
                return;
            }
            setStatSendStrategy(statReportStrategy);
        } catch (JSONException e) {
            f18311e.m5238d("rs not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static synchronized void m5286c() {
        synchronized (StatConfig.class) {
            f18329w++;
        }
    }

    /* renamed from: c */
    static void m5285c(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(f18309c);
            f18311e.m5238d("hibernateVer:" + string + ", current version:" + StatConstants.VERSION);
            long m5194b = C4420k.m5194b(string);
            if (C4420k.m5194b(StatConstants.VERSION) > m5194b) {
                return;
            }
            C4425p.m5150b(C4426d.m5148a(), f18309c, m5194b);
            setEnableStatService(false);
            f18311e.warn("MTA has disable for SDK version of " + string + " or lower.");
        } catch (JSONException e) {
            f18311e.m5238d("__HIBERNATE__ not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static void m5284d() {
        f18331y++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static int m5283e() {
        return f18331y;
    }

    public static synchronized String getAppKey(Context context) {
        String str;
        synchronized (StatConfig.class) {
            if (f18320n != null) {
                str = f18320n;
            } else {
                if (context != null && f18320n == null) {
                    f18320n = C4420k.m5178i(context);
                }
                if (f18320n == null || f18320n.trim().length() == 0) {
                    f18311e.error("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = f18320n;
            }
        }
        return str;
    }

    public static int getCurSessionStatReportCount() {
        return f18329w;
    }

    public static String getCustomProperty(String str) {
        try {
            return f18307a.f18406b.getString(str);
        } catch (Throwable th) {
            f18311e.m5236e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        try {
            String string = f18307a.f18406b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f18311e.m5236e(th);
            return str2;
        }
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            f18311e.error("Context for getCustomUid is null.");
            return null;
        }
        if (f18306C == null) {
            f18306C = C4425p.m5152a(context, "MTA_CUSTOM_UID", "");
        }
        return f18306C;
    }

    public static DeviceInfo getDeviceInfo(Context context) {
        return StatMid.getDeviceInfo(context);
    }

    public static synchronized String getInstallChannel(Context context) {
        String str;
        synchronized (StatConfig.class) {
            if (f18321o != null) {
                str = f18321o;
            } else {
                f18321o = C4420k.m5177j(context);
                if (f18321o == null || f18321o.trim().length() == 0) {
                    f18311e.m5233w("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = f18321o;
            }
        }
        return str;
    }

    public static int getMaxBatchReportCount() {
        return f18318l;
    }

    public static int getMaxDaySessionNumbers() {
        return f18330x;
    }

    public static int getMaxParallelTimmingEvents() {
        return f18323q;
    }

    public static int getMaxReportEventLength() {
        return f18304A;
    }

    public static int getMaxSendRetryCount() {
        return f18317k;
    }

    public static int getMaxSessionStatReportCount() {
        return f18328v;
    }

    public static int getMaxStoreEventCount() {
        return f18315i;
    }

    public static String getMid(Context context) {
        return StatMid.getMid(context);
    }

    public static String getQQ() {
        return f18310d;
    }

    public static int getSendPeriodMinutes() {
        return f18322p;
    }

    public static int getSessionTimoutMillis() {
        return f18314h;
    }

    public static String getStatReportUrl() {
        return f18327u;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return f18312f;
    }

    public static void initNativeCrashReport(Context context, String str) {
        if (!isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18311e.error("The Context of StatConfig.initNativeCrashReport() can not be null!");
        } else {
            StatNativeCrashReport.initNativeCrash(context, str);
        }
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return C4420k.m5197b().isDebugEnable();
    }

    public static boolean isEnableConcurrentProcess() {
        return f18305B;
    }

    public static boolean isEnableSmartReporting() {
        return f18324r;
    }

    public static boolean isEnableStatService() {
        return f18313g;
    }

    public static void setAppKey(Context context, String str) {
        if (context == null) {
            f18311e.error("ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            f18311e.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (f18320n == null) {
                f18320n = m5297a(context);
            }
            if (!m5293a(str) && !m5293a(C4420k.m5178i(context))) {
                return;
            }
            m5296a(context, f18320n);
        }
    }

    public static void setAppKey(String str) {
        if (str == null) {
            f18311e.error("appkey in StatConfig.setAppKey() is null");
        } else if (str.length() > 256) {
            f18311e.error("The length of appkey cann't exceed 256 bytes.");
        } else {
            f18320n = str;
        }
    }

    public static void setAutoExceptionCaught(boolean z) {
        isAutoExceptionCaught = z;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            f18311e.error("Context for setCustomUid is null.");
            return;
        }
        C4425p.m5149b(context, "MTA_CUSTOM_UID", str);
        f18306C = str;
    }

    public static void setDebugEnable(boolean z) {
        C4420k.m5197b().setDebugEnable(z);
        m5290a(z);
    }

    public static void setEnableConcurrentProcess(boolean z) {
        f18305B = z;
    }

    public static void setEnableSmartReporting(boolean z) {
        f18324r = z;
    }

    public static void setEnableStatService(boolean z) {
        f18313g = z;
        if (!z) {
            f18311e.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void setInstallChannel(String str) {
        if (str.length() > 128) {
            f18311e.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f18321o = str;
        }
    }

    public static void setMaxBatchReportCount(int i) {
        if (!m5298a(i, 2, 1000)) {
            f18311e.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
        } else {
            f18318l = i;
        }
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            f18311e.m5236e("maxDaySessionNumbers must be greater than 0.");
        } else {
            f18330x = i;
        }
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (!m5298a(i, 1, 4096)) {
            f18311e.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        } else {
            f18323q = i;
        }
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            f18311e.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            f18304A = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (!m5298a(i, 1, 1000)) {
            f18311e.error("setMaxSendRetryCount can not exceed the range of [1,1000].");
        } else {
            f18317k = i;
        }
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            f18311e.error("maxSessionStatReportCount cannot be less than 0.");
        } else {
            f18328v = i;
        }
    }

    public static void setMaxStoreEventCount(int i) {
        if (!m5298a(i, 0, 500000)) {
            f18311e.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
        } else {
            f18315i = i;
        }
    }

    public static void setQQ(Context context, String str) {
        StatService.reportQQ(context, str);
    }

    public static void setSendPeriodMinutes(int i) {
        if (!m5298a(i, 1, 10080)) {
            f18311e.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        } else {
            f18322p = i;
        }
    }

    public static void setSessionTimoutMillis(int i) {
        if (!m5298a(i, 1000, C0359h.f696Z)) {
            f18311e.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        } else {
            f18314h = i;
        }
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            f18311e.error("statReportUrl cannot be null or empty.");
        } else {
            f18327u = str;
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        f18312f = statReportStrategy;
        f18311e.m5238d("Change to statSendStrategy: " + statReportStrategy);
    }
}
