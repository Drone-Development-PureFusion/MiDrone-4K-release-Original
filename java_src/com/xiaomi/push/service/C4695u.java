package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
import com.xiaomi.xmpush.thrift.C4766ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.u */
/* loaded from: classes2.dex */
public final class C4695u extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19203b;

    /* renamed from: c */
    final /* synthetic */ C4766ab f19204c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4695u(int i, XMPushService xMPushService, C4766ab c4766ab) {
        super(i);
        this.f19203b = xMPushService;
        this.f19204c = c4766ab;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            C4598aa.m4440a(this.f19203b, C4689s.m4109a((Context) this.f19203b, this.f19204c));
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19203b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send ack message for message.";
    }
}
