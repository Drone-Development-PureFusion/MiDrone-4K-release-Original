package com.xiaomi.push.service;

import android.content.Context;
import com.tencent.p227mm.sdk.message.RMsgInfoDB;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.C4727l;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.xmpush.thrift.C4766ab;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4828u;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import java.nio.ByteBuffer;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5389f;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.aa */
/* loaded from: classes.dex */
public final class C4598aa {
    /* renamed from: a */
    static C4707b m4438a(XMPushService xMPushService, byte[] bArr) {
        C4766ab c4766ab = new C4766ab();
        try {
            C4796aq.m3470a(c4766ab, bArr);
            return m4437a(C4683o.m4137a(xMPushService), xMPushService, c4766ab);
        } catch (C5389f e) {
            AbstractC4478b.m5039a(e);
            return null;
        }
    }

    /* renamed from: a */
    static C4707b m4437a(C4682n c4682n, Context context, C4766ab c4766ab) {
        try {
            C4707b c4707b = new C4707b();
            c4707b.m4034a(5);
            c4707b.m4022c(c4682n.f19164a);
            c4707b.m4025b(c4766ab.f19629f);
            c4707b.m4030a("SECMSG", RMsgInfoDB.TABLE);
            String str = c4682n.f19164a;
            c4766ab.f19630g.f20501b = str.substring(0, str.indexOf("@"));
            c4766ab.f19630g.f20503d = str.substring(str.indexOf("/") + 1);
            c4707b.m4027a(C4796aq.m3471a(c4766ab), c4682n.f19166c);
            c4707b.m4028a((short) 1);
            AbstractC4478b.m5041a("try send mi push message. packagename:" + c4766ab.f19629f + " action:" + c4766ab.f19624a);
            return c4707b;
        } catch (NullPointerException e) {
            AbstractC4478b.m5039a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C4766ab m4436a(String str, String str2) {
        C4772ae c4772ae = new C4772ae();
        c4772ae.m3698b(str2);
        c4772ae.m3695c("package uninstalled");
        c4772ae.m3706a(AbstractC4732d.m3887j());
        c4772ae.m3702a(false);
        return m4435a(str, str2, c4772ae, EnumC4763a.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static <T extends AbstractC5358a<T, ?>> C4766ab m4435a(String str, String str2, T t, EnumC4763a enumC4763a) {
        byte[] m3471a = C4796aq.m3471a(t);
        C4766ab c4766ab = new C4766ab();
        C4828u c4828u = new C4828u();
        c4828u.f20500a = 5L;
        c4828u.f20501b = "fakeid";
        c4766ab.m3747a(c4828u);
        c4766ab.m3745a(ByteBuffer.wrap(m3471a));
        c4766ab.m3750a(enumC4763a);
        c4766ab.m3738c(true);
        c4766ab.m3741b(str);
        c4766ab.m3744a(false);
        c4766ab.m3746a(str2);
        return c4766ab;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4442a(XMPushService xMPushService) {
        if (C4683o.m4137a(xMPushService.getApplicationContext()) != null) {
            C4612ak.C4614b m4141a = C4683o.m4137a(xMPushService.getApplicationContext()).m4141a(xMPushService);
            m4441a(xMPushService, m4141a);
            C4612ak.m4383a().m4379a(m4141a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4441a(XMPushService xMPushService, C4612ak.C4614b c4614b) {
        c4614b.m4366a(new C4599ab(xMPushService));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4440a(XMPushService xMPushService, C4766ab c4766ab) {
        AbstractC4713a m4453h = xMPushService.m4453h();
        if (m4453h != null) {
            if (!m4453h.mo3993a()) {
                throw new C4727l("Don't support XMPP connection.");
            }
            C4707b m4437a = m4437a(C4683o.m4137a(xMPushService), xMPushService, c4766ab);
            if (m4437a == null) {
                return;
            }
            m4453h.mo3982b(m4437a);
            return;
        }
        throw new C4727l("try send msg while connection is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4439a(XMPushService xMPushService, String str, byte[] bArr) {
        AbstractC4713a m4453h = xMPushService.m4453h();
        if (m4453h != null) {
            if (!m4453h.mo3993a()) {
                throw new C4727l("Don't support XMPP connection.");
            }
            C4707b m4438a = m4438a(xMPushService, bArr);
            if (m4438a != null) {
                m4453h.mo3982b(m4438a);
                return;
            } else {
                C4687r.m4119a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
                return;
            }
        }
        throw new C4727l("try send msg while connection is null.");
    }
}
