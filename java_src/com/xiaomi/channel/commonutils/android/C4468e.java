package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.reflect.C4500a;
import com.xiaomi.channel.commonutils.string.C4507d;
/* renamed from: com.xiaomi.channel.commonutils.android.e */
/* loaded from: classes2.dex */
public class C4468e {

    /* renamed from: a */
    private static String f18524a = null;

    /* renamed from: b */
    private static String f18525b = null;

    /* renamed from: c */
    private static String f18526c = null;

    /* renamed from: a */
    public static String m5086a() {
        if (Build.VERSION.SDK_INT > 8) {
            return Build.SERIAL;
        }
        return null;
    }

    /* renamed from: a */
    public static String m5085a(Context context) {
        if (f18525b == null) {
            String m5082c = m5082c(context);
            String m5083b = m5083b(context);
            f18525b = "a-" + C4507d.m4944b(m5082c + m5083b + m5086a());
        }
        return f18525b;
    }

    @TargetApi(17)
    /* renamed from: b */
    public static int m5084b() {
        Object m4971a;
        if (Build.VERSION.SDK_INT >= 17 && (m4971a = C4500a.m4971a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(m4971a)).intValue();
        }
        return -1;
    }

    /* renamed from: b */
    public static String m5083b(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            AbstractC4478b.m5039a(th);
            return null;
        }
    }

    /* renamed from: c */
    public static String m5082c(Context context) {
        int i = 10;
        String m5081d = m5081d(context);
        while (m5081d == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
            }
            m5081d = m5081d(context);
            i = i2;
        }
        return m5081d;
    }

    /* renamed from: d */
    public static String m5081d(Context context) {
        Object m4971a;
        Object m4972a;
        if (f18524a != null) {
            return f18524a;
        }
        try {
            String str = (!C4470g.m5075a() || (m4971a = C4500a.m4971a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (m4972a = C4500a.m4972a(m4971a, "getMiuiDeviceId", new Object[0])) == null || !(m4972a instanceof String)) ? null : (String) String.class.cast(m4972a);
            if (str == null && m5077h(context)) {
                str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
            if (str == null) {
                return str;
            }
            f18524a = str;
            return str;
        } catch (Throwable th) {
            AbstractC4478b.m5039a(th);
            return null;
        }
    }

    /* renamed from: e */
    public static synchronized String m5080e(Context context) {
        String str;
        synchronized (C4468e.class) {
            if (f18526c != null) {
                str = f18526c;
            } else {
                String m5083b = m5083b(context);
                f18526c = C4507d.m4944b(m5083b + m5086a());
                str = f18526c;
            }
        }
        return str;
    }

    /* renamed from: f */
    public static String m5079f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    /* renamed from: g */
    public static String m5078g(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            return null;
        }
    }

    /* renamed from: h */
    private static boolean m5077h(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }
}
