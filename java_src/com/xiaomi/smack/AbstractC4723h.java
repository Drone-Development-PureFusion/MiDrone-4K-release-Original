package com.xiaomi.smack;

import android.os.SystemClock;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.ViewCompat;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.Host;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.util.C4747e;
import com.xiaomi.stats.C4761h;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.xiaomi.smack.h */
/* loaded from: classes.dex */
public abstract class AbstractC4723h extends AbstractC4713a {

    /* renamed from: p */
    protected Socket f19393p;

    /* renamed from: r */
    protected XMPushService f19395r;

    /* renamed from: v */
    private String f19399v;

    /* renamed from: w */
    private int f19400w;

    /* renamed from: o */
    protected Exception f19392o = null;

    /* renamed from: q */
    String f19394q = null;

    /* renamed from: s */
    protected volatile long f19396s = 0;

    /* renamed from: t */
    protected volatile long f19397t = 0;

    /* renamed from: u */
    protected volatile long f19398u = 0;

    public AbstractC4723h(XMPushService xMPushService, C4715b c4715b) {
        super(xMPushService, c4715b);
        this.f19395r = xMPushService;
    }

    /* renamed from: a */
    private void m3943a(C4715b c4715b) {
        m3941a(c4715b.m3956e(), c4715b.m3957d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0225, code lost:
        if (android.text.TextUtils.equals(r10, com.xiaomi.channel.commonutils.network.C4497d.m4978k(r16.f19395r)) != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0228 A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m3941a(String str, int i) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        this.f19392o = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = AbstractC4478b.m5035e("get bucket for host : " + str).intValue();
        Fallback m3934b = m3934b(str);
        AbstractC4478b.m5042a(Integer.valueOf(intValue));
        if (m3934b != null) {
            arrayList = m3934b.mo4737a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.f19398u = 0L;
        String m4978k = C4497d.m4978k(this.f19395r);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = z3;
                break;
            }
            String next = it2.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.f19358b++;
            try {
                AbstractC4478b.m5041a("begin to connect to " + next);
                this.f19393p = m3928s();
                this.f19393p.connect(Host.m4753b(next, i), 8000);
                AbstractC4478b.m5041a("tcp connected");
                this.f19393p.setTcpNoDelay(true);
                this.f19399v = next;
                mo3936b();
                z = true;
                try {
                    this.f19359c = System.currentTimeMillis() - currentTimeMillis;
                    this.f19367k = m4978k;
                    if (m3934b != 0) {
                        m3934b.m4763b(next, this.f19359c, 0L);
                    }
                    this.f19398u = SystemClock.elapsedRealtime();
                    AbstractC4478b.m5041a("connected to " + next + " in " + this.f19359c);
                    break;
                } catch (C4727l e) {
                    e = e;
                    if (m3934b != 0) {
                        try {
                            m3934b.m4762b(next, System.currentTimeMillis() - currentTimeMillis, 0L, e);
                        } catch (Throwable th) {
                            th = th;
                            if (!z) {
                                C4761h.m3776a(next, this.f19392o);
                            }
                            throw th;
                        }
                    }
                    this.f19392o = e;
                    AbstractC4478b.m5036d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" ").append(e.getMessage()).append("\n");
                    if (!z) {
                        C4761h.m3776a(next, this.f19392o);
                        if (!TextUtils.equals(m4978k, C4497d.m4978k(this.f19395r))) {
                            HostManager.getInstance().persist();
                            if (z) {
                            }
                        }
                    }
                    z2 = z;
                    z3 = z2;
                } catch (IOException e2) {
                    e = e2;
                    if (m3934b != null) {
                        m3934b.m4762b(next, System.currentTimeMillis() - currentTimeMillis, 0L, e);
                    }
                    this.f19392o = e;
                    AbstractC4478b.m5036d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" ").append(e.getMessage()).append("\n");
                    if (!z) {
                        C4761h.m3776a(next, this.f19392o);
                        if (!TextUtils.equals(m4978k, C4497d.m4978k(this.f19395r))) {
                            HostManager.getInstance().persist();
                            if (z) {
                            }
                        }
                    }
                    z2 = z;
                    z3 = z2;
                } catch (Throwable th2) {
                    th = th2;
                    z3 = true;
                    try {
                        this.f19392o = new Exception("abnormal exception", th);
                        AbstractC4478b.m5039a(th);
                    } catch (Throwable th3) {
                        th = th3;
                        z = z3;
                        if (!z) {
                        }
                        throw th;
                    }
                    if (!z3) {
                        C4761h.m3776a(next, this.f19392o);
                        if (!TextUtils.equals(m4978k, C4497d.m4978k(this.f19395r))) {
                            z = z3;
                            HostManager.getInstance().persist();
                            if (z) {
                            }
                        }
                    }
                    z2 = z3;
                    z3 = z2;
                }
            } catch (C4727l e3) {
                e = e3;
                z = z3;
            } catch (IOException e4) {
                e = e4;
                z = z3;
            } catch (Throwable th4) {
                th = th4;
            }
            z3 = z2;
        }
        HostManager.getInstance().persist();
        if (z) {
            throw new C4727l(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3944a(int i, Exception exc) {
        if (m() != 2) {
            a(2, i, exc);
            this.f19366j = "";
            try {
                this.f19393p.close();
            } catch (Throwable th) {
            }
            this.f19396s = 0L;
            this.f19397t = 0L;
        }
    }

    /* renamed from: a */
    protected void m3942a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f19398u >= 300000) {
            this.f19400w = 0;
        } else if (!C4497d.m4985d(this.f19395r)) {
        } else {
            this.f19400w++;
            if (this.f19400w < 2) {
                return;
            }
            String mo3931d = mo3931d();
            AbstractC4478b.m5041a("max short conn time reached, sink down current host:" + mo3931d);
            m3940a(mo3931d, 0L, exc);
            this.f19400w = 0;
        }
    }

    /* renamed from: a */
    protected void m3940a(String str, long j, Exception exc) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(C4715b.m3960b(), false);
        if (fallbacksByHost != null) {
            fallbacksByHost.m4762b(str, j, 0L, exc);
            HostManager.getInstance().persist();
        }
    }

    /* renamed from: a */
    protected abstract void mo3939a(boolean z);

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: a */
    public void mo3938a(C4707b[] c4707bArr) {
        throw new C4727l("Don't support send Blob");
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: a */
    public void mo3937a(AbstractC4732d[] abstractC4732dArr) {
        for (AbstractC4732d abstractC4732d : abstractC4732dArr) {
            a(abstractC4732d);
        }
    }

    /* renamed from: b */
    Fallback m3934b(String str) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(str, false);
        if (!fallbacksByHost.mo4736b()) {
            C4747e.m3831a(new RunnableC4726k(this, str));
        }
        this.f19362f = 0;
        try {
            byte[] address = InetAddress.getByName(fallbacksByHost.f18690f).getAddress();
            this.f19362f = address[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            this.f19362f |= (address[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            this.f19362f |= (address[2] << 16) & 16711680;
            this.f19362f = ((address[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | this.f19362f;
        } catch (UnknownHostException e) {
        }
        return fallbacksByHost;
    }

    /* renamed from: b */
    protected synchronized void mo3936b() {
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: b */
    public void mo3935b(int i, Exception exc) {
        mo3944a(i, exc);
        if ((exc != null || i == 18) && this.f19398u != 0) {
            m3942a(exc);
        }
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: b */
    public void mo3933b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo3939a(z);
        if (!z) {
            this.f19395r.m4493a(new C4724i(this, 13, currentTimeMillis), AbstractC0517a.f1169e);
        }
    }

    /* renamed from: c */
    public void m3932c(int i, Exception exc) {
        this.f19395r.m4494a(new C4725j(this, 2, i, exc));
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: d */
    public String mo3931d() {
        return this.f19399v;
    }

    /* renamed from: q */
    public String m3930q() {
        return this.f19366j;
    }

    /* renamed from: r */
    public synchronized void m3929r() {
        try {
            if (k() || j()) {
                AbstractC4478b.m5041a("WARNING: current xmpp has connected");
            } else {
                a(0, 0, (Exception) null);
                m3943a(this.f19369m);
            }
        } catch (IOException e) {
            throw new C4727l(e);
        }
    }

    /* renamed from: s */
    public Socket m3928s() {
        return new Socket();
    }

    /* renamed from: t */
    public void m3927t() {
        this.f19396s = SystemClock.elapsedRealtime();
    }

    /* renamed from: u */
    public void m3926u() {
        this.f19397t = SystemClock.elapsedRealtime();
    }
}
