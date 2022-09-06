package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.AbstractC4471h;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.android.C4468e;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.y */
/* loaded from: classes2.dex */
public final class RunnableC4550y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f18678a;

    /* renamed from: b */
    final /* synthetic */ boolean f18679b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4550y(Context context, boolean z) {
        this.f18678a = context;
        this.f18679b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String m4781d;
        String m4781d2;
        String m4781d3;
        String m4782c;
        String m4782c2;
        String m4782c3;
        AbstractC4478b.m5041a("do sync info");
        C4772ae c4772ae = new C4772ae(MiPushClient.generatePacketID(), false);
        C4520a m4909a = C4520a.m4909a(this.f18678a);
        c4772ae.m3695c(EnumC4818o.SyncInfo.f20376N);
        c4772ae.m3698b(m4909a.m4901c());
        c4772ae.m3693d(this.f18678a.getPackageName());
        c4772ae.f19690h = new HashMap();
        AbstractC4471h.m5070a(c4772ae.f19690h, Constants.EXTRA_KEY_APP_VERSION, C4464b.m5099a(this.f18678a, this.f18678a.getPackageName()));
        AbstractC4471h.m5070a(c4772ae.f19690h, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C4464b.m5097b(this.f18678a, this.f18678a.getPackageName())));
        AbstractC4471h.m5070a(c4772ae.f19690h, "push_sdk_vn", "3_2_1");
        AbstractC4471h.m5070a(c4772ae.f19690h, "push_sdk_vc", Integer.toString(30201));
        AbstractC4471h.m5070a(c4772ae.f19690h, Constants.EXTRA_KEY_TOKEN, m4909a.m4900d());
        AbstractC4471h.m5070a(c4772ae.f19690h, Constants.EXTRA_KEY_IMEI_MD5, C4507d.m4948a(C4468e.m5082c(this.f18678a)));
        AbstractC4471h.m5070a(c4772ae.f19690h, Constants.EXTRA_KEY_REG_ID, m4909a.m4899e());
        AbstractC4471h.m5070a(c4772ae.f19690h, Constants.EXTRA_KEY_REG_SECRET, m4909a.m4898f());
        AbstractC4471h.m5070a(c4772ae.f19690h, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f18678a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f18679b) {
            Map<String, String> map = c4772ae.f19690h;
            m4782c = C4549x.m4782c(MiPushClient.getAllAlias(this.f18678a));
            AbstractC4471h.m5070a(map, Constants.EXTRA_KEY_ALIASES_MD5, m4782c);
            Map<String, String> map2 = c4772ae.f19690h;
            m4782c2 = C4549x.m4782c(MiPushClient.getAllTopic(this.f18678a));
            AbstractC4471h.m5070a(map2, Constants.EXTRA_KEY_TOPICS_MD5, m4782c2);
            Map<String, String> map3 = c4772ae.f19690h;
            m4782c3 = C4549x.m4782c(MiPushClient.getAllUserAccount(this.f18678a));
            AbstractC4471h.m5070a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, m4782c3);
        } else {
            Map<String, String> map4 = c4772ae.f19690h;
            m4781d = C4549x.m4781d(MiPushClient.getAllAlias(this.f18678a));
            AbstractC4471h.m5070a(map4, Constants.EXTRA_KEY_ALIASES, m4781d);
            Map<String, String> map5 = c4772ae.f19690h;
            m4781d2 = C4549x.m4781d(MiPushClient.getAllTopic(this.f18678a));
            AbstractC4471h.m5070a(map5, Constants.EXTRA_KEY_TOPICS, m4781d2);
            Map<String, String> map6 = c4772ae.f19690h;
            m4781d3 = C4549x.m4781d(MiPushClient.getAllUserAccount(this.f18678a));
            AbstractC4471h.m5070a(map6, Constants.EXTRA_KEY_ACCOUNTS, m4781d3);
        }
        C4545u.m4818a(this.f18678a).m4807a(c4772ae, EnumC4763a.Notification, false, null);
    }
}
