package com.github.moduth.blockcanary.p215b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.github.moduth.blockcanary.C3953c;
import java.util.List;
/* renamed from: com.github.moduth.blockcanary.b.d */
/* loaded from: classes.dex */
public class C3952d {

    /* renamed from: a */
    private static volatile String f16940a;

    /* renamed from: b */
    private static final Object f16941b = new Object();

    private C3952d() {
        throw new InstantiationError("Must not instantiate this class");
    }

    /* renamed from: a */
    public static String m6387a() {
        String str;
        if (f16940a != null) {
            return f16940a;
        }
        synchronized (f16941b) {
            if (f16940a != null) {
                str = f16940a;
            } else {
                f16940a = m6386a(C3953c.m6380b().mo6365e());
                str = f16940a;
            }
        }
        return str;
    }

    /* renamed from: a */
    private static String m6386a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
