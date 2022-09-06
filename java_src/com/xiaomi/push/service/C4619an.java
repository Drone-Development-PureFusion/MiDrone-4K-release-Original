package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.xiaomi.channel.commonutils.android.C4473j;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostFilter;
import com.xiaomi.network.HostManager;
import com.xiaomi.network.HostManagerV2;
import com.xiaomi.push.protobuf.C4565a;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.push.service.C4627at;
import com.xiaomi.push.thrift.EnumC4701a;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.util.C4746d;
import com.xiaomi.stats.C4758f;
import com.xiaomi.stats.C4761h;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.an */
/* loaded from: classes.dex */
public class C4619an extends C4627at.AbstractC4628a implements HostManager.HostManagerFactory {

    /* renamed from: a */
    private XMPushService f19010a;

    /* renamed from: b */
    private long f19011b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.an$a */
    /* loaded from: classes2.dex */
    public static class C4620a implements HostManager.HttpGet {
        C4620a() {
        }

        @Override // com.xiaomi.network.HostManager.HttpGet
        /* renamed from: a */
        public String mo4358a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(26));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", C4746d.m3838a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(C4473j.m5063c()));
            String builder = buildUpon.toString();
            AbstractC4478b.m5037c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String m4997a = C4497d.m4997a(C4473j.m5067a(), url);
                C4761h.m3777a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return m4997a;
            } catch (IOException e) {
                C4761h.m3777a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.an$b */
    /* loaded from: classes2.dex */
    static class C4621b extends HostManagerV2 {
        protected C4621b(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
            super(context, hostFilter, httpGet, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaomi.network.HostManagerV2, com.xiaomi.network.HostManager
        public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
            try {
                if (C4758f.m3796a().m3789c()) {
                    str2 = C4627at.m4329e();
                }
                return super.getRemoteFallbackJSON(arrayList, str, str2);
            } catch (IOException e) {
                C4761h.m3780a(0, EnumC4701a.GSLB_ERR.m4077a(), 1, null, C4497d.m4985d(this.sAppContext) ? 1 : 0);
                throw e;
            }
        }
    }

    C4619an(XMPushService xMPushService) {
        this.f19010a = xMPushService;
    }

    /* renamed from: a */
    public static void m4359a(XMPushService xMPushService) {
        C4619an c4619an = new C4619an(xMPushService);
        C4627at.m4340a().m4338a(c4619an);
        synchronized (HostManager.class) {
            HostManager.setHostManagerFactory(c4619an);
            HostManager.init(xMPushService, null, new C4620a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.network.HostManager.HostManagerFactory
    /* renamed from: a */
    public HostManager mo4360a(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
        return new C4621b(context, hostFilter, httpGet, str);
    }

    @Override // com.xiaomi.push.service.C4627at.AbstractC4628a
    /* renamed from: a */
    public void mo4324a(C4565a.C4566a c4566a) {
    }

    @Override // com.xiaomi.push.service.C4627at.AbstractC4628a
    /* renamed from: a */
    public void mo3784a(C4567b.C4569b c4569b) {
        Fallback fallbacksByHost;
        boolean z;
        if (!c4569b.m4647e() || !c4569b.m4648d() || System.currentTimeMillis() - this.f19011b <= Util.MILLSECONDS_OF_HOUR) {
            return;
        }
        AbstractC4478b.m5041a("fetch bucket :" + c4569b.m4648d());
        this.f19011b = System.currentTimeMillis();
        HostManager hostManager = HostManager.getInstance();
        hostManager.clear();
        hostManager.refreshFallbacks();
        AbstractC4713a m4453h = this.f19010a.m4453h();
        if (m4453h == null || (fallbacksByHost = hostManager.getFallbacksByHost(m4453h.m3979c().m3956e())) == null) {
            return;
        }
        ArrayList<String> m4759d = fallbacksByHost.m4759d();
        Iterator<String> it2 = m4759d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            } else if (it2.next().equals(m4453h.mo3931d())) {
                z = false;
                break;
            }
        }
        if (!z || m4759d.isEmpty()) {
            return;
        }
        AbstractC4478b.m5041a("bucket changed, force reconnect");
        this.f19010a.m4499a(0, (Exception) null);
        this.f19010a.m4477a(false);
    }
}
