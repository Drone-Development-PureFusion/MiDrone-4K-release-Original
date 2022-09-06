package com.xiaomi.stats;

import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C4702b;
import com.xiaomi.push.thrift.EnumC4701a;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.stats.C4755d;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.stats.a */
/* loaded from: classes2.dex */
public class C4752a implements C4612ak.C4614b.AbstractC4615a {

    /* renamed from: a */
    private XMPushService f19529a;

    /* renamed from: b */
    private C4612ak.C4614b f19530b;

    /* renamed from: c */
    private AbstractC4713a f19531c;

    /* renamed from: e */
    private int f19533e;

    /* renamed from: f */
    private boolean f19534f = false;

    /* renamed from: d */
    private C4612ak.EnumC4616c f19532d = C4612ak.EnumC4616c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4752a(XMPushService xMPushService, C4612ak.C4614b c4614b) {
        this.f19529a = xMPushService;
        this.f19530b = c4614b;
    }

    /* renamed from: b */
    private void m3813b() {
        this.f19530b.m4363b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3812c() {
        m3813b();
        if (this.f19534f && this.f19533e != 11) {
            C4702b m3786f = C4758f.m3796a().m3786f();
            switch (C4754c.f19536a[this.f19532d.ordinal()]) {
                case 1:
                    if (this.f19533e != 17) {
                        if (this.f19533e != 21) {
                            try {
                                C4755d.C4756a m3807c = C4755d.m3807c(C4758f.m3791b().m3804a());
                                m3786f.f19291b = m3807c.f19537a.m4077a();
                                m3786f.m4062c(m3807c.f19538b);
                                break;
                            } catch (NullPointerException e) {
                                m3786f = null;
                                break;
                            }
                        } else {
                            m3786f.f19291b = EnumC4701a.BIND_TIMEOUT.m4077a();
                            break;
                        }
                    } else {
                        m3786f.f19291b = EnumC4701a.BIND_TCP_READ_TIMEOUT.m4077a();
                        break;
                    }
                case 3:
                    m3786f.f19291b = EnumC4701a.BIND_SUCCESS.m4077a();
                    break;
            }
            if (m3786f == null) {
                return;
            }
            m3786f.m4066b(this.f19531c.mo3931d());
            m3786f.m4058d(this.f19530b.f18955b);
            m3786f.f19292c = 1;
            try {
                m3786f.m4074a((byte) Integer.parseInt(this.f19530b.f18961h));
            } catch (NumberFormatException e2) {
            }
            C4758f.m3796a().m3792a(m3786f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3816a() {
        this.f19530b.m4366a(this);
        this.f19531c = this.f19529a.m4453h();
    }

    @Override // com.xiaomi.push.service.C4612ak.C4614b.AbstractC4615a
    /* renamed from: a */
    public void mo3815a(C4612ak.EnumC4616c enumC4616c, C4612ak.EnumC4616c enumC4616c2, int i) {
        if (!this.f19534f && enumC4616c == C4612ak.EnumC4616c.binding) {
            this.f19532d = enumC4616c2;
            this.f19533e = i;
            this.f19534f = true;
        }
        this.f19529a.m4494a(new C4753b(this, 4));
    }
}
