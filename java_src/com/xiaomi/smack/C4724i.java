package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;
/* renamed from: com.xiaomi.smack.i */
/* loaded from: classes2.dex */
class C4724i extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ long f19401b;

    /* renamed from: c */
    final /* synthetic */ AbstractC4723h f19402c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4724i(AbstractC4723h abstractC4723h, int i, long j) {
        super(i);
        this.f19402c = abstractC4723h;
        this.f19401b = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        Thread.yield();
        if (!this.f19402c.k() || this.f19402c.a(this.f19401b)) {
            return;
        }
        this.f19402c.f19395r.m4499a(22, (Exception) null);
        this.f19402c.f19395r.m4477a(true);
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "check the ping-pong." + this.f19401b;
    }
}
