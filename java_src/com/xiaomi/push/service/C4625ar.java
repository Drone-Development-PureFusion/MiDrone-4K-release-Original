package com.xiaomi.push.service;

import com.tencent.p227mm.sdk.platformtools.LocaleUtil;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.stats.C4758f;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.ar */
/* loaded from: classes.dex */
public class C4625ar {

    /* renamed from: e */
    private static int f19021e = 300000;

    /* renamed from: a */
    private XMPushService f19022a;

    /* renamed from: d */
    private int f19025d = 0;

    /* renamed from: b */
    private int f19023b = 500;

    /* renamed from: c */
    private long f19024c = 0;

    public C4625ar(XMPushService xMPushService) {
        this.f19022a = xMPushService;
    }

    /* renamed from: b */
    private int m4341b() {
        if (this.f19025d > 8) {
            return 300000;
        }
        if (this.f19025d > 4) {
            return 60000;
        }
        if (this.f19025d > 1) {
            return 10000;
        }
        if (this.f19024c == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f19024c >= 300000) {
            this.f19023b = 500;
            return 0;
        } else if (this.f19023b >= f19021e) {
            return this.f19023b;
        } else {
            int i = this.f19023b;
            this.f19023b = (int) (this.f19023b * 1.5d);
            return i;
        }
    }

    /* renamed from: a */
    public void m4343a() {
        this.f19024c = System.currentTimeMillis();
        this.f19022a.m4500a(1);
        this.f19025d = 0;
    }

    /* renamed from: a */
    public void m4342a(boolean z) {
        if (!this.f19022a.m4473b()) {
            AbstractC4478b.m5037c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f19022a.m4472b(1)) {
                this.f19025d++;
            }
            this.f19022a.m4500a(1);
            XMPushService xMPushService = this.f19022a;
            XMPushService xMPushService2 = this.f19022a;
            xMPushService2.getClass();
            xMPushService.m4494a(new XMPushService.C4585d());
        } else if (this.f19022a.m4472b(1)) {
        } else {
            int m4341b = m4341b();
            if (!this.f19022a.m4472b(1)) {
                this.f19025d++;
            }
            AbstractC4478b.m5041a("schedule reconnect in " + m4341b + LocaleUtil.MALAY);
            XMPushService xMPushService3 = this.f19022a;
            XMPushService xMPushService4 = this.f19022a;
            xMPushService4.getClass();
            xMPushService3.m4493a(new XMPushService.C4585d(), m4341b);
            if (this.f19025d == 2 && C4758f.m3796a().m3789c()) {
                C4604ae.m4405b();
            }
            if (this.f19025d != 3) {
                return;
            }
            C4604ae.m4408a();
        }
    }
}
