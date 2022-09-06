package com.xiaomi.push.service.receivers;

import android.content.Context;
/* renamed from: com.xiaomi.push.service.receivers.a */
/* loaded from: classes.dex */
class RunnableC4688a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f19192a;

    /* renamed from: b */
    final /* synthetic */ NetworkStatusReceiver f19193b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4688a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f19193b = networkStatusReceiver;
        this.f19192a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19193b.m4113a(this.f19192a);
    }
}
