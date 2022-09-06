package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.android.C4468e;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.channel.commonutils.stats.C4502a;
import com.xiaomi.push.service.C4627at;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C4702b;
import com.xiaomi.push.thrift.C4704c;
import com.xiaomi.push.thrift.EnumC4701a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.p248a.p283b.C5389f;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.C5379k;
import org.p248a.p283b.p286c.C5383b;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.xiaomi.stats.f */
/* loaded from: classes.dex */
public class C4758f {

    /* renamed from: a */
    private String f19550a;

    /* renamed from: c */
    private int f19552c;

    /* renamed from: d */
    private long f19553d;

    /* renamed from: e */
    private C4757e f19554e;

    /* renamed from: b */
    private boolean f19551b = false;

    /* renamed from: f */
    private C4502a f19555f = C4502a.m4965a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.stats.f$a */
    /* loaded from: classes2.dex */
    public static class C4759a {

        /* renamed from: a */
        static final C4758f f19556a = new C4758f();
    }

    /* renamed from: a */
    private C4702b m3794a(C4502a.C4503a c4503a) {
        if (c4503a.f18584a == 0) {
            if (!(c4503a.f18586c instanceof C4702b)) {
                return null;
            }
            return (C4702b) c4503a.f18586c;
        }
        C4702b m3786f = m3786f();
        m3786f.m4073a(EnumC4701a.CHANNEL_STATS_COUNTER.m4077a());
        m3786f.m4063c(c4503a.f18584a);
        m3786f.m4062c(c4503a.f18585b);
        return m3786f;
    }

    /* renamed from: a */
    public static C4758f m3796a() {
        return C4759a.f19556a;
    }

    /* renamed from: b */
    private C4704c m3790b(int i) {
        ArrayList arrayList = new ArrayList();
        C4704c c4704c = new C4704c(this.f19550a, arrayList);
        if (!C4497d.m4983f(this.f19554e.f19539a)) {
            c4704c.m4043a(C4468e.m5079f(this.f19554e.f19539a));
        }
        C5383b c5383b = new C5383b(i);
        AbstractC5373e mo1221a = new C5379k.C5380a().mo1221a(c5383b);
        try {
            c4704c.mo1285b(mo1221a);
        } catch (C5389f e) {
        }
        LinkedList<C4502a.C4503a> m4962c = this.f19555f.m4962c();
        while (m4962c.size() > 0) {
            try {
                C4702b m3794a = m3794a(m4962c.getLast());
                if (m3794a != null) {
                    m3794a.mo1285b(mo1221a);
                }
                if (c5383b.m1220m_() > i) {
                    break;
                }
                if (m3794a != null) {
                    arrayList.add(m3794a);
                }
                m4962c.removeLast();
            } catch (NoSuchElementException e2) {
            } catch (C5389f e3) {
            }
        }
        return c4704c;
    }

    /* renamed from: b */
    public static C4757e m3791b() {
        C4757e c4757e;
        synchronized (C4759a.f19556a) {
            c4757e = C4759a.f19556a.f19554e;
        }
        return c4757e;
    }

    /* renamed from: g */
    private void m3785g() {
        if (!this.f19551b || System.currentTimeMillis() - this.f19553d <= this.f19552c) {
            return;
        }
        this.f19551b = false;
        this.f19553d = 0L;
    }

    /* renamed from: a */
    public void m3795a(int i) {
        int i2 = C0359h.f698aa;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.f19552c == i2 && this.f19551b) {
                return;
            }
            this.f19551b = true;
            this.f19553d = System.currentTimeMillis();
            this.f19552c = i2;
            AbstractC4478b.m5037c("enable dot duration = " + i2 + " start = " + this.f19553d);
        }
    }

    /* renamed from: a */
    public synchronized void m3793a(XMPushService xMPushService) {
        this.f19554e = new C4757e(xMPushService);
        this.f19550a = "";
        C4627at.m4340a().m4338a(new C4760g(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m3792a(C4702b c4702b) {
        this.f19555f.m4964a(c4702b);
    }

    /* renamed from: c */
    public boolean m3789c() {
        return this.f19551b;
    }

    /* renamed from: d */
    boolean m3788d() {
        m3785g();
        return this.f19551b && this.f19555f.m4963b() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized C4704c m3787e() {
        C4704c c4704c;
        c4704c = null;
        if (m3788d()) {
            int i = 750;
            if (!C4497d.m4983f(this.f19554e.f19539a)) {
                i = 375;
            }
            c4704c = m3790b(i);
        }
        return c4704c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public synchronized C4702b m3786f() {
        C4702b c4702b;
        c4702b = new C4702b();
        c4702b.m4071a(C4497d.m4978k(this.f19554e.f19539a));
        c4702b.f19290a = (byte) 0;
        c4702b.f19292c = 1;
        c4702b.m4059d((int) (System.currentTimeMillis() / 1000));
        if (this.f19554e.f19540b != null) {
            c4702b.m4055e(this.f19554e.f19540b.m3977f());
        }
        return c4702b;
    }
}
