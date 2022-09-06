package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.amap.api.mapcore.util.ey */
/* loaded from: classes.dex */
public class C0976ey {

    /* renamed from: a */
    private static String f3045a = "";

    /* renamed from: b */
    private static String f3046b = "";

    /* renamed from: c */
    private static String f3047c = "";

    /* renamed from: d */
    private static String f3048d = "";

    /* renamed from: e */
    private static String f3049e = null;

    /* renamed from: a */
    public static String m18172a(Context context) {
        try {
            return m18165g(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f3048d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m18171a(String str) {
        f3048d = str;
    }

    /* renamed from: b */
    public static String m18170b(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "AppInfo", "getApplicationName");
        }
        if (!"".equals(f3045a)) {
            return f3045a;
        }
        PackageManager packageManager = context.getPackageManager();
        f3045a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f3045a;
    }

    /* renamed from: c */
    public static String m18169c(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "AppInfo", "getpckn");
        }
        if (f3046b == null || "".equals(f3046b)) {
            f3046b = context.getPackageName();
            return f3046b;
        }
        return f3046b;
    }

    /* renamed from: d */
    public static String m18168d(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "AppInfo", "getApplicationVersion");
        }
        if (!"".equals(f3047c)) {
            return f3047c;
        }
        f3047c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        return f3047c == null ? "" : f3047c;
    }

    /* renamed from: e */
    public static String m18167e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            stringBuffer.append(TextUtils.isEmpty(f3046b) ? packageInfo.packageName : m18169c(context));
            f3049e = stringBuffer.toString();
            return f3049e;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "AppInfo", "getpck");
            return f3049e;
        }
    }

    /* renamed from: f */
    public static String m18166f(Context context) {
        try {
            return m18165g(context);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "AppInfo", "getKey");
            return f3048d;
        }
    }

    /* renamed from: g */
    private static String m18165g(Context context) {
        if (f3048d == null || f3048d.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f3048d;
            }
            f3048d = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            if (f3048d == null) {
                f3048d = "";
            }
        }
        return f3048d;
    }
}
