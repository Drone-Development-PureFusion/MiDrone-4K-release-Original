package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.push.service.XMPushService;
/* renamed from: com.xiaomi.push.service.be */
/* loaded from: classes.dex */
class C4648be extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19066b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4648be(XMPushService xMPushService, int i) {
        super(i);
        this.f19066b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        C4598aa.m4442a(this.f19066b);
        if (C4497d.m4985d(this.f19066b)) {
            this.f19066b.m4477a(true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "prepare the mi push account.";
    }
}
