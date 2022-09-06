package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;
/* renamed from: com.xiaomi.stats.b */
/* loaded from: classes2.dex */
class C4753b extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ C4752a f19535b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4753b(C4752a c4752a, int i) {
        super(i);
        this.f19535b = c4752a;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        this.f19535b.m3812c();
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "Handling bind stats";
    }
}
