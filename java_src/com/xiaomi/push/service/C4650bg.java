package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.smack.util.C4747e;
import org.p248a.p249a.C5083e;
/* renamed from: com.xiaomi.push.service.bg */
/* loaded from: classes.dex */
class C4650bg extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ XMPushService f19068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4650bg(XMPushService xMPushService) {
        this.f19068a = xMPushService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean m4479a;
        if (intent.getAction().equals("com.xiaomi.metok.geofencing.state_change")) {
            String stringExtra = intent.getStringExtra(C5083e.f21644H);
            String stringExtra2 = intent.getStringExtra("Describe");
            String stringExtra3 = intent.getStringExtra("State");
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            m4479a = this.f19068a.m4479a(stringExtra3, stringExtra2, context);
            if (!m4479a) {
                stringExtra3 = "Unknown";
                AbstractC4478b.m5041a(" updated geofence statue about geo_id:" + stringExtra2 + " falied. current_statue:" + stringExtra3);
            }
            C4747e.m3831a(new RunnableC4651bh(this, context, stringExtra2, stringExtra3));
            AbstractC4478b.m5037c("ownresilt结果:state= " + stringExtra3 + "\n describe=" + stringExtra2 + "\n location=" + stringExtra);
        }
    }
}
