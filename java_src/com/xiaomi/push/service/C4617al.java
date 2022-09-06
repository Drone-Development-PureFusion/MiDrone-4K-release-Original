package com.xiaomi.push.service;

import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.al */
/* loaded from: classes2.dex */
public class C4617al implements C4612ak.C4614b.AbstractC4615a {

    /* renamed from: a */
    final /* synthetic */ C4612ak.C4614b f18975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4617al(C4612ak.C4614b c4614b) {
        this.f18975a = c4614b;
    }

    @Override // com.xiaomi.push.service.C4612ak.C4614b.AbstractC4615a
    /* renamed from: a */
    public void mo3815a(C4612ak.EnumC4616c enumC4616c, C4612ak.EnumC4616c enumC4616c2, int i) {
        XMPushService xMPushService;
        XMPushService.C4583b c4583b;
        XMPushService xMPushService2;
        XMPushService.C4583b c4583b2;
        if (enumC4616c2 == C4612ak.EnumC4616c.binding) {
            xMPushService2 = this.f18975a.f18969p;
            c4583b2 = this.f18975a.f18970q;
            xMPushService2.m4493a(c4583b2, 60000L);
            return;
        }
        xMPushService = this.f18975a.f18969p;
        c4583b = this.f18975a.f18970q;
        xMPushService.m4470b(c4583b);
    }
}
