package com.xiaomi.push.service;

import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.XMPushService;
/* renamed from: com.xiaomi.push.service.bf */
/* loaded from: classes.dex */
class C4649bf implements C4612ak.AbstractC4613a {

    /* renamed from: a */
    final /* synthetic */ XMPushService f19067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4649bf(XMPushService xMPushService) {
        this.f19067a = xMPushService;
    }

    @Override // com.xiaomi.push.service.C4612ak.AbstractC4613a
    /* renamed from: a */
    public void mo4284a() {
        this.f19067a.m4447n();
        if (C4612ak.m4383a().m4373c() <= 0) {
            this.f19067a.m4494a(new XMPushService.C4587f(12, null));
        }
    }
}
