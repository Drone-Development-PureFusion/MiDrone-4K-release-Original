package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.C4410a;
import com.tencent.stat.common.C4415f;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.C4425p;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.p232a.C4397a;
import com.tencent.stat.p232a.C4398b;
import com.tencent.stat.p232a.C4399c;
import com.tencent.stat.p232a.C4400d;
import com.tencent.stat.p232a.C4403g;
import com.tencent.stat.p232a.C4404h;
import com.tencent.stat.p232a.C4406j;
import com.tencent.stat.p232a.C4407k;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Thread;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StatService {

    /* renamed from: a */
    private static Handler f18346a;

    /* renamed from: b */
    private static volatile Map<C4399c, Long> f18347b = new ConcurrentHashMap();

    /* renamed from: c */
    private static volatile long f18348c = 0;

    /* renamed from: d */
    private static volatile long f18349d = 0;

    /* renamed from: e */
    private static volatile int f18350e = 0;

    /* renamed from: f */
    private static volatile String f18351f = "";

    /* renamed from: g */
    private static volatile String f18352g = "";

    /* renamed from: h */
    private static Map<String, Long> f18353h = new ConcurrentHashMap();

    /* renamed from: i */
    private static StatLogger f18354i = C4420k.m5197b();

    /* renamed from: j */
    private static Thread.UncaughtExceptionHandler f18355j = null;

    /* renamed from: k */
    private static volatile boolean f18356k = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m5270a(Context context, boolean z) {
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = z && currentTimeMillis - f18348c >= ((long) StatConfig.getSessionTimoutMillis());
        f18348c = currentTimeMillis;
        if (f18349d == 0) {
            f18349d = C4420k.m5193c();
        }
        if (currentTimeMillis >= f18349d) {
            f18349d = C4420k.m5193c();
            if (C4436n.m5134a(context).m5121b(context).getUserType() != 1) {
                C4436n.m5134a(context).m5121b(context).m5306b(1);
            }
            StatConfig.m5288b(0);
            StatMid.m5282a(context);
            z3 = true;
        }
        if (!f18356k) {
            z2 = z3;
        }
        if (z2) {
            if (StatConfig.m5283e() < StatConfig.getMaxDaySessionNumbers()) {
                C4420k.m5207F(context);
                m5264d(context);
            } else {
                f18354i.m5236e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (f18356k) {
            C4415f.m5219b(context);
            testSpeed(context);
            m5263e(context);
            f18356k = false;
        }
        return f18350e;
    }

    /* renamed from: a */
    static JSONObject m5274a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (StatConfig.f18308b.f18408d != 0) {
                jSONObject2.put("v", StatConfig.f18308b.f18408d);
            }
            jSONObject.put(Integer.toString(StatConfig.f18308b.f18405a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (StatConfig.f18307a.f18408d != 0) {
                jSONObject3.put("v", StatConfig.f18307a.f18408d);
            }
            jSONObject.put(Integer.toString(StatConfig.f18307a.f18405a), jSONObject3);
        } catch (JSONException e) {
            f18354i.m5237e((Exception) e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    static synchronized void m5273a(Context context) {
        synchronized (StatService.class) {
            if (context != null) {
                if (f18346a == null && m5267b(context)) {
                    if (!C4415f.m5222a(context)) {
                        f18354i.m5236e("ooh, Compatibility problem was found in this device!");
                        f18354i.m5236e("If you are on debug mode, please delete apk and try again.");
                        StatConfig.setEnableStatService(false);
                    } else {
                        HandlerThread handlerThread = new HandlerThread("StatService");
                        handlerThread.start();
                        f18346a = new Handler(handlerThread.getLooper());
                        C4436n.m5134a(context);
                        C4426d.m5147a(context);
                        C4426d.m5144b();
                        StatConfig.getDeviceInfo(context);
                        f18355j = Thread.getDefaultUncaughtExceptionHandler();
                        if (StatConfig.isAutoExceptionCaught()) {
                            Thread.setDefaultUncaughtExceptionHandler(new C4429g(context.getApplicationContext()));
                        } else {
                            f18354i.warn("MTA SDK AutoExceptionCaught is disable");
                        }
                        if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH && C4420k.m5180h(context)) {
                            C4436n.m5134a(context).m5135a(-1);
                        }
                        f18354i.m5238d("Init MTA StatService success.");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static void m5272a(Context context, Throwable th) {
        try {
            if (StatConfig.isEnableStatService()) {
                if (context == null) {
                    f18354i.error("The Context of StatService.reportSdkSelfException() can not be null!");
                } else {
                    C4400d c4400d = new C4400d(context, m5270a(context, false), 99, th);
                    if (m5265c(context) != null) {
                        m5265c(context).post(new RunnableC4433k(c4400d));
                    }
                }
            }
        } catch (Throwable th2) {
            f18354i.m5236e("reportSdkSelfException error: " + th2);
        }
    }

    /* renamed from: a */
    static void m5271a(Context context, Map<String, ?> map) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.sendAdditionEvent() can not be null!");
            return;
        }
        try {
            C4397a c4397a = new C4397a(context, m5270a(context, false), map);
            if (m5265c(context) == null) {
                return;
            }
            m5265c(context).post(new RunnableC4433k(c4397a));
        } catch (Throwable th) {
            f18354i.m5236e(th);
            m5272a(context, th);
        }
    }

    /* renamed from: a */
    static boolean m5269a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    static boolean m5267b(Context context) {
        if (C4420k.m5194b(StatConstants.VERSION) <= C4425p.m5153a(context, StatConfig.f18309c, 0L)) {
            StatConfig.setEnableStatService(false);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static Handler m5265c(Context context) {
        if (f18346a == null) {
            m5273a(context);
        }
        return f18346a;
    }

    public static void commitEvents(Context context, int i) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.commitEvents() can not be null!");
        } else if (i < -1 || i == 0) {
            f18354i.error("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
        } else {
            try {
                C4436n.m5134a(context).m5135a(i);
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    /* renamed from: d */
    static void m5264d(Context context) {
        if (m5265c(context) != null) {
            f18354i.m5238d("start new session.");
            f18350e = C4420k.m5205a();
            StatConfig.m5299a(0);
            StatConfig.m5284d();
            m5265c(context).post(new RunnableC4433k(new C4407k(context, f18350e, m5274a())));
        }
    }

    /* renamed from: e */
    static void m5263e(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.reportNativeCrash() can not be null!");
            return;
        }
        try {
            if (m5265c(context) == null) {
                return;
            }
            m5265c(context).post(new RunnableC4431i(context));
        } catch (Throwable th) {
            f18354i.m5236e(th);
            m5272a(context, th);
        }
    }

    public static void onPause(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.onPause() can not be null!");
        } else {
            trackEndPage(context, C4420k.m5176k(context));
        }
    }

    public static void onResume(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.onResume() can not be null!");
        } else {
            trackBeginPage(context, C4420k.m5176k(context));
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.reportAppMonitorStat() can not be null!");
        } else if (statAppMonitor == null) {
            f18354i.error("The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
        } else if (statAppMonitor.getInterfaceName() == null) {
            f18354i.error("The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
        } else {
            try {
                C4404h c4404h = new C4404h(context, m5270a(context, false), statAppMonitor);
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4433k(c4404h));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void reportError(Context context, String str) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.reportError() can not be null!");
        } else if (m5269a(str)) {
            f18354i.error("Error message in StatService.reportError() is empty.");
        } else {
            try {
                C4400d c4400d = new C4400d(context, m5270a(context, false), str, 0, StatConfig.getMaxReportEventLength());
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4433k(c4400d));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void reportException(Context context, Throwable th) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.reportException() can not be null!");
        } else if (th == null) {
            f18354i.error("The Throwable error message of StatService.reportException() can not be null!");
        } else {
            C4400d c4400d = new C4400d(context, m5270a(context, false), 1, th);
            if (m5265c(context) == null) {
                return;
            }
            m5265c(context).post(new RunnableC4433k(c4400d));
        }
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.reportGameUser() can not be null!");
        } else if (statGameUser == null) {
            f18354i.error("The gameUser of StatService.reportGameUser() can not be null!");
        } else if (statGameUser.getAccount() == null || statGameUser.getAccount().length() == 0) {
            f18354i.error("The account of gameUser on StatService.reportGameUser() can not be null or empty!");
        } else {
            try {
                C4403g c4403g = new C4403g(context, m5270a(context, false), statGameUser);
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4433k(c4403g));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void reportQQ(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (!StatConfig.f18310d.equals(str)) {
            StatConfig.f18310d = new String(str);
            m5271a(context, (Map<String, ?>) null);
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            f18354i.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            C4410a.m5231a(context, map);
        } catch (JSONException e) {
            f18354i.m5237e((Exception) e);
        }
    }

    public static void startNewSession(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.startNewSession() can not be null!");
            return;
        }
        try {
            stopSession();
            m5270a(context, true);
        } catch (Throwable th) {
            f18354i.m5236e(th);
            m5272a(context, th);
        }
    }

    public static boolean startStatService(Context context, String str, String str2) {
        if (!StatConfig.isEnableStatService()) {
            f18354i.error("MTA StatService is disable.");
            return false;
        }
        f18354i.m5238d("MTA SDK version, current: " + StatConstants.VERSION + " ,required: " + str2);
        if (context == null || str2 == null) {
            f18354i.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
        } else if (C4420k.m5194b(StatConstants.VERSION) < C4420k.m5194b(str2)) {
            String str3 = ("MTA SDK version conflicted, current: " + StatConstants.VERSION + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
            f18354i.error(str3);
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException(str3);
        } else {
            try {
                String installChannel = StatConfig.getInstallChannel(context);
                if (installChannel == null || installChannel.length() == 0) {
                    StatConfig.setInstallChannel(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                if (str != null) {
                    StatConfig.setAppKey(context, str);
                }
                m5265c(context);
                m5270a(context, false);
                return true;
            } catch (Throwable th) {
                f18354i.m5236e(th);
                return false;
            }
        }
    }

    public static void stopSession() {
        f18348c = 0L;
    }

    public static void testSpeed(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.testSpeed() can not be null!");
            return;
        }
        try {
            if (m5265c(context) == null) {
                return;
            }
            m5265c(context).post(new RunnableC4432j(context, null));
        } catch (Throwable th) {
            f18354i.m5236e(th);
            m5272a(context, th);
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.testSpeed() can not be null!");
        } else if (map == null || map.size() == 0) {
            f18354i.error("The domainMap of StatService.testSpeed() can not be null or empty!");
        } else {
            try {
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4432j(context, map));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void trackBeginPage(Context context, String str) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null || str == null || str.length() == 0) {
            f18354i.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            return;
        }
        try {
            synchronized (f18353h) {
                if (f18353h.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    f18354i.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                } else {
                    f18351f = str;
                    if (f18353h.containsKey(f18351f)) {
                        f18354i.m5236e("Duplicate PageID : " + f18351f + ", onResume() repeated?");
                    } else {
                        f18353h.put(f18351f, Long.valueOf(System.currentTimeMillis()));
                        m5270a(context, true);
                    }
                }
            }
        } catch (Throwable th) {
            f18354i.m5236e(th);
            m5272a(context, th);
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
        } else if (m5269a(str)) {
            f18354i.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
        } else {
            try {
                C4399c c4399c = new C4399c(str, strArr, null);
                if (f18347b.containsKey(c4399c)) {
                    f18354i.error("Duplicate CustomEvent key: " + c4399c.toString() + ", trackCustomBeginEvent() repeated?");
                } else if (f18347b.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                    f18347b.put(c4399c, Long.valueOf(System.currentTimeMillis()));
                } else {
                    f18354i.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                }
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
        } else if (m5269a(str)) {
            f18354i.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
        } else {
            try {
                C4399c c4399c = new C4399c(str, null, properties);
                if (f18347b.containsKey(c4399c)) {
                    f18354i.error("Duplicate CustomEvent key: " + c4399c.toString() + ", trackCustomBeginKVEvent() repeated?");
                } else if (f18347b.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                    f18347b.put(c4399c, Long.valueOf(System.currentTimeMillis()));
                } else {
                    f18354i.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                }
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void trackCustomEndEvent(Context context, String str, String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        } else if (m5269a(str)) {
            f18354i.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
        } else {
            try {
                C4399c c4399c = new C4399c(str, strArr, null);
                Long remove = f18347b.remove(c4399c);
                if (remove == null) {
                    f18354i.error("No start time found for custom event: " + c4399c.toString() + ", lost trackCustomBeginEvent()?");
                    return;
                }
                C4398b c4398b = new C4398b(context, m5270a(context, false), str);
                c4398b.m5250a(strArr);
                Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                c4398b.m5252a(Long.valueOf(valueOf.longValue() == 0 ? 1L : valueOf.longValue()).longValue());
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4433k(c4398b));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        } else if (m5269a(str)) {
            f18354i.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
        } else {
            try {
                C4399c c4399c = new C4399c(str, null, properties);
                Long remove = f18347b.remove(c4399c);
                if (remove == null) {
                    f18354i.error("No start time found for custom event: " + c4399c.toString() + ", lost trackCustomBeginKVEvent()?");
                    return;
                }
                C4398b c4398b = new C4398b(context, m5270a(context, false), str);
                c4398b.m5251a(properties);
                Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                c4398b.m5252a(Long.valueOf(valueOf.longValue() == 0 ? 1L : valueOf.longValue()).longValue());
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4433k(c4398b));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void trackCustomEvent(Context context, String str, String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.trackCustomEvent() can not be null!");
        } else if (m5269a(str)) {
            f18354i.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        } else {
            try {
                C4398b c4398b = new C4398b(context, m5270a(context, false), str);
                c4398b.m5250a(strArr);
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4433k(c4398b));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            f18354i.error("The Context of StatService.trackCustomEvent() can not be null!");
        } else if (m5269a(str)) {
            f18354i.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        } else {
            try {
                C4398b c4398b = new C4398b(context, m5270a(context, false), str);
                c4398b.m5251a(properties);
                if (m5265c(context) == null) {
                    return;
                }
                m5265c(context).post(new RunnableC4433k(c4398b));
            } catch (Throwable th) {
                f18354i.m5236e(th);
                m5272a(context, th);
            }
        }
    }

    public static void trackEndPage(Context context, String str) {
        Long remove;
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null || str == null || str.length() == 0) {
            f18354i.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            return;
        }
        try {
            synchronized (f18353h) {
                remove = f18353h.remove(str);
            }
            if (remove == null) {
                f18354i.m5236e("Starttime for PageID:" + str + " not found, lost onResume()?");
                return;
            }
            Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
            if (valueOf.longValue() <= 0) {
                valueOf = 1L;
            }
            String str2 = f18352g;
            if (str2 != null && str2.equals(str)) {
                str2 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            if (m5265c(context) != null) {
                C4406j c4406j = new C4406j(context, str2, str, m5270a(context, false), valueOf);
                if (!str.equals(f18351f)) {
                    f18354i.warn("Invalid invocation since previous onResume on diff page.");
                }
                m5265c(context).post(new RunnableC4433k(c4406j));
            }
            f18352g = str;
        } catch (Throwable th) {
            f18354i.m5236e(th);
            m5272a(context, th);
        }
    }
}
