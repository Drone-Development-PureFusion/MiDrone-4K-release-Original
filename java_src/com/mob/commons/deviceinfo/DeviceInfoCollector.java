package com.mob.commons.deviceinfo;

import android.content.Context;
import com.mob.commons.clt.DvcClt;
@Deprecated
/* loaded from: classes.dex */
public class DeviceInfoCollector {
    public static synchronized void startCollector(Context context) {
        synchronized (DeviceInfoCollector.class) {
            DvcClt.startCollector(context);
        }
    }
}
