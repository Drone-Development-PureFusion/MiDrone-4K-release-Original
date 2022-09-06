package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.android.AbstractC4471h;
import com.xiaomi.channel.commonutils.android.C4468e;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.push.service.C4609ah;
import com.xiaomi.push.service.C4670k;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4803e;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import java.util.HashMap;
/* renamed from: com.xiaomi.mipush.sdk.z */
/* loaded from: classes2.dex */
public class C4551z implements C4670k.AbstractC4671a {
    public C4551z(Context context) {
        C4670k.m4213a(context).m4212a(this);
    }

    /* renamed from: b */
    private void m4779b(String str, Context context) {
        C4772ae c4772ae = new C4772ae();
        c4772ae.m3695c(EnumC4818o.ClientMIIDUpdate.f20376N);
        c4772ae.m3698b(C4520a.m4909a(context).m4901c());
        c4772ae.m3706a(MiPushClient.generatePacketID());
        HashMap hashMap = new HashMap();
        AbstractC4471h.m5070a(hashMap, Constants.EXTRA_KEY_MIID, str);
        c4772ae.m3703a(hashMap);
        int m5084b = C4468e.m5084b();
        if (m5084b >= 0) {
            c4772ae.m3688i().put("space_id", Integer.toString(m5084b));
        }
        C4545u.m4818a(context).m4807a(c4772ae, EnumC4763a.Notification, true, null);
    }

    /* renamed from: a */
    public void m4780a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long j = sharedPreferences.getLong("last_sync_miid_time", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int m4397a = C4609ah.m4394a(context).m4397a(EnumC4803e.SyncMIIDFrequency.m3437a(), 21600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) <= m4397a) {
        } else {
            C4484f.m5025a(context).m5023a((C4484f.AbstractRunnableC4485a) new C4522aa(context), m4397a);
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
        }
    }

    @Override // com.xiaomi.push.service.C4670k.AbstractC4671a
    /* renamed from: a */
    public void mo4203a(String str, Context context) {
        m4779b(str, context);
    }
}
