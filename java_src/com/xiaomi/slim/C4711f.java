package com.xiaomi.slim;

import android.text.TextUtils;
import com.google.p217a.p218a.C3990a;
import com.google.p217a.p218a.C3994d;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.AbstractC4723h;
import com.xiaomi.smack.C4715b;
import com.xiaomi.smack.C4727l;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.util.C4749g;
import com.xiaomi.stats.C4761h;
/* renamed from: com.xiaomi.slim.f */
/* loaded from: classes.dex */
public class C4711f extends AbstractC4723h {

    /* renamed from: v */
    private Thread f19352v;

    /* renamed from: w */
    private C4708c f19353w;

    /* renamed from: x */
    private C4709d f19354x;

    public C4711f(XMPushService xMPushService, C4715b c4715b) {
        super(xMPushService, c4715b);
    }

    /* renamed from: c */
    private C4707b m3995c(boolean z) {
        C4707b c4707b = new C4707b();
        c4707b.m4030a("PING", (String) null);
        if (z) {
            c4707b.m4031a("1");
        } else {
            c4707b.m4031a("0");
        }
        C4567b.C4577j c4577j = new C4567b.C4577j();
        byte[] mo3964a = c().mo3964a();
        if (mo3964a != null) {
            try {
                c4577j.m4540a(C4567b.C4569b.m4650b(mo3964a));
            } catch (C3994d e) {
            }
        }
        byte[] m3773c = C4761h.m3773c();
        if (m3773c != null) {
            c4577j.m4541a(C3990a.m6308a(m3773c));
        }
        c4707b.m4027a(c4577j.c(), (String) null);
        return c4707b;
    }

    /* renamed from: v */
    private void m3994v() {
        try {
            this.f19353w = new C4708c(this.f19393p.getInputStream(), this);
            this.f19354x = new C4709d(this.f19393p.getOutputStream(), this);
            this.f19352v = new C4712g(this, "Blob Reader (" + this.f19368l + ")");
            this.f19352v.start();
        } catch (Exception e) {
            throw new C4727l("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.smack.AbstractC4723h
    /* renamed from: a */
    public synchronized void mo3944a(int i, Exception exc) {
        if (this.f19353w != null) {
            this.f19353w.m4006b();
            this.f19353w = null;
        }
        if (this.f19354x != null) {
            try {
                this.f19354x.m4000b();
            } catch (Exception e) {
                AbstractC4478b.m5039a(e);
            }
            this.f19354x = null;
        }
        super.mo3944a(i, exc);
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: a */
    public synchronized void mo3989a(C4612ak.C4614b c4614b) {
        C4706a.m4037a(c4614b, q(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3998a(C4707b c4707b) {
        if (c4707b == null) {
            return;
        }
        if (c4707b.m4020d()) {
            AbstractC4478b.m5041a("[Slim] RCV blob chid=" + c4707b.m4023c() + "; id=" + c4707b.m4015h() + "; errCode=" + c4707b.m4018e() + "; err=" + c4707b.m4017f());
        }
        if (c4707b.m4023c() == 0) {
            if ("PING".equals(c4707b.m4035a())) {
                AbstractC4478b.m5041a("[Slim] RCV ping id=" + c4707b.m4015h());
                u();
            } else if ("CLOSE".equals(c4707b.m4035a())) {
                c(13, null);
            }
        }
        for (AbstractC4713a.C4714a c4714a : this.f19363g.values()) {
            c4714a.m3966a(c4707b);
        }
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    @Deprecated
    /* renamed from: a */
    public void mo3986a(AbstractC4732d abstractC4732d) {
        mo3982b(C4707b.m4032a(abstractC4732d, (String) null));
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: a */
    public synchronized void mo3984a(String str, String str2) {
        C4706a.m4036a(str, str2, this);
    }

    @Override // com.xiaomi.smack.AbstractC4723h
    /* renamed from: a */
    protected void mo3939a(boolean z) {
        if (this.f19354x != null) {
            C4707b m3995c = m3995c(z);
            AbstractC4478b.m5041a("[Slim] SND ping id=" + m3995c.m4015h());
            mo3982b(m3995c);
            t();
            return;
        }
        throw new C4727l("The BlobWriter is null.");
    }

    @Override // com.xiaomi.smack.AbstractC4723h, com.xiaomi.smack.AbstractC4713a
    /* renamed from: a */
    public void mo3938a(C4707b[] c4707bArr) {
        for (C4707b c4707b : c4707bArr) {
            mo3982b(c4707b);
        }
    }

    @Override // com.xiaomi.smack.AbstractC4723h, com.xiaomi.smack.AbstractC4713a
    /* renamed from: a */
    public void mo3937a(AbstractC4732d[] abstractC4732dArr) {
        for (AbstractC4732d abstractC4732d : abstractC4732dArr) {
            mo3986a(abstractC4732d);
        }
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: a */
    public boolean mo3993a() {
        return true;
    }

    @Override // com.xiaomi.smack.AbstractC4723h
    /* renamed from: b */
    protected synchronized void mo3936b() {
        m3994v();
        this.f19354x.m4002a();
    }

    @Override // com.xiaomi.smack.AbstractC4713a
    /* renamed from: b */
    public void mo3982b(C4707b c4707b) {
        if (this.f19354x != null) {
            try {
                int m4001a = this.f19354x.m4001a(c4707b);
                String m4014i = c4707b.m4014i();
                if (!TextUtils.isEmpty(m4014i)) {
                    C4749g.m3827a(this.f19370n, m4014i, m4001a, false, System.currentTimeMillis());
                }
                for (AbstractC4713a.C4714a c4714a : this.f19364h.values()) {
                    c4714a.m3966a(c4707b);
                }
                return;
            } catch (Exception e) {
                throw new C4727l(e);
            }
        }
        throw new C4727l("the writer is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3996b(AbstractC4732d abstractC4732d) {
        if (abstractC4732d == null) {
            return;
        }
        for (AbstractC4713a.C4714a c4714a : this.f19363g.values()) {
            c4714a.m3965a(abstractC4732d);
        }
    }
}
