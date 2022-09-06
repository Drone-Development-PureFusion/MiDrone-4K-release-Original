package com.xiaomi.smack;

import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.channel.commonutils.string.C4506c;
import com.xiaomi.measite.smack.C4510a;
import com.xiaomi.push.service.AbstractC4618am;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.debugger.AbstractC4718a;
import com.xiaomi.smack.filter.AbstractC4721a;
import com.xiaomi.smack.packet.AbstractC4732d;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.xiaomi.smack.a */
/* loaded from: classes.dex */
public abstract class AbstractC4713a {

    /* renamed from: a */
    public static boolean f19356a;

    /* renamed from: o */
    private static final AtomicInteger f19357o = new AtomicInteger(0);

    /* renamed from: f */
    protected int f19362f;

    /* renamed from: m */
    protected C4715b f19369m;

    /* renamed from: n */
    protected XMPushService f19370n;

    /* renamed from: b */
    protected int f19358b = 0;

    /* renamed from: c */
    protected long f19359c = -1;

    /* renamed from: d */
    protected volatile long f19360d = 0;

    /* renamed from: e */
    protected volatile long f19361e = 0;

    /* renamed from: p */
    private LinkedList<Pair<Integer, Long>> f19371p = new LinkedList<>();

    /* renamed from: q */
    private final Collection<AbstractC4717d> f19372q = new CopyOnWriteArrayList();

    /* renamed from: g */
    protected final Map<AbstractC4720f, C4714a> f19363g = new ConcurrentHashMap();

    /* renamed from: h */
    protected final Map<AbstractC4720f, C4714a> f19364h = new ConcurrentHashMap();

    /* renamed from: i */
    protected AbstractC4718a f19365i = null;

    /* renamed from: j */
    protected String f19366j = "";

    /* renamed from: k */
    protected String f19367k = "";

    /* renamed from: r */
    private int f19373r = 2;

    /* renamed from: l */
    protected final int f19368l = f19357o.getAndIncrement();

    /* renamed from: s */
    private long f19374s = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.xiaomi.smack.a$a */
    /* loaded from: classes2.dex */
    public static class C4714a {

        /* renamed from: a */
        private AbstractC4720f f19375a;

        /* renamed from: b */
        private AbstractC4721a f19376b;

        public C4714a(AbstractC4720f abstractC4720f, AbstractC4721a abstractC4721a) {
            this.f19375a = abstractC4720f;
            this.f19376b = abstractC4721a;
        }

        /* renamed from: a */
        public void m3966a(C4707b c4707b) {
            this.f19375a.mo3953a(c4707b);
        }

        /* renamed from: a */
        public void m3965a(AbstractC4732d abstractC4732d) {
            if (this.f19376b == null || this.f19376b.mo3951a(abstractC4732d)) {
                this.f19375a.mo3952b(abstractC4732d);
            }
        }
    }

    static {
        f19356a = false;
        try {
            f19356a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        C4722g.m3950a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC4713a(XMPushService xMPushService, C4715b c4715b) {
        this.f19369m = c4715b;
        this.f19370n = xMPushService;
        m3974i();
    }

    /* renamed from: a */
    private String m3992a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: b */
    private void m3983b(int i) {
        synchronized (this.f19371p) {
            if (i == 1) {
                this.f19371p.clear();
            } else {
                this.f19371p.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f19371p.size() > 6) {
                    this.f19371p.remove(0);
                }
            }
        }
    }

    /* renamed from: a */
    public void m3991a(int i, int i2, Exception exc) {
        if (i != this.f19373r) {
            AbstractC4478b.m5041a(String.format("update the connection status. %1$s -> %2$s : %3$s ", m3992a(this.f19373r), m3992a(i), AbstractC4618am.m4361a(i2)));
        }
        if (C4497d.m4985d(this.f19370n)) {
            m3983b(i);
        }
        if (i == 1) {
            this.f19370n.m4500a(10);
            if (this.f19373r != 0) {
                AbstractC4478b.m5041a("try set connected while not connecting.");
            }
            this.f19373r = i;
            for (AbstractC4717d abstractC4717d : this.f19372q) {
                abstractC4717d.mo3803a(this);
            }
        } else if (i == 0) {
            if (this.f19373r != 2) {
                AbstractC4478b.m5041a("try set connecting while not disconnected.");
            }
            this.f19373r = i;
            for (AbstractC4717d abstractC4717d2 : this.f19372q) {
                abstractC4717d2.mo3799b(this);
            }
        } else if (i == 2) {
            this.f19370n.m4500a(10);
            if (this.f19373r == 0) {
                for (AbstractC4717d abstractC4717d3 : this.f19372q) {
                    abstractC4717d3.mo3801a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.f19373r == 1) {
                for (AbstractC4717d abstractC4717d4 : this.f19372q) {
                    abstractC4717d4.mo3802a(this, i2, exc);
                }
            }
            this.f19373r = i;
        }
    }

    /* renamed from: a */
    public abstract void mo3989a(C4612ak.C4614b c4614b);

    /* renamed from: a */
    public void m3988a(AbstractC4717d abstractC4717d) {
        if (abstractC4717d != null && !this.f19372q.contains(abstractC4717d)) {
            this.f19372q.add(abstractC4717d);
        }
    }

    /* renamed from: a */
    public void m3987a(AbstractC4720f abstractC4720f, AbstractC4721a abstractC4721a) {
        if (abstractC4720f == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f19363g.put(abstractC4720f, new C4714a(abstractC4720f, abstractC4721a));
    }

    /* renamed from: a */
    public abstract void mo3986a(AbstractC4732d abstractC4732d);

    /* renamed from: a */
    public synchronized void m3985a(String str) {
        if (this.f19373r == 0) {
            AbstractC4478b.m5041a("setChallenge hash = " + C4506c.m4951a(str).substring(0, 8));
            this.f19366j = str;
            m3991a(1, 0, null);
        } else {
            AbstractC4478b.m5041a("ignore setChallenge because connection was disconnected");
        }
    }

    /* renamed from: a */
    public abstract void mo3984a(String str, String str2);

    /* renamed from: a */
    public abstract void mo3938a(C4707b[] c4707bArr);

    /* renamed from: a */
    public abstract void mo3937a(AbstractC4732d[] abstractC4732dArr);

    /* renamed from: a */
    public boolean mo3993a() {
        return false;
    }

    /* renamed from: a */
    public synchronized boolean m3990a(long j) {
        return this.f19374s >= j;
    }

    /* renamed from: b */
    public abstract void mo3935b(int i, Exception exc);

    /* renamed from: b */
    public abstract void mo3982b(C4707b c4707b);

    /* renamed from: b */
    public void m3981b(AbstractC4717d abstractC4717d) {
        this.f19372q.remove(abstractC4717d);
    }

    /* renamed from: b */
    public void m3980b(AbstractC4720f abstractC4720f, AbstractC4721a abstractC4721a) {
        if (abstractC4720f == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f19364h.put(abstractC4720f, new C4714a(abstractC4720f, abstractC4721a));
    }

    /* renamed from: b */
    public abstract void mo3933b(boolean z);

    /* renamed from: c */
    public C4715b m3979c() {
        return this.f19369m;
    }

    /* renamed from: d */
    public String mo3931d() {
        return this.f19369m.m3956e();
    }

    /* renamed from: e */
    public String m3978e() {
        return this.f19369m.m3958c();
    }

    /* renamed from: f */
    public int m3977f() {
        return this.f19362f;
    }

    /* renamed from: g */
    public long m3976g() {
        return this.f19361e;
    }

    /* renamed from: h */
    public void m3975h() {
        mo3935b(0, (Exception) null);
    }

    /* renamed from: i */
    protected void m3974i() {
        String str;
        Class<?> cls = null;
        if (!this.f19369m.m3955f() || this.f19365i != null) {
            return;
        }
        try {
            str = System.getProperty("smack.debuggerClass");
        } catch (Throwable th) {
            str = null;
        }
        if (str != null) {
            try {
                cls = Class.forName(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (cls == null) {
            this.f19365i = new C4510a(this);
            return;
        }
        try {
            this.f19365i = (AbstractC4718a) cls.getConstructor(AbstractC4713a.class, Writer.class, Reader.class).newInstance(this);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
        }
    }

    /* renamed from: j */
    public boolean m3973j() {
        return this.f19373r == 0;
    }

    /* renamed from: k */
    public boolean m3972k() {
        return this.f19373r == 1;
    }

    /* renamed from: l */
    public int m3971l() {
        return this.f19358b;
    }

    /* renamed from: m */
    public int m3970m() {
        return this.f19373r;
    }

    /* renamed from: n */
    public synchronized void m3969n() {
        this.f19374s = System.currentTimeMillis();
    }

    /* renamed from: o */
    public synchronized boolean m3968o() {
        return System.currentTimeMillis() - this.f19374s < ((long) C4722g.m3947b());
    }

    /* renamed from: p */
    public void m3967p() {
        synchronized (this.f19371p) {
            this.f19371p.clear();
        }
    }
}
