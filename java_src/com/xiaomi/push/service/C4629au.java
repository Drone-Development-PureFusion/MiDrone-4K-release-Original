package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.android.C4473j;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4488h;
import com.xiaomi.channel.commonutils.network.AbstractC4496c;
import com.xiaomi.network.HttpUtils;
import com.xiaomi.push.protobuf.C4565a;
import com.xiaomi.push.service.C4627at;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.au */
/* loaded from: classes2.dex */
public class C4629au extends C4488h.AbstractC4490b {

    /* renamed from: a */
    boolean f19034a = false;

    /* renamed from: b */
    final /* synthetic */ C4627at f19035b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4629au(C4627at c4627at) {
        this.f19035b = c4627at;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: b */
    public void mo3817b() {
        try {
            C4565a.C4566a m4701b = C4565a.C4566a.m4701b(Base64.decode(HttpUtils.m4745a(C4473j.m5067a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<AbstractC4496c>) null), 10));
            if (m4701b == null) {
                return;
            }
            this.f19035b.f19032c = m4701b;
            this.f19034a = true;
            this.f19035b.m4325i();
        } catch (Exception e) {
            AbstractC4478b.m5041a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: c */
    public void mo4323c() {
        List list;
        List list2;
        C4627at.AbstractC4628a[] abstractC4628aArr;
        C4565a.C4566a c4566a;
        this.f19035b.f19033d = null;
        if (this.f19034a) {
            synchronized (this.f19035b) {
                list = this.f19035b.f19031b;
                list2 = this.f19035b.f19031b;
                abstractC4628aArr = (C4627at.AbstractC4628a[]) list.toArray(new C4627at.AbstractC4628a[list2.size()]);
            }
            for (C4627at.AbstractC4628a abstractC4628a : abstractC4628aArr) {
                c4566a = this.f19035b.f19032c;
                abstractC4628a.mo4324a(c4566a);
            }
        }
    }
}
