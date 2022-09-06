package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;
/* renamed from: com.xiaomi.smack.j */
/* loaded from: classes2.dex */
class C4725j extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ int f19403b;

    /* renamed from: c */
    final /* synthetic */ Exception f19404c;

    /* renamed from: d */
    final /* synthetic */ AbstractC4723h f19405d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4725j(AbstractC4723h abstractC4723h, int i, int i2, Exception exc) {
        super(i);
        this.f19405d = abstractC4723h;
        this.f19403b = i2;
        this.f19404c = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        this.f19405d.f19395r.m4499a(this.f19403b, this.f19404c);
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "shutdown the connection. " + this.f19403b + ", " + this.f19404c;
    }
}
