package org.p248a.p249a.p268i.p270b;

import java.util.concurrent.atomic.AtomicLong;
/* renamed from: org.a.a.i.b.q */
/* loaded from: classes2.dex */
public final class C5193q {

    /* renamed from: a */
    private final AtomicLong f21968a = new AtomicLong();

    /* renamed from: b */
    private final AtomicLong f21969b = new AtomicLong();

    /* renamed from: c */
    private final C5194a f21970c = new C5194a();

    /* renamed from: d */
    private final C5194a f21971d = new C5194a();

    /* renamed from: e */
    private final C5194a f21972e = new C5194a();

    /* renamed from: f */
    private final C5194a f21973f = new C5194a();

    /* renamed from: org.a.a.i.b.q$a */
    /* loaded from: classes2.dex */
    static class C5194a {

        /* renamed from: a */
        private final AtomicLong f21974a = new AtomicLong(0);

        /* renamed from: b */
        private final AtomicLong f21975b = new AtomicLong(0);

        C5194a() {
        }

        /* renamed from: a */
        public long m1733a() {
            return this.f21974a.get();
        }

        /* renamed from: a */
        public void m1732a(long j) {
            this.f21974a.incrementAndGet();
            this.f21975b.addAndGet(System.currentTimeMillis() - j);
        }

        /* renamed from: b */
        public long m1731b() {
            long j = this.f21974a.get();
            if (j > 0) {
                return this.f21975b.get() / j;
            }
            return 0L;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[count=").append(m1733a()).append(", averageDuration=").append(m1731b()).append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public AtomicLong m1749a() {
        return this.f21968a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public AtomicLong m1748b() {
        return this.f21969b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public C5194a m1747c() {
        return this.f21970c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public C5194a m1746d() {
        return this.f21971d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public C5194a m1745e() {
        return this.f21972e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public C5194a m1744f() {
        return this.f21973f;
    }

    /* renamed from: g */
    public long m1743g() {
        return this.f21968a.get();
    }

    /* renamed from: h */
    public long m1742h() {
        return this.f21969b.get();
    }

    /* renamed from: i */
    public long m1741i() {
        return this.f21970c.m1733a();
    }

    /* renamed from: j */
    public long m1740j() {
        return this.f21970c.m1731b();
    }

    /* renamed from: k */
    public long m1739k() {
        return this.f21971d.m1733a();
    }

    /* renamed from: l */
    public long m1738l() {
        return this.f21971d.m1731b();
    }

    /* renamed from: m */
    public long m1737m() {
        return this.f21972e.m1733a();
    }

    /* renamed from: n */
    public long m1736n() {
        return this.f21972e.m1731b();
    }

    /* renamed from: o */
    public long m1735o() {
        return this.f21973f.m1733a();
    }

    /* renamed from: p */
    public long m1734p() {
        return this.f21973f.m1731b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[activeConnections=").append(this.f21968a).append(", scheduledConnections=").append(this.f21969b).append(", successfulConnections=").append(this.f21970c).append(", failedConnections=").append(this.f21971d).append(", requests=").append(this.f21972e).append(", tasks=").append(this.f21973f).append("]");
        return sb.toString();
    }
}
