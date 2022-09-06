package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.module.C4675b;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.bh */
/* loaded from: classes.dex */
class RunnableC4651bh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f19069a;

    /* renamed from: b */
    final /* synthetic */ String f19070b;

    /* renamed from: c */
    final /* synthetic */ String f19071c;

    /* renamed from: d */
    final /* synthetic */ C4650bg f19072d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4651bh(C4650bg c4650bg, Context context, String str, String str2) {
        this.f19072d = c4650bg;
        this.f19069a = context;
        this.f19070b = str;
        this.f19071c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<C4675b> it2 = C4661g.m4257a(this.f19069a).m4252c(this.f19070b).iterator();
        while (it2.hasNext()) {
            C4675b next = it2.next();
            if (XMPushService.m4498a(next.m4156e(), this.f19071c)) {
                if (next.m4165a() >= System.currentTimeMillis()) {
                    byte[] m4157d = next.m4157d();
                    if (m4157d == null) {
                        AbstractC4478b.m5041a("Geo canBeShownMessage content null");
                    } else {
                        Intent m4094a = C4689s.m4094a(m4157d, System.currentTimeMillis());
                        if (m4094a == null) {
                            AbstractC4478b.m5041a("Geo canBeShownMessage intent null");
                        } else {
                            C4689s.m4099a(this.f19072d.f19068a, (String) null, m4157d, m4094a, true);
                            if (C4661g.m4257a(this.f19072d.f19068a).m4255a(next.m4160b()) == 0) {
                                AbstractC4478b.m5041a("show some exit geofence message. then remove this message failed. message_id:" + next.m4160b());
                            }
                        }
                    }
                } else if (C4661g.m4257a(this.f19069a).m4255a(next.m4160b()) == 0) {
                    AbstractC4478b.m5041a("XMPushService remove some geofence message failed. message_id:" + next.m4160b());
                }
            }
        }
    }
}
