package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C4702b;
import com.xiaomi.push.thrift.C4704c;
import com.xiaomi.push.thrift.EnumC4701a;
import com.xiaomi.stats.C4755d;
import com.xiaomi.xmpush.thrift.C4796aq;
import java.util.Hashtable;
/* renamed from: com.xiaomi.stats.h */
/* loaded from: classes.dex */
public class C4761h {

    /* renamed from: a */
    private static final int f19558a = EnumC4701a.PING_RTT.m4077a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.stats.h$a */
    /* loaded from: classes2.dex */
    public static class C4762a {

        /* renamed from: a */
        static Hashtable<Integer, Long> f19559a = new Hashtable<>();
    }

    /* renamed from: a */
    public static void m3783a() {
        m3781a(0, f19558a);
    }

    /* renamed from: a */
    public static void m3782a(int i) {
        C4702b m3786f = C4758f.m3796a().m3786f();
        m3786f.m4073a(EnumC4701a.CHANNEL_STATS_COUNTER.m4077a());
        m3786f.m4063c(i);
        C4758f.m3796a().m3792a(m3786f);
    }

    /* renamed from: a */
    public static synchronized void m3781a(int i, int i2) {
        synchronized (C4761h.class) {
            if (i2 < 16777215) {
                C4762a.f19559a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                AbstractC4478b.m5036d("stats key should less than 16777215");
            }
        }
    }

    /* renamed from: a */
    public static void m3780a(int i, int i2, int i3, String str, int i4) {
        C4702b m3786f = C4758f.m3796a().m3786f();
        m3786f.m4074a((byte) i);
        m3786f.m4073a(i2);
        m3786f.m4068b(i3);
        m3786f.m4066b(str);
        m3786f.m4063c(i4);
        C4758f.m3796a().m3792a(m3786f);
    }

    /* renamed from: a */
    public static synchronized void m3779a(int i, int i2, String str, int i3) {
        synchronized (C4761h.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (C4762a.f19559a.containsKey(Integer.valueOf(i4))) {
                C4702b m3786f = C4758f.m3796a().m3786f();
                m3786f.m4073a(i2);
                m3786f.m4068b((int) (currentTimeMillis - C4762a.f19559a.get(Integer.valueOf(i4)).longValue()));
                m3786f.m4066b(str);
                if (i3 > -1) {
                    m3786f.m4063c(i3);
                }
                C4758f.m3796a().m3792a(m3786f);
                C4762a.f19559a.remove(Integer.valueOf(i2));
            } else {
                AbstractC4478b.m5036d("stats key not found");
            }
        }
    }

    /* renamed from: a */
    public static void m3778a(XMPushService xMPushService, C4612ak.C4614b c4614b) {
        new C4752a(xMPushService, c4614b).m3816a();
    }

    /* renamed from: a */
    public static void m3777a(String str, int i, Exception exc) {
        C4702b m3786f = C4758f.m3796a().m3786f();
        if (i > 0) {
            m3786f.m4073a(EnumC4701a.GSLB_REQUEST_SUCCESS.m4077a());
            m3786f.m4066b(str);
            m3786f.m4068b(i);
            C4758f.m3796a().m3792a(m3786f);
            return;
        }
        try {
            C4755d.C4756a m3809a = C4755d.m3809a(exc);
            m3786f.m4073a(m3809a.f19537a.m4077a());
            m3786f.m4062c(m3809a.f19538b);
            m3786f.m4066b(str);
            C4758f.m3796a().m3792a(m3786f);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a */
    public static void m3776a(String str, Exception exc) {
        try {
            C4755d.C4756a m3808b = C4755d.m3808b(exc);
            C4702b m3786f = C4758f.m3796a().m3786f();
            m3786f.m4073a(m3808b.f19537a.m4077a());
            m3786f.m4062c(m3808b.f19538b);
            m3786f.m4066b(str);
            C4758f.m3796a().m3792a(m3786f);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: b */
    public static void m3775b() {
        m3779a(0, f19558a, null, -1);
    }

    /* renamed from: b */
    public static void m3774b(String str, Exception exc) {
        try {
            C4755d.C4756a m3806d = C4755d.m3806d(exc);
            C4702b m3786f = C4758f.m3796a().m3786f();
            m3786f.m4073a(m3806d.f19537a.m4077a());
            m3786f.m4062c(m3806d.f19538b);
            m3786f.m4066b(str);
            C4758f.m3796a().m3792a(m3786f);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: c */
    public static byte[] m3773c() {
        C4704c m3787e = C4758f.m3796a().m3787e();
        if (m3787e != null) {
            return C4796aq.m3471a(m3787e);
        }
        return null;
    }
}
