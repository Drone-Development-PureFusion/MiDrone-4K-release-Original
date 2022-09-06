package com.xiaomi.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
/* loaded from: classes2.dex */
public class NetworkStatusChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4497d.m4983f(context)) {
            try {
                context.startService(new Intent(context, HostRefreshService.class));
            } catch (Exception e) {
                AbstractC4478b.m5039a(e);
            }
        }
    }
}
