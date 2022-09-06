package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.C4479a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C4715b;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.bk */
/* loaded from: classes.dex */
public class C4654bk extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ int f19076b;

    /* renamed from: c */
    final /* synthetic */ byte[] f19077c;

    /* renamed from: d */
    final /* synthetic */ String f19078d;

    /* renamed from: e */
    final /* synthetic */ XMPushService f19079e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4654bk(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f19079e = xMPushService;
        this.f19076b = i2;
        this.f19077c = bArr;
        this.f19078d = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        C4715b c4715b;
        C4683o.m4133b(this.f19079e);
        C4612ak.m4383a().m4378a("5");
        C4479a.m5033a(this.f19076b);
        c4715b = this.f19079e.f18890c;
        c4715b.m3959b(C4715b.m3960b());
        this.f19079e.m4476a(this.f19077c, this.f19078d);
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "clear account cache.";
    }
}
