package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.AbstractC4471h;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.push.service.C4670k;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import java.util.HashMap;
/* renamed from: com.xiaomi.mipush.sdk.aa */
/* loaded from: classes2.dex */
public class C4522aa extends C4484f.AbstractRunnableC4485a {

    /* renamed from: a */
    private Context f18624a;

    public C4522aa(Context context) {
        this.f18624a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4484f.AbstractRunnableC4485a
    /* renamed from: a */
    public int mo4276a() {
        return 13;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4772ae c4772ae = new C4772ae(MiPushClient.generatePacketID(), false);
        C4520a m4909a = C4520a.m4909a(this.f18624a);
        c4772ae.m3695c(EnumC4818o.SyncMIID.f20376N);
        c4772ae.m3698b(m4909a.m4901c());
        c4772ae.m3693d(this.f18624a.getPackageName());
        HashMap hashMap = new HashMap();
        AbstractC4471h.m5070a(hashMap, Constants.EXTRA_KEY_MIID, C4670k.m4213a(this.f18624a).m4206c());
        c4772ae.f19690h = hashMap;
        C4545u.m4818a(this.f18624a).m4807a(c4772ae, EnumC4763a.Notification, true, null);
    }
}
