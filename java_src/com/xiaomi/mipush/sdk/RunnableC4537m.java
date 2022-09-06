package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.C4468e;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.m */
/* loaded from: classes2.dex */
public final class RunnableC4537m implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        context = MiPushClient.sContext;
        if (C4468e.m5082c(context) != null) {
            C4772ae c4772ae = new C4772ae();
            context2 = MiPushClient.sContext;
            c4772ae.m3698b(C4520a.m4909a(context2).m4901c());
            c4772ae.m3695c("client_info_update");
            c4772ae.m3706a(MiPushClient.generatePacketID());
            c4772ae.m3703a(new HashMap());
            Map<String, String> m3688i = c4772ae.m3688i();
            context3 = MiPushClient.sContext;
            m3688i.put(Constants.EXTRA_KEY_IMEI_MD5, C4507d.m4948a(C4468e.m5082c(context3)));
            int m5084b = C4468e.m5084b();
            if (m5084b >= 0) {
                c4772ae.m3688i().put("space_id", Integer.toString(m5084b));
            }
            context4 = MiPushClient.sContext;
            C4545u.m4818a(context4).m4807a(c4772ae, EnumC4763a.Notification, false, null);
        }
    }
}
