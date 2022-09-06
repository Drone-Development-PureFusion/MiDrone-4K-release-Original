package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.C4612ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.ab */
/* loaded from: classes2.dex */
public final class C4599ab implements C4612ak.C4614b.AbstractC4615a {

    /* renamed from: a */
    final /* synthetic */ XMPushService f18929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4599ab(XMPushService xMPushService) {
        this.f18929a = xMPushService;
    }

    @Override // com.xiaomi.push.service.C4612ak.C4614b.AbstractC4615a
    /* renamed from: a */
    public void mo3815a(C4612ak.EnumC4616c enumC4616c, C4612ak.EnumC4616c enumC4616c2, int i) {
        if (enumC4616c2 == C4612ak.EnumC4616c.binded) {
            C4687r.m4118a(this.f18929a);
            C4687r.m4116b(this.f18929a);
        } else if (enumC4616c2 != C4612ak.EnumC4616c.unbind) {
        } else {
            C4687r.m4120a(this.f18929a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
