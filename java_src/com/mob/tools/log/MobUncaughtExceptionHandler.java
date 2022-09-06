package com.mob.tools.log;

import android.util.Log;
import com.mob.tools.MobLog;
import java.lang.Thread;
/* loaded from: classes.dex */
public class MobUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static boolean disable;
    private static boolean isDebug = false;
    private static Thread.UncaughtExceptionHandler oriHandler;

    public static void closeLog() {
        isDebug = false;
    }

    public static void disable() {
        disable = true;
    }

    public static void openLog() {
        isDebug = true;
    }

    public static void register() {
        if (!disable) {
            oriHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new MobUncaughtExceptionHandler());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (isDebug) {
            Log.wtf("MobUncaughtExceptionHandler", th);
        }
        MobLog.getInstance().crash(th);
        if (oriHandler != null) {
            oriHandler.uncaughtException(thread, th);
        }
    }
}
