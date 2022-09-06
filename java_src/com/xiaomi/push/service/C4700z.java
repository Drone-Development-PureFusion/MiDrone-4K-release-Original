package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
import com.xiaomi.xmpush.thrift.C4766ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.z */
/* loaded from: classes2.dex */
public final class C4700z extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19216b;

    /* renamed from: c */
    final /* synthetic */ C4766ab f19217c;

    /* renamed from: d */
    final /* synthetic */ boolean f19218d;

    /* renamed from: e */
    final /* synthetic */ boolean f19219e;

    /* renamed from: f */
    final /* synthetic */ boolean f19220f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4700z(int i, XMPushService xMPushService, C4766ab c4766ab, boolean z, boolean z2, boolean z3) {
        super(i);
        this.f19216b = xMPushService;
        this.f19217c = c4766ab;
        this.f19218d = z;
        this.f19219e = z2;
        this.f19220f = z3;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            C4598aa.m4440a(this.f19216b, C4689s.m4108a((Context) this.f19216b, this.f19217c, this.f19218d, this.f19219e, this.f19220f));
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19216b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send wrong message ack for message.";
    }
}
