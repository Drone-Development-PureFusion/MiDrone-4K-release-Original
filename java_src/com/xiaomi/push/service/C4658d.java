package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.push.service.module.C4675b;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.d */
/* loaded from: classes.dex */
public class C4658d extends C4484f.AbstractRunnableC4485a {

    /* renamed from: a */
    private XMPushService f19084a;

    public C4658d(XMPushService xMPushService) {
        this.f19084a = xMPushService;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4484f.AbstractRunnableC4485a
    /* renamed from: a */
    public int mo4276a() {
        return 15;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<C4675b> it2 = C4661g.m4257a(this.f19084a).m4258a().iterator();
        while (it2.hasNext()) {
            C4675b next = it2.next();
            if (next.m4165a() < System.currentTimeMillis()) {
                if (C4661g.m4257a(this.f19084a).m4255a(next.m4160b()) == 0) {
                    AbstractC4478b.m5041a("GeofenceDbCleaner delete a geofence message failed message_id:" + next.m4160b());
                }
                C4689s.m4101a(this.f19084a, C4689s.m4095a(next.m4157d()), false, false, true);
            }
        }
    }
}
