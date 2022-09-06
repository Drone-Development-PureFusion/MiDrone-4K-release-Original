package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.AbstractC4720f;
import com.xiaomi.smack.packet.AbstractC4732d;
/* renamed from: com.xiaomi.push.service.az */
/* loaded from: classes.dex */
class C4642az implements AbstractC4720f {

    /* renamed from: a */
    final /* synthetic */ XMPushService f19060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4642az(XMPushService xMPushService) {
        this.f19060a = xMPushService;
    }

    @Override // com.xiaomi.smack.AbstractC4720f
    /* renamed from: a */
    public void mo3953a(C4707b c4707b) {
        this.f19060a.m4494a(new XMPushService.C4584c(c4707b));
    }

    @Override // com.xiaomi.smack.AbstractC4720f
    /* renamed from: b */
    public void mo3952b(AbstractC4732d abstractC4732d) {
        this.f19060a.m4494a(new XMPushService.C4592k(abstractC4732d));
    }
}
