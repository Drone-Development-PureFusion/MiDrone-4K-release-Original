package com.mob.tools.log;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class NLog {
    private static boolean disable;
    private static HashMap<String, NLog> loggers = new HashMap<>();
    private static LogPrinter printer = new LogPrinter();

    static {
        MobUncaughtExceptionHandler.register();
    }

    public NLog() {
        loggers.put(getSDKTag(), this);
        if (loggers.size() == 1) {
            loggers.put("__FIRST__", this);
        }
    }

    public static void disable() {
        disable = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final NLog getInstanceForSDK(final String str, boolean z) {
        NLog nLog = loggers.get(str);
        if (nLog == null) {
            nLog = loggers.get("__FIRST__");
        }
        return (nLog != null || !z) ? nLog : new NLog() { // from class: com.mob.tools.log.NLog.1
            @Override // com.mob.tools.log.NLog
            protected String getSDKTag() {
                return str;
            }
        };
    }

    private final String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void setCollector(String str, LogCollector logCollector) {
        printer.setCollector(str, logCollector);
    }

    public static void setContext(Context context) {
        if (context != null) {
            printer.setContext(context);
            NativeErrorHandler.prepare(context);
        }
    }

    public final int crash(Throwable th) {
        if (disable) {
            return 0;
        }
        return printer.println(getSDKTag(), 6, 1, getStackTraceString(th));
    }

    /* renamed from: d */
    public final int m5972d(Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 3, 0, obj2);
    }

    /* renamed from: d */
    public final int m5971d(Throwable th) {
        if (disable) {
            return 0;
        }
        return printer.println(getSDKTag(), 3, 0, getStackTraceString(th));
    }

    /* renamed from: d */
    public final int m5970d(Throwable th, Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 3, 0, sb.append(obj2).append('\n').append(getStackTraceString(th)).toString());
    }

    /* renamed from: e */
    public final int m5969e(Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 6, 0, obj2);
    }

    /* renamed from: e */
    public final int m5968e(Throwable th) {
        if (disable) {
            return 0;
        }
        return printer.println(getSDKTag(), 6, 0, getStackTraceString(th));
    }

    /* renamed from: e */
    public final int m5967e(Throwable th, Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 6, 0, sb.append(obj2).append('\n').append(getStackTraceString(th)).toString());
    }

    protected abstract String getSDKTag();

    /* renamed from: i */
    public final int m5966i(Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 4, 0, obj2);
    }

    /* renamed from: i */
    public final int m5965i(Throwable th) {
        if (disable) {
            return 0;
        }
        return printer.println(getSDKTag(), 4, 0, getStackTraceString(th));
    }

    /* renamed from: i */
    public final int m5964i(Throwable th, Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 4, 0, sb.append(obj2).append('\n').append(getStackTraceString(th)).toString());
    }

    public final void nativeCrashLog(String str) {
        if (disable) {
            return;
        }
        printer.nativeCrashLog(getSDKTag(), str);
    }

    /* renamed from: v */
    public final int m5963v(Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 2, 0, obj2);
    }

    /* renamed from: v */
    public final int m5962v(Throwable th) {
        if (disable) {
            return 0;
        }
        return printer.println(getSDKTag(), 2, 0, getStackTraceString(th));
    }

    /* renamed from: v */
    public final int m5961v(Throwable th, Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 2, 0, sb.append(obj2).append('\n').append(getStackTraceString(th)).toString());
    }

    /* renamed from: w */
    public final int m5960w(Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 5, 0, obj2);
    }

    /* renamed from: w */
    public final int m5959w(Throwable th) {
        if (disable) {
            return 0;
        }
        return printer.println(getSDKTag(), 5, 0, getStackTraceString(th));
    }

    /* renamed from: w */
    public final int m5958w(Throwable th, Object obj, Object... objArr) {
        if (disable) {
            return 0;
        }
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 5, 0, sb.append(obj2).append('\n').append(getStackTraceString(th)).toString());
    }
}
