package com.mob.commons.appcollector;

import android.content.Context;
import com.mob.commons.clt.PkgClt;
@Deprecated
/* loaded from: classes.dex */
public class PackageCollector {
    public static synchronized boolean register(Context context, String str) {
        boolean register;
        synchronized (PackageCollector.class) {
            register = PkgClt.register(context, str);
        }
        return register;
    }

    public static synchronized void startCollector(Context context) {
        synchronized (PackageCollector.class) {
            PkgClt.startCollector(context);
        }
    }
}
