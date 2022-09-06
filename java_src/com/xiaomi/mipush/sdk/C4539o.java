package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.push.service.C4609ah;
import com.xiaomi.push.service.C4610ai;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4823r;
import com.xiaomi.xmpush.thrift.C4836y;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4804f;
import com.xiaomi.xmpush.thrift.EnumC4818o;
/* renamed from: com.xiaomi.mipush.sdk.o */
/* loaded from: classes2.dex */
public class C4539o extends C4484f.AbstractRunnableC4485a {

    /* renamed from: a */
    private Context f18654a;

    public C4539o(Context context) {
        this.f18654a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4484f.AbstractRunnableC4485a
    /* renamed from: a */
    public int mo4276a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4609ah m4394a = C4609ah.m4394a(this.f18654a);
        C4836y c4836y = new C4836y();
        c4836y.m3179a(C4610ai.m4387a(m4394a, EnumC4804f.MISC_CONFIG));
        c4836y.m3175b(C4610ai.m4387a(m4394a, EnumC4804f.PLUGIN_CONFIG));
        C4772ae c4772ae = new C4772ae("-1", false);
        c4772ae.m3695c(EnumC4818o.DailyCheckClientConfig.f20376N);
        c4772ae.m3701a(C4796aq.m3471a(c4836y));
        C4545u.m4818a(this.f18654a).m4809a((C4545u) c4772ae, EnumC4763a.Notification, (C4823r) null);
    }
}
