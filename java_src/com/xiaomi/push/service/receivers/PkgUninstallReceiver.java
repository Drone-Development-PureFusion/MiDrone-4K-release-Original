package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.AbstractC4623ap;
import com.xiaomi.push.service.C4662h;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes2.dex */
public class PkgUninstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            return;
        }
        boolean z = intent.getExtras().getBoolean("android.intent.extra.REPLACING");
        Uri data = intent.getData();
        if (data == null || z) {
            return;
        }
        try {
            Intent intent2 = new Intent(context, XMPushService.class);
            intent2.setAction(AbstractC4623ap.f19015a);
            intent2.putExtra("uninstall_pkg_name", data.getEncodedSchemeSpecificPart());
            context.startService(intent2);
            C4662h.m4250a(context.getApplicationContext(), data.getEncodedSchemeSpecificPart());
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
        }
    }
}
