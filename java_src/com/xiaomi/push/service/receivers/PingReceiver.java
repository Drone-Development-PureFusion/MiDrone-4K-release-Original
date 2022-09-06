package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.AbstractC4618am;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.timers.C4691a;
/* loaded from: classes.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4691a.m4085a(false);
        AbstractC4478b.m5037c(intent.getPackage() + " is the package name");
        if (!AbstractC4618am.f18998o.equals(intent.getAction())) {
            AbstractC4478b.m5041a("cancel the old ping timer");
            C4691a.m4087a();
        } else if (!TextUtils.equals(context.getPackageName(), intent.getPackage())) {
        } else {
            AbstractC4478b.m5037c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                context.startService(intent2);
            } catch (Exception e) {
                AbstractC4478b.m5039a(e);
            }
        }
    }
}
