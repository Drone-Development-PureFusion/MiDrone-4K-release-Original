package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
import com.xiaomi.xmpush.thrift.C4766ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.y */
/* loaded from: classes2.dex */
public final class C4699y extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ XMPushService f19212b;

    /* renamed from: c */
    final /* synthetic */ C4766ab f19213c;

    /* renamed from: d */
    final /* synthetic */ String f19214d;

    /* renamed from: e */
    final /* synthetic */ String f19215e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4699y(int i, XMPushService xMPushService, C4766ab c4766ab, String str, String str2) {
        super(i);
        this.f19212b = xMPushService;
        this.f19213c = c4766ab;
        this.f19214d = str;
        this.f19215e = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            C4766ab m4109a = C4689s.m4109a((Context) this.f19212b, this.f19213c);
            m4109a.f19631h.m3301a(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, this.f19214d);
            m4109a.f19631h.m3301a("reason", this.f19215e);
            C4598aa.m4440a(this.f19212b, m4109a);
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19212b.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send wrong message ack for message.";
    }
}
