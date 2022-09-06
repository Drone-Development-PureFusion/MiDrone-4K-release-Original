package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.zxing.client.result.optional.NDEFRecord;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.log.C4556b;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.thrift.EnumC4701a;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.C4715b;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.packet.C4728a;
import com.xiaomi.smack.packet.C4729b;
import com.xiaomi.smack.packet.C4731c;
import com.xiaomi.smack.util.C4749g;
import com.xiaomi.stats.C4761h;
import java.util.Date;
/* loaded from: classes.dex */
public class PacketSync {

    /* renamed from: a */
    private XMPushService f18881a;

    /* loaded from: classes.dex */
    public interface PacketReceiveHandler extends Parcelable {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PacketSync(XMPushService xMPushService) {
        this.f18881a = xMPushService;
    }

    /* renamed from: a */
    private void m4507a(C4728a c4728a) {
        String m3917c = c4728a.m3917c();
        if (!TextUtils.isEmpty(m3917c)) {
            String[] split = m3917c.split(";");
            Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(C4715b.m3960b(), false);
            if (fallbacksByHost == null || split.length <= 0) {
                return;
            }
            fallbacksByHost.m4765a(split);
            this.f18881a.m4499a(20, (Exception) null);
            this.f18881a.m4477a(true);
        }
    }

    /* renamed from: b */
    private void m4504b(AbstractC4732d abstractC4732d) {
        C4612ak.C4614b m4374b;
        String m3882m = abstractC4732d.m3882m();
        String m3884l = abstractC4732d.m3884l();
        if (TextUtils.isEmpty(m3882m) || TextUtils.isEmpty(m3884l) || (m4374b = C4612ak.m4383a().m4374b(m3884l, m3882m)) == null) {
            return;
        }
        C4749g.m3827a(this.f18881a, m4374b.f18954a, C4749g.m3824a(abstractC4732d.mo3862c()), true, System.currentTimeMillis());
    }

    /* renamed from: c */
    private void m4503c(C4707b c4707b) {
        C4612ak.C4614b m4374b;
        String m4013j = c4707b.m4013j();
        String num = Integer.toString(c4707b.m4023c());
        if (TextUtils.isEmpty(m4013j) || TextUtils.isEmpty(num) || (m4374b = C4612ak.m4383a().m4374b(num, m4013j)) == null) {
            return;
        }
        C4749g.m3827a(this.f18881a, m4374b.f18954a, c4707b.m4011l(), true, System.currentTimeMillis());
    }

    /* renamed from: a */
    public void m4508a(C4707b c4707b) {
        if (5 != c4707b.m4023c()) {
            m4503c(c4707b);
        }
        try {
            m4505b(c4707b);
        } catch (Exception e) {
            AbstractC4478b.m5040a("handle Blob chid = " + c4707b.m4023c() + " cmd = " + c4707b.m4035a() + " packetid = " + c4707b.m4015h() + " failure ", e);
        }
    }

    /* renamed from: a */
    public void m4506a(AbstractC4732d abstractC4732d) {
        if (!"5".equals(abstractC4732d.m3884l())) {
            m4504b(abstractC4732d);
        }
        String m3884l = abstractC4732d.m3884l();
        if (TextUtils.isEmpty(m3884l)) {
            m3884l = "1";
            abstractC4732d.m3883l(m3884l);
        }
        if (m3884l.equals("0")) {
            AbstractC4478b.m5041a("Received wrong packet with chid = 0 : " + abstractC4732d.mo3862c());
        }
        if (abstractC4732d instanceof C4729b) {
            C4728a m3875p = abstractC4732d.m3875p("kick");
            if (m3875p != null) {
                String m3882m = abstractC4732d.m3882m();
                String m3922a = m3875p.m3922a("type");
                String m3922a2 = m3875p.m3922a("reason");
                AbstractC4478b.m5041a("kicked by server, chid=" + m3884l + " userid=" + m3882m + " type=" + m3922a + " reason=" + m3922a2);
                if (!"wait".equals(m3922a)) {
                    this.f18881a.m4480a(m3884l, m3882m, 3, m3922a2, m3922a);
                    C4612ak.m4383a().m4377a(m3884l, m3882m);
                    return;
                }
                C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(m3884l, m3882m);
                if (m4374b == null) {
                    return;
                }
                this.f18881a.m4487a(m4374b);
                m4374b.m4364a(C4612ak.EnumC4616c.unbind, 3, 0, m3922a2, m3922a);
                return;
            }
        } else if (abstractC4732d instanceof C4731c) {
            C4731c c4731c = (C4731c) abstractC4732d;
            if ("redir".equals(c4731c.m3910a())) {
                C4728a p = c4731c.p("hosts");
                if (p == null) {
                    return;
                }
                m4507a(p);
                return;
            }
        }
        this.f18881a.m4459e().m4288a(this.f18881a, m3884l, abstractC4732d);
    }

    /* renamed from: b */
    public void m4505b(C4707b c4707b) {
        String m4035a = c4707b.m4035a();
        switch (c4707b.m4023c()) {
            case 0:
                if ("PING".equals(m4035a)) {
                    byte[] m4012k = c4707b.m4012k();
                    if (m4012k != null && m4012k.length > 0) {
                        C4567b.C4577j m4538b = C4567b.C4577j.m4538b(m4012k);
                        if (m4538b.m4535f()) {
                            C4627at.m4340a().m4339a(m4538b.m4534g());
                        }
                    }
                    if ("1".equals(c4707b.m4015h())) {
                        this.f18881a.m4501a();
                        return;
                    } else {
                        C4761h.m3775b();
                        return;
                    }
                } else if (!"SYNC".equals(m4035a)) {
                    if (!"NOTIFY".equals(c4707b.m4035a())) {
                        return;
                    }
                    C4567b.C4575h m4551b = C4567b.C4575h.m4551b(c4707b.m4012k());
                    AbstractC4478b.m5041a("notify by server err = " + m4551b.m4550d() + " desc = " + m4551b.m4548f());
                    return;
                } else if ("CONF".equals(c4707b.m4026b())) {
                    C4627at.m4340a().m4339a(C4567b.C4569b.m4650b(c4707b.m4012k()));
                    return;
                } else if (TextUtils.equals(NDEFRecord.URI_WELL_KNOWN_TYPE, c4707b.m4026b())) {
                    C4567b.C4578k m4522b = C4567b.C4578k.m4522b(c4707b.m4012k());
                    C4556b.m4723a(this.f18881a).m4720a(m4522b.m4521d(), m4522b.m4519f(), new Date(m4522b.m4517h()), new Date(m4522b.m4515j()), m4522b.m4511n() * 1024, m4522b.m4513l());
                    C4707b c4707b2 = new C4707b();
                    c4707b2.m4034a(0);
                    c4707b2.m4030a(c4707b.m4035a(), "UCA");
                    c4707b2.m4031a(c4707b.m4015h());
                    this.f18881a.m4494a(new C4626as(this.f18881a, c4707b2));
                    return;
                } else if (!TextUtils.equals("P", c4707b.m4026b())) {
                    return;
                } else {
                    C4567b.C4576i m4544b = C4567b.C4576i.m4544b(c4707b.m4012k());
                    C4707b c4707b3 = new C4707b();
                    c4707b3.m4034a(0);
                    c4707b3.m4030a(c4707b.m4035a(), "PCA");
                    c4707b3.m4031a(c4707b.m4015h());
                    C4567b.C4576i c4576i = new C4567b.C4576i();
                    if (m4544b.m4542e()) {
                        c4576i.m4546a(m4544b.m4543d());
                    }
                    c4707b3.m4027a(c4576i.c(), (String) null);
                    this.f18881a.m4494a(new C4626as(this.f18881a, c4707b3));
                    AbstractC4478b.m5041a("ACK msgP: id = " + c4707b.m4015h());
                    return;
                }
            default:
                String num = Integer.toString(c4707b.m4023c());
                if ("SECMSG".equals(c4707b.m4035a())) {
                    if (!c4707b.m4020d()) {
                        this.f18881a.m4459e().m4289a(this.f18881a, num, c4707b);
                        return;
                    } else {
                        AbstractC4478b.m5041a("Recv SECMSG errCode = " + c4707b.m4018e() + " errStr = " + c4707b.m4017f());
                        return;
                    }
                } else if (!"BIND".equals(m4035a)) {
                    if (!"KICK".equals(m4035a)) {
                        return;
                    }
                    C4567b.C4574g m4562b = C4567b.C4574g.m4562b(c4707b.m4012k());
                    String m4013j = c4707b.m4013j();
                    String m4560d = m4562b.m4560d();
                    String m4558f = m4562b.m4558f();
                    AbstractC4478b.m5041a("kicked by server, chid=" + num + " userid=" + m4013j + " type=" + m4560d + " reason=" + m4558f);
                    if (!"wait".equals(m4560d)) {
                        this.f18881a.m4480a(num, m4013j, 3, m4558f, m4560d);
                        C4612ak.m4383a().m4377a(num, m4013j);
                        return;
                    }
                    C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(num, m4013j);
                    if (m4374b == null) {
                        return;
                    }
                    this.f18881a.m4487a(m4374b);
                    m4374b.m4364a(C4612ak.EnumC4616c.unbind, 3, 0, m4558f, m4560d);
                    return;
                } else {
                    C4567b.C4571d m4617b = C4567b.C4571d.m4617b(c4707b.m4012k());
                    String m4013j2 = c4707b.m4013j();
                    C4612ak.C4614b m4374b2 = C4612ak.m4383a().m4374b(num, m4013j2);
                    if (m4374b2 == null) {
                        return;
                    }
                    if (m4617b.m4615d()) {
                        AbstractC4478b.m5041a("SMACK: channel bind succeeded, chid=" + c4707b.m4023c());
                        m4374b2.m4364a(C4612ak.EnumC4616c.binded, 1, 0, null, null);
                        return;
                    }
                    String m4613f = m4617b.m4613f();
                    if ("auth".equals(m4613f)) {
                        if ("invalid-sig".equals(m4617b.m4611h())) {
                            AbstractC4478b.m5041a("SMACK: bind error invalid-sig token = " + m4374b2.f18956c + " sec = " + m4374b2.f18962i);
                            C4761h.m3780a(0, EnumC4701a.BIND_INVALID_SIG.m4077a(), 1, null, 0);
                        }
                        m4374b2.m4364a(C4612ak.EnumC4616c.unbind, 1, 5, m4617b.m4611h(), m4613f);
                        C4612ak.m4383a().m4377a(num, m4013j2);
                    } else if ("cancel".equals(m4613f)) {
                        m4374b2.m4364a(C4612ak.EnumC4616c.unbind, 1, 7, m4617b.m4611h(), m4613f);
                        C4612ak.m4383a().m4377a(num, m4013j2);
                    } else if ("wait".equals(m4613f)) {
                        this.f18881a.m4487a(m4374b2);
                        m4374b2.m4364a(C4612ak.EnumC4616c.unbind, 1, 7, m4617b.m4611h(), m4613f);
                    }
                    AbstractC4478b.m5041a("SMACK: channel bind failed, chid=" + num + " reason=" + m4617b.m4611h());
                    return;
                }
        }
    }
}
