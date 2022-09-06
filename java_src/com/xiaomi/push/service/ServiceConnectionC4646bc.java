package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.bc */
/* loaded from: classes.dex */
public class ServiceConnectionC4646bc implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ XMPushService f19064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC4646bc(XMPushService xMPushService) {
        this.f19064a = xMPushService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        AbstractC4478b.m5038b("onServiceConnected " + iBinder);
        Service m4502a = XMJobService.m4502a();
        if (m4502a == null) {
            AbstractC4478b.m5041a("XMService connected but innerService is null " + iBinder);
            return;
        }
        XMPushService xMPushService = this.f19064a;
        i = XMPushService.f18888g;
        xMPushService.startForeground(i, XMPushService.m4496a((Context) this.f19064a));
        i2 = XMPushService.f18888g;
        m4502a.startForeground(i2, XMPushService.m4496a((Context) this.f19064a));
        m4502a.stopForeground(true);
        this.f19064a.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
