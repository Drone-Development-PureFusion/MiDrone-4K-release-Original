package com.tencent.open.p229b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.Global;
import java.util.Locale;
/* renamed from: com.tencent.open.b.c */
/* loaded from: classes2.dex */
public class C4339c {

    /* renamed from: d */
    private static String f18134d;

    /* renamed from: a */
    static String f18131a = null;

    /* renamed from: b */
    static String f18132b = null;

    /* renamed from: c */
    static String f18133c = null;

    /* renamed from: e */
    private static String f18135e = null;

    /* renamed from: a */
    public static String m5420a() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            Context context = Global.getContext();
            if (context != null && (wifiManager = (WifiManager) context.getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getMacAddress();
            }
            return "";
        } catch (SecurityException e) {
            C4331f.m5444b("MobileInfoUtil", "getLocalMacAddress>>>", e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m5419a(Context context) {
        if (!TextUtils.isEmpty(f18134d)) {
            return f18134d;
        }
        if (context == null) {
            return "";
        }
        f18134d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            f18134d = width + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f18134d;
    }

    /* renamed from: b */
    public static String m5418b() {
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: b */
    public static String m5417b(Context context) {
        if (f18131a == null || f18131a.length() <= 0) {
            if (context == null) {
                return "";
            }
            try {
                f18131a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return f18131a;
            } catch (Exception e) {
                return "";
            }
        }
        return f18131a;
    }

    /* renamed from: c */
    public static String m5416c(Context context) {
        if (f18132b == null || f18132b.length() <= 0) {
            if (context == null) {
                return "";
            }
            try {
                f18132b = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                return f18132b;
            } catch (Exception e) {
                return "";
            }
        }
        return f18132b;
    }

    /* renamed from: d */
    public static String m5415d(Context context) {
        if (f18133c == null || f18133c.length() <= 0) {
            if (context == null) {
                return "";
            }
            try {
                f18133c = Settings.Secure.getString(context.getContentResolver(), "android_id");
                return f18133c;
            } catch (Exception e) {
                return "";
            }
        }
        return f18133c;
    }

    /* renamed from: e */
    public static String m5414e(Context context) {
        try {
            if (f18135e == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=").append(m5417b(context)).append('&');
                sb.append("model=").append(Build.MODEL).append('&');
                sb.append("os=").append(Build.VERSION.RELEASE).append('&');
                sb.append("apilevel=").append(Build.VERSION.SDK_INT).append('&');
                String m5424b = C4337a.m5424b(context);
                if (m5424b == null) {
                    m5424b = "";
                }
                sb.append("network=").append(m5424b).append('&');
                sb.append("sdcard=").append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0).append('&');
                sb.append("display=").append(displayMetrics.widthPixels).append('*').append(displayMetrics.heightPixels).append('&');
                sb.append("manu=").append(Build.MANUFACTURER).append("&");
                sb.append("wifi=").append(C4337a.m5421e(context));
                f18135e = sb.toString();
            }
            return f18135e;
        } catch (Exception e) {
            return null;
        }
    }
}
