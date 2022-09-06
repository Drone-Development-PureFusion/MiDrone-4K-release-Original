package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.push.service.C4630av;
import com.xiaomi.push.service.C4633aw;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.xiaomi.mipush.sdk.ab */
/* loaded from: classes2.dex */
public class C4523ab implements C4633aw.AbstractC4635b {

    /* renamed from: a */
    private Context f18625a;

    public C4523ab(Context context) {
        this.f18625a = context;
    }

    @Override // com.xiaomi.push.service.C4633aw.AbstractC4635b
    /* renamed from: a */
    public void mo4280a(ArrayList<C4630av.C4632b> arrayList) {
        if (arrayList == null) {
            AbstractC4478b.m5036d("[MiTinyDataClient]:requests is null, MiTinyDataClient upload by long connection failed.");
            return;
        }
        ArrayList<C4772ae> m4320a = C4630av.m4320a(arrayList, this.f18625a.getPackageName(), C4520a.m4909a(this.f18625a).m4901c());
        if (m4320a == null) {
            AbstractC4478b.m5036d("Get a null XmPushActionNotification when TinyDataHelper.transToTriftObj() in MiPushClient.");
            return;
        }
        Iterator<C4772ae> it2 = m4320a.iterator();
        while (it2.hasNext()) {
            C4772ae next = it2.next();
            next.m3705a("uploadWay", "longMiTinyClient");
            C4545u.m4818a(this.f18625a).m4807a(next, EnumC4763a.Notification, true, null);
        }
    }

    @Override // com.xiaomi.push.service.C4633aw.AbstractC4635b
    /* renamed from: a */
    public boolean mo4283a(C4630av.C4632b c4632b) {
        return C4497d.m4985d(this.f18625a);
    }
}
