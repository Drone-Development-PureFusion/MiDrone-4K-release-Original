package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.amap.api.services.core.w */
/* loaded from: classes.dex */
public class C1259w {

    /* renamed from: d */
    private static String f4195d;

    /* renamed from: a */
    private static String f4192a = "";

    /* renamed from: b */
    private static String f4193b = null;

    /* renamed from: c */
    private static String f4194c = "";

    /* renamed from: e */
    private static String f4196e = null;

    /* renamed from: a */
    public static String m16926a(Context context) {
        try {
        } catch (PackageManager.NameNotFoundException e) {
            C1190ay.m17177a(e, "AppInfo", "getApplicationName");
            e.printStackTrace();
        } catch (Throwable th) {
            C1190ay.m17177a(th, "AppInfo", "getApplicationName");
            th.printStackTrace();
        }
        if (!"".equals(f4192a)) {
            return f4192a;
        }
        PackageManager packageManager = context.getPackageManager();
        f4192a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f4192a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m16925a(String str) {
        f4195d = str;
    }

    /* renamed from: b */
    public static String m16924b(Context context) {
        try {
        } catch (Throwable th) {
            C1190ay.m17177a(th, "AppInfo", "getPackageName");
            th.printStackTrace();
        }
        if (f4193b == null || "".equals(f4193b)) {
            f4193b = context.getApplicationContext().getPackageName();
            return f4193b;
        }
        return f4193b;
    }

    /* renamed from: c */
    public static String m16923c(Context context) {
        try {
        } catch (PackageManager.NameNotFoundException e) {
            C1190ay.m17177a(e, "AppInfo", "getApplicationVersion");
            e.printStackTrace();
        } catch (Throwable th) {
            C1190ay.m17177a(th, "AppInfo", "getApplicationVersion");
            th.printStackTrace();
        }
        if (!"".equals(f4194c)) {
            return f4194c;
        }
        f4194c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        return f4194c;
    }

    /* renamed from: d */
    public static String m16922d(Context context) {
        try {
            if (f4196e != null && !"".equals(f4196e)) {
                return f4196e;
            }
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
            stringBuffer.append(packageInfo.packageName);
            f4196e = stringBuffer.toString();
            return f4196e;
        } catch (PackageManager.NameNotFoundException e) {
            C1190ay.m17177a(e, "AppInfo", "getSHA1AndPackage");
            e.printStackTrace();
            return f4196e;
        } catch (NoSuchAlgorithmException e2) {
            C1190ay.m17177a(e2, "AppInfo", "getSHA1AndPackage");
            e2.printStackTrace();
            return f4196e;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "AppInfo", "getSHA1AndPackage");
            th.printStackTrace();
            return f4196e;
        }
    }

    /* renamed from: e */
    public static String m16921e(Context context) {
        try {
            return m16919g(context);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return f4195d;
        } catch (Throwable th) {
            th.printStackTrace();
            return f4195d;
        }
    }

    /* renamed from: f */
    public static String m16920f(Context context) {
        try {
            return m16919g(context);
        } catch (PackageManager.NameNotFoundException e) {
            C1190ay.m17177a(e, "AppInfo", "getKey");
            e.printStackTrace();
            return f4195d;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "AppInfo", "getKey");
            th.printStackTrace();
            return f4195d;
        }
    }

    /* renamed from: g */
    private static String m16919g(Context context) {
        if (f4195d == null || f4195d.equals("")) {
            f4195d = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.amap.api.v2.apikey");
        }
        return f4195d;
    }
}
