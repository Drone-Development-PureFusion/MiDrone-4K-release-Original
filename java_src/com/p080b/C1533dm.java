package com.p080b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.b.dm */
/* loaded from: classes.dex */
public class C1533dm {

    /* renamed from: a */
    private static String f5480a = "";

    /* renamed from: b */
    private static String f5481b = "";

    /* renamed from: c */
    private static String f5482c = "";

    /* renamed from: d */
    private static String f5483d = "";

    /* renamed from: e */
    private static String f5484e = null;

    /* renamed from: a */
    public static String m15670a(Context context) {
        try {
            return m15661g(context);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return f5483d;
        } catch (Throwable th) {
            th.printStackTrace();
            return f5483d;
        }
    }

    /* renamed from: a */
    public static void m15669a(String str) {
        f5481b = str;
    }

    /* renamed from: b */
    public static String m15668b(Context context) {
        try {
        } catch (PackageManager.NameNotFoundException e) {
            C1450b.m16187a(e, "AppInfo", "getApplicationName");
        } catch (Throwable th) {
            C1450b.m16187a(th, "AppInfo", "getApplicationName");
        }
        if (!"".equals(f5480a)) {
            return f5480a;
        }
        PackageManager packageManager = context.getPackageManager();
        f5480a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f5480a;
    }

    /* renamed from: b */
    public static void m15667b(String str) {
        f5484e = str;
    }

    /* renamed from: c */
    public static String m15666c(Context context) {
        try {
        } catch (Throwable th) {
            C1450b.m16187a(th, "AppInfo", "getPackageName");
        }
        if (f5481b == null || "".equals(f5481b)) {
            f5481b = context.getApplicationContext().getPackageName();
            return f5481b;
        }
        return f5481b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m15665c(String str) {
        f5483d = str;
    }

    /* renamed from: d */
    public static String m15664d(Context context) {
        try {
        } catch (PackageManager.NameNotFoundException e) {
            C1450b.m16187a(e, "AppInfo", "getApplicationVersion");
        } catch (Throwable th) {
            C1450b.m16187a(th, "AppInfo", "getApplicationVersion");
        }
        if (!"".equals(f5482c)) {
            return f5482c;
        }
        f5482c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        return f5482c;
    }

    /* renamed from: e */
    public static String m15663e(Context context) {
        try {
            if (f5484e != null && !"".equals(f5484e)) {
                return f5484e;
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
            f5484e = stringBuffer.toString();
            return f5484e;
        } catch (PackageManager.NameNotFoundException e) {
            C1450b.m16187a(e, "AppInfo", "getSHA1AndPackage");
            return f5484e;
        } catch (NoSuchAlgorithmException e2) {
            C1450b.m16187a(e2, "AppInfo", "getSHA1AndPackage");
            return f5484e;
        } catch (Throwable th) {
            C1450b.m16187a(th, "AppInfo", "getSHA1AndPackage");
            return f5484e;
        }
    }

    /* renamed from: f */
    public static String m15662f(Context context) {
        try {
            return m15661g(context);
        } catch (PackageManager.NameNotFoundException e) {
            C1450b.m16187a(e, "AppInfo", "getKey");
            return f5483d;
        } catch (Throwable th) {
            C1450b.m16187a(th, "AppInfo", "getKey");
            return f5483d;
        }
    }

    /* renamed from: g */
    private static String m15661g(Context context) {
        if (f5483d == null || f5483d.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return f5483d;
            }
            f5483d = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
        }
        return f5483d;
    }
}
