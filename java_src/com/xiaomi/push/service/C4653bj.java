package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.bj */
/* loaded from: classes2.dex */
class C4653bj extends XMPushService.AbstractC4589h {

    /* renamed from: b */
    final /* synthetic */ ArrayList f19074b;

    /* renamed from: c */
    final /* synthetic */ C4652bi f19075c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4653bj(C4652bi c4652bi, int i, ArrayList arrayList) {
        super(i);
        this.f19075c = c4652bi;
        this.f19074b = arrayList;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: a */
    public void mo3811a() {
        String m4281a;
        String packageName = this.f19075c.f19073a.getPackageName();
        m4281a = this.f19075c.m4281a(packageName);
        ArrayList<C4772ae> m4320a = C4630av.m4320a(this.f19074b, packageName, m4281a);
        if (m4320a == null) {
            AbstractC4478b.m5036d("Get a null XmPushActionNotification when TinyDataHelper.transToTriftObj() in XMPushService.");
            return;
        }
        Iterator<C4772ae> it2 = m4320a.iterator();
        while (it2.hasNext()) {
            C4772ae next = it2.next();
            next.m3705a("uploadWay", "longXMPushService");
            this.f19075c.f19073a.m4478a(packageName, C4796aq.m3471a(C4598aa.m4435a(packageName, m4281a, next, EnumC4763a.Notification)), true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
    /* renamed from: b */
    public String mo3810b() {
        return "Send tiny data.";
    }
}
