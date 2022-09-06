package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4480b;
import com.xiaomi.channel.commonutils.reflect.C4500a;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.channel.commonutils.android.b */
/* loaded from: classes.dex */
public class C4464b {

    /* renamed from: com.xiaomi.channel.commonutils.android.b$a */
    /* loaded from: classes2.dex */
    public enum EnumC4465a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: d */
        private final int f18523d;

        EnumC4465a(int i) {
            this.f18523d = i;
        }

        /* renamed from: a */
        public int m5090a() {
            return this.f18523d;
        }
    }

    /* renamed from: a */
    public static String m5100a(Context context) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (!C4480b.m5030a(runningTasks) && runningTasks.get(0) != null && runningTasks.get(0).topActivity != null) {
                return runningTasks.get(0).topActivity.getPackageName();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m5099a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: b */
    public static int m5097b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m5098b(Context context) {
        return TextUtils.equals(context.getPackageName(), m5100a(context));
    }

    /* renamed from: c */
    public static int m5095c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: c */
    public static String m5096c(Context context) {
        if (context == null) {
            return null;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    @TargetApi(19)
    /* renamed from: d */
    public static EnumC4465a m5093d(Context context, String str) {
        EnumC4465a enumC4465a;
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
            return EnumC4465a.UNKNOWN;
        }
        try {
            Integer num = (Integer) C4500a.m4976a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                enumC4465a = EnumC4465a.UNKNOWN;
            } else {
                Integer num2 = (Integer) C4500a.m4972a((AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(context.getPackageManager().getApplicationInfo(str, 0).uid), str);
                enumC4465a = (num2 == null || num2.intValue() != 0) ? EnumC4465a.NOT_ALLOWED : EnumC4465a.ALLOWED;
            }
            return enumC4465a;
        } catch (Throwable th) {
            return EnumC4465a.UNKNOWN;
        }
    }

    /* renamed from: d */
    public static String m5094d(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String[] strArr = runningAppProcessInfo.pkgList;
                for (int i = 0; strArr != null && i < strArr.length; i++) {
                    if (!arrayList.contains(strArr[i])) {
                        arrayList.add(strArr[i]);
                        if (arrayList.size() == 1) {
                            sb.append(((String) arrayList.get(0)).hashCode() % 100000);
                        } else {
                            sb.append("#").append(strArr[i].hashCode() % 100000);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static Signature[] m5092e(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 64).signatures;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m5091f(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
