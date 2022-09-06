package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.mipush.sdk.C4520a;
import com.xiaomi.mipush.sdk.C4540p;
import com.xiaomi.mipush.sdk.C4545u;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.service.C4633aw;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static int f19185a = 1;

    /* renamed from: b */
    private static int f19186b = 1;

    /* renamed from: c */
    private static int f19187c = 2;

    /* renamed from: d */
    private static BlockingQueue<Runnable> f19188d = new LinkedBlockingQueue();

    /* renamed from: e */
    private static ThreadPoolExecutor f19189e = new ThreadPoolExecutor(f19185a, f19186b, f19187c, TimeUnit.SECONDS, f19188d);

    /* renamed from: f */
    private static boolean f19190f = false;

    /* renamed from: g */
    private boolean f19191g;

    public NetworkStatusReceiver() {
        this.f19191g = false;
        this.f19191g = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f19191g = false;
        f19190f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4113a(Context context) {
        if (!C4545u.m4818a(context).m4798c() && C4520a.m4909a(context).m4895i() && !C4520a.m4909a(context).m4890n()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                context.startService(intent);
            } catch (Exception e) {
                AbstractC4478b.m5039a(e);
            }
        }
        if (C4497d.m4985d(context) && C4545u.m4818a(context).m4794g()) {
            C4545u.m4818a(context).m4797d();
            C4633aw.m4319a().m4305b("NewWork Changed");
        }
        if (C4497d.m4985d(context)) {
            if ("disable_syncing".equals(C4540p.m4845a(context).m4846a())) {
                MiPushClient.disablePush(context);
            }
            if (!"enable_syncing".equals(C4540p.m4845a(context).m4846a())) {
                return;
            }
            MiPushClient.enablePush(context);
        }
    }

    /* renamed from: a */
    public static boolean m4114a() {
        return f19190f;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f19191g) {
            return;
        }
        f19189e.execute(new RunnableC4688a(this, context));
    }
}
