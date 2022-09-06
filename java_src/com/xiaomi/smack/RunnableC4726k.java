package com.xiaomi.smack;

import com.xiaomi.network.HostManager;
/* renamed from: com.xiaomi.smack.k */
/* loaded from: classes2.dex */
class RunnableC4726k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f19406a;

    /* renamed from: b */
    final /* synthetic */ AbstractC4723h f19407b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4726k(AbstractC4723h abstractC4723h, String str) {
        this.f19407b = abstractC4723h;
        this.f19406a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HostManager.getInstance().getFallbacksByHost(this.f19406a, true);
    }
}
