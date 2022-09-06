package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.smack.AbstractC4719e;
import com.xiaomi.smack.C4715b;
import java.util.Map;
/* renamed from: com.xiaomi.push.service.bd */
/* loaded from: classes.dex */
class C4647bd extends C4715b {

    /* renamed from: a */
    final /* synthetic */ XMPushService f19065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4647bd(XMPushService xMPushService, Map map, int i, String str, AbstractC4719e abstractC4719e) {
        super(map, i, str, abstractC4719e);
        this.f19065a = xMPushService;
    }

    @Override // com.xiaomi.smack.C4715b
    /* renamed from: a */
    public byte[] mo3964a() {
        try {
            C4567b.C4569b c4569b = new C4567b.C4569b();
            c4569b.m4654a(C4627at.m4340a().m4332c());
            return c4569b.c();
        } catch (Exception e) {
            AbstractC4478b.m5041a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
