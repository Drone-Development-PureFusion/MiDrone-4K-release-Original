package com.xiaomi.stats;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C4702b;
import com.xiaomi.push.thrift.EnumC4701a;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.AbstractC4717d;
import com.xiaomi.smack.C4722g;
/* renamed from: com.xiaomi.stats.e */
/* loaded from: classes.dex */
public class C4757e implements AbstractC4717d {

    /* renamed from: a */
    XMPushService f19539a;

    /* renamed from: b */
    AbstractC4713a f19540b;

    /* renamed from: c */
    private int f19541c;

    /* renamed from: d */
    private Exception f19542d;

    /* renamed from: e */
    private String f19543e;

    /* renamed from: f */
    private long f19544f = 0;

    /* renamed from: g */
    private long f19545g = 0;

    /* renamed from: h */
    private long f19546h = 0;

    /* renamed from: i */
    private long f19547i = 0;

    /* renamed from: j */
    private long f19548j;

    /* renamed from: k */
    private long f19549k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4757e(XMPushService xMPushService) {
        this.f19548j = 0L;
        this.f19549k = 0L;
        this.f19539a = xMPushService;
        this.f19543e = C4497d.m4978k(xMPushService);
        m3798c();
        int myUid = Process.myUid();
        this.f19549k = TrafficStats.getUidRxBytes(myUid);
        this.f19548j = TrafficStats.getUidTxBytes(myUid);
    }

    /* renamed from: c */
    private void m3798c() {
        this.f19545g = 0L;
        this.f19547i = 0L;
        this.f19544f = 0L;
        this.f19546h = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C4497d.m4985d(this.f19539a)) {
            this.f19544f = elapsedRealtime;
        }
        if (this.f19539a.m4457f()) {
            this.f19546h = elapsedRealtime;
        }
    }

    /* renamed from: d */
    private synchronized void m3797d() {
        AbstractC4478b.m5037c("stat connpt = " + this.f19543e + " netDuration = " + this.f19545g + " ChannelDuration = " + this.f19547i + " channelConnectedTime = " + this.f19546h);
        C4702b c4702b = new C4702b();
        c4702b.f19290a = (byte) 0;
        c4702b.m4073a(EnumC4701a.CHANNEL_ONLINE_RATE.m4077a());
        c4702b.m4071a(this.f19543e);
        c4702b.m4059d((int) (System.currentTimeMillis() / 1000));
        c4702b.m4068b((int) (this.f19545g / 1000));
        c4702b.m4063c((int) (this.f19547i / 1000));
        C4758f.m3796a().m3792a(c4702b);
        m3798c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Exception m3804a() {
        return this.f19542d;
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3803a(AbstractC4713a abstractC4713a) {
        m3800b();
        this.f19546h = SystemClock.elapsedRealtime();
        C4761h.m3779a(0, EnumC4701a.CONN_SUCCESS.m4077a(), abstractC4713a.mo3931d(), abstractC4713a.m3971l());
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3802a(AbstractC4713a abstractC4713a, int i, Exception exc) {
        if (this.f19541c == 0 && this.f19542d == null) {
            this.f19541c = i;
            this.f19542d = exc;
            C4761h.m3774b(abstractC4713a.mo3931d(), exc);
        }
        if (i == 22 && this.f19546h != 0) {
            long m3976g = abstractC4713a.m3976g() - this.f19546h;
            if (m3976g < 0) {
                m3976g = 0;
            }
            this.f19547i = m3976g + (C4722g.m3946c() / 2) + this.f19547i;
            this.f19546h = 0L;
        }
        m3800b();
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        AbstractC4478b.m5037c("Stats rx=" + (uidRxBytes - this.f19549k) + ", tx=" + (uidTxBytes - this.f19548j));
        this.f19549k = uidRxBytes;
        this.f19548j = uidTxBytes;
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3801a(AbstractC4713a abstractC4713a, Exception exc) {
        C4761h.m3780a(0, EnumC4701a.CHANNEL_CON_FAIL.m4077a(), 1, abstractC4713a.mo3931d(), C4497d.m4985d(this.f19539a) ? 1 : 0);
        m3800b();
    }

    /* renamed from: b */
    public synchronized void m3800b() {
        if (this.f19539a != null) {
            String m4978k = C4497d.m4978k(this.f19539a);
            boolean m4985d = C4497d.m4985d(this.f19539a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f19544f > 0) {
                this.f19545g += elapsedRealtime - this.f19544f;
                this.f19544f = 0L;
            }
            if (this.f19546h != 0) {
                this.f19547i += elapsedRealtime - this.f19546h;
                this.f19546h = 0L;
            }
            if (m4985d) {
                if ((!TextUtils.equals(this.f19543e, m4978k) && this.f19545g > 30000) || this.f19545g > 5400000) {
                    m3797d();
                }
                this.f19543e = m4978k;
                if (this.f19544f == 0) {
                    this.f19544f = elapsedRealtime;
                }
                if (this.f19539a.m4457f()) {
                    this.f19546h = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: b */
    public void mo3799b(AbstractC4713a abstractC4713a) {
        this.f19541c = 0;
        this.f19542d = null;
        this.f19540b = abstractC4713a;
        C4761h.m3781a(0, EnumC4701a.CONN_SUCCESS.m4077a());
    }
}
