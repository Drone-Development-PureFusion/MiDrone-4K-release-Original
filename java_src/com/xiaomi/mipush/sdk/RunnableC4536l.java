package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.module.C4676c;
import com.xiaomi.push.service.module.C4677d;
import com.xiaomi.push.service.module.EnumC4680e;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.l */
/* loaded from: classes2.dex */
public final class RunnableC4536l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        context = MiPushClient.sContext;
        C4676c m4150a = C4677d.m4152a(context).m4150a(EnumC4680e.MODULE_CDATA);
        if (m4150a != null) {
            try {
                Method method = m4150a.m4155a().loadClass("com.xiaomi.push.mpcd.MpcdPlugin").getMethod("main", Context.class);
                context2 = MiPushClient.sContext;
                method.invoke(null, context2);
            } catch (Exception e) {
                AbstractC4478b.m5041a("plugin load fail");
            }
        }
    }
}
