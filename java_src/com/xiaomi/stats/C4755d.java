package com.xiaomi.stats;

import com.xiaomi.push.thrift.EnumC4701a;
import com.xiaomi.smack.C4716c;
import com.xiaomi.smack.C4727l;
import java.net.UnknownHostException;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.xiaomi.stats.d */
/* loaded from: classes2.dex */
final class C4755d {

    /* renamed from: com.xiaomi.stats.d$a */
    /* loaded from: classes2.dex */
    static class C4756a {

        /* renamed from: a */
        EnumC4701a f19537a;

        /* renamed from: b */
        String f19538b;

        C4756a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C4756a m3809a(Exception exc) {
        m3805e(exc);
        boolean z = exc instanceof C4727l;
        Exception exc2 = exc;
        if (z) {
            Throwable m3925a = ((C4727l) exc).m3925a();
            exc2 = exc;
            if (m3925a != null) {
                exc2 = ((C4727l) exc).m3925a();
            }
        }
        C4756a c4756a = new C4756a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int m3954a = C4716c.m3954a(exc2);
        if (m3954a != 0) {
            c4756a.f19537a = EnumC4701a.m4076a(m3954a + EnumC4701a.GSLB_REQUEST_SUCCESS.m4077a());
        }
        if (c4756a.f19537a == null) {
            c4756a.f19537a = EnumC4701a.GSLB_TCP_ERR_OTHER;
        }
        if (c4756a.f19537a == EnumC4701a.GSLB_TCP_ERR_OTHER) {
            c4756a.f19538b = str;
        }
        return c4756a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static C4756a m3808b(Exception exc) {
        Throwable cause;
        m3805e(exc);
        boolean z = exc instanceof C4727l;
        Exception exc2 = exc;
        if (z) {
            Throwable m3925a = ((C4727l) exc).m3925a();
            exc2 = exc;
            if (m3925a != null) {
                exc2 = ((C4727l) exc).m3925a();
            }
        }
        C4756a c4756a = new C4756a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int m3954a = C4716c.m3954a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (m3954a != 0) {
            c4756a.f19537a = EnumC4701a.m4076a(m3954a + EnumC4701a.CONN_SUCCESS.m4077a());
            if (c4756a.f19537a == EnumC4701a.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                c4756a.f19537a = EnumC4701a.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            c4756a.f19537a = EnumC4701a.CONN_XMPP_ERR;
        }
        if (c4756a.f19537a == EnumC4701a.CONN_TCP_ERR_OTHER || c4756a.f19537a == EnumC4701a.CONN_XMPP_ERR || c4756a.f19537a == EnumC4701a.CONN_BOSH_ERR) {
            c4756a.f19538b = str;
        }
        return c4756a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static C4756a m3807c(Exception exc) {
        m3805e(exc);
        boolean z = exc instanceof C4727l;
        Exception exc2 = exc;
        if (z) {
            Throwable m3925a = ((C4727l) exc).m3925a();
            exc2 = exc;
            if (m3925a != null) {
                exc2 = ((C4727l) exc).m3925a();
            }
        }
        C4756a c4756a = new C4756a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (C4716c.m3954a(exc2)) {
            case 105:
                c4756a.f19537a = EnumC4701a.BIND_TCP_READ_TIMEOUT;
                break;
            case Opcodes.LDIV /* 109 */:
                c4756a.f19537a = EnumC4701a.BIND_TCP_CONNRESET;
                break;
            case 110:
                c4756a.f19537a = EnumC4701a.BIND_TCP_BROKEN_PIPE;
                break;
            case 199:
                c4756a.f19537a = EnumC4701a.BIND_TCP_ERR;
                break;
            case 499:
                c4756a.f19537a = EnumC4701a.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    c4756a.f19537a = EnumC4701a.BIND_BOSH_ITEM_NOT_FOUND;
                    break;
                }
                break;
            default:
                c4756a.f19537a = EnumC4701a.BIND_XMPP_ERR;
                break;
        }
        if (c4756a.f19537a == EnumC4701a.BIND_TCP_ERR || c4756a.f19537a == EnumC4701a.BIND_XMPP_ERR || c4756a.f19537a == EnumC4701a.BIND_BOSH_ERR) {
            c4756a.f19538b = str;
        }
        return c4756a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static C4756a m3806d(Exception exc) {
        m3805e(exc);
        boolean z = exc instanceof C4727l;
        Exception exc2 = exc;
        if (z) {
            Throwable m3925a = ((C4727l) exc).m3925a();
            exc2 = exc;
            if (m3925a != null) {
                exc2 = ((C4727l) exc).m3925a();
            }
        }
        C4756a c4756a = new C4756a();
        String message = exc2.getMessage();
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (C4716c.m3954a(exc2)) {
            case 105:
                c4756a.f19537a = EnumC4701a.CHANNEL_TCP_READTIMEOUT;
                break;
            case Opcodes.LDIV /* 109 */:
                c4756a.f19537a = EnumC4701a.CHANNEL_TCP_CONNRESET;
                break;
            case 110:
                c4756a.f19537a = EnumC4701a.CHANNEL_TCP_BROKEN_PIPE;
                break;
            case 199:
                c4756a.f19537a = EnumC4701a.CHANNEL_TCP_ERR;
                break;
            case 499:
                c4756a.f19537a = EnumC4701a.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    c4756a.f19537a = EnumC4701a.CHANNEL_BOSH_ITEMNOTFIND;
                    break;
                }
                break;
            default:
                c4756a.f19537a = EnumC4701a.CHANNEL_XMPPEXCEPTION;
                break;
        }
        if (c4756a.f19537a == EnumC4701a.CHANNEL_TCP_ERR || c4756a.f19537a == EnumC4701a.CHANNEL_XMPPEXCEPTION || c4756a.f19537a == EnumC4701a.CHANNEL_BOSH_EXCEPTION) {
            c4756a.f19538b = str;
        }
        return c4756a;
    }

    /* renamed from: e */
    private static void m3805e(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }
}
