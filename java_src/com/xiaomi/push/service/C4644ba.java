package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* renamed from: com.xiaomi.push.service.ba */
/* loaded from: classes.dex */
class C4644ba extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19062b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4644ba(XMPushService xMPushService, int i) {
        super(i);
        this.f19062b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        if (this.f19062b.f18895i != null) {
            this.f19062b.f18895i.mo3935b(15, (Exception) null);
            this.f19062b.f18895i = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "disconnect for service destroy.";
    }
}
