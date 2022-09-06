package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4727l;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.bm */
/* loaded from: classes.dex */
public class C4656bm extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ String f19081b;

    /* renamed from: c */
    final /* synthetic */ byte[] f19082c;

    /* renamed from: d */
    final /* synthetic */ XMPushService f19083d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4656bm(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.f19083d = xMPushService;
        this.f19081b = str;
        this.f19082c = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        try {
            C4598aa.m4439a(this.f19083d, this.f19081b, this.f19082c);
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            this.f19083d.m4499a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "send mi push message";
    }
}
