package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.log.C4562e;
import com.xiaomi.push.log.C4563f;
/* loaded from: classes.dex */
public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger = null;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            for (String str : strArr) {
                if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    private static void setPushLog(Context context) {
        boolean z = sUserLogger != null;
        C4563f c4563f = new C4563f(context);
        if (!sDisablePushLog && hasWritePermission(context) && z) {
            AbstractC4478b.m5043a(new C4562e(sUserLogger, c4563f));
        } else if (!sDisablePushLog && hasWritePermission(context)) {
            AbstractC4478b.m5043a(c4563f);
        } else if (z) {
            AbstractC4478b.m5043a(sUserLogger);
        } else {
            AbstractC4478b.m5043a(new C4562e(null, null));
        }
    }
}
