package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
import com.xiaomi.xmpush.thrift.C4766ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.x */
/* loaded from: classes2.dex */
public final class C4698x extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19209b;

    /* renamed from: c */
    final /* synthetic */ C4766ab f19210c;

    /* renamed from: d */
    final /* synthetic */ String f19211d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4698x(int i, XMPushService xMPushService, C4766ab c4766ab, String str) {
        super(i);
        this.f19209b = xMPushService;
        this.f19210c = c4766ab;
        this.f19211d = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            C4766ab m4109a = C4689s.m4109a((Context) this.f19209b, this.f19210c);
            m4109a.m3727m().m3301a("absent_target_package", this.f19211d);
            C4598aa.m4440a(this.f19209b, m4109a);
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19209b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send app absent ack message for message.";
    }
}
