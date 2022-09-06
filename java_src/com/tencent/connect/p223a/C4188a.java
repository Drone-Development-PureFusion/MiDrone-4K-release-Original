package com.tencent.connect.p223a;

import android.content.Context;
import com.fimi.soul.biz.p168a.C2355b;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.OpenConfig;
import java.lang.reflect.Method;
/* renamed from: com.tencent.connect.a.a */
/* loaded from: classes.dex */
public class C4188a {

    /* renamed from: a */
    private static Class<?> f17343a = null;

    /* renamed from: b */
    private static Class<?> f17344b = null;

    /* renamed from: c */
    private static Method f17345c = null;

    /* renamed from: d */
    private static Method f17346d = null;

    /* renamed from: e */
    private static Method f17347e = null;

    /* renamed from: f */
    private static Method f17348f = null;

    /* renamed from: g */
    private static boolean f17349g = false;

    /* renamed from: a */
    public static void m5956a(Context context, QQToken qQToken, String str, String... strArr) {
        if (!f17349g) {
            return;
        }
        m5955b(context, qQToken);
        try {
            f17346d.invoke(f17344b, context, str, strArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m5957a(Context context, QQToken qQToken) {
        return OpenConfig.getInstance(context, qQToken.getAppId()).getBoolean("Common_ta_enable");
    }

    /* renamed from: b */
    public static void m5955b(Context context, QQToken qQToken) {
        try {
            if (m5957a(context, qQToken)) {
                f17348f.invoke(f17343a, true);
            } else {
                f17348f.invoke(f17343a, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m5954c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f17343a = Class.forName("com.tencent.stat.StatConfig");
            f17344b = Class.forName("com.tencent.stat.StatService");
            f17345c = f17344b.getMethod("reportQQ", new Class[0]);
            f17346d = f17344b.getMethod("trackCustomEvent", new Class[0]);
            f17347e = f17344b.getMethod("commitEvents", new Class[0]);
            f17348f = f17343a.getMethod("setEnableStatService", new Class[0]);
            m5955b(context, qQToken);
            f17343a.getMethod("setAutoExceptionCaught", new Class[0]).invoke(f17343a, false);
            f17343a.getMethod("setEnableSmartReporting", new Class[0]).invoke(f17343a, true);
            f17343a.getMethod("setSendPeriodMinutes", new Class[0]).invoke(f17343a, 1440);
            f17343a.getMethod("setStatSendStrategy", new Class[0]).invoke(f17343a, Integer.valueOf(Class.forName("com.tencent.stat.StatReportStrategy").getField("PERIOD").getInt(null)));
            f17343a.getMethod("setStatReportUrl", new Class[0]).invoke(f17343a, "http://cgi.connect.qq.com/qqconnectutil/sdk");
            f17344b.getMethod("startStatService", new Class[0]).invoke(f17344b, context, str, Integer.valueOf(Class.forName("com.tencent.stat.common.StatConstants").getField(C2355b.f7979e).getInt(null)));
            f17349g = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public static void m5953d(Context context, QQToken qQToken) {
        if (!f17349g) {
            return;
        }
        m5955b(context, qQToken);
        if (qQToken.getOpenId() == null) {
            return;
        }
        try {
            f17345c.invoke(f17344b, context, qQToken.getOpenId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
