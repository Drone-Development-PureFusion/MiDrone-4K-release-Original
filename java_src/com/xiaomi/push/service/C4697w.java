package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
import com.xiaomi.xmpush.thrift.C4766ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.w */
/* loaded from: classes2.dex */
public final class C4697w extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19207b;

    /* renamed from: c */
    final /* synthetic */ C4766ab f19208c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4697w(int i, XMPushService xMPushService, C4766ab c4766ab) {
        super(i);
        this.f19207b = xMPushService;
        this.f19208c = c4766ab;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            C4766ab m4109a = C4689s.m4109a((Context) this.f19207b, this.f19208c);
            m4109a.m3727m().m3301a("miui_message_unrecognized", "1");
            C4598aa.m4440a(this.f19207b, m4109a);
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19207b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send ack message for unrecognized new miui message.";
    }
}
