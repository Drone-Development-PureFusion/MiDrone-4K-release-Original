package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
import com.xiaomi.xmpush.thrift.C4766ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.t */
/* loaded from: classes2.dex */
public final class C4690t extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19194b;

    /* renamed from: c */
    final /* synthetic */ C4766ab f19195c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4690t(int i, XMPushService xMPushService, C4766ab c4766ab) {
        super(i);
        this.f19194b = xMPushService;
        this.f19195c = c4766ab;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            C4598aa.m4440a(this.f19194b, C4598aa.m4436a(this.f19195c.m3730j(), this.f19195c.m3732h()));
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19194b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send app absent message.";
    }
}
